package com.amazon.device.iap.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amazon.a.a.o.f;
import com.amazon.device.iap.internal.model.ProductBuilder;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class Product implements Parcelable {
    private static final String COINS_REWARD_AMOUNT = "coinsRewardAmount";
    public static final Parcelable.Creator<Product> CREATOR = new Parcelable.Creator<Product>() {
        public Product createFromParcel(Parcel parcel) {
            return new Product(parcel);
        }

        public Product[] newArray(int i) {
            return new Product[i];
        }
    };
    private static final String DESCRIPTION = "description";
    private static final String FREE_TRIAL_PERIOD = "freeTrialPeriod";
    private static final String PRICE = "price";
    private static final String PRODUCT_TYPE = "productType";
    private static final String PROMOTIONS = "promotions";
    private static final String SKU = "sku";
    private static final String SMALL_ICON_URL = "smallIconUrl";
    private static final String SUBSCRIPTION_PERIOD = "subscriptionPeriod";
    private static final String TITLE = "title";
    private final CoinsReward coinsReward;
    private final String description;
    private final String freeTrialPeriod;
    private final String price;
    private final ProductType productType;
    private List<Promotion> promotions;
    private final String sku;
    private final String smallIconUrl;
    private final String subscriptionPeriod;
    private final String title;

    public int describeContents() {
        return 0;
    }

    public CoinsReward getCoinsReward() {
        return this.coinsReward;
    }

    public String getDescription() {
        return this.description;
    }

    public String getFreeTrialPeriod() {
        return this.freeTrialPeriod;
    }

    public String getPrice() {
        return this.price;
    }

    public ProductType getProductType() {
        return this.productType;
    }

    public List<Promotion> getPromotions() {
        return this.promotions;
    }

    public String getSku() {
        return this.sku;
    }

    public String getSmallIconUrl() {
        return this.smallIconUrl;
    }

    public String getSubscriptionPeriod() {
        return this.subscriptionPeriod;
    }

    public String getTitle() {
        return this.title;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.sku);
        parcel.writeString(this.productType.toString());
        parcel.writeString(this.description);
        parcel.writeString(this.price);
        parcel.writeString(this.smallIconUrl);
        parcel.writeString(this.title);
        parcel.writeInt(getCoinsRewardAmount());
        parcel.writeString(this.subscriptionPeriod);
        parcel.writeString(this.freeTrialPeriod);
        parcel.writeTypedList(this.promotions);
    }

    private Product(Parcel parcel) {
        this.sku = parcel.readString();
        this.productType = ProductType.valueOf(parcel.readString());
        this.description = parcel.readString();
        this.price = parcel.readString();
        this.smallIconUrl = parcel.readString();
        this.title = parcel.readString();
        this.coinsReward = CoinsReward.from(parcel.dataAvail() > 0 ? parcel.readInt() : 0);
        this.subscriptionPeriod = parcel.readString();
        this.freeTrialPeriod = parcel.readString();
        this.promotions = parcel.createTypedArrayList(Promotion.CREATOR);
    }

    public Product(ProductBuilder productBuilder) {
        f.a((Object) productBuilder.getSku(), "sku");
        f.a((Object) productBuilder.getProductType(), PRODUCT_TYPE);
        f.a((Object) productBuilder.getDescription(), "description");
        f.a((Object) productBuilder.getTitle(), "title");
        f.a((Object) productBuilder.getSmallIconUrl(), SMALL_ICON_URL);
        if (ProductType.SUBSCRIPTION != productBuilder.getProductType()) {
            f.a((Object) productBuilder.getPrice(), "price");
        }
        this.sku = productBuilder.getSku();
        this.productType = productBuilder.getProductType();
        this.description = productBuilder.getDescription();
        this.price = productBuilder.getPrice();
        this.smallIconUrl = productBuilder.getSmallIconUrl();
        this.title = productBuilder.getTitle();
        this.coinsReward = CoinsReward.from(productBuilder.getCoinsRewardAmount());
        this.subscriptionPeriod = productBuilder.getSubscriptionPeriod();
        this.freeTrialPeriod = productBuilder.getFreeTrialPeriod();
        this.promotions = productBuilder.getPromotions();
    }

    private int getCoinsRewardAmount() {
        CoinsReward coinsReward2 = this.coinsReward;
        if (coinsReward2 == null) {
            return 0;
        }
        return coinsReward2.getAmount();
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("sku", this.sku);
        jSONObject.put(PRODUCT_TYPE, this.productType);
        jSONObject.put("description", this.description);
        jSONObject.put("price", this.price);
        jSONObject.put(SMALL_ICON_URL, this.smallIconUrl);
        jSONObject.put("title", this.title);
        jSONObject.put("coinsRewardAmount", getCoinsRewardAmount());
        String str = this.subscriptionPeriod;
        if (str != null) {
            jSONObject.put("subscriptionPeriod", str);
        }
        String str2 = this.freeTrialPeriod;
        if (str2 != null) {
            jSONObject.put("freeTrialPeriod", str2);
        }
        if (this.promotions != null) {
            JSONArray jSONArray = new JSONArray();
            for (Promotion json : this.promotions) {
                jSONArray.put(json.toJSON());
            }
            jSONObject.put("promotions", jSONArray);
        }
        return jSONObject;
    }

    public String toString() {
        try {
            return toJSON().toString(4);
        } catch (JSONException unused) {
            return null;
        }
    }
}
