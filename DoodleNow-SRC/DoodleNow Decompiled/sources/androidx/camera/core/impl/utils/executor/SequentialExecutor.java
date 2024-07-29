package androidx.camera.core.impl.utils.executor;

import androidx.core.util.Preconditions;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;

final class SequentialExecutor implements Executor {
    private static final String TAG = "SequentialExecutor";
    private final Executor mExecutor;
    final Deque<Runnable> mQueue = new ArrayDeque();
    private final QueueWorker mWorker = new QueueWorker();
    long mWorkerRunCount = 0;
    WorkerRunningState mWorkerRunningState = WorkerRunningState.IDLE;

    enum WorkerRunningState {
        IDLE,
        QUEUING,
        QUEUED,
        RUNNING
    }

    SequentialExecutor(Executor executor) {
        this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r5.mExecutor.execute(r5.mWorker);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        if (r5.mWorkerRunningState == androidx.camera.core.impl.utils.executor.SequentialExecutor.WorkerRunningState.QUEUING) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0032, code lost:
        r6 = r5.mQueue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0034, code lost:
        monitor-enter(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0039, code lost:
        if (r5.mWorkerRunCount != r1) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003f, code lost:
        if (r5.mWorkerRunningState != androidx.camera.core.impl.utils.executor.SequentialExecutor.WorkerRunningState.QUEUING) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0041, code lost:
        r5.mWorkerRunningState = androidx.camera.core.impl.utils.executor.SequentialExecutor.WorkerRunningState.QUEUED;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0045, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0046, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004a, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x004f, code lost:
        monitor-enter(r5.mQueue);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0054, code lost:
        if (r5.mWorkerRunningState == androidx.camera.core.impl.utils.executor.SequentialExecutor.WorkerRunningState.IDLE) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0064, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0066, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0069, code lost:
        if ((r6 instanceof java.util.concurrent.RejectedExecutionException) == false) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x006e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x006f, code lost:
        throw r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void execute(final java.lang.Runnable r6) {
        /*
            r5 = this;
            androidx.core.util.Preconditions.checkNotNull(r6)
            java.util.Deque<java.lang.Runnable> r0 = r5.mQueue
            monitor-enter(r0)
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r1 = r5.mWorkerRunningState     // Catch:{ all -> 0x007a }
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r2 = androidx.camera.core.impl.utils.executor.SequentialExecutor.WorkerRunningState.RUNNING     // Catch:{ all -> 0x007a }
            if (r1 == r2) goto L_0x0073
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r1 = r5.mWorkerRunningState     // Catch:{ all -> 0x007a }
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r2 = androidx.camera.core.impl.utils.executor.SequentialExecutor.WorkerRunningState.QUEUED     // Catch:{ all -> 0x007a }
            if (r1 != r2) goto L_0x0013
            goto L_0x0073
        L_0x0013:
            long r1 = r5.mWorkerRunCount     // Catch:{ all -> 0x007a }
            androidx.camera.core.impl.utils.executor.SequentialExecutor$1 r3 = new androidx.camera.core.impl.utils.executor.SequentialExecutor$1     // Catch:{ all -> 0x007a }
            r3.<init>(r6)     // Catch:{ all -> 0x007a }
            java.util.Deque<java.lang.Runnable> r6 = r5.mQueue     // Catch:{ all -> 0x007a }
            r6.add(r3)     // Catch:{ all -> 0x007a }
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r6 = androidx.camera.core.impl.utils.executor.SequentialExecutor.WorkerRunningState.QUEUING     // Catch:{ all -> 0x007a }
            r5.mWorkerRunningState = r6     // Catch:{ all -> 0x007a }
            monitor-exit(r0)     // Catch:{ all -> 0x007a }
            java.util.concurrent.Executor r6 = r5.mExecutor     // Catch:{ RuntimeException -> 0x004c, Error -> 0x004a }
            androidx.camera.core.impl.utils.executor.SequentialExecutor$QueueWorker r0 = r5.mWorker     // Catch:{ RuntimeException -> 0x004c, Error -> 0x004a }
            r6.execute(r0)     // Catch:{ RuntimeException -> 0x004c, Error -> 0x004a }
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r6 = r5.mWorkerRunningState
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r0 = androidx.camera.core.impl.utils.executor.SequentialExecutor.WorkerRunningState.QUEUING
            if (r6 == r0) goto L_0x0032
            return
        L_0x0032:
            java.util.Deque<java.lang.Runnable> r6 = r5.mQueue
            monitor-enter(r6)
            long r3 = r5.mWorkerRunCount     // Catch:{ all -> 0x0047 }
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0045
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r0 = r5.mWorkerRunningState     // Catch:{ all -> 0x0047 }
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r1 = androidx.camera.core.impl.utils.executor.SequentialExecutor.WorkerRunningState.QUEUING     // Catch:{ all -> 0x0047 }
            if (r0 != r1) goto L_0x0045
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r0 = androidx.camera.core.impl.utils.executor.SequentialExecutor.WorkerRunningState.QUEUED     // Catch:{ all -> 0x0047 }
            r5.mWorkerRunningState = r0     // Catch:{ all -> 0x0047 }
        L_0x0045:
            monitor-exit(r6)     // Catch:{ all -> 0x0047 }
            return
        L_0x0047:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0047 }
            throw r0
        L_0x004a:
            r6 = move-exception
            goto L_0x004d
        L_0x004c:
            r6 = move-exception
        L_0x004d:
            java.util.Deque<java.lang.Runnable> r1 = r5.mQueue
            monitor-enter(r1)
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r0 = r5.mWorkerRunningState     // Catch:{ all -> 0x0070 }
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r2 = androidx.camera.core.impl.utils.executor.SequentialExecutor.WorkerRunningState.IDLE     // Catch:{ all -> 0x0070 }
            if (r0 == r2) goto L_0x005c
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r0 = r5.mWorkerRunningState     // Catch:{ all -> 0x0070 }
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r2 = androidx.camera.core.impl.utils.executor.SequentialExecutor.WorkerRunningState.QUEUING     // Catch:{ all -> 0x0070 }
            if (r0 != r2) goto L_0x0066
        L_0x005c:
            java.util.Deque<java.lang.Runnable> r0 = r5.mQueue     // Catch:{ all -> 0x0070 }
            boolean r0 = r0.removeLastOccurrence(r3)     // Catch:{ all -> 0x0070 }
            if (r0 == 0) goto L_0x0066
            r0 = 1
            goto L_0x0067
        L_0x0066:
            r0 = 0
        L_0x0067:
            boolean r2 = r6 instanceof java.util.concurrent.RejectedExecutionException     // Catch:{ all -> 0x0070 }
            if (r2 == 0) goto L_0x006f
            if (r0 != 0) goto L_0x006f
            monitor-exit(r1)     // Catch:{ all -> 0x0070 }
            return
        L_0x006f:
            throw r6     // Catch:{ all -> 0x0070 }
        L_0x0070:
            r6 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0070 }
            throw r6
        L_0x0073:
            java.util.Deque<java.lang.Runnable> r1 = r5.mQueue     // Catch:{ all -> 0x007a }
            r1.add(r6)     // Catch:{ all -> 0x007a }
            monitor-exit(r0)     // Catch:{ all -> 0x007a }
            return
        L_0x007a:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x007a }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.utils.executor.SequentialExecutor.execute(java.lang.Runnable):void");
    }

    final class QueueWorker implements Runnable {
        QueueWorker() {
        }

        public void run() {
            try {
                workOnQueue();
            } catch (Error e) {
                synchronized (SequentialExecutor.this.mQueue) {
                    SequentialExecutor.this.mWorkerRunningState = WorkerRunningState.IDLE;
                    throw e;
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0014, code lost:
            java.lang.Thread.currentThread().interrupt();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x003f, code lost:
            if (r1 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0041, code lost:
            java.lang.Thread.currentThread().interrupt();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x004e, code lost:
            r1 = r1 | java.lang.Thread.interrupted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            r3.run();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
            if (r1 == false) goto L_?;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void workOnQueue() {
            /*
                r7 = this;
                r0 = 0
                r1 = r0
            L_0x0002:
                androidx.camera.core.impl.utils.executor.SequentialExecutor r2 = androidx.camera.core.impl.utils.executor.SequentialExecutor.this     // Catch:{ all -> 0x006e }
                java.util.Deque<java.lang.Runnable> r2 = r2.mQueue     // Catch:{ all -> 0x006e }
                monitor-enter(r2)     // Catch:{ all -> 0x006e }
                if (r0 != 0) goto L_0x002c
                androidx.camera.core.impl.utils.executor.SequentialExecutor r0 = androidx.camera.core.impl.utils.executor.SequentialExecutor.this     // Catch:{ all -> 0x006b }
                androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r0 = r0.mWorkerRunningState     // Catch:{ all -> 0x006b }
                androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r3 = androidx.camera.core.impl.utils.executor.SequentialExecutor.WorkerRunningState.RUNNING     // Catch:{ all -> 0x006b }
                if (r0 != r3) goto L_0x001c
                monitor-exit(r2)     // Catch:{ all -> 0x006b }
                if (r1 == 0) goto L_0x001b
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
            L_0x001b:
                return
            L_0x001c:
                androidx.camera.core.impl.utils.executor.SequentialExecutor r0 = androidx.camera.core.impl.utils.executor.SequentialExecutor.this     // Catch:{ all -> 0x006b }
                long r3 = r0.mWorkerRunCount     // Catch:{ all -> 0x006b }
                r5 = 1
                long r3 = r3 + r5
                r0.mWorkerRunCount = r3     // Catch:{ all -> 0x006b }
                androidx.camera.core.impl.utils.executor.SequentialExecutor r0 = androidx.camera.core.impl.utils.executor.SequentialExecutor.this     // Catch:{ all -> 0x006b }
                androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r3 = androidx.camera.core.impl.utils.executor.SequentialExecutor.WorkerRunningState.RUNNING     // Catch:{ all -> 0x006b }
                r0.mWorkerRunningState = r3     // Catch:{ all -> 0x006b }
                r0 = 1
            L_0x002c:
                androidx.camera.core.impl.utils.executor.SequentialExecutor r3 = androidx.camera.core.impl.utils.executor.SequentialExecutor.this     // Catch:{ all -> 0x006b }
                java.util.Deque<java.lang.Runnable> r3 = r3.mQueue     // Catch:{ all -> 0x006b }
                java.lang.Object r3 = r3.poll()     // Catch:{ all -> 0x006b }
                java.lang.Runnable r3 = (java.lang.Runnable) r3     // Catch:{ all -> 0x006b }
                if (r3 != 0) goto L_0x0049
                androidx.camera.core.impl.utils.executor.SequentialExecutor r0 = androidx.camera.core.impl.utils.executor.SequentialExecutor.this     // Catch:{ all -> 0x006b }
                androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r3 = androidx.camera.core.impl.utils.executor.SequentialExecutor.WorkerRunningState.IDLE     // Catch:{ all -> 0x006b }
                r0.mWorkerRunningState = r3     // Catch:{ all -> 0x006b }
                monitor-exit(r2)     // Catch:{ all -> 0x006b }
                if (r1 == 0) goto L_0x0048
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
            L_0x0048:
                return
            L_0x0049:
                monitor-exit(r2)     // Catch:{ all -> 0x006b }
                boolean r2 = java.lang.Thread.interrupted()     // Catch:{ all -> 0x006e }
                r1 = r1 | r2
                r3.run()     // Catch:{ RuntimeException -> 0x0053 }
                goto L_0x0002
            L_0x0053:
                r2 = move-exception
                java.lang.String r4 = "SequentialExecutor"
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x006e }
                r5.<init>()     // Catch:{ all -> 0x006e }
                java.lang.String r6 = "Exception while executing runnable "
                r5.append(r6)     // Catch:{ all -> 0x006e }
                r5.append(r3)     // Catch:{ all -> 0x006e }
                java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x006e }
                androidx.camera.core.Logger.e(r4, r3, r2)     // Catch:{ all -> 0x006e }
                goto L_0x0002
            L_0x006b:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x006b }
                throw r0     // Catch:{ all -> 0x006e }
            L_0x006e:
                r0 = move-exception
                if (r1 == 0) goto L_0x0078
                java.lang.Thread r1 = java.lang.Thread.currentThread()
                r1.interrupt()
            L_0x0078:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.utils.executor.SequentialExecutor.QueueWorker.workOnQueue():void");
        }
    }
}
