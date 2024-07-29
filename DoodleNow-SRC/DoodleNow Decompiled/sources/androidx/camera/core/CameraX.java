package androidx.camera.core;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.SparseArray;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.RetryPolicy;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraFactory;
import androidx.camera.core.impl.CameraRepository;
import androidx.camera.core.impl.MetadataHolderService;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.ContextUtil;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.os.HandlerCompat;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Executor;

public final class CameraX {
    private static final Object MIN_LOG_LEVEL_LOCK = new Object();
    private static final String RETRY_TOKEN = "retry_token";
    private static final String TAG = "CameraX";
    private static final SparseArray<Integer> sMinLogLevelReferenceCountMap = new SparseArray<>();
    private final Executor mCameraExecutor;
    private CameraFactory mCameraFactory;
    final CameraRepository mCameraRepository = new CameraRepository();
    private final CameraXConfig mCameraXConfig;
    private UseCaseConfigFactory mDefaultConfigFactory;
    private final ListenableFuture<Void> mInitInternalFuture;
    private InternalInitState mInitState = InternalInitState.UNINITIALIZED;
    private final Object mInitializeLock = new Object();
    private final Integer mMinLogLevel;
    private RetryPolicy mRetryPolicy;
    private final Handler mSchedulerHandler;
    private final HandlerThread mSchedulerThread;
    private ListenableFuture<Void> mShutdownInternalFuture = Futures.immediateFuture(null);
    private CameraDeviceSurfaceManager mSurfaceManager;

    private enum InternalInitState {
        UNINITIALIZED,
        INITIALIZING,
        INITIALIZING_ERROR,
        INITIALIZED,
        SHUTDOWN
    }

    public CameraRepository getCameraRepository() {
        return this.mCameraRepository;
    }

    public ListenableFuture<Void> getInitializeFuture() {
        return this.mInitInternalFuture;
    }

    public CameraX(Context context, CameraXConfig.Provider provider) {
        if (provider != null) {
            this.mCameraXConfig = provider.getCameraXConfig();
        } else {
            CameraXConfig.Provider configProvider = getConfigProvider(context);
            if (configProvider != null) {
                this.mCameraXConfig = configProvider.getCameraXConfig();
            } else {
                throw new IllegalStateException("CameraX is not configured properly. The most likely cause is you did not include a default implementation in your build such as 'camera-camera2'.");
            }
        }
        Executor cameraExecutor = this.mCameraXConfig.getCameraExecutor((Executor) null);
        Handler schedulerHandler = this.mCameraXConfig.getSchedulerHandler((Handler) null);
        this.mCameraExecutor = cameraExecutor == null ? new CameraExecutor() : cameraExecutor;
        if (schedulerHandler == null) {
            HandlerThread handlerThread = new HandlerThread("CameraX-scheduler", 10);
            this.mSchedulerThread = handlerThread;
            handlerThread.start();
            this.mSchedulerHandler = HandlerCompat.createAsync(handlerThread.getLooper());
        } else {
            this.mSchedulerThread = null;
            this.mSchedulerHandler = schedulerHandler;
        }
        Integer num = (Integer) this.mCameraXConfig.retrieveOption(CameraXConfig.OPTION_MIN_LOGGING_LEVEL, (Object) null);
        this.mMinLogLevel = num;
        increaseMinLogLevelReference(num);
        this.mRetryPolicy = new RetryPolicy.Builder(this.mCameraXConfig.getCameraProviderInitRetryPolicy()).build();
        this.mInitInternalFuture = initInternal(context);
    }

    public CameraFactory getCameraFactory() {
        CameraFactory cameraFactory = this.mCameraFactory;
        if (cameraFactory != null) {
            return cameraFactory;
        }
        throw new IllegalStateException("CameraX not initialized yet.");
    }

