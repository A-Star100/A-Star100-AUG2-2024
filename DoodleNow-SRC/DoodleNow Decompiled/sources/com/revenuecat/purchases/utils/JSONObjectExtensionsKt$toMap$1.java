package com.revenuecat.purchases.utils;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0010\u0000\u001a\u0016\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0012\u0004\u0012\u0002H\u00040\u0001\"\u0004\b\u0000\u0010\u00042\u000e\u0010\u0005\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "kotlin.jvm.PlatformType", "T", "jsonKey", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: JSONObjectExtensions.kt */
final class JSONObjectExtensionsKt$toMap$1 extends Lambda implements Function1<String, Pair<? extends String, ? extends T>> {
    final /* synthetic */ boolean $deep;
    final /* synthetic */ JSONObject $this_toMap;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JSONObjectExtensionsKt$toMap$1(boolean z, JSONObject jSONObject) {
        super(1);
        this.$deep = z;
        this.$this_toMap = jSONObject;
    }

    public final Pair<String, T> invoke(String str) {
        if (!this.$deep) {
            return TuplesKt.to(str, this.$this_toMap.get(str));
        }
        Object obj = this.$this_toMap.get(str);
        if (obj instanceof JSONObject) {
            obj = JSONObjectExtensionsKt.toMap((JSONObject) obj, true);
        } else if (obj instanceof JSONArray) {
            obj = JSONArrayExtensionsKt.toList((JSONArray) obj);
        }
        return TuplesKt.to(str, obj);
    }
}
