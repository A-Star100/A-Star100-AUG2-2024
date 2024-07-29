package com.airbnb.android.react.lottie;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.amazon.device.iap.internal.c.b;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u0006\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0016\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bH\u0016J\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0002H\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u0002H\u0014J\"\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u001a\u0010\u001c\u001a\u00020\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001d\u001a\u00020\u001bH\u0007J\u001a\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u0018H\u0007J\u0018\u0010 \u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u001bH\u0007J\u001f\u0010\"\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010#\u001a\u0004\u0018\u00010\u001bH\u0007¢\u0006\u0002\u0010$J\u001a\u0010%\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010&\u001a\u0004\u0018\u00010\fH\u0007J\u0018\u0010'\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u001bH\u0007J\u0018\u0010)\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010*\u001a\u00020+H\u0007J\u001a\u0010,\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010-\u001a\u0004\u0018\u00010\fH\u0007J\u001a\u0010.\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010/\u001a\u0004\u0018\u00010\fH\u0007J\u001a\u00100\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00022\b\u00101\u001a\u0004\u0018\u00010\fH\u0007J\u001a\u00102\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00022\b\u00103\u001a\u0004\u0018\u00010\fH\u0007J\u001a\u00104\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00022\b\u00105\u001a\u0004\u0018\u00010\fH\u0007J\u001a\u00106\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00022\b\u00107\u001a\u0004\u0018\u00010\fH\u0007J\u0018\u00108\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u00109\u001a\u00020:H\u0007J\u001a\u0010;\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010<\u001a\u0004\u0018\u00010\u0018H\u0007R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/airbnb/android/react/lottie/LottieAnimationViewManager;", "Lcom/facebook/react/uimanager/SimpleViewManager;", "Lcom/airbnb/lottie/LottieAnimationView;", "()V", "propManagersMap", "Ljava/util/WeakHashMap;", "Lcom/airbnb/android/react/lottie/LottieAnimationViewPropertyManager;", "createViewInstance", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getExportedCustomDirectEventTypeConstants", "", "", "", "getExportedViewConstants", "", "getName", "getOrCreatePropertyManager", "view", "onAfterUpdateTransaction", "", "receiveCommand", "commandName", "args", "Lcom/facebook/react/bridge/ReadableArray;", "setAutoPlay", "autoPlay", "", "setCacheComposition", "cacheComposition", "setColorFilters", "colorFilters", "setEnableMergePaths", "enableMergePaths", "setHardwareAccelerationAndroid", "hardwareAccelerationAndroid", "(Lcom/airbnb/lottie/LottieAnimationView;Ljava/lang/Boolean;)V", "setImageAssetsFolder", "imageAssetsFolder", "setLoop", "loop", "setProgress", "progress", "", "setRenderMode", "renderMode", "setResizeMode", "resizeMode", "setSourceDotLottie", "uri", "setSourceJson", "json", "setSourceName", "name", "setSourceURL", "urlString", "setSpeed", "speed", "", "setTextFilters", "textFilters", "lottie-react-native_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LottieAnimationViewManager.kt */
public final class LottieAnimationViewManager extends SimpleViewManager<LottieAnimationView> {
    private final WeakHashMap<LottieAnimationView, LottieAnimationViewPropertyManager> propManagersMap = new WeakHashMap<>();

    public String getName() {
        return LottieAnimationViewManagerImpl.REACT_CLASS;
    }

    private final LottieAnimationViewPropertyManager getOrCreatePropertyManager(LottieAnimationView lottieAnimationView) {
        LottieAnimationViewPropertyManager lottieAnimationViewPropertyManager = this.propManagersMap.get(lottieAnimationView);
        if (lottieAnimationViewPropertyManager != null) {
            return lottieAnimationViewPropertyManager;
        }
        LottieAnimationViewPropertyManager lottieAnimationViewPropertyManager2 = new LottieAnimationViewPropertyManager(lottieAnimationView);
        this.propManagersMap.put(lottieAnimationView, lottieAnimationViewPropertyManager2);
        return lottieAnimationViewPropertyManager2;
    }

    public Map<String, Object> getExportedViewConstants() {
        return LottieAnimationViewManagerImpl.getExportedViewConstants();
    }

    public LottieAnimationView createViewInstance(ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(themedReactContext, "context");
        LottieAnimationView createViewInstance = LottieAnimationViewManagerImpl.createViewInstance(themedReactContext);
        createViewInstance.setFailureListener(new LottieAnimationViewManager$$ExternalSyntheticLambda0(createViewInstance));
        createViewInstance.addLottieOnCompositionLoadedListener(new LottieAnimationViewManager$$ExternalSyntheticLambda1(createViewInstance));
        createViewInstance.addAnimatorListener(new LottieAnimationViewManager$createViewInstance$3(createViewInstance));
        return createViewInstance;
    }

