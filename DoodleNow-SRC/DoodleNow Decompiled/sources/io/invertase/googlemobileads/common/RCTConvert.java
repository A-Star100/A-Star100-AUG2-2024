package io.invertase.googlemobileads.common;

import android.util.Log;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

public class RCTConvert {
    private static String TAG = "RCTConvert";

    public static WritableMap mapPutValue(String str, @Nullable Object obj, WritableMap writableMap) {
        if (obj == null) {
            writableMap.putNull(str);
            return writableMap;
        }
        String name = obj.getClass().getName();
        name.hashCode();
        char c = 65535;
        switch (name.hashCode()) {
            case -2056817302:
                if (name.equals("java.lang.Integer")) {
                    c = 0;
                    break;
                }
                break;
            case -527879800:
                if (name.equals("java.lang.Float")) {
                    c = 1;
                    break;
                }
                break;
            case 344809556:
                if (name.equals("java.lang.Boolean")) {
                    c = 2;
                    break;
                }
                break;
            case 398795216:
                if (name.equals("java.lang.Long")) {
                    c = 3;
                    break;
                }
                break;
            case 761287205:
                if (name.equals("java.lang.Double")) {
                    c = 4;
                    break;
                }
                break;
            case 1195259493:
                if (name.equals("java.lang.String")) {
                    c = 5;
                    break;
                }
                break;
            case 1614941136:
                if (name.equals("org.json.JSONObject$1")) {
                    c = 6;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                writableMap.putInt(str, ((Integer) obj).intValue());
                break;
            case 1:
                writableMap.putDouble(str, (double) ((Float) obj).floatValue());
                break;
            case 2:
                writableMap.putBoolean(str, ((Boolean) obj).booleanValue());
                break;
            case 3:
                writableMap.putDouble(str, (double) ((Long) obj).longValue());
                break;
            case 4:
                writableMap.putDouble(str, ((Double) obj).doubleValue());
                break;
            case 5:
                writableMap.putString(str, (String) obj);
                break;
            case 6:
                writableMap.putString(str, obj.toString());
                break;
            default:
                if (!List.class.isAssignableFrom(obj.getClass())) {
                    if (!Map.class.isAssignableFrom(obj.getClass())) {
                        String str2 = TAG;
                        Log.d(str2, "utils:mapPutValue:unknownType:" + name);
                        writableMap.putNull(str);
                        break;
                    } else {
                        WritableMap createMap = Arguments.createMap();
                        for (Map.Entry entry : ((Map) obj).entrySet()) {
                            mapPutValue((String) entry.getKey(), entry.getValue(), createMap);
                        }
                        writableMap.putMap(str, createMap);
                        break;
                    }
                } else {
                    writableMap.putArray(str, Arguments.makeNativeArray((List) obj));
                    break;
                }
        }
        return writableMap;
    }

    public static WritableMap readableMapToWritableMap(ReadableMap readableMap) {
        WritableMap createMap = Arguments.createMap();
        createMap.merge(readableMap);
        return createMap;
    }

    public static Map<String, Object> toHashMap(ReadableMap readableMap) {
        return readableMap.toHashMap();
    }

    public static List<Object> toArrayList(ReadableArray readableArray) {
        return readableArray.toArrayList();
    }
}
