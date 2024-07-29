package com.amazon.device.simplesignin.a.a.a;

import android.os.RemoteException;
import com.amazon.d.a.j;
import com.amazon.device.simplesignin.a.a.a;
import com.amazon.device.simplesignin.a.a.c;
import com.amazon.device.simplesignin.a.a.d;
import com.amazon.device.simplesignin.model.Link;
import com.amazon.device.simplesignin.model.RequestStatus;
import com.amazon.device.simplesignin.model.response.GetUserAndLinksResponse;
import java.util.List;
import java.util.Map;

/* compiled from: GetUserAndLinksCommand */
public class b extends c {
    private static final String b = "SSI_GetUserAndLinks";
    private static final String c = "1.0";
    private static final String d = "b";

    b(a aVar, String str) {
        super(aVar, b, "1.0");
        super.a(a.a, str);
    }

    /* access modifiers changed from: protected */
    public boolean b(j jVar) throws RemoteException {
        Map b2 = jVar.b();
        if (!b2.containsKey(a.b) || !b2.containsKey(a.c)) {
            a(RequestStatus.FAILURE);
            return false;
        }
        String str = (String) b2.get(a.b);
        String str2 = (String) b2.get(a.c);
        if (str == null || str2 == null) {
            a(RequestStatus.FAILURE);
            return false;
        }
        List<Link> a = com.amazon.device.simplesignin.a.d.b.a(str, str2);
        if (a == null) {
            a(RequestStatus.FAILURE);
            return false;
        }
        a(RequestStatus.SUCCESSFUL, str, a);
        return true;
    }

    /* access modifiers changed from: protected */
    public void a(RequestStatus requestStatus) {
        if (RequestStatus.INVALID_LINK_SIGNING_KEY_ENCRYPTION.equals(requestStatus) || RequestStatus.INVALID_LINK_SIGNING_KEY.equals(requestStatus)) {
            a(RequestStatus.FAILURE, (String) null, (List<Link>) null);
        } else {
            a(requestStatus, (String) null, (List<Link>) null);
        }
    }

    private void a(RequestStatus requestStatus, String str, List<Link> list) {
        GetUserAndLinksResponse getUserAndLinksResponse = new GetUserAndLinksResponse();
        getUserAndLinksResponse.setRequestId(((d) j()).e());
        getUserAndLinksResponse.setRequestStatus(requestStatus);
        getUserAndLinksResponse.setAmazonUserId(str);
        getUserAndLinksResponse.setLinks(list);
        super.a((Object) getUserAndLinksResponse);
    }
}
