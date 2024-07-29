package com.onesignal.debug.internal;

import com.onesignal.debug.IDebugManager;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.logging.Logging;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048V@VX\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048V@VX\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/onesignal/debug/internal/DebugManager;", "Lcom/onesignal/debug/IDebugManager;", "()V", "value", "Lcom/onesignal/debug/LogLevel;", "alertLevel", "getAlertLevel", "()Lcom/onesignal/debug/LogLevel;", "setAlertLevel", "(Lcom/onesignal/debug/LogLevel;)V", "logLevel", "getLogLevel", "setLogLevel", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: DebugManager.kt */
public final class DebugManager implements IDebugManager {
    public DebugManager() {
        setLogLevel(LogLevel.WARN);
        setAlertLevel(LogLevel.NONE);
    }

    public LogLevel getLogLevel() {
        return Logging.getLogLevel();
    }

    public void setLogLevel(LogLevel logLevel) {
        Intrinsics.checkNotNullParameter(logLevel, "value");
        Logging.setLogLevel(logLevel);
    }

    public LogLevel getAlertLevel() {
        return Logging.getVisualLogLevel();
    }

    public void setAlertLevel(LogLevel logLevel) {
        Intrinsics.checkNotNullParameter(logLevel, "value");
        Logging.setVisualLogLevel(logLevel);
    }
}
