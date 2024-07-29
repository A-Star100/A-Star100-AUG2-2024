package com.airbnb.android.react.lottie;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.RenderMode;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u0006\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0007J \u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0007J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0007J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0007J\u0018\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0007J\u0018\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0018\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020#H\u0007J\u0018\u0010$\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u001fH\u0007J\u001a\u0010&\u001a\u00020\u00112\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010\"\u001a\u00020#H\u0007J\u0018\u0010)\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020#H\u0007J\u0018\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020#H\u0007J\u001a\u0010-\u001a\u00020\u00112\b\u0010.\u001a\u0004\u0018\u00010\u00042\u0006\u0010\"\u001a\u00020#H\u0007J\u0018\u0010/\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020#H\u0007J\u0018\u00101\u001a\u00020\u00112\u0006\u00102\u001a\u0002032\u0006\u0010\"\u001a\u00020#H\u0007J\u001a\u00104\u001a\u00020\u00112\b\u00105\u001a\u0004\u0018\u00010\u00042\u0006\u0010\"\u001a\u00020#H\u0007J\u001a\u00106\u001a\u00020\u00112\b\u00107\u001a\u0004\u0018\u00010\u00042\u0006\u0010\"\u001a\u00020#H\u0007J\u001a\u00108\u001a\u00020\u00112\b\u00109\u001a\u0004\u0018\u00010\u00042\u0006\u0010\"\u001a\u00020#H\u0007J\u001a\u0010:\u001a\u00020\u00112\b\u0010;\u001a\u0004\u0018\u00010\u00042\u0006\u0010\"\u001a\u00020#H\u0007J\u001a\u0010<\u001a\u00020\u00112\b\u0010=\u001a\u0004\u0018\u00010\u00042\u0006\u0010\"\u001a\u00020#H\u0007J\u001a\u0010>\u001a\u00020\u00112\b\u0010?\u001a\u0004\u0018\u00010\u00042\u0006\u0010\"\u001a\u00020#H\u0007J\u0018\u0010@\u001a\u00020\u00112\u0006\u0010A\u001a\u00020B2\u0006\u0010\"\u001a\u00020#H\u0007J\u001a\u0010C\u001a\u00020\u00112\b\u0010D\u001a\u0004\u0018\u00010(2\u0006\u0010\"\u001a\u00020#H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R&\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00068FX\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\t¨\u0006E"}, d2 = {"Lcom/airbnb/android/react/lottie/LottieAnimationViewManagerImpl;", "", "()V", "REACT_CLASS", "", "exportedViewConstants", "", "getExportedViewConstants$annotations", "getExportedViewConstants", "()Ljava/util/Map;", "createViewInstance", "Lcom/airbnb/lottie/LottieAnimationView;", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getExportedCustomDirectEventTypeConstants", "", "pause", "", "view", "play", "startFrame", "", "endFrame", "reset", "resume", "sendAnimationFailureEvent", "error", "", "sendAnimationLoadedEvent", "sendOnAnimationFinishEvent", "isCancelled", "", "setAutoPlay", "autoPlay", "viewManager", "Lcom/airbnb/android/react/lottie/LottieAnimationViewPropertyManager;", "setCacheComposition", "cacheComposition", "setColorFilters", "colorFilters", "Lcom/facebook/react/bridge/ReadableArray;", "setEnableMergePaths", "enableMergePaths", "setHardwareAcceleration", "hardwareAccelerationAndroid", "setImageAssetsFolder", "imageAssetsFolder", "setLoop", "loop", "setProgress", "progress", "", "setRenderMode", "renderMode", "setResizeMode", "resizeMode", "setSourceDotLottieURI", "uri", "setSourceJson", "json", "setSourceName", "name", "setSourceURL", "urlString", "setSpeed", "speed", "", "setTextFilters", "textFilters", "lottie-react-native_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LottieAnimationViewManagerImpl.kt */
public final class LottieAnimationViewManagerImpl {
    public static final LottieAnimationViewManagerImpl INSTANCE = new LottieAnimationViewManagerImpl();
    public static final String REACT_CLASS = "LottieAnimationView";

    @JvmStatic
    public static /* synthetic */ void getExportedViewConstants$annotations() {
    }

