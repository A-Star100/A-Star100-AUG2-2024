package com.polidea.rxandroidble2.internal;

import android.util.Log;
import com.polidea.rxandroidble2.LogOptions;
import com.polidea.rxandroidble2.internal.logger.LoggerSetup;
import com.polidea.rxandroidble2.internal.logger.LoggerUtil;
import com.polidea.rxandroidble2.internal.logger.LoggerUtilBluetoothServices;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RxBleLog {
    private static final Pattern ANONYMOUS_CLASS = Pattern.compile("\\$\\d+$");
    @Deprecated
    public static final int DEBUG = 3;
    @Deprecated
    public static final int ERROR = 6;
    @Deprecated
    public static final int INFO = 4;
    private static final LogOptions.Logger LOGCAT_LOGGER;
    private static final ThreadLocal<String> NEXT_TAG = new ThreadLocal<>();
    @Deprecated
    public static final int NONE = Integer.MAX_VALUE;
    @Deprecated
    public static final int VERBOSE = 2;
    @Deprecated
    public static final int WARN = 5;
    private static LoggerSetup loggerSetup;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LogLevel {
    }

    public interface Logger {
        void log(int i, String str, String str2);
    }

    static {
        AnonymousClass1 r7 = new LogOptions.Logger() {
            public void log(int i, String str, String str2) {
                Log.println(i, str, str2);
            }
        };
        LOGCAT_LOGGER = r7;
        loggerSetup = new LoggerSetup(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, false, true, r7);
    }

    private RxBleLog() {
    }

    @Deprecated
    public static void setLogger(final Logger logger) {
        updateLogOptions(new LogOptions.Builder().setLogger(logger == null ? LOGCAT_LOGGER : new LogOptions.Logger() {
            public void log(int i, String str, String str2) {
                Logger.this.log(i, str, str2);
            }
        }).build());
    }

    @Deprecated
    public static void setLogLevel(int i) {
        updateLogOptions(new LogOptions.Builder().setLogLevel(Integer.valueOf(i)).build());
    }

    public static void updateLogOptions(LogOptions logOptions) {
        LoggerSetup loggerSetup2 = loggerSetup;
        LoggerSetup merge = loggerSetup2.merge(logOptions);
        d("Received new options (%s) and merged with old setup: %s. New setup: %s", logOptions, loggerSetup2, merge);
        loggerSetup = merge;
    }

    private static String createTag() {
        String str;
        ThreadLocal<String> threadLocal = NEXT_TAG;
        String str2 = threadLocal.get();
        if (str2 != null) {
            threadLocal.remove();
            return str2;
        }
        List asList = Arrays.asList(new String[]{RxBleLog.class.getName(), LoggerUtil.class.getName(), LoggerUtilBluetoothServices.class.getName()});
        Throwable th = new Throwable();
        StackTraceElement[] stackTrace = th.getStackTrace();
        int i = 0;
        while (i < stackTrace.length && asList.contains(stackTrace[i].getClassName())) {
            i++;
        }
        if (stackTrace.length > i) {
            String className = stackTrace[i].getClassName();
            Matcher matcher = ANONYMOUS_CLASS.matcher(className);
            if (matcher.find()) {
                className = matcher.replaceAll("");
            }
            String replace = className.replace("Impl", "").replace("RxBle", "");
            int indexOf = replace.indexOf(36);
            if (indexOf <= 0) {
                str = replace.substring(replace.lastIndexOf(46) + 1);
            } else {
                str = replace.substring(replace.lastIndexOf(46) + 1, indexOf);
            }
            return "RxBle#" + str;
        }
        throw new IllegalStateException("Synthetic stacktrace didn't have enough elements: are you using proguard?", th);
    }

    private static String formatString(String str, Object... objArr) {
        return objArr.length == 0 ? str : String.format(str, objArr);
    }

    public static void v(String str, Object... objArr) {
        throwShade(2, (Throwable) null, str, objArr);
    }

    public static void v(Throwable th, String str, Object... objArr) {
        throwShade(2, th, str, objArr);
    }

    public static void d(String str, Object... objArr) {
        throwShade(3, (Throwable) null, str, objArr);
    }

    public static void d(Throwable th, String str, Object... objArr) {
        throwShade(3, th, str, objArr);
    }

    public static void i(String str, Object... objArr) {
        throwShade(4, (Throwable) null, str, objArr);
    }

    public static void i(Throwable th, String str, Object... objArr) {
        throwShade(4, th, str, objArr);
    }

    public static void w(String str, Object... objArr) {
        throwShade(5, (Throwable) null, str, objArr);
    }

    public static void w(Throwable th, String str, Object... objArr) {
        throwShade(5, th, str, objArr);
    }

    public static void e(String str, Object... objArr) {
        throwShade(6, (Throwable) null, str, objArr);
    }

    public static void e(Throwable th, String str, Object... objArr) {
        throwShade(6, th, str, objArr);
    }

    private static void throwShade(int i, Throwable th, String str, Object... objArr) {
        if (i >= loggerSetup.logLevel) {
            String formatString = formatString(str, objArr);
            if (formatString == null || formatString.length() == 0) {
                if (th != null) {
                    formatString = Log.getStackTraceString(th);
                } else {
                    return;
                }
            } else if (th != null) {
                formatString = formatString + "\n" + Log.getStackTraceString(th);
            }
            println(i, createTag(), formatString);
        }
    }

    private static void println(int i, String str, String str2) {
        if (str2.length() < 4000) {
            loggerSetup.logger.log(i, str, str2);
            return;
        }
        for (String log : str2.split("\n")) {
            loggerSetup.logger.log(i, str, log);
        }
    }

    public static boolean isAtLeast(int i) {
        return loggerSetup.logLevel <= i;
    }

    public static int getMacAddressLogSetting() {
        return loggerSetup.macAddressLogSetting;
    }

    public static int getUuidLogSetting() {
        return loggerSetup.uuidLogSetting;
    }

    public static boolean getShouldLogAttributeValues() {
        return loggerSetup.shouldLogAttributeValues;
    }

    public static boolean getShouldLogScannedPeripherals() {
        return loggerSetup.shouldLogScannedPeripherals;
    }
}
