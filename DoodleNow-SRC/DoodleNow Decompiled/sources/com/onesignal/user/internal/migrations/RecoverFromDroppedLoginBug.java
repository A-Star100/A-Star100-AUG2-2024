package com.onesignal.user.internal.migrations;

import com.onesignal.common.IDManager;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.operations.IOperationRepo;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.user.internal.identity.IdentityModel;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.operations.LoginUserOperation;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/onesignal/user/internal/migrations/RecoverFromDroppedLoginBug;", "Lcom/onesignal/core/internal/startup/IStartableService;", "_operationRepo", "Lcom/onesignal/core/internal/operations/IOperationRepo;", "_identityModelStore", "Lcom/onesignal/user/internal/identity/IdentityModelStore;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "(Lcom/onesignal/core/internal/operations/IOperationRepo;Lcom/onesignal/user/internal/identity/IdentityModelStore;Lcom/onesignal/core/internal/config/ConfigModelStore;)V", "isInBadState", "", "recoverByAddingBackDroppedLoginOperation", "", "start", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: RecoverFromDroppedLoginBug.kt */
public final class RecoverFromDroppedLoginBug implements IStartableService {
    private final ConfigModelStore _configModelStore;
    /* access modifiers changed from: private */
    public final IdentityModelStore _identityModelStore;
    /* access modifiers changed from: private */
    public final IOperationRepo _operationRepo;

    public RecoverFromDroppedLoginBug(IOperationRepo iOperationRepo, IdentityModelStore identityModelStore, ConfigModelStore configModelStore) {
        Intrinsics.checkNotNullParameter(iOperationRepo, "_operationRepo");
        Intrinsics.checkNotNullParameter(identityModelStore, "_identityModelStore");
        Intrinsics.checkNotNullParameter(configModelStore, "_configModelStore");
        this._operationRepo = iOperationRepo;
        this._identityModelStore = identityModelStore;
        this._configModelStore = configModelStore;
    }

    public void start() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new RecoverFromDroppedLoginBug$start$1(this, (Continuation<? super RecoverFromDroppedLoginBug$start$1>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final boolean isInBadState() {
        return ((IdentityModel) this._identityModelStore.getModel()).getExternalId() != null && IDManager.INSTANCE.isLocalId(((IdentityModel) this._identityModelStore.getModel()).getOnesignalId()) && !this._operationRepo.containsInstanceOf(Reflection.getOrCreateKotlinClass(LoginUserOperation.class));
    }

    /* access modifiers changed from: private */
    public final void recoverByAddingBackDroppedLoginOperation() {
        IOperationRepo.DefaultImpls.enqueue$default(this._operationRepo, new LoginUserOperation(((ConfigModel) this._configModelStore.getModel()).getAppId(), ((IdentityModel) this._identityModelStore.getModel()).getOnesignalId(), ((IdentityModel) this._identityModelStore.getModel()).getExternalId(), (String) null), false, 2, (Object) null);
    }
}
