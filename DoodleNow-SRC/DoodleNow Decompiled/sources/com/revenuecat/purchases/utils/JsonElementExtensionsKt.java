package com.revenuecat.purchases.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\u001a\u001c\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006*\u00020\u0002H\u0000\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"extractedContent", "", "Lkotlinx/serialization/json/JsonElement;", "getExtractedContent", "(Lkotlinx/serialization/json/JsonElement;)Ljava/lang/Object;", "asMap", "", "", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: JsonElementExtensions.kt */
public final class JsonElementExtensionsKt {
    public static final Map<String, Object> asMap(JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "<this>");
        if (!(jsonElement instanceof JsonObject)) {
            return null;
        }
        Iterable<Map.Entry> entrySet = JsonElementKt.getJsonObject(jsonElement).entrySet();
        Map<String, Object> linkedHashMap = new LinkedHashMap<>(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(entrySet, 10)), 16));
        for (Map.Entry entry : entrySet) {
            Pair pair = TuplesKt.to(entry.getKey(), getExtractedContent((JsonElement) entry.getValue()));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    private static final Object getExtractedContent(JsonElement jsonElement) {
        Double d;
        if (jsonElement instanceof JsonPrimitive) {
            JsonPrimitive jsonPrimitive = JsonElementKt.getJsonPrimitive(jsonElement);
            if (jsonPrimitive.isString()) {
                return jsonPrimitive.getContent();
            }
            Boolean booleanOrNull = JsonElementKt.getBooleanOrNull(jsonPrimitive);
            d = booleanOrNull;
            if (booleanOrNull == null) {
                Integer intOrNull = JsonElementKt.getIntOrNull(jsonPrimitive);
                d = intOrNull;
                if (intOrNull == null) {
                    Long longOrNull = JsonElementKt.getLongOrNull(jsonPrimitive);
                    d = longOrNull;
                    if (longOrNull == null) {
                        Float floatOrNull = JsonElementKt.getFloatOrNull(jsonPrimitive);
                        d = floatOrNull;
                        if (floatOrNull == null) {
                            Double doubleOrNull = JsonElementKt.getDoubleOrNull(jsonPrimitive);
                            d = doubleOrNull;
                            if (doubleOrNull == null) {
                                return JsonElementKt.getContentOrNull(jsonPrimitive);
                            }
                        }
                    }
                }
            }
        } else if (jsonElement instanceof JsonArray) {
            Iterable<JsonElement> jsonArray = JsonElementKt.getJsonArray(jsonElement);
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonArray, 10));
            for (JsonElement extractedContent : jsonArray) {
                arrayList.add(getExtractedContent(extractedContent));
            }
            return (List) arrayList;
        } else if (!(jsonElement instanceof JsonObject)) {
            return null;
        } else {
            Iterable<Map.Entry> entrySet = JsonElementKt.getJsonObject(jsonElement).entrySet();
            Map linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(entrySet, 10)), 16));
            for (Map.Entry entry : entrySet) {
                Pair pair = TuplesKt.to(entry.getKey(), getExtractedContent((JsonElement) entry.getValue()));
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            d = linkedHashMap;
        }
        return d;
    }
}
