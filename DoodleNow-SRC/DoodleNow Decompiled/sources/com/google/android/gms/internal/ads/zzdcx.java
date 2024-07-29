package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdcx implements AppEventListener, OnAdMetadataChangedListener, zzcyq, zza, zzdbb, zzczk, zzdap, zzp, zzczg, zzdgn {
    private final zzdcv zza = new zzdcv(this, (zzdcu) null);
    /* access modifiers changed from: private */
    @Nullable
    public zzeoa zzb;
    /* access modifiers changed from: private */
    @Nullable
    public zzeoe zzc;
    /* access modifiers changed from: private */
    @Nullable
    public zzfbl zzd;
    /* access modifiers changed from: private */
    @Nullable
    public zzfeq zze;

    private static void zzn(Object obj, zzdcw zzdcw) {
        if (obj != null) {
            zzdcw.zza(obj);
        }
    }

    public final void onAdClicked() {
        zzn(this.zzb, zzdbn.zza);
        zzn(this.zzc, zzdbo.zza);
    }

    public final void onAdMetadataChanged() {
        zzn(this.zze, zzdbt.zza);
    }

    public final void onAppEvent(String str, String str2) {
        zzn(this.zzb, new zzdbz(str, str2));
    }

    public final void zza() {
        zzn(this.zzb, zzdcs.zza);
        zzn(this.zze, zzdct.zza);
    }

    public final void zzb() {
        zzn(this.zzb, zzdcl.zza);
        zzn(this.zze, zzdcm.zza);
    }

    public final void zzc() {
        zzn(this.zzb, zzdbu.zza);
        zzn(this.zze, zzdbv.zza);
    }

    public final void zzdG() {
        zzn(this.zzb, zzdci.zza);
        zzn(this.zzc, zzdcn.zza);
        zzn(this.zze, zzdco.zza);
        zzn(this.zzd, zzdcp.zza);
    }

    public final void zzdH() {
        zzn(this.zzd, zzdcg.zza);
    }

    public final void zzdf() {
        zzn(this.zzb, zzdca.zza);
    }

    public final void zzdk() {
        zzn(this.zzd, zzdbs.zza);
    }

    public final void zzdq() {
        zzn(this.zzd, zzdcf.zza);
    }

    public final void zzdr() {
        zzn(this.zzd, zzdcb.zza);
    }

    public final void zzds(zzbxq zzbxq, String str, String str2) {
        zzn(this.zzb, new zzdbw(zzbxq, str, str2));
        zzn(this.zze, new zzdby(zzbxq, str, str2));
    }

    public final void zzdt() {
        zzn(this.zzd, zzdch.zza);
    }

    public final void zzdu(int i) {
        zzn(this.zzd, new zzdcj(i));
    }

    public final void zze() {
        zzn(this.zzb, zzdbm.zza);
        zzn(this.zze, zzdbx.zza);
    }

    public final void zzf() {
        zzn(this.zzb, zzdbp.zza);
        zzn(this.zze, zzdbq.zza);
    }

    public final void zzg() {
        zzn(this.zzd, zzdck.zza);
    }

    public final void zzh(zzs zzs) {
        zzn(this.zzb, new zzdcc(zzs));
        zzn(this.zze, new zzdcd(zzs));
        zzn(this.zzd, new zzdce(zzs));
    }

    public final zzdcv zzi() {
        return this.zza;
    }

    public final void zzq(zze zze2) {
        zzn(this.zze, new zzdcq(zze2));
        zzn(this.zzb, new zzdcr(zze2));
    }

    public final void zzr() {
        zzn(this.zzb, zzdbr.zza);
    }
}
