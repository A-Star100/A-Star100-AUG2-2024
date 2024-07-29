package com.reactcommunity.rndatetimepicker;

import android.os.Bundle;
import android.widget.DatePicker;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class RNDatePickerDialogFragment$$ExternalSyntheticLambda1 implements DatePicker.OnDateChangedListener {
    public final /* synthetic */ Bundle f$0;
    public final /* synthetic */ long f$1;
    public final /* synthetic */ long f$2;
    public final /* synthetic */ DatePicker f$3;

    public /* synthetic */ RNDatePickerDialogFragment$$ExternalSyntheticLambda1(Bundle bundle, long j, long j2, DatePicker datePicker) {
        this.f$0 = bundle;
        this.f$1 = j;
        this.f$2 = j2;
        this.f$3 = datePicker;
    }

    public final void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
        RNDatePickerDialogFragment.lambda$createDialog$0(this.f$0, this.f$1, this.f$2, this.f$3, datePicker, i, i2, i3);
    }
}
