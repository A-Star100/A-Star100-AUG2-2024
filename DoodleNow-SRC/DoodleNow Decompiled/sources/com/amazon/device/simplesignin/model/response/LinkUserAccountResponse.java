package com.amazon.device.simplesignin.model.response;

import com.amazon.device.simplesignin.model.Link;
import com.amazon.device.simplesignin.model.RequestId;
import com.amazon.device.simplesignin.model.RequestStatus;

public class LinkUserAccountResponse {
    private Link link;
    private RequestId requestId;
    private RequestStatus requestStatus;
    private SuccessCode successCode;

    public enum SuccessCode {
        LinkAlreadyExists,
        LinkEstablished,
        ConsentDenied
    }

    public Link getLink() {
        return this.link;
    }

    public RequestId getRequestId() {
        return this.requestId;
    }

    public RequestStatus getRequestStatus() {
        return this.requestStatus;
    }

    public SuccessCode getSuccessCode() {
        return this.successCode;
    }

    public void setLink(Link link2) {
        this.link = link2;
    }

    public void setRequestId(RequestId requestId2) {
        this.requestId = requestId2;
    }

    public void setRequestStatus(RequestStatus requestStatus2) {
        this.requestStatus = requestStatus2;
    }

    public void setSuccessCode(SuccessCode successCode2) {
        this.successCode = successCode2;
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object obj) {
        return obj instanceof LinkUserAccountResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LinkUserAccountResponse)) {
            return false;
        }
        LinkUserAccountResponse linkUserAccountResponse = (LinkUserAccountResponse) obj;
        if (!linkUserAccountResponse.canEqual(this)) {
            return false;
        }
        RequestId requestId2 = getRequestId();
        RequestId requestId3 = linkUserAccountResponse.getRequestId();
        if (requestId2 != null ? !requestId2.equals(requestId3) : requestId3 != null) {
            return false;
        }
        RequestStatus requestStatus2 = getRequestStatus();
        RequestStatus requestStatus3 = linkUserAccountResponse.getRequestStatus();
        if (requestStatus2 != null ? !requestStatus2.equals(requestStatus3) : requestStatus3 != null) {
            return false;
        }
        SuccessCode successCode2 = getSuccessCode();
        SuccessCode successCode3 = linkUserAccountResponse.getSuccessCode();
        if (successCode2 != null ? !successCode2.equals(successCode3) : successCode3 != null) {
            return false;
        }
        Link link2 = getLink();
        Link link3 = linkUserAccountResponse.getLink();
        return link2 != null ? link2.equals(link3) : link3 == null;
    }

    public int hashCode() {
        RequestId requestId2 = getRequestId();
        int i = 43;
        int hashCode = requestId2 == null ? 43 : requestId2.hashCode();
        RequestStatus requestStatus2 = getRequestStatus();
        int hashCode2 = ((hashCode + 59) * 59) + (requestStatus2 == null ? 43 : requestStatus2.hashCode());
        SuccessCode successCode2 = getSuccessCode();
        int hashCode3 = (hashCode2 * 59) + (successCode2 == null ? 43 : successCode2.hashCode());
        Link link2 = getLink();
        int i2 = hashCode3 * 59;
        if (link2 != null) {
            i = link2.hashCode();
        }
        return i2 + i;
    }
}
