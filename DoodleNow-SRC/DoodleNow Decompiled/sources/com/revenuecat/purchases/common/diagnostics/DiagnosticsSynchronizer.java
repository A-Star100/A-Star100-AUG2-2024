package com.revenuecat.purchases.common.diagnostics;

import android.content.Context;
import android.content.SharedPreferences;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.Delay;
import com.revenuecat.purchases.common.Dispatcher;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0001\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0006\u0010\u0012\u001a\u00020\u0011J\u0016\u0010\u0013\u001a\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015H\u0002J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0011H\u0002J\u0006\u0010\u001c\u001a\u00020\u0011R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsSynchronizer;", "", "context", "Landroid/content/Context;", "diagnosticsFileHelper", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsFileHelper;", "diagnosticsTracker", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;", "backend", "Lcom/revenuecat/purchases/common/Backend;", "diagnosticsDispatcher", "Lcom/revenuecat/purchases/common/Dispatcher;", "sharedPreferences", "Lkotlin/Lazy;", "Landroid/content/SharedPreferences;", "(Landroid/content/Context;Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsFileHelper;Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;Lcom/revenuecat/purchases/common/Backend;Lcom/revenuecat/purchases/common/Dispatcher;Lkotlin/Lazy;)V", "clearConsecutiveNumberOfErrors", "", "clearDiagnosticsFileIfTooBig", "enqueue", "command", "Lkotlin/Function0;", "getEventsToSync", "", "Lorg/json/JSONObject;", "increaseConsecutiveNumberOfErrors", "", "resetDiagnosticsStatus", "syncDiagnosticsFileIfNeeded", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: DiagnosticsSynchronizer.kt */
public final class DiagnosticsSynchronizer {
    public static final String CONSECUTIVE_FAILURES_COUNT_KEY = "consecutive_failures_count";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long MAX_EVENTS_TO_SYNC_PER_REQUEST = 200;
    public static final int MAX_NUMBER_POST_RETRIES = 3;
    /* access modifiers changed from: private */
    public final Backend backend;
    private final Dispatcher diagnosticsDispatcher;
    /* access modifiers changed from: private */
    public final DiagnosticsFileHelper diagnosticsFileHelper;
    /* access modifiers changed from: private */
    public final DiagnosticsTracker diagnosticsTracker;
    private final Lazy<SharedPreferences> sharedPreferences;

    public DiagnosticsSynchronizer(Context context, DiagnosticsFileHelper diagnosticsFileHelper2, DiagnosticsTracker diagnosticsTracker2, Backend backend2, Dispatcher dispatcher, Lazy<? extends SharedPreferences> lazy) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(diagnosticsFileHelper2, "diagnosticsFileHelper");
        Intrinsics.checkNotNullParameter(diagnosticsTracker2, "diagnosticsTracker");
        Intrinsics.checkNotNullParameter(backend2, "backend");
        Intrinsics.checkNotNullParameter(dispatcher, "diagnosticsDispatcher");
        Intrinsics.checkNotNullParameter(lazy, "sharedPreferences");
        this.diagnosticsFileHelper = diagnosticsFileHelper2;
        this.diagnosticsTracker = diagnosticsTracker2;
        this.backend = backend2;
        this.diagnosticsDispatcher = dispatcher;
        this.sharedPreferences = lazy;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DiagnosticsSynchronizer(final Context context, DiagnosticsFileHelper diagnosticsFileHelper2, DiagnosticsTracker diagnosticsTracker2, Backend backend2, Dispatcher dispatcher, Lazy lazy, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, diagnosticsFileHelper2, diagnosticsTracker2, backend2, dispatcher, (i & 32) != 0 ? LazyKt.lazy(new Function0<SharedPreferences>() {
            public final SharedPreferences invoke() {
                return DiagnosticsSynchronizer.Companion.initializeSharedPreferences(context);
            }
        }) : lazy);
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u0016\u0010\u0003\u001a\u00020\u00048\u0006XT¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u0016\u0010\u0006\u001a\u00020\u00078\u0006XT¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0002R\u0016\u0010\t\u001a\u00020\n8\u0006XT¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0002¨\u0006\u0010"}, d2 = {"Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsSynchronizer$Companion;", "", "()V", "CONSECUTIVE_FAILURES_COUNT_KEY", "", "getCONSECUTIVE_FAILURES_COUNT_KEY$annotations", "MAX_EVENTS_TO_SYNC_PER_REQUEST", "", "getMAX_EVENTS_TO_SYNC_PER_REQUEST$annotations", "MAX_NUMBER_POST_RETRIES", "", "getMAX_NUMBER_POST_RETRIES$annotations", "initializeSharedPreferences", "Landroid/content/SharedPreferences;", "context", "Landroid/content/Context;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: DiagnosticsSynchronizer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getCONSECUTIVE_FAILURES_COUNT_KEY$annotations() {
        }

        public static /* synthetic */ void getMAX_EVENTS_TO_SYNC_PER_REQUEST$annotations() {
        }

        public static /* synthetic */ void getMAX_NUMBER_POST_RETRIES$annotations() {
        }

        private Companion() {
        }

        public final SharedPreferences initializeSharedPreferences(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            SharedPreferences sharedPreferences = context.getSharedPreferences("com_revenuecat_purchases_" + context.getPackageName() + "_preferences_diagnostics", 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…DE_PRIVATE,\n            )");
            return sharedPreferences;
        }
    }

    public final void clearDiagnosticsFileIfTooBig() {
        enqueue(new DiagnosticsSynchronizer$clearDiagnosticsFileIfTooBig$1(this));
    }

    public final void syncDiagnosticsFileIfNeeded() {
        enqueue(new DiagnosticsSynchronizer$syncDiagnosticsFileIfNeeded$1(this));
    }

    /* access modifiers changed from: private */
    public final List<JSONObject> getEventsToSync() {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = CollectionsKt.emptyList();
        this.diagnosticsFileHelper.readFileAsJson(new DiagnosticsSynchronizer$getEventsToSync$1(objectRef));
        return (List) objectRef.element;
    }

    private final void enqueue(Function0<Unit> function0) {
        Dispatcher.enqueue$default(this.diagnosticsDispatcher, new DiagnosticsSynchronizer$$ExternalSyntheticLambda0(function0), (Delay) null, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void enqueue$lambda$0(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$tmp0");
        function0.invoke();
    }

    /* access modifiers changed from: private */
    public final void clearConsecutiveNumberOfErrors() {
        this.sharedPreferences.getValue().edit().remove(CONSECUTIVE_FAILURES_COUNT_KEY).apply();
    }

    /* access modifiers changed from: private */
    public final int increaseConsecutiveNumberOfErrors() {
        int i = this.sharedPreferences.getValue().getInt(CONSECUTIVE_FAILURES_COUNT_KEY, 0) + 1;
        this.sharedPreferences.getValue().edit().putInt(CONSECUTIVE_FAILURES_COUNT_KEY, i).apply();
        return i;
    }

    /* access modifiers changed from: private */
    public final void resetDiagnosticsStatus() {
        clearConsecutiveNumberOfErrors();
        this.diagnosticsFileHelper.deleteFile();
    }
}
