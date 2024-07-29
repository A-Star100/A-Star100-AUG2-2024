package expo.modules.location.records;

import android.location.Location;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B)\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ'\u0010\u001f\u001a\u0002H \"\b\b\u0000\u0010 *\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H 0#H\u0000¢\u0006\u0004\b$\u0010%R&\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R(\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0016\n\u0002\u0010\u0018\u0012\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0016\n\u0002\u0010\u001e\u0012\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006&"}, d2 = {"Lexpo/modules/location/records/LocationResponse;", "Lexpo/modules/kotlin/records/Record;", "Ljava/io/Serializable;", "location", "Landroid/location/Location;", "(Landroid/location/Location;)V", "coords", "Lexpo/modules/location/records/LocationObjectCoords;", "timestamp", "", "mocked", "", "(Lexpo/modules/location/records/LocationObjectCoords;Ljava/lang/Double;Ljava/lang/Boolean;)V", "getCoords$annotations", "()V", "getCoords", "()Lexpo/modules/location/records/LocationObjectCoords;", "setCoords", "(Lexpo/modules/location/records/LocationObjectCoords;)V", "getMocked$annotations", "getMocked", "()Ljava/lang/Boolean;", "setMocked", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getTimestamp$annotations", "getTimestamp", "()Ljava/lang/Double;", "setTimestamp", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "toBundle", "BundleType", "Landroid/os/BaseBundle;", "bundleTypeClass", "Ljava/lang/Class;", "toBundle$expo_location_release", "(Ljava/lang/Class;)Landroid/os/BaseBundle;", "expo-location_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LocationResults.kt */
public final class LocationResponse implements Record, Serializable {
    private LocationObjectCoords coords;
    private Boolean mocked;
    private Double timestamp;

    public LocationResponse() {
        this((LocationObjectCoords) null, (Double) null, (Boolean) null, 7, (DefaultConstructorMarker) null);
    }

    @Field
    public static /* synthetic */ void getCoords$annotations() {
    }

    @Field
    public static /* synthetic */ void getMocked$annotations() {
    }

    @Field
    public static /* synthetic */ void getTimestamp$annotations() {
    }

    public final LocationObjectCoords getCoords() {
        return this.coords;
    }

    public final Boolean getMocked() {
        return this.mocked;
    }

    public final Double getTimestamp() {
        return this.timestamp;
    }

    public final void setCoords(LocationObjectCoords locationObjectCoords) {
        this.coords = locationObjectCoords;
    }

    public final void setMocked(Boolean bool) {
        this.mocked = bool;
    }

    public final void setTimestamp(Double d) {
        this.timestamp = d;
    }

    public LocationResponse(LocationObjectCoords locationObjectCoords, Double d, Boolean bool) {
        this.coords = locationObjectCoords;
        this.timestamp = d;
        this.mocked = bool;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LocationResponse(LocationObjectCoords locationObjectCoords, Double d, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : locationObjectCoords, (i & 2) != 0 ? null : d, (i & 4) != 0 ? null : bool);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LocationResponse(Location location) {
        this(new LocationObjectCoords(location), Double.valueOf((double) location.getTime()), Boolean.valueOf(location.isFromMockProvider()));
        Intrinsics.checkNotNullParameter(location, "location");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: android.os.PersistableBundle} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <BundleType extends android.os.BaseBundle> BundleType toBundle$expo_location_release(java.lang.Class<BundleType> r6) {
        /*
            r5 = this;
            java.lang.String r0 = "bundleTypeClass"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.Class<android.os.PersistableBundle> r0 = android.os.PersistableBundle.class
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x0013
            android.os.PersistableBundle r0 = new android.os.PersistableBundle
            r0.<init>()
            goto L_0x0018
        L_0x0013:
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
        L_0x0018:
            boolean r1 = r0 instanceof android.os.BaseBundle
            r2 = 0
            if (r1 == 0) goto L_0x0020
            android.os.BaseBundle r0 = (android.os.BaseBundle) r0
            goto L_0x0021
        L_0x0020:
            r0 = r2
        L_0x0021:
            if (r0 == 0) goto L_0x006f
            java.lang.Double r6 = r5.timestamp
            if (r6 == 0) goto L_0x0032
            java.lang.Number r6 = (java.lang.Number) r6
            double r3 = r6.doubleValue()
            java.lang.String r6 = "timestamp"
            r0.putDouble(r6, r3)
        L_0x0032:
            java.lang.Boolean r6 = r5.mocked
            if (r6 == 0) goto L_0x003f
            boolean r6 = r6.booleanValue()
            java.lang.String r1 = "mocked"
            r0.putBoolean(r1, r6)
        L_0x003f:
            boolean r6 = r0 instanceof android.os.PersistableBundle
            java.lang.String r1 = "coords"
            if (r6 == 0) goto L_0x0058
            r6 = r0
            android.os.PersistableBundle r6 = (android.os.PersistableBundle) r6
            expo.modules.location.records.LocationObjectCoords r3 = r5.coords
            if (r3 == 0) goto L_0x0054
            java.lang.Class<android.os.PersistableBundle> r2 = android.os.PersistableBundle.class
            android.os.BaseBundle r2 = r3.toBundle$expo_location_release(r2)
            android.os.PersistableBundle r2 = (android.os.PersistableBundle) r2
        L_0x0054:
            r6.putPersistableBundle(r1, r2)
            goto L_0x006e
        L_0x0058:
            boolean r6 = r0 instanceof android.os.Bundle
            if (r6 == 0) goto L_0x006e
            r6 = r0
            android.os.Bundle r6 = (android.os.Bundle) r6
            expo.modules.location.records.LocationObjectCoords r3 = r5.coords
            if (r3 == 0) goto L_0x006b
            java.lang.Class<android.os.Bundle> r2 = android.os.Bundle.class
            android.os.BaseBundle r2 = r3.toBundle$expo_location_release(r2)
            android.os.Bundle r2 = (android.os.Bundle) r2
        L_0x006b:
            r6.putBundle(r1, r2)
        L_0x006e:
            return r0
        L_0x006f:
            expo.modules.location.ConversionException r0 = new expo.modules.location.ConversionException
            java.lang.Class<expo.modules.location.records.LocationResponse> r1 = expo.modules.location.records.LocationResponse.class
            java.lang.String r2 = "Unsupported bundleTypeClass"
            r0.<init>(r1, r6, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.location.records.LocationResponse.toBundle$expo_location_release(java.lang.Class):android.os.BaseBundle");
    }
}
