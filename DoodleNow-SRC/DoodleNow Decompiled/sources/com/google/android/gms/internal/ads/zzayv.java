package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzayv extends zzazd {
    private final StackTraceElement[] zzi;

    public zzayv(zzaxp zzaxp, String str, String str2, zzata zzata, int i, int i2, StackTraceElement[] stackTraceElementArr) {
        super(zzaxp, "9douHjmTTjq3N4YYUdzzHaKyxIqsB5K92p8t26vKQB1HahpVak+32YHan4LmgLPE", "q6oLc2ULDKRAR1VDdX5lO9/kb0NHjx7PMACMr/7cZL8=", zzata, i, 45);
        this.zzi = stackTraceElementArr;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        zzaun zzaun;
        Object obj = this.zzi;
        if (obj != null) {
            zzaxg zzaxg = new zzaxg((String) this.zzf.invoke((Object) null, new Object[]{obj}));
            synchronized (this.zze) {
                this.zze.zzL(zzaxg.zza.longValue());
                if (zzaxg.zzb.booleanValue()) {
                    zzata zzata = this.zze;
                    if (zzaxg.zzc.booleanValue()) {
                        zzaun = zzaun.ENUM_FALSE;
                    } else {
                        zzaun = zzaun.ENUM_TRUE;
                    }
                    zzata.zzA(zzaun);
                } else {
                    this.zze.zzA(zzaun.ENUM_FAILURE);
                }
            }
        }
    }
}
