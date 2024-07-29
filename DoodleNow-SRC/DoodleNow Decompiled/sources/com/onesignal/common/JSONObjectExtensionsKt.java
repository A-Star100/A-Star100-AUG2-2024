package com.onesignal.common;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\u001aC\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052#\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\b\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0007\u001a5\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\b\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u000b0\u0007\u001aM\u0010\f\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00012#\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\u0004\u0012\u0004\b\b(\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007\u001a5\u0010\u0010\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\b\u0012\b\b\u0004\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u000b0\u0007\u001a*\u0010\u0012\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u0014\u001a \u0010\u0012\u001a\u00020\u0003*\u00020\u00032\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014\u001a\u001c\u0010\u0016\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0015\u001a\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u0019*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u001a\u001a\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u001c*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u001d\u001a\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u001f*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010 \u001a\u0014\u0010!\u001a\u0004\u0018\u00010\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0019\u0010\"\u001a\u0004\u0018\u00010#*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010$\u001a\u0014\u0010%\u001a\u0004\u0018\u00010\u0005*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0014\u0010&\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u0001*\u00020'\u001a\u0018\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00150)*\u00020\u0003¨\u0006*"}, d2 = {"expandJSONArray", "", "T", "Lorg/json/JSONObject;", "name", "", "into", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "childObject", "expandJSONObject", "", "putJSONArray", "list", "create", "item", "putJSONObject", "expand", "putMap", "map", "", "", "putSafe", "value", "safeBool", "", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Boolean;", "safeDouble", "", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Double;", "safeInt", "", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Integer;", "safeJSONObject", "safeLong", "", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Long;", "safeString", "toList", "Lorg/json/JSONArray;", "toMap", "", "com.onesignal.core"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: JSONObjectExtensions.kt */
public final class JSONObjectExtensionsKt {
    public static final Integer safeInt(JSONObject jSONObject, String str) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        if (jSONObject.has(str)) {
            return Integer.valueOf(jSONObject.getInt(str));
        }
        return null;
    }

    public static final Long safeLong(JSONObject jSONObject, String str) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        if (jSONObject.has(str)) {
            return Long.valueOf(jSONObject.getLong(str));
        }
        return null;
    }

    public static final Double safeDouble(JSONObject jSONObject, String str) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        if (jSONObject.has(str)) {
            return Double.valueOf(jSONObject.getDouble(str));
        }
        return null;
    }

    public static final Boolean safeBool(JSONObject jSONObject, String str) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        if (jSONObject.has(str)) {
            return Boolean.valueOf(jSONObject.getBoolean(str));
        }
        return null;
    }

    public static final String safeString(JSONObject jSONObject, String str) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        if (jSONObject.has(str)) {
            return jSONObject.getString(str);
        }
        return null;
    }

    public static final JSONObject safeJSONObject(JSONObject jSONObject, String str) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        if (jSONObject.has(str)) {
            return jSONObject.getJSONObject(str);
        }
        return null;
    }

    public static final Map<String, Object> toMap(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Map<String, Object> hashMap = new HashMap<>();
        Iterator<String> keys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "this.keys()");
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            Intrinsics.checkNotNullExpressionValue(next, SubscriberAttributeKt.JSON_NAME_KEY);
            if (JSONObject.NULL.equals(obj)) {
                obj = null;
            } else if (obj instanceof JSONObject) {
                obj = toMap((JSONObject) obj);
            } else if (obj instanceof JSONArray) {
                obj = toList((JSONArray) obj);
            }
            hashMap.put(next, obj);
        }
        return hashMap;
    }

    public static final List<Object> toList(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        int length = jSONArray.length();
        List<Object> arrayList = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            Object opt = jSONArray.opt(i);
            if (JSONObject.NULL.equals(opt)) {
                arrayList.add((Object) null);
            } else if (opt instanceof JSONArray) {
                arrayList.add(toList((JSONArray) opt));
            } else if (opt instanceof JSONObject) {
                arrayList.add(toMap((JSONObject) opt));
            } else {
                arrayList.add(opt);
            }
        }
        return arrayList;
    }

    public static final void expandJSONObject(JSONObject jSONObject, String str, Function1<? super JSONObject, Unit> function1) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function1, "into");
        if (jSONObject.has(str)) {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "this.getJSONObject(name)");
            function1.invoke(jSONObject2);
        }
    }

    public static final <T> List<T> expandJSONArray(JSONObject jSONObject, String str, Function1<? super JSONObject, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function1, "into");
        List<T> arrayList = new ArrayList<>();
        if (jSONObject.has(str)) {
            JSONArray jSONArray = jSONObject.getJSONArray(str);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "itemJSONObject");
                Object invoke = function1.invoke(jSONObject2);
                if (invoke != null) {
                    arrayList.add(invoke);
                }
            }
        }
        return arrayList;
    }

    public static final JSONObject putMap(JSONObject jSONObject, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(map, "map");
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            Object value = next.getValue();
            if (value == null) {
                value = JSONObject.NULL;
            }
            jSONObject.put(str, value);
        }
        return jSONObject;
    }

    public static final JSONObject putMap(JSONObject jSONObject, String str, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        if (map != null) {
            putJSONObject(jSONObject, str, new JSONObjectExtensionsKt$putMap$1(map));
        }
        return jSONObject;
    }

    public static final JSONObject putJSONObject(JSONObject jSONObject, String str, Function1<? super JSONObject, Unit> function1) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function1, "expand");
        JSONObject jSONObject2 = new JSONObject();
        function1.invoke(jSONObject2);
        jSONObject.put(str, jSONObject2);
        return jSONObject;
    }

    public static final <T> JSONObject putJSONArray(JSONObject jSONObject, String str, List<? extends T> list, Function1<? super T, ? extends JSONObject> function1) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function1, "create");
        if (list != null) {
            JSONArray jSONArray = new JSONArray();
            for (Object invoke : list) {
                JSONObject jSONObject2 = (JSONObject) function1.invoke(invoke);
                if (jSONObject2 != null) {
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put(str, jSONArray);
        }
        return jSONObject;
    }

    public static final JSONObject putSafe(JSONObject jSONObject, String str, Object obj) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        if (obj != null) {
            jSONObject.put(str, obj);
        }
        return jSONObject;
    }
}
