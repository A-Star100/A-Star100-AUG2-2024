package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public class zzelx extends zzbqt {
    private final zzcyo zza;
    private final zzdgl zzb;
    private final zzczi zzc;
    private final zzczx zzd;
    private final zzdac zze;
    private final zzddk zzf;
    private final zzdaw zzg;
    private final zzdhi zzh;
    private final zzddg zzi;
    private final zzczd zzj;

    public zzelx(zzcyo zzcyo, zzdgl zzdgl, zzczi zzczi, zzczx zzczx, zzdac zzdac, zzddk zzddk, zzdaw zzdaw, zzdhi zzdhi, zzddg zzddg, zzczd zzczd) {
        this.zza = zzcyo;
        this.zzb = zzdgl;
        this.zzc = zzczi;
        this.zzd = zzczx;
        this.zze = zzdac;
        this.zzf = zzddk;
        this.zzg = zzdaw;
        this.zzh = zzdhi;
        this.zzi = zzddg;
        this.zzj = zzczd;
    }

    public final void zze() {
        this.zza.onAdClicked();
        this.zzb.zzdG();
    }

    public final void zzf() {
        this.zzg.zzdu(4);
    }

    public final void zzg(int i) {
    }

    public final void zzh(zze zze2) {
    }

    public final void zzi(int i, String str) {
    }

    @Deprecated
    public final void zzj(int i) throws RemoteException {
        zzk(new zze(i, "", AdError.UNDEFINED_DOMAIN, (zze) null, (IBinder) null));
    }

    public final void zzk(zze zze2) {
        this.zzj.zza(zzfhk.zzc(8, zze2));
    }

    public final void zzl(String str) {
        zzk(new zze(0, str, AdError.UNDEFINED_DOMAIN, (zze) null, (IBinder) null));
    }

    public void zzm() {
        this.zzc.zza();
        this.zzi.zzb();
    }

    public final void zzn() {
        this.zzd.zzb();
    }

    public final void zzo() {
        this.zze.zzs();
    }

    public final void zzp() {
        this.zzg.zzdr();
        this.zzi.zza();
    }

    public final void zzq(String str, String str2) {
        this.zzf.zzb(str, str2);
    }

    public final void zzr(zzbhy zzbhy, String str) {
    }

    public void zzs(zzbyc zzbyc) {
    }

    public void zzt(zzbyg zzbyg) throws RemoteException {
    }

    public void zzu() throws RemoteException {
    }

    public void zzv() {
        this.zzh.zza();
    }

    public final void zzw() {
        this.zzh.zzb();
    }

    public final void zzx() throws RemoteException {
        this.zzh.zzc();
    }

    public void zzy() {
        this.zzh.zzd();
    }
}
