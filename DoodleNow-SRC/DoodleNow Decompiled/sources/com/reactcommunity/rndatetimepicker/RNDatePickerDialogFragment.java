package com.reactcommunity.rndatetimepicker;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.widget.DatePicker;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import java.util.Calendar;
import java.util.Locale;

public class RNDatePickerDialogFragment extends DialogFragment {
    private DatePickerDialog instance;
    private DatePickerDialog.OnDateSetListener mOnDateSetListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private DialogInterface.OnClickListener mOnNeutralButtonActionListener;

    /* access modifiers changed from: package-private */
    public void setOnDateSetListener(DatePickerDialog.OnDateSetListener onDateSetListener) {
        this.mOnDateSetListener = onDateSetListener;
    }

    /* access modifiers changed from: package-private */
    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    /* access modifiers changed from: package-private */
    public void setOnNeutralButtonActionListener(DialogInterface.OnClickListener onClickListener) {
        this.mOnNeutralButtonActionListener = onClickListener;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        DatePickerDialog createDialog = createDialog(getArguments());
        this.instance = createDialog;
        return createDialog;
    }

    public void update(Bundle bundle) {
        RNDate rNDate = new RNDate(bundle);
        this.instance.updateDate(rNDate.year(), rNDate.month(), rNDate.day());
    }

    static DatePickerDialog getDialog(Bundle bundle, Context context, DatePickerDialog.OnDateSetListener onDateSetListener) {
        RNDate rNDate = new RNDate(bundle);
        int year = rNDate.year();
        int month = rNDate.month();
        int day = rNDate.day();
        RNDatePickerDisplay displayDate = (bundle == null || bundle.getString("display", (String) null) == null) ? Common.getDisplayDate(bundle) : RNDatePickerDisplay.valueOf(bundle.getString("display").toUpperCase(Locale.US));
        if (displayDate != RNDatePickerDisplay.SPINNER) {
            return new RNDismissableDatePickerDialog(context, onDateSetListener, year, month, day, displayDate);
        }
        return new RNDismissableDatePickerDialog(context, R.style.SpinnerDatePickerDialog, onDateSetListener, year, month, day, displayDate);
    }

    private DatePickerDialog createDialog(Bundle bundle) {
        FragmentActivity activity = getActivity();
        DatePickerDialog dialog = getDialog(bundle, activity, this.mOnDateSetListener);
        if (bundle != null) {
            Common.setButtonTitles(bundle, dialog, this.mOnNeutralButtonActionListener);
            if (activity != null) {
                dialog.setOnShowListener(Common.setButtonTextColor(activity, dialog, bundle, Common.getDisplayDate(bundle) == RNDatePickerDisplay.SPINNER));
            }
        }
        DatePicker datePicker = dialog.getDatePicker();
        long minDateWithTimeZone = Common.minDateWithTimeZone(bundle);
        long maxDateWithTimeZone = Common.maxDateWithTimeZone(bundle);
        if (bundle.containsKey(RNConstants.ARG_MINDATE)) {
            datePicker.setMinDate(minDateWithTimeZone);
        } else {
            datePicker.setMinDate(RNConstants.DEFAULT_MIN_DATE);
        }
        if (bundle.containsKey(RNConstants.ARG_MAXDATE)) {
            datePicker.setMaxDate(maxDateWithTimeZone);
        }
        if (bundle.containsKey(RNConstants.FIRST_DAY_OF_WEEK)) {
            datePicker.setFirstDayOfWeek(bundle.getInt(RNConstants.FIRST_DAY_OF_WEEK));
        }
        if (Build.VERSION.SDK_INT >= 26 && (bundle.containsKey(RNConstants.ARG_MAXDATE) || bundle.containsKey(RNConstants.ARG_MINDATE))) {
            datePicker.setOnDateChangedListener(new RNDatePickerDialogFragment$$ExternalSyntheticLambda1(bundle, minDateWithTimeZone, maxDateWithTimeZone, datePicker));
        }
        if (bundle.containsKey("testID")) {
            datePicker.setTag(bundle.getString("testID"));
        }
        return dialog;
    }

    static /* synthetic */ void lambda$createDialog$0(Bundle bundle, long j, long j2, DatePicker datePicker, DatePicker datePicker2, int i, int i2, int i3) {
        Calendar instance2 = Calendar.getInstance(Common.getTimeZone(bundle));
        instance2.set(i, i2, i3, 0, 0, 0);
        long j3 = j;
        long j4 = j2;
        instance2.setTimeInMillis(Math.min(Math.max(instance2.getTimeInMillis(), j), j2));
        if (datePicker.getYear() != instance2.get(1) || datePicker.getMonth() != instance2.get(2) || datePicker.getDayOfMonth() != instance2.get(5)) {
            DatePicker datePicker3 = datePicker;
            datePicker.updateDate(instance2.get(1), instance2.get(2), instance2.get(5));
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        DialogInterface.OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }
}
