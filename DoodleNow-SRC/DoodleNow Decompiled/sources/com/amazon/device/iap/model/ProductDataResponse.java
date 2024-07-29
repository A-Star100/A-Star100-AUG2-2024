package com.amazon.device.iap.model;

import com.amazon.a.a.o.f;
import com.amazon.device.iap.internal.model.ProductDataResponseBuilder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class ProductDataResponse {
    private static final String PRODUCT_DATA = "productData";
    private static final String REQUEST_ID = "requestId";
    private static final String REQUEST_STATUS = "requestStatus";
    private static final String TO_STRING_FORMAT = "(%s, requestId: \"%s\", unavailableSkus: %s, requestStatus: \"%s\", productData: %s)";
    private static final String UNAVAILABLE_SKUS = "UNAVAILABLE_SKUS";
    private final Map<String, Product> productData;
    private final RequestId requestId;
    private final RequestStatus requestStatus;
    private final Set<String> unavailableSkus;

    public enum RequestStatus {
        SUCCESSFUL,
        FAILED,
        NOT_SUPPORTED
    }

    public Map<String, Product> getProductData() {
        return this.productData;
    }

    public RequestId getRequestId() {
        return this.requestId;
    }

    public RequestStatus getRequestStatus() {
        return this.requestStatus;
    }

    public Set<String> getUnavailableSkus() {
        return this.unavailableSkus;
    }

    public ProductDataResponse(ProductDataResponseBuilder productDataResponseBuilder) {
        f.a((Object) productDataResponseBuilder.getRequestId(), "requestId");
        f.a((Object) productDataResponseBuilder.getRequestStatus(), "requestStatus");
        if (productDataResponseBuilder.getUnavailableSkus() == null) {
            productDataResponseBuilder.setUnavailableSkus(new HashSet());
        }
        if (RequestStatus.SUCCESSFUL == productDataResponseBuilder.getRequestStatus()) {
            f.a((Object) productDataResponseBuilder.getProductData(), PRODUCT_DATA);
        } else {
            productDataResponseBuilder.setProductData(new HashMap());
        }
        this.requestId = productDataResponseBuilder.getRequestId();
        this.requestStatus = productDataResponseBuilder.getRequestStatus();
        this.unavailableSkus = productDataResponseBuilder.getUnavailableSkus();
        this.productData = productDataResponseBuilder.getProductData();
    }

    public String toString() {
        Object[] objArr = new Object[5];
        objArr[0] = super.toString();
        objArr[1] = this.requestId;
        Set<String> set = this.unavailableSkus;
        String str = "null";
        objArr[2] = set != null ? set.toString() : str;
        RequestStatus requestStatus2 = this.requestStatus;
        objArr[3] = requestStatus2 != null ? requestStatus2.toString() : str;
        Map<String, Product> map = this.productData;
        if (map != null) {
            str = map.toString();
        }
        objArr[4] = str;
        return String.format(TO_STRING_FORMAT, objArr);
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("requestId", this.requestId);
        jSONObject.put(UNAVAILABLE_SKUS, this.unavailableSkus);
        jSONObject.put("requestStatus", this.requestStatus);
        JSONObject jSONObject2 = new JSONObject();
        Map<String, Product> map = this.productData;
        if (map != null) {
            for (String next : map.keySet()) {
                jSONObject2.put(next, this.productData.get(next).toJSON());
            }
        }
        jSONObject.put(PRODUCT_DATA, jSONObject2);
        return jSONObject;
    }
}
