package com.onesignal.core.internal.config.impl;

import com.onesignal.common.modeling.ISingletonModelStoreChangeHandler;
import com.onesignal.common.modeling.ModelChangeTags;
import com.onesignal.common.modeling.ModelChangedArgs;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.internal.backend.IParamsBackendService;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.user.internal.subscriptions.ISubscriptionManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00152\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0015B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/onesignal/core/internal/config/impl/ConfigModelStoreListener;", "Lcom/onesignal/core/internal/startup/IStartableService;", "Lcom/onesignal/common/modeling/ISingletonModelStoreChangeHandler;", "Lcom/onesignal/core/internal/config/ConfigModel;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_paramsBackendService", "Lcom/onesignal/core/internal/backend/IParamsBackendService;", "_subscriptionManager", "Lcom/onesignal/user/internal/subscriptions/ISubscriptionManager;", "(Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/core/internal/backend/IParamsBackendService;Lcom/onesignal/user/internal/subscriptions/ISubscriptionManager;)V", "fetchParams", "", "onModelReplaced", "model", "tag", "", "onModelUpdated", "args", "Lcom/onesignal/common/modeling/ModelChangedArgs;", "start", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ConfigModelStoreListener.kt */
public final class ConfigModelStoreListener implements IStartableService, ISingletonModelStoreChangeHandler<ConfigModel> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int INCREASE_BETWEEN_RETRIES = 10000;
    private static final int MAX_WAIT_BETWEEN_RETRIES = 90000;
    private static final int MIN_WAIT_BETWEEN_RETRIES = 30000;
    /* access modifiers changed from: private */
    public final ConfigModelStore _configModelStore;
    /* access modifiers changed from: private */
    public final IParamsBackendService _paramsBackendService;
    /* access modifiers changed from: private */
    public final ISubscriptionManager _subscriptionManager;

    public ConfigModelStoreListener(ConfigModelStore configModelStore, IParamsBackendService iParamsBackendService, ISubscriptionManager iSubscriptionManager) {
        Intrinsics.checkNotNullParameter(configModelStore, "_configModelStore");
        Intrinsics.checkNotNullParameter(iParamsBackendService, "_paramsBackendService");
        Intrinsics.checkNotNullParameter(iSubscriptionManager, "_subscriptionManager");
        this._configModelStore = configModelStore;
        this._paramsBackendService = iParamsBackendService;
        this._subscriptionManager = iSubscriptionManager;
    }

    public void start() {
        this._configModelStore.subscribe(this);
        fetchParams();
    }

    public void onModelUpdated(ModelChangedArgs modelChangedArgs, String str) {
        Intrinsics.checkNotNullParameter(modelChangedArgs, "args");
        Intrinsics.checkNotNullParameter(str, "tag");
        if (Intrinsics.areEqual((Object) modelChangedArgs.getProperty(), (Object) "appId")) {
            fetchParams();
        }
    }

    public void onModelReplaced(ConfigModel configModel, String str) {
        Intrinsics.checkNotNullParameter(configModel, "model");
        Intrinsics.checkNotNullParameter(str, "tag");
        if (Intrinsics.areEqual((Object) str, (Object) ModelChangeTags.NORMAL)) {
            fetchParams();
        }
    }

    private final void fetchParams() {
        String appId = ((ConfigModel) this._configModelStore.getModel()).getAppId();
        if (appId.length() != 0) {
            ThreadUtilsKt.suspendifyOnThread$default(0, new ConfigModelStoreListener$fetchParams$1(appId, this, (Continuation<? super ConfigModelStoreListener$fetchParams$1>) null), 1, (Object) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/onesignal/core/internal/config/impl/ConfigModelStoreListener$Companion;", "", "()V", "INCREASE_BETWEEN_RETRIES", "", "MAX_WAIT_BETWEEN_RETRIES", "MIN_WAIT_BETWEEN_RETRIES", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ConfigModelStoreListener.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
