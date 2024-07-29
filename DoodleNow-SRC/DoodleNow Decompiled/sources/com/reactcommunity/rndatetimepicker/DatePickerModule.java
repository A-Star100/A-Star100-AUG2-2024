package com.reactcommunity.rndatetimepicker;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.DatePicker;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.module.annotations.ReactModule;
import java.util.Calendar;

@ReactModule(name = "RNCDatePicker")
public class DatePickerModule extends NativeModuleDatePickerSpec {
    @VisibleForTesting
    public static final String NAME = "RNCDatePicker";

    public String getName() {
        return NAME;
    }

    public DatePickerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private class DatePickerDialogListener implements DatePickerDialog.OnDateSetListener, DialogInterface.OnDismissListener, DialogInterface.OnClickListener {
        private final Bundle mArgs;
        private final Promise mPromise;
        private boolean mPromiseResolved = false;

        public DatePickerDialogListener(Promise promise, Bundle bundle) {
            this.mPromise = promise;
            this.mArgs = bundle;
        }

        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            if (!this.mPromiseResolved && DatePickerModule.this.getReactApplicationContext().hasActiveReactInstance()) {
                RNDate rNDate = new RNDate(this.mArgs);
                Calendar instance = Calendar.getInstance(Common.getTimeZone(this.mArgs));
                instance.set(i, i2, i3, rNDate.hour(), rNDate.minute(), 0);
                instance.set(14, 0);
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putString("action", RNConstants.ACTION_DATE_SET);
                writableNativeMap.putDouble("timestamp", (double) instance.getTimeInMillis());
                writableNativeMap.putDouble("utcOffset", (double) ((instance.getTimeZone().getOffset(instance.getTimeInMillis()) / 1000) / 60));
                this.mPromise.resolve(writableNativeMap);
                this.mPromiseResolved = true;
            }
        }

        public void onDismiss(DialogInterface dialogInterface) {
            if (!this.mPromiseResolved && DatePickerModule.this.getReactApplicationContext().hasActiveReactInstance()) {
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putString("action", RNConstants.ACTION_DISMISSED);
                this.mPromise.resolve(writableNativeMap);
                this.mPromiseResolved = true;
            }
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (!this.mPromiseResolved && DatePickerModule.this.getReactApplicationContext().hasActiveReactInstance()) {
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putString("action", RNConstants.ACTION_NEUTRAL_BUTTON);
                this.mPromise.resolve(writableNativeMap);
                this.mPromiseResolved = true;
            }
        }
    }

    @ReactMethod
    public void dismiss(Promise promise) {
        Common.dismissDialog((FragmentActivity) getCurrentActivity(), NAME, promise);
    }

    @ReactMethod
    public void open(ReadableMap readableMap, Promise promise) {
        FragmentActivity fragmentActivity = (FragmentActivity) getCurrentActivity();
        if (fragmentActivity == null) {
            promise.reject(RNConstants.ERROR_NO_ACTIVITY, "Tried to open a DatePicker dialog while not attached to an Activity");
        } else {
            UiThreadUtil.runOnUiThread(new DatePickerModule$$ExternalSyntheticLambda0(this, fragmentActivity.getSupportFragmentManager(), readableMap, promise));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$open$0(FragmentManager fragmentManager, ReadableMap readableMap, Promise promise) {
        RNDatePickerDialogFragment rNDatePickerDialogFragment = (RNDatePickerDialogFragment) fragmentManager.findFragmentByTag(NAME);
        Bundle createFragmentArguments = createFragmentArguments(readableMap);
        if (rNDatePickerDialogFragment != null) {
            rNDatePickerDialogFragment.update(createFragmentArguments);
            return;
        }
        RNDatePickerDialogFragment rNDatePickerDialogFragment2 = new RNDatePickerDialogFragment();
        rNDatePickerDialogFragment2.setArguments(createFragmentArguments);
        DatePickerDialogListener datePickerDialogListener = new DatePickerDialogListener(promise, createFragmentArguments);
        rNDatePickerDialogFragment2.setOnDismissListener(datePickerDialogListener);
        rNDatePickerDialogFragment2.setOnDateSetListener(datePickerDialogListener);
        rNDatePickerDialogFragment2.setOnNeutralButtonActionListener(datePickerDialogListener);
        rNDatePickerDialogFragment2.show(fragmentManager, NAME);
    }

    private Bundle createFragmentArguments(ReadableMap readableMap) {
        Bundle createFragmentArguments = Common.createFragmentArguments(readableMap);
        if (readableMap.hasKey(RNConstants.ARG_MINDATE) && !readableMap.isNull(RNConstants.ARG_MINDATE)) {
            createFragmentArguments.putLong(RNConstants.ARG_MINDATE, (long) readableMap.getDouble(RNConstants.ARG_MINDATE));
        }
        if (readableMap.hasKey(RNConstants.ARG_MAXDATE) && !readableMap.isNull(RNConstants.ARG_MAXDATE)) {
            createFragmentArguments.putLong(RNConstants.ARG_MAXDATE, (long) readableMap.getDouble(RNConstants.ARG_MAXDATE));
        }
        if (readableMap.hasKey("display") && !readableMap.isNull("display")) {
            createFragmentArguments.putString("display", readableMap.getString("display"));
        }
        if (readableMap.hasKey(RNConstants.ARG_DIALOG_BUTTONS) && !readableMap.isNull(RNConstants.ARG_DIALOG_BUTTONS)) {
            createFragmentArguments.putBundle(RNConstants.ARG_DIALOG_BUTTONS, Arguments.toBundle(readableMap.getMap(RNConstants.ARG_DIALOG_BUTTONS)));
        }
        if (readableMap.hasKey(RNConstants.ARG_TZOFFSET_MINS) && !readableMap.isNull(RNConstants.ARG_TZOFFSET_MINS)) {
            createFragmentArguments.putLong(RNConstants.ARG_TZOFFSET_MINS, (long) readableMap.getDouble(RNConstants.ARG_TZOFFSET_MINS));
        }
        if (readableMap.hasKey("testID") && !readableMap.isNull("testID")) {
            createFragmentArguments.putString("testID", readableMap.getString("testID"));
        }
        if (readableMap.hasKey(RNConstants.FIRST_DAY_OF_WEEK) && !readableMap.isNull(RNConstants.FIRST_DAY_OF_WEEK)) {
            createFragmentArguments.putInt(RNConstants.FIRST_DAY_OF_WEEK, readableMap.getInt(RNConstants.FIRST_DAY_OF_WEEK) + 1);
        }
        return createFragmentArguments;
    }
}
