package com.amazon.device.iap.internal.util;

/* compiled from: ReceiptVersion */
public enum d {
    LEGACY(0),
    V1(1),
    V2(2),
    V3(3);
    
    private int e;

    /* access modifiers changed from: package-private */
    public int a() {
        return this.e;
    }

    private d(int i) {
        this.e = i;
    }

    public boolean a(d dVar) {
        return dVar != null && this.e < dVar.e;
    }
}
