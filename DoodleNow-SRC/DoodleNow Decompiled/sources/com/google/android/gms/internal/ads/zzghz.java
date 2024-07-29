package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzghz {
    @Nullable
    private zzgik zza = null;
    @Nullable
    private zzgxn zzb = null;
    @Nullable
    private Integer zzc = null;

    private zzghz() {
    }

    /* synthetic */ zzghz(zzghy zzghy) {
    }

    public final zzghz zza(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzghz zzb(zzgxn zzgxn) {
        this.zzb = zzgxn;
        return this;
    }

    public final zzghz zzc(zzgik zzgik) {
        this.zza = zzgik;
        return this;
    }

    public final zzgib zzd() throws GeneralSecurityException {
        zzgxn zzgxn;
        zzgxm zzb2;
        zzgik zzgik = this.zza;
        if (zzgik == null || (zzgxn = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        } else if (zzgik.zzb() != zzgxn.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        } else if (zzgik.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        } else if (this.zza.zza() || this.zzc == null) {
            if (this.zza.zzd() == zzgii.zzc) {
                zzb2 = zzgxm.zzb(new byte[0]);
            } else if (this.zza.zzd() == zzgii.zzb) {
                zzb2 = zzgxm.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
            } else if (this.zza.zzd() == zzgii.zza) {
                zzb2 = zzgxm.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
            } else {
                throw new IllegalStateException("Unknown AesGcmParameters.Variant: ".concat(String.valueOf(String.valueOf(this.zza.zzd()))));
            }
            return new zzgib(this.zza, this.zzb, zzb2, this.zzc, (zzgia) null);
        } else {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
    }
}
