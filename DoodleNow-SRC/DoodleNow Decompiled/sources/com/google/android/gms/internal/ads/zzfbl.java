package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.overlay.zzp;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfbl implements zzcyt, zzdap, zzfdb, zzp, zzdbb, zzczg, zzdgn {
    private final zzfhs zza;
    private final AtomicReference zzb = new AtomicReference();
    private final AtomicReference zzc = new AtomicReference();
    private final AtomicReference zzd = new AtomicReference();
    private final AtomicReference zze = new AtomicReference();
    private final AtomicReference zzf = new AtomicReference();
    private final AtomicReference zzg = new AtomicReference();
    private zzfbl zzh = null;

    public zzfbl(zzfhs zzfhs) {
        this.zza = zzfhs;
    }

    public static zzfbl zzi(zzfbl zzfbl) {
        zzfbl zzfbl2 = new zzfbl(zzfbl.zza);
        zzfbl2.zzh = zzfbl;
        return zzfbl2;
    }

    public final void zzdG() {
        zzfbl zzfbl = this.zzh;
        if (zzfbl != null) {
            zzfbl.zzdG();
        } else {
            zzfcs.zza(this.zzd, zzfbc.zza);
        }
    }

    public final void zzdH() {
    }

    public final void zzdf() {
    }

    public final void zzdk() {
    }

    public final void zzdq() {
        zzfbl zzfbl = this.zzh;
        if (zzfbl != null) {
            zzfbl.zzdq();
        } else {
            zzfcs.zza(this.zzf, zzfaz.zza);
        }
    }

    public final void zzdr() {
        zzfbl zzfbl = this.zzh;
        if (zzfbl != null) {
            zzfbl.zzdr();
            return;
        }
        zzfcs.zza(this.zzf, zzfbk.zza);
        zzfcs.zza(this.zzd, zzfax.zza);
        zzfcs.zza(this.zzd, zzfay.zza);
    }

    public final void zzdt() {
        zzfbl zzfbl = this.zzh;
        if (zzfbl != null) {
            zzfbl.zzdt();
        } else {
            zzfcs.zza(this.zzf, zzfbj.zza);
        }
    }

    public final void zzdu(int i) {
        zzfbl zzfbl = this.zzh;
        if (zzfbl != null) {
            zzfbl.zzdu(i);
        } else {
            zzfcs.zza(this.zzf, new zzfbf(i));
        }
    }

    public final void zzg() {
        zzfbl zzfbl = this.zzh;
        if (zzfbl != null) {
            zzfbl.zzg();
        } else {
            zzfcs.zza(this.zze, zzfbi.zza);
        }
    }

    public final void zzh(zzs zzs) {
        zzfbl zzfbl = this.zzh;
        if (zzfbl != null) {
            zzfbl.zzh(zzs);
        } else {
            zzfcs.zza(this.zzg, new zzfaw(zzs));
        }
    }

    public final void zzj() {
        zzfbl zzfbl = this.zzh;
        if (zzfbl != null) {
            zzfbl.zzj();
            return;
        }
        this.zza.zza();
        zzfcs.zza(this.zzc, zzfbd.zza);
        zzfcs.zza(this.zzd, zzfbe.zza);
    }

    public final void zzl(zzfdb zzfdb) {
        this.zzh = (zzfbl) zzfdb;
    }

    public final void zzm(zzp zzp) {
        this.zzf.set(zzp);
    }

    public final void zzn(zzdg zzdg) {
        this.zzg.set(zzdg);
    }

    public final void zzo(zzbbu zzbbu) {
        this.zzb.set(zzbbu);
    }

    public final void zzp(zzbby zzbby) {
        this.zzd.set(zzbby);
    }

    public final void zzq(zze zze2) {
        zzfbl zzfbl = this.zzh;
        if (zzfbl != null) {
            zzfbl.zzq(zze2);
        } else {
            zzfcs.zza(this.zzd, new zzfba(zze2));
        }
    }

    public final void zzk(zzbbr zzbbr) {
        zzfbl zzfbl = this.zzh;
        if (zzfbl != null) {
            zzfbl.zzk(zzbbr);
        } else {
            zzfcs.zza(this.zzb, new zzfbb(zzbbr));
        }
    }

    public final void zzdB(zze zze2) {
        zzfbl zzfbl = this.zzh;
        if (zzfbl != null) {
            zzfbl.zzdB(zze2);
            return;
        }
        zzfcs.zza(this.zzb, new zzfbg(zze2));
        zzfcs.zza(this.zzb, new zzfbh(zze2));
    }
}
