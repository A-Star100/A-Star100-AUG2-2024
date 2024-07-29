package com.revenuecat.purchases.common.networking;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J#\u0010\u0003\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006H\u0000¢\u0006\u0002\b\bJ#\u0010\t\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006H\u0000¢\u0006\u0002\b\nJ4\u0010\u000b\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\f\u0018\u0001*\u0004\u0018\u00010\u00012\u0019\u0010\r\u001a\u0015\u0012\u0004\u0012\u0002H\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e¢\u0006\u0002\b\u000fH\b¨\u0006\u0010"}, d2 = {"Lcom/revenuecat/purchases/common/networking/MapConverter;", "", "()V", "convertToJSON", "Lorg/json/JSONObject;", "inputMap", "", "", "convertToJSON$purchases_defaultsRelease", "createJSONObject", "createJSONObject$purchases_defaultsRelease", "tryCast", "T", "ifSuccess", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: MapConverter.kt */
public final class MapConverter {
    public final JSONObject createJSONObject$purchases_defaultsRelease(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "inputMap");
        return new JSONObject(map);
    }

    private final /* synthetic */ <T> Object tryCast(Object obj, Function1<? super T, ? extends Object> function1) {
        Intrinsics.reifiedOperationMarker(3, "T");
        return obj instanceof Object ? function1.invoke(obj) : obj;
    }

    public final JSONObject convertToJSON$purchases_defaultsRelease(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "inputMap");
        Map linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof List) {
                Iterable iterable = (Iterable) value;
                if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                    Iterator it = iterable.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!(it.next() instanceof String)) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                value = new JSONObject(MapsKt.mapOf(TuplesKt.to("temp_key", new JSONArray((Collection) value)))).getJSONArray("temp_key");
            } else if (value instanceof Map) {
                value = convertToJSON$purchases_defaultsRelease((Map) value);
            }
            linkedHashMap.put(key, value);
        }
        return createJSONObject$purchases_defaultsRelease(linkedHashMap);
    }
}
