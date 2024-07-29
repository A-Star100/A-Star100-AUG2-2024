package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgpk {
    @Nullable
    private zzgpv zza = null;
    @Nullable
    private zzgxn zzb = null;
    @Nullable
    private Integer zzc = null;

    private zzgpk() {
    }

    /* synthetic */ zzgpk(zzgpj zzgpj) {
    }

    public final zzgpk zza(zzgxn zzgxn) throws GeneralSecurityException {
        this.zzb = zzgxn;
        return this;
    }

    public final zzgpk zzb(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzgpk zzc(zzgpv zzgpv) {
        this.zza = zzgpv;
        return this;
    }

    public final zzgpm zzd() throws GeneralSecurityException {
        zzgxn zzgxn;
        zzgxm zzb2;
        zzgpv zzgpv = this.zza;
        if (zzgpv == null || (zzgxn = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        } else if (zzgpv.zzc() != zzgxn.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        } else if (zzgpv.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        } else if (this.zza.zza() || this.zzc == null) {
            if (this.zza.zzf() == zzgpt.zzd) {
                zzb2 = zzgxm.zzb(new byte[0]);
            } else if (this.zza.zzf() == zzgpt.zzc || this.zza.zzf() == zzgpt.zzb) {
                zzb2 = zzgxm.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
            } else if (this.zza.zzf() == zzgpt.zza) {
                zzb2 = zzgxm.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
            } else {
                throw new IllegalStateException("Unknown AesCmacParametersParameters.Variant: ".concat(String.valueOf(String.valueOf(this.zza.zzf()))));
            }
            return new zzgpm(this.zza, this.zzb, zzb2, this.zzc, (zzgpl) null);
        } else {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
    }
}
