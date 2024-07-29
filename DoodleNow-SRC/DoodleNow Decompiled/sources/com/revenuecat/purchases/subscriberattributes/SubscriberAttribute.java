package com.revenuecat.purchases.subscriberattributes;

import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.subscriberattributes.SpecialSubscriberAttributesKt;
import com.revenuecat.purchases.common.subscriberattributes.SubscriberAttributeKey;
import java.util.Date;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B7\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB\u000f\b\u0016\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eB5\u0012\u0006\u0010\u0002\u001a\u00020\u000f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u0010J\t\u0010\u001a\u001a\u00020\u000fHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J=\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u000f2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010 \u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\"\u001a\u00020#H\u0016J\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010%J\u0006\u0010&\u001a\u00020\rJ\b\u0010'\u001a\u00020\u0003H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006("}, d2 = {"Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttribute;", "", "key", "", "value", "dateProvider", "Lcom/revenuecat/purchases/common/DateProvider;", "setTime", "Ljava/util/Date;", "isSynced", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/common/DateProvider;Ljava/util/Date;Z)V", "jsonObject", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey;", "(Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey;Ljava/lang/String;Lcom/revenuecat/purchases/common/DateProvider;Ljava/util/Date;Z)V", "getDateProvider", "()Lcom/revenuecat/purchases/common/DateProvider;", "()Z", "getKey", "()Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey;", "getSetTime", "()Ljava/util/Date;", "getValue", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toBackendMap", "", "toJSONObject", "toString", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SubscriberAttribute.kt */
public final class SubscriberAttribute {
    private final DateProvider dateProvider;
    private final boolean isSynced;
    private final SubscriberAttributeKey key;
    private final Date setTime;
    private final String value;

