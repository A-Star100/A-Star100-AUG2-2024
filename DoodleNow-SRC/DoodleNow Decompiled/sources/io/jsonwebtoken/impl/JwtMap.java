package io.jsonwebtoken.impl;

import io.jsonwebtoken.lang.Assert;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class JwtMap implements Map<String, Object> {
    private final Map<String, Object> map;

    public JwtMap() {
        this(new LinkedHashMap());
    }

    public JwtMap(Map<String, Object> map2) {
        Assert.notNull(map2, "Map argument cannot be null.");
        this.map = map2;
    }

    /* access modifiers changed from: protected */
    public String getString(String str) {
        Object obj = get(str);
        if (obj != null) {
            return String.valueOf(obj);
        }
        return null;
    }

    protected static Date toDate(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Date) {
            return (Date) obj;
        }
        if (obj instanceof Number) {
            return new Date(((Number) obj).longValue() * 1000);
        }
        if (obj instanceof String) {
            return new Date(Long.parseLong((String) obj) * 1000);
        }
        throw new IllegalStateException("Cannot convert '" + str + "' value [" + obj + "] to Date instance.");
    }

    /* access modifiers changed from: protected */
    public void setValue(String str, Object obj) {
        if (obj == null) {
            this.map.remove(str);
        } else {
            this.map.put(str, obj);
        }
    }

    /* access modifiers changed from: protected */
    public Date getDate(String str) {
        return toDate(this.map.get(str), str);
    }

    /* access modifiers changed from: protected */
    public void setDate(String str, Date date) {
        if (date == null) {
            this.map.remove(str);
        } else {
            this.map.put(str, Long.valueOf(date.getTime() / 1000));
        }
    }

    public int size() {
        return this.map.size();
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return this.map.containsValue(obj);
    }

    public Object get(Object obj) {
        return this.map.get(obj);
    }

    public Object put(String str, Object obj) {
        if (obj == null) {
            return this.map.remove(str);
        }
        return this.map.put(str, obj);
    }

    public Object remove(Object obj) {
        return this.map.remove(obj);
    }

    public void putAll(Map<? extends String, ?> map2) {
        if (map2 != null) {
            for (String str : map2.keySet()) {
                this.map.put(str, map2.get(str));
            }
        }
    }

    public void clear() {
        this.map.clear();
    }

    public Set<String> keySet() {
        return this.map.keySet();
    }

    public Collection<Object> values() {
        return this.map.values();
    }

    public Set<Map.Entry<String, Object>> entrySet() {
        return this.map.entrySet();
    }

    public String toString() {
        return this.map.toString();
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public boolean equals(Object obj) {
        return this.map.equals(obj);
    }
}
