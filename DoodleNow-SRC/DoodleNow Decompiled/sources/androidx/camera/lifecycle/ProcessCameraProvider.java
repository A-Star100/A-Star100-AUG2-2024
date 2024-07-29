package androidx.camera.lifecycle;

import android.content.Context;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraEffect;
import androidx.camera.core.CameraFilter;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraInfoUnavailableException;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraX;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.ConcurrentCamera;
import androidx.camera.core.UseCase;
import androidx.camera.core.UseCaseGroup;
import androidx.camera.core.ViewPort;
import androidx.camera.core.concurrent.CameraCoordinator;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraConfigProvider;
import androidx.camera.core.impl.CameraConfigs;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.ExtendedCameraConfigProviderStore;
import androidx.camera.core.impl.RestrictedCameraInfo;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LifecycleOwner;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 S2\u00020\u0001:\u0001SB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0007JQ\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\b\u00101\u001a\u0004\u0018\u0001022\u000e\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001040\u00042\u0016\u00105\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010706\"\u0004\u0018\u000107H\u0000¢\u0006\u0004\b8\u00109J5\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0016\u00105\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010706\"\u0004\u0018\u000107H\u0007¢\u0006\u0002\u0010:J\u0018\u0010)\u001a\u00020;2\u000e\u0010<\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010=0\u0004H\u0007J\u0010\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0002J\u000e\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u0018\u0010C\u001a\u00020D2\u0006\u0010-\u001a\u00020.2\u0006\u0010E\u001a\u00020\u0005H\u0002J\u0010\u0010F\u001a\u00020\u00052\u0006\u0010-\u001a\u00020.H\u0017J\u0016\u0010G\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001f2\u0006\u0010H\u001a\u00020$H\u0002J\u0010\u0010I\u001a\u00020\u00142\u0006\u0010-\u001a\u00020.H\u0016J\u0010\u0010J\u001a\u00020\u00142\u0006\u0010K\u001a\u000207H\u0016J\u0010\u0010L\u001a\u00020?2\u0006\u0010M\u001a\u00020\u001bH\u0002J\u0010\u0010N\u001a\u00020?2\u0006\u0010H\u001a\u00020$H\u0002J\u000e\u0010O\u001a\b\u0012\u0004\u0012\u00020!0\u001fH\u0007J%\u0010P\u001a\u00020?2\u0016\u00105\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010706\"\u0004\u0018\u000107H\u0017¢\u0006\u0002\u0010QJ\b\u0010R\u001a\u00020?H\u0017R0\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048B@BX\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00048F¢\u0006\u0006\u001a\u0004\b\f\u0010\bR$\u0010\r\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8B@BX\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148G¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u001c\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00178\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001f8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R \u0010 \u001a\u0010\u0012\f\u0012\n \"*\u0004\u0018\u00010!0!0\u001f8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0004¢\u0006\u0002\n\u0000¨\u0006T"}, d2 = {"Landroidx/camera/lifecycle/ProcessCameraProvider;", "Landroidx/camera/lifecycle/LifecycleCameraProvider;", "()V", "cameraInfos", "", "Landroidx/camera/core/CameraInfo;", "activeConcurrentCameraInfos", "getActiveConcurrentCameraInfos", "()Ljava/util/List;", "setActiveConcurrentCameraInfos", "(Ljava/util/List;)V", "availableConcurrentCameraInfos", "getAvailableConcurrentCameraInfos", "cameraOperatingMode", "", "getCameraOperatingMode", "()I", "setCameraOperatingMode", "(I)V", "isConcurrentCameraModeOn", "", "()Z", "mCameraInfoMap", "", "Landroidx/camera/core/internal/CameraUseCaseAdapter$CameraId;", "Landroidx/camera/core/impl/RestrictedCameraInfo;", "mCameraX", "Landroidx/camera/core/CameraX;", "mCameraXConfigProvider", "Landroidx/camera/core/CameraXConfig$Provider;", "mCameraXInitializeFuture", "Lcom/google/common/util/concurrent/ListenableFuture;", "mCameraXShutdownFuture", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "mContext", "Landroid/content/Context;", "mLifecycleCameraRepository", "Landroidx/camera/lifecycle/LifecycleCameraRepository;", "mLock", "", "bindToLifecycle", "Landroidx/camera/core/Camera;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "cameraSelector", "Landroidx/camera/core/CameraSelector;", "useCaseGroup", "Landroidx/camera/core/UseCaseGroup;", "viewPort", "Landroidx/camera/core/ViewPort;", "effects", "Landroidx/camera/core/CameraEffect;", "useCases", "", "Landroidx/camera/core/UseCase;", "bindToLifecycle$camera_lifecycle_release", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/camera/core/CameraSelector;Landroidx/camera/core/ViewPort;Ljava/util/List;[Landroidx/camera/core/UseCase;)Landroidx/camera/core/Camera;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/camera/core/CameraSelector;[Landroidx/camera/core/UseCase;)Landroidx/camera/core/Camera;", "Landroidx/camera/core/ConcurrentCamera;", "singleCameraConfigs", "Landroidx/camera/core/ConcurrentCamera$SingleCameraConfig;", "configureInstanceInternal", "", "cameraXConfig", "Landroidx/camera/core/CameraXConfig;", "getAvailableCameraInfos", "getCameraConfig", "Landroidx/camera/core/impl/CameraConfig;", "cameraInfo", "getCameraInfo", "getOrCreateCameraXInstance", "context", "hasCamera", "isBound", "useCase", "setCameraX", "cameraX", "setContext", "shutdownAsync", "unbind", "([Landroidx/camera/core/UseCase;)V", "unbindAll", "Companion", "camera-lifecycle_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ProcessCameraProvider.kt */
public final class ProcessCameraProvider implements LifecycleCameraProvider {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final ProcessCameraProvider sAppInstance = new ProcessCameraProvider();
    private final Map<CameraUseCaseAdapter.CameraId, RestrictedCameraInfo> mCameraInfoMap;
    private CameraX mCameraX;
    private CameraXConfig.Provider mCameraXConfigProvider;
    private ListenableFuture<CameraX> mCameraXInitializeFuture;
    private ListenableFuture<Void> mCameraXShutdownFuture;
    private Context mContext;
    private final LifecycleCameraRepository mLifecycleCameraRepository;
    private final Object mLock = new Object();

    @JvmStatic
    public static final void configureInstance(CameraXConfig cameraXConfig) {
        Companion.configureInstance(cameraXConfig);
    }

    /* access modifiers changed from: private */
    public static final CameraXConfig configureInstanceInternal$lambda$10$lambda$9(CameraXConfig cameraXConfig) {
        Intrinsics.checkNotNullParameter(cameraXConfig, "$cameraXConfig");
        return cameraXConfig;
    }

    @JvmStatic
    public static final ListenableFuture<ProcessCameraProvider> getInstance(Context context) {
        return Companion.getInstance(context);
    }

    /* access modifiers changed from: private */
    public final void setCameraX(CameraX cameraX) {
        this.mCameraX = cameraX;
    }

    /* access modifiers changed from: private */
    public final void setContext(Context context) {
        this.mContext = context;
    }

    private ProcessCameraProvider() {
        ListenableFuture<Void> immediateFuture = Futures.immediateFuture(null);
        Intrinsics.checkNotNullExpressionValue(immediateFuture, "immediateFuture<Void>(null)");
        this.mCameraXShutdownFuture = immediateFuture;
        this.mLifecycleCameraRepository = new LifecycleCameraRepository();
        this.mCameraInfoMap = new HashMap();
    }

    public final ListenableFuture<Void> shutdownAsync() {
        ListenableFuture<Void> listenableFuture;
        Threads.runOnMainSync(new ProcessCameraProvider$$ExternalSyntheticLambda1(this));
        CameraX cameraX = this.mCameraX;
        if (cameraX != null) {
            Intrinsics.checkNotNull(cameraX);
            cameraX.getCameraFactory().getCameraCoordinator().shutdown();
        }
        CameraX cameraX2 = this.mCameraX;
        if (cameraX2 != null) {
            Intrinsics.checkNotNull(cameraX2);
            listenableFuture = cameraX2.shutdown();
        } else {
            listenableFuture = Futures.immediateFuture(null);
        }
        Intrinsics.checkNotNullExpressionValue(listenableFuture, "if (mCameraX != null) mC…mediateFuture<Void>(null)");
        synchronized (this.mLock) {
            this.mCameraXConfigProvider = null;
            this.mCameraXInitializeFuture = null;
            this.mCameraXShutdownFuture = listenableFuture;
            this.mCameraInfoMap.clear();
            Unit unit = Unit.INSTANCE;
        }
        this.mCameraX = null;
        this.mContext = null;
        return listenableFuture;
    }

    /* access modifiers changed from: private */
    public static final void shutdownAsync$lambda$0(ProcessCameraProvider processCameraProvider) {
        Intrinsics.checkNotNullParameter(processCameraProvider, "this$0");
        processCameraProvider.unbindAll();
        processCameraProvider.mLifecycleCameraRepository.clear();
    }

    public final Camera bindToLifecycle(LifecycleOwner lifecycleOwner, CameraSelector cameraSelector, UseCase... useCaseArr) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(cameraSelector, "cameraSelector");
        Intrinsics.checkNotNullParameter(useCaseArr, "useCases");
        if (getCameraOperatingMode() != 2) {
            setCameraOperatingMode(1);
            return bindToLifecycle$camera_lifecycle_release(lifecycleOwner, cameraSelector, (ViewPort) null, CollectionsKt.emptyList(), (UseCase[]) Arrays.copyOf(useCaseArr, useCaseArr.length));
        }
        throw new UnsupportedOperationException("bindToLifecycle for single camera is not supported in concurrent camera mode, call unbindAll() first");
    }

    public final Camera bindToLifecycle(LifecycleOwner lifecycleOwner, CameraSelector cameraSelector, UseCaseGroup useCaseGroup) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(cameraSelector, "cameraSelector");
        Intrinsics.checkNotNullParameter(useCaseGroup, "useCaseGroup");
        if (getCameraOperatingMode() != 2) {
            setCameraOperatingMode(1);
            ViewPort viewPort = useCaseGroup.getViewPort();
            List<CameraEffect> effects = useCaseGroup.getEffects();
            Intrinsics.checkNotNullExpressionValue(effects, "useCaseGroup.effects");
            List<UseCase> useCases = useCaseGroup.getUseCases();
            Intrinsics.checkNotNullExpressionValue(useCases, "useCaseGroup.useCases");
            UseCase[] useCaseArr = (UseCase[]) useCases.toArray(new UseCase[0]);
            return bindToLifecycle$camera_lifecycle_release(lifecycleOwner, cameraSelector, viewPort, effects, (UseCase[]) Arrays.copyOf(useCaseArr, useCaseArr.length));
        }
        throw new UnsupportedOperationException("bindToLifecycle for single camera is not supported in concurrent camera mode, call unbindAll() first.");
    }

    public final ConcurrentCamera bindToLifecycle(List<ConcurrentCamera.SingleCameraConfig> list) {
        List<ConcurrentCamera.SingleCameraConfig> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "singleCameraConfigs");
        if (list.size() < 2) {
            throw new IllegalArgumentException("Concurrent camera needs two camera configs.");
        } else if (list.size() <= 2) {
            ConcurrentCamera.SingleCameraConfig singleCameraConfig = list2.get(0);
            Intrinsics.checkNotNull(singleCameraConfig);
            ConcurrentCamera.SingleCameraConfig singleCameraConfig2 = singleCameraConfig;
            ConcurrentCamera.SingleCameraConfig singleCameraConfig3 = list2.get(1);
            Intrinsics.checkNotNull(singleCameraConfig3);
            ConcurrentCamera.SingleCameraConfig singleCameraConfig4 = singleCameraConfig3;
            List arrayList = new ArrayList();
            if (!Intrinsics.areEqual((Object) singleCameraConfig2.getCameraSelector().getLensFacing(), (Object) singleCameraConfig4.getCameraSelector().getLensFacing())) {
                Context context = this.mContext;
                Intrinsics.checkNotNull(context);
                if (!context.getPackageManager().hasSystemFeature("android.hardware.camera.concurrent")) {
                    throw new UnsupportedOperationException("Concurrent camera is not supported on the device.");
                } else if (getCameraOperatingMode() != 1) {
                    List arrayList2 = new ArrayList();
                    try {
                        CameraSelector cameraSelector = singleCameraConfig2.getCameraSelector();
                        Intrinsics.checkNotNullExpressionValue(cameraSelector, "firstCameraConfig.cameraSelector");
                        CameraInfo cameraInfo = getCameraInfo(cameraSelector);
                        CameraSelector cameraSelector2 = singleCameraConfig4.getCameraSelector();
                        Intrinsics.checkNotNullExpressionValue(cameraSelector2, "secondCameraConfig.cameraSelector");
                        CameraInfo cameraInfo2 = getCameraInfo(cameraSelector2);
                        arrayList2.add(cameraInfo);
                        arrayList2.add(cameraInfo2);
                        if (!(!getActiveConcurrentCameraInfos().isEmpty()) || Intrinsics.areEqual((Object) arrayList2, (Object) getActiveConcurrentCameraInfos())) {
                            setCameraOperatingMode(2);
                            for (ConcurrentCamera.SingleCameraConfig next : list) {
                                Intrinsics.checkNotNull(next);
                                LifecycleOwner lifecycleOwner = next.getLifecycleOwner();
                                Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "config!!.lifecycleOwner");
                                CameraSelector cameraSelector3 = next.getCameraSelector();
                                Intrinsics.checkNotNullExpressionValue(cameraSelector3, "config.cameraSelector");
                                ViewPort viewPort = next.getUseCaseGroup().getViewPort();
                                List<CameraEffect> effects = next.getUseCaseGroup().getEffects();
                                Intrinsics.checkNotNullExpressionValue(effects, "config.useCaseGroup.effects");
                                List<UseCase> useCases = next.getUseCaseGroup().getUseCases();
                                Intrinsics.checkNotNullExpressionValue(useCases, "config.useCaseGroup.useCases");
                                UseCase[] useCaseArr = (UseCase[]) useCases.toArray(new UseCase[0]);
                                arrayList.add(bindToLifecycle$camera_lifecycle_release(lifecycleOwner, cameraSelector3, viewPort, effects, (UseCase[]) Arrays.copyOf(useCaseArr, useCaseArr.length)));
                            }
                            setActiveConcurrentCameraInfos(arrayList2);
                        } else {
                            throw new UnsupportedOperationException("Cameras are already running, call unbindAll() before binding more cameras.");
                        }
                    } catch (IllegalArgumentException unused) {
                        throw new IllegalArgumentException("Invalid camera selectors in camera configs.");
                    }
                } else {
                    throw new UnsupportedOperationException("Camera is already running, call unbindAll() before binding more cameras.");
                }
            } else if (getCameraOperatingMode() == 2) {
                throw new UnsupportedOperationException("Camera is already running, call unbindAll() before binding more cameras.");
            } else if (!Intrinsics.areEqual((Object) singleCameraConfig2.getLifecycleOwner(), (Object) singleCameraConfig4.getLifecycleOwner()) || !Intrinsics.areEqual((Object) singleCameraConfig2.getUseCaseGroup().getViewPort(), (Object) singleCameraConfig4.getUseCaseGroup().getViewPort()) || !Intrinsics.areEqual((Object) singleCameraConfig2.getUseCaseGroup().getEffects(), (Object) singleCameraConfig4.getUseCaseGroup().getEffects())) {
                throw new IllegalArgumentException("Two camera configs need to have the same lifecycle owner, view port and effects.");
            } else {
                LifecycleOwner lifecycleOwner2 = singleCameraConfig2.getLifecycleOwner();
                Intrinsics.checkNotNullExpressionValue(lifecycleOwner2, "firstCameraConfig.lifecycleOwner");
                CameraSelector cameraSelector4 = singleCameraConfig2.getCameraSelector();
                Intrinsics.checkNotNullExpressionValue(cameraSelector4, "firstCameraConfig.cameraSelector");
                ViewPort viewPort2 = singleCameraConfig2.getUseCaseGroup().getViewPort();
                List<CameraEffect> effects2 = singleCameraConfig2.getUseCaseGroup().getEffects();
                Intrinsics.checkNotNullExpressionValue(effects2, "firstCameraConfig.useCaseGroup.effects");
                List arrayList3 = new ArrayList();
                for (ConcurrentCamera.SingleCameraConfig next2 : list) {
                    Intrinsics.checkNotNull(next2);
                    for (UseCase next3 : next2.getUseCaseGroup().getUseCases()) {
                        Intrinsics.checkNotNullExpressionValue(next3, "config!!.useCaseGroup.useCases");
                        UseCase useCase = next3;
                        String physicalCameraId = next2.getCameraSelector().getPhysicalCameraId();
                        if (physicalCameraId != null) {
                            useCase.setPhysicalCameraId(physicalCameraId);
                        }
                    }
                    List<UseCase> useCases2 = next2.getUseCaseGroup().getUseCases();
                    Intrinsics.checkNotNullExpressionValue(useCases2, "config.useCaseGroup.useCases");
                    arrayList3.addAll(useCases2);
                }
                setCameraOperatingMode(1);
                UseCase[] useCaseArr2 = (UseCase[]) arrayList3.toArray(new UseCase[0]);
                arrayList.add(bindToLifecycle$camera_lifecycle_release(lifecycleOwner2, cameraSelector4, viewPort2, effects2, (UseCase[]) Arrays.copyOf(useCaseArr2, useCaseArr2.length)));
            }
            return new ConcurrentCamera(arrayList);
        } else {
            throw new IllegalArgumentException("Concurrent camera is only supporting two cameras at maximum.");
        }
    }

    public final Camera bindToLifecycle$camera_lifecycle_release(LifecycleOwner lifecycleOwner, CameraSelector cameraSelector, ViewPort viewPort, List<? extends CameraEffect> list, UseCase... useCaseArr) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(cameraSelector, "cameraSelector");
        Intrinsics.checkNotNullParameter(list, "effects");
        Intrinsics.checkNotNullParameter(useCaseArr, "useCases");
        Threads.checkMainThread();
        CameraX cameraX = this.mCameraX;
        Intrinsics.checkNotNull(cameraX);
        CameraInternal select = cameraSelector.select(cameraX.getCameraRepository().getCameras());
        Intrinsics.checkNotNullExpressionValue(select, "cameraSelector.select(mC…cameraRepository.cameras)");
        CameraInfo cameraInfo = getCameraInfo(cameraSelector);
        Intrinsics.checkNotNull(cameraInfo, "null cannot be cast to non-null type androidx.camera.core.impl.RestrictedCameraInfo");
        RestrictedCameraInfo restrictedCameraInfo = (RestrictedCameraInfo) cameraInfo;
        LifecycleCamera lifecycleCamera = this.mLifecycleCameraRepository.getLifecycleCamera(lifecycleOwner, CameraUseCaseAdapter.generateCameraId(restrictedCameraInfo));
        Collection<LifecycleCamera> lifecycleCameras = this.mLifecycleCameraRepository.getLifecycleCameras();
        for (UseCase useCase : ArraysKt.filterNotNull(useCaseArr)) {
            Iterator<LifecycleCamera> it = lifecycleCameras.iterator();
            while (true) {
                if (it.hasNext()) {
                    LifecycleCamera next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "lifecycleCameras");
                    LifecycleCamera lifecycleCamera2 = next;
                    if (lifecycleCamera2.isBound(useCase) && !Intrinsics.areEqual((Object) lifecycleCamera2, (Object) lifecycleCamera)) {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String format = String.format("Use case %s already bound to a different lifecycle.", Arrays.copyOf(new Object[]{useCase}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                        throw new IllegalStateException(format);
                    }
                }
            }
        }
        if (lifecycleCamera == null) {
            LifecycleCameraRepository lifecycleCameraRepository = this.mLifecycleCameraRepository;
            CameraX cameraX2 = this.mCameraX;
            Intrinsics.checkNotNull(cameraX2);
            CameraCoordinator cameraCoordinator = cameraX2.getCameraFactory().getCameraCoordinator();
            CameraX cameraX3 = this.mCameraX;
            Intrinsics.checkNotNull(cameraX3);
            CameraDeviceSurfaceManager cameraDeviceSurfaceManager = cameraX3.getCameraDeviceSurfaceManager();
            CameraX cameraX4 = this.mCameraX;
            Intrinsics.checkNotNull(cameraX4);
            lifecycleCamera = lifecycleCameraRepository.createLifecycleCamera(lifecycleOwner, new CameraUseCaseAdapter(select, restrictedCameraInfo, cameraCoordinator, cameraDeviceSurfaceManager, cameraX4.getDefaultConfigFactory()));
        }
        if (useCaseArr.length == 0) {
            Intrinsics.checkNotNull(lifecycleCamera);
            return lifecycleCamera;
        }
        LifecycleCameraRepository lifecycleCameraRepository2 = this.mLifecycleCameraRepository;
        Intrinsics.checkNotNull(lifecycleCamera);
        CameraX cameraX5 = this.mCameraX;
        Intrinsics.checkNotNull(cameraX5);
        lifecycleCameraRepository2.bindToLifecycleCamera(lifecycleCamera, viewPort, list, CollectionsKt.listOf(Arrays.copyOf(useCaseArr, useCaseArr.length)), cameraX5.getCameraFactory().getCameraCoordinator());
        return lifecycleCamera;
    }

    public boolean isBound(UseCase useCase) {
        Intrinsics.checkNotNullParameter(useCase, "useCase");
        for (LifecycleCamera next : this.mLifecycleCameraRepository.getLifecycleCameras()) {
            Intrinsics.checkNotNullExpressionValue(next, "mLifecycleCameraRepository.lifecycleCameras");
            if (next.isBound(useCase)) {
                return true;
            }
        }
        return false;
    }

    public void unbind(UseCase... useCaseArr) {
        Intrinsics.checkNotNullParameter(useCaseArr, "useCases");
        Threads.checkMainThread();
        if (getCameraOperatingMode() != 2) {
            this.mLifecycleCameraRepository.unbind(CollectionsKt.listOf(Arrays.copyOf(useCaseArr, useCaseArr.length)));
            return;
        }
        throw new UnsupportedOperationException("Unbind usecase is not supported in concurrent camera mode, call unbindAll() first.");
    }

    public void unbindAll() {
        Threads.checkMainThread();
        setCameraOperatingMode(0);
        this.mLifecycleCameraRepository.unbindAll();
    }

    public boolean hasCamera(CameraSelector cameraSelector) throws CameraInfoUnavailableException {
        Intrinsics.checkNotNullParameter(cameraSelector, "cameraSelector");
        try {
            CameraX cameraX = this.mCameraX;
            Intrinsics.checkNotNull(cameraX);
            cameraSelector.select(cameraX.getCameraRepository().getCameras());
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public List<CameraInfo> getAvailableCameraInfos() {
        List<CameraInfo> arrayList = new ArrayList<>();
        CameraX cameraX = this.mCameraX;
        Intrinsics.checkNotNull(cameraX);
        LinkedHashSet<CameraInternal> cameras = cameraX.getCameraRepository().getCameras();
        Intrinsics.checkNotNullExpressionValue(cameras, "mCameraX!!.cameraRepository.cameras");
        for (CameraInternal cameraInfo : cameras) {
            CameraInfo cameraInfo2 = cameraInfo.getCameraInfo();
            Intrinsics.checkNotNullExpressionValue(cameraInfo2, "camera.cameraInfo");
            arrayList.add(cameraInfo2);
        }
        return arrayList;
    }

    public final List<List<CameraInfo>> getAvailableConcurrentCameraInfos() {
        Objects.requireNonNull(this.mCameraX);
        CameraX cameraX = this.mCameraX;
        Intrinsics.checkNotNull(cameraX);
        Objects.requireNonNull(cameraX.getCameraFactory().getCameraCoordinator());
        CameraX cameraX2 = this.mCameraX;
        Intrinsics.checkNotNull(cameraX2);
        List<List<CameraSelector>> concurrentCameraSelectors = cameraX2.getCameraFactory().getCameraCoordinator().getConcurrentCameraSelectors();
        Intrinsics.checkNotNullExpressionValue(concurrentCameraSelectors, "mCameraX!!.cameraFactory…concurrentCameraSelectors");
        List<List<CameraInfo>> arrayList = new ArrayList<>();
        for (List<CameraSelector> it : concurrentCameraSelectors) {
            List arrayList2 = new ArrayList();
            for (CameraSelector cameraSelector : it) {
                try {
                    Intrinsics.checkNotNullExpressionValue(cameraSelector, "cameraSelector");
                    arrayList2.add(getCameraInfo(cameraSelector));
                } catch (IllegalArgumentException unused) {
                }
            }
            arrayList.add(arrayList2);
        }
        return arrayList;
    }

    public CameraInfo getCameraInfo(CameraSelector cameraSelector) {
        RestrictedCameraInfo restrictedCameraInfo;
        Intrinsics.checkNotNullParameter(cameraSelector, "cameraSelector");
        CameraX cameraX = this.mCameraX;
        Intrinsics.checkNotNull(cameraX);
        CameraInfoInternal cameraInfoInternal = cameraSelector.select(cameraX.getCameraRepository().getCameras()).getCameraInfoInternal();
        Intrinsics.checkNotNullExpressionValue(cameraInfoInternal, "cameraSelector.select(mC…meras).cameraInfoInternal");
        CameraConfig cameraConfig = getCameraConfig(cameraSelector, cameraInfoInternal);
        CameraUseCaseAdapter.CameraId create = CameraUseCaseAdapter.CameraId.create(cameraInfoInternal.getCameraId(), cameraConfig.getCompatibilityId());
        Intrinsics.checkNotNullExpressionValue(create, "create(\n                …atibilityId\n            )");
        synchronized (this.mLock) {
            restrictedCameraInfo = this.mCameraInfoMap.get(create);
            if (restrictedCameraInfo == null) {
                restrictedCameraInfo = new RestrictedCameraInfo(cameraInfoInternal, cameraConfig);
                this.mCameraInfoMap.put(create, restrictedCameraInfo);
            }
            Unit unit = Unit.INSTANCE;
        }
        return restrictedCameraInfo;
    }

    public final boolean isConcurrentCameraModeOn() {
        return getCameraOperatingMode() == 2;
    }

    /* access modifiers changed from: private */
    public final ListenableFuture<CameraX> getOrCreateCameraXInstance(Context context) {
        synchronized (this.mLock) {
            ListenableFuture<CameraX> listenableFuture = this.mCameraXInitializeFuture;
            if (listenableFuture != null) {
                Intrinsics.checkNotNull(listenableFuture, "null cannot be cast to non-null type com.google.common.util.concurrent.ListenableFuture<androidx.camera.core.CameraX>");
                return listenableFuture;
            }
            ListenableFuture<CameraX> future = CallbackToFutureAdapter.getFuture(new ProcessCameraProvider$$ExternalSyntheticLambda3(this, new CameraX(context, this.mCameraXConfigProvider)));
            this.mCameraXInitializeFuture = future;
            Intrinsics.checkNotNull(future, "null cannot be cast to non-null type com.google.common.util.concurrent.ListenableFuture<androidx.camera.core.CameraX>");
            return future;
        }
    }

    /* access modifiers changed from: private */
    public static final Object getOrCreateCameraXInstance$lambda$8$lambda$7(ProcessCameraProvider processCameraProvider, CameraX cameraX, CallbackToFutureAdapter.Completer completer) {
        Intrinsics.checkNotNullParameter(processCameraProvider, "this$0");
        Intrinsics.checkNotNullParameter(cameraX, "$cameraX");
        Intrinsics.checkNotNullParameter(completer, "completer");
        synchronized (processCameraProvider.mLock) {
            FutureChain<T> transformAsync = FutureChain.from(processCameraProvider.mCameraXShutdownFuture).transformAsync(new ProcessCameraProvider$$ExternalSyntheticLambda2(new ProcessCameraProvider$getOrCreateCameraXInstance$1$1$1$future$1(cameraX)), CameraXExecutors.directExecutor());
            Intrinsics.checkNotNullExpressionValue(transformAsync, "cameraX = CameraX(contex…                        )");
            Futures.addCallback(transformAsync, new ProcessCameraProvider$getOrCreateCameraXInstance$1$1$1$1(completer, cameraX), CameraXExecutors.directExecutor());
            Unit unit = Unit.INSTANCE;
        }
        return "ProcessCameraProvider-initializeCameraX";
    }

    /* access modifiers changed from: private */
    public static final ListenableFuture getOrCreateCameraXInstance$lambda$8$lambda$7$lambda$6$lambda$5(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        return (ListenableFuture) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void configureInstanceInternal(CameraXConfig cameraXConfig) {
        synchronized (this.mLock) {
            Preconditions.checkNotNull(cameraXConfig);
            Preconditions.checkState(this.mCameraXConfigProvider == null, "CameraX has already been configured. To use a different configuration, shutdown() must be called.");
            this.mCameraXConfigProvider = new ProcessCameraProvider$$ExternalSyntheticLambda0(cameraXConfig);
            Unit unit = Unit.INSTANCE;
        }
    }

    private final CameraConfig getCameraConfig(CameraSelector cameraSelector, CameraInfo cameraInfo) {
        Iterator it = cameraSelector.getCameraFilterSet().iterator();
        CameraConfig cameraConfig = null;
        while (it.hasNext()) {
            Object next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "cameraSelector.cameraFilterSet");
            CameraFilter cameraFilter = (CameraFilter) next;
            if (!Intrinsics.areEqual((Object) cameraFilter.getIdentifier(), (Object) CameraFilter.DEFAULT_ID)) {
                CameraConfigProvider configProvider = ExtendedCameraConfigProviderStore.getConfigProvider(cameraFilter.getIdentifier());
                Context context = this.mContext;
                Intrinsics.checkNotNull(context);
                CameraConfig config = configProvider.getConfig(cameraInfo, context);
                if (config == null) {
                    continue;
                } else if (cameraConfig == null) {
                    cameraConfig = config;
                } else {
                    throw new IllegalArgumentException("Cannot apply multiple extended camera configs at the same time.");
                }
            }
        }
        return cameraConfig == null ? CameraConfigs.defaultConfig() : cameraConfig;
    }

    private final int getCameraOperatingMode() {
        CameraX cameraX = this.mCameraX;
        if (cameraX == null) {
            return 0;
        }
        Intrinsics.checkNotNull(cameraX);
        return cameraX.getCameraFactory().getCameraCoordinator().getCameraOperatingMode();
    }

    private final void setCameraOperatingMode(int i) {
        CameraX cameraX = this.mCameraX;
        if (cameraX != null) {
            Intrinsics.checkNotNull(cameraX);
            cameraX.getCameraFactory().getCameraCoordinator().setCameraOperatingMode(i);
        }
    }

    private final List<CameraInfo> getActiveConcurrentCameraInfos() {
        CameraX cameraX = this.mCameraX;
        if (cameraX == null) {
            return new ArrayList<>();
        }
        Intrinsics.checkNotNull(cameraX);
        List<CameraInfo> activeConcurrentCameraInfos = cameraX.getCameraFactory().getCameraCoordinator().getActiveConcurrentCameraInfos();
        Intrinsics.checkNotNullExpressionValue(activeConcurrentCameraInfos, "mCameraX!!.cameraFactory…tiveConcurrentCameraInfos");
        return activeConcurrentCameraInfos;
    }

    private final void setActiveConcurrentCameraInfos(List<? extends CameraInfo> list) {
        CameraX cameraX = this.mCameraX;
        if (cameraX != null) {
            Intrinsics.checkNotNull(cameraX);
            cameraX.getCameraFactory().getCameraCoordinator().setActiveConcurrentCameraInfos(list);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/camera/lifecycle/ProcessCameraProvider$Companion;", "", "()V", "sAppInstance", "Landroidx/camera/lifecycle/ProcessCameraProvider;", "configureInstance", "", "cameraXConfig", "Landroidx/camera/core/CameraXConfig;", "getInstance", "Lcom/google/common/util/concurrent/ListenableFuture;", "context", "Landroid/content/Context;", "camera-lifecycle_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ProcessCameraProvider.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ListenableFuture<ProcessCameraProvider> getInstance(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Preconditions.checkNotNull(context);
            ListenableFuture<ProcessCameraProvider> transform = Futures.transform(ProcessCameraProvider.sAppInstance.getOrCreateCameraXInstance(context), new ProcessCameraProvider$Companion$$ExternalSyntheticLambda0(new ProcessCameraProvider$Companion$getInstance$1(context)), CameraXExecutors.directExecutor());
            Intrinsics.checkNotNullExpressionValue(transform, "context: Context): Liste…tExecutor()\n            )");
            return transform;
        }

        /* access modifiers changed from: private */
        public static final ProcessCameraProvider getInstance$lambda$0(Function1 function1, Object obj) {
            Intrinsics.checkNotNullParameter(function1, "$tmp0");
            return (ProcessCameraProvider) function1.invoke(obj);
        }

        @JvmStatic
        public final void configureInstance(CameraXConfig cameraXConfig) {
            Intrinsics.checkNotNullParameter(cameraXConfig, "cameraXConfig");
            ProcessCameraProvider.sAppInstance.configureInstanceInternal(cameraXConfig);
        }
    }
}
