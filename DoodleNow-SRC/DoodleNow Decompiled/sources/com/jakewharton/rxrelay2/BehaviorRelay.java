package com.jakewharton.rxrelay2;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import com.jakewharton.rxrelay2.AppendOnlyLinkedArrayList;
import io.reactivex.Observer;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class BehaviorRelay<T> extends Relay<T> {
    static final BehaviorDisposable[] EMPTY = new BehaviorDisposable[0];
    private static final Object[] EMPTY_ARRAY = new Object[0];
    long index;
    final Lock readLock;
    final AtomicReference<BehaviorDisposable<T>[]> subscribers;
    final AtomicReference<T> value;
    final Lock writeLock;

    @CheckReturnValue
    public static <T> BehaviorRelay<T> create() {
        return new BehaviorRelay<>();
    }

    @CheckReturnValue
    public static <T> BehaviorRelay<T> createDefault(T t) {
        return new BehaviorRelay<>(t);
    }

    BehaviorRelay() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.readLock = reentrantReadWriteLock.readLock();
        this.writeLock = reentrantReadWriteLock.writeLock();
        this.subscribers = new AtomicReference<>(EMPTY);
        this.value = new AtomicReference<>();
    }

    BehaviorRelay(T t) {
        this();
        if (t != null) {
            this.value.lazySet(t);
            return;
        }
        throw new NullPointerException("defaultValue == null");
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        BehaviorDisposable behaviorDisposable = new BehaviorDisposable(observer, this);
        observer.onSubscribe(behaviorDisposable);
        add(behaviorDisposable);
        if (behaviorDisposable.cancelled) {
            remove(behaviorDisposable);
        } else {
            behaviorDisposable.emitFirst();
        }
    }

    public void accept(T t) {
        if (t != null) {
            setCurrent(t);
            for (BehaviorDisposable emitNext : (BehaviorDisposable[]) this.subscribers.get()) {
                emitNext.emitNext(t, this.index);
            }
            return;
        }
        throw new NullPointerException("value == null");
    }

    public boolean hasObservers() {
        return ((BehaviorDisposable[]) this.subscribers.get()).length != 0;
    }

    /* access modifiers changed from: package-private */
    public int subscriberCount() {
        return ((BehaviorDisposable[]) this.subscribers.get()).length;
    }

    public T getValue() {
        return this.value.get();
    }

    @Deprecated
    public Object[] getValues() {
        Object[] objArr = EMPTY_ARRAY;
        Object[] values = getValues(objArr);
        return values == objArr ? new Object[0] : values;
    }

    @Deprecated
    public T[] getValues(T[] tArr) {
        T t = this.value.get();
        if (t == null) {
            if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        } else if (tArr.length != 0) {
            tArr[0] = t;
            if (tArr.length == 1) {
                return tArr;
            }
            tArr[1] = null;
            return tArr;
        } else {
            T[] tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1);
            tArr2[0] = t;
            return tArr2;
        }
    }

    public boolean hasValue() {
        return this.value.get() != null;
    }

    /* access modifiers changed from: package-private */
    public void add(BehaviorDisposable<T> behaviorDisposable) {
        BehaviorDisposable[] behaviorDisposableArr;
        BehaviorDisposable[] behaviorDisposableArr2;
        do {
            behaviorDisposableArr = (BehaviorDisposable[]) this.subscribers.get();
            int length = behaviorDisposableArr.length;
            behaviorDisposableArr2 = new BehaviorDisposable[(length + 1)];
            System.arraycopy(behaviorDisposableArr, 0, behaviorDisposableArr2, 0, length);
            behaviorDisposableArr2[length] = behaviorDisposable;
        } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.subscribers, behaviorDisposableArr, behaviorDisposableArr2));
    }

    /* access modifiers changed from: package-private */
    public void remove(BehaviorDisposable<T> behaviorDisposable) {
        BehaviorDisposable<T>[] behaviorDisposableArr;
        BehaviorDisposable[] behaviorDisposableArr2;
        do {
            behaviorDisposableArr = (BehaviorDisposable[]) this.subscribers.get();
            int length = behaviorDisposableArr.length;
            if (length != 0) {
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (behaviorDisposableArr[i] == behaviorDisposable) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        behaviorDisposableArr2 = EMPTY;
                    } else {
                        BehaviorDisposable[] behaviorDisposableArr3 = new BehaviorDisposable[(length - 1)];
                        System.arraycopy(behaviorDisposableArr, 0, behaviorDisposableArr3, 0, i);
                        System.arraycopy(behaviorDisposableArr, i + 1, behaviorDisposableArr3, i, (length - i) - 1);
                        behaviorDisposableArr2 = behaviorDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.subscribers, behaviorDisposableArr, behaviorDisposableArr2));
    }

    /* access modifiers changed from: package-private */
    public void setCurrent(T t) {
        this.writeLock.lock();
        this.index++;
        this.value.lazySet(t);
        this.writeLock.unlock();
    }

    static final class BehaviorDisposable<T> implements Disposable, AppendOnlyLinkedArrayList.NonThrowingPredicate<T> {
        volatile boolean cancelled;
        final Observer<? super T> downstream;
        boolean emitting;
        boolean fastPath;
        long index;
        boolean next;
        AppendOnlyLinkedArrayList<T> queue;
        final BehaviorRelay<T> state;

        public boolean isDisposed() {
            return this.cancelled;
        }

        BehaviorDisposable(Observer<? super T> observer, BehaviorRelay<T> behaviorRelay) {
            this.downstream = observer;
            this.state = behaviorRelay;
        }

        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.state.remove(this);
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
            if (r0 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0033, code lost:
            test(r0);
            emitLoop();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void emitFirst() {
            /*
                r4 = this;
                boolean r0 = r4.cancelled
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                monitor-enter(r4)
                boolean r0 = r4.cancelled     // Catch:{ all -> 0x003a }
                if (r0 == 0) goto L_0x000c
                monitor-exit(r4)     // Catch:{ all -> 0x003a }
                return
            L_0x000c:
                boolean r0 = r4.next     // Catch:{ all -> 0x003a }
                if (r0 == 0) goto L_0x0012
                monitor-exit(r4)     // Catch:{ all -> 0x003a }
                return
            L_0x0012:
                com.jakewharton.rxrelay2.BehaviorRelay<T> r0 = r4.state     // Catch:{ all -> 0x003a }
                java.util.concurrent.locks.Lock r1 = r0.readLock     // Catch:{ all -> 0x003a }
                r1.lock()     // Catch:{ all -> 0x003a }
                long r2 = r0.index     // Catch:{ all -> 0x003a }
                r4.index = r2     // Catch:{ all -> 0x003a }
                java.util.concurrent.atomic.AtomicReference<T> r0 = r0.value     // Catch:{ all -> 0x003a }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x003a }
                r1.unlock()     // Catch:{ all -> 0x003a }
                r1 = 1
                if (r0 == 0) goto L_0x002b
                r2 = r1
                goto L_0x002c
            L_0x002b:
                r2 = 0
            L_0x002c:
                r4.emitting = r2     // Catch:{ all -> 0x003a }
                r4.next = r1     // Catch:{ all -> 0x003a }
                monitor-exit(r4)     // Catch:{ all -> 0x003a }
                if (r0 == 0) goto L_0x0039
                r4.test(r0)
                r4.emitLoop()
            L_0x0039:
                return
            L_0x003a:
                r0 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x003a }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jakewharton.rxrelay2.BehaviorRelay.BehaviorDisposable.emitFirst():void");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0031, code lost:
            r2.fastPath = true;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void emitNext(T r3, long r4) {
            /*
                r2 = this;
                boolean r0 = r2.cancelled
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                boolean r0 = r2.fastPath
                if (r0 != 0) goto L_0x0037
                monitor-enter(r2)
                boolean r0 = r2.cancelled     // Catch:{ all -> 0x0034 }
                if (r0 == 0) goto L_0x0010
                monitor-exit(r2)     // Catch:{ all -> 0x0034 }
                return
            L_0x0010:
                long r0 = r2.index     // Catch:{ all -> 0x0034 }
                int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r4 != 0) goto L_0x0018
                monitor-exit(r2)     // Catch:{ all -> 0x0034 }
                return
            L_0x0018:
                boolean r4 = r2.emitting     // Catch:{ all -> 0x0034 }
                if (r4 == 0) goto L_0x002d
                com.jakewharton.rxrelay2.AppendOnlyLinkedArrayList<T> r4 = r2.queue     // Catch:{ all -> 0x0034 }
                if (r4 != 0) goto L_0x0028
                com.jakewharton.rxrelay2.AppendOnlyLinkedArrayList r4 = new com.jakewharton.rxrelay2.AppendOnlyLinkedArrayList     // Catch:{ all -> 0x0034 }
                r5 = 4
                r4.<init>(r5)     // Catch:{ all -> 0x0034 }
                r2.queue = r4     // Catch:{ all -> 0x0034 }
            L_0x0028:
                r4.add(r3)     // Catch:{ all -> 0x0034 }
                monitor-exit(r2)     // Catch:{ all -> 0x0034 }
                return
            L_0x002d:
                r4 = 1
                r2.next = r4     // Catch:{ all -> 0x0034 }
                monitor-exit(r2)     // Catch:{ all -> 0x0034 }
                r2.fastPath = r4
                goto L_0x0037
            L_0x0034:
                r3 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0034 }
                throw r3
            L_0x0037:
                r2.test(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jakewharton.rxrelay2.BehaviorRelay.BehaviorDisposable.emitNext(java.lang.Object, long):void");
        }

        public boolean test(T t) {
            if (this.cancelled) {
                return false;
            }
            this.downstream.onNext(t);
            return false;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0013, code lost:
            r0.forEachWhile(r2);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void emitLoop() {
            /*
                r2 = this;
            L_0x0000:
                boolean r0 = r2.cancelled
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                monitor-enter(r2)
                com.jakewharton.rxrelay2.AppendOnlyLinkedArrayList<T> r0 = r2.queue     // Catch:{ all -> 0x0017 }
                if (r0 != 0) goto L_0x000f
                r0 = 0
                r2.emitting = r0     // Catch:{ all -> 0x0017 }
                monitor-exit(r2)     // Catch:{ all -> 0x0017 }
                return
            L_0x000f:
                r1 = 0
                r2.queue = r1     // Catch:{ all -> 0x0017 }
                monitor-exit(r2)     // Catch:{ all -> 0x0017 }
                r0.forEachWhile(r2)
                goto L_0x0000
            L_0x0017:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0017 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jakewharton.rxrelay2.BehaviorRelay.BehaviorDisposable.emitLoop():void");
        }
    }
}
