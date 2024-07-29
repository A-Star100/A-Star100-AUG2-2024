package com.reactnativegooglesignin;

import android.content.Context;
import android.view.View;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.android.gms.common.SignInButton;
import java.util.HashMap;
import java.util.Map;

public class RNGoogleSigninButtonViewManager extends SimpleViewManager<SignInButton> implements RNGoogleSigninButtonManagerInterface<SignInButton> {
    public static final String MODULE_NAME = "RNGoogleSigninButton";
    private static final View.OnClickListener mOnClickListener = new RNGoogleSigninButtonViewManager$$ExternalSyntheticLambda0();
    private final ViewManagerDelegate<SignInButton> mDelegate = new RNGoogleSigninButtonManagerDelegate(this);

    /* access modifiers changed from: protected */
    public ViewManagerDelegate<SignInButton> getDelegate() {
        return null;
    }

    public String getName() {
        return MODULE_NAME;
    }

    static /* synthetic */ void lambda$static$0(View view) {
        ReactContext reactContext = (ReactContext) view.getContext();
        int id = view.getId();
        UIManagerHelper.getEventDispatcherForReactTag(reactContext, id).dispatchEvent(new SigninButtonEvent(UIManagerHelper.getSurfaceId((Context) reactContext), id));
    }

    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        Map<String, Object> exportedCustomBubblingEventTypeConstants = super.getExportedCustomBubblingEventTypeConstants();
        if (exportedCustomBubblingEventTypeConstants == null) {
            exportedCustomBubblingEventTypeConstants = new HashMap<>();
        }
        exportedCustomBubblingEventTypeConstants.put(SigninButtonEvent.EVENT_NAME, MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onPress")));
        return exportedCustomBubblingEventTypeConstants;
    }

    /* access modifiers changed from: protected */
    public SignInButton createViewInstance(ThemedReactContext themedReactContext) {
        return new SignInButton(themedReactContext);
    }

    /* access modifiers changed from: protected */
    public void addEventEmitters(ThemedReactContext themedReactContext, SignInButton signInButton) {
        signInButton.setOnClickListener(mOnClickListener);
    }

    @ReactProp(name = "size")
    public void setSize(SignInButton signInButton, int i) {
        signInButton.setSize(i);
    }

    @ReactProp(name = "disabled")
    public void setDisabled(SignInButton signInButton, boolean z) {
        signInButton.setEnabled(!z);
    }

    @ReactProp(name = "color")
    public void setColor(SignInButton signInButton, String str) {
        if (str == null) {
            signInButton.setColorScheme(2);
        } else {
            signInButton.setColorScheme("dark".equals(str) ^ true ? 1 : 0);
        }
    }
}
