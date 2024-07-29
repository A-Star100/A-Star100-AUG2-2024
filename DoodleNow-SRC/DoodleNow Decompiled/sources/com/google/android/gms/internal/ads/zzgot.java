package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgot implements zzgoy {
    private final String zza;
    private final zzgxm zzb;
    private final zzgyj zzc;
    private final zzguo zzd;
    private final zzgvv zze;
    @Nullable
    private final Integer zzf;

    private zzgot(String str, zzgyj zzgyj, zzguo zzguo, zzgvv zzgvv, @Nullable Integer num) {
        this.zza = str;
        this.zzb = zzgpi.zza(str);
        this.zzc = zzgyj;
        this.zzd = zzguo;
        this.zze = zzgvv;
        this.zzf = num;
    }

    public static zzgot zza(String str, zzgyj zzgyj, zzguo zzguo, zzgvv zzgvv, @Nullable Integer num) throws GeneralSecurityException {
        if (zzgvv == zzgvv.RAW) {
            if (num != null) {
                throw new GeneralSecurityException("Keys with output prefix type raw should not have an id requirement.");
            }
        } else if (num == null) {
            throw new GeneralSecurityException("Keys with output prefix type different from raw should have an id requirement.");
        }
        return new zzgot(str, zzgyj, zzguo, zzgvv, num);
    }

    public final zzguo zzb() {
        return this.zzd;
    }

    public final zzgvv zzc() {
        return this.zze;
    }

    public final zzgxm zzd() {
        return this.zzb;
    }

    public final zzgyj zze() {
        return this.zzc;
    }

    @Nullable
    public final Integer zzf() {
        return this.zzf;
    }

    public final String zzg() {
        return this.zza;
    }
}
