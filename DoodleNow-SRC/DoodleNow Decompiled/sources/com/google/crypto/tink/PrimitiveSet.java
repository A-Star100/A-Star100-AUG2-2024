package com.google.crypto.tink;

import com.google.crypto.tink.internal.MutableSerializationRegistry;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.monitoring.MonitoringAnnotations;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.subtle.Hex;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

public final class PrimitiveSet<P> {
    private final MonitoringAnnotations annotations;
    private final boolean isMutable;
    private Entry<P> primary;
    private final Class<P> primitiveClass;
    private final ConcurrentMap<Prefix, List<Entry<P>>> primitives;

    public MonitoringAnnotations getAnnotations() {
        return this.annotations;
    }

    @Nullable
    public Entry<P> getPrimary() {
        return this.primary;
    }

    public Class<P> getPrimitiveClass() {
        return this.primitiveClass;
    }

    public static final class Entry<P> {
        @Nullable
        private final P fullPrimitive;
        private final byte[] identifier;
        private final Key key;
        private final int keyId;
        private final String keyType;
        private final OutputPrefixType outputPrefixType;
        @Nullable
        private final P primitive;
        private final KeyStatusType status;

        @Nullable
        public P getFullPrimitive() {
            return this.fullPrimitive;
        }

        public Key getKey() {
            return this.key;
        }

        public int getKeyId() {
            return this.keyId;
        }

        public String getKeyType() {
            return this.keyType;
        }

        public OutputPrefixType getOutputPrefixType() {
            return this.outputPrefixType;
        }

        @Nullable
        public P getPrimitive() {
            return this.primitive;
        }

        public KeyStatusType getStatus() {
            return this.status;
        }

        Entry(@Nullable P p, @Nullable P p2, byte[] bArr, KeyStatusType keyStatusType, OutputPrefixType outputPrefixType2, int i, String str, Key key2) {
            this.fullPrimitive = p;
            this.primitive = p2;
            this.identifier = Arrays.copyOf(bArr, bArr.length);
            this.status = keyStatusType;
            this.outputPrefixType = outputPrefixType2;
            this.keyId = i;
            this.keyType = str;
            this.key = key2;
        }

        @Nullable
        public final byte[] getIdentifier() {
            byte[] bArr = this.identifier;
            if (bArr == null) {
                return null;
            }
            return Arrays.copyOf(bArr, bArr.length);
        }

        @Nullable
        public Parameters getParameters() {
            Key key2 = this.key;
            if (key2 == null) {
                return null;
            }
            return key2.getParameters();
        }
    }

