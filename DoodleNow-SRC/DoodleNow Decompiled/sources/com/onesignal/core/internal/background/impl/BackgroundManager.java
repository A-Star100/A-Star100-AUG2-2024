package com.onesignal.core.internal.background.impl;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import com.onesignal.common.AndroidSupportV4Compat;
import com.onesignal.core.internal.application.IApplicationLifecycleHandler;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.background.IBackgroundManager;
import com.onesignal.core.internal.background.IBackgroundService;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.core.services.SyncJobService;
import com.onesignal.core.services.SyncService;
import com.onesignal.debug.internal.logging.Logging;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 02\u00020\u00012\u00020\u00022\u00020\u0003:\u00010B#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u0011H\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u0011H\u0002J\b\u0010 \u001a\u00020\u0011H\u0003J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u0011H\u0016J\b\u0010#\u001a\u00020\u001cH\u0016J\u0011\u0010$\u001a\u00020\u001cH@ø\u0001\u0000¢\u0006\u0002\u0010%J\b\u0010&\u001a\u00020\u001cH\u0002J\u0010\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u0017H\u0002J\u0010\u0010)\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u0017H\u0002J\u0010\u0010*\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u0017H\u0003J\u0010\u0010+\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u0017H\u0002J\b\u0010,\u001a\u00020\u001cH\u0016J\b\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u00198\u0002X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u0019X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00061"}, d2 = {"Lcom/onesignal/core/internal/background/impl/BackgroundManager;", "Lcom/onesignal/core/internal/application/IApplicationLifecycleHandler;", "Lcom/onesignal/core/internal/background/IBackgroundManager;", "Lcom/onesignal/core/internal/startup/IStartableService;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "_backgroundServices", "", "Lcom/onesignal/core/internal/background/IBackgroundService;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/core/internal/time/ITime;Ljava/util/List;)V", "backgroundSyncJob", "Lkotlinx/coroutines/Job;", "lock", "", "needsJobReschedule", "", "getNeedsJobReschedule", "()Z", "setNeedsJobReschedule", "(Z)V", "nextScheduledSyncTimeMs", "", "syncServiceJobClass", "Ljava/lang/Class;", "syncServicePendingIntentClass", "cancelBackgroundSyncTask", "", "cancelRunBackgroundServices", "cancelSyncTask", "hasBootPermission", "isJobIdRunning", "onFocus", "firedOnSubscribe", "onUnfocused", "runBackgroundServices", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scheduleBackground", "scheduleBackgroundSyncTask", "delayMs", "scheduleSyncServiceAsAlarm", "scheduleSyncServiceAsJob", "scheduleSyncTask", "start", "syncServicePendingIntent", "Landroid/app/PendingIntent;", "useJob", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: BackgroundManager.kt */
public final class BackgroundManager implements IApplicationLifecycleHandler, IBackgroundManager, IStartableService {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int SYNC_TASK_ID = 2071862118;
    private final IApplicationService _applicationService;
    /* access modifiers changed from: private */
    public final List<IBackgroundService> _backgroundServices;
    private final ITime _time;
    /* access modifiers changed from: private */
    public Job backgroundSyncJob;
    /* access modifiers changed from: private */
    public final Object lock = new Object();
    private boolean needsJobReschedule;
    /* access modifiers changed from: private */
    public long nextScheduledSyncTimeMs;
    private final Class<?> syncServiceJobClass = SyncJobService.class;
    private final Class<?> syncServicePendingIntentClass = SyncService.class;

    private final boolean useJob() {
        return true;
    }

    public boolean getNeedsJobReschedule() {
        return this.needsJobReschedule;
    }

    public void setNeedsJobReschedule(boolean z) {
        this.needsJobReschedule = z;
    }

