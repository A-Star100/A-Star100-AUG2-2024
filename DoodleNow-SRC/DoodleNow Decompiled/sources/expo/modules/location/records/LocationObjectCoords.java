package expo.modules.location.records;

import android.location.Location;
import android.os.BaseBundle;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import expo.modules.location.ConversionException;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005BY\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000eJ'\u0010(\u001a\u0002H)\"\b\b\u0000\u0010)*\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u0002H)0,H\u0000¢\u0006\u0004\b-\u0010.R(\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0016\n\u0002\u0010\u0015\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0016\n\u0002\u0010\u0015\u0012\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R(\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0016\n\u0002\u0010\u0015\u0012\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\u0012\"\u0004\b\u001b\u0010\u0014R(\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0016\n\u0002\u0010\u0015\u0012\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R(\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0016\n\u0002\u0010\u0015\u0012\u0004\b\u001f\u0010\u0010\u001a\u0004\b \u0010\u0012\"\u0004\b!\u0010\u0014R(\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0016\n\u0002\u0010\u0015\u0012\u0004\b\"\u0010\u0010\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010\u0014R(\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0016\n\u0002\u0010\u0015\u0012\u0004\b%\u0010\u0010\u001a\u0004\b&\u0010\u0012\"\u0004\b'\u0010\u0014¨\u0006/"}, d2 = {"Lexpo/modules/location/records/LocationObjectCoords;", "Lexpo/modules/kotlin/records/Record;", "Ljava/io/Serializable;", "location", "Landroid/location/Location;", "(Landroid/location/Location;)V", "latitude", "", "longitude", "altitude", "accuracy", "altitudeAccuracy", "heading", "speed", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)V", "getAccuracy$annotations", "()V", "getAccuracy", "()Ljava/lang/Double;", "setAccuracy", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getAltitude$annotations", "getAltitude", "setAltitude", "getAltitudeAccuracy$annotations", "getAltitudeAccuracy", "setAltitudeAccuracy", "getHeading$annotations", "getHeading", "setHeading", "getLatitude$annotations", "getLatitude", "setLatitude", "getLongitude$annotations", "getLongitude", "setLongitude", "getSpeed$annotations", "getSpeed", "setSpeed", "toBundle", "BundleType", "Landroid/os/BaseBundle;", "bundleTypeClass", "Ljava/lang/Class;", "toBundle$expo_location_release", "(Ljava/lang/Class;)Landroid/os/BaseBundle;", "expo-location_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LocationResults.kt */
public final class LocationObjectCoords implements Record, Serializable {
    private Double accuracy;
    private Double altitude;
    private Double altitudeAccuracy;
    private Double heading;
    private Double latitude;
    private Double longitude;
    private Double speed;

    public LocationObjectCoords() {
        this((Double) null, (Double) null, (Double) null, (Double) null, (Double) null, (Double) null, (Double) null, 127, (DefaultConstructorMarker) null);
    }

    @Field
    public static /* synthetic */ void getAccuracy$annotations() {
    }

    @Field
    public static /* synthetic */ void getAltitude$annotations() {
    }

    @Field
    public static /* synthetic */ void getAltitudeAccuracy$annotations() {
    }

    @Field
    public static /* synthetic */ void getHeading$annotations() {
    }

    @Field
    public static /* synthetic */ void getLatitude$annotations() {
    }

    @Field
    public static /* synthetic */ void getLongitude$annotations() {
    }

    @Field
    public static /* synthetic */ void getSpeed$annotations() {
    }

    public final Double getAccuracy() {
        return this.accuracy;
    }

    public final Double getAltitude() {
        return this.altitude;
    }

    public final Double getAltitudeAccuracy() {
        return this.altitudeAccuracy;
    }

    public final Double getHeading() {
        return this.heading;
    }

    public final Double getLatitude() {
        return this.latitude;
    }

    public final Double getLongitude() {
        return this.longitude;
    }

    public final Double getSpeed() {
        return this.speed;
    }

    public final void setAccuracy(Double d) {
        this.accuracy = d;
    }

    public final void setAltitude(Double d) {
        this.altitude = d;
    }

