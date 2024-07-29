package com.polidea.rxandroidble2.internal.util;

import com.polidea.rxandroidble2.internal.serialization.QueueReleaseInterface;
import io.reactivex.ObservableEmitter;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;
import java.util.concurrent.atomic.AtomicBoolean;

public class QueueReleasingEmitterWrapper<T> implements Observer<T>, Cancellable {
    private final ObservableEmitter<T> emitter;
    private final AtomicBoolean isEmitterCanceled = new AtomicBoolean(false);
    private final QueueReleaseInterface queueReleaseInterface;

    public void onSubscribe(Disposable disposable) {
    }

    public QueueReleasingEmitterWrapper(ObservableEmitter<T> observableEmitter, QueueReleaseInterface queueReleaseInterface2) {
        this.emitter = observableEmitter;
        this.queueReleaseInterface = queueReleaseInterface2;
        observableEmitter.setCancellable(this);
    }

    public void onComplete() {
        this.queueReleaseInterface.release();
        this.emitter.onComplete();
    }

    public void onError(Throwable th) {
        this.queueReleaseInterface.release();
        this.emitter.tryOnError(th);
    }

    public void onNext(T t) {
        this.emitter.onNext(t);
    }

    public synchronized void cancel() {
        this.isEmitterCanceled.set(true);
    }

    public synchronized boolean isWrappedEmitterUnsubscribed() {
        return this.isEmitterCanceled.get();
    }
}
