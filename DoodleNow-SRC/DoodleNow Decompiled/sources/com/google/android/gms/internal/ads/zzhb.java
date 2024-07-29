package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzhb {
    public static final /* synthetic */ int zzh = 0;
    public final Uri zza;
    public final int zzb;
    public final byte[] zzc;
    public final Map zzd;
    public final long zze;
    public final long zzf;
    public final int zzg;

    static {
        zzbq.zzb("media3.datasource");
    }

    private zzhb(Uri uri, long j, int i, byte[] bArr, Map map, long j2, long j3, String str, int i2, Object obj) {
        boolean z = false;
        boolean z2 = j2 >= 0;
        zzek.zzd(z2);
        zzek.zzd(z2);
        if (j3 <= 0) {
            j3 = j3 == -1 ? -1 : j3;
            zzek.zzd(z);
            uri.getClass();
            this.zza = uri;
            this.zzb = 1;
            this.zzc = null;
            this.zzd = Collections.unmodifiableMap(new HashMap(map));
            this.zze = j2;
            this.zzf = j3;
            this.zzg = i2;
        }
        z = true;
        zzek.zzd(z);
        uri.getClass();
        this.zza = uri;
        this.zzb = 1;
        this.zzc = null;
        this.zzd = Collections.unmodifiableMap(new HashMap(map));
        this.zze = j2;
        this.zzf = j3;
        this.zzg = i2;
    }

    /* synthetic */ zzhb(Uri uri, long j, int i, byte[] bArr, Map map, long j2, long j3, String str, int i2, Object obj, zzha zzha) {
        this(uri, 0, 1, (byte[]) null, map, j2, j3, (String) null, i2, (Object) null);
    }

    @Deprecated
    public zzhb(Uri uri, long j, long j2, String str) {
        this(uri, 0, 1, (byte[]) null, Collections.emptyMap(), j, j2, (String) null, 0, (Object) null);
    }

    public final String toString() {
        String obj = this.zza.toString();
        return "DataSpec[GET " + obj + ", " + this.zze + ", " + this.zzf + ", null, " + this.zzg + "]";
    }

    public final zzgz zza() {
        return new zzgz(this, (zzgy) null);
    }

    public final boolean zzb(int i) {
        return (this.zzg & i) == i;
    }
}
