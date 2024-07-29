package com.reactcommunity.rndatetimepicker;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TimePicker;
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

@ReactModule(name = "RNCTimePicker")
public class TimePickerModule extends NativeModuleTimePickerSpec {
    @VisibleForTesting
    public static final String NAME = "RNCTimePicker";

    public String getName() {
        return NAME;
    }

    public TimePickerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private class TimePickerDialogListener implements TimePickerDialog.OnTimeSetListener, DialogInterface.OnDismissListener, DialogInterface.OnClickListener {
        private final Bundle mArgs;
        private final Promise mPromise;
        private boolean mPromiseResolved = false;

        public TimePickerDialogListener(Promise promise, Bundle bundle) {
            this.mPromise = promise;
            this.mArgs = bundle;
        }

        public void onTimeSet(TimePicker timePicker, int i, int i2) {
            if (!this.mPromiseResolved && TimePickerModule.this.getReactApplicationContext().hasActiveReactInstance()) {
                RNDate rNDate = new RNDate(this.mArgs);
                Calendar instance = Calendar.getInstance(Common.getTimeZone(this.mArgs));
                instance.set(rNDate.year(), rNDate.month(), rNDate.day(), i, i2, 0);
                instance.set(14, 0);
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putString("action", RNConstants.ACTION_TIME_SET);
                writableNativeMap.putDouble("timestamp", (double) instance.getTimeInMillis());
                writableNativeMap.putDouble("utcOffset", (double) ((instance.getTimeZone().getOffset(instance.getTimeInMillis()) / 1000) / 60));
                this.mPromise.resolve(writableNativeMap);
                this.mPromiseResolved = true;
            }
        }

        public void onDismiss(DialogInterface dialogInterface) {
            if (!this.mPromiseResolved && TimePickerModule.this.getReactApplicationContext().hasActiveReactInstance()) {
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putString("action", RNConstants.ACTION_DISMISSED);
                this.mPromise.resolve(writableNativeMap);
                this.mPromiseResolved = true;
            }
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (!this.mPromiseResolved && TimePickerModule.this.getReactApplicationContext().hasActiveReactInstance()) {
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
            promise.reject(RNConstants.ERROR_NO_ACTIVITY, "Tried to open a TimePicker dialog while not attached to an Activity");
        } else {
            UiThreadUtil.runOnUiThread(new TimePickerModule$$ExternalSyntheticLambda0(this, fragmentActivity.getSupportFragmentManager(), readableMap, promise));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$open$0(FragmentManager fragmentManager, ReadableMap readableMap, Promise promise) {
        RNTimePickerDialogFragment rNTimePickerDialogFragment = (RNTimePickerDialogFragment) fragmentManager.findFragmentByTag(NAME);
        Bundle createFragmentArguments = createFragmentArguments(readableMap);
        if (rNTimePickerDialogFragment != null) {
            rNTimePickerDialogFragment.update(createFragmentArguments);
            return;
        }
        RNTimePickerDialogFragment rNTimePickerDialogFragment2 = new RNTimePickerDialogFragment();
        rNTimePickerDialogFragment2.setArguments(createFragmentArguments);
        TimePickerDialogListener timePickerDialogListener = new TimePickerDialogListener(promise, createFragmentArguments);
        rNTimePickerDialogFragment2.setOnDismissListener(timePickerDialogListener);
        rNTimePickerDialogFragment2.setOnTimeSetListener(timePickerDialogListener);
        rNTimePickerDialogFragment2.setOnNeutralButtonActionListener(timePickerDialogListener);
        rNTimePickerDialogFragment2.show(fragmentManager, NAME);
    }

    private Bundle createFragmentArguments(ReadableMap readableMap) {
        Bundle createFragmentArguments = Common.createFragmentArguments(readableMap);
        if (readableMap.hasKey(RNConstants.ARG_IS24HOUR) && !readableMap.isNull(RNConstants.ARG_IS24HOUR)) {
            createFragmentArguments.putBoolean(RNConstants.ARG_IS24HOUR, readableMap.getBoolean(RNConstants.ARG_IS24HOUR));
        }
        if (readableMap.hasKey("display") && !readableMap.isNull("display")) {
            createFragmentArguments.putString("display", readableMap.getString("display"));
        }
        if (readableMap.hasKey(RNConstants.ARG_DIALOG_BUTTONS) && !readableMap.isNull(RNConstants.ARG_DIALOG_BUTTONS)) {
            createFragmentArguments.putBundle(RNConstants.ARG_DIALOG_BUTTONS, Arguments.toBundle(readableMap.getMap(RNConstants.ARG_DIALOG_BUTTONS)));
        }
        if (readableMap.hasKey(RNConstants.ARG_INTERVAL) && !readableMap.isNull(RNConstants.ARG_INTERVAL)) {
            createFragmentArguments.putInt(RNConstants.ARG_INTERVAL, readableMap.getInt(RNConstants.ARG_INTERVAL));
        }
        if (readableMap.hasKey(RNConstants.ARG_TZOFFSET_MINS) && !readableMap.isNull(RNConstants.ARG_TZOFFSET_MINS)) {
            createFragmentArguments.putLong(RNConstants.ARG_TZOFFSET_MINS, (long) readableMap.getDouble(RNConstants.ARG_TZOFFSET_MINS));
        }
        return createFragmentArguments;
    }
}
