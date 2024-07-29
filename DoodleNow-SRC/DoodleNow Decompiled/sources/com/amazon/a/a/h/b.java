package com.amazon.a.a.h;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* compiled from: MetricBatch */
public class b implements Serializable, Iterable<a> {
    private static final long a = 1;
    private final List<a> b = new ArrayList();

    public Collection<a> b() {
        return this.b;
    }

    public boolean a() {
        return this.b.isEmpty();
    }

    public Iterator<a> iterator() {
        return this.b.iterator();
    }

    public void a(a aVar) {
        this.b.add(aVar);
    }

    public int c() {
        return this.b.size();
    }

    public String toString() {
        return "MetricBatch: [" + this.b + "]";
    }
}
