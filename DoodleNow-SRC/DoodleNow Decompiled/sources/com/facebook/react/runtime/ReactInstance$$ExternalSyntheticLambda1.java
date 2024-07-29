package com.facebook.react.runtime;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.NativeMap;
import com.facebook.react.uimanager.UIConstantsProviderManager;
import com.facebook.react.uimanager.UIManagerModuleConstantsHelper;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ReactInstance$$ExternalSyntheticLambda1 implements UIConstantsProviderManager.DefaultEventTypesProvider {
    public final NativeMap getDefaultEventTypes() {
        return Arguments.makeNativeMap(UIManagerModuleConstantsHelper.getDefaultExportableEventTypes());
    }
}
