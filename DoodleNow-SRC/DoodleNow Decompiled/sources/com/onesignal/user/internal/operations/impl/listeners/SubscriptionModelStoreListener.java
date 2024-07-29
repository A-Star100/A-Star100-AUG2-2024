package com.onesignal.user.internal.operations.impl.listeners;

import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.operations.IOperationRepo;
import com.onesignal.core.internal.operations.Operation;
import com.onesignal.core.internal.operations.listeners.ModelStoreListener;
import com.onesignal.user.internal.identity.IdentityModel;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.operations.CreateSubscriptionOperation;
import com.onesignal.user.internal.operations.DeleteSubscriptionOperation;
import com.onesignal.user.internal.operations.UpdateSubscriptionOperation;
import com.onesignal.user.internal.subscriptions.SubscriptionModel;
import com.onesignal.user.internal.subscriptions.SubscriptionModelStore;
import com.onesignal.user.internal.subscriptions.SubscriptionStatus;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J4\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/onesignal/user/internal/operations/impl/listeners/SubscriptionModelStoreListener;", "Lcom/onesignal/core/internal/operations/listeners/ModelStoreListener;", "Lcom/onesignal/user/internal/subscriptions/SubscriptionModel;", "store", "Lcom/onesignal/user/internal/subscriptions/SubscriptionModelStore;", "opRepo", "Lcom/onesignal/core/internal/operations/IOperationRepo;", "_identityModelStore", "Lcom/onesignal/user/internal/identity/IdentityModelStore;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "(Lcom/onesignal/user/internal/subscriptions/SubscriptionModelStore;Lcom/onesignal/core/internal/operations/IOperationRepo;Lcom/onesignal/user/internal/identity/IdentityModelStore;Lcom/onesignal/core/internal/config/ConfigModelStore;)V", "getAddOperation", "Lcom/onesignal/core/internal/operations/Operation;", "model", "getRemoveOperation", "getUpdateOperation", "path", "", "property", "oldValue", "", "newValue", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SubscriptionModelStoreListener.kt */
public final class SubscriptionModelStoreListener extends ModelStoreListener<SubscriptionModel> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final ConfigModelStore _configModelStore;
    private final IdentityModelStore _identityModelStore;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubscriptionModelStoreListener(SubscriptionModelStore subscriptionModelStore, IOperationRepo iOperationRepo, IdentityModelStore identityModelStore, ConfigModelStore configModelStore) {
        super(subscriptionModelStore, iOperationRepo);
        Intrinsics.checkNotNullParameter(subscriptionModelStore, ProductResponseJsonKeys.STORE);
        Intrinsics.checkNotNullParameter(iOperationRepo, "opRepo");
        Intrinsics.checkNotNullParameter(identityModelStore, "_identityModelStore");
        Intrinsics.checkNotNullParameter(configModelStore, "_configModelStore");
        this._identityModelStore = identityModelStore;
        this._configModelStore = configModelStore;
    }

    public Operation getAddOperation(SubscriptionModel subscriptionModel) {
        Intrinsics.checkNotNullParameter(subscriptionModel, "model");
        Pair<Boolean, SubscriptionStatus> subscriptionEnabledAndStatus = Companion.getSubscriptionEnabledAndStatus(subscriptionModel);
        return new CreateSubscriptionOperation(((ConfigModel) this._configModelStore.getModel()).getAppId(), ((IdentityModel) this._identityModelStore.getModel()).getOnesignalId(), subscriptionModel.getId(), subscriptionModel.getType(), subscriptionEnabledAndStatus.getFirst().booleanValue(), subscriptionModel.getAddress(), subscriptionEnabledAndStatus.getSecond());
    }

    public Operation getRemoveOperation(SubscriptionModel subscriptionModel) {
        Intrinsics.checkNotNullParameter(subscriptionModel, "model");
        return new DeleteSubscriptionOperation(((ConfigModel) this._configModelStore.getModel()).getAppId(), ((IdentityModel) this._identityModelStore.getModel()).getOnesignalId(), subscriptionModel.getId());
    }

    public Operation getUpdateOperation(SubscriptionModel subscriptionModel, String str, String str2, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(subscriptionModel, "model");
        Intrinsics.checkNotNullParameter(str, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH);
        Intrinsics.checkNotNullParameter(str2, "property");
        Pair<Boolean, SubscriptionStatus> subscriptionEnabledAndStatus = Companion.getSubscriptionEnabledAndStatus(subscriptionModel);
        return new UpdateSubscriptionOperation(((ConfigModel) this._configModelStore.getModel()).getAppId(), ((IdentityModel) this._identityModelStore.getModel()).getOnesignalId(), subscriptionModel.getId(), subscriptionModel.getType(), subscriptionEnabledAndStatus.getFirst().booleanValue(), subscriptionModel.getAddress(), subscriptionEnabledAndStatus.getSecond());
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/onesignal/user/internal/operations/impl/listeners/SubscriptionModelStoreListener$Companion;", "", "()V", "getSubscriptionEnabledAndStatus", "Lkotlin/Pair;", "", "Lcom/onesignal/user/internal/subscriptions/SubscriptionStatus;", "model", "Lcom/onesignal/user/internal/subscriptions/SubscriptionModel;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SubscriptionModelStoreListener.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Pair<Boolean, SubscriptionStatus> getSubscriptionEnabledAndStatus(SubscriptionModel subscriptionModel) {
            SubscriptionStatus subscriptionStatus;
            boolean z;
            Intrinsics.checkNotNullParameter(subscriptionModel, "model");
            if (!subscriptionModel.getOptedIn() || subscriptionModel.getStatus() != SubscriptionStatus.SUBSCRIBED || subscriptionModel.getAddress().length() <= 0) {
                if (!subscriptionModel.getOptedIn()) {
                    subscriptionStatus = SubscriptionStatus.UNSUBSCRIBE;
                } else {
                    subscriptionStatus = subscriptionModel.getStatus();
                }
                z = false;
            } else {
                subscriptionStatus = SubscriptionStatus.SUBSCRIBED;
                z = true;
            }
            return new Pair<>(Boolean.valueOf(z), subscriptionStatus);
        }
    }
}
