package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import com.amazon.a.a.o.b.f;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzbe;
import com.google.android.gms.ads.internal.util.zzbf;
import com.google.android.gms.ads.internal.util.zzbh;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzu;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcdo {
    private final Context zza;
    private final String zzb;
    private final VersionInfoParcel zzc;
    private final zzbel zzd;
    private final zzbeo zze;
    private final zzbh zzf;
    private final long[] zzg;
    private final String[] zzh;
    private boolean zzi = false;
    private boolean zzj = false;
    private boolean zzk = false;
    private boolean zzl = false;
    private boolean zzm;
    private zzcct zzn;
    private boolean zzo;
    private boolean zzp;
    private long zzq = -1;

    public zzcdo(Context context, VersionInfoParcel versionInfoParcel, String str, zzbeo zzbeo, zzbel zzbel) {
        zzbf zzbf = new zzbf();
        zzbf zzbf2 = zzbf;
        zzbf2.zza("min_1", Double.MIN_VALUE, 1.0d);
        zzbf2.zza("1_5", 1.0d, 5.0d);
        zzbf2.zza("5_10", 5.0d, 10.0d);
        zzbf2.zza("10_20", 10.0d, 20.0d);
        zzbf2.zza("20_30", 20.0d, 30.0d);
        zzbf2.zza("30_max", 30.0d, Double.MAX_VALUE);
        this.zzf = zzbf.zzb();
        this.zza = context;
        this.zzc = versionInfoParcel;
        this.zzb = str;
        this.zze = zzbeo;
        this.zzd = zzbel;
        String str2 = (String) zzba.zzc().zza(zzbdz.zzA);
        if (str2 == null) {
            this.zzh = new String[0];
            this.zzg = new long[0];
            return;
        }
        String[] split = TextUtils.split(str2, f.a);
        int length = split.length;
        this.zzh = new String[length];
        this.zzg = new long[length];
        for (int i = 0; i < split.length; i++) {
            try {
                this.zzg[i] = Long.parseLong(split[i]);
            } catch (NumberFormatException e) {
                zzm.zzk("Unable to parse frame hash target time number.", e);
                this.zzg[i] = -1;
            }
        }
    }

    public final void zza(zzcct zzcct) {
        zzbeg.zza(this.zze, this.zzd, "vpc2");
        this.zzi = true;
        this.zze.zzd("vpn", zzcct.zzj());
        this.zzn = zzcct;
    }

    public final void zzb() {
        if (this.zzi && !this.zzj) {
            zzbeg.zza(this.zze, this.zzd, "vfr2");
            this.zzj = true;
        }
    }

    public final void zzc() {
        this.zzm = true;
        if (this.zzj && !this.zzk) {
            zzbeg.zza(this.zze, this.zzd, "vfp2");
            this.zzk = true;
        }
    }

    public final void zzd() {
        if (((Boolean) zzbgh.zza.zze()).booleanValue() && !this.zzo) {
            Bundle bundle = new Bundle();
            bundle.putString("type", "native-player-metrics");
            bundle.putString("request", this.zzb);
            bundle.putString("player", this.zzn.zzj());
            for (zzbe zzbe : this.zzf.zza()) {
                String valueOf = String.valueOf(zzbe.zza);
                bundle.putString("fps_c_".concat(valueOf), Integer.toString(zzbe.zze));
                String valueOf2 = String.valueOf(zzbe.zza);
                bundle.putString("fps_p_".concat(valueOf2), Double.toString(zzbe.zzd));
            }
            int i = 0;
            while (true) {
                long[] jArr = this.zzg;
                if (i < jArr.length) {
                    String str = this.zzh[i];
                    if (str != null) {
                        Long valueOf3 = Long.valueOf(jArr[i]);
                        Objects.toString(valueOf3);
                        bundle.putString("fh_".concat(valueOf3.toString()), str);
                    }
                    i++;
                } else {
                    zzu.zzp().zzh(this.zza, this.zzc.afmaVersion, "gmob-apps", bundle, true);
                    this.zzo = true;
                    return;
                }
            }
        }
    }

    public final void zze() {
        this.zzm = false;
    }

    public final void zzf(zzcct zzcct) {
        if (this.zzk && !this.zzl) {
            if (zze.zzc() && !this.zzl) {
                zze.zza("VideoMetricsMixin first frame");
            }
            zzbeg.zza(this.zze, this.zzd, "vff2");
            this.zzl = true;
        }
        long nanoTime = zzu.zzB().nanoTime();
        if (this.zzm && this.zzp && this.zzq != -1) {
            this.zzf.zzb(((double) TimeUnit.SECONDS.toNanos(1)) / ((double) (nanoTime - this.zzq)));
        }
        this.zzp = this.zzm;
        this.zzq = nanoTime;
        long longValue = ((Long) zzba.zzc().zza(zzbdz.zzB)).longValue();
        long zza2 = (long) zzcct.zza();
        int i = 0;
        while (true) {
            String[] strArr = this.zzh;
            if (i >= strArr.length) {
                return;
            }
            if (strArr[i] == null && longValue > Math.abs(zza2 - this.zzg[i])) {
                String[] strArr2 = this.zzh;
                int i2 = 8;
                Bitmap bitmap = zzcct.getBitmap(8, 8);
                long j = 63;
                int i3 = 0;
                long j2 = 0;
                while (i3 < i2) {
                    int i4 = 0;
                    while (i4 < i2) {
                        int pixel = bitmap.getPixel(i4, i3);
                        j2 |= ((Color.blue(pixel) + Color.red(pixel)) + Color.green(pixel) > 128 ? 1 : 0) << ((int) j);
                        j--;
                        i4++;
                        i2 = 8;
                    }
                    i3++;
                    i2 = 8;
                }
                strArr2[i] = String.format("%016X", new Object[]{Long.valueOf(j2)});
                return;
            }
            zzcct zzcct2 = zzcct;
            i++;
        }
    }
}
