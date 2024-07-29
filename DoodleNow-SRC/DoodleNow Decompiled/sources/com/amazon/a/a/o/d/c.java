package com.amazon.a.a.o.d;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: Verifier */
public class c implements Iterable<a> {
    private Map<b, a> a = new HashMap();

    public <T> c a(T t, T t2, b bVar) {
        if (!a((Object) t, (Object) t2)) {
            this.a.put(bVar, new a(bVar, "'" + t + "' != '" + t2 + "'"));
        }
        return this;
    }

    private boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public <T extends Comparable<T>> c a(T t, T t2, b bVar) {
        if (t.compareTo(t2) <= 0) {
            this.a.put(bVar, new a(bVar, "'" + t + "' <= '" + t2 + "'"));
        }
        return this;
    }

    public c a(Exception exc, b bVar) {
        this.a.put(bVar, new a(bVar, "Exception: " + exc));
        return this;
    }

    public boolean a() {
        return !this.a.isEmpty();
    }

    public Iterator<a> iterator() {
        return this.a.values().iterator();
    }

    public boolean a(b bVar) {
        return this.a.containsKey(bVar);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Verifier:");
        for (a aVar : this.a.values()) {
            sb.append("\n\t" + aVar);
        }
        return sb.toString();
    }
}
