package com.amazon.device.simplesignin.a.a.c.a;

import com.amazon.d.a.j;
import com.amazon.device.simplesignin.a.a.a;
import com.amazon.device.simplesignin.a.a.c;
import com.amazon.device.simplesignin.a.a.d;
import com.amazon.device.simplesignin.model.RequestStatus;
import com.amazon.device.simplesignin.model.response.ShowLoginSelectionResponse;
import java.util.Map;

/* compiled from: LoginSelectionResponseCommand */
class b extends c {
    private static final String b = "SSI_LoginSelectionResponse";
    private static final String c = "1.0";

    b(a aVar) {
        super(aVar, b, "1.0");
    }

    /* access modifiers changed from: protected */
    public boolean b(j jVar) throws Exception {
        Map b2 = jVar.b();
        if (!b2.containsKey(a.o)) {
            a(RequestStatus.FAILURE);
            return false;
        }
        String str = (String) b2.get(a.o);
        if (str == null) {
            a(RequestStatus.FAILURE);
            return false;
        }
        String str2 = (String) b2.get(a.p);
        if (!ShowLoginSelectionResponse.UserSelection.LoginSelected.name().equals(str) || str2 == null) {
            a(RequestStatus.SUCCESSFUL, (String) null, ShowLoginSelectionResponse.UserSelection.ManualSignIn);
            return true;
        }
        a(RequestStatus.SUCCESSFUL, str2, ShowLoginSelectionResponse.UserSelection.LoginSelected);
        return true;
    }

    /* access modifiers changed from: protected */
    public void a(RequestStatus requestStatus) {
        if (RequestStatus.INVALID_LINK_SIGNING_KEY_ENCRYPTION.equals(requestStatus) || RequestStatus.INVALID_LINK_SIGNING_KEY.equals(requestStatus)) {
            a(RequestStatus.FAILURE, (String) null, (ShowLoginSelectionResponse.UserSelection) null);
        } else {
            a(requestStatus, (String) null, (ShowLoginSelectionResponse.UserSelection) null);
        }
    }

    private void a(RequestStatus requestStatus, String str, ShowLoginSelectionResponse.UserSelection userSelection) {
        ShowLoginSelectionResponse showLoginSelectionResponse = new ShowLoginSelectionResponse();
        showLoginSelectionResponse.setRequestId(((d) j()).e());
        showLoginSelectionResponse.setRequestStatus(requestStatus);
        showLoginSelectionResponse.setUserSelection(userSelection);
        showLoginSelectionResponse.setLinkId(str);
        super.a((Object) showLoginSelectionResponse);
    }
}
