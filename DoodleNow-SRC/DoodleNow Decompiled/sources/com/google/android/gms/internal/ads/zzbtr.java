package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbtr extends zzbts implements zzbky {
    DisplayMetrics zza;
    int zzb = -1;
    int zzc = -1;
    int zzd = -1;
    int zze = -1;
    int zzf = -1;
    int zzg = -1;
    private final zzcgm zzh;
    private final Context zzi;
    private final WindowManager zzj;
    private final zzbdi zzk;
    private float zzl;
    private int zzm;

    public zzbtr(zzcgm zzcgm, Context context, zzbdi zzbdi) {
        super(zzcgm, "");
        this.zzh = zzcgm;
        this.zzi = context;
        this.zzk = zzbdi;
        this.zzj = (WindowManager) context.getSystemService("window");
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        JSONObject jSONObject;
        zzcgm zzcgm = (zzcgm) obj;
        this.zza = new DisplayMetrics();
        Display defaultDisplay = this.zzj.getDefaultDisplay();
        defaultDisplay.getMetrics(this.zza);
        this.zzl = this.zza.density;
        this.zzm = defaultDisplay.getRotation();
        zzay.zzb();
        DisplayMetrics displayMetrics = this.zza;
        this.zzb = zzf.zzw(displayMetrics, displayMetrics.widthPixels);
        zzay.zzb();
        DisplayMetrics displayMetrics2 = this.zza;
        this.zzc = zzf.zzw(displayMetrics2, displayMetrics2.heightPixels);
        Activity zzi2 = this.zzh.zzi();
        if (zzi2 == null || zzi2.getWindow() == null) {
            this.zzd = this.zzb;
            this.zze = this.zzc;
        } else {
            zzu.zzp();
            int[] zzQ = zzt.zzQ(zzi2);
            zzay.zzb();
            this.zzd = zzf.zzw(this.zza, zzQ[0]);
            zzay.zzb();
            this.zze = zzf.zzw(this.zza, zzQ[1]);
        }
        if (this.zzh.zzO().zzi()) {
            this.zzf = this.zzb;
            this.zzg = this.zzc;
        } else {
            this.zzh.measure(0, 0);
        }
        zzj(this.zzb, this.zzc, this.zzd, this.zze, this.zzl, this.zzm);
        zzbtq zzbtq = new zzbtq();
        zzbdi zzbdi = this.zzk;
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        zzbtq.zze(zzbdi.zza(intent));
        zzbdi zzbdi2 = this.zzk;
        Intent intent2 = new Intent("android.intent.action.VIEW");
        intent2.setData(Uri.parse("sms:"));
        zzbtq.zzc(zzbdi2.zza(intent2));
        zzbtq.zza(this.zzk.zzb());
        zzbtq.zzd(this.zzk.zzc());
        zzbtq.zzb(true);
        boolean zzh2 = zzbtq.zza;
        boolean zzj2 = zzbtq.zzb;
        boolean zzf2 = zzbtq.zzc;
        boolean zzi3 = zzbtq.zzd;
        boolean zzg2 = zzbtq.zze;
        zzcgm zzcgm2 = this.zzh;
        try {
            jSONObject = new JSONObject().put("sms", zzh2).put("tel", zzj2).put("calendar", zzf2).put("storePicture", zzi3).put("inlineVideo", zzg2);
        } catch (JSONException e) {
            zzm.zzh("Error occurred while obtaining the MRAID capabilities.", e);
            jSONObject = null;
        }
        zzcgm2.zze("onDeviceFeaturesReceived", jSONObject);
        int[] iArr = new int[2];
        this.zzh.getLocationOnScreen(iArr);
        zzb(zzay.zzb().zzb(this.zzi, iArr[0]), zzay.zzb().zzb(this.zzi, iArr[1]));
        if (zze.zzm(2)) {
            zzm.zzi("Dispatching Ready Event.");
        }
        zzi(this.zzh.zzn().afmaVersion);
    }

    public final void zzb(int i, int i2) {
        int i3;
        Context context = this.zzi;
        int i4 = 0;
        if (context instanceof Activity) {
            zzu.zzp();
            i3 = zzt.zzR((Activity) context)[0];
        } else {
            i3 = 0;
        }
        if (this.zzh.zzO() == null || !this.zzh.zzO().zzi()) {
            zzcgm zzcgm = this.zzh;
            int width = zzcgm.getWidth();
            int height = zzcgm.getHeight();
            if (((Boolean) zzba.zzc().zza(zzbdz.zzR)).booleanValue()) {
                if (width == 0) {
                    width = this.zzh.zzO() != null ? this.zzh.zzO().zzb : 0;
                }
                if (height == 0) {
                    if (this.zzh.zzO() != null) {
                        i4 = this.zzh.zzO().zza;
                    }
                    this.zzf = zzay.zzb().zzb(this.zzi, width);
                    this.zzg = zzay.zzb().zzb(this.zzi, i4);
                }
            }
            i4 = height;
            this.zzf = zzay.zzb().zzb(this.zzi, width);
            this.zzg = zzay.zzb().zzb(this.zzi, i4);
        }
        zzg(i, i2 - i3, this.zzf, this.zzg);
        this.zzh.zzN().zzC(i, i2);
    }
}
