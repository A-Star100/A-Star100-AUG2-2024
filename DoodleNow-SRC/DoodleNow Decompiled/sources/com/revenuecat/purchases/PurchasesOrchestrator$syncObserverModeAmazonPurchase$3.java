package com.revenuecat.purchases;

import androidx.camera.video.AudioStats;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.ReceiptInfo;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.strings.PurchaseStrings;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "normalizedProductID", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: PurchasesOrchestrator.kt */
final class PurchasesOrchestrator$syncObserverModeAmazonPurchase$3 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ String $amazonUserID;
    final /* synthetic */ String $appUserID;
    final /* synthetic */ String $isoCurrencyCode;
    final /* synthetic */ Double $price;
    final /* synthetic */ String $receiptID;
    final /* synthetic */ PurchasesOrchestrator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PurchasesOrchestrator$syncObserverModeAmazonPurchase$3(Double d, String str, PurchasesOrchestrator purchasesOrchestrator, String str2, String str3, String str4) {
        super(1);
        this.$price = d;
        this.$isoCurrencyCode = str;
        this.this$0 = purchasesOrchestrator;
        this.$receiptID = str2;
        this.$amazonUserID = str3;
        this.$appUserID = str4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "normalizedProductID");
        List listOf = CollectionsKt.listOf(str);
        Double d = this.$price;
        Double d2 = (d == null || d.doubleValue() == AudioStats.AUDIO_AMPLITUDE_NONE) ? null : d;
        String str2 = this.$isoCurrencyCode;
        ReceiptInfo receiptInfo = new ReceiptInfo(listOf, (PresentedOfferingContext) null, (String) null, (StoreProduct) null, d2, (str2 == null || StringsKt.isBlank(str2)) ? null : str2, (ReplacementMode) null, 78, (DefaultConstructorMarker) null);
        PostReceiptHelper access$getPostReceiptHelper$p = this.this$0.postReceiptHelper;
        String str3 = this.$receiptID;
        String str4 = this.$amazonUserID;
        boolean allowSharingPlayStoreAccount = this.this$0.getAllowSharingPlayStoreAccount();
        String str5 = this.$appUserID;
        PostReceiptInitiationSource postReceiptInitiationSource = PostReceiptInitiationSource.RESTORE;
        final String str6 = this.$receiptID;
        final String str7 = this.$amazonUserID;
        final String str8 = this.$receiptID;
        final String str9 = this.$amazonUserID;
        access$getPostReceiptHelper$p.postTokenWithoutConsuming(str3, str4, receiptInfo, allowSharingPlayStoreAccount, str5, (String) null, postReceiptInitiationSource, new Function1<CustomerInfo, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((CustomerInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(CustomerInfo customerInfo) {
                Intrinsics.checkNotNullParameter(customerInfo, "it");
                String format = String.format(PurchaseStrings.PURCHASE_SYNCED_USER_ID, Arrays.copyOf(new Object[]{str6, str7}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                LogWrapperKt.log(LogIntent.PURCHASE, format);
            }
        }, new Function1<PurchasesError, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PurchasesError) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(PurchasesError purchasesError) {
                Intrinsics.checkNotNullParameter(purchasesError, "error");
                String format = String.format(PurchaseStrings.SYNCING_PURCHASE_ERROR_DETAILS_USER_ID, Arrays.copyOf(new Object[]{str8, str9, purchasesError}, 3));
                Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                LogWrapperKt.log(LogIntent.RC_ERROR, format);
            }
        });
    }
}
