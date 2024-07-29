package com.revenuecat.purchases.subscriberattributes;

import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.revenuecat.purchases.common.BackendKt;
import com.revenuecat.purchases.common.SubscriberAttributeError;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u0004\u0018\u00010\u0003H\u0000\u001a2\u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00050\u0005*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u0005H\u0000¨\u0006\t"}, d2 = {"getAttributeErrors", "", "Lcom/revenuecat/purchases/common/SubscriberAttributeError;", "Lorg/json/JSONObject;", "toBackendMap", "", "", "", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttribute;", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: backendHelpers.kt */
public final class BackendHelpersKt {
    public static final List<SubscriberAttributeError> getAttributeErrors(JSONObject jSONObject) {
        if (jSONObject == null) {
            return CollectionsKt.emptyList();
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(BackendKt.ATTRIBUTES_ERROR_RESPONSE_KEY);
        if (optJSONObject != null) {
            jSONObject = optJSONObject;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(BackendKt.ATTRIBUTE_ERRORS_KEY);
        if (optJSONArray != null) {
            Iterable until = RangesKt.until(0, optJSONArray.length());
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
            Iterator it = until.iterator();
            while (it.hasNext()) {
                arrayList.add(optJSONArray.getJSONObject(((IntIterator) it).nextInt()));
            }
            Collection arrayList2 = new ArrayList();
            for (Object next : (List) arrayList) {
                JSONObject jSONObject2 = (JSONObject) next;
                if (jSONObject2.has("key_name") && jSONObject2.has(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE)) {
                    arrayList2.add(next);
                }
            }
            Iterable<JSONObject> iterable = (List) arrayList2;
            Collection arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (JSONObject jSONObject3 : iterable) {
                String string = jSONObject3.getString("key_name");
                Intrinsics.checkNotNullExpressionValue(string, "it.getString(\"key_name\")");
                String string2 = jSONObject3.getString(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE);
                Intrinsics.checkNotNullExpressionValue(string2, "it.getString(\"message\")");
                arrayList3.add(new SubscriberAttributeError(string, string2));
            }
            List<SubscriberAttributeError> list = CollectionsKt.toList((List) arrayList3);
            if (list != null) {
                return list;
            }
        }
        return CollectionsKt.emptyList();
    }

    public static final Map<String, Map<String, Object>> toBackendMap(Map<String, SubscriberAttribute> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Collection arrayList = new ArrayList(map.size());
        for (Map.Entry next : map.entrySet()) {
            arrayList.add(TuplesKt.to((String) next.getKey(), ((SubscriberAttribute) next.getValue()).toBackendMap()));
        }
        return MapsKt.toMap((List) arrayList);
    }
}
