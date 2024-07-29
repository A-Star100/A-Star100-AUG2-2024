package com.revenuecat.purchases.subscriberattributes;

import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.strings.AttributionStrings;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SubscriberAttributesManager.kt */
final class SubscriberAttributesManager$synchronizeSubscriberAttributesForAllUsers$1$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0<Unit> $completion;
    final /* synthetic */ String $currentAppUserID;
    final /* synthetic */ Ref.IntRef $currentSyncedAttributeCount;
    final /* synthetic */ String $syncingAppUserID;
    final /* synthetic */ Map<String, SubscriberAttribute> $unsyncedAttributesForUser;
    final /* synthetic */ int $unsyncedStoredAttributesCount;
    final /* synthetic */ SubscriberAttributesManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriberAttributesManager$synchronizeSubscriberAttributesForAllUsers$1$1$1(SubscriberAttributesManager subscriberAttributesManager, String str, Map<String, SubscriberAttribute> map, String str2, Ref.IntRef intRef, Function0<Unit> function0, int i) {
        super(0);
        this.this$0 = subscriberAttributesManager;
        this.$syncingAppUserID = str;
        this.$unsyncedAttributesForUser = map;
        this.$currentAppUserID = str2;
        this.$currentSyncedAttributeCount = intRef;
        this.$completion = function0;
        this.$unsyncedStoredAttributesCount = i;
    }

    public final void invoke() {
        this.this$0.markAsSynced(this.$syncingAppUserID, this.$unsyncedAttributesForUser, CollectionsKt.emptyList());
        LogIntent logIntent = LogIntent.RC_SUCCESS;
        String format = String.format(AttributionStrings.ATTRIBUTES_SYNC_SUCCESS, Arrays.copyOf(new Object[]{this.$syncingAppUserID}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        if (!Intrinsics.areEqual((Object) this.$currentAppUserID, (Object) this.$syncingAppUserID)) {
            this.this$0.getDeviceCache().clearSubscriberAttributesIfSyncedForSubscriber(this.$syncingAppUserID);
        }
        this.$currentSyncedAttributeCount.element++;
        if (this.$completion != null && this.$currentSyncedAttributeCount.element == this.$unsyncedStoredAttributesCount) {
            this.$completion.invoke();
        }
    }
}
