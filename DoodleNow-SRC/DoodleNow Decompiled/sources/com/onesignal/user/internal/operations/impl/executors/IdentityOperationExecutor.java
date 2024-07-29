package com.onesignal.user.internal.operations.impl.executors;

import com.onesignal.common.NetworkUtils;
import com.onesignal.core.internal.operations.IOperationExecutor;
import com.onesignal.user.internal.backend.IIdentityBackendService;
import com.onesignal.user.internal.builduser.IRebuildUserService;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.operations.impl.states.NewRecordsState;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001f\u0010\u0010\u001a\u00020\u00112\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00120\fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lcom/onesignal/user/internal/operations/impl/executors/IdentityOperationExecutor;", "Lcom/onesignal/core/internal/operations/IOperationExecutor;", "_identityBackend", "Lcom/onesignal/user/internal/backend/IIdentityBackendService;", "_identityModelStore", "Lcom/onesignal/user/internal/identity/IdentityModelStore;", "_buildUserService", "Lcom/onesignal/user/internal/builduser/IRebuildUserService;", "_newRecordState", "Lcom/onesignal/user/internal/operations/impl/states/NewRecordsState;", "(Lcom/onesignal/user/internal/backend/IIdentityBackendService;Lcom/onesignal/user/internal/identity/IdentityModelStore;Lcom/onesignal/user/internal/builduser/IRebuildUserService;Lcom/onesignal/user/internal/operations/impl/states/NewRecordsState;)V", "operations", "", "", "getOperations", "()Ljava/util/List;", "execute", "Lcom/onesignal/core/internal/operations/ExecutionResponse;", "Lcom/onesignal/core/internal/operations/Operation;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: IdentityOperationExecutor.kt */
public final class IdentityOperationExecutor implements IOperationExecutor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DELETE_ALIAS = "delete-alias";
    public static final String SET_ALIAS = "set-alias";
    private final IRebuildUserService _buildUserService;
    private final IIdentityBackendService _identityBackend;
    private final IdentityModelStore _identityModelStore;
    private final NewRecordsState _newRecordState;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: IdentityOperationExecutor.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NetworkUtils.ResponseStatusType.values().length];
            iArr[NetworkUtils.ResponseStatusType.RETRYABLE.ordinal()] = 1;
            iArr[NetworkUtils.ResponseStatusType.INVALID.ordinal()] = 2;
            iArr[NetworkUtils.ResponseStatusType.CONFLICT.ordinal()] = 3;
            iArr[NetworkUtils.ResponseStatusType.UNAUTHORIZED.ordinal()] = 4;
            iArr[NetworkUtils.ResponseStatusType.MISSING.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public IdentityOperationExecutor(IIdentityBackendService iIdentityBackendService, IdentityModelStore identityModelStore, IRebuildUserService iRebuildUserService, NewRecordsState newRecordsState) {
        Intrinsics.checkNotNullParameter(iIdentityBackendService, "_identityBackend");
        Intrinsics.checkNotNullParameter(identityModelStore, "_identityModelStore");
        Intrinsics.checkNotNullParameter(iRebuildUserService, "_buildUserService");
        Intrinsics.checkNotNullParameter(newRecordsState, "_newRecordState");
        this._identityBackend = iIdentityBackendService;
        this._identityModelStore = identityModelStore;
        this._buildUserService = iRebuildUserService;
        this._newRecordState = newRecordsState;
    }

    public List<String> getOperations() {
        return CollectionsKt.listOf(SET_ALIAS, DELETE_ALIAS);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v51, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v32, resolved type: com.onesignal.user.internal.operations.impl.executors.IdentityOperationExecutor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v54, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v34, resolved type: com.onesignal.user.internal.operations.impl.executors.IdentityOperationExecutor} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x015d A[Catch:{ BackendException -> 0x005e }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0283 A[Catch:{ BackendException -> 0x0044 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object execute(java.util.List<? extends com.onesignal.core.internal.operations.Operation> r24, kotlin.coroutines.Continuation<? super com.onesignal.core.internal.operations.ExecutionResponse> r25) {
        /*
            r23 = this;
            r1 = r23
            r0 = r24
            r2 = r25
            boolean r3 = r2 instanceof com.onesignal.user.internal.operations.impl.executors.IdentityOperationExecutor$execute$1
            if (r3 == 0) goto L_0x001a
            r3 = r2
            com.onesignal.user.internal.operations.impl.executors.IdentityOperationExecutor$execute$1 r3 = (com.onesignal.user.internal.operations.impl.executors.IdentityOperationExecutor$execute$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001f
        L_0x001a:
            com.onesignal.user.internal.operations.impl.executors.IdentityOperationExecutor$execute$1 r3 = new com.onesignal.user.internal.operations.impl.executors.IdentityOperationExecutor$execute$1
            r3.<init>(r1, r2)
        L_0x001f:
            r9 = r3
            java.lang.Object r2 = r9.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r9.label
            r10 = 404(0x194, float:5.66E-43)
            r11 = 5
            r12 = 4
            r13 = 3
            r14 = 1
            r15 = 2
            if (r4 == 0) goto L_0x0061
            if (r4 == r14) goto L_0x004f
            if (r4 != r15) goto L_0x0047
            java.lang.Object r0 = r9.L$1
            r3 = r0
            com.onesignal.core.internal.operations.Operation r3 = (com.onesignal.core.internal.operations.Operation) r3
            java.lang.Object r0 = r9.L$0
            r4 = r0
            com.onesignal.user.internal.operations.impl.executors.IdentityOperationExecutor r4 = (com.onesignal.user.internal.operations.impl.executors.IdentityOperationExecutor) r4
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ BackendException -> 0x0044 }
            goto L_0x026a
        L_0x0044:
            r0 = move-exception
            goto L_0x02a2
        L_0x0047:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x004f:
            java.lang.Object r0 = r9.L$1
            r3 = r0
            com.onesignal.core.internal.operations.Operation r3 = (com.onesignal.core.internal.operations.Operation) r3
            java.lang.Object r0 = r9.L$0
            r4 = r0
            com.onesignal.user.internal.operations.impl.executors.IdentityOperationExecutor r4 = (com.onesignal.user.internal.operations.impl.executors.IdentityOperationExecutor) r4
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ BackendException -> 0x005e }
            goto L_0x0144
        L_0x005e:
            r0 = move-exception
            goto L_0x0181
        L_0x0061:
            kotlin.ResultKt.throwOnFailure(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "IdentityOperationExecutor(operations: "
            r2.<init>(r4)
            r2.append(r0)
            r4 = 41
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r4 = 0
            com.onesignal.debug.internal.logging.Logging.debug$default(r2, r4, r15, r4)
            r2 = r0
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            boolean r4 = r2 instanceof java.util.Collection
            if (r4 == 0) goto L_0x008c
            r5 = r2
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x008c
            goto L_0x00b9
        L_0x008c:
            java.util.Iterator r5 = r2.iterator()
        L_0x0090:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x00b9
            java.lang.Object r6 = r5.next()
            com.onesignal.core.internal.operations.Operation r6 = (com.onesignal.core.internal.operations.Operation) r6
            boolean r7 = r6 instanceof com.onesignal.user.internal.operations.SetAliasOperation
            if (r7 != 0) goto L_0x0090
            boolean r6 = r6 instanceof com.onesignal.user.internal.operations.DeleteAliasOperation
            if (r6 == 0) goto L_0x00a5
            goto L_0x0090
        L_0x00a5:
            java.lang.Exception r2 = new java.lang.Exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Unrecognized operation(s)! Attempted operations:\n"
            r3.<init>(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        L_0x00b9:
            if (r4 == 0) goto L_0x00c5
            r5 = r2
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x00c5
            goto L_0x0102
        L_0x00c5:
            java.util.Iterator r5 = r2.iterator()
        L_0x00c9:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0102
            java.lang.Object r6 = r5.next()
            com.onesignal.core.internal.operations.Operation r6 = (com.onesignal.core.internal.operations.Operation) r6
            boolean r6 = r6 instanceof com.onesignal.user.internal.operations.SetAliasOperation
            if (r6 == 0) goto L_0x00c9
            if (r4 == 0) goto L_0x00e5
            r4 = r2
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x00e5
            goto L_0x0102
        L_0x00e5:
            java.util.Iterator r2 = r2.iterator()
        L_0x00e9:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0102
            java.lang.Object r4 = r2.next()
            com.onesignal.core.internal.operations.Operation r4 = (com.onesignal.core.internal.operations.Operation) r4
            boolean r4 = r4 instanceof com.onesignal.user.internal.operations.DeleteAliasOperation
            if (r4 != 0) goto L_0x00fa
            goto L_0x00e9
        L_0x00fa:
            java.lang.Exception r0 = new java.lang.Exception
            java.lang.String r2 = "Can't process SetAliasOperation and DeleteAliasOperation at the same time."
            r0.<init>(r2)
            throw r0
        L_0x0102:
            java.lang.Object r0 = kotlin.collections.CollectionsKt.last(r24)
            r2 = r0
            com.onesignal.core.internal.operations.Operation r2 = (com.onesignal.core.internal.operations.Operation) r2
            boolean r0 = r2 instanceof com.onesignal.user.internal.operations.SetAliasOperation
            if (r0 == 0) goto L_0x023e
            com.onesignal.user.internal.backend.IIdentityBackendService r4 = r1._identityBackend     // Catch:{ BackendException -> 0x017e }
            r0 = r2
            com.onesignal.user.internal.operations.SetAliasOperation r0 = (com.onesignal.user.internal.operations.SetAliasOperation) r0     // Catch:{ BackendException -> 0x017e }
            java.lang.String r5 = r0.getAppId()     // Catch:{ BackendException -> 0x017e }
            java.lang.String r6 = "onesignal_id"
            r0 = r2
            com.onesignal.user.internal.operations.SetAliasOperation r0 = (com.onesignal.user.internal.operations.SetAliasOperation) r0     // Catch:{ BackendException -> 0x017e }
            java.lang.String r7 = r0.getOnesignalId()     // Catch:{ BackendException -> 0x017e }
            r0 = r2
            com.onesignal.user.internal.operations.SetAliasOperation r0 = (com.onesignal.user.internal.operations.SetAliasOperation) r0     // Catch:{ BackendException -> 0x017e }
            java.lang.String r0 = r0.getLabel()     // Catch:{ BackendException -> 0x017e }
            r8 = r2
            com.onesignal.user.internal.operations.SetAliasOperation r8 = (com.onesignal.user.internal.operations.SetAliasOperation) r8     // Catch:{ BackendException -> 0x017e }
            java.lang.String r8 = r8.getValue()     // Catch:{ BackendException -> 0x017e }
            kotlin.Pair r0 = kotlin.TuplesKt.to(r0, r8)     // Catch:{ BackendException -> 0x017e }
            java.util.Map r8 = kotlin.collections.MapsKt.mapOf(r0)     // Catch:{ BackendException -> 0x017e }
            r9.L$0 = r1     // Catch:{ BackendException -> 0x017e }
            r9.L$1 = r2     // Catch:{ BackendException -> 0x017e }
            r9.label = r14     // Catch:{ BackendException -> 0x017e }
            java.lang.Object r0 = r4.setAlias(r5, r6, r7, r8, r9)     // Catch:{ BackendException -> 0x017e }
            if (r0 != r3) goto L_0x0142
            return r3
        L_0x0142:
            r4 = r1
            r3 = r2
        L_0x0144:
            com.onesignal.user.internal.identity.IdentityModelStore r0 = r4._identityModelStore     // Catch:{ BackendException -> 0x005e }
            com.onesignal.common.modeling.Model r0 = r0.getModel()     // Catch:{ BackendException -> 0x005e }
            com.onesignal.user.internal.identity.IdentityModel r0 = (com.onesignal.user.internal.identity.IdentityModel) r0     // Catch:{ BackendException -> 0x005e }
            java.lang.String r0 = r0.getOnesignalId()     // Catch:{ BackendException -> 0x005e }
            r2 = r3
            com.onesignal.user.internal.operations.SetAliasOperation r2 = (com.onesignal.user.internal.operations.SetAliasOperation) r2     // Catch:{ BackendException -> 0x005e }
            java.lang.String r2 = r2.getOnesignalId()     // Catch:{ BackendException -> 0x005e }
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)     // Catch:{ BackendException -> 0x005e }
            if (r0 == 0) goto L_0x033b
            com.onesignal.user.internal.identity.IdentityModelStore r0 = r4._identityModelStore     // Catch:{ BackendException -> 0x005e }
            com.onesignal.common.modeling.Model r16 = r0.getModel()     // Catch:{ BackendException -> 0x005e }
            r0 = r3
            com.onesignal.user.internal.operations.SetAliasOperation r0 = (com.onesignal.user.internal.operations.SetAliasOperation) r0     // Catch:{ BackendException -> 0x005e }
            java.lang.String r17 = r0.getLabel()     // Catch:{ BackendException -> 0x005e }
            r0 = r3
            com.onesignal.user.internal.operations.SetAliasOperation r0 = (com.onesignal.user.internal.operations.SetAliasOperation) r0     // Catch:{ BackendException -> 0x005e }
            java.lang.String r18 = r0.getValue()     // Catch:{ BackendException -> 0x005e }
            java.lang.String r19 = "HYDRATE"
            r20 = 0
            r21 = 8
            r22 = 0
            com.onesignal.common.modeling.Model.setStringProperty$default(r16, r17, r18, r19, r20, r21, r22)     // Catch:{ BackendException -> 0x005e }
            goto L_0x033b
        L_0x017e:
            r0 = move-exception
            r4 = r1
            r3 = r2
        L_0x0181:
            com.onesignal.common.NetworkUtils r2 = com.onesignal.common.NetworkUtils.INSTANCE
            int r5 = r0.getStatusCode()
            com.onesignal.common.NetworkUtils$ResponseStatusType r2 = r2.getResponseStatusType(r5)
            int[] r5 = com.onesignal.user.internal.operations.impl.executors.IdentityOperationExecutor.WhenMappings.$EnumSwitchMapping$0
            int r2 = r2.ordinal()
            r2 = r5[r2]
            if (r2 == r14) goto L_0x022c
            if (r2 == r15) goto L_0x021d
            if (r2 == r13) goto L_0x020b
            if (r2 == r12) goto L_0x01fa
            if (r2 != r11) goto L_0x01f4
            int r2 = r0.getStatusCode()
            if (r2 != r10) goto L_0x01c3
            com.onesignal.user.internal.operations.impl.states.NewRecordsState r2 = r4._newRecordState
            r5 = r3
            com.onesignal.user.internal.operations.SetAliasOperation r5 = (com.onesignal.user.internal.operations.SetAliasOperation) r5
            java.lang.String r5 = r5.getOnesignalId()
            boolean r2 = r2.isInMissingRetryWindow(r5)
            if (r2 == 0) goto L_0x01c3
            com.onesignal.core.internal.operations.ExecutionResponse r2 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r6 = com.onesignal.core.internal.operations.ExecutionResult.FAIL_RETRY
            r7 = 0
            r8 = 0
            java.lang.Integer r9 = r0.getRetryAfterSeconds()
            r10 = 6
            r11 = 0
            r5 = r2
            r5.<init>(r6, r7, r8, r9, r10, r11)
            return r2
        L_0x01c3:
            com.onesignal.user.internal.builduser.IRebuildUserService r2 = r4._buildUserService
            com.onesignal.user.internal.operations.SetAliasOperation r3 = (com.onesignal.user.internal.operations.SetAliasOperation) r3
            java.lang.String r4 = r3.getAppId()
            java.lang.String r3 = r3.getOnesignalId()
            java.util.List r8 = r2.getRebuildOperationsIfCurrentUser(r4, r3)
            if (r8 != 0) goto L_0x01e4
            com.onesignal.core.internal.operations.ExecutionResponse r0 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r10 = com.onesignal.core.internal.operations.ExecutionResult.FAIL_NORETRY
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 14
            r15 = 0
            r9 = r0
            r9.<init>(r10, r11, r12, r13, r14, r15)
            return r0
        L_0x01e4:
            com.onesignal.core.internal.operations.ExecutionResponse r2 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r6 = com.onesignal.core.internal.operations.ExecutionResult.FAIL_RETRY
            r7 = 0
            java.lang.Integer r9 = r0.getRetryAfterSeconds()
            r10 = 2
            r11 = 0
            r5 = r2
            r5.<init>(r6, r7, r8, r9, r10, r11)
            return r2
        L_0x01f4:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x01fa:
            com.onesignal.core.internal.operations.ExecutionResponse r9 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r3 = com.onesignal.core.internal.operations.ExecutionResult.FAIL_UNAUTHORIZED
            r4 = 0
            r5 = 0
            java.lang.Integer r6 = r0.getRetryAfterSeconds()
            r7 = 6
            r8 = 0
            r2 = r9
            r2.<init>(r3, r4, r5, r6, r7, r8)
            goto L_0x023d
        L_0x020b:
            com.onesignal.core.internal.operations.ExecutionResponse r9 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r11 = com.onesignal.core.internal.operations.ExecutionResult.FAIL_CONFLICT
            r12 = 0
            r13 = 0
            java.lang.Integer r14 = r0.getRetryAfterSeconds()
            r15 = 6
            r16 = 0
            r10 = r9
            r10.<init>(r11, r12, r13, r14, r15, r16)
            goto L_0x023d
        L_0x021d:
            com.onesignal.core.internal.operations.ExecutionResponse r9 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r3 = com.onesignal.core.internal.operations.ExecutionResult.FAIL_NORETRY
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 14
            r8 = 0
            r2 = r9
            r2.<init>(r3, r4, r5, r6, r7, r8)
            goto L_0x023d
        L_0x022c:
            com.onesignal.core.internal.operations.ExecutionResponse r9 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r11 = com.onesignal.core.internal.operations.ExecutionResult.FAIL_RETRY
            r12 = 0
            r13 = 0
            java.lang.Integer r14 = r0.getRetryAfterSeconds()
            r15 = 6
            r16 = 0
            r10 = r9
            r10.<init>(r11, r12, r13, r14, r15, r16)
        L_0x023d:
            return r9
        L_0x023e:
            boolean r0 = r2 instanceof com.onesignal.user.internal.operations.DeleteAliasOperation
            if (r0 == 0) goto L_0x033b
            com.onesignal.user.internal.backend.IIdentityBackendService r4 = r1._identityBackend     // Catch:{ BackendException -> 0x029f }
            r0 = r2
            com.onesignal.user.internal.operations.DeleteAliasOperation r0 = (com.onesignal.user.internal.operations.DeleteAliasOperation) r0     // Catch:{ BackendException -> 0x029f }
            java.lang.String r5 = r0.getAppId()     // Catch:{ BackendException -> 0x029f }
            java.lang.String r6 = "onesignal_id"
            r0 = r2
            com.onesignal.user.internal.operations.DeleteAliasOperation r0 = (com.onesignal.user.internal.operations.DeleteAliasOperation) r0     // Catch:{ BackendException -> 0x029f }
            java.lang.String r7 = r0.getOnesignalId()     // Catch:{ BackendException -> 0x029f }
            r0 = r2
            com.onesignal.user.internal.operations.DeleteAliasOperation r0 = (com.onesignal.user.internal.operations.DeleteAliasOperation) r0     // Catch:{ BackendException -> 0x029f }
            java.lang.String r8 = r0.getLabel()     // Catch:{ BackendException -> 0x029f }
            r9.L$0 = r1     // Catch:{ BackendException -> 0x029f }
            r9.L$1 = r2     // Catch:{ BackendException -> 0x029f }
            r9.label = r15     // Catch:{ BackendException -> 0x029f }
            java.lang.Object r0 = r4.deleteAlias(r5, r6, r7, r8, r9)     // Catch:{ BackendException -> 0x029f }
            if (r0 != r3) goto L_0x0268
            return r3
        L_0x0268:
            r4 = r1
            r3 = r2
        L_0x026a:
            com.onesignal.user.internal.identity.IdentityModelStore r0 = r4._identityModelStore     // Catch:{ BackendException -> 0x0044 }
            com.onesignal.common.modeling.Model r0 = r0.getModel()     // Catch:{ BackendException -> 0x0044 }
            com.onesignal.user.internal.identity.IdentityModel r0 = (com.onesignal.user.internal.identity.IdentityModel) r0     // Catch:{ BackendException -> 0x0044 }
            java.lang.String r0 = r0.getOnesignalId()     // Catch:{ BackendException -> 0x0044 }
            r2 = r3
            com.onesignal.user.internal.operations.DeleteAliasOperation r2 = (com.onesignal.user.internal.operations.DeleteAliasOperation) r2     // Catch:{ BackendException -> 0x0044 }
            java.lang.String r2 = r2.getOnesignalId()     // Catch:{ BackendException -> 0x0044 }
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)     // Catch:{ BackendException -> 0x0044 }
            if (r0 == 0) goto L_0x033b
            com.onesignal.user.internal.identity.IdentityModelStore r0 = r4._identityModelStore     // Catch:{ BackendException -> 0x0044 }
            com.onesignal.common.modeling.Model r16 = r0.getModel()     // Catch:{ BackendException -> 0x0044 }
            r0 = r3
            com.onesignal.user.internal.operations.DeleteAliasOperation r0 = (com.onesignal.user.internal.operations.DeleteAliasOperation) r0     // Catch:{ BackendException -> 0x0044 }
            java.lang.String r17 = r0.getLabel()     // Catch:{ BackendException -> 0x0044 }
            r18 = 0
            java.lang.String r19 = "HYDRATE"
            r20 = 0
            r21 = 8
            r22 = 0
            com.onesignal.common.modeling.Model.setOptStringProperty$default(r16, r17, r18, r19, r20, r21, r22)     // Catch:{ BackendException -> 0x0044 }
            goto L_0x033b
        L_0x029f:
            r0 = move-exception
            r4 = r1
            r3 = r2
        L_0x02a2:
            com.onesignal.common.NetworkUtils r2 = com.onesignal.common.NetworkUtils.INSTANCE
            int r5 = r0.getStatusCode()
            com.onesignal.common.NetworkUtils$ResponseStatusType r2 = r2.getResponseStatusType(r5)
            int[] r5 = com.onesignal.user.internal.operations.impl.executors.IdentityOperationExecutor.WhenMappings.$EnumSwitchMapping$0
            int r2 = r2.ordinal()
            r2 = r5[r2]
            if (r2 == r14) goto L_0x0329
            if (r2 == r15) goto L_0x031a
            if (r2 == r13) goto L_0x030a
            if (r2 == r12) goto L_0x02f9
            if (r2 != r11) goto L_0x02f3
            int r2 = r0.getStatusCode()
            if (r2 != r10) goto L_0x02e3
            com.onesignal.user.internal.operations.impl.states.NewRecordsState r2 = r4._newRecordState
            com.onesignal.user.internal.operations.DeleteAliasOperation r3 = (com.onesignal.user.internal.operations.DeleteAliasOperation) r3
            java.lang.String r3 = r3.getOnesignalId()
            boolean r2 = r2.isInMissingRetryWindow(r3)
            if (r2 == 0) goto L_0x02e3
            com.onesignal.core.internal.operations.ExecutionResponse r2 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r4 = com.onesignal.core.internal.operations.ExecutionResult.FAIL_RETRY
            r5 = 0
            r6 = 0
            java.lang.Integer r7 = r0.getRetryAfterSeconds()
            r8 = 6
            r9 = 0
            r3 = r2
            r3.<init>(r4, r5, r6, r7, r8, r9)
            goto L_0x02f2
        L_0x02e3:
            com.onesignal.core.internal.operations.ExecutionResponse r2 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r11 = com.onesignal.core.internal.operations.ExecutionResult.SUCCESS
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 14
            r16 = 0
            r10 = r2
            r10.<init>(r11, r12, r13, r14, r15, r16)
        L_0x02f2:
            return r2
        L_0x02f3:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x02f9:
            com.onesignal.core.internal.operations.ExecutionResponse r9 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r3 = com.onesignal.core.internal.operations.ExecutionResult.FAIL_UNAUTHORIZED
            r4 = 0
            r5 = 0
            java.lang.Integer r6 = r0.getRetryAfterSeconds()
            r7 = 6
            r8 = 0
            r2 = r9
            r2.<init>(r3, r4, r5, r6, r7, r8)
            goto L_0x033a
        L_0x030a:
            com.onesignal.core.internal.operations.ExecutionResponse r9 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r11 = com.onesignal.core.internal.operations.ExecutionResult.SUCCESS
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 14
            r16 = 0
            r10 = r9
            r10.<init>(r11, r12, r13, r14, r15, r16)
            goto L_0x033a
        L_0x031a:
            com.onesignal.core.internal.operations.ExecutionResponse r9 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r3 = com.onesignal.core.internal.operations.ExecutionResult.FAIL_NORETRY
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 14
            r8 = 0
            r2 = r9
            r2.<init>(r3, r4, r5, r6, r7, r8)
            goto L_0x033a
        L_0x0329:
            com.onesignal.core.internal.operations.ExecutionResponse r9 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r11 = com.onesignal.core.internal.operations.ExecutionResult.FAIL_RETRY
            r12 = 0
            r13 = 0
            java.lang.Integer r14 = r0.getRetryAfterSeconds()
            r15 = 6
            r16 = 0
            r10 = r9
            r10.<init>(r11, r12, r13, r14, r15, r16)
        L_0x033a:
            return r9
        L_0x033b:
            com.onesignal.core.internal.operations.ExecutionResponse r0 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r3 = com.onesignal.core.internal.operations.ExecutionResult.SUCCESS
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 14
            r8 = 0
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.operations.impl.executors.IdentityOperationExecutor.execute(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/onesignal/user/internal/operations/impl/executors/IdentityOperationExecutor$Companion;", "", "()V", "DELETE_ALIAS", "", "SET_ALIAS", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: IdentityOperationExecutor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
