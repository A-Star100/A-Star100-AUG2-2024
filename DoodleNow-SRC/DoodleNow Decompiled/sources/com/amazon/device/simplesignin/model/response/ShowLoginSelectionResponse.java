package com.amazon.device.simplesignin.model.response;

import com.amazon.device.simplesignin.model.RequestId;
import com.amazon.device.simplesignin.model.RequestStatus;

public class ShowLoginSelectionResponse {
    private String linkId;
    private RequestId requestId;
    private RequestStatus requestStatus;
    private UserSelection userSelection;

    public enum UserSelection {
        ManualSignIn,
        LoginSelected
    }

    public String getLinkId() {
        return this.linkId;
    }

    public RequestId getRequestId() {
        return this.requestId;
    }

    public RequestStatus getRequestStatus() {
        return this.requestStatus;
    }

    public UserSelection getUserSelection() {
        return this.userSelection;
    }

    public void setLinkId(String str) {
        this.linkId = str;
    }

    public void setRequestId(RequestId requestId2) {
        this.requestId = requestId2;
    }

    public void setRequestStatus(RequestStatus requestStatus2) {
        this.requestStatus = requestStatus2;
    }

    public void setUserSelection(UserSelection userSelection2) {
        this.userSelection = userSelection2;
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object obj) {
        return obj instanceof ShowLoginSelectionResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShowLoginSelectionResponse)) {
            return false;
        }
        ShowLoginSelectionResponse showLoginSelectionResponse = (ShowLoginSelectionResponse) obj;
        if (!showLoginSelectionResponse.canEqual(this)) {
            return false;
        }
        RequestId requestId2 = getRequestId();
        RequestId requestId3 = showLoginSelectionResponse.getRequestId();
        if (requestId2 != null ? !requestId2.equals(requestId3) : requestId3 != null) {
            return false;
        }
        RequestStatus requestStatus2 = getRequestStatus();
        RequestStatus requestStatus3 = showLoginSelectionResponse.getRequestStatus();
        if (requestStatus2 != null ? !requestStatus2.equals(requestStatus3) : requestStatus3 != null) {
            return false;
        }
        UserSelection userSelection2 = getUserSelection();
        UserSelection userSelection3 = showLoginSelectionResponse.getUserSelection();
        if (userSelection2 != null ? !userSelection2.equals(userSelection3) : userSelection3 != null) {
            return false;
        }
        String linkId2 = getLinkId();
        String linkId3 = showLoginSelectionResponse.getLinkId();
        return linkId2 != null ? linkId2.equals(linkId3) : linkId3 == null;
    }

    public int hashCode() {
        RequestId requestId2 = getRequestId();
        int i = 43;
        int hashCode = requestId2 == null ? 43 : requestId2.hashCode();
        RequestStatus requestStatus2 = getRequestStatus();
        int hashCode2 = ((hashCode + 59) * 59) + (requestStatus2 == null ? 43 : requestStatus2.hashCode());
        UserSelection userSelection2 = getUserSelection();
        int hashCode3 = (hashCode2 * 59) + (userSelection2 == null ? 43 : userSelection2.hashCode());
        String linkId2 = getLinkId();
        int i2 = hashCode3 * 59;
        if (linkId2 != null) {
            i = linkId2.hashCode();
        }
        return i2 + i;
    }
}
