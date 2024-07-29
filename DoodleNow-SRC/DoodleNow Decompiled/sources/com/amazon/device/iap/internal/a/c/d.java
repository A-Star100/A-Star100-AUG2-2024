package com.amazon.device.iap.internal.a.c;

import android.os.RemoteException;
import com.amazon.a.a.o.b;
import com.amazon.a.a.o.f;
import com.amazon.d.a.j;
import com.amazon.device.iap.internal.a.c;
import com.amazon.device.iap.internal.model.UserDataBuilder;
import com.amazon.device.iap.internal.model.UserDataResponseBuilder;
import com.amazon.device.iap.model.UserData;
import com.amazon.device.iap.model.UserDataResponse;
import java.util.Map;

/* compiled from: GetUserIdCommandV2 */
public final class d extends b {
    private static final String d = "d";

    public d(c cVar) {
        super(cVar, b.ae);
    }

    /* access modifiers changed from: protected */
    public boolean b(j jVar) throws RemoteException, com.amazon.a.a.d.b {
        String str = d;
        com.amazon.device.iap.internal.util.b.a(str, "onResult: result = " + jVar);
        Map b = jVar.b();
        com.amazon.device.iap.internal.util.b.a(str, "data: " + b);
        String str2 = (String) b.get("userId");
        String str3 = (String) b.get(b.m);
        c cVar = (c) j();
        if (f.a(str2) || f.a(str3)) {
            cVar.a().a((Object) new UserDataResponseBuilder().setRequestId(cVar.d()).setRequestStatus(UserDataResponse.RequestStatus.FAILED).build());
            return false;
        }
        UserData build = new UserDataBuilder().setUserId(str2).setMarketplace(str3).build();
        UserDataResponse build2 = new UserDataResponseBuilder().setRequestId(cVar.d()).setRequestStatus(UserDataResponse.RequestStatus.SUCCESSFUL).setUserData(build).build();
        cVar.a().a("userId", build.getUserId());
        cVar.a().a((Object) build2);
        return true;
    }
}
