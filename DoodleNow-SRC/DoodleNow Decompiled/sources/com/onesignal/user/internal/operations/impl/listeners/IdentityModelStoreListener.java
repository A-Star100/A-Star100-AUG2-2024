package com.onesignal.user.internal.operations.impl.listeners;

import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.operations.IOperationRepo;
import com.onesignal.core.internal.operations.Operation;
import com.onesignal.core.internal.operations.listeners.SingletonModelStoreListener;
import com.onesignal.user.internal.identity.IdentityModel;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.operations.DeleteAliasOperation;
import com.onesignal.user.internal.operations.SetAliasOperation;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016J4\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/onesignal/user/internal/operations/impl/listeners/IdentityModelStoreListener;", "Lcom/onesignal/core/internal/operations/listeners/SingletonModelStoreListener;", "Lcom/onesignal/user/internal/identity/IdentityModel;", "store", "Lcom/onesignal/user/internal/identity/IdentityModelStore;", "opRepo", "Lcom/onesignal/core/internal/operations/IOperationRepo;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "(Lcom/onesignal/user/internal/identity/IdentityModelStore;Lcom/onesignal/core/internal/operations/IOperationRepo;Lcom/onesignal/core/internal/config/ConfigModelStore;)V", "getReplaceOperation", "Lcom/onesignal/core/internal/operations/Operation;", "model", "getUpdateOperation", "path", "", "property", "oldValue", "", "newValue", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: IdentityModelStoreListener.kt */
public final class IdentityModelStoreListener extends SingletonModelStoreListener<IdentityModel> {
    private final ConfigModelStore _configModelStore;

    public Operation getReplaceOperation(IdentityModel identityModel) {
        Intrinsics.checkNotNullParameter(identityModel, "model");
        return null;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IdentityModelStoreListener(IdentityModelStore identityModelStore, IOperationRepo iOperationRepo, ConfigModelStore configModelStore) {
        super(identityModelStore, iOperationRepo);
        Intrinsics.checkNotNullParameter(identityModelStore, ProductResponseJsonKeys.STORE);
        Intrinsics.checkNotNullParameter(iOperationRepo, "opRepo");
        Intrinsics.checkNotNullParameter(configModelStore, "_configModelStore");
        this._configModelStore = configModelStore;
    }

    public Operation getUpdateOperation(IdentityModel identityModel, String str, String str2, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(identityModel, "model");
        Intrinsics.checkNotNullParameter(str, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH);
        Intrinsics.checkNotNullParameter(str2, "property");
        if (obj2 == null || !(obj2 instanceof String)) {
            return new DeleteAliasOperation(((ConfigModel) this._configModelStore.getModel()).getAppId(), identityModel.getOnesignalId(), str2);
        }
        return new SetAliasOperation(((ConfigModel) this._configModelStore.getModel()).getAppId(), identityModel.getOnesignalId(), str2, (String) obj2);
    }
}
