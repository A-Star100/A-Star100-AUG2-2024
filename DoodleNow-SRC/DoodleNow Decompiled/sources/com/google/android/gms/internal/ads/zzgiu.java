package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgiu {
    @Nullable
    private Integer zza = null;
    private zzgiv zzb = zzgiv.zzc;

    private zzgiu() {
    }

    /* synthetic */ zzgiu(zzgit zzgit) {
    }

    public final zzgiu zzb(zzgiv zzgiv) {
        this.zzb = zzgiv;
        return this;
    }

    public final zzgiu zza(int i) throws GeneralSecurityException {
        if (i == 16 || i == 32) {
            this.zza = Integer.valueOf(i);
            return this;
        }
        throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte and 32-byte AES keys are supported", new Object[]{Integer.valueOf(i)}));
    }

    public final zzgix zzc() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("Key size is not set");
        } else if (this.zzb != null) {
            return new zzgix(num.intValue(), this.zzb, (zzgiw) null);
        } else {
            throw new GeneralSecurityException("Variant is not set");
        }
    }
}
