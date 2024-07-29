package expo.modules.imagepicker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.tracing.Trace;
import expo.modules.core.errors.ModuleNotFoundException;
import expo.modules.core.interfaces.ActivityProvider;
import expo.modules.imagepicker.contracts.CameraContractOptions;
import expo.modules.imagepicker.contracts.CropImageContractOptions;
import expo.modules.imagepicker.contracts.ImageLibraryContractOptions;
import expo.modules.imagepicker.contracts.ImagePickerContractResult;
import expo.modules.interfaces.permissions.Permissions;
import expo.modules.interfaces.permissions.PermissionsResponseListener;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.UtilsKt;
import expo.modules.kotlin.activityresult.AppContextActivityResultLauncher;
import expo.modules.kotlin.functions.AsyncFunction;
import expo.modules.kotlin.functions.AsyncFunctionBuilder;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BaseAsyncFunctionComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.functions.SuspendFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.objects.ObjectDefinitionBuilder;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import java.io.File;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\"H\u0016J\u000e\u0010#\u001a\u00020$H@¢\u0006\u0002\u0010%J\u0010\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020(H\u0002J\u001b\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*2\u0006\u0010,\u001a\u00020\u0018H\u0002¢\u0006\u0002\u0010-J\u0018\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u00020\n2\u0006\u0010'\u001a\u00020(H\u0002J4\u00100\u001a\u0002012\u001c\u00102\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n04\u0012\u0006\u0012\u0004\u0018\u000101032\u0006\u0010'\u001a\u00020(H@¢\u0006\u0002\u00105J,\u00106\u001a\u0002072\u001c\u00102\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n04\u0012\u0006\u0012\u0004\u0018\u00010103H@¢\u0006\u0002\u00108R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX.¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n0\bX.¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\n0\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lexpo/modules/imagepicker/ImagePickerModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "cacheDirectory", "Ljava/io/File;", "getCacheDirectory", "()Ljava/io/File;", "cameraLauncher", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultLauncher;", "Lexpo/modules/imagepicker/contracts/CameraContractOptions;", "Lexpo/modules/imagepicker/contracts/ImagePickerContractResult;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "cropImageLauncher", "Lexpo/modules/imagepicker/contracts/CropImageContractOptions;", "currentActivity", "Landroid/app/Activity;", "getCurrentActivity", "()Landroid/app/Activity;", "imageLibraryLauncher", "Lexpo/modules/imagepicker/contracts/ImageLibraryContractOptions;", "isPickerOpen", "", "mediaHandler", "Lexpo/modules/imagepicker/MediaHandler;", "pendingMediaPickingResult", "Lexpo/modules/imagepicker/PendingMediaPickingResult;", "createPermissionsDecorator", "Lexpo/modules/interfaces/permissions/PermissionsResponseListener;", "promise", "Lexpo/modules/kotlin/Promise;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "ensureCameraPermissionsAreGranted", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureTargetActivityIsAvailable", "options", "Lexpo/modules/imagepicker/ImagePickerOptions;", "getMediaLibraryPermissions", "", "", "writeOnly", "(Z)[Ljava/lang/String;", "handleResultUponActivityDestruction", "result", "launchContract", "", "pickerLauncher", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function1;Lexpo/modules/imagepicker/ImagePickerOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "launchPicker", "Lexpo/modules/imagepicker/contracts/ImagePickerContractResult$Success;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-image-picker_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ImagePickerModule.kt */
public final class ImagePickerModule extends Module {
    /* access modifiers changed from: private */
    public AppContextActivityResultLauncher<CameraContractOptions, ImagePickerContractResult> cameraLauncher;
    /* access modifiers changed from: private */
    public AppContextActivityResultLauncher<CropImageContractOptions, ImagePickerContractResult> cropImageLauncher;
    /* access modifiers changed from: private */
    public AppContextActivityResultLauncher<ImageLibraryContractOptions, ImagePickerContractResult> imageLibraryLauncher;
    private boolean isPickerOpen;
    /* access modifiers changed from: private */
    public final MediaHandler mediaHandler = new MediaHandler(this);
    /* access modifiers changed from: private */
    public PendingMediaPickingResult pendingMediaPickingResult;

    public ModuleDefinitionData definition() {
        AsyncFunction asyncFunction;
        AsyncFunction asyncFunction2;
        AsyncFunction asyncFunctionComponent;
        AsyncFunction asyncFunctionComponent2;
        Module module = this;
        Trace.beginSection("[ExpoModulesCore] " + (module.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(module);
            moduleDefinitionBuilder.Name(ImagePickerConstants.TAG);
            Class<Boolean> cls = Boolean.class;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("requestMediaLibraryPermissionsAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, ImagePickerModule$definition$lambda$7$$inlined$AsyncFunctionWithPromise$1.INSTANCE))}, new ImagePickerModule$definition$lambda$7$$inlined$AsyncFunctionWithPromise$2(this));
            moduleDefinitionBuilder.getAsyncFunctions().put("requestMediaLibraryPermissionsAsync", asyncFunctionWithPromiseComponent);
            AsyncFunction asyncFunction3 = asyncFunctionWithPromiseComponent;
            Class<Boolean> cls2 = Boolean.class;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2 = new AsyncFunctionWithPromiseComponent("getMediaLibraryPermissionsAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, ImagePickerModule$definition$lambda$7$$inlined$AsyncFunctionWithPromise$3.INSTANCE))}, new ImagePickerModule$definition$lambda$7$$inlined$AsyncFunctionWithPromise$4(this));
            moduleDefinitionBuilder.getAsyncFunctions().put("getMediaLibraryPermissionsAsync", asyncFunctionWithPromiseComponent2);
            AsyncFunction asyncFunction4 = asyncFunctionWithPromiseComponent2;
            ObjectDefinitionBuilder objectDefinitionBuilder = moduleDefinitionBuilder;
            if (Intrinsics.areEqual((Object) Promise.class, (Object) Promise.class)) {
                asyncFunction = new AsyncFunctionWithPromiseComponent("requestCameraPermissionsAsync", new AnyType[0], new ImagePickerModule$definition$lambda$7$$inlined$AsyncFunction$1(this));
            } else {
                Class<Promise> cls3 = Promise.class;
                AnyType[] anyTypeArr = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, ImagePickerModule$definition$lambda$7$$inlined$AsyncFunction$2.INSTANCE))};
                Function1 imagePickerModule$definition$lambda$7$$inlined$AsyncFunction$3 = new ImagePickerModule$definition$lambda$7$$inlined$AsyncFunction$3(this);
                Class<Unit> cls4 = Unit.class;
                if (Intrinsics.areEqual((Object) cls4, (Object) Integer.TYPE)) {
                    asyncFunctionComponent2 = new IntAsyncFunctionComponent("requestCameraPermissionsAsync", anyTypeArr, imagePickerModule$definition$lambda$7$$inlined$AsyncFunction$3);
                } else if (Intrinsics.areEqual((Object) cls4, (Object) Boolean.TYPE)) {
                    asyncFunctionComponent2 = new BoolAsyncFunctionComponent("requestCameraPermissionsAsync", anyTypeArr, imagePickerModule$definition$lambda$7$$inlined$AsyncFunction$3);
                } else if (Intrinsics.areEqual((Object) cls4, (Object) Double.TYPE)) {
                    asyncFunctionComponent2 = new DoubleAsyncFunctionComponent("requestCameraPermissionsAsync", anyTypeArr, imagePickerModule$definition$lambda$7$$inlined$AsyncFunction$3);
                } else if (Intrinsics.areEqual((Object) cls4, (Object) Float.TYPE)) {
                    asyncFunctionComponent2 = new FloatAsyncFunctionComponent("requestCameraPermissionsAsync", anyTypeArr, imagePickerModule$definition$lambda$7$$inlined$AsyncFunction$3);
                } else if (Intrinsics.areEqual((Object) cls4, (Object) String.class)) {
                    asyncFunctionComponent2 = new StringAsyncFunctionComponent("requestCameraPermissionsAsync", anyTypeArr, imagePickerModule$definition$lambda$7$$inlined$AsyncFunction$3);
                } else {
                    asyncFunctionComponent2 = new AsyncFunctionComponent("requestCameraPermissionsAsync", anyTypeArr, imagePickerModule$definition$lambda$7$$inlined$AsyncFunction$3);
                }
                asyncFunction = asyncFunctionComponent2;
            }
            objectDefinitionBuilder.getAsyncFunctions().put("requestCameraPermissionsAsync", asyncFunction);
            ObjectDefinitionBuilder objectDefinitionBuilder2 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual((Object) Promise.class, (Object) Promise.class)) {
                asyncFunction2 = new AsyncFunctionWithPromiseComponent("getCameraPermissionsAsync", new AnyType[0], new ImagePickerModule$definition$lambda$7$$inlined$AsyncFunction$4(this));
            } else {
                Class<Promise> cls5 = Promise.class;
                AnyType[] anyTypeArr2 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, ImagePickerModule$definition$lambda$7$$inlined$AsyncFunction$5.INSTANCE))};
                Function1 imagePickerModule$definition$lambda$7$$inlined$AsyncFunction$6 = new ImagePickerModule$definition$lambda$7$$inlined$AsyncFunction$6(this);
                Class<Unit> cls6 = Unit.class;
                if (Intrinsics.areEqual((Object) cls6, (Object) Integer.TYPE)) {
                    asyncFunctionComponent = new IntAsyncFunctionComponent("getCameraPermissionsAsync", anyTypeArr2, imagePickerModule$definition$lambda$7$$inlined$AsyncFunction$6);
                } else if (Intrinsics.areEqual((Object) cls6, (Object) Boolean.TYPE)) {
                    asyncFunctionComponent = new BoolAsyncFunctionComponent("getCameraPermissionsAsync", anyTypeArr2, imagePickerModule$definition$lambda$7$$inlined$AsyncFunction$6);
                } else if (Intrinsics.areEqual((Object) cls6, (Object) Double.TYPE)) {
                    asyncFunctionComponent = new DoubleAsyncFunctionComponent("getCameraPermissionsAsync", anyTypeArr2, imagePickerModule$definition$lambda$7$$inlined$AsyncFunction$6);
                } else if (Intrinsics.areEqual((Object) cls6, (Object) Float.TYPE)) {
                    asyncFunctionComponent = new FloatAsyncFunctionComponent("getCameraPermissionsAsync", anyTypeArr2, imagePickerModule$definition$lambda$7$$inlined$AsyncFunction$6);
                } else if (Intrinsics.areEqual((Object) cls6, (Object) String.class)) {
                    asyncFunctionComponent = new StringAsyncFunctionComponent("getCameraPermissionsAsync", anyTypeArr2, imagePickerModule$definition$lambda$7$$inlined$AsyncFunction$6);
                } else {
                    asyncFunctionComponent = new AsyncFunctionComponent("getCameraPermissionsAsync", anyTypeArr2, imagePickerModule$definition$lambda$7$$inlined$AsyncFunction$6);
                }
                asyncFunction2 = asyncFunctionComponent;
            }
            objectDefinitionBuilder2.getAsyncFunctions().put("getCameraPermissionsAsync", asyncFunction2);
            AsyncFunctionBuilder AsyncFunction = moduleDefinitionBuilder.AsyncFunction("launchCameraAsync");
            Class<ImagePickerOptions> cls7 = ImagePickerOptions.class;
            AsyncFunction.setAsyncFunctionComponent(new SuspendFunctionComponent(AsyncFunction.getName(), new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ImagePickerOptions.class), false, ImagePickerModule$definition$lambda$7$$inlined$Coroutine$1.INSTANCE))}, new ImagePickerModule$definition$lambda$7$$inlined$Coroutine$2((Continuation) null, this)));
            AsyncFunctionBuilder AsyncFunction2 = moduleDefinitionBuilder.AsyncFunction("launchImageLibraryAsync");
            Class<ImagePickerOptions> cls8 = ImagePickerOptions.class;
            AsyncFunction2.setAsyncFunctionComponent(new SuspendFunctionComponent(AsyncFunction2.getName(), new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ImagePickerOptions.class), false, ImagePickerModule$definition$lambda$7$$inlined$Coroutine$3.INSTANCE))}, new ImagePickerModule$definition$lambda$7$$inlined$Coroutine$4((Continuation) null, this)));
            AsyncFunctionBuilder AsyncFunction3 = moduleDefinitionBuilder.AsyncFunction("getPendingResultAsync");
            SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(AsyncFunction3.getName(), new AnyType[0], new ImagePickerModule$definition$lambda$7$$inlined$Coroutine$5((Continuation) null, this));
            AsyncFunction3.setAsyncFunctionComponent(suspendFunctionComponent);
            BaseAsyncFunctionComponent baseAsyncFunctionComponent = suspendFunctionComponent;
            moduleDefinitionBuilder.RegisterActivityContracts(new ImagePickerModule$definition$1$8(this, (Continuation<? super ImagePickerModule$definition$1$8>) null));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    public final Context getContext() {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new IllegalArgumentException("React Application Context is null".toString());
    }

    private final Activity getCurrentActivity() {
        ActivityProvider activityProvider = getAppContext().getActivityProvider();
        Activity currentActivity = activityProvider != null ? activityProvider.getCurrentActivity() : null;
        if (currentActivity != null) {
            return currentActivity;
        }
        throw new MissingCurrentActivityException();
    }

    /* access modifiers changed from: private */
    public final File getCacheDirectory() {
        return getAppContext().getCacheDirectory();
    }

    /* access modifiers changed from: private */
    public final PermissionsResponseListener createPermissionsDecorator(Promise promise) {
        return new ImagePickerModule$$ExternalSyntheticLambda0(promise, UtilsKt.weak(getAppContext().getReactContext()), this);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0073 A[EDGE_INSN: B:55:0x0073->B:19:0x0073 ?: BREAK  ] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00dc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void createPermissionsDecorator$lambda$14(expo.modules.kotlin.Promise r7, java.lang.ref.WeakReference r8, expo.modules.imagepicker.ImagePickerModule r9, java.util.Map r10) {
        /*
            java.lang.String r0 = "$promise"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "$weakContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            boolean r9 = r10.isEmpty()
            r0 = 0
            r1 = 1
            if (r9 == 0) goto L_0x001c
        L_0x001a:
            r9 = r1
            goto L_0x0040
        L_0x001c:
            java.util.Set r9 = r10.entrySet()
            java.util.Iterator r9 = r9.iterator()
        L_0x0024:
            boolean r2 = r9.hasNext()
            if (r2 == 0) goto L_0x001a
            java.lang.Object r2 = r9.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r2 = r2.getValue()
            expo.modules.interfaces.permissions.PermissionsResponse r2 = (expo.modules.interfaces.permissions.PermissionsResponse) r2
            expo.modules.interfaces.permissions.PermissionsStatus r2 = r2.getStatus()
            expo.modules.interfaces.permissions.PermissionsStatus r3 = expo.modules.interfaces.permissions.PermissionsStatus.GRANTED
            if (r2 != r3) goto L_0x003f
            goto L_0x0024
        L_0x003f:
            r9 = r0
        L_0x0040:
            boolean r2 = r10.isEmpty()
            r2 = r2 ^ r1
            if (r2 == 0) goto L_0x0073
            boolean r2 = r10.isEmpty()
            if (r2 == 0) goto L_0x004e
            goto L_0x0071
        L_0x004e:
            java.util.Set r2 = r10.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0056:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0071
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r3 = r3.getValue()
            expo.modules.interfaces.permissions.PermissionsResponse r3 = (expo.modules.interfaces.permissions.PermissionsResponse) r3
            expo.modules.interfaces.permissions.PermissionsStatus r3 = r3.getStatus()
            expo.modules.interfaces.permissions.PermissionsStatus r4 = expo.modules.interfaces.permissions.PermissionsStatus.DENIED
            if (r3 != r4) goto L_0x0073
            goto L_0x0056
        L_0x0071:
            r2 = r1
            goto L_0x0074
        L_0x0073:
            r2 = r0
        L_0x0074:
            boolean r3 = r10.isEmpty()
            if (r3 == 0) goto L_0x007c
        L_0x007a:
            r0 = r1
            goto L_0x009c
        L_0x007c:
            java.util.Set r10 = r10.entrySet()
            java.util.Iterator r10 = r10.iterator()
        L_0x0084:
            boolean r3 = r10.hasNext()
            if (r3 == 0) goto L_0x007a
            java.lang.Object r3 = r10.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r3 = r3.getValue()
            expo.modules.interfaces.permissions.PermissionsResponse r3 = (expo.modules.interfaces.permissions.PermissionsResponse) r3
            boolean r3 = r3.getCanAskAgain()
            if (r3 != 0) goto L_0x0084
        L_0x009c:
            android.os.Bundle r10 = new android.os.Bundle
            r10.<init>()
            java.lang.String r3 = "expires"
            java.lang.String r4 = "never"
            r10.putString(r3, r4)
            if (r9 == 0) goto L_0x00b1
            expo.modules.interfaces.permissions.PermissionsStatus r2 = expo.modules.interfaces.permissions.PermissionsStatus.GRANTED
            java.lang.String r2 = r2.getStatus()
            goto L_0x00c0
        L_0x00b1:
            if (r2 == 0) goto L_0x00ba
            expo.modules.interfaces.permissions.PermissionsStatus r2 = expo.modules.interfaces.permissions.PermissionsStatus.DENIED
            java.lang.String r2 = r2.getStatus()
            goto L_0x00c0
        L_0x00ba:
            expo.modules.interfaces.permissions.PermissionsStatus r2 = expo.modules.interfaces.permissions.PermissionsStatus.UNDETERMINED
            java.lang.String r2 = r2.getStatus()
        L_0x00c0:
            java.lang.String r3 = "status"
            r10.putString(r3, r2)
            java.lang.String r2 = "canAskAgain"
            r10.putBoolean(r2, r0)
            java.lang.String r0 = "granted"
            r10.putBoolean(r0, r9)
            java.lang.String r4 = "accessPrivileges"
            if (r9 == 0) goto L_0x00dc
            java.lang.String r8 = "all"
            r10.putString(r4, r8)
            r7.resolve((java.lang.Object) r10)
            return
        L_0x00dc:
            int r9 = android.os.Build.VERSION.SDK_INT
            r5 = 34
            java.lang.String r6 = "none"
            if (r9 >= r5) goto L_0x00eb
            r10.putString(r4, r6)
            r7.resolve((java.lang.Object) r10)
            return
        L_0x00eb:
            java.lang.Object r8 = r8.get()
            android.content.Context r8 = (android.content.Context) r8
            if (r8 != 0) goto L_0x00fe
            expo.modules.kotlin.exception.Exceptions$ReactContextLost r8 = new expo.modules.kotlin.exception.Exceptions$ReactContextLost
            r8.<init>()
            expo.modules.kotlin.exception.CodedException r8 = (expo.modules.kotlin.exception.CodedException) r8
            r7.reject(r8)
            return
        L_0x00fe:
            java.lang.String r9 = "android.permission.READ_MEDIA_VISUAL_USER_SELECTED"
            int r8 = androidx.core.content.ContextCompat.checkSelfPermission(r8, r9)
            if (r8 != 0) goto L_0x011b
            r10.putBoolean(r0, r1)
            r10.putBoolean(r2, r1)
            expo.modules.interfaces.permissions.PermissionsStatus r8 = expo.modules.interfaces.permissions.PermissionsStatus.GRANTED
            java.lang.String r8 = r8.getStatus()
            r10.putString(r3, r8)
            java.lang.String r8 = "limited"
            r10.putString(r4, r8)
            goto L_0x011e
        L_0x011b:
            r10.putString(r4, r6)
        L_0x011e:
            r7.resolve((java.lang.Object) r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.imagepicker.ImagePickerModule.createPermissionsDecorator$lambda$14(expo.modules.kotlin.Promise, java.lang.ref.WeakReference, expo.modules.imagepicker.ImagePickerModule, java.util.Map):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:11|12|13|65|66|67|68) */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0037, code lost:
        r11 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x0110 */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e7 A[Catch:{ OperationCanceledException -> 0x006f, all -> 0x006b }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00e8 A[Catch:{ OperationCanceledException -> 0x006f, all -> 0x006b }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0106 A[Catch:{ OperationCanceledException -> 0x0110 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object launchContract(kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super expo.modules.imagepicker.contracts.ImagePickerContractResult>, ? extends java.lang.Object> r10, expo.modules.imagepicker.ImagePickerOptions r11, kotlin.coroutines.Continuation<java.lang.Object> r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof expo.modules.imagepicker.ImagePickerModule$launchContract$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            expo.modules.imagepicker.ImagePickerModule$launchContract$1 r0 = (expo.modules.imagepicker.ImagePickerModule$launchContract$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            expo.modules.imagepicker.ImagePickerModule$launchContract$1 r0 = new expo.modules.imagepicker.ImagePickerModule$launchContract$1
            r0.<init>(r9, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 0
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L_0x0072
            if (r2 == r6) goto L_0x0057
            if (r2 == r4) goto L_0x0042
            if (r2 != r3) goto L_0x003a
            java.lang.Object r10 = r0.L$0
            expo.modules.imagepicker.ImagePickerModule r10 = (expo.modules.imagepicker.ImagePickerModule) r10
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ OperationCanceledException -> 0x0110 }
            goto L_0x0107
        L_0x0037:
            r11 = move-exception
            goto L_0x0118
        L_0x003a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0042:
            java.lang.Object r10 = r0.L$3
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r11 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r11 = (kotlin.jvm.internal.Ref.ObjectRef) r11
            java.lang.Object r2 = r0.L$1
            expo.modules.imagepicker.ImagePickerOptions r2 = (expo.modules.imagepicker.ImagePickerOptions) r2
            java.lang.Object r8 = r0.L$0
            expo.modules.imagepicker.ImagePickerModule r8 = (expo.modules.imagepicker.ImagePickerModule) r8
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ OperationCanceledException -> 0x006f, all -> 0x006b }
            goto L_0x00e9
        L_0x0057:
            java.lang.Object r10 = r0.L$3
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r11 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r11 = (kotlin.jvm.internal.Ref.ObjectRef) r11
            java.lang.Object r2 = r0.L$1
            expo.modules.imagepicker.ImagePickerOptions r2 = (expo.modules.imagepicker.ImagePickerOptions) r2
            java.lang.Object r8 = r0.L$0
            expo.modules.imagepicker.ImagePickerModule r8 = (expo.modules.imagepicker.ImagePickerModule) r8
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ OperationCanceledException -> 0x006f, all -> 0x006b }
            goto L_0x009e
        L_0x006b:
            r11 = move-exception
            r10 = r8
            goto L_0x0118
        L_0x006f:
            r10 = r8
            goto L_0x0110
        L_0x0072:
            kotlin.ResultKt.throwOnFailure(r12)
            boolean r12 = r9.isPickerOpen     // Catch:{ OperationCanceledException -> 0x010f, all -> 0x010c }
            if (r12 == 0) goto L_0x0081
            expo.modules.imagepicker.ImagePickerResponse r10 = new expo.modules.imagepicker.ImagePickerResponse     // Catch:{ OperationCanceledException -> 0x010f, all -> 0x010c }
            r10.<init>(r6, r7, r4, r7)     // Catch:{ OperationCanceledException -> 0x010f, all -> 0x010c }
            r9.isPickerOpen = r5
            return r10
        L_0x0081:
            r9.isPickerOpen = r6     // Catch:{ OperationCanceledException -> 0x010f, all -> 0x010c }
            kotlin.jvm.internal.Ref$ObjectRef r12 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ OperationCanceledException -> 0x010f, all -> 0x010c }
            r12.<init>()     // Catch:{ OperationCanceledException -> 0x010f, all -> 0x010c }
            r0.L$0 = r9     // Catch:{ OperationCanceledException -> 0x010f, all -> 0x010c }
            r0.L$1 = r11     // Catch:{ OperationCanceledException -> 0x010f, all -> 0x010c }
            r0.L$2 = r12     // Catch:{ OperationCanceledException -> 0x010f, all -> 0x010c }
            r0.L$3 = r12     // Catch:{ OperationCanceledException -> 0x010f, all -> 0x010c }
            r0.label = r6     // Catch:{ OperationCanceledException -> 0x010f, all -> 0x010c }
            java.lang.Object r10 = r9.launchPicker(r10, r0)     // Catch:{ OperationCanceledException -> 0x010f, all -> 0x010c }
            if (r10 != r1) goto L_0x0099
            return r1
        L_0x0099:
            r8 = r9
            r2 = r11
            r11 = r12
            r12 = r10
            r10 = r11
        L_0x009e:
            r10.element = r12     // Catch:{ OperationCanceledException -> 0x006f, all -> 0x006b }
            boolean r10 = r2.getAllowsMultipleSelection()     // Catch:{ OperationCanceledException -> 0x006f, all -> 0x006b }
            if (r10 != 0) goto L_0x00eb
            boolean r10 = r2.getAllowsEditing()     // Catch:{ OperationCanceledException -> 0x006f, all -> 0x006b }
            if (r10 == 0) goto L_0x00eb
            T r10 = r11.element     // Catch:{ OperationCanceledException -> 0x006f, all -> 0x006b }
            expo.modules.imagepicker.contracts.ImagePickerContractResult$Success r10 = (expo.modules.imagepicker.contracts.ImagePickerContractResult.Success) r10     // Catch:{ OperationCanceledException -> 0x006f, all -> 0x006b }
            java.util.List r10 = r10.getData()     // Catch:{ OperationCanceledException -> 0x006f, all -> 0x006b }
            int r10 = r10.size()     // Catch:{ OperationCanceledException -> 0x006f, all -> 0x006b }
            if (r10 != r6) goto L_0x00eb
            T r10 = r11.element     // Catch:{ OperationCanceledException -> 0x006f, all -> 0x006b }
            expo.modules.imagepicker.contracts.ImagePickerContractResult$Success r10 = (expo.modules.imagepicker.contracts.ImagePickerContractResult.Success) r10     // Catch:{ OperationCanceledException -> 0x006f, all -> 0x006b }
            java.util.List r10 = r10.getData()     // Catch:{ OperationCanceledException -> 0x006f, all -> 0x006b }
            java.lang.Object r10 = r10.get(r5)     // Catch:{ OperationCanceledException -> 0x006f, all -> 0x006b }
            kotlin.Pair r10 = (kotlin.Pair) r10     // Catch:{ OperationCanceledException -> 0x006f, all -> 0x006b }
            java.lang.Object r10 = r10.getFirst()     // Catch:{ OperationCanceledException -> 0x006f, all -> 0x006b }
            expo.modules.imagepicker.MediaType r12 = expo.modules.imagepicker.MediaType.IMAGE     // Catch:{ OperationCanceledException -> 0x006f, all -> 0x006b }
            if (r10 != r12) goto L_0x00eb
            expo.modules.imagepicker.ImagePickerModule$launchContract$2 r10 = new expo.modules.imagepicker.ImagePickerModule$launchContract$2     // Catch:{ OperationCanceledException -> 0x006f, all -> 0x006b }
            r10.<init>(r8, r11, r2, r7)     // Catch:{ OperationCanceledException -> 0x006f, all -> 0x006b }
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10     // Catch:{ OperationCanceledException -> 0x006f, all -> 0x006b }
            r0.L$0 = r8     // Catch:{ OperationCanceledException -> 0x006f, all -> 0x006b }
            r0.L$1 = r2     // Catch:{ OperationCanceledException -> 0x006f, all -> 0x006b }
            r0.L$2 = r11     // Catch:{ OperationCanceledException -> 0x006f, all -> 0x006b }
            r0.L$3 = r11     // Catch:{ OperationCanceledException -> 0x006f, all -> 0x006b }
            r0.label = r4     // Catch:{ OperationCanceledException -> 0x006f, all -> 0x006b }
            java.lang.Object r12 = r8.launchPicker(r10, r0)     // Catch:{ OperationCanceledException -> 0x006f, all -> 0x006b }
            if (r12 != r1) goto L_0x00e8
            return r1
        L_0x00e8:
            r10 = r11
        L_0x00e9:
            r10.element = r12     // Catch:{ OperationCanceledException -> 0x006f, all -> 0x006b }
        L_0x00eb:
            r10 = r8
            expo.modules.imagepicker.MediaHandler r12 = r10.mediaHandler     // Catch:{ OperationCanceledException -> 0x0110 }
            T r11 = r11.element     // Catch:{ OperationCanceledException -> 0x0110 }
            expo.modules.imagepicker.contracts.ImagePickerContractResult$Success r11 = (expo.modules.imagepicker.contracts.ImagePickerContractResult.Success) r11     // Catch:{ OperationCanceledException -> 0x0110 }
            java.util.List r11 = r11.getData()     // Catch:{ OperationCanceledException -> 0x0110 }
            r0.L$0 = r10     // Catch:{ OperationCanceledException -> 0x0110 }
            r0.L$1 = r7     // Catch:{ OperationCanceledException -> 0x0110 }
            r0.L$2 = r7     // Catch:{ OperationCanceledException -> 0x0110 }
            r0.L$3 = r7     // Catch:{ OperationCanceledException -> 0x0110 }
            r0.label = r3     // Catch:{ OperationCanceledException -> 0x0110 }
            java.lang.Object r12 = r12.readExtras$expo_image_picker_release(r11, r2, r0)     // Catch:{ OperationCanceledException -> 0x0110 }
            if (r12 != r1) goto L_0x0107
            return r1
        L_0x0107:
            expo.modules.imagepicker.ImagePickerResponse r12 = (expo.modules.imagepicker.ImagePickerResponse) r12     // Catch:{ OperationCanceledException -> 0x0110 }
            r10.isPickerOpen = r5
            return r12
        L_0x010c:
            r11 = move-exception
            r10 = r9
            goto L_0x0118
        L_0x010f:
            r10 = r9
        L_0x0110:
            expo.modules.imagepicker.ImagePickerResponse r11 = new expo.modules.imagepicker.ImagePickerResponse     // Catch:{ all -> 0x0037 }
            r11.<init>(r6, r7, r4, r7)     // Catch:{ all -> 0x0037 }
            r10.isPickerOpen = r5
            return r11
        L_0x0118:
            r10.isPickerOpen = r5
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.imagepicker.ImagePickerModule.launchContract(kotlin.jvm.functions.Function1, expo.modules.imagepicker.ImagePickerOptions, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void handleResultUponActivityDestruction(ImagePickerContractResult imagePickerContractResult, ImagePickerOptions imagePickerOptions) {
        if (imagePickerContractResult instanceof ImagePickerContractResult.Success) {
            this.pendingMediaPickingResult = new PendingMediaPickingResult(((ImagePickerContractResult.Success) imagePickerContractResult).getData(), imagePickerOptions);
        }
    }

    /* access modifiers changed from: private */
    public final Object launchPicker(Function1<? super Continuation<? super ImagePickerContractResult>, ? extends Object> function1, Continuation<? super ImagePickerContractResult.Success> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ImagePickerModule$launchPicker$2(function1, (Continuation<? super ImagePickerModule$launchPicker$2>) null), continuation);
    }

    /* access modifiers changed from: private */
    public final String[] getMediaLibraryPermissions(boolean z) {
        if (Build.VERSION.SDK_INT >= 33) {
            return (String[]) CollectionsKt.listOfNotNull((T[]) new String[]{"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO"}).toArray(new String[0]);
        }
        String[] strArr = new String[2];
        strArr[0] = "android.permission.WRITE_EXTERNAL_STORAGE";
        strArr[1] = z ^ true ? "android.permission.READ_EXTERNAL_STORAGE" : null;
        return (String[]) CollectionsKt.listOfNotNull((T[]) strArr).toArray(new String[0]);
    }

    /* access modifiers changed from: private */
    public final void ensureTargetActivityIsAvailable(ImagePickerOptions imagePickerOptions) {
        Intent intent = new Intent(imagePickerOptions.getMediaTypes().toCameraIntentAction());
        if (intent.resolveActivity(getCurrentActivity().getApplication().getPackageManager()) == null) {
            throw new MissingActivityToHandleIntent(intent.getType());
        }
    }

    /* access modifiers changed from: private */
    public final Object ensureCameraPermissionsAreGranted(Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        Permissions permissions = getAppContext().getPermissions();
        if (permissions != null) {
            PermissionsResponseListener imagePickerModule$ensureCameraPermissionsAreGranted$2$1 = new ImagePickerModule$ensureCameraPermissionsAreGranted$2$1(cancellableContinuation);
            String[] strArr = new String[2];
            strArr[0] = Build.VERSION.SDK_INT < 33 ? "android.permission.WRITE_EXTERNAL_STORAGE" : null;
            strArr[1] = "android.permission.CAMERA";
            String[] strArr2 = (String[]) CollectionsKt.listOfNotNull((T[]) strArr).toArray(new String[0]);
            permissions.askForPermissions(imagePickerModule$ensureCameraPermissionsAreGranted$2$1, (String[]) Arrays.copyOf(strArr2, strArr2.length));
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
        }
        throw new ModuleNotFoundException("Permissions");
    }
}
