package com.revenuecat.purchases;

import android.os.Handler;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingResult;
import com.revenuecat.purchases.google.BillingResultExtensionsKt;
import com.revenuecat.purchases.interfaces.Callback;
import com.revenuecat.purchases.models.BillingFeature;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/revenuecat/purchases/PurchasesOrchestrator$Companion$canMakePayments$2$1", "Lcom/android/billingclient/api/BillingClientStateListener;", "onBillingServiceDisconnected", "", "onBillingSetupFinished", "billingResult", "Lcom/android/billingclient/api/BillingResult;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PurchasesOrchestrator.kt */
public final class PurchasesOrchestrator$Companion$canMakePayments$2$1 implements BillingClientStateListener {
    final /* synthetic */ BillingClient $billingClient;
    final /* synthetic */ Callback<Boolean> $callback;
    final /* synthetic */ List<BillingFeature> $features;
    final /* synthetic */ Handler $mainHandler;

    PurchasesOrchestrator$Companion$canMakePayments$2$1(Handler handler, Callback<Boolean> callback, BillingClient billingClient, List<? extends BillingFeature> list) {
        this.$mainHandler = handler;
        this.$callback = callback;
        this.$billingClient = billingClient;
        this.$features = list;
    }

    public void onBillingSetupFinished(BillingResult billingResult) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        this.$mainHandler.post(new PurchasesOrchestrator$Companion$canMakePayments$2$1$$ExternalSyntheticLambda1(billingResult, this.$callback, this.$billingClient, this.$features));
    }

    /* access modifiers changed from: private */
    public static final void onBillingSetupFinished$lambda$1(BillingResult billingResult, Callback callback, BillingClient billingClient, List list) {
        Intrinsics.checkNotNullParameter(billingResult, "$billingResult");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(billingClient, "$billingClient");
        Intrinsics.checkNotNullParameter(list, "$features");
        try {
            if (!BillingResultExtensionsKt.isSuccessful(billingResult)) {
                callback.onReceived(false);
                billingClient.endConnection();
                return;
            }
            Iterable iterable = list;
            boolean z = true;
            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                Iterator it = iterable.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    BillingResult isFeatureSupported = billingClient.isFeatureSupported(((BillingFeature) it.next()).getPlayBillingClientName());
                    Intrinsics.checkNotNullExpressionValue(isFeatureSupported, "billingClient.isFeatureS…it.playBillingClientName)");
                    if (!BillingResultExtensionsKt.isSuccessful(isFeatureSupported)) {
                        z = false;
                        break;
                    }
                }
            }
            billingClient.endConnection();
            callback.onReceived(Boolean.valueOf(z));
        } catch (IllegalArgumentException unused) {
            callback.onReceived(false);
        }
    }

    public void onBillingServiceDisconnected() {
        this.$mainHandler.post(new PurchasesOrchestrator$Companion$canMakePayments$2$1$$ExternalSyntheticLambda0(this.$billingClient, this.$callback));
    }

    /* access modifiers changed from: private */
    public static final void onBillingServiceDisconnected$lambda$2(BillingClient billingClient, Callback callback) {
        Intrinsics.checkNotNullParameter(billingClient, "$billingClient");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        try {
            billingClient.endConnection();
        } catch (IllegalArgumentException unused) {
        } catch (Throwable th) {
            callback.onReceived(false);
            throw th;
        }
        callback.onReceived(false);
    }
}
