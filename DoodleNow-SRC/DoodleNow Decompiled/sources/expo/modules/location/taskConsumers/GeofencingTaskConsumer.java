package expo.modules.location.taskConsumers;

import android.app.PendingIntent;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingClient;
import com.google.android.gms.location.GeofencingEvent;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationServices;
import com.onesignal.session.internal.outcomes.impl.OutcomeEventsTable;
import expo.modules.interfaces.taskManager.TaskConsumer;
import expo.modules.interfaces.taskManager.TaskConsumerInterface;
import expo.modules.interfaces.taskManager.TaskInterface;
import expo.modules.interfaces.taskManager.TaskManagerUtilsInterface;
import expo.modules.location.GeofencingException;
import expo.modules.location.LocationHelpers;
import expo.modules.location.records.GeofencingRegionState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 <2\u00020\u00012\u00020\u0002:\u0001<B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J$\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00132\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020\u0016H\u0016J\b\u0010(\u001a\u00020#H\u0016J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*H\u0002J\u001c\u0010,\u001a\u00020\f2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J\u001a\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u001b2\u0006\u00100\u001a\u00020\u0013H\u0002J\u0016\u00101\u001a\u00020\u000e2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\f03H\u0002J\b\u00104\u001a\u00020\u0010H\u0002J\u0010\u00105\u001a\u0002062\u0006\u0010+\u001a\u00020*H\u0002J\u001c\u00107\u001a\u00020#2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016J\b\u00109\u001a\u00020#H\u0002J\b\u0010:\u001a\u00020#H\u0002J\b\u0010;\u001a\u00020\u0013H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lexpo/modules/location/taskConsumers/GeofencingTaskConsumer;", "Lexpo/modules/interfaces/taskManager/TaskConsumer;", "Lexpo/modules/interfaces/taskManager/TaskConsumerInterface;", "context", "Landroid/content/Context;", "taskManagerUtils", "Lexpo/modules/interfaces/taskManager/TaskManagerUtilsInterface;", "(Landroid/content/Context;Lexpo/modules/interfaces/taskManager/TaskManagerUtilsInterface;)V", "mGeofencingClient", "Lcom/google/android/gms/location/GeofencingClient;", "mGeofencingList", "", "Lcom/google/android/gms/location/Geofence;", "mGeofencingRequest", "Lcom/google/android/gms/location/GeofencingRequest;", "mPendingIntent", "Landroid/app/PendingIntent;", "mRegions", "", "", "Landroid/os/PersistableBundle;", "mTask", "Lexpo/modules/interfaces/taskManager/TaskInterface;", "bundleFromRegion", "identifier", "region", "", "", "didExecuteJob", "", "jobService", "Landroid/app/job/JobService;", "params", "Landroid/app/job/JobParameters;", "didReceiveBroadcast", "", "intent", "Landroid/content/Intent;", "didRegister", "task", "didUnregister", "eventTypeFromTransitionType", "", "transitionType", "geofenceFromRegion", "getParamAsDouble", "", "param", "errorMessage", "prepareGeofencingRequest", "geofences", "", "preparePendingIntent", "regionStateForTransitionType", "Lexpo/modules/location/records/GeofencingRegionState;", "setOptions", "options", "startGeofencing", "stopGeofencing", "taskType", "Companion", "expo-location_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: GeofencingTaskConsumer.kt */
public final class GeofencingTaskConsumer extends TaskConsumer implements TaskConsumerInterface {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "GeofencingTaskConsumer";
    private GeofencingClient mGeofencingClient;
    private List<Geofence> mGeofencingList = new ArrayList();
    private GeofencingRequest mGeofencingRequest;
    private PendingIntent mPendingIntent;
    private Map<String, PersistableBundle> mRegions = new HashMap();
    private TaskInterface mTask;

    private final int eventTypeFromTransitionType(int i) {
        if (i != 1) {
            return i != 2 ? 0 : 2;
        }
        return 1;
    }

    public String taskType() {
        return "geofencing";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GeofencingTaskConsumer(Context context, TaskManagerUtilsInterface taskManagerUtilsInterface) {
        super(context, taskManagerUtilsInterface);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void didRegister(TaskInterface taskInterface) {
        Intrinsics.checkNotNullParameter(taskInterface, "task");
        this.mTask = taskInterface;
        startGeofencing();
    }

    public void didUnregister() {
        stopGeofencing();
        this.mTask = null;
        this.mPendingIntent = null;
        this.mGeofencingClient = null;
        this.mGeofencingRequest = null;
        this.mGeofencingList.clear();
    }

    public void setOptions(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "options");
        super.setOptions(map);
        stopGeofencing();
        startGeofencing();
    }

    public void didReceiveBroadcast(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        GeofencingEvent fromIntent = GeofencingEvent.fromIntent(intent);
        if (fromIntent == null) {
            GeofencingTaskConsumer geofencingTaskConsumer = this;
            Log.w(TAG, "Received a null geofencing event. Ignoring");
        } else if (fromIntent.hasError()) {
            Error error = new Error(Companion.getErrorString(fromIntent.getErrorCode()));
            TaskInterface taskInterface = this.mTask;
            if (taskInterface != null) {
                taskInterface.execute((Bundle) null, error);
            }
        } else {
            int geofenceTransition = fromIntent.getGeofenceTransition();
            GeofencingRegionState regionStateForTransitionType = regionStateForTransitionType(geofenceTransition);
            int eventTypeFromTransitionType = eventTypeFromTransitionType(geofenceTransition);
            List<Geofence> triggeringGeofences = fromIntent.getTriggeringGeofences();
            if (triggeringGeofences != null) {
                for (Geofence requestId : triggeringGeofences) {
                    PersistableBundle persistableBundle = this.mRegions.get(requestId.getRequestId());
                    if (persistableBundle != null) {
                        PersistableBundle persistableBundle2 = new PersistableBundle();
                        persistableBundle.putInt("state", regionStateForTransitionType.ordinal());
                        persistableBundle2.putInt("eventType", eventTypeFromTransitionType);
                        persistableBundle2.putPersistableBundle("region", persistableBundle);
                        getTaskManagerUtils().scheduleJob(getContext().getApplicationContext(), this.mTask, CollectionsKt.listOf(persistableBundle2));
                    }
                }
            }
        }
    }

    public boolean didExecuteJob(JobService jobService, JobParameters jobParameters) {
        Intrinsics.checkNotNullParameter(jobService, "jobService");
        Intrinsics.checkNotNullParameter(jobParameters, OutcomeEventsTable.COLUMN_NAME_PARAMS);
        TaskInterface taskInterface = this.mTask;
        if (taskInterface == null) {
            return false;
        }
        for (PersistableBundle next : getTaskManagerUtils().extractDataFromJobParams(jobParameters)) {
            Bundle bundle = new Bundle();
            Bundle bundle2 = new Bundle();
            bundle2.putAll(next.getPersistableBundle("region"));
            bundle.putInt("eventType", next.getInt("eventType"));
            bundle.putBundle("region", bundle2);
            taskInterface.execute(bundle, (Error) null, new GeofencingTaskConsumer$$ExternalSyntheticLambda0(jobService, jobParameters));
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static final void didExecuteJob$lambda$2(JobService jobService, JobParameters jobParameters, Map map) {
        Intrinsics.checkNotNullParameter(jobService, "$jobService");
        Intrinsics.checkNotNullParameter(jobParameters, "$params");
        jobService.jobFinished(jobParameters, false);
    }

    private final void startGeofencing() {
        GeofencingRequest geofencingRequest;
        Context context = getContext();
        if (context == null) {
            GeofencingTaskConsumer geofencingTaskConsumer = this;
            Log.w(TAG, "The context has been abandoned");
        } else if (!LocationHelpers.Companion.isAnyProviderAvailable(context)) {
            Log.w(TAG, "There is no location provider available");
        } else {
            this.mRegions = new HashMap();
            this.mGeofencingList = new ArrayList();
            TaskInterface taskInterface = this.mTask;
            Map<String, Object> options = taskInterface != null ? taskInterface.getOptions() : null;
            if (options != null) {
                Object obj = options.get("regions");
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.util.ArrayList<*>{ kotlin.collections.TypeAliasesKt.ArrayList<*> }");
                Collection arrayList = new ArrayList();
                for (Object next : (ArrayList) obj) {
                    if (next instanceof HashMap) {
                        arrayList.add(next);
                    }
                }
                for (Map map : (List) arrayList) {
                    Geofence geofenceFromRegion = geofenceFromRegion(map);
                    String requestId = geofenceFromRegion.getRequestId();
                    Intrinsics.checkNotNullExpressionValue(requestId, "getRequestId(...)");
                    this.mRegions.put(requestId, bundleFromRegion(requestId, map));
                    this.mGeofencingList.add(geofenceFromRegion);
                }
                this.mPendingIntent = preparePendingIntent();
                this.mGeofencingRequest = prepareGeofencingRequest(this.mGeofencingList);
                GeofencingClient geofencingClient = LocationServices.getGeofencingClient(getContext());
                this.mGeofencingClient = geofencingClient;
                try {
                    PendingIntent pendingIntent = this.mPendingIntent;
                    if (pendingIntent != null && (geofencingRequest = this.mGeofencingRequest) != null && geofencingClient != null) {
                        geofencingClient.addGeofences(geofencingRequest, pendingIntent);
                    }
                } catch (SecurityException e) {
                    Log.w(TAG, "Geofencing request has been rejected.", e);
                }
            } else {
                throw new GeofencingException("Task is null, can't start geofencing", (Throwable) null, 2, (DefaultConstructorMarker) null);
            }
        }
    }

    private final void stopGeofencing() {
        PendingIntent pendingIntent = this.mPendingIntent;
        if (pendingIntent != null) {
            GeofencingClient geofencingClient = this.mGeofencingClient;
            if (geofencingClient != null) {
                geofencingClient.removeGeofences(pendingIntent);
            }
            pendingIntent.cancel();
        }
    }

    private final GeofencingRequest prepareGeofencingRequest(List<? extends Geofence> list) {
        GeofencingRequest build = new GeofencingRequest.Builder().setInitialTrigger(3).addGeofences(list).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    private final PendingIntent preparePendingIntent() {
        PendingIntent createTaskIntent = getTaskManagerUtils().createTaskIntent(getContext(), this.mTask);
        Intrinsics.checkNotNullExpressionValue(createTaskIntent, "createTaskIntent(...)");
        return createTaskIntent;
    }

    private final double getParamAsDouble(Object obj, String str) {
        Double d;
        if (obj instanceof Double) {
            d = (Double) obj;
        } else if (obj instanceof Float) {
            d = Double.valueOf((double) ((Number) obj).floatValue());
        } else if (obj instanceof Integer) {
            d = Double.valueOf((double) ((Number) obj).intValue());
        } else if (obj instanceof Long) {
            d = Double.valueOf((double) ((Number) obj).longValue());
        } else {
            d = obj instanceof String ? StringsKt.toDoubleOrNull((String) obj) : null;
        }
        if (d != null) {
            return d.doubleValue();
        }
        throw new GeofencingException(str, (Throwable) null, 2, (DefaultConstructorMarker) null);
    }

    private final Geofence geofenceFromRegion(Map<String, ? extends Object> map) {
        Object obj = map.get("identifier");
        Boolean bool = null;
        String str = obj instanceof String ? (String) obj : null;
        if (str == null) {
            str = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
        }
        Object obj2 = map.get("radius");
        Object obj3 = map.get("radius");
        double paramAsDouble = getParamAsDouble(obj2, "Region: radius: `" + obj3 + "` can't be cast to Double");
        Object obj4 = map.get("longitude");
        Object obj5 = map.get("longitude");
        double paramAsDouble2 = getParamAsDouble(obj4, "Region: longitude: `" + obj5 + "` can't be cast to Double");
        Object obj6 = map.get("latitude");
        Object obj7 = map.get("latitude");
        double paramAsDouble3 = getParamAsDouble(obj6, "Region: latitude `" + obj7 + "` can't be cast to Double");
        Object obj8 = map.get("notifyOnEnter");
        Boolean bool2 = obj8 instanceof Boolean ? (Boolean) obj8 : null;
        boolean z = true;
        boolean booleanValue = bool2 != null ? bool2.booleanValue() : true;
        Object obj9 = map.get("notifyOnExit");
        if (obj9 instanceof Boolean) {
            bool = (Boolean) obj9;
        }
        if (bool != null) {
            z = bool.booleanValue();
        }
        Geofence build = new Geofence.Builder().setRequestId(str).setCircularRegion(paramAsDouble3, paramAsDouble2, (float) paramAsDouble).setExpirationDuration(-1).setTransitionTypes((z ? 2 : 0) | booleanValue ? 1 : 0).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    private final PersistableBundle bundleFromRegion(String str, Map<String, ? extends Object> map) {
        PersistableBundle persistableBundle = new PersistableBundle();
        Object obj = map.get("radius");
        Object obj2 = map.get("radius");
        double paramAsDouble = getParamAsDouble(obj, "Region: radius: `" + obj2 + "` can't be cast to Double");
        Object obj3 = map.get("longitude");
        Object obj4 = map.get("longitude");
        double paramAsDouble2 = getParamAsDouble(obj3, "Region: longitude: `" + obj4 + "` can't be cast to Double");
        Object obj5 = map.get("latitude");
        Object obj6 = map.get("latitude");
        double paramAsDouble3 = getParamAsDouble(obj5, "Region: latitude: `" + obj6 + "` can't be cast to Double");
        persistableBundle.putString("identifier", str);
        persistableBundle.putDouble("radius", paramAsDouble);
        persistableBundle.putDouble("latitude", paramAsDouble3);
        persistableBundle.putDouble("longitude", paramAsDouble2);
        persistableBundle.putInt("state", GeofencingRegionState.UNKNOWN.ordinal());
        return persistableBundle;
    }

    private final GeofencingRegionState regionStateForTransitionType(int i) {
        if (i != 1) {
            if (i == 2) {
                return GeofencingRegionState.OUTSIDE;
            }
            if (i != 4) {
                return GeofencingRegionState.UNKNOWN;
            }
        }
        return GeofencingRegionState.INSIDE;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lexpo/modules/location/taskConsumers/GeofencingTaskConsumer$Companion;", "", "()V", "TAG", "", "getErrorString", "errorCode", "", "expo-location_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: GeofencingTaskConsumer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final String getErrorString(int i) {
            switch (i) {
                case 1000:
                    return "Geofencing not available.";
                case 1001:
                    return "Too many geofences.";
                case 1002:
                    return "Too many pending intents.";
                default:
                    return "Unknown geofencing error.";
            }
        }

        private Companion() {
        }
    }
}
