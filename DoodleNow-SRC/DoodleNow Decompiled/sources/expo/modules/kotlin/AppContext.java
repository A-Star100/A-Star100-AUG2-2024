package expo.modules.kotlin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.tracing.Trace;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.RuntimeExecutor;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.turbomodule.core.CallInvokerHolderImpl;
import com.facebook.react.turbomodule.core.interfaces.CallInvokerHolder;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.UIManagerModule;
import expo.modules.adapters.react.NativeModulesProxy;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.errors.ContextDestroyedException;
import expo.modules.core.errors.ModuleNotFoundException;
import expo.modules.core.interfaces.ActivityProvider;
import expo.modules.core.logging.Logger;
import expo.modules.interfaces.barcodescanner.BarCodeScannerInterface;
import expo.modules.interfaces.camera.CameraViewInterface;
import expo.modules.interfaces.constants.ConstantsInterface;
import expo.modules.interfaces.filesystem.AppDirectoriesModuleInterface;
import expo.modules.interfaces.filesystem.FilePermissionModuleInterface;
import expo.modules.interfaces.font.FontManagerInterface;
import expo.modules.interfaces.imageloader.ImageLoaderInterface;
import expo.modules.interfaces.permissions.Permissions;
import expo.modules.interfaces.sensors.SensorServiceInterface;
import expo.modules.interfaces.taskManager.TaskManagerInterface;
import expo.modules.kotlin.activityresult.ActivityResultsManager;
import expo.modules.kotlin.activityresult.DefaultAppContextActivityResultCaller;
import expo.modules.kotlin.defaultmodules.CoreModule;
import expo.modules.kotlin.defaultmodules.ErrorManagerModule;
import expo.modules.kotlin.defaultmodules.NativeModulesProxyModule;
import expo.modules.kotlin.events.EventEmitter;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.events.KEventEmitterWrapper;
import expo.modules.kotlin.events.KModuleEventEmitterWrapper;
import expo.modules.kotlin.events.OnActivityResultPayload;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.jni.JNIDeallocator;
import expo.modules.kotlin.jni.JSIContext;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.providers.AppContextProvider;
import expo.modules.kotlin.providers.CurrentActivityProvider;
import expo.modules.kotlin.sharedobjects.ClassRegistry;
import expo.modules.kotlin.sharedobjects.SharedObjectRegistry;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.android.HandlerDispatcher;
import kotlinx.coroutines.android.HandlerDispatcherKt;

