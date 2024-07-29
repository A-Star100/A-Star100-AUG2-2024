package com.amazon.device.simplesignin.a.a.b;

import com.amazon.device.simplesignin.a.a.d;
import com.amazon.device.simplesignin.model.Link;
import com.amazon.device.simplesignin.model.RequestStatus;
import com.amazon.device.simplesignin.model.response.LinkUserAccountResponse;

/* compiled from: LinkUserAccountCommandBase */
public abstract class c extends com.amazon.device.simplesignin.a.a.c {
    protected c(d dVar, String str, String str2) {
        super(dVar, str, str2);
    }

    /* access modifiers changed from: protected */
    public void a(RequestStatus requestStatus) {
        a(requestStatus, (Link) null, (LinkUserAccountResponse.SuccessCode) null);
    }

    /* access modifiers changed from: protected */
    public void a(RequestStatus requestStatus, Link link, LinkUserAccountResponse.SuccessCode successCode) {
        LinkUserAccountResponse linkUserAccountResponse = new LinkUserAccountResponse();
        linkUserAccountResponse.setRequestId(((d) j()).e());
        linkUserAccountResponse.setRequestStatus(requestStatus);
        linkUserAccountResponse.setLink(link);
        linkUserAccountResponse.setSuccessCode(successCode);
        super.a((Object) linkUserAccountResponse);
    }
}
