package com.onesignal.notifications.internal.registration.impl;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.onesignal.common.AndroidUtils;
import com.onesignal.core.internal.config.ConfigModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.notifications.internal.registration.impl.GooglePlayServicesUpgradePrompt$showUpdateGPSDialog$2", f = "GooglePlayServicesUpgradePrompt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: GooglePlayServicesUpgradePrompt.kt */
final class GooglePlayServicesUpgradePrompt$showUpdateGPSDialog$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GooglePlayServicesUpgradePrompt this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GooglePlayServicesUpgradePrompt$showUpdateGPSDialog$2(GooglePlayServicesUpgradePrompt googlePlayServicesUpgradePrompt, Continuation<? super GooglePlayServicesUpgradePrompt$showUpdateGPSDialog$2> continuation) {
        super(2, continuation);
        this.this$0 = googlePlayServicesUpgradePrompt;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GooglePlayServicesUpgradePrompt$showUpdateGPSDialog$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GooglePlayServicesUpgradePrompt$showUpdateGPSDialog$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Activity current = this.this$0._applicationService.getCurrent();
            if (current == null) {
                return Unit.INSTANCE;
            }
            Context context = current;
            String resourceString = AndroidUtils.INSTANCE.getResourceString(context, "onesignal_gms_missing_alert_text", "To receive push notifications please press 'Update' to enable 'Google Play services'.");
            String resourceString2 = AndroidUtils.INSTANCE.getResourceString(context, "onesignal_gms_missing_alert_button_update", "Update");
            String resourceString3 = AndroidUtils.INSTANCE.getResourceString(context, "onesignal_gms_missing_alert_button_skip", "Skip");
            new AlertDialog.Builder(context).setMessage(resourceString).setPositiveButton(resourceString2, new GooglePlayServicesUpgradePrompt$showUpdateGPSDialog$2$$ExternalSyntheticLambda0(this.this$0, current)).setNegativeButton(resourceString3, new GooglePlayServicesUpgradePrompt$showUpdateGPSDialog$2$$ExternalSyntheticLambda1(this.this$0)).setNeutralButton(AndroidUtils.INSTANCE.getResourceString(context, "onesignal_gms_missing_alert_button_close", "Close"), (DialogInterface.OnClickListener) null).create().show();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* access modifiers changed from: private */
    /* renamed from: invokeSuspend$lambda-0  reason: not valid java name */
    public static final void m1043invokeSuspend$lambda0(GooglePlayServicesUpgradePrompt googlePlayServicesUpgradePrompt, Activity activity, DialogInterface dialogInterface, int i) {
        googlePlayServicesUpgradePrompt.openPlayStoreToApp(activity);
    }

    /* access modifiers changed from: private */
    /* renamed from: invokeSuspend$lambda-1  reason: not valid java name */
    public static final void m1044invokeSuspend$lambda1(GooglePlayServicesUpgradePrompt googlePlayServicesUpgradePrompt, DialogInterface dialogInterface, int i) {
        ((ConfigModel) googlePlayServicesUpgradePrompt._configModelStore.getModel()).setUserRejectedGMSUpdate(true);
    }
}
