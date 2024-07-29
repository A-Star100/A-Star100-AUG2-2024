package com.onesignal.user.internal.operations.impl.executors;

import com.onesignal.common.NetworkUtils;
import com.onesignal.core.internal.operations.IOperationExecutor;
import com.onesignal.user.internal.backend.IUserBackendService;
import com.onesignal.user.internal.builduser.IRebuildUserService;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.operations.impl.states.NewRecordsState;
import com.onesignal.user.internal.properties.PropertiesModelStore;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u001f\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lcom/onesignal/user/internal/operations/impl/executors/UpdateUserOperationExecutor;", "Lcom/onesignal/core/internal/operations/IOperationExecutor;", "_userBackend", "Lcom/onesignal/user/internal/backend/IUserBackendService;", "_identityModelStore", "Lcom/onesignal/user/internal/identity/IdentityModelStore;", "_propertiesModelStore", "Lcom/onesignal/user/internal/properties/PropertiesModelStore;", "_buildUserService", "Lcom/onesignal/user/internal/builduser/IRebuildUserService;", "_newRecordState", "Lcom/onesignal/user/internal/operations/impl/states/NewRecordsState;", "(Lcom/onesignal/user/internal/backend/IUserBackendService;Lcom/onesignal/user/internal/identity/IdentityModelStore;Lcom/onesignal/user/internal/properties/PropertiesModelStore;Lcom/onesignal/user/internal/builduser/IRebuildUserService;Lcom/onesignal/user/internal/operations/impl/states/NewRecordsState;)V", "operations", "", "", "getOperations", "()Ljava/util/List;", "execute", "Lcom/onesignal/core/internal/operations/ExecutionResponse;", "ops", "Lcom/onesignal/core/internal/operations/Operation;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: UpdateUserOperationExecutor.kt */
public final class UpdateUserOperationExecutor implements IOperationExecutor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DELETE_TAG = "delete-tag";
    public static final String SET_PROPERTY = "set-property";
    public static final String SET_TAG = "set-tag";
    public static final String TRACK_PURCHASE = "track-purchase";
    public static final String TRACK_SESSION_END = "track-session-end";
    public static final String TRACK_SESSION_START = "track-session-start";
    private final IRebuildUserService _buildUserService;
    private final IdentityModelStore _identityModelStore;
    private final NewRecordsState _newRecordState;
    private final PropertiesModelStore _propertiesModelStore;
    private final IUserBackendService _userBackend;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: UpdateUserOperationExecutor.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NetworkUtils.ResponseStatusType.values().length];
            iArr[NetworkUtils.ResponseStatusType.RETRYABLE.ordinal()] = 1;
            iArr[NetworkUtils.ResponseStatusType.UNAUTHORIZED.ordinal()] = 2;
            iArr[NetworkUtils.ResponseStatusType.MISSING.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public UpdateUserOperationExecutor(IUserBackendService iUserBackendService, IdentityModelStore identityModelStore, PropertiesModelStore propertiesModelStore, IRebuildUserService iRebuildUserService, NewRecordsState newRecordsState) {
        Intrinsics.checkNotNullParameter(iUserBackendService, "_userBackend");
        Intrinsics.checkNotNullParameter(identityModelStore, "_identityModelStore");
        Intrinsics.checkNotNullParameter(propertiesModelStore, "_propertiesModelStore");
        Intrinsics.checkNotNullParameter(iRebuildUserService, "_buildUserService");
        Intrinsics.checkNotNullParameter(newRecordsState, "_newRecordState");
        this._userBackend = iUserBackendService;
        this._identityModelStore = identityModelStore;
        this._propertiesModelStore = propertiesModelStore;
        this._buildUserService = iRebuildUserService;
        this._newRecordState = newRecordsState;
    }

    public List<String> getOperations() {
        return CollectionsKt.listOf(SET_TAG, DELETE_TAG, SET_PROPERTY, TRACK_SESSION_START, TRACK_SESSION_END, TRACK_PURCHASE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v37, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0258 A[Catch:{ BackendException -> 0x0044 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object execute(java.util.List<? extends com.onesignal.core.internal.operations.Operation> r30, kotlin.coroutines.Continuation<? super com.onesignal.core.internal.operations.ExecutionResponse> r31) {
        /*
            r29 = this;
            r1 = r29
            r0 = r30
            r2 = r31
            boolean r3 = r2 instanceof com.onesignal.user.internal.operations.impl.executors.UpdateUserOperationExecutor$execute$1
            if (r3 == 0) goto L_0x001a
            r3 = r2
            com.onesignal.user.internal.operations.impl.executors.UpdateUserOperationExecutor$execute$1 r3 = (com.onesignal.user.internal.operations.impl.executors.UpdateUserOperationExecutor$execute$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001f
        L_0x001a:
            com.onesignal.user.internal.operations.impl.executors.UpdateUserOperationExecutor$execute$1 r3 = new com.onesignal.user.internal.operations.impl.executors.UpdateUserOperationExecutor$execute$1
            r3.<init>(r1, r2)
        L_0x001f:
            r11 = r3
            java.lang.Object r2 = r11.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r11.label
            r12 = 1
            if (r4 == 0) goto L_0x004f
            if (r4 != r12) goto L_0x0047
            java.lang.Object r0 = r11.L$3
            r3 = r0
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r0 = r11.L$2
            r4 = r0
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r0 = r11.L$1
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r5 = r11.L$0
            com.onesignal.user.internal.operations.impl.executors.UpdateUserOperationExecutor r5 = (com.onesignal.user.internal.operations.impl.executors.UpdateUserOperationExecutor) r5
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ BackendException -> 0x0044 }
            goto L_0x0246
        L_0x0044:
            r0 = move-exception
            goto L_0x02db
        L_0x0047:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x004f:
            kotlin.ResultKt.throwOnFailure(r2)
            com.onesignal.debug.LogLevel r2 = com.onesignal.debug.LogLevel.DEBUG
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "UpdateUserOperationExecutor(operation: "
            r4.<init>(r5)
            r4.append(r0)
            r5 = 41
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.onesignal.debug.internal.logging.Logging.log(r2, r4)
            r2 = 0
            r4 = r2
            java.lang.String r4 = (java.lang.String) r4
            com.onesignal.user.internal.backend.PropertiesObject r4 = new com.onesignal.user.internal.backend.PropertiesObject
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 63
            r21 = 0
            r13 = r4
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21)
            com.onesignal.user.internal.backend.PropertiesDeltasObject r5 = new com.onesignal.user.internal.backend.PropertiesDeltasObject
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 15
            r28 = 0
            r22 = r5
            r22.<init>(r23, r24, r25, r26, r27, r28)
            java.util.Iterator r6 = r30.iterator()
            r7 = 0
            r13 = r2
            r8 = r4
            r10 = r5
            r9 = r7
        L_0x009e:
            boolean r4 = r6.hasNext()
            if (r4 == 0) goto L_0x0227
            java.lang.Object r4 = r6.next()
            com.onesignal.core.internal.operations.Operation r4 = (com.onesignal.core.internal.operations.Operation) r4
            boolean r5 = r4 instanceof com.onesignal.user.internal.operations.SetTagOperation
            if (r5 == 0) goto L_0x00c4
            if (r13 != 0) goto L_0x00bb
            r2 = r4
            com.onesignal.user.internal.operations.SetTagOperation r2 = (com.onesignal.user.internal.operations.SetTagOperation) r2
            java.lang.String r13 = r2.getAppId()
            java.lang.String r2 = r2.getOnesignalId()
        L_0x00bb:
            com.onesignal.user.internal.operations.impl.executors.PropertyOperationHelper r5 = com.onesignal.user.internal.operations.impl.executors.PropertyOperationHelper.INSTANCE
            com.onesignal.user.internal.operations.SetTagOperation r4 = (com.onesignal.user.internal.operations.SetTagOperation) r4
            com.onesignal.user.internal.backend.PropertiesObject r8 = r5.createPropertiesFromOperation((com.onesignal.user.internal.operations.SetTagOperation) r4, (com.onesignal.user.internal.backend.PropertiesObject) r8)
            goto L_0x009e
        L_0x00c4:
            boolean r5 = r4 instanceof com.onesignal.user.internal.operations.DeleteTagOperation
            if (r5 == 0) goto L_0x00de
            if (r13 != 0) goto L_0x00d5
            r2 = r4
            com.onesignal.user.internal.operations.DeleteTagOperation r2 = (com.onesignal.user.internal.operations.DeleteTagOperation) r2
            java.lang.String r13 = r2.getAppId()
            java.lang.String r2 = r2.getOnesignalId()
        L_0x00d5:
            com.onesignal.user.internal.operations.impl.executors.PropertyOperationHelper r5 = com.onesignal.user.internal.operations.impl.executors.PropertyOperationHelper.INSTANCE
            com.onesignal.user.internal.operations.DeleteTagOperation r4 = (com.onesignal.user.internal.operations.DeleteTagOperation) r4
            com.onesignal.user.internal.backend.PropertiesObject r8 = r5.createPropertiesFromOperation((com.onesignal.user.internal.operations.DeleteTagOperation) r4, (com.onesignal.user.internal.backend.PropertiesObject) r8)
            goto L_0x009e
        L_0x00de:
            boolean r5 = r4 instanceof com.onesignal.user.internal.operations.SetPropertyOperation
            if (r5 == 0) goto L_0x00f8
            if (r13 != 0) goto L_0x00ef
            r2 = r4
            com.onesignal.user.internal.operations.SetPropertyOperation r2 = (com.onesignal.user.internal.operations.SetPropertyOperation) r2
            java.lang.String r13 = r2.getAppId()
            java.lang.String r2 = r2.getOnesignalId()
        L_0x00ef:
            com.onesignal.user.internal.operations.impl.executors.PropertyOperationHelper r5 = com.onesignal.user.internal.operations.impl.executors.PropertyOperationHelper.INSTANCE
            com.onesignal.user.internal.operations.SetPropertyOperation r4 = (com.onesignal.user.internal.operations.SetPropertyOperation) r4
            com.onesignal.user.internal.backend.PropertiesObject r8 = r5.createPropertiesFromOperation((com.onesignal.user.internal.operations.SetPropertyOperation) r4, (com.onesignal.user.internal.backend.PropertiesObject) r8)
            goto L_0x009e
        L_0x00f8:
            boolean r5 = r4 instanceof com.onesignal.user.internal.operations.TrackSessionStartOperation
            if (r5 == 0) goto L_0x0135
            if (r13 != 0) goto L_0x0108
            com.onesignal.user.internal.operations.TrackSessionStartOperation r4 = (com.onesignal.user.internal.operations.TrackSessionStartOperation) r4
            java.lang.String r13 = r4.getAppId()
            java.lang.String r2 = r4.getOnesignalId()
        L_0x0108:
            java.lang.Integer r4 = r10.getSessionCount()
            if (r4 == 0) goto L_0x011b
            java.lang.Integer r4 = r10.getSessionCount()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            int r4 = r4.intValue()
            int r4 = r4 + r12
            goto L_0x011c
        L_0x011b:
            r4 = r12
        L_0x011c:
            com.onesignal.user.internal.backend.PropertiesDeltasObject r5 = new com.onesignal.user.internal.backend.PropertiesDeltasObject
            java.lang.Long r7 = r10.getSessionTime()
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            java.math.BigDecimal r9 = r10.getAmountSpent()
            java.util.List r10 = r10.getPurchases()
            r5.<init>(r7, r4, r9, r10)
            r10 = r5
            r9 = r12
            goto L_0x009e
        L_0x0135:
            boolean r5 = r4 instanceof com.onesignal.user.internal.operations.TrackSessionEndOperation
            if (r5 == 0) goto L_0x017d
            if (r13 != 0) goto L_0x0146
            r2 = r4
            com.onesignal.user.internal.operations.TrackSessionEndOperation r2 = (com.onesignal.user.internal.operations.TrackSessionEndOperation) r2
            java.lang.String r13 = r2.getAppId()
            java.lang.String r2 = r2.getOnesignalId()
        L_0x0146:
            java.lang.Long r5 = r10.getSessionTime()
            if (r5 == 0) goto L_0x015f
            java.lang.Long r5 = r10.getSessionTime()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            long r14 = r5.longValue()
            com.onesignal.user.internal.operations.TrackSessionEndOperation r4 = (com.onesignal.user.internal.operations.TrackSessionEndOperation) r4
            long r4 = r4.getSessionTime()
            long r14 = r14 + r4
            goto L_0x0165
        L_0x015f:
            com.onesignal.user.internal.operations.TrackSessionEndOperation r4 = (com.onesignal.user.internal.operations.TrackSessionEndOperation) r4
            long r14 = r4.getSessionTime()
        L_0x0165:
            com.onesignal.user.internal.backend.PropertiesDeltasObject r4 = new com.onesignal.user.internal.backend.PropertiesDeltasObject
            java.lang.Long r5 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r14)
            java.lang.Integer r7 = r10.getSessionCount()
            java.math.BigDecimal r14 = r10.getAmountSpent()
            java.util.List r10 = r10.getPurchases()
            r4.<init>(r5, r7, r14, r10)
            r10 = r4
            goto L_0x009e
        L_0x017d:
            boolean r5 = r4 instanceof com.onesignal.user.internal.operations.TrackPurchaseOperation
            if (r5 == 0) goto L_0x0213
            if (r13 != 0) goto L_0x018e
            r2 = r4
            com.onesignal.user.internal.operations.TrackPurchaseOperation r2 = (com.onesignal.user.internal.operations.TrackPurchaseOperation) r2
            java.lang.String r13 = r2.getAppId()
            java.lang.String r2 = r2.getOnesignalId()
        L_0x018e:
            java.math.BigDecimal r5 = r10.getAmountSpent()
            if (r5 == 0) goto L_0x01ac
            java.math.BigDecimal r5 = r10.getAmountSpent()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            r7 = r4
            com.onesignal.user.internal.operations.TrackPurchaseOperation r7 = (com.onesignal.user.internal.operations.TrackPurchaseOperation) r7
            java.math.BigDecimal r7 = r7.getAmountSpent()
            java.math.BigDecimal r5 = r5.add(r7)
            java.lang.String r7 = "this.add(other)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r7)
            goto L_0x01b3
        L_0x01ac:
            r5 = r4
            com.onesignal.user.internal.operations.TrackPurchaseOperation r5 = (com.onesignal.user.internal.operations.TrackPurchaseOperation) r5
            java.math.BigDecimal r5 = r5.getAmountSpent()
        L_0x01b3:
            java.util.List r7 = r10.getPurchases()
            if (r7 == 0) goto L_0x01c7
            java.util.List r7 = r10.getPurchases()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            java.util.Collection r7 = (java.util.Collection) r7
            java.util.List r7 = kotlin.collections.CollectionsKt.toMutableList(r7)
            goto L_0x01ce
        L_0x01c7:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.List r7 = (java.util.List) r7
        L_0x01ce:
            com.onesignal.user.internal.operations.TrackPurchaseOperation r4 = (com.onesignal.user.internal.operations.TrackPurchaseOperation) r4
            java.util.List r4 = r4.getPurchases()
            java.util.Iterator r4 = r4.iterator()
        L_0x01d8:
            boolean r14 = r4.hasNext()
            if (r14 == 0) goto L_0x01fe
            java.lang.Object r14 = r4.next()
            com.onesignal.user.internal.operations.PurchaseInfo r14 = (com.onesignal.user.internal.operations.PurchaseInfo) r14
            com.onesignal.user.internal.backend.PurchaseObject r15 = new com.onesignal.user.internal.backend.PurchaseObject
            java.lang.String r12 = r14.getSku()
            r16 = r2
            java.lang.String r2 = r14.getIso()
            java.math.BigDecimal r14 = r14.getAmount()
            r15.<init>(r12, r2, r14)
            r7.add(r15)
            r2 = r16
            r12 = 1
            goto L_0x01d8
        L_0x01fe:
            r16 = r2
            com.onesignal.user.internal.backend.PropertiesDeltasObject r2 = new com.onesignal.user.internal.backend.PropertiesDeltasObject
            java.lang.Long r4 = r10.getSessionTime()
            java.lang.Integer r10 = r10.getSessionCount()
            r2.<init>(r4, r10, r5, r7)
            r10 = r2
            r2 = r16
            r12 = 1
            goto L_0x009e
        L_0x0213:
            java.lang.Exception r0 = new java.lang.Exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Unrecognized operation: "
            r2.<init>(r3)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x0227:
            if (r13 == 0) goto L_0x0373
            if (r2 == 0) goto L_0x0373
            com.onesignal.user.internal.backend.IUserBackendService r4 = r1._userBackend     // Catch:{ BackendException -> 0x02d7 }
            java.lang.String r6 = "onesignal_id"
            r11.L$0 = r1     // Catch:{ BackendException -> 0x02d7 }
            r11.L$1 = r0     // Catch:{ BackendException -> 0x02d7 }
            r11.L$2 = r13     // Catch:{ BackendException -> 0x02d7 }
            r11.L$3 = r2     // Catch:{ BackendException -> 0x02d7 }
            r5 = 1
            r11.label = r5     // Catch:{ BackendException -> 0x02d7 }
            r5 = r13
            r7 = r2
            java.lang.Object r4 = r4.updateUser(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ BackendException -> 0x02d7 }
            if (r4 != r3) goto L_0x0243
            return r3
        L_0x0243:
            r5 = r1
            r3 = r2
            r4 = r13
        L_0x0246:
            com.onesignal.user.internal.identity.IdentityModelStore r2 = r5._identityModelStore     // Catch:{ BackendException -> 0x0044 }
            com.onesignal.common.modeling.Model r2 = r2.getModel()     // Catch:{ BackendException -> 0x0044 }
            com.onesignal.user.internal.identity.IdentityModel r2 = (com.onesignal.user.internal.identity.IdentityModel) r2     // Catch:{ BackendException -> 0x0044 }
            java.lang.String r2 = r2.getOnesignalId()     // Catch:{ BackendException -> 0x0044 }
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)     // Catch:{ BackendException -> 0x0044 }
            if (r2 == 0) goto L_0x0373
            java.util.Iterator r0 = r0.iterator()     // Catch:{ BackendException -> 0x0044 }
        L_0x025c:
            boolean r2 = r0.hasNext()     // Catch:{ BackendException -> 0x0044 }
            if (r2 == 0) goto L_0x0373
            java.lang.Object r2 = r0.next()     // Catch:{ BackendException -> 0x0044 }
            com.onesignal.core.internal.operations.Operation r2 = (com.onesignal.core.internal.operations.Operation) r2     // Catch:{ BackendException -> 0x0044 }
            boolean r6 = r2 instanceof com.onesignal.user.internal.operations.SetTagOperation     // Catch:{ BackendException -> 0x0044 }
            if (r6 == 0) goto L_0x0292
            com.onesignal.user.internal.properties.PropertiesModelStore r6 = r5._propertiesModelStore     // Catch:{ BackendException -> 0x0044 }
            com.onesignal.common.modeling.Model r6 = r6.getModel()     // Catch:{ BackendException -> 0x0044 }
            com.onesignal.user.internal.properties.PropertiesModel r6 = (com.onesignal.user.internal.properties.PropertiesModel) r6     // Catch:{ BackendException -> 0x0044 }
            com.onesignal.common.modeling.MapModel r6 = r6.getTags()     // Catch:{ BackendException -> 0x0044 }
            r7 = r6
            com.onesignal.common.modeling.Model r7 = (com.onesignal.common.modeling.Model) r7     // Catch:{ BackendException -> 0x0044 }
            r6 = r2
            com.onesignal.user.internal.operations.SetTagOperation r6 = (com.onesignal.user.internal.operations.SetTagOperation) r6     // Catch:{ BackendException -> 0x0044 }
            java.lang.String r8 = r6.getKey()     // Catch:{ BackendException -> 0x0044 }
            com.onesignal.user.internal.operations.SetTagOperation r2 = (com.onesignal.user.internal.operations.SetTagOperation) r2     // Catch:{ BackendException -> 0x0044 }
            java.lang.String r9 = r2.getValue()     // Catch:{ BackendException -> 0x0044 }
            java.lang.String r10 = "HYDRATE"
            r11 = 0
            r12 = 8
            r13 = 0
            com.onesignal.common.modeling.Model.setStringProperty$default(r7, r8, r9, r10, r11, r12, r13)     // Catch:{ BackendException -> 0x0044 }
            goto L_0x025c
        L_0x0292:
            boolean r6 = r2 instanceof com.onesignal.user.internal.operations.DeleteTagOperation     // Catch:{ BackendException -> 0x0044 }
            if (r6 == 0) goto L_0x02b6
            com.onesignal.user.internal.properties.PropertiesModelStore r6 = r5._propertiesModelStore     // Catch:{ BackendException -> 0x0044 }
            com.onesignal.common.modeling.Model r6 = r6.getModel()     // Catch:{ BackendException -> 0x0044 }
            com.onesignal.user.internal.properties.PropertiesModel r6 = (com.onesignal.user.internal.properties.PropertiesModel) r6     // Catch:{ BackendException -> 0x0044 }
            com.onesignal.common.modeling.MapModel r6 = r6.getTags()     // Catch:{ BackendException -> 0x0044 }
            r7 = r6
            com.onesignal.common.modeling.Model r7 = (com.onesignal.common.modeling.Model) r7     // Catch:{ BackendException -> 0x0044 }
            com.onesignal.user.internal.operations.DeleteTagOperation r2 = (com.onesignal.user.internal.operations.DeleteTagOperation) r2     // Catch:{ BackendException -> 0x0044 }
            java.lang.String r8 = r2.getKey()     // Catch:{ BackendException -> 0x0044 }
            r9 = 0
            java.lang.String r10 = "HYDRATE"
            r11 = 0
            r12 = 8
            r13 = 0
            com.onesignal.common.modeling.Model.setOptStringProperty$default(r7, r8, r9, r10, r11, r12, r13)     // Catch:{ BackendException -> 0x0044 }
            goto L_0x025c
        L_0x02b6:
            boolean r6 = r2 instanceof com.onesignal.user.internal.operations.SetPropertyOperation     // Catch:{ BackendException -> 0x0044 }
            if (r6 == 0) goto L_0x025c
            com.onesignal.user.internal.properties.PropertiesModelStore r6 = r5._propertiesModelStore     // Catch:{ BackendException -> 0x0044 }
            com.onesignal.common.modeling.Model r7 = r6.getModel()     // Catch:{ BackendException -> 0x0044 }
            r6 = r2
            com.onesignal.user.internal.operations.SetPropertyOperation r6 = (com.onesignal.user.internal.operations.SetPropertyOperation) r6     // Catch:{ BackendException -> 0x0044 }
            java.lang.String r8 = r6.getProperty()     // Catch:{ BackendException -> 0x0044 }
            com.onesignal.user.internal.operations.SetPropertyOperation r2 = (com.onesignal.user.internal.operations.SetPropertyOperation) r2     // Catch:{ BackendException -> 0x0044 }
            java.lang.Object r9 = r2.getValue()     // Catch:{ BackendException -> 0x0044 }
            java.lang.String r10 = "HYDRATE"
            r11 = 0
            r12 = 8
            r13 = 0
            com.onesignal.common.modeling.Model.setOptAnyProperty$default(r7, r8, r9, r10, r11, r12, r13)     // Catch:{ BackendException -> 0x0044 }
            goto L_0x025c
        L_0x02d7:
            r0 = move-exception
            r5 = r1
            r3 = r2
            r4 = r13
        L_0x02db:
            com.onesignal.common.NetworkUtils r2 = com.onesignal.common.NetworkUtils.INSTANCE
            int r6 = r0.getStatusCode()
            com.onesignal.common.NetworkUtils$ResponseStatusType r2 = r2.getResponseStatusType(r6)
            int[] r6 = com.onesignal.user.internal.operations.impl.executors.UpdateUserOperationExecutor.WhenMappings.$EnumSwitchMapping$0
            int r2 = r2.ordinal()
            r2 = r6[r2]
            r6 = 1
            if (r2 == r6) goto L_0x0361
            r6 = 2
            if (r2 == r6) goto L_0x034e
            r6 = 3
            if (r2 == r6) goto L_0x0306
            com.onesignal.core.internal.operations.ExecutionResponse r0 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r8 = com.onesignal.core.internal.operations.ExecutionResult.FAIL_NORETRY
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 14
            r13 = 0
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12, r13)
            goto L_0x0372
        L_0x0306:
            int r2 = r0.getStatusCode()
            r6 = 404(0x194, float:5.66E-43)
            if (r2 != r6) goto L_0x0327
            com.onesignal.user.internal.operations.impl.states.NewRecordsState r2 = r5._newRecordState
            boolean r2 = r2.isInMissingRetryWindow(r3)
            if (r2 == 0) goto L_0x0327
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
        L_0x0327:
            com.onesignal.user.internal.builduser.IRebuildUserService r2 = r5._buildUserService
            java.util.List r8 = r2.getRebuildOperationsIfCurrentUser(r4, r3)
            if (r8 != 0) goto L_0x033e
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
        L_0x033e:
            com.onesignal.core.internal.operations.ExecutionResponse r2 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r6 = com.onesignal.core.internal.operations.ExecutionResult.FAIL_RETRY
            r7 = 0
            java.lang.Integer r9 = r0.getRetryAfterSeconds()
            r10 = 2
            r11 = 0
            r5 = r2
            r5.<init>(r6, r7, r8, r9, r10, r11)
            return r2
        L_0x034e:
            com.onesignal.core.internal.operations.ExecutionResponse r2 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r13 = com.onesignal.core.internal.operations.ExecutionResult.FAIL_UNAUTHORIZED
            r14 = 0
            r15 = 0
            java.lang.Integer r16 = r0.getRetryAfterSeconds()
            r17 = 6
            r18 = 0
            r12 = r2
            r12.<init>(r13, r14, r15, r16, r17, r18)
            goto L_0x0371
        L_0x0361:
            com.onesignal.core.internal.operations.ExecutionResponse r2 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r4 = com.onesignal.core.internal.operations.ExecutionResult.FAIL_RETRY
            r5 = 0
            r6 = 0
            java.lang.Integer r7 = r0.getRetryAfterSeconds()
            r8 = 6
            r9 = 0
            r3 = r2
            r3.<init>(r4, r5, r6, r7, r8, r9)
        L_0x0371:
            r0 = r2
        L_0x0372:
            return r0
        L_0x0373:
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
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.operations.impl.executors.UpdateUserOperationExecutor.execute(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/onesignal/user/internal/operations/impl/executors/UpdateUserOperationExecutor$Companion;", "", "()V", "DELETE_TAG", "", "SET_PROPERTY", "SET_TAG", "TRACK_PURCHASE", "TRACK_SESSION_END", "TRACK_SESSION_START", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: UpdateUserOperationExecutor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
