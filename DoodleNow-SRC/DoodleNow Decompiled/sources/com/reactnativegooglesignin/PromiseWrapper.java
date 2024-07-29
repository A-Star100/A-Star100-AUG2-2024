package com.reactnativegooglesignin;

import android.util.Log;
import com.facebook.react.bridge.Promise;

public class PromiseWrapper {
    public static final String ASYNC_OP_IN_PROGRESS = "ASYNC_OP_IN_PROGRESS";
    private final String MODULE_NAME;
    private String nameOfCallInProgress;
    private Promise promise;

    private void resetMembers() {
        this.nameOfCallInProgress = null;
        this.promise = null;
    }

    public String getNameOfCallInProgress() {
        return this.nameOfCallInProgress;
    }

    public PromiseWrapper(String str) {
        this.MODULE_NAME = str;
    }

    public void setPromiseWithInProgressCheck(Promise promise2, String str) {
        Promise promise3 = this.promise;
        if (promise3 != null) {
            rejectPreviousPromiseBecauseNewOneIsInProgress(promise3, str);
        }
        this.promise = promise2;
        this.nameOfCallInProgress = str;
    }

    public void resolve(Object obj) {
        Promise promise2 = this.promise;
        if (promise2 == null) {
            Log.e(this.MODULE_NAME, "cannot resolve promise because it's null");
            return;
        }
        resetMembers();
        promise2.resolve(obj);
    }

    public void reject(String str) {
        reject(this.nameOfCallInProgress, str);
    }

    public void reject(String str, String str2) {
        Promise promise2 = this.promise;
        if (promise2 == null) {
            Log.e(this.MODULE_NAME, "cannot reject promise because it's null");
            return;
        }
        resetMembers();
        promise2.reject(str, str2);
    }

    public void reject(Exception exc) {
        Promise promise2 = this.promise;
        String str = this.nameOfCallInProgress;
        if (promise2 == null) {
            Log.e(this.MODULE_NAME, "cannot reject promise because it's null");
            return;
        }
        ErrorDto errorDto = new ErrorDto(exc, str);
        resetMembers();
        promise2.reject(errorDto.getCode(), errorDto.getMessage(), (Throwable) exc);
    }

    private void rejectPreviousPromiseBecauseNewOneIsInProgress(Promise promise2, String str) {
        promise2.reject(ASYNC_OP_IN_PROGRESS, "Warning: previous promise did not settle and was overwritten. You've called \"" + str + "\" while \"" + getNameOfCallInProgress() + "\" was already in progress and has not completed yet.");
    }
}
