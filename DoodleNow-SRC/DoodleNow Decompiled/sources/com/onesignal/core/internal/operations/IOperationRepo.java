package com.onesignal.core.internal.operations;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u00020\u0006\"\b\b\u0000\u0010\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\nH&J\u001a\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u0006H&J#\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u0006H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0003H&\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/onesignal/core/internal/operations/IOperationRepo;", "", "awaitInitialized", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "containsInstanceOf", "", "T", "Lcom/onesignal/core/internal/operations/Operation;", "type", "Lkotlin/reflect/KClass;", "enqueue", "operation", "flush", "enqueueAndWait", "(Lcom/onesignal/core/internal/operations/Operation;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "forceExecuteOperations", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: IOperationRepo.kt */
public interface IOperationRepo {
    Object awaitInitialized(Continuation<? super Unit> continuation);

    <T extends Operation> boolean containsInstanceOf(KClass<T> kClass);

    void enqueue(Operation operation, boolean z);

    Object enqueueAndWait(Operation operation, boolean z, Continuation<? super Boolean> continuation);

    void forceExecuteOperations();

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: IOperationRepo.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void enqueue$default(IOperationRepo iOperationRepo, Operation operation, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                iOperationRepo.enqueue(operation, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enqueue");
        }

        public static /* synthetic */ Object enqueueAndWait$default(IOperationRepo iOperationRepo, Operation operation, boolean z, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                return iOperationRepo.enqueueAndWait(operation, z, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enqueueAndWait");
        }
    }
}
