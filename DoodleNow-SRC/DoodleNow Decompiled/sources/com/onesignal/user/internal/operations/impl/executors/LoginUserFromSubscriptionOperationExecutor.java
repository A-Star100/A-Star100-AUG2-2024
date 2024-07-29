package com.onesignal.user.internal.operations.impl.executors;

import com.onesignal.common.NetworkUtils;
import com.onesignal.core.internal.operations.ExecutionResponse;
import com.onesignal.core.internal.operations.IOperationExecutor;
import com.onesignal.core.internal.operations.Operation;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.user.internal.backend.ISubscriptionBackendService;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.operations.LoginUserFromSubscriptionOperation;
import com.onesignal.user.internal.properties.PropertiesModelStore;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001f\u0010\u000e\u001a\u00020\u000f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00100\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/onesignal/user/internal/operations/impl/executors/LoginUserFromSubscriptionOperationExecutor;", "Lcom/onesignal/core/internal/operations/IOperationExecutor;", "_subscriptionBackend", "Lcom/onesignal/user/internal/backend/ISubscriptionBackendService;", "_identityModelStore", "Lcom/onesignal/user/internal/identity/IdentityModelStore;", "_propertiesModelStore", "Lcom/onesignal/user/internal/properties/PropertiesModelStore;", "(Lcom/onesignal/user/internal/backend/ISubscriptionBackendService;Lcom/onesignal/user/internal/identity/IdentityModelStore;Lcom/onesignal/user/internal/properties/PropertiesModelStore;)V", "operations", "", "", "getOperations", "()Ljava/util/List;", "execute", "Lcom/onesignal/core/internal/operations/ExecutionResponse;", "Lcom/onesignal/core/internal/operations/Operation;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginUser", "loginUserOp", "Lcom/onesignal/user/internal/operations/LoginUserFromSubscriptionOperation;", "(Lcom/onesignal/user/internal/operations/LoginUserFromSubscriptionOperation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: LoginUserFromSubscriptionOperationExecutor.kt */
public final class LoginUserFromSubscriptionOperationExecutor implements IOperationExecutor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String LOGIN_USER_FROM_SUBSCRIPTION_USER = "login-user-from-subscription";
    private final IdentityModelStore _identityModelStore;
    private final PropertiesModelStore _propertiesModelStore;
    private final ISubscriptionBackendService _subscriptionBackend;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: LoginUserFromSubscriptionOperationExecutor.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NetworkUtils.ResponseStatusType.values().length];
            iArr[NetworkUtils.ResponseStatusType.RETRYABLE.ordinal()] = 1;
            iArr[NetworkUtils.ResponseStatusType.UNAUTHORIZED.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public LoginUserFromSubscriptionOperationExecutor(ISubscriptionBackendService iSubscriptionBackendService, IdentityModelStore identityModelStore, PropertiesModelStore propertiesModelStore) {
        Intrinsics.checkNotNullParameter(iSubscriptionBackendService, "_subscriptionBackend");
        Intrinsics.checkNotNullParameter(identityModelStore, "_identityModelStore");
        Intrinsics.checkNotNullParameter(propertiesModelStore, "_propertiesModelStore");
        this._subscriptionBackend = iSubscriptionBackendService;
        this._identityModelStore = identityModelStore;
        this._propertiesModelStore = propertiesModelStore;
    }

    public List<String> getOperations() {
        return CollectionsKt.listOf(LOGIN_USER_FROM_SUBSCRIPTION_USER);
    }

    public Object execute(List<? extends Operation> list, Continuation<? super ExecutionResponse> continuation) {
        Logging.debug$default("LoginUserFromSubscriptionOperationExecutor(operation: " + list + ')', (Throwable) null, 2, (Object) null);
        if (list.size() <= 1) {
            Operation operation = (Operation) CollectionsKt.first(list);
            if (operation instanceof LoginUserFromSubscriptionOperation) {
                return loginUser((LoginUserFromSubscriptionOperation) operation, continuation);
            }
            throw new Exception("Unrecognized operation: " + operation);
        }
        throw new Exception("Only supports one operation! Attempted operations:\n" + list);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006c A[Catch:{ BackendException -> 0x0106 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0093 A[Catch:{ BackendException -> 0x0106 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object loginUser(com.onesignal.user.internal.operations.LoginUserFromSubscriptionOperation r17, kotlin.coroutines.Continuation<? super com.onesignal.core.internal.operations.ExecutionResponse> r18) {
        /*
            r16 = this;
            r1 = r16
            r0 = r18
            java.lang.String r2 = "Subscription "
            boolean r3 = r0 instanceof com.onesignal.user.internal.operations.impl.executors.LoginUserFromSubscriptionOperationExecutor$loginUser$1
            if (r3 == 0) goto L_0x001a
            r3 = r0
            com.onesignal.user.internal.operations.impl.executors.LoginUserFromSubscriptionOperationExecutor$loginUser$1 r3 = (com.onesignal.user.internal.operations.impl.executors.LoginUserFromSubscriptionOperationExecutor$loginUser$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r0 = r3.label
            int r0 = r0 - r5
            r3.label = r0
            goto L_0x001f
        L_0x001a:
            com.onesignal.user.internal.operations.impl.executors.LoginUserFromSubscriptionOperationExecutor$loginUser$1 r3 = new com.onesignal.user.internal.operations.impl.executors.LoginUserFromSubscriptionOperationExecutor$loginUser$1
            r3.<init>(r1, r0)
        L_0x001f:
            java.lang.Object r0 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 2
            r7 = 1
            if (r5 == 0) goto L_0x0041
            if (r5 != r7) goto L_0x0039
            java.lang.Object r4 = r3.L$1
            com.onesignal.user.internal.operations.LoginUserFromSubscriptionOperation r4 = (com.onesignal.user.internal.operations.LoginUserFromSubscriptionOperation) r4
            java.lang.Object r3 = r3.L$0
            com.onesignal.user.internal.operations.impl.executors.LoginUserFromSubscriptionOperationExecutor r3 = (com.onesignal.user.internal.operations.impl.executors.LoginUserFromSubscriptionOperationExecutor) r3
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ BackendException -> 0x0106 }
            goto L_0x005f
        L_0x0039:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r0)
            com.onesignal.user.internal.backend.ISubscriptionBackendService r0 = r1._subscriptionBackend     // Catch:{ BackendException -> 0x0106 }
            java.lang.String r5 = r17.getAppId()     // Catch:{ BackendException -> 0x0106 }
            java.lang.String r8 = r17.getSubscriptionId()     // Catch:{ BackendException -> 0x0106 }
            r3.L$0 = r1     // Catch:{ BackendException -> 0x0106 }
            r9 = r17
            r3.L$1 = r9     // Catch:{ BackendException -> 0x0106 }
            r3.label = r7     // Catch:{ BackendException -> 0x0106 }
            java.lang.Object r0 = r0.getIdentityFromSubscription(r5, r8, r3)     // Catch:{ BackendException -> 0x0106 }
            if (r0 != r4) goto L_0x005d
            return r4
        L_0x005d:
            r3 = r1
            r4 = r9
        L_0x005f:
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ BackendException -> 0x0106 }
            java.lang.String r5 = "onesignal_id"
            r8 = 0
            java.lang.Object r0 = kotlin.io.path.PathTreeWalk$$ExternalSyntheticApiModelOutline0.m((java.util.Map) r0, (java.lang.Object) r5, (java.lang.Object) r8)     // Catch:{ BackendException -> 0x0106 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ BackendException -> 0x0106 }
            if (r0 != 0) goto L_0x0093
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ BackendException -> 0x0106 }
            r0.<init>(r2)     // Catch:{ BackendException -> 0x0106 }
            java.lang.String r2 = r4.getSubscriptionId()     // Catch:{ BackendException -> 0x0106 }
            r0.append(r2)     // Catch:{ BackendException -> 0x0106 }
            java.lang.String r2 = " has no onesignal_id!"
            r0.append(r2)     // Catch:{ BackendException -> 0x0106 }
            java.lang.String r0 = r0.toString()     // Catch:{ BackendException -> 0x0106 }
            com.onesignal.debug.internal.logging.Logging.warn$default(r0, r8, r6, r8)     // Catch:{ BackendException -> 0x0106 }
            com.onesignal.core.internal.operations.ExecutionResponse r0 = new com.onesignal.core.internal.operations.ExecutionResponse     // Catch:{ BackendException -> 0x0106 }
            com.onesignal.core.internal.operations.ExecutionResult r10 = com.onesignal.core.internal.operations.ExecutionResult.FAIL_NORETRY     // Catch:{ BackendException -> 0x0106 }
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 14
            r15 = 0
            r9 = r0
            r9.<init>(r10, r11, r12, r13, r14, r15)     // Catch:{ BackendException -> 0x0106 }
            return r0
        L_0x0093:
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap     // Catch:{ BackendException -> 0x0106 }
            r2.<init>()     // Catch:{ BackendException -> 0x0106 }
            java.util.Map r2 = (java.util.Map) r2     // Catch:{ BackendException -> 0x0106 }
            java.lang.String r5 = r4.getOnesignalId()     // Catch:{ BackendException -> 0x0106 }
            r2.put(r5, r0)     // Catch:{ BackendException -> 0x0106 }
            com.onesignal.user.internal.identity.IdentityModelStore r5 = r3._identityModelStore     // Catch:{ BackendException -> 0x0106 }
            com.onesignal.common.modeling.Model r5 = r5.getModel()     // Catch:{ BackendException -> 0x0106 }
            com.onesignal.user.internal.identity.IdentityModel r5 = (com.onesignal.user.internal.identity.IdentityModel) r5     // Catch:{ BackendException -> 0x0106 }
            com.onesignal.user.internal.properties.PropertiesModelStore r3 = r3._propertiesModelStore     // Catch:{ BackendException -> 0x0106 }
            com.onesignal.common.modeling.Model r3 = r3.getModel()     // Catch:{ BackendException -> 0x0106 }
            com.onesignal.user.internal.properties.PropertiesModel r3 = (com.onesignal.user.internal.properties.PropertiesModel) r3     // Catch:{ BackendException -> 0x0106 }
            java.lang.String r8 = r5.getOnesignalId()     // Catch:{ BackendException -> 0x0106 }
            java.lang.String r9 = r4.getOnesignalId()     // Catch:{ BackendException -> 0x0106 }
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)     // Catch:{ BackendException -> 0x0106 }
            if (r8 == 0) goto L_0x00ce
            r9 = r5
            com.onesignal.common.modeling.Model r9 = (com.onesignal.common.modeling.Model) r9     // Catch:{ BackendException -> 0x0106 }
            java.lang.String r10 = "onesignal_id"
            java.lang.String r12 = "HYDRATE"
            r13 = 0
            r14 = 8
            r15 = 0
            r11 = r0
            com.onesignal.common.modeling.Model.setStringProperty$default(r9, r10, r11, r12, r13, r14, r15)     // Catch:{ BackendException -> 0x0106 }
        L_0x00ce:
            java.lang.String r5 = r3.getOnesignalId()     // Catch:{ BackendException -> 0x0106 }
            java.lang.String r8 = r4.getOnesignalId()     // Catch:{ BackendException -> 0x0106 }
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r8)     // Catch:{ BackendException -> 0x0106 }
            if (r5 == 0) goto L_0x00eb
            r9 = r3
            com.onesignal.common.modeling.Model r9 = (com.onesignal.common.modeling.Model) r9     // Catch:{ BackendException -> 0x0106 }
            java.lang.String r10 = "onesignalId"
            java.lang.String r12 = "HYDRATE"
            r13 = 0
            r14 = 8
            r15 = 0
            r11 = r0
            com.onesignal.common.modeling.Model.setStringProperty$default(r9, r10, r11, r12, r13, r14, r15)     // Catch:{ BackendException -> 0x0106 }
        L_0x00eb:
            com.onesignal.core.internal.operations.ExecutionResponse r3 = new com.onesignal.core.internal.operations.ExecutionResponse     // Catch:{ BackendException -> 0x0106 }
            com.onesignal.core.internal.operations.ExecutionResult r9 = com.onesignal.core.internal.operations.ExecutionResult.SUCCESS     // Catch:{ BackendException -> 0x0106 }
            com.onesignal.user.internal.operations.RefreshUserOperation r5 = new com.onesignal.user.internal.operations.RefreshUserOperation     // Catch:{ BackendException -> 0x0106 }
            java.lang.String r4 = r4.getAppId()     // Catch:{ BackendException -> 0x0106 }
            r5.<init>(r4, r0)     // Catch:{ BackendException -> 0x0106 }
            java.util.List r11 = kotlin.collections.CollectionsKt.listOf(r5)     // Catch:{ BackendException -> 0x0106 }
            r12 = 0
            r13 = 8
            r14 = 0
            r8 = r3
            r10 = r2
            r8.<init>(r9, r10, r11, r12, r13, r14)     // Catch:{ BackendException -> 0x0106 }
            return r3
        L_0x0106:
            r0 = move-exception
            com.onesignal.common.NetworkUtils r2 = com.onesignal.common.NetworkUtils.INSTANCE
            int r0 = r0.getStatusCode()
            com.onesignal.common.NetworkUtils$ResponseStatusType r0 = r2.getResponseStatusType(r0)
            int[] r2 = com.onesignal.user.internal.operations.impl.executors.LoginUserFromSubscriptionOperationExecutor.WhenMappings.$EnumSwitchMapping$0
            int r0 = r0.ordinal()
            r0 = r2[r0]
            if (r0 == r7) goto L_0x013b
            if (r0 == r6) goto L_0x012c
            com.onesignal.core.internal.operations.ExecutionResponse r0 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r9 = com.onesignal.core.internal.operations.ExecutionResult.FAIL_NORETRY
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 14
            r14 = 0
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r13, r14)
            goto L_0x0149
        L_0x012c:
            com.onesignal.core.internal.operations.ExecutionResponse r0 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r3 = com.onesignal.core.internal.operations.ExecutionResult.FAIL_UNAUTHORIZED
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 14
            r8 = 0
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8)
            goto L_0x0149
        L_0x013b:
            com.onesignal.core.internal.operations.ExecutionResponse r0 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r10 = com.onesignal.core.internal.operations.ExecutionResult.FAIL_RETRY
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 14
            r15 = 0
            r9 = r0
            r9.<init>(r10, r11, r12, r13, r14, r15)
        L_0x0149:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.operations.impl.executors.LoginUserFromSubscriptionOperationExecutor.loginUser(com.onesignal.user.internal.operations.LoginUserFromSubscriptionOperation, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/onesignal/user/internal/operations/impl/executors/LoginUserFromSubscriptionOperationExecutor$Companion;", "", "()V", "LOGIN_USER_FROM_SUBSCRIPTION_USER", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: LoginUserFromSubscriptionOperationExecutor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
