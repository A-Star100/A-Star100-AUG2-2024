package com.revenuecat.purchases.google.usecase;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingConfig;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.strings.BillingStrings;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B°\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\b\u0012\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\bj\u0002`\f\u0012#\u0010\r\u001a\u001f\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\u000f\u0012\u0004\u0012\u00020\t0\b\u0012H\u0010\u0010\u001aD\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012!\u0012\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\t0\b¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\t0\u0011j\u0002`\u0016¢\u0006\u0002\u0010\u0017J\b\u0010\"\u001a\u00020\tH\u0016J\u0012\u0010#\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010\u0002H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR!\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\bj\u0002`\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR.\u0010\r\u001a\u001f\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\u000f\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001f¨\u0006%"}, d2 = {"Lcom/revenuecat/purchases/google/usecase/GetBillingConfigUseCase;", "Lcom/revenuecat/purchases/google/usecase/BillingClientUseCase;", "Lcom/android/billingclient/api/BillingConfig;", "useCaseParams", "Lcom/revenuecat/purchases/google/usecase/GetBillingConfigUseCaseParams;", "deviceCache", "Lcom/revenuecat/purchases/common/caching/DeviceCache;", "onReceive", "Lkotlin/Function1;", "", "onError", "Lcom/revenuecat/purchases/PurchasesError;", "Lcom/revenuecat/purchases/PurchasesErrorCallback;", "withConnectedClient", "Lcom/android/billingclient/api/BillingClient;", "Lkotlin/ExtensionFunctionType;", "executeRequestOnUIThread", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "delayInMillis", "Lcom/revenuecat/purchases/google/usecase/ExecuteRequestOnUIThreadFunction;", "(Lcom/revenuecat/purchases/google/usecase/GetBillingConfigUseCaseParams;Lcom/revenuecat/purchases/common/caching/DeviceCache;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "getDeviceCache", "()Lcom/revenuecat/purchases/common/caching/DeviceCache;", "errorMessage", "", "getErrorMessage", "()Ljava/lang/String;", "getOnError", "()Lkotlin/jvm/functions/Function1;", "getOnReceive", "getWithConnectedClient", "executeAsync", "onOk", "received", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: GetBillingConfigUseCase.kt */
public final class GetBillingConfigUseCase extends BillingClientUseCase<BillingConfig> {
    private final DeviceCache deviceCache;
    private final Function1<PurchasesError, Unit> onError;
    private final Function1<BillingConfig, Unit> onReceive;
    private final Function1<Function1<? super BillingClient, Unit>, Unit> withConnectedClient;

    public final DeviceCache getDeviceCache() {
        return this.deviceCache;
    }

    public String getErrorMessage() {
        return "Error getting billing config";
    }

    public final Function1<PurchasesError, Unit> getOnError() {
        return this.onError;
    }

    public final Function1<BillingConfig, Unit> getOnReceive() {
        return this.onReceive;
    }

    public final Function1<Function1<? super BillingClient, Unit>, Unit> getWithConnectedClient() {
        return this.withConnectedClient;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetBillingConfigUseCase(GetBillingConfigUseCaseParams getBillingConfigUseCaseParams, DeviceCache deviceCache2, Function1<? super BillingConfig, Unit> function1, Function1<? super PurchasesError, Unit> function12, Function1<? super Function1<? super BillingClient, Unit>, Unit> function13, Function2<? super Long, ? super Function1<? super PurchasesError, Unit>, Unit> function2) {
        super(getBillingConfigUseCaseParams, function12, function2);
        Intrinsics.checkNotNullParameter(getBillingConfigUseCaseParams, "useCaseParams");
        Intrinsics.checkNotNullParameter(deviceCache2, "deviceCache");
        Intrinsics.checkNotNullParameter(function1, "onReceive");
        Intrinsics.checkNotNullParameter(function12, "onError");
        Intrinsics.checkNotNullParameter(function13, "withConnectedClient");
        Intrinsics.checkNotNullParameter(function2, "executeRequestOnUIThread");
        this.deviceCache = deviceCache2;
        this.onReceive = function1;
        this.onError = function12;
        this.withConnectedClient = function13;
    }

    public void executeAsync() {
        this.withConnectedClient.invoke(new GetBillingConfigUseCase$executeAsync$1(this));
    }

    public void onOk(BillingConfig billingConfig) {
        if (billingConfig == null) {
            this.onError.invoke(new PurchasesError(PurchasesErrorCode.StoreProblemError, BillingStrings.BILLING_CONFIG_NULL_ON_SUCCESS));
            return;
        }
        DeviceCache deviceCache2 = this.deviceCache;
        String countryCode = billingConfig.getCountryCode();
        Intrinsics.checkNotNullExpressionValue(countryCode, "received.countryCode");
        deviceCache2.setStorefront(countryCode);
        this.onReceive.invoke(billingConfig);
    }
}
