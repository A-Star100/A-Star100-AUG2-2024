package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzaaq implements zzaby, zzdn, zzabi {
    private static final Executor zza = zzaai.zza;
    private final Context zzb;
    private final zzcp zzc;
    private final CopyOnWriteArraySet zzd = new CopyOnWriteArraySet();
    private zzel zze = zzel.zza;
    private zzabd zzf;
    private zzabj zzg;
    private zzaba zzh;
    private zzev zzi;
    private zzcq zzj;
    private zzaao zzk;
    private List zzl;
    private Pair zzm;
    private int zzn = 0;

    /* synthetic */ zzaaq(zzaaj zzaaj, zzaap zzaap) {
        this.zzb = zzaaj.zza;
        zzcp zzb2 = zzaaj.zzc;
        zzek.zzb(zzb2);
        this.zzc = zzb2;
    }

    public final zzabd zza() {
        return this.zzf;
    }

    public final zzabx zzb() {
        zzaao zzaao = this.zzk;
        zzek.zzb(zzaao);
        return zzaao;
    }

    public final void zzc() {
        zzfp.zza.zzb();
        zzfp.zza.zza();
        this.zzm = null;
    }

    public final void zzd(zzam zzam) throws zzabw {
        int i;
        boolean z = true;
        zzek.zzf(this.zzn == 0);
        zzek.zzb(this.zzl);
        if (this.zzg == null || this.zzf == null) {
            z = false;
        }
        zzek.zzf(z);
        zzel zzel = this.zze;
        Looper myLooper = Looper.myLooper();
        zzek.zzb(myLooper);
        this.zzi = zzel.zzb(myLooper, (Handler.Callback) null);
        zzt zzt = zzam.zzy;
        if (zzt == null || !((i = zzt.zzf) == 7 || i == 6)) {
            zzt = zzt.zza;
        }
        if (zzt.zzf == 7) {
            zzr zzc2 = zzt.zzc();
            zzc2.zzd(6);
            zzt = zzc2.zzg();
        }
        zzt zzt2 = zzt;
        try {
            zzcp zzcp = this.zzc;
            Context context = this.zzb;
            zzw zzw = zzw.zzb;
            zzev zzev = this.zzi;
            Objects.requireNonNull(zzev);
            this.zzj = zzcp.zza(context, zzt2, zzw, this, new zzaah(zzev), zzfzn.zzm(), 0);
            Pair pair = this.zzm;
            if (pair != null) {
                Surface surface = (Surface) pair.first;
                zzfp zzfp = (zzfp) this.zzm.second;
                zzfp.zzb();
                zzfp.zza();
            }
            this.zzk = new zzaao(this.zzb, this, (zzcq) null);
            this.zzl.getClass();
            throw null;
        } catch (zzdl e) {
            throw new zzabw(e, zzam);
        }
    }

    public final void zze() {
        if (this.zzn != 2) {
            zzev zzev = this.zzi;
            if (zzev != null) {
                zzev.zze((Object) null);
            }
            this.zzm = null;
            this.zzn = 2;
        }
    }

    public final void zzf(zzel zzel) {
        zzek.zzf(!zzl());
        this.zze = zzel;
    }

    public final void zzg(Surface surface, zzfp zzfp) {
        Pair pair = this.zzm;
        if (pair == null || !((Surface) pair.first).equals(surface) || !((zzfp) this.zzm.second).equals(zzfp)) {
            this.zzm = Pair.create(surface, zzfp);
            zzfp.zzb();
            zzfp.zza();
        }
    }

    public final void zzh(long j) {
        zzek.zzb(this.zzk);
        throw null;
    }

    public final void zzi(List list) {
        this.zzl = list;
        if (zzl()) {
            zzek.zzb(this.zzk);
            throw null;
        }
    }

    public final void zzj(zzaba zzaba) {
        this.zzh = zzaba;
    }

    public final void zzk(zzabd zzabd) {
        zzek.zzf(!zzl());
        this.zzf = zzabd;
        this.zzg = new zzabj(this, zzabd);
    }

    public final boolean zzl() {
        return this.zzn == 1;
    }
}
