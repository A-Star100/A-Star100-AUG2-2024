package com.revenuecat.purchases.subscriberattributes;

import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.strings.AttributionStrings;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SubscriberAttributesManager.kt */
final class SubscriberAttributesManager$synchronizeSubscriberAttributesForAllUsers$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0<Unit> $completion;
    final /* synthetic */ String $currentAppUserID;
    final /* synthetic */ SubscriberAttributesManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriberAttributesManager$synchronizeSubscriberAttributesForAllUsers$1(SubscriberAttributesManager subscriberAttributesManager, Function0<Unit> function0, String str) {
        super(0);
        this.this$0 = subscriberAttributesManager;
        this.$completion = function0;
        this.$currentAppUserID = str;
    }

    public final void invoke() {
        Map<String, Map<String, SubscriberAttribute>> unsyncedSubscriberAttributes = this.this$0.getDeviceCache().getUnsyncedSubscriberAttributes();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : unsyncedSubscriberAttributes.entrySet()) {
            if (!StringsKt.isBlank((String) next.getKey())) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        Map map = linkedHashMap;
        if (map.isEmpty()) {
            LogWrapperKt.log(LogIntent.DEBUG, AttributionStrings.NO_SUBSCRIBER_ATTRIBUTES_TO_SYNCHRONIZE);
            Function0<Unit> function0 = this.$completion;
            if (function0 != null) {
                function0.invoke();
                return;
            }
            return;
        }
        int size = map.size();
        Ref.IntRef intRef = new Ref.IntRef();
        SubscriberAttributesManager subscriberAttributesManager = this.this$0;
        String str = this.$currentAppUserID;
        Function0<Unit> function02 = this.$completion;
        for (Map.Entry entry : map.entrySet()) {
            String str2 = (String) entry.getKey();
            Map map2 = (Map) entry.getValue();
            SubscriberAttributesManager subscriberAttributesManager2 = subscriberAttributesManager;
            String str3 = str2;
            Map map3 = map2;
            String str4 = str;
            subscriberAttributesManager.getBackend().postSubscriberAttributes(BackendHelpersKt.toBackendMap(map2), str2, new SubscriberAttributesManager$synchronizeSubscriberAttributesForAllUsers$1$1$1(subscriberAttributesManager2, str3, map3, str, intRef, function02, size), new SubscriberAttributesManager$synchronizeSubscriberAttributesForAllUsers$1$1$2(subscriberAttributesManager2, str3, map3, intRef, function02, size));
            str = str4;
        }
    }
}
