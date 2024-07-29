package com.google.android.gms.internal.mlkit_common;

import java.util.concurrent.Executor;

/* compiled from: com.google.mlkit:common@@18.9.0 */
enum zzbg implements Executor {
    INSTANCE;

    public final void execute(Runnable runnable) {
        runnable.run();
    }

    public final String toString() {
        return "MoreExecutors.directExecutor()";
    }
}
