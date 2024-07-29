package com.revenuecat.purchases.google.usecase;

import com.android.billingclient.api.BillingClient;
import com.revenuecat.purchases.PurchasesError;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B·\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\n0\u0006j\u0002`\r\u0012#\u0010\u000e\u001a\u001f\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n0\u0006¢\u0006\u0002\b\u0010\u0012\u0004\u0012\u00020\n0\u0006\u0012H\u0010\u0011\u001aD\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0014\u0012!\u0012\u001f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\n0\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\n0\u0012j\u0002`\u0015¢\u0006\u0002\u0010\u0016J\b\u0010\"\u001a\u00020\nH\u0016J\u0010\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u0002H\u0016R\u0014\u0010\u0017\u001a\u00020\u00188TX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR!\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\n0\u0006j\u0002`\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR,\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R.\u0010\u000e\u001a\u001f\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n0\u0006¢\u0006\u0002\b\u0010\u0012\u0004\u0012\u00020\n0\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001f¨\u0006%"}, d2 = {"Lcom/revenuecat/purchases/google/usecase/AcknowledgePurchaseUseCase;", "Lcom/revenuecat/purchases/google/usecase/BillingClientUseCase;", "", "useCaseParams", "Lcom/revenuecat/purchases/google/usecase/AcknowledgePurchaseUseCaseParams;", "onReceive", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "purchaseToken", "", "onError", "Lcom/revenuecat/purchases/PurchasesError;", "Lcom/revenuecat/purchases/PurchasesErrorCallback;", "withConnectedClient", "Lcom/android/billingclient/api/BillingClient;", "Lkotlin/ExtensionFunctionType;", "executeRequestOnUIThread", "Lkotlin/Function2;", "", "delayInMillis", "Lcom/revenuecat/purchases/google/usecase/ExecuteRequestOnUIThreadFunction;", "(Lcom/revenuecat/purchases/google/usecase/AcknowledgePurchaseUseCaseParams;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "backoffForNetworkErrors", "", "getBackoffForNetworkErrors", "()Z", "errorMessage", "getErrorMessage", "()Ljava/lang/String;", "getOnError", "()Lkotlin/jvm/functions/Function1;", "getOnReceive", "getWithConnectedClient", "executeAsync", "onOk", "received", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AcknowledgePurchaseUseCase.kt */
public final class AcknowledgePurchaseUseCase extends BillingClientUseCase<String> {
    private final Function1<PurchasesError, Unit> onError;
    private final Function1<String, Unit> onReceive;
    /* access modifiers changed from: private */
    public final AcknowledgePurchaseUseCaseParams useCaseParams;
    private final Function1<Function1<? super BillingClient, Unit>, Unit> withConnectedClient;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: AcknowledgePurchaseUseCase.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.revenuecat.purchases.PostReceiptInitiationSource[] r0 = com.revenuecat.purchases.PostReceiptInitiationSource.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.revenuecat.purchases.PostReceiptInitiationSource r1 = com.revenuecat.purchases.PostReceiptInitiationSource.RESTORE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.revenuecat.purchases.PostReceiptInitiationSource r1 = com.revenuecat.purchases.PostReceiptInitiationSource.PURCHASE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.revenuecat.purchases.PostReceiptInitiationSource r1 = com.revenuecat.purchases.PostReceiptInitiationSource.UNSYNCED_ACTIVE_PURCHASES     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.google.usecase.AcknowledgePurchaseUseCase.WhenMappings.<clinit>():void");
        }
    }

    public String getErrorMessage() {
        return "Error acknowledging purchase";
    }

    public final Function1<PurchasesError, Unit> getOnError() {
        return this.onError;
    }

    public final Function1<String, Unit> getOnReceive() {
        return this.onReceive;
    }

    public final Function1<Function1<? super BillingClient, Unit>, Unit> getWithConnectedClient() {
        return this.withConnectedClient;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AcknowledgePurchaseUseCase(AcknowledgePurchaseUseCaseParams acknowledgePurchaseUseCaseParams, Function1<? super String, Unit> function1, Function1<? super PurchasesError, Unit> function12, Function1<? super Function1<? super BillingClient, Unit>, Unit> function13, Function2<? super Long, ? super Function1<? super PurchasesError, Unit>, Unit> function2) {
        super(acknowledgePurchaseUseCaseParams, function12, function2);
        Intrinsics.checkNotNullParameter(acknowledgePurchaseUseCaseParams, "useCaseParams");
        Intrinsics.checkNotNullParameter(function1, "onReceive");
        Intrinsics.checkNotNullParameter(function12, "onError");
        Intrinsics.checkNotNullParameter(function13, "withConnectedClient");
        Intrinsics.checkNotNullParameter(function2, "executeRequestOnUIThread");
        this.useCaseParams = acknowledgePurchaseUseCaseParams;
        this.onReceive = function1;
        this.onError = function12;
        this.withConnectedClient = function13;
    }

    /* access modifiers changed from: protected */
    public boolean getBackoffForNetworkErrors() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.useCaseParams.getInitiationSource().ordinal()];
        if (i == 1 || i == 2) {
            return false;
        }
        if (i == 3) {
            return true;
        }
        throw new NoWhenBranchMatchedException();
    }

    public void executeAsync() {
        this.withConnectedClient.invoke(new AcknowledgePurchaseUseCase$executeAsync$1(this));
    }

    public void onOk(String str) {
        Intrinsics.checkNotNullParameter(str, "received");
        this.onReceive.invoke(str);
    }
}