    public static /* synthetic */ SubscriberAttribute copy$default(SubscriberAttribute subscriberAttribute, SubscriberAttributeKey subscriberAttributeKey, String str, DateProvider dateProvider2, Date date, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            subscriberAttributeKey = subscriberAttribute.key;
        }
        if ((i & 2) != 0) {
            str = subscriberAttribute.value;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            dateProvider2 = subscriberAttribute.dateProvider;
        }
        DateProvider dateProvider3 = dateProvider2;
        if ((i & 8) != 0) {
            date = subscriberAttribute.setTime;
        }
        Date date2 = date;
        if ((i & 16) != 0) {
            z = subscriberAttribute.isSynced;
        }
        return subscriberAttribute.copy(subscriberAttributeKey, str2, dateProvider3, date2, z);
    }

    public final SubscriberAttributeKey component1() {
        return this.key;
    }

    public final String component2() {
        return this.value;
    }

    public final DateProvider component3() {
        return this.dateProvider;
    }

    public final Date component4() {
        return this.setTime;
    }

    public final boolean component5() {
        return this.isSynced;
    }

    public final SubscriberAttribute copy(SubscriberAttributeKey subscriberAttributeKey, String str, DateProvider dateProvider2, Date date, boolean z) {
        Intrinsics.checkNotNullParameter(subscriberAttributeKey, SubscriberAttributeKt.JSON_NAME_KEY);
        Intrinsics.checkNotNullParameter(dateProvider2, "dateProvider");
        Intrinsics.checkNotNullParameter(date, "setTime");
        return new SubscriberAttribute(subscriberAttributeKey, str, dateProvider2, date, z);
    }

    public final DateProvider getDateProvider() {
        return this.dateProvider;
    }

    public final SubscriberAttributeKey getKey() {
        return this.key;
    }

    public final Date getSetTime() {
        return this.setTime;
    }

    public final String getValue() {
        return this.value;
    }

    public final boolean isSynced() {
        return this.isSynced;
    }

    public SubscriberAttribute(SubscriberAttributeKey subscriberAttributeKey, String str, DateProvider dateProvider2, Date date, boolean z) {
        Intrinsics.checkNotNullParameter(subscriberAttributeKey, SubscriberAttributeKt.JSON_NAME_KEY);
        Intrinsics.checkNotNullParameter(dateProvider2, "dateProvider");
        Intrinsics.checkNotNullParameter(date, "setTime");
        this.key = subscriberAttributeKey;
        this.value = str;
        this.dateProvider = dateProvider2;
        this.setTime = date;
        this.isSynced = z;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SubscriberAttribute(com.revenuecat.purchases.common.subscriberattributes.SubscriberAttributeKey r7, java.lang.String r8, com.revenuecat.purchases.common.DateProvider r9, java.util.Date r10, boolean r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r6 = this;
            r13 = r12 & 4
            if (r13 == 0) goto L_0x000b
            com.revenuecat.purchases.common.DefaultDateProvider r9 = new com.revenuecat.purchases.common.DefaultDateProvider
            r9.<init>()
            com.revenuecat.purchases.common.DateProvider r9 = (com.revenuecat.purchases.common.DateProvider) r9
        L_0x000b:
            r3 = r9
            r9 = r12 & 8
            if (r9 == 0) goto L_0x0014
            java.util.Date r10 = r3.getNow()
        L_0x0014:
            r4 = r10
            r9 = r12 & 16
            if (r9 == 0) goto L_0x001a
            r11 = 0
        L_0x001a:
            r5 = r11
            r0 = r6
            r1 = r7
            r2 = r8
            r0.<init>((com.revenuecat.purchases.common.subscriberattributes.SubscriberAttributeKey) r1, (java.lang.String) r2, (com.revenuecat.purchases.common.DateProvider) r3, (java.util.Date) r4, (boolean) r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.subscriberattributes.SubscriberAttribute.<init>(com.revenuecat.purchases.common.subscriberattributes.SubscriberAttributeKey, java.lang.String, com.revenuecat.purchases.common.DateProvider, java.util.Date, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SubscriberAttribute(java.lang.String r7, java.lang.String r8, com.revenuecat.purchases.common.DateProvider r9, java.util.Date r10, boolean r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r6 = this;
            r13 = r12 & 4
            if (r13 == 0) goto L_0x000b
            com.revenuecat.purchases.common.DefaultDateProvider r9 = new com.revenuecat.purchases.common.DefaultDateProvider
            r9.<init>()
            com.revenuecat.purchases.common.DateProvider r9 = (com.revenuecat.purchases.common.DateProvider) r9
        L_0x000b:
            r3 = r9
            r9 = r12 & 8
            if (r9 == 0) goto L_0x0014
            java.util.Date r10 = r3.getNow()
        L_0x0014:
            r4 = r10
            r9 = r12 & 16
            if (r9 == 0) goto L_0x001a
            r11 = 0
        L_0x001a:
            r5 = r11
            r0 = r6
            r1 = r7
            r2 = r8
            r0.<init>((java.lang.String) r1, (java.lang.String) r2, (com.revenuecat.purchases.common.DateProvider) r3, (java.util.Date) r4, (boolean) r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.subscriberattributes.SubscriberAttribute.<init>(java.lang.String, java.lang.String, com.revenuecat.purchases.common.DateProvider, java.util.Date, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SubscriberAttribute(String str, String str2, DateProvider dateProvider2, Date date, boolean z) {
        this(SpecialSubscriberAttributesKt.getSubscriberAttributeKey(str), str2, (DateProvider) null, date, z, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, SubscriberAttributeKt.JSON_NAME_KEY);
        Intrinsics.checkNotNullParameter(dateProvider2, "dateProvider");
        Intrinsics.checkNotNullParameter(date, "setTime");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SubscriberAttribute(org.json.JSONObject r11) throws org.json.JSONException {
        /*
            r10 = this;
            java.lang.String r0 = "jsonObject"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "key"
            java.lang.String r0 = r11.getString(r0)
            java.lang.String r1 = "jsonObject.getString(JSON_NAME_KEY)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            com.revenuecat.purchases.common.subscriberattributes.SubscriberAttributeKey r3 = com.revenuecat.purchases.common.subscriberattributes.SpecialSubscriberAttributesKt.getSubscriberAttributeKey(r0)
            java.lang.String r0 = "value"
            java.lang.String r4 = com.revenuecat.purchases.utils.JSONObjectExtensionsKt.getNullableString(r11, r0)
            r5 = 0
            java.util.Date r6 = new java.util.Date
            java.lang.String r0 = "set_time"
            long r0 = r11.getLong(r0)
            r6.<init>(r0)
            java.lang.String r0 = "is_synced"
            boolean r7 = r11.getBoolean(r0)
            r8 = 4
            r9 = 0
            r2 = r10
            r2.<init>((com.revenuecat.purchases.common.subscriberattributes.SubscriberAttributeKey) r3, (java.lang.String) r4, (com.revenuecat.purchases.common.DateProvider) r5, (java.util.Date) r6, (boolean) r7, (int) r8, (kotlin.jvm.internal.DefaultConstructorMarker) r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.subscriberattributes.SubscriberAttribute.<init>(org.json.JSONObject):void");
    }

    public final JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(SubscriberAttributeKt.JSON_NAME_KEY, this.key.getBackendKey());
        String str = this.value;
        if (str == null || jSONObject.put("value", str) == null) {
            jSONObject.put("value", JSONObject.NULL);
        }
        jSONObject.put(SubscriberAttributeKt.JSON_NAME_SET_TIME, this.setTime.getTime());
        jSONObject.put(SubscriberAttributeKt.JSON_NAME_IS_SYNCED, this.isSynced);
        return jSONObject;
    }

    public final Map<String, Object> toBackendMap() {
        return MapsKt.mapOf(TuplesKt.to("value", this.value), TuplesKt.to(SubscriberAttributeKt.BACKEND_NAME_TIMESTAMP, Long.valueOf(this.setTime.getTime())));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.revenuecat.purchases.subscriberattributes.SubscriberAttribute");
        SubscriberAttribute subscriberAttribute = (SubscriberAttribute) obj;
        return Intrinsics.areEqual((Object) this.key, (Object) subscriberAttribute.key) && Intrinsics.areEqual((Object) this.value, (Object) subscriberAttribute.value) && Intrinsics.areEqual((Object) this.setTime, (Object) subscriberAttribute.setTime) && this.isSynced == subscriberAttribute.isSynced;
    }

    public int hashCode() {
        int hashCode = this.key.hashCode() * 31;
        String str = this.value;
        return ((((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.setTime.hashCode()) * 31) + UByte$$ExternalSyntheticBackport0.m(this.isSynced);
    }

    public String toString() {
        return "SubscriberAttribute(key=" + this.key + ", value=" + this.value + ", setTime=" + this.setTime + ", isSynced=" + this.isSynced + ')';
    }
}
