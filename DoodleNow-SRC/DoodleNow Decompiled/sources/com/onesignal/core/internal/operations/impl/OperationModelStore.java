package com.onesignal.core.internal.operations.impl;

import com.onesignal.common.modeling.ModelStore;
import com.onesignal.core.internal.operations.Operation;
import com.onesignal.core.internal.preferences.IPreferencesService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/onesignal/core/internal/operations/impl/OperationModelStore;", "Lcom/onesignal/common/modeling/ModelStore;", "Lcom/onesignal/core/internal/operations/Operation;", "prefs", "Lcom/onesignal/core/internal/preferences/IPreferencesService;", "(Lcom/onesignal/core/internal/preferences/IPreferencesService;)V", "create", "jsonObject", "Lorg/json/JSONObject;", "loadOperations", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: OperationModelStore.kt */
public final class OperationModelStore extends ModelStore<Operation> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OperationModelStore(IPreferencesService iPreferencesService) {
        super("operations", iPreferencesService);
        Intrinsics.checkNotNullParameter(iPreferencesService, "prefs");
    }

    public final void loadOperations() {
        load();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:57:0x011e, code lost:
        r0.initializeFromJson(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0121, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.onesignal.core.internal.operations.Operation create(org.json.JSONObject r5) {
        /*
            r4 = this;
            r0 = 2
            r1 = 0
            if (r5 != 0) goto L_0x000a
            java.lang.String r5 = "null jsonObject sent to OperationModelStore.create"
            com.onesignal.debug.internal.logging.Logging.error$default(r5, r1, r0, r1)
            return r1
        L_0x000a:
            java.lang.String r2 = "name"
            boolean r3 = r5.has(r2)
            if (r3 != 0) goto L_0x0018
            java.lang.String r5 = "jsonObject must have 'name' attribute"
            com.onesignal.debug.internal.logging.Logging.error$default(r5, r1, r0, r1)
            return r1
        L_0x0018:
            java.lang.String r0 = r5.getString(r2)
            if (r0 == 0) goto L_0x0122
            int r1 = r0.hashCode()
            switch(r1) {
                case -1865677906: goto L_0x010f;
                case -1793763409: goto L_0x00ff;
                case -1606689981: goto L_0x00ef;
                case -1188793632: goto L_0x00df;
                case -1080179201: goto L_0x00cf;
                case -828599391: goto L_0x00bf;
                case -516221659: goto L_0x00af;
                case -92337283: goto L_0x009e;
                case 532599746: goto L_0x008d;
                case 846157390: goto L_0x007c;
                case 1707031487: goto L_0x006b;
                case 1763437688: goto L_0x005a;
                case 1852485538: goto L_0x0049;
                case 1983836079: goto L_0x0038;
                case 2135250281: goto L_0x0027;
                default: goto L_0x0025;
            }
        L_0x0025:
            goto L_0x0122
        L_0x0027:
            java.lang.String r1 = "track-session-start"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0122
            com.onesignal.user.internal.operations.TrackSessionStartOperation r0 = new com.onesignal.user.internal.operations.TrackSessionStartOperation
            r0.<init>()
            com.onesignal.core.internal.operations.Operation r0 = (com.onesignal.core.internal.operations.Operation) r0
            goto L_0x011e
        L_0x0038:
            java.lang.String r1 = "set-tag"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0122
            com.onesignal.user.internal.operations.SetTagOperation r0 = new com.onesignal.user.internal.operations.SetTagOperation
            r0.<init>()
            com.onesignal.core.internal.operations.Operation r0 = (com.onesignal.core.internal.operations.Operation) r0
            goto L_0x011e
        L_0x0049:
            java.lang.String r1 = "track-session-end"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0122
            com.onesignal.user.internal.operations.TrackSessionEndOperation r0 = new com.onesignal.user.internal.operations.TrackSessionEndOperation
            r0.<init>()
            com.onesignal.core.internal.operations.Operation r0 = (com.onesignal.core.internal.operations.Operation) r0
            goto L_0x011e
        L_0x005a:
            java.lang.String r1 = "delete-tag"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0122
            com.onesignal.user.internal.operations.DeleteTagOperation r0 = new com.onesignal.user.internal.operations.DeleteTagOperation
            r0.<init>()
            com.onesignal.core.internal.operations.Operation r0 = (com.onesignal.core.internal.operations.Operation) r0
            goto L_0x011e
        L_0x006b:
            java.lang.String r1 = "transfer-subscription"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0122
            com.onesignal.user.internal.operations.TransferSubscriptionOperation r0 = new com.onesignal.user.internal.operations.TransferSubscriptionOperation
            r0.<init>()
            com.onesignal.core.internal.operations.Operation r0 = (com.onesignal.core.internal.operations.Operation) r0
            goto L_0x011e
        L_0x007c:
            java.lang.String r1 = "create-subscription"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0122
            com.onesignal.user.internal.operations.CreateSubscriptionOperation r0 = new com.onesignal.user.internal.operations.CreateSubscriptionOperation
            r0.<init>()
            com.onesignal.core.internal.operations.Operation r0 = (com.onesignal.core.internal.operations.Operation) r0
            goto L_0x011e
        L_0x008d:
            java.lang.String r1 = "login-user-from-subscription"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0122
            com.onesignal.user.internal.operations.LoginUserFromSubscriptionOperation r0 = new com.onesignal.user.internal.operations.LoginUserFromSubscriptionOperation
            r0.<init>()
            com.onesignal.core.internal.operations.Operation r0 = (com.onesignal.core.internal.operations.Operation) r0
            goto L_0x011e
        L_0x009e:
            java.lang.String r1 = "refresh-user"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0122
            com.onesignal.user.internal.operations.RefreshUserOperation r0 = new com.onesignal.user.internal.operations.RefreshUserOperation
            r0.<init>()
            com.onesignal.core.internal.operations.Operation r0 = (com.onesignal.core.internal.operations.Operation) r0
            goto L_0x011e
        L_0x00af:
            java.lang.String r1 = "set-alias"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0122
            com.onesignal.user.internal.operations.SetAliasOperation r0 = new com.onesignal.user.internal.operations.SetAliasOperation
            r0.<init>()
            com.onesignal.core.internal.operations.Operation r0 = (com.onesignal.core.internal.operations.Operation) r0
            goto L_0x011e
        L_0x00bf:
            java.lang.String r1 = "update-subscription"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0122
            com.onesignal.user.internal.operations.UpdateSubscriptionOperation r0 = new com.onesignal.user.internal.operations.UpdateSubscriptionOperation
            r0.<init>()
            com.onesignal.core.internal.operations.Operation r0 = (com.onesignal.core.internal.operations.Operation) r0
            goto L_0x011e
        L_0x00cf:
            java.lang.String r1 = "delete-subscription"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0122
            com.onesignal.user.internal.operations.DeleteSubscriptionOperation r0 = new com.onesignal.user.internal.operations.DeleteSubscriptionOperation
            r0.<init>()
            com.onesignal.core.internal.operations.Operation r0 = (com.onesignal.core.internal.operations.Operation) r0
            goto L_0x011e
        L_0x00df:
            java.lang.String r1 = "set-property"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0122
            com.onesignal.user.internal.operations.SetPropertyOperation r0 = new com.onesignal.user.internal.operations.SetPropertyOperation
            r0.<init>()
            com.onesignal.core.internal.operations.Operation r0 = (com.onesignal.core.internal.operations.Operation) r0
            goto L_0x011e
        L_0x00ef:
            java.lang.String r1 = "track-purchase"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0122
            com.onesignal.user.internal.operations.TrackPurchaseOperation r0 = new com.onesignal.user.internal.operations.TrackPurchaseOperation
            r0.<init>()
            com.onesignal.core.internal.operations.Operation r0 = (com.onesignal.core.internal.operations.Operation) r0
            goto L_0x011e
        L_0x00ff:
            java.lang.String r1 = "login-user"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0122
            com.onesignal.user.internal.operations.LoginUserOperation r0 = new com.onesignal.user.internal.operations.LoginUserOperation
            r0.<init>()
            com.onesignal.core.internal.operations.Operation r0 = (com.onesignal.core.internal.operations.Operation) r0
            goto L_0x011e
        L_0x010f:
            java.lang.String r1 = "delete-alias"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0122
            com.onesignal.user.internal.operations.DeleteAliasOperation r0 = new com.onesignal.user.internal.operations.DeleteAliasOperation
            r0.<init>()
            com.onesignal.core.internal.operations.Operation r0 = (com.onesignal.core.internal.operations.Operation) r0
        L_0x011e:
            r0.initializeFromJson(r5)
            return r0
        L_0x0122:
            java.lang.Exception r5 = new java.lang.Exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Unrecognized operation: "
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.core.internal.operations.impl.OperationModelStore.create(org.json.JSONObject):com.onesignal.core.internal.operations.Operation");
    }
}
