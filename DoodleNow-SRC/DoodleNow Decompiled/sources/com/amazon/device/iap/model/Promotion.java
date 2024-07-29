package com.amazon.device.iap.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amazon.a.a.o.b;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class Promotion implements Parcelable {
    public static final Parcelable.Creator<Promotion> CREATOR = new Parcelable.Creator<Promotion>() {
        public Promotion createFromParcel(Parcel parcel) {
            return new Promotion(parcel);
        }

        public Promotion[] newArray(int i) {
            return new Promotion[i];
        }
    };
    private List<PromotionPlan> promotionPlans;
    private final String promotionType;

    public int describeContents() {
        return 0;
    }

    public List<PromotionPlan> getPromotionPlans() {
        return this.promotionPlans;
    }

    public String getPromotionType() {
        return this.promotionType;
    }

    public Promotion(String str, List<PromotionPlan> list) {
        this.promotionType = str;
        this.promotionPlans = list;
    }

    private Promotion(Parcel parcel) {
        this.promotionType = parcel.readString();
        this.promotionPlans = parcel.createTypedArrayList(PromotionPlan.CREATOR);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.promotionType);
        parcel.writeTypedList(this.promotionPlans);
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(b.r, getPromotionType());
        JSONArray jSONArray = new JSONArray();
        for (PromotionPlan json : getPromotionPlans()) {
            jSONArray.put(json.toJSON());
        }
        jSONObject.put(b.s, jSONArray);
        return jSONObject;
    }

    public String toString() {
        try {
            return toJSON().toString(4);
        } catch (JSONException unused) {
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Promotion)) {
            return false;
        }
        Promotion promotion = (Promotion) obj;
        if (getPromotionPlans() == null || !getPromotionPlans().equals(promotion.getPromotionPlans()) || getPromotionType() == null || !getPromotionType().equals(promotion.getPromotionType())) {
            return false;
        }
        return true;
    }
}
