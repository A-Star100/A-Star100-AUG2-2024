package com.onesignal.user.internal.operations;

import com.onesignal.common.modeling.Model;
import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0005¢\u0006\u0002\u0010\bR$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00068F@BX\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@BX\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@BX\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/onesignal/user/internal/operations/PurchaseInfo;", "Lcom/onesignal/common/modeling/Model;", "sku", "", "iso", "amount", "Ljava/math/BigDecimal;", "(Ljava/lang/String;Ljava/lang/String;Ljava/math/BigDecimal;)V", "()V", "value", "getAmount", "()Ljava/math/BigDecimal;", "setAmount", "(Ljava/math/BigDecimal;)V", "getIso", "()Ljava/lang/String;", "setIso", "(Ljava/lang/String;)V", "getSku", "setSku", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TrackPurchaseOperation.kt */
public final class PurchaseInfo extends Model {
    public PurchaseInfo() {
        super((Model) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public final String getSku() {
        return Model.getStringProperty$default(this, "sku", (Function0) null, 2, (Object) null);
    }

    private final void setSku(String str) {
        Model.setStringProperty$default(this, "sku", str, (String) null, false, 12, (Object) null);
    }

    public final String getIso() {
        return Model.getStringProperty$default(this, "iso", (Function0) null, 2, (Object) null);
    }

    private final void setIso(String str) {
        Model.setStringProperty$default(this, "iso", str, (String) null, false, 12, (Object) null);
    }

    public final BigDecimal getAmount() {
        return Model.getBigDecimalProperty$default(this, "amount", (Function0) null, 2, (Object) null);
    }

    private final void setAmount(BigDecimal bigDecimal) {
        Model.setBigDecimalProperty$default(this, "amount", bigDecimal, (String) null, false, 12, (Object) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PurchaseInfo(String str, String str2, BigDecimal bigDecimal) {
        this();
        Intrinsics.checkNotNullParameter(str, "sku");
        Intrinsics.checkNotNullParameter(str2, "iso");
        Intrinsics.checkNotNullParameter(bigDecimal, "amount");
        setSku(str);
        setIso(str2);
        setAmount(bigDecimal);
    }
}
