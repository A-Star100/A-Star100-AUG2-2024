package expo.modules.location;

import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lexpo/modules/location/LocationRequestRejectedException;", "Lexpo/modules/kotlin/exception/CodedException;", "cause", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/lang/Exception;)V", "expo-location_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LocationExceptions.kt */
public final class LocationRequestRejectedException extends CodedException {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LocationRequestRejectedException(java.lang.Exception r3) {
        /*
            r2 = this;
            java.lang.String r0 = "cause"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r3 = r3.getMessage()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Location request has been rejected: "
            r0.<init>(r1)
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            r0 = 0
            r1 = 2
            r2.<init>(r3, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.location.LocationRequestRejectedException.<init>(java.lang.Exception):void");
    }
}
