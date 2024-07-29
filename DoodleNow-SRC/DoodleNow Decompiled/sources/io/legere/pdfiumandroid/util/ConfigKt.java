package io.legere.pdfiumandroid.util;

import io.legere.pdfiumandroid.LoggerInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007\"\u001a\u0010\u0000\u001a\u00020\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"pdfiumConfig", "Lio/legere/pdfiumandroid/util/Config;", "getPdfiumConfig", "()Lio/legere/pdfiumandroid/util/Config;", "setPdfiumConfig", "(Lio/legere/pdfiumandroid/util/Config;)V", "handleAlreadyClosed", "", "isClosed", "pdfiumandroid_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: Config.kt */
public final class ConfigKt {
    private static Config pdfiumConfig = new Config((LoggerInterface) null, (AlreadyClosedBehavior) null, 3, (DefaultConstructorMarker) null);

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: Config.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                io.legere.pdfiumandroid.util.AlreadyClosedBehavior[] r0 = io.legere.pdfiumandroid.util.AlreadyClosedBehavior.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                io.legere.pdfiumandroid.util.AlreadyClosedBehavior r1 = io.legere.pdfiumandroid.util.AlreadyClosedBehavior.EXCEPTION     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                io.legere.pdfiumandroid.util.AlreadyClosedBehavior r1 = io.legere.pdfiumandroid.util.AlreadyClosedBehavior.IGNORE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.legere.pdfiumandroid.util.ConfigKt.WhenMappings.<clinit>():void");
        }
    }

    public static final Config getPdfiumConfig() {
        return pdfiumConfig;
    }

    public static final void setPdfiumConfig(Config config) {
        Intrinsics.checkNotNullParameter(config, "<set-?>");
        pdfiumConfig = config;
    }

    public static final boolean handleAlreadyClosed(boolean z) {
        if (z) {
            int i = WhenMappings.$EnumSwitchMapping$0[pdfiumConfig.getAlreadyClosedBehavior().ordinal()];
            if (i == 1) {
                throw new IllegalStateException("Already closed".toString());
            } else if (i == 2) {
                pdfiumConfig.getLogger().d("PdfiumCore", "Already closed");
            }
        }
        return z;
    }
}
