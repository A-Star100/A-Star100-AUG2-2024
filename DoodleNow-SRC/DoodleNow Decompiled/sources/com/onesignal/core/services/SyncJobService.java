package com.onesignal.core.services;

import android.app.job.JobParameters;
import android.app.job.JobService;
import com.onesignal.OneSignal;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.internal.background.IBackgroundManager;
import com.onesignal.debug.internal.logging.Logging;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/onesignal/core/services/SyncJobService;", "Landroid/app/job/JobService;", "()V", "onStartJob", "", "jobParameters", "Landroid/app/job/JobParameters;", "onStopJob", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SyncJobService.kt */
public final class SyncJobService extends JobService {
    public boolean onStartJob(JobParameters jobParameters) {
        Intrinsics.checkNotNullParameter(jobParameters, "jobParameters");
        if (!OneSignal.initWithContext(this)) {
            return false;
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = OneSignal.INSTANCE.getServices().getService(IBackgroundManager.class);
        ThreadUtilsKt.suspendifyOnThread$default(0, new SyncJobService$onStartJob$1(objectRef, this, jobParameters, (Continuation<? super SyncJobService$onStartJob$1>) null), 1, (Object) null);
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        Intrinsics.checkNotNullParameter(jobParameters, "jobParameters");
        boolean cancelRunBackgroundServices = ((IBackgroundManager) OneSignal.INSTANCE.getServices().getService(IBackgroundManager.class)).cancelRunBackgroundServices();
        Logging.debug$default("SyncJobService onStopJob called, system conditions not available reschedule: " + cancelRunBackgroundServices, (Throwable) null, 2, (Object) null);
        return cancelRunBackgroundServices;
    }
}
