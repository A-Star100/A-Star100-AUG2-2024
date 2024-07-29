package com.amazon.device.iap.internal.model;

import com.amazon.device.iap.model.Product;
import com.amazon.device.iap.model.ProductType;
import com.amazon.device.iap.model.Promotion;
import java.util.List;

public class ProductBuilder {
    private int coinsRewardAmount;
    private String description;
    private String freeTrialPeriod;
    private String price;
    private ProductType productType;
    private List<Promotion> promotions;
    private String sku;
    private String smallIconUrl;
    private String subscriptionPeriod;
    private String title;

    public int getCoinsRewardAmount() {
        return this.coinsRewardAmount;
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

    public ProductBuilder setCoinsRewardAmount(int i) {
        this.coinsRewardAmount = i;
        return this;
    }

    public ProductBuilder setDescription(String str) {
        this.description = str;
        return this;
    }

    public ProductBuilder setFreeTrialPeriod(String str) {
        this.freeTrialPeriod = str;
        return this;
    }

    public ProductBuilder setPrice(String str) {
        this.price = str;
        return this;
    }

    public ProductBuilder setProductType(ProductType productType2) {
        this.productType = productType2;
        return this;
    }

    public ProductBuilder setPromotions(List<Promotion> list) {
        this.promotions = list;
        return this;
    }

    public ProductBuilder setSku(String str) {
        this.sku = str;
        return this;
    }

    public ProductBuilder setSmallIconUrl(String str) {
        this.smallIconUrl = str;
        return this;
    }

    public ProductBuilder setSubscriptionPeriod(String str) {
        this.subscriptionPeriod = str;
        return this;
    }

    public ProductBuilder setTitle(String str) {
        this.title = str;
        return this;
    }

    public Product build() {
        return new Product(this);
    }
}
