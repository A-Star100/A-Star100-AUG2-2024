package com.google.android.gms.internal.mlkit_vision_barcode;

import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
final class zzds extends zzcx {
    static final zzcx zza = new zzds((Object) null, new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    private zzds(@CheckForNull Object obj, Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    static zzds zzg(int i, Object[] objArr, zzcw zzcw) {
        Object obj = objArr[0];
        obj.getClass();
        Object obj2 = objArr[1];
        obj2.getClass();
        zzcb.zzb(obj, obj2);
        return new zzds((Object) null, objArr, 1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0020 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001f A[RETURN] */
    @javax.annotation.CheckForNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object get(@javax.annotation.CheckForNull java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object[] r0 = r4.zzb
            int r1 = r4.zzc
            r2 = 0
            if (r5 != 0) goto L_0x0009
        L_0x0007:
            r5 = r2
            goto L_0x001d
        L_0x0009:
            r3 = 1
            if (r1 != r3) goto L_0x0007
            r1 = 0
            r1 = r0[r1]
            r1.getClass()
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x0007
            r5 = r0[r3]
            r5.getClass()
        L_0x001d:
            if (r5 != 0) goto L_0x0020
            return r2
        L_0x0020:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode.zzds.get(java.lang.Object):java.lang.Object");
    }

    public final int size() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final zzcq zza() {
        return new zzdr(this.zzb, 1, this.zzc);
    }

    /* access modifiers changed from: package-private */
    public final zzcy zzd() {
        return new zzdp(this, this.zzb, 0, this.zzc);
    }

    /* access modifiers changed from: package-private */
    public final zzcy zze() {
        return new zzdq(this, new zzdr(this.zzb, 0, this.zzc));
    }
}
