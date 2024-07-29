package expo.modules.location.services;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.revenuecat.purchases.common.Constants;
import com.rnfs.Downloader$$ExternalSyntheticApiModelOutline0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 #2\u00020\u0001:\u0002#$B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0003J\u0019\u0010\u0011\u001a\u0004\u0018\u00010\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J \u0010\u0017\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\fH\u0017J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0016H\u0016J\u0012\u0010\u001d\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0006H\u0003J\u000e\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\nJ\u000e\u0010!\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\"\u001a\u00020\u001bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lexpo/modules/location/services/LocationTaskService;", "Landroid/app/Service;", "()V", "mBinder", "Landroid/os/IBinder;", "mChannelId", "", "mKillService", "", "mParentContext", "Landroid/content/Context;", "mServiceId", "", "buildServiceNotification", "Landroid/app/Notification;", "serviceOptions", "Landroid/os/Bundle;", "colorStringToInteger", "color", "(Ljava/lang/String;)Ljava/lang/Integer;", "onBind", "intent", "Landroid/content/Intent;", "onStartCommand", "flags", "startId", "onTaskRemoved", "", "rootIntent", "prepareChannel", "id", "setParentContext", "context", "startForeground", "stop", "Companion", "ServiceBinder", "expo-location_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LocationTaskService.kt */
public final class LocationTaskService extends Service {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static int sServiceId = 481756;
    private final IBinder mBinder = new ServiceBinder();
    private String mChannelId;
    private boolean mKillService;
    private Context mParentContext;
    private final int mServiceId;

    public IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return this.mBinder;
    }

    public final void setParentContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mParentContext = context;
    }

    public LocationTaskService() {
        int i = sServiceId;
        sServiceId = i + 1;
        this.mServiceId = i;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lexpo/modules/location/services/LocationTaskService$ServiceBinder;", "Landroid/os/Binder;", "(Lexpo/modules/location/services/LocationTaskService;)V", "service", "Lexpo/modules/location/services/LocationTaskService;", "getService", "()Lexpo/modules/location/services/LocationTaskService;", "expo-location_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: LocationTaskService.kt */
    public final class ServiceBinder extends Binder {
        public final LocationTaskService getService() {
            return LocationTaskService.this;
        }

        public ServiceBinder() {
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return 3;
        }
        String string = extras.getString("appId");
        String string2 = extras.getString("taskName");
        this.mChannelId = string + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + string2;
        this.mKillService = extras.getBoolean("killService", false);
        return 3;
    }

    public final void stop() {
        stopForeground(true);
        stopSelf();
    }

    public void onTaskRemoved(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "rootIntent");
        if (this.mKillService) {
            super.onTaskRemoved(intent);
            stop();
        }
    }

    public final void startForeground(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "serviceOptions");
        startForeground(this.mServiceId, buildServiceNotification(bundle));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x004b, code lost:
        if (r1.setColorized(true).setColor(r7.intValue()) == null) goto L_0x004d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.app.Notification buildServiceNotification(android.os.Bundle r7) {
        /*
            r6 = this;
            java.lang.String r0 = r6.mChannelId
            r6.prepareChannel(r0)
            com.rnfs.Downloader$$ExternalSyntheticApiModelOutline0.m$1()
            r0 = r6
            android.content.Context r0 = (android.content.Context) r0
            java.lang.String r1 = r6.mChannelId
            android.app.Notification$Builder r1 = com.rnfs.Downloader$$ExternalSyntheticApiModelOutline0.m((android.content.Context) r0, (java.lang.String) r1)
            java.lang.String r2 = "notificationTitle"
            java.lang.String r2 = r7.getString(r2)
            java.lang.String r3 = "notificationBody"
            java.lang.String r3 = r7.getString(r3)
            java.lang.String r4 = "notificationColor"
            java.lang.String r7 = r7.getString(r4)
            java.lang.Integer r7 = r6.colorStringToInteger(r7)
            if (r2 == 0) goto L_0x002e
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setContentTitle(r2)
        L_0x002e:
            if (r3 == 0) goto L_0x0035
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r1.setContentText(r3)
        L_0x0035:
            r2 = 0
            if (r7 == 0) goto L_0x004d
            r3 = r7
            java.lang.Number r3 = (java.lang.Number) r3
            r3.intValue()
            r3 = 1
            android.app.Notification$Builder r3 = r1.setColorized(r3)
            int r7 = r7.intValue()
            android.app.Notification$Builder r7 = r3.setColor(r7)
            if (r7 != 0) goto L_0x0053
        L_0x004d:
            r7 = r6
            expo.modules.location.services.LocationTaskService r7 = (expo.modules.location.services.LocationTaskService) r7
            android.app.Notification.Builder unused = r1.setColorized(r2)
        L_0x0053:
            android.content.Context r7 = r6.mParentContext
            r3 = 0
            java.lang.String r4 = "mParentContext"
            if (r7 != 0) goto L_0x005e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r7 = r3
        L_0x005e:
            android.content.pm.PackageManager r7 = r7.getPackageManager()
            android.content.Context r5 = r6.mParentContext
            if (r5 != 0) goto L_0x006a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            goto L_0x006b
        L_0x006a:
            r3 = r5
        L_0x006b:
            java.lang.String r3 = r3.getPackageName()
            android.content.Intent r7 = r7.getLaunchIntentForPackage(r3)
            if (r7 == 0) goto L_0x008e
            r3 = 536870912(0x20000000, float:1.0842022E-19)
            r7.setFlags(r3)
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 31
            if (r3 < r4) goto L_0x0083
            r3 = 33554432(0x2000000, float:9.403955E-38)
            goto L_0x0084
        L_0x0083:
            r3 = r2
        L_0x0084:
            r4 = 134217728(0x8000000, float:3.85186E-34)
            r3 = r3 | r4
            android.app.PendingIntent r7 = android.app.PendingIntent.getActivity(r0, r2, r7, r3)
            r1.setContentIntent(r7)
        L_0x008e:
            java.lang.String r7 = "service"
            android.app.Notification$Builder r7 = r1.setCategory(r7)
            android.content.pm.ApplicationInfo r0 = r6.getApplicationInfo()
            int r0 = r0.icon
            android.app.Notification$Builder r7 = r7.setSmallIcon(r0)
            android.app.Notification r7 = r7.build()
            java.lang.String r0 = "build(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.location.services.LocationTaskService.buildServiceNotification(android.os.Bundle):android.app.Notification");
    }

    private final void prepareChannel(String str) {
        Object systemService = getSystemService(OneSignalDbContract.NotificationTable.TABLE_NAME);
        NotificationManager notificationManager = systemService instanceof NotificationManager ? (NotificationManager) systemService : null;
        if (notificationManager != null) {
            String obj = getApplicationInfo().loadLabel(getPackageManager()).toString();
            if (notificationManager.getNotificationChannel(str) == null) {
                Downloader$$ExternalSyntheticApiModelOutline0.m$2();
                NotificationChannel m = Downloader$$ExternalSyntheticApiModelOutline0.m(str, (CharSequence) obj, 2);
                m.setDescription("Background location notification channel");
                notificationManager.createNotificationChannel(m);
            }
        }
    }

    private final Integer colorStringToInteger(String str) {
        try {
            return Integer.valueOf(Color.parseColor(str));
        } catch (Exception unused) {
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lexpo/modules/location/services/LocationTaskService$Companion;", "", "()V", "sServiceId", "", "expo-location_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: LocationTaskService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
