package com.polidea.rxandroidble2.internal.cache;

import bleshadow.javax.inject.Inject;
import com.polidea.rxandroidble2.ClientScope;
import com.polidea.rxandroidble2.internal.DeviceComponent;
import com.polidea.rxandroidble2.internal.cache.DeviceComponentWeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@ClientScope
public class DeviceComponentCache implements Map<String, DeviceComponent> {
    private final HashMap<String, DeviceComponentWeakReference> cache;
    private final DeviceComponentWeakReference.Provider deviceComponentReferenceProvider;

    @Inject
    public DeviceComponentCache() {
        this(new DeviceComponentWeakReference.Provider() {
            public DeviceComponentWeakReference provide(DeviceComponent deviceComponent) {
                return new DeviceComponentWeakReference(deviceComponent);
            }
        });
    }

    DeviceComponentCache(DeviceComponentWeakReference.Provider provider) {
        this.cache = new HashMap<>();
        this.deviceComponentReferenceProvider = provider;
    }

    public void clear() {
        this.cache.clear();
    }

    public boolean containsKey(Object obj) {
        return this.cache.containsKey(obj) && get(obj) != null;
    }

    public boolean containsValue(Object obj) {
        for (DeviceComponentWeakReference contains : this.cache.values()) {
            if (contains.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public Set<Map.Entry<String, DeviceComponent>> entrySet() {
        HashSet hashSet = new HashSet();
        for (Map.Entry next : this.cache.entrySet()) {
            DeviceComponentWeakReference deviceComponentWeakReference = (DeviceComponentWeakReference) next.getValue();
            if (!deviceComponentWeakReference.isEmpty()) {
                hashSet.add(new CacheEntry((String) next.getKey(), this.deviceComponentReferenceProvider.provide((DeviceComponent) deviceComponentWeakReference.get())));
            }
        }
        return hashSet;
    }

    public DeviceComponent get(Object obj) {
        DeviceComponentWeakReference deviceComponentWeakReference = this.cache.get(obj);
        if (deviceComponentWeakReference != null) {
            return (DeviceComponent) deviceComponentWeakReference.get();
        }
        return null;
    }

    public boolean isEmpty() {
        evictEmptyReferences();
        return this.cache.isEmpty();
    }

    public Set<String> keySet() {
        return this.cache.keySet();
    }

    public DeviceComponent put(String str, DeviceComponent deviceComponent) {
        this.cache.put(str, this.deviceComponentReferenceProvider.provide(deviceComponent));
        evictEmptyReferences();
        return deviceComponent;
    }

    public void putAll(Map<? extends String, ? extends DeviceComponent> map) {
        for (Map.Entry next : map.entrySet()) {
            put((String) next.getKey(), (DeviceComponent) next.getValue());
        }
    }

    public DeviceComponent remove(Object obj) {
        DeviceComponentWeakReference remove = this.cache.remove(obj);
        evictEmptyReferences();
        if (remove != null) {
            return (DeviceComponent) remove.get();
        }
        return null;
    }

    public int size() {
        evictEmptyReferences();
        return this.cache.size();
    }

    public Collection<DeviceComponent> values() {
        ArrayList arrayList = new ArrayList();
        for (DeviceComponentWeakReference next : this.cache.values()) {
            if (!next.isEmpty()) {
                arrayList.add((DeviceComponent) next.get());
            }
        }
        return arrayList;
    }

    private void evictEmptyReferences() {
        Iterator<Map.Entry<String, DeviceComponentWeakReference>> it = this.cache.entrySet().iterator();
        while (it.hasNext()) {
            if (((DeviceComponentWeakReference) it.next().getValue()).isEmpty()) {
                it.remove();
            }
        }
    }
}
