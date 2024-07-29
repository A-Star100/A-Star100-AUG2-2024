package kotlinx.serialization.json.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonNames;
import kotlinx.serialization.json.JsonSchemaCacheKt;
import kotlinx.serialization.json.internal.DescriptorSchemaCache;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u001a\u0018\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002*\u00020\nH\u0000\u001a\u001c\u0010\u000b\u001a\u00020\u0004*\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0000\u001a&\u0010\u000f\u001a\u00020\u0004*\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0003H\u0000\u001aF\u0010\u0011\u001a\u00020\u0012*\u00020\r2\u0006\u0010\u0013\u001a\u00020\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u00152\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00152\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0015H\bø\u0001\u0000\".\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0019"}, d2 = {"JsonAlternativeNamesKey", "Lkotlinx/serialization/json/internal/DescriptorSchemaCache$Key;", "", "", "", "getJsonAlternativeNamesKey$annotations", "()V", "getJsonAlternativeNamesKey", "()Lkotlinx/serialization/json/internal/DescriptorSchemaCache$Key;", "buildAlternativeNamesMap", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getJsonNameIndex", "json", "Lkotlinx/serialization/json/Json;", "name", "getJsonNameIndexOrThrow", "suffix", "tryCoerceValue", "", "elementDescriptor", "peekNull", "Lkotlin/Function0;", "peekString", "onEnumCoercing", "", "kotlinx-serialization-json"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: JsonNamesMap.kt */
public final class JsonNamesMapKt {
    private static final DescriptorSchemaCache.Key<Map<String, Integer>> JsonAlternativeNamesKey = new DescriptorSchemaCache.Key<>();

    public static final DescriptorSchemaCache.Key<Map<String, Integer>> getJsonAlternativeNamesKey() {
        return JsonAlternativeNamesKey;
    }

    public static /* synthetic */ void getJsonAlternativeNamesKey$annotations() {
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.util.Map, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final void buildAlternativeNamesMap$putOrThrow(java.util.Map<java.lang.String, java.lang.Integer> r3, kotlinx.serialization.descriptors.SerialDescriptor r4, java.lang.String r5, int r6) {
        /*
            boolean r0 = r3.containsKey(r5)
            if (r0 != 0) goto L_0x000e
            java.lang.Integer r4 = java.lang.Integer.valueOf(r6)
            r3.put(r5, r4)
            return
        L_0x000e:
            kotlinx.serialization.json.internal.JsonException r0 = new kotlinx.serialization.json.internal.JsonException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "The suggested name '"
            r1.<init>(r2)
            r1.append(r5)
            java.lang.String r2 = "' for property "
            r1.append(r2)
            java.lang.String r6 = r4.getElementName(r6)
            r1.append(r6)
            java.lang.String r6 = " is already one of the names for property "
            r1.append(r6)
            java.lang.Object r3 = kotlin.collections.MapsKt.getValue(r3, r5)
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            java.lang.String r3 = r4.getElementName(r3)
            r1.append(r3)
            java.lang.String r3 = " in "
            r1.append(r3)
            r1.append(r4)
            java.lang.String r3 = r1.toString()
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.JsonNamesMapKt.buildAlternativeNamesMap$putOrThrow(java.util.Map, kotlinx.serialization.descriptors.SerialDescriptor, java.lang.String, int):void");
    }

    public static final Map<String, Integer> buildAlternativeNamesMap(SerialDescriptor serialDescriptor) {
        String[] names;
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        int elementsCount = serialDescriptor.getElementsCount();
        Map<String, Integer> map = null;
        for (int i = 0; i < elementsCount; i++) {
            Collection arrayList = new ArrayList();
            for (Object next : serialDescriptor.getElementAnnotations(i)) {
                if (next instanceof JsonNames) {
                    arrayList.add(next);
                }
            }
            JsonNames jsonNames = (JsonNames) CollectionsKt.singleOrNull((List) arrayList);
            if (!(jsonNames == null || (names = jsonNames.names()) == null)) {
                for (String str : names) {
                    if (map == null) {
                        map = CreateMapForCacheKt.createMapForCache(serialDescriptor.getElementsCount());
                    }
                    Intrinsics.checkNotNull(map);
                    buildAlternativeNamesMap$putOrThrow(map, serialDescriptor, str, i);
                }
            }
        }
        return map == null ? MapsKt.emptyMap() : map;
    }

    public static final int getJsonNameIndex(SerialDescriptor serialDescriptor, Json json, String str) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(str, "name");
        int elementIndex = serialDescriptor.getElementIndex(str);
        if (elementIndex != -3 || !json.getConfiguration().getUseAlternativeNames()) {
            return elementIndex;
        }
        Integer num = (Integer) ((Map) JsonSchemaCacheKt.getSchemaCache(json).getOrPut(serialDescriptor, JsonAlternativeNamesKey, new JsonNamesMapKt$getJsonNameIndex$alternativeNamesMap$1(serialDescriptor))).get(str);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    public static /* synthetic */ int getJsonNameIndexOrThrow$default(SerialDescriptor serialDescriptor, Json json, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "";
        }
        return getJsonNameIndexOrThrow(serialDescriptor, json, str, str2);
    }

    public static final int getJsonNameIndexOrThrow(SerialDescriptor serialDescriptor, Json json, String str, String str2) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "suffix");
        int jsonNameIndex = getJsonNameIndex(serialDescriptor, json, str);
        if (jsonNameIndex != -3) {
            return jsonNameIndex;
        }
        throw new SerializationException(serialDescriptor.getSerialName() + " does not contain element with name '" + str + '\'' + str2);
    }

    public static /* synthetic */ boolean tryCoerceValue$default(Json json, SerialDescriptor serialDescriptor, Function0 function0, Function0 function02, Function0 function03, int i, Object obj) {
        String str;
        if ((i & 8) != 0) {
            function03 = JsonNamesMapKt$tryCoerceValue$1.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(json, "<this>");
        Intrinsics.checkNotNullParameter(serialDescriptor, "elementDescriptor");
        Intrinsics.checkNotNullParameter(function0, "peekNull");
        Intrinsics.checkNotNullParameter(function02, "peekString");
        Intrinsics.checkNotNullParameter(function03, "onEnumCoercing");
        if (!serialDescriptor.isNullable() && ((Boolean) function0.invoke()).booleanValue()) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) serialDescriptor.getKind(), (Object) SerialKind.ENUM.INSTANCE) || (str = (String) function02.invoke()) == null || getJsonNameIndex(serialDescriptor, json, str) != -3) {
            return false;
        }
        function03.invoke();
        return true;
    }

    public static final boolean tryCoerceValue(Json json, SerialDescriptor serialDescriptor, Function0<Boolean> function0, Function0<String> function02, Function0<Unit> function03) {
        String invoke;
        Intrinsics.checkNotNullParameter(json, "<this>");
        Intrinsics.checkNotNullParameter(serialDescriptor, "elementDescriptor");
        Intrinsics.checkNotNullParameter(function0, "peekNull");
        Intrinsics.checkNotNullParameter(function02, "peekString");
        Intrinsics.checkNotNullParameter(function03, "onEnumCoercing");
        if (!serialDescriptor.isNullable() && function0.invoke().booleanValue()) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) serialDescriptor.getKind(), (Object) SerialKind.ENUM.INSTANCE) || (invoke = function02.invoke()) == null || getJsonNameIndex(serialDescriptor, json, invoke) != -3) {
            return false;
        }
        function03.invoke();
        return true;
    }
}
