package com.revenuecat.purchases.subscriberattributes;

import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.SubscriberAttributeError;
import com.revenuecat.purchases.strings.AttributionStrings;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "error", "Lcom/revenuecat/purchases/PurchasesError;", "didBackendGetAttributes", "", "attributeErrors", "", "Lcom/revenuecat/purchases/common/SubscriberAttributeError;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SubscriberAttributesManager.kt */
final class SubscriberAttributesManager$synchronizeSubscriberAttributesForAllUsers$1$1$2 extends Lambda implements Function3<PurchasesError, Boolean, List<? extends SubscriberAttributeError>, Unit> {
    final /* synthetic */ Function0<Unit> $completion;
    final /* synthetic */ Ref.IntRef $currentSyncedAttributeCount;
    final /* synthetic */ String $syncingAppUserID;
    final /* synthetic */ Map<String, SubscriberAttribute> $unsyncedAttributesForUser;
    final /* synthetic */ int $unsyncedStoredAttributesCount;
    final /* synthetic */ SubscriberAttributesManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriberAttributesManager$synchronizeSubscriberAttributesForAllUsers$1$1$2(SubscriberAttributesManager subscriberAttributesManager, String str, Map<String, SubscriberAttribute> map, Ref.IntRef intRef, Function0<Unit> function0, int i) {
        super(3);
        this.this$0 = subscriberAttributesManager;
        this.$syncingAppUserID = str;
        this.$unsyncedAttributesForUser = map;
        this.$currentSyncedAttributeCount = intRef;
        this.$completion = function0;
        this.$unsyncedStoredAttributesCount = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((PurchasesError) obj, ((Boolean) obj2).booleanValue(), (List<SubscriberAttributeError>) (List) obj3);
        return Unit.INSTANCE;
    }

    public final void invoke(PurchasesError purchasesError, boolean z, List<SubscriberAttributeError> list) {
        Intrinsics.checkNotNullParameter(purchasesError, "error");
        Intrinsics.checkNotNullParameter(list, "attributeErrors");
        if (z) {
            this.this$0.markAsSynced(this.$syncingAppUserID, this.$unsyncedAttributesForUser, list);
        }
        LogIntent logIntent = LogIntent.RC_ERROR;
        String format = String.format(AttributionStrings.ATTRIBUTES_SYNC_ERROR, Arrays.copyOf(new Object[]{this.$syncingAppUserID, purchasesError}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.$currentSyncedAttributeCount.element++;
        if (this.$completion != null && this.$currentSyncedAttributeCount.element == this.$unsyncedStoredAttributesCount) {
            this.$completion.invoke();
        }
    }
}
