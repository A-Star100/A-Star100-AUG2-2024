package com.amazon.a.a.o;

import java.util.Iterator;
import java.util.WeakHashMap;

/* compiled from: WeakHashSet */
public class g<T> implements Iterable<T> {
    private WeakHashMap<T, Object> a = new WeakHashMap<>();

    public void a(T t) {
        this.a.put(t, (Object) null);
    }

    public boolean a() {
        return this.a.isEmpty();
    }

    public Iterator<T> iterator() {
        return this.a.keySet().iterator();
    }

    public void b(T t) {
        this.a.remove(t);
    }

    public int b() {
        return this.a.size();
    }

    public String toString() {
        return this.a.keySet().toString();
    }
}
