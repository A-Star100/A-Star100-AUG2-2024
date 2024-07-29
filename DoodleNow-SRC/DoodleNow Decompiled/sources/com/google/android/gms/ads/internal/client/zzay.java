package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbje;
import com.google.android.gms.internal.ads.zzbum;
import com.google.android.gms.internal.ads.zzbyv;
import java.util.Random;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzay {
    private static final zzay zza = new zzay();
    private final zzf zzb;
    private final zzaw zzc;
    private final String zzd;
    private final VersionInfoParcel zze;
    private final Random zzf;

    protected zzay() {
        zzf zzf2 = new zzf();
        zzaw zzaw = new zzaw(new zzk(), new zzi(), new zzeq(), new zzbjd(), new zzbyv(), new zzbum(), new zzbje());
        String zze2 = zzf.zze();
        VersionInfoParcel versionInfoParcel = new VersionInfoParcel(0, 241199000, true);
        Random random = new Random();
        this.zzb = zzf2;
        this.zzc = zzaw;
        this.zzd = zze2;
        this.zze = versionInfoParcel;
        this.zzf = random;
    }

    public static zzaw zza() {
        return zza.zzc;
    }

    public static zzf zzb() {
        return zza.zzb;
    }

    public static VersionInfoParcel zzc() {
        return zza.zze;
    }

    public static String zzd() {
        return zza.zzd;
    }

    public static Random zze() {
        return zza.zzf;
    }
}
