package com.onesignal.common.modeling;

import com.google.firebase.messaging.Constants;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\b\u0002\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u00010\u0003B\u001d\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004H\u0016J\u0015\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001eJ\u0016\u0010\u001f\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\u001aH\u0016J\u001d\u0010\"\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010#J\u001e\u0010$\u001a\u00020\u00182\u0014\u0010%\u001a\u0010\u0012\u0006\b\u0001\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000&H\u0016J\u0015\u0010'\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010 R&\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\n0\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006("}, d2 = {"Lcom/onesignal/common/modeling/MapModel;", "V", "Lcom/onesignal/common/modeling/Model;", "", "", "parentModel", "parentProperty", "(Lcom/onesignal/common/modeling/Model;Ljava/lang/String;)V", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "size", "", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "clear", "", "containsKey", "", "key", "containsValue", "value", "(Ljava/lang/Object;)Z", "get", "(Ljava/lang/String;)Ljava/lang/Object;", "isEmpty", "put", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "from", "", "remove", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: MapModel.kt */
public class MapModel<V> extends Model implements Map<String, V>, KMutableMap {
    public MapModel() {
        this((Model) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MapModel(Model model, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : model, (i & 2) != 0 ? null : str);
    }

    public final /* bridge */ boolean containsKey(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        return containsKey((String) obj);
    }

    public final /* bridge */ Set<Map.Entry<String, V>> entrySet() {
        return getEntries();
    }

    public final /* bridge */ V get(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        return get((String) obj);
    }

    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    public final /* bridge */ V remove(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        return remove((String) obj);
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    public MapModel(Model model, String str) {
        super(model, str);
    }

    public int getSize() {
        return getData().size();
    }

    public Set<Map.Entry<String, V>> getEntries() {
        Collection arrayList = new ArrayList();
        for (Object next : getData().entrySet()) {
            if (TypeIntrinsics.isMutableMapEntry(next)) {
                arrayList.add(next);
            }
        }
        return CollectionsKt.toMutableSet((List) arrayList);
    }

    public Set<String> getKeys() {
        return getData().keySet();
    }

    public Collection<V> getValues() {
        Iterable<Object> values = getData().values();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(values, 10));
        for (Object add : values) {
            arrayList.add(add);
        }
        return CollectionsKt.toMutableList((List) arrayList);
    }

    public boolean containsKey(String str) {
        Intrinsics.checkNotNullParameter(str, SubscriberAttributeKt.JSON_NAME_KEY);
        return getData().containsKey(str);
    }

    public boolean containsValue(V v) {
        return getData().containsValue(v);
    }

    public boolean isEmpty() {
        return getData().isEmpty();
    }

    public V get(String str) {
        Intrinsics.checkNotNullParameter(str, SubscriberAttributeKt.JSON_NAME_KEY);
        return Model.getOptAnyProperty$default(this, str, (Function0) null, 2, (Object) null);
    }

    public void clear() {
        for (String optAnyProperty$default : getData().keySet()) {
            Model.setOptAnyProperty$default(this, optAnyProperty$default, (Object) null, (String) null, false, 12, (Object) null);
        }
    }

    public V put(String str, V v) {
        Intrinsics.checkNotNullParameter(str, SubscriberAttributeKt.JSON_NAME_KEY);
        Model.setOptAnyProperty$default(this, str, v, (String) null, false, 12, (Object) null);
        return v;
    }

    public void putAll(Map<? extends String, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, Constants.MessagePayloadKeys.FROM);
        for (Map.Entry next : map.entrySet()) {
            Model.setOptAnyProperty$default(this, (String) next.getKey(), next.getValue(), (String) null, false, 12, (Object) null);
        }
    }

    public V remove(String str) {
        Intrinsics.checkNotNullParameter(str, SubscriberAttributeKt.JSON_NAME_KEY);
        Model model = this;
        V optAnyProperty$default = Model.getOptAnyProperty$default(model, str, (Function0) null, 2, (Object) null);
        Model.setOptAnyProperty$default(model, str, (Object) null, (String) null, false, 12, (Object) null);
        return optAnyProperty$default;
    }
}
