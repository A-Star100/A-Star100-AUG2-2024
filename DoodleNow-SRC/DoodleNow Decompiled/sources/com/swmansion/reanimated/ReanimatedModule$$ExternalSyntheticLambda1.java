package com.swmansion.reanimated;

import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIBlock;
import java.util.ArrayList;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ReanimatedModule$$ExternalSyntheticLambda1 implements UIBlock {
    public final /* synthetic */ ReanimatedModule f$0;
    public final /* synthetic */ ArrayList f$1;

    public /* synthetic */ ReanimatedModule$$ExternalSyntheticLambda1(ReanimatedModule reanimatedModule, ArrayList arrayList) {
        this.f$0 = reanimatedModule;
        this.f$1 = arrayList;
    }

    public final void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
        this.f$0.lambda$willDispatchViewUpdates$1(this.f$1, nativeViewHierarchyManager);
    }
}
