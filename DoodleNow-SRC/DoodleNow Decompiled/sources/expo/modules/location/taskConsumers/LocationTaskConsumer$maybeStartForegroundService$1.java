package expo.modules.location.taskConsumers;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import expo.modules.location.services.LocationTaskService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"expo/modules/location/taskConsumers/LocationTaskConsumer$maybeStartForegroundService$1", "Landroid/content/ServiceConnection;", "onServiceConnected", "", "name", "Landroid/content/ComponentName;", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "expo-location_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LocationTaskConsumer.kt */
public final class LocationTaskConsumer$maybeStartForegroundService$1 implements ServiceConnection {
    final /* synthetic */ Bundle $serviceOptions;
    final /* synthetic */ LocationTaskConsumer this$0;

    LocationTaskConsumer$maybeStartForegroundService$1(LocationTaskConsumer locationTaskConsumer, Bundle bundle) {
        this.this$0 = locationTaskConsumer;
        this.$serviceOptions = bundle;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Intrinsics.checkNotNullParameter(componentName, "name");
        Intrinsics.checkNotNullParameter(iBinder, NotificationCompat.CATEGORY_SERVICE);
        LocationTaskConsumer locationTaskConsumer = this.this$0;
        LocationTaskService locationTaskService = null;
        LocationTaskService.ServiceBinder serviceBinder = iBinder instanceof LocationTaskService.ServiceBinder ? (LocationTaskService.ServiceBinder) iBinder : null;
        if (serviceBinder != null) {
            locationTaskService = serviceBinder.getService();
        }
        locationTaskConsumer.mService = locationTaskService;
        LocationTaskService access$getMService$p = this.this$0.mService;
        if (access$getMService$p != null) {
            LocationTaskConsumer locationTaskConsumer2 = this.this$0;
            Bundle bundle = this.$serviceOptions;
            Context access$getContext = locationTaskConsumer2.getContext();
            Intrinsics.checkNotNullExpressionValue(access$getContext, "access$getContext(...)");
            access$getMService$p.setParentContext(access$getContext);
            Intrinsics.checkNotNull(bundle);
            access$getMService$p.startForeground(bundle);
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        Intrinsics.checkNotNullParameter(componentName, "name");
        LocationTaskService access$getMService$p = this.this$0.mService;
        if (access$getMService$p != null) {
            access$getMService$p.stop();
        }
        this.this$0.mService = null;
    }
}
