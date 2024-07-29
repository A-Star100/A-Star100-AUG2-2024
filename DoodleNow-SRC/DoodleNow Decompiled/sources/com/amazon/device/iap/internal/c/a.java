package com.amazon.device.iap.internal.c;

import com.amazon.a.a.o.b;
import com.amazon.device.iap.model.Promotion;
import com.amazon.device.iap.model.PromotionPlan;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PromotionsDataParser */
final class a {
    a() {
    }

    static List<Promotion> a(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = jSONObject.getJSONArray(b.q);
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(b(jSONArray.getJSONObject(i)));
        }
        return arrayList;
    }

    private static Promotion b(JSONObject jSONObject) throws JSONException {
        return new Promotion(jSONObject.getString(b.r), a(jSONObject.getJSONArray(b.s)));
    }

    private static List<PromotionPlan> a(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(c(jSONArray.getJSONObject(i)));
        }
        return arrayList;
    }

    private static PromotionPlan c(JSONObject jSONObject) throws JSONException {
        String str;
        String string = jSONObject.getString(b.t);
        int i = jSONObject.getInt(b.u);
        JSONObject optJSONObject = jSONObject.optJSONObject(b.w);
        if (optJSONObject == null || optJSONObject == JSONObject.NULL) {
            str = null;
        } else {
            Currency instance = Currency.getInstance(optJSONObject.optString(b.a));
            str = instance.getSymbol() + optJSONObject.optString("value");
        }
        return new PromotionPlan(string, str, i);
    }
}