    private static CameraXConfig.Provider getConfigProvider(Context context) {
        Application applicationFromContext = ContextUtil.getApplicationFromContext(context);
        if (applicationFromContext instanceof CameraXConfig.Provider) {
            return (CameraXConfig.Provider) applicationFromContext;
        }
        try {
            Context applicationContext = ContextUtil.getApplicationContext(context);
            ServiceInfo serviceInfo = applicationContext.getPackageManager().getServiceInfo(new ComponentName(applicationContext, MetadataHolderService.class), 640);
            String string = serviceInfo.metaData != null ? serviceInfo.metaData.getString("androidx.camera.core.impl.MetadataHolderService.DEFAULT_CONFIG_PROVIDER") : null;
            if (string != null) {
                return (CameraXConfig.Provider) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            }
            Logger.e(TAG, "No default CameraXConfig.Provider specified in meta-data. The most likely cause is you did not include a default implementation in your build such as 'camera-camera2'.");
            return null;
        } catch (PackageManager.NameNotFoundException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | NullPointerException | InvocationTargetException e) {
            Logger.e(TAG, "Failed to retrieve default CameraXConfig.Provider from meta-data", e);
            return null;
        }
    }

    public CameraDeviceSurfaceManager getCameraDeviceSurfaceManager() {
        CameraDeviceSurfaceManager cameraDeviceSurfaceManager = this.mSurfaceManager;
        if (cameraDeviceSurfaceManager != null) {
            return cameraDeviceSurfaceManager;
        }
        throw new IllegalStateException("CameraX not initialized yet.");
    }

    public UseCaseConfigFactory getDefaultConfigFactory() {
        UseCaseConfigFactory useCaseConfigFactory = this.mDefaultConfigFactory;
        if (useCaseConfigFactory != null) {
            return useCaseConfigFactory;
        }
        throw new IllegalStateException("CameraX not initialized yet.");
    }

    public ListenableFuture<Void> shutdown() {
        return shutdownInternal();
    }

