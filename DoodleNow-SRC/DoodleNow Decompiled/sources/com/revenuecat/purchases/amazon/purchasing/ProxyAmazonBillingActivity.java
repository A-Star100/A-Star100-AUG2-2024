package com.revenuecat.purchases.amazon.purchasing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.revenuecat.purchases.amazon.PurchasingServiceProvider;
import com.revenuecat.purchases.api.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\u000bH\u0014R&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/revenuecat/purchases/amazon/purchasing/ProxyAmazonBillingActivity;", "Landroid/app/Activity;", "()V", "proxyAmazonBillingDelegate", "Lcom/revenuecat/purchases/amazon/purchasing/ProxyAmazonBillingDelegate;", "getProxyAmazonBillingDelegate$purchases_defaultsRelease$annotations", "getProxyAmazonBillingDelegate$purchases_defaultsRelease", "()Lcom/revenuecat/purchases/amazon/purchasing/ProxyAmazonBillingDelegate;", "setProxyAmazonBillingDelegate$purchases_defaultsRelease", "(Lcom/revenuecat/purchases/amazon/purchasing/ProxyAmazonBillingDelegate;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ProxyAmazonBillingActivity.kt */
public final class ProxyAmazonBillingActivity extends Activity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRAS_PURCHASING_SERVICE_PROVIDER = "purchasing_service_provider";
    public static final String EXTRAS_REQUEST_ID = "request_id";
    public static final String EXTRAS_RESULT_RECEIVER = "result_receiver";
    public static final String EXTRAS_SKU = "sku";
    private ProxyAmazonBillingDelegate proxyAmazonBillingDelegate;

    public static /* synthetic */ void getProxyAmazonBillingDelegate$purchases_defaultsRelease$annotations() {
    }

    public final ProxyAmazonBillingDelegate getProxyAmazonBillingDelegate$purchases_defaultsRelease() {
        return this.proxyAmazonBillingDelegate;
    }

    public final void setProxyAmazonBillingDelegate$purchases_defaultsRelease(ProxyAmazonBillingDelegate proxyAmazonBillingDelegate2) {
        this.proxyAmazonBillingDelegate = proxyAmazonBillingDelegate2;
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/amazon/purchasing/ProxyAmazonBillingActivity$Companion;", "", "()V", "EXTRAS_PURCHASING_SERVICE_PROVIDER", "", "EXTRAS_REQUEST_ID", "EXTRAS_RESULT_RECEIVER", "EXTRAS_SKU", "newStartIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "resultReceiver", "Landroid/os/ResultReceiver;", "sku", "purchasingServiceProvider", "Lcom/revenuecat/purchases/amazon/PurchasingServiceProvider;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ProxyAmazonBillingActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Intent newStartIntent(Context context, ResultReceiver resultReceiver, String str, PurchasingServiceProvider purchasingServiceProvider) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(resultReceiver, "resultReceiver");
            Intrinsics.checkNotNullParameter(str, "sku");
            Intrinsics.checkNotNullParameter(purchasingServiceProvider, "purchasingServiceProvider");
            Intent intent = new Intent(context, ProxyAmazonBillingActivity.class);
            intent.putExtra(ProxyAmazonBillingActivity.EXTRAS_RESULT_RECEIVER, resultReceiver);
            intent.putExtra("sku", str);
            intent.putExtra(ProxyAmazonBillingActivity.EXTRAS_PURCHASING_SERVICE_PROVIDER, purchasingServiceProvider);
            return intent;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        setTheme(R.style.ProxyAmazonBillingActivityTheme);
        super.onCreate(bundle);
        ProxyAmazonBillingDelegate proxyAmazonBillingDelegate2 = new ProxyAmazonBillingDelegate();
        this.proxyAmazonBillingDelegate = proxyAmazonBillingDelegate2;
        proxyAmazonBillingDelegate2.onCreate(this, bundle);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        ProxyAmazonBillingDelegate proxyAmazonBillingDelegate2 = this.proxyAmazonBillingDelegate;
        if (proxyAmazonBillingDelegate2 != null) {
            proxyAmazonBillingDelegate2.onDestroy(this);
        }
        this.proxyAmazonBillingDelegate = null;
    }
}
