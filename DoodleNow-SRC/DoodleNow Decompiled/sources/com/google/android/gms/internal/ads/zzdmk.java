package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdmk {
    private final zzdri zza;
    private final zzdpx zzb;
    private final zzcqr zzc;
    private final zzdlg zzd;

    public zzdmk(zzdri zzdri, zzdpx zzdpx, zzcqr zzcqr, zzdlg zzdlg) {
        this.zza = zzdri;
        this.zzb = zzdpx;
        this.zzc = zzcqr;
        this.zzd = zzdlg;
    }

    public final View zza() throws zzcgy {
        zzcgm zza2 = this.zza.zza(zzq.zzc(), (zzffn) null, (zzffq) null);
        View view = (View) zza2;
        view.setVisibility(8);
        zza2.zzae("/sendMessageToSdk", new zzdmf(this));
        zza2.zzae("/adMuted", new zzdmg(this));
        this.zzb.zzm(new WeakReference(zza2), "/loadHtml", new zzdmh(this));
        this.zzb.zzm(new WeakReference(zza2), "/showOverlay", new zzdmi(this));
        this.zzb.zzm(new WeakReference(zza2), "/hideOverlay", new zzdmj(this));
        return view;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzcgm zzcgm, Map map) {
        this.zzb.zzj("sendMessageToNativeJs", map);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzcgm zzcgm, Map map) {
        this.zzd.zzg();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(Map map, boolean z, int i, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("messageType", "htmlLoaded");
        hashMap.put("id", (String) map.get("id"));
        this.zzb.zzj("sendMessageToNativeJs", hashMap);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(zzcgm zzcgm, Map map) {
        zzm.zzi("Showing native ads overlay.");
        zzcgm.zzF().setVisibility(0);
        this.zzc.zze(true);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(zzcgm zzcgm, Map map) {
        zzm.zzi("Hiding native ads overlay.");
        zzcgm.zzF().setVisibility(8);
        this.zzc.zze(false);
    }
}
