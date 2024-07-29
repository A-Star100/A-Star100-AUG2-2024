package io.legere.pdfiumandroid.util;

import io.legere.pdfiumandroid.DefaultLogger;
import io.legere.pdfiumandroid.LoggerInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lio/legere/pdfiumandroid/util/Config;", "", "logger", "Lio/legere/pdfiumandroid/LoggerInterface;", "alreadyClosedBehavior", "Lio/legere/pdfiumandroid/util/AlreadyClosedBehavior;", "(Lio/legere/pdfiumandroid/LoggerInterface;Lio/legere/pdfiumandroid/util/AlreadyClosedBehavior;)V", "getAlreadyClosedBehavior", "()Lio/legere/pdfiumandroid/util/AlreadyClosedBehavior;", "getLogger", "()Lio/legere/pdfiumandroid/LoggerInterface;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "pdfiumandroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: Config.kt */
public final class Config {
    private final AlreadyClosedBehavior alreadyClosedBehavior;
    private final LoggerInterface logger;

    public Config() {
        this((LoggerInterface) null, (AlreadyClosedBehavior) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Config copy$default(Config config, LoggerInterface loggerInterface, AlreadyClosedBehavior alreadyClosedBehavior2, int i, Object obj) {
        if ((i & 1) != 0) {
            loggerInterface = config.logger;
        }
        if ((i & 2) != 0) {
            alreadyClosedBehavior2 = config.alreadyClosedBehavior;
        }
        return config.copy(loggerInterface, alreadyClosedBehavior2);
    }

    public final LoggerInterface component1() {
        return this.logger;
    }

    public final AlreadyClosedBehavior component2() {
        return this.alreadyClosedBehavior;
    }

    public final Config copy(LoggerInterface loggerInterface, AlreadyClosedBehavior alreadyClosedBehavior2) {
        Intrinsics.checkNotNullParameter(loggerInterface, "logger");
        Intrinsics.checkNotNullParameter(alreadyClosedBehavior2, "alreadyClosedBehavior");
        return new Config(loggerInterface, alreadyClosedBehavior2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Config)) {
            return false;
        }
        Config config = (Config) obj;
        return Intrinsics.areEqual((Object) this.logger, (Object) config.logger) && this.alreadyClosedBehavior == config.alreadyClosedBehavior;
    }

    public final AlreadyClosedBehavior getAlreadyClosedBehavior() {
        return this.alreadyClosedBehavior;
    }

    public final LoggerInterface getLogger() {
        return this.logger;
    }

    public int hashCode() {
        return (this.logger.hashCode() * 31) + this.alreadyClosedBehavior.hashCode();
    }

    public String toString() {
        return "Config(logger=" + this.logger + ", alreadyClosedBehavior=" + this.alreadyClosedBehavior + ')';
    }

    public Config(LoggerInterface loggerInterface, AlreadyClosedBehavior alreadyClosedBehavior2) {
        Intrinsics.checkNotNullParameter(loggerInterface, "logger");
        Intrinsics.checkNotNullParameter(alreadyClosedBehavior2, "alreadyClosedBehavior");
        this.logger = loggerInterface;
        this.alreadyClosedBehavior = alreadyClosedBehavior2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Config(LoggerInterface loggerInterface, AlreadyClosedBehavior alreadyClosedBehavior2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new DefaultLogger() : loggerInterface, (i & 2) != 0 ? AlreadyClosedBehavior.EXCEPTION : alreadyClosedBehavior2);
    }
}
