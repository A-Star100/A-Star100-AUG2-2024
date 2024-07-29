package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzlx {
    private final zzpb zza;
    private final List zzb = new ArrayList();
    private final IdentityHashMap zzc = new IdentityHashMap();
    private final Map zzd = new HashMap();
    private final zzlw zze;
    private final HashMap zzf;
    private final Set zzg;
    /* access modifiers changed from: private */
    public final zzmp zzh;
    /* access modifiers changed from: private */
    public final zzev zzi;
    private boolean zzj;
    private zzhy zzk;
    private zzxb zzl = new zzxb(0);

    public zzlx(zzlw zzlw, zzmp zzmp, zzev zzev, zzpb zzpb) {
        this.zza = zzpb;
        this.zze = zzlw;
        this.zzh = zzmp;
        this.zzi = zzev;
        this.zzf = new HashMap();
        this.zzg = new HashSet();
    }

    private final void zzr(int i, int i2) {
        while (i < this.zzb.size()) {
            ((zzlv) this.zzb.get(i)).zzd += i2;
            i++;
        }
    }

    private final void zzs(zzlv zzlv) {
        zzlu zzlu = (zzlu) this.zzf.get(zzlv);
        if (zzlu != null) {
            zzlu.zza.zzi(zzlu.zzb);
        }
    }

    private final void zzt() {
        Iterator it = this.zzg.iterator();
        while (it.hasNext()) {
            zzlv zzlv = (zzlv) it.next();
            if (zzlv.zzc.isEmpty()) {
                zzs(zzlv);
                it.remove();
            }
        }
    }

    private final void zzu(zzlv zzlv) {
        if (zzlv.zze && zzlv.zzc.isEmpty()) {
            zzlu zzlu = (zzlu) this.zzf.remove(zzlv);
            zzlu.getClass();
            zzlu.zza.zzp(zzlu.zzb);
            zzlu.zza.zzs(zzlu.zzc);
            zzlu.zza.zzr(zzlu.zzc);
            this.zzg.remove(zzlv);
        }
    }

    private final void zzv(zzlv zzlv) {
        zzvc zzvc = zzlv.zza;
        zzln zzln = new zzln(this);
        zzlt zzlt = new zzlt(this, zzlv);
        this.zzf.put(zzlv, new zzlu(zzvc, zzln, zzlt));
        zzvc.zzh(new Handler(zzfx.zzy(), (Handler.Callback) null), zzlt);
        zzvc.zzg(new Handler(zzfx.zzy(), (Handler.Callback) null), zzlt);
        zzvc.zzm(zzln, this.zzk, this.zza);
    }

    private final void zzw(int i, int i2) {
        while (true) {
            i2--;
            if (i2 >= i) {
                zzlv zzlv = (zzlv) this.zzb.remove(i2);
                this.zzd.remove(zzlv.zzb);
                zzr(i2, -zzlv.zza.zzC().zzc());
                zzlv.zze = true;
                if (this.zzj) {
                    zzu(zzlv);
                }
            } else {
                return;
            }
        }
    }

    public final int zza() {
        return this.zzb.size();
    }

    public final zzcx zzb() {
        if (this.zzb.isEmpty()) {
            return zzcx.zza;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.zzb.size(); i2++) {
            zzlv zzlv = (zzlv) this.zzb.get(i2);
            zzlv.zzd = i;
            i += zzlv.zza.zzC().zzc();
        }
        return new zzmd(this.zzb, this.zzl);
    }

    public final zzcx zzc(int i, int i2, List list) {
        boolean z = true;
        zzek.zzd(i >= 0 && i <= i2 && i2 <= zza());
        if (list.size() != i2 - i) {
            z = false;
        }
        zzek.zzd(z);
        for (int i3 = i; i3 < i2; i3++) {
            ((zzlv) this.zzb.get(i3)).zza.zzt((zzbp) list.get(i3 - i));
        }
        return zzb();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(zzvj zzvj, zzcx zzcx) {
        this.zze.zzh();
    }

    public final void zzg(zzhy zzhy) {
        zzek.zzf(!this.zzj);
        this.zzk = zzhy;
        for (int i = 0; i < this.zzb.size(); i++) {
            zzlv zzlv = (zzlv) this.zzb.get(i);
            zzv(zzlv);
            this.zzg.add(zzlv);
        }
        this.zzj = true;
    }

    public final void zzh() {
        for (zzlu zzlu : this.zzf.values()) {
            try {
                zzlu.zza.zzp(zzlu.zzb);
            } catch (RuntimeException e) {
                zzfe.zzd("MediaSourceList", "Failed to release child source.", e);
            }
            zzlu.zza.zzs(zzlu.zzc);
            zzlu.zza.zzr(zzlu.zzc);
        }
        this.zzf.clear();
        this.zzg.clear();
        this.zzj = false;
    }

    public final void zzi(zzvf zzvf) {
        zzlv zzlv = (zzlv) this.zzc.remove(zzvf);
        zzlv.getClass();
        zzlv.zza.zzG(zzvf);
        zzlv.zzc.remove(((zzuz) zzvf).zza);
        if (!this.zzc.isEmpty()) {
            zzt();
        }
        zzu(zzlv);
    }

    public final boolean zzj() {
        return this.zzj;
    }

    public final zzcx zzk(int i, List list, zzxb zzxb) {
        if (!list.isEmpty()) {
            this.zzl = zzxb;
            for (int i2 = i; i2 < list.size() + i; i2++) {
                zzlv zzlv = (zzlv) list.get(i2 - i);
                if (i2 > 0) {
                    zzlv zzlv2 = (zzlv) this.zzb.get(i2 - 1);
                    zzlv.zzc(zzlv2.zzd + zzlv2.zza.zzC().zzc());
                } else {
                    zzlv.zzc(0);
                }
                zzr(i2, zzlv.zza.zzC().zzc());
                this.zzb.add(i2, zzlv);
                this.zzd.put(zzlv.zzb, zzlv);
                if (this.zzj) {
                    zzv(zzlv);
                    if (this.zzc.isEmpty()) {
                        this.zzg.add(zzlv);
                    } else {
                        zzs(zzlv);
                    }
                }
            }
        }
        return zzb();
    }

    public final zzcx zzl(int i, int i2, int i3, zzxb zzxb) {
        zzek.zzd(zza() >= 0);
        this.zzl = null;
        return zzb();
    }

    public final zzcx zzm(int i, int i2, zzxb zzxb) {
        boolean z = false;
        if (i >= 0 && i <= i2 && i2 <= zza()) {
            z = true;
        }
        zzek.zzd(z);
        this.zzl = zzxb;
        zzw(i, i2);
        return zzb();
    }

    public final zzcx zzn(List list, zzxb zzxb) {
        zzw(0, this.zzb.size());
        return zzk(this.zzb.size(), list, zzxb);
    }

    public final zzcx zzo(zzxb zzxb) {
        int zza2 = zza();
        if (zzxb.zzc() != zza2) {
            zzxb = zzxb.zzf().zzg(0, zza2);
        }
        this.zzl = zzxb;
        return zzb();
    }

    public final zzvf zzp(zzvh zzvh, zzzo zzzo, long j) {
        int i = zzmd.zzc;
        Object obj = ((Pair) zzvh.zza).first;
        zzvh zza2 = zzvh.zza(((Pair) zzvh.zza).second);
        zzlv zzlv = (zzlv) this.zzd.get(obj);
        zzlv.getClass();
        this.zzg.add(zzlv);
        zzlu zzlu = (zzlu) this.zzf.get(zzlv);
        if (zzlu != null) {
            zzlu.zza.zzk(zzlu.zzb);
        }
        zzlv.zzc.add(zza2);
        zzuz zzH = zzlv.zza.zzI(zza2, zzzo, j);
        this.zzc.put(zzH, zzlv);
        zzt();
        return zzH;
    }

    public final zzxb zzq() {
        return this.zzl;
    }
}
