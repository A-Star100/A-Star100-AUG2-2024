package com.onesignal.debug.internal.logging;

import android.util.Log;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.debug.LogLevel;
import java.io.PrintWriter;
import java.io.StringWriter;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fH\u0007J\u001c\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00042\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0007J\u001c\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00042\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0007J\u001c\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00042\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0007J\u001c\u0010 \u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00042\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0007J\u0018\u0010!\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0004H\u0007J\"\u0010!\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0007J\u001c\u0010\"\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00042\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0007J\u001c\u0010#\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00042\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0013\u0010\u0002\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011¨\u0006$"}, d2 = {"Lcom/onesignal/debug/internal/logging/Logging;", "", "()V", "TAG", "", "applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "getApplicationService", "()Lcom/onesignal/core/internal/application/IApplicationService;", "setApplicationService", "(Lcom/onesignal/core/internal/application/IApplicationService;)V", "logLevel", "Lcom/onesignal/debug/LogLevel;", "getLogLevel$annotations", "getLogLevel", "()Lcom/onesignal/debug/LogLevel;", "setLogLevel", "(Lcom/onesignal/debug/LogLevel;)V", "visualLogLevel", "getVisualLogLevel$annotations", "getVisualLogLevel", "setVisualLogLevel", "atLogLevel", "", "level", "debug", "", "message", "throwable", "", "error", "fatal", "info", "log", "verbose", "warn", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Logging.kt */
public final class Logging {
    public static final Logging INSTANCE = new Logging();
    private static final String TAG = "OneSignal";
    private static IApplicationService applicationService;
    private static LogLevel logLevel = LogLevel.WARN;
    private static LogLevel visualLogLevel = LogLevel.NONE;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Logging.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LogLevel.values().length];
            iArr[LogLevel.VERBOSE.ordinal()] = 1;
            iArr[LogLevel.DEBUG.ordinal()] = 2;
            iArr[LogLevel.INFO.ordinal()] = 3;
            iArr[LogLevel.WARN.ordinal()] = 4;
            iArr[LogLevel.ERROR.ordinal()] = 5;
            iArr[LogLevel.FATAL.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final LogLevel getLogLevel() {
        return logLevel;
    }

    @JvmStatic
    public static /* synthetic */ void getLogLevel$annotations() {
    }

    public static final LogLevel getVisualLogLevel() {
        return visualLogLevel;
    }

    @JvmStatic
    public static /* synthetic */ void getVisualLogLevel$annotations() {
    }

    public static final void setLogLevel(LogLevel logLevel2) {
        Intrinsics.checkNotNullParameter(logLevel2, "<set-?>");
        logLevel = logLevel2;
    }

    public static final void setVisualLogLevel(LogLevel logLevel2) {
        Intrinsics.checkNotNullParameter(logLevel2, "<set-?>");
        visualLogLevel = logLevel2;
    }

    public final IApplicationService getApplicationService() {
        return applicationService;
    }

    public final void setApplicationService(IApplicationService iApplicationService) {
        applicationService = iApplicationService;
    }

    private Logging() {
    }

    @JvmStatic
    public static final boolean atLogLevel(LogLevel logLevel2) {
        Intrinsics.checkNotNullParameter(logLevel2, "level");
        return logLevel2.compareTo(visualLogLevel) < 1 || logLevel2.compareTo(logLevel) < 1;
    }

    public static /* synthetic */ void verbose$default(String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        verbose(str, th);
    }

    @JvmStatic
    public static final void verbose(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE);
        log(LogLevel.VERBOSE, str, th);
    }

    public static /* synthetic */ void debug$default(String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        debug(str, th);
    }

    @JvmStatic
    public static final void debug(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE);
        log(LogLevel.DEBUG, str, th);
    }

    public static /* synthetic */ void info$default(String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        info(str, th);
    }

    @JvmStatic
    public static final void info(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE);
        log(LogLevel.INFO, str, th);
    }

    public static /* synthetic */ void warn$default(String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        warn(str, th);
    }

    @JvmStatic
    public static final void warn(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE);
        log(LogLevel.WARN, str, th);
    }

    public static /* synthetic */ void error$default(String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        error(str, th);
    }

    @JvmStatic
    public static final void error(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE);
        log(LogLevel.ERROR, str, th);
    }

    public static /* synthetic */ void fatal$default(String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        fatal(str, th);
    }

    @JvmStatic
    public static final void fatal(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE);
        log(LogLevel.FATAL, str, th);
    }

    @JvmStatic
    public static final void log(LogLevel logLevel2, String str) {
        Intrinsics.checkNotNullParameter(logLevel2, "level");
        Intrinsics.checkNotNullParameter(str, OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE);
        log(logLevel2, str, (Throwable) null);
    }

    @JvmStatic
    public static final void log(LogLevel logLevel2, String str, Throwable th) {
        Intrinsics.checkNotNullParameter(logLevel2, "level");
        Intrinsics.checkNotNullParameter(str, OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE);
        String str2 = "[" + Thread.currentThread().getName() + "] " + str;
        if (logLevel2.compareTo(logLevel) < 1) {
            switch (WhenMappings.$EnumSwitchMapping$0[logLevel2.ordinal()]) {
                case 1:
                    Log.v("OneSignal", str2, th);
                    break;
                case 2:
                    Log.d("OneSignal", str2, th);
                    break;
                case 3:
                    Log.i("OneSignal", str2, th);
                    break;
                case 4:
                    Log.w("OneSignal", str2, th);
                    break;
                case 5:
                case 6:
                    Log.e("OneSignal", str, th);
                    break;
            }
        }
        if (logLevel2.compareTo(visualLogLevel) < 1) {
            IApplicationService iApplicationService = applicationService;
            if ((iApplicationService != null ? iApplicationService.getCurrent() : null) != null) {
                try {
                    String trimIndent = StringsKt.trimIndent(str + 10);
                    if (th != null) {
                        StringWriter stringWriter = new StringWriter();
                        th.printStackTrace(new PrintWriter(stringWriter));
                        trimIndent = (trimIndent + th.getMessage()) + stringWriter;
                    }
                    ThreadUtilsKt.suspendifyOnMain(new Logging$log$1(logLevel2, trimIndent, (Continuation<? super Logging$log$1>) null));
                } catch (Throwable th2) {
                    Log.e("OneSignal", "Error showing logging message.", th2);
                }
            }
        }
    }
}
