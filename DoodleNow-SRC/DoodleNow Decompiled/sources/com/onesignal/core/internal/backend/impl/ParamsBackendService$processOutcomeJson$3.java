package com.onesignal.core.internal.backend.impl;

import com.facebook.react.uimanager.ViewProps;
import com.onesignal.common.JSONObjectExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ParamsBackendService.kt */
final class ParamsBackendService$processOutcomeJson$3 extends Lambda implements Function1<JSONObject, Unit> {
    final /* synthetic */ Ref.ObjectRef<Boolean> $isUnattributedEnabled;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ParamsBackendService$processOutcomeJson$3(Ref.ObjectRef<Boolean> objectRef) {
        super(1);
        this.$isUnattributedEnabled = objectRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((JSONObject) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "it");
        this.$isUnattributedEnabled.element = JSONObjectExtensionsKt.safeBool(jSONObject, ViewProps.ENABLED);
    }
}
