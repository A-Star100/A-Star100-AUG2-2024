package com.onesignal.user.internal.operations;

import com.onesignal.common.IDManager;
import com.onesignal.common.modeling.Model;
import com.onesignal.core.internal.operations.GroupComparisonType;
import com.onesignal.core.internal.operations.Operation;
import com.onesignal.user.internal.operations.impl.executors.UpdateUserOperationExecutor;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B5\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fB\u0005¢\u0006\u0002\u0010\rJ\u001e\u0010-\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n2\u0006\u0010.\u001a\u00020\u00032\u0006\u0010/\u001a\u000200H\u0014J\u001c\u00101\u001a\u0002022\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000304H\u0016R$\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b8F@BX\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00038F@BX\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0014R\u0014\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0014R$\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00038F@BX\u000e¢\u0006\f\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u0016R0\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8F@BX\u000e¢\u0006\f\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00068F@BX\u000e¢\u0006\f\u001a\u0004\b*\u0010\u001b\"\u0004\b+\u0010,¨\u00065"}, d2 = {"Lcom/onesignal/user/internal/operations/TrackPurchaseOperation;", "Lcom/onesignal/core/internal/operations/Operation;", "appId", "", "onesignalId", "treatNewAsExisting", "", "amountSpent", "Ljava/math/BigDecimal;", "purchases", "", "Lcom/onesignal/user/internal/operations/PurchaseInfo;", "(Ljava/lang/String;Ljava/lang/String;ZLjava/math/BigDecimal;Ljava/util/List;)V", "()V", "value", "getAmountSpent", "()Ljava/math/BigDecimal;", "setAmountSpent", "(Ljava/math/BigDecimal;)V", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "applyToRecordId", "getApplyToRecordId", "canStartExecute", "getCanStartExecute", "()Z", "createComparisonKey", "getCreateComparisonKey", "groupComparisonType", "Lcom/onesignal/core/internal/operations/GroupComparisonType;", "getGroupComparisonType", "()Lcom/onesignal/core/internal/operations/GroupComparisonType;", "modifyComparisonKey", "getModifyComparisonKey", "getOnesignalId", "setOnesignalId", "getPurchases", "()Ljava/util/List;", "setPurchases", "(Ljava/util/List;)V", "getTreatNewAsExisting", "setTreatNewAsExisting", "(Z)V", "createListForProperty", "property", "jsonArray", "Lorg/json/JSONArray;", "translateIds", "", "map", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TrackPurchaseOperation.kt */
public final class TrackPurchaseOperation extends Operation {
    private final GroupComparisonType groupComparisonType;

    public String getCreateComparisonKey() {
        return "";
    }

    public GroupComparisonType getGroupComparisonType() {
        return this.groupComparisonType;
    }

    public TrackPurchaseOperation() {
        super(UpdateUserOperationExecutor.TRACK_PURCHASE);
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

    public final boolean getTreatNewAsExisting() {
        return Model.getBooleanProperty$default(this, "treatNewAsExisting", (Function0) null, 2, (Object) null);
    }

    private final void setTreatNewAsExisting(boolean z) {
        Model.setBooleanProperty$default(this, "treatNewAsExisting", z, (String) null, false, 12, (Object) null);
    }

    public final BigDecimal getAmountSpent() {
        return Model.getBigDecimalProperty$default(this, "amountSpent", (Function0) null, 2, (Object) null);
    }

    private final void setAmountSpent(BigDecimal bigDecimal) {
        Model.setBigDecimalProperty$default(this, "amountSpent", bigDecimal, (String) null, false, 12, (Object) null);
    }

    public final List<PurchaseInfo> getPurchases() {
        return Model.getListProperty$default(this, "purchases", (Function0) null, 2, (Object) null);
    }

    private final void setPurchases(List<PurchaseInfo> list) {
        Model.setListProperty$default(this, "purchases", list, (String) null, false, 12, (Object) null);
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
    public TrackPurchaseOperation(String str, String str2, boolean z, BigDecimal bigDecimal, List<PurchaseInfo> list) {
        this();
        Intrinsics.checkNotNullParameter(str, "appId");
        Intrinsics.checkNotNullParameter(str2, "onesignalId");
        Intrinsics.checkNotNullParameter(bigDecimal, "amountSpent");
        Intrinsics.checkNotNullParameter(list, "purchases");
        setAppId(str);
        setOnesignalId(str2);
        setTreatNewAsExisting(z);
        setAmountSpent(bigDecimal);
        setPurchases(list);
    }

    public void translateIds(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        if (map.containsKey(getOnesignalId())) {
            String str = map.get(getOnesignalId());
            Intrinsics.checkNotNull(str);
            setOnesignalId(str);
        }
    }

    /* access modifiers changed from: protected */
    public List<?> createListForProperty(String str, JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(str, "property");
        Intrinsics.checkNotNullParameter(jSONArray, "jsonArray");
        if (!Intrinsics.areEqual((Object) str, (Object) "purchases")) {
            return null;
        }
        List<?> arrayList = new ArrayList<>();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            PurchaseInfo purchaseInfo = new PurchaseInfo();
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            Intrinsics.checkNotNullExpressionValue(jSONObject, "jsonArray.getJSONObject(item)");
            purchaseInfo.initializeFromJson(jSONObject);
            arrayList.add(purchaseInfo);
        }
        return arrayList;
    }
}
