package com.google.android.gms.internal.ads;

import android.util.DisplayMetrics;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzaza extends zzazd {
    private final View zzi;

    public zzaza(zzaxp zzaxp, String str, String str2, zzata zzata, int i, int i2, View view) {
        super(zzaxp, "fHaUCxrr3fcbpdQPVJw6OSoHeHoizr6wmxmAsnLvDUhuNG2u8ebKX4VPxAoXSx4W", "K/sgHSTVeE1LLZ4HP+m5KF6ND+k7W4ID3M3VTul8bAI=", zzata, i, 57);
        this.zzi = view;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        if (this.zzi != null) {
            Boolean bool = (Boolean) zzba.zzc().zza(zzbdz.zzdn);
            Boolean bool2 = (Boolean) zzba.zzc().zza(zzbdz.zzkD);
            DisplayMetrics displayMetrics = this.zzb.zzb().getResources().getDisplayMetrics();
            zzaxt zzaxt = new zzaxt((String) this.zzf.invoke((Object) null, new Object[]{this.zzi, displayMetrics, bool, bool2}));
            zzaub zza = zzauc.zza();
            zza.zzb(zzaxt.zza.longValue());
            zza.zzd(zzaxt.zzb.longValue());
            zza.zze(zzaxt.zzc.longValue());
            if (bool2.booleanValue()) {
                zza.zzc(zzaxt.zze.longValue());
            }
            if (bool.booleanValue()) {
                zza.zza(zzaxt.zzd.longValue());
            }
            this.zze.zzaf((zzauc) zza.zzbr());
        }
    }
}
