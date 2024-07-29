package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzggz {
    @Nullable
    private zzghl zza = null;
    @Nullable
    private zzgxn zzb = null;
    @Nullable
    private zzgxn zzc = null;
    @Nullable
    private Integer zzd = null;

    private zzggz() {
    }

    /* synthetic */ zzggz(zzggy zzggy) {
    }

    public final zzggz zza(zzgxn zzgxn) {
        this.zzb = zzgxn;
        return this;
    }

    public final zzggz zzb(zzgxn zzgxn) {
        this.zzc = zzgxn;
        return this;
    }

    public final zzggz zzc(@Nullable Integer num) {
        this.zzd = num;
        return this;
    }

    public final zzggz zzd(zzghl zzghl) {
        this.zza = zzghl;
        return this;
    }

    public final zzghb zze() throws GeneralSecurityException {
        zzgxm zzb2;
        zzghl zzghl = this.zza;
        if (zzghl != null) {
            zzgxn zzgxn = this.zzb;
            if (zzgxn == null || this.zzc == null) {
                throw new GeneralSecurityException("Cannot build without key material");
            } else if (zzghl.zzb() != zzgxn.zza()) {
                throw new GeneralSecurityException("AES key size mismatch");
            } else if (zzghl.zzc() != this.zzc.zza()) {
                throw new GeneralSecurityException("HMAC key size mismatch");
            } else if (this.zza.zza() && this.zzd == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            } else if (this.zza.zza() || this.zzd == null) {
                if (this.zza.zzh() == zzghj.zzc) {
                    zzb2 = zzgxm.zzb(new byte[0]);
                } else if (this.zza.zzh() == zzghj.zzb) {
                    zzb2 = zzgxm.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzd.intValue()).array());
                } else if (this.zza.zzh() == zzghj.zza) {
                    zzb2 = zzgxm.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzd.intValue()).array());
                } else {
                    throw new IllegalStateException("Unknown AesCtrHmacAeadParameters.Variant: ".concat(String.valueOf(String.valueOf(this.zza.zzh()))));
                }
                return new zzghb(this.zza, this.zzb, this.zzc, zzb2, this.zzd, (zzgha) null);
            } else {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
        } else {
            throw new GeneralSecurityException("Cannot build without parameters");
        }
    }
}
