package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzayj extends zzazd {
    private final zzaxq zzi;

    public zzayj(zzaxp zzaxp, String str, String str2, zzata zzata, int i, int i2, zzaxq zzaxq) {
        super(zzaxp, "ZdMwT5n8r4APV4u4GhQlb1VCwOIVHkTm7kF7LnArEpyZnsv+C3G3q6fVFgtTcqcc", "O+vmm8flr2e7ZrTWUx/T8ClWwcEwLlJlfjM8sMGjZbg=", zzata, i, 85);
        this.zzi = zzaxq;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        long[] jArr = (long[]) this.zzf.invoke((Object) null, new Object[]{Long.valueOf(this.zzi.zzd()), Long.valueOf(this.zzi.zzh()), Long.valueOf(this.zzi.zzb()), Long.valueOf(this.zzi.zzf())});
        synchronized (this.zze) {
            this.zze.zzx(jArr[0]);
            this.zze.zzw(jArr[1]);
        }
    }
}
