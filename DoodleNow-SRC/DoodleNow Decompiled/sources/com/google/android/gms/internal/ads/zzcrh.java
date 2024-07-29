package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzbu;
import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.client.zzdn;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcrh extends zzbbq {
    private final zzcrg zza;
    private final zzbu zzb;
    private final zzfbl zzc;
    private boolean zzd = ((Boolean) zzba.zzc().zza(zzbdz.zzaG)).booleanValue();
    private final zzduh zze;

    public zzcrh(zzcrg zzcrg, zzbu zzbu, zzfbl zzfbl, zzduh zzduh) {
        this.zza = zzcrg;
        this.zzb = zzbu;
        this.zzc = zzfbl;
        this.zze = zzduh;
    }

    public final zzbu zze() {
        return this.zzb;
    }

    public final zzdn zzf() {
        if (!((Boolean) zzba.zzc().zza(zzbdz.zzgQ)).booleanValue()) {
            return null;
        }
        return this.zza.zzl();
    }

    public final void zzg(boolean z) {
        this.zzd = z;
    }

    public final void zzh(zzdg zzdg) {
        Preconditions.checkMainThread("setOnPaidEventListener must be called on the main UI thread.");
        if (this.zzc != null) {
            try {
                if (!zzdg.zzf()) {
                    this.zze.zze();
                }
            } catch (RemoteException e) {
                zzm.zzf("Error in making CSI ping for reporting paid event callback", e);
            }
            this.zzc.zzn(zzdg);
        }
    }

    public final void zzi(IObjectWrapper iObjectWrapper, zzbby zzbby) {
        try {
            this.zzc.zzp(zzbby);
            this.zza.zzd((Activity) ObjectWrapper.unwrap(iObjectWrapper), zzbby, this.zzd);
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }
}
