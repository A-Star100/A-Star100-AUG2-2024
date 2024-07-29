package com.revenuecat.purchases.hybridcommon.mappers;

import androidx.core.app.NotificationCompat;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B4\u0012-\u0010\u0002\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0016J\"\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0016R5\u0010\u0002\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/revenuecat/purchases/hybridcommon/mappers/LogHandlerWithMapping;", "Lcom/revenuecat/purchases/LogHandler;", "callback", "Lkotlin/Function1;", "", "", "Lkotlin/ParameterName;", "name", "logData", "", "(Lkotlin/jvm/functions/Function1;)V", "d", "tag", "msg", "e", "throwable", "", "i", "invokeCallback", "logLevel", "Lcom/revenuecat/purchases/LogLevel;", "v", "w", "hybridcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: LogHandlerWithMapping.kt */
public final class LogHandlerWithMapping implements LogHandler {
    private final Function1<Map<String, String>, Unit> callback;

    public LogHandlerWithMapping(Function1<? super Map<String, String>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        this.callback = function1;
    }

    public void d(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
        invokeCallback(LogLevel.DEBUG, str2);
    }

    public void e(String str, String str2, Throwable th) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
        if (th != null) {
            String str3 = str2 + ". Throwable: " + th;
            if (str3 != null) {
                str2 = str3;
            }
        }
        invokeCallback(LogLevel.ERROR, str2);
    }

    public void i(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
        invokeCallback(LogLevel.INFO, str2);
    }

    public void v(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
        invokeCallback(LogLevel.VERBOSE, str2);
    }

    public void w(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
        invokeCallback(LogLevel.WARN, str2);
    }

    private final void invokeCallback(LogLevel logLevel, String str) {
        Function1<Map<String, String>, Unit> function1 = this.callback;
        String upperCase = logLevel.name().toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        function1.invoke(MapsKt.mapOf(TuplesKt.to("logLevel", upperCase), TuplesKt.to(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, str)));
    }
}
