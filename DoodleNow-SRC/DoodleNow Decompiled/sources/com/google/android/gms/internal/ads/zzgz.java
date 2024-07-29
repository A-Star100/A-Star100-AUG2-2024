package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgz {
    private Uri zza;
    private Map zzb;
    private long zzc;
    private final long zzd;
    private int zze;

    public zzgz() {
        this.zzb = Collections.emptyMap();
        this.zzd = -1;
    }

    /* synthetic */ zzgz(zzhb zzhb, zzgy zzgy) {
        this.zza = zzhb.zza;
        this.zzb = zzhb.zzd;
        this.zzc = zzhb.zze;
        this.zzd = zzhb.zzf;
        this.zze = zzhb.zzg;
    }

    public final zzgz zza(int i) {
        this.zze = 6;
        return this;
    }

    public final zzgz zzb(Map map) {
        this.zzb = map;
        return this;
    }

    public final zzgz zzc(long j) {
        this.zzc = j;
        return this;
    }

    public final zzgz zzd(Uri uri) {
        this.zza = uri;
        return this;
    }

    public final zzhb zze() {
        if (this.zza != null) {
            return new zzhb(this.zza, 0, 1, (byte[]) null, this.zzb, this.zzc, this.zzd, (String) null, this.zze, (Object) null, (zzha) null);
        }
        throw new IllegalStateException("The uri must be set.");
    }
}
