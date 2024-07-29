package com.revenuecat.purchases.react;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006H\u0002¢\u0006\u0002\u0010\u0007J\u001a\u0010\b\u001a\u00020\t2\u0010\u0010\n\u001a\f\u0012\u0004\u0012\u00020\f\u0012\u0002\b\u00030\u000bH\u0007J\u0010\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007¨\u0006\u0015"}, d2 = {"Lcom/revenuecat/purchases/react/RNPurchasesConverters;", "", "()V", "convertArrayToWritableArray", "Lcom/facebook/react/bridge/WritableArray;", "array", "", "([Ljava/lang/Object;)Lcom/facebook/react/bridge/WritableArray;", "convertMapToWriteableMap", "Lcom/facebook/react/bridge/WritableMap;", "map", "", "", "convertReadableArrayToJson", "Lorg/json/JSONArray;", "readableArray", "Lcom/facebook/react/bridge/ReadableArray;", "convertReadableMapToJson", "Lorg/json/JSONObject;", "readableMap", "Lcom/facebook/react/bridge/ReadableMap;", "react-native-purchases_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: RNPurchasesConverters.kt */
public final class RNPurchasesConverters {
    public static final RNPurchasesConverters INSTANCE = new RNPurchasesConverters();

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: RNPurchasesConverters.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|1|2|3|4|5|6|7|8|9|10|11|12|13|15) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.facebook.react.bridge.ReadableType[] r0 = com.facebook.react.bridge.ReadableType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Null     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Boolean     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Number     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.String     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Map     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Array     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.react.RNPurchasesConverters.WhenMappings.<clinit>():void");
        }
    }

    private RNPurchasesConverters() {
    }

    @JvmStatic
    public static final JSONObject convertReadableMapToJson(ReadableMap readableMap) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        Intrinsics.checkNotNull(readableMap);
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        Intrinsics.checkNotNullExpressionValue(keySetIterator, "keySetIterator(...)");
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            switch (WhenMappings.$EnumSwitchMapping$0[readableMap.getType(nextKey).ordinal()]) {
                case 1:
                    jSONObject.put(nextKey, JSONObject.NULL);
                    break;
                case 2:
                    jSONObject.put(nextKey, readableMap.getBoolean(nextKey));
                    break;
                case 3:
                    jSONObject.put(nextKey, readableMap.getDouble(nextKey));
                    break;
                case 4:
                    jSONObject.put(nextKey, readableMap.getString(nextKey));
                    break;
                case 5:
                    jSONObject.put(nextKey, convertReadableMapToJson(readableMap.getMap(nextKey)));
                    break;
                case 6:
                    jSONObject.put(nextKey, INSTANCE.convertReadableArrayToJson(readableMap.getArray(nextKey)));
                    break;
            }
        }
        return jSONObject;
    }

    public final JSONArray convertReadableArrayToJson(ReadableArray readableArray) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        Intrinsics.checkNotNull(readableArray);
        int size = readableArray.size();
        for (int i = 0; i < size; i++) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[readableArray.getType(i).ordinal()];
            if (i2 == 2) {
                jSONArray.put(readableArray.getBoolean(i));
            } else if (i2 == 3) {
                jSONArray.put(readableArray.getDouble(i));
            } else if (i2 == 4) {
                jSONArray.put(readableArray.getString(i));
            } else if (i2 == 5) {
                jSONArray.put(convertReadableMapToJson(readableArray.getMap(i)));
            } else if (i2 == 6) {
                jSONArray.put(convertReadableArrayToJson(readableArray.getArray(i)));
            }
        }
        return jSONArray;
    }

    private final WritableArray convertArrayToWritableArray(Object[] objArr) {
        WritableArray writableNativeArray = new WritableNativeArray();
        for (Boolean bool : objArr) {
            if (bool == null) {
                writableNativeArray.pushNull();
            } else if (bool instanceof Boolean) {
                writableNativeArray.pushBoolean(bool.booleanValue());
            } else if (bool instanceof Integer) {
                writableNativeArray.pushInt(((Number) bool).intValue());
            } else if (bool instanceof Long) {
                writableNativeArray.pushDouble((double) ((Number) bool).longValue());
            } else if (bool instanceof Double) {
                writableNativeArray.pushDouble(((Number) bool).doubleValue());
            } else if (bool instanceof String) {
                writableNativeArray.pushString((String) bool);
            } else if (bool instanceof Map) {
                Intrinsics.checkNotNull(bool, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, *>");
                writableNativeArray.pushMap(convertMapToWriteableMap((Map) bool));
            } else if (bool instanceof Object[]) {
                Intrinsics.checkNotNull(bool, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                writableNativeArray.pushArray(convertArrayToWritableArray((Object[]) bool));
            } else if (bool instanceof List) {
                writableNativeArray.pushArray(convertArrayToWritableArray(((Collection) bool).toArray(new Object[0])));
            }
        }
        return writableNativeArray;
    }

    @JvmStatic
    public static final WritableMap convertMapToWriteableMap(Map<String, ?> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        WritableMap writableNativeMap = new WritableNativeMap();
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            Object value = next.getValue();
            if (value == null) {
                writableNativeMap.putNull(str);
            } else if (value instanceof Boolean) {
                writableNativeMap.putBoolean(str, ((Boolean) value).booleanValue());
            } else if (value instanceof Integer) {
                writableNativeMap.putInt(str, ((Number) value).intValue());
            } else if (value instanceof Long) {
                writableNativeMap.putDouble(str, (double) ((Number) value).longValue());
            } else if (value instanceof Double) {
                writableNativeMap.putDouble(str, ((Number) value).doubleValue());
            } else if (value instanceof String) {
                writableNativeMap.putString(str, (String) value);
            } else if (value instanceof Map) {
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, *>");
                writableNativeMap.putMap(str, convertMapToWriteableMap((Map) value));
            } else if (value instanceof Object[]) {
                RNPurchasesConverters rNPurchasesConverters = INSTANCE;
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                writableNativeMap.putArray(str, rNPurchasesConverters.convertArrayToWritableArray((Object[]) value));
            } else if (value instanceof List) {
                writableNativeMap.putArray(str, INSTANCE.convertArrayToWritableArray(((Collection) value).toArray(new Object[0])));
            }
        }
        return writableNativeMap;
    }
}
