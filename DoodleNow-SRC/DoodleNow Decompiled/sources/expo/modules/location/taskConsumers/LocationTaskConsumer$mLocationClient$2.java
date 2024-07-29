package expo.modules.location.taskConsumers;

import android.content.Context;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: LocationTaskConsumer.kt */
final class LocationTaskConsumer$mLocationClient$2 extends Lambda implements Function0<FusedLocationProviderClient> {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LocationTaskConsumer$mLocationClient$2(Context context) {
        super(0);
        this.$context = context;
    }

    public final FusedLocationProviderClient invoke() {
        FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this.$context);
        Intrinsics.checkNotNullExpressionValue(fusedLocationProviderClient, "getFusedLocationProviderClient(...)");
        return fusedLocationProviderClient;
    }
}
