package com.onesignal.common;

import android.os.Bundle;
import com.onesignal.debug.internal.logging.Logging;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001a\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\u0004J\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00112\u0006\u0010\u0012\u001a\u00020\u0006J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00142\u0006\u0010\u0015\u001a\u00020\fJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0017\u001a\u00020\u0001J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0006J\u0010\u0010\u001a\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/onesignal/common/JSONUtils;", "", "()V", "EXTERNAL_USER_ID", "", "bundleAsJSONObject", "Lorg/json/JSONObject;", "bundle", "Landroid/os/Bundle;", "compareJSONArrays", "", "jsonArray1", "Lorg/json/JSONArray;", "jsonArray2", "jsonStringToBundle", "data", "newStringMapFromJSONObject", "", "jsonObject", "newStringSetFromJSONArray", "", "jsonArray", "normalizeType", "object", "toUnescapedEUIDString", "json", "wrapInJsonArray", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: JSONUtils.kt */
public final class JSONUtils {
    public static final String EXTERNAL_USER_ID = "external_user_id";
    public static final JSONUtils INSTANCE = new JSONUtils();

    private JSONUtils() {
    }

    public final JSONArray wrapInJsonArray(JSONObject jSONObject) {
        JSONArray put = new JSONArray().put(jSONObject);
        Intrinsics.checkNotNullExpressionValue(put, "JSONArray().put(jsonObject)");
        return put;
    }

    public final JSONObject bundleAsJSONObject(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            try {
                jSONObject.put(str, bundle.get(str));
            } catch (JSONException e) {
                Logging.error("bundleAsJSONObject error for key: " + str, e);
            }
        }
        return jSONObject;
    }

    public final Bundle jsonStringToBundle(String str) {
        Intrinsics.checkNotNullParameter(str, "data");
        try {
            JSONObject jSONObject = new JSONObject(str);
            Bundle bundle = new Bundle();
            Iterator<String> keys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "jsonObject.keys()");
            while (keys.hasNext()) {
                String next = keys.next();
                Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
                String str2 = next;
                bundle.putString(str2, jSONObject.getString(str2));
            }
            return bundle;
        } catch (JSONException e) {
            e.printStackTrace();
            Bundle bundle2 = null;
            return null;
        }
    }

    public final Map<String, String> newStringMapFromJSONObject(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Iterator<String> keys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "jsonObject.keys()");
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                Object opt = jSONObject.opt(next);
                if (!(opt instanceof JSONArray)) {
                    if (!(opt instanceof JSONObject)) {
                        if (!jSONObject.isNull(next)) {
                            if (!Intrinsics.areEqual((Object) "", opt)) {
                                linkedHashMap.put(next, opt.toString());
                            }
                        }
                        linkedHashMap.put(next, "");
                    }
                }
                Logging.error$default("Omitting key '" + next + "'! sendTags DO NOT supported nested values!", (Throwable) null, 2, (Object) null);
            } catch (Throwable unused) {
            }
        }
        return linkedHashMap;
    }

    public final Set<String> newStringSetFromJSONArray(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "jsonArray");
        Set<String> linkedHashSet = new LinkedHashSet<>();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            String string = jSONArray.getString(i);
            Intrinsics.checkNotNullExpressionValue(string, "jsonArray.getString(i)");
            linkedHashSet.add(string);
        }
        return linkedHashSet;
    }

    public final String toUnescapedEUIDString(JSONObject jSONObject) {
        String group;
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
        if (!jSONObject.has(EXTERNAL_USER_ID)) {
            return jSONObject2;
        }
        Matcher matcher = Pattern.compile("(?<=\"external_user_id\":\").*?(?=\")").matcher(jSONObject2);
        if (!matcher.find() || (group = matcher.group(0)) == null) {
            return jSONObject2;
        }
        String replaceAll = matcher.replaceAll(Matcher.quoteReplacement(StringsKt.replace$default(group, "\\/", "/", false, 4, (Object) null)));
        Intrinsics.checkNotNullExpressionValue(replaceAll, "eidMatcher.replaceAll(unescapedEID)");
        return replaceAll;
    }

    public final boolean compareJSONArrays(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        if (jSONArray == null || jSONArray2 == null || jSONArray.length() != jSONArray2.length()) {
            return false;
        }
        try {
            int length = jSONArray.length();
            int i = 0;
            while (i < length) {
                int length2 = jSONArray2.length();
                int i2 = 0;
                while (i2 < length2) {
                    Object obj = jSONArray.get(i);
                    Intrinsics.checkNotNullExpressionValue(obj, "jsonArray1[i]");
                    Object normalizeType = normalizeType(obj);
                    Object obj2 = jSONArray2.get(i2);
                    Intrinsics.checkNotNullExpressionValue(obj2, "jsonArray2[j]");
                    if (!Intrinsics.areEqual(normalizeType, normalizeType(obj2))) {
                        i2++;
                    } else {
                        i++;
                    }
                }
                return false;
            }
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    public final Object normalizeType(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "object");
        Class<?> cls = obj.getClass();
        if (Intrinsics.areEqual((Object) cls, (Object) Integer.TYPE)) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        return Intrinsics.areEqual((Object) cls, (Object) Float.TYPE) ? Double.valueOf((double) ((Float) obj).floatValue()) : obj;
    }
}
