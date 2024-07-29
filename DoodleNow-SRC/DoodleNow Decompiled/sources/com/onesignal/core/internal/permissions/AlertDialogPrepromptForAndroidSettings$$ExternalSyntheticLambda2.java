package com.onesignal.core.internal.permissions;

import android.content.DialogInterface;
import com.onesignal.core.internal.permissions.AlertDialogPrepromptForAndroidSettings;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AlertDialogPrepromptForAndroidSettings$$ExternalSyntheticLambda2 implements DialogInterface.OnCancelListener {
    public final /* synthetic */ AlertDialogPrepromptForAndroidSettings.Callback f$0;

    public /* synthetic */ AlertDialogPrepromptForAndroidSettings$$ExternalSyntheticLambda2(AlertDialogPrepromptForAndroidSettings.Callback callback) {
        this.f$0 = callback;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        AlertDialogPrepromptForAndroidSettings.m1031show$lambda2(this.f$0, dialogInterface);
    }
}