    public final void setAltitudeAccuracy(Double d) {
        this.altitudeAccuracy = d;
    }

    public final void setHeading(Double d) {
        this.heading = d;
    }

    public final void setLatitude(Double d) {
        this.latitude = d;
    }

    public final void setLongitude(Double d) {
        this.longitude = d;
    }

    public final void setSpeed(Double d) {
        this.speed = d;
    }

    public LocationObjectCoords(Double d, Double d2, Double d3, Double d4, Double d5, Double d6, Double d7) {
        this.latitude = d;
        this.longitude = d2;
        this.altitude = d3;
        this.accuracy = d4;
        this.altitudeAccuracy = d5;
        this.heading = d6;
        this.speed = d7;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ LocationObjectCoords(java.lang.Double r7, java.lang.Double r8, java.lang.Double r9, java.lang.Double r10, java.lang.Double r11, java.lang.Double r12, java.lang.Double r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r6 = this;
            r15 = r14 & 1
            r0 = 0
            if (r15 == 0) goto L_0x0007
            r15 = r0
            goto L_0x0008
        L_0x0007:
            r15 = r7
        L_0x0008:
            r7 = r14 & 2
            if (r7 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r8
        L_0x000f:
            r7 = r14 & 4
            if (r7 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r9
        L_0x0016:
            r7 = r14 & 8
            if (r7 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r10
        L_0x001d:
            r7 = r14 & 16
            if (r7 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r11
        L_0x0024:
            r7 = r14 & 32
            if (r7 == 0) goto L_0x002a
            r5 = r0
            goto L_0x002b
        L_0x002a:
            r5 = r12
        L_0x002b:
            r7 = r14 & 64
            if (r7 == 0) goto L_0x0031
            r14 = r0
            goto L_0x0032
        L_0x0031:
            r14 = r13
        L_0x0032:
            r7 = r6
            r8 = r15
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r4
            r13 = r5
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.location.records.LocationObjectCoords.<init>(java.lang.Double, java.lang.Double, java.lang.Double, java.lang.Double, java.lang.Double, java.lang.Double, java.lang.Double, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LocationObjectCoords(Location location) {
        this(Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude()), Double.valueOf(location.getAltitude()), Double.valueOf((double) location.getAccuracy()), Build.VERSION.SDK_INT >= 26 ? Double.valueOf((double) location.getVerticalAccuracyMeters()) : null, Double.valueOf((double) location.getBearing()), Double.valueOf((double) location.getSpeed()));
        Intrinsics.checkNotNullParameter(location, "location");
    }

    public final <BundleType extends BaseBundle> BundleType toBundle$expo_location_release(Class<BundleType> cls) {
        BundleType bundletype;
        Intrinsics.checkNotNullParameter(cls, "bundleTypeClass");
        if (Intrinsics.areEqual((Object) cls, (Object) PersistableBundle.class)) {
            bundletype = new PersistableBundle();
        } else {
            bundletype = new Bundle();
        }
        BundleType bundletype2 = bundletype instanceof BaseBundle ? (BaseBundle) bundletype : null;
        if (bundletype2 != null) {
            Double d = this.latitude;
            if (d != null) {
                bundletype2.putDouble("latitude", d.doubleValue());
            }
            Double d2 = this.longitude;
            if (d2 != null) {
                bundletype2.putDouble("longitude", d2.doubleValue());
            }
            Double d3 = this.altitude;
            if (d3 != null) {
                bundletype2.putDouble("altitude", d3.doubleValue());
            }
            Double d4 = this.accuracy;
            if (d4 != null) {
                bundletype2.putDouble("accuracy", d4.doubleValue());
            }
            Double d5 = this.altitudeAccuracy;
            if (d5 != null) {
                bundletype2.putDouble("altitudeAccuracy", d5.doubleValue());
            }
            Double d6 = this.heading;
            if (d6 != null) {
                bundletype2.putDouble("heading", d6.doubleValue());
            }
            Double d7 = this.speed;
            if (d7 != null) {
                bundletype2.putDouble("speed", d7.doubleValue());
            }
            return bundletype2;
        }
        throw new ConversionException(LocationObjectCoords.class, cls, "Requested an unsupported bundle type");
    }
}
