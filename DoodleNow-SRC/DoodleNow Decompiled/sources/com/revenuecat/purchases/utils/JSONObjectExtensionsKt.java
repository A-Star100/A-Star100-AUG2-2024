package com.revenuecat.purchases.utils;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0004*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0000\u001a\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0016\u0010\b\u001a\u0004\u0018\u00010\u0004*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0000\u001a*\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u000b\u0018\u00010\n\"\u0004\b\u0000\u0010\u000b*\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\rH\u0000¨\u0006\u000e"}, d2 = {"getDate", "Ljava/util/Date;", "Lorg/json/JSONObject;", "jsonKey", "", "getNullableString", "name", "optDate", "optNullableString", "toMap", "", "T", "deep", "", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: JSONObjectExtensions.kt */
public final class JSONObjectExtensionsKt {
    public static final Date getDate(JSONObject jSONObject, String str) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(str, "jsonKey");
        Date parse = Iso8601Utils.parse(jSONObject.getString(str));
        Intrinsics.checkNotNullExpressionValue(parse, "parse(getString(jsonKey))");
        return parse;
    }

    public static final Date optDate(JSONObject jSONObject, String str) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(str, "jsonKey");
        if (jSONObject.isNull(str)) {
            jSONObject = null;
        }
        if (jSONObject != null) {
            return getDate(jSONObject, str);
        }
        return null;
    }

    public static final String getNullableString(JSONObject jSONObject, String str) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        if (jSONObject.isNull(str)) {
            jSONObject = null;
        }
        if (jSONObject != null) {
            return jSONObject.getString(str);
        }
        return null;
    }

    public static final String optNullableString(JSONObject jSONObject, String str) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        if (!jSONObject.has(str)) {
            jSONObject = null;
        }
        if (jSONObject != null) {
            return getNullableString(jSONObject, str);
        }
        return null;
    }

    public static /* synthetic */ Map toMap$default(JSONObject jSONObject, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return toMap(jSONObject, z);
    }

    public static final <T> Map<String, T> toMap(JSONObject jSONObject, boolean z) {
        Sequence<T> asSequence;
        Sequence<R> map;
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Iterator<String> keys = jSONObject.keys();
        if (keys == null || (asSequence = SequencesKt.asSequence(keys)) == null || (map = SequencesKt.map(asSequence, new JSONObjectExtensionsKt$toMap$1(z, jSONObject))) == null) {
            return null;
        }
        return MapsKt.toMap(map);
    }
}