    /* access modifiers changed from: private */
    public static <P> Entry<P> addEntryToMap(@Nullable P p, @Nullable P p2, Keyset.Key key, ConcurrentMap<Prefix, List<Entry<P>>> concurrentMap) throws GeneralSecurityException {
        ConcurrentMap<Prefix, List<Entry<P>>> concurrentMap2 = concurrentMap;
        Integer valueOf = Integer.valueOf(key.getKeyId());
        if (key.getOutputPrefixType() == OutputPrefixType.RAW) {
            valueOf = null;
        }
        Entry entry = new Entry(p, p2, CryptoFormat.getOutputPrefix(key), key.getStatus(), key.getOutputPrefixType(), key.getKeyId(), key.getKeyData().getTypeUrl(), MutableSerializationRegistry.globalInstance().parseKeyWithLegacyFallback(ProtoKeySerialization.create(key.getKeyData().getTypeUrl(), key.getKeyData().getValue(), key.getKeyData().getKeyMaterialType(), key.getOutputPrefixType(), valueOf), InsecureSecretKeyAccess.get()));
        ArrayList arrayList = new ArrayList();
        arrayList.add(entry);
        Prefix prefix = new Prefix(entry.getIdentifier());
        List list = (List) concurrentMap2.put(prefix, Collections.unmodifiableList(arrayList));
        if (list != null) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(list);
            arrayList2.add(entry);
            concurrentMap2.put(prefix, Collections.unmodifiableList(arrayList2));
        }
        return entry;
    }

    public boolean hasAnnotations() {
        return !this.annotations.toMap().isEmpty();
    }

    public List<Entry<P>> getRawPrimitives() {
        return getPrimitive(CryptoFormat.RAW_PREFIX);
    }

    public List<Entry<P>> getPrimitive(byte[] bArr) {
        List<Entry<P>> list = (List) this.primitives.get(new Prefix(bArr));
        return list != null ? list : Collections.emptyList();
    }

    public Collection<List<Entry<P>>> getAll() {
        return this.primitives.values();
    }

    private PrimitiveSet(Class<P> cls) {
        this.primitives = new ConcurrentHashMap();
        this.primitiveClass = cls;
        this.annotations = MonitoringAnnotations.EMPTY;
        this.isMutable = true;
    }

    private PrimitiveSet(ConcurrentMap<Prefix, List<Entry<P>>> concurrentMap, Entry<P> entry, MonitoringAnnotations monitoringAnnotations, Class<P> cls) {
        this.primitives = concurrentMap;
        this.primary = entry;
        this.primitiveClass = cls;
        this.annotations = monitoringAnnotations;
        this.isMutable = false;
    }

    @Deprecated
    public static <P> PrimitiveSet<P> newPrimitiveSet(Class<P> cls) {
        return new PrimitiveSet<>(cls);
    }

    @Deprecated
    public void setPrimary(Entry<P> entry) {
        if (!this.isMutable) {
            throw new IllegalStateException("setPrimary cannot be called on an immutable primitive set");
        } else if (entry == null) {
            throw new IllegalArgumentException("the primary entry must be non-null");
        } else if (entry.getStatus() != KeyStatusType.ENABLED) {
            throw new IllegalArgumentException("the primary entry has to be ENABLED");
        } else if (!getPrimitive(entry.getIdentifier()).isEmpty()) {
            this.primary = entry;
        } else {
            throw new IllegalArgumentException("the primary entry cannot be set to an entry which is not held by this primitive set");
        }
    }

    @Deprecated
    public Entry<P> addPrimitive(P p, Keyset.Key key) throws GeneralSecurityException {
        if (!this.isMutable) {
            throw new IllegalStateException("addPrimitive cannot be called on an immutable primitive set");
        } else if (key.getStatus() == KeyStatusType.ENABLED) {
            return addEntryToMap((Object) null, p, key, this.primitives);
        } else {
            throw new GeneralSecurityException("only ENABLED key is allowed");
        }
    }

    private static class Prefix implements Comparable<Prefix> {
        private final byte[] prefix;

        private Prefix(byte[] bArr) {
            this.prefix = Arrays.copyOf(bArr, bArr.length);
        }

        public int hashCode() {
            return Arrays.hashCode(this.prefix);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Prefix)) {
                return false;
            }
            return Arrays.equals(this.prefix, ((Prefix) obj).prefix);
        }

        public int compareTo(Prefix prefix2) {
            byte[] bArr = this.prefix;
            int length = bArr.length;
            byte[] bArr2 = prefix2.prefix;
            if (length != bArr2.length) {
                return bArr.length - bArr2.length;
            }
            int i = 0;
            while (true) {
                byte[] bArr3 = this.prefix;
                if (i >= bArr3.length) {
                    return 0;
                }
                byte b = bArr3[i];
                byte b2 = prefix2.prefix[i];
                if (b != b2) {
                    return b - b2;
                }
                i++;
            }
        }

        public String toString() {
            return Hex.encode(this.prefix);
        }
    }

    public static class Builder<P> {
        private MonitoringAnnotations annotations;
        private Entry<P> primary;
        private final Class<P> primitiveClass;
        private ConcurrentMap<Prefix, List<Entry<P>>> primitives;

        private Builder<P> addPrimitive(@Nullable P p, @Nullable P p2, Keyset.Key key, boolean z) throws GeneralSecurityException {
            if (this.primitives == null) {
                throw new IllegalStateException("addPrimitive cannot be called after build");
            } else if (p == null && p2 == null) {
                throw new GeneralSecurityException("at least one of the `fullPrimitive` or `primitive` must be set");
            } else if (key.getStatus() == KeyStatusType.ENABLED) {
                Entry<P> access$100 = PrimitiveSet.addEntryToMap(p, p2, key, this.primitives);
                if (z) {
                    if (this.primary == null) {
                        this.primary = access$100;
                    } else {
                        throw new IllegalStateException("you cannot set two primary primitives");
                    }
                }
                return this;
            } else {
                throw new GeneralSecurityException("only ENABLED key is allowed");
            }
        }

        public Builder<P> addPrimitive(P p, Keyset.Key key) throws GeneralSecurityException {
            return addPrimitive((Object) null, p, key, false);
        }

        public Builder<P> addPrimaryPrimitive(P p, Keyset.Key key) throws GeneralSecurityException {
            return addPrimitive((Object) null, p, key, true);
        }

        public Builder<P> addFullPrimitiveAndOptionalPrimitive(@Nullable P p, @Nullable P p2, Keyset.Key key) throws GeneralSecurityException {
            return addPrimitive(p, p2, key, false);
        }

        public Builder<P> addPrimaryFullPrimitiveAndOptionalPrimitive(@Nullable P p, @Nullable P p2, Keyset.Key key) throws GeneralSecurityException {
            return addPrimitive(p, p2, key, true);
        }

        public Builder<P> setAnnotations(MonitoringAnnotations monitoringAnnotations) {
            if (this.primitives != null) {
                this.annotations = monitoringAnnotations;
                return this;
            }
            throw new IllegalStateException("setAnnotations cannot be called after build");
        }

        public PrimitiveSet<P> build() throws GeneralSecurityException {
            ConcurrentMap<Prefix, List<Entry<P>>> concurrentMap = this.primitives;
            if (concurrentMap != null) {
                PrimitiveSet primitiveSet = new PrimitiveSet(concurrentMap, this.primary, this.annotations, this.primitiveClass);
                this.primitives = null;
                return primitiveSet;
            }
            throw new IllegalStateException("build cannot be called twice");
        }

        private Builder(Class<P> cls) {
            this.primitives = new ConcurrentHashMap();
            this.primitiveClass = cls;
            this.annotations = MonitoringAnnotations.EMPTY;
        }
    }

    public static <P> Builder<P> newBuilder(Class<P> cls) {
        return new Builder<>(cls);
    }
}
