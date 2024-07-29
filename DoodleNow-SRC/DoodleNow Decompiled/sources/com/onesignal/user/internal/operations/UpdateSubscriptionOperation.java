package com.onesignal.user.internal.operations;

import com.facebook.react.uimanager.ViewProps;
import com.onesignal.common.IDManager;
import com.onesignal.common.modeling.Model;
import com.onesignal.common.modeling.ModelChangeTags;
import com.onesignal.core.internal.operations.GroupComparisonType;
import com.onesignal.core.internal.operations.Operation;
import com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor;
import com.onesignal.user.internal.subscriptions.SubscriptionStatus;
import com.onesignal.user.internal.subscriptions.SubscriptionType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B?\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rB\u0005¢\u0006\u0002\u0010\u000eJ\u001c\u00102\u001a\u0002032\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000305H\u0016R$\u0010\n\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00038F@BX\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00038F@BX\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0011R\u0014\u0010\u0018\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0011R$\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t8F@BX\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020!X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0011R$\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00038F@BX\u000e¢\u0006\f\u001a\u0004\b&\u0010\u0011\"\u0004\b'\u0010\u0013R$\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f8F@BX\u000e¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00038F@BX\u000e¢\u0006\f\u001a\u0004\b,\u0010\u0011\"\u0004\b-\u0010\u0013R$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00078F@BX\u000e¢\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u00066"}, d2 = {"Lcom/onesignal/user/internal/operations/UpdateSubscriptionOperation;", "Lcom/onesignal/core/internal/operations/Operation;", "appId", "", "onesignalId", "subscriptionId", "type", "Lcom/onesignal/user/internal/subscriptions/SubscriptionType;", "enabled", "", "address", "status", "Lcom/onesignal/user/internal/subscriptions/SubscriptionStatus;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/onesignal/user/internal/subscriptions/SubscriptionType;ZLjava/lang/String;Lcom/onesignal/user/internal/subscriptions/SubscriptionStatus;)V", "()V", "value", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "getAppId", "setAppId", "applyToRecordId", "getApplyToRecordId", "canStartExecute", "getCanStartExecute", "()Z", "createComparisonKey", "getCreateComparisonKey", "getEnabled", "setEnabled", "(Z)V", "groupComparisonType", "Lcom/onesignal/core/internal/operations/GroupComparisonType;", "getGroupComparisonType", "()Lcom/onesignal/core/internal/operations/GroupComparisonType;", "modifyComparisonKey", "getModifyComparisonKey", "getOnesignalId", "setOnesignalId", "getStatus", "()Lcom/onesignal/user/internal/subscriptions/SubscriptionStatus;", "setStatus", "(Lcom/onesignal/user/internal/subscriptions/SubscriptionStatus;)V", "getSubscriptionId", "setSubscriptionId", "getType", "()Lcom/onesignal/user/internal/subscriptions/SubscriptionType;", "setType", "(Lcom/onesignal/user/internal/subscriptions/SubscriptionType;)V", "translateIds", "", "map", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: UpdateSubscriptionOperation.kt */
public final class UpdateSubscriptionOperation extends Operation {
    private final GroupComparisonType groupComparisonType;

    public GroupComparisonType getGroupComparisonType() {
        return this.groupComparisonType;
    }

    public UpdateSubscriptionOperation() {
        super(SubscriptionOperationExecutor.UPDATE_SUBSCRIPTION);
        this.groupComparisonType = GroupComparisonType.ALTER;
    }

    public final String getAppId() {
        return Model.getStringProperty$default(this, "appId", (Function0) null, 2, (Object) null);
    }

    private final void setAppId(String str) {
        Model.setStringProperty$default(this, "appId", str, (String) null, false, 12, (Object) null);
    }

    public final String getOnesignalId() {
        return Model.getStringProperty$default(this, "onesignalId", (Function0) null, 2, (Object) null);
    }

    private final void setOnesignalId(String str) {
        Model.setStringProperty$default(this, "onesignalId", str, (String) null, false, 12, (Object) null);
    }

    public final String getSubscriptionId() {
        return Model.getStringProperty$default(this, "subscriptionId", (Function0) null, 2, (Object) null);
    }

    private final void setSubscriptionId(String str) {
        Model.setStringProperty$default(this, "subscriptionId", str, (String) null, false, 12, (Object) null);
    }

    public final SubscriptionType getType() {
        Object obj = null;
        Object optAnyProperty$default = Model.getOptAnyProperty$default(this, "type", (Function0) null, 2, (Object) null);
        if (optAnyProperty$default != null) {
            if (optAnyProperty$default instanceof SubscriptionType) {
                obj = (Enum) optAnyProperty$default;
            } else if (optAnyProperty$default instanceof String) {
                obj = SubscriptionType.valueOf((String) optAnyProperty$default);
            } else if (optAnyProperty$default != null) {
                obj = (SubscriptionType) optAnyProperty$default;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.onesignal.user.internal.subscriptions.SubscriptionType");
            }
        }
        if (obj != null) {
            return (SubscriptionType) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.onesignal.user.internal.subscriptions.SubscriptionType");
    }

    public final boolean getEnabled() {
        return Model.getBooleanProperty$default(this, ViewProps.ENABLED, (Function0) null, 2, (Object) null);
    }

    private final void setEnabled(boolean z) {
        Model.setBooleanProperty$default(this, ViewProps.ENABLED, z, (String) null, false, 12, (Object) null);
    }

    public final String getAddress() {
        return Model.getStringProperty$default(this, "address", (Function0) null, 2, (Object) null);
    }

    private final void setAddress(String str) {
        Model.setStringProperty$default(this, "address", str, (String) null, false, 12, (Object) null);
    }

    public final SubscriptionStatus getStatus() {
        Object obj = null;
        Object optAnyProperty$default = Model.getOptAnyProperty$default(this, "status", (Function0) null, 2, (Object) null);
        if (optAnyProperty$default != null) {
            if (optAnyProperty$default instanceof SubscriptionStatus) {
                obj = (Enum) optAnyProperty$default;
            } else if (optAnyProperty$default instanceof String) {
                obj = SubscriptionStatus.valueOf((String) optAnyProperty$default);
            } else if (optAnyProperty$default != null) {
                obj = (SubscriptionStatus) optAnyProperty$default;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.onesignal.user.internal.subscriptions.SubscriptionStatus");
            }
        }
        if (obj != null) {
            return (SubscriptionStatus) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.onesignal.user.internal.subscriptions.SubscriptionStatus");
    }

    public String getCreateComparisonKey() {
        return getAppId() + ".User." + getOnesignalId();
    }

    public String getModifyComparisonKey() {
        return getAppId() + ".User." + getOnesignalId() + ".Subscription." + getSubscriptionId();
    }

    public boolean getCanStartExecute() {
        return !IDManager.INSTANCE.isLocalId(getOnesignalId()) && !IDManager.INSTANCE.isLocalId(getOnesignalId());
    }

    public String getApplyToRecordId() {
        return getSubscriptionId();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public UpdateSubscriptionOperation(String str, String str2, String str3, SubscriptionType subscriptionType, boolean z, String str4, SubscriptionStatus subscriptionStatus) {
        this();
        Intrinsics.checkNotNullParameter(str, "appId");
        Intrinsics.checkNotNullParameter(str2, "onesignalId");
        Intrinsics.checkNotNullParameter(str3, "subscriptionId");
        Intrinsics.checkNotNullParameter(subscriptionType, "type");
        Intrinsics.checkNotNullParameter(str4, "address");
        Intrinsics.checkNotNullParameter(subscriptionStatus, "status");
        setAppId(str);
        setOnesignalId(str2);
        setSubscriptionId(str3);
        setType(subscriptionType);
        setEnabled(z);
        setAddress(str4);
        setStatus(subscriptionStatus);
    }

    public void translateIds(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        if (map.containsKey(getOnesignalId())) {
            String str = map.get(getOnesignalId());
            Intrinsics.checkNotNull(str);
            setOnesignalId(str);
        }
        if (map.containsKey(getSubscriptionId())) {
            String str2 = map.get(getSubscriptionId());
            Intrinsics.checkNotNull(str2);
            setSubscriptionId(str2);
        }
    }

    private final void setType(SubscriptionType subscriptionType) {
        Enum enumR = subscriptionType;
        setOptAnyProperty("type", enumR != null ? enumR.toString() : null, ModelChangeTags.NORMAL, false);
    }

    private final void setStatus(SubscriptionStatus subscriptionStatus) {
        Enum enumR = subscriptionStatus;
        setOptAnyProperty("status", enumR != null ? enumR.toString() : null, ModelChangeTags.NORMAL, false);
    }
}
