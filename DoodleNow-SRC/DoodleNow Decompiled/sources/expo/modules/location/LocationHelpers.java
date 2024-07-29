package expo.modules.location;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import androidx.work.WorkRequest;
import com.facebook.react.bridge.BaseJavaModule;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.gms.location.CurrentLocationRequest;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.tasks.CancellationToken;
import expo.modules.interfaces.permissions.Permissions;
import expo.modules.kotlin.Promise;
import expo.modules.location.records.LocationLastKnownOptions;
import expo.modules.location.records.LocationOptions;
import expo.modules.location.records.PermissionRequestResponse;
import io.nlopez.smartlocation.location.config.LocationAccuracy;
import io.nlopez.smartlocation.location.config.LocationParams;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lexpo/modules/location/LocationHelpers;", "", "()V", "Companion", "expo-location_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LocationHelpers.kt */
public final class LocationHelpers {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\tH@¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J,\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\tH@¢\u0006\u0004\b\u0012\u0010\u000bJ\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u001f\u0010\u0018\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0000¢\u0006\u0002\b\u001dJ\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020!H\u0002J\u0015\u0010\"\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020!H\u0000¢\u0006\u0002\b$J\u0015\u0010%\u001a\u00020&2\u0006\u0010\u001b\u001a\u00020!H\u0000¢\u0006\u0002\b'J&\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020/J\u001e\u00100\u001a\u00020)2\u0006\u00101\u001a\u0002022\u0006\u0010,\u001a\u00020#2\u0006\u0010.\u001a\u00020/¨\u00063"}, d2 = {"Lexpo/modules/location/LocationHelpers$Companion;", "", "()V", "askForPermissionsWithPermissionsManager", "Landroid/os/Bundle;", "contextPermissions", "Lexpo/modules/interfaces/permissions/Permissions;", "permissionStrings", "", "", "askForPermissionsWithPermissionsManager$expo_location_release", "(Lexpo/modules/interfaces/permissions/Permissions;[Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildLocationParamsForAccuracy", "Lio/nlopez/smartlocation/location/config/LocationParams$Builder;", "accuracy", "", "getPermissionsWithPermissionsManager", "Lexpo/modules/location/records/PermissionRequestResponse;", "getPermissionsWithPermissionsManager$expo_location_release", "hasNetworkProviderEnabled", "", "context", "Landroid/content/Context;", "isAnyProviderAvailable", "isLocationValid", "location", "Landroid/location/Location;", "options", "Lexpo/modules/location/records/LocationLastKnownOptions;", "isLocationValid$expo_location_release", "mapAccuracyToPriority", "mapOptionsToLocationParams", "Lio/nlopez/smartlocation/location/config/LocationParams;", "Lexpo/modules/location/records/LocationOptions;", "prepareCurrentLocationRequest", "Lcom/google/android/gms/location/CurrentLocationRequest;", "prepareCurrentLocationRequest$expo_location_release", "prepareLocationRequest", "Lcom/google/android/gms/location/LocationRequest;", "prepareLocationRequest$expo_location_release", "requestContinuousUpdates", "", "locationModule", "Lexpo/modules/location/LocationModule;", "locationRequest", "watchId", "promise", "Lexpo/modules/kotlin/Promise;", "requestSingleLocation", "locationProvider", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "expo-location_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: LocationHelpers.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int mapAccuracyToPriority(int i) {
            switch (i) {
                case 1:
                    return 104;
                case 4:
                case 5:
                case 6:
                    return 100;
                default:
                    return 102;
            }
        }

        private Companion() {
        }

        public final boolean isLocationValid$expo_location_release(Location location, LocationLastKnownOptions locationLastKnownOptions) {
            Intrinsics.checkNotNullParameter(locationLastKnownOptions, "options");
            if (location == null) {
                return false;
            }
            Double maxAge = locationLastKnownOptions.getMaxAge();
            double d = Double.MAX_VALUE;
            double doubleValue = maxAge != null ? maxAge.doubleValue() : Double.MAX_VALUE;
            Double requiredAccuracy = locationLastKnownOptions.getRequiredAccuracy();
            if (requiredAccuracy != null) {
                d = requiredAccuracy.doubleValue();
            }
            if (((double) (System.currentTimeMillis() - location.getTime())) > doubleValue || ((double) location.getAccuracy()) > d) {
                return false;
            }
            return true;
        }

        public final boolean hasNetworkProviderEnabled(Context context) {
            if (context == null) {
                return false;
            }
            Object systemService = context.getSystemService("location");
            LocationManager locationManager = systemService instanceof LocationManager ? (LocationManager) systemService : null;
            if (locationManager == null || !locationManager.isProviderEnabled("network")) {
                return false;
            }
            return true;
        }

        public final LocationRequest prepareLocationRequest$expo_location_release(LocationOptions locationOptions) {
            Intrinsics.checkNotNullParameter(locationOptions, "options");
            LocationParams mapOptionsToLocationParams = mapOptionsToLocationParams(locationOptions);
            LocationRequest build = new LocationRequest.Builder(mapOptionsToLocationParams.getInterval()).setMinUpdateIntervalMillis(mapOptionsToLocationParams.getInterval()).setMaxUpdateDelayMillis(mapOptionsToLocationParams.getInterval()).setMinUpdateDistanceMeters(mapOptionsToLocationParams.getDistance()).setPriority(mapAccuracyToPriority(locationOptions.getAccuracy())).build();
            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
            return build;
        }

        public final CurrentLocationRequest prepareCurrentLocationRequest$expo_location_release(LocationOptions locationOptions) {
            Intrinsics.checkNotNullParameter(locationOptions, "options");
            LocationParams mapOptionsToLocationParams = mapOptionsToLocationParams(locationOptions);
            CurrentLocationRequest.Builder builder = new CurrentLocationRequest.Builder();
            builder.setGranularity(0);
            builder.setPriority(LocationHelpers.Companion.mapAccuracyToPriority(locationOptions.getAccuracy()));
            builder.setMaxUpdateAgeMillis(mapOptionsToLocationParams.getInterval());
            CurrentLocationRequest build = builder.build();
            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
            return build;
        }

        public final void requestSingleLocation(FusedLocationProviderClient fusedLocationProviderClient, CurrentLocationRequest currentLocationRequest, Promise promise) {
            Intrinsics.checkNotNullParameter(fusedLocationProviderClient, "locationProvider");
            Intrinsics.checkNotNullParameter(currentLocationRequest, "locationRequest");
            Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
            try {
                fusedLocationProviderClient.getCurrentLocation(currentLocationRequest, (CancellationToken) null).addOnSuccessListener(new LocationHelpers$Companion$$ExternalSyntheticLambda0(new LocationHelpers$Companion$requestSingleLocation$1(promise))).addOnFailureListener(new LocationHelpers$Companion$$ExternalSyntheticLambda1(promise)).addOnCanceledListener(new LocationHelpers$Companion$$ExternalSyntheticLambda2(promise));
            } catch (SecurityException e) {
                promise.reject(new LocationRequestRejectedException(e));
            }
        }

        /* access modifiers changed from: private */
        public static final void requestSingleLocation$lambda$1(Function1 function1, Object obj) {
            Intrinsics.checkNotNullParameter(function1, "$tmp0");
            function1.invoke(obj);
        }

        /* access modifiers changed from: private */
        public static final void requestSingleLocation$lambda$2(Promise promise, Exception exc) {
            Intrinsics.checkNotNullParameter(promise, "$promise");
            Intrinsics.checkNotNullParameter(exc, "it");
            promise.reject(new LocationRequestRejectedException(exc));
        }

        /* access modifiers changed from: private */
        public static final void requestSingleLocation$lambda$3(Promise promise) {
            Intrinsics.checkNotNullParameter(promise, "$promise");
            promise.reject(new LocationRequestCancelledException());
        }

        public final void requestContinuousUpdates(LocationModule locationModule, LocationRequest locationRequest, int i, Promise promise) {
            Intrinsics.checkNotNullParameter(locationModule, "locationModule");
            Intrinsics.checkNotNullParameter(locationRequest, "locationRequest");
            Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
            locationModule.requestLocationUpdates(locationRequest, Integer.valueOf(i), new LocationHelpers$Companion$requestContinuousUpdates$1(locationModule, i, promise));
        }

        private final LocationParams mapOptionsToLocationParams(LocationOptions locationOptions) {
            LocationParams.Builder buildLocationParamsForAccuracy = buildLocationParamsForAccuracy(locationOptions.getAccuracy());
            Long timeInterval = locationOptions.getTimeInterval();
            if (timeInterval != null) {
                buildLocationParamsForAccuracy.setInterval(timeInterval.longValue());
            }
            Integer distanceInterval = locationOptions.getDistanceInterval();
            if (distanceInterval != null) {
                buildLocationParamsForAccuracy.setDistance((float) distanceInterval.intValue());
            }
            LocationParams build = buildLocationParamsForAccuracy.build();
            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
            return build;
        }

        private final LocationParams.Builder buildLocationParamsForAccuracy(int i) {
            switch (i) {
                case 1:
                    LocationParams.Builder interval = new LocationParams.Builder().setAccuracy(LocationAccuracy.LOWEST).setDistance(3000.0f).setInterval(WorkRequest.MIN_BACKOFF_MILLIS);
                    Intrinsics.checkNotNullExpressionValue(interval, "setInterval(...)");
                    return interval;
                case 2:
                    LocationParams.Builder interval2 = new LocationParams.Builder().setAccuracy(LocationAccuracy.LOW).setDistance(1000.0f).setInterval(5000);
                    Intrinsics.checkNotNullExpressionValue(interval2, "setInterval(...)");
                    return interval2;
                case 3:
                    LocationParams.Builder interval3 = new LocationParams.Builder().setAccuracy(LocationAccuracy.MEDIUM).setDistance(100.0f).setInterval(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
                    Intrinsics.checkNotNullExpressionValue(interval3, "setInterval(...)");
                    return interval3;
                case 4:
                    LocationParams.Builder interval4 = new LocationParams.Builder().setAccuracy(LocationAccuracy.HIGH).setDistance(50.0f).setInterval(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                    Intrinsics.checkNotNullExpressionValue(interval4, "setInterval(...)");
                    return interval4;
                case 5:
                    LocationParams.Builder interval5 = new LocationParams.Builder().setAccuracy(LocationAccuracy.HIGH).setDistance(25.0f).setInterval(1000);
                    Intrinsics.checkNotNullExpressionValue(interval5, "setInterval(...)");
                    return interval5;
                case 6:
                    LocationParams.Builder interval6 = new LocationParams.Builder().setAccuracy(LocationAccuracy.HIGH).setDistance(0.0f).setInterval(500);
                    Intrinsics.checkNotNullExpressionValue(interval6, "setInterval(...)");
                    return interval6;
                default:
                    LocationParams.Builder interval7 = new LocationParams.Builder().setAccuracy(LocationAccuracy.MEDIUM).setDistance(100.0f).setInterval(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
                    Intrinsics.checkNotNullExpressionValue(interval7, "setInterval(...)");
                    return interval7;
            }
        }

        public final boolean isAnyProviderAvailable(Context context) {
            LocationManager locationManager = null;
            Object systemService = context != null ? context.getSystemService("location") : null;
            if (systemService instanceof LocationManager) {
                locationManager = (LocationManager) systemService;
            }
            if (locationManager == null) {
                return false;
            }
            if (locationManager.isProviderEnabled("gps") || locationManager.isProviderEnabled("network")) {
                return true;
            }
            return false;
        }

        public final Object getPermissionsWithPermissionsManager$expo_location_release(Permissions permissions, String[] strArr, Continuation<? super PermissionRequestResponse> continuation) {
            SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
            Permissions.CC.getPermissionsWithPermissionsManager(permissions, (Promise) new LocationHelpers$Companion$getPermissionsWithPermissionsManager$2$1(safeContinuation), (String[]) Arrays.copyOf(strArr, strArr.length));
            Object orThrow = safeContinuation.getOrThrow();
            if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return orThrow;
        }

        public final Object askForPermissionsWithPermissionsManager$expo_location_release(Permissions permissions, String[] strArr, Continuation<? super Bundle> continuation) {
            SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
            Permissions.CC.askForPermissionsWithPermissionsManager(permissions, (Promise) new LocationHelpers$Companion$askForPermissionsWithPermissionsManager$2$1(safeContinuation), (String[]) Arrays.copyOf(strArr, strArr.length));
            Object orThrow = safeContinuation.getOrThrow();
            if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return orThrow;
        }
    }
}
