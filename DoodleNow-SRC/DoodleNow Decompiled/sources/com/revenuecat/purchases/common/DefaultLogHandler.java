package com.revenuecat.purchases.common;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.revenuecat.purchases.LogHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\"\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\u000e"}, d2 = {"Lcom/revenuecat/purchases/common/DefaultLogHandler;", "Lcom/revenuecat/purchases/LogHandler;", "()V", "d", "", "tag", "", "msg", "e", "throwable", "", "i", "v", "w", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: logWrapper.kt */
final class DefaultLogHandler implements LogHandler {
    public void v(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
        Log.v(str, str2);
    }

    public void d(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
        Log.d(str, str2);
    }

    public void i(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
        Log.i(str, str2);
    }

    public void w(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
        Log.w(str, str2);
    }

    public void e(String str, String str2, Throwable th) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
        if (th != null) {
            Log.e(str, str2, th);
        } else {
            Log.e(str, str2);
        }
    }
}