    private LottieAnimationViewManagerImpl() {
    }

    public static final Map<String, Object> getExportedViewConstants() {
        Map<String, Object> build = MapBuilder.builder().put("VERSION", 1).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    @JvmStatic
    public static final LottieAnimationView createViewInstance(ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(themedReactContext, "context");
        LottieAnimationView lottieAnimationView = new LottieAnimationView(themedReactContext);
        lottieAnimationView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        return lottieAnimationView;
    }

    @JvmStatic
    public static final void sendOnAnimationFinishEvent(LottieAnimationView lottieAnimationView, boolean z) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "view");
        Context context = lottieAnimationView.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.uimanager.ThemedReactContext");
        ThemedReactContext themedReactContext = (ThemedReactContext) context;
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(themedReactContext, lottieAnimationView.getId());
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(new OnAnimationFinishEvent(themedReactContext.getSurfaceId(), lottieAnimationView.getId(), z));
        }
    }

    @JvmStatic
    public static final void sendAnimationFailureEvent(LottieAnimationView lottieAnimationView, Throwable th) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "view");
        Intrinsics.checkNotNullParameter(th, "error");
        Context context = lottieAnimationView.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.uimanager.ThemedReactContext");
        ThemedReactContext themedReactContext = (ThemedReactContext) context;
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(themedReactContext, lottieAnimationView.getId());
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(new OnAnimationFailureEvent(themedReactContext.getSurfaceId(), lottieAnimationView.getId(), th));
        }
    }

    @JvmStatic
    public static final void sendAnimationLoadedEvent(LottieAnimationView lottieAnimationView) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "view");
        Context context = lottieAnimationView.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.uimanager.ThemedReactContext");
        ThemedReactContext themedReactContext = (ThemedReactContext) context;
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(themedReactContext, lottieAnimationView.getId());
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(new OnAnimationLoadedEvent(themedReactContext.getSurfaceId(), lottieAnimationView.getId()));
        }
    }

    @JvmStatic
    public static final Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        Map<String, Object> of = MapBuilder.of(OnAnimationFinishEvent.EVENT_NAME, MapBuilder.of("registrationName", "onAnimationFinish"), OnAnimationFailureEvent.EVENT_NAME, MapBuilder.of("registrationName", "onAnimationFailure"), OnAnimationLoadedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onAnimationLoaded"));
        Intrinsics.checkNotNullExpressionValue(of, "of(...)");
        return of;
    }

    @JvmStatic
    public static final void play(LottieAnimationView lottieAnimationView, int i, int i2) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "view");
        new Handler(Looper.getMainLooper()).post(new LottieAnimationViewManagerImpl$$ExternalSyntheticLambda0(i, i2, lottieAnimationView));
    }

    /* access modifiers changed from: private */
    public static final void play$lambda$1(int i, int i2, LottieAnimationView lottieAnimationView) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "$view");
        if (!(i == -1 || i2 == -1)) {
            if (i > i2) {
                lottieAnimationView.setMinAndMaxFrame(i2, i);
                if (lottieAnimationView.getSpeed() > 0.0f) {
                    lottieAnimationView.reverseAnimationSpeed();
                }
            } else {
                lottieAnimationView.setMinAndMaxFrame(i, i2);
                if (lottieAnimationView.getSpeed() < 0.0f) {
                    lottieAnimationView.reverseAnimationSpeed();
                }
            }
        }
        if (ViewCompat.isAttachedToWindow(lottieAnimationView)) {
            lottieAnimationView.setProgress(0.0f);
            lottieAnimationView.playAnimation();
            return;
        }
        lottieAnimationView.addOnAttachStateChangeListener(new LottieAnimationViewManagerImpl$play$1$1());
    }

    @JvmStatic
    public static final void reset(LottieAnimationView lottieAnimationView) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "view");
        new Handler(Looper.getMainLooper()).post(new LottieAnimationViewManagerImpl$$ExternalSyntheticLambda2(lottieAnimationView));
    }

    /* access modifiers changed from: private */
    public static final void reset$lambda$2(LottieAnimationView lottieAnimationView) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "$view");
        if (ViewCompat.isAttachedToWindow(lottieAnimationView)) {
            lottieAnimationView.cancelAnimation();
            lottieAnimationView.setProgress(0.0f);
        }
    }

    @JvmStatic
    public static final void pause(LottieAnimationView lottieAnimationView) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "view");
        new Handler(Looper.getMainLooper()).post(new LottieAnimationViewManagerImpl$$ExternalSyntheticLambda1(lottieAnimationView));
    }

    /* access modifiers changed from: private */
    public static final void pause$lambda$3(LottieAnimationView lottieAnimationView) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "$view");
        if (ViewCompat.isAttachedToWindow(lottieAnimationView)) {
            lottieAnimationView.pauseAnimation();
        }
    }

    @JvmStatic
    public static final void resume(LottieAnimationView lottieAnimationView) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "view");
        new Handler(Looper.getMainLooper()).post(new LottieAnimationViewManagerImpl$$ExternalSyntheticLambda3(lottieAnimationView));
    }

    /* access modifiers changed from: private */
    public static final void resume$lambda$4(LottieAnimationView lottieAnimationView) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "$view");
        if (ViewCompat.isAttachedToWindow(lottieAnimationView)) {
            lottieAnimationView.resumeAnimation();
        }
    }

    @JvmStatic
    public static final void setSourceName(String str, LottieAnimationViewPropertyManager lottieAnimationViewPropertyManager) {
        Intrinsics.checkNotNullParameter(lottieAnimationViewPropertyManager, "viewManager");
        if (str != null && !StringsKt.contains$default((CharSequence) str, (CharSequence) ".", false, 2, (Object) null)) {
            str = str + ".json";
        }
        lottieAnimationViewPropertyManager.setAnimationName(str);
        lottieAnimationViewPropertyManager.commitChanges();
    }

    @JvmStatic
    public static final void setSourceJson(String str, LottieAnimationViewPropertyManager lottieAnimationViewPropertyManager) {
        Intrinsics.checkNotNullParameter(lottieAnimationViewPropertyManager, "viewManager");
        lottieAnimationViewPropertyManager.setAnimationJson(str);
        lottieAnimationViewPropertyManager.commitChanges();
    }

    @JvmStatic
    public static final void setSourceURL(String str, LottieAnimationViewPropertyManager lottieAnimationViewPropertyManager) {
        Intrinsics.checkNotNullParameter(lottieAnimationViewPropertyManager, "viewManager");
        lottieAnimationViewPropertyManager.setAnimationURL(str);
        lottieAnimationViewPropertyManager.commitChanges();
    }

    @JvmStatic
    public static final void setSourceDotLottieURI(String str, LottieAnimationViewPropertyManager lottieAnimationViewPropertyManager) {
        Intrinsics.checkNotNullParameter(lottieAnimationViewPropertyManager, "viewManager");
        lottieAnimationViewPropertyManager.setSourceDotLottie(str);
        lottieAnimationViewPropertyManager.commitChanges();
    }

    @JvmStatic
    public static final void setCacheComposition(LottieAnimationView lottieAnimationView, boolean z) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "view");
        lottieAnimationView.setCacheComposition(z);
    }

    @JvmStatic
    public static final void setResizeMode(String str, LottieAnimationViewPropertyManager lottieAnimationViewPropertyManager) {
        ImageView.ScaleType scaleType;
        Intrinsics.checkNotNullParameter(lottieAnimationViewPropertyManager, "viewManager");
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -1364013995) {
                if (hashCode != 94852023) {
                    if (hashCode == 951526612 && str.equals("contain")) {
                        scaleType = ImageView.ScaleType.FIT_CENTER;
                        lottieAnimationViewPropertyManager.setScaleType(scaleType);
                    }
                } else if (str.equals("cover")) {
                    scaleType = ImageView.ScaleType.CENTER_CROP;
                    lottieAnimationViewPropertyManager.setScaleType(scaleType);
                }
            } else if (str.equals(TtmlNode.CENTER)) {
                scaleType = ImageView.ScaleType.CENTER_INSIDE;
                lottieAnimationViewPropertyManager.setScaleType(scaleType);
            }
        }
        scaleType = null;
        lottieAnimationViewPropertyManager.setScaleType(scaleType);
    }

    @JvmStatic
    public static final void setRenderMode(String str, LottieAnimationViewPropertyManager lottieAnimationViewPropertyManager) {
        RenderMode renderMode;
        Intrinsics.checkNotNullParameter(lottieAnimationViewPropertyManager, "viewManager");
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != 165298699) {
                if (hashCode != 899536360) {
                    if (hashCode == 2101957031 && str.equals("SOFTWARE")) {
                        renderMode = RenderMode.SOFTWARE;
                        lottieAnimationViewPropertyManager.setRenderMode(renderMode);
                    }
                } else if (str.equals("HARDWARE")) {
                    renderMode = RenderMode.HARDWARE;
                    lottieAnimationViewPropertyManager.setRenderMode(renderMode);
                }
            } else if (str.equals("AUTOMATIC")) {
                renderMode = RenderMode.AUTOMATIC;
                lottieAnimationViewPropertyManager.setRenderMode(renderMode);
            }
        }
        renderMode = null;
        lottieAnimationViewPropertyManager.setRenderMode(renderMode);
    }

    @JvmStatic
    public static final void setHardwareAcceleration(boolean z, LottieAnimationViewPropertyManager lottieAnimationViewPropertyManager) {
        Intrinsics.checkNotNullParameter(lottieAnimationViewPropertyManager, "viewManager");
        int i = 1;
        if (z) {
            i = 2;
        }
        lottieAnimationViewPropertyManager.setLayerType(i);
    }

    @JvmStatic
    public static final void setProgress(float f, LottieAnimationViewPropertyManager lottieAnimationViewPropertyManager) {
        Intrinsics.checkNotNullParameter(lottieAnimationViewPropertyManager, "viewManager");
        lottieAnimationViewPropertyManager.setProgress(Float.valueOf(f));
    }

    @JvmStatic
    public static final void setSpeed(double d, LottieAnimationViewPropertyManager lottieAnimationViewPropertyManager) {
        Intrinsics.checkNotNullParameter(lottieAnimationViewPropertyManager, "viewManager");
        lottieAnimationViewPropertyManager.setSpeed(Float.valueOf((float) d));
    }

    @JvmStatic
    public static final void setLoop(boolean z, LottieAnimationViewPropertyManager lottieAnimationViewPropertyManager) {
        Intrinsics.checkNotNullParameter(lottieAnimationViewPropertyManager, "viewManager");
        lottieAnimationViewPropertyManager.setLoop(Boolean.valueOf(z));
    }

    @JvmStatic
    public static final void setAutoPlay(boolean z, LottieAnimationViewPropertyManager lottieAnimationViewPropertyManager) {
        Intrinsics.checkNotNullParameter(lottieAnimationViewPropertyManager, "viewManager");
        lottieAnimationViewPropertyManager.setAutoPlay(Boolean.valueOf(z));
    }

    @JvmStatic
    public static final void setEnableMergePaths(boolean z, LottieAnimationViewPropertyManager lottieAnimationViewPropertyManager) {
        Intrinsics.checkNotNullParameter(lottieAnimationViewPropertyManager, "viewManager");
        lottieAnimationViewPropertyManager.setEnableMergePaths(Boolean.valueOf(z));
    }

    @JvmStatic
    public static final void setImageAssetsFolder(String str, LottieAnimationViewPropertyManager lottieAnimationViewPropertyManager) {
        Intrinsics.checkNotNullParameter(lottieAnimationViewPropertyManager, "viewManager");
        lottieAnimationViewPropertyManager.setImageAssetsFolder(str);
    }

    @JvmStatic
    public static final void setColorFilters(ReadableArray readableArray, LottieAnimationViewPropertyManager lottieAnimationViewPropertyManager) {
        Intrinsics.checkNotNullParameter(lottieAnimationViewPropertyManager, "viewManager");
        lottieAnimationViewPropertyManager.setColorFilters(readableArray);
    }

    @JvmStatic
    public static final void setTextFilters(ReadableArray readableArray, LottieAnimationViewPropertyManager lottieAnimationViewPropertyManager) {
        Intrinsics.checkNotNullParameter(lottieAnimationViewPropertyManager, "viewManager");
        lottieAnimationViewPropertyManager.setTextFilters(readableArray);
    }
}
