package com.jakewharton.rxrelay2;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.Observer;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class PublishRelay<T> extends Relay<T> {
    static final PublishDisposable[] EMPTY = new PublishDisposable[0];
    final AtomicReference<PublishDisposable<T>[]> subscribers = new AtomicReference<>(EMPTY);

    @CheckReturnValue
    public static <T> PublishRelay<T> create() {
        return new PublishRelay<>();
    }

    PublishRelay() {
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        PublishDisposable publishDisposable = new PublishDisposable(observer, this);
        observer.onSubscribe(publishDisposable);
        add(publishDisposable);
        if (publishDisposable.isDisposed()) {
            remove(publishDisposable);
        }
    }

    /* access modifiers changed from: package-private */
    public void add(PublishDisposable<T> publishDisposable) {
        PublishDisposable[] publishDisposableArr;
        PublishDisposable[] publishDisposableArr2;
        do {
            publishDisposableArr = (PublishDisposable[]) this.subscribers.get();
            int length = publishDisposableArr.length;
            publishDisposableArr2 = new PublishDisposable[(length + 1)];
            System.arraycopy(publishDisposableArr, 0, publishDisposableArr2, 0, length);
            publishDisposableArr2[length] = publishDisposable;
        } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.subscribers, publishDisposableArr, publishDisposableArr2));
    }

    /* access modifiers changed from: package-private */
    public void remove(PublishDisposable<T> publishDisposable) {
        PublishDisposable<T>[] publishDisposableArr;
        PublishDisposable[] publishDisposableArr2;
        do {
            publishDisposableArr = (PublishDisposable[]) this.subscribers.get();
            if (publishDisposableArr != EMPTY) {
                int length = publishDisposableArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (publishDisposableArr[i] == publishDisposable) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        publishDisposableArr2 = EMPTY;
                    } else {
                        PublishDisposable[] publishDisposableArr3 = new PublishDisposable[(length - 1)];
                        System.arraycopy(publishDisposableArr, 0, publishDisposableArr3, 0, i);
                        System.arraycopy(publishDisposableArr, i + 1, publishDisposableArr3, i, (length - i) - 1);
                        publishDisposableArr2 = publishDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.subscribers, publishDisposableArr, publishDisposableArr2));
    }

    public void accept(T t) {
        if (t != null) {
            for (PublishDisposable onNext : (PublishDisposable[]) this.subscribers.get()) {
                onNext.onNext(t);
            }
            return;
        }
        throw new NullPointerException("value == null");
    }

    public boolean hasObservers() {
        return ((PublishDisposable[]) this.subscribers.get()).length != 0;
    }

    static final class PublishDisposable<T> extends AtomicBoolean implements Disposable {
        private static final long serialVersionUID = 3562861878281475070L;
        final Observer<? super T> downstream;
        final PublishRelay<T> parent;

        PublishDisposable(Observer<? super T> observer, PublishRelay<T> publishRelay) {
            this.downstream = observer;
            this.parent = publishRelay;
        }

        public void onNext(T t) {
            if (!get()) {
                this.downstream.onNext(t);
            }
        }

        public void dispose() {
            if (compareAndSet(false, true)) {
                this.parent.remove(this);
            }
        }

        public boolean isDisposed() {
            return get();
        }
    }
}
