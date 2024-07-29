package com.amazon.a.a.b.b;

import android.os.RemoteException;
import com.amazon.a.a.d.b;
import com.amazon.a.a.o.c;
import com.amazon.d.a.h;
import com.amazon.d.a.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: SubmitCrashReportsTask */
public class a extends com.amazon.a.a.n.a.a {
    private static final c b = new c("SubmitCrashReportsTask");
    @com.amazon.a.a.k.a
    private com.amazon.a.a.b.a c;
    private List<com.amazon.a.a.b.c> d;

    /* access modifiers changed from: protected */
    public void a(h hVar) throws RemoteException, b {
    }

    /* access modifiers changed from: protected */
    public String a_() {
        return "submit_crash_reports";
    }

    /* access modifiers changed from: protected */
    public String c() {
        return "1.0";
    }

    /* access modifiers changed from: protected */
    public void e() throws b {
        this.d = this.c.a();
        if (c.a) {
            c cVar = b;
            cVar.a("--------------- Crash Reports -------------------");
            cVar.a("Size: " + this.d.size());
            cVar.a("--------------------------------------------------");
        }
    }

    /* access modifiers changed from: protected */
    public boolean d() {
        return !this.d.isEmpty();
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> b() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (com.amazon.a.a.b.c a : this.d) {
            arrayList.add(a.a());
        }
        hashMap.put("reports", arrayList);
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public void a(j jVar) throws RemoteException, b {
        this.c.a(this.d);
    }
}
