package com.facebook.react.runtime.hermes;

import com.facebook.jni.HybridData;
import com.facebook.react.fabric.ReactNativeConfig;
import com.facebook.react.runtime.JSRuntimeFactory;
import com.facebook.soloader.SoLoader;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/facebook/react/runtime/hermes/HermesInstance;", "Lcom/facebook/react/runtime/JSRuntimeFactory;", "()V", "reactNativeConfig", "Lcom/facebook/react/fabric/ReactNativeConfig;", "(Lcom/facebook/react/fabric/ReactNativeConfig;)V", "Companion", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: HermesInstance.kt */
public final class HermesInstance extends JSRuntimeFactory {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @JvmStatic
    protected static final native HybridData initHybrid(Object obj);

    public HermesInstance(ReactNativeConfig reactNativeConfig) {
        super(initHybrid(reactNativeConfig));
    }

    public HermesInstance() {
        this((ReactNativeConfig) null);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H ¨\u0006\u0006"}, d2 = {"Lcom/facebook/react/runtime/hermes/HermesInstance$Companion;", "", "()V", "initHybrid", "Lcom/facebook/jni/HybridData;", "reactNativeConfig", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: HermesInstance.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: protected */
        @JvmStatic
        public final HybridData initHybrid(Object obj) {
            return HermesInstance.initHybrid(obj);
        }

        private Companion() {
        }
    }

    static {
        SoLoader.loadLibrary("hermesinstancejni");
    }
}
