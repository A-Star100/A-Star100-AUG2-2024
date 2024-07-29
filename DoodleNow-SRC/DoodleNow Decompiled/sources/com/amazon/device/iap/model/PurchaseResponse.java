package com.amazon.device.iap.model;

import com.amazon.a.a.o.f;
import com.amazon.device.iap.internal.model.PurchaseResponseBuilder;
import org.json.JSONException;
import org.json.JSONObject;

public final class PurchaseResponse {
    private static final String RECEIPT = "receipt";
    private static final String REQUEST_ID = "requestId";
    private static final String REQUEST_STATUS = "requestStatus";
    private static final String TO_STRING_FORMAT = "(%s, requestId: \"%s\", purchaseRequestStatus: \"%s\", userId: \"%s\", receipt: %s)";
    private static final String USER_DATA = "userData";
    private final Receipt receipt;
    private final RequestId requestId;
    private final RequestStatus requestStatus;
    private final UserData userData;

    public Receipt getReceipt() {
        return this.receipt;
    }

    public RequestId getRequestId() {
        return this.requestId;
    }

    public RequestStatus getRequestStatus() {
        return this.requestStatus;
    }

    public UserData getUserData() {
        return this.userData;
    }

    public enum RequestStatus {
        SUCCESSFUL,
        FAILED,
        INVALID_SKU,
        ALREADY_PURCHASED,
        NOT_SUPPORTED;

        public static RequestStatus safeValueOf(String str) {
            if (f.a(str)) {
                return null;
            }
            if ("ALREADY_ENTITLED".equalsIgnoreCase(str)) {
                return ALREADY_PURCHASED;
            }
            return valueOf(str.toUpperCase());
        }
    }

    public PurchaseResponse(PurchaseResponseBuilder purchaseResponseBuilder) {
        f.a((Object) purchaseResponseBuilder.getRequestId(), "requestId");
        f.a((Object) purchaseResponseBuilder.getRequestStatus(), "requestStatus");
        if (purchaseResponseBuilder.getRequestStatus() == RequestStatus.SUCCESSFUL) {
            f.a((Object) purchaseResponseBuilder.getReceipt(), "receipt");
            f.a((Object) purchaseResponseBuilder.getUserData(), USER_DATA);
        }
        this.requestId = purchaseResponseBuilder.getRequestId();
        this.userData = purchaseResponseBuilder.getUserData();
        this.receipt = purchaseResponseBuilder.getReceipt();
        this.requestStatus = purchaseResponseBuilder.getRequestStatus();
    }

    public String toString() {
        Object[] objArr = new Object[5];
        objArr[0] = super.toString();
        objArr[1] = this.requestId;
        RequestStatus requestStatus2 = this.requestStatus;
        objArr[2] = requestStatus2 != null ? requestStatus2.toString() : "null";
        objArr[3] = this.userData;
        objArr[4] = this.receipt;
        return String.format(TO_STRING_FORMAT, objArr);
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("requestId", this.requestId);
        jSONObject.put("requestStatus", this.requestStatus);
        UserData userData2 = this.userData;
        Object obj = "";
        jSONObject.put(USER_DATA, userData2 != null ? userData2.toJSON() : obj);
        if (getReceipt() != null) {
            obj = getReceipt().toJSON();
        }
        jSONObject.put("receipt", obj);
        return jSONObject;
    }
}