    private ListenableFuture<Void> initInternal(Context context) {
        ListenableFuture<Void> future;
        synchronized (this.mInitializeLock) {
            Preconditions.checkState(this.mInitState == InternalInitState.UNINITIALIZED, "CameraX.initInternal() should only be called once per instance");
            this.mInitState = InternalInitState.INITIALIZING;
            future = CallbackToFutureAdapter.getFuture(new CameraX$$ExternalSyntheticLambda3(this, context));
        }
        return future;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$initInternal$0$androidx-camera-core-CameraX  reason: not valid java name */
    public /* synthetic */ Object m132lambda$initInternal$0$androidxcameracoreCameraX(Context context, CallbackToFutureAdapter.Completer completer) throws Exception {
        initAndRetryRecursively(this.mCameraExecutor, SystemClock.elapsedRealtime(), 1, context, completer);
        return "CameraX initInternal";
    }

    private void initAndRetryRecursively(Executor executor, long j, int i, Context context, CallbackToFutureAdapter.Completer<Void> completer) {
        executor.execute(new CameraX$$ExternalSyntheticLambda0(this, context, executor, completer, j, i));
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.Throwable] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: lambda$initAndRetryRecursively$2$androidx-camera-core-CameraX  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void m131lambda$initAndRetryRecursively$2$androidxcameracoreCameraX(android.content.Context r17, java.util.concurrent.Executor r18, androidx.concurrent.futures.CallbackToFutureAdapter.Completer r19, long r20, int r22) {
        /*
            r16 = this;
            r9 = r16
            r3 = r18
            r8 = r19
            r4 = r20
            r6 = r22
            android.content.Context r7 = androidx.camera.core.impl.utils.ContextUtil.getApplicationContext(r17)
            r1 = 0
            androidx.camera.core.CameraXConfig r0 = r9.mCameraXConfig     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
            androidx.camera.core.impl.CameraFactory$Provider r10 = r0.getCameraFactoryProvider(r1)     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
            if (r10 == 0) goto L_0x0095
            java.util.concurrent.Executor r0 = r9.mCameraExecutor     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
            android.os.Handler r2 = r9.mSchedulerHandler     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
            androidx.camera.core.impl.CameraThreadConfig r12 = androidx.camera.core.impl.CameraThreadConfig.create(r0, r2)     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
            androidx.camera.core.CameraXConfig r0 = r9.mCameraXConfig     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
            androidx.camera.core.CameraSelector r0 = r0.getAvailableCamerasLimiter(r1)     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
            androidx.camera.core.CameraXConfig r2 = r9.mCameraXConfig     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
            long r14 = r2.getCameraOpenRetryMaxTimeoutInMillisWhileResuming()     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
            r11 = r7
            r13 = r0
            androidx.camera.core.impl.CameraFactory r2 = r10.newInstance(r11, r12, r13, r14)     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
            r9.mCameraFactory = r2     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
            androidx.camera.core.CameraXConfig r2 = r9.mCameraXConfig     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
            androidx.camera.core.impl.CameraDeviceSurfaceManager$Provider r2 = r2.getDeviceSurfaceManagerProvider(r1)     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
            if (r2 == 0) goto L_0x0088
            androidx.camera.core.impl.CameraFactory r10 = r9.mCameraFactory     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
            java.lang.Object r10 = r10.getCameraManager()     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
            androidx.camera.core.impl.CameraFactory r11 = r9.mCameraFactory     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
            java.util.Set r11 = r11.getAvailableCameraIds()     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
            androidx.camera.core.impl.CameraDeviceSurfaceManager r2 = r2.newInstance(r7, r10, r11)     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
            r9.mSurfaceManager = r2     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
            androidx.camera.core.CameraXConfig r2 = r9.mCameraXConfig     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
            androidx.camera.core.impl.UseCaseConfigFactory$Provider r2 = r2.getUseCaseConfigFactoryProvider(r1)     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
            if (r2 == 0) goto L_0x007b
            androidx.camera.core.impl.UseCaseConfigFactory r2 = r2.newInstance(r7)     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
            r9.mDefaultConfigFactory = r2     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
            boolean r2 = r3 instanceof androidx.camera.core.CameraExecutor     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
            if (r2 == 0) goto L_0x0067
            r2 = r3
            androidx.camera.core.CameraExecutor r2 = (androidx.camera.core.CameraExecutor) r2     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
            androidx.camera.core.impl.CameraFactory r10 = r9.mCameraFactory     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
            r2.init(r10)     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
        L_0x0067:
            androidx.camera.core.impl.CameraRepository r2 = r9.mCameraRepository     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
            androidx.camera.core.impl.CameraFactory r10 = r9.mCameraFactory     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
            r2.init(r10)     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
            androidx.camera.core.impl.CameraRepository r2 = r9.mCameraRepository     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
            androidx.camera.core.impl.CameraValidator.validateCameras(r7, r2, r0)     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
            r16.setStateToInitialized()     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
            r8.set(r1)     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
            goto L_0x014a
        L_0x007b:
            androidx.camera.core.InitializationException r0 = new androidx.camera.core.InitializationException     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
            java.lang.String r10 = "Invalid app configuration provided. Missing UseCaseConfigFactory."
            r2.<init>(r10)     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
            r0.<init>((java.lang.Throwable) r2)     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
            throw r0     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
        L_0x0088:
            androidx.camera.core.InitializationException r0 = new androidx.camera.core.InitializationException     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
            java.lang.String r10 = "Invalid app configuration provided. Missing CameraDeviceSurfaceManager."
            r2.<init>(r10)     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
            r0.<init>((java.lang.Throwable) r2)     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
            throw r0     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
        L_0x0095:
            androidx.camera.core.InitializationException r0 = new androidx.camera.core.InitializationException     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
            java.lang.String r10 = "Invalid app configuration provided. Missing CameraFactory."
            r2.<init>(r10)     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
            r0.<init>((java.lang.Throwable) r2)     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
            throw r0     // Catch:{ CameraIdListIncorrectException -> 0x00a6, InitializationException -> 0x00a4, RuntimeException -> 0x00a2 }
        L_0x00a2:
            r0 = move-exception
            goto L_0x00a7
        L_0x00a4:
            r0 = move-exception
            goto L_0x00a7
        L_0x00a6:
            r0 = move-exception
        L_0x00a7:
            androidx.camera.core.RetryPolicy r2 = r9.mRetryPolicy
            androidx.camera.core.impl.CameraProviderExecutionState r10 = new androidx.camera.core.impl.CameraProviderExecutionState
            r10.<init>(r4, r6, r0)
            androidx.camera.core.RetryPolicy$RetryConfig r10 = r2.onRetryDecisionRequested(r10)
            boolean r2 = r10.shouldRetry()
            if (r2 == 0) goto L_0x00f8
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r6 >= r2) goto L_0x00f8
            java.lang.String r1 = "CameraX"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r11 = "Retry init. Start time "
            r2.<init>(r11)
            r2.append(r4)
            java.lang.String r11 = " current time "
            r2.append(r11)
            long r11 = android.os.SystemClock.elapsedRealtime()
            r2.append(r11)
            java.lang.String r2 = r2.toString()
            androidx.camera.core.Logger.w(r1, r2, r0)
            android.os.Handler r0 = r9.mSchedulerHandler
            androidx.camera.core.CameraX$$ExternalSyntheticLambda4 r11 = new androidx.camera.core.CameraX$$ExternalSyntheticLambda4
            r1 = r11
            r2 = r16
            r3 = r18
            r4 = r20
            r6 = r22
            r8 = r19
            r1.<init>(r2, r3, r4, r6, r7, r8)
            java.lang.String r1 = "retry_token"
            long r2 = r10.getRetryDelayInMillis()
            androidx.core.os.HandlerCompat.postDelayed(r0, r11, r1, r2)
            goto L_0x014a
        L_0x00f8:
            java.lang.Object r2 = r9.mInitializeLock
            monitor-enter(r2)
            androidx.camera.core.CameraX$InternalInitState r3 = androidx.camera.core.CameraX.InternalInitState.INITIALIZING_ERROR     // Catch:{ all -> 0x014b }
            r9.mInitState = r3     // Catch:{ all -> 0x014b }
            monitor-exit(r2)     // Catch:{ all -> 0x014b }
            boolean r2 = r10.shouldCompleteWithoutFailure()
            if (r2 == 0) goto L_0x010d
            r16.setStateToInitialized()
            r8.set(r1)
            goto L_0x014a
        L_0x010d:
            boolean r1 = r0 instanceof androidx.camera.core.impl.CameraValidator.CameraIdListIncorrectException
            if (r1 == 0) goto L_0x013a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Device reporting less cameras than anticipated. On real devices: Retrying initialization might resolve temporary camera errors. On emulators: Ensure virtual camera configuration matches supported camera features as reported by PackageManager#hasSystemFeature. Available cameras: "
            r1.<init>(r2)
            r2 = r0
            androidx.camera.core.impl.CameraValidator$CameraIdListIncorrectException r2 = (androidx.camera.core.impl.CameraValidator.CameraIdListIncorrectException) r2
            int r2 = r2.getAvailableCameraCount()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "CameraX"
            androidx.camera.core.Logger.e(r2, r1, r0)
            androidx.camera.core.InitializationException r0 = new androidx.camera.core.InitializationException
            androidx.camera.core.CameraUnavailableException r2 = new androidx.camera.core.CameraUnavailableException
            r3 = 3
            r2.<init>((int) r3, (java.lang.String) r1)
            r0.<init>((java.lang.Throwable) r2)
            r8.setException(r0)
            goto L_0x014a
        L_0x013a:
            boolean r1 = r0 instanceof androidx.camera.core.InitializationException
            if (r1 == 0) goto L_0x0142
            r8.setException(r0)
            goto L_0x014a
        L_0x0142:
            androidx.camera.core.InitializationException r1 = new androidx.camera.core.InitializationException
            r1.<init>((java.lang.Throwable) r0)
            r8.setException(r1)
        L_0x014a:
            return
        L_0x014b:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x014b }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.CameraX.m131lambda$initAndRetryRecursively$2$androidxcameracoreCameraX(android.content.Context, java.util.concurrent.Executor, androidx.concurrent.futures.CallbackToFutureAdapter$Completer, long, int):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$initAndRetryRecursively$1$androidx-camera-core-CameraX  reason: not valid java name */
    public /* synthetic */ void m130lambda$initAndRetryRecursively$1$androidxcameracoreCameraX(Executor executor, long j, int i, Context context, CallbackToFutureAdapter.Completer completer) {
        initAndRetryRecursively(executor, j, i + 1, context, completer);
    }

    private void setStateToInitialized() {
        synchronized (this.mInitializeLock) {
            this.mInitState = InternalInitState.INITIALIZED;
        }
    }

    private ListenableFuture<Void> shutdownInternal() {
        synchronized (this.mInitializeLock) {
            this.mSchedulerHandler.removeCallbacksAndMessages(RETRY_TOKEN);
            int ordinal = this.mInitState.ordinal();
            if (ordinal == 0) {
                this.mInitState = InternalInitState.SHUTDOWN;
                ListenableFuture<Void> immediateFuture = Futures.immediateFuture(null);
                return immediateFuture;
            } else if (ordinal != 1) {
                if (ordinal == 2 || ordinal == 3) {
                    this.mInitState = InternalInitState.SHUTDOWN;
                    decreaseMinLogLevelReference(this.mMinLogLevel);
                    this.mShutdownInternalFuture = CallbackToFutureAdapter.getFuture(new CameraX$$ExternalSyntheticLambda1(this));
                }
                ListenableFuture<Void> listenableFuture = this.mShutdownInternalFuture;
                return listenableFuture;
            } else {
                throw new IllegalStateException("CameraX could not be shutdown when it is initializing.");
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$shutdownInternal$4$androidx-camera-core-CameraX  reason: not valid java name */
    public /* synthetic */ Object m134lambda$shutdownInternal$4$androidxcameracoreCameraX(CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mCameraRepository.deinit().addListener(new CameraX$$ExternalSyntheticLambda2(this, completer), this.mCameraExecutor);
        return "CameraX shutdownInternal";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$shutdownInternal$3$androidx-camera-core-CameraX  reason: not valid java name */
    public /* synthetic */ void m133lambda$shutdownInternal$3$androidxcameracoreCameraX(CallbackToFutureAdapter.Completer completer) {
        if (this.mSchedulerThread != null) {
            Executor executor = this.mCameraExecutor;
            if (executor instanceof CameraExecutor) {
                ((CameraExecutor) executor).deinit();
            }
            this.mSchedulerThread.quit();
        }
        completer.set(null);
    }

    /* access modifiers changed from: package-private */
    public boolean isInitialized() {
        boolean z;
        synchronized (this.mInitializeLock) {
            z = this.mInitState == InternalInitState.INITIALIZED;
        }
        return z;
    }

    private static void increaseMinLogLevelReference(Integer num) {
        synchronized (MIN_LOG_LEVEL_LOCK) {
            if (num != null) {
                Preconditions.checkArgumentInRange(num.intValue(), 3, 6, "minLogLevel");
                SparseArray<Integer> sparseArray = sMinLogLevelReferenceCountMap;
                int i = 1;
                if (sparseArray.get(num.intValue()) != null) {
                    i = 1 + sparseArray.get(num.intValue()).intValue();
                }
                sparseArray.put(num.intValue(), Integer.valueOf(i));
                updateOrResetMinLogLevel();
            }
        }
    }

    private static void decreaseMinLogLevelReference(Integer num) {
        synchronized (MIN_LOG_LEVEL_LOCK) {
            if (num != null) {
                SparseArray<Integer> sparseArray = sMinLogLevelReferenceCountMap;
                int intValue = sparseArray.get(num.intValue()).intValue() - 1;
                if (intValue == 0) {
                    sparseArray.remove(num.intValue());
                } else {
                    sparseArray.put(num.intValue(), Integer.valueOf(intValue));
                }
                updateOrResetMinLogLevel();
            }
        }
    }

    private static void updateOrResetMinLogLevel() {
        SparseArray<Integer> sparseArray = sMinLogLevelReferenceCountMap;
        if (sparseArray.size() == 0) {
            Logger.resetMinLogLevel();
        } else if (sparseArray.get(3) != null) {
            Logger.setMinLogLevel(3);
        } else if (sparseArray.get(4) != null) {
            Logger.setMinLogLevel(4);
        } else if (sparseArray.get(5) != null) {
            Logger.setMinLogLevel(5);
        } else if (sparseArray.get(6) != null) {
            Logger.setMinLogLevel(6);
        }
    }
}
