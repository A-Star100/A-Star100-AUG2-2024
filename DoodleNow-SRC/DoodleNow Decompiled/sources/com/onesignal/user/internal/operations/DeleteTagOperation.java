package com.onesignal.user.internal.operations;

import com.onesignal.common.IDManager;
import com.onesignal.common.modeling.Model;
import com.onesignal.core.internal.operations.GroupComparisonType;
import com.onesignal.core.internal.operations.Operation;
import com.onesignal.user.internal.operations.impl.executors.UpdateUserOperationExecutor;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006B\u0005¢\u0006\u0002\u0010\u0007J\u001c\u0010\u001f\u001a\u00020 2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\"H\u0016R$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00038F@BX\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\nR\u0014\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R$\u0010\u0005\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00038F@BX\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\n\"\u0004\b\u001a\u0010\fR\u0014\u0010\u001b\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\nR$\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00038F@BX\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\n\"\u0004\b\u001e\u0010\f¨\u0006#"}, d2 = {"Lcom/onesignal/user/internal/operations/DeleteTagOperation;", "Lcom/onesignal/core/internal/operations/Operation;", "appId", "", "onesignalId", "key", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()V", "value", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "applyToRecordId", "getApplyToRecordId", "canStartExecute", "", "getCanStartExecute", "()Z", "createComparisonKey", "getCreateComparisonKey", "groupComparisonType", "Lcom/onesignal/core/internal/operations/GroupComparisonType;", "getGroupComparisonType", "()Lcom/onesignal/core/internal/operations/GroupComparisonType;", "getKey", "setKey", "modifyComparisonKey", "getModifyComparisonKey", "getOnesignalId", "setOnesignalId", "translateIds", "", "map", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: DeleteTagOperation.kt */
public final class DeleteTagOperation extends Operation {
    private final GroupComparisonType groupComparisonType;

    public String getCreateComparisonKey() {
        return "";
    }

    public GroupComparisonType getGroupComparisonType() {
        return this.groupComparisonType;
    }

    public DeleteTagOperation() {
        super(UpdateUserOperationExecutor.DELETE_TAG);
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

    public final String getKey() {
        return Model.getStringProperty$default(this, SubscriberAttributeKt.JSON_NAME_KEY, (Function0) null, 2, (Object) null);
    }

    private final void setKey(String str) {
        Model.setStringProperty$default(this, SubscriberAttributeKt.JSON_NAME_KEY, str, (String) null, false, 12, (Object) null);
    }

    public String getModifyComparisonKey() {
        return getAppId() + ".User." + getOnesignalId();
    }

    public boolean getCanStartExecute() {
        return !IDManager.INSTANCE.isLocalId(getOnesignalId());
    }

    public String getApplyToRecordId() {
        return getOnesignalId();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DeleteTagOperation(String str, String str2, String str3) {
        this();
        Intrinsics.checkNotNullParameter(str, "appId");
        Intrinsics.checkNotNullParameter(str2, "onesignalId");
        Intrinsics.checkNotNullParameter(str3, SubscriberAttributeKt.JSON_NAME_KEY);
        setAppId(str);
        setOnesignalId(str2);
        setKey(str3);
    }

    public void translateIds(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        if (map.containsKey(getOnesignalId())) {
            String str = map.get(getOnesignalId());
            Intrinsics.checkNotNull(str);
            setOnesignalId(str);
        }
    }
}
