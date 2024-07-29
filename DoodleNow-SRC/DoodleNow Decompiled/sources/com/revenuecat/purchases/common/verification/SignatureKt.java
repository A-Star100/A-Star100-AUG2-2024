package com.revenuecat.purchases.common.verification;

import com.revenuecat.purchases.common.verification.Signature;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¨\u0006\u0004"}, d2 = {"copyOf", "", "component", "Lcom/revenuecat/purchases/common/verification/Signature$Component;", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: Signature.kt */
public final class SignatureKt {
    /* access modifiers changed from: private */
    public static final byte[] copyOf(byte[] bArr, Signature.Component component) {
        return ArraysKt.copyOfRange(bArr, component.getStartByte(), component.getEndByte());
    }
}
