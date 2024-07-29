package bleshadow.dagger.internal;

import bleshadow.javax.inject.Provider;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

abstract class AbstractMapFactory<K, V, V2> implements Factory<Map<K, V2>> {
    /* access modifiers changed from: private */
    public final Map<K, Provider<V>> contributingMap;

    /* access modifiers changed from: package-private */
    public final Map<K, Provider<V>> contributingMap() {
        return this.contributingMap;
    }

    AbstractMapFactory(Map<K, Provider<V>> map) {
        this.contributingMap = Collections.unmodifiableMap(map);
    }

    public static abstract class Builder<K, V, V2> {
        final LinkedHashMap<K, Provider<V>> map;

        Builder(int i) {
            this.map = DaggerCollections.newLinkedHashMapWithExpectedSize(i);
        }

        /* access modifiers changed from: package-private */
        public Builder<K, V, V2> put(K k, Provider<V> provider) {
            this.map.put(Preconditions.checkNotNull(k, SubscriberAttributeKt.JSON_NAME_KEY), Preconditions.checkNotNull(provider, "provider"));
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder<K, V, V2> putAll(Provider<Map<K, V2>> provider) {
            if (provider instanceof DelegateFactory) {
                return putAll(((DelegateFactory) provider).getDelegate());
            }
            this.map.putAll(((AbstractMapFactory) provider).contributingMap);
            return this;
        }
    }
}
