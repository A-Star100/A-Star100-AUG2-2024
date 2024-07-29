package com.amazon.device.iap.internal.a.c;

import com.amazon.a.a.n.a.h;
import com.amazon.device.iap.internal.a.c;
import com.amazon.device.iap.internal.model.UserDataResponseBuilder;
import com.amazon.device.iap.model.RequestId;
import com.amazon.device.iap.model.UserDataResponse;

/* compiled from: GetUserDataRequest */
public final class a extends c {
    public a(RequestId requestId) {
        super(requestId);
        d dVar = new d(this);
        dVar.b((h) new c(this));
        a((h) dVar);
    }

    public void b() {
        a((Object) (UserDataResponse) a().b());
    }

    public void c() {
        UserDataResponse userDataResponse = (UserDataResponse) a().b();
        if (userDataResponse == null) {
            userDataResponse = new UserDataResponseBuilder().setRequestId(d()).setRequestStatus(UserDataResponse.RequestStatus.FAILED).build();
        }
        a((Object) userDataResponse);
    }
}
