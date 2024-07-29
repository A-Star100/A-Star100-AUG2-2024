package expo.modules.location.records;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B?\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\tR(\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0016\n\u0002\u0010\u0010\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0016\n\u0002\u0010\u0010\u0012\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR$\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R(\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0016\n\u0002\u0010\u0010\u0012\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR(\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0016\n\u0002\u0010\u0010\u0012\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000f¨\u0006\u001f"}, d2 = {"Lexpo/modules/location/records/LocationProviderStatus;", "Lexpo/modules/kotlin/records/Record;", "Ljava/io/Serializable;", "backgroundModeEnabled", "", "gpsAvailable", "networkAvailable", "locationServicesEnabled", "passiveAvailable", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;ZLjava/lang/Boolean;)V", "getBackgroundModeEnabled$annotations", "()V", "getBackgroundModeEnabled", "()Ljava/lang/Boolean;", "setBackgroundModeEnabled", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getGpsAvailable$annotations", "getGpsAvailable", "setGpsAvailable", "getLocationServicesEnabled$annotations", "getLocationServicesEnabled", "()Z", "setLocationServicesEnabled", "(Z)V", "getNetworkAvailable$annotations", "getNetworkAvailable", "setNetworkAvailable", "getPassiveAvailable$annotations", "getPassiveAvailable", "setPassiveAvailable", "expo-location_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LocationResults.kt */
public final class LocationProviderStatus implements Record, Serializable {
    private Boolean backgroundModeEnabled;
    private Boolean gpsAvailable;
    private boolean locationServicesEnabled;
    private Boolean networkAvailable;
    private Boolean passiveAvailable;

    public LocationProviderStatus() {
        this((Boolean) null, (Boolean) null, (Boolean) null, false, (Boolean) null, 31, (DefaultConstructorMarker) null);
    }

    @Field
    public static /* synthetic */ void getBackgroundModeEnabled$annotations() {
    }

    @Field
    public static /* synthetic */ void getGpsAvailable$annotations() {
    }

    @Field
    public static /* synthetic */ void getLocationServicesEnabled$annotations() {
    }

    @Field
    public static /* synthetic */ void getNetworkAvailable$annotations() {
    }

    @Field
    public static /* synthetic */ void getPassiveAvailable$annotations() {
    }

    public final Boolean getBackgroundModeEnabled() {
        return this.backgroundModeEnabled;
    }

    public final Boolean getGpsAvailable() {
        return this.gpsAvailable;
    }

    public final boolean getLocationServicesEnabled() {
        return this.locationServicesEnabled;
    }

    public final Boolean getNetworkAvailable() {
        return this.networkAvailable;
    }

    public final Boolean getPassiveAvailable() {
        return this.passiveAvailable;
    }

    public final void setBackgroundModeEnabled(Boolean bool) {
        this.backgroundModeEnabled = bool;
    }

    public final void setGpsAvailable(Boolean bool) {
        this.gpsAvailable = bool;
    }

    public final void setLocationServicesEnabled(boolean z) {
        this.locationServicesEnabled = z;
    }

    public final void setNetworkAvailable(Boolean bool) {
        this.networkAvailable = bool;
    }

    public final void setPassiveAvailable(Boolean bool) {
        this.passiveAvailable = bool;
    }

    public LocationProviderStatus(Boolean bool, Boolean bool2, Boolean bool3, boolean z, Boolean bool4) {
        this.backgroundModeEnabled = bool;
        this.gpsAvailable = bool2;
        this.networkAvailable = bool3;
        this.locationServicesEnabled = z;
        this.passiveAvailable = bool4;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ LocationProviderStatus(java.lang.Boolean r5, java.lang.Boolean r6, java.lang.Boolean r7, boolean r8, java.lang.Boolean r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            r1 = 0
            if (r5 == 0) goto L_0x0011
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r1)
        L_0x0011:
            r2 = r6
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0018
            r3 = r0
            goto L_0x0019
        L_0x0018:
            r3 = r7
        L_0x0019:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001e
            goto L_0x001f
        L_0x001e:
            r1 = r8
        L_0x001f:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0025
            r10 = r0
            goto L_0x0026
        L_0x0025:
            r10 = r9
        L_0x0026:
            r5 = r4
            r6 = r11
            r7 = r2
            r8 = r3
            r9 = r1
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.location.records.LocationProviderStatus.<init>(java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, boolean, java.lang.Boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
