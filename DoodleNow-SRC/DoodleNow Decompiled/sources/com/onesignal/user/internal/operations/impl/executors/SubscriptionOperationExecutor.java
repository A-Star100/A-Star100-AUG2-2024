package com.onesignal.user.internal.operations.impl.executors;

import com.onesignal.common.NetworkUtils;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.device.IDeviceService;
import com.onesignal.core.internal.operations.ExecutionResponse;
import com.onesignal.core.internal.operations.IOperationExecutor;
import com.onesignal.core.internal.operations.Operation;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.user.internal.backend.ISubscriptionBackendService;
import com.onesignal.user.internal.backend.SubscriptionObjectType;
import com.onesignal.user.internal.builduser.IRebuildUserService;
import com.onesignal.user.internal.operations.CreateSubscriptionOperation;
import com.onesignal.user.internal.operations.DeleteSubscriptionOperation;
import com.onesignal.user.internal.operations.TransferSubscriptionOperation;
import com.onesignal.user.internal.operations.UpdateSubscriptionOperation;
import com.onesignal.user.internal.operations.impl.states.NewRecordsState;
import com.onesignal.user.internal.subscriptions.SubscriptionModelStore;
import com.onesignal.user.internal.subscriptions.SubscriptionType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 -2\u00020\u0001:\u0001-B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J'\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ\u0019\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"H@ø\u0001\u0000¢\u0006\u0002\u0010#J\u001f\u0010$\u001a\u00020\u001b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010%J\u0019\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020(H@ø\u0001\u0000¢\u0006\u0002\u0010)J'\u0010*\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020+2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010,R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u0002\u0004\n\u0002\b\u0019¨\u0006."}, d2 = {"Lcom/onesignal/user/internal/operations/impl/executors/SubscriptionOperationExecutor;", "Lcom/onesignal/core/internal/operations/IOperationExecutor;", "_subscriptionBackend", "Lcom/onesignal/user/internal/backend/ISubscriptionBackendService;", "_deviceService", "Lcom/onesignal/core/internal/device/IDeviceService;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_subscriptionModelStore", "Lcom/onesignal/user/internal/subscriptions/SubscriptionModelStore;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_buildUserService", "Lcom/onesignal/user/internal/builduser/IRebuildUserService;", "_newRecordState", "Lcom/onesignal/user/internal/operations/impl/states/NewRecordsState;", "(Lcom/onesignal/user/internal/backend/ISubscriptionBackendService;Lcom/onesignal/core/internal/device/IDeviceService;Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/user/internal/subscriptions/SubscriptionModelStore;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/user/internal/builduser/IRebuildUserService;Lcom/onesignal/user/internal/operations/impl/states/NewRecordsState;)V", "operations", "", "", "getOperations", "()Ljava/util/List;", "convert", "Lcom/onesignal/user/internal/backend/SubscriptionObjectType;", "subscriptionType", "Lcom/onesignal/user/internal/subscriptions/SubscriptionType;", "createSubscription", "Lcom/onesignal/core/internal/operations/ExecutionResponse;", "createOperation", "Lcom/onesignal/user/internal/operations/CreateSubscriptionOperation;", "Lcom/onesignal/core/internal/operations/Operation;", "(Lcom/onesignal/user/internal/operations/CreateSubscriptionOperation;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSubscription", "op", "Lcom/onesignal/user/internal/operations/DeleteSubscriptionOperation;", "(Lcom/onesignal/user/internal/operations/DeleteSubscriptionOperation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "execute", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transferSubscription", "startingOperation", "Lcom/onesignal/user/internal/operations/TransferSubscriptionOperation;", "(Lcom/onesignal/user/internal/operations/TransferSubscriptionOperation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSubscription", "Lcom/onesignal/user/internal/operations/UpdateSubscriptionOperation;", "(Lcom/onesignal/user/internal/operations/UpdateSubscriptionOperation;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SubscriptionOperationExecutor.kt */
public final class SubscriptionOperationExecutor implements IOperationExecutor {
    public static final String CREATE_SUBSCRIPTION = "create-subscription";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DELETE_SUBSCRIPTION = "delete-subscription";
    public static final String TRANSFER_SUBSCRIPTION = "transfer-subscription";
    public static final String UPDATE_SUBSCRIPTION = "update-subscription";
    private final IApplicationService _applicationService;
    private final IRebuildUserService _buildUserService;
    private final ConfigModelStore _configModelStore;
    private final IDeviceService _deviceService;
    private final NewRecordsState _newRecordState;
    private final ISubscriptionBackendService _subscriptionBackend;
    private final SubscriptionModelStore _subscriptionModelStore;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SubscriptionOperationExecutor.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[NetworkUtils.ResponseStatusType.values().length];
            iArr[NetworkUtils.ResponseStatusType.RETRYABLE.ordinal()] = 1;
            iArr[NetworkUtils.ResponseStatusType.CONFLICT.ordinal()] = 2;
            iArr[NetworkUtils.ResponseStatusType.INVALID.ordinal()] = 3;
            iArr[NetworkUtils.ResponseStatusType.UNAUTHORIZED.ordinal()] = 4;
            iArr[NetworkUtils.ResponseStatusType.MISSING.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[SubscriptionType.values().length];
            iArr2[SubscriptionType.SMS.ordinal()] = 1;
            iArr2[SubscriptionType.EMAIL.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public SubscriptionOperationExecutor(ISubscriptionBackendService iSubscriptionBackendService, IDeviceService iDeviceService, IApplicationService iApplicationService, SubscriptionModelStore subscriptionModelStore, ConfigModelStore configModelStore, IRebuildUserService iRebuildUserService, NewRecordsState newRecordsState) {
        Intrinsics.checkNotNullParameter(iSubscriptionBackendService, "_subscriptionBackend");
        Intrinsics.checkNotNullParameter(iDeviceService, "_deviceService");
        Intrinsics.checkNotNullParameter(iApplicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(subscriptionModelStore, "_subscriptionModelStore");
        Intrinsics.checkNotNullParameter(configModelStore, "_configModelStore");
        Intrinsics.checkNotNullParameter(iRebuildUserService, "_buildUserService");
        Intrinsics.checkNotNullParameter(newRecordsState, "_newRecordState");
        this._subscriptionBackend = iSubscriptionBackendService;
        this._deviceService = iDeviceService;
        this._applicationService = iApplicationService;
        this._subscriptionModelStore = subscriptionModelStore;
        this._configModelStore = configModelStore;
        this._buildUserService = iRebuildUserService;
        this._newRecordState = newRecordsState;
    }

    public List<String> getOperations() {
        return CollectionsKt.listOf(CREATE_SUBSCRIPTION, UPDATE_SUBSCRIPTION, DELETE_SUBSCRIPTION, TRANSFER_SUBSCRIPTION);
    }

    public Object execute(List<? extends Operation> list, Continuation<? super ExecutionResponse> continuation) {
        LogLevel logLevel = LogLevel.DEBUG;
        Logging.log(logLevel, "SubscriptionOperationExecutor(operations: " + list + ')');
        Operation operation = (Operation) CollectionsKt.first(list);
        if (operation instanceof CreateSubscriptionOperation) {
            return createSubscription((CreateSubscriptionOperation) operation, list, continuation);
        }
        Iterable<Operation> iterable = list;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            for (Operation operation2 : iterable) {
                if (operation2 instanceof DeleteSubscriptionOperation) {
                    if (list.size() <= 1) {
                        Collection arrayList = new ArrayList();
                        for (Object next : iterable) {
                            if (next instanceof DeleteSubscriptionOperation) {
                                arrayList.add(next);
                            }
                        }
                        return deleteSubscription((DeleteSubscriptionOperation) CollectionsKt.first((List) arrayList), continuation);
                    }
                    throw new Exception("Only supports one operation! Attempted operations:\n" + list);
                }
            }
        }
        if (operation instanceof UpdateSubscriptionOperation) {
            return updateSubscription((UpdateSubscriptionOperation) operation, list, continuation);
        }
        if (!(operation instanceof TransferSubscriptionOperation)) {
            throw new Exception("Unrecognized operation: " + operation);
        } else if (list.size() <= 1) {
            return transferSubscription((TransferSubscriptionOperation) operation, continuation);
        } else {
            throw new Exception("TransferSubscriptionOperation only supports one operation! Attempted operations:\n" + list);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v25, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v25, resolved type: com.onesignal.user.internal.operations.CreateSubscriptionOperation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v26, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v24, resolved type: com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0132 A[Catch:{ BackendException -> 0x019c }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0142 A[Catch:{ BackendException -> 0x019c }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x023f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object createSubscription(com.onesignal.user.internal.operations.CreateSubscriptionOperation r25, java.util.List<? extends com.onesignal.core.internal.operations.Operation> r26, kotlin.coroutines.Continuation<? super com.onesignal.core.internal.operations.ExecutionResponse> r27) {
        /*
            r24 = this;
            r1 = r24
            r0 = r26
            r2 = r27
            boolean r3 = r2 instanceof com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor$createSubscription$1
            if (r3 == 0) goto L_0x001a
            r3 = r2
            com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor$createSubscription$1 r3 = (com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor$createSubscription$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001f
        L_0x001a:
            com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor$createSubscription$1 r3 = new com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor$createSubscription$1
            r3.<init>(r1, r2)
        L_0x001f:
            r9 = r3
            java.lang.Object r2 = r9.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r9.label
            r10 = 1
            if (r4 == 0) goto L_0x004a
            if (r4 != r10) goto L_0x0042
            java.lang.Object r0 = r9.L$1
            r3 = r0
            com.onesignal.user.internal.operations.CreateSubscriptionOperation r3 = (com.onesignal.user.internal.operations.CreateSubscriptionOperation) r3
            java.lang.Object r0 = r9.L$0
            r4 = r0
            com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor r4 = (com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor) r4
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ BackendException -> 0x003e }
            r0 = r2
            r2 = r3
            goto L_0x012e
        L_0x003e:
            r0 = move-exception
            r2 = r3
            goto L_0x01a4
        L_0x0042:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x004a:
            kotlin.ResultKt.throwOnFailure(r2)
            r2 = r0
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            boolean r4 = r2 instanceof java.util.Collection
            if (r4 == 0) goto L_0x005e
            r4 = r2
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x005e
            goto L_0x0082
        L_0x005e:
            java.util.Iterator r2 = r2.iterator()
        L_0x0062:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0082
            java.lang.Object r4 = r2.next()
            com.onesignal.core.internal.operations.Operation r4 = (com.onesignal.core.internal.operations.Operation) r4
            boolean r4 = r4 instanceof com.onesignal.user.internal.operations.DeleteSubscriptionOperation
            if (r4 == 0) goto L_0x0062
            com.onesignal.core.internal.operations.ExecutionResponse r0 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r12 = com.onesignal.core.internal.operations.ExecutionResult.SUCCESS
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 14
            r17 = 0
            r11 = r0
            r11.<init>(r12, r13, r14, r15, r16, r17)
            return r0
        L_0x0082:
            int r2 = r26.size()
            java.util.ListIterator r0 = r0.listIterator(r2)
        L_0x008a:
            boolean r2 = r0.hasPrevious()
            if (r2 == 0) goto L_0x009c
            java.lang.Object r2 = r0.previous()
            r4 = r2
            com.onesignal.core.internal.operations.Operation r4 = (com.onesignal.core.internal.operations.Operation) r4
            boolean r4 = r4 instanceof com.onesignal.user.internal.operations.UpdateSubscriptionOperation
            if (r4 == 0) goto L_0x008a
            goto L_0x009d
        L_0x009c:
            r2 = 0
        L_0x009d:
            com.onesignal.user.internal.operations.UpdateSubscriptionOperation r2 = (com.onesignal.user.internal.operations.UpdateSubscriptionOperation) r2
            if (r2 == 0) goto L_0x00a6
            boolean r0 = r2.getEnabled()
            goto L_0x00aa
        L_0x00a6:
            boolean r0 = r25.getEnabled()
        L_0x00aa:
            if (r2 == 0) goto L_0x00b2
            java.lang.String r4 = r2.getAddress()
            if (r4 != 0) goto L_0x00b6
        L_0x00b2:
            java.lang.String r4 = r25.getAddress()
        L_0x00b6:
            r14 = r4
            if (r2 == 0) goto L_0x00bf
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r2 = r2.getStatus()
            if (r2 != 0) goto L_0x00c3
        L_0x00bf:
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r2 = r25.getStatus()
        L_0x00c3:
            com.onesignal.user.internal.backend.SubscriptionObject r8 = new com.onesignal.user.internal.backend.SubscriptionObject     // Catch:{ BackendException -> 0x01a0 }
            r12 = 0
            com.onesignal.user.internal.subscriptions.SubscriptionType r4 = r25.getType()     // Catch:{ BackendException -> 0x01a0 }
            com.onesignal.user.internal.backend.SubscriptionObjectType r13 = r1.convert(r4)     // Catch:{ BackendException -> 0x01a0 }
            java.lang.Boolean r15 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)     // Catch:{ BackendException -> 0x01a0 }
            int r0 = r2.getValue()     // Catch:{ BackendException -> 0x01a0 }
            java.lang.Integer r16 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r0)     // Catch:{ BackendException -> 0x01a0 }
            java.lang.String r17 = "050115"
            java.lang.String r18 = android.os.Build.MODEL     // Catch:{ BackendException -> 0x01a0 }
            java.lang.String r19 = android.os.Build.VERSION.RELEASE     // Catch:{ BackendException -> 0x01a0 }
            com.onesignal.common.RootToolsInternalMethods r0 = com.onesignal.common.RootToolsInternalMethods.INSTANCE     // Catch:{ BackendException -> 0x01a0 }
            boolean r0 = r0.isRooted()     // Catch:{ BackendException -> 0x01a0 }
            java.lang.Boolean r20 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)     // Catch:{ BackendException -> 0x01a0 }
            com.onesignal.common.DeviceUtils r0 = com.onesignal.common.DeviceUtils.INSTANCE     // Catch:{ BackendException -> 0x01a0 }
            com.onesignal.core.internal.application.IApplicationService r2 = r1._applicationService     // Catch:{ BackendException -> 0x01a0 }
            android.content.Context r2 = r2.getAppContext()     // Catch:{ BackendException -> 0x01a0 }
            java.lang.Integer r21 = r0.getNetType(r2)     // Catch:{ BackendException -> 0x01a0 }
            com.onesignal.common.DeviceUtils r0 = com.onesignal.common.DeviceUtils.INSTANCE     // Catch:{ BackendException -> 0x01a0 }
            com.onesignal.core.internal.application.IApplicationService r2 = r1._applicationService     // Catch:{ BackendException -> 0x01a0 }
            android.content.Context r2 = r2.getAppContext()     // Catch:{ BackendException -> 0x01a0 }
            java.lang.String r22 = r0.getCarrierName(r2)     // Catch:{ BackendException -> 0x01a0 }
            com.onesignal.common.AndroidUtils r0 = com.onesignal.common.AndroidUtils.INSTANCE     // Catch:{ BackendException -> 0x01a0 }
            com.onesignal.core.internal.application.IApplicationService r2 = r1._applicationService     // Catch:{ BackendException -> 0x01a0 }
            android.content.Context r2 = r2.getAppContext()     // Catch:{ BackendException -> 0x01a0 }
            java.lang.String r23 = r0.getAppVersion(r2)     // Catch:{ BackendException -> 0x01a0 }
            r11 = r8
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)     // Catch:{ BackendException -> 0x01a0 }
            com.onesignal.user.internal.backend.ISubscriptionBackendService r4 = r1._subscriptionBackend     // Catch:{ BackendException -> 0x01a0 }
            java.lang.String r5 = r25.getAppId()     // Catch:{ BackendException -> 0x01a0 }
            java.lang.String r6 = "onesignal_id"
            java.lang.String r7 = r25.getOnesignalId()     // Catch:{ BackendException -> 0x01a0 }
            r9.L$0 = r1     // Catch:{ BackendException -> 0x01a0 }
            r2 = r25
            r9.L$1 = r2     // Catch:{ BackendException -> 0x019e }
            r9.label = r10     // Catch:{ BackendException -> 0x019e }
            java.lang.Object r0 = r4.createSubscription(r5, r6, r7, r8, r9)     // Catch:{ BackendException -> 0x019e }
            if (r0 != r3) goto L_0x012d
            return r3
        L_0x012d:
            r4 = r1
        L_0x012e:
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ BackendException -> 0x019c }
            if (r0 != 0) goto L_0x0142
            com.onesignal.core.internal.operations.ExecutionResponse r0 = new com.onesignal.core.internal.operations.ExecutionResponse     // Catch:{ BackendException -> 0x019c }
            com.onesignal.core.internal.operations.ExecutionResult r12 = com.onesignal.core.internal.operations.ExecutionResult.SUCCESS     // Catch:{ BackendException -> 0x019c }
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 14
            r17 = 0
            r11 = r0
            r11.<init>(r12, r13, r14, r15, r16, r17)     // Catch:{ BackendException -> 0x019c }
            return r0
        L_0x0142:
            com.onesignal.user.internal.subscriptions.SubscriptionModelStore r3 = r4._subscriptionModelStore     // Catch:{ BackendException -> 0x019c }
            java.lang.String r5 = r2.getSubscriptionId()     // Catch:{ BackendException -> 0x019c }
            com.onesignal.common.modeling.Model r3 = r3.get(r5)     // Catch:{ BackendException -> 0x019c }
            com.onesignal.user.internal.subscriptions.SubscriptionModel r3 = (com.onesignal.user.internal.subscriptions.SubscriptionModel) r3     // Catch:{ BackendException -> 0x019c }
            if (r3 == 0) goto L_0x0160
            r11 = r3
            com.onesignal.common.modeling.Model r11 = (com.onesignal.common.modeling.Model) r11     // Catch:{ BackendException -> 0x019c }
            java.lang.String r12 = "id"
            java.lang.String r14 = "HYDRATE"
            r15 = 0
            r16 = 8
            r17 = 0
            r13 = r0
            com.onesignal.common.modeling.Model.setStringProperty$default(r11, r12, r13, r14, r15, r16, r17)     // Catch:{ BackendException -> 0x019c }
        L_0x0160:
            com.onesignal.core.internal.config.ConfigModelStore r3 = r4._configModelStore     // Catch:{ BackendException -> 0x019c }
            com.onesignal.common.modeling.Model r3 = r3.getModel()     // Catch:{ BackendException -> 0x019c }
            com.onesignal.core.internal.config.ConfigModel r3 = (com.onesignal.core.internal.config.ConfigModel) r3     // Catch:{ BackendException -> 0x019c }
            java.lang.String r3 = r3.getPushSubscriptionId()     // Catch:{ BackendException -> 0x019c }
            java.lang.String r5 = r2.getSubscriptionId()     // Catch:{ BackendException -> 0x019c }
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)     // Catch:{ BackendException -> 0x019c }
            if (r3 == 0) goto L_0x0181
            com.onesignal.core.internal.config.ConfigModelStore r3 = r4._configModelStore     // Catch:{ BackendException -> 0x019c }
            com.onesignal.common.modeling.Model r3 = r3.getModel()     // Catch:{ BackendException -> 0x019c }
            com.onesignal.core.internal.config.ConfigModel r3 = (com.onesignal.core.internal.config.ConfigModel) r3     // Catch:{ BackendException -> 0x019c }
            r3.setPushSubscriptionId(r0)     // Catch:{ BackendException -> 0x019c }
        L_0x0181:
            com.onesignal.core.internal.operations.ExecutionResponse r3 = new com.onesignal.core.internal.operations.ExecutionResponse     // Catch:{ BackendException -> 0x019c }
            com.onesignal.core.internal.operations.ExecutionResult r12 = com.onesignal.core.internal.operations.ExecutionResult.SUCCESS     // Catch:{ BackendException -> 0x019c }
            java.lang.String r5 = r2.getSubscriptionId()     // Catch:{ BackendException -> 0x019c }
            kotlin.Pair r0 = kotlin.TuplesKt.to(r5, r0)     // Catch:{ BackendException -> 0x019c }
            java.util.Map r13 = kotlin.collections.MapsKt.mapOf(r0)     // Catch:{ BackendException -> 0x019c }
            r14 = 0
            r15 = 0
            r16 = 12
            r17 = 0
            r11 = r3
            r11.<init>(r12, r13, r14, r15, r16, r17)     // Catch:{ BackendException -> 0x019c }
            return r3
        L_0x019c:
            r0 = move-exception
            goto L_0x01a4
        L_0x019e:
            r0 = move-exception
            goto L_0x01a3
        L_0x01a0:
            r0 = move-exception
            r2 = r25
        L_0x01a3:
            r4 = r1
        L_0x01a4:
            com.onesignal.common.NetworkUtils r3 = com.onesignal.common.NetworkUtils.INSTANCE
            int r5 = r0.getStatusCode()
            com.onesignal.common.NetworkUtils$ResponseStatusType r3 = r3.getResponseStatusType(r5)
            int[] r5 = com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor.WhenMappings.$EnumSwitchMapping$0
            int r3 = r3.ordinal()
            r3 = r5[r3]
            if (r3 == r10) goto L_0x023f
            r5 = 2
            if (r3 == r5) goto L_0x022f
            r5 = 3
            if (r3 == r5) goto L_0x022f
            r5 = 4
            if (r3 == r5) goto L_0x021e
            r5 = 5
            if (r3 != r5) goto L_0x0218
            int r3 = r0.getStatusCode()
            r5 = 404(0x194, float:5.66E-43)
            if (r3 != r5) goto L_0x01e9
            com.onesignal.user.internal.operations.impl.states.NewRecordsState r3 = r4._newRecordState
            java.lang.String r5 = r2.getOnesignalId()
            boolean r3 = r3.isInMissingRetryWindow(r5)
            if (r3 == 0) goto L_0x01e9
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
        L_0x01e9:
            com.onesignal.user.internal.builduser.IRebuildUserService r3 = r4._buildUserService
            java.lang.String r4 = r2.getAppId()
            java.lang.String r2 = r2.getOnesignalId()
            java.util.List r8 = r3.getRebuildOperationsIfCurrentUser(r4, r2)
            if (r8 != 0) goto L_0x0208
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
        L_0x0208:
            com.onesignal.core.internal.operations.ExecutionResponse r2 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r6 = com.onesignal.core.internal.operations.ExecutionResult.FAIL_RETRY
            r7 = 0
            java.lang.Integer r9 = r0.getRetryAfterSeconds()
            r10 = 2
            r11 = 0
            r5 = r2
            r5.<init>(r6, r7, r8, r9, r10, r11)
            return r2
        L_0x0218:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x021e:
            com.onesignal.core.internal.operations.ExecutionResponse r9 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r3 = com.onesignal.core.internal.operations.ExecutionResult.FAIL_UNAUTHORIZED
            r4 = 0
            r5 = 0
            java.lang.Integer r6 = r0.getRetryAfterSeconds()
            r7 = 6
            r8 = 0
            r2 = r9
            r2.<init>(r3, r4, r5, r6, r7, r8)
            goto L_0x024f
        L_0x022f:
            com.onesignal.core.internal.operations.ExecutionResponse r9 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r11 = com.onesignal.core.internal.operations.ExecutionResult.FAIL_NORETRY
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 14
            r16 = 0
            r10 = r9
            r10.<init>(r11, r12, r13, r14, r15, r16)
            goto L_0x024f
        L_0x023f:
            com.onesignal.core.internal.operations.ExecutionResponse r9 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r3 = com.onesignal.core.internal.operations.ExecutionResult.FAIL_RETRY
            r4 = 0
            r5 = 0
            java.lang.Integer r6 = r0.getRetryAfterSeconds()
            r7 = 6
            r8 = 0
            r2 = r9
            r2.<init>(r3, r4, r5, r6, r7, r8)
        L_0x024f:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor.createSubscription(com.onesignal.user.internal.operations.CreateSubscriptionOperation, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v15, resolved type: com.onesignal.user.internal.operations.UpdateSubscriptionOperation} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object updateSubscription(com.onesignal.user.internal.operations.UpdateSubscriptionOperation r21, java.util.List<? extends com.onesignal.core.internal.operations.Operation> r22, kotlin.coroutines.Continuation<? super com.onesignal.core.internal.operations.ExecutionResponse> r23) {
        /*
            r20 = this;
            r1 = r20
            r0 = r23
            boolean r2 = r0 instanceof com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor$updateSubscription$1
            if (r2 == 0) goto L_0x0018
            r2 = r0
            com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor$updateSubscription$1 r2 = (com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor$updateSubscription$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r0 = r2.label
            int r0 = r0 - r4
            r2.label = r0
            goto L_0x001d
        L_0x0018:
            com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor$updateSubscription$1 r2 = new com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor$updateSubscription$1
            r2.<init>(r1, r0)
        L_0x001d:
            java.lang.Object r0 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            if (r4 == 0) goto L_0x0042
            if (r4 != r5) goto L_0x003a
            java.lang.Object r3 = r2.L$1
            com.onesignal.user.internal.operations.UpdateSubscriptionOperation r3 = (com.onesignal.user.internal.operations.UpdateSubscriptionOperation) r3
            java.lang.Object r2 = r2.L$0
            com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor r2 = (com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor) r2
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ BackendException -> 0x0037 }
            goto L_0x00c4
        L_0x0037:
            r0 = move-exception
            goto L_0x00d6
        L_0x003a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0042:
            kotlin.ResultKt.throwOnFailure(r0)
            java.lang.Object r0 = kotlin.collections.CollectionsKt.last(r22)
            java.lang.String r4 = "null cannot be cast to non-null type com.onesignal.user.internal.operations.UpdateSubscriptionOperation"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r4)
            r4 = r0
            com.onesignal.user.internal.operations.UpdateSubscriptionOperation r4 = (com.onesignal.user.internal.operations.UpdateSubscriptionOperation) r4
            com.onesignal.user.internal.backend.SubscriptionObject r0 = new com.onesignal.user.internal.backend.SubscriptionObject     // Catch:{ BackendException -> 0x00d3 }
            r7 = 0
            com.onesignal.user.internal.subscriptions.SubscriptionType r6 = r4.getType()     // Catch:{ BackendException -> 0x00d3 }
            com.onesignal.user.internal.backend.SubscriptionObjectType r8 = r1.convert(r6)     // Catch:{ BackendException -> 0x00d3 }
            java.lang.String r9 = r4.getAddress()     // Catch:{ BackendException -> 0x00d3 }
            boolean r6 = r4.getEnabled()     // Catch:{ BackendException -> 0x00d3 }
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)     // Catch:{ BackendException -> 0x00d3 }
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r6 = r4.getStatus()     // Catch:{ BackendException -> 0x00d3 }
            int r6 = r6.getValue()     // Catch:{ BackendException -> 0x00d3 }
            java.lang.Integer r11 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)     // Catch:{ BackendException -> 0x00d3 }
            java.lang.String r12 = "050115"
            java.lang.String r13 = android.os.Build.MODEL     // Catch:{ BackendException -> 0x00d3 }
            java.lang.String r14 = android.os.Build.VERSION.RELEASE     // Catch:{ BackendException -> 0x00d3 }
            com.onesignal.common.RootToolsInternalMethods r6 = com.onesignal.common.RootToolsInternalMethods.INSTANCE     // Catch:{ BackendException -> 0x00d3 }
            boolean r6 = r6.isRooted()     // Catch:{ BackendException -> 0x00d3 }
            java.lang.Boolean r15 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)     // Catch:{ BackendException -> 0x00d3 }
            com.onesignal.common.DeviceUtils r6 = com.onesignal.common.DeviceUtils.INSTANCE     // Catch:{ BackendException -> 0x00d3 }
            com.onesignal.core.internal.application.IApplicationService r5 = r1._applicationService     // Catch:{ BackendException -> 0x00d3 }
            android.content.Context r5 = r5.getAppContext()     // Catch:{ BackendException -> 0x00d3 }
            java.lang.Integer r16 = r6.getNetType(r5)     // Catch:{ BackendException -> 0x00d3 }
            com.onesignal.common.DeviceUtils r5 = com.onesignal.common.DeviceUtils.INSTANCE     // Catch:{ BackendException -> 0x00d3 }
            com.onesignal.core.internal.application.IApplicationService r6 = r1._applicationService     // Catch:{ BackendException -> 0x00d3 }
            android.content.Context r6 = r6.getAppContext()     // Catch:{ BackendException -> 0x00d3 }
            java.lang.String r17 = r5.getCarrierName(r6)     // Catch:{ BackendException -> 0x00d3 }
            com.onesignal.common.AndroidUtils r5 = com.onesignal.common.AndroidUtils.INSTANCE     // Catch:{ BackendException -> 0x00d3 }
            com.onesignal.core.internal.application.IApplicationService r6 = r1._applicationService     // Catch:{ BackendException -> 0x00d3 }
            android.content.Context r6 = r6.getAppContext()     // Catch:{ BackendException -> 0x00d3 }
            java.lang.String r18 = r5.getAppVersion(r6)     // Catch:{ BackendException -> 0x00d3 }
            r6 = r0
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ BackendException -> 0x00d3 }
            com.onesignal.user.internal.backend.ISubscriptionBackendService r5 = r1._subscriptionBackend     // Catch:{ BackendException -> 0x00d3 }
            java.lang.String r6 = r4.getAppId()     // Catch:{ BackendException -> 0x00d3 }
            java.lang.String r7 = r4.getSubscriptionId()     // Catch:{ BackendException -> 0x00d3 }
            r2.L$0 = r1     // Catch:{ BackendException -> 0x00d3 }
            r2.L$1 = r4     // Catch:{ BackendException -> 0x00d3 }
            r8 = 1
            r2.label = r8     // Catch:{ BackendException -> 0x00d3 }
            java.lang.Object r0 = r5.updateSubscription(r6, r7, r0, r2)     // Catch:{ BackendException -> 0x00d3 }
            if (r0 != r3) goto L_0x00c4
            return r3
        L_0x00c4:
            com.onesignal.core.internal.operations.ExecutionResponse r0 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r5 = com.onesignal.core.internal.operations.ExecutionResult.SUCCESS
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 14
            r10 = 0
            r4 = r0
            r4.<init>(r5, r6, r7, r8, r9, r10)
            return r0
        L_0x00d3:
            r0 = move-exception
            r2 = r1
            r3 = r4
        L_0x00d6:
            com.onesignal.common.NetworkUtils r4 = com.onesignal.common.NetworkUtils.INSTANCE
            int r5 = r0.getStatusCode()
            com.onesignal.common.NetworkUtils$ResponseStatusType r4 = r4.getResponseStatusType(r5)
            int[] r5 = com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor.WhenMappings.$EnumSwitchMapping$0
            int r4 = r4.ordinal()
            r4 = r5[r4]
            r5 = 1
            if (r4 == r5) goto L_0x0185
            r5 = 5
            if (r4 == r5) goto L_0x00fe
            com.onesignal.core.internal.operations.ExecutionResponse r0 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r7 = com.onesignal.core.internal.operations.ExecutionResult.FAIL_NORETRY
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 14
            r12 = 0
            r6 = r0
            r6.<init>(r7, r8, r9, r10, r11, r12)
            goto L_0x0196
        L_0x00fe:
            int r4 = r0.getStatusCode()
            r5 = 404(0x194, float:5.66E-43)
            if (r4 != r5) goto L_0x014f
            java.lang.String r4 = r3.getOnesignalId()
            java.lang.String r5 = r3.getSubscriptionId()
            java.lang.String[] r4 = new java.lang.String[]{r4, r5}
            java.util.List r4 = kotlin.collections.CollectionsKt.listOf(r4)
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            boolean r5 = r4 instanceof java.util.Collection
            if (r5 == 0) goto L_0x0126
            r5 = r4
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x0126
            goto L_0x014f
        L_0x0126:
            java.util.Iterator r4 = r4.iterator()
        L_0x012a:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x014f
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            com.onesignal.user.internal.operations.impl.states.NewRecordsState r6 = r2._newRecordState
            boolean r5 = r6.isInMissingRetryWindow(r5)
            if (r5 == 0) goto L_0x012a
            com.onesignal.core.internal.operations.ExecutionResponse r2 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r7 = com.onesignal.core.internal.operations.ExecutionResult.FAIL_RETRY
            r8 = 0
            r9 = 0
            java.lang.Integer r10 = r0.getRetryAfterSeconds()
            r11 = 6
            r12 = 0
            r6 = r2
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return r2
        L_0x014f:
            com.onesignal.core.internal.operations.ExecutionResponse r0 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r14 = com.onesignal.core.internal.operations.ExecutionResult.FAIL_NORETRY
            r15 = 0
            com.onesignal.user.internal.operations.CreateSubscriptionOperation r2 = new com.onesignal.user.internal.operations.CreateSubscriptionOperation
            java.lang.String r5 = r3.getAppId()
            java.lang.String r6 = r3.getOnesignalId()
            java.lang.String r7 = r3.getSubscriptionId()
            com.onesignal.user.internal.subscriptions.SubscriptionType r8 = r3.getType()
            boolean r9 = r3.getEnabled()
            java.lang.String r10 = r3.getAddress()
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r11 = r3.getStatus()
            r4 = r2
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            java.util.List r16 = kotlin.collections.CollectionsKt.listOf(r2)
            r17 = 0
            r18 = 10
            r19 = 0
            r13 = r0
            r13.<init>(r14, r15, r16, r17, r18, r19)
            goto L_0x0196
        L_0x0185:
            com.onesignal.core.internal.operations.ExecutionResponse r9 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r3 = com.onesignal.core.internal.operations.ExecutionResult.FAIL_RETRY
            r4 = 0
            r5 = 0
            java.lang.Integer r6 = r0.getRetryAfterSeconds()
            r7 = 6
            r8 = 0
            r2 = r9
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r0 = r9
        L_0x0196:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor.updateSubscription(com.onesignal.user.internal.operations.UpdateSubscriptionOperation, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object transferSubscription(com.onesignal.user.internal.operations.TransferSubscriptionOperation r18, kotlin.coroutines.Continuation<? super com.onesignal.core.internal.operations.ExecutionResponse> r19) {
        /*
            r17 = this;
            r1 = r17
            r0 = r19
            boolean r2 = r0 instanceof com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor$transferSubscription$1
            if (r2 == 0) goto L_0x0018
            r2 = r0
            com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor$transferSubscription$1 r2 = (com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor$transferSubscription$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r0 = r2.label
            int r0 = r0 - r4
            r2.label = r0
            goto L_0x001d
        L_0x0018:
            com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor$transferSubscription$1 r2 = new com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor$transferSubscription$1
            r2.<init>(r1, r0)
        L_0x001d:
            r8 = r2
            java.lang.Object r0 = r8.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r8.label
            r9 = 1
            if (r3 == 0) goto L_0x0039
            if (r3 != r9) goto L_0x0031
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ BackendException -> 0x002f }
            goto L_0x0055
        L_0x002f:
            r0 = move-exception
            goto L_0x0064
        L_0x0031:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r0)
            com.onesignal.user.internal.backend.ISubscriptionBackendService r3 = r1._subscriptionBackend     // Catch:{ BackendException -> 0x002f }
            java.lang.String r4 = r18.getAppId()     // Catch:{ BackendException -> 0x002f }
            java.lang.String r5 = r18.getSubscriptionId()     // Catch:{ BackendException -> 0x002f }
            java.lang.String r6 = "onesignal_id"
            java.lang.String r7 = r18.getOnesignalId()     // Catch:{ BackendException -> 0x002f }
            r8.label = r9     // Catch:{ BackendException -> 0x002f }
            java.lang.Object r0 = r3.transferSubscription(r4, r5, r6, r7, r8)     // Catch:{ BackendException -> 0x002f }
            if (r0 != r2) goto L_0x0055
            return r2
        L_0x0055:
            com.onesignal.core.internal.operations.ExecutionResponse r0 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r4 = com.onesignal.core.internal.operations.ExecutionResult.SUCCESS
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 14
            r9 = 0
            r3 = r0
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return r0
        L_0x0064:
            com.onesignal.common.NetworkUtils r2 = com.onesignal.common.NetworkUtils.INSTANCE
            int r3 = r0.getStatusCode()
            com.onesignal.common.NetworkUtils$ResponseStatusType r2 = r2.getResponseStatusType(r3)
            int[] r3 = com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor.WhenMappings.$EnumSwitchMapping$0
            int r2 = r2.ordinal()
            r2 = r3[r2]
            if (r2 != r9) goto L_0x008a
            com.onesignal.core.internal.operations.ExecutionResponse r2 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r11 = com.onesignal.core.internal.operations.ExecutionResult.FAIL_RETRY
            r12 = 0
            r13 = 0
            java.lang.Integer r14 = r0.getRetryAfterSeconds()
            r15 = 6
            r16 = 0
            r10 = r2
            r10.<init>(r11, r12, r13, r14, r15, r16)
            goto L_0x0098
        L_0x008a:
            com.onesignal.core.internal.operations.ExecutionResponse r2 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r4 = com.onesignal.core.internal.operations.ExecutionResult.FAIL_NORETRY
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 14
            r9 = 0
            r3 = r2
            r3.<init>(r4, r5, r6, r7, r8, r9)
        L_0x0098:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor.transferSubscription(com.onesignal.user.internal.operations.TransferSubscriptionOperation, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final SubscriptionObjectType convert(SubscriptionType subscriptionType) {
        int i = WhenMappings.$EnumSwitchMapping$1[subscriptionType.ordinal()];
        if (i == 1) {
            return SubscriptionObjectType.SMS;
        }
        if (i != 2) {
            return SubscriptionObjectType.Companion.fromDeviceType(this._deviceService.getDeviceType());
        }
        return SubscriptionObjectType.EMAIL;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object deleteSubscription(com.onesignal.user.internal.operations.DeleteSubscriptionOperation r20, kotlin.coroutines.Continuation<? super com.onesignal.core.internal.operations.ExecutionResponse> r21) {
        /*
            r19 = this;
            r1 = r19
            r0 = r21
            boolean r2 = r0 instanceof com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor$deleteSubscription$1
            if (r2 == 0) goto L_0x0018
            r2 = r0
            com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor$deleteSubscription$1 r2 = (com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor$deleteSubscription$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r0 = r2.label
            int r0 = r0 - r4
            r2.label = r0
            goto L_0x001d
        L_0x0018:
            com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor$deleteSubscription$1 r2 = new com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor$deleteSubscription$1
            r2.<init>(r1, r0)
        L_0x001d:
            java.lang.Object r0 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            if (r4 == 0) goto L_0x0041
            if (r4 != r5) goto L_0x0039
            java.lang.Object r3 = r2.L$1
            com.onesignal.user.internal.operations.DeleteSubscriptionOperation r3 = (com.onesignal.user.internal.operations.DeleteSubscriptionOperation) r3
            java.lang.Object r2 = r2.L$0
            com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor r2 = (com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor) r2
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ BackendException -> 0x0036 }
            goto L_0x005f
        L_0x0036:
            r0 = move-exception
            r7 = r3
            goto L_0x007f
        L_0x0039:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r0)
            com.onesignal.user.internal.backend.ISubscriptionBackendService r0 = r1._subscriptionBackend     // Catch:{ BackendException -> 0x007b }
            java.lang.String r4 = r20.getAppId()     // Catch:{ BackendException -> 0x007b }
            java.lang.String r6 = r20.getSubscriptionId()     // Catch:{ BackendException -> 0x007b }
            r2.L$0 = r1     // Catch:{ BackendException -> 0x007b }
            r7 = r20
            r2.L$1 = r7     // Catch:{ BackendException -> 0x0079 }
            r2.label = r5     // Catch:{ BackendException -> 0x0079 }
            java.lang.Object r0 = r0.deleteSubscription(r4, r6, r2)     // Catch:{ BackendException -> 0x0079 }
            if (r0 != r3) goto L_0x005d
            return r3
        L_0x005d:
            r2 = r1
            r3 = r7
        L_0x005f:
            com.onesignal.user.internal.subscriptions.SubscriptionModelStore r0 = r2._subscriptionModelStore     // Catch:{ BackendException -> 0x0036 }
            java.lang.String r4 = r3.getSubscriptionId()     // Catch:{ BackendException -> 0x0036 }
            java.lang.String r6 = "HYDRATE"
            r0.remove(r4, r6)     // Catch:{ BackendException -> 0x0036 }
            com.onesignal.core.internal.operations.ExecutionResponse r0 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r8 = com.onesignal.core.internal.operations.ExecutionResult.SUCCESS
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 14
            r13 = 0
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12, r13)
            return r0
        L_0x0079:
            r0 = move-exception
            goto L_0x007e
        L_0x007b:
            r0 = move-exception
            r7 = r20
        L_0x007e:
            r2 = r1
        L_0x007f:
            com.onesignal.common.NetworkUtils r3 = com.onesignal.common.NetworkUtils.INSTANCE
            int r4 = r0.getStatusCode()
            com.onesignal.common.NetworkUtils$ResponseStatusType r3 = r3.getResponseStatusType(r4)
            int[] r4 = com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor.WhenMappings.$EnumSwitchMapping$0
            int r3 = r3.ordinal()
            r3 = r4[r3]
            if (r3 == r5) goto L_0x0109
            r4 = 5
            if (r3 == r4) goto L_0x00a6
            com.onesignal.core.internal.operations.ExecutionResponse r0 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r9 = com.onesignal.core.internal.operations.ExecutionResult.FAIL_NORETRY
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 14
            r14 = 0
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r13, r14)
            goto L_0x011a
        L_0x00a6:
            int r3 = r0.getStatusCode()
            r4 = 404(0x194, float:5.66E-43)
            if (r3 != r4) goto L_0x00f8
            java.lang.String r3 = r7.getOnesignalId()
            java.lang.String r4 = r7.getSubscriptionId()
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}
            java.util.List r3 = kotlin.collections.CollectionsKt.listOf(r3)
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            boolean r4 = r3 instanceof java.util.Collection
            if (r4 == 0) goto L_0x00ce
            r4 = r3
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x00ce
            goto L_0x00f8
        L_0x00ce:
            java.util.Iterator r3 = r3.iterator()
        L_0x00d2:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x00f8
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            com.onesignal.user.internal.operations.impl.states.NewRecordsState r5 = r2._newRecordState
            boolean r4 = r5.isInMissingRetryWindow(r4)
            if (r4 == 0) goto L_0x00d2
            com.onesignal.core.internal.operations.ExecutionResponse r2 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r6 = com.onesignal.core.internal.operations.ExecutionResult.FAIL_RETRY
            r7 = 0
            r8 = 0
            java.lang.Integer r9 = r0.getRetryAfterSeconds()
            r10 = 6
            r11 = 0
            r5 = r2
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r0 = r2
            goto L_0x011a
        L_0x00f8:
            com.onesignal.core.internal.operations.ExecutionResponse r0 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r13 = com.onesignal.core.internal.operations.ExecutionResult.SUCCESS
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 14
            r18 = 0
            r12 = r0
            r12.<init>(r13, r14, r15, r16, r17, r18)
            goto L_0x011a
        L_0x0109:
            com.onesignal.core.internal.operations.ExecutionResponse r9 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r3 = com.onesignal.core.internal.operations.ExecutionResult.FAIL_RETRY
            r4 = 0
            r5 = 0
            java.lang.Integer r6 = r0.getRetryAfterSeconds()
            r7 = 6
            r8 = 0
            r2 = r9
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r0 = r9
        L_0x011a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor.deleteSubscription(com.onesignal.user.internal.operations.DeleteSubscriptionOperation, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/onesignal/user/internal/operations/impl/executors/SubscriptionOperationExecutor$Companion;", "", "()V", "CREATE_SUBSCRIPTION", "", "DELETE_SUBSCRIPTION", "TRANSFER_SUBSCRIPTION", "UPDATE_SUBSCRIPTION", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SubscriptionOperationExecutor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