    public BackgroundManager(IApplicationService iApplicationService, ITime iTime, List<? extends IBackgroundService> list) {
        Intrinsics.checkNotNullParameter(iApplicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(iTime, "_time");
        Intrinsics.checkNotNullParameter(list, "_backgroundServices");
        this._applicationService = iApplicationService;
        this._time = iTime;
        this._backgroundServices = list;
    }

    public void start() {
        this._applicationService.addApplicationLifecycleHandler(this);
    }

    public void onFocus(boolean z) {
        cancelSyncTask();
    }

    public void onUnfocused() {
        scheduleBackground();
    }

    /* access modifiers changed from: private */
    public final void scheduleBackground() {
        Long l = null;
        for (IBackgroundService scheduleBackgroundRunIn : this._backgroundServices) {
            Long scheduleBackgroundRunIn2 = scheduleBackgroundRunIn.getScheduleBackgroundRunIn();
            if (scheduleBackgroundRunIn2 != null && (l == null || scheduleBackgroundRunIn2.longValue() < l.longValue())) {
                l = scheduleBackgroundRunIn2;
            }
        }
        if (l != null) {
            scheduleSyncTask(l.longValue());
        }
    }

    private final void cancelSyncTask() {
        synchronized (this.lock) {
            this.nextScheduledSyncTimeMs = 0;
            cancelBackgroundSyncTask();
            Unit unit = Unit.INSTANCE;
        }
    }

    public Object runBackgroundServices(Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new BackgroundManager$runBackgroundServices$2(this, (Continuation<? super BackgroundManager$runBackgroundServices$2>) null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    public boolean cancelRunBackgroundServices() {
        Job job = this.backgroundSyncJob;
        if (job == null) {
            return false;
        }
        Intrinsics.checkNotNull(job);
        if (!job.isActive()) {
            return false;
        }
        Job job2 = this.backgroundSyncJob;
        Intrinsics.checkNotNull(job2);
        Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        return true;
    }

    private final void scheduleSyncTask(long j) {
        synchronized (this.lock) {
            if (this.nextScheduledSyncTimeMs == 0 || this._time.getCurrentTimeMillis() + j <= this.nextScheduledSyncTimeMs) {
                if (j < 5000) {
                    j = 5000;
                }
                scheduleBackgroundSyncTask(j);
                this.nextScheduledSyncTimeMs = this._time.getCurrentTimeMillis() + j;
                Unit unit = Unit.INSTANCE;
                return;
            }
            Logging.debug$default("OSSyncService scheduleSyncTask already update scheduled nextScheduledSyncTimeMs: " + this.nextScheduledSyncTimeMs, (Throwable) null, 2, (Object) null);
        }
    }

    private final void scheduleBackgroundSyncTask(long j) {
        synchronized (this.lock) {
            if (useJob()) {
                scheduleSyncServiceAsJob(j);
            } else {
                scheduleSyncServiceAsAlarm(j);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final boolean hasBootPermission() {
        return AndroidSupportV4Compat.ContextCompat.INSTANCE.checkSelfPermission(this._applicationService.getAppContext(), "android.permission.RECEIVE_BOOT_COMPLETED") == 0;
    }

    private final boolean isJobIdRunning() {
        Job job;
        Object systemService = this._applicationService.getAppContext().getSystemService("jobscheduler");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.job.JobScheduler");
        for (JobInfo id : ((JobScheduler) systemService).getAllPendingJobs()) {
            if (id.getId() == SYNC_TASK_ID && (job = this.backgroundSyncJob) != null) {
                Intrinsics.checkNotNull(job);
                if (job.isActive()) {
                    return true;
                }
            }
        }
        return false;
    }

    private final void scheduleSyncServiceAsJob(long j) {
        Logging.debug$default("OSBackgroundSync scheduleSyncServiceAsJob:atTime: " + j, (Throwable) null, 2, (Object) null);
        if (isJobIdRunning()) {
            Logging.verbose$default("OSBackgroundSync scheduleSyncServiceAsJob Scheduler already running!", (Throwable) null, 2, (Object) null);
            setNeedsJobReschedule(true);
            return;
        }
        Context appContext = this._applicationService.getAppContext();
        Intrinsics.checkNotNull(appContext);
        Class<?> cls = this.syncServiceJobClass;
        Intrinsics.checkNotNull(cls);
        JobInfo.Builder builder = new JobInfo.Builder(SYNC_TASK_ID, new ComponentName(appContext, cls));
        builder.setMinimumLatency(j).setRequiredNetworkType(1);
        if (hasBootPermission()) {
            builder.setPersisted(true);
        }
        Context appContext2 = this._applicationService.getAppContext();
        Intrinsics.checkNotNull(appContext2);
        Object systemService = appContext2.getSystemService("jobscheduler");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.job.JobScheduler");
        try {
            int schedule = ((JobScheduler) systemService).schedule(builder.build());
            Logging.info$default("OSBackgroundSync scheduleSyncServiceAsJob:result: " + schedule, (Throwable) null, 2, (Object) null);
        } catch (NullPointerException e) {
            Logging.error("scheduleSyncServiceAsJob called JobScheduler.jobScheduler which triggered an internal null Android error. Skipping job.", e);
        }
    }

    private final void scheduleSyncServiceAsAlarm(long j) {
        Logging.verbose$default(getClass().getSimpleName() + " scheduleServiceSyncTask:atTime: " + j, (Throwable) null, 2, (Object) null);
        PendingIntent syncServicePendingIntent = syncServicePendingIntent();
        Object systemService = this._applicationService.getAppContext().getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
        ((AlarmManager) systemService).set(0, this._time.getCurrentTimeMillis() + j, syncServicePendingIntent);
    }

    private final void cancelBackgroundSyncTask() {
        Logging.debug$default(getClass().getSimpleName() + " cancel background sync", (Throwable) null, 2, (Object) null);
        synchronized (this.lock) {
            if (useJob()) {
                Object systemService = this._applicationService.getAppContext().getSystemService("jobscheduler");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.job.JobScheduler");
                ((JobScheduler) systemService).cancel(SYNC_TASK_ID);
            } else {
                Object systemService2 = this._applicationService.getAppContext().getSystemService(NotificationCompat.CATEGORY_ALARM);
                Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.app.AlarmManager");
                ((AlarmManager) systemService2).cancel(syncServicePendingIntent());
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final PendingIntent syncServicePendingIntent() {
        PendingIntent service = PendingIntent.getService(this._applicationService.getAppContext(), SYNC_TASK_ID, new Intent(this._applicationService.getAppContext(), this.syncServicePendingIntentClass), 201326592);
        Intrinsics.checkNotNullExpressionValue(service, "getService(\n            …FLAG_IMMUTABLE,\n        )");
        return service;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/onesignal/core/internal/background/impl/BackgroundManager$Companion;", "", "()V", "SYNC_TASK_ID", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: BackgroundManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
