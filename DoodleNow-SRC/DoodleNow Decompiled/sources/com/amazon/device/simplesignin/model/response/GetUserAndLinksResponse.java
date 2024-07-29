package com.amazon.device.simplesignin.model.response;

import com.amazon.device.simplesignin.model.Link;
import com.amazon.device.simplesignin.model.RequestId;
import com.amazon.device.simplesignin.model.RequestStatus;
import java.util.List;

public class GetUserAndLinksResponse {
    private String amazonUserId;
    private List<Link> links;
    private RequestId requestId;
    private RequestStatus requestStatus;

    public String getAmazonUserId() {
        return this.amazonUserId;
    }

    public List<Link> getLinks() {
        return this.links;
    }

    public RequestId getRequestId() {
        return this.requestId;
    }

    public RequestStatus getRequestStatus() {
        return this.requestStatus;
    }

    public void setAmazonUserId(String str) {
        this.amazonUserId = str;
    }

    public void setLinks(List<Link> list) {
        this.links = list;
    }

    public void setRequestId(RequestId requestId2) {
        this.requestId = requestId2;
    }

    public void setRequestStatus(RequestStatus requestStatus2) {
        this.requestStatus = requestStatus2;
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object obj) {
        return obj instanceof GetUserAndLinksResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetUserAndLinksResponse)) {
            return false;
        }
        GetUserAndLinksResponse getUserAndLinksResponse = (GetUserAndLinksResponse) obj;
        if (!getUserAndLinksResponse.canEqual(this)) {
            return false;
        }
        RequestId requestId2 = getRequestId();
        RequestId requestId3 = getUserAndLinksResponse.getRequestId();
        if (requestId2 != null ? !requestId2.equals(requestId3) : requestId3 != null) {
            return false;
        }
        RequestStatus requestStatus2 = getRequestStatus();
        RequestStatus requestStatus3 = getUserAndLinksResponse.getRequestStatus();
        if (requestStatus2 != null ? !requestStatus2.equals(requestStatus3) : requestStatus3 != null) {
            return false;
        }
        String amazonUserId2 = getAmazonUserId();
        String amazonUserId3 = getUserAndLinksResponse.getAmazonUserId();
        if (amazonUserId2 != null ? !amazonUserId2.equals(amazonUserId3) : amazonUserId3 != null) {
            return false;
        }
        List<Link> links2 = getLinks();
        List<Link> links3 = getUserAndLinksResponse.getLinks();
        return links2 != null ? links2.equals(links3) : links3 == null;
    }

    public int hashCode() {
        RequestId requestId2 = getRequestId();
        int i = 43;
        int hashCode = requestId2 == null ? 43 : requestId2.hashCode();
        RequestStatus requestStatus2 = getRequestStatus();
        int hashCode2 = ((hashCode + 59) * 59) + (requestStatus2 == null ? 43 : requestStatus2.hashCode());
        String amazonUserId2 = getAmazonUserId();
        int hashCode3 = (hashCode2 * 59) + (amazonUserId2 == null ? 43 : amazonUserId2.hashCode());
        List<Link> links2 = getLinks();
        int i2 = hashCode3 * 59;
        if (links2 != null) {
            i = links2.hashCode();
        }
        return i2 + i;
    }
}
