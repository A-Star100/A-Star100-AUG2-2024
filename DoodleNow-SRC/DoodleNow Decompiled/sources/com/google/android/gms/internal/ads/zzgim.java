package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgim {
    @Nullable
    private zzgix zza = null;
    @Nullable
    private zzgxn zzb = null;
    @Nullable
    private Integer zzc = null;

    private zzgim() {
    }

    /* synthetic */ zzgim(zzgil zzgil) {
    }

    public final zzgim zza(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzgim zzb(zzgxn zzgxn) {
        this.zzb = zzgxn;
        return this;
    }

    public final zzgim zzc(zzgix zzgix) {
        this.zza = zzgix;
        return this;
    }

    public final zzgio zzd() throws GeneralSecurityException {
        zzgxn zzgxn;
        zzgxm zzb2;
        zzgix zzgix = this.zza;
        if (zzgix == null || (zzgxn = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        } else if (zzgix.zzb() != zzgxn.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        } else if (zzgix.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        } else if (this.zza.zza() || this.zzc == null) {
            if (this.zza.zzd() == zzgiv.zzc) {
                zzb2 = zzgxm.zzb(new byte[0]);
            } else if (this.zza.zzd() == zzgiv.zzb) {
                zzb2 = zzgxm.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
            } else if (this.zza.zzd() == zzgiv.zza) {
                zzb2 = zzgxm.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
            } else {
                throw new IllegalStateException("Unknown AesGcmSivParameters.Variant: ".concat(String.valueOf(String.valueOf(this.zza.zzd()))));
            }
            return new zzgio(this.zza, this.zzb, zzb2, this.zzc, (zzgin) null);
        } else {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
    }
}
