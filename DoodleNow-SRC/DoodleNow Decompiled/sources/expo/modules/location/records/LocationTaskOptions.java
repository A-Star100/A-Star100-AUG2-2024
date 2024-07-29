package expo.modules.location.records;

import expo.modules.kotlin.records.Field;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u001b\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001cH\u0000¢\u0006\u0002\b\u001fR(\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0016\n\u0002\u0010\u000f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR(\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0016\n\u0002\u0010\u000f\u0012\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR(\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0016\n\u0002\u0010\u000f\u0012\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000eR&\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0016\u0010\n\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006 "}, d2 = {"Lexpo/modules/location/records/LocationTaskOptions;", "Lexpo/modules/location/records/LocationOptions;", "deferredUpdatesDistance", "", "deferredUpdatesInterval", "deferredUpdatesTimeout", "foregroundService", "Lexpo/modules/location/records/LocationTaskServiceOptions;", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Lexpo/modules/location/records/LocationTaskServiceOptions;)V", "getDeferredUpdatesDistance$annotations", "()V", "getDeferredUpdatesDistance", "()Ljava/lang/Float;", "setDeferredUpdatesDistance", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getDeferredUpdatesInterval$annotations", "getDeferredUpdatesInterval", "setDeferredUpdatesInterval", "getDeferredUpdatesTimeout$annotations", "getDeferredUpdatesTimeout", "setDeferredUpdatesTimeout", "getForegroundService$annotations", "getForegroundService", "()Lexpo/modules/location/records/LocationTaskServiceOptions;", "setForegroundService", "(Lexpo/modules/location/records/LocationTaskServiceOptions;)V", "toMutableMap", "", "", "", "toMutableMap$expo_location_release", "expo-location_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LocationArguments.kt */
public final class LocationTaskOptions extends LocationOptions {
    private Float deferredUpdatesDistance;
    private Float deferredUpdatesInterval;
    private Float deferredUpdatesTimeout;
    private LocationTaskServiceOptions foregroundService;

    public LocationTaskOptions() {
        this((Float) null, (Float) null, (Float) null, (LocationTaskServiceOptions) null, 15, (DefaultConstructorMarker) null);
    }

    @Field
    public static /* synthetic */ void getDeferredUpdatesDistance$annotations() {
    }

    @Field
    public static /* synthetic */ void getDeferredUpdatesInterval$annotations() {
    }

    @Field
    public static /* synthetic */ void getDeferredUpdatesTimeout$annotations() {
    }

    @Field
    public static /* synthetic */ void getForegroundService$annotations() {
    }

    public final Float getDeferredUpdatesDistance() {
        return this.deferredUpdatesDistance;
    }

    public final Float getDeferredUpdatesInterval() {
        return this.deferredUpdatesInterval;
    }

    public final Float getDeferredUpdatesTimeout() {
        return this.deferredUpdatesTimeout;
    }

    public final LocationTaskServiceOptions getForegroundService() {
        return this.foregroundService;
    }

    public final void setDeferredUpdatesDistance(Float f) {
        this.deferredUpdatesDistance = f;
    }

    public final void setDeferredUpdatesInterval(Float f) {
        this.deferredUpdatesInterval = f;
    }

    public final void setDeferredUpdatesTimeout(Float f) {
        this.deferredUpdatesTimeout = f;
    }

    public final void setForegroundService(LocationTaskServiceOptions locationTaskServiceOptions) {
        this.foregroundService = locationTaskServiceOptions;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ LocationTaskOptions(java.lang.Float r2, java.lang.Float r3, java.lang.Float r4, expo.modules.location.records.LocationTaskServiceOptions r5, int r6, kotlin.jvm.internal.DefaultConstructorMarker r7) {
        /*
            r1 = this;
            r7 = r6 & 1
            r0 = 0
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            if (r7 == 0) goto L_0x000a
            r2 = r0
        L_0x000a:
            r7 = r6 & 2
            if (r7 == 0) goto L_0x000f
            r3 = r0
        L_0x000f:
            r7 = r6 & 4
            r0 = 0
            if (r7 == 0) goto L_0x0015
            r4 = r0
        L_0x0015:
            r6 = r6 & 8
            if (r6 == 0) goto L_0x001a
            r5 = r0
        L_0x001a:
            r1.<init>(r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.location.records.LocationTaskOptions.<init>(java.lang.Float, java.lang.Float, java.lang.Float, expo.modules.location.records.LocationTaskServiceOptions, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public LocationTaskOptions(Float f, Float f2, Float f3, LocationTaskServiceOptions locationTaskServiceOptions) {
        super(0, (Integer) null, false, (Long) null, 15, (DefaultConstructorMarker) null);
        this.deferredUpdatesDistance = f;
        this.deferredUpdatesInterval = f2;
        this.deferredUpdatesTimeout = f3;
        this.foregroundService = locationTaskServiceOptions;
    }

    public final Map<String, Object> toMutableMap$expo_location_release() {
        Map<String, ? extends Object> map;
        Pair[] pairArr = new Pair[8];
        pairArr[0] = TuplesKt.to("accuracy", Integer.valueOf(getAccuracy()));
        pairArr[1] = TuplesKt.to("distanceInterval", getDistanceInterval());
        pairArr[2] = TuplesKt.to("mayShowUserSettingsDialog", Boolean.valueOf(getMayShowUserSettingsDialog()));
        pairArr[3] = TuplesKt.to("timeInterval", getTimeInterval());
        pairArr[4] = TuplesKt.to("deferredUpdatesDistance", this.deferredUpdatesDistance);
        pairArr[5] = TuplesKt.to("deferredUpdatesInterval", this.deferredUpdatesInterval);
        pairArr[6] = TuplesKt.to("deferredUpdatesTimeout", this.deferredUpdatesTimeout);
        LocationTaskServiceOptions locationTaskServiceOptions = this.foregroundService;
        if (locationTaskServiceOptions == null || (map = locationTaskServiceOptions.toMutableMap$expo_location_release()) == null) {
            map = new LinkedHashMap<>();
        }
        pairArr[7] = TuplesKt.to("foregroundService", map);
        return MapsKt.mutableMapOf(pairArr);
    }
}
