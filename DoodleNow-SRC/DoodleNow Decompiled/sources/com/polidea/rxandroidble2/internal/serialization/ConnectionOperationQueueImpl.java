package com.polidea.rxandroidble2.internal.serialization;

import bleshadow.javax.inject.Inject;
import bleshadow.javax.inject.Named;
import com.polidea.rxandroidble2.exceptions.BleDisconnectedException;
import com.polidea.rxandroidble2.exceptions.BleException;
import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.internal.connection.ConnectionScope;
import com.polidea.rxandroidble2.internal.connection.ConnectionSubscriptionWatcher;
import com.polidea.rxandroidble2.internal.connection.DisconnectionRouterOutput;
import com.polidea.rxandroidble2.internal.logger.LoggerUtil;
import com.polidea.rxandroidble2.internal.operations.Operation;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.functions.Cancellable;
import io.reactivex.observers.DisposableObserver;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@ConnectionScope
public class ConnectionOperationQueueImpl implements ConnectionOperationQueue, ConnectionSubscriptionWatcher {
    private final String deviceMacAddress;
    private BleException disconnectionException = null;
    private final DisconnectionRouterOutput disconnectionRouterOutput;
    private DisposableObserver<BleException> disconnectionThrowableSubscription;
    final OperationPriorityFifoBlockingQueue queue = new OperationPriorityFifoBlockingQueue();
    private final Future<?> runnableFuture;
    volatile boolean shouldRun = true;

    @Inject
    ConnectionOperationQueueImpl(@Named("mac-address") final String str, DisconnectionRouterOutput disconnectionRouterOutput2, @Named("executor_connection_queue") ExecutorService executorService, @Named("bluetooth_interaction") final Scheduler scheduler) {
        this.deviceMacAddress = str;
        this.disconnectionRouterOutput = disconnectionRouterOutput2;
        this.runnableFuture = executorService.submit(new Runnable() {
            public void run() {
                while (true) {
                    if (!ConnectionOperationQueueImpl.this.shouldRun) {
                        break;
                    }
                    try {
                        FIFORunnableEntry<?> take = ConnectionOperationQueueImpl.this.queue.take();
                        Operation<T> operation = take.operation;
                        long currentTimeMillis = System.currentTimeMillis();
                        LoggerUtil.logOperationStarted(operation);
                        LoggerUtil.logOperationRunning(operation);
                        QueueSemaphore queueSemaphore = new QueueSemaphore();
                        take.run(queueSemaphore, scheduler);
                        queueSemaphore.awaitRelease();
                        LoggerUtil.logOperationFinished(operation, currentTimeMillis, System.currentTimeMillis());
                    } catch (InterruptedException e) {
                        synchronized (ConnectionOperationQueueImpl.this) {
                            if (!ConnectionOperationQueueImpl.this.shouldRun) {
                                break;
                            }
                            RxBleLog.e(e, "Error while processing connection operation queue", new Object[0]);
                        }
                    }
                }
                ConnectionOperationQueueImpl.this.flushQueue();
                RxBleLog.v("Terminated (%s)", LoggerUtil.commonMacMessage(str));
            }
        });
    }

    /* access modifiers changed from: package-private */
    public synchronized void flushQueue() {
        while (!this.queue.isEmpty()) {
            this.queue.takeNow().operationResultObserver.tryOnError(this.disconnectionException);
        }
    }

    public synchronized <T> Observable<T> queue(final Operation<T> operation) {
        if (!this.shouldRun) {
            return Observable.error((Throwable) this.disconnectionException);
        }
        return Observable.create(new ObservableOnSubscribe<T>() {
            public void subscribe(ObservableEmitter<T> observableEmitter) {
                final FIFORunnableEntry fIFORunnableEntry = new FIFORunnableEntry(operation, observableEmitter);
                observableEmitter.setCancellable(new Cancellable() {
                    public void cancel() {
                        if (ConnectionOperationQueueImpl.this.queue.remove(fIFORunnableEntry)) {
                            LoggerUtil.logOperationRemoved(operation);
                        }
                    }
                });
                LoggerUtil.logOperationQueued(operation);
                ConnectionOperationQueueImpl.this.queue.add(fIFORunnableEntry);
            }
        });
    }

    public synchronized void terminate(BleException bleException) {
        if (this.disconnectionException == null) {
            RxBleLog.d(bleException, "Connection operations queue to be terminated (%s)", LoggerUtil.commonMacMessage(this.deviceMacAddress));
            this.shouldRun = false;
            this.disconnectionException = bleException;
            this.runnableFuture.cancel(true);
        }
    }

    public void onConnectionSubscribed() {
        this.disconnectionThrowableSubscription = (DisposableObserver) this.disconnectionRouterOutput.asValueOnlyObservable().subscribeWith(new DisposableObserver<BleException>() {
            public void onComplete() {
            }

            public void onError(Throwable th) {
            }

            public void onNext(BleException bleException) {
                ConnectionOperationQueueImpl.this.terminate(bleException);
            }
        });
    }

    public void onConnectionUnsubscribed() {
        this.disconnectionThrowableSubscription.dispose();
        this.disconnectionThrowableSubscription = null;
        terminate(new BleDisconnectedException(this.deviceMacAddress, -1));
    }
}
