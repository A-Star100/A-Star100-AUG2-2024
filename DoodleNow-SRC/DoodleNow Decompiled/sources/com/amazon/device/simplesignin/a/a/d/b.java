package com.amazon.device.simplesignin.a.a.d;

import com.amazon.d.a.j;
import com.amazon.device.simplesignin.a.a.a;
import com.amazon.device.simplesignin.a.a.c;
import com.amazon.device.simplesignin.a.a.d;
import com.amazon.device.simplesignin.model.RequestStatus;
import com.amazon.device.simplesignin.model.response.UnlinkUserAccountResponse;
import java.util.Map;

/* compiled from: UnlinkUserAccountCommand */
public class b extends c {
    private static final String b = "SSI_UnlinkUserAccount";
    private static final String c = "1.0";

    public b(a aVar, String str) {
        super(aVar, b, "1.0");
        super.a(a.a, str);
    }

    /* access modifiers changed from: protected */
    public void a(RequestStatus requestStatus) {
        b(requestStatus);
    }

    /* access modifiers changed from: protected */
    public boolean b(j jVar) throws Exception {
        b(RequestStatus.SUCCESSFUL);
        Map b2 = jVar.b();
        return b2.containsKey(a.q) && b2.get(a.q) != null;
    }

    private void b(RequestStatus requestStatus) {
        UnlinkUserAccountResponse unlinkUserAccountResponse = new UnlinkUserAccountResponse();
        unlinkUserAccountResponse.setRequestId(((d) j()).e());
        unlinkUserAccountResponse.setRequestStatus(requestStatus);
        super.a((Object) unlinkUserAccountResponse);
    }
}