    /* access modifiers changed from: private */
    public static final void createViewInstance$lambda$0(LottieAnimationView lottieAnimationView, Throwable th) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "$view");
        Intrinsics.checkNotNull(th);
        LottieAnimationViewManagerImpl.sendAnimationFailureEvent(lottieAnimationView, th);
    }

    /* access modifiers changed from: private */
    public static final void createViewInstance$lambda$1(LottieAnimationView lottieAnimationView, LottieComposition lottieComposition) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "$view");
        LottieAnimationViewManagerImpl.sendAnimationLoadedEvent(lottieAnimationView);
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return LottieAnimationViewManagerImpl.getExportedCustomDirectEventTypeConstants();
    }

    public void receiveCommand(LottieAnimationView lottieAnimationView, String str, ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "view");
        Intrinsics.checkNotNullParameter(str, "commandName");
        switch (str.hashCode()) {
            case -934426579:
                if (str.equals("resume")) {
                    LottieAnimationViewManagerImpl.resume(lottieAnimationView);
                    return;
                }
                return;
            case 3443508:
                if (str.equals("play")) {
                    int i = -1;
                    int i2 = readableArray != null ? readableArray.getInt(0) : -1;
                    if (readableArray != null) {
                        i = readableArray.getInt(1);
                    }
                    LottieAnimationViewManagerImpl.play(lottieAnimationView, i2, i);
                    return;
                }
                return;
            case 106440182:
                if (str.equals("pause")) {
                    LottieAnimationViewManagerImpl.pause(lottieAnimationView);
                    return;
                }
                return;
            case 108404047:
                if (str.equals(b.at)) {
                    LottieAnimationViewManagerImpl.reset(lottieAnimationView);
                    return;
                }
                return;
            default:
                return;
        }
    }

    @ReactProp(name = "sourceName")
    public final void setSourceName(LottieAnimationView lottieAnimationView, String str) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "view");
        LottieAnimationViewManagerImpl.setSourceName(str, getOrCreatePropertyManager(lottieAnimationView));
    }

    @ReactProp(name = "sourceJson")
    public final void setSourceJson(LottieAnimationView lottieAnimationView, String str) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "view");
        LottieAnimationViewManagerImpl.setSourceJson(str, getOrCreatePropertyManager(lottieAnimationView));
    }

    @ReactProp(name = "sourceURL")
    public final void setSourceURL(LottieAnimationView lottieAnimationView, String str) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "view");
        LottieAnimationViewManagerImpl.setSourceURL(str, getOrCreatePropertyManager(lottieAnimationView));
    }

    @ReactProp(name = "cacheComposition")
    public final void setCacheComposition(LottieAnimationView lottieAnimationView, boolean z) {
        Intrinsics.checkNotNull(lottieAnimationView);
        LottieAnimationViewManagerImpl.setCacheComposition(lottieAnimationView, z);
    }

    @ReactProp(name = "resizeMode")
    public final void setResizeMode(LottieAnimationView lottieAnimationView, String str) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "view");
        LottieAnimationViewManagerImpl.setResizeMode(str, getOrCreatePropertyManager(lottieAnimationView));
    }

    @ReactProp(name = "renderMode")
    public final void setRenderMode(LottieAnimationView lottieAnimationView, String str) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "view");
        LottieAnimationViewManagerImpl.setRenderMode(str, getOrCreatePropertyManager(lottieAnimationView));
    }

    @ReactProp(name = "hardwareAccelerationAndroid")
    public final void setHardwareAccelerationAndroid(LottieAnimationView lottieAnimationView, Boolean bool) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "view");
        Intrinsics.checkNotNull(bool);
        LottieAnimationViewManagerImpl.setHardwareAcceleration(bool.booleanValue(), getOrCreatePropertyManager(lottieAnimationView));
    }

    @ReactProp(name = "progress")
    public final void setProgress(LottieAnimationView lottieAnimationView, float f) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "view");
        LottieAnimationViewManagerImpl.setProgress(f, getOrCreatePropertyManager(lottieAnimationView));
    }

    @ReactProp(name = "speed")
    public final void setSpeed(LottieAnimationView lottieAnimationView, double d) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "view");
        LottieAnimationViewManagerImpl.setSpeed(d, getOrCreatePropertyManager(lottieAnimationView));
    }

    @ReactProp(name = "loop")
    public final void setLoop(LottieAnimationView lottieAnimationView, boolean z) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "view");
        LottieAnimationViewManagerImpl.setLoop(z, getOrCreatePropertyManager(lottieAnimationView));
    }

    @ReactProp(name = "autoPlay")
    public final void setAutoPlay(LottieAnimationView lottieAnimationView, boolean z) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "view");
        LottieAnimationViewManagerImpl.setAutoPlay(z, getOrCreatePropertyManager(lottieAnimationView));
    }

    @ReactProp(name = "imageAssetsFolder")
    public final void setImageAssetsFolder(LottieAnimationView lottieAnimationView, String str) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "view");
        LottieAnimationViewManagerImpl.setImageAssetsFolder(str, getOrCreatePropertyManager(lottieAnimationView));
    }

    @ReactProp(name = "enableMergePathsAndroidForKitKatAndAbove")
    public final void setEnableMergePaths(LottieAnimationView lottieAnimationView, boolean z) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "view");
        LottieAnimationViewManagerImpl.setEnableMergePaths(z, getOrCreatePropertyManager(lottieAnimationView));
    }

    @ReactProp(name = "colorFilters")
    public final void setColorFilters(LottieAnimationView lottieAnimationView, ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "view");
        LottieAnimationViewManagerImpl.setColorFilters(readableArray, getOrCreatePropertyManager(lottieAnimationView));
    }

    @ReactProp(name = "textFiltersAndroid")
    public final void setTextFilters(LottieAnimationView lottieAnimationView, ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "view");
        LottieAnimationViewManagerImpl.setTextFilters(readableArray, getOrCreatePropertyManager(lottieAnimationView));
    }

    @ReactProp(name = "sourceDotLottieURI")
    public final void setSourceDotLottie(LottieAnimationView lottieAnimationView, String str) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "view");
        LottieAnimationViewManagerImpl.setSourceDotLottieURI(str, getOrCreatePropertyManager(lottieAnimationView));
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(LottieAnimationView lottieAnimationView) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "view");
        super.onAfterUpdateTransaction(lottieAnimationView);
        getOrCreatePropertyManager(lottieAnimationView).commitChanges();
    }
}
