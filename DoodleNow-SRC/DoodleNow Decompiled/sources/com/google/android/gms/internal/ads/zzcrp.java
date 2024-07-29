package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzbu;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzcrp extends zzcrm {
    private final Context zzc;
    private final View zzd;
    private final zzcgm zze;
    private final zzffo zzf;
    private final zzctt zzg;
    private final zzdlj zzh;
    private final zzdgp zzi;
    private final zzhip zzj;
    private final Executor zzk;
    private zzq zzl;

    zzcrp(zzctu zzctu, Context context, zzffo zzffo, View view, zzcgm zzcgm, zzctt zzctt, zzdlj zzdlj, zzdgp zzdgp, zzhip zzhip, Executor executor) {
        super(zzctu);
        this.zzc = context;
        this.zzd = view;
        this.zze = zzcgm;
        this.zzf = zzffo;
        this.zzg = zzctt;
        this.zzh = zzdlj;
        this.zzi = zzdgp;
        this.zzj = zzhip;
        this.zzk = executor;
    }

    public static /* synthetic */ void zzi(zzcrp zzcrp) {
        zzdlj zzdlj = zzcrp.zzh;
        if (zzdlj.zze() != null) {
            try {
                zzdlj.zze().zze((zzbu) zzcrp.zzj.zzb(), ObjectWrapper.wrap(zzcrp.zzc));
            } catch (RemoteException e) {
                zzm.zzh("RemoteException when notifyAdLoad is called", e);
            }
        }
    }

    public final int zza() {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzhN)).booleanValue() && this.zzb.zzah) {
            if (!((Boolean) zzba.zzc().zza(zzbdz.zzhO)).booleanValue()) {
                return 0;
            }
        }
        return this.zza.zzb.zzb.zzc;
    }

    public final View zzc() {
        return this.zzd;
    }

    public final zzdq zzd() {
        try {
            return this.zzg.zza();
        } catch (zzfgp unused) {
            return null;
        }
    }

    public final zzffo zze() {
        zzq zzq = this.zzl;
        if (zzq != null) {
            return zzfgo.zzb(zzq);
        }
        zzffn zzffn = this.zzb;
        if (zzffn.zzad) {
            for (String str : zzffn.zza) {
                if (str == null || !str.contains("FirstParty")) {
                }
            }
            View view = this.zzd;
            return new zzffo(view.getWidth(), view.getHeight(), false);
        }
        return (zzffo) this.zzb.zzs.get(0);
    }

    public final zzffo zzf() {
        return this.zzf;
    }

    public final void zzg() {
        this.zzi.zza();
    }

    public final void zzh(ViewGroup viewGroup, zzq zzq) {
        zzcgm zzcgm;
        if (viewGroup != null && (zzcgm = this.zze) != null) {
            zzcgm.zzah(zzcie.zzc(zzq));
            viewGroup.setMinimumHeight(zzq.zzc);
            viewGroup.setMinimumWidth(zzq.zzf);
            this.zzl = zzq;
        }
    }

    public final void zzj() {
        this.zzk.execute(new zzcro(this));
        super.zzj();
    }
}
