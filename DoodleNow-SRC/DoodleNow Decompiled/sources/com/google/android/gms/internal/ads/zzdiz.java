package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.internal.ads.zzbdg;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdiz implements zzcyq, zzdfs {
    private final zzbzz zza;
    private final Context zzb;
    private final zzcad zzc;
    private final View zzd;
    private String zze;
    private final zzbdg.zza.C0013zza zzf;

    public zzdiz(zzbzz zzbzz, Context context, zzcad zzcad, View view, zzbdg.zza.C0013zza zza2) {
        this.zza = zzbzz;
        this.zzb = context;
        this.zzc = zzcad;
        this.zzd = view;
        this.zzf = zza2;
    }

    public final void zza() {
        this.zza.zzb(false);
    }

    public final void zzb() {
    }

    public final void zzc() {
        View view = this.zzd;
        if (!(view == null || this.zze == null)) {
            this.zzc.zzo(view.getContext(), this.zze);
        }
        this.zza.zzb(true);
    }

    @ParametersAreNonnullByDefault
    public final void zzds(zzbxq zzbxq, String str, String str2) {
        if (this.zzc.zzp(this.zzb)) {
            try {
                zzcad zzcad = this.zzc;
                Context context = this.zzb;
                zzcad.zzl(context, zzcad.zza(context), this.zza.zza(), zzbxq.zzc(), zzbxq.zzb());
            } catch (RemoteException e) {
                zzm.zzk("Remote Exception to get reward item.", e);
            }
        }
    }

    public final void zze() {
    }

    public final void zzf() {
    }

    public final void zzk() {
    }

    public final void zzl() {
        if (this.zzf != zzbdg.zza.C0013zza.APP_OPEN) {
            String zzc2 = this.zzc.zzc(this.zzb);
            this.zze = zzc2;
            this.zze = String.valueOf(zzc2).concat(this.zzf == zzbdg.zza.C0013zza.REWARD_BASED_VIDEO_AD ? "/Rewarded" : "/Interstitial");
        }
    }
}
