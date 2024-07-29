package com.amazon.device.iap.model;

import com.amazon.a.a.o.f;
import com.amazon.device.iap.internal.model.ReceiptBuilder;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public final class Receipt {
    private static final String CANCEL_DATE = "endDate";
    private static final Date DATE_CANCELED = new Date(1);
    private static final String DEFERRED_DATE = "deferredDate";
    private static final String DEFERRED_SKU = "deferredSku";
    private static final String PRODUCT_TYPE = "itemType";
    private static final String PURCHASE_DATE = "purchaseDate";
    private static final String RECEIPT_ID = "receiptId";
    private static final String SKU = "sku";
    private static final String TERM_SKU = "termSku";
    private final Date cancelDate;
    private final Date deferredDate;
    private final String deferredSku;
    private final ProductType productType;
    private final Date purchaseDate;
    private final String receiptId;
    private final String sku;
    private final String termSku;

    public Date getCancelDate() {
        return this.cancelDate;
    }

    public Date getDeferredDate() {
        return this.deferredDate;
    }

    public String getDeferredSku() {
        return this.deferredSku;
    }

    public ProductType getProductType() {
        return this.productType;
    }

    public Date getPurchaseDate() {
        return this.purchaseDate;
    }

    public String getReceiptId() {
        return this.receiptId;
    }

    public String getSku() {
        return this.sku;
    }

    public String getTermSku() {
        return this.termSku;
    }

    public boolean isCanceled() {
        return this.cancelDate != null;
    }

    public boolean isDeferred() {
        return this.deferredDate != null;
    }

    public int hashCode() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Date date = this.cancelDate;
        int i7 = 0;
        int hashCode = ((date == null ? 0 : date.hashCode()) + 31) * 31;
        ProductType productType2 = this.productType;
        if (productType2 == null) {
            i = 0;
        } else {
            i = productType2.hashCode();
        }
        int i8 = (hashCode + i) * 31;
        Date date2 = this.purchaseDate;
        if (date2 == null) {
            i2 = 0;
        } else {
            i2 = date2.hashCode();
        }
        int i9 = (i8 + i2) * 31;
        Date date3 = this.deferredDate;
        if (date3 == null) {
            i3 = 0;
        } else {
            i3 = date3.hashCode();
        }
        int i10 = (i9 + i3) * 31;
        String str = this.receiptId;
        if (str == null) {
            i4 = 0;
        } else {
            i4 = str.hashCode();
        }
        int i11 = (i10 + i4) * 31;
        String str2 = this.sku;
        if (str2 == null) {
            i5 = 0;
        } else {
            i5 = str2.hashCode();
        }
        int i12 = (i11 + i5) * 31;
        String str3 = this.deferredSku;
        if (str3 == null) {
            i6 = 0;
        } else {
            i6 = str3.hashCode();
        }
        int i13 = (i12 + i6) * 31;
        String str4 = this.termSku;
        if (str4 != null) {
            i7 = str4.hashCode();
        }
        return i13 + i7;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Receipt receipt = (Receipt) obj;
        Date date = this.cancelDate;
        if (date == null) {
            if (receipt.cancelDate != null) {
                return false;
            }
        } else if (!date.equals(receipt.cancelDate)) {
            return false;
        }
        if (this.productType != receipt.productType) {
            return false;
        }
        Date date2 = this.purchaseDate;
        if (date2 == null) {
            if (receipt.purchaseDate != null) {
                return false;
            }
        } else if (!date2.equals(receipt.purchaseDate)) {
            return false;
        }
        String str = this.receiptId;
        if (str == null) {
            if (receipt.receiptId != null) {
                return false;
            }
        } else if (!str.equals(receipt.receiptId)) {
            return false;
        }
        String str2 = this.sku;
        if (str2 == null) {
            if (receipt.sku != null) {
                return false;
            }
        } else if (!str2.equals(receipt.sku)) {
            return false;
        }
        String str3 = this.deferredSku;
        if (str3 == null) {
            if (receipt.deferredSku != null) {
                return false;
            }
        } else if (!str3.equals(receipt.deferredSku)) {
            return false;
        }
        Date date3 = this.deferredDate;
        if (date3 != null) {
            return date3.equals(receipt.deferredDate) && this.termSku.equals(receipt.termSku);
        }
        if (receipt.deferredDate != null) {
            return false;
        }
    }

    public Receipt(ReceiptBuilder receiptBuilder) {
        f.a((Object) receiptBuilder.getSku(), "sku");
        f.a((Object) receiptBuilder.getProductType(), "productType");
        if (ProductType.SUBSCRIPTION == receiptBuilder.getProductType()) {
            f.a((Object) receiptBuilder.getPurchaseDate(), "purchaseDate");
        }
        this.receiptId = receiptBuilder.getReceiptId();
        this.sku = receiptBuilder.getSku();
        this.productType = receiptBuilder.getProductType();
        this.purchaseDate = receiptBuilder.getPurchaseDate();
        this.cancelDate = receiptBuilder.getCancelDate();
        this.deferredSku = receiptBuilder.getDeferredSku();
        this.deferredDate = receiptBuilder.getDeferredDate();
        this.termSku = receiptBuilder.getTermSku();
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("receiptId", this.receiptId);
            jSONObject.put("sku", this.sku);
            jSONObject.put("itemType", this.productType);
            jSONObject.put("purchaseDate", this.purchaseDate);
            jSONObject.put("endDate", this.cancelDate);
            jSONObject.put("deferredSku", this.deferredSku);
            jSONObject.put("deferredDate", this.deferredDate);
            jSONObject.put("termSku", this.termSku);
        } catch (JSONException unused) {
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
