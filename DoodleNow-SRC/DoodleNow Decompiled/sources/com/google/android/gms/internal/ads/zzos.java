package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import java.io.IOException;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzos implements zzmp {
    private final zzel zza;
    private final zzcu zzb;
    private final zzcw zzc = new zzcw();
    private final zzor zzd;
    private final SparseArray zze;
    private zzfb zzf;
    private zzco zzg;
    private zzev zzh;
    private boolean zzi;

    public static /* synthetic */ void zzV(zzos zzos) {
        zzmq zzT = zzos.zzT();
        zzos.zzY(zzT, AnalyticsListener.EVENT_PLAYER_RELEASED, new zzmu(zzT));
        zzos.zzf.zze();
    }

    private final zzmq zzab() {
        return zzZ(this.zzd.zzd());
    }

    private final zzmq zzac() {
        return zzZ(this.zzd.zze());
    }

    private final zzmq zzad(zzce zzce) {
        zzvh zzvh;
        if (!(zzce instanceof zziz) || (zzvh = ((zziz) zzce).zzj) == null) {
            return zzT();
        }
        return zzZ(zzvh);
    }

    public final void zzA(zzam zzam, zzis zzis) {
        zzmq zzac = zzac();
        zzY(zzac, 1009, new zzog(zzac, zzam, zzis));
    }

    public final void zzB(long j) {
        zzmq zzac = zzac();
        zzY(zzac, 1010, new zznk(zzac, j));
    }

    public final void zzC(Exception exc) {
        zzmq zzac = zzac();
        zzY(zzac, 1014, new zzoo(zzac, exc));
    }

    public final void zzD(zzqh zzqh) {
        zzmq zzac = zzac();
        zzY(zzac, 1031, new zzod(zzac, zzqh));
    }

    public final void zzE(zzqh zzqh) {
        zzmq zzac = zzac();
        zzY(zzac, 1032, new zzon(zzac, zzqh));
    }

    public final void zzF(int i, long j, long j2) {
        zzmq zzac = zzac();
        zzY(zzac, 1011, new zzng(zzac, i, j, j2));
    }

    public final void zzG(int i, long j) {
        zzmq zzab = zzab();
        zzY(zzab, 1018, new zznq(zzab, i, j));
    }

    public final void zzH(Object obj, long j) {
        zzmq zzac = zzac();
        zzY(zzac, 26, new zzok(zzac, obj, j));
    }

    public final void zzI(Exception exc) {
        zzmq zzac = zzac();
        zzY(zzac, AnalyticsListener.EVENT_VIDEO_CODEC_ERROR, new zznf(zzac, exc));
    }

    public final void zzJ(String str, long j, long j2) {
        zzmq zzac = zzac();
        zzY(zzac, 1016, new zzom(zzac, str, j2, j));
    }

    public final void zzK(String str) {
        zzmq zzac = zzac();
        zzY(zzac, 1019, new zznp(zzac, str));
    }

    public final void zzL(zzir zzir) {
        zzmq zzab = zzab();
        zzY(zzab, 1020, new zzoc(zzab, zzir));
    }

    public final void zzM(zzir zzir) {
        zzmq zzac = zzac();
        zzY(zzac, 1015, new zzoi(zzac, zzir));
    }

    public final void zzN(long j, int i) {
        zzmq zzab = zzab();
        zzY(zzab, 1021, new zznu(zzab, j, i));
    }

    public final void zzO(zzam zzam, zzis zzis) {
        zzmq zzac = zzac();
        zzY(zzac, 1017, new zzob(zzac, zzam, zzis));
    }

    public final void zzP() {
        zzev zzev = this.zzh;
        zzek.zzb(zzev);
        zzev.zzh(new zzoj(this));
    }

    public final void zzQ(zzms zzms) {
        this.zzf.zzf(zzms);
    }

    public final void zzR(zzco zzco, Looper looper) {
        boolean z = true;
        if (this.zzg != null && !this.zzd.zzb.isEmpty()) {
            z = false;
        }
        zzek.zzf(z);
        zzco.getClass();
        this.zzg = zzco;
        this.zzh = this.zza.zzb(looper, (Handler.Callback) null);
        this.zzf = this.zzf.zza(looper, new zzni(this, zzco));
    }

    /* access modifiers changed from: protected */
    public final zzmq zzT() {
        return zzZ(this.zzd.zzb());
    }

    /* access modifiers changed from: protected */
    @RequiresNonNull({"player"})
    public final zzmq zzU(zzcx zzcx, int i, zzvh zzvh) {
        zzcx zzcx2 = zzcx;
        int i2 = i;
        boolean z = true;
        zzvh zzvh2 = true == zzcx.zzo() ? null : zzvh;
        long zza2 = this.zza.zza();
        if (!zzcx2.equals(this.zzg.zzn()) || i2 != this.zzg.zzd()) {
            z = false;
        }
        long j = 0;
        if (zzvh2 == null || !zzvh2.zzb()) {
            if (z) {
                j = this.zzg.zzj();
            } else if (!zzcx.zzo()) {
                long j2 = zzcx2.zze(i2, this.zzc, 0).zzn;
                j = zzfx.zzu(0);
            }
        } else if (z && this.zzg.zzb() == zzvh2.zzb && this.zzg.zzc() == zzvh2.zzc) {
            j = this.zzg.zzk();
        }
        return new zzmq(zza2, zzcx, i, zzvh2, j, this.zzg.zzn(), this.zzg.zzd(), this.zzd.zzb(), this.zzg.zzk(), this.zzg.zzm());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzW(zzco zzco, zzms zzms, zzah zzah) {
        zzms.zzi(zzco, new zzmr(zzah, this.zze));
    }

    public final void zzX(int i, long j, long j2) {
        zzmq zzZ = zzZ(this.zzd.zzc());
        zzY(zzZ, 1006, new zznd(zzZ, i, j, j2));
    }

    /* access modifiers changed from: protected */
    public final void zzY(zzmq zzmq, int i, zzey zzey) {
        this.zze.put(i, zzmq);
        zzfb zzfb = this.zzf;
        zzfb.zzd(i, zzey);
        zzfb.zzc();
    }

    public final void zza(zzck zzck) {
        zzmq zzT = zzT();
        zzY(zzT, 13, new zzmz(zzT, zzck));
    }

    public final void zzae(int i, zzvh zzvh, zzvd zzvd) {
        zzmq zzaa = zzaa(i, zzvh);
        zzY(zzaa, 1004, new zznv(zzaa, zzvd));
    }

    public final void zzaf(int i, zzvh zzvh, zzuy zzuy, zzvd zzvd) {
        zzmq zzaa = zzaa(i, zzvh);
        zzY(zzaa, 1002, new zznw(zzaa, zzuy, zzvd));
    }

    public final void zzag(int i, zzvh zzvh, zzuy zzuy, zzvd zzvd) {
        zzmq zzaa = zzaa(i, zzvh);
        zzY(zzaa, 1001, new zzoa(zzaa, zzuy, zzvd));
    }

    public final void zzah(int i, zzvh zzvh, zzuy zzuy, zzvd zzvd, IOException iOException, boolean z) {
        zzmq zzaa = zzaa(i, zzvh);
        zzY(zzaa, 1003, new zznh(zzaa, zzuy, zzvd, iOException, z));
    }

    public final void zzai(int i, zzvh zzvh, zzuy zzuy, zzvd zzvd) {
        zzmq zzaa = zzaa(i, zzvh);
        zzY(zzaa, 1000, new zzmy(zzaa, zzuy, zzvd));
    }

    public final void zzb(boolean z) {
        zzmq zzT = zzT();
        zzY(zzT, 3, new zzmw(zzT, z));
    }

    public final void zzc(boolean z) {
        zzmq zzT = zzT();
        zzY(zzT, 7, new zznl(zzT, z));
    }

    public final void zzd(zzbp zzbp, int i) {
        zzmq zzT = zzT();
        zzY(zzT, 1, new zznb(zzT, zzbp, i));
    }

    public final void zze(zzbv zzbv) {
        zzmq zzT = zzT();
        zzY(zzT, 14, new zzop(zzT, zzbv));
    }

    public final void zzf(boolean z, int i) {
        zzmq zzT = zzT();
        zzY(zzT, 5, new zzns(zzT, z, i));
    }

    public final void zzg(zzcg zzcg) {
        zzmq zzT = zzT();
        zzY(zzT, 12, new zzmt(zzT, zzcg));
    }

    public final void zzh(int i) {
        zzmq zzT = zzT();
        zzY(zzT, 4, new zznz(zzT, i));
    }

    public final void zzi(int i) {
        zzmq zzT = zzT();
        zzY(zzT, 6, new zzno(zzT, i));
    }

    public final void zzj(zzce zzce) {
        zzmq zzad = zzad(zzce);
        zzY(zzad, 10, new zznx(zzad, zzce));
    }

    public final void zzk(zzce zzce) {
        zzmq zzad = zzad(zzce);
        zzY(zzad, 10, new zznr(zzad, zzce));
    }

    public final void zzl(boolean z, int i) {
        zzmq zzT = zzT();
        zzY(zzT, -1, new zznj(zzT, z, i));
    }

    public final void zzn(boolean z) {
        zzmq zzac = zzac();
        zzY(zzac, 23, new zznc(zzac, z));
    }

    public final void zzo(int i, int i2) {
        zzmq zzac = zzac();
        zzY(zzac, 24, new zzoq(zzac, i, i2));
    }

    public final void zzq(zzdk zzdk) {
        zzmq zzT = zzT();
        zzY(zzT, 2, new zznm(zzT, zzdk));
    }

    public final void zzr(zzdp zzdp) {
        zzmq zzac = zzac();
        zzY(zzac, 25, new zzoe(zzac, zzdp));
    }

    public final void zzs(float f) {
        zzmq zzac = zzac();
        zzY(zzac, 22, new zzne(zzac, f));
    }

    public final void zzt(zzms zzms) {
        this.zzf.zzb(zzms);
    }

    public final void zzu() {
        if (!this.zzi) {
            zzmq zzT = zzT();
            this.zzi = true;
            zzY(zzT, -1, new zzof(zzT));
        }
    }

    public final void zzv(Exception exc) {
        zzmq zzac = zzac();
        zzY(zzac, AnalyticsListener.EVENT_AUDIO_CODEC_ERROR, new zzol(zzac, exc));
    }

    public final void zzw(String str, long j, long j2) {
        zzmq zzac = zzac();
        zzY(zzac, 1008, new zznn(zzac, str, j2, j));
    }

    public final void zzx(String str) {
        zzmq zzac = zzac();
        zzY(zzac, 1012, new zzmx(zzac, str));
    }

    public final void zzy(zzir zzir) {
        zzmq zzab = zzab();
        zzY(zzab, 1013, new zzny(zzab, zzir));
    }

    public final void zzz(zzir zzir) {
        zzmq zzac = zzac();
        zzY(zzac, 1007, new zzmv(zzac, zzir));
    }

    public final void zzS(List list, zzvh zzvh) {
        zzco zzco = this.zzg;
        zzco.getClass();
        this.zzd.zzh(list, zzvh, zzco);
    }

    public final void zzm(zzcn zzcn, zzcn zzcn2, int i) {
        if (i == 1) {
            this.zzi = false;
            i = 1;
        }
        zzor zzor = this.zzd;
        zzco zzco = this.zzg;
        zzco.getClass();
        zzor.zzg(zzco);
        zzmq zzT = zzT();
        zzY(zzT, 11, new zzoh(zzT, i, zzcn, zzcn2));
    }

    public final void zzp(zzcx zzcx, int i) {
        zzco zzco = this.zzg;
        zzco.getClass();
        this.zzd.zzi(zzco);
        zzmq zzT = zzT();
        zzY(zzT, 0, new zzna(zzT, i));
    }

    public zzos(zzel zzel) {
        zzel.getClass();
        this.zza = zzel;
        this.zzf = new zzfb(zzfx.zzy(), zzel, zznt.zza);
        zzcu zzcu = new zzcu();
        this.zzb = zzcu;
        this.zzd = new zzor(zzcu);
        this.zze = new SparseArray();
    }

    private final zzmq zzaa(int i, zzvh zzvh) {
        zzco zzco = this.zzg;
        zzco.getClass();
        if (zzvh == null) {
            zzcx zzn = zzco.zzn();
            if (i >= zzn.zzc()) {
                zzn = zzcx.zza;
            }
            return zzU(zzn, i, (zzvh) null);
        } else if (this.zzd.zza(zzvh) != null) {
            return zzZ(zzvh);
        } else {
            return zzU(zzcx.zza, i, zzvh);
        }
    }

    private final zzmq zzZ(zzvh zzvh) {
        this.zzg.getClass();
        zzcx zza2 = zzvh == null ? null : this.zzd.zza(zzvh);
        if (zzvh == null || zza2 == null) {
            int zzd2 = this.zzg.zzd();
            zzcx zzn = this.zzg.zzn();
            if (zzd2 >= zzn.zzc()) {
                zzn = zzcx.zza;
            }
            return zzU(zzn, zzd2, (zzvh) null);
        }
        return zzU(zza2, zza2.zzn(zzvh.zza, this.zzb).zzd, zzvh);
    }
}
