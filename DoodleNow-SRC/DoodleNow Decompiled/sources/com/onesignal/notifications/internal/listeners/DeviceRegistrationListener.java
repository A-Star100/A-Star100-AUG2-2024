package com.onesignal.notifications.internal.listeners;

import com.onesignal.common.modeling.ISingletonModelStoreChangeHandler;
import com.onesignal.common.modeling.ModelChangeTags;
import com.onesignal.common.modeling.ModelChangedArgs;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.notifications.INotificationsManager;
import com.onesignal.notifications.IPermissionObserver;
import com.onesignal.notifications.internal.channels.INotificationChannelManager;
import com.onesignal.notifications.internal.pushtoken.IPushTokenManager;
import com.onesignal.user.internal.subscriptions.ISubscriptionChangedHandler;
import com.onesignal.user.internal.subscriptions.ISubscriptionManager;
import com.onesignal.user.subscriptions.ISubscription;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u0005B-\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010 \u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010!\u001a\u00020\u0012H\u0002J\b\u0010\"\u001a\u00020\u0012H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/onesignal/notifications/internal/listeners/DeviceRegistrationListener;", "Lcom/onesignal/core/internal/startup/IStartableService;", "Lcom/onesignal/common/modeling/ISingletonModelStoreChangeHandler;", "Lcom/onesignal/core/internal/config/ConfigModel;", "Lcom/onesignal/notifications/IPermissionObserver;", "Lcom/onesignal/user/internal/subscriptions/ISubscriptionChangedHandler;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_channelManager", "Lcom/onesignal/notifications/internal/channels/INotificationChannelManager;", "_pushTokenManager", "Lcom/onesignal/notifications/internal/pushtoken/IPushTokenManager;", "_notificationsManager", "Lcom/onesignal/notifications/INotificationsManager;", "_subscriptionManager", "Lcom/onesignal/user/internal/subscriptions/ISubscriptionManager;", "(Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/notifications/internal/channels/INotificationChannelManager;Lcom/onesignal/notifications/internal/pushtoken/IPushTokenManager;Lcom/onesignal/notifications/INotificationsManager;Lcom/onesignal/user/internal/subscriptions/ISubscriptionManager;)V", "onModelReplaced", "", "model", "tag", "", "onModelUpdated", "args", "Lcom/onesignal/common/modeling/ModelChangedArgs;", "onNotificationPermissionChange", "permission", "", "onSubscriptionAdded", "subscription", "Lcom/onesignal/user/subscriptions/ISubscription;", "onSubscriptionChanged", "onSubscriptionRemoved", "retrievePushTokenAndUpdateSubscription", "start", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: DeviceRegistrationListener.kt */
public final class DeviceRegistrationListener implements IStartableService, ISingletonModelStoreChangeHandler<ConfigModel>, IPermissionObserver, ISubscriptionChangedHandler {
    private final INotificationChannelManager _channelManager;
    private final ConfigModelStore _configModelStore;
    /* access modifiers changed from: private */
    public final INotificationsManager _notificationsManager;
    /* access modifiers changed from: private */
    public final IPushTokenManager _pushTokenManager;
    /* access modifiers changed from: private */
    public final ISubscriptionManager _subscriptionManager;

    public void onModelUpdated(ModelChangedArgs modelChangedArgs, String str) {
        Intrinsics.checkNotNullParameter(modelChangedArgs, "args");
        Intrinsics.checkNotNullParameter(str, "tag");
    }

    public void onSubscriptionAdded(ISubscription iSubscription) {
        Intrinsics.checkNotNullParameter(iSubscription, "subscription");
    }

    public void onSubscriptionRemoved(ISubscription iSubscription) {
        Intrinsics.checkNotNullParameter(iSubscription, "subscription");
    }

    public DeviceRegistrationListener(ConfigModelStore configModelStore, INotificationChannelManager iNotificationChannelManager, IPushTokenManager iPushTokenManager, INotificationsManager iNotificationsManager, ISubscriptionManager iSubscriptionManager) {
        Intrinsics.checkNotNullParameter(configModelStore, "_configModelStore");
        Intrinsics.checkNotNullParameter(iNotificationChannelManager, "_channelManager");
        Intrinsics.checkNotNullParameter(iPushTokenManager, "_pushTokenManager");
        Intrinsics.checkNotNullParameter(iNotificationsManager, "_notificationsManager");
        Intrinsics.checkNotNullParameter(iSubscriptionManager, "_subscriptionManager");
        this._configModelStore = configModelStore;
        this._channelManager = iNotificationChannelManager;
        this._pushTokenManager = iPushTokenManager;
        this._notificationsManager = iNotificationsManager;
        this._subscriptionManager = iSubscriptionManager;
    }

    public void start() {
        this._configModelStore.subscribe(this);
        this._notificationsManager.addPermissionObserver(this);
        this._subscriptionManager.subscribe(this);
    }

    public void onModelReplaced(ConfigModel configModel, String str) {
        Intrinsics.checkNotNullParameter(configModel, "model");
        Intrinsics.checkNotNullParameter(str, "tag");
        if (Intrinsics.areEqual((Object) str, (Object) ModelChangeTags.HYDRATE)) {
            this._channelManager.processChannelList(configModel.getNotificationChannels());
            retrievePushTokenAndUpdateSubscription();
        }
    }

    public void onNotificationPermissionChange(boolean z) {
        retrievePushTokenAndUpdateSubscription();
    }

    private final void retrievePushTokenAndUpdateSubscription() {
        this._subscriptionManager.getSubscriptions().getPush();
        ThreadUtilsKt.suspendifyOnThread$default(0, new DeviceRegistrationListener$retrievePushTokenAndUpdateSubscription$1(this, (Continuation<? super DeviceRegistrationListener$retrievePushTokenAndUpdateSubscription$1>) null), 1, (Object) null);
    }

    public void onSubscriptionChanged(ISubscription iSubscription, ModelChangedArgs modelChangedArgs) {
        Intrinsics.checkNotNullParameter(iSubscription, "subscription");
        Intrinsics.checkNotNullParameter(modelChangedArgs, "args");
        if (Intrinsics.areEqual((Object) modelChangedArgs.getPath(), (Object) "optedIn") && Intrinsics.areEqual(modelChangedArgs.getNewValue(), (Object) true) && !this._notificationsManager.getPermission()) {
            ThreadUtilsKt.suspendifyOnThread$default(0, new DeviceRegistrationListener$onSubscriptionChanged$2(this, (Continuation<? super DeviceRegistrationListener$onSubscriptionChanged$2>) null), 1, (Object) null);
        }
    }
}
