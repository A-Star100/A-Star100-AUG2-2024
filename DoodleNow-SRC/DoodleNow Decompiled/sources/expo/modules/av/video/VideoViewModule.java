package expo.modules.av.video;

import androidx.tracing.Trace;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.av.video.scalablevideoview.ScalableType;
import expo.modules.kotlin.functions.AsyncFunction;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.kotlin.views.ConcreteViewProp;
import expo.modules.kotlin.views.ViewDefinitionBuilder;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lexpo/modules/av/video/VideoViewModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-av_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: VideoViewModule.kt */
public final class VideoViewModule extends Module {
    public ModuleDefinitionData definition() {
        Module module = this;
        Trace.beginSection("[ExpoModulesCore] " + (module.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(module);
            moduleDefinitionBuilder.Name("ExpoVideoView");
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(VideoViewWrapper.class);
            if (moduleDefinitionBuilder.getViewManagerDefinition() == null) {
                ViewDefinitionBuilder viewDefinitionBuilder = new ViewDefinitionBuilder(orCreateKotlinClass, new LazyKType(Reflection.getOrCreateKotlinClass(VideoViewWrapper.class), false, VideoViewModule$definition$lambda$2$$inlined$View$1.INSTANCE, 2, (DefaultConstructorMarker) null));
                viewDefinitionBuilder.setOnViewDestroys(new VideoViewModule$definition$lambda$2$lambda$0$$inlined$OnViewDestroysGeneric$1(VideoViewModule$definition$1$1$1.INSTANCE));
                viewDefinitionBuilder.Events("onStatusUpdate", "onLoadStart", "onLoad", "onError", "onReadyForDisplay", "onFullscreenUpdate");
                viewDefinitionBuilder.getProps().put("status", new ConcreteViewProp("status", new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableMap.class), false, VideoViewModule$definition$lambda$2$lambda$0$$inlined$Prop$1.INSTANCE)), VideoViewModule$definition$1$1$2.INSTANCE));
                viewDefinitionBuilder.getProps().put("useNativeControls", new ConcreteViewProp("useNativeControls", new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, VideoViewModule$definition$lambda$2$lambda$0$$inlined$Prop$2.INSTANCE)), VideoViewModule$definition$1$1$3.INSTANCE));
                viewDefinitionBuilder.getProps().put("source", new ConcreteViewProp("source", new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableMap.class), false, VideoViewModule$definition$lambda$2$lambda$0$$inlined$Prop$3.INSTANCE)), VideoViewModule$definition$1$1$4.INSTANCE));
                viewDefinitionBuilder.getProps().put(ViewProps.RESIZE_MODE, new ConcreteViewProp(ViewProps.RESIZE_MODE, new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, VideoViewModule$definition$lambda$2$lambda$0$$inlined$Prop$4.INSTANCE)), VideoViewModule$definition$1$1$5.INSTANCE));
                moduleDefinitionBuilder.setViewManagerDefinition(viewDefinitionBuilder.build());
                moduleDefinitionBuilder.Constants((Pair<String, ? extends Object>[]) new Pair[]{TuplesKt.to("ScaleNone", String.valueOf(ScalableType.LEFT_TOP.ordinal())), TuplesKt.to("ScaleToFill", String.valueOf(ScalableType.FIT_XY.ordinal())), TuplesKt.to("ScaleAspectFit", String.valueOf(ScalableType.FIT_CENTER.ordinal())), TuplesKt.to("ScaleAspectFill", String.valueOf(ScalableType.CENTER_CROP.ordinal()))});
                Class<Integer> cls = Integer.class;
                Class<Boolean> cls2 = Boolean.class;
                AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("setFullscreen", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, VideoViewModule$definition$lambda$2$$inlined$AsyncFunctionWithPromise$1.INSTANCE)), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, VideoViewModule$definition$lambda$2$$inlined$AsyncFunctionWithPromise$2.INSTANCE))}, new VideoViewModule$definition$lambda$2$$inlined$AsyncFunctionWithPromise$3(this));
                moduleDefinitionBuilder.getAsyncFunctions().put("setFullscreen", asyncFunctionWithPromiseComponent);
                AsyncFunction asyncFunction = asyncFunctionWithPromiseComponent;
                return moduleDefinitionBuilder.buildModule();
            }
            throw new IllegalArgumentException("The module definition may have exported only one view manager.".toString());
        } finally {
            Trace.endSection();
        }
    }
}
