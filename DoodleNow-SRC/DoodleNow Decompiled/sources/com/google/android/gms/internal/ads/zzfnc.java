package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfnc extends zzfmy {
    private final zzfna zza;
    private final zzfmz zzb;
    private final zzfnu zzc = new zzfnu();
    private zzfpg zzd;
    private zzfoe zze;
    private boolean zzf = false;
    private boolean zzg = false;
    private final String zzh;

    zzfnc(zzfmz zzfmz, zzfna zzfna) {
        String uuid = UUID.randomUUID().toString();
        this.zzb = zzfmz;
        this.zza = zzfna;
        this.zzh = uuid;
        zzk((View) null);
        if (zzfna.zzd() == zzfnb.HTML || zzfna.zzd() == zzfnb.JAVASCRIPT) {
            this.zze = new zzfof(uuid, zzfna.zza());
        } else {
            this.zze = new zzfoi(uuid, zzfna.zzi(), (String) null);
        }
        this.zze.zzn();
        zzfnq.zza().zzd(this);
        this.zze.zzf(zzfmz);
    }

    private final void zzk(View view) {
        this.zzd = new zzfpg(view);
    }

    public final void zzb(View view, zzfnf zzfnf, String str) {
        if (!this.zzg) {
            this.zzc.zzb(view, zzfnf, "Ad overlay");
        }
    }

    public final void zzc() {
        if (!this.zzg) {
            this.zzd.clear();
            if (!this.zzg) {
                this.zzc.zzc();
            }
            this.zzg = true;
            this.zze.zze();
            zzfnq.zza().zze(this);
            this.zze.zzc();
            this.zze = null;
        }
    }

    public final void zzd(View view) {
        if (!this.zzg && zzf() != view) {
            zzk(view);
            this.zze.zzb();
            Collection<zzfnc> zzc2 = zzfnq.zza().zzc();
            if (zzc2 != null && !zzc2.isEmpty()) {
                for (zzfnc zzfnc : zzc2) {
                    if (zzfnc != this && zzfnc.zzf() == view) {
                        zzfnc.zzd.clear();
                    }
                }
            }
        }
    }

    public final void zze() {
        if (!this.zzf) {
            this.zzf = true;
            zzfnq.zza().zzf(this);
            this.zze.zzl(zzfny.zzb().zza());
            this.zze.zzg(zzfno.zza().zzb());
            this.zze.zzi(this, this.zza);
        }
    }

    public final View zzf() {
        return (View) this.zzd.get();
    }

    public final zzfoe zzg() {
        return this.zze;
    }

    public final String zzh() {
        return this.zzh;
    }

    public final List zzi() {
        return this.zzc.zza();
    }

    public final boolean zzj() {
        return this.zzf && !this.zzg;
    }
}
