package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzor {
    private final zzcu zza;
    /* access modifiers changed from: private */
    public zzfzn zzb = zzfzn.zzm();
    private zzfzq zzc = zzfzq.zzd();
    private zzvh zzd;
    private zzvh zze;
    private zzvh zzf;

    public zzor(zzcu zzcu) {
        this.zza = zzcu;
    }

    private static zzvh zzj(zzco zzco, zzfzn zzfzn, zzvh zzvh, zzcu zzcu) {
        zzcx zzn = zzco.zzn();
        int zze2 = zzco.zze();
        Object zzf2 = zzn.zzo() ? null : zzn.zzf(zze2);
        int zzc2 = (zzco.zzx() || zzn.zzo()) ? -1 : zzn.zzd(zze2, zzcu, false).zzc(zzfx.zzr(zzco.zzk()));
        for (int i = 0; i < zzfzn.size(); i++) {
            zzvh zzvh2 = (zzvh) zzfzn.get(i);
            if (zzm(zzvh2, zzf2, zzco.zzx(), zzco.zzb(), zzco.zzc(), zzc2)) {
                return zzvh2;
            }
        }
        if (zzfzn.isEmpty() && zzvh != null) {
            if (zzm(zzvh, zzf2, zzco.zzx(), zzco.zzb(), zzco.zzc(), zzc2)) {
                return zzvh;
            }
        }
        return null;
    }

    private final void zzk(zzfzp zzfzp, zzvh zzvh, zzcx zzcx) {
        if (zzvh != null) {
            if (zzcx.zza(zzvh.zza) != -1) {
                zzfzp.zza(zzvh, zzcx);
                return;
            }
            zzcx zzcx2 = (zzcx) this.zzc.get(zzvh);
            if (zzcx2 != null) {
                zzfzp.zza(zzvh, zzcx2);
            }
        }
    }

    private final void zzl(zzcx zzcx) {
        zzfzp zzfzp = new zzfzp();
        if (this.zzb.isEmpty()) {
            zzk(zzfzp, this.zze, zzcx);
            if (!zzfwl.zza(this.zzf, this.zze)) {
                zzk(zzfzp, this.zzf, zzcx);
            }
            if (!zzfwl.zza(this.zzd, this.zze) && !zzfwl.zza(this.zzd, this.zzf)) {
                zzk(zzfzp, this.zzd, zzcx);
            }
        } else {
            for (int i = 0; i < this.zzb.size(); i++) {
                zzk(zzfzp, (zzvh) this.zzb.get(i), zzcx);
            }
            if (!this.zzb.contains(this.zzd)) {
                zzk(zzfzp, this.zzd, zzcx);
            }
        }
        this.zzc = zzfzp.zzc();
    }

    private static boolean zzm(zzvh zzvh, Object obj, boolean z, int i, int i2, int i3) {
        if (!zzvh.zza.equals(obj)) {
            return false;
        }
        if (z) {
            if (!(zzvh.zzb == i && zzvh.zzc == i2)) {
                return false;
            }
        } else if (!(zzvh.zzb == -1 && zzvh.zze == i3)) {
            return false;
        }
        return true;
    }

    public final zzcx zza(zzvh zzvh) {
        return (zzcx) this.zzc.get(zzvh);
    }

    public final zzvh zzb() {
        return this.zzd;
    }

    public final zzvh zzc() {
        Object obj;
        Object next;
        if (this.zzb.isEmpty()) {
            return null;
        }
        zzfzn zzfzn = this.zzb;
        if (!(zzfzn instanceof List)) {
            Iterator it = zzfzn.iterator();
            do {
                next = it.next();
            } while (it.hasNext());
            obj = next;
        } else if (!zzfzn.isEmpty()) {
            obj = zzfzn.get(zzfzn.size() - 1);
        } else {
            throw new NoSuchElementException();
        }
        return (zzvh) obj;
    }

    public final zzvh zzd() {
        return this.zze;
    }

    public final zzvh zze() {
        return this.zzf;
    }

    public final void zzg(zzco zzco) {
        this.zzd = zzj(zzco, this.zzb, this.zze, this.zza);
    }

    public final void zzh(List list, zzvh zzvh, zzco zzco) {
        this.zzb = zzfzn.zzk(list);
        if (!list.isEmpty()) {
            this.zze = (zzvh) list.get(0);
            zzvh.getClass();
            this.zzf = zzvh;
        }
        if (this.zzd == null) {
            this.zzd = zzj(zzco, this.zzb, this.zze, this.zza);
        }
        zzl(zzco.zzn());
    }

    public final void zzi(zzco zzco) {
        this.zzd = zzj(zzco, this.zzb, this.zze, this.zza);
        zzl(zzco.zzn());
    }
}
