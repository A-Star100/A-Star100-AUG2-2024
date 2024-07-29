package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcrg extends zzctv {
    private final zzcgm zzc;
    private final int zzd;
    private final Context zze;
    private final zzcqu zzf;
    private final zzdiu zzg;
    private final zzdfr zzh;
    private final zzczd zzi;
    private final boolean zzj;
    private final zzcbl zzk;
    private boolean zzl = false;

    zzcrg(zzctu zzctu, Context context, zzcgm zzcgm, int i, zzcqu zzcqu, zzdiu zzdiu, zzdfr zzdfr, zzczd zzczd, zzcbl zzcbl) {
        super(zzctu);
        this.zzc = zzcgm;
        this.zze = context;
        this.zzd = i;
        this.zzf = zzcqu;
        this.zzg = zzdiu;
        this.zzh = zzdfr;
        this.zzi = zzczd;
        this.zzj = ((Boolean) zzba.zzc().zza(zzbdz.zzfm)).booleanValue();
        this.zzk = zzcbl;
    }

    public final int zza() {
        return this.zzd;
    }

    public final void zzb() {
        super.zzb();
        zzcgm zzcgm = this.zzc;
        if (zzcgm != null) {
            zzcgm.destroy();
        }
    }

    public final void zzc(zzbbl zzbbl) {
        zzcgm zzcgm = this.zzc;
        if (zzcgm != null) {
            zzcgm.zzai(zzbbl);
        }
    }

    /* JADX WARNING: type inference failed for: r3v13, types: [android.content.Context] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd(android.app.Activity r3, com.google.android.gms.internal.ads.zzbby r4, boolean r5) throws android.os.RemoteException {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x0004
            android.content.Context r3 = r2.zze
        L_0x0004:
            boolean r4 = r2.zzj
            if (r4 == 0) goto L_0x000d
            com.google.android.gms.internal.ads.zzdfr r4 = r2.zzh
            r4.zzb()
        L_0x000d:
            com.google.android.gms.internal.ads.zzbdq r4 = com.google.android.gms.internal.ads.zzbdz.zzaB
            com.google.android.gms.internal.ads.zzbdx r0 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r4 = r0.zza(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x0061
            com.google.android.gms.ads.internal.zzu.zzp()
            boolean r4 = com.google.android.gms.ads.internal.util.zzt.zzG(r3)
            if (r4 == 0) goto L_0x0061
            java.lang.String r4 = "Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit  https://googlemobileadssdk.page.link/admob-interstitial-policies"
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r4)
            com.google.android.gms.internal.ads.zzczd r4 = r2.zzi
            r4.zzb()
            com.google.android.gms.internal.ads.zzbdq r4 = com.google.android.gms.internal.ads.zzbdz.zzaC
            com.google.android.gms.internal.ads.zzbdx r5 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r4 = r5.zza(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x00d2
            com.google.android.gms.internal.ads.zzfqa r4 = new com.google.android.gms.internal.ads.zzfqa
            android.content.Context r3 = r3.getApplicationContext()
            com.google.android.gms.ads.internal.util.zzbx r5 = com.google.android.gms.ads.internal.zzu.zzt()
            android.os.Looper r5 = r5.zzb()
            r4.<init>(r3, r5)
            com.google.android.gms.internal.ads.zzffz r3 = r2.zza
            com.google.android.gms.internal.ads.zzffy r3 = r3.zzb
            com.google.android.gms.internal.ads.zzffq r3 = r3.zzb
            java.lang.String r3 = r3.zzb
            r4.zza(r3)
            return
        L_0x0061:
            com.google.android.gms.internal.ads.zzbdq r4 = com.google.android.gms.internal.ads.zzbdz.zzlz
            com.google.android.gms.internal.ads.zzbdx r0 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r4 = r0.zza(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            r0 = 0
            if (r4 == 0) goto L_0x00a0
            com.google.android.gms.internal.ads.zzcgm r4 = r2.zzc
            if (r4 == 0) goto L_0x00a0
            com.google.android.gms.internal.ads.zzffn r4 = r4.zzD()
            if (r4 == 0) goto L_0x00a0
            boolean r1 = r4.zzar
            if (r1 == 0) goto L_0x00a0
            int r4 = r4.zzas
            com.google.android.gms.internal.ads.zzcbl r1 = r2.zzk
            int r1 = r1.zzb()
            if (r4 != r1) goto L_0x008d
            goto L_0x00a0
        L_0x008d:
            java.lang.String r3 = "The app open consent form has been shown."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r3)
            com.google.android.gms.internal.ads.zzczd r3 = r2.zzi
            r4 = 12
            java.lang.String r5 = "The consent form has already been shown."
            com.google.android.gms.ads.internal.client.zze r4 = com.google.android.gms.internal.ads.zzfhk.zzd(r4, r5, r0)
            r3.zza(r4)
            return
        L_0x00a0:
            boolean r4 = r2.zzl
            if (r4 == 0) goto L_0x00b4
            java.lang.String r4 = "App open interstitial ad is already visible."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r4)
            com.google.android.gms.internal.ads.zzczd r4 = r2.zzi
            r1 = 10
            com.google.android.gms.ads.internal.client.zze r0 = com.google.android.gms.internal.ads.zzfhk.zzd(r1, r0, r0)
            r4.zza(r0)
        L_0x00b4:
            boolean r4 = r2.zzl
            if (r4 != 0) goto L_0x00d2
            com.google.android.gms.internal.ads.zzdiu r4 = r2.zzg     // Catch:{ zzdit -> 0x00cc }
            com.google.android.gms.internal.ads.zzczd r0 = r2.zzi     // Catch:{ zzdit -> 0x00cc }
            r4.zza(r5, r3, r0)     // Catch:{ zzdit -> 0x00cc }
            boolean r3 = r2.zzj     // Catch:{ zzdit -> 0x00cc }
            if (r3 == 0) goto L_0x00c8
            com.google.android.gms.internal.ads.zzdfr r3 = r2.zzh     // Catch:{ zzdit -> 0x00cc }
            r3.zza()     // Catch:{ zzdit -> 0x00cc }
        L_0x00c8:
            r3 = 1
            r2.zzl = r3
            return
        L_0x00cc:
            r3 = move-exception
            com.google.android.gms.internal.ads.zzczd r4 = r2.zzi
            r4.zzc(r3)
        L_0x00d2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcrg.zzd(android.app.Activity, com.google.android.gms.internal.ads.zzbby, boolean):void");
    }

    public final void zze(long j, int i) {
        this.zzf.zza(j, i);
    }
}
