package com.bleplx.adapter.utils;

import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DisposableMap {
    private final Map<String, Disposable> subscriptions = new HashMap();

    public synchronized void replaceSubscription(String str, Disposable disposable) {
        Disposable put = this.subscriptions.put(str, disposable);
        if (put != null && !put.isDisposed()) {
            put.dispose();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean removeSubscription(java.lang.String r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.Map<java.lang.String, io.reactivex.disposables.Disposable> r0 = r1.subscriptions     // Catch:{ all -> 0x001a }
            java.lang.Object r2 = r0.remove(r2)     // Catch:{ all -> 0x001a }
            io.reactivex.disposables.Disposable r2 = (io.reactivex.disposables.Disposable) r2     // Catch:{ all -> 0x001a }
            if (r2 != 0) goto L_0x000e
            monitor-exit(r1)
            r2 = 0
            return r2
        L_0x000e:
            boolean r0 = r2.isDisposed()     // Catch:{ all -> 0x001a }
            if (r0 != 0) goto L_0x0017
            r2.dispose()     // Catch:{ all -> 0x001a }
        L_0x0017:
            monitor-exit(r1)
            r2 = 1
            return r2
        L_0x001a:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bleplx.adapter.utils.DisposableMap.removeSubscription(java.lang.String):boolean");
    }

    public synchronized void removeAllSubscriptions() {
        Iterator<Map.Entry<String, Disposable>> it = this.subscriptions.entrySet().iterator();
        while (it.hasNext()) {
            Disposable disposable = (Disposable) it.next().getValue();
            it.remove();
            if (!disposable.isDisposed()) {
                disposable.dispose();
            }
        }
    }
}
