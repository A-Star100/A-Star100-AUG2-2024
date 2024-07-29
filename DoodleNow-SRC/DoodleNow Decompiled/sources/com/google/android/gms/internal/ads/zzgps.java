package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgps {
    @Nullable
    private Integer zza = null;
    @Nullable
    private Integer zzb = null;
    private zzgpt zzc = zzgpt.zzd;

    private zzgps() {
    }

    /* synthetic */ zzgps(zzgpr zzgpr) {
    }

    public final zzgps zzc(zzgpt zzgpt) {
        this.zzc = zzgpt;
        return this;
    }

    public final zzgps zza(int i) throws GeneralSecurityException {
        if (i == 16 || i == 32) {
            this.zza = Integer.valueOf(i);
            return this;
        }
        throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 128-bit and 256-bit AES keys are supported", new Object[]{Integer.valueOf(i * 8)}));
    }

    public final zzgps zzb(int i) throws GeneralSecurityException {
        if (i < 10 || i > 16) {
            throw new GeneralSecurityException("Invalid tag size for AesCmacParameters: " + i);
        }
        this.zzb = Integer.valueOf(i);
        return this;
    }

    public final zzgpv zzd() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("key size not set");
        } else if (this.zzb == null) {
            throw new GeneralSecurityException("tag size not set");
        } else if (this.zzc != null) {
            return new zzgpv(num.intValue(), this.zzb.intValue(), this.zzc, (zzgpu) null);
        } else {
            throw new GeneralSecurityException("variant not set");
        }
    }
}
