package com.amazon.a.a.c;

import com.amazon.a.a.o.a.a;
import com.amazon.a.a.o.c;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.HashMap;
import java.util.Map;

/* compiled from: EventManagerImpl */
public class g implements f {
    private static final c a = new c("EventManagerImpl");
    private final Map<b, e<?>> b = new HashMap();

    public <T extends a> void a(c<T> cVar) {
        a.a((Object) cVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        a.a();
        b a2 = cVar.a();
        c cVar2 = a;
        cVar2.a("Registering listener for event: " + a2 + ", " + cVar);
        e eVar = this.b.get(a2);
        if (eVar == null) {
            eVar = new e();
            this.b.put(a2, eVar);
        }
        eVar.a(cVar);
    }

    public void a(a aVar) {
        b a2 = aVar.a();
        if (c.a) {
            c cVar = a;
            cVar.a("Posting event: " + a2);
        }
        if (this.b.containsKey(a2)) {
            this.b.get(a2).a(aVar);
        } else if (c.a) {
            a.a("No registered listeners, returning");
        }
    }
}
