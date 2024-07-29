package com.facebook.react;

import com.facebook.react.bridge.ReactApplicationContext;
import java.util.Iterator;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BaseReactPackage$$ExternalSyntheticLambda0 implements Iterable {
    public final /* synthetic */ BaseReactPackage f$0;
    public final /* synthetic */ Iterator f$1;
    public final /* synthetic */ ReactApplicationContext f$2;

    public /* synthetic */ BaseReactPackage$$ExternalSyntheticLambda0(BaseReactPackage baseReactPackage, Iterator it, ReactApplicationContext reactApplicationContext) {
        this.f$0 = baseReactPackage;
        this.f$1 = it;
        this.f$2 = reactApplicationContext;
    }

    public final Iterator iterator() {
        return this.f$0.lambda$getNativeModuleIterator$0(this.f$1, this.f$2);
    }
}
