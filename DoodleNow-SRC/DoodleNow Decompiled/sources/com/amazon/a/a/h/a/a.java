package com.amazon.a.a.h.a;

import android.os.RemoteException;
import com.amazon.a.a.h.b;
import com.amazon.a.a.o.c;
import com.amazon.d.a.h;
import com.amazon.d.a.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: SubmitMetricsTask */
public class a extends com.amazon.a.a.n.a.a {
    private static final c b = new c("SubmitMetricsTask");
    @com.amazon.a.a.k.a
    private com.amazon.a.a.h.c c;
    private b d;

    /* access modifiers changed from: protected */
    public void a(h hVar) throws RemoteException, com.amazon.a.a.d.b {
    }

    /* access modifiers changed from: protected */
    public void a(j jVar) throws RemoteException, com.amazon.a.a.d.b {
    }

    /* access modifiers changed from: protected */
    public String a_() {
        return "submit_metrics";
    }

    /* access modifiers changed from: protected */
    public String c() {
        return "1.0";
    }

    /* access modifiers changed from: protected */
    public void e() throws com.amazon.a.a.d.b {
        this.d = this.c.a();
        if (c.a) {
            c cVar = b;
            cVar.a("--------------- SUBMIT METRICS -------------------");
            cVar.a("Size: " + this.d.c());
            cVar.a("--------------------------------------------------");
        }
    }

    /* access modifiers changed from: protected */
    public boolean d() {
        return !this.d.a();
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> b() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList(this.d.c());
        Iterator<com.amazon.a.a.h.a> it = this.d.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().a());
        }
        hashMap.put("metrics", arrayList);
        return hashMap;
    }
}
