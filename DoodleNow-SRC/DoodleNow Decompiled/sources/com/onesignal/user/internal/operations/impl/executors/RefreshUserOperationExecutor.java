package com.onesignal.user.internal.operations.impl.executors;

import com.onesignal.common.NetworkUtils;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.operations.ExecutionResponse;
import com.onesignal.core.internal.operations.IOperationExecutor;
import com.onesignal.core.internal.operations.Operation;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.user.internal.backend.IUserBackendService;
import com.onesignal.user.internal.backend.SubscriptionObjectType;
import com.onesignal.user.internal.builduser.IRebuildUserService;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.operations.RefreshUserOperation;
import com.onesignal.user.internal.operations.impl.states.NewRecordsState;
import com.onesignal.user.internal.properties.PropertiesModelStore;
import com.onesignal.user.internal.subscriptions.SubscriptionModelStore;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u001f\u0010\u0016\u001a\u00020\u00172\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00180\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH@ø\u0001\u0000¢\u0006\u0002\u0010\u001dR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Lcom/onesignal/user/internal/operations/impl/executors/RefreshUserOperationExecutor;", "Lcom/onesignal/core/internal/operations/IOperationExecutor;", "_userBackend", "Lcom/onesignal/user/internal/backend/IUserBackendService;", "_identityModelStore", "Lcom/onesignal/user/internal/identity/IdentityModelStore;", "_propertiesModelStore", "Lcom/onesignal/user/internal/properties/PropertiesModelStore;", "_subscriptionsModelStore", "Lcom/onesignal/user/internal/subscriptions/SubscriptionModelStore;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_buildUserService", "Lcom/onesignal/user/internal/builduser/IRebuildUserService;", "_newRecordState", "Lcom/onesignal/user/internal/operations/impl/states/NewRecordsState;", "(Lcom/onesignal/user/internal/backend/IUserBackendService;Lcom/onesignal/user/internal/identity/IdentityModelStore;Lcom/onesignal/user/internal/properties/PropertiesModelStore;Lcom/onesignal/user/internal/subscriptions/SubscriptionModelStore;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/user/internal/builduser/IRebuildUserService;Lcom/onesignal/user/internal/operations/impl/states/NewRecordsState;)V", "operations", "", "", "getOperations", "()Ljava/util/List;", "execute", "Lcom/onesignal/core/internal/operations/ExecutionResponse;", "Lcom/onesignal/core/internal/operations/Operation;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUser", "op", "Lcom/onesignal/user/internal/operations/RefreshUserOperation;", "(Lcom/onesignal/user/internal/operations/RefreshUserOperation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: RefreshUserOperationExecutor.kt */
public final class RefreshUserOperationExecutor implements IOperationExecutor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String REFRESH_USER = "refresh-user";
    private final IRebuildUserService _buildUserService;
    private final ConfigModelStore _configModelStore;
    private final IdentityModelStore _identityModelStore;
    private final NewRecordsState _newRecordState;
    private final PropertiesModelStore _propertiesModelStore;
    private final SubscriptionModelStore _subscriptionsModelStore;
    private final IUserBackendService _userBackend;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: RefreshUserOperationExecutor.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[SubscriptionObjectType.values().length];
            iArr[SubscriptionObjectType.EMAIL.ordinal()] = 1;
            iArr[SubscriptionObjectType.SMS.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[NetworkUtils.ResponseStatusType.values().length];
            iArr2[NetworkUtils.ResponseStatusType.RETRYABLE.ordinal()] = 1;
            iArr2[NetworkUtils.ResponseStatusType.UNAUTHORIZED.ordinal()] = 2;
            iArr2[NetworkUtils.ResponseStatusType.MISSING.ordinal()] = 3;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public RefreshUserOperationExecutor(IUserBackendService iUserBackendService, IdentityModelStore identityModelStore, PropertiesModelStore propertiesModelStore, SubscriptionModelStore subscriptionModelStore, ConfigModelStore configModelStore, IRebuildUserService iRebuildUserService, NewRecordsState newRecordsState) {
        Intrinsics.checkNotNullParameter(iUserBackendService, "_userBackend");
        Intrinsics.checkNotNullParameter(identityModelStore, "_identityModelStore");
        Intrinsics.checkNotNullParameter(propertiesModelStore, "_propertiesModelStore");
        Intrinsics.checkNotNullParameter(subscriptionModelStore, "_subscriptionsModelStore");
        Intrinsics.checkNotNullParameter(configModelStore, "_configModelStore");
        Intrinsics.checkNotNullParameter(iRebuildUserService, "_buildUserService");
        Intrinsics.checkNotNullParameter(newRecordsState, "_newRecordState");
        this._userBackend = iUserBackendService;
        this._identityModelStore = identityModelStore;
        this._propertiesModelStore = propertiesModelStore;
        this._subscriptionsModelStore = subscriptionModelStore;
        this._configModelStore = configModelStore;
        this._buildUserService = iRebuildUserService;
        this._newRecordState = newRecordsState;
    }

    public List<String> getOperations() {
        return CollectionsKt.listOf(REFRESH_USER);
    }

    public Object execute(List<? extends Operation> list, Continuation<? super ExecutionResponse> continuation) {
        LogLevel logLevel = LogLevel.DEBUG;
        Logging.log(logLevel, "RefreshUserOperationExecutor(operation: " + list + ')');
        Iterable<Operation> iterable = list;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            for (Operation operation : iterable) {
                if (!(operation instanceof RefreshUserOperation)) {
                    throw new Exception("Unrecognized operation(s)! Attempted operations:\n" + list);
                }
            }
        }
        Operation operation2 = (Operation) CollectionsKt.first(list);
        if (operation2 instanceof RefreshUserOperation) {
            return getUser((RefreshUserOperation) operation2, continuation);
        }
        throw new Exception("Unrecognized operation: " + operation2);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x025a  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x02d6  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007c A[Catch:{ BackendException -> 0x0039 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008b A[Catch:{ BackendException -> 0x0039 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getUser(com.onesignal.user.internal.operations.RefreshUserOperation r18, kotlin.coroutines.Continuation<? super com.onesignal.core.internal.operations.ExecutionResponse> r19) {
        /*
            r17 = this;
            r1 = r17
            r0 = r19
            java.lang.String r2 = "HYDRATE"
            boolean r3 = r0 instanceof com.onesignal.user.internal.operations.impl.executors.RefreshUserOperationExecutor$getUser$1
            if (r3 == 0) goto L_0x001a
            r3 = r0
            com.onesignal.user.internal.operations.impl.executors.RefreshUserOperationExecutor$getUser$1 r3 = (com.onesignal.user.internal.operations.impl.executors.RefreshUserOperationExecutor$getUser$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r0 = r3.label
            int r0 = r0 - r5
            r3.label = r0
            goto L_0x001f
        L_0x001a:
            com.onesignal.user.internal.operations.impl.executors.RefreshUserOperationExecutor$getUser$1 r3 = new com.onesignal.user.internal.operations.impl.executors.RefreshUserOperationExecutor$getUser$1
            r3.<init>(r1, r0)
        L_0x001f:
            java.lang.Object r0 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 2
            r7 = 1
            if (r5 == 0) goto L_0x0044
            if (r5 != r7) goto L_0x003c
            java.lang.Object r4 = r3.L$1
            com.onesignal.user.internal.operations.RefreshUserOperation r4 = (com.onesignal.user.internal.operations.RefreshUserOperation) r4
            java.lang.Object r3 = r3.L$0
            com.onesignal.user.internal.operations.impl.executors.RefreshUserOperationExecutor r3 = (com.onesignal.user.internal.operations.impl.executors.RefreshUserOperationExecutor) r3
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ BackendException -> 0x0039 }
            goto L_0x0064
        L_0x0039:
            r0 = move-exception
            goto L_0x0246
        L_0x003c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r0)
            com.onesignal.user.internal.backend.IUserBackendService r0 = r1._userBackend     // Catch:{ BackendException -> 0x0241 }
            java.lang.String r5 = r18.getAppId()     // Catch:{ BackendException -> 0x0241 }
            java.lang.String r8 = "onesignal_id"
            java.lang.String r9 = r18.getOnesignalId()     // Catch:{ BackendException -> 0x0241 }
            r3.L$0 = r1     // Catch:{ BackendException -> 0x0241 }
            r10 = r18
            r3.L$1 = r10     // Catch:{ BackendException -> 0x023f }
            r3.label = r7     // Catch:{ BackendException -> 0x023f }
            java.lang.Object r0 = r0.getUser(r5, r8, r9, r3)     // Catch:{ BackendException -> 0x023f }
            if (r0 != r4) goto L_0x0062
            return r4
        L_0x0062:
            r3 = r1
            r4 = r10
        L_0x0064:
            com.onesignal.user.internal.backend.CreateUserResponse r0 = (com.onesignal.user.internal.backend.CreateUserResponse) r0     // Catch:{ BackendException -> 0x0039 }
            java.lang.String r5 = r4.getOnesignalId()     // Catch:{ BackendException -> 0x0039 }
            com.onesignal.user.internal.identity.IdentityModelStore r8 = r3._identityModelStore     // Catch:{ BackendException -> 0x0039 }
            com.onesignal.common.modeling.Model r8 = r8.getModel()     // Catch:{ BackendException -> 0x0039 }
            com.onesignal.user.internal.identity.IdentityModel r8 = (com.onesignal.user.internal.identity.IdentityModel) r8     // Catch:{ BackendException -> 0x0039 }
            java.lang.String r8 = r8.getOnesignalId()     // Catch:{ BackendException -> 0x0039 }
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r8)     // Catch:{ BackendException -> 0x0039 }
            if (r5 != 0) goto L_0x008b
            com.onesignal.core.internal.operations.ExecutionResponse r0 = new com.onesignal.core.internal.operations.ExecutionResponse     // Catch:{ BackendException -> 0x0039 }
            com.onesignal.core.internal.operations.ExecutionResult r9 = com.onesignal.core.internal.operations.ExecutionResult.SUCCESS     // Catch:{ BackendException -> 0x0039 }
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 14
            r14 = 0
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r13, r14)     // Catch:{ BackendException -> 0x0039 }
            return r0
        L_0x008b:
            com.onesignal.user.internal.identity.IdentityModel r5 = new com.onesignal.user.internal.identity.IdentityModel     // Catch:{ BackendException -> 0x0039 }
            r5.<init>()     // Catch:{ BackendException -> 0x0039 }
            java.util.Map r8 = r0.getIdentities()     // Catch:{ BackendException -> 0x0039 }
            java.util.Set r8 = r8.entrySet()     // Catch:{ BackendException -> 0x0039 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ BackendException -> 0x0039 }
        L_0x009c:
            boolean r9 = r8.hasNext()     // Catch:{ BackendException -> 0x0039 }
            if (r9 == 0) goto L_0x00b7
            java.lang.Object r9 = r8.next()     // Catch:{ BackendException -> 0x0039 }
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9     // Catch:{ BackendException -> 0x0039 }
            r10 = r5
            java.util.Map r10 = (java.util.Map) r10     // Catch:{ BackendException -> 0x0039 }
            java.lang.Object r11 = r9.getKey()     // Catch:{ BackendException -> 0x0039 }
            java.lang.Object r9 = r9.getValue()     // Catch:{ BackendException -> 0x0039 }
            r10.put(r11, r9)     // Catch:{ BackendException -> 0x0039 }
            goto L_0x009c
        L_0x00b7:
            com.onesignal.user.internal.properties.PropertiesModel r8 = new com.onesignal.user.internal.properties.PropertiesModel     // Catch:{ BackendException -> 0x0039 }
            r8.<init>()     // Catch:{ BackendException -> 0x0039 }
            java.lang.String r9 = r4.getOnesignalId()     // Catch:{ BackendException -> 0x0039 }
            r8.setOnesignalId(r9)     // Catch:{ BackendException -> 0x0039 }
            com.onesignal.user.internal.backend.PropertiesObject r9 = r0.getProperties()     // Catch:{ BackendException -> 0x0039 }
            java.lang.String r9 = r9.getCountry()     // Catch:{ BackendException -> 0x0039 }
            if (r9 == 0) goto L_0x00d8
            com.onesignal.user.internal.backend.PropertiesObject r9 = r0.getProperties()     // Catch:{ BackendException -> 0x0039 }
            java.lang.String r9 = r9.getCountry()     // Catch:{ BackendException -> 0x0039 }
            r8.setCountry(r9)     // Catch:{ BackendException -> 0x0039 }
        L_0x00d8:
            com.onesignal.user.internal.backend.PropertiesObject r9 = r0.getProperties()     // Catch:{ BackendException -> 0x0039 }
            java.lang.String r9 = r9.getLanguage()     // Catch:{ BackendException -> 0x0039 }
            if (r9 == 0) goto L_0x00ed
            com.onesignal.user.internal.backend.PropertiesObject r9 = r0.getProperties()     // Catch:{ BackendException -> 0x0039 }
            java.lang.String r9 = r9.getLanguage()     // Catch:{ BackendException -> 0x0039 }
            r8.setLanguage(r9)     // Catch:{ BackendException -> 0x0039 }
        L_0x00ed:
            com.onesignal.user.internal.backend.PropertiesObject r9 = r0.getProperties()     // Catch:{ BackendException -> 0x0039 }
            java.util.Map r9 = r9.getTags()     // Catch:{ BackendException -> 0x0039 }
            if (r9 == 0) goto L_0x012e
            com.onesignal.user.internal.backend.PropertiesObject r9 = r0.getProperties()     // Catch:{ BackendException -> 0x0039 }
            java.util.Map r9 = r9.getTags()     // Catch:{ BackendException -> 0x0039 }
            java.util.Set r9 = r9.entrySet()     // Catch:{ BackendException -> 0x0039 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ BackendException -> 0x0039 }
        L_0x0107:
            boolean r10 = r9.hasNext()     // Catch:{ BackendException -> 0x0039 }
            if (r10 == 0) goto L_0x012e
            java.lang.Object r10 = r9.next()     // Catch:{ BackendException -> 0x0039 }
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10     // Catch:{ BackendException -> 0x0039 }
            java.lang.Object r11 = r10.getValue()     // Catch:{ BackendException -> 0x0039 }
            if (r11 == 0) goto L_0x0107
            com.onesignal.common.modeling.MapModel r11 = r8.getTags()     // Catch:{ BackendException -> 0x0039 }
            java.util.Map r11 = (java.util.Map) r11     // Catch:{ BackendException -> 0x0039 }
            java.lang.Object r12 = r10.getKey()     // Catch:{ BackendException -> 0x0039 }
            java.lang.Object r10 = r10.getValue()     // Catch:{ BackendException -> 0x0039 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)     // Catch:{ BackendException -> 0x0039 }
            r11.put(r12, r10)     // Catch:{ BackendException -> 0x0039 }
            goto L_0x0107
        L_0x012e:
            com.onesignal.user.internal.backend.PropertiesObject r9 = r0.getProperties()     // Catch:{ BackendException -> 0x0039 }
            java.lang.String r9 = r9.getTimezoneId()     // Catch:{ BackendException -> 0x0039 }
            if (r9 == 0) goto L_0x0143
            com.onesignal.user.internal.backend.PropertiesObject r9 = r0.getProperties()     // Catch:{ BackendException -> 0x0039 }
            java.lang.String r9 = r9.getTimezoneId()     // Catch:{ BackendException -> 0x0039 }
            r8.setTimezone(r9)     // Catch:{ BackendException -> 0x0039 }
        L_0x0143:
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ BackendException -> 0x0039 }
            r9.<init>()     // Catch:{ BackendException -> 0x0039 }
            java.util.List r9 = (java.util.List) r9     // Catch:{ BackendException -> 0x0039 }
            java.util.List r0 = r0.getSubscriptions()     // Catch:{ BackendException -> 0x0039 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ BackendException -> 0x0039 }
        L_0x0152:
            boolean r10 = r0.hasNext()     // Catch:{ BackendException -> 0x0039 }
            if (r10 == 0) goto L_0x0201
            java.lang.Object r10 = r0.next()     // Catch:{ BackendException -> 0x0039 }
            com.onesignal.user.internal.backend.SubscriptionObject r10 = (com.onesignal.user.internal.backend.SubscriptionObject) r10     // Catch:{ BackendException -> 0x0039 }
            com.onesignal.user.internal.subscriptions.SubscriptionModel r11 = new com.onesignal.user.internal.subscriptions.SubscriptionModel     // Catch:{ BackendException -> 0x0039 }
            r11.<init>()     // Catch:{ BackendException -> 0x0039 }
            java.lang.String r12 = r10.getId()     // Catch:{ BackendException -> 0x0039 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)     // Catch:{ BackendException -> 0x0039 }
            r11.setId(r12)     // Catch:{ BackendException -> 0x0039 }
            java.lang.String r12 = r10.getToken()     // Catch:{ BackendException -> 0x0039 }
            java.lang.String r13 = ""
            if (r12 != 0) goto L_0x0176
            r12 = r13
        L_0x0176:
            r11.setAddress(r12)     // Catch:{ BackendException -> 0x0039 }
            com.onesignal.user.internal.subscriptions.SubscriptionStatus$Companion r12 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.Companion     // Catch:{ BackendException -> 0x0039 }
            java.lang.Integer r14 = r10.getNotificationTypes()     // Catch:{ BackendException -> 0x0039 }
            if (r14 == 0) goto L_0x0186
            int r14 = r14.intValue()     // Catch:{ BackendException -> 0x0039 }
            goto L_0x018c
        L_0x0186:
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r14 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.SUBSCRIBED     // Catch:{ BackendException -> 0x0039 }
            int r14 = r14.getValue()     // Catch:{ BackendException -> 0x0039 }
        L_0x018c:
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r12 = r12.fromInt(r14)     // Catch:{ BackendException -> 0x0039 }
            if (r12 != 0) goto L_0x0194
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r12 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.SUBSCRIBED     // Catch:{ BackendException -> 0x0039 }
        L_0x0194:
            r11.setStatus(r12)     // Catch:{ BackendException -> 0x0039 }
            com.onesignal.user.internal.backend.SubscriptionObjectType r12 = r10.getType()     // Catch:{ BackendException -> 0x0039 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)     // Catch:{ BackendException -> 0x0039 }
            int[] r14 = com.onesignal.user.internal.operations.impl.executors.RefreshUserOperationExecutor.WhenMappings.$EnumSwitchMapping$0     // Catch:{ BackendException -> 0x0039 }
            int r12 = r12.ordinal()     // Catch:{ BackendException -> 0x0039 }
            r12 = r14[r12]     // Catch:{ BackendException -> 0x0039 }
            if (r12 == r7) goto L_0x01b0
            if (r12 == r6) goto L_0x01ad
            com.onesignal.user.internal.subscriptions.SubscriptionType r12 = com.onesignal.user.internal.subscriptions.SubscriptionType.PUSH     // Catch:{ BackendException -> 0x0039 }
            goto L_0x01b2
        L_0x01ad:
            com.onesignal.user.internal.subscriptions.SubscriptionType r12 = com.onesignal.user.internal.subscriptions.SubscriptionType.SMS     // Catch:{ BackendException -> 0x0039 }
            goto L_0x01b2
        L_0x01b0:
            com.onesignal.user.internal.subscriptions.SubscriptionType r12 = com.onesignal.user.internal.subscriptions.SubscriptionType.EMAIL     // Catch:{ BackendException -> 0x0039 }
        L_0x01b2:
            r11.setType(r12)     // Catch:{ BackendException -> 0x0039 }
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r12 = r11.getStatus()     // Catch:{ BackendException -> 0x0039 }
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r14 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.UNSUBSCRIBE     // Catch:{ BackendException -> 0x0039 }
            if (r12 == r14) goto L_0x01c7
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r12 = r11.getStatus()     // Catch:{ BackendException -> 0x0039 }
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r14 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.DISABLED_FROM_REST_API_DEFAULT_REASON     // Catch:{ BackendException -> 0x0039 }
            if (r12 == r14) goto L_0x01c7
            r12 = r7
            goto L_0x01c8
        L_0x01c7:
            r12 = 0
        L_0x01c8:
            r11.setOptedIn(r12)     // Catch:{ BackendException -> 0x0039 }
            java.lang.String r12 = r10.getSdk()     // Catch:{ BackendException -> 0x0039 }
            if (r12 != 0) goto L_0x01d2
            r12 = r13
        L_0x01d2:
            r11.setSdk(r12)     // Catch:{ BackendException -> 0x0039 }
            java.lang.String r12 = r10.getDeviceOS()     // Catch:{ BackendException -> 0x0039 }
            if (r12 != 0) goto L_0x01dc
            r12 = r13
        L_0x01dc:
            r11.setDeviceOS(r12)     // Catch:{ BackendException -> 0x0039 }
            java.lang.String r12 = r10.getCarrier()     // Catch:{ BackendException -> 0x0039 }
            if (r12 != 0) goto L_0x01e6
            r12 = r13
        L_0x01e6:
            r11.setCarrier(r12)     // Catch:{ BackendException -> 0x0039 }
            java.lang.String r10 = r10.getAppVersion()     // Catch:{ BackendException -> 0x0039 }
            if (r10 != 0) goto L_0x01f0
            goto L_0x01f1
        L_0x01f0:
            r13 = r10
        L_0x01f1:
            r11.setAppVersion(r13)     // Catch:{ BackendException -> 0x0039 }
            com.onesignal.user.internal.subscriptions.SubscriptionType r10 = r11.getType()     // Catch:{ BackendException -> 0x0039 }
            com.onesignal.user.internal.subscriptions.SubscriptionType r12 = com.onesignal.user.internal.subscriptions.SubscriptionType.PUSH     // Catch:{ BackendException -> 0x0039 }
            if (r10 == r12) goto L_0x0152
            r9.add(r11)     // Catch:{ BackendException -> 0x0039 }
            goto L_0x0152
        L_0x0201:
            com.onesignal.core.internal.config.ConfigModelStore r0 = r3._configModelStore     // Catch:{ BackendException -> 0x0039 }
            com.onesignal.common.modeling.Model r0 = r0.getModel()     // Catch:{ BackendException -> 0x0039 }
            com.onesignal.core.internal.config.ConfigModel r0 = (com.onesignal.core.internal.config.ConfigModel) r0     // Catch:{ BackendException -> 0x0039 }
            java.lang.String r0 = r0.getPushSubscriptionId()     // Catch:{ BackendException -> 0x0039 }
            if (r0 == 0) goto L_0x021c
            com.onesignal.user.internal.subscriptions.SubscriptionModelStore r10 = r3._subscriptionsModelStore     // Catch:{ BackendException -> 0x0039 }
            com.onesignal.common.modeling.Model r0 = r10.get(r0)     // Catch:{ BackendException -> 0x0039 }
            com.onesignal.user.internal.subscriptions.SubscriptionModel r0 = (com.onesignal.user.internal.subscriptions.SubscriptionModel) r0     // Catch:{ BackendException -> 0x0039 }
            if (r0 == 0) goto L_0x021c
            r9.add(r0)     // Catch:{ BackendException -> 0x0039 }
        L_0x021c:
            com.onesignal.user.internal.identity.IdentityModelStore r0 = r3._identityModelStore     // Catch:{ BackendException -> 0x0039 }
            com.onesignal.common.modeling.Model r5 = (com.onesignal.common.modeling.Model) r5     // Catch:{ BackendException -> 0x0039 }
            r0.replace(r5, r2)     // Catch:{ BackendException -> 0x0039 }
            com.onesignal.user.internal.properties.PropertiesModelStore r0 = r3._propertiesModelStore     // Catch:{ BackendException -> 0x0039 }
            com.onesignal.common.modeling.Model r8 = (com.onesignal.common.modeling.Model) r8     // Catch:{ BackendException -> 0x0039 }
            r0.replace(r8, r2)     // Catch:{ BackendException -> 0x0039 }
            com.onesignal.user.internal.subscriptions.SubscriptionModelStore r0 = r3._subscriptionsModelStore     // Catch:{ BackendException -> 0x0039 }
            r0.replaceAll(r9, r2)     // Catch:{ BackendException -> 0x0039 }
            com.onesignal.core.internal.operations.ExecutionResponse r0 = new com.onesignal.core.internal.operations.ExecutionResponse     // Catch:{ BackendException -> 0x0039 }
            com.onesignal.core.internal.operations.ExecutionResult r11 = com.onesignal.core.internal.operations.ExecutionResult.SUCCESS     // Catch:{ BackendException -> 0x0039 }
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 14
            r16 = 0
            r10 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16)     // Catch:{ BackendException -> 0x0039 }
            return r0
        L_0x023f:
            r0 = move-exception
            goto L_0x0244
        L_0x0241:
            r0 = move-exception
            r10 = r18
        L_0x0244:
            r3 = r1
            r4 = r10
        L_0x0246:
            com.onesignal.common.NetworkUtils r2 = com.onesignal.common.NetworkUtils.INSTANCE
            int r5 = r0.getStatusCode()
            com.onesignal.common.NetworkUtils$ResponseStatusType r2 = r2.getResponseStatusType(r5)
            int[] r5 = com.onesignal.user.internal.operations.impl.executors.RefreshUserOperationExecutor.WhenMappings.$EnumSwitchMapping$1
            int r2 = r2.ordinal()
            r2 = r5[r2]
            if (r2 == r7) goto L_0x02d6
            if (r2 == r6) goto L_0x02c4
            r5 = 3
            if (r2 == r5) goto L_0x026f
            com.onesignal.core.internal.operations.ExecutionResponse r0 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r7 = com.onesignal.core.internal.operations.ExecutionResult.FAIL_NORETRY
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 14
            r12 = 0
            r6 = r0
            r6.<init>(r7, r8, r9, r10, r11, r12)
            goto L_0x02e8
        L_0x026f:
            int r2 = r0.getStatusCode()
            r5 = 404(0x194, float:5.66E-43)
            if (r2 != r5) goto L_0x0294
            com.onesignal.user.internal.operations.impl.states.NewRecordsState r2 = r3._newRecordState
            java.lang.String r5 = r4.getOnesignalId()
            boolean r2 = r2.isInMissingRetryWindow(r5)
            if (r2 == 0) goto L_0x0294
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
        L_0x0294:
            com.onesignal.user.internal.builduser.IRebuildUserService r2 = r3._buildUserService
            java.lang.String r3 = r4.getAppId()
            java.lang.String r4 = r4.getOnesignalId()
            java.util.List r8 = r2.getRebuildOperationsIfCurrentUser(r3, r4)
            if (r8 != 0) goto L_0x02b3
            com.onesignal.core.internal.operations.ExecutionResponse r0 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r10 = com.onesignal.core.internal.operations.ExecutionResult.FAIL_NORETRY
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 14
            r15 = 0
            r9 = r0
            r9.<init>(r10, r11, r12, r13, r14, r15)
            goto L_0x02c3
        L_0x02b3:
            com.onesignal.core.internal.operations.ExecutionResponse r2 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r6 = com.onesignal.core.internal.operations.ExecutionResult.FAIL_RETRY
            r7 = 0
            java.lang.Integer r9 = r0.getRetryAfterSeconds()
            r10 = 2
            r11 = 0
            r5 = r2
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r0 = r2
        L_0x02c3:
            return r0
        L_0x02c4:
            com.onesignal.core.internal.operations.ExecutionResponse r9 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r3 = com.onesignal.core.internal.operations.ExecutionResult.FAIL_UNAUTHORIZED
            r4 = 0
            r5 = 0
            java.lang.Integer r6 = r0.getRetryAfterSeconds()
            r7 = 6
            r8 = 0
            r2 = r9
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r0 = r9
            goto L_0x02e8
        L_0x02d6:
            com.onesignal.core.internal.operations.ExecutionResponse r2 = new com.onesignal.core.internal.operations.ExecutionResponse
            com.onesignal.core.internal.operations.ExecutionResult r11 = com.onesignal.core.internal.operations.ExecutionResult.FAIL_RETRY
            r12 = 0
            r13 = 0
            java.lang.Integer r14 = r0.getRetryAfterSeconds()
            r15 = 6
            r16 = 0
            r10 = r2
            r10.<init>(r11, r12, r13, r14, r15, r16)
            r0 = r2
        L_0x02e8:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.operations.impl.executors.RefreshUserOperationExecutor.getUser(com.onesignal.user.internal.operations.RefreshUserOperation, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/onesignal/user/internal/operations/impl/executors/RefreshUserOperationExecutor$Companion;", "", "()V", "REFRESH_USER", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: RefreshUserOperationExecutor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