@Metadata(d1 = {"\u0000¾\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\b\u0001J!\u0010\u0001\u001a\u00030\u00012\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u0001H\u0000¢\u0006\u0003\b\u0001J\u0013\u0010\u0001\u001a\u0004\u0018\u00010%2\b\u0010\u0001\u001a\u00030\u0001J\u0012\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001J(\u0010\u0001\u001a\u0005\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001*\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0007¢\u0006\u0003\u0010\u0001J\b\u0010\u0001\u001a\u00030\u0001J\u001c\u0010\u0001\u001a\u0005\u0018\u0001H\u0001\"\u0007\b\u0000\u0010\u0001\u0018\u0001H\b¢\u0006\u0003\u0010\u0001J9\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020:2\b\u0010\u0001\u001a\u00030\u00012\b\u0010 \u0001\u001a\u00030\u00012\n\u0010¡\u0001\u001a\u0005\u0018\u00010¢\u0001H\u0000¢\u0006\u0003\b£\u0001J\b\u0010¤\u0001\u001a\u00030\u0001J\u0010\u0010¥\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\b¦\u0001J\u0010\u0010§\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\b¨\u0001J\u0010\u0010©\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\bª\u0001J\u0010\u0010«\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\b¬\u0001J\u001c\u0010­\u0001\u001a\u00030\u00012\n\u0010®\u0001\u001a\u0005\u0018\u00010¢\u0001H\u0000¢\u0006\u0003\b¯\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0016\u0010$\u001a\u0004\u0018\u00010%8@X\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0013\u0010(\u001a\u0004\u0018\u00010)8F¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020-X\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0013\u00100\u001a\u0004\u0018\u0001018F¢\u0006\u0006\u001a\u0004\b2\u00103R\u001a\u00104\u001a\b\u0012\u0004\u0012\u00020605X\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0016\u00109\u001a\u0004\u0018\u00010:8VX\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0013\u0010=\u001a\u0004\u0018\u00010>8F¢\u0006\u0006\u001a\u0004\b?\u0010@R\u0013\u0010A\u001a\u0004\u0018\u00010B8F¢\u0006\u0006\u001a\u0004\bC\u0010DR\u0013\u0010E\u001a\u0004\u0018\u00010F8F¢\u0006\u0006\u001a\u0004\bG\u0010HR\u0011\u0010I\u001a\u00020J8F¢\u0006\u0006\u001a\u0004\bK\u0010LR\u000e\u0010M\u001a\u00020JX\u000e¢\u0006\u0002\n\u0000R\u0013\u0010N\u001a\u0004\u0018\u00010O8F¢\u0006\u0006\u001a\u0004\bP\u0010QR\u0011\u0010R\u001a\u00020S¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u001a\u0010V\u001a\u00020WX.¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R\"\u0010^\u001a\n\u0012\u0004\u0012\u00020_\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u0011\u0010d\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\be\u0010\u001bR\u0011\u0010f\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\bg\u0010\u001bR\u000e\u0010h\u001a\u00020iX\u0004¢\u0006\u0002\n\u0000R\u0013\u0010j\u001a\u0004\u0018\u00010k8F¢\u0006\u0006\u001a\u0004\bl\u0010mR\u0011\u0010n\u001a\u00020!8F¢\u0006\u0006\u001a\u0004\bo\u0010#R\u0013\u0010p\u001a\u0004\u0018\u00010q8F¢\u0006\u0006\u001a\u0004\br\u0010sR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020uX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010v\u001a\u00020w¢\u0006\b\n\u0000\u001a\u0004\bx\u0010yR\u0013\u0010z\u001a\u0004\u0018\u00010{8F¢\u0006\u0006\u001a\u0004\b|\u0010}R\u0016\u0010~\u001a\u00020X\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0017\u0010\u0001\u001a\u0005\u0018\u00010\u00018F¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001¨\u0006°\u0001"}, d2 = {"Lexpo/modules/kotlin/AppContext;", "Lexpo/modules/kotlin/providers/CurrentActivityProvider;", "modulesProvider", "Lexpo/modules/kotlin/ModulesProvider;", "legacyModuleRegistry", "Lexpo/modules/core/ModuleRegistry;", "reactContextHolder", "Ljava/lang/ref/WeakReference;", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lexpo/modules/kotlin/ModulesProvider;Lexpo/modules/core/ModuleRegistry;Ljava/lang/ref/WeakReference;)V", "activityProvider", "Lexpo/modules/core/interfaces/ActivityProvider;", "getActivityProvider", "()Lexpo/modules/core/interfaces/ActivityProvider;", "activityResultsManager", "Lexpo/modules/kotlin/activityresult/ActivityResultsManager;", "appContextActivityResultCaller", "Lexpo/modules/kotlin/activityresult/DefaultAppContextActivityResultCaller;", "getAppContextActivityResultCaller$expo_modules_core_release", "()Lexpo/modules/kotlin/activityresult/DefaultAppContextActivityResultCaller;", "appDirectories", "Lexpo/modules/interfaces/filesystem/AppDirectoriesModuleInterface;", "getAppDirectories", "()Lexpo/modules/interfaces/filesystem/AppDirectoriesModuleInterface;", "backgroundCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getBackgroundCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "barcodeScanner", "Lexpo/modules/interfaces/barcodescanner/BarCodeScannerInterface;", "getBarcodeScanner", "()Lexpo/modules/interfaces/barcodescanner/BarCodeScannerInterface;", "cacheDirectory", "Ljava/io/File;", "getCacheDirectory", "()Ljava/io/File;", "callbackInvoker", "Lexpo/modules/kotlin/events/EventEmitter;", "getCallbackInvoker$expo_modules_core_release", "()Lexpo/modules/kotlin/events/EventEmitter;", "camera", "Lexpo/modules/interfaces/camera/CameraViewInterface;", "getCamera", "()Lexpo/modules/interfaces/camera/CameraViewInterface;", "classRegistry", "Lexpo/modules/kotlin/sharedobjects/ClassRegistry;", "getClassRegistry$expo_modules_core_release", "()Lexpo/modules/kotlin/sharedobjects/ClassRegistry;", "constants", "Lexpo/modules/interfaces/constants/ConstantsInterface;", "getConstants", "()Lexpo/modules/interfaces/constants/ConstantsInterface;", "coreModule", "Lexpo/modules/kotlin/ModuleHolder;", "Lexpo/modules/kotlin/defaultmodules/CoreModule;", "getCoreModule$expo_modules_core_release", "()Lexpo/modules/kotlin/ModuleHolder;", "currentActivity", "Landroid/app/Activity;", "getCurrentActivity", "()Landroid/app/Activity;", "errorManager", "Lexpo/modules/kotlin/defaultmodules/ErrorManagerModule;", "getErrorManager", "()Lexpo/modules/kotlin/defaultmodules/ErrorManagerModule;", "filePermission", "Lexpo/modules/interfaces/filesystem/FilePermissionModuleInterface;", "getFilePermission", "()Lexpo/modules/interfaces/filesystem/FilePermissionModuleInterface;", "font", "Lexpo/modules/interfaces/font/FontManagerInterface;", "getFont", "()Lexpo/modules/interfaces/font/FontManagerInterface;", "hasActiveReactInstance", "", "getHasActiveReactInstance", "()Z", "hostWasDestroyed", "imageLoader", "Lexpo/modules/interfaces/imageloader/ImageLoaderInterface;", "getImageLoader", "()Lexpo/modules/interfaces/imageloader/ImageLoaderInterface;", "jniDeallocator", "Lexpo/modules/kotlin/jni/JNIDeallocator;", "getJniDeallocator", "()Lexpo/modules/kotlin/jni/JNIDeallocator;", "jsiInterop", "Lexpo/modules/kotlin/jni/JSIContext;", "getJsiInterop$expo_modules_core_release", "()Lexpo/modules/kotlin/jni/JSIContext;", "setJsiInterop$expo_modules_core_release", "(Lexpo/modules/kotlin/jni/JSIContext;)V", "getLegacyModuleRegistry", "()Lexpo/modules/core/ModuleRegistry;", "legacyModulesProxyHolder", "Lexpo/modules/adapters/react/NativeModulesProxy;", "getLegacyModulesProxyHolder$expo_modules_core_release", "()Ljava/lang/ref/WeakReference;", "setLegacyModulesProxyHolder$expo_modules_core_release", "(Ljava/lang/ref/WeakReference;)V", "mainQueue", "getMainQueue", "modulesQueue", "getModulesQueue", "modulesQueueDispatcher", "Lkotlinx/coroutines/android/HandlerDispatcher;", "permissions", "Lexpo/modules/interfaces/permissions/Permissions;", "getPermissions", "()Lexpo/modules/interfaces/permissions/Permissions;", "persistentFilesDirectory", "getPersistentFilesDirectory", "reactContext", "Landroid/content/Context;", "getReactContext", "()Landroid/content/Context;", "reactLifecycleDelegate", "Lexpo/modules/kotlin/ReactLifecycleDelegate;", "registry", "Lexpo/modules/kotlin/ModuleRegistry;", "getRegistry", "()Lexpo/modules/kotlin/ModuleRegistry;", "sensor", "Lexpo/modules/interfaces/sensors/SensorServiceInterface;", "getSensor", "()Lexpo/modules/interfaces/sensors/SensorServiceInterface;", "sharedObjectRegistry", "Lexpo/modules/kotlin/sharedobjects/SharedObjectRegistry;", "getSharedObjectRegistry$expo_modules_core_release", "()Lexpo/modules/kotlin/sharedobjects/SharedObjectRegistry;", "taskManager", "Lexpo/modules/interfaces/taskManager/TaskManagerInterface;", "getTaskManager", "()Lexpo/modules/interfaces/taskManager/TaskManagerInterface;", "assertMainThread", "", "assertMainThread$expo_modules_core_release", "dispatchOnMainUsingUIManager", "block", "Lkotlin/Function0;", "dispatchOnMainUsingUIManager$expo_modules_core_release", "eventEmitter", "module", "Lexpo/modules/kotlin/modules/Module;", "executeOnJavaScriptThread", "runnable", "Ljava/lang/Runnable;", "findView", "T", "Landroid/view/View;", "viewTag", "", "(I)Landroid/view/View;", "installJSIInterop", "legacyModule", "Module", "()Ljava/lang/Object;", "onActivityResult", "activity", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onActivityResult$expo_modules_core_release", "onCreate", "onDestroy", "onDestroy$expo_modules_core_release", "onHostDestroy", "onHostDestroy$expo_modules_core_release", "onHostPause", "onHostPause$expo_modules_core_release", "onHostResume", "onHostResume$expo_modules_core_release", "onNewIntent", "intent", "onNewIntent$expo_modules_core_release", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: AppContext.kt */
public final class AppContext implements CurrentActivityProvider {
    private final ActivityResultsManager activityResultsManager;
    private final DefaultAppContextActivityResultCaller appContextActivityResultCaller;
    private final CoroutineScope backgroundCoroutineScope;
    private final ClassRegistry classRegistry = new ClassRegistry();
    private final ModuleHolder<CoreModule> coreModule;
    private boolean hostWasDestroyed;
    private final JNIDeallocator jniDeallocator;
    public JSIContext jsiInterop;
    private final ModuleRegistry legacyModuleRegistry;
    private WeakReference<NativeModulesProxy> legacyModulesProxyHolder;
    private final CoroutineScope mainQueue;
    private final CoroutineScope modulesQueue;
    private final HandlerDispatcher modulesQueueDispatcher;
    /* access modifiers changed from: private */
    public final WeakReference<ReactApplicationContext> reactContextHolder;
    /* access modifiers changed from: private */
    public final ReactLifecycleDelegate reactLifecycleDelegate;
    private final ModuleRegistry registry;
    private final SharedObjectRegistry sharedObjectRegistry = new SharedObjectRegistry(this);

    public final DefaultAppContextActivityResultCaller getAppContextActivityResultCaller$expo_modules_core_release() {
        return this.appContextActivityResultCaller;
    }

    public final CoroutineScope getBackgroundCoroutineScope() {
        return this.backgroundCoroutineScope;
    }

    public final ClassRegistry getClassRegistry$expo_modules_core_release() {
        return this.classRegistry;
    }

    public final ModuleHolder<CoreModule> getCoreModule$expo_modules_core_release() {
        return this.coreModule;
    }

    public final JNIDeallocator getJniDeallocator() {
        return this.jniDeallocator;
    }

    public final ModuleRegistry getLegacyModuleRegistry() {
        return this.legacyModuleRegistry;
    }

    public final WeakReference<NativeModulesProxy> getLegacyModulesProxyHolder$expo_modules_core_release() {
        return this.legacyModulesProxyHolder;
    }

    public final CoroutineScope getMainQueue() {
        return this.mainQueue;
    }

    public final CoroutineScope getModulesQueue() {
        return this.modulesQueue;
    }

    public final ModuleRegistry getRegistry() {
        return this.registry;
    }

    public final SharedObjectRegistry getSharedObjectRegistry$expo_modules_core_release() {
        return this.sharedObjectRegistry;
    }

    public final void setJsiInterop$expo_modules_core_release(JSIContext jSIContext) {
        Intrinsics.checkNotNullParameter(jSIContext, "<set-?>");
        this.jsiInterop = jSIContext;
    }

    public final void setLegacyModulesProxyHolder$expo_modules_core_release(WeakReference<NativeModulesProxy> weakReference) {
        this.legacyModulesProxyHolder = weakReference;
    }

    public AppContext(ModulesProvider modulesProvider, ModuleRegistry moduleRegistry, WeakReference<ReactApplicationContext> weakReference) {
        Intrinsics.checkNotNullParameter(modulesProvider, "modulesProvider");
        Intrinsics.checkNotNullParameter(moduleRegistry, "legacyModuleRegistry");
        Intrinsics.checkNotNullParameter(weakReference, "reactContextHolder");
        this.legacyModuleRegistry = moduleRegistry;
        this.reactContextHolder = weakReference;
        ModuleRegistry moduleRegistry2 = new ModuleRegistry(new WeakReference(this));
        this.registry = moduleRegistry2;
        ReactLifecycleDelegate reactLifecycleDelegate2 = new ReactLifecycleDelegate(this);
        this.reactLifecycleDelegate = reactLifecycleDelegate2;
        AppContext appContext = this;
        CoreModule coreModule2 = new CoreModule();
        coreModule2.set_appContext$expo_modules_core_release(this);
        this.coreModule = new ModuleHolder<>(coreModule2);
        HandlerThread handlerThread = new HandlerThread("expo.modules.AsyncFunctionQueue");
        handlerThread.start();
        HandlerDispatcher from$default = HandlerDispatcherKt.from$default(new Handler(handlerThread.getLooper()), (String) null, 1, (Object) null);
        this.modulesQueueDispatcher = from$default;
        this.backgroundCoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus(new CoroutineName("expo.modules.BackgroundCoroutineScope")));
        this.modulesQueue = CoroutineScopeKt.CoroutineScope(from$default.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus(new CoroutineName("expo.modules.AsyncFunctionQueue")));
        this.mainQueue = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus(new CoroutineName("expo.modules.MainQueue")));
        this.jniDeallocator = new JNIDeallocator(false, 1, (DefaultConstructorMarker) null);
        ActivityResultsManager activityResultsManager2 = new ActivityResultsManager(this);
        this.activityResultsManager = activityResultsManager2;
        this.appContextActivityResultCaller = new DefaultAppContextActivityResultCaller(activityResultsManager2);
        Object obj = weakReference.get();
        if (obj != null) {
            ReactApplicationContext reactApplicationContext = (ReactApplicationContext) obj;
            reactApplicationContext.addLifecycleEventListener(reactLifecycleDelegate2);
            reactApplicationContext.addActivityEventListener(reactLifecycleDelegate2);
            moduleRegistry2.register(new ErrorManagerModule());
            moduleRegistry2.register(new NativeModulesProxyModule());
            moduleRegistry2.register(modulesProvider);
            CoreLoggerKt.getLogger().info("✅ AppContext was initialized");
            return;
        }
        throw new IllegalArgumentException("The app context should be created with valid react context.".toString());
    }

    public final JSIContext getJsiInterop$expo_modules_core_release() {
        JSIContext jSIContext = this.jsiInterop;
        if (jSIContext != null) {
            return jSIContext;
        }
        Intrinsics.throwUninitializedPropertyAccessException("jsiInterop");
        return null;
    }

    public final void installJSIInterop() {
        synchronized (this) {
            if (this.jsiInterop != null) {
                Logger.warn$default(CoreLoggerKt.getLogger(), "⚠️ JSI interop was already installed", (Throwable) null, 2, (Object) null);
                return;
            }
            Trace.beginSection("[ExpoModulesCore] AppContext.installJSIInterop");
            try {
                setJsiInterop$expo_modules_core_release(new JSIContext());
                ReactApplicationContext reactApplicationContext = (ReactApplicationContext) this.reactContextHolder.get();
                if (reactApplicationContext != null) {
                    Intrinsics.checkNotNull(reactApplicationContext);
                    JavaScriptContextHolder javaScriptContextHolder = reactApplicationContext.getJavaScriptContextHolder();
                    if (javaScriptContextHolder != null) {
                        Long valueOf = Long.valueOf(javaScriptContextHolder.get());
                        if (valueOf.longValue() == 0) {
                            valueOf = null;
                        }
                        if (valueOf == null) {
                            Logger.error$default(CoreLoggerKt.getLogger(), "❌ Cannot install JSI interop - JS runtime pointer is null", (Throwable) null, 2, (Object) null);
                        } else {
                            long longValue = valueOf.longValue();
                            if (reactApplicationContext.isBridgeless()) {
                                JSIContext jsiInterop$expo_modules_core_release = getJsiInterop$expo_modules_core_release();
                                JNIDeallocator jniDeallocator2 = getJniDeallocator();
                                RuntimeExecutor runtimeExecutor = reactApplicationContext.getRuntimeExecutor();
                                Intrinsics.checkNotNull(runtimeExecutor);
                                jsiInterop$expo_modules_core_release.installJSIForBridgeless(this, longValue, jniDeallocator2, runtimeExecutor);
                            } else {
                                JSIContext jsiInterop$expo_modules_core_release2 = getJsiInterop$expo_modules_core_release();
                                JNIDeallocator jniDeallocator3 = getJniDeallocator();
                                CallInvokerHolder jSCallInvokerHolder = reactApplicationContext.getCatalystInstance().getJSCallInvokerHolder();
                                Intrinsics.checkNotNull(jSCallInvokerHolder, "null cannot be cast to non-null type com.facebook.react.turbomodule.core.CallInvokerHolderImpl");
                                jsiInterop$expo_modules_core_release2.installJSI(this, longValue, jniDeallocator3, (CallInvokerHolderImpl) jSCallInvokerHolder);
                            }
                            CoreLoggerKt.getLogger().info("✅ JSI interop was installed");
                        }
                    }
                }
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
            Unit unit = Unit.INSTANCE;
            Trace.endSection();
            Unit unit2 = Unit.INSTANCE;
        }
    }

    public final /* synthetic */ <Module> Module legacyModule() {
        try {
            ModuleRegistry legacyModuleRegistry2 = getLegacyModuleRegistry();
            Intrinsics.reifiedOperationMarker(4, "Module");
            Class<Object> cls = Object.class;
            Class cls2 = cls;
            return legacyModuleRegistry2.getModule(cls);
        } catch (Exception unused) {
            return null;
        }
    }

    public final File getPersistentFilesDirectory() {
        File persistentFilesDirectory;
        AppDirectoriesModuleInterface appDirectories = getAppDirectories();
        if (appDirectories != null && (persistentFilesDirectory = appDirectories.getPersistentFilesDirectory()) != null) {
            return persistentFilesDirectory;
        }
        throw new ModuleNotFoundException("expo.modules.interfaces.filesystem.AppDirectories");
    }

    public final File getCacheDirectory() {
        File cacheDirectory;
        AppDirectoriesModuleInterface appDirectories = getAppDirectories();
        if (appDirectories != null && (cacheDirectory = appDirectories.getCacheDirectory()) != null) {
            return cacheDirectory;
        }
        throw new ModuleNotFoundException("expo.modules.interfaces.filesystem.AppDirectories");
    }

    public final Context getReactContext() {
        return (Context) this.reactContextHolder.get();
    }

    public final boolean getHasActiveReactInstance() {
        ReactApplicationContext reactApplicationContext = (ReactApplicationContext) this.reactContextHolder.get();
        if (reactApplicationContext != null) {
            return reactApplicationContext.hasActiveReactInstance();
        }
        return false;
    }

    public final void onHostResume$expo_modules_core_release() {
        Activity currentActivity = getCurrentActivity();
        if (!(currentActivity instanceof AppCompatActivity)) {
            Activity currentActivity2 = getCurrentActivity();
            String localClassName = currentActivity2 != null ? currentActivity2.getLocalClassName() : null;
            throw new IllegalStateException(("Current Activity is of incorrect class, expected AppCompatActivity, received " + localClassName).toString());
        }
        if (this.hostWasDestroyed) {
            this.hostWasDestroyed = false;
            this.registry.registerActivityContracts$expo_modules_core_release();
        }
        this.activityResultsManager.onHostResume((AppCompatActivity) currentActivity);
        this.registry.post(EventName.ACTIVITY_ENTERS_FOREGROUND);
    }

    public final void onHostPause$expo_modules_core_release() {
        this.registry.post(EventName.ACTIVITY_ENTERS_BACKGROUND);
    }

    public final void onHostDestroy$expo_modules_core_release() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            if (!(currentActivity instanceof AppCompatActivity)) {
                Activity currentActivity2 = getCurrentActivity();
                String localClassName = currentActivity2 != null ? currentActivity2.getLocalClassName() : null;
                throw new IllegalStateException(("Current Activity is of incorrect class, expected AppCompatActivity, received " + localClassName).toString());
            }
            this.activityResultsManager.onHostDestroy((AppCompatActivity) currentActivity);
        }
        this.registry.post(EventName.ACTIVITY_DESTROYS);
        this.hostWasDestroyed = true;
    }

    public final void onActivityResult$expo_modules_core_release(Activity activity, int i, int i2, Intent intent) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activityResultsManager.onActivityResult(i, i2, intent);
        this.registry.post(EventName.ON_ACTIVITY_RESULT, activity, new OnActivityResultPayload(i, i2, intent));
    }

    public final void onNewIntent$expo_modules_core_release(Intent intent) {
        this.registry.post(EventName.ON_NEW_INTENT, intent);
    }

    public final <T extends View> T findView(int i) {
        ReactApplicationContext reactApplicationContext = (ReactApplicationContext) this.reactContextHolder.get();
        if (reactApplicationContext == null) {
            return null;
        }
        UIManager uIManagerForReactTag = UIManagerHelper.getUIManagerForReactTag(reactApplicationContext, i);
        T resolveView = uIManagerForReactTag != null ? uIManagerForReactTag.resolveView(i) : null;
        if (resolveView instanceof View) {
            return resolveView;
        }
        return null;
    }

    public final void dispatchOnMainUsingUIManager$expo_modules_core_release(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        ReactApplicationContext reactApplicationContext = (ReactApplicationContext) this.reactContextHolder.get();
        if (reactApplicationContext != null) {
            UIManager uIManagerForReactTag = UIManagerHelper.getUIManagerForReactTag(reactApplicationContext, 1);
            Intrinsics.checkNotNull(uIManagerForReactTag, "null cannot be cast to non-null type com.facebook.react.uimanager.UIManagerModule");
            ((UIManagerModule) uIManagerForReactTag).addUIBlock(new AppContext$$ExternalSyntheticLambda0(function0));
            return;
        }
        throw new Exceptions.ReactContextLost();
    }

    /* access modifiers changed from: private */
    public static final void dispatchOnMainUsingUIManager$lambda$15(Function0 function0, NativeViewHierarchyManager nativeViewHierarchyManager) {
        Intrinsics.checkNotNullParameter(function0, "$block");
        function0.invoke();
    }

    public final void assertMainThread$expo_modules_core_release() {
        Utils utils = Utils.INSTANCE;
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            String name = Thread.currentThread().getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            String name2 = Looper.getMainLooper().getThread().getName();
            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            throw new Exceptions.IncorrectThreadException(name, name2);
        }
    }

    public final void executeOnJavaScriptThread(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        ReactApplicationContext reactApplicationContext = (ReactApplicationContext) this.reactContextHolder.get();
        if (reactApplicationContext != null) {
            reactApplicationContext.runOnJSQueueThread(runnable);
        }
    }

    public Activity getCurrentActivity() {
        Activity currentActivity;
        ActivityProvider activityProvider = getActivityProvider();
        if (activityProvider != null && (currentActivity = activityProvider.getCurrentActivity()) != null) {
            return currentActivity;
        }
        Context reactContext = getReactContext();
        ReactApplicationContext reactApplicationContext = reactContext instanceof ReactApplicationContext ? (ReactApplicationContext) reactContext : null;
        if (reactApplicationContext != null) {
            return reactApplicationContext.getCurrentActivity();
        }
        return null;
    }

    public final void onCreate() {
        Trace.beginSection("[ExpoModulesCore] AppContext.onCreate");
        try {
            getRegistry().postOnCreate();
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    public final ConstantsInterface getConstants() {
        Object obj;
        try {
            obj = getLegacyModuleRegistry().getModule(ConstantsInterface.class);
        } catch (Exception unused) {
            obj = null;
        }
        return (ConstantsInterface) obj;
    }

    public final FilePermissionModuleInterface getFilePermission() {
        Object obj;
        try {
            obj = getLegacyModuleRegistry().getModule(FilePermissionModuleInterface.class);
        } catch (Exception unused) {
            obj = null;
        }
        return (FilePermissionModuleInterface) obj;
    }

    private final AppDirectoriesModuleInterface getAppDirectories() {
        Object obj;
        try {
            obj = getLegacyModuleRegistry().getModule(AppDirectoriesModuleInterface.class);
        } catch (Exception unused) {
            obj = null;
        }
        return (AppDirectoriesModuleInterface) obj;
    }

    public final Permissions getPermissions() {
        Object obj;
        try {
            obj = getLegacyModuleRegistry().getModule(Permissions.class);
        } catch (Exception unused) {
            obj = null;
        }
        return (Permissions) obj;
    }

    public final ImageLoaderInterface getImageLoader() {
        Object obj;
        try {
            obj = getLegacyModuleRegistry().getModule(ImageLoaderInterface.class);
        } catch (Exception unused) {
            obj = null;
        }
        return (ImageLoaderInterface) obj;
    }

    public final BarCodeScannerInterface getBarcodeScanner() {
        Object obj;
        try {
            obj = getLegacyModuleRegistry().getModule(BarCodeScannerInterface.class);
        } catch (Exception unused) {
            obj = null;
        }
        return (BarCodeScannerInterface) obj;
    }

    public final CameraViewInterface getCamera() {
        Object obj;
        try {
            obj = getLegacyModuleRegistry().getModule(CameraViewInterface.class);
        } catch (Exception unused) {
            obj = null;
        }
        return (CameraViewInterface) obj;
    }

    public final FontManagerInterface getFont() {
        Object obj;
        try {
            obj = getLegacyModuleRegistry().getModule(FontManagerInterface.class);
        } catch (Exception unused) {
            obj = null;
        }
        return (FontManagerInterface) obj;
    }

    public final SensorServiceInterface getSensor() {
        Object obj;
        try {
            obj = getLegacyModuleRegistry().getModule(SensorServiceInterface.class);
        } catch (Exception unused) {
            obj = null;
        }
        return (SensorServiceInterface) obj;
    }

    public final TaskManagerInterface getTaskManager() {
        Object obj;
        try {
            obj = getLegacyModuleRegistry().getModule(TaskManagerInterface.class);
        } catch (Exception unused) {
            obj = null;
        }
        return (TaskManagerInterface) obj;
    }

    public final ActivityProvider getActivityProvider() {
        Object obj;
        try {
            obj = getLegacyModuleRegistry().getModule(ActivityProvider.class);
        } catch (Exception unused) {
            obj = null;
        }
        return (ActivityProvider) obj;
    }

    public final EventEmitter eventEmitter(Module module) {
        Object obj;
        Intrinsics.checkNotNullParameter(module, "module");
        try {
            obj = getLegacyModuleRegistry().getModule(expo.modules.core.interfaces.services.EventEmitter.class);
        } catch (Exception unused) {
            obj = null;
        }
        expo.modules.core.interfaces.services.EventEmitter eventEmitter = (expo.modules.core.interfaces.services.EventEmitter) obj;
        if (eventEmitter == null) {
            return null;
        }
        ModuleHolder moduleHolder = this.registry.getModuleHolder(module);
        if (moduleHolder != null) {
            return new KModuleEventEmitterWrapper(moduleHolder, eventEmitter, this.reactContextHolder);
        }
        throw new IllegalArgumentException("Cannot create an event emitter for the module that isn't present in the module registry.".toString());
    }

    public final EventEmitter getCallbackInvoker$expo_modules_core_release() {
        Object obj;
        try {
            obj = getLegacyModuleRegistry().getModule(expo.modules.core.interfaces.services.EventEmitter.class);
        } catch (Exception unused) {
            obj = null;
        }
        expo.modules.core.interfaces.services.EventEmitter eventEmitter = (expo.modules.core.interfaces.services.EventEmitter) obj;
        if (eventEmitter == null) {
            return null;
        }
        return new KEventEmitterWrapper(eventEmitter, this.reactContextHolder);
    }

    public final ErrorManagerModule getErrorManager() {
        AppContextProvider appContextProvider;
        Object obj;
        Iterator it = this.registry.getRegistry().values().iterator();
        while (true) {
            appContextProvider = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Module module = ((ModuleHolder) obj).getModule();
            if (module != null) {
                if (module instanceof ErrorManagerModule) {
                    break;
                }
            } else {
                break;
            }
        }
        ModuleHolder moduleHolder = (ModuleHolder) obj;
        AppContextProvider module2 = moduleHolder != null ? moduleHolder.getModule() : null;
        if (module2 instanceof ErrorManagerModule) {
            appContextProvider = module2;
        }
        return (ErrorManagerModule) appContextProvider;
    }

    public final void onDestroy$expo_modules_core_release() {
        Trace.beginSection("[ExpoModulesCore] AppContext.onDestroy");
        try {
            ReactApplicationContext reactApplicationContext = (ReactApplicationContext) this.reactContextHolder.get();
            if (reactApplicationContext != null) {
                reactApplicationContext.removeLifecycleEventListener(this.reactLifecycleDelegate);
            }
            getRegistry().post(EventName.MODULE_DESTROY);
            getRegistry().cleanUp();
            getCoreModule$expo_modules_core_release().getModule().set_appContext$expo_modules_core_release((AppContext) null);
            CoroutineScopeKt.cancel(getModulesQueue(), new ContextDestroyedException((String) null, 1, (DefaultConstructorMarker) null));
            CoroutineScopeKt.cancel(getMainQueue(), new ContextDestroyedException((String) null, 1, (DefaultConstructorMarker) null));
            CoroutineScopeKt.cancel(getBackgroundCoroutineScope(), new ContextDestroyedException((String) null, 1, (DefaultConstructorMarker) null));
            getJniDeallocator().deallocate$expo_modules_core_release();
            CoreLoggerKt.getLogger().info("✅ AppContext was destroyed");
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }
}
