package com.reactcommunity.rndatetimepicker;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Common$$ExternalSyntheticLambda0 implements DialogInterface.OnShowListener {
    public final /* synthetic */ AlertDialog f$0;
    public final /* synthetic */ Context f$1;
    public final /* synthetic */ Bundle f$2;
    public final /* synthetic */ boolean f$3;

    public /* synthetic */ Common$$ExternalSyntheticLambda0(AlertDialog alertDialog, Context context, Bundle bundle, boolean z) {
        this.f$0 = alertDialog;
        this.f$1 = context;
        this.f$2 = bundle;
        this.f$3 = z;
    }

    public final void onShow(DialogInterface dialogInterface) {
        Common.lambda$setButtonTextColor$0(this.f$0, this.f$1, this.f$2, this.f$3, dialogInterface);
    }
}
