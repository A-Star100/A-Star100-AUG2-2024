package com.revenuecat.purchases.common.diagnostics;

import com.revenuecat.purchases.common.FileHelper;
import com.revenuecat.purchases.utils.EventsFileHelper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsFileHelper;", "Lcom/revenuecat/purchases/utils/EventsFileHelper;", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsEntry;", "fileHelper", "Lcom/revenuecat/purchases/common/FileHelper;", "(Lcom/revenuecat/purchases/common/FileHelper;)V", "isDiagnosticsFileTooBig", "", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: DiagnosticsFileHelper.kt */
public final class DiagnosticsFileHelper extends EventsFileHelper<DiagnosticsEntry> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int DIAGNOSTICS_FILE_LIMIT_IN_KB = 500;
    public static final String DIAGNOSTICS_FILE_PATH = "RevenueCat/diagnostics/diagnostic_entries.jsonl";
    private final FileHelper fileHelper;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsFileHelper$Companion;", "", "()V", "DIAGNOSTICS_FILE_LIMIT_IN_KB", "", "DIAGNOSTICS_FILE_PATH", "", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: DiagnosticsFileHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DiagnosticsFileHelper(FileHelper fileHelper2) {
        super(fileHelper2, DIAGNOSTICS_FILE_PATH, (Function1) null);
        Intrinsics.checkNotNullParameter(fileHelper2, "fileHelper");
        this.fileHelper = fileHelper2;
    }

    public final synchronized boolean isDiagnosticsFileTooBig() {
        return this.fileHelper.fileSizeInKB(DIAGNOSTICS_FILE_PATH) > 500.0d;
    }
}
