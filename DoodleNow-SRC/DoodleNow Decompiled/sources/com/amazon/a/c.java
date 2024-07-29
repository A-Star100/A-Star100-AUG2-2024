package com.amazon.a;

import android.os.RemoteException;
import com.amazon.a.a.d.b;
import com.amazon.a.a.i.e;
import com.amazon.a.a.i.g;
import com.amazon.a.a.n.a.a;
import com.amazon.d.a.h;
import com.amazon.d.a.j;
import java.util.Map;

/* compiled from: CheckifAppIsBlockedTask */
public class c extends a {
    private static final com.amazon.a.a.o.c b = new com.amazon.a.a.o.c("CheckIfAppisBlockedTask");
    @com.amazon.a.a.k.a
    private e c;

    /* access modifiers changed from: protected */
    public String a_() {
        return "check_blocked_status";
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> b() {
        return null;
    }

    /* access modifiers changed from: protected */
    public String c() {
        return "1.0";
    }

    /* access modifiers changed from: protected */
    public boolean d() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void a(j jVar) throws RemoteException, b {
        if (jVar.b() != null && jVar.b().containsKey("verbose")) {
            boolean booleanValue = ((Boolean) jVar.b().get("verbose")).booleanValue();
            com.amazon.a.a.o.c.b = booleanValue;
            com.amazon.a.a.o.c.a = booleanValue;
        }
    }

    /* access modifiers changed from: protected */
    public void a(h hVar) throws RemoteException, b {
        if (m()) {
            n();
        }
        b.c("app is blocked, killing");
        this.c.a(new g(new com.amazon.a.a.i.c(hVar.b(), hVar.c(), hVar.d(), hVar.e())));
    }
}
