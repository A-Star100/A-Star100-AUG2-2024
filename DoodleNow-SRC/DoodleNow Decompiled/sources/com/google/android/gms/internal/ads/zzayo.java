package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzayo extends zzazd {
    private final zzaws zzi;
    private final long zzj;
    private final long zzk;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzayo(zzaxp zzaxp, String str, String str2, zzata zzata, int i, int i2, zzaws zzaws, long j, long j2) {
        super(zzaxp, "gAg/p/cQzJRjYz9LhE8cRk72DVV1Cpozf/TbzvACqLcTgM3sRjMEb3DCmwYhMmhP", "avDZD6/xoSbFYvWCy23XLncB75oD5DxKdrTKFY2O0hY=", zzata, i, 11);
        this.zzi = zzaws;
        this.zzj = j;
        this.zzk = j2;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        zzaws zzaws = this.zzi;
        if (zzaws != null) {
            zzawq zzawq = new zzawq((String) this.zzf.invoke((Object) null, new Object[]{zzaws.zzb(), Long.valueOf(this.zzj), Long.valueOf(this.zzk)}));
            synchronized (this.zze) {
                this.zze.zzE(zzawq.zza.longValue());
                if (zzawq.zzb.longValue() >= 0) {
                    this.zze.zzW(zzawq.zzb.longValue());
                }
                if (zzawq.zzc.longValue() >= 0) {
                    this.zze.zzg(zzawq.zzc.longValue());
                }
            }
        }
    }
}
