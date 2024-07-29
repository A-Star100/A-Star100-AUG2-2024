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

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "indirectJSON", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ParamsBackendService.kt */
final class ParamsBackendService$processOutcomeJson$2 extends Lambda implements Function1<JSONObject, Unit> {
    final /* synthetic */ Ref.ObjectRef<Integer> $iamLimit;
    final /* synthetic */ Ref.ObjectRef<Integer> $indirectIAMAttributionWindow;
    final /* synthetic */ Ref.ObjectRef<Integer> $indirectNotificationAttributionWindow;
    final /* synthetic */ Ref.ObjectRef<Boolean> $isIndirectEnabled;
    final /* synthetic */ Ref.ObjectRef<Integer> $notificationLimit;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ParamsBackendService$processOutcomeJson$2(Ref.ObjectRef<Boolean> objectRef, Ref.ObjectRef<Integer> objectRef2, Ref.ObjectRef<Integer> objectRef3, Ref.ObjectRef<Integer> objectRef4, Ref.ObjectRef<Integer> objectRef5) {
        super(1);
        this.$isIndirectEnabled = objectRef;
        this.$indirectNotificationAttributionWindow = objectRef2;
        this.$notificationLimit = objectRef3;
        this.$indirectIAMAttributionWindow = objectRef4;
        this.$iamLimit = objectRef5;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((JSONObject) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "indirectJSON");
        this.$isIndirectEnabled.element = JSONObjectExtensionsKt.safeBool(jSONObject, ViewProps.ENABLED);
        final Ref.ObjectRef<Integer> objectRef = this.$indirectNotificationAttributionWindow;
        final Ref.ObjectRef<Integer> objectRef2 = this.$notificationLimit;
        JSONObjectExtensionsKt.expandJSONObject(jSONObject, "notification_attribution", new Function1<JSONObject, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((JSONObject) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(JSONObject jSONObject) {
                Intrinsics.checkNotNullParameter(jSONObject, "it");
                objectRef.element = JSONObjectExtensionsKt.safeInt(jSONObject, "minutes_since_displayed");
                objectRef2.element = JSONObjectExtensionsKt.safeInt(jSONObject, "limit");
            }
        });
        final Ref.ObjectRef<Integer> objectRef3 = this.$indirectIAMAttributionWindow;
        final Ref.ObjectRef<Integer> objectRef4 = this.$iamLimit;
        JSONObjectExtensionsKt.expandJSONObject(jSONObject, "in_app_message_attribution", new Function1<JSONObject, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((JSONObject) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(JSONObject jSONObject) {
                Intrinsics.checkNotNullParameter(jSONObject, "it");
                objectRef3.element = JSONObjectExtensionsKt.safeInt(jSONObject, "minutes_since_displayed");
                objectRef4.element = JSONObjectExtensionsKt.safeInt(jSONObject, "limit");
            }
        });
    }
}
