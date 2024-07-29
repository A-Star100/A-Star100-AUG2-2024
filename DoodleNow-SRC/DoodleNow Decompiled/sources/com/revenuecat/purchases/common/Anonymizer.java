package com.revenuecat.purchases.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0002J&\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bJ\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tJ&\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/revenuecat/purchases/common/Anonymizer;", "", "()V", "anonymizeRegex", "Lkotlin/text/Regex;", "anonymizedAny", "valueToAnonymize", "anonymizedMap", "", "", "mapToAnonymize", "anonymizedString", "textToAnonymize", "anonymizedStringMap", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Anonymizer.kt */
public final class Anonymizer {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final String EMAIL_REGEX = "[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.]+@[a-zA-Z0-9]+\\.[a-zA-Z]+";
    @Deprecated
    public static final String IP_REGEX = "((25[0-5]|(2[0-4]|1\\d|[1-9]|)\\d)\\.?\\b){4}";
    @Deprecated
    public static final String REDACTED = "*****";
    @Deprecated
    public static final String UUID_REGEX = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
    private final Regex anonymizeRegex = new Regex("[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.]+@[a-zA-Z0-9]+\\.[a-zA-Z]+|[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}|((25[0-5]|(2[0-4]|1\\d|[1-9]|)\\d)\\.?\\b){4}");

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/common/Anonymizer$Companion;", "", "()V", "EMAIL_REGEX", "", "IP_REGEX", "REDACTED", "UUID_REGEX", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Anonymizer.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final String anonymizedString(String str) {
        Intrinsics.checkNotNullParameter(str, "textToAnonymize");
        return this.anonymizeRegex.replace((CharSequence) str, REDACTED);
    }

    private final Object anonymizedAny(Object obj) {
        Object obj2;
        if (obj instanceof String) {
            return anonymizedString((String) obj);
        }
        if (obj instanceof List) {
            Iterable iterable = (Iterable) obj;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                arrayList.add(next == null ? null : anonymizedAny(next));
            }
            return (List) arrayList;
        } else if (!(obj instanceof Map)) {
            return obj;
        } else {
            Map map = (Map) obj;
            Map linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
            for (Map.Entry entry : map.entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                if (value == null) {
                    obj2 = null;
                } else {
                    obj2 = anonymizedAny(value);
                }
                linkedHashMap.put(key, obj2);
            }
            return linkedHashMap;
        }
    }

    public final Map<String, Object> anonymizedMap(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "mapToAnonymize");
        Map<String, Object> linkedHashMap = new LinkedHashMap<>(MapsKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), anonymizedAny(entry.getValue()));
        }
        return linkedHashMap;
    }

    public final Map<String, String> anonymizedStringMap(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "mapToAnonymize");
        Map<String, String> linkedHashMap = new LinkedHashMap<>(MapsKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), anonymizedString((String) entry.getValue()));
        }
        return linkedHashMap;
    }
}
