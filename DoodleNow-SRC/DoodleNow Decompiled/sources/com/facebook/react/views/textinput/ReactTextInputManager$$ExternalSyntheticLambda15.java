package com.facebook.react.views.textinput;

import android.view.View;
import com.facebook.react.uimanager.ThemedReactContext;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ReactTextInputManager$$ExternalSyntheticLambda15 implements View.OnFocusChangeListener {
    public final /* synthetic */ ThemedReactContext f$0;
    public final /* synthetic */ ReactEditText f$1;

    public /* synthetic */ ReactTextInputManager$$ExternalSyntheticLambda15(ThemedReactContext themedReactContext, ReactEditText reactEditText) {
        this.f$0 = themedReactContext;
        this.f$1 = reactEditText;
    }

    public final void onFocusChange(View view, boolean z) {
        ReactTextInputManager.lambda$addEventEmitters$0(this.f$0, this.f$1, view, z);
    }
}
