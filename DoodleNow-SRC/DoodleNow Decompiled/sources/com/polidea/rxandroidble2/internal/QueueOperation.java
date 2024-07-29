package com.polidea.rxandroidble2.internal;

import android.os.DeadObjectException;
import com.polidea.rxandroidble2.exceptions.BleException;
import com.polidea.rxandroidble2.internal.operations.Operation;
import com.polidea.rxandroidble2.internal.serialization.QueueReleaseInterface;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public abstract class QueueOperation<T> implements Operation<T> {
    /* access modifiers changed from: protected */
    public abstract void protectedRun(ObservableEmitter<T> observableEmitter, QueueReleaseInterface queueReleaseInterface) throws Throwable;

    /* access modifiers changed from: protected */
    public abstract BleException provideException(DeadObjectException deadObjectException);

    public final Observable<T> run(final QueueReleaseInterface queueReleaseInterface) {
        return Observable.create(new ObservableOnSubscribe<T>() {
            public void subscribe(ObservableEmitter<T> observableEmitter) {
                try {
                    QueueOperation.this.protectedRun(observableEmitter, queueReleaseInterface);
                } catch (DeadObjectException e) {
                    observableEmitter.tryOnError(QueueOperation.this.provideException(e));
                    RxBleLog.e(e, "QueueOperation terminated with a DeadObjectException", new Object[0]);
                } catch (Throwable th) {
                    observableEmitter.tryOnError(th);
                    RxBleLog.e(th, "QueueOperation terminated with an unexpected exception", new Object[0]);
                }
            }
        });
    }

    public Priority definedPriority() {
        return Priority.NORMAL;
    }

    public int compareTo(Operation operation) {
        return operation.definedPriority().priority - definedPriority().priority;
    }
}
