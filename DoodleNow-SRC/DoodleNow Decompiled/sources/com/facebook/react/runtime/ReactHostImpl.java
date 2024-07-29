package com.facebook.react.runtime;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.JSEngineResolutionAlgorithm;
import com.facebook.react.MemoryPressureRouter;
import com.facebook.react.ReactHost;
import com.facebook.react.ReactInstanceEventListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.MemoryPressureListener;
import com.facebook.react.bridge.NativeArray;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.ReactNoCrashBridgeNotAllowedSoftException;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.RuntimeExecutor;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.queue.QueueThreadExceptionHandler;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.devsupport.DevSupportManagerBase;
import com.facebook.react.devsupport.DisabledDevSupportManager;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.fabric.ComponentFactory;
import com.facebook.react.fabric.FabricUIManager;
import com.facebook.react.interfaces.TaskInterface;
import com.facebook.react.interfaces.exceptionmanager.ReactJsExceptionHandler;
import com.facebook.react.interfaces.fabric.ReactSurface;
import com.facebook.react.modules.appearance.AppearanceModule;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.runtime.internal.bolts.Continuation;
import com.facebook.react.runtime.internal.bolts.Task;
import com.facebook.react.runtime.internal.bolts.TaskCompletionSource;
import com.facebook.react.turbomodule.core.interfaces.CallInvokerHolder;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.BlackHoleEventDispatcher;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.imagehelper.ResourceDrawableIdHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public class ReactHostImpl implements ReactHost {
    private static final int BRIDGELESS_MARKER_INSTANCE_KEY = 1;
    private static final boolean DEV = false;
    private static final String TAG = "ReactHost";
    private static final AtomicInteger mCounter = new AtomicInteger(0);
    private final AtomicReference<Activity> mActivity;
    private final boolean mAllowPackagerServerAccess;
    private final Set<ReactSurfaceImpl> mAttachedSurfaces;
    private final Executor mBGExecutor;
    private final Set<Function0<Unit>> mBeforeDestroyListeners;
    private final BridgelessAtomicRef<BridgelessReactContext> mBridgelessReactContextRef;
    private final BridgelessReactStateTracker mBridgelessReactStateTracker;
    private final ComponentFactory mComponentFactory;
    private final Context mContext;
    private DefaultHardwareBackBtnHandler mDefaultHardwareBackBtnHandler;
    private Task<Void> mDestroyTask;
    private final DevSupportManager mDevSupportManager;
    private final int mId;
    private JSEngineResolutionAlgorithm mJSEngineResolutionAlgorithm;
    private final AtomicReference<WeakReference<Activity>> mLastUsedActivity;
    private MemoryPressureListener mMemoryPressureListener;
    private final MemoryPressureRouter mMemoryPressureRouter;
    private final QueueThreadExceptionHandler mQueueThreadExceptionHandler;
    private final ReactHostDelegate mReactHostDelegate;
    private final Collection<ReactInstanceEventListener> mReactInstanceEventListeners;
    private final BridgelessAtomicRef<Task<ReactInstance>> mReactInstanceTaskRef;
    private final ReactJsExceptionHandler mReactJsExceptionHandler;
    private final ReactLifecycleStateManager mReactLifecycleStateManager;
    /* access modifiers changed from: private */
    public Task<ReactInstance> mReloadTask;
    private Task<Void> mStartTask;
    private final Executor mUIExecutor;
    private final boolean mUseDevSupport;

    private interface ReactInstanceTaskUnwrapper {
        ReactInstance unwrap(Task<ReactInstance> task, String str);
    }

    interface VeniceThenable<T> {
        void then(T t);
    }

    public JSEngineResolutionAlgorithm getJsEngineResolutionAlgorithm() {
        return this.mJSEngineResolutionAlgorithm;
    }

    public MemoryPressureRouter getMemoryPressureRouter() {
        return this.mMemoryPressureRouter;
    }

    public void setJsEngineResolutionAlgorithm(JSEngineResolutionAlgorithm jSEngineResolutionAlgorithm) {
        this.mJSEngineResolutionAlgorithm = jSEngineResolutionAlgorithm;
    }

    public ReactHostImpl(Context context, ReactHostDelegate reactHostDelegate, ComponentFactory componentFactory, boolean z, ReactJsExceptionHandler reactJsExceptionHandler, boolean z2) {
        this(context, reactHostDelegate, componentFactory, Executors.newSingleThreadExecutor(), Task.UI_THREAD_EXECUTOR, reactJsExceptionHandler, z, z2);
    }

    public ReactHostImpl(Context context, ReactHostDelegate reactHostDelegate, ComponentFactory componentFactory, Executor executor, Executor executor2, ReactJsExceptionHandler reactJsExceptionHandler, boolean z, boolean z2) {
        this.mAttachedSurfaces = Collections.synchronizedSet(new HashSet());
        this.mReactInstanceEventListeners = Collections.synchronizedList(new ArrayList());
        this.mReactInstanceTaskRef = new BridgelessAtomicRef<>(Task.forResult((ReactInstance) Assertions.nullsafeFIXME(null, "forResult parameter supports null, but is not annotated as @Nullable")));
        this.mBridgelessReactContextRef = new BridgelessAtomicRef<>();
        this.mActivity = new AtomicReference<>();
        this.mLastUsedActivity = new AtomicReference<>(new WeakReference((Object) null));
        BridgelessReactStateTracker bridgelessReactStateTracker = new BridgelessReactStateTracker(false);
        this.mBridgelessReactStateTracker = bridgelessReactStateTracker;
        this.mReactLifecycleStateManager = new ReactLifecycleStateManager(bridgelessReactStateTracker);
        this.mId = mCounter.getAndIncrement();
        this.mJSEngineResolutionAlgorithm = null;
        this.mBeforeDestroyListeners = Collections.synchronizedSet(new HashSet());
        this.mStartTask = null;
        this.mReloadTask = null;
        this.mDestroyTask = null;
        this.mContext = context;
        this.mReactHostDelegate = reactHostDelegate;
        this.mComponentFactory = componentFactory;
        this.mBGExecutor = executor;
        this.mUIExecutor = executor2;
        this.mReactJsExceptionHandler = reactJsExceptionHandler;
        this.mQueueThreadExceptionHandler = new ReactHostImpl$$ExternalSyntheticLambda12(this);
        this.mMemoryPressureRouter = new MemoryPressureRouter(context);
        this.mMemoryPressureListener = new ReactHostImpl$$ExternalSyntheticLambda13(this);
        this.mAllowPackagerServerAccess = z;
        this.mDevSupportManager = new DisabledDevSupportManager();
        this.mUseDevSupport = z2;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(int i) {
        callWithExistingReactInstance("handleMemoryPressure(" + i + ")", new ReactHostImpl$$ExternalSyntheticLambda35(i));
    }

    public LifecycleState getLifecycleState() {
        return this.mReactLifecycleStateManager.getLifecycleState();
    }

    public TaskInterface<Void> start() {
        return Task.call(new ReactHostImpl$$ExternalSyntheticLambda34(this), this.mBGExecutor).continueWithTask(new ReactHostImpl$$ExternalSyntheticLambda20());
    }

    /* access modifiers changed from: package-private */
    public TaskInterface<Void> prerenderSurface(ReactSurfaceImpl reactSurfaceImpl) {
        String str = "prerenderSurface(surfaceId = " + reactSurfaceImpl.getSurfaceID() + ")";
        log(str, "Schedule");
        attachSurface(reactSurfaceImpl);
        return callAfterGetOrCreateReactInstance(str, new ReactHostImpl$$ExternalSyntheticLambda15(this, str, reactSurfaceImpl));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$prerenderSurface$2(String str, ReactSurfaceImpl reactSurfaceImpl, ReactInstance reactInstance) {
        log(str, "Execute");
        reactInstance.prerenderSurface(reactSurfaceImpl);
    }

    /* access modifiers changed from: package-private */
    public TaskInterface<Void> startSurface(ReactSurfaceImpl reactSurfaceImpl) {
        String str = "startSurface(surfaceId = " + reactSurfaceImpl.getSurfaceID() + ")";
        log(str, "Schedule");
        attachSurface(reactSurfaceImpl);
        return callAfterGetOrCreateReactInstance(str, new ReactHostImpl$$ExternalSyntheticLambda23(this, str, reactSurfaceImpl));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$startSurface$3(String str, ReactSurfaceImpl reactSurfaceImpl, ReactInstance reactInstance) {
        log(str, "Execute");
        reactInstance.startSurface(reactSurfaceImpl);
    }

    /* access modifiers changed from: package-private */
    public TaskInterface<Void> stopSurface(ReactSurfaceImpl reactSurfaceImpl) {
        String str = "stopSurface(surfaceId = " + reactSurfaceImpl.getSurfaceID() + ")";
        log(str, "Schedule");
        detachSurface(reactSurfaceImpl);
        return callWithExistingReactInstance(str, new ReactHostImpl$$ExternalSyntheticLambda41(this, str, reactSurfaceImpl)).makeVoid();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$stopSurface$4(String str, ReactSurfaceImpl reactSurfaceImpl, ReactInstance reactInstance) {
        log(str, "Execute");
        reactInstance.stopSurface(reactSurfaceImpl);
    }

    public void onHostResume(Activity activity, DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler) {
        this.mDefaultHardwareBackBtnHandler = defaultHardwareBackBtnHandler;
        onHostResume(activity);
    }

    public void onHostResume(Activity activity) {
        log("onHostResume(activity)");
        setCurrentActivity(activity);
        this.mReactLifecycleStateManager.moveToOnHostResume(getCurrentReactContext(), getCurrentActivity());
    }

    public void onHostPause(Activity activity) {
        String str;
        log("onHostPause(activity)");
        ReactContext currentReactContext = getCurrentReactContext();
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            String simpleName = currentActivity.getClass().getSimpleName();
            if (activity == null) {
                str = "null";
            } else {
                str = activity.getClass().getSimpleName();
            }
            boolean z = activity == currentActivity;
            Assertions.assertCondition(z, "Pausing an activity that is not the current activity, this is incorrect! Current activity: " + simpleName + " Paused activity: " + str);
        }
        this.mDefaultHardwareBackBtnHandler = null;
        this.mReactLifecycleStateManager.moveToOnHostPause(currentReactContext, currentActivity);
    }

    public void onHostPause() {
        log("onHostPause()");
        ReactContext currentReactContext = getCurrentReactContext();
        this.mDefaultHardwareBackBtnHandler = null;
        this.mReactLifecycleStateManager.moveToOnHostPause(currentReactContext, getCurrentActivity());
    }

    public void onHostDestroy() {
        log("onHostDestroy()");
        moveToHostDestroy(getCurrentReactContext());
    }

    public void onHostDestroy(Activity activity) {
        log("onHostDestroy(activity)");
        if (getCurrentActivity() == activity) {
            moveToHostDestroy(getCurrentReactContext());
        }
    }

    public ReactContext getCurrentReactContext() {
        return this.mBridgelessReactContextRef.getNullable();
    }

    public DevSupportManager getDevSupportManager() {
        return (DevSupportManager) Assertions.assertNotNull(this.mDevSupportManager);
    }

    public ReactSurface createSurface(Context context, String str, Bundle bundle) {
        ReactSurfaceImpl reactSurfaceImpl = new ReactSurfaceImpl(context, str, bundle);
        reactSurfaceImpl.attachView(new ReactSurfaceView(context, reactSurfaceImpl));
        reactSurfaceImpl.attach(this);
        return reactSurfaceImpl;
    }

    /* access modifiers changed from: package-private */
    public boolean isInstanceInitialized() {
        return ((ReactInstance) this.mReactInstanceTaskRef.get().getResult()) != null;
    }

    public boolean onBackPressed() {
        DeviceEventManagerModule deviceEventManagerModule;
        UiThreadUtil.assertOnUiThread();
        ReactInstance reactInstance = (ReactInstance) this.mReactInstanceTaskRef.get().getResult();
        if (reactInstance == null || (deviceEventManagerModule = (DeviceEventManagerModule) reactInstance.getNativeModule(DeviceEventManagerModule.class)) == null) {
            return false;
        }
        deviceEventManagerModule.emitHardwareBackPressed();
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.facebook.react.bridge.queue.ReactQueueConfiguration getReactQueueConfiguration() {
        /*
            r3 = this;
            com.facebook.react.runtime.BridgelessAtomicRef<com.facebook.react.runtime.internal.bolts.Task<com.facebook.react.runtime.ReactInstance>> r0 = r3.mReactInstanceTaskRef
            monitor-enter(r0)
            com.facebook.react.runtime.BridgelessAtomicRef<com.facebook.react.runtime.internal.bolts.Task<com.facebook.react.runtime.ReactInstance>> r1 = r3.mReactInstanceTaskRef     // Catch:{ all -> 0x002c }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x002c }
            com.facebook.react.runtime.internal.bolts.Task r1 = (com.facebook.react.runtime.internal.bolts.Task) r1     // Catch:{ all -> 0x002c }
            boolean r2 = r1.isFaulted()     // Catch:{ all -> 0x002c }
            if (r2 != 0) goto L_0x0029
            boolean r2 = r1.isCancelled()     // Catch:{ all -> 0x002c }
            if (r2 != 0) goto L_0x0029
            java.lang.Object r2 = r1.getResult()     // Catch:{ all -> 0x002c }
            if (r2 == 0) goto L_0x0029
            java.lang.Object r1 = r1.getResult()     // Catch:{ all -> 0x002c }
            com.facebook.react.runtime.ReactInstance r1 = (com.facebook.react.runtime.ReactInstance) r1     // Catch:{ all -> 0x002c }
            com.facebook.react.bridge.queue.ReactQueueConfiguration r1 = r1.getReactQueueConfiguration()     // Catch:{ all -> 0x002c }
            monitor-exit(r0)     // Catch:{ all -> 0x002c }
            return r1
        L_0x0029:
            monitor-exit(r0)     // Catch:{ all -> 0x002c }
            r0 = 0
            return r0
        L_0x002c:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002c }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.runtime.ReactHostImpl.getReactQueueConfiguration():com.facebook.react.bridge.queue.ReactQueueConfiguration");
    }

    public void addReactInstanceEventListener(ReactInstanceEventListener reactInstanceEventListener) {
        this.mReactInstanceEventListeners.add(reactInstanceEventListener);
    }

    public void removeReactInstanceEventListener(ReactInstanceEventListener reactInstanceEventListener) {
        this.mReactInstanceEventListeners.remove(reactInstanceEventListener);
    }

    public TaskInterface<Void> reload(String str) {
        return Task.call(new ReactHostImpl$$ExternalSyntheticLambda19(this, str), this.mBGExecutor).continueWithTask(new ReactHostImpl$$ExternalSyntheticLambda20());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Task lambda$reload$7(String str) throws Exception {
        Task<Void> task;
        if (this.mDestroyTask != null) {
            log("reload()", "Waiting for destroy to finish, before reloading React Native.");
            task = this.mDestroyTask.continueWithTask(new ReactHostImpl$$ExternalSyntheticLambda17(this, str), this.mBGExecutor).makeVoid();
        } else {
            task = getOrCreateReloadTask(str).makeVoid();
        }
        return task.continueWithTask((Continuation<Void, Task<TContinuationResult>>) new ReactHostImpl$$ExternalSyntheticLambda18(this), this.mBGExecutor);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Task lambda$reload$5(String str, Task task) throws Exception {
        return getOrCreateReloadTask(str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Task lambda$reload$6(Task task) throws Exception {
        if (!task.isFaulted()) {
            return task;
        }
        this.mReactHostDelegate.handleInstanceException(task.getError());
        return getOrCreateDestroyTask("Reload failed", task.getError());
    }

    public TaskInterface<Void> destroy(String str, Exception exc) {
        return Task.call(new ReactHostImpl$$ExternalSyntheticLambda30(this, str, exc), this.mBGExecutor).continueWithTask(new ReactHostImpl$$ExternalSyntheticLambda20());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Task lambda$destroy$9(String str, Exception exc) throws Exception {
        if (this.mReloadTask == null) {
            return getOrCreateDestroyTask(str, exc);
        }
        log("destroy()", "Reloading React Native. Waiting for reload to finish before destroying React Native.");
        return this.mReloadTask.continueWithTask(new ReactHostImpl$$ExternalSyntheticLambda26(this, str, exc), this.mBGExecutor);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Task lambda$destroy$8(String str, Exception exc, Task task) throws Exception {
        return getOrCreateDestroyTask(str, exc);
    }

    private MemoryPressureListener createMemoryPressureListener(ReactInstance reactInstance) {
        return new ReactHostImpl$$ExternalSyntheticLambda4(this, new WeakReference(reactInstance));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$createMemoryPressureListener$11(WeakReference weakReference, int i) {
        this.mBGExecutor.execute(new ReactHostImpl$$ExternalSyntheticLambda3(weakReference, i));
    }

    static /* synthetic */ void lambda$createMemoryPressureListener$10(WeakReference weakReference, int i) {
        ReactInstance reactInstance = (ReactInstance) weakReference.get();
        if (reactInstance != null) {
            reactInstance.handleMemoryPressure(i);
        }
    }

    /* access modifiers changed from: package-private */
    public Activity getCurrentActivity() {
        return this.mActivity.get();
    }

    /* access modifiers changed from: package-private */
    public Activity getLastUsedActivity() {
        WeakReference weakReference = this.mLastUsedActivity.get();
        if (weakReference != null) {
            return (Activity) weakReference.get();
        }
        return null;
    }

    private void setCurrentActivity(Activity activity) {
        this.mActivity.set(activity);
        if (activity != null) {
            this.mLastUsedActivity.set(new WeakReference(activity));
        }
    }

    /* access modifiers changed from: package-private */
    public EventDispatcher getEventDispatcher() {
        ReactInstance reactInstance = (ReactInstance) this.mReactInstanceTaskRef.get().getResult();
        if (reactInstance == null) {
            return BlackHoleEventDispatcher.get();
        }
        return reactInstance.getEventDispatcher();
    }

    /* access modifiers changed from: package-private */
    public FabricUIManager getUIManager() {
        ReactInstance reactInstance = (ReactInstance) this.mReactInstanceTaskRef.get().getResult();
        if (reactInstance == null) {
            return null;
        }
        return reactInstance.getUIManager();
    }

    /* access modifiers changed from: package-private */
    public <T extends NativeModule> boolean hasNativeModule(Class<T> cls) {
        ReactInstance reactInstance = (ReactInstance) this.mReactInstanceTaskRef.get().getResult();
        if (reactInstance != null) {
            return reactInstance.hasNativeModule(cls);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public Collection<NativeModule> getNativeModules() {
        ReactInstance reactInstance = (ReactInstance) this.mReactInstanceTaskRef.get().getResult();
        if (reactInstance != null) {
            return reactInstance.getNativeModules();
        }
        return new ArrayList();
    }

    /* access modifiers changed from: package-private */
    public <T extends NativeModule> T getNativeModule(Class<T> cls) {
        if (cls == UIManagerModule.class) {
            ReactSoftExceptionLogger.logSoftExceptionVerbose(TAG, new ReactNoCrashBridgeNotAllowedSoftException("getNativeModule(UIManagerModule.class) cannot be called when the bridge is disabled"));
        }
        ReactInstance reactInstance = (ReactInstance) this.mReactInstanceTaskRef.get().getResult();
        if (reactInstance != null) {
            return reactInstance.getNativeModule(cls);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public NativeModule getNativeModule(String str) {
        ReactInstance reactInstance = (ReactInstance) this.mReactInstanceTaskRef.get().getResult();
        if (reactInstance != null) {
            return reactInstance.getNativeModule(str);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public RuntimeExecutor getRuntimeExecutor() {
        ReactInstance reactInstance = (ReactInstance) this.mReactInstanceTaskRef.get().getResult();
        if (reactInstance != null) {
            return reactInstance.getBufferedRuntimeExecutor();
        }
        ReactSoftExceptionLogger.logSoftException(TAG, new ReactNoCrashSoftException("Tried to get runtime executor while instance is not ready"));
        return null;
    }

    /* access modifiers changed from: package-private */
    public CallInvokerHolder getJSCallInvokerHolder() {
        ReactInstance reactInstance = (ReactInstance) this.mReactInstanceTaskRef.get().getResult();
        if (reactInstance != null) {
            return reactInstance.getJSCallInvokerHolder();
        }
        ReactSoftExceptionLogger.logSoftException(TAG, new ReactNoCrashSoftException("Tried to get JSCallInvokerHolder while instance is not ready"));
        return null;
    }

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        log("onActivityResult(activity = \"" + activity + "\", requestCode = \"" + i + "\", resultCode = \"" + i2 + "\", data = \"" + intent + "\")");
        ReactContext currentReactContext = getCurrentReactContext();
        if (currentReactContext != null) {
            currentReactContext.onActivityResult(activity, i, i2, intent);
        } else {
            ReactSoftExceptionLogger.logSoftException(TAG, new ReactNoCrashSoftException("Tried to access onActivityResult while context is not ready"));
        }
    }

    public void onWindowFocusChange(boolean z) {
        log("onWindowFocusChange(hasFocus = \"" + z + "\")");
        ReactContext currentReactContext = getCurrentReactContext();
        if (currentReactContext != null) {
            currentReactContext.onWindowFocusChange(z);
        } else {
            ReactSoftExceptionLogger.logSoftException(TAG, new ReactNoCrashSoftException("Tried to access onWindowFocusChange while context is not ready"));
        }
    }

    public void onNewIntent(Intent intent) {
        DeviceEventManagerModule deviceEventManagerModule;
        log("onNewIntent()");
        ReactContext currentReactContext = getCurrentReactContext();
        if (currentReactContext != null) {
            String action = intent.getAction();
            Uri data = intent.getData();
            if (data != null && (("android.intent.action.VIEW".equals(action) || "android.nfc.action.NDEF_DISCOVERED".equals(action)) && (deviceEventManagerModule = (DeviceEventManagerModule) currentReactContext.getNativeModule(DeviceEventManagerModule.class)) != null)) {
                deviceEventManagerModule.emitNewIntentReceived(data);
            }
            currentReactContext.onNewIntent(getCurrentActivity(), intent);
            return;
        }
        ReactSoftExceptionLogger.logSoftException(TAG, new ReactNoCrashSoftException("Tried to access onNewIntent while context is not ready"));
    }

    public void onConfigurationChanged(Context context) {
        AppearanceModule appearanceModule;
        ReactContext currentReactContext = getCurrentReactContext();
        if (currentReactContext != null && (appearanceModule = (AppearanceModule) currentReactContext.getNativeModule(AppearanceModule.class)) != null) {
            appearanceModule.onConfigurationChanged(context);
        }
    }

    /* access modifiers changed from: package-private */
    public JavaScriptContextHolder getJavaScriptContextHolder() {
        ReactInstance reactInstance = (ReactInstance) this.mReactInstanceTaskRef.get().getResult();
        if (reactInstance != null) {
            return reactInstance.getJavaScriptContextHolder();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public DefaultHardwareBackBtnHandler getDefaultBackButtonHandler() {
        return new ReactHostImpl$$ExternalSyntheticLambda27(this);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$getDefaultBackButtonHandler$12() {
        UiThreadUtil.assertOnUiThread();
        DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler = this.mDefaultHardwareBackBtnHandler;
        if (defaultHardwareBackBtnHandler != null) {
            defaultHardwareBackBtnHandler.invokeDefaultOnBackPressed();
        }
    }

    /* access modifiers changed from: package-private */
    public Task<Boolean> loadBundle(JSBundleLoader jSBundleLoader) {
        log("loadBundle()", "Schedule");
        return callWithExistingReactInstance("loadBundle()", new ReactHostImpl$$ExternalSyntheticLambda0(this, jSBundleLoader));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$loadBundle$13(JSBundleLoader jSBundleLoader, ReactInstance reactInstance) {
        log("loadBundle()", "Execute");
        reactInstance.loadJSBundle(jSBundleLoader);
    }

    /* access modifiers changed from: package-private */
    public Task<Boolean> registerSegment(int i, String str, Callback callback) {
        String str2 = "registerSegment(segmentId = \"" + i + "\", path = \"" + str + "\")";
        log(str2, "Schedule");
        return callWithExistingReactInstance(str2, new ReactHostImpl$$ExternalSyntheticLambda11(this, str2, i, str, callback));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$registerSegment$14(String str, int i, String str2, Callback callback, ReactInstance reactInstance) {
        log(str, "Execute");
        reactInstance.registerSegment(i, str2);
        ((Callback) Assertions.assertNotNull(callback)).invoke(new Object[0]);
    }

    /* access modifiers changed from: package-private */
    public void handleHostException(Exception exc) {
        String str = "handleHostException(message = \"" + exc.getMessage() + "\")";
        log(str);
        destroy(str, exc);
        this.mReactHostDelegate.handleInstanceException(exc);
    }

    /* access modifiers changed from: package-private */
    public Task<Boolean> callFunctionOnModule(String str, String str2, NativeArray nativeArray) {
        return callWithExistingReactInstance("callFunctionOnModule(\"" + str + "\", \"" + str2 + "\")", new ReactHostImpl$$ExternalSyntheticLambda29(str, str2, nativeArray));
    }

    /* access modifiers changed from: package-private */
    public void attachSurface(ReactSurfaceImpl reactSurfaceImpl) {
        log("attachSurface(surfaceId = " + reactSurfaceImpl.getSurfaceID() + ")");
        synchronized (this.mAttachedSurfaces) {
            this.mAttachedSurfaces.add(reactSurfaceImpl);
        }
    }

    /* access modifiers changed from: package-private */
    public void detachSurface(ReactSurfaceImpl reactSurfaceImpl) {
        log("detachSurface(surfaceId = " + reactSurfaceImpl.getSurfaceID() + ")");
        synchronized (this.mAttachedSurfaces) {
            this.mAttachedSurfaces.remove(reactSurfaceImpl);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isSurfaceAttached(ReactSurfaceImpl reactSurfaceImpl) {
        boolean contains;
        synchronized (this.mAttachedSurfaces) {
            contains = this.mAttachedSurfaces.contains(reactSurfaceImpl);
        }
        return contains;
    }

    /* access modifiers changed from: package-private */
    public boolean isSurfaceWithModuleNameAttached(String str) {
        synchronized (this.mAttachedSurfaces) {
            for (ReactSurfaceImpl moduleName : this.mAttachedSurfaces) {
                if (moduleName.getModuleName().equals(str)) {
                    return true;
                }
            }
            return false;
        }
    }

    public void addBeforeDestroyListener(Function0<Unit> function0) {
        synchronized (this.mBeforeDestroyListeners) {
            this.mBeforeDestroyListeners.add(function0);
        }
    }

    public void removeBeforeDestroyListener(Function0<Unit> function0) {
        synchronized (this.mBeforeDestroyListeners) {
            this.mBeforeDestroyListeners.remove(function0);
        }
    }

    /* access modifiers changed from: private */
    public Task<Void> getOrCreateStartTask() {
        if (this.mStartTask == null) {
            log("getOrCreateStartTask()", "Schedule");
            this.mStartTask = waitThenCallGetOrCreateReactInstanceTask().continueWithTask(new ReactHostImpl$$ExternalSyntheticLambda22(this), this.mBGExecutor);
        }
        return this.mStartTask;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Task lambda$getOrCreateStartTask$17(Task task) throws Exception {
        if (!task.isFaulted()) {
            return task.makeVoid();
        }
        this.mReactHostDelegate.handleInstanceException(task.getError());
        return getOrCreateDestroyTask("getOrCreateStartTask() failure: " + task.getError().getMessage(), task.getError()).continueWithTask(new ReactHostImpl$$ExternalSyntheticLambda36(task)).makeVoid();
    }

    private void moveToHostDestroy(ReactContext reactContext) {
        this.mReactLifecycleStateManager.moveToOnHostDestroy(reactContext);
        setCurrentActivity((Activity) null);
    }

    private void raiseSoftException(String str, String str2) {
        raiseSoftException(str, str2, (Throwable) null);
    }

    private void raiseSoftException(String str, String str2, Throwable th) {
        log(str, str2);
        if (!ReactFeatureFlags.enableBridgelessArchitectureSoftExceptions) {
            return;
        }
        if (th != null) {
            ReactSoftExceptionLogger.logSoftException(TAG, new ReactNoCrashSoftException(str + ": " + str2, th));
            return;
        }
        ReactSoftExceptionLogger.logSoftException(TAG, new ReactNoCrashSoftException(str + ": " + str2));
    }

    private Task<Boolean> callWithExistingReactInstance(String str, VeniceThenable<ReactInstance> veniceThenable) {
        return this.mReactInstanceTaskRef.get().onSuccess(new ReactHostImpl$$ExternalSyntheticLambda33(this, "callWithExistingReactInstance(" + str + ")", veniceThenable), this.mBGExecutor);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$callWithExistingReactInstance$18(String str, VeniceThenable veniceThenable, Task task) throws Exception {
        ReactInstance reactInstance = (ReactInstance) task.getResult();
        if (reactInstance == null) {
            raiseSoftException(str, "Execute: ReactInstance null. Dropping work.");
            return Boolean.FALSE;
        }
        veniceThenable.then(reactInstance);
        return Boolean.TRUE;
    }

    private Task<Void> callAfterGetOrCreateReactInstance(String str, VeniceThenable<ReactInstance> veniceThenable) {
        return getOrCreateReactInstance().onSuccess(new ReactHostImpl$$ExternalSyntheticLambda31(this, "callAfterGetOrCreateReactInstance(" + str + ")", veniceThenable), this.mBGExecutor).continueWith(new ReactHostImpl$$ExternalSyntheticLambda32(this), this.mBGExecutor);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Void lambda$callAfterGetOrCreateReactInstance$19(String str, VeniceThenable veniceThenable, Task task) throws Exception {
        ReactInstance reactInstance = (ReactInstance) task.getResult();
        if (reactInstance == null) {
            raiseSoftException(str, "Execute: ReactInstance is null");
            return null;
        }
        veniceThenable.then(reactInstance);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Void lambda$callAfterGetOrCreateReactInstance$20(Task task) throws Exception {
        if (!task.isFaulted()) {
            return null;
        }
        handleHostException(task.getError());
        return null;
    }

    private BridgelessReactContext getOrCreateReactContext() {
        return this.mBridgelessReactContextRef.getOrCreate(new ReactHostImpl$$ExternalSyntheticLambda16(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ BridgelessReactContext lambda$getOrCreateReactContext$21() {
        log("getOrCreateReactContext()", "Creating BridgelessReactContext");
        return new BridgelessReactContext(this.mContext, this);
    }

    private Task<ReactInstance> getOrCreateReactInstance() {
        return Task.call(new ReactHostImpl$$ExternalSyntheticLambda38(this), this.mBGExecutor).continueWithTask(new ReactHostImpl$$ExternalSyntheticLambda20());
    }

    /* access modifiers changed from: private */
    public Task<ReactInstance> waitThenCallGetOrCreateReactInstanceTask() {
        return waitThenCallGetOrCreateReactInstanceTaskWithRetries(0, 4);
    }

    private Task<ReactInstance> waitThenCallGetOrCreateReactInstanceTaskWithRetries(int i, int i2) {
        if (this.mReloadTask != null) {
            log("waitThenCallGetOrCreateReactInstanceTaskWithRetries", "React Native is reloading. Return reload task.");
            return this.mReloadTask;
        }
        if (this.mDestroyTask != null) {
            if (i < i2) {
                log("waitThenCallGetOrCreateReactInstanceTaskWithRetries", "React Native is tearing down.Wait for teardown to finish, before trying again (try count = " + i + ").");
                return this.mDestroyTask.onSuccessTask(new ReactHostImpl$$ExternalSyntheticLambda24(this, i, i2), this.mBGExecutor);
            }
            raiseSoftException("waitThenCallGetOrCreateReactInstanceTaskWithRetries", "React Native is tearing down. Not wait for teardown to finish: reached max retries.");
        }
        return getOrCreateReactInstanceTask();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Task lambda$waitThenCallGetOrCreateReactInstanceTaskWithRetries$22(int i, int i2, Task task) throws Exception {
        return waitThenCallGetOrCreateReactInstanceTaskWithRetries(i + 1, i2);
    }

    private Task<ReactInstance> getOrCreateReactInstanceTask() {
        log("getOrCreateReactInstanceTask()");
        return this.mReactInstanceTaskRef.getOrCreate(new ReactHostImpl$$ExternalSyntheticLambda37(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Task lambda$getOrCreateReactInstanceTask$26() {
        log("getOrCreateReactInstanceTask()", "Start");
        ReactMarker.logMarker(ReactMarkerConstants.REACT_BRIDGELESS_LOADING_START, 1);
        return getJsBundleLoader().onSuccess(new ReactHostImpl$$ExternalSyntheticLambda39(this), this.mBGExecutor).onSuccess(new ReactHostImpl$$ExternalSyntheticLambda40(this), this.mUIExecutor);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ AnonymousClass1Result lambda$getOrCreateReactInstanceTask$24(Task task) throws Exception {
        JSBundleLoader jSBundleLoader = (JSBundleLoader) task.getResult();
        BridgelessReactContext orCreateReactContext = getOrCreateReactContext();
        DevSupportManager devSupportManager = getDevSupportManager();
        orCreateReactContext.setJSExceptionHandler(devSupportManager);
        log("getOrCreateReactInstanceTask()", "Creating ReactInstance");
        ReactInstance reactInstance = new ReactInstance(orCreateReactContext, this.mReactHostDelegate, this.mComponentFactory, devSupportManager, this.mQueueThreadExceptionHandler, this.mReactJsExceptionHandler, this.mUseDevSupport);
        if (ReactFeatureFlags.unstable_bridgelessArchitectureMemoryPressureHackyBoltsFix) {
            this.mMemoryPressureListener = createMemoryPressureListener(reactInstance);
        }
        this.mMemoryPressureRouter.addMemoryPressureListener(this.mMemoryPressureListener);
        log("getOrCreateReactInstanceTask()", "Loading JS Bundle");
        reactInstance.loadJSBundle(jSBundleLoader);
        log("getOrCreateReactInstanceTask()", "Calling DevSupportManagerBase.onNewReactContextCreated(reactContext)");
        devSupportManager.onNewReactContextCreated(orCreateReactContext);
        orCreateReactContext.runOnJSQueueThread(new ReactHostImpl$$ExternalSyntheticLambda14());
        return new Object(reactInstance, orCreateReactContext) {
            final ReactContext mContext;
            final ReactInstance mInstance;
            final boolean mIsReloading;
            final /* synthetic */ ReactInstance val$instance;
            final /* synthetic */ BridgelessReactContext val$reactContext;

            {
                this.val$instance = r2;
                this.val$reactContext = r3;
                this.mInstance = r2;
                this.mContext = r3;
                this.mIsReloading = ReactHostImpl.this.mReloadTask != null;
            }
        };
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ReactInstance lambda$getOrCreateReactInstanceTask$25(Task task) throws Exception {
        ReactInstance reactInstance = ((AnonymousClass1Result) task.getResult()).mInstance;
        ReactContext reactContext = ((AnonymousClass1Result) task.getResult()).mContext;
        boolean z = ((AnonymousClass1Result) task.getResult()).mIsReloading;
        boolean z2 = this.mReactLifecycleStateManager.getLifecycleState() == LifecycleState.RESUMED;
        if (!z || z2) {
            this.mReactLifecycleStateManager.resumeReactContextIfHostResumed(reactContext, getCurrentActivity());
        } else {
            this.mReactLifecycleStateManager.moveToOnHostResume(reactContext, getCurrentActivity());
        }
        ReactInstanceEventListener[] reactInstanceEventListenerArr = (ReactInstanceEventListener[]) this.mReactInstanceEventListeners.toArray(new ReactInstanceEventListener[this.mReactInstanceEventListeners.size()]);
        log("getOrCreateReactInstanceTask()", "Executing ReactInstanceEventListeners");
        for (ReactInstanceEventListener reactInstanceEventListener : reactInstanceEventListenerArr) {
            if (reactInstanceEventListener != null) {
                reactInstanceEventListener.onReactContextInitialized(reactContext);
            }
        }
        return reactInstance;
    }

    private Task<JSBundleLoader> getJsBundleLoader() {
        log("getJSBundleLoader()");
        return Task.call(new ReactHostImpl$$ExternalSyntheticLambda28(this));
    }

    private /* synthetic */ Task lambda$getJsBundleLoader$27(Task task) throws Exception {
        if (((Boolean) task.getResult()).booleanValue()) {
            return loadJSBundleFromMetro();
        }
        return Task.forResult(this.mReactHostDelegate.getJsBundleLoader());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ JSBundleLoader lambda$getJsBundleLoader$28() throws Exception {
        return this.mReactHostDelegate.getJsBundleLoader();
    }

    private Task<Boolean> isMetroRunning() {
        log("isMetroRunning()");
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        getDevSupportManager().isPackagerRunning(new ReactHostImpl$$ExternalSyntheticLambda21(this, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$isMetroRunning$29(TaskCompletionSource taskCompletionSource, boolean z) {
        log("isMetroRunning()", "Async result = " + z);
        taskCompletionSource.setResult(Boolean.valueOf(z));
    }

    private Task<JSBundleLoader> loadJSBundleFromMetro() {
        log("loadJSBundleFromMetro()");
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        DevSupportManagerBase devSupportManagerBase = (DevSupportManagerBase) getDevSupportManager();
        String devServerBundleURL = devSupportManagerBase.getDevServerHelper().getDevServerBundleURL((String) Assertions.assertNotNull(devSupportManagerBase.getJSAppBundleName()));
        devSupportManagerBase.reloadJSFromServer(devServerBundleURL, new ReactHostImpl$$ExternalSyntheticLambda25(this, devServerBundleURL, devSupportManagerBase, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$loadJSBundleFromMetro$30(String str, DevSupportManagerBase devSupportManagerBase, TaskCompletionSource taskCompletionSource) {
        log("loadJSBundleFromMetro()", "Creating BundleLoader");
        taskCompletionSource.setResult(JSBundleLoader.createCachedBundleFromNetworkLoader(str, devSupportManagerBase.getDownloadedJSBundleFile()));
    }

    private void log(String str, String str2) {
        BridgelessReactStateTracker bridgelessReactStateTracker = this.mBridgelessReactStateTracker;
        bridgelessReactStateTracker.enterState("ReactHost{" + this.mId + "}." + str + ": " + str2);
    }

    private void log(String str) {
        BridgelessReactStateTracker bridgelessReactStateTracker = this.mBridgelessReactStateTracker;
        bridgelessReactStateTracker.enterState("ReactHost{" + this.mId + "}." + str);
    }

    private void stopAttachedSurfaces(String str, ReactInstance reactInstance) {
        log(str, "Stopping all React Native surfaces");
        synchronized (this.mAttachedSurfaces) {
            for (ReactSurfaceImpl next : this.mAttachedSurfaces) {
                reactInstance.stopSurface(next);
                next.clear();
            }
        }
    }

    private void startAttachedSurfaces(String str, ReactInstance reactInstance) {
        log(str, "Restarting previously running React Native Surfaces");
        synchronized (this.mAttachedSurfaces) {
            for (ReactSurfaceImpl startSurface : this.mAttachedSurfaces) {
                reactInstance.startSurface(startSurface);
            }
        }
    }

    private ReactInstanceTaskUnwrapper createReactInstanceUnwraper(String str, String str2, String str3) {
        return new ReactHostImpl$$ExternalSyntheticLambda42(this, str, str3, str2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ReactInstance lambda$createReactInstanceUnwraper$31(String str, String str2, String str3, Task task, String str4) {
        ReactInstance reactInstance = (ReactInstance) task.getResult();
        ReactInstance reactInstance2 = (ReactInstance) this.mReactInstanceTaskRef.get().getResult();
        String str5 = "Stage: " + str4;
        String str6 = str + " reason: " + str2;
        if (task.isFaulted()) {
            Exception error = task.getError();
            raiseSoftException(str3, str + ": ReactInstance task faulted. " + str5 + ". " + ("Fault reason: " + error.getMessage()) + ". " + str6);
            return reactInstance2;
        } else if (task.isCancelled()) {
            raiseSoftException(str3, str + ": ReactInstance task cancelled. " + str5 + ". " + str6);
            return reactInstance2;
        } else if (reactInstance == null) {
            raiseSoftException(str3, str + ": ReactInstance task returned null. " + str5 + ". " + str6);
            return reactInstance2;
        } else {
            if (!(reactInstance2 == null || reactInstance == reactInstance2)) {
                raiseSoftException(str3, str + ": Detected two different ReactInstances. Returning old. " + str5 + ". " + str6);
            }
            return reactInstance;
        }
    }

    private Task<ReactInstance> getOrCreateReloadTask(String str) {
        log("getOrCreateReloadTask()");
        raiseSoftException("getOrCreateReloadTask()", str);
        ReactInstanceTaskUnwrapper createReactInstanceUnwraper = createReactInstanceUnwraper("Reload", "getOrCreateReloadTask()", str);
        if (this.mReloadTask == null) {
            this.mReloadTask = this.mReactInstanceTaskRef.get().continueWithTask(new ReactHostImpl$$ExternalSyntheticLambda43(this, createReactInstanceUnwraper, str), this.mUIExecutor).continueWithTask(new ReactHostImpl$$ExternalSyntheticLambda44(this, createReactInstanceUnwraper), this.mBGExecutor).continueWithTask(new ReactHostImpl$$ExternalSyntheticLambda45(this, createReactInstanceUnwraper), this.mUIExecutor).continueWithTask(new ReactHostImpl$$ExternalSyntheticLambda46(this, createReactInstanceUnwraper), this.mUIExecutor).continueWithTask(new ReactHostImpl$$ExternalSyntheticLambda47(this, createReactInstanceUnwraper), this.mBGExecutor).continueWithTask(new ReactHostImpl$$ExternalSyntheticLambda1(this, createReactInstanceUnwraper), this.mBGExecutor).continueWithTask(new ReactHostImpl$$ExternalSyntheticLambda2(this, str), this.mBGExecutor);
        }
        return this.mReloadTask;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Task lambda$getOrCreateReloadTask$32(ReactInstanceTaskUnwrapper reactInstanceTaskUnwrapper, String str, Task task) throws Exception {
        log("getOrCreateReloadTask()", "Starting React Native reload");
        ReactInstance unwrap = reactInstanceTaskUnwrapper.unwrap(task, "1: Starting reload");
        ReactContext nullable = this.mBridgelessReactContextRef.getNullable();
        if (nullable == null) {
            raiseSoftException("getOrCreateReloadTask()", "ReactContext is null. Reload reason: " + str);
        }
        if (nullable != null && this.mReactLifecycleStateManager.getLifecycleState() == LifecycleState.RESUMED) {
            log("getOrCreateReloadTask()", "Calling ReactContext.onHostPause()");
            nullable.onHostPause();
        }
        return Task.forResult(unwrap);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Task lambda$getOrCreateReloadTask$33(ReactInstanceTaskUnwrapper reactInstanceTaskUnwrapper, Task task) throws Exception {
        ReactInstance unwrap = reactInstanceTaskUnwrapper.unwrap(task, "2: Surface shutdown");
        if (unwrap == null) {
            raiseSoftException("getOrCreateReloadTask()", "Skipping surface shutdown: ReactInstance null");
            return task;
        }
        stopAttachedSurfaces("getOrCreateReloadTask()", unwrap);
        return task;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Task lambda$getOrCreateReloadTask$34(ReactInstanceTaskUnwrapper reactInstanceTaskUnwrapper, Task task) throws Exception {
        HashSet<Function0> hashSet;
        reactInstanceTaskUnwrapper.unwrap(task, "3: Executing Before Destroy Listeners");
        synchronized (this.mBeforeDestroyListeners) {
            hashSet = new HashSet<>(this.mBeforeDestroyListeners);
        }
        for (Function0 invoke : hashSet) {
            invoke.invoke();
        }
        return task;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Task lambda$getOrCreateReloadTask$35(ReactInstanceTaskUnwrapper reactInstanceTaskUnwrapper, Task task) throws Exception {
        reactInstanceTaskUnwrapper.unwrap(task, "4: Destroying ReactContext");
        log("getOrCreateReloadTask()", "Removing memory pressure listener");
        this.mMemoryPressureRouter.removeMemoryPressureListener(this.mMemoryPressureListener);
        ReactContext nullable = this.mBridgelessReactContextRef.getNullable();
        if (nullable != null) {
            log("getOrCreateReloadTask()", "Destroying ReactContext");
            nullable.destroy();
        }
        if (this.mUseDevSupport && nullable != null) {
            log("getOrCreateReloadTask()", "Calling DevSupportManager.onReactInstanceDestroyed(reactContext)");
            this.mDevSupportManager.onReactInstanceDestroyed(nullable);
        }
        return task;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Task lambda$getOrCreateReloadTask$36(ReactInstanceTaskUnwrapper reactInstanceTaskUnwrapper, Task task) throws Exception {
        ReactInstance unwrap = reactInstanceTaskUnwrapper.unwrap(task, "5: Destroying ReactInstance");
        if (unwrap == null) {
            raiseSoftException("getOrCreateReloadTask()", "Skipping ReactInstance.destroy(): ReactInstance null");
        } else {
            log("getOrCreateReloadTask()", "Destroying ReactInstance");
            unwrap.destroy();
        }
        log("getOrCreateReloadTask()", "Resetting ReactContext ref");
        this.mBridgelessReactContextRef.reset();
        log("getOrCreateReloadTask()", "Resetting ReactInstance task ref");
        this.mReactInstanceTaskRef.reset();
        log("getOrCreateReloadTask()", "Resetting preload task ref");
        this.mStartTask = null;
        return getOrCreateReactInstanceTask();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Task lambda$getOrCreateReloadTask$37(ReactInstanceTaskUnwrapper reactInstanceTaskUnwrapper, Task task) throws Exception {
        ReactInstance unwrap = reactInstanceTaskUnwrapper.unwrap(task, "7: Restarting surfaces");
        if (unwrap == null) {
            raiseSoftException("getOrCreateReloadTask()", "Skipping surface restart: ReactInstance null");
            return task;
        }
        startAttachedSurfaces("getOrCreateReloadTask()", unwrap);
        return task;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Task lambda$getOrCreateReloadTask$38(String str, Task task) throws Exception {
        if (task.isFaulted()) {
            Exception error = task.getError();
            raiseSoftException("getOrCreateReloadTask()", "Error during reload. ReactInstance task faulted. Fault reason: " + error.getMessage() + ". Reload reason: " + str, task.getError());
        }
        if (task.isCancelled()) {
            raiseSoftException("getOrCreateReloadTask()", "Error during reload. ReactInstance task cancelled. Reload reason: " + str);
        }
        log("getOrCreateReloadTask()", "Resetting reload task ref");
        this.mReloadTask = null;
        return task;
    }

    private Task<Void> getOrCreateDestroyTask(String str, Exception exc) {
        log("getOrCreateDestroyTask()");
        raiseSoftException("getOrCreateDestroyTask()", str, exc);
        ReactInstanceTaskUnwrapper createReactInstanceUnwraper = createReactInstanceUnwraper("Destroy", "getOrCreateDestroyTask()", str);
        if (this.mDestroyTask == null) {
            this.mDestroyTask = this.mReactInstanceTaskRef.get().continueWithTask(new ReactHostImpl$$ExternalSyntheticLambda5(this, createReactInstanceUnwraper, str), this.mUIExecutor).continueWithTask(new ReactHostImpl$$ExternalSyntheticLambda6(this, createReactInstanceUnwraper), this.mBGExecutor).continueWithTask(new ReactHostImpl$$ExternalSyntheticLambda7(this, createReactInstanceUnwraper), this.mUIExecutor).continueWithTask(new ReactHostImpl$$ExternalSyntheticLambda8(this, createReactInstanceUnwraper, str), this.mUIExecutor).continueWithTask(new ReactHostImpl$$ExternalSyntheticLambda9(this, createReactInstanceUnwraper), this.mBGExecutor).continueWith(new ReactHostImpl$$ExternalSyntheticLambda10(this, str));
        }
        return this.mDestroyTask;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Task lambda$getOrCreateDestroyTask$39(ReactInstanceTaskUnwrapper reactInstanceTaskUnwrapper, String str, Task task) throws Exception {
        log("getOrCreateDestroyTask()", "Starting React Native destruction");
        ReactInstance unwrap = reactInstanceTaskUnwrapper.unwrap(task, "1: Starting destroy");
        if (this.mUseDevSupport) {
            log("getOrCreateDestroyTask()", "DevSupportManager cleanup");
            this.mDevSupportManager.stopInspector();
        }
        ReactContext nullable = this.mBridgelessReactContextRef.getNullable();
        if (nullable == null) {
            raiseSoftException("getOrCreateDestroyTask()", "ReactContext is null. Destroy reason: " + str);
        }
        log("getOrCreateDestroyTask()", "Move ReactHost to onHostDestroy()");
        this.mReactLifecycleStateManager.moveToOnHostDestroy(nullable);
        return Task.forResult(unwrap);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Task lambda$getOrCreateDestroyTask$40(ReactInstanceTaskUnwrapper reactInstanceTaskUnwrapper, Task task) throws Exception {
        ReactInstance unwrap = reactInstanceTaskUnwrapper.unwrap(task, "2: Stopping surfaces");
        if (unwrap == null) {
            raiseSoftException("getOrCreateDestroyTask()", "Skipping surface shutdown: ReactInstance null");
            return task;
        }
        stopAttachedSurfaces("getOrCreateDestroyTask()", unwrap);
        synchronized (this.mAttachedSurfaces) {
            this.mAttachedSurfaces.clear();
        }
        return task;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Task lambda$getOrCreateDestroyTask$41(ReactInstanceTaskUnwrapper reactInstanceTaskUnwrapper, Task task) throws Exception {
        HashSet<Function0> hashSet;
        reactInstanceTaskUnwrapper.unwrap(task, "3: Executing Before Destroy Listeners");
        synchronized (this.mBeforeDestroyListeners) {
            hashSet = new HashSet<>(this.mBeforeDestroyListeners);
        }
        for (Function0 invoke : hashSet) {
            invoke.invoke();
        }
        return task;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Task lambda$getOrCreateDestroyTask$42(ReactInstanceTaskUnwrapper reactInstanceTaskUnwrapper, String str, Task task) throws Exception {
        reactInstanceTaskUnwrapper.unwrap(task, "4: Destroying ReactContext");
        ReactContext nullable = this.mBridgelessReactContextRef.getNullable();
        if (nullable == null) {
            raiseSoftException("getOrCreateDestroyTask()", "ReactContext is null. Destroy reason: " + str);
        }
        log("getOrCreateDestroyTask()", "Destroying MemoryPressureRouter");
        this.mMemoryPressureRouter.destroy(this.mContext);
        if (nullable != null) {
            log("getOrCreateDestroyTask()", "Destroying ReactContext");
            nullable.destroy();
        }
        setCurrentActivity((Activity) null);
        ResourceDrawableIdHelper.getInstance().clear();
        return task;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Task lambda$getOrCreateDestroyTask$43(ReactInstanceTaskUnwrapper reactInstanceTaskUnwrapper, Task task) throws Exception {
        ReactInstance unwrap = reactInstanceTaskUnwrapper.unwrap(task, "5: Destroying ReactInstance");
        if (unwrap == null) {
            raiseSoftException("getOrCreateDestroyTask()", "Skipping ReactInstance.destroy(): ReactInstance null");
        } else {
            log("getOrCreateDestroyTask()", "Destroying ReactInstance");
            unwrap.destroy();
        }
        log("getOrCreateDestroyTask()", "Resetting ReactContext ref ");
        this.mBridgelessReactContextRef.reset();
        log("getOrCreateDestroyTask()", "Resetting ReactInstance task ref");
        this.mReactInstanceTaskRef.reset();
        log("getOrCreateDestroyTask()", "Resetting Preload task ref");
        this.mStartTask = null;
        log("getOrCreateDestroyTask()", "Resetting destroy task ref");
        this.mDestroyTask = null;
        return task;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Void lambda$getOrCreateDestroyTask$44(String str, Task task) throws Exception {
        if (task.isFaulted()) {
            Exception error = task.getError();
            raiseSoftException("getOrCreateDestroyTask()", "React destruction failed. ReactInstance task faulted. Fault reason: " + error.getMessage() + ". Destroy reason: " + str, task.getError());
        }
        if (!task.isCancelled()) {
            return null;
        }
        raiseSoftException("getOrCreateDestroyTask()", "React destruction failed. ReactInstance task cancelled. Destroy reason: " + str);
        return null;
    }
}
