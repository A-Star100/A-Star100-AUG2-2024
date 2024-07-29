package com.onesignal.core.internal.purchases.impl;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import com.onesignal.core.internal.purchases.impl.TrackGooglePurchase;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/onesignal/core/internal/purchases/impl/TrackGooglePurchase$trackIAP$serviceConn$1", "Landroid/content/ServiceConnection;", "onServiceConnected", "", "name", "Landroid/content/ComponentName;", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TrackGooglePurchase.kt */
public final class TrackGooglePurchase$trackIAP$serviceConn$1 implements ServiceConnection {
    final /* synthetic */ TrackGooglePurchase this$0;

    TrackGooglePurchase$trackIAP$serviceConn$1(TrackGooglePurchase trackGooglePurchase) {
        this.this$0 = trackGooglePurchase;
    }

    public void onServiceDisconnected(ComponentName componentName) {
        Intrinsics.checkNotNullParameter(componentName, "name");
        TrackGooglePurchase.Companion companion = TrackGooglePurchase.Companion;
        TrackGooglePurchase.iapEnabled = -99;
        this.this$0.mIInAppBillingService = null;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Intrinsics.checkNotNullParameter(componentName, "name");
        Intrinsics.checkNotNullParameter(iBinder, NotificationCompat.CATEGORY_SERVICE);
        try {
            Class<?> cls = Class.forName("com.android.vending.billing.IInAppBillingService$Stub");
            TrackGooglePurchase.Companion companion = TrackGooglePurchase.Companion;
            Intrinsics.checkNotNullExpressionValue(cls, "stubClass");
            Method access$getAsInterfaceMethod = companion.getAsInterfaceMethod(cls);
            Intrinsics.checkNotNull(access$getAsInterfaceMethod);
            access$getAsInterfaceMethod.setAccessible(true);
            this.this$0.mIInAppBillingService = access$getAsInterfaceMethod.invoke((Object) null, new Object[]{iBinder});
            this.this$0.queryBoughtItems();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
