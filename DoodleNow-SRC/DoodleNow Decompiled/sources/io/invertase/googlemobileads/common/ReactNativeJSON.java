package io.invertase.googlemobileads.common;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import io.invertase.googlemobileads.BuildConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReactNativeJSON {
    private static ReactNativeJSON sharedInstance = new ReactNativeJSON();
    private JSONObject jsonObject;

    public static ReactNativeJSON getSharedInstance() {
        return sharedInstance;
    }

    public String getRawJSON() {
        return BuildConfig.GOOGLE_MOBILE_ADS_JSON_RAW;
    }

    private ReactNativeJSON() {
        try {
            this.jsonObject = new JSONObject(BuildConfig.GOOGLE_MOBILE_ADS_JSON_RAW);
        } catch (JSONException unused) {
        }
    }

    public boolean contains(String str) {
        JSONObject jSONObject = this.jsonObject;
        if (jSONObject == null) {
            return false;
        }
        return jSONObject.has(str);
    }

    public boolean getBooleanValue(String str, boolean z) {
        JSONObject jSONObject = this.jsonObject;
        return jSONObject == null ? z : jSONObject.optBoolean(str, z);
    }

    public int getIntValue(String str, int i) {
        JSONObject jSONObject = this.jsonObject;
        return jSONObject == null ? i : jSONObject.optInt(str, i);
    }

    public long getLongValue(String str, long j) {
        JSONObject jSONObject = this.jsonObject;
        return jSONObject == null ? j : jSONObject.optLong(str, j);
    }

    public String getStringValue(String str, String str2) {
        JSONObject jSONObject = this.jsonObject;
        return jSONObject == null ? str2 : jSONObject.optString(str, str2);
    }

    public ArrayList<String> getArrayValue(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        JSONObject jSONObject = this.jsonObject;
        if (jSONObject == null) {
            return arrayList;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray(str);
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    arrayList.add(optJSONArray.getString(i));
                }
            }
        } catch (JSONException unused) {
        }
        return arrayList;
    }

    public WritableMap getAll() {
        WritableMap createMap = Arguments.createMap();
        JSONArray names = this.jsonObject.names();
        for (int i = 0; i < names.length(); i++) {
            try {
                String string = names.getString(i);
                SharedUtils.mapPutValue(string, this.jsonObject.get(string), createMap);
            } catch (JSONException unused) {
            }
        }
        return createMap;
    }
}
