package androidx.work.impl.utils.taskexecutor;

import java.util.concurrent.Executor;

public interface TaskExecutor {
    void executeOnTaskThread(Runnable runnable);

    Executor getMainThreadExecutor();

    SerialExecutor getSerialTaskExecutor();

    /* renamed from: androidx.work.impl.utils.taskexecutor.TaskExecutor$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$executeOnTaskThread(TaskExecutor _this, Runnable runnable) {
            _this.getSerialTaskExecutor().execute(runnable);
        }
    }
}
