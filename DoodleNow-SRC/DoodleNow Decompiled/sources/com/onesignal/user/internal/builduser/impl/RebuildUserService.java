package com.onesignal.user.internal.builduser.impl;

import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.user.internal.builduser.IRebuildUserService;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.properties.PropertiesModelStore;
import com.onesignal.user.internal.subscriptions.SubscriptionModelStore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ \u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/onesignal/user/internal/builduser/impl/RebuildUserService;", "Lcom/onesignal/user/internal/builduser/IRebuildUserService;", "_identityModelStore", "Lcom/onesignal/user/internal/identity/IdentityModelStore;", "_propertiesModelStore", "Lcom/onesignal/user/internal/properties/PropertiesModelStore;", "_subscriptionsModelStore", "Lcom/onesignal/user/internal/subscriptions/SubscriptionModelStore;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "(Lcom/onesignal/user/internal/identity/IdentityModelStore;Lcom/onesignal/user/internal/properties/PropertiesModelStore;Lcom/onesignal/user/internal/subscriptions/SubscriptionModelStore;Lcom/onesignal/core/internal/config/ConfigModelStore;)V", "getRebuildOperationsIfCurrentUser", "", "Lcom/onesignal/core/internal/operations/Operation;", "appId", "", "onesignalId", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: RebuildUserService.kt */
public final class RebuildUserService implements IRebuildUserService {
    private final ConfigModelStore _configModelStore;
    private final IdentityModelStore _identityModelStore;
    private final PropertiesModelStore _propertiesModelStore;
    private final SubscriptionModelStore _subscriptionsModelStore;

    public RebuildUserService(IdentityModelStore identityModelStore, PropertiesModelStore propertiesModelStore, SubscriptionModelStore subscriptionModelStore, ConfigModelStore configModelStore) {
        Intrinsics.checkNotNullParameter(identityModelStore, "_identityModelStore");
        Intrinsics.checkNotNullParameter(propertiesModelStore, "_propertiesModelStore");
        Intrinsics.checkNotNullParameter(subscriptionModelStore, "_subscriptionsModelStore");
        Intrinsics.checkNotNullParameter(configModelStore, "_configModelStore");
        this._identityModelStore = identityModelStore;
        this._propertiesModelStore = propertiesModelStore;
        this._subscriptionsModelStore = subscriptionModelStore;
        this._configModelStore = configModelStore;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: com.onesignal.user.internal.subscriptions.SubscriptionModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.onesignal.user.internal.subscriptions.SubscriptionModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: com.onesignal.user.internal.subscriptions.SubscriptionModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.onesignal.user.internal.subscriptions.SubscriptionModel} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.onesignal.core.internal.operations.Operation> getRebuildOperationsIfCurrentUser(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            java.lang.String r0 = "appId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "onesignalId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            com.onesignal.user.internal.identity.IdentityModel r0 = new com.onesignal.user.internal.identity.IdentityModel
            r0.<init>()
            com.onesignal.user.internal.identity.IdentityModelStore r1 = r12._identityModelStore
            com.onesignal.common.modeling.Model r1 = r1.getModel()
            r2 = 0
            r0.initializeFromModel(r2, r1)
            com.onesignal.user.internal.properties.PropertiesModel r1 = new com.onesignal.user.internal.properties.PropertiesModel
            r1.<init>()
            com.onesignal.user.internal.properties.PropertiesModelStore r3 = r12._propertiesModelStore
            com.onesignal.common.modeling.Model r3 = r3.getModel()
            r1.initializeFromModel(r2, r3)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.List r1 = (java.util.List) r1
            com.onesignal.user.internal.subscriptions.SubscriptionModelStore r3 = r12._subscriptionsModelStore
            java.util.Collection r3 = r3.list()
            java.util.Iterator r3 = r3.iterator()
        L_0x0038:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0052
            java.lang.Object r4 = r3.next()
            com.onesignal.user.internal.subscriptions.SubscriptionModel r4 = (com.onesignal.user.internal.subscriptions.SubscriptionModel) r4
            com.onesignal.user.internal.subscriptions.SubscriptionModel r5 = new com.onesignal.user.internal.subscriptions.SubscriptionModel
            r5.<init>()
            com.onesignal.common.modeling.Model r4 = (com.onesignal.common.modeling.Model) r4
            r5.initializeFromModel(r2, r4)
            r1.add(r5)
            goto L_0x0038
        L_0x0052:
            java.lang.String r3 = r0.getOnesignalId()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r14)
            if (r3 != 0) goto L_0x005d
            return r2
        L_0x005d:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.List r3 = (java.util.List) r3
            com.onesignal.user.internal.operations.LoginUserOperation r11 = new com.onesignal.user.internal.operations.LoginUserOperation
            java.lang.String r7 = r0.getExternalId()
            r8 = 0
            r9 = 8
            r10 = 0
            r4 = r11
            r5 = r13
            r6 = r14
            r4.<init>(r5, r6, r7, r8, r9, r10)
            r3.add(r11)
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r0 = r1.iterator()
        L_0x007d:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00a1
            java.lang.Object r1 = r0.next()
            r4 = r1
            com.onesignal.user.internal.subscriptions.SubscriptionModel r4 = (com.onesignal.user.internal.subscriptions.SubscriptionModel) r4
            java.lang.String r4 = r4.getId()
            com.onesignal.core.internal.config.ConfigModelStore r5 = r12._configModelStore
            com.onesignal.common.modeling.Model r5 = r5.getModel()
            com.onesignal.core.internal.config.ConfigModel r5 = (com.onesignal.core.internal.config.ConfigModel) r5
            java.lang.String r5 = r5.getPushSubscriptionId()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 == 0) goto L_0x007d
            r2 = r1
        L_0x00a1:
            com.onesignal.user.internal.subscriptions.SubscriptionModel r2 = (com.onesignal.user.internal.subscriptions.SubscriptionModel) r2
            if (r2 == 0) goto L_0x00c4
            com.onesignal.user.internal.operations.CreateSubscriptionOperation r0 = new com.onesignal.user.internal.operations.CreateSubscriptionOperation
            java.lang.String r7 = r2.getId()
            com.onesignal.user.internal.subscriptions.SubscriptionType r8 = r2.getType()
            boolean r9 = r2.getOptedIn()
            java.lang.String r10 = r2.getAddress()
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r11 = r2.getStatus()
            r4 = r0
            r5 = r13
            r6 = r14
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            r3.add(r0)
        L_0x00c4:
            com.onesignal.user.internal.operations.RefreshUserOperation r0 = new com.onesignal.user.internal.operations.RefreshUserOperation
            r0.<init>(r13, r14)
            r3.add(r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.builduser.impl.RebuildUserService.getRebuildOperationsIfCurrentUser(java.lang.String, java.lang.String):java.util.List");
    }
}
