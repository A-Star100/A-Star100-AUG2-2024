package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.net.Network;
import android.net.Uri;
import android.os.PersistableBundle;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkGenerationalId;
import java.util.HashMap;
import java.util.Map;

public class SystemJobService extends JobService implements ExecutionListener {
    private static final String TAG = Logger.tagWithPrefix("SystemJobService");
    private final Map<WorkGenerationalId, JobParameters> mJobParameters = new HashMap();
    private final StartStopTokens mStartStopTokens = new StartStopTokens();
    private WorkManagerImpl mWorkManagerImpl;

    public void onCreate() {
        super.onCreate();
        try {
            WorkManagerImpl instance = WorkManagerImpl.getInstance(getApplicationContext());
            this.mWorkManagerImpl = instance;
            instance.getProcessor().addExecutionListener(this);
        } catch (IllegalStateException unused) {
            if (Application.class.equals(getApplication().getClass())) {
                Logger.get().warning(TAG, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.");
                return;
            }
            throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
        }
    }

    public void onDestroy() {
        super.onDestroy();
        WorkManagerImpl workManagerImpl = this.mWorkManagerImpl;
        if (workManagerImpl != null) {
            workManagerImpl.getProcessor().removeExecutionListener(this);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006c, code lost:
        if (android.os.Build.VERSION.SDK_INT < 24) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006e, code lost:
        r0 = new androidx.work.WorkerParameters.RuntimeExtras();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0077, code lost:
        if (androidx.work.impl.background.systemjob.SystemJobService.Api24Impl.getTriggeredContentUris(r8) == null) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0079, code lost:
        r0.triggeredContentUris = java.util.Arrays.asList(androidx.work.impl.background.systemjob.SystemJobService.Api24Impl.getTriggeredContentUris(r8));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0087, code lost:
        if (androidx.work.impl.background.systemjob.SystemJobService.Api24Impl.getTriggeredContentAuthorities(r8) == null) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0089, code lost:
        r0.triggeredContentAuthorities = java.util.Arrays.asList(androidx.work.impl.background.systemjob.SystemJobService.Api24Impl.getTriggeredContentAuthorities(r8));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0097, code lost:
        if (android.os.Build.VERSION.SDK_INT < 28) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0099, code lost:
        r0.network = androidx.work.impl.background.systemjob.SystemJobService.Api28Impl.getNetwork(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a0, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a1, code lost:
        r7.mWorkManagerImpl.startWork(r7.mStartStopTokens.tokenFor(r2), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ac, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onStartJob(android.app.job.JobParameters r8) {
        /*
            r7 = this;
            java.lang.String r0 = "Job is already being executed by SystemJobService: "
            java.lang.String r1 = "onStartJob for "
            androidx.work.impl.WorkManagerImpl r2 = r7.mWorkManagerImpl
            r3 = 1
            r4 = 0
            if (r2 != 0) goto L_0x0019
            androidx.work.Logger r0 = androidx.work.Logger.get()
            java.lang.String r1 = TAG
            java.lang.String r2 = "WorkManager is not initialized; requesting retry."
            r0.debug(r1, r2)
            r7.jobFinished(r8, r3)
            return r4
        L_0x0019:
            androidx.work.impl.model.WorkGenerationalId r2 = workGenerationalIdFromJobParameters(r8)
            if (r2 != 0) goto L_0x002b
            androidx.work.Logger r8 = androidx.work.Logger.get()
            java.lang.String r0 = TAG
            java.lang.String r1 = "WorkSpec id not found!"
            r8.error(r0, r1)
            return r4
        L_0x002b:
            java.util.Map<androidx.work.impl.model.WorkGenerationalId, android.app.job.JobParameters> r5 = r7.mJobParameters
            monitor-enter(r5)
            java.util.Map<androidx.work.impl.model.WorkGenerationalId, android.app.job.JobParameters> r6 = r7.mJobParameters     // Catch:{ all -> 0x00ad }
            boolean r6 = r6.containsKey(r2)     // Catch:{ all -> 0x00ad }
            if (r6 == 0) goto L_0x004d
            androidx.work.Logger r8 = androidx.work.Logger.get()     // Catch:{ all -> 0x00ad }
            java.lang.String r1 = TAG     // Catch:{ all -> 0x00ad }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ad }
            r3.<init>(r0)     // Catch:{ all -> 0x00ad }
            r3.append(r2)     // Catch:{ all -> 0x00ad }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x00ad }
            r8.debug(r1, r0)     // Catch:{ all -> 0x00ad }
            monitor-exit(r5)     // Catch:{ all -> 0x00ad }
            return r4
        L_0x004d:
            androidx.work.Logger r0 = androidx.work.Logger.get()     // Catch:{ all -> 0x00ad }
            java.lang.String r4 = TAG     // Catch:{ all -> 0x00ad }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ad }
            r6.<init>(r1)     // Catch:{ all -> 0x00ad }
            r6.append(r2)     // Catch:{ all -> 0x00ad }
            java.lang.String r1 = r6.toString()     // Catch:{ all -> 0x00ad }
            r0.debug(r4, r1)     // Catch:{ all -> 0x00ad }
            java.util.Map<androidx.work.impl.model.WorkGenerationalId, android.app.job.JobParameters> r0 = r7.mJobParameters     // Catch:{ all -> 0x00ad }
            r0.put(r2, r8)     // Catch:{ all -> 0x00ad }
            monitor-exit(r5)     // Catch:{ all -> 0x00ad }
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 24
            if (r0 < r1) goto L_0x00a0
            androidx.work.WorkerParameters$RuntimeExtras r0 = new androidx.work.WorkerParameters$RuntimeExtras
            r0.<init>()
            android.net.Uri[] r1 = androidx.work.impl.background.systemjob.SystemJobService.Api24Impl.getTriggeredContentUris(r8)
            if (r1 == 0) goto L_0x0083
            android.net.Uri[] r1 = androidx.work.impl.background.systemjob.SystemJobService.Api24Impl.getTriggeredContentUris(r8)
            java.util.List r1 = java.util.Arrays.asList(r1)
            r0.triggeredContentUris = r1
        L_0x0083:
            java.lang.String[] r1 = androidx.work.impl.background.systemjob.SystemJobService.Api24Impl.getTriggeredContentAuthorities(r8)
            if (r1 == 0) goto L_0x0093
            java.lang.String[] r1 = androidx.work.impl.background.systemjob.SystemJobService.Api24Impl.getTriggeredContentAuthorities(r8)
            java.util.List r1 = java.util.Arrays.asList(r1)
            r0.triggeredContentAuthorities = r1
        L_0x0093:
            int r1 = android.os.Build.VERSION.SDK_INT
            r4 = 28
            if (r1 < r4) goto L_0x00a1
            android.net.Network r8 = androidx.work.impl.background.systemjob.SystemJobService.Api28Impl.getNetwork(r8)
            r0.network = r8
            goto L_0x00a1
        L_0x00a0:
            r0 = 0
        L_0x00a1:
            androidx.work.impl.WorkManagerImpl r8 = r7.mWorkManagerImpl
            androidx.work.impl.StartStopTokens r1 = r7.mStartStopTokens
            androidx.work.impl.StartStopToken r1 = r1.tokenFor((androidx.work.impl.model.WorkGenerationalId) r2)
            r8.startWork(r1, r0)
            return r3
        L_0x00ad:
            r8 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x00ad }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.background.systemjob.SystemJobService.onStartJob(android.app.job.JobParameters):boolean");
    }

    public boolean onStopJob(JobParameters jobParameters) {
        if (this.mWorkManagerImpl == null) {
            Logger.get().debug(TAG, "WorkManager is not initialized; requesting retry.");
            return true;
        }
        WorkGenerationalId workGenerationalIdFromJobParameters = workGenerationalIdFromJobParameters(jobParameters);
        if (workGenerationalIdFromJobParameters == null) {
            Logger.get().error(TAG, "WorkSpec id not found!");
            return false;
        }
        Logger logger = Logger.get();
        String str = TAG;
        logger.debug(str, "onStopJob for " + workGenerationalIdFromJobParameters);
        synchronized (this.mJobParameters) {
            this.mJobParameters.remove(workGenerationalIdFromJobParameters);
        }
        StartStopToken remove = this.mStartStopTokens.remove(workGenerationalIdFromJobParameters);
        if (remove != null) {
            this.mWorkManagerImpl.stopWork(remove);
        }
        return !this.mWorkManagerImpl.getProcessor().isCancelled(workGenerationalIdFromJobParameters.getWorkSpecId());
    }

    public void onExecuted(WorkGenerationalId workGenerationalId, boolean z) {
        JobParameters remove;
        Logger logger = Logger.get();
        String str = TAG;
        logger.debug(str, workGenerationalId.getWorkSpecId() + " executed on JobScheduler");
        synchronized (this.mJobParameters) {
            remove = this.mJobParameters.remove(workGenerationalId);
        }
        this.mStartStopTokens.remove(workGenerationalId);
        if (remove != null) {
            jobFinished(remove, z);
        }
    }

    private static WorkGenerationalId workGenerationalIdFromJobParameters(JobParameters jobParameters) {
        try {
            PersistableBundle extras = jobParameters.getExtras();
            if (extras == null || !extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return new WorkGenerationalId(extras.getString("EXTRA_WORK_SPEC_ID"), extras.getInt("EXTRA_WORK_SPEC_GENERATION"));
        } catch (NullPointerException unused) {
            return null;
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static Uri[] getTriggeredContentUris(JobParameters jobParameters) {
            return jobParameters.getTriggeredContentUris();
        }

        static String[] getTriggeredContentAuthorities(JobParameters jobParameters) {
            return jobParameters.getTriggeredContentAuthorities();
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static Network getNetwork(JobParameters jobParameters) {
            return jobParameters.getNetwork();
        }
    }
}
