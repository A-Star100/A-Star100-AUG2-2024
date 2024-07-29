package expo.modules.location.taskConsumers;

import android.app.PendingIntent;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import androidx.camera.video.AudioStats;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.tasks.Task;
import com.onesignal.session.internal.outcomes.impl.OutcomeEventsTable;
import expo.modules.core.MapHelper;
import expo.modules.core.arguments.MapArguments;
import expo.modules.core.arguments.ReadableArguments;
import expo.modules.core.interfaces.Arguments;
import expo.modules.core.interfaces.LifecycleEventListener;
import expo.modules.interfaces.taskManager.TaskConsumer;
import expo.modules.interfaces.taskManager.TaskConsumerInterface;
import expo.modules.interfaces.taskManager.TaskExecutionCallback;
import expo.modules.interfaces.taskManager.TaskInterface;
import expo.modules.interfaces.taskManager.TaskManagerUtilsInterface;
import expo.modules.location.AppForegroundedSingleton;
import expo.modules.location.LocationHelpers;
import expo.modules.location.records.LocationOptions;
import expo.modules.location.records.LocationResponse;
import expo.modules.location.services.LocationTaskService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000 E2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001EB\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\r0\"H\u0002J\u0018\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020\u001eH\u0016J\b\u0010-\u001a\u00020 H\u0016J(\u0010.\u001a\u00020 2\u0016\u0010/\u001a\u0012\u0012\u0004\u0012\u00020100j\b\u0012\u0004\u0012\u000201`22\u0006\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u00020 H\u0002J\b\u00106\u001a\u00020 H\u0002J\b\u00107\u001a\u00020 H\u0016J\b\u00108\u001a\u00020 H\u0016J\b\u00109\u001a\u00020 H\u0016J\b\u0010:\u001a\u00020\u001aH\u0002J\u001c\u0010;\u001a\u00020 2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020?0=H\u0016J\b\u0010@\u001a\u00020\u000fH\u0002J\b\u0010A\u001a\u00020 H\u0002J\b\u0010B\u001a\u00020 H\u0002J\b\u0010C\u001a\u00020 H\u0002J\b\u0010D\u001a\u00020>H\u0016R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lexpo/modules/location/taskConsumers/LocationTaskConsumer;", "Lexpo/modules/interfaces/taskManager/TaskConsumer;", "Lexpo/modules/interfaces/taskManager/TaskConsumerInterface;", "Lexpo/modules/core/interfaces/LifecycleEventListener;", "context", "Landroid/content/Context;", "taskManagerUtils", "Lexpo/modules/interfaces/taskManager/TaskManagerUtilsInterface;", "(Landroid/content/Context;Lexpo/modules/interfaces/taskManager/TaskManagerUtilsInterface;)V", "mDeferredDistance", "", "mDeferredLocations", "", "Landroid/location/Location;", "mIsHostPaused", "", "mLastReportedLocation", "mLocationClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "getMLocationClient", "()Lcom/google/android/gms/location/FusedLocationProviderClient;", "mLocationClient$delegate", "Lkotlin/Lazy;", "mLocationRequest", "Lcom/google/android/gms/location/LocationRequest;", "mPendingIntent", "Landroid/app/PendingIntent;", "mService", "Lexpo/modules/location/services/LocationTaskService;", "mTask", "Lexpo/modules/interfaces/taskManager/TaskInterface;", "deferLocations", "", "locations", "", "didExecuteJob", "jobService", "Landroid/app/job/JobService;", "params", "Landroid/app/job/JobParameters;", "didReceiveBroadcast", "intent", "Landroid/content/Intent;", "didRegister", "task", "didUnregister", "executeTaskWithLocationBundles", "locationBundles", "Ljava/util/ArrayList;", "Landroid/os/Bundle;", "Lkotlin/collections/ArrayList;", "callback", "Lexpo/modules/interfaces/taskManager/TaskExecutionCallback;", "maybeReportDeferredLocations", "maybeStartForegroundService", "onHostDestroy", "onHostPause", "onHostResume", "preparePendingIntent", "setOptions", "options", "", "", "", "shouldReportDeferredLocations", "startLocationUpdates", "stopForegroundService", "stopLocationUpdates", "taskType", "Companion", "expo-location_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LocationTaskConsumer.kt */
public final class LocationTaskConsumer extends TaskConsumer implements TaskConsumerInterface, LifecycleEventListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String FOREGROUND_SERVICE_KEY = "foregroundService";
    private static final String TAG = "LocationTaskConsumer";
    private static long sLastTimestamp;
    private double mDeferredDistance;
    private final List<Location> mDeferredLocations = new ArrayList();
    private boolean mIsHostPaused = true;
    private Location mLastReportedLocation;
    private final Lazy mLocationClient$delegate;
    private LocationRequest mLocationRequest;
    private PendingIntent mPendingIntent;
    /* access modifiers changed from: private */
    public LocationTaskService mService;
    private TaskInterface mTask;

    public void onHostDestroy() {
        this.mIsHostPaused = true;
    }

    public void onHostPause() {
        this.mIsHostPaused = true;
    }

    public String taskType() {
        return "location";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LocationTaskConsumer(Context context, TaskManagerUtilsInterface taskManagerUtilsInterface) {
        super(context, taskManagerUtilsInterface);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mLocationClient$delegate = LazyKt.lazy(new LocationTaskConsumer$mLocationClient$2(context));
    }

    private final FusedLocationProviderClient getMLocationClient() {
        return (FusedLocationProviderClient) this.mLocationClient$delegate.getValue();
    }

    public void didRegister(TaskInterface taskInterface) {
        Intrinsics.checkNotNullParameter(taskInterface, "task");
        this.mTask = taskInterface;
        startLocationUpdates();
        maybeStartForegroundService();
    }

    public void didUnregister() {
        stopLocationUpdates();
        stopForegroundService();
        this.mTask = null;
        this.mPendingIntent = null;
        this.mLocationRequest = null;
    }

    public void setOptions(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "options");
        super.setOptions(map);
        stopLocationUpdates();
        startLocationUpdates();
        maybeStartForegroundService();
    }

    public void didReceiveBroadcast(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (this.mTask != null) {
            LocationResult extractResult = LocationResult.extractResult(intent);
            if (extractResult != null) {
                List<Location> locations = extractResult.getLocations();
                Intrinsics.checkNotNullExpressionValue(locations, "getLocations(...)");
                deferLocations(locations);
                maybeReportDeferredLocations();
                return;
            }
            try {
                getMLocationClient().getLastLocation().addOnCompleteListener(new LocationTaskConsumer$$ExternalSyntheticLambda2(this));
            } catch (SecurityException e) {
                String message = e.getMessage();
                Log.e(TAG, "Cannot get last location: " + message);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void didReceiveBroadcast$lambda$1(LocationTaskConsumer locationTaskConsumer, Task task) {
        Intrinsics.checkNotNullParameter(locationTaskConsumer, "this$0");
        Intrinsics.checkNotNullParameter(task, "task");
        Location location = (Location) task.getResult();
        if (location != null) {
            locationTaskConsumer.deferLocations(CollectionsKt.listOf(location));
            locationTaskConsumer.maybeReportDeferredLocations();
        }
    }

    public boolean didExecuteJob(JobService jobService, JobParameters jobParameters) {
        Intrinsics.checkNotNullParameter(jobService, "jobService");
        Intrinsics.checkNotNullParameter(jobParameters, OutcomeEventsTable.COLUMN_NAME_PARAMS);
        List<PersistableBundle> extractDataFromJobParams = getTaskManagerUtils().extractDataFromJobParams(jobParameters);
        ArrayList arrayList = new ArrayList();
        for (PersistableBundle next : extractDataFromJobParams) {
            Bundle bundle = new Bundle();
            Bundle bundle2 = new Bundle();
            if (next != null) {
                bundle2.putAll(next.getPersistableBundle("coords"));
                bundle.putAll(next);
                bundle.putBundle("coords", bundle2);
                arrayList.add(bundle);
            }
        }
        executeTaskWithLocationBundles(arrayList, new LocationTaskConsumer$$ExternalSyntheticLambda1(jobService, jobParameters));
        return true;
    }

    /* access modifiers changed from: private */
    public static final void didExecuteJob$lambda$2(JobService jobService, JobParameters jobParameters, Map map) {
        Intrinsics.checkNotNullParameter(jobService, "$jobService");
        Intrinsics.checkNotNullParameter(jobParameters, "$params");
        jobService.jobFinished(jobParameters, false);
    }

    private final void startLocationUpdates() {
        Context context = getContext();
        if (context == null) {
            LocationTaskConsumer locationTaskConsumer = this;
            Log.w(TAG, "The context has been abandoned");
        } else if (!LocationHelpers.Companion.isAnyProviderAvailable(context)) {
            Log.w(TAG, "There is no location provider available");
        } else {
            TaskInterface taskInterface = this.mTask;
            if (taskInterface == null) {
                LocationTaskConsumer locationTaskConsumer2 = this;
                Log.w(TAG, "Could not find a location task for the location update");
                return;
            }
            LocationHelpers.Companion companion = LocationHelpers.Companion;
            Map<String, Object> options = taskInterface.getOptions();
            Intrinsics.checkNotNullExpressionValue(options, "getOptions(...)");
            this.mLocationRequest = companion.prepareLocationRequest$expo_location_release(new LocationOptions(options));
            PendingIntent preparePendingIntent = preparePendingIntent();
            this.mPendingIntent = preparePendingIntent;
            LocationRequest locationRequest = this.mLocationRequest;
            if (locationRequest == null) {
                LocationTaskConsumer locationTaskConsumer3 = this;
                Log.w(TAG, "Could not find a location request for the location update");
            } else if (preparePendingIntent == null) {
                LocationTaskConsumer locationTaskConsumer4 = this;
                Log.w(TAG, "Could not find intent for the location update");
            } else {
                try {
                    getMLocationClient().requestLocationUpdates(locationRequest, preparePendingIntent);
                } catch (SecurityException e) {
                    Log.w(TAG, "Location request has been rejected.", e);
                }
            }
        }
    }

    private final void stopLocationUpdates() {
        PendingIntent pendingIntent = this.mPendingIntent;
        if (pendingIntent != null) {
            getMLocationClient().removeLocationUpdates(pendingIntent);
            pendingIntent.cancel();
        }
    }

    private final void maybeStartForegroundService() {
        if (Build.VERSION.SDK_INT >= 26) {
            if (!AppForegroundedSingleton.INSTANCE.isForegrounded()) {
                Log.w(TAG, "Foreground location task cannot be started while the app is in the background!");
                return;
            }
            TaskInterface taskInterface = this.mTask;
            if (taskInterface == null) {
                LocationTaskConsumer locationTaskConsumer = this;
                Log.w(TAG, "Location task is null");
                return;
            }
            ReadableArguments mapArguments = new MapArguments(taskInterface.getOptions());
            Companion companion = Companion;
            Map<String, Object> options = taskInterface.getOptions();
            Intrinsics.checkNotNullExpressionValue(options, "getOptions(...)");
            boolean shouldUseForegroundService = companion.shouldUseForegroundService(options);
            LocationTaskService locationTaskService = this.mService;
            if (locationTaskService != null && !shouldUseForegroundService) {
                stopForegroundService();
            } else if (shouldUseForegroundService) {
                if (locationTaskService == null) {
                    Intent intent = new Intent(getContext(), LocationTaskService.class);
                    Bundle bundle = new Bundle();
                    Bundle bundle2 = mapArguments.getArguments(FOREGROUND_SERVICE_KEY).toBundle();
                    bundle.putString("appId", taskInterface.getAppScopeKey());
                    bundle.putString("taskName", taskInterface.getName());
                    bundle.putBoolean("killService", bundle2.getBoolean("killServiceOnDestroy", false));
                    intent.putExtras(bundle);
                    ComponentName unused = getContext().startForegroundService(intent);
                    getContext().bindService(intent, new LocationTaskConsumer$maybeStartForegroundService$1(this, bundle2), 1);
                } else if (locationTaskService != null) {
                    Bundle bundle3 = mapArguments.getArguments(FOREGROUND_SERVICE_KEY).toBundle();
                    Intrinsics.checkNotNullExpressionValue(bundle3, "toBundle(...)");
                    locationTaskService.startForeground(bundle3);
                }
            }
        }
    }

    private final void stopForegroundService() {
        LocationTaskService locationTaskService = this.mService;
        if (locationTaskService != null) {
            locationTaskService.stop();
        }
    }

    private final void deferLocations(List<? extends Location> list) {
        int size = this.mDeferredLocations.size();
        Location location = size > 0 ? this.mDeferredLocations.get(size - 1) : this.mLastReportedLocation;
        for (Location location2 : list) {
            if (location != null) {
                this.mDeferredDistance += (double) Math.abs(location2.distanceTo(location));
            }
            location = location2;
        }
        this.mDeferredLocations.addAll(list);
    }

    private final void maybeReportDeferredLocations() {
        if (shouldReportDeferredLocations()) {
            Context applicationContext = getContext().getApplicationContext();
            List arrayList = new ArrayList();
            for (Location next : this.mDeferredLocations) {
                long time = next.getTime();
                if (time > sLastTimestamp) {
                    arrayList.add((PersistableBundle) new LocationResponse(next).toBundle$expo_location_release(PersistableBundle.class));
                    sLastTimestamp = time;
                }
            }
            if (arrayList.size() > 0) {
                List<Location> list = this.mDeferredLocations;
                this.mLastReportedLocation = list.get(list.size() - 1);
                this.mDeferredDistance = AudioStats.AUDIO_AMPLITUDE_NONE;
                this.mDeferredLocations.clear();
                getTaskManagerUtils().scheduleJob(applicationContext, this.mTask, arrayList);
            }
        }
    }

    private final boolean shouldReportDeferredLocations() {
        TaskInterface taskInterface = this.mTask;
        if (taskInterface == null || this.mDeferredLocations.size() == 0) {
            return false;
        }
        if (!this.mIsHostPaused) {
            return true;
        }
        Location location = this.mLastReportedLocation;
        if (location == null) {
            location = this.mDeferredLocations.get(0);
        }
        List<Location> list = this.mDeferredLocations;
        Arguments mapHelper = new MapHelper(taskInterface.getOptions());
        double d = mapHelper.getDouble("deferredUpdatesDistance");
        if (list.get(list.size() - 1).getTime() - location.getTime() < mapHelper.getLong("deferredUpdatesInterval") || this.mDeferredDistance < d) {
            return false;
        }
        return true;
    }

    private final PendingIntent preparePendingIntent() {
        PendingIntent createTaskIntent = getTaskManagerUtils().createTaskIntent(getContext(), this.mTask);
        Intrinsics.checkNotNullExpressionValue(createTaskIntent, "createTaskIntent(...)");
        return createTaskIntent;
    }

    private final void executeTaskWithLocationBundles(ArrayList<Bundle> arrayList, TaskExecutionCallback taskExecutionCallback) {
        if (arrayList.size() <= 0 || this.mTask == null) {
            taskExecutionCallback.onFinished((Map<String, Object>) null);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("locations", arrayList);
        TaskInterface taskInterface = this.mTask;
        if (taskInterface != null) {
            taskInterface.execute(bundle, (Error) null, taskExecutionCallback);
        }
    }

    public void onHostResume() {
        this.mIsHostPaused = false;
        maybeReportDeferredLocations();
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\b\u001a\u00020\t2\u0016\u0010\n\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lexpo/modules/location/taskConsumers/LocationTaskConsumer$Companion;", "", "()V", "FOREGROUND_SERVICE_KEY", "", "TAG", "sLastTimestamp", "", "shouldUseForegroundService", "", "options", "", "expo-location_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: LocationTaskConsumer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean shouldUseForegroundService(Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(map, "options");
            return map.containsKey(LocationTaskConsumer.FOREGROUND_SERVICE_KEY);
        }
    }
}
