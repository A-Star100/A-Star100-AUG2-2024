package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public abstract class zzcae {
    static zzcae zza;

    public static synchronized zzcae zzd(Context context) {
        synchronized (zzcae.class) {
            zzcae zzcae = zza;
            if (zzcae != null) {
                return zzcae;
            }
            Context applicationContext = context.getApplicationContext();
            zzbdz.zza(applicationContext);
            zzg zzi = zzu.zzo().zzi();
            zzi.zzq(applicationContext);
            zzbzw zzbzw = new zzbzw((zzbzv) null);
            zzbzw.zzb(applicationContext);
            zzbzw.zzc(zzu.zzB());
            zzbzw.zza(zzi);
            zzbzw.zzd(zzu.zzn());
            zzcae zze = zzbzw.zze();
            zza = zze;
            zze.zza().zza();
            zzcai zzc = zza.zzc();
            if (((Boolean) zzba.zzc().zza(zzbdz.zzaq)).booleanValue()) {
                zzu.zzp();
                Map zzv = zzt.zzv((String) zzba.zzc().zza(zzbdz.zzas));
                for (String zzc2 : zzv.keySet()) {
                    zzc.zzc(zzc2);
                }
                zzc.zzd(new zzcag(zzc, zzv));
            }
            zzcae zzcae2 = zza;
            return zzcae2;
        }
    }

    /* access modifiers changed from: package-private */
    public abstract zzbzp zza();

    /* access modifiers changed from: package-private */
    public abstract zzbzt zzb();

    /* access modifiers changed from: package-private */
    public abstract zzcai zzc();
}
