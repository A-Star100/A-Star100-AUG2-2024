package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.RNSScreenContainerManagerInterface;

public class RNSScreenContainerManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & RNSScreenContainerManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public RNSScreenContainerManagerDelegate(U u) {
        super(u);
    }

    public void setProperty(T t, String str, Object obj) {
        super.setProperty(t, str, obj);
    }
}
