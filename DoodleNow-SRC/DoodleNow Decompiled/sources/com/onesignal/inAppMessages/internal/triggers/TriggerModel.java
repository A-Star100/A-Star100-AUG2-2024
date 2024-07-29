package com.onesignal.inAppMessages.internal.triggers;

import com.onesignal.common.modeling.Model;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8F@FX\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/onesignal/inAppMessages/internal/triggers/TriggerModel;", "Lcom/onesignal/common/modeling/Model;", "()V", "value", "", "key", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TriggerModel.kt */
public final class TriggerModel extends Model {
    public TriggerModel() {
        super((Model) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public final String getKey() {
        return getStringProperty(SubscriberAttributeKt.JSON_NAME_KEY, TriggerModel$key$2.INSTANCE);
    }

    public final void setKey(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        Model.setStringProperty$default(this, SubscriberAttributeKt.JSON_NAME_KEY, str, (String) null, false, 12, (Object) null);
    }

    public final Object getValue() {
        return getAnyProperty("value", TriggerModel$value$2.INSTANCE);
    }

    public final void setValue(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "value");
        Model.setAnyProperty$default(this, "value", obj, (String) null, true, 4, (Object) null);
    }
}
