package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzghn {
    @Nullable
    private zzghx zza = null;
    @Nullable
    private zzgxn zzb = null;
    @Nullable
    private Integer zzc = null;

    private zzghn() {
    }

    /* synthetic */ zzghn(zzghm zzghm) {
    }

    public final zzghn zza(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzghn zzb(zzgxn zzgxn) {
        this.zzb = zzgxn;
        return this;
    }

    public final zzghn zzc(zzghx zzghx) {
        this.zza = zzghx;
        return this;
    }

    public final zzghp zzd() throws GeneralSecurityException {
        zzgxn zzgxn;
        zzgxm zzb2;
        zzghx zzghx = this.zza;
        if (zzghx == null || (zzgxn = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        } else if (zzghx.zzc() != zzgxn.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        } else if (zzghx.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        } else if (this.zza.zza() || this.zzc == null) {
            if (this.zza.zze() == zzghv.zzc) {
                zzb2 = zzgxm.zzb(new byte[0]);
            } else if (this.zza.zze() == zzghv.zzb) {
                zzb2 = zzgxm.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
            } else if (this.zza.zze() == zzghv.zza) {
                zzb2 = zzgxm.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
            } else {
                throw new IllegalStateException("Unknown AesEaxParameters.Variant: ".concat(String.valueOf(String.valueOf(this.zza.zze()))));
            }
            return new zzghp(this.zza, this.zzb, zzb2, this.zzc, (zzgho) null);
        } else {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
    }
}
