package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public class zzbff {
    private final String zza;
    private final Object zzb;
    private final int zzc;

    protected zzbff(String str, Object obj, int i) {
        this.zza = str;
        this.zzb = obj;
        this.zzc = i;
    }

    public static zzbff zza(String str, double d) {
        return new zzbff(str, Double.valueOf(d), 3);
    }

    public static zzbff zzb(String str, long j) {
        return new zzbff(str, Long.valueOf(j), 2);
    }

    public static zzbff zzc(String str, String str2) {
        return new zzbff(str, str2, 4);
    }

    public static zzbff zzd(String str, boolean z) {
        return new zzbff(str, Boolean.valueOf(z), 1);
    }

    public final Object zze() {
        zzbgi zza2 = zzbgk.zza();
        if (zza2 == null) {
            if (zzbgk.zzb() != null) {
                zzbgk.zzb().zza();
            }
            return this.zzb;
        }
        int i = this.zzc - 1;
        if (i == 0) {
            return zza2.zza(this.zza, ((Boolean) this.zzb).booleanValue());
        }
        if (i == 1) {
            return zza2.zzc(this.zza, ((Long) this.zzb).longValue());
        }
        if (i != 2) {
            return zza2.zzd(this.zza, (String) this.zzb);
        }
        return zza2.zzb(this.zza, ((Double) this.zzb).doubleValue());
    }
}
