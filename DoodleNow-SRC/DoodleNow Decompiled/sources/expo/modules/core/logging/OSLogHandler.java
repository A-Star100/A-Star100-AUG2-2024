package expo.modules.core.logging;

import android.util.Log;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J'\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0010¢\u0006\u0002\b\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lexpo/modules/core/logging/OSLogHandler;", "Lexpo/modules/core/logging/LogHandler;", "category", "", "(Ljava/lang/String;)V", "getCategory", "()Ljava/lang/String;", "log", "", "type", "Lexpo/modules/core/logging/LogType;", "message", "cause", "", "log$expo_modules_core_release", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: OSLogHandler.kt */
public final class OSLogHandler extends LogHandler {
    private final String category;

    public final String getCategory() {
        return this.category;
    }

    public OSLogHandler(String str) {
        Intrinsics.checkNotNullParameter(str, "category");
        this.category = str;
    }

    public void log$expo_modules_core_release(LogType logType, String str, Throwable th) {
        Intrinsics.checkNotNullParameter(logType, "type");
        Intrinsics.checkNotNullParameter(str, OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE);
        if (!OSLogHandlerKt.isAndroid) {
            String type = logType.getType();
            String str2 = this.category;
            System.out.println("[" + type + "] " + str2 + "\t" + str);
            if (th != null) {
                String localizedMessage = th.getLocalizedMessage();
                String stackTraceToString = ExceptionsKt.stackTraceToString(th);
                System.out.println(localizedMessage + "\n" + stackTraceToString);
                return;
            }
            return;
        }
        int oSLogType = LogType.Companion.toOSLogType(logType);
        if (oSLogType == 3) {
            Log.d(this.category, str, th);
        } else if (oSLogType == 4) {
            Log.i(this.category, str, th);
        } else if (oSLogType == 5) {
            Log.w(this.category, str, th);
        } else if (oSLogType == 6) {
            Log.e(this.category, str, th);
        } else if (oSLogType == 7) {
            Log.e(this.category, str, th);
        }
    }
}
