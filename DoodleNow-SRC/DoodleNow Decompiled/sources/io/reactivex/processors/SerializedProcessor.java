package io.reactivex.processors;

import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import org.reactivestreams.Subscriber;

final class SerializedProcessor<T> extends FlowableProcessor<T> {
    final FlowableProcessor<T> actual;
    volatile boolean done;
    boolean emitting;
    AppendOnlyLinkedArrayList<Object> queue;

    SerializedProcessor(FlowableProcessor<T> flowableProcessor) {
        this.actual = flowableProcessor;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.actual.subscribe(subscriber);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0028, code lost:
        if (r1 == false) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002b, code lost:
        r2.actual.onSubscribe(r3);
        emitLoop();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSubscribe(org.reactivestreams.Subscription r3) {
        /*
            r2 = this;
            boolean r0 = r2.done
            if (r0 != 0) goto L_0x0037
            monitor-enter(r2)
            boolean r0 = r2.done     // Catch:{ all -> 0x0034 }
            r1 = 1
            if (r0 == 0) goto L_0x000b
            goto L_0x0027
        L_0x000b:
            boolean r0 = r2.emitting     // Catch:{ all -> 0x0034 }
            if (r0 == 0) goto L_0x0024
            io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r0 = r2.queue     // Catch:{ all -> 0x0034 }
            if (r0 != 0) goto L_0x001b
            io.reactivex.internal.util.AppendOnlyLinkedArrayList r0 = new io.reactivex.internal.util.AppendOnlyLinkedArrayList     // Catch:{ all -> 0x0034 }
            r1 = 4
            r0.<init>(r1)     // Catch:{ all -> 0x0034 }
            r2.queue = r0     // Catch:{ all -> 0x0034 }
        L_0x001b:
            java.lang.Object r3 = io.reactivex.internal.util.NotificationLite.subscription(r3)     // Catch:{ all -> 0x0034 }
            r0.add(r3)     // Catch:{ all -> 0x0034 }
            monitor-exit(r2)     // Catch:{ all -> 0x0034 }
            return
        L_0x0024:
            r2.emitting = r1     // Catch:{ all -> 0x0034 }
            r1 = 0
        L_0x0027:
            monitor-exit(r2)     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x002b
            goto L_0x0037
        L_0x002b:
            io.reactivex.processors.FlowableProcessor<T> r0 = r2.actual
            r0.onSubscribe(r3)
            r2.emitLoop()
            goto L_0x003a
        L_0x0034:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0034 }
            throw r3
        L_0x0037:
            r3.cancel()
        L_0x003a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.processors.SerializedProcessor.onSubscribe(org.reactivestreams.Subscription):void");
    }

    public void onNext(T t) {
        if (!this.done) {
            synchronized (this) {
                if (!this.done) {
                    if (this.emitting) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.queue;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.queue = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.next(t));
                        return;
                    }
                    this.emitting = true;
                    this.actual.onNext(t);
                    emitLoop();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002e, code lost:
        if (r1 == false) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0030, code lost:
        io.reactivex.plugins.RxJavaPlugins.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0033, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0034, code lost:
        r2.actual.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0039, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onError(java.lang.Throwable r3) {
        /*
            r2 = this;
            boolean r0 = r2.done
            if (r0 == 0) goto L_0x0008
            io.reactivex.plugins.RxJavaPlugins.onError(r3)
            return
        L_0x0008:
            monitor-enter(r2)
            boolean r0 = r2.done     // Catch:{ all -> 0x003a }
            r1 = 1
            if (r0 == 0) goto L_0x000f
            goto L_0x002d
        L_0x000f:
            r2.done = r1     // Catch:{ all -> 0x003a }
            boolean r0 = r2.emitting     // Catch:{ all -> 0x003a }
            if (r0 == 0) goto L_0x002a
            io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r0 = r2.queue     // Catch:{ all -> 0x003a }
            if (r0 != 0) goto L_0x0021
            io.reactivex.internal.util.AppendOnlyLinkedArrayList r0 = new io.reactivex.internal.util.AppendOnlyLinkedArrayList     // Catch:{ all -> 0x003a }
            r1 = 4
            r0.<init>(r1)     // Catch:{ all -> 0x003a }
            r2.queue = r0     // Catch:{ all -> 0x003a }
        L_0x0021:
            java.lang.Object r3 = io.reactivex.internal.util.NotificationLite.error(r3)     // Catch:{ all -> 0x003a }
            r0.setFirst(r3)     // Catch:{ all -> 0x003a }
            monitor-exit(r2)     // Catch:{ all -> 0x003a }
            return
        L_0x002a:
            r2.emitting = r1     // Catch:{ all -> 0x003a }
            r1 = 0
        L_0x002d:
            monitor-exit(r2)     // Catch:{ all -> 0x003a }
            if (r1 == 0) goto L_0x0034
            io.reactivex.plugins.RxJavaPlugins.onError(r3)
            return
        L_0x0034:
            io.reactivex.processors.FlowableProcessor<T> r0 = r2.actual
            r0.onError(r3)
            return
        L_0x003a:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x003a }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.processors.SerializedProcessor.onError(java.lang.Throwable):void");
    }

    public void onComplete() {
        if (!this.done) {
            synchronized (this) {
                if (!this.done) {
                    this.done = true;
                    if (this.emitting) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.queue;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.queue = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.complete());
                        return;
                    }
                    this.emitting = true;
                    this.actual.onComplete();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void emitLoop() {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        while (true) {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.queue;
                if (appendOnlyLinkedArrayList == null) {
                    this.emitting = false;
                    return;
                }
                this.queue = null;
            }
            appendOnlyLinkedArrayList.accept((Subscriber<? super U>) this.actual);
        }
        while (true) {
        }
    }

    public boolean hasSubscribers() {
        return this.actual.hasSubscribers();
    }

    public boolean hasThrowable() {
        return this.actual.hasThrowable();
    }

    public Throwable getThrowable() {
        return this.actual.getThrowable();
    }

    public boolean hasComplete() {
        return this.actual.hasComplete();
    }
}
