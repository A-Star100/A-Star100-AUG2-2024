package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzhx implements zzgv {
    private final zzgv zza;
    private long zzb;
    private Uri zzc = Uri.EMPTY;
    private Map zzd = Collections.emptyMap();

    public zzhx(zzgv zzgv) {
        this.zza = zzgv;
    }

    public final int zza(byte[] bArr, int i, int i2) throws IOException {
        int zza2 = this.zza.zza(bArr, i, i2);
        if (zza2 != -1) {
            this.zzb += (long) zza2;
        }
        return zza2;
    }

    public final long zzb(zzhb zzhb) throws IOException {
        this.zzc = zzhb.zza;
        this.zzd = Collections.emptyMap();
        long zzb2 = this.zza.zzb(zzhb);
        Uri zzc2 = zzc();
        zzc2.getClass();
        this.zzc = zzc2;
        this.zzd = zze();
        return zzb2;
    }

    public final Uri zzc() {
        return this.zza.zzc();
    }

    public final void zzd() throws IOException {
        this.zza.zzd();
    }

    public final Map zze() {
        return this.zza.zze();
    }

    public final long zzg() {
        return this.zzb;
    }

    public final Uri zzh() {
        return this.zzc;
    }

    public final Map zzi() {
        return this.zzd;
    }

    public final void zzf(zzhy zzhy) {
        zzhy.getClass();
        this.zza.zzf(zzhy);
    }
}
