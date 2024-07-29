package com.onesignal.user.internal.operations.impl.executors;

import android.os.Build;
import com.onesignal.common.AndroidUtils;
import com.onesignal.common.DeviceUtils;
import com.onesignal.common.NetworkUtils;
import com.onesignal.common.OneSignalUtils;
import com.onesignal.common.RootToolsInternalMethods;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.device.IDeviceService;
import com.onesignal.core.internal.language.ILanguageContext;
import com.onesignal.core.internal.operations.ExecutionResponse;
import com.onesignal.core.internal.operations.ExecutionResult;
import com.onesignal.core.internal.operations.IOperationExecutor;
import com.onesignal.core.internal.operations.Operation;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.user.internal.backend.IUserBackendService;
import com.onesignal.user.internal.backend.SubscriptionObject;
import com.onesignal.user.internal.backend.SubscriptionObjectType;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.operations.CreateSubscriptionOperation;
import com.onesignal.user.internal.operations.DeleteSubscriptionOperation;
import com.onesignal.user.internal.operations.LoginUserOperation;
import com.onesignal.user.internal.operations.TransferSubscriptionOperation;
import com.onesignal.user.internal.operations.UpdateSubscriptionOperation;
import com.onesignal.user.internal.properties.PropertiesModelStore;
import com.onesignal.user.internal.subscriptions.SubscriptionModelStore;
import com.onesignal.user.internal.subscriptions.SubscriptionType;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 -2\u00020\u0001:\u0001-BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J0\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J0\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020 2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J0\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020!2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J0\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\"2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J'\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020'0\u0016H@ø\u0001\u0000¢\u0006\u0002\u0010(J\u001f\u0010)\u001a\u00020$2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020'0\u0016H@ø\u0001\u0000¢\u0006\u0002\u0010*J'\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020&2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020'0\u0016H@ø\u0001\u0000¢\u0006\u0002\u0010(R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u0002\u0004\n\u0002\b\u0019¨\u0006."}, d2 = {"Lcom/onesignal/user/internal/operations/impl/executors/LoginUserOperationExecutor;", "Lcom/onesignal/core/internal/operations/IOperationExecutor;", "_identityOperationExecutor", "Lcom/onesignal/user/internal/operations/impl/executors/IdentityOperationExecutor;", "_application", "Lcom/onesignal/core/internal/application/IApplicationService;", "_deviceService", "Lcom/onesignal/core/internal/device/IDeviceService;", "_userBackend", "Lcom/onesignal/user/internal/backend/IUserBackendService;", "_identityModelStore", "Lcom/onesignal/user/internal/identity/IdentityModelStore;", "_propertiesModelStore", "Lcom/onesignal/user/internal/properties/PropertiesModelStore;", "_subscriptionsModelStore", "Lcom/onesignal/user/internal/subscriptions/SubscriptionModelStore;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_languageContext", "Lcom/onesignal/core/internal/language/ILanguageContext;", "(Lcom/onesignal/user/internal/operations/impl/executors/IdentityOperationExecutor;Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/core/internal/device/IDeviceService;Lcom/onesignal/user/internal/backend/IUserBackendService;Lcom/onesignal/user/internal/identity/IdentityModelStore;Lcom/onesignal/user/internal/properties/PropertiesModelStore;Lcom/onesignal/user/internal/subscriptions/SubscriptionModelStore;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/core/internal/language/ILanguageContext;)V", "operations", "", "", "getOperations", "()Ljava/util/List;", "createSubscriptionsFromOperation", "", "Lcom/onesignal/user/internal/backend/SubscriptionObject;", "operation", "Lcom/onesignal/user/internal/operations/CreateSubscriptionOperation;", "subscriptions", "Lcom/onesignal/user/internal/operations/DeleteSubscriptionOperation;", "Lcom/onesignal/user/internal/operations/TransferSubscriptionOperation;", "Lcom/onesignal/user/internal/operations/UpdateSubscriptionOperation;", "createUser", "Lcom/onesignal/core/internal/operations/ExecutionResponse;", "createUserOperation", "Lcom/onesignal/user/internal/operations/LoginUserOperation;", "Lcom/onesignal/core/internal/operations/Operation;", "(Lcom/onesignal/user/internal/operations/LoginUserOperation;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "execute", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginUser", "loginUserOp", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: LoginUserOperationExecutor.kt */
public final class LoginUserOperationExecutor implements IOperationExecutor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String LOGIN_USER = "login-user";
    private final IApplicationService _application;
    private final ConfigModelStore _configModelStore;
    private final IDeviceService _deviceService;
    private final IdentityModelStore _identityModelStore;
    private final IdentityOperationExecutor _identityOperationExecutor;
    private final ILanguageContext _languageContext;
    private final PropertiesModelStore _propertiesModelStore;
    private final SubscriptionModelStore _subscriptionsModelStore;
    private final IUserBackendService _userBackend;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: LoginUserOperationExecutor.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[ExecutionResult.values().length];
            iArr[ExecutionResult.SUCCESS.ordinal()] = 1;
            iArr[ExecutionResult.FAIL_CONFLICT.ordinal()] = 2;
            iArr[ExecutionResult.FAIL_NORETRY.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[NetworkUtils.ResponseStatusType.values().length];
            iArr2[NetworkUtils.ResponseStatusType.RETRYABLE.ordinal()] = 1;
            iArr2[NetworkUtils.ResponseStatusType.UNAUTHORIZED.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[SubscriptionType.values().length];
            iArr3[SubscriptionType.SMS.ordinal()] = 1;
            iArr3[SubscriptionType.EMAIL.ordinal()] = 2;
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    public LoginUserOperationExecutor(IdentityOperationExecutor identityOperationExecutor, IApplicationService iApplicationService, IDeviceService iDeviceService, IUserBackendService iUserBackendService, IdentityModelStore identityModelStore, PropertiesModelStore propertiesModelStore, SubscriptionModelStore subscriptionModelStore, ConfigModelStore configModelStore, ILanguageContext iLanguageContext) {
        Intrinsics.checkNotNullParameter(identityOperationExecutor, "_identityOperationExecutor");
        Intrinsics.checkNotNullParameter(iApplicationService, "_application");
        Intrinsics.checkNotNullParameter(iDeviceService, "_deviceService");
        Intrinsics.checkNotNullParameter(iUserBackendService, "_userBackend");
        Intrinsics.checkNotNullParameter(identityModelStore, "_identityModelStore");
        Intrinsics.checkNotNullParameter(propertiesModelStore, "_propertiesModelStore");
        Intrinsics.checkNotNullParameter(subscriptionModelStore, "_subscriptionsModelStore");
        Intrinsics.checkNotNullParameter(configModelStore, "_configModelStore");
        Intrinsics.checkNotNullParameter(iLanguageContext, "_languageContext");
        this._identityOperationExecutor = identityOperationExecutor;
        this._application = iApplicationService;
        this._deviceService = iDeviceService;
        this._userBackend = iUserBackendService;
        this._identityModelStore = identityModelStore;
        this._propertiesModelStore = propertiesModelStore;
        this._subscriptionsModelStore = subscriptionModelStore;
        this._configModelStore = configModelStore;
        this._languageContext = iLanguageContext;
    }

    public List<String> getOperations() {
        return CollectionsKt.listOf(LOGIN_USER);
    }

    public Object execute(List<? extends Operation> list, Continuation<? super ExecutionResponse> continuation) {
        Logging.debug$default("LoginUserOperationExecutor(operation: " + list + ')', (Throwable) null, 2, (Object) null);
        Operation operation = (Operation) CollectionsKt.first(list);
        if (operation instanceof LoginUserOperation) {
            return loginUser((LoginUserOperation) operation, CollectionsKt.drop(list, 1), continuation);
        }
        throw new Exception("Unrecognized operation: " + operation);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object loginUser(com.onesignal.user.internal.operations.LoginUserOperation r22, java.util.List<? extends com.onesignal.core.internal.operations.Operation> r23, kotlin.coroutines.Continuation<? super com.onesignal.core.internal.operations.ExecutionResponse> r24) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = r23
            r3 = r24
            boolean r4 = r3 instanceof com.onesignal.user.internal.operations.impl.executors.LoginUserOperationExecutor$loginUser$1
            if (r4 == 0) goto L_0x001c
            r4 = r3
            com.onesignal.user.internal.operations.impl.executors.LoginUserOperationExecutor$loginUser$1 r4 = (com.onesignal.user.internal.operations.impl.executors.LoginUserOperationExecutor$loginUser$1) r4
            int r5 = r4.label
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r5 & r6
            if (r5 == 0) goto L_0x001c
            int r3 = r4.label
            int r3 = r3 - r6
            r4.label = r3
            goto L_0x0021
        L_0x001c:
            com.onesignal.user.internal.operations.impl.executors.LoginUserOperationExecutor$loginUser$1 r4 = new com.onesignal.user.internal.operations.impl.executors.LoginUserOperationExecutor$loginUser$1
            r4.<init>(r0, r3)
        L_0x0021:
            java.lang.Object r3 = r4.result
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r6 = r4.label
            r7 = 4
            r8 = 3
            r9 = 1
            r10 = 2
            if (r6 == 0) goto L_0x0063
            if (r6 == r9) goto L_0x005e
            if (r6 == r10) goto L_0x0049
            if (r6 == r8) goto L_0x0044
            if (r6 != r7) goto L_0x003c
            kotlin.ResultKt.throwOnFailure(r3)
            goto L_0x00f6
        L_0x003c:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r3)
            goto L_0x011e
        L_0x0049:
            java.lang.Object r1 = r4.L$2
            java.util.List r1 = (java.util.List) r1
            java.lang.Object r2 = r4.L$1
            com.onesignal.user.internal.operations.LoginUserOperation r2 = (com.onesignal.user.internal.operations.LoginUserOperation) r2
            java.lang.Object r6 = r4.L$0
            com.onesignal.user.internal.operations.impl.executors.LoginUserOperationExecutor r6 = (com.onesignal.user.internal.operations.impl.executors.LoginUserOperationExecutor) r6
            kotlin.ResultKt.throwOnFailure(r3)
            r20 = r2
            r2 = r1
            r1 = r20
            goto L_0x00a3
        L_0x005e:
            kotlin.ResultKt.throwOnFailure(r3)
            goto L_0x019b
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r3)
            java.lang.String r3 = r22.getExistingOnesignalId()
            if (r3 == 0) goto L_0x0192
            java.lang.String r3 = r22.getExternalId()
            if (r3 != 0) goto L_0x0074
            goto L_0x0192
        L_0x0074:
            com.onesignal.user.internal.operations.impl.executors.IdentityOperationExecutor r3 = r0._identityOperationExecutor
            com.onesignal.user.internal.operations.SetAliasOperation r6 = new com.onesignal.user.internal.operations.SetAliasOperation
            java.lang.String r11 = r22.getAppId()
            java.lang.String r12 = r22.getExistingOnesignalId()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            java.lang.String r13 = r22.getExternalId()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            java.lang.String r14 = "external_id"
            r6.<init>(r11, r12, r14, r13)
            java.util.List r6 = kotlin.collections.CollectionsKt.listOf(r6)
            r4.L$0 = r0
            r4.L$1 = r1
            r4.L$2 = r2
            r4.label = r10
            java.lang.Object r3 = r3.execute(r6, r4)
            if (r3 != r5) goto L_0x00a2
            return r5
        L_0x00a2:
            r6 = r0
        L_0x00a3:
            com.onesignal.core.internal.operations.ExecutionResponse r3 = (com.onesignal.core.internal.operations.ExecutionResponse) r3
            com.onesignal.core.internal.operations.ExecutionResult r11 = r3.getResult()
            int[] r12 = com.onesignal.user.internal.operations.impl.executors.LoginUserOperationExecutor.WhenMappings.$EnumSwitchMapping$0
            int r11 = r11.ordinal()
            r11 = r12[r11]
            if (r11 == r9) goto L_0x011f
            r9 = 34
            r12 = 0
            if (r11 == r10) goto L_0x00f7
            if (r11 == r8) goto L_0x00cf
            com.onesignal.core.internal.operations.ExecutionResponse r1 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r14 = r3.getResult()
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 14
            r19 = 0
            r13 = r1
            r13.<init>(r14, r15, r16, r17, r18, r19)
            goto L_0x0191
        L_0x00cf:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r8 = "LoginUserOperationExecutor encountered error. Attempt to recover by switching to user with \"external_id\": \""
            r3.<init>(r8)
            java.lang.String r8 = r1.getExternalId()
            r3.append(r8)
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            com.onesignal.debug.internal.logging.Logging.error$default(r3, r12, r10, r12)
            r4.L$0 = r12
            r4.L$1 = r12
            r4.L$2 = r12
            r4.label = r7
            java.lang.Object r3 = r6.createUser(r1, r2, r4)
            if (r3 != r5) goto L_0x00f6
            return r5
        L_0x00f6:
            return r3
        L_0x00f7:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r7 = "LoginUserOperationExecutor now handling 409 response with \"code\": \"user-2\" by switching to user with \"external_id\": \""
            r3.<init>(r7)
            java.lang.String r7 = r1.getExternalId()
            r3.append(r7)
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            com.onesignal.debug.internal.logging.Logging.debug$default(r3, r12, r10, r12)
            r4.L$0 = r12
            r4.L$1 = r12
            r4.L$2 = r12
            r4.label = r8
            java.lang.Object r3 = r6.createUser(r1, r2, r4)
            if (r3 != r5) goto L_0x011e
            return r5
        L_0x011e:
            return r3
        L_0x011f:
            java.lang.String r2 = r1.getExistingOnesignalId()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            com.onesignal.user.internal.identity.IdentityModelStore r3 = r6._identityModelStore
            com.onesignal.common.modeling.Model r3 = r3.getModel()
            com.onesignal.user.internal.identity.IdentityModel r3 = (com.onesignal.user.internal.identity.IdentityModel) r3
            java.lang.String r3 = r3.getOnesignalId()
            java.lang.String r4 = r1.getOnesignalId()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 == 0) goto L_0x014e
            com.onesignal.user.internal.identity.IdentityModelStore r3 = r6._identityModelStore
            com.onesignal.common.modeling.Model r7 = r3.getModel()
            java.lang.String r8 = "onesignal_id"
            java.lang.String r10 = "HYDRATE"
            r11 = 0
            r12 = 8
            r13 = 0
            r9 = r2
            com.onesignal.common.modeling.Model.setStringProperty$default(r7, r8, r9, r10, r11, r12, r13)
        L_0x014e:
            com.onesignal.user.internal.properties.PropertiesModelStore r3 = r6._propertiesModelStore
            com.onesignal.common.modeling.Model r3 = r3.getModel()
            com.onesignal.user.internal.properties.PropertiesModel r3 = (com.onesignal.user.internal.properties.PropertiesModel) r3
            java.lang.String r3 = r3.getOnesignalId()
            java.lang.String r4 = r1.getOnesignalId()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 == 0) goto L_0x0176
            com.onesignal.user.internal.properties.PropertiesModelStore r3 = r6._propertiesModelStore
            com.onesignal.common.modeling.Model r4 = r3.getModel()
            java.lang.String r5 = "onesignalId"
            java.lang.String r7 = "HYDRATE"
            r8 = 0
            r9 = 8
            r10 = 0
            r6 = r2
            com.onesignal.common.modeling.Model.setStringProperty$default(r4, r5, r6, r7, r8, r9, r10)
        L_0x0176:
            com.onesignal.core.internal.operations.ExecutionResponse r3 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r12 = com.onesignal.core.internal.operations.ExecutionResult.SUCCESS_STARTING_ONLY
            java.lang.String r1 = r1.getOnesignalId()
            kotlin.Pair r1 = kotlin.TuplesKt.to(r1, r2)
            java.util.Map r13 = kotlin.collections.MapsKt.mapOf(r1)
            r14 = 0
            r15 = 0
            r16 = 12
            r17 = 0
            r11 = r3
            r11.<init>(r12, r13, r14, r15, r16, r17)
            r1 = r3
        L_0x0191:
            return r1
        L_0x0192:
            r4.label = r9
            java.lang.Object r3 = r0.createUser(r1, r2, r4)
            if (r3 != r5) goto L_0x019b
            return r5
        L_0x019b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.operations.impl.executors.LoginUserOperationExecutor.loginUser(com.onesignal.user.internal.operations.LoginUserOperation, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x016d A[Catch:{ BackendException -> 0x0040 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x018c A[Catch:{ BackendException -> 0x0040 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01a4 A[Catch:{ BackendException -> 0x0040 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x022d A[Catch:{ BackendException -> 0x0040 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x023b A[Catch:{ BackendException -> 0x0040 }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0226 A[EDGE_INSN: B:83:0x0226->B:62:0x0226 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object createUser(com.onesignal.user.internal.operations.LoginUserOperation r22, java.util.List<? extends com.onesignal.core.internal.operations.Operation> r23, kotlin.coroutines.Continuation<? super com.onesignal.core.internal.operations.ExecutionResponse> r24) {
        /*
            r21 = this;
            r1 = r21
            r0 = r24
            boolean r2 = r0 instanceof com.onesignal.user.internal.operations.impl.executors.LoginUserOperationExecutor$createUser$1
            if (r2 == 0) goto L_0x0018
            r2 = r0
            com.onesignal.user.internal.operations.impl.executors.LoginUserOperationExecutor$createUser$1 r2 = (com.onesignal.user.internal.operations.impl.executors.LoginUserOperationExecutor$createUser$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r0 = r2.label
            int r0 = r0 - r4
            r2.label = r0
            goto L_0x001d
        L_0x0018:
            com.onesignal.user.internal.operations.impl.executors.LoginUserOperationExecutor$createUser$1 r2 = new com.onesignal.user.internal.operations.impl.executors.LoginUserOperationExecutor$createUser$1
            r2.<init>(r1, r0)
        L_0x001d:
            r8 = r2
            java.lang.Object r0 = r8.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r8.label
            r9 = 1
            if (r3 == 0) goto L_0x004b
            if (r3 != r9) goto L_0x0043
            java.lang.Object r2 = r8.L$3
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r3 = r8.L$2
            java.util.Map r3 = (java.util.Map) r3
            java.lang.Object r4 = r8.L$1
            com.onesignal.user.internal.operations.LoginUserOperation r4 = (com.onesignal.user.internal.operations.LoginUserOperation) r4
            java.lang.Object r5 = r8.L$0
            com.onesignal.user.internal.operations.impl.executors.LoginUserOperationExecutor r5 = (com.onesignal.user.internal.operations.impl.executors.LoginUserOperationExecutor) r5
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ BackendException -> 0x0040 }
            goto L_0x012f
        L_0x0040:
            r0 = move-exception
            goto L_0x024e
        L_0x0043:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x004b:
            kotlin.ResultKt.throwOnFailure(r0)
            java.util.Map r0 = kotlin.collections.MapsKt.emptyMap()
            java.util.Map r3 = kotlin.collections.MapsKt.emptyMap()
            java.util.LinkedHashMap r4 = new java.util.LinkedHashMap
            r4.<init>()
            r7 = r4
            java.util.Map r7 = (java.util.Map) r7
            com.onesignal.common.TimeUtils r4 = com.onesignal.common.TimeUtils.INSTANCE
            java.lang.String r4 = r4.getTimeZoneId()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            java.lang.String r5 = "timezone_id"
            r7.put(r5, r4)
            com.onesignal.core.internal.language.ILanguageContext r4 = r1._languageContext
            java.lang.String r4 = r4.getLanguage()
            java.lang.String r5 = "language"
            r7.put(r5, r4)
            java.lang.String r4 = r22.getExternalId()
            if (r4 == 0) goto L_0x008d
            java.util.Map r0 = kotlin.collections.MapsKt.toMutableMap(r0)
            java.lang.String r4 = r22.getExternalId()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            java.lang.String r5 = "external_id"
            r0.put(r5, r4)
        L_0x008d:
            java.util.Iterator r4 = r23.iterator()
        L_0x0091:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x00dd
            java.lang.Object r5 = r4.next()
            com.onesignal.core.internal.operations.Operation r5 = (com.onesignal.core.internal.operations.Operation) r5
            boolean r6 = r5 instanceof com.onesignal.user.internal.operations.CreateSubscriptionOperation
            if (r6 == 0) goto L_0x00a8
            com.onesignal.user.internal.operations.CreateSubscriptionOperation r5 = (com.onesignal.user.internal.operations.CreateSubscriptionOperation) r5
            java.util.Map r3 = r1.createSubscriptionsFromOperation((com.onesignal.user.internal.operations.CreateSubscriptionOperation) r5, (java.util.Map<java.lang.String, com.onesignal.user.internal.backend.SubscriptionObject>) r3)
            goto L_0x0091
        L_0x00a8:
            boolean r6 = r5 instanceof com.onesignal.user.internal.operations.TransferSubscriptionOperation
            if (r6 == 0) goto L_0x00b3
            com.onesignal.user.internal.operations.TransferSubscriptionOperation r5 = (com.onesignal.user.internal.operations.TransferSubscriptionOperation) r5
            java.util.Map r3 = r1.createSubscriptionsFromOperation((com.onesignal.user.internal.operations.TransferSubscriptionOperation) r5, (java.util.Map<java.lang.String, com.onesignal.user.internal.backend.SubscriptionObject>) r3)
            goto L_0x0091
        L_0x00b3:
            boolean r6 = r5 instanceof com.onesignal.user.internal.operations.UpdateSubscriptionOperation
            if (r6 == 0) goto L_0x00be
            com.onesignal.user.internal.operations.UpdateSubscriptionOperation r5 = (com.onesignal.user.internal.operations.UpdateSubscriptionOperation) r5
            java.util.Map r3 = r1.createSubscriptionsFromOperation((com.onesignal.user.internal.operations.UpdateSubscriptionOperation) r5, (java.util.Map<java.lang.String, com.onesignal.user.internal.backend.SubscriptionObject>) r3)
            goto L_0x0091
        L_0x00be:
            boolean r6 = r5 instanceof com.onesignal.user.internal.operations.DeleteSubscriptionOperation
            if (r6 == 0) goto L_0x00c9
            com.onesignal.user.internal.operations.DeleteSubscriptionOperation r5 = (com.onesignal.user.internal.operations.DeleteSubscriptionOperation) r5
            java.util.Map r3 = r1.createSubscriptionsFromOperation((com.onesignal.user.internal.operations.DeleteSubscriptionOperation) r5, (java.util.Map<java.lang.String, com.onesignal.user.internal.backend.SubscriptionObject>) r3)
            goto L_0x0091
        L_0x00c9:
            java.lang.Exception r0 = new java.lang.Exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Unrecognized operation: "
            r2.<init>(r3)
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x00dd:
            java.util.List r10 = kotlin.collections.MapsKt.toList(r3)     // Catch:{ BackendException -> 0x0040 }
            com.onesignal.user.internal.backend.IUserBackendService r3 = r1._userBackend     // Catch:{ BackendException -> 0x0040 }
            java.lang.String r4 = r22.getAppId()     // Catch:{ BackendException -> 0x0040 }
            r5 = r10
            java.lang.Iterable r5 = (java.lang.Iterable) r5     // Catch:{ BackendException -> 0x0040 }
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ BackendException -> 0x0040 }
            r11 = 10
            int r11 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r5, r11)     // Catch:{ BackendException -> 0x0040 }
            r6.<init>(r11)     // Catch:{ BackendException -> 0x0040 }
            java.util.Collection r6 = (java.util.Collection) r6     // Catch:{ BackendException -> 0x0040 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ BackendException -> 0x0040 }
        L_0x00fb:
            boolean r11 = r5.hasNext()     // Catch:{ BackendException -> 0x0040 }
            if (r11 == 0) goto L_0x0111
            java.lang.Object r11 = r5.next()     // Catch:{ BackendException -> 0x0040 }
            kotlin.Pair r11 = (kotlin.Pair) r11     // Catch:{ BackendException -> 0x0040 }
            java.lang.Object r11 = r11.getSecond()     // Catch:{ BackendException -> 0x0040 }
            com.onesignal.user.internal.backend.SubscriptionObject r11 = (com.onesignal.user.internal.backend.SubscriptionObject) r11     // Catch:{ BackendException -> 0x0040 }
            r6.add(r11)     // Catch:{ BackendException -> 0x0040 }
            goto L_0x00fb
        L_0x0111:
            java.util.List r6 = (java.util.List) r6     // Catch:{ BackendException -> 0x0040 }
            r8.L$0 = r1     // Catch:{ BackendException -> 0x0040 }
            r11 = r22
            r8.L$1 = r11     // Catch:{ BackendException -> 0x0040 }
            r8.L$2 = r0     // Catch:{ BackendException -> 0x0040 }
            r8.L$3 = r10     // Catch:{ BackendException -> 0x0040 }
            r8.label = r9     // Catch:{ BackendException -> 0x0040 }
            r5 = r0
            java.lang.Object r3 = r3.createUser(r4, r5, r6, r7, r8)     // Catch:{ BackendException -> 0x0040 }
            if (r3 != r2) goto L_0x0127
            return r2
        L_0x0127:
            r5 = r1
            r2 = r10
            r4 = r11
            r20 = r3
            r3 = r0
            r0 = r20
        L_0x012f:
            com.onesignal.user.internal.backend.CreateUserResponse r0 = (com.onesignal.user.internal.backend.CreateUserResponse) r0     // Catch:{ BackendException -> 0x0040 }
            java.util.LinkedHashMap r6 = new java.util.LinkedHashMap     // Catch:{ BackendException -> 0x0040 }
            r6.<init>()     // Catch:{ BackendException -> 0x0040 }
            r12 = r6
            java.util.Map r12 = (java.util.Map) r12     // Catch:{ BackendException -> 0x0040 }
            java.util.Map r6 = r0.getIdentities()     // Catch:{ BackendException -> 0x0040 }
            java.lang.String r7 = "onesignal_id"
            java.lang.Object r6 = r6.get(r7)     // Catch:{ BackendException -> 0x0040 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)     // Catch:{ BackendException -> 0x0040 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ BackendException -> 0x0040 }
            java.lang.String r7 = r4.getOnesignalId()     // Catch:{ BackendException -> 0x0040 }
            r12.put(r7, r6)     // Catch:{ BackendException -> 0x0040 }
            com.onesignal.user.internal.identity.IdentityModelStore r7 = r5._identityModelStore     // Catch:{ BackendException -> 0x0040 }
            com.onesignal.common.modeling.Model r7 = r7.getModel()     // Catch:{ BackendException -> 0x0040 }
            com.onesignal.user.internal.identity.IdentityModel r7 = (com.onesignal.user.internal.identity.IdentityModel) r7     // Catch:{ BackendException -> 0x0040 }
            com.onesignal.user.internal.properties.PropertiesModelStore r8 = r5._propertiesModelStore     // Catch:{ BackendException -> 0x0040 }
            com.onesignal.common.modeling.Model r8 = r8.getModel()     // Catch:{ BackendException -> 0x0040 }
            com.onesignal.user.internal.properties.PropertiesModel r8 = (com.onesignal.user.internal.properties.PropertiesModel) r8     // Catch:{ BackendException -> 0x0040 }
            java.lang.String r10 = r7.getOnesignalId()     // Catch:{ BackendException -> 0x0040 }
            java.lang.String r11 = r4.getOnesignalId()     // Catch:{ BackendException -> 0x0040 }
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r11)     // Catch:{ BackendException -> 0x0040 }
            if (r10 == 0) goto L_0x017e
            r13 = r7
            com.onesignal.common.modeling.Model r13 = (com.onesignal.common.modeling.Model) r13     // Catch:{ BackendException -> 0x0040 }
            java.lang.String r14 = "onesignal_id"
            java.lang.String r16 = "HYDRATE"
            r17 = 0
            r18 = 8
            r19 = 0
            r15 = r6
            com.onesignal.common.modeling.Model.setStringProperty$default(r13, r14, r15, r16, r17, r18, r19)     // Catch:{ BackendException -> 0x0040 }
        L_0x017e:
            java.lang.String r7 = r8.getOnesignalId()     // Catch:{ BackendException -> 0x0040 }
            java.lang.String r10 = r4.getOnesignalId()     // Catch:{ BackendException -> 0x0040 }
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r10)     // Catch:{ BackendException -> 0x0040 }
            if (r7 == 0) goto L_0x019d
            r13 = r8
            com.onesignal.common.modeling.Model r13 = (com.onesignal.common.modeling.Model) r13     // Catch:{ BackendException -> 0x0040 }
            java.lang.String r14 = "onesignalId"
            java.lang.String r16 = "HYDRATE"
            r17 = 0
            r18 = 8
            r19 = 0
            r15 = r6
            com.onesignal.common.modeling.Model.setStringProperty$default(r13, r14, r15, r16, r17, r18, r19)     // Catch:{ BackendException -> 0x0040 }
        L_0x019d:
            int r7 = r2.size()     // Catch:{ BackendException -> 0x0040 }
            r8 = 0
        L_0x01a2:
            if (r8 >= r7) goto L_0x0226
            java.util.List r10 = r0.getSubscriptions()     // Catch:{ BackendException -> 0x0040 }
            int r10 = r10.size()     // Catch:{ BackendException -> 0x0040 }
            if (r8 < r10) goto L_0x01af
            goto L_0x0226
        L_0x01af:
            java.util.List r10 = r0.getSubscriptions()     // Catch:{ BackendException -> 0x0040 }
            java.lang.Object r10 = r10.get(r8)     // Catch:{ BackendException -> 0x0040 }
            com.onesignal.user.internal.backend.SubscriptionObject r10 = (com.onesignal.user.internal.backend.SubscriptionObject) r10     // Catch:{ BackendException -> 0x0040 }
            java.lang.Object r11 = r2.get(r8)     // Catch:{ BackendException -> 0x0040 }
            kotlin.Pair r11 = (kotlin.Pair) r11     // Catch:{ BackendException -> 0x0040 }
            java.lang.Object r11 = r11.getFirst()     // Catch:{ BackendException -> 0x0040 }
            java.lang.String r13 = r10.getId()     // Catch:{ BackendException -> 0x0040 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)     // Catch:{ BackendException -> 0x0040 }
            r12.put(r11, r13)     // Catch:{ BackendException -> 0x0040 }
            com.onesignal.core.internal.config.ConfigModelStore r11 = r5._configModelStore     // Catch:{ BackendException -> 0x0040 }
            com.onesignal.common.modeling.Model r11 = r11.getModel()     // Catch:{ BackendException -> 0x0040 }
            com.onesignal.core.internal.config.ConfigModel r11 = (com.onesignal.core.internal.config.ConfigModel) r11     // Catch:{ BackendException -> 0x0040 }
            java.lang.String r11 = r11.getPushSubscriptionId()     // Catch:{ BackendException -> 0x0040 }
            java.lang.Object r13 = r2.get(r8)     // Catch:{ BackendException -> 0x0040 }
            kotlin.Pair r13 = (kotlin.Pair) r13     // Catch:{ BackendException -> 0x0040 }
            java.lang.Object r13 = r13.getFirst()     // Catch:{ BackendException -> 0x0040 }
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r13)     // Catch:{ BackendException -> 0x0040 }
            if (r11 == 0) goto L_0x01f8
            com.onesignal.core.internal.config.ConfigModelStore r11 = r5._configModelStore     // Catch:{ BackendException -> 0x0040 }
            com.onesignal.common.modeling.Model r11 = r11.getModel()     // Catch:{ BackendException -> 0x0040 }
            com.onesignal.core.internal.config.ConfigModel r11 = (com.onesignal.core.internal.config.ConfigModel) r11     // Catch:{ BackendException -> 0x0040 }
            java.lang.String r13 = r10.getId()     // Catch:{ BackendException -> 0x0040 }
            r11.setPushSubscriptionId(r13)     // Catch:{ BackendException -> 0x0040 }
        L_0x01f8:
            com.onesignal.user.internal.subscriptions.SubscriptionModelStore r11 = r5._subscriptionsModelStore     // Catch:{ BackendException -> 0x0040 }
            java.lang.Object r13 = r2.get(r8)     // Catch:{ BackendException -> 0x0040 }
            kotlin.Pair r13 = (kotlin.Pair) r13     // Catch:{ BackendException -> 0x0040 }
            java.lang.Object r13 = r13.getFirst()     // Catch:{ BackendException -> 0x0040 }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ BackendException -> 0x0040 }
            com.onesignal.common.modeling.Model r11 = r11.get(r13)     // Catch:{ BackendException -> 0x0040 }
            com.onesignal.user.internal.subscriptions.SubscriptionModel r11 = (com.onesignal.user.internal.subscriptions.SubscriptionModel) r11     // Catch:{ BackendException -> 0x0040 }
            if (r11 == 0) goto L_0x0222
            r13 = r11
            com.onesignal.common.modeling.Model r13 = (com.onesignal.common.modeling.Model) r13     // Catch:{ BackendException -> 0x0040 }
            java.lang.String r14 = "id"
            java.lang.String r15 = r10.getId()     // Catch:{ BackendException -> 0x0040 }
            java.lang.String r16 = "HYDRATE"
            r17 = 0
            r18 = 8
            r19 = 0
            com.onesignal.common.modeling.Model.setStringProperty$default(r13, r14, r15, r16, r17, r18, r19)     // Catch:{ BackendException -> 0x0040 }
        L_0x0222:
            int r8 = r8 + 1
            goto L_0x01a2
        L_0x0226:
            boolean r0 = r3.isEmpty()     // Catch:{ BackendException -> 0x0040 }
            r0 = r0 ^ r9
            if (r0 == 0) goto L_0x023b
            com.onesignal.user.internal.operations.RefreshUserOperation r0 = new com.onesignal.user.internal.operations.RefreshUserOperation     // Catch:{ BackendException -> 0x0040 }
            java.lang.String r2 = r4.getAppId()     // Catch:{ BackendException -> 0x0040 }
            r0.<init>(r2, r6)     // Catch:{ BackendException -> 0x0040 }
            java.util.List r0 = kotlin.collections.CollectionsKt.listOf(r0)     // Catch:{ BackendException -> 0x0040 }
            goto L_0x023f
        L_0x023b:
            r0 = 0
            r2 = r0
            java.util.List r2 = (java.util.List) r2     // Catch:{ BackendException -> 0x0040 }
        L_0x023f:
            r13 = r0
            com.onesignal.core.internal.operations.ExecutionResponse r0 = new com.onesignal.core.internal.operations.ExecutionResponse     // Catch:{ BackendException -> 0x0040 }
            com.onesignal.core.internal.operations.ExecutionResult r11 = com.onesignal.core.internal.operations.ExecutionResult.SUCCESS     // Catch:{ BackendException -> 0x0040 }
            r14 = 0
            r15 = 8
            r16 = 0
            r10 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16)     // Catch:{ BackendException -> 0x0040 }
            return r0
        L_0x024e:
            com.onesignal.common.NetworkUtils r2 = com.onesignal.common.NetworkUtils.INSTANCE
            int r3 = r0.getStatusCode()
            com.onesignal.common.NetworkUtils$ResponseStatusType r2 = r2.getResponseStatusType(r3)
            int[] r3 = com.onesignal.user.internal.operations.impl.executors.LoginUserOperationExecutor.WhenMappings.$EnumSwitchMapping$1
            int r2 = r2.ordinal()
            r2 = r3[r2]
            if (r2 == r9) goto L_0x0287
            r3 = 2
            if (r2 == r3) goto L_0x0274
            com.onesignal.core.internal.operations.ExecutionResponse r0 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r5 = com.onesignal.core.internal.operations.ExecutionResult.FAIL_PAUSE_OPREPO
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 14
            r10 = 0
            r4 = r0
            r4.<init>(r5, r6, r7, r8, r9, r10)
            goto L_0x0298
        L_0x0274:
            com.onesignal.core.internal.operations.ExecutionResponse r2 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r12 = com.onesignal.core.internal.operations.ExecutionResult.FAIL_UNAUTHORIZED
            r13 = 0
            r14 = 0
            java.lang.Integer r15 = r0.getRetryAfterSeconds()
            r16 = 6
            r17 = 0
            r11 = r2
            r11.<init>(r12, r13, r14, r15, r16, r17)
            goto L_0x0297
        L_0x0287:
            com.onesignal.core.internal.operations.ExecutionResponse r2 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r4 = com.onesignal.core.internal.operations.ExecutionResult.FAIL_RETRY
            r5 = 0
            r6 = 0
            java.lang.Integer r7 = r0.getRetryAfterSeconds()
            r8 = 6
            r9 = 0
            r3 = r2
            r3.<init>(r4, r5, r6, r7, r8, r9)
        L_0x0297:
            r0 = r2
        L_0x0298:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.operations.impl.executors.LoginUserOperationExecutor.createUser(com.onesignal.user.internal.operations.LoginUserOperation, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Map<String, SubscriptionObject> createSubscriptionsFromOperation(TransferSubscriptionOperation transferSubscriptionOperation, Map<String, SubscriptionObject> map) {
        Map<String, SubscriptionObject> map2 = map;
        Map<String, SubscriptionObject> mutableMap = MapsKt.toMutableMap(map);
        if (mutableMap.containsKey(transferSubscriptionOperation.getSubscriptionId())) {
            String subscriptionId = transferSubscriptionOperation.getSubscriptionId();
            String subscriptionId2 = transferSubscriptionOperation.getSubscriptionId();
            SubscriptionObject subscriptionObject = map2.get(transferSubscriptionOperation.getSubscriptionId());
            Intrinsics.checkNotNull(subscriptionObject);
            SubscriptionObjectType type = subscriptionObject.getType();
            SubscriptionObject subscriptionObject2 = map2.get(transferSubscriptionOperation.getSubscriptionId());
            Intrinsics.checkNotNull(subscriptionObject2);
            String token = subscriptionObject2.getToken();
            SubscriptionObject subscriptionObject3 = map2.get(transferSubscriptionOperation.getSubscriptionId());
            Intrinsics.checkNotNull(subscriptionObject3);
            Boolean enabled = subscriptionObject3.getEnabled();
            SubscriptionObject subscriptionObject4 = map2.get(transferSubscriptionOperation.getSubscriptionId());
            Intrinsics.checkNotNull(subscriptionObject4);
            Integer notificationTypes = subscriptionObject4.getNotificationTypes();
            SubscriptionObject subscriptionObject5 = map2.get(transferSubscriptionOperation.getSubscriptionId());
            Intrinsics.checkNotNull(subscriptionObject5);
            String sdk = subscriptionObject5.getSdk();
            SubscriptionObject subscriptionObject6 = map2.get(transferSubscriptionOperation.getSubscriptionId());
            Intrinsics.checkNotNull(subscriptionObject6);
            String deviceModel = subscriptionObject6.getDeviceModel();
            SubscriptionObject subscriptionObject7 = map2.get(transferSubscriptionOperation.getSubscriptionId());
            Intrinsics.checkNotNull(subscriptionObject7);
            String deviceOS = subscriptionObject7.getDeviceOS();
            SubscriptionObject subscriptionObject8 = map2.get(transferSubscriptionOperation.getSubscriptionId());
            Intrinsics.checkNotNull(subscriptionObject8);
            Boolean rooted = subscriptionObject8.getRooted();
            SubscriptionObject subscriptionObject9 = map2.get(transferSubscriptionOperation.getSubscriptionId());
            Intrinsics.checkNotNull(subscriptionObject9);
            Integer netType = subscriptionObject9.getNetType();
            SubscriptionObject subscriptionObject10 = map2.get(transferSubscriptionOperation.getSubscriptionId());
            Intrinsics.checkNotNull(subscriptionObject10);
            String carrier = subscriptionObject10.getCarrier();
            SubscriptionObject subscriptionObject11 = map2.get(transferSubscriptionOperation.getSubscriptionId());
            Intrinsics.checkNotNull(subscriptionObject11);
            SubscriptionObject subscriptionObject12 = r3;
            SubscriptionObject subscriptionObject13 = new SubscriptionObject(subscriptionId2, type, token, enabled, notificationTypes, sdk, deviceModel, deviceOS, rooted, netType, carrier, subscriptionObject11.getAppVersion());
            mutableMap.put(subscriptionId, subscriptionObject12);
        } else {
            String subscriptionId3 = transferSubscriptionOperation.getSubscriptionId();
            SubscriptionObject subscriptionObject14 = r2;
            SubscriptionObject subscriptionObject15 = new SubscriptionObject(transferSubscriptionOperation.getSubscriptionId(), (SubscriptionObjectType) null, (String) null, (Boolean) null, (Integer) null, (String) null, (String) null, (String) null, (Boolean) null, (Integer) null, (String) null, (String) null, 4094, (DefaultConstructorMarker) null);
            mutableMap.put(subscriptionId3, subscriptionObject14);
        }
        return mutableMap;
    }

    private final Map<String, SubscriptionObject> createSubscriptionsFromOperation(CreateSubscriptionOperation createSubscriptionOperation, Map<String, SubscriptionObject> map) {
        SubscriptionObjectType subscriptionObjectType;
        Map<String, SubscriptionObject> mutableMap = MapsKt.toMutableMap(map);
        int i = WhenMappings.$EnumSwitchMapping$2[createSubscriptionOperation.getType().ordinal()];
        if (i == 1) {
            subscriptionObjectType = SubscriptionObjectType.SMS;
        } else if (i != 2) {
            subscriptionObjectType = SubscriptionObjectType.Companion.fromDeviceType(this._deviceService.getDeviceType());
        } else {
            subscriptionObjectType = SubscriptionObjectType.EMAIL;
        }
        SubscriptionObjectType subscriptionObjectType2 = subscriptionObjectType;
        String subscriptionId = createSubscriptionOperation.getSubscriptionId();
        SubscriptionObject subscriptionObject = r3;
        SubscriptionObject subscriptionObject2 = new SubscriptionObject((String) null, subscriptionObjectType2, createSubscriptionOperation.getAddress(), Boolean.valueOf(createSubscriptionOperation.getEnabled()), Integer.valueOf(createSubscriptionOperation.getStatus().getValue()), OneSignalUtils.SDK_VERSION, Build.MODEL, Build.VERSION.RELEASE, Boolean.valueOf(RootToolsInternalMethods.INSTANCE.isRooted()), DeviceUtils.INSTANCE.getNetType(this._application.getAppContext()), DeviceUtils.INSTANCE.getCarrierName(this._application.getAppContext()), AndroidUtils.INSTANCE.getAppVersion(this._application.getAppContext()));
        mutableMap.put(subscriptionId, subscriptionObject);
        return mutableMap;
    }

    private final Map<String, SubscriptionObject> createSubscriptionsFromOperation(UpdateSubscriptionOperation updateSubscriptionOperation, Map<String, SubscriptionObject> map) {
        Map<String, SubscriptionObject> map2 = map;
        Map<String, SubscriptionObject> mutableMap = MapsKt.toMutableMap(map);
        if (mutableMap.containsKey(updateSubscriptionOperation.getSubscriptionId())) {
            String subscriptionId = updateSubscriptionOperation.getSubscriptionId();
            SubscriptionObject subscriptionObject = map2.get(updateSubscriptionOperation.getSubscriptionId());
            Intrinsics.checkNotNull(subscriptionObject);
            String id = subscriptionObject.getId();
            SubscriptionObject subscriptionObject2 = map2.get(updateSubscriptionOperation.getSubscriptionId());
            Intrinsics.checkNotNull(subscriptionObject2);
            SubscriptionObjectType type = subscriptionObject2.getType();
            String address = updateSubscriptionOperation.getAddress();
            Boolean valueOf = Boolean.valueOf(updateSubscriptionOperation.getEnabled());
            Integer valueOf2 = Integer.valueOf(updateSubscriptionOperation.getStatus().getValue());
            SubscriptionObject subscriptionObject3 = map2.get(updateSubscriptionOperation.getSubscriptionId());
            Intrinsics.checkNotNull(subscriptionObject3);
            String sdk = subscriptionObject3.getSdk();
            SubscriptionObject subscriptionObject4 = map2.get(updateSubscriptionOperation.getSubscriptionId());
            Intrinsics.checkNotNull(subscriptionObject4);
            String deviceModel = subscriptionObject4.getDeviceModel();
            SubscriptionObject subscriptionObject5 = map2.get(updateSubscriptionOperation.getSubscriptionId());
            Intrinsics.checkNotNull(subscriptionObject5);
            String deviceOS = subscriptionObject5.getDeviceOS();
            SubscriptionObject subscriptionObject6 = map2.get(updateSubscriptionOperation.getSubscriptionId());
            Intrinsics.checkNotNull(subscriptionObject6);
            Boolean rooted = subscriptionObject6.getRooted();
            SubscriptionObject subscriptionObject7 = map2.get(updateSubscriptionOperation.getSubscriptionId());
            Intrinsics.checkNotNull(subscriptionObject7);
            Integer netType = subscriptionObject7.getNetType();
            SubscriptionObject subscriptionObject8 = map2.get(updateSubscriptionOperation.getSubscriptionId());
            Intrinsics.checkNotNull(subscriptionObject8);
            String carrier = subscriptionObject8.getCarrier();
            SubscriptionObject subscriptionObject9 = map2.get(updateSubscriptionOperation.getSubscriptionId());
            Intrinsics.checkNotNull(subscriptionObject9);
            SubscriptionObject subscriptionObject10 = r3;
            SubscriptionObject subscriptionObject11 = new SubscriptionObject(id, type, address, valueOf, valueOf2, sdk, deviceModel, deviceOS, rooted, netType, carrier, subscriptionObject9.getAppVersion());
            mutableMap.put(subscriptionId, subscriptionObject10);
        }
        return mutableMap;
    }

    private final Map<String, SubscriptionObject> createSubscriptionsFromOperation(DeleteSubscriptionOperation deleteSubscriptionOperation, Map<String, SubscriptionObject> map) {
        Map<String, SubscriptionObject> mutableMap = MapsKt.toMutableMap(map);
        mutableMap.remove(deleteSubscriptionOperation.getSubscriptionId());
        return mutableMap;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/onesignal/user/internal/operations/impl/executors/LoginUserOperationExecutor$Companion;", "", "()V", "LOGIN_USER", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: LoginUserOperationExecutor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
