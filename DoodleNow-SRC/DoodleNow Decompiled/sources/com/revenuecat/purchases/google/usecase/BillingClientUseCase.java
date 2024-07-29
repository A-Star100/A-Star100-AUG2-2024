package com.revenuecat.purchases.google.usecase;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.google.BillingResponse;
import com.revenuecat.purchases.google.BillingResultExtensionsKt;
import com.revenuecat.purchases.google.ErrorsKt;
import com.revenuecat.purchases.strings.BillingStrings;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002Bo\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\t\u0012H\u0010\n\u001aD\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012!\u0012\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\b0\u000bj\u0002`\u0010¢\u0006\u0002\u0010\u0011J$\u0010 \u001a\u00020\b2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\"\u001a\u00020!H\u0002J$\u0010#\u001a\u00020\b2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\"\u001a\u00020!H\u0002J\b\u0010$\u001a\u00020\bH&J\u0010\u0010%\u001a\u00020\b2\u0006\u0010\"\u001a\u00020!H\u0002J\b\u0010&\u001a\u00020\u0017H\u0002J\u0015\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00028\u0000H&¢\u0006\u0002\u0010)JG\u0010*\u001a\u00020\b2\u0006\u0010\"\u001a\u00020!2\u0006\u0010+\u001a\u00028\u00002\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u00062\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\u0010-J\b\u0010.\u001a\u00020\bH\u0002J\u0010\u0010/\u001a\u00020\b2\b\b\u0002\u00100\u001a\u00020\fJ'\u00101\u001a\u00020\b*\u0004\u0018\u0001022\u0017\u00103\u001a\u0013\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b4H\u0004R\u0014\u0010\u0012\u001a\u00020\u0013XD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019RS\u0010\n\u001aD\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012!\u0012\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\b0\u000bj\u0002`\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dXD¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/revenuecat/purchases/google/usecase/BillingClientUseCase;", "T", "", "useCaseParams", "Lcom/revenuecat/purchases/google/usecase/UseCaseParams;", "onError", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/PurchasesError;", "", "Lcom/revenuecat/purchases/PurchasesErrorCallback;", "executeRequestOnUIThread", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "delayInMillis", "Lcom/revenuecat/purchases/google/usecase/ExecuteRequestOnUIThreadFunction;", "(Lcom/revenuecat/purchases/google/usecase/UseCaseParams;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "backoffForNetworkErrors", "", "getBackoffForNetworkErrors", "()Z", "errorMessage", "", "getErrorMessage", "()Ljava/lang/String;", "getExecuteRequestOnUIThread", "()Lkotlin/jvm/functions/Function2;", "maxRetries", "", "retryAttempt", "retryBackoffMilliseconds", "backoffOrErrorIfUseInSession", "Lcom/android/billingclient/api/BillingResult;", "billingResult", "backoffOrRetryNetworkError", "executeAsync", "forwardError", "getStackTrace", "onOk", "received", "(Ljava/lang/Object;)V", "processResult", "response", "onSuccess", "(Lcom/android/billingclient/api/BillingResult;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "retryWithBackoff", "run", "delayMilliseconds", "withConnectedClient", "Lcom/android/billingclient/api/BillingClient;", "receivingFunction", "Lkotlin/ExtensionFunctionType;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: BillingClientUseCase.kt */
public abstract class BillingClientUseCase<T> {
    private final boolean backoffForNetworkErrors;
    private final Function2<Long, Function1<? super PurchasesError, Unit>, Unit> executeRequestOnUIThread;
    private final int maxRetries = 3;
    /* access modifiers changed from: private */
    public final Function1<PurchasesError, Unit> onError;
    private int retryAttempt;
    private long retryBackoffMilliseconds = 878;
    private final UseCaseParams useCaseParams;

    public abstract void executeAsync();

    /* access modifiers changed from: protected */
    public boolean getBackoffForNetworkErrors() {
        return this.backoffForNetworkErrors;
    }

    public abstract String getErrorMessage();

    public final Function2<Long, Function1<? super PurchasesError, Unit>, Unit> getExecuteRequestOnUIThread() {
        return this.executeRequestOnUIThread;
    }

    public abstract void onOk(T t);

    public BillingClientUseCase(UseCaseParams useCaseParams2, Function1<? super PurchasesError, Unit> function1, Function2<? super Long, ? super Function1<? super PurchasesError, Unit>, Unit> function2) {
        Intrinsics.checkNotNullParameter(useCaseParams2, "useCaseParams");
        Intrinsics.checkNotNullParameter(function1, "onError");
        Intrinsics.checkNotNullParameter(function2, "executeRequestOnUIThread");
        this.useCaseParams = useCaseParams2;
        this.onError = function1;
        this.executeRequestOnUIThread = function2;
    }

    public static /* synthetic */ void run$default(BillingClientUseCase billingClientUseCase, long j, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                j = 0;
            }
            billingClientUseCase.run(j);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: run");
    }

    public final void run(long j) {
        this.executeRequestOnUIThread.invoke(Long.valueOf(j), new BillingClientUseCase$run$1(this));
    }

    public static /* synthetic */ void processResult$default(BillingClientUseCase billingClientUseCase, BillingResult billingResult, Object obj, Function1 function1, Function1 function12, int i, Object obj2) {
        if (obj2 == null) {
            if ((i & 4) != 0) {
                function1 = new BillingClientUseCase$processResult$1(billingClientUseCase);
            }
            if ((i & 8) != 0) {
                function12 = new BillingClientUseCase$processResult$2(billingClientUseCase);
            }
            billingClientUseCase.processResult(billingResult, obj, function1, function12);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: processResult");
    }

    public final void processResult(BillingResult billingResult, T t, Function1<? super T, Unit> function1, Function1<? super BillingResult, Unit> function12) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        Intrinsics.checkNotNullParameter(function1, "onSuccess");
        Intrinsics.checkNotNullParameter(function12, "onError");
        BillingResponse fromCode = BillingResponse.Companion.fromCode(billingResult.getResponseCode());
        if (Intrinsics.areEqual((Object) fromCode, (Object) BillingResponse.OK.INSTANCE)) {
            this.retryBackoffMilliseconds = 878;
            function1.invoke(t);
        } else if (Intrinsics.areEqual((Object) fromCode, (Object) BillingResponse.ServiceDisconnected.INSTANCE)) {
            LogWrapperKt.log(LogIntent.GOOGLE_ERROR, BillingStrings.BILLING_SERVICE_DISCONNECTED);
            run$default(this, 0, 1, (Object) null);
        } else if (Intrinsics.areEqual((Object) fromCode, (Object) BillingResponse.ServiceUnavailable.INSTANCE)) {
            backoffOrErrorIfUseInSession(function12, billingResult);
        } else if (!Intrinsics.areEqual((Object) fromCode, (Object) BillingResponse.NetworkError.INSTANCE) && !Intrinsics.areEqual((Object) fromCode, (Object) BillingResponse.Error.INSTANCE)) {
            function12.invoke(billingResult);
        } else {
            backoffOrRetryNetworkError(function12, billingResult);
        }
    }

    /* access modifiers changed from: protected */
    public final void withConnectedClient(BillingClient billingClient, Function1<? super BillingClient, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "receivingFunction");
        Unit unit = null;
        if (billingClient != null) {
            if (!billingClient.isReady()) {
                billingClient = null;
            }
            if (billingClient != null) {
                function1.invoke(billingClient);
                unit = Unit.INSTANCE;
            }
        }
        if (unit == null) {
            LogIntent logIntent = LogIntent.GOOGLE_WARNING;
            String format = String.format(BillingStrings.BILLING_CLIENT_DISCONNECTED, Arrays.copyOf(new Object[]{getStackTrace()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            LogWrapperKt.log(logIntent, format);
        }
    }

    private final String getStackTrace() {
        StringWriter stringWriter = new StringWriter();
        new Throwable().printStackTrace(new PrintWriter(stringWriter));
        String stringWriter2 = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(stringWriter2, "stringWriter.toString()");
        return stringWriter2;
    }

    /* access modifiers changed from: private */
    public final void forwardError(BillingResult billingResult) {
        String str = getErrorMessage() + " - " + BillingResultExtensionsKt.toHumanReadableDescription(billingResult);
        LogWrapperKt.log(LogIntent.GOOGLE_ERROR, str);
        Function1<PurchasesError, Unit> function1 = this.onError;
        PurchasesError billingResponseToPurchasesError = ErrorsKt.billingResponseToPurchasesError(billingResult.getResponseCode(), str);
        LogUtilsKt.errorLog(billingResponseToPurchasesError);
        function1.invoke(billingResponseToPurchasesError);
    }

    private final void backoffOrRetryNetworkError(Function1<? super BillingResult, Unit> function1, BillingResult billingResult) {
        int i;
        if (getBackoffForNetworkErrors() && this.retryBackoffMilliseconds < 900000) {
            retryWithBackoff();
        } else if (getBackoffForNetworkErrors() || (i = this.retryAttempt) >= this.maxRetries) {
            function1.invoke(billingResult);
        } else {
            this.retryAttempt = i + 1;
            executeAsync();
        }
    }

    private final void backoffOrErrorIfUseInSession(Function1<? super BillingResult, Unit> function1, BillingResult billingResult) {
        if (this.useCaseParams.getAppInBackground()) {
            LogWrapperKt.log(LogIntent.GOOGLE_WARNING, BillingStrings.BILLING_SERVICE_UNAVAILABLE_BACKGROUND);
            if (this.retryBackoffMilliseconds < 900000) {
                retryWithBackoff();
            } else {
                function1.invoke(billingResult);
            }
        } else {
            LogWrapperKt.log(LogIntent.GOOGLE_ERROR, BillingStrings.BILLING_SERVICE_UNAVAILABLE_FOREGROUND);
            function1.invoke(billingResult);
        }
    }

    private final void retryWithBackoff() {
        long j = this.retryBackoffMilliseconds;
        this.retryBackoffMilliseconds = Math.min(((long) 2) * j, 900000);
        run(j);
    }
}
