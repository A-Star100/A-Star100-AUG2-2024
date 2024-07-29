package com.amazon.device.iap.internal.a.a;

import com.amazon.a.a.o.b;
import com.amazon.a.a.o.f;
import com.amazon.device.iap.model.Promotion;
import com.amazon.device.iap.model.PromotionPlan;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PromotionsDataParser */
final class e {
    e() {
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
        JSONObject jSONObject2;
        String string = jSONObject.getString(b.t);
        int i = jSONObject.getInt(b.u);
        String optString = jSONObject.optString(b.v);
        if (f.a(optString) && (jSONObject2 = jSONObject.getJSONObject(b.w)) != null) {
            Currency instance = Currency.getInstance(jSONObject2.getString(b.a));
            optString = instance.getSymbol() + new BigDecimal(jSONObject2.getString("value"));
        }
        return new PromotionPlan(string, optString, i);
    }
}
