package expo.modules.kotlin.defaultmodules;

import expo.modules.kotlin.ModuleHolder;
import expo.modules.kotlin.events.KModuleEventEmitterWrapperKt;
import expo.modules.kotlin.views.CallbacksDefinition;
import expo.modules.kotlin.views.ViewManagerDefinition;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0003\u0018\u00012\u0010\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "R", "P0", "<name for destructuring parameter 0>", "", "invoke", "([Ljava/lang/Object;)Ljava/lang/Object;", "expo/modules/kotlin/objects/ObjectDefinitionBuilder$Function$6"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ObjectDefinitionBuilder.kt */
public final class CoreModule$definition$lambda$8$$inlined$Function$5 extends Lambda implements Function1<Object[], Object> {
    final /* synthetic */ CoreModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoreModule$definition$lambda$8$$inlined$Function$5(CoreModule coreModule) {
        super(1);
        this.this$0 = coreModule;
    }

    public final Object invoke(Object[] objArr) {
        ViewManagerDefinition viewManagerDefinition;
        String[] names;
        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
        ModuleHolder<?> moduleHolder = this.this$0.getAppContext().getRegistry().getModuleHolder(objArr[0]);
        Map map = null;
        if (moduleHolder == null || (viewManagerDefinition = moduleHolder.getDefinition().getViewManagerDefinition()) == null) {
            return null;
        }
        Iterable keySet = viewManagerDefinition.getProps$expo_modules_core_release().keySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(keySet, 10)), 16));
        for (Object next : keySet) {
            String str = (String) next;
            linkedHashMap.put(next, true);
        }
        Map map2 = linkedHashMap;
        CallbacksDefinition callbacksDefinition = viewManagerDefinition.getCallbacksDefinition();
        if (!(callbacksDefinition == null || (names = callbacksDefinition.getNames()) == null)) {
            map = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(names.length), 16));
            for (String str2 : names) {
                Pair pair = TuplesKt.to(KModuleEventEmitterWrapperKt.normalizeEventName(str2), MapsKt.mapOf(TuplesKt.to("registrationName", str2)));
                map.put(pair.getFirst(), pair.getSecond());
            }
        }
        return MapsKt.mapOf(TuplesKt.to("validAttributes", map2), TuplesKt.to("directEventTypes", map));
    }
}
