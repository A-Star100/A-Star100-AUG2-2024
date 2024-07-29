package com.onesignal.user.internal.subscriptions;

import com.amplitude.api.Constants;
import com.onesignal.common.modeling.Model;
import com.onesignal.common.modeling.ModelChangeTags;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR$\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138F@FX\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR$\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u001c8F@FX\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010#\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\"8F@FX\u000e¢\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006("}, d2 = {"Lcom/onesignal/user/internal/subscriptions/SubscriptionModel;", "Lcom/onesignal/common/modeling/Model;", "()V", "value", "", "address", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "appVersion", "getAppVersion", "setAppVersion", "carrier", "getCarrier", "setCarrier", "deviceOS", "getDeviceOS", "setDeviceOS", "", "optedIn", "getOptedIn", "()Z", "setOptedIn", "(Z)V", "sdk", "getSdk", "setSdk", "Lcom/onesignal/user/internal/subscriptions/SubscriptionStatus;", "status", "getStatus", "()Lcom/onesignal/user/internal/subscriptions/SubscriptionStatus;", "setStatus", "(Lcom/onesignal/user/internal/subscriptions/SubscriptionStatus;)V", "Lcom/onesignal/user/internal/subscriptions/SubscriptionType;", "type", "getType", "()Lcom/onesignal/user/internal/subscriptions/SubscriptionType;", "setType", "(Lcom/onesignal/user/internal/subscriptions/SubscriptionType;)V", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SubscriptionModel.kt */
public final class SubscriptionModel extends Model {
    public SubscriptionModel() {
        super((Model) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public final boolean getOptedIn() {
        return Model.getBooleanProperty$default(this, "optedIn", (Function0) null, 2, (Object) null);
    }

    public final void setOptedIn(boolean z) {
        Model.setBooleanProperty$default(this, "optedIn", z, (String) null, false, 12, (Object) null);
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

    public final String getAddress() {
        return Model.getStringProperty$default(this, "address", (Function0) null, 2, (Object) null);
    }

    public final void setAddress(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        Model.setStringProperty$default(this, "address", str, (String) null, false, 12, (Object) null);
    }

    public final SubscriptionStatus getStatus() {
        Object obj = null;
        if (!hasProperty("status")) {
            Enum enumR = SubscriptionStatus.SUBSCRIBED;
            setOptAnyProperty("status", enumR != null ? enumR.toString() : null, ModelChangeTags.NORMAL, false);
        }
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

    public final String getSdk() {
        return getStringProperty("sdk", SubscriptionModel$sdk$2.INSTANCE);
    }

    public final void setSdk(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        Model.setStringProperty$default(this, "sdk", str, (String) null, false, 12, (Object) null);
    }

    public final String getDeviceOS() {
        return getStringProperty("deviceOS", SubscriptionModel$deviceOS$2.INSTANCE);
    }

    public final void setDeviceOS(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        Model.setStringProperty$default(this, "deviceOS", str, (String) null, false, 12, (Object) null);
    }

    public final String getCarrier() {
        return getStringProperty(Constants.AMP_TRACKING_OPTION_CARRIER, SubscriptionModel$carrier$2.INSTANCE);
    }

    public final void setCarrier(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        Model.setStringProperty$default(this, Constants.AMP_TRACKING_OPTION_CARRIER, str, (String) null, false, 12, (Object) null);
    }

    public final String getAppVersion() {
        return getStringProperty("appVersion", SubscriptionModel$appVersion$2.INSTANCE);
    }

    public final void setAppVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        Model.setStringProperty$default(this, "appVersion", str, (String) null, false, 12, (Object) null);
    }

    public final void setType(SubscriptionType subscriptionType) {
        Intrinsics.checkNotNullParameter(subscriptionType, "value");
        setOptAnyProperty("type", subscriptionType.toString(), ModelChangeTags.NORMAL, false);
    }

    public final void setStatus(SubscriptionStatus subscriptionStatus) {
        Intrinsics.checkNotNullParameter(subscriptionStatus, "value");
        setOptAnyProperty("status", subscriptionStatus.toString(), ModelChangeTags.NORMAL, false);
    }
}
