package com.google.android.gms.internal.ads;

import android.provider.Settings;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzayb extends zzazd {
    public zzayb(zzaxp zzaxp, String str, String str2, zzata zzata, int i, int i2) {
        super(zzaxp, "d7YRusR2mxxBt1bBYjK2gXVvJl/MfqFw2IiZZVeFOFqksQBErGXLOKgf56kYtWpK", "q4VBjxb/Ij/RcUKEcmQK+TpC64QFNLpq6sfIawaWN1g=", zzata, i, 49);
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        zzaun zzaun;
        this.zze.zzf(zzaun.ENUM_FAILURE);
        try {
            boolean booleanValue = ((Boolean) this.zzf.invoke((Object) null, new Object[]{this.zzb.zzb()})).booleanValue();
            zzata zzata = this.zze;
            if (booleanValue) {
                zzaun = zzaun.ENUM_TRUE;
            } else {
                zzaun = zzaun.ENUM_FALSE;
            }
            zzata.zzf(zzaun);
        } catch (InvocationTargetException e) {
            if (!(e.getTargetException() instanceof Settings.SettingNotFoundException)) {
                throw e;
            }
        }
    }
}
