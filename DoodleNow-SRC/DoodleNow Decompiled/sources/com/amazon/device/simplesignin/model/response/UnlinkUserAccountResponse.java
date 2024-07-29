package com.amazon.device.simplesignin.model.response;

import com.amazon.device.simplesignin.model.RequestId;
import com.amazon.device.simplesignin.model.RequestStatus;

public class UnlinkUserAccountResponse {
    private RequestId requestId;
    private RequestStatus requestStatus;

    public RequestId getRequestId() {
        return this.requestId;
    }

    public RequestStatus getRequestStatus() {
        return this.requestStatus;
    }

    public void setRequestId(RequestId requestId2) {
        this.requestId = requestId2;
    }

    public void setRequestStatus(RequestStatus requestStatus2) {
        this.requestStatus = requestStatus2;
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object obj) {
        return obj instanceof UnlinkUserAccountResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UnlinkUserAccountResponse)) {
            return false;
        }
        UnlinkUserAccountResponse unlinkUserAccountResponse = (UnlinkUserAccountResponse) obj;
        if (!unlinkUserAccountResponse.canEqual(this)) {
            return false;
        }
        RequestId requestId2 = getRequestId();
        RequestId requestId3 = unlinkUserAccountResponse.getRequestId();
        if (requestId2 != null ? !requestId2.equals(requestId3) : requestId3 != null) {
            return false;
        }
        RequestStatus requestStatus2 = getRequestStatus();
        RequestStatus requestStatus3 = unlinkUserAccountResponse.getRequestStatus();
        return requestStatus2 != null ? requestStatus2.equals(requestStatus3) : requestStatus3 == null;
    }

    public int hashCode() {
        RequestId requestId2 = getRequestId();
        int i = 43;
        int hashCode = requestId2 == null ? 43 : requestId2.hashCode();
        RequestStatus requestStatus2 = getRequestStatus();
        int i2 = (hashCode + 59) * 59;
        if (requestStatus2 != null) {
            i = requestStatus2.hashCode();
        }
        return i2 + i;
    }
}
