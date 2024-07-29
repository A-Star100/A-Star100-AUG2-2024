package com.onesignal.inAppMessages.internal;

import android.content.DialogInterface;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class InAppMessagesManager$$ExternalSyntheticLambda0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ InAppMessagesManager f$0;
    public final /* synthetic */ InAppMessage f$1;
    public final /* synthetic */ List f$2;

    public /* synthetic */ InAppMessagesManager$$ExternalSyntheticLambda0(InAppMessagesManager inAppMessagesManager, InAppMessage inAppMessage, List list) {
        this.f$0 = inAppMessagesManager;
        this.f$1 = inAppMessage;
        this.f$2 = list;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        InAppMessagesManager.m1035showAlertDialogMessage$lambda5(this.f$0, this.f$1, this.f$2, dialogInterface, i);
    }
}
