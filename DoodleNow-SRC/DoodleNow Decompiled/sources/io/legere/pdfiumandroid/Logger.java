package io.legere.pdfiumandroid;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0001R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lio/legere/pdfiumandroid/Logger;", "Lio/legere/pdfiumandroid/LoggerInterface;", "()V", "logger", "d", "", "tag", "", "message", "e", "t", "", "setLogger", "pdfiumandroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: Logger.kt */
public final class Logger implements LoggerInterface {
    public static final Logger INSTANCE = new Logger();
    private static LoggerInterface logger;

    public final void setLogger(LoggerInterface loggerInterface) {
        Intrinsics.checkNotNullParameter(loggerInterface, "logger");
        logger = loggerInterface;
    }

    private Logger() {
    }

    public void d(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        LoggerInterface loggerInterface = logger;
        if (loggerInterface != null) {
            loggerInterface.d(str, str2);
        }
    }

    public void e(String str, Throwable th, String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        LoggerInterface loggerInterface = logger;
        if (loggerInterface != null) {
            loggerInterface.e(str, th, str2);
        }
    }
}
