package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzb;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdpx {
    /* access modifiers changed from: private */
    public final zzdpk zza = new zzdpk();
    private final zza zzb;
    private final zzcgz zzc;
    private final Context zzd;
    /* access modifiers changed from: private */
    public final zzduh zze;
    private final Executor zzf;
    private final zzawo zzg;
    private final VersionInfoParcel zzh;
    private final zzblo zzi;
    /* access modifiers changed from: private */
    public final zzefd zzj;
    /* access modifiers changed from: private */
    public final zzfmt zzk;
    private final zzefo zzl;
    private final zzfgm zzm;
    private ListenableFuture zzn;

    zzdpx(zzdpu zzdpu) {
        this.zzd = zzdpu.zzc;
        this.zzf = zzdpu.zzf;
        this.zzg = zzdpu.zzg;
        this.zzh = zzdpu.zzh;
        this.zzb = zzdpu.zza;
        this.zzc = zzdpu.zzb;
        this.zzi = new zzblo();
        this.zzj = zzdpu.zze;
        this.zzk = zzdpu.zzi;
        this.zze = zzdpu.zzd;
        this.zzl = zzdpu.zzj;
        this.zzm = zzdpu.zzk;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzcgm zza(zzcgm zzcgm) {
        zzcgm zzcgm2 = zzcgm;
        zzcgm2.zzae("/result", this.zzi);
        zzcic zzN = zzcgm.zzN();
        zzb zzb2 = r2;
        zzb zzb3 = new zzb(this.zzd, (zzbzo) null, (zzbwg) null);
        zzdpk zzdpk = this.zza;
        zzN.zzR((com.google.android.gms.ads.internal.client.zza) null, zzdpk, zzdpk, zzdpk, zzdpk, false, (zzblb) null, zzb2, (zzbtt) null, (zzbzo) null, this.zzj, this.zzk, this.zze, (zzbls) null, (zzdgn) null, (zzblr) null, (zzbll) null, (zzbkz) null, (zzcpk) null);
        return zzcgm2;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzf(String str, JSONObject jSONObject, zzcgm zzcgm) throws Exception {
        return this.zzi.zzb(zzcgm, str, jSONObject);
    }

    public final synchronized ListenableFuture zzg(String str, JSONObject jSONObject) {
        ListenableFuture listenableFuture = this.zzn;
        if (listenableFuture == null) {
            return zzgee.zzh((Object) null);
        }
        return zzgee.zzn(listenableFuture, new zzdpl(this, str, jSONObject), this.zzf);
    }

    public final synchronized void zzh(zzffn zzffn, zzffq zzffq, zzcpk zzcpk) {
        ListenableFuture listenableFuture = this.zzn;
        if (listenableFuture != null) {
            zzgee.zzr(listenableFuture, new zzdpr(this, zzffn, zzffq, zzcpk), this.zzf);
        }
    }

    public final synchronized void zzi() {
        ListenableFuture listenableFuture = this.zzn;
        if (listenableFuture != null) {
            zzgee.zzr(listenableFuture, new zzdpn(this), this.zzf);
            this.zzn = null;
        }
    }

    public final synchronized void zzj(String str, Map map) {
        ListenableFuture listenableFuture = this.zzn;
        if (listenableFuture != null) {
            zzgee.zzr(listenableFuture, new zzdpq(this, "sendMessageToNativeJs", map), this.zzf);
        }
    }

    public final synchronized void zzk() {
        zzbdq zzbdq = zzbdz.zzdG;
        ListenableFuture zzm2 = zzgee.zzm(zzgee.zzk(new zzcgx(this.zzd, this.zzg, this.zzh, this.zzb, this.zzl, this.zzm, (String) zzba.zzc().zza(zzbdq)), zzcbr.zze), new zzdpm(this), this.zzf);
        this.zzn = zzm2;
        zzcbu.zza(zzm2, "NativeJavascriptExecutor.initializeEngine");
    }

    public final synchronized void zzl(String str, zzbky zzbky) {
        ListenableFuture listenableFuture = this.zzn;
        if (listenableFuture != null) {
            zzgee.zzr(listenableFuture, new zzdpo(this, str, zzbky), this.zzf);
        }
    }

    public final void zzm(WeakReference weakReference, String str, zzbky zzbky) {
        zzl(str, new zzdpw(this, weakReference, str, zzbky, (zzdpv) null));
    }

    public final synchronized void zzn(String str, zzbky zzbky) {
        ListenableFuture listenableFuture = this.zzn;
        if (listenableFuture != null) {
            zzgee.zzr(listenableFuture, new zzdpp(this, str, zzbky), this.zzf);
        }
    }
}
