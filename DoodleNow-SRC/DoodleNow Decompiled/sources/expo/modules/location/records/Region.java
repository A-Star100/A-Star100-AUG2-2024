package expo.modules.location.records;

import androidx.camera.video.AudioStats;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002BS\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u001b\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010302H\u0000¢\u0006\u0002\b4R&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R(\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0016\n\u0002\u0010\"\u0012\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R(\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0016\n\u0002\u0010\"\u0012\u0004\b#\u0010\u0010\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R(\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0016\n\u0002\u0010+\u0012\u0004\b&\u0010\u0010\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010\f\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b,\u0010\u0010\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u00065"}, d2 = {"Lexpo/modules/location/records/Region;", "Lexpo/modules/kotlin/records/Record;", "Ljava/io/Serializable;", "identifier", "", "latitude", "", "longitude", "notifyOnEnter", "", "notifyOnExit", "radius", "state", "Lexpo/modules/location/records/GeofencingRegionState;", "(Ljava/lang/String;DDLjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Double;Lexpo/modules/location/records/GeofencingRegionState;)V", "getIdentifier$annotations", "()V", "getIdentifier", "()Ljava/lang/String;", "setIdentifier", "(Ljava/lang/String;)V", "getLatitude$annotations", "getLatitude", "()D", "setLatitude", "(D)V", "getLongitude$annotations", "getLongitude", "setLongitude", "getNotifyOnEnter$annotations", "getNotifyOnEnter", "()Ljava/lang/Boolean;", "setNotifyOnEnter", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getNotifyOnExit$annotations", "getNotifyOnExit", "setNotifyOnExit", "getRadius$annotations", "getRadius", "()Ljava/lang/Double;", "setRadius", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getState$annotations", "getState", "()Lexpo/modules/location/records/GeofencingRegionState;", "setState", "(Lexpo/modules/location/records/GeofencingRegionState;)V", "toMap", "", "", "toMap$expo_location_release", "expo-location_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LocationArguments.kt */
public final class Region implements Record, Serializable {
    private String identifier;
    private double latitude;
    private double longitude;
    private Boolean notifyOnEnter;
    private Boolean notifyOnExit;
    private Double radius;
    private GeofencingRegionState state;

    public Region() {
        this((String) null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, (Boolean) null, (Boolean) null, (Double) null, (GeofencingRegionState) null, 127, (DefaultConstructorMarker) null);
    }

    @Field
    public static /* synthetic */ void getIdentifier$annotations() {
    }

    @Field
    public static /* synthetic */ void getLatitude$annotations() {
    }

    @Field
    public static /* synthetic */ void getLongitude$annotations() {
    }

    @Field
    public static /* synthetic */ void getNotifyOnEnter$annotations() {
    }

    @Field
    public static /* synthetic */ void getNotifyOnExit$annotations() {
    }

    @Field
    public static /* synthetic */ void getRadius$annotations() {
    }

    @Field
    public static /* synthetic */ void getState$annotations() {
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public final Boolean getNotifyOnEnter() {
        return this.notifyOnEnter;
    }

    public final Boolean getNotifyOnExit() {
        return this.notifyOnExit;
    }

    public final Double getRadius() {
        return this.radius;
    }

    public final GeofencingRegionState getState() {
        return this.state;
    }

    public final void setIdentifier(String str) {
        this.identifier = str;
    }

    public final void setLatitude(double d) {
        this.latitude = d;
    }

    public final void setLongitude(double d) {
        this.longitude = d;
    }

    public final void setNotifyOnEnter(Boolean bool) {
        this.notifyOnEnter = bool;
    }

    public final void setNotifyOnExit(Boolean bool) {
        this.notifyOnExit = bool;
    }

    public final void setRadius(Double d) {
        this.radius = d;
    }

    public final void setState(GeofencingRegionState geofencingRegionState) {
        Intrinsics.checkNotNullParameter(geofencingRegionState, "<set-?>");
        this.state = geofencingRegionState;
    }

    public Region(String str, double d, double d2, Boolean bool, Boolean bool2, Double d3, GeofencingRegionState geofencingRegionState) {
        Intrinsics.checkNotNullParameter(geofencingRegionState, "state");
        this.identifier = str;
        this.latitude = d;
        this.longitude = d2;
        this.notifyOnEnter = bool;
        this.notifyOnExit = bool2;
        this.radius = d3;
        this.state = geofencingRegionState;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Region(java.lang.String r11, double r12, double r14, java.lang.Boolean r16, java.lang.Boolean r17, java.lang.Double r18, expo.modules.location.records.GeofencingRegionState r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r10 = this;
            r0 = r20 & 1
            if (r0 == 0) goto L_0x0006
            r0 = 0
            goto L_0x0007
        L_0x0006:
            r0 = r11
        L_0x0007:
            r1 = r20 & 2
            r2 = 0
            if (r1 == 0) goto L_0x000f
            r4 = r2
            goto L_0x0010
        L_0x000f:
            r4 = r12
        L_0x0010:
            r1 = r20 & 4
            if (r1 == 0) goto L_0x0016
            r6 = r2
            goto L_0x0017
        L_0x0016:
            r6 = r14
        L_0x0017:
            r1 = r20 & 8
            r8 = 1
            if (r1 == 0) goto L_0x0021
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r8)
            goto L_0x0023
        L_0x0021:
            r1 = r16
        L_0x0023:
            r9 = r20 & 16
            if (r9 == 0) goto L_0x002c
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            goto L_0x002e
        L_0x002c:
            r8 = r17
        L_0x002e:
            r9 = r20 & 32
            if (r9 == 0) goto L_0x0037
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            goto L_0x0039
        L_0x0037:
            r2 = r18
        L_0x0039:
            r3 = r20 & 64
            if (r3 == 0) goto L_0x0040
            expo.modules.location.records.GeofencingRegionState r3 = expo.modules.location.records.GeofencingRegionState.UNKNOWN
            goto L_0x0042
        L_0x0040:
            r3 = r19
        L_0x0042:
            r11 = r10
            r12 = r0
            r13 = r4
            r15 = r6
            r17 = r1
            r18 = r8
            r19 = r2
            r20 = r3
            r11.<init>(r12, r13, r15, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.location.records.Region.<init>(java.lang.String, double, double, java.lang.Boolean, java.lang.Boolean, java.lang.Double, expo.modules.location.records.GeofencingRegionState, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Map<String, Object> toMap$expo_location_release() {
        return MapsKt.mapOf(TuplesKt.to("identifier", this.identifier), TuplesKt.to("latitude", Double.valueOf(this.latitude)), TuplesKt.to("longitude", Double.valueOf(this.longitude)), TuplesKt.to("notifyOnEnter", this.notifyOnEnter), TuplesKt.to("notifyOnExit", this.notifyOnExit), TuplesKt.to("radius", this.radius), TuplesKt.to("state", this.state));
    }
}
