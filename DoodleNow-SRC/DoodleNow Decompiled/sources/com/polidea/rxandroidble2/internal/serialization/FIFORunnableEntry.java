package com.polidea.rxandroidble2.internal.serialization;

import com.polidea.rxandroidble2.internal.logger.LoggerUtil;
import com.polidea.rxandroidble2.internal.operations.Operation;
import io.reactivex.ObservableEmitter;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicLong;

class FIFORunnableEntry<T> implements Comparable<FIFORunnableEntry> {
    private static final AtomicLong SEQUENCE = new AtomicLong(0);
    final Operation<T> operation;
    final ObservableEmitter<T> operationResultObserver;
    private final long seqNum = SEQUENCE.getAndIncrement();

    FIFORunnableEntry(Operation<T> operation2, ObservableEmitter<T> observableEmitter) {
        this.operation = operation2;
        this.operationResultObserver = observableEmitter;
    }

    public int compareTo(FIFORunnableEntry fIFORunnableEntry) {
        int compareTo = this.operation.compareTo(fIFORunnableEntry.operation);
        if (compareTo != 0 || fIFORunnableEntry.operation == this.operation) {
            return compareTo;
        }
        return this.seqNum < fIFORunnableEntry.seqNum ? -1 : 1;
    }

    public void run(final QueueSemaphore queueSemaphore, final Scheduler scheduler) {
        if (this.operationResultObserver.isDisposed()) {
            LoggerUtil.logOperationSkippedBecauseDisposedWhenAboutToRun(this.operation);
            queueSemaphore.release();
            return;
        }
        scheduler.scheduleDirect(new Runnable() {
            public void run() {
                FIFORunnableEntry.this.operation.run(queueSemaphore).unsubscribeOn(scheduler).subscribe(new Observer<T>() {
                    public void onSubscribe(Disposable disposable) {
                        FIFORunnableEntry.this.operationResultObserver.setDisposable(disposable);
                    }

                    public void onNext(T t) {
                        FIFORunnableEntry.this.operationResultObserver.onNext(t);
                    }

                    public void onError(Throwable th) {
                        FIFORunnableEntry.this.operationResultObserver.tryOnError(th);
                    }

                    public void onComplete() {
                        FIFORunnableEntry.this.operationResultObserver.onComplete();
                    }
                });
            }
        });
    }
}
