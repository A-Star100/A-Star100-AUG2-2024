package com.onesignal.common;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: JSONObjectExtensions.kt */
final class JSONObjectExtensionsKt$putMap$1 extends Lambda implements Function1<JSONObject, Unit> {
    final /* synthetic */ Map<String, Object> $map;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JSONObjectExtensionsKt$putMap$1(Map<String, ? extends Object> map) {
        super(1);
        this.$map = map;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((JSONObject) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "it");
        JSONObjectExtensionsKt.putMap(jSONObject, this.$map);
    }
}
