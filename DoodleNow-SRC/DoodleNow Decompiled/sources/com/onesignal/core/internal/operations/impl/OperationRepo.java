package com.onesignal.core.internal.operations.impl;

import com.onesignal.common.threading.WaiterWithValue;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.operations.ExecutionResult;
import com.onesignal.core.internal.operations.GroupComparisonType;
import com.onesignal.core.internal.operations.IOperationExecutor;
import com.onesignal.core.internal.operations.IOperationRepo;
import com.onesignal.core.internal.operations.Operation;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.user.internal.operations.impl.states.NewRecordsState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.ThreadPoolDispatcherKt;
import kotlinx.coroutines.TimeoutKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0002KLB3\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0011\u0010'\u001a\u00020\u001bH@ø\u0001\u0000¢\u0006\u0002\u0010(J \u0010)\u001a\u00020\u001d\"\b\b\u0000\u0010**\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u0002H*0-H\u0016J#\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u00020\u00122\b\u00100\u001a\u0004\u0018\u00010\u0012H@ø\u0001\u0000¢\u0006\u0002\u00101J\u0018\u00102\u001a\u00020\u001b2\u0006\u00103\u001a\u00020+2\u0006\u00104\u001a\u00020\u001dH\u0016J!\u00105\u001a\u00020\u001d2\u0006\u00103\u001a\u00020+2\u0006\u00104\u001a\u00020\u001dH@ø\u0001\u0000¢\u0006\u0002\u00106J!\u00107\u001a\u00020\u001b2\f\u00108\u001a\b\u0012\u0004\u0012\u00020 0\u0004H@ø\u0001\u0000¢\u0006\u0004\b9\u0010:J\b\u0010;\u001a\u00020\u001bH\u0016J\u0016\u0010<\u001a\b\u0012\u0004\u0012\u00020 0\u00042\u0006\u0010=\u001a\u00020 H\u0002J\u001d\u0010>\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u00042\u0006\u0010?\u001a\u00020\u0012H\u0000¢\u0006\u0002\b@J1\u0010A\u001a\u00020\u001b2\u0006\u0010B\u001a\u00020 2\u0006\u00104\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020\u001d2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010EJ\r\u0010F\u001a\u00020\u001bH\u0000¢\u0006\u0002\bGJ\u0011\u0010H\u001a\u00020\u001bH@ø\u0001\u0000¢\u0006\u0002\u0010(J\b\u0010I\u001a\u00020\u001bH\u0016J\u0011\u0010J\u001a\u00020\u001bH@ø\u0001\u0000¢\u0006\u0002\u0010(R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00050\u0017X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006M"}, d2 = {"Lcom/onesignal/core/internal/operations/impl/OperationRepo;", "Lcom/onesignal/core/internal/operations/IOperationRepo;", "Lcom/onesignal/core/internal/startup/IStartableService;", "executors", "", "Lcom/onesignal/core/internal/operations/IOperationExecutor;", "_operationModelStore", "Lcom/onesignal/core/internal/operations/impl/OperationModelStore;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "_newRecordState", "Lcom/onesignal/user/internal/operations/impl/states/NewRecordsState;", "(Ljava/util/List;Lcom/onesignal/core/internal/operations/impl/OperationModelStore;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/core/internal/time/ITime;Lcom/onesignal/user/internal/operations/impl/states/NewRecordsState;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "enqueueIntoBucket", "", "executeBucket", "getExecuteBucket", "()I", "executorsMap", "", "", "initialized", "Lkotlinx/coroutines/CompletableDeferred;", "", "paused", "", "queue", "", "Lcom/onesignal/core/internal/operations/impl/OperationRepo$OperationQueueItem;", "getQueue$com_onesignal_core", "()Ljava/util/List;", "retryWaiter", "Lcom/onesignal/common/threading/WaiterWithValue;", "Lcom/onesignal/core/internal/operations/impl/OperationRepo$LoopWaiterMessage;", "waiter", "awaitInitialized", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "containsInstanceOf", "T", "Lcom/onesignal/core/internal/operations/Operation;", "type", "Lkotlin/reflect/KClass;", "delayBeforeNextExecution", "retries", "retryAfterSeconds", "(ILjava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enqueue", "operation", "flush", "enqueueAndWait", "(Lcom/onesignal/core/internal/operations/Operation;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeOperations", "ops", "executeOperations$com_onesignal_core", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "forceExecuteOperations", "getGroupableOperations", "startingOp", "getNextOps", "bucketFilter", "getNextOps$com_onesignal_core", "internalEnqueue", "queueItem", "addToStore", "index", "(Lcom/onesignal/core/internal/operations/impl/OperationRepo$OperationQueueItem;ZZLjava/lang/Integer;)V", "loadSavedOperations", "loadSavedOperations$com_onesignal_core", "processQueueForever", "start", "waitForNewOperationAndExecutionInterval", "LoopWaiterMessage", "OperationQueueItem", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: OperationRepo.kt */
public final class OperationRepo implements IOperationRepo, IStartableService {
    private final ConfigModelStore _configModelStore;
    private final NewRecordsState _newRecordState;
    private final OperationModelStore _operationModelStore;
    private final ITime _time;
    private CoroutineScope coroutineScope = CoroutineScopeKt.CoroutineScope(ThreadPoolDispatcherKt.newSingleThreadContext("OpRepo"));
    private int enqueueIntoBucket;
    private final Map<String, IOperationExecutor> executorsMap;
    private final CompletableDeferred<Unit> initialized = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
    private boolean paused;
    private final List<OperationQueueItem> queue = new ArrayList();
    /* access modifiers changed from: private */
    public final WaiterWithValue<LoopWaiterMessage> retryWaiter = new WaiterWithValue<>();
    /* access modifiers changed from: private */
    public final WaiterWithValue<LoopWaiterMessage> waiter = new WaiterWithValue<>();

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: OperationRepo.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ExecutionResult.values().length];
            iArr[ExecutionResult.SUCCESS.ordinal()] = 1;
            iArr[ExecutionResult.FAIL_UNAUTHORIZED.ordinal()] = 2;
            iArr[ExecutionResult.FAIL_NORETRY.ordinal()] = 3;
            iArr[ExecutionResult.FAIL_CONFLICT.ordinal()] = 4;
            iArr[ExecutionResult.SUCCESS_STARTING_ONLY.ordinal()] = 5;
            iArr[ExecutionResult.FAIL_RETRY.ordinal()] = 6;
            iArr[ExecutionResult.FAIL_PAUSE_OPREPO.ordinal()] = 7;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final int getExecuteBucket() {
        int i = this.enqueueIntoBucket;
        if (i == 0) {
            return 0;
        }
        return i - 1;
    }

    public final List<OperationQueueItem> getQueue$com_onesignal_core() {
        return this.queue;
    }

    public OperationRepo(List<? extends IOperationExecutor> list, OperationModelStore operationModelStore, ConfigModelStore configModelStore, ITime iTime, NewRecordsState newRecordsState) {
        Intrinsics.checkNotNullParameter(list, "executors");
        Intrinsics.checkNotNullParameter(operationModelStore, "_operationModelStore");
        Intrinsics.checkNotNullParameter(configModelStore, "_configModelStore");
        Intrinsics.checkNotNullParameter(iTime, "_time");
        Intrinsics.checkNotNullParameter(newRecordsState, "_newRecordState");
        this._operationModelStore = operationModelStore;
        this._configModelStore = configModelStore;
        this._time = iTime;
        this._newRecordState = newRecordsState;
        Map<String, IOperationExecutor> linkedHashMap = new LinkedHashMap<>();
        for (IOperationExecutor iOperationExecutor : list) {
            for (String put : iOperationExecutor.getOperations()) {
                linkedHashMap.put(put, iOperationExecutor);
            }
        }
        this.executorsMap = linkedHashMap;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\t\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/onesignal/core/internal/operations/impl/OperationRepo$OperationQueueItem;", "", "operation", "Lcom/onesignal/core/internal/operations/Operation;", "waiter", "Lcom/onesignal/common/threading/WaiterWithValue;", "", "bucket", "", "retries", "(Lcom/onesignal/core/internal/operations/Operation;Lcom/onesignal/common/threading/WaiterWithValue;II)V", "getBucket", "()I", "getOperation", "()Lcom/onesignal/core/internal/operations/Operation;", "getRetries", "setRetries", "(I)V", "getWaiter", "()Lcom/onesignal/common/threading/WaiterWithValue;", "toString", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: OperationRepo.kt */
    public static final class OperationQueueItem {
        private final int bucket;
        private final Operation operation;
        private int retries;
        private final WaiterWithValue<Boolean> waiter;

        public final int getBucket() {
            return this.bucket;
        }

        public final Operation getOperation() {
            return this.operation;
        }

        public final int getRetries() {
            return this.retries;
        }

        public final WaiterWithValue<Boolean> getWaiter() {
            return this.waiter;
        }

        public final void setRetries(int i) {
            this.retries = i;
        }

        public OperationQueueItem(Operation operation2, WaiterWithValue<Boolean> waiterWithValue, int i, int i2) {
            Intrinsics.checkNotNullParameter(operation2, "operation");
            this.operation = operation2;
            this.waiter = waiterWithValue;
            this.bucket = i;
            this.retries = i2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ OperationQueueItem(Operation operation2, WaiterWithValue waiterWithValue, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(operation2, (i3 & 2) != 0 ? null : waiterWithValue, i, (i3 & 8) != 0 ? 0 : i2);
        }

        public String toString() {
            return "bucket:" + this.bucket + ", retries:" + this.retries + ", operation:" + this.operation + 10;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/onesignal/core/internal/operations/impl/OperationRepo$LoopWaiterMessage;", "", "force", "", "previousWaitedTime", "", "(ZJ)V", "getForce", "()Z", "getPreviousWaitedTime", "()J", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: OperationRepo.kt */
    public static final class LoopWaiterMessage {
        private final boolean force;
        private final long previousWaitedTime;

        public final boolean getForce() {
            return this.force;
        }

        public final long getPreviousWaitedTime() {
            return this.previousWaitedTime;
        }

        public LoopWaiterMessage(boolean z, long j) {
            this.force = z;
            this.previousWaitedTime = j;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ LoopWaiterMessage(boolean z, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, (i & 2) != 0 ? 0 : j);
        }
    }

    public Object awaitInitialized(Continuation<? super Unit> continuation) {
        Object await = this.initialized.await(continuation);
        return await == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? await : Unit.INSTANCE;
    }

    public <T extends Operation> boolean containsInstanceOf(KClass<T> kClass) {
        boolean z;
        Intrinsics.checkNotNullParameter(kClass, "type");
        synchronized (this.queue) {
            Iterable iterable = this.queue;
            z = false;
            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                Iterator it = iterable.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (kClass.isInstance(((OperationQueueItem) it.next()).getOperation())) {
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return z;
    }

    public void start() {
        this.paused = false;
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new OperationRepo$start$1(this, (Continuation<? super OperationRepo$start$1>) null), 3, (Object) null);
    }

    public void enqueue(Operation operation, boolean z) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        LogLevel logLevel = LogLevel.DEBUG;
        Logging.log(logLevel, "OperationRepo.enqueue(operation: " + operation + ", flush: " + z + ')');
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        operation.setId(uuid);
        internalEnqueue$default(this, new OperationQueueItem(operation, (WaiterWithValue) null, this.enqueueIntoBucket, 0, 10, (DefaultConstructorMarker) null), z, true, (Integer) null, 8, (Object) null);
    }

    public Object enqueueAndWait(Operation operation, boolean z, Continuation<? super Boolean> continuation) {
        LogLevel logLevel = LogLevel.DEBUG;
        Logging.log(logLevel, "OperationRepo.enqueueAndWait(operation: " + operation + ", force: " + z + ')');
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        operation.setId(uuid);
        WaiterWithValue waiterWithValue = new WaiterWithValue();
        internalEnqueue$default(this, new OperationQueueItem(operation, waiterWithValue, this.enqueueIntoBucket, 0, 8, (DefaultConstructorMarker) null), z, true, (Integer) null, 8, (Object) null);
        return waiterWithValue.waitForWake(continuation);
    }

    static /* synthetic */ void internalEnqueue$default(OperationRepo operationRepo, OperationQueueItem operationQueueItem, boolean z, boolean z2, Integer num, int i, Object obj) {
        if ((i & 8) != 0) {
            num = null;
        }
        operationRepo.internalEnqueue(operationQueueItem, z, z2, num);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0078, code lost:
        if (r9 == false) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007a, code lost:
        com.onesignal.common.modeling.IModelStore.DefaultImpls.add$default(r6._operationModelStore, r7.getOperation(), (java.lang.String) null, 2, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0087, code lost:
        r6.waiter.wake(new com.onesignal.core.internal.operations.impl.OperationRepo.LoopWaiterMessage(r8, 0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0093, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void internalEnqueue(com.onesignal.core.internal.operations.impl.OperationRepo.OperationQueueItem r7, boolean r8, boolean r9, java.lang.Integer r10) {
        /*
            r6 = this;
            java.util.List<com.onesignal.core.internal.operations.impl.OperationRepo$OperationQueueItem> r0 = r6.queue
            monitor-enter(r0)
            java.util.List<com.onesignal.core.internal.operations.impl.OperationRepo$OperationQueueItem> r1 = r6.queue     // Catch:{ all -> 0x0094 }
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch:{ all -> 0x0094 }
            boolean r2 = r1 instanceof java.util.Collection     // Catch:{ all -> 0x0094 }
            r3 = 2
            r4 = 0
            if (r2 == 0) goto L_0x0017
            r2 = r1
            java.util.Collection r2 = (java.util.Collection) r2     // Catch:{ all -> 0x0094 }
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x0094 }
            if (r2 == 0) goto L_0x0017
            goto L_0x0060
        L_0x0017:
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0094 }
        L_0x001b:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0094 }
            if (r2 == 0) goto L_0x0060
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0094 }
            com.onesignal.core.internal.operations.impl.OperationRepo$OperationQueueItem r2 = (com.onesignal.core.internal.operations.impl.OperationRepo.OperationQueueItem) r2     // Catch:{ all -> 0x0094 }
            com.onesignal.core.internal.operations.Operation r2 = r2.getOperation()     // Catch:{ all -> 0x0094 }
            java.lang.String r2 = r2.getId()     // Catch:{ all -> 0x0094 }
            com.onesignal.core.internal.operations.Operation r5 = r7.getOperation()     // Catch:{ all -> 0x0094 }
            java.lang.String r5 = r5.getId()     // Catch:{ all -> 0x0094 }
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r5)     // Catch:{ all -> 0x0094 }
            if (r2 == 0) goto L_0x001b
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0094 }
            r8.<init>()     // Catch:{ all -> 0x0094 }
            java.lang.String r9 = "OperationRepo: internalEnqueue - operation.id: "
            r8.append(r9)     // Catch:{ all -> 0x0094 }
            com.onesignal.core.internal.operations.Operation r7 = r7.getOperation()     // Catch:{ all -> 0x0094 }
            java.lang.String r7 = r7.getId()     // Catch:{ all -> 0x0094 }
            r8.append(r7)     // Catch:{ all -> 0x0094 }
            java.lang.String r7 = " already exists in the queue."
            r8.append(r7)     // Catch:{ all -> 0x0094 }
            java.lang.String r7 = r8.toString()     // Catch:{ all -> 0x0094 }
            com.onesignal.debug.internal.logging.Logging.debug$default(r7, r4, r3, r4)     // Catch:{ all -> 0x0094 }
            monitor-exit(r0)
            return
        L_0x0060:
            if (r10 == 0) goto L_0x006e
            java.util.List<com.onesignal.core.internal.operations.impl.OperationRepo$OperationQueueItem> r1 = r6.queue     // Catch:{ all -> 0x0094 }
            int r10 = r10.intValue()     // Catch:{ all -> 0x0094 }
            r1.add(r10, r7)     // Catch:{ all -> 0x0094 }
            kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0094 }
            goto L_0x0077
        L_0x006e:
            java.util.List<com.onesignal.core.internal.operations.impl.OperationRepo$OperationQueueItem> r10 = r6.queue     // Catch:{ all -> 0x0094 }
            boolean r10 = r10.add(r7)     // Catch:{ all -> 0x0094 }
            java.lang.Boolean.valueOf(r10)     // Catch:{ all -> 0x0094 }
        L_0x0077:
            monitor-exit(r0)
            if (r9 == 0) goto L_0x0087
            com.onesignal.core.internal.operations.impl.OperationModelStore r9 = r6._operationModelStore
            com.onesignal.common.modeling.IModelStore r9 = (com.onesignal.common.modeling.IModelStore) r9
            com.onesignal.core.internal.operations.Operation r7 = r7.getOperation()
            com.onesignal.common.modeling.Model r7 = (com.onesignal.common.modeling.Model) r7
            com.onesignal.common.modeling.IModelStore.DefaultImpls.add$default(r9, r7, r4, r3, r4)
        L_0x0087:
            com.onesignal.common.threading.WaiterWithValue<com.onesignal.core.internal.operations.impl.OperationRepo$LoopWaiterMessage> r7 = r6.waiter
            com.onesignal.core.internal.operations.impl.OperationRepo$LoopWaiterMessage r9 = new com.onesignal.core.internal.operations.impl.OperationRepo$LoopWaiterMessage
            r0 = 0
            r9.<init>(r8, r0)
            r7.wake(r9)
            return
        L_0x0094:
            r7 = move-exception
            monitor-exit(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.core.internal.operations.impl.OperationRepo.internalEnqueue(com.onesignal.core.internal.operations.impl.OperationRepo$OperationQueueItem, boolean, boolean, java.lang.Integer):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object processQueueForever(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.onesignal.core.internal.operations.impl.OperationRepo$processQueueForever$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            com.onesignal.core.internal.operations.impl.OperationRepo$processQueueForever$1 r0 = (com.onesignal.core.internal.operations.impl.OperationRepo$processQueueForever$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            com.onesignal.core.internal.operations.impl.OperationRepo$processQueueForever$1 r0 = new com.onesignal.core.internal.operations.impl.OperationRepo$processQueueForever$1
            r0.<init>(r10, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L_0x0058
            if (r2 == r6) goto L_0x0050
            if (r2 == r5) goto L_0x0048
            if (r2 == r4) goto L_0x0040
            if (r2 != r3) goto L_0x0038
            java.lang.Object r2 = r0.L$0
            com.onesignal.core.internal.operations.impl.OperationRepo r2 = (com.onesignal.core.internal.operations.impl.OperationRepo) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00c1
        L_0x0038:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0040:
            java.lang.Object r2 = r0.L$0
            com.onesignal.core.internal.operations.impl.OperationRepo r2 = (com.onesignal.core.internal.operations.impl.OperationRepo) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x006c
        L_0x0048:
            java.lang.Object r2 = r0.L$0
            com.onesignal.core.internal.operations.impl.OperationRepo r2 = (com.onesignal.core.internal.operations.impl.OperationRepo) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x009f
        L_0x0050:
            java.lang.Object r2 = r0.L$0
            com.onesignal.core.internal.operations.impl.OperationRepo r2 = (com.onesignal.core.internal.operations.impl.OperationRepo) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0067
        L_0x0058:
            kotlin.ResultKt.throwOnFailure(r11)
            r0.L$0 = r10
            r0.label = r6
            java.lang.Object r11 = r10.waitForNewOperationAndExecutionInterval(r0)
            if (r11 != r1) goto L_0x0066
            return r1
        L_0x0066:
            r2 = r10
        L_0x0067:
            int r11 = r2.enqueueIntoBucket
            int r11 = r11 + r6
            r2.enqueueIntoBucket = r11
        L_0x006c:
            boolean r11 = r2.paused
            r7 = 0
            if (r11 == 0) goto L_0x0079
            java.lang.String r11 = "OperationRepo is paused"
            com.onesignal.debug.internal.logging.Logging.debug$default(r11, r7, r5, r7)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x0079:
            int r11 = r2.getExecuteBucket()
            java.util.List r11 = r2.getNextOps$com_onesignal_core(r11)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "processQueueForever:ops:\n"
            r8.<init>(r9)
            r8.append(r11)
            java.lang.String r8 = r8.toString()
            com.onesignal.debug.internal.logging.Logging.debug$default(r8, r7, r5, r7)
            if (r11 == 0) goto L_0x00b6
            r0.L$0 = r2
            r0.label = r5
            java.lang.Object r11 = r2.executeOperations$com_onesignal_core(r11, r0)
            if (r11 != r1) goto L_0x009f
            return r1
        L_0x009f:
            com.onesignal.core.internal.config.ConfigModelStore r11 = r2._configModelStore
            com.onesignal.common.modeling.Model r11 = r11.getModel()
            com.onesignal.core.internal.config.ConfigModel r11 = (com.onesignal.core.internal.config.ConfigModel) r11
            long r7 = r11.getOpRepoPostWakeDelay()
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r11 = kotlinx.coroutines.DelayKt.delay(r7, r0)
            if (r11 != r1) goto L_0x006c
            return r1
        L_0x00b6:
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r11 = r2.waitForNewOperationAndExecutionInterval(r0)
            if (r11 != r1) goto L_0x00c1
            return r1
        L_0x00c1:
            int r11 = r2.enqueueIntoBucket
            int r11 = r11 + r6
            r2.enqueueIntoBucket = r11
            goto L_0x006c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.core.internal.operations.impl.OperationRepo.processQueueForever(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void forceExecuteOperations() {
        this.retryWaiter.wake(new LoopWaiterMessage(true, 0, 2, (DefaultConstructorMarker) null));
        this.waiter.wake(new LoopWaiterMessage(false, 0, 2, (DefaultConstructorMarker) null));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object waitForNewOperationAndExecutionInterval(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.onesignal.core.internal.operations.impl.OperationRepo$waitForNewOperationAndExecutionInterval$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            com.onesignal.core.internal.operations.impl.OperationRepo$waitForNewOperationAndExecutionInterval$1 r0 = (com.onesignal.core.internal.operations.impl.OperationRepo$waitForNewOperationAndExecutionInterval$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            com.onesignal.core.internal.operations.impl.OperationRepo$waitForNewOperationAndExecutionInterval$1 r0 = new com.onesignal.core.internal.operations.impl.OperationRepo$waitForNewOperationAndExecutionInterval$1
            r0.<init>(r10, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x004d
            if (r2 == r4) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            java.lang.Object r2 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            java.lang.Object r4 = r0.L$0
            com.onesignal.core.internal.operations.impl.OperationRepo r4 = (com.onesignal.core.internal.operations.impl.OperationRepo) r4
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00a2
        L_0x0035:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x003d:
            java.lang.Object r2 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            java.lang.Object r4 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref.ObjectRef) r4
            java.lang.Object r5 = r0.L$0
            com.onesignal.core.internal.operations.impl.OperationRepo r5 = (com.onesignal.core.internal.operations.impl.OperationRepo) r5
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0068
        L_0x004d:
            kotlin.ResultKt.throwOnFailure(r11)
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            com.onesignal.common.threading.WaiterWithValue<com.onesignal.core.internal.operations.impl.OperationRepo$LoopWaiterMessage> r11 = r10.waiter
            r0.L$0 = r10
            r0.L$1 = r2
            r0.L$2 = r2
            r0.label = r4
            java.lang.Object r11 = r11.waitForWake(r0)
            if (r11 != r1) goto L_0x0066
            return r1
        L_0x0066:
            r5 = r10
            r4 = r2
        L_0x0068:
            r2.element = r11
            com.onesignal.core.internal.config.ConfigModelStore r11 = r5._configModelStore
            com.onesignal.common.modeling.Model r11 = r11.getModel()
            com.onesignal.core.internal.config.ConfigModel r11 = (com.onesignal.core.internal.config.ConfigModel) r11
            long r6 = r11.getOpRepoExecutionInterval()
            T r11 = r4.element
            com.onesignal.core.internal.operations.impl.OperationRepo$LoopWaiterMessage r11 = (com.onesignal.core.internal.operations.impl.OperationRepo.LoopWaiterMessage) r11
            long r8 = r11.getPreviousWaitedTime()
            long r6 = r6 - r8
            r2 = r4
            r4 = r5
        L_0x0081:
            T r11 = r2.element
            com.onesignal.core.internal.operations.impl.OperationRepo$LoopWaiterMessage r11 = (com.onesignal.core.internal.operations.impl.OperationRepo.LoopWaiterMessage) r11
            boolean r11 = r11.getForce()
            if (r11 != 0) goto L_0x00b2
            com.onesignal.core.internal.operations.impl.OperationRepo$waitForNewOperationAndExecutionInterval$waitedTheFullTime$1 r11 = new com.onesignal.core.internal.operations.impl.OperationRepo$waitForNewOperationAndExecutionInterval$waitedTheFullTime$1
            r5 = 0
            r11.<init>(r2, r4, r5)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r0.L$0 = r4
            r0.L$1 = r2
            r0.L$2 = r5
            r0.label = r3
            java.lang.Object r11 = kotlinx.coroutines.TimeoutKt.withTimeoutOrNull(r6, r11, r0)
            if (r11 != r1) goto L_0x00a2
            return r1
        L_0x00a2:
            if (r11 != 0) goto L_0x00a5
            goto L_0x00b2
        L_0x00a5:
            com.onesignal.core.internal.config.ConfigModelStore r11 = r4._configModelStore
            com.onesignal.common.modeling.Model r11 = r11.getModel()
            com.onesignal.core.internal.config.ConfigModel r11 = (com.onesignal.core.internal.config.ConfigModel) r11
            long r6 = r11.getOpRepoExecutionInterval()
            goto L_0x0081
        L_0x00b2:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.core.internal.operations.impl.OperationRepo.waitForNewOperationAndExecutionInterval(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    public final java.lang.Object executeOperations$com_onesignal_core(java.util.List<com.onesignal.core.internal.operations.impl.OperationRepo.OperationQueueItem> r25, kotlin.coroutines.Continuation<? super kotlin.Unit> r26) {
        /*
            r24 = this;
            r1 = r24
            r2 = r25
            r0 = r26
            java.lang.String r3 = "Could not find executor for operation "
            boolean r4 = r0 instanceof com.onesignal.core.internal.operations.impl.OperationRepo$executeOperations$1
            if (r4 == 0) goto L_0x001c
            r4 = r0
            com.onesignal.core.internal.operations.impl.OperationRepo$executeOperations$1 r4 = (com.onesignal.core.internal.operations.impl.OperationRepo$executeOperations$1) r4
            int r5 = r4.label
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r5 & r6
            if (r5 == 0) goto L_0x001c
            int r0 = r4.label
            int r0 = r0 - r6
            r4.label = r0
            goto L_0x0021
        L_0x001c:
            com.onesignal.core.internal.operations.impl.OperationRepo$executeOperations$1 r4 = new com.onesignal.core.internal.operations.impl.OperationRepo$executeOperations$1
            r4.<init>(r1, r0)
        L_0x0021:
            java.lang.Object r0 = r4.result
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r6 = r4.label
            r7 = 3
            r8 = 0
            r9 = 1
            r10 = 2
            r11 = 0
            if (r6 == 0) goto L_0x008a
            if (r6 == r9) goto L_0x006d
            if (r6 == r10) goto L_0x004e
            if (r6 != r7) goto L_0x0046
            java.lang.Object r2 = r4.L$1
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r3 = r4.L$0
            com.onesignal.core.internal.operations.impl.OperationRepo r3 = (com.onesignal.core.internal.operations.impl.OperationRepo) r3
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0043 }
            goto L_0x046f
        L_0x0043:
            r0 = move-exception
            goto L_0x0419
        L_0x0046:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x004e:
            long r2 = r4.J$0
            java.lang.Object r6 = r4.L$4
            com.onesignal.core.internal.operations.ExecutionResponse r6 = (com.onesignal.core.internal.operations.ExecutionResponse) r6
            java.lang.Object r12 = r4.L$3
            java.util.List r12 = (java.util.List) r12
            java.lang.Object r13 = r4.L$2
            com.onesignal.core.internal.operations.impl.OperationRepo$OperationQueueItem r13 = (com.onesignal.core.internal.operations.impl.OperationRepo.OperationQueueItem) r13
            java.lang.Object r14 = r4.L$1
            java.util.List r14 = (java.util.List) r14
            java.lang.Object r15 = r4.L$0
            com.onesignal.core.internal.operations.impl.OperationRepo r15 = (com.onesignal.core.internal.operations.impl.OperationRepo) r15
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0069 }
            goto L_0x0191
        L_0x0069:
            r0 = move-exception
            r3 = r15
            goto L_0x041a
        L_0x006d:
            java.lang.Object r2 = r4.L$3
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r3 = r4.L$2
            com.onesignal.core.internal.operations.impl.OperationRepo$OperationQueueItem r3 = (com.onesignal.core.internal.operations.impl.OperationRepo.OperationQueueItem) r3
            java.lang.Object r6 = r4.L$1
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r12 = r4.L$0
            com.onesignal.core.internal.operations.impl.OperationRepo r12 = (com.onesignal.core.internal.operations.impl.OperationRepo) r12
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0085 }
            r13 = r3
            r3 = r12
            r12 = r2
            r2 = r6
            goto L_0x00e3
        L_0x0085:
            r0 = move-exception
            r14 = r6
            r3 = r12
            goto L_0x041a
        L_0x008a:
            kotlin.ResultKt.throwOnFailure(r0)
            java.lang.Object r0 = kotlin.collections.CollectionsKt.first(r25)     // Catch:{ all -> 0x0417 }
            com.onesignal.core.internal.operations.impl.OperationRepo$OperationQueueItem r0 = (com.onesignal.core.internal.operations.impl.OperationRepo.OperationQueueItem) r0     // Catch:{ all -> 0x0417 }
            java.util.Map<java.lang.String, com.onesignal.core.internal.operations.IOperationExecutor> r6 = r1.executorsMap     // Catch:{ all -> 0x0417 }
            com.onesignal.core.internal.operations.Operation r12 = r0.getOperation()     // Catch:{ all -> 0x0417 }
            java.lang.String r12 = r12.getName()     // Catch:{ all -> 0x0417 }
            java.lang.Object r6 = r6.get(r12)     // Catch:{ all -> 0x0417 }
            com.onesignal.core.internal.operations.IOperationExecutor r6 = (com.onesignal.core.internal.operations.IOperationExecutor) r6     // Catch:{ all -> 0x0417 }
            if (r6 == 0) goto L_0x03fd
            r3 = r2
            java.lang.Iterable r3 = (java.lang.Iterable) r3     // Catch:{ all -> 0x0417 }
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ all -> 0x0417 }
            r13 = 10
            int r13 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r3, r13)     // Catch:{ all -> 0x0417 }
            r12.<init>(r13)     // Catch:{ all -> 0x0417 }
            java.util.Collection r12 = (java.util.Collection) r12     // Catch:{ all -> 0x0417 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0417 }
        L_0x00b9:
            boolean r13 = r3.hasNext()     // Catch:{ all -> 0x0417 }
            if (r13 == 0) goto L_0x00cd
            java.lang.Object r13 = r3.next()     // Catch:{ all -> 0x0417 }
            com.onesignal.core.internal.operations.impl.OperationRepo$OperationQueueItem r13 = (com.onesignal.core.internal.operations.impl.OperationRepo.OperationQueueItem) r13     // Catch:{ all -> 0x0417 }
            com.onesignal.core.internal.operations.Operation r13 = r13.getOperation()     // Catch:{ all -> 0x0417 }
            r12.add(r13)     // Catch:{ all -> 0x0417 }
            goto L_0x00b9
        L_0x00cd:
            java.util.List r12 = (java.util.List) r12     // Catch:{ all -> 0x0417 }
            r4.L$0 = r1     // Catch:{ all -> 0x0417 }
            r4.L$1 = r2     // Catch:{ all -> 0x0417 }
            r4.L$2 = r0     // Catch:{ all -> 0x0417 }
            r4.L$3 = r12     // Catch:{ all -> 0x0417 }
            r4.label = r9     // Catch:{ all -> 0x0417 }
            java.lang.Object r3 = r6.execute(r12, r4)     // Catch:{ all -> 0x0417 }
            if (r3 != r5) goto L_0x00e0
            return r5
        L_0x00e0:
            r13 = r0
            r0 = r3
            r3 = r1
        L_0x00e3:
            r6 = r0
            com.onesignal.core.internal.operations.ExecutionResponse r6 = (com.onesignal.core.internal.operations.ExecutionResponse) r6     // Catch:{ all -> 0x0043 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0043 }
            r0.<init>()     // Catch:{ all -> 0x0043 }
            java.lang.String r14 = "OperationRepo: execute response = "
            r0.append(r14)     // Catch:{ all -> 0x0043 }
            com.onesignal.core.internal.operations.ExecutionResult r14 = r6.getResult()     // Catch:{ all -> 0x0043 }
            r0.append(r14)     // Catch:{ all -> 0x0043 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0043 }
            com.onesignal.debug.internal.logging.Logging.debug$default(r0, r11, r10, r11)     // Catch:{ all -> 0x0043 }
            java.util.Map r0 = r6.getIdTranslations()     // Catch:{ all -> 0x0043 }
            if (r0 == 0) goto L_0x01b4
            r0 = r2
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch:{ all -> 0x0043 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0043 }
        L_0x010b:
            boolean r14 = r0.hasNext()     // Catch:{ all -> 0x0043 }
            if (r14 == 0) goto L_0x0123
            java.lang.Object r14 = r0.next()     // Catch:{ all -> 0x0043 }
            com.onesignal.core.internal.operations.impl.OperationRepo$OperationQueueItem r14 = (com.onesignal.core.internal.operations.impl.OperationRepo.OperationQueueItem) r14     // Catch:{ all -> 0x0043 }
            com.onesignal.core.internal.operations.Operation r14 = r14.getOperation()     // Catch:{ all -> 0x0043 }
            java.util.Map r15 = r6.getIdTranslations()     // Catch:{ all -> 0x0043 }
            r14.translateIds(r15)     // Catch:{ all -> 0x0043 }
            goto L_0x010b
        L_0x0123:
            java.util.List<com.onesignal.core.internal.operations.impl.OperationRepo$OperationQueueItem> r14 = r3.queue     // Catch:{ all -> 0x0043 }
            monitor-enter(r14)     // Catch:{ all -> 0x0043 }
            java.util.List<com.onesignal.core.internal.operations.impl.OperationRepo$OperationQueueItem> r0 = r3.queue     // Catch:{ all -> 0x01b1 }
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch:{ all -> 0x01b1 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x01b1 }
        L_0x012e:
            boolean r15 = r0.hasNext()     // Catch:{ all -> 0x01b1 }
            if (r15 == 0) goto L_0x0147
            java.lang.Object r15 = r0.next()     // Catch:{ all -> 0x01b1 }
            com.onesignal.core.internal.operations.impl.OperationRepo$OperationQueueItem r15 = (com.onesignal.core.internal.operations.impl.OperationRepo.OperationQueueItem) r15     // Catch:{ all -> 0x01b1 }
            com.onesignal.core.internal.operations.Operation r15 = r15.getOperation()     // Catch:{ all -> 0x01b1 }
            java.util.Map r7 = r6.getIdTranslations()     // Catch:{ all -> 0x01b1 }
            r15.translateIds(r7)     // Catch:{ all -> 0x01b1 }
            r7 = 3
            goto L_0x012e
        L_0x0147:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x01b1 }
            monitor-exit(r14)     // Catch:{ all -> 0x0043 }
            java.util.Map r0 = r6.getIdTranslations()     // Catch:{ all -> 0x0043 }
            java.util.Collection r0 = r0.values()     // Catch:{ all -> 0x0043 }
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch:{ all -> 0x0043 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0043 }
        L_0x0158:
            boolean r7 = r0.hasNext()     // Catch:{ all -> 0x0043 }
            if (r7 == 0) goto L_0x016a
            java.lang.Object r7 = r0.next()     // Catch:{ all -> 0x0043 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x0043 }
            com.onesignal.user.internal.operations.impl.states.NewRecordsState r14 = r3._newRecordState     // Catch:{ all -> 0x0043 }
            r14.add(r7)     // Catch:{ all -> 0x0043 }
            goto L_0x0158
        L_0x016a:
            com.onesignal.core.internal.config.ConfigModelStore r0 = r3._configModelStore     // Catch:{ all -> 0x0043 }
            com.onesignal.common.modeling.Model r0 = r0.getModel()     // Catch:{ all -> 0x0043 }
            com.onesignal.core.internal.config.ConfigModel r0 = (com.onesignal.core.internal.config.ConfigModel) r0     // Catch:{ all -> 0x0043 }
            long r14 = r0.getOpRepoPostCreateDelay()     // Catch:{ all -> 0x0043 }
            r4.L$0 = r3     // Catch:{ all -> 0x0043 }
            r4.L$1 = r2     // Catch:{ all -> 0x0043 }
            r4.L$2 = r13     // Catch:{ all -> 0x0043 }
            r4.L$3 = r12     // Catch:{ all -> 0x0043 }
            r4.L$4 = r6     // Catch:{ all -> 0x0043 }
            r4.J$0 = r14     // Catch:{ all -> 0x0043 }
            r4.label = r10     // Catch:{ all -> 0x0043 }
            java.lang.Object r0 = kotlinx.coroutines.DelayKt.delay(r14, r4)     // Catch:{ all -> 0x0043 }
            if (r0 != r5) goto L_0x018b
            return r5
        L_0x018b:
            r22 = r14
            r14 = r2
            r15 = r3
            r2 = r22
        L_0x0191:
            java.util.List<com.onesignal.core.internal.operations.impl.OperationRepo$OperationQueueItem> r7 = r15.queue     // Catch:{ all -> 0x0069 }
            monitor-enter(r7)     // Catch:{ all -> 0x0069 }
            java.util.List<com.onesignal.core.internal.operations.impl.OperationRepo$OperationQueueItem> r0 = r15.queue     // Catch:{ all -> 0x01ae }
            java.util.Collection r0 = (java.util.Collection) r0     // Catch:{ all -> 0x01ae }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x01ae }
            r0 = r0 ^ r9
            if (r0 == 0) goto L_0x01a9
            com.onesignal.common.threading.WaiterWithValue<com.onesignal.core.internal.operations.impl.OperationRepo$LoopWaiterMessage> r0 = r15.waiter     // Catch:{ all -> 0x01ae }
            com.onesignal.core.internal.operations.impl.OperationRepo$LoopWaiterMessage r9 = new com.onesignal.core.internal.operations.impl.OperationRepo$LoopWaiterMessage     // Catch:{ all -> 0x01ae }
            r9.<init>(r8, r2)     // Catch:{ all -> 0x01ae }
            r0.wake(r9)     // Catch:{ all -> 0x01ae }
        L_0x01a9:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x01ae }
            monitor-exit(r7)     // Catch:{ all -> 0x0069 }
            r3 = r15
            goto L_0x01b5
        L_0x01ae:
            r0 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0069 }
            throw r0     // Catch:{ all -> 0x0069 }
        L_0x01b1:
            r0 = move-exception
            monitor-exit(r14)     // Catch:{ all -> 0x0043 }
            throw r0     // Catch:{ all -> 0x0043 }
        L_0x01b4:
            r14 = r2
        L_0x01b5:
            kotlin.jvm.internal.Ref$IntRef r0 = new kotlin.jvm.internal.Ref$IntRef     // Catch:{ all -> 0x03fb }
            r0.<init>()     // Catch:{ all -> 0x03fb }
            com.onesignal.core.internal.operations.ExecutionResult r2 = r6.getResult()     // Catch:{ all -> 0x03fb }
            int[] r7 = com.onesignal.core.internal.operations.impl.OperationRepo.WhenMappings.$EnumSwitchMapping$0     // Catch:{ all -> 0x03fb }
            int r2 = r2.ordinal()     // Catch:{ all -> 0x03fb }
            r2 = r7[r2]     // Catch:{ all -> 0x03fb }
            switch(r2) {
                case 1: goto L_0x032e;
                case 2: goto L_0x02d4;
                case 3: goto L_0x02d4;
                case 4: goto L_0x02d4;
                case 5: goto L_0x0261;
                case 6: goto L_0x020c;
                case 7: goto L_0x01cb;
                default: goto L_0x01c9;
            }     // Catch:{ all -> 0x03fb }
        L_0x01c9:
            goto L_0x0377
        L_0x01cb:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x03fb }
            r2.<init>()     // Catch:{ all -> 0x03fb }
            java.lang.String r7 = "Operation execution failed with eventual retry, pausing the operation repo: "
            r2.append(r7)     // Catch:{ all -> 0x03fb }
            r2.append(r12)     // Catch:{ all -> 0x03fb }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x03fb }
            com.onesignal.debug.internal.logging.Logging.error$default(r2, r11, r10, r11)     // Catch:{ all -> 0x03fb }
            r2 = 1
            r3.paused = r2     // Catch:{ all -> 0x03fb }
            java.util.List<com.onesignal.core.internal.operations.impl.OperationRepo$OperationQueueItem> r2 = r3.queue     // Catch:{ all -> 0x03fb }
            monitor-enter(r2)     // Catch:{ all -> 0x03fb }
            r7 = r14
            java.lang.Iterable r7 = (java.lang.Iterable) r7     // Catch:{ all -> 0x0209 }
            java.util.List r7 = kotlin.collections.CollectionsKt.reversed(r7)     // Catch:{ all -> 0x0209 }
            java.lang.Iterable r7 = (java.lang.Iterable) r7     // Catch:{ all -> 0x0209 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x0209 }
        L_0x01f2:
            boolean r9 = r7.hasNext()     // Catch:{ all -> 0x0209 }
            if (r9 == 0) goto L_0x0204
            java.lang.Object r9 = r7.next()     // Catch:{ all -> 0x0209 }
            com.onesignal.core.internal.operations.impl.OperationRepo$OperationQueueItem r9 = (com.onesignal.core.internal.operations.impl.OperationRepo.OperationQueueItem) r9     // Catch:{ all -> 0x0209 }
            java.util.List<com.onesignal.core.internal.operations.impl.OperationRepo$OperationQueueItem> r12 = r3.queue     // Catch:{ all -> 0x0209 }
            r12.add(r8, r9)     // Catch:{ all -> 0x0209 }
            goto L_0x01f2
        L_0x0204:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0209 }
            monitor-exit(r2)     // Catch:{ all -> 0x03fb }
            goto L_0x0377
        L_0x0209:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x03fb }
            throw r0     // Catch:{ all -> 0x03fb }
        L_0x020c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x03fb }
            r2.<init>()     // Catch:{ all -> 0x03fb }
            java.lang.String r7 = "Operation execution failed, retrying: "
            r2.append(r7)     // Catch:{ all -> 0x03fb }
            r2.append(r12)     // Catch:{ all -> 0x03fb }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x03fb }
            com.onesignal.debug.internal.logging.Logging.error$default(r2, r11, r10, r11)     // Catch:{ all -> 0x03fb }
            java.util.List<com.onesignal.core.internal.operations.impl.OperationRepo$OperationQueueItem> r2 = r3.queue     // Catch:{ all -> 0x03fb }
            monitor-enter(r2)     // Catch:{ all -> 0x03fb }
            r7 = r14
            java.lang.Iterable r7 = (java.lang.Iterable) r7     // Catch:{ all -> 0x025e }
            java.util.List r7 = kotlin.collections.CollectionsKt.reversed(r7)     // Catch:{ all -> 0x025e }
            java.lang.Iterable r7 = (java.lang.Iterable) r7     // Catch:{ all -> 0x025e }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x025e }
        L_0x0230:
            boolean r9 = r7.hasNext()     // Catch:{ all -> 0x025e }
            if (r9 == 0) goto L_0x0259
            java.lang.Object r9 = r7.next()     // Catch:{ all -> 0x025e }
            com.onesignal.core.internal.operations.impl.OperationRepo$OperationQueueItem r9 = (com.onesignal.core.internal.operations.impl.OperationRepo.OperationQueueItem) r9     // Catch:{ all -> 0x025e }
            int r12 = r9.getRetries()     // Catch:{ all -> 0x025e }
            r13 = 1
            int r12 = r12 + r13
            r9.setRetries(r12)     // Catch:{ all -> 0x025e }
            int r12 = r9.getRetries()     // Catch:{ all -> 0x025e }
            int r13 = r0.element     // Catch:{ all -> 0x025e }
            if (r12 <= r13) goto L_0x0253
            int r12 = r9.getRetries()     // Catch:{ all -> 0x025e }
            r0.element = r12     // Catch:{ all -> 0x025e }
        L_0x0253:
            java.util.List<com.onesignal.core.internal.operations.impl.OperationRepo$OperationQueueItem> r12 = r3.queue     // Catch:{ all -> 0x025e }
            r12.add(r8, r9)     // Catch:{ all -> 0x025e }
            goto L_0x0230
        L_0x0259:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x025e }
            monitor-exit(r2)     // Catch:{ all -> 0x03fb }
            goto L_0x0377
        L_0x025e:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x03fb }
            throw r0     // Catch:{ all -> 0x03fb }
        L_0x0261:
            com.onesignal.core.internal.operations.impl.OperationModelStore r2 = r3._operationModelStore     // Catch:{ all -> 0x03fb }
            com.onesignal.common.modeling.IModelStore r2 = (com.onesignal.common.modeling.IModelStore) r2     // Catch:{ all -> 0x03fb }
            com.onesignal.core.internal.operations.Operation r7 = r13.getOperation()     // Catch:{ all -> 0x03fb }
            java.lang.String r7 = r7.getId()     // Catch:{ all -> 0x03fb }
            com.onesignal.common.modeling.IModelStore.DefaultImpls.remove$default(r2, r7, r11, r10, r11)     // Catch:{ all -> 0x03fb }
            com.onesignal.common.threading.WaiterWithValue r2 = r13.getWaiter()     // Catch:{ all -> 0x03fb }
            if (r2 == 0) goto L_0x0280
            r7 = 1
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)     // Catch:{ all -> 0x03fb }
            r2.wake(r9)     // Catch:{ all -> 0x03fb }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x03fb }
        L_0x0280:
            java.util.List<com.onesignal.core.internal.operations.impl.OperationRepo$OperationQueueItem> r2 = r3.queue     // Catch:{ all -> 0x03fb }
            monitor-enter(r2)     // Catch:{ all -> 0x03fb }
            r7 = r14
            java.lang.Iterable r7 = (java.lang.Iterable) r7     // Catch:{ all -> 0x02d1 }
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x02d1 }
            r9.<init>()     // Catch:{ all -> 0x02d1 }
            java.util.Collection r9 = (java.util.Collection) r9     // Catch:{ all -> 0x02d1 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x02d1 }
        L_0x0291:
            boolean r12 = r7.hasNext()     // Catch:{ all -> 0x02d1 }
            if (r12 == 0) goto L_0x02ac
            java.lang.Object r12 = r7.next()     // Catch:{ all -> 0x02d1 }
            r15 = r12
            com.onesignal.core.internal.operations.impl.OperationRepo$OperationQueueItem r15 = (com.onesignal.core.internal.operations.impl.OperationRepo.OperationQueueItem) r15     // Catch:{ all -> 0x02d1 }
            boolean r15 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r13)     // Catch:{ all -> 0x02d1 }
            r16 = 1
            r15 = r15 ^ 1
            if (r15 == 0) goto L_0x0291
            r9.add(r12)     // Catch:{ all -> 0x02d1 }
            goto L_0x0291
        L_0x02ac:
            java.util.List r9 = (java.util.List) r9     // Catch:{ all -> 0x02d1 }
            java.lang.Iterable r9 = (java.lang.Iterable) r9     // Catch:{ all -> 0x02d1 }
            java.util.List r7 = kotlin.collections.CollectionsKt.reversed(r9)     // Catch:{ all -> 0x02d1 }
            java.lang.Iterable r7 = (java.lang.Iterable) r7     // Catch:{ all -> 0x02d1 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x02d1 }
        L_0x02ba:
            boolean r9 = r7.hasNext()     // Catch:{ all -> 0x02d1 }
            if (r9 == 0) goto L_0x02cc
            java.lang.Object r9 = r7.next()     // Catch:{ all -> 0x02d1 }
            com.onesignal.core.internal.operations.impl.OperationRepo$OperationQueueItem r9 = (com.onesignal.core.internal.operations.impl.OperationRepo.OperationQueueItem) r9     // Catch:{ all -> 0x02d1 }
            java.util.List<com.onesignal.core.internal.operations.impl.OperationRepo$OperationQueueItem> r12 = r3.queue     // Catch:{ all -> 0x02d1 }
            r12.add(r8, r9)     // Catch:{ all -> 0x02d1 }
            goto L_0x02ba
        L_0x02cc:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x02d1 }
            monitor-exit(r2)     // Catch:{ all -> 0x03fb }
            goto L_0x0377
        L_0x02d1:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x03fb }
            throw r0     // Catch:{ all -> 0x03fb }
        L_0x02d4:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x03fb }
            r2.<init>()     // Catch:{ all -> 0x03fb }
            java.lang.String r7 = "Operation execution failed without retry: "
            r2.append(r7)     // Catch:{ all -> 0x03fb }
            r2.append(r12)     // Catch:{ all -> 0x03fb }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x03fb }
            com.onesignal.debug.internal.logging.Logging.error$default(r2, r11, r10, r11)     // Catch:{ all -> 0x03fb }
            r2 = r14
            java.lang.Iterable r2 = (java.lang.Iterable) r2     // Catch:{ all -> 0x03fb }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x03fb }
        L_0x02ef:
            boolean r7 = r2.hasNext()     // Catch:{ all -> 0x03fb }
            if (r7 == 0) goto L_0x030b
            java.lang.Object r7 = r2.next()     // Catch:{ all -> 0x03fb }
            com.onesignal.core.internal.operations.impl.OperationRepo$OperationQueueItem r7 = (com.onesignal.core.internal.operations.impl.OperationRepo.OperationQueueItem) r7     // Catch:{ all -> 0x03fb }
            com.onesignal.core.internal.operations.impl.OperationModelStore r9 = r3._operationModelStore     // Catch:{ all -> 0x03fb }
            com.onesignal.common.modeling.IModelStore r9 = (com.onesignal.common.modeling.IModelStore) r9     // Catch:{ all -> 0x03fb }
            com.onesignal.core.internal.operations.Operation r7 = r7.getOperation()     // Catch:{ all -> 0x03fb }
            java.lang.String r7 = r7.getId()     // Catch:{ all -> 0x03fb }
            com.onesignal.common.modeling.IModelStore.DefaultImpls.remove$default(r9, r7, r11, r10, r11)     // Catch:{ all -> 0x03fb }
            goto L_0x02ef
        L_0x030b:
            r2 = r14
            java.lang.Iterable r2 = (java.lang.Iterable) r2     // Catch:{ all -> 0x03fb }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x03fb }
        L_0x0312:
            boolean r7 = r2.hasNext()     // Catch:{ all -> 0x03fb }
            if (r7 == 0) goto L_0x0377
            java.lang.Object r7 = r2.next()     // Catch:{ all -> 0x03fb }
            com.onesignal.core.internal.operations.impl.OperationRepo$OperationQueueItem r7 = (com.onesignal.core.internal.operations.impl.OperationRepo.OperationQueueItem) r7     // Catch:{ all -> 0x03fb }
            com.onesignal.common.threading.WaiterWithValue r7 = r7.getWaiter()     // Catch:{ all -> 0x03fb }
            if (r7 == 0) goto L_0x0312
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r8)     // Catch:{ all -> 0x03fb }
            r7.wake(r9)     // Catch:{ all -> 0x03fb }
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x03fb }
            goto L_0x0312
        L_0x032e:
            r2 = r14
            java.lang.Iterable r2 = (java.lang.Iterable) r2     // Catch:{ all -> 0x03fb }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x03fb }
        L_0x0335:
            boolean r7 = r2.hasNext()     // Catch:{ all -> 0x03fb }
            if (r7 == 0) goto L_0x0351
            java.lang.Object r7 = r2.next()     // Catch:{ all -> 0x03fb }
            com.onesignal.core.internal.operations.impl.OperationRepo$OperationQueueItem r7 = (com.onesignal.core.internal.operations.impl.OperationRepo.OperationQueueItem) r7     // Catch:{ all -> 0x03fb }
            com.onesignal.core.internal.operations.impl.OperationModelStore r9 = r3._operationModelStore     // Catch:{ all -> 0x03fb }
            com.onesignal.common.modeling.IModelStore r9 = (com.onesignal.common.modeling.IModelStore) r9     // Catch:{ all -> 0x03fb }
            com.onesignal.core.internal.operations.Operation r7 = r7.getOperation()     // Catch:{ all -> 0x03fb }
            java.lang.String r7 = r7.getId()     // Catch:{ all -> 0x03fb }
            com.onesignal.common.modeling.IModelStore.DefaultImpls.remove$default(r9, r7, r11, r10, r11)     // Catch:{ all -> 0x03fb }
            goto L_0x0335
        L_0x0351:
            r2 = r14
            java.lang.Iterable r2 = (java.lang.Iterable) r2     // Catch:{ all -> 0x03fb }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x03fb }
        L_0x0358:
            boolean r7 = r2.hasNext()     // Catch:{ all -> 0x03fb }
            if (r7 == 0) goto L_0x0377
            java.lang.Object r7 = r2.next()     // Catch:{ all -> 0x03fb }
            com.onesignal.core.internal.operations.impl.OperationRepo$OperationQueueItem r7 = (com.onesignal.core.internal.operations.impl.OperationRepo.OperationQueueItem) r7     // Catch:{ all -> 0x03fb }
            com.onesignal.common.threading.WaiterWithValue r7 = r7.getWaiter()     // Catch:{ all -> 0x03fb }
            if (r7 == 0) goto L_0x0375
            r9 = 1
            java.lang.Boolean r12 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r9)     // Catch:{ all -> 0x03fb }
            r7.wake(r12)     // Catch:{ all -> 0x03fb }
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x03fb }
            goto L_0x0358
        L_0x0375:
            r9 = 1
            goto L_0x0358
        L_0x0377:
            java.util.List r2 = r6.getOperations()     // Catch:{ all -> 0x03fb }
            if (r2 == 0) goto L_0x03e1
            java.util.List<com.onesignal.core.internal.operations.impl.OperationRepo$OperationQueueItem> r2 = r3.queue     // Catch:{ all -> 0x03fb }
            monitor-enter(r2)     // Catch:{ all -> 0x03fb }
            java.util.List r7 = r6.getOperations()     // Catch:{ all -> 0x03de }
            java.lang.Iterable r7 = (java.lang.Iterable) r7     // Catch:{ all -> 0x03de }
            java.util.List r7 = kotlin.collections.CollectionsKt.reversed(r7)     // Catch:{ all -> 0x03de }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x03de }
        L_0x038e:
            boolean r9 = r7.hasNext()     // Catch:{ all -> 0x03de }
            if (r9 == 0) goto L_0x03da
            java.lang.Object r9 = r7.next()     // Catch:{ all -> 0x03de }
            com.onesignal.core.internal.operations.Operation r9 = (com.onesignal.core.internal.operations.Operation) r9     // Catch:{ all -> 0x03de }
            java.util.UUID r12 = java.util.UUID.randomUUID()     // Catch:{ all -> 0x03de }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x03de }
            java.lang.String r13 = "randomUUID().toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r13)     // Catch:{ all -> 0x03de }
            r9.setId(r12)     // Catch:{ all -> 0x03de }
            com.onesignal.core.internal.operations.impl.OperationRepo$OperationQueueItem r12 = new com.onesignal.core.internal.operations.impl.OperationRepo$OperationQueueItem     // Catch:{ all -> 0x03de }
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 10
            r21 = 0
            r15 = r12
            r16 = r9
            r15.<init>(r16, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x03de }
            java.util.List<com.onesignal.core.internal.operations.impl.OperationRepo$OperationQueueItem> r9 = r3.queue     // Catch:{ all -> 0x03de }
            r9.add(r8, r12)     // Catch:{ all -> 0x03de }
            com.onesignal.core.internal.operations.impl.OperationModelStore r9 = r3._operationModelStore     // Catch:{ all -> 0x03de }
            r15 = r9
            com.onesignal.common.modeling.IModelStore r15 = (com.onesignal.common.modeling.IModelStore) r15     // Catch:{ all -> 0x03de }
            r16 = 0
            com.onesignal.core.internal.operations.Operation r9 = r12.getOperation()     // Catch:{ all -> 0x03de }
            r17 = r9
            com.onesignal.common.modeling.Model r17 = (com.onesignal.common.modeling.Model) r17     // Catch:{ all -> 0x03de }
            r18 = 0
            r19 = 4
            r20 = 0
            com.onesignal.common.modeling.IModelStore.DefaultImpls.add$default(r15, r16, r17, r18, r19, r20)     // Catch:{ all -> 0x03de }
            goto L_0x038e
        L_0x03da:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x03de }
            monitor-exit(r2)     // Catch:{ all -> 0x03fb }
            goto L_0x03e1
        L_0x03de:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x03fb }
            throw r0     // Catch:{ all -> 0x03fb }
        L_0x03e1:
            int r0 = r0.element     // Catch:{ all -> 0x03fb }
            java.lang.Integer r2 = r6.getRetryAfterSeconds()     // Catch:{ all -> 0x03fb }
            r4.L$0 = r3     // Catch:{ all -> 0x03fb }
            r4.L$1 = r14     // Catch:{ all -> 0x03fb }
            r4.L$2 = r11     // Catch:{ all -> 0x03fb }
            r4.L$3 = r11     // Catch:{ all -> 0x03fb }
            r4.L$4 = r11     // Catch:{ all -> 0x03fb }
            r6 = 3
            r4.label = r6     // Catch:{ all -> 0x03fb }
            java.lang.Object r0 = r3.delayBeforeNextExecution(r0, r2, r4)     // Catch:{ all -> 0x03fb }
            if (r0 != r5) goto L_0x046f
            return r5
        L_0x03fb:
            r0 = move-exception
            goto L_0x041a
        L_0x03fd:
            java.lang.Exception r4 = new java.lang.Exception     // Catch:{ all -> 0x0417 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0417 }
            r5.<init>(r3)     // Catch:{ all -> 0x0417 }
            com.onesignal.core.internal.operations.Operation r0 = r0.getOperation()     // Catch:{ all -> 0x0417 }
            java.lang.String r0 = r0.getName()     // Catch:{ all -> 0x0417 }
            r5.append(r0)     // Catch:{ all -> 0x0417 }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x0417 }
            r4.<init>(r0)     // Catch:{ all -> 0x0417 }
            throw r4     // Catch:{ all -> 0x0417 }
        L_0x0417:
            r0 = move-exception
            r3 = r1
        L_0x0419:
            r14 = r2
        L_0x041a:
            com.onesignal.debug.LogLevel r2 = com.onesignal.debug.LogLevel.ERROR
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "Error attempting to execute operation: "
            r4.<init>(r5)
            r4.append(r14)
            java.lang.String r4 = r4.toString()
            com.onesignal.debug.internal.logging.Logging.log(r2, r4, r0)
            java.lang.Iterable r14 = (java.lang.Iterable) r14
            java.util.Iterator r0 = r14.iterator()
        L_0x0433:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x044f
            java.lang.Object r2 = r0.next()
            com.onesignal.core.internal.operations.impl.OperationRepo$OperationQueueItem r2 = (com.onesignal.core.internal.operations.impl.OperationRepo.OperationQueueItem) r2
            com.onesignal.core.internal.operations.impl.OperationModelStore r4 = r3._operationModelStore
            com.onesignal.common.modeling.IModelStore r4 = (com.onesignal.common.modeling.IModelStore) r4
            com.onesignal.core.internal.operations.Operation r2 = r2.getOperation()
            java.lang.String r2 = r2.getId()
            com.onesignal.common.modeling.IModelStore.DefaultImpls.remove$default(r4, r2, r11, r10, r11)
            goto L_0x0433
        L_0x044f:
            java.util.Iterator r0 = r14.iterator()
        L_0x0453:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x046f
            java.lang.Object r2 = r0.next()
            com.onesignal.core.internal.operations.impl.OperationRepo$OperationQueueItem r2 = (com.onesignal.core.internal.operations.impl.OperationRepo.OperationQueueItem) r2
            com.onesignal.common.threading.WaiterWithValue r2 = r2.getWaiter()
            if (r2 == 0) goto L_0x0453
            java.lang.Boolean r3 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r8)
            r2.wake(r3)
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            goto L_0x0453
        L_0x046f:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.core.internal.operations.impl.OperationRepo.executeOperations$com_onesignal_core(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object delayBeforeNextExecution(int i, Integer num, Continuation<? super Unit> continuation) {
        Logging.debug$default("retryAfterSeconds: " + num, (Throwable) null, 2, (Object) null);
        long max = Math.max(((long) i) * ((ConfigModel) this._configModelStore.getModel()).getOpRepoDefaultFailRetryBackoff(), (num != null ? (long) num.intValue() : 0) * ((long) 1000));
        if (max < 1) {
            return Unit.INSTANCE;
        }
        Logging.error$default("Operations being delay for: " + max + " ms", (Throwable) null, 2, (Object) null);
        Object withTimeoutOrNull = TimeoutKt.withTimeoutOrNull(max, new OperationRepo$delayBeforeNextExecution$2(this, (Continuation<? super OperationRepo$delayBeforeNextExecution$2>) null), continuation);
        return withTimeoutOrNull == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withTimeoutOrNull : Unit.INSTANCE;
    }

    public final List<OperationQueueItem> getNextOps$com_onesignal_core(int i) {
        List<OperationQueueItem> list;
        Object obj;
        synchronized (this.queue) {
            Iterator it = this.queue.iterator();
            while (true) {
                list = null;
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                OperationQueueItem operationQueueItem = (OperationQueueItem) obj;
                if (operationQueueItem.getOperation().getCanStartExecute() && this._newRecordState.canAccess(operationQueueItem.getOperation().getApplyToRecordId()) && operationQueueItem.getBucket() <= i) {
                    break;
                }
            }
            OperationQueueItem operationQueueItem2 = (OperationQueueItem) obj;
            if (operationQueueItem2 != null) {
                this.queue.remove(operationQueueItem2);
                list = getGroupableOperations(operationQueueItem2);
            } else {
                List list2 = null;
            }
        }
        return list;
    }

    private final List<OperationQueueItem> getGroupableOperations(OperationQueueItem operationQueueItem) {
        String str;
        String str2;
        List<OperationQueueItem> mutableListOf = CollectionsKt.mutableListOf(operationQueueItem);
        if (operationQueueItem.getOperation().getGroupComparisonType() == GroupComparisonType.NONE) {
            return mutableListOf;
        }
        if (operationQueueItem.getOperation().getGroupComparisonType() == GroupComparisonType.CREATE) {
            str = operationQueueItem.getOperation().getCreateComparisonKey();
        } else {
            str = operationQueueItem.getOperation().getModifyComparisonKey();
        }
        for (OperationQueueItem operationQueueItem2 : CollectionsKt.toList(this.queue)) {
            if (operationQueueItem.getOperation().getGroupComparisonType() == GroupComparisonType.CREATE) {
                str2 = operationQueueItem2.getOperation().getCreateComparisonKey();
            } else {
                str2 = operationQueueItem2.getOperation().getModifyComparisonKey();
            }
            if (Intrinsics.areEqual((Object) str2, (Object) "") && Intrinsics.areEqual((Object) str, (Object) "")) {
                throw new Exception("Both comparison keys can not be blank!");
            } else if (this._newRecordState.canAccess(operationQueueItem2.getOperation().getApplyToRecordId()) && Intrinsics.areEqual((Object) str2, (Object) str)) {
                this.queue.remove(operationQueueItem2);
                mutableListOf.add(operationQueueItem2);
            }
        }
        return mutableListOf;
    }

    public final void loadSavedOperations$com_onesignal_core() {
        this._operationModelStore.loadOperations();
        for (Operation operationQueueItem : CollectionsKt.reversed(this._operationModelStore.list())) {
            internalEnqueue(new OperationQueueItem(operationQueueItem, (WaiterWithValue) null, this.enqueueIntoBucket, 0, 10, (DefaultConstructorMarker) null), false, false, 0);
        }
        this.initialized.complete(Unit.INSTANCE);
    }
}
