package com.onesignal.user.internal.operations;

import com.onesignal.common.IDManager;
import com.onesignal.common.modeling.Model;
import com.onesignal.core.internal.operations.GroupComparisonType;
import com.onesignal.core.internal.operations.Operation;
import com.onesignal.user.internal.operations.impl.executors.UpdateUserOperationExecutor;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\u0005¢\u0006\u0002\u0010\tJ\u001c\u0010$\u001a\u00020%2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030'H\u0016R$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038F@BX\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000bR\u0014\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u000bR$\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038F@BX\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u000b\"\u0004\b\u001d\u0010\rR$\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038F@BX\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u000b\"\u0004\b\u001f\u0010\rR(\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078F@BX\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006("}, d2 = {"Lcom/onesignal/user/internal/operations/SetPropertyOperation;", "Lcom/onesignal/core/internal/operations/Operation;", "appId", "", "onesignalId", "property", "value", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "()V", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "applyToRecordId", "getApplyToRecordId", "canStartExecute", "", "getCanStartExecute", "()Z", "createComparisonKey", "getCreateComparisonKey", "groupComparisonType", "Lcom/onesignal/core/internal/operations/GroupComparisonType;", "getGroupComparisonType", "()Lcom/onesignal/core/internal/operations/GroupComparisonType;", "modifyComparisonKey", "getModifyComparisonKey", "getOnesignalId", "setOnesignalId", "getProperty", "setProperty", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "translateIds", "", "map", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SetPropertyOperation.kt */
public final class SetPropertyOperation extends Operation {
    private final GroupComparisonType groupComparisonType;

    public String getCreateComparisonKey() {
        return "";
    }

    public GroupComparisonType getGroupComparisonType() {
        return this.groupComparisonType;
    }

    public SetPropertyOperation() {
        super(UpdateUserOperationExecutor.SET_PROPERTY);
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

    public final String getProperty() {
        return Model.getStringProperty$default(this, "property", (Function0) null, 2, (Object) null);
    }

    private final void setProperty(String str) {
        Model.setStringProperty$default(this, "property", str, (String) null, false, 12, (Object) null);
    }

    public final Object getValue() {
        return Model.getOptAnyProperty$default(this, "value", (Function0) null, 2, (Object) null);
    }

    private final void setValue(Object obj) {
        Model.setOptAnyProperty$default(this, "value", obj, (String) null, false, 12, (Object) null);
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
    public SetPropertyOperation(String str, String str2, String str3, Object obj) {
        this();
        Intrinsics.checkNotNullParameter(str, "appId");
        Intrinsics.checkNotNullParameter(str2, "onesignalId");
        Intrinsics.checkNotNullParameter(str3, "property");
        setAppId(str);
        setOnesignalId(str2);
        setProperty(str3);
        setValue(obj);
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
