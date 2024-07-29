package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzb;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdrh {
    private final zzcyo zza;
    private final zzdgl zzb;
    /* access modifiers changed from: private */
    public final zzczx zzc;
    private final zzdak zzd;
    private final zzdaw zze;
    private final zzddk zzf;
    private final Executor zzg;
    private final zzdgh zzh;
    private final zzcqh zzi;
    private final zzb zzj;
    private final zzbzo zzk;
    private final zzawo zzl;
    /* access modifiers changed from: private */
    public final zzddb zzm;
    private final zzefd zzn;
    private final zzfmt zzo;
    private final zzduh zzp;
    private final zzcpk zzq;
    private final zzdrn zzr;

    public zzdrh(zzcyo zzcyo, zzczx zzczx, zzdak zzdak, zzdaw zzdaw, zzddk zzddk, Executor executor, zzdgh zzdgh, zzcqh zzcqh, zzb zzb2, zzbzo zzbzo, zzawo zzawo, zzddb zzddb, zzefd zzefd, zzfmt zzfmt, zzduh zzduh, zzdgl zzdgl, zzcpk zzcpk, zzdrn zzdrn) {
        this.zza = zzcyo;
        this.zzc = zzczx;
        this.zzd = zzdak;
        this.zze = zzdaw;
        this.zzf = zzddk;
        this.zzg = executor;
        this.zzh = zzdgh;
        this.zzi = zzcqh;
        this.zzj = zzb2;
        this.zzk = zzbzo;
        this.zzl = zzawo;
        this.zzm = zzddb;
        this.zzn = zzefd;
        this.zzo = zzfmt;
        this.zzp = zzduh;
        this.zzb = zzdgl;
        this.zzq = zzcpk;
        this.zzr = zzdrn;
    }

    public static final ListenableFuture zzj(zzcgm zzcgm, String str, String str2) {
        zzcbw zzcbw = new zzcbw();
        zzcgm.zzN().zzB(new zzdqy(zzcbw));
        zzcgm.zzac(str, str2, (String) null);
        return zzcbw;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc() {
        this.zza.onAdClicked();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(String str, String str2) {
        this.zzf.zzb(str, str2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze() {
        this.zzc.zzb();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(View view) {
        this.zzj.zza();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzg(zzcgm zzcgm, zzcgm zzcgm2, Map map) {
        this.zzi.zzh(zzcgm);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ boolean zzh(View view, MotionEvent motionEvent) {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzjR)).booleanValue() && motionEvent != null && motionEvent.getAction() == 0) {
            this.zzr.zzb(motionEvent);
        }
        this.zzj.zza();
        if (view == null) {
            return false;
        }
        view.performClick();
        return false;
    }

    public final void zzi(zzcgm zzcgm, boolean z, zzblb zzblb) {
        zzawk zzc2;
        zzcgm zzcgm2 = zzcgm;
        zzcic zzN = zzcgm.zzN();
        zzdqz zzdqz = r4;
        zzdqz zzdqz2 = new zzdqz(this);
        zzdra zzdra = r4;
        zzdra zzdra2 = new zzdra(this);
        zzdrb zzdrb = r4;
        zzdrb zzdrb2 = new zzdrb(this);
        zzdrg zzdrg = r4;
        zzdrg zzdrg2 = new zzdrg(this);
        zzbzo zzbzo = this.zzk;
        zzefd zzefd = this.zzn;
        zzfmt zzfmt = this.zzo;
        zzdak zzdak = this.zzd;
        zzduh zzduh = this.zzp;
        zzN.zzR(zzdqz, zzdak, this.zze, zzdra, zzdrb, z, zzblb, this.zzj, zzdrg, zzbzo, zzefd, zzfmt, zzduh, (zzbls) null, this.zzb, (zzblr) null, (zzbll) null, (zzbkz) null, this.zzq);
        zzcgm zzcgm3 = zzcgm;
        zzcgm3.setOnTouchListener(new zzdrc(this));
        zzcgm3.setOnClickListener(new zzdrd(this));
        if (((Boolean) zzba.zzc().zza(zzbdz.zzcy)).booleanValue() && (zzc2 = this.zzl.zzc()) != null) {
            zzc2.zzo((View) zzcgm3);
        }
        this.zzh.zzo(zzcgm3, this.zzg);
        this.zzh.zzo(new zzdre(zzcgm3), this.zzg);
        this.zzh.zza((View) zzcgm3);
        zzcgm3.zzae("/trackActiveViewUnit", new zzdrf(this, zzcgm3));
        this.zzi.zzi(zzcgm3);
    }
}
