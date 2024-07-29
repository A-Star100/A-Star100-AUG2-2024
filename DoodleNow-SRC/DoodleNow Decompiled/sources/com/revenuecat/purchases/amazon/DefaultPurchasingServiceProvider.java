package com.revenuecat.purchases.amazon;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.amazon.a.a.o.b;
import com.amazon.device.iap.PurchasingListener;
import com.amazon.device.iap.PurchasingService;
import com.amazon.device.iap.model.FulfillmentResult;
import com.amazon.device.iap.model.RequestId;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\tH\u0016J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0019\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0004HÖ\u0001¨\u0006\u001e"}, d2 = {"Lcom/revenuecat/purchases/amazon/DefaultPurchasingServiceProvider;", "Lcom/revenuecat/purchases/amazon/PurchasingServiceProvider;", "()V", "describeContents", "", "getProductData", "Lcom/amazon/device/iap/model/RequestId;", "skus", "", "", "getPurchaseUpdates", "reset", "", "getUserData", "notifyFulfillment", "", "receiptId", "fulfillmentResult", "Lcom/amazon/device/iap/model/FulfillmentResult;", "purchase", "sku", "registerListener", "context", "Landroid/content/Context;", "listener", "Lcom/amazon/device/iap/PurchasingListener;", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: DefaultPurchasingServiceProvider.kt */
public final class DefaultPurchasingServiceProvider implements PurchasingServiceProvider {
    public static final Parcelable.Creator<DefaultPurchasingServiceProvider> CREATOR = new Creator();

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: DefaultPurchasingServiceProvider.kt */
    public static final class Creator implements Parcelable.Creator<DefaultPurchasingServiceProvider> {
        public final DefaultPurchasingServiceProvider createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.readInt();
            return new DefaultPurchasingServiceProvider();
        }

        public final DefaultPurchasingServiceProvider[] newArray(int i) {
            return new DefaultPurchasingServiceProvider[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(1);
    }

    public void registerListener(Context context, PurchasingListener purchasingListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(purchasingListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        PurchasingService.registerListener(context, purchasingListener);
    }

    public RequestId getUserData() {
        RequestId userData = PurchasingService.getUserData();
        Intrinsics.checkNotNullExpressionValue(userData, "getUserData()");
        return userData;
    }

    public RequestId purchase(String str) {
        Intrinsics.checkNotNullParameter(str, "sku");
        RequestId purchase = PurchasingService.purchase(str);
        Intrinsics.checkNotNullExpressionValue(purchase, "purchase(sku)");
        return purchase;
    }

    public RequestId getProductData(Set<String> set) {
        Intrinsics.checkNotNullParameter(set, b.O);
        RequestId productData = PurchasingService.getProductData(set);
        Intrinsics.checkNotNullExpressionValue(productData, "getProductData(skus)");
        return productData;
    }

    public RequestId getPurchaseUpdates(boolean z) {
        RequestId purchaseUpdates = PurchasingService.getPurchaseUpdates(z);
        Intrinsics.checkNotNullExpressionValue(purchaseUpdates, "getPurchaseUpdates(reset)");
        return purchaseUpdates;
    }

    public void notifyFulfillment(String str, FulfillmentResult fulfillmentResult) {
        Intrinsics.checkNotNullParameter(str, b.E);
        Intrinsics.checkNotNullParameter(fulfillmentResult, "fulfillmentResult");
        PurchasingService.notifyFulfillment(str, fulfillmentResult);
    }
}
