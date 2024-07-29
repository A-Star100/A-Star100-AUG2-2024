package com.amazon.a.a.c;

import com.amazon.a.a.c.a;
import com.amazon.a.a.o.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: EventListenerNotificationQueue */
public class e<EventType extends a> implements Comparator<c<EventType>> {
    private static final c a = new c("EventListenerNotificationQueue");
    private List<c<EventType>> b = new ArrayList();

    public void a(c<EventType> cVar) {
        if (c.a) {
            c cVar2 = a;
            cVar2.a("Adding listener: " + cVar);
        }
        this.b.add(cVar);
        Collections.sort(this.b, this);
    }

    public void a(EventType eventtype) {
        for (c next : this.b) {
            if (c.a) {
                c cVar = a;
                cVar.a("Notifying listener: " + next);
            }
            next.a(eventtype);
        }
    }

    /* renamed from: a */
    public int compare(c<EventType> cVar, c<EventType> cVar2) {
        return cVar.b().compareTo(cVar2.b());
    }
}
