package com.reactnativegooglesignin;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.google.android.gms.common.SignInButton;

public class RNGoogleSigninButtonManagerDelegate implements ViewManagerDelegate<SignInButton> {
    RNGoogleSigninButtonManagerDelegate(RNGoogleSigninButtonViewManager rNGoogleSigninButtonViewManager) {
    }

    public void setProperty(SignInButton signInButton, String str, Object obj) {
        throw new RuntimeException("setProperty must not be called");
    }

    public void receiveCommand(SignInButton signInButton, String str, ReadableArray readableArray) {
        throw new RuntimeException("receiveCommand must not be called");
    }
}
