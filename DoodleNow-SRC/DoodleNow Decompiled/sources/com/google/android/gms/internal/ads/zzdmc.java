package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdmc implements View.OnClickListener {
    String zza;
    Long zzb;
    WeakReference zzc;
    private final zzdpx zzd;
    private final Clock zze;
    private zzbiy zzf;
    private zzbky zzg;

    public zzdmc(zzdpx zzdpx, Clock clock) {
        this.zzd = zzdpx;
        this.zze = clock;
    }

    private final void zzd() {
        View view;
        this.zza = null;
        this.zzb = null;
        WeakReference weakReference = this.zzc;
        if (weakReference != null && (view = (View) weakReference.get()) != null) {
            view.setClickable(false);
            view.setOnClickListener((View.OnClickListener) null);
            this.zzc = null;
        }
    }

    public final void onClick(View view) {
        WeakReference weakReference = this.zzc;
        if (weakReference != null && weakReference.get() == view) {
            if (!(this.zza == null || this.zzb == null)) {
                HashMap hashMap = new HashMap();
                hashMap.put("id", this.zza);
                hashMap.put("time_interval", String.valueOf(this.zze.currentTimeMillis() - this.zzb.longValue()));
                hashMap.put("messageType", "onePointFiveClick");
                this.zzd.zzj("sendMessageToNativeJs", hashMap);
            }
            zzd();
        }
    }

    public final zzbiy zza() {
        return this.zzf;
    }

    public final void zzb() {
        if (this.zzf != null && this.zzb != null) {
            zzd();
            try {
                this.zzf.zze();
            } catch (RemoteException e) {
                zzm.zzl("#007 Could not call remote method.", e);
            }
        }
    }

    public final void zzc(zzbiy zzbiy) {
        this.zzf = zzbiy;
        zzbky zzbky = this.zzg;
        if (zzbky != null) {
            this.zzd.zzn("/unconfirmedClick", zzbky);
        }
        zzdmb zzdmb = new zzdmb(this, zzbiy);
        this.zzg = zzdmb;
        this.zzd.zzl("/unconfirmedClick", zzdmb);
    }
}
