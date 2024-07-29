package com.onesignal.user;

import com.onesignal.common.modules.IModule;
import com.onesignal.common.services.ServiceBuilder;
import com.onesignal.core.internal.operations.IOperationExecutor;
import com.onesignal.core.internal.startup.IBootstrapService;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.user.internal.UserManager;
import com.onesignal.user.internal.backend.IIdentityBackendService;
import com.onesignal.user.internal.backend.ISubscriptionBackendService;
import com.onesignal.user.internal.backend.IUserBackendService;
import com.onesignal.user.internal.backend.impl.IdentityBackendService;
import com.onesignal.user.internal.backend.impl.SubscriptionBackendService;
import com.onesignal.user.internal.backend.impl.UserBackendService;
import com.onesignal.user.internal.builduser.IRebuildUserService;
import com.onesignal.user.internal.builduser.impl.RebuildUserService;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.migrations.RecoverFromDroppedLoginBug;
import com.onesignal.user.internal.operations.impl.executors.IdentityOperationExecutor;
import com.onesignal.user.internal.operations.impl.executors.LoginUserFromSubscriptionOperationExecutor;
import com.onesignal.user.internal.operations.impl.executors.LoginUserOperationExecutor;
import com.onesignal.user.internal.operations.impl.executors.RefreshUserOperationExecutor;
import com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor;
import com.onesignal.user.internal.operations.impl.executors.UpdateUserOperationExecutor;
import com.onesignal.user.internal.operations.impl.listeners.IdentityModelStoreListener;
import com.onesignal.user.internal.operations.impl.listeners.PropertiesModelStoreListener;
import com.onesignal.user.internal.operations.impl.listeners.SubscriptionModelStoreListener;
import com.onesignal.user.internal.operations.impl.states.NewRecordsState;
import com.onesignal.user.internal.properties.PropertiesModelStore;
import com.onesignal.user.internal.service.UserRefreshService;
import com.onesignal.user.internal.subscriptions.ISubscriptionManager;
import com.onesignal.user.internal.subscriptions.SubscriptionModelStore;
import com.onesignal.user.internal.subscriptions.impl.SubscriptionManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/onesignal/user/UserModule;", "Lcom/onesignal/common/modules/IModule;", "()V", "register", "", "builder", "Lcom/onesignal/common/services/ServiceBuilder;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: UserModule.kt */
public final class UserModule implements IModule {
    public void register(ServiceBuilder serviceBuilder) {
        Intrinsics.checkNotNullParameter(serviceBuilder, "builder");
        serviceBuilder.register(PropertiesModelStore.class).provides(PropertiesModelStore.class);
        serviceBuilder.register(PropertiesModelStoreListener.class).provides(IBootstrapService.class);
        serviceBuilder.register(IdentityModelStore.class).provides(IdentityModelStore.class);
        serviceBuilder.register(IdentityModelStoreListener.class).provides(IBootstrapService.class);
        serviceBuilder.register(IdentityBackendService.class).provides(IIdentityBackendService.class);
        serviceBuilder.register(IdentityOperationExecutor.class).provides(IdentityOperationExecutor.class).provides(IOperationExecutor.class);
        serviceBuilder.register(SubscriptionModelStore.class).provides(SubscriptionModelStore.class);
        serviceBuilder.register(SubscriptionModelStoreListener.class).provides(IBootstrapService.class);
        serviceBuilder.register(SubscriptionBackendService.class).provides(ISubscriptionBackendService.class);
        serviceBuilder.register(SubscriptionOperationExecutor.class).provides(SubscriptionOperationExecutor.class).provides(IOperationExecutor.class);
        serviceBuilder.register(SubscriptionManager.class).provides(ISubscriptionManager.class);
        serviceBuilder.register(RebuildUserService.class).provides(IRebuildUserService.class);
        serviceBuilder.register(UserBackendService.class).provides(IUserBackendService.class);
        serviceBuilder.register(UpdateUserOperationExecutor.class).provides(UpdateUserOperationExecutor.class).provides(IOperationExecutor.class);
        serviceBuilder.register(LoginUserOperationExecutor.class).provides(IOperationExecutor.class);
        serviceBuilder.register(LoginUserFromSubscriptionOperationExecutor.class).provides(IOperationExecutor.class);
        serviceBuilder.register(RefreshUserOperationExecutor.class).provides(IOperationExecutor.class);
        serviceBuilder.register(UserManager.class).provides(IUserManager.class);
        serviceBuilder.register(UserRefreshService.class).provides(IStartableService.class);
        serviceBuilder.register(RecoverFromDroppedLoginBug.class).provides(IStartableService.class);
        serviceBuilder.register(NewRecordsState.class).provides(NewRecordsState.class);
    }
}
