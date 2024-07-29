package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfeq implements OnAdMetadataChangedListener, zzdae, zzcyt, zzcyq, zzczg, zzdbb, zzfdb, zzdgn {
    private final zzfhs zza;
    private final AtomicReference zzb = new AtomicReference();
    private final AtomicReference zzc = new AtomicReference();
    private final AtomicReference zzd = new AtomicReference();
    private final AtomicReference zze = new AtomicReference();
    private final AtomicReference zzf = new AtomicReference();
    private final AtomicReference zzg = new AtomicReference();
    private final AtomicReference zzh = new AtomicReference();

    public zzfeq(zzfhs zzfhs) {
        this.zza = zzfhs;
    }

    public final void onAdMetadataChanged() {
        zzfcs.zza(this.zzb, zzfee.zza);
    }

    public final void zza() {
        this.zza.zza();
        zzfcs.zza(this.zzd, zzfem.zza);
        zzfcs.zza(this.zze, zzfen.zza);
    }

    public final void zzb() {
        zzfcs.zza(this.zze, zzfeo.zza);
    }

    public final void zzc() {
        zzfcs.zza(this.zzd, zzfdy.zza);
        zzfcs.zza(this.zze, zzfdz.zza);
        zzfcs.zza(this.zzd, zzfea.zza);
    }

    public final void zzdB(zze zze2) {
        int i = zze2.zza;
        zzfcs.zza(this.zzc, new zzfej(zze2));
        zzfcs.zza(this.zzc, new zzfek(i));
        zzfcs.zza(this.zze, new zzfel(i));
    }

    public final void zzdG() {
        zzfcs.zza(this.zzd, zzfef.zza);
    }

    public final void zzdf() {
    }

    public final void zzds(zzbxq zzbxq, String str, String str2) {
        zzfcs.zza(this.zzd, new zzfep(zzbxq));
        zzfcs.zza(this.zzf, new zzfdv(zzbxq, str, str2));
        zzfcs.zza(this.zze, new zzfdw(zzbxq));
        zzfcs.zza(this.zzg, new zzfdx(zzbxq, str, str2));
    }

    public final void zze() {
        zzfcs.zza(this.zze, zzfei.zza);
    }

    public final void zzf() {
        zzfcs.zza(this.zze, zzfdu.zza);
    }

    public final void zzg(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        this.zzb.set(onAdMetadataChangedListener);
    }

    public final void zzh(zzs zzs) {
        zzfcs.zza(this.zzh, new zzfeb(zzs));
    }

    public final void zzi(zzdg zzdg) {
        this.zzh.set(zzdg);
    }

    public final void zzj(zzbym zzbym) {
        this.zzd.set(zzbym);
    }

    public final void zzk(zzbyq zzbyq) {
        this.zzc.set(zzbyq);
    }

    public final void zzl(zzfdb zzfdb) {
        throw null;
    }

    @Deprecated
    public final void zzm(zzbxw zzbxw) {
        this.zze.set(zzbxw);
    }

    @Deprecated
    public final void zzn(zzbxr zzbxr) {
        this.zzg.set(zzbxr);
    }

    public final void zzo(zzbyr zzbyr) {
        this.zzf.set(zzbyr);
    }

    public final void zzq(zze zze2) {
        zzfcs.zza(this.zzd, new zzfeg(zze2));
        zzfcs.zza(this.zzd, new zzfeh(zze2));
    }

    public final void zzs() {
        zzfcs.zza(this.zzc, zzfec.zza);
        zzfcs.zza(this.zze, zzfed.zza);
    }
}
