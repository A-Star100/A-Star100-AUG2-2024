package redis.clients.util;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class JedisByteHashMap implements Map<byte[], byte[]>, Cloneable, Serializable {
    private static final long serialVersionUID = -6971431362627219416L;
    private transient Map<ByteArrayWrapper, byte[]> internalMap = new HashMap();

    public void clear() {
        this.internalMap.clear();
    }

    public boolean containsKey(Object key) {
        if (key instanceof byte[]) {
            return this.internalMap.containsKey(new ByteArrayWrapper((byte[]) key));
        }
        return this.internalMap.containsKey(key);
    }

    public boolean containsValue(Object value) {
        return this.internalMap.containsValue(value);
    }

    public Set<Map.Entry<byte[], byte[]>> entrySet() {
        HashSet<Map.Entry<byte[], byte[]>> hashSet = new HashSet<>();
        for (Map.Entry<ByteArrayWrapper, byte[]> entry : this.internalMap.entrySet()) {
            hashSet.add(new JedisByteEntry(entry.getKey().data, entry.getValue()));
        }
        return hashSet;
    }

    public byte[] get(Object key) {
        if (key instanceof byte[]) {
            return this.internalMap.get(new ByteArrayWrapper((byte[]) key));
        }
        return this.internalMap.get(key);
    }

    public boolean isEmpty() {
        return this.internalMap.isEmpty();
    }

    public Set<byte[]> keySet() {
        Set<byte[]> keySet = new HashSet<>();
        for (ByteArrayWrapper access$0 : this.internalMap.keySet()) {
            keySet.add(access$0.data);
        }
        return keySet;
    }

    public byte[] put(byte[] key, byte[] value) {
        return this.internalMap.put(new ByteArrayWrapper(key), value);
    }

    public void putAll(Map<? extends byte[], ? extends byte[]> m) {
        for (Map.Entry<? extends byte[], ? extends byte[]> next : m.entrySet()) {
            this.internalMap.put(new ByteArrayWrapper((byte[]) next.getKey()), (byte[]) next.getValue());
        }
    }

    public byte[] remove(Object key) {
        if (key instanceof byte[]) {
            return this.internalMap.remove(new ByteArrayWrapper((byte[]) key));
        }
        return this.internalMap.remove(key);
    }

    public int size() {
        return this.internalMap.size();
    }

    public Collection<byte[]> values() {
        return this.internalMap.values();
    }

    private static final class ByteArrayWrapper {
        /* access modifiers changed from: private */
        public final byte[] data;

        public ByteArrayWrapper(byte[] data2) {
            if (data2 != null) {
                this.data = data2;
                return;
            }
            throw new NullPointerException();
        }

        public boolean equals(Object other) {
            if (!(other instanceof ByteArrayWrapper)) {
                return false;
            }
            return Arrays.equals(this.data, ((ByteArrayWrapper) other).data);
        }

        public int hashCode() {
            return Arrays.hashCode(this.data);
        }
    }

    private static final class JedisByteEntry implements Map.Entry<byte[], byte[]> {
        private byte[] key;
        private byte[] value;

        public JedisByteEntry(byte[] key2, byte[] value2) {
            this.key = key2;
            this.value = value2;
        }

        public byte[] getKey() {
            return this.key;
        }

        public byte[] getValue() {
            return this.value;
        }

        public byte[] setValue(byte[] value2) {
            this.value = value2;
            return value2;
        }
    }
}
