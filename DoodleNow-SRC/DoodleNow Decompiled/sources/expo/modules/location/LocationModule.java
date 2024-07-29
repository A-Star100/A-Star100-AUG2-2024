package expo.modules.location;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.hardware.GeomagneticField;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import androidx.core.os.BundleKt;
import androidx.tracing.Trace;
import com.canhub.cropper.CropImageOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.CurrentLocationRequest;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.Task;
import com.onesignal.location.internal.common.LocationConstants;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import expo.modules.core.interfaces.ActivityEventListener;
import expo.modules.core.interfaces.ActivityProvider;
import expo.modules.core.interfaces.LifecycleEventListener;
import expo.modules.core.interfaces.services.UIManager;
import expo.modules.interfaces.permissions.Permissions;
import expo.modules.interfaces.taskManager.TaskManagerInterface;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunction;
import expo.modules.kotlin.functions.AsyncFunctionBuilder;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BaseAsyncFunctionComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.functions.SuspendFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.objects.ObjectDefinitionBuilder;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.location.LocationHelpers;
import expo.modules.location.records.GeocodeResponse;
import expo.modules.location.records.GeofencingOptions;
import expo.modules.location.records.Heading;
import expo.modules.location.records.HeadingEventResponse;
import expo.modules.location.records.LocationLastKnownOptions;
import expo.modules.location.records.LocationOptions;
import expo.modules.location.records.LocationProviderStatus;
import expo.modules.location.records.LocationResponse;
import expo.modules.location.records.LocationTaskOptions;
import expo.modules.location.records.PermissionRequestResponse;
import expo.modules.location.records.ReverseGeocodeLocation;
import expo.modules.location.records.ReverseGeocodeResponse;
import io.nlopez.smartlocation.SmartLocation;
import io.nlopez.smartlocation.geocoding.utils.LocationAddress;
import io.nlopez.smartlocation.location.config.LocationParams;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001B\u0005¢\u0006\u0002\u0010\u0005J\u0018\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\"H\u0002J\u0010\u00102\u001a\u00020\u00152\u0006\u00103\u001a\u00020\u0015H\u0002J\u0010\u00104\u001a\u00020\u00152\u0006\u00105\u001a\u00020\u0015H\u0002J\b\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u00020/H\u0002J\u0010\u00109\u001a\u00020/2\u0006\u0010:\u001a\u00020\u0007H\u0002J\u001c\u0010;\u001a\b\u0012\u0004\u0012\u00020=0<2\u0006\u0010>\u001a\u00020?H@¢\u0006\u0002\u0010@J\u000e\u0010A\u001a\u00020BH@¢\u0006\u0002\u0010CJ\u0018\u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020HH\u0002J\u000e\u0010I\u001a\u00020BH@¢\u0006\u0002\u0010CJ\u0010\u0010J\u001a\u0004\u0018\u00010KH@¢\u0006\u0002\u0010CJ\u0018\u0010L\u001a\u0004\u0018\u00010M2\u0006\u0010E\u001a\u00020NH@¢\u0006\u0002\u0010OJ\b\u0010P\u001a\u00020\rH\u0002J\b\u0010Q\u001a\u00020\rH\u0002J\b\u0010R\u001a\u00020\rH\u0002J\b\u0010S\u001a\u00020\rH\u0002J\u001a\u0010T\u001a\u00020/2\b\u0010U\u001a\u0004\u0018\u00010V2\u0006\u0010W\u001a\u00020\u0007H\u0016J,\u0010X\u001a\u00020/2\b\u0010Y\u001a\u0004\u0018\u00010Z2\u0006\u0010[\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u00072\b\u0010\\\u001a\u0004\u0018\u00010]H\u0016J\b\u0010^\u001a\u00020/H\u0016J\b\u0010_\u001a\u00020/H\u0016J\b\u0010`\u001a\u00020/H\u0016J\u0012\u0010a\u001a\u00020/2\b\u0010b\u001a\u0004\u0018\u00010]H\u0016J\u0012\u0010c\u001a\u00020/2\b\u0010d\u001a\u0004\u0018\u00010eH\u0016J\u0010\u0010f\u001a\u00020/2\u0006\u0010g\u001a\u00020\u0007H\u0002J\u0010\u0010h\u001a\u00020/2\u0006\u0010g\u001a\u00020\u0007H\u0002J\u000e\u0010i\u001a\u00020BH@¢\u0006\u0002\u0010CJ%\u0010j\u001a\u00020/2\u0006\u00100\u001a\u00020\u001f2\b\u0010g\u001a\u0004\u0018\u00010\u00072\u0006\u0010k\u001a\u00020l¢\u0006\u0002\u0010mJ\u0010\u0010n\u001a\u00020/2\u0006\u00100\u001a\u00020\u001fH\u0002J\b\u0010o\u001a\u00020/H\u0002J\u001c\u0010p\u001a\b\u0012\u0004\u0012\u00020q0<2\u0006\u0010r\u001a\u00020sH@¢\u0006\u0002\u0010tJ\u001d\u0010u\u001a\u00020/2\u0006\u0010v\u001a\u00020\u00072\u0006\u0010w\u001a\u00020MH\u0000¢\u0006\u0002\bxJ\b\u0010y\u001a\u00020/H\u0002J\b\u0010z\u001a\u00020\rH\u0003J\b\u0010{\u001a\u00020/H\u0002J\b\u0010|\u001a\u00020/H\u0002J\b\u0010}\u001a\u00020/H\u0002J\b\u0010~\u001a\u00020/H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R*\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001a0\u0019j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001a`\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u0002\n\u0000R*\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001f0\u0019j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001f`\u001bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\"0!j\b\u0012\u0004\u0012\u00020\"`#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X.¢\u0006\u0002\n\u0000R\u001b\u0010&\u001a\u00020'8BX\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b(\u0010)R\u000e\u0010,\u001a\u00020-X.¢\u0006\u0002\n\u0000¨\u0006\u0001"}, d2 = {"Lexpo/modules/location/LocationModule;", "Lexpo/modules/kotlin/modules/Module;", "Lexpo/modules/core/interfaces/LifecycleEventListener;", "Landroid/hardware/SensorEventListener;", "Lexpo/modules/core/interfaces/ActivityEventListener;", "()V", "mAccuracy", "", "mActivityProvider", "Lexpo/modules/core/interfaces/ActivityProvider;", "mContext", "Landroid/content/Context;", "mGeocoderPaused", "", "mGeofield", "Landroid/hardware/GeomagneticField;", "mGeomagnetic", "", "mGravity", "mHeadingId", "mLastAzimuth", "", "mLastUpdate", "", "mLocationCallbacks", "Ljava/util/HashMap;", "Lcom/google/android/gms/location/LocationCallback;", "Lkotlin/collections/HashMap;", "mLocationProvider", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "mLocationRequests", "Lcom/google/android/gms/location/LocationRequest;", "mPendingLocationRequests", "Ljava/util/ArrayList;", "Lexpo/modules/location/LocationActivityResultListener;", "Lkotlin/collections/ArrayList;", "mSensorManager", "Landroid/hardware/SensorManager;", "mTaskManager", "Lexpo/modules/interfaces/taskManager/TaskManagerInterface;", "getMTaskManager", "()Lexpo/modules/interfaces/taskManager/TaskManagerInterface;", "mTaskManager$delegate", "Lkotlin/Lazy;", "mUIManager", "Lexpo/modules/core/interfaces/services/UIManager;", "addPendingLocationRequest", "", "locationRequest", "listener", "calcMagNorth", "azimuth", "calcTrueNorth", "magNorth", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "destroyHeadingWatch", "executePendingRequests", "resultCode", "geocode", "", "Lexpo/modules/location/records/GeocodeResponse;", "address", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBackgroundPermissionsAsync", "Lexpo/modules/location/records/PermissionRequestResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentPositionAsync", "options", "Lexpo/modules/location/records/LocationOptions;", "promise", "Lexpo/modules/kotlin/Promise;", "getForegroundPermissionsAsync", "getLastKnownLocation", "Landroid/location/Location;", "getLastKnownPositionAsync", "Lexpo/modules/location/records/LocationResponse;", "Lexpo/modules/location/records/LocationLastKnownOptions;", "(Lexpo/modules/location/records/LocationLastKnownOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasForegroundServicePermissions", "isBackgroundPermissionInManifest", "isMissingBackgroundPermissions", "isMissingForegroundPermissions", "onAccuracyChanged", "sensor", "Landroid/hardware/Sensor;", "accuracy", "onActivityResult", "activity", "Landroid/app/Activity;", "requestCode", "data", "Landroid/content/Intent;", "onHostDestroy", "onHostPause", "onHostResume", "onNewIntent", "intent", "onSensorChanged", "event", "Landroid/hardware/SensorEvent;", "pauseLocationUpdatesForRequest", "requestId", "removeLocationUpdatesForRequest", "requestBackgroundPermissionsAsync", "requestLocationUpdates", "callbacks", "Lexpo/modules/location/LocationRequestCallbacks;", "(Lcom/google/android/gms/location/LocationRequest;Ljava/lang/Integer;Lexpo/modules/location/LocationRequestCallbacks;)V", "resolveUserSettingsForRequest", "resumeLocationUpdates", "reverseGeocode", "Lexpo/modules/location/records/ReverseGeocodeResponse;", "location", "Lexpo/modules/location/records/ReverseGeocodeLocation;", "(Lexpo/modules/location/records/ReverseGeocodeLocation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendLocationResponse", "watchId", "response", "sendLocationResponse$expo_location_release", "sendUpdate", "shouldAskBackgroundPermissions", "startHeadingUpdate", "startWatching", "stopHeadingWatch", "stopWatching", "Companion", "expo-location_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LocationModule.kt */
public final class LocationModule extends Module implements LifecycleEventListener, SensorEventListener, ActivityEventListener {
    public static final int ACCURACY_BALANCED = 3;
    public static final int ACCURACY_BEST_FOR_NAVIGATION = 6;
    public static final int ACCURACY_HIGH = 4;
    public static final int ACCURACY_HIGHEST = 5;
    public static final int ACCURACY_LOW = 2;
    public static final int ACCURACY_LOWEST = 1;
    private static final int CHECK_SETTINGS_REQUEST_CODE = 42;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final double DEGREE_DELTA = 0.0355d;
    public static final int GEOFENCING_EVENT_ENTER = 1;
    public static final int GEOFENCING_EVENT_EXIT = 2;
    private static final String HEADING_EVENT_NAME = "Expo.headingChanged";
    private static final String LOCATION_EVENT_NAME = "Expo.locationChanged";
    /* access modifiers changed from: private */
    public static final String TAG = "LocationModule";
    public static final float TIME_DELTA = 50.0f;
    private int mAccuracy;
    /* access modifiers changed from: private */
    public ActivityProvider mActivityProvider;
    /* access modifiers changed from: private */
    public Context mContext;
    private boolean mGeocoderPaused;
    private GeomagneticField mGeofield;
    private float[] mGeomagnetic = new float[9];
    private float[] mGravity = new float[9];
    /* access modifiers changed from: private */
    public int mHeadingId;
    private float mLastAzimuth;
    private long mLastUpdate;
    private final HashMap<Integer, LocationCallback> mLocationCallbacks = new HashMap<>();
    /* access modifiers changed from: private */
    public FusedLocationProviderClient mLocationProvider;
    private final HashMap<Integer, LocationRequest> mLocationRequests = new HashMap<>();
    private ArrayList<LocationActivityResultListener> mPendingLocationRequests = new ArrayList<>();
    /* access modifiers changed from: private */
    public SensorManager mSensorManager;
    private final Lazy mTaskManager$delegate = LazyKt.lazy(new LocationModule$mTaskManager$2(this));
    /* access modifiers changed from: private */
    public UIManager mUIManager;

    private final boolean shouldAskBackgroundPermissions() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
        this.mAccuracy = i;
    }

    public void onNewIntent(Intent intent) {
    }

    /* access modifiers changed from: private */
    public final TaskManagerInterface getMTaskManager() {
        return (TaskManagerInterface) this.mTaskManager$delegate.getValue();
    }

    public ModuleDefinitionData definition() {
        AsyncFunction asyncFunction;
        AsyncFunction asyncFunction2;
        AsyncFunction asyncFunction3;
        AsyncFunction asyncFunction4;
        AsyncFunction asyncFunction5;
        AsyncFunction asyncFunction6;
        AsyncFunction asyncFunction7;
        AsyncFunction asyncFunction8;
        AsyncFunction asyncFunction9;
        AsyncFunction asyncFunction10;
        AsyncFunction asyncFunctionComponent;
        AsyncFunction asyncFunctionComponent2;
        AsyncFunction asyncFunctionComponent3;
        AsyncFunction asyncFunctionComponent4;
        AsyncFunction asyncFunctionComponent5;
        AsyncFunction asyncFunctionComponent6;
        Module module = this;
        Trace.beginSection("[ExpoModulesCore] " + (module.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(module);
            moduleDefinitionBuilder.Name("ExpoLocation");
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_CREATE, new BasicEventListener(EventName.MODULE_CREATE, new LocationModule$definition$lambda$27$$inlined$OnCreate$1(this)));
            moduleDefinitionBuilder.Events(HEADING_EVENT_NAME, LOCATION_EVENT_NAME);
            AsyncFunctionBuilder AsyncFunction = moduleDefinitionBuilder.AsyncFunction("requestPermissionsAsync");
            SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(AsyncFunction.getName(), new AnyType[0], new LocationModule$definition$lambda$27$$inlined$Coroutine$1((Continuation) null, this));
            AsyncFunction.setAsyncFunctionComponent(suspendFunctionComponent);
            BaseAsyncFunctionComponent baseAsyncFunctionComponent = suspendFunctionComponent;
            AsyncFunctionBuilder AsyncFunction2 = moduleDefinitionBuilder.AsyncFunction("getPermissionsAsync");
            SuspendFunctionComponent suspendFunctionComponent2 = new SuspendFunctionComponent(AsyncFunction2.getName(), new AnyType[0], new LocationModule$definition$lambda$27$$inlined$Coroutine$2((Continuation) null, this));
            AsyncFunction2.setAsyncFunctionComponent(suspendFunctionComponent2);
            BaseAsyncFunctionComponent baseAsyncFunctionComponent2 = suspendFunctionComponent2;
            AsyncFunctionBuilder AsyncFunction3 = moduleDefinitionBuilder.AsyncFunction("requestForegroundPermissionsAsync");
            SuspendFunctionComponent suspendFunctionComponent3 = new SuspendFunctionComponent(AsyncFunction3.getName(), new AnyType[0], new LocationModule$definition$lambda$27$$inlined$Coroutine$3((Continuation) null, this));
            AsyncFunction3.setAsyncFunctionComponent(suspendFunctionComponent3);
            BaseAsyncFunctionComponent baseAsyncFunctionComponent3 = suspendFunctionComponent3;
            AsyncFunctionBuilder AsyncFunction4 = moduleDefinitionBuilder.AsyncFunction("requestBackgroundPermissionsAsync");
            SuspendFunctionComponent suspendFunctionComponent4 = new SuspendFunctionComponent(AsyncFunction4.getName(), new AnyType[0], new LocationModule$definition$lambda$27$$inlined$Coroutine$4((Continuation) null, this));
            AsyncFunction4.setAsyncFunctionComponent(suspendFunctionComponent4);
            BaseAsyncFunctionComponent baseAsyncFunctionComponent4 = suspendFunctionComponent4;
            AsyncFunctionBuilder AsyncFunction5 = moduleDefinitionBuilder.AsyncFunction("getForegroundPermissionsAsync");
            SuspendFunctionComponent suspendFunctionComponent5 = new SuspendFunctionComponent(AsyncFunction5.getName(), new AnyType[0], new LocationModule$definition$lambda$27$$inlined$Coroutine$5((Continuation) null, this));
            AsyncFunction5.setAsyncFunctionComponent(suspendFunctionComponent5);
            BaseAsyncFunctionComponent baseAsyncFunctionComponent5 = suspendFunctionComponent5;
            AsyncFunctionBuilder AsyncFunction6 = moduleDefinitionBuilder.AsyncFunction("getBackgroundPermissionsAsync");
            SuspendFunctionComponent suspendFunctionComponent6 = new SuspendFunctionComponent(AsyncFunction6.getName(), new AnyType[0], new LocationModule$definition$lambda$27$$inlined$Coroutine$6((Continuation) null, this));
            AsyncFunction6.setAsyncFunctionComponent(suspendFunctionComponent6);
            BaseAsyncFunctionComponent baseAsyncFunctionComponent6 = suspendFunctionComponent6;
            AsyncFunctionBuilder AsyncFunction7 = moduleDefinitionBuilder.AsyncFunction("getLastKnownPositionAsync");
            Class<LocationLastKnownOptions> cls = LocationLastKnownOptions.class;
            AsyncFunction7.setAsyncFunctionComponent(new SuspendFunctionComponent(AsyncFunction7.getName(), new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(LocationLastKnownOptions.class), false, LocationModule$definition$lambda$27$$inlined$Coroutine$7.INSTANCE))}, new LocationModule$definition$lambda$27$$inlined$Coroutine$8((Continuation) null, this)));
            Class<LocationOptions> cls2 = LocationOptions.class;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("getCurrentPositionAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(LocationOptions.class), false, LocationModule$definition$lambda$27$$inlined$AsyncFunctionWithPromise$1.INSTANCE))}, new LocationModule$definition$lambda$27$$inlined$AsyncFunctionWithPromise$2(this));
            moduleDefinitionBuilder.getAsyncFunctions().put("getCurrentPositionAsync", asyncFunctionWithPromiseComponent);
            AsyncFunction asyncFunction11 = asyncFunctionWithPromiseComponent;
            ObjectDefinitionBuilder objectDefinitionBuilder = moduleDefinitionBuilder;
            AnyType[] anyTypeArr = new AnyType[0];
            Function1 locationModule$definition$lambda$27$$inlined$AsyncFunction$1 = new LocationModule$definition$lambda$27$$inlined$AsyncFunction$1(this);
            Class<LocationProviderStatus> cls3 = LocationProviderStatus.class;
            if (Intrinsics.areEqual((Object) cls3, (Object) Integer.TYPE)) {
                asyncFunction = new IntAsyncFunctionComponent("getProviderStatusAsync", anyTypeArr, locationModule$definition$lambda$27$$inlined$AsyncFunction$1);
            } else if (Intrinsics.areEqual((Object) cls3, (Object) Boolean.TYPE)) {
                asyncFunction = new BoolAsyncFunctionComponent("getProviderStatusAsync", anyTypeArr, locationModule$definition$lambda$27$$inlined$AsyncFunction$1);
            } else if (Intrinsics.areEqual((Object) cls3, (Object) Double.TYPE)) {
                asyncFunction = new DoubleAsyncFunctionComponent("getProviderStatusAsync", anyTypeArr, locationModule$definition$lambda$27$$inlined$AsyncFunction$1);
            } else if (Intrinsics.areEqual((Object) cls3, (Object) Float.TYPE)) {
                asyncFunction = new FloatAsyncFunctionComponent("getProviderStatusAsync", anyTypeArr, locationModule$definition$lambda$27$$inlined$AsyncFunction$1);
            } else if (Intrinsics.areEqual((Object) cls3, (Object) String.class)) {
                asyncFunction = new StringAsyncFunctionComponent("getProviderStatusAsync", anyTypeArr, locationModule$definition$lambda$27$$inlined$AsyncFunction$1);
            } else {
                asyncFunction = new AsyncFunctionComponent("getProviderStatusAsync", anyTypeArr, locationModule$definition$lambda$27$$inlined$AsyncFunction$1);
            }
            objectDefinitionBuilder.getAsyncFunctions().put("getProviderStatusAsync", asyncFunction);
            ObjectDefinitionBuilder objectDefinitionBuilder2 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual((Object) Integer.class, (Object) Promise.class)) {
                asyncFunction2 = new AsyncFunctionWithPromiseComponent("watchDeviceHeading", new AnyType[0], new LocationModule$definition$lambda$27$$inlined$AsyncFunction$2(this));
            } else {
                Class<Integer> cls4 = Integer.class;
                AnyType[] anyTypeArr2 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, LocationModule$definition$lambda$27$$inlined$AsyncFunction$3.INSTANCE))};
                Function1 locationModule$definition$lambda$27$$inlined$AsyncFunction$4 = new LocationModule$definition$lambda$27$$inlined$AsyncFunction$4(this);
                Class<Unit> cls5 = Unit.class;
                if (Intrinsics.areEqual((Object) cls5, (Object) Integer.TYPE)) {
                    asyncFunctionComponent6 = new IntAsyncFunctionComponent("watchDeviceHeading", anyTypeArr2, locationModule$definition$lambda$27$$inlined$AsyncFunction$4);
                } else if (Intrinsics.areEqual((Object) cls5, (Object) Boolean.TYPE)) {
                    asyncFunctionComponent6 = new BoolAsyncFunctionComponent("watchDeviceHeading", anyTypeArr2, locationModule$definition$lambda$27$$inlined$AsyncFunction$4);
                } else if (Intrinsics.areEqual((Object) cls5, (Object) Double.TYPE)) {
                    asyncFunctionComponent6 = new DoubleAsyncFunctionComponent("watchDeviceHeading", anyTypeArr2, locationModule$definition$lambda$27$$inlined$AsyncFunction$4);
                } else if (Intrinsics.areEqual((Object) cls5, (Object) Float.TYPE)) {
                    asyncFunctionComponent6 = new FloatAsyncFunctionComponent("watchDeviceHeading", anyTypeArr2, locationModule$definition$lambda$27$$inlined$AsyncFunction$4);
                } else if (Intrinsics.areEqual((Object) cls5, (Object) String.class)) {
                    asyncFunctionComponent6 = new StringAsyncFunctionComponent("watchDeviceHeading", anyTypeArr2, locationModule$definition$lambda$27$$inlined$AsyncFunction$4);
                } else {
                    asyncFunctionComponent6 = new AsyncFunctionComponent("watchDeviceHeading", anyTypeArr2, locationModule$definition$lambda$27$$inlined$AsyncFunction$4);
                }
                asyncFunction2 = asyncFunctionComponent6;
            }
            objectDefinitionBuilder2.getAsyncFunctions().put("watchDeviceHeading", asyncFunction2);
            Class<Integer> cls6 = Integer.class;
            Class<LocationOptions> cls7 = LocationOptions.class;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2 = new AsyncFunctionWithPromiseComponent("watchPositionImplAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, LocationModule$definition$lambda$27$$inlined$AsyncFunctionWithPromise$3.INSTANCE)), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(LocationOptions.class), false, LocationModule$definition$lambda$27$$inlined$AsyncFunctionWithPromise$4.INSTANCE))}, new LocationModule$definition$lambda$27$$inlined$AsyncFunctionWithPromise$5(this));
            moduleDefinitionBuilder.getAsyncFunctions().put("watchPositionImplAsync", asyncFunctionWithPromiseComponent2);
            AsyncFunction asyncFunction12 = asyncFunctionWithPromiseComponent2;
            ObjectDefinitionBuilder objectDefinitionBuilder3 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual((Object) Integer.class, (Object) Promise.class)) {
                asyncFunction3 = new AsyncFunctionWithPromiseComponent("removeWatchAsync", new AnyType[0], new LocationModule$definition$lambda$27$$inlined$AsyncFunction$5(this));
            } else {
                Class<Integer> cls8 = Integer.class;
                AnyType[] anyTypeArr3 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, LocationModule$definition$lambda$27$$inlined$AsyncFunction$6.INSTANCE))};
                Function1 locationModule$definition$lambda$27$$inlined$AsyncFunction$7 = new LocationModule$definition$lambda$27$$inlined$AsyncFunction$7(this);
                Class<Unit> cls9 = Unit.class;
                if (Intrinsics.areEqual((Object) cls9, (Object) Integer.TYPE)) {
                    asyncFunctionComponent5 = new IntAsyncFunctionComponent("removeWatchAsync", anyTypeArr3, locationModule$definition$lambda$27$$inlined$AsyncFunction$7);
                } else if (Intrinsics.areEqual((Object) cls9, (Object) Boolean.TYPE)) {
                    asyncFunctionComponent5 = new BoolAsyncFunctionComponent("removeWatchAsync", anyTypeArr3, locationModule$definition$lambda$27$$inlined$AsyncFunction$7);
                } else if (Intrinsics.areEqual((Object) cls9, (Object) Double.TYPE)) {
                    asyncFunctionComponent5 = new DoubleAsyncFunctionComponent("removeWatchAsync", anyTypeArr3, locationModule$definition$lambda$27$$inlined$AsyncFunction$7);
                } else if (Intrinsics.areEqual((Object) cls9, (Object) Float.TYPE)) {
                    asyncFunctionComponent5 = new FloatAsyncFunctionComponent("removeWatchAsync", anyTypeArr3, locationModule$definition$lambda$27$$inlined$AsyncFunction$7);
                } else if (Intrinsics.areEqual((Object) cls9, (Object) String.class)) {
                    asyncFunctionComponent5 = new StringAsyncFunctionComponent("removeWatchAsync", anyTypeArr3, locationModule$definition$lambda$27$$inlined$AsyncFunction$7);
                } else {
                    asyncFunctionComponent5 = new AsyncFunctionComponent("removeWatchAsync", anyTypeArr3, locationModule$definition$lambda$27$$inlined$AsyncFunction$7);
                }
                asyncFunction3 = asyncFunctionComponent5;
            }
            objectDefinitionBuilder3.getAsyncFunctions().put("removeWatchAsync", asyncFunction3);
            AsyncFunctionBuilder AsyncFunction8 = moduleDefinitionBuilder.AsyncFunction("geocodeAsync");
            Class<String> cls10 = String.class;
            AsyncFunction8.setAsyncFunctionComponent(new SuspendFunctionComponent(AsyncFunction8.getName(), new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, LocationModule$definition$lambda$27$$inlined$Coroutine$9.INSTANCE))}, new LocationModule$definition$lambda$27$$inlined$Coroutine$10((Continuation) null, this)));
            AsyncFunctionBuilder AsyncFunction9 = moduleDefinitionBuilder.AsyncFunction("reverseGeocodeAsync");
            Class<ReverseGeocodeLocation> cls11 = ReverseGeocodeLocation.class;
            AsyncFunction9.setAsyncFunctionComponent(new SuspendFunctionComponent(AsyncFunction9.getName(), new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReverseGeocodeLocation.class), false, LocationModule$definition$lambda$27$$inlined$Coroutine$11.INSTANCE))}, new LocationModule$definition$lambda$27$$inlined$Coroutine$12((Continuation) null, this)));
            AsyncFunctionBuilder AsyncFunction10 = moduleDefinitionBuilder.AsyncFunction("enableNetworkProviderAsync");
            SuspendFunctionComponent suspendFunctionComponent7 = new SuspendFunctionComponent(AsyncFunction10.getName(), new AnyType[0], new LocationModule$definition$lambda$27$$inlined$Coroutine$13((Continuation) null, this));
            AsyncFunction10.setAsyncFunctionComponent(suspendFunctionComponent7);
            BaseAsyncFunctionComponent baseAsyncFunctionComponent7 = suspendFunctionComponent7;
            ObjectDefinitionBuilder objectDefinitionBuilder4 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr4 = new AnyType[0];
            Function1 locationModule$definition$lambda$27$$inlined$AsyncFunction$8 = new LocationModule$definition$lambda$27$$inlined$AsyncFunction$8(this);
            Class<Boolean> cls12 = Boolean.class;
            if (Intrinsics.areEqual((Object) cls12, (Object) Integer.TYPE)) {
                asyncFunction4 = new IntAsyncFunctionComponent("hasServicesEnabledAsync", anyTypeArr4, locationModule$definition$lambda$27$$inlined$AsyncFunction$8);
            } else if (Intrinsics.areEqual((Object) cls12, (Object) Boolean.TYPE)) {
                asyncFunction4 = new BoolAsyncFunctionComponent("hasServicesEnabledAsync", anyTypeArr4, locationModule$definition$lambda$27$$inlined$AsyncFunction$8);
            } else if (Intrinsics.areEqual((Object) cls12, (Object) Double.TYPE)) {
                asyncFunction4 = new DoubleAsyncFunctionComponent("hasServicesEnabledAsync", anyTypeArr4, locationModule$definition$lambda$27$$inlined$AsyncFunction$8);
            } else if (Intrinsics.areEqual((Object) cls12, (Object) Float.TYPE)) {
                asyncFunction4 = new FloatAsyncFunctionComponent("hasServicesEnabledAsync", anyTypeArr4, locationModule$definition$lambda$27$$inlined$AsyncFunction$8);
            } else if (Intrinsics.areEqual((Object) cls12, (Object) String.class)) {
                asyncFunction4 = new StringAsyncFunctionComponent("hasServicesEnabledAsync", anyTypeArr4, locationModule$definition$lambda$27$$inlined$AsyncFunction$8);
            } else {
                asyncFunction4 = new AsyncFunctionComponent("hasServicesEnabledAsync", anyTypeArr4, locationModule$definition$lambda$27$$inlined$AsyncFunction$8);
            }
            objectDefinitionBuilder4.getAsyncFunctions().put("hasServicesEnabledAsync", asyncFunction4);
            ObjectDefinitionBuilder objectDefinitionBuilder5 = moduleDefinitionBuilder;
            Class<String> cls13 = String.class;
            Class<LocationTaskOptions> cls14 = LocationTaskOptions.class;
            AnyType[] anyTypeArr5 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, LocationModule$definition$lambda$27$$inlined$AsyncFunction$9.INSTANCE)), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(LocationTaskOptions.class), false, LocationModule$definition$lambda$27$$inlined$AsyncFunction$10.INSTANCE))};
            Function1 locationModule$definition$lambda$27$$inlined$AsyncFunction$11 = new LocationModule$definition$lambda$27$$inlined$AsyncFunction$11(this);
            Class<Unit> cls15 = Unit.class;
            if (Intrinsics.areEqual((Object) cls15, (Object) Integer.TYPE)) {
                asyncFunction5 = new IntAsyncFunctionComponent("startLocationUpdatesAsync", anyTypeArr5, locationModule$definition$lambda$27$$inlined$AsyncFunction$11);
            } else if (Intrinsics.areEqual((Object) cls15, (Object) Boolean.TYPE)) {
                asyncFunction5 = new BoolAsyncFunctionComponent("startLocationUpdatesAsync", anyTypeArr5, locationModule$definition$lambda$27$$inlined$AsyncFunction$11);
            } else if (Intrinsics.areEqual((Object) cls15, (Object) Double.TYPE)) {
                asyncFunction5 = new DoubleAsyncFunctionComponent("startLocationUpdatesAsync", anyTypeArr5, locationModule$definition$lambda$27$$inlined$AsyncFunction$11);
            } else if (Intrinsics.areEqual((Object) cls15, (Object) Float.TYPE)) {
                asyncFunction5 = new FloatAsyncFunctionComponent("startLocationUpdatesAsync", anyTypeArr5, locationModule$definition$lambda$27$$inlined$AsyncFunction$11);
            } else if (Intrinsics.areEqual((Object) cls15, (Object) String.class)) {
                asyncFunction5 = new StringAsyncFunctionComponent("startLocationUpdatesAsync", anyTypeArr5, locationModule$definition$lambda$27$$inlined$AsyncFunction$11);
            } else {
                asyncFunction5 = new AsyncFunctionComponent("startLocationUpdatesAsync", anyTypeArr5, locationModule$definition$lambda$27$$inlined$AsyncFunction$11);
            }
            objectDefinitionBuilder5.getAsyncFunctions().put("startLocationUpdatesAsync", asyncFunction5);
            ObjectDefinitionBuilder objectDefinitionBuilder6 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual((Object) String.class, (Object) Promise.class)) {
                asyncFunction6 = new AsyncFunctionWithPromiseComponent("stopLocationUpdatesAsync", new AnyType[0], new LocationModule$definition$lambda$27$$inlined$AsyncFunction$12(this));
            } else {
                Class<String> cls16 = String.class;
                AnyType[] anyTypeArr6 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, LocationModule$definition$lambda$27$$inlined$AsyncFunction$13.INSTANCE))};
                Function1 locationModule$definition$lambda$27$$inlined$AsyncFunction$14 = new LocationModule$definition$lambda$27$$inlined$AsyncFunction$14(this);
                Class<Unit> cls17 = Unit.class;
                if (Intrinsics.areEqual((Object) cls17, (Object) Integer.TYPE)) {
                    asyncFunctionComponent4 = new IntAsyncFunctionComponent("stopLocationUpdatesAsync", anyTypeArr6, locationModule$definition$lambda$27$$inlined$AsyncFunction$14);
                } else if (Intrinsics.areEqual((Object) cls17, (Object) Boolean.TYPE)) {
                    asyncFunctionComponent4 = new BoolAsyncFunctionComponent("stopLocationUpdatesAsync", anyTypeArr6, locationModule$definition$lambda$27$$inlined$AsyncFunction$14);
                } else if (Intrinsics.areEqual((Object) cls17, (Object) Double.TYPE)) {
                    asyncFunctionComponent4 = new DoubleAsyncFunctionComponent("stopLocationUpdatesAsync", anyTypeArr6, locationModule$definition$lambda$27$$inlined$AsyncFunction$14);
                } else if (Intrinsics.areEqual((Object) cls17, (Object) Float.TYPE)) {
                    asyncFunctionComponent4 = new FloatAsyncFunctionComponent("stopLocationUpdatesAsync", anyTypeArr6, locationModule$definition$lambda$27$$inlined$AsyncFunction$14);
                } else if (Intrinsics.areEqual((Object) cls17, (Object) String.class)) {
                    asyncFunctionComponent4 = new StringAsyncFunctionComponent("stopLocationUpdatesAsync", anyTypeArr6, locationModule$definition$lambda$27$$inlined$AsyncFunction$14);
                } else {
                    asyncFunctionComponent4 = new AsyncFunctionComponent("stopLocationUpdatesAsync", anyTypeArr6, locationModule$definition$lambda$27$$inlined$AsyncFunction$14);
                }
                asyncFunction6 = asyncFunctionComponent4;
            }
            objectDefinitionBuilder6.getAsyncFunctions().put("stopLocationUpdatesAsync", asyncFunction6);
            ObjectDefinitionBuilder objectDefinitionBuilder7 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual((Object) String.class, (Object) Promise.class)) {
                asyncFunction7 = new AsyncFunctionWithPromiseComponent("hasStartedLocationUpdatesAsync", new AnyType[0], new LocationModule$definition$lambda$27$$inlined$AsyncFunction$15(this));
            } else {
                Class<String> cls18 = String.class;
                AnyType[] anyTypeArr7 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, LocationModule$definition$lambda$27$$inlined$AsyncFunction$16.INSTANCE))};
                Function1 locationModule$definition$lambda$27$$inlined$AsyncFunction$17 = new LocationModule$definition$lambda$27$$inlined$AsyncFunction$17(this);
                Class<Boolean> cls19 = Boolean.class;
                if (Intrinsics.areEqual((Object) cls19, (Object) Integer.TYPE)) {
                    asyncFunctionComponent3 = new IntAsyncFunctionComponent("hasStartedLocationUpdatesAsync", anyTypeArr7, locationModule$definition$lambda$27$$inlined$AsyncFunction$17);
                } else if (Intrinsics.areEqual((Object) cls19, (Object) Boolean.TYPE)) {
                    asyncFunctionComponent3 = new BoolAsyncFunctionComponent("hasStartedLocationUpdatesAsync", anyTypeArr7, locationModule$definition$lambda$27$$inlined$AsyncFunction$17);
                } else if (Intrinsics.areEqual((Object) cls19, (Object) Double.TYPE)) {
                    asyncFunctionComponent3 = new DoubleAsyncFunctionComponent("hasStartedLocationUpdatesAsync", anyTypeArr7, locationModule$definition$lambda$27$$inlined$AsyncFunction$17);
                } else if (Intrinsics.areEqual((Object) cls19, (Object) Float.TYPE)) {
                    asyncFunctionComponent3 = new FloatAsyncFunctionComponent("hasStartedLocationUpdatesAsync", anyTypeArr7, locationModule$definition$lambda$27$$inlined$AsyncFunction$17);
                } else if (Intrinsics.areEqual((Object) cls19, (Object) String.class)) {
                    asyncFunctionComponent3 = new StringAsyncFunctionComponent("hasStartedLocationUpdatesAsync", anyTypeArr7, locationModule$definition$lambda$27$$inlined$AsyncFunction$17);
                } else {
                    asyncFunctionComponent3 = new AsyncFunctionComponent("hasStartedLocationUpdatesAsync", anyTypeArr7, locationModule$definition$lambda$27$$inlined$AsyncFunction$17);
                }
                asyncFunction7 = asyncFunctionComponent3;
            }
            objectDefinitionBuilder7.getAsyncFunctions().put("hasStartedLocationUpdatesAsync", asyncFunction7);
            ObjectDefinitionBuilder objectDefinitionBuilder8 = moduleDefinitionBuilder;
            Class<String> cls20 = String.class;
            Class<GeofencingOptions> cls21 = GeofencingOptions.class;
            AnyType[] anyTypeArr8 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, LocationModule$definition$lambda$27$$inlined$AsyncFunction$18.INSTANCE)), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(GeofencingOptions.class), false, LocationModule$definition$lambda$27$$inlined$AsyncFunction$19.INSTANCE))};
            Function1 locationModule$definition$lambda$27$$inlined$AsyncFunction$20 = new LocationModule$definition$lambda$27$$inlined$AsyncFunction$20(this);
            Class<Unit> cls22 = Unit.class;
            if (Intrinsics.areEqual((Object) cls22, (Object) Integer.TYPE)) {
                asyncFunction8 = new IntAsyncFunctionComponent("startGeofencingAsync", anyTypeArr8, locationModule$definition$lambda$27$$inlined$AsyncFunction$20);
            } else if (Intrinsics.areEqual((Object) cls22, (Object) Boolean.TYPE)) {
                asyncFunction8 = new BoolAsyncFunctionComponent("startGeofencingAsync", anyTypeArr8, locationModule$definition$lambda$27$$inlined$AsyncFunction$20);
            } else if (Intrinsics.areEqual((Object) cls22, (Object) Double.TYPE)) {
                asyncFunction8 = new DoubleAsyncFunctionComponent("startGeofencingAsync", anyTypeArr8, locationModule$definition$lambda$27$$inlined$AsyncFunction$20);
            } else if (Intrinsics.areEqual((Object) cls22, (Object) Float.TYPE)) {
                asyncFunction8 = new FloatAsyncFunctionComponent("startGeofencingAsync", anyTypeArr8, locationModule$definition$lambda$27$$inlined$AsyncFunction$20);
            } else if (Intrinsics.areEqual((Object) cls22, (Object) String.class)) {
                asyncFunction8 = new StringAsyncFunctionComponent("startGeofencingAsync", anyTypeArr8, locationModule$definition$lambda$27$$inlined$AsyncFunction$20);
            } else {
                asyncFunction8 = new AsyncFunctionComponent("startGeofencingAsync", anyTypeArr8, locationModule$definition$lambda$27$$inlined$AsyncFunction$20);
            }
            objectDefinitionBuilder8.getAsyncFunctions().put("startGeofencingAsync", asyncFunction8);
            ObjectDefinitionBuilder objectDefinitionBuilder9 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual((Object) String.class, (Object) Promise.class)) {
                asyncFunction9 = new AsyncFunctionWithPromiseComponent("hasStartedGeofencingAsync", new AnyType[0], new LocationModule$definition$lambda$27$$inlined$AsyncFunction$21(this));
            } else {
                Class<String> cls23 = String.class;
                AnyType[] anyTypeArr9 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, LocationModule$definition$lambda$27$$inlined$AsyncFunction$22.INSTANCE))};
                Function1 locationModule$definition$lambda$27$$inlined$AsyncFunction$23 = new LocationModule$definition$lambda$27$$inlined$AsyncFunction$23(this);
                Class<Boolean> cls24 = Boolean.class;
                if (Intrinsics.areEqual((Object) cls24, (Object) Integer.TYPE)) {
                    asyncFunctionComponent2 = new IntAsyncFunctionComponent("hasStartedGeofencingAsync", anyTypeArr9, locationModule$definition$lambda$27$$inlined$AsyncFunction$23);
                } else if (Intrinsics.areEqual((Object) cls24, (Object) Boolean.TYPE)) {
                    asyncFunctionComponent2 = new BoolAsyncFunctionComponent("hasStartedGeofencingAsync", anyTypeArr9, locationModule$definition$lambda$27$$inlined$AsyncFunction$23);
                } else if (Intrinsics.areEqual((Object) cls24, (Object) Double.TYPE)) {
                    asyncFunctionComponent2 = new DoubleAsyncFunctionComponent("hasStartedGeofencingAsync", anyTypeArr9, locationModule$definition$lambda$27$$inlined$AsyncFunction$23);
                } else if (Intrinsics.areEqual((Object) cls24, (Object) Float.TYPE)) {
                    asyncFunctionComponent2 = new FloatAsyncFunctionComponent("hasStartedGeofencingAsync", anyTypeArr9, locationModule$definition$lambda$27$$inlined$AsyncFunction$23);
                } else if (Intrinsics.areEqual((Object) cls24, (Object) String.class)) {
                    asyncFunctionComponent2 = new StringAsyncFunctionComponent("hasStartedGeofencingAsync", anyTypeArr9, locationModule$definition$lambda$27$$inlined$AsyncFunction$23);
                } else {
                    asyncFunctionComponent2 = new AsyncFunctionComponent("hasStartedGeofencingAsync", anyTypeArr9, locationModule$definition$lambda$27$$inlined$AsyncFunction$23);
                }
                asyncFunction9 = asyncFunctionComponent2;
            }
            objectDefinitionBuilder9.getAsyncFunctions().put("hasStartedGeofencingAsync", asyncFunction9);
            ObjectDefinitionBuilder objectDefinitionBuilder10 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual((Object) String.class, (Object) Promise.class)) {
                asyncFunction10 = new AsyncFunctionWithPromiseComponent("stopGeofencingAsync", new AnyType[0], new LocationModule$definition$lambda$27$$inlined$AsyncFunction$24(this));
            } else {
                Class<String> cls25 = String.class;
                AnyType[] anyTypeArr10 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, LocationModule$definition$lambda$27$$inlined$AsyncFunction$25.INSTANCE))};
                Function1 locationModule$definition$lambda$27$$inlined$AsyncFunction$26 = new LocationModule$definition$lambda$27$$inlined$AsyncFunction$26(this);
                Class<Unit> cls26 = Unit.class;
                if (Intrinsics.areEqual((Object) cls26, (Object) Integer.TYPE)) {
                    asyncFunctionComponent = new IntAsyncFunctionComponent("stopGeofencingAsync", anyTypeArr10, locationModule$definition$lambda$27$$inlined$AsyncFunction$26);
                } else if (Intrinsics.areEqual((Object) cls26, (Object) Boolean.TYPE)) {
                    asyncFunctionComponent = new BoolAsyncFunctionComponent("stopGeofencingAsync", anyTypeArr10, locationModule$definition$lambda$27$$inlined$AsyncFunction$26);
                } else if (Intrinsics.areEqual((Object) cls26, (Object) Double.TYPE)) {
                    asyncFunctionComponent = new DoubleAsyncFunctionComponent("stopGeofencingAsync", anyTypeArr10, locationModule$definition$lambda$27$$inlined$AsyncFunction$26);
                } else if (Intrinsics.areEqual((Object) cls26, (Object) Float.TYPE)) {
                    asyncFunctionComponent = new FloatAsyncFunctionComponent("stopGeofencingAsync", anyTypeArr10, locationModule$definition$lambda$27$$inlined$AsyncFunction$26);
                } else if (Intrinsics.areEqual((Object) cls26, (Object) String.class)) {
                    asyncFunctionComponent = new StringAsyncFunctionComponent("stopGeofencingAsync", anyTypeArr10, locationModule$definition$lambda$27$$inlined$AsyncFunction$26);
                } else {
                    asyncFunctionComponent = new AsyncFunctionComponent("stopGeofencingAsync", anyTypeArr10, locationModule$definition$lambda$27$$inlined$AsyncFunction$26);
                }
                asyncFunction10 = asyncFunctionComponent;
            }
            objectDefinitionBuilder10.getAsyncFunctions().put("stopGeofencingAsync", asyncFunction10);
            moduleDefinitionBuilder.getEventListeners().put(EventName.ACTIVITY_ENTERS_FOREGROUND, new BasicEventListener(EventName.ACTIVITY_ENTERS_FOREGROUND, new LocationModule$definition$lambda$27$$inlined$OnActivityEntersForeground$1()));
            moduleDefinitionBuilder.getEventListeners().put(EventName.ACTIVITY_ENTERS_BACKGROUND, new BasicEventListener(EventName.ACTIVITY_ENTERS_BACKGROUND, new LocationModule$definition$lambda$27$$inlined$OnActivityEntersBackground$1()));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0075 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getForegroundPermissionsAsync(kotlin.coroutines.Continuation<? super expo.modules.location.records.PermissionRequestResponse> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof expo.modules.location.LocationModule$getForegroundPermissionsAsync$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            expo.modules.location.LocationModule$getForegroundPermissionsAsync$1 r0 = (expo.modules.location.LocationModule$getForegroundPermissionsAsync$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            expo.modules.location.LocationModule$getForegroundPermissionsAsync$1 r0 = new expo.modules.location.LocationModule$getForegroundPermissionsAsync$1
            r0.<init>(r7, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r0 = r0.L$0
            expo.modules.location.records.PermissionRequestResponse r0 = (expo.modules.location.records.PermissionRequestResponse) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0079
        L_0x0031:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0039:
            java.lang.Object r2 = r0.L$0
            expo.modules.interfaces.permissions.Permissions r2 = (expo.modules.interfaces.permissions.Permissions) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0061
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r8)
            expo.modules.kotlin.AppContext r8 = r7.getAppContext()
            expo.modules.interfaces.permissions.Permissions r2 = r8.getPermissions()
            if (r2 == 0) goto L_0x0097
            expo.modules.location.LocationHelpers$Companion r8 = expo.modules.location.LocationHelpers.Companion
            java.lang.String r5 = "android.permission.ACCESS_COARSE_LOCATION"
            java.lang.String[] r5 = new java.lang.String[]{r5}
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r8 = r8.getPermissionsWithPermissionsManager$expo_location_release(r2, r5, r0)
            if (r8 != r1) goto L_0x0061
            return r1
        L_0x0061:
            expo.modules.location.records.PermissionRequestResponse r8 = (expo.modules.location.records.PermissionRequestResponse) r8
            expo.modules.location.LocationHelpers$Companion r4 = expo.modules.location.LocationHelpers.Companion
            java.lang.String r5 = "android.permission.ACCESS_FINE_LOCATION"
            java.lang.String[] r5 = new java.lang.String[]{r5}
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r0 = r4.getPermissionsWithPermissionsManager$expo_location_release(r2, r5, r0)
            if (r0 != r1) goto L_0x0076
            return r1
        L_0x0076:
            r6 = r0
            r0 = r8
            r8 = r6
        L_0x0079:
            expo.modules.location.records.PermissionRequestResponse r8 = (expo.modules.location.records.PermissionRequestResponse) r8
            boolean r1 = r0.getGranted()
            if (r1 == 0) goto L_0x0084
            java.lang.String r1 = "coarse"
            goto L_0x0086
        L_0x0084:
            java.lang.String r1 = "none"
        L_0x0086:
            boolean r8 = r8.getGranted()
            if (r8 == 0) goto L_0x008e
            java.lang.String r1 = "fine"
        L_0x008e:
            expo.modules.location.records.PermissionDetailsLocationAndroid r8 = new expo.modules.location.records.PermissionDetailsLocationAndroid
            r8.<init>(r1, r1)
            r0.setAndroid(r8)
            return r0
        L_0x0097:
            expo.modules.location.NoPermissionsModuleException r8 = new expo.modules.location.NoPermissionsModuleException
            r8.<init>()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.location.LocationModule.getForegroundPermissionsAsync(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object requestBackgroundPermissionsAsync(kotlin.coroutines.Continuation<? super expo.modules.location.records.PermissionRequestResponse> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof expo.modules.location.LocationModule$requestBackgroundPermissionsAsync$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            expo.modules.location.LocationModule$requestBackgroundPermissionsAsync$1 r0 = (expo.modules.location.LocationModule$requestBackgroundPermissionsAsync$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            expo.modules.location.LocationModule$requestBackgroundPermissionsAsync$1 r0 = new expo.modules.location.LocationModule$requestBackgroundPermissionsAsync$1
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x006d
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0051
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r6)
            boolean r6 = r5.isBackgroundPermissionInManifest()
            if (r6 == 0) goto L_0x007b
            boolean r6 = r5.shouldAskBackgroundPermissions()
            if (r6 != 0) goto L_0x0052
            r0.label = r4
            java.lang.Object r6 = r5.getForegroundPermissionsAsync(r0)
            if (r6 != r1) goto L_0x0051
            return r1
        L_0x0051:
            return r6
        L_0x0052:
            expo.modules.kotlin.AppContext r6 = r5.getAppContext()
            expo.modules.interfaces.permissions.Permissions r6 = r6.getPermissions()
            if (r6 == 0) goto L_0x0075
            expo.modules.location.LocationHelpers$Companion r2 = expo.modules.location.LocationHelpers.Companion
            java.lang.String r4 = "android.permission.ACCESS_BACKGROUND_LOCATION"
            java.lang.String[] r4 = new java.lang.String[]{r4}
            r0.label = r3
            java.lang.Object r6 = r2.askForPermissionsWithPermissionsManager$expo_location_release(r6, r4, r0)
            if (r6 != r1) goto L_0x006d
            return r1
        L_0x006d:
            android.os.Bundle r6 = (android.os.Bundle) r6
            expo.modules.location.records.PermissionRequestResponse r0 = new expo.modules.location.records.PermissionRequestResponse
            r0.<init>(r6)
            return r0
        L_0x0075:
            expo.modules.location.NoPermissionsModuleException r6 = new expo.modules.location.NoPermissionsModuleException
            r6.<init>()
            throw r6
        L_0x007b:
            expo.modules.location.NoPermissionInManifestException r6 = new expo.modules.location.NoPermissionInManifestException
            java.lang.String r0 = "ACCESS_BACKGROUND_LOCATION"
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.location.LocationModule.requestBackgroundPermissionsAsync(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object getBackgroundPermissionsAsync(Continuation<? super PermissionRequestResponse> continuation) {
        if (!isBackgroundPermissionInManifest()) {
            throw new NoPermissionInManifestException("ACCESS_BACKGROUND_LOCATION");
        } else if (!shouldAskBackgroundPermissions()) {
            return getForegroundPermissionsAsync(continuation);
        } else {
            Permissions permissions = getAppContext().getPermissions();
            if (permissions != null) {
                return LocationHelpers.Companion.getPermissionsWithPermissionsManager$expo_location_release(permissions, new String[]{LocationConstants.ANDROID_BACKGROUND_LOCATION_PERMISSION_STRING}, continuation);
            }
            throw new NoPermissionsModuleException();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getLastKnownPositionAsync(expo.modules.location.records.LocationLastKnownOptions r5, kotlin.coroutines.Continuation<? super expo.modules.location.records.LocationResponse> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof expo.modules.location.LocationModule$getLastKnownPositionAsync$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            expo.modules.location.LocationModule$getLastKnownPositionAsync$1 r0 = (expo.modules.location.LocationModule$getLastKnownPositionAsync$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            expo.modules.location.LocationModule$getLastKnownPositionAsync$1 r0 = new expo.modules.location.LocationModule$getLastKnownPositionAsync$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r5 = r0.L$0
            expo.modules.location.records.LocationLastKnownOptions r5 = (expo.modules.location.records.LocationLastKnownOptions) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004a
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            boolean r6 = r4.isMissingForegroundPermissions()
            if (r6 != 0) goto L_0x005f
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r4.getLastKnownLocation(r0)
            if (r6 != r1) goto L_0x004a
            return r1
        L_0x004a:
            android.location.Location r6 = (android.location.Location) r6
            r0 = 0
            if (r6 != 0) goto L_0x0050
            return r0
        L_0x0050:
            expo.modules.location.LocationHelpers$Companion r1 = expo.modules.location.LocationHelpers.Companion
            boolean r5 = r1.isLocationValid$expo_location_release(r6, r5)
            if (r5 == 0) goto L_0x005e
            expo.modules.location.records.LocationResponse r5 = new expo.modules.location.records.LocationResponse
            r5.<init>(r6)
            return r5
        L_0x005e:
            return r0
        L_0x005f:
            expo.modules.location.LocationUnauthorizedException r5 = new expo.modules.location.LocationUnauthorizedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.location.LocationModule.getLastKnownPositionAsync(expo.modules.location.records.LocationLastKnownOptions, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void getCurrentPositionAsync(LocationOptions locationOptions, Promise promise) {
        LocationRequest prepareLocationRequest$expo_location_release = LocationHelpers.Companion.prepareLocationRequest$expo_location_release(locationOptions);
        CurrentLocationRequest prepareCurrentLocationRequest$expo_location_release = LocationHelpers.Companion.prepareCurrentLocationRequest$expo_location_release(locationOptions);
        boolean mayShowUserSettingsDialog = locationOptions.getMayShowUserSettingsDialog();
        if (isMissingForegroundPermissions()) {
            promise.reject(new LocationUnauthorizedException());
            return;
        }
        LocationHelpers.Companion companion = LocationHelpers.Companion;
        Context context = this.mContext;
        FusedLocationProviderClient fusedLocationProviderClient = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        if (companion.hasNetworkProviderEnabled(context) || !mayShowUserSettingsDialog) {
            LocationHelpers.Companion companion2 = LocationHelpers.Companion;
            FusedLocationProviderClient fusedLocationProviderClient2 = this.mLocationProvider;
            if (fusedLocationProviderClient2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLocationProvider");
            } else {
                fusedLocationProviderClient = fusedLocationProviderClient2;
            }
            companion2.requestSingleLocation(fusedLocationProviderClient, prepareCurrentLocationRequest$expo_location_release, promise);
            return;
        }
        addPendingLocationRequest(prepareLocationRequest$expo_location_release, new LocationModule$getCurrentPositionAsync$1(this, prepareCurrentLocationRequest$expo_location_release, promise));
    }

    public final void requestLocationUpdates(LocationRequest locationRequest, Integer num, LocationRequestCallbacks locationRequestCallbacks) {
        Intrinsics.checkNotNullParameter(locationRequest, "locationRequest");
        Intrinsics.checkNotNullParameter(locationRequestCallbacks, "callbacks");
        FusedLocationProviderClient fusedLocationProviderClient = this.mLocationProvider;
        if (fusedLocationProviderClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLocationProvider");
            fusedLocationProviderClient = null;
        }
        LocationCallback locationModule$requestLocationUpdates$locationCallback$1 = new LocationModule$requestLocationUpdates$locationCallback$1(locationRequestCallbacks);
        if (num != null) {
            this.mLocationCallbacks.put(num, locationModule$requestLocationUpdates$locationCallback$1);
            this.mLocationRequests.put(num, locationRequest);
        }
        try {
            fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationModule$requestLocationUpdates$locationCallback$1, Looper.getMainLooper());
            locationRequestCallbacks.onRequestSuccess();
        } catch (SecurityException e) {
            locationRequestCallbacks.onRequestFailed(new LocationRequestRejectedException(e));
        }
    }

    /* access modifiers changed from: private */
    public final void addPendingLocationRequest(LocationRequest locationRequest, LocationActivityResultListener locationActivityResultListener) {
        this.mPendingLocationRequests.add(locationActivityResultListener);
        if (this.mPendingLocationRequests.size() == 1) {
            resolveUserSettingsForRequest(locationRequest);
        }
    }

    private final void resolveUserSettingsForRequest(LocationRequest locationRequest) {
        ActivityProvider activityProvider = this.mActivityProvider;
        Context context = null;
        if (activityProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivityProvider");
            activityProvider = null;
        }
        Activity currentActivity = activityProvider.getCurrentActivity();
        if (currentActivity == null) {
            executePendingRequests(0);
            return;
        }
        LocationSettingsRequest.Builder addLocationRequest = new LocationSettingsRequest.Builder().addLocationRequest(locationRequest);
        Intrinsics.checkNotNullExpressionValue(addLocationRequest, "addLocationRequest(...)");
        Context context2 = this.mContext;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            context = context2;
        }
        SettingsClient settingsClient = LocationServices.getSettingsClient(context);
        Intrinsics.checkNotNullExpressionValue(settingsClient, "getSettingsClient(...)");
        Task<LocationSettingsResponse> checkLocationSettings = settingsClient.checkLocationSettings(addLocationRequest.build());
        Intrinsics.checkNotNullExpressionValue(checkLocationSettings, "checkLocationSettings(...)");
        checkLocationSettings.addOnSuccessListener(new LocationModule$$ExternalSyntheticLambda0(new LocationModule$resolveUserSettingsForRequest$1(this)));
        checkLocationSettings.addOnFailureListener(new LocationModule$$ExternalSyntheticLambda1(this, currentActivity));
    }

    /* access modifiers changed from: private */
    public static final void resolveUserSettingsForRequest$lambda$31(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void resolveUserSettingsForRequest$lambda$32(LocationModule locationModule, Activity activity, Exception exc) {
        Intrinsics.checkNotNullParameter(locationModule, "this$0");
        Intrinsics.checkNotNullParameter(exc, "e");
        if (((ApiException) exc).getStatusCode() == 6) {
            try {
                ResolvableApiException resolvableApiException = (ResolvableApiException) exc;
                UIManager uIManager = locationModule.mUIManager;
                if (uIManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mUIManager");
                    uIManager = null;
                }
                uIManager.registerActivityEventListener(locationModule);
                resolvableApiException.startResolutionForResult(activity, 42);
            } catch (IntentSender.SendIntentException unused) {
                locationModule.executePendingRequests(0);
            }
        } else {
            locationModule.executePendingRequests(0);
        }
    }

    /* access modifiers changed from: private */
    public final void executePendingRequests(int i) {
        Iterator<LocationActivityResultListener> it = this.mPendingLocationRequests.iterator();
        while (it.hasNext()) {
            it.next().onResult(i);
        }
        this.mPendingLocationRequests.clear();
    }

    /* access modifiers changed from: private */
    public final void startHeadingUpdate() {
        Context context = this.mContext;
        SensorManager sensorManager = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        SmartLocation.LocationControl config = SmartLocation.with(context).location().oneFix().config(LocationParams.BEST_EFFORT);
        Location lastLocation = config.getLastLocation();
        if (lastLocation != null) {
            this.mGeofield = new GeomagneticField((float) lastLocation.getLatitude(), (float) lastLocation.getLongitude(), (float) lastLocation.getAltitude(), System.currentTimeMillis());
        } else {
            config.start(new LocationModule$$ExternalSyntheticLambda2(this));
        }
        SensorManager sensorManager2 = this.mSensorManager;
        if (sensorManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSensorManager");
            sensorManager2 = null;
        }
        SensorEventListener sensorEventListener = this;
        SensorManager sensorManager3 = this.mSensorManager;
        if (sensorManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSensorManager");
            sensorManager3 = null;
        }
        sensorManager2.registerListener(sensorEventListener, sensorManager3.getDefaultSensor(2), 3);
        SensorManager sensorManager4 = this.mSensorManager;
        if (sensorManager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSensorManager");
            sensorManager4 = null;
        }
        SensorManager sensorManager5 = this.mSensorManager;
        if (sensorManager5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSensorManager");
        } else {
            sensorManager = sensorManager5;
        }
        sensorManager4.registerListener(sensorEventListener, sensorManager.getDefaultSensor(1), 3);
    }

    /* access modifiers changed from: private */
    public static final void startHeadingUpdate$lambda$33(LocationModule locationModule, Location location) {
        Intrinsics.checkNotNullParameter(locationModule, "this$0");
        Intrinsics.checkNotNullParameter(location, "location");
        locationModule.mGeofield = new GeomagneticField((float) location.getLatitude(), (float) location.getLongitude(), (float) location.getAltitude(), System.currentTimeMillis());
    }

    private final void sendUpdate() {
        float[] fArr = new float[9];
        if (SensorManager.getRotationMatrix(fArr, new float[9], this.mGravity, this.mGeomagnetic)) {
            float[] fArr2 = new float[3];
            SensorManager.getOrientation(fArr, fArr2);
            if (((double) Math.abs(fArr2[0] - this.mLastAzimuth)) > 0.0355d && ((float) (System.currentTimeMillis() - this.mLastUpdate)) > 50.0f) {
                this.mLastAzimuth = fArr2[0];
                this.mLastUpdate = System.currentTimeMillis();
                float calcMagNorth = calcMagNorth(fArr2[0]);
                sendEvent(HEADING_EVENT_NAME, new HeadingEventResponse(Integer.valueOf(this.mHeadingId), new Heading(calcTrueNorth(calcMagNorth), calcMagNorth, this.mAccuracy)).toBundle$expo_location_release());
            }
        }
    }

    public final void sendLocationResponse$expo_location_release(int i, LocationResponse locationResponse) {
        Intrinsics.checkNotNullParameter(locationResponse, "response");
        Bundle bundleOf = BundleKt.bundleOf();
        bundleOf.putBundle("location", (Bundle) locationResponse.toBundle$expo_location_release(Bundle.class));
        bundleOf.putInt("watchId", i);
        sendEvent(LOCATION_EVENT_NAME, bundleOf);
    }

    private final float calcMagNorth(float f) {
        float degrees = (float) Math.toDegrees((double) f);
        float f2 = (float) CropImageOptions.DEGREES_360;
        return (degrees + f2) % f2;
    }

    private final float calcTrueNorth(float f) {
        GeomagneticField geomagneticField = this.mGeofield;
        if (!(!isMissingForegroundPermissions())) {
            geomagneticField = null;
        }
        if (geomagneticField == null) {
            return -1.0f;
        }
        return (f + geomagneticField.getDeclination()) % ((float) CropImageOptions.DEGREES_360);
    }

    private final void stopHeadingWatch() {
        SensorManager sensorManager = this.mSensorManager;
        if (sensorManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSensorManager");
            sensorManager = null;
        }
        sensorManager.unregisterListener(this);
    }

    /* access modifiers changed from: private */
    public final void destroyHeadingWatch() {
        stopHeadingWatch();
        this.mGravity = new float[9];
        this.mGeomagnetic = new float[9];
        this.mGeofield = null;
        this.mHeadingId = 0;
        this.mLastAzimuth = 0.0f;
        this.mAccuracy = 0;
    }

    private final void startWatching() {
        if (!isMissingForegroundPermissions()) {
            this.mGeocoderPaused = false;
        }
        resumeLocationUpdates();
    }

    private final void stopWatching() {
        if (Geocoder.isPresent() && !isMissingForegroundPermissions()) {
            Context context = this.mContext;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context = null;
            }
            SmartLocation.with(context).geocoding().stop();
            this.mGeocoderPaused = true;
        }
        for (Integer next : this.mLocationCallbacks.keySet()) {
            Intrinsics.checkNotNull(next);
            pauseLocationUpdatesForRequest(next.intValue());
        }
    }

    private final void pauseLocationUpdatesForRequest(int i) {
        LocationCallback locationCallback = this.mLocationCallbacks.get(Integer.valueOf(i));
        if (locationCallback != null) {
            FusedLocationProviderClient fusedLocationProviderClient = this.mLocationProvider;
            if (fusedLocationProviderClient == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLocationProvider");
                fusedLocationProviderClient = null;
            }
            fusedLocationProviderClient.removeLocationUpdates(locationCallback);
        }
    }

    /* access modifiers changed from: private */
    public final void removeLocationUpdatesForRequest(int i) {
        pauseLocationUpdatesForRequest(i);
        this.mLocationCallbacks.remove(Integer.valueOf(i));
        this.mLocationRequests.remove(Integer.valueOf(i));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0010, code lost:
        r1 = r0.next();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void resumeLocationUpdates() {
        /*
            r5 = this;
            java.util.HashMap<java.lang.Integer, com.google.android.gms.location.LocationCallback> r0 = r5.mLocationCallbacks
            java.util.Set r0 = r0.keySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x000a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0053
            java.lang.Object r1 = r0.next()
            java.lang.Integer r1 = (java.lang.Integer) r1
            java.util.HashMap<java.lang.Integer, com.google.android.gms.location.LocationCallback> r2 = r5.mLocationCallbacks
            java.lang.Object r2 = r2.get(r1)
            com.google.android.gms.location.LocationCallback r2 = (com.google.android.gms.location.LocationCallback) r2
            if (r2 != 0) goto L_0x0021
            return
        L_0x0021:
            java.util.HashMap<java.lang.Integer, com.google.android.gms.location.LocationRequest> r3 = r5.mLocationRequests
            java.lang.Object r1 = r3.get(r1)
            com.google.android.gms.location.LocationRequest r1 = (com.google.android.gms.location.LocationRequest) r1
            if (r1 != 0) goto L_0x002c
            return
        L_0x002c:
            com.google.android.gms.location.FusedLocationProviderClient r3 = r5.mLocationProvider     // Catch:{ SecurityException -> 0x003e }
            if (r3 != 0) goto L_0x0036
            java.lang.String r3 = "mLocationProvider"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)     // Catch:{ SecurityException -> 0x003e }
            r3 = 0
        L_0x0036:
            android.os.Looper r4 = android.os.Looper.myLooper()     // Catch:{ SecurityException -> 0x003e }
            r3.requestLocationUpdates((com.google.android.gms.location.LocationRequest) r1, (com.google.android.gms.location.LocationCallback) r2, (android.os.Looper) r4)     // Catch:{ SecurityException -> 0x003e }
            goto L_0x000a
        L_0x003e:
            r1 = move-exception
            java.lang.String r2 = TAG
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Error occurred while resuming location updates: "
            r3.<init>(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            android.util.Log.e(r2, r1)
            goto L_0x000a
        L_0x0053:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.location.LocationModule.resumeLocationUpdates():void");
    }

    /* access modifiers changed from: private */
    public final Object getLastKnownLocation(Continuation<? super Location> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        Continuation continuation2 = safeContinuation;
        try {
            FusedLocationProviderClient fusedLocationProviderClient = this.mLocationProvider;
            if (fusedLocationProviderClient == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLocationProvider");
                fusedLocationProviderClient = null;
            }
            fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new LocationModule$sam$com_google_android_gms_tasks_OnSuccessListener$0(new LocationModule$getLastKnownLocation$2$1(continuation2))).addOnCanceledListener(new LocationModule$getLastKnownLocation$2$2(continuation2)).addOnFailureListener(new LocationModule$getLastKnownLocation$2$3(continuation2));
        } catch (SecurityException unused) {
            Result.Companion companion = Result.Companion;
            continuation2.resumeWith(Result.m1230constructorimpl((Object) null));
        }
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* access modifiers changed from: private */
    public final Object geocode(String str, Continuation<? super List<GeocodeResponse>> continuation) {
        Unit unit = null;
        if (this.mGeocoderPaused) {
            throw new GeocodeException("Geocoder is not running", (Throwable) null, 2, (DefaultConstructorMarker) null);
        } else if (isMissingForegroundPermissions()) {
            throw new LocationUnauthorizedException();
        } else if (Geocoder.isPresent()) {
            SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
            Continuation continuation2 = safeContinuation;
            Context context = this.mContext;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context = null;
            }
            List<Address> fromLocationName = new Geocoder(context, Locale.getDefault()).getFromLocationName(str, 1);
            if (fromLocationName != null) {
                Collection arrayList = new ArrayList();
                for (Address locationAddress : fromLocationName) {
                    LocationAddress locationAddress2 = new LocationAddress(locationAddress);
                    GeocodeResponse.Companion companion = GeocodeResponse.Companion;
                    Location location = locationAddress2.getLocation();
                    Intrinsics.checkNotNullExpressionValue(location, "getLocation(...)");
                    GeocodeResponse from = companion.from(location);
                    if (from != null) {
                        arrayList.add(from);
                    }
                }
                Result.Companion companion2 = Result.Companion;
                continuation2.resumeWith(Result.m1230constructorimpl((List) arrayList));
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                Result.Companion companion3 = Result.Companion;
                continuation2.resumeWith(Result.m1230constructorimpl(CollectionsKt.emptyList()));
            }
            Object orThrow = safeContinuation.getOrThrow();
            if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return orThrow;
        } else {
            throw new NoGeocodeException();
        }
    }

    /* access modifiers changed from: private */
    public final Object reverseGeocode(ReverseGeocodeLocation reverseGeocodeLocation, Continuation<? super List<ReverseGeocodeResponse>> continuation) {
        ReverseGeocodeResponse reverseGeocodeResponse;
        Unit unit = null;
        if (this.mGeocoderPaused) {
            throw new GeocodeException("Geocoder is not running", (Throwable) null, 2, (DefaultConstructorMarker) null);
        } else if (isMissingForegroundPermissions()) {
            throw new LocationUnauthorizedException();
        } else if (Geocoder.isPresent()) {
            Location location = new Location("");
            location.setLatitude(reverseGeocodeLocation.getLatitude());
            location.setLongitude(reverseGeocodeLocation.getLongitude());
            SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
            Continuation continuation2 = safeContinuation;
            Context context = this.mContext;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context = null;
            }
            List<Address> fromLocation = new Geocoder(context, Locale.getDefault()).getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            if (fromLocation != null) {
                Collection arrayList = new ArrayList();
                for (Address address : fromLocation) {
                    if (address != null) {
                        Intrinsics.checkNotNull(address);
                        reverseGeocodeResponse = new ReverseGeocodeResponse(address);
                    } else {
                        reverseGeocodeResponse = null;
                    }
                    if (reverseGeocodeResponse != null) {
                        arrayList.add(reverseGeocodeResponse);
                    }
                }
                Result.Companion companion = Result.Companion;
                continuation2.resumeWith(Result.m1230constructorimpl((List) arrayList));
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                Result.Companion companion2 = Result.Companion;
                continuation2.resumeWith(Result.m1230constructorimpl(CollectionsKt.emptyList()));
            }
            Object orThrow = safeContinuation.getOrThrow();
            if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return orThrow;
        } else {
            throw new NoGeocodeException();
        }
    }

    /* access modifiers changed from: private */
    public final boolean isMissingForegroundPermissions() {
        Permissions permissions = getAppContext().getPermissions();
        if (permissions != null) {
            return !permissions.hasGrantedPermissions(LocationConstants.ANDROID_FINE_LOCATION_PERMISSION_STRING) && !permissions.hasGrantedPermissions(LocationConstants.ANDROID_COARSE_LOCATION_PERMISSION_STRING);
        }
        throw new Exceptions.AppContextLost();
    }

    /* access modifiers changed from: private */
    public final boolean hasForegroundServicePermissions() {
        Permissions permissions = getAppContext().getPermissions();
        if (permissions == null) {
            throw new Exceptions.AppContextLost();
        } else if (Build.VERSION.SDK_INT >= 34) {
            boolean hasGrantedPermissions = permissions.hasGrantedPermissions("android.permission.FOREGROUND_SERVICE_LOCATION");
            if (!permissions.hasGrantedPermissions("android.permission.FOREGROUND_SERVICE") || !hasGrantedPermissions) {
                return false;
            }
            return true;
        } else if (Build.VERSION.SDK_INT >= 28) {
            return permissions.hasGrantedPermissions("android.permission.FOREGROUND_SERVICE");
        } else {
            return true;
        }
    }

    /* access modifiers changed from: private */
    public final boolean isMissingBackgroundPermissions() {
        Permissions permissions = getAppContext().getPermissions();
        if (permissions == null) {
            return true;
        }
        if (Build.VERSION.SDK_INT < 29 || permissions.hasGrantedPermissions(LocationConstants.ANDROID_BACKGROUND_LOCATION_PERMISSION_STRING)) {
            return false;
        }
        return true;
    }

    private final boolean isBackgroundPermissionInManifest() {
        if (Build.VERSION.SDK_INT < 29) {
            return true;
        }
        Permissions permissions = getAppContext().getPermissions();
        if (permissions != null) {
            return permissions.isPermissionPresentInManifest(LocationConstants.ANDROID_BACKGROUND_LOCATION_PERMISSION_STRING);
        }
        throw new NoPermissionsModuleException();
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\n \u0013*\u0004\u0018\u00010\u00100\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017XT¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lexpo/modules/location/LocationModule$Companion;", "", "()V", "ACCURACY_BALANCED", "", "ACCURACY_BEST_FOR_NAVIGATION", "ACCURACY_HIGH", "ACCURACY_HIGHEST", "ACCURACY_LOW", "ACCURACY_LOWEST", "CHECK_SETTINGS_REQUEST_CODE", "DEGREE_DELTA", "", "GEOFENCING_EVENT_ENTER", "GEOFENCING_EVENT_EXIT", "HEADING_EVENT_NAME", "", "LOCATION_EVENT_NAME", "TAG", "kotlin.jvm.PlatformType", "getTAG$expo_location_release", "()Ljava/lang/String;", "TIME_DELTA", "", "expo-location_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: LocationModule.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG$expo_location_release() {
            return LocationModule.TAG;
        }
    }

    public void onHostResume() {
        startWatching();
        startHeadingUpdate();
    }

    public void onHostPause() {
        stopWatching();
        stopHeadingWatch();
    }

    public void onHostDestroy() {
        stopWatching();
        stopHeadingWatch();
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent != null) {
            if (sensorEvent.sensor.getType() == 1) {
                float[] fArr = sensorEvent.values;
                Intrinsics.checkNotNullExpressionValue(fArr, DiagnosticsEntry.Histogram.VALUES_KEY);
                this.mGravity = fArr;
            } else if (sensorEvent.sensor.getType() == 2) {
                float[] fArr2 = sensorEvent.values;
                Intrinsics.checkNotNullExpressionValue(fArr2, DiagnosticsEntry.Histogram.VALUES_KEY);
                this.mGeomagnetic = fArr2;
            }
            sendUpdate();
        }
    }

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        if (i == 42) {
            executePendingRequests(i2);
            UIManager uIManager = this.mUIManager;
            if (uIManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUIManager");
                uIManager = null;
            }
            uIManager.unregisterActivityEventListener(this);
        }
    }
}
