package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgqb {
    @Nullable
    private zzgqo zza = null;
    @Nullable
    private zzgxn zzb = null;
    @Nullable
    private Integer zzc = null;

    private zzgqb() {
    }

    /* synthetic */ zzgqb(zzgqa zzgqa) {
    }

    public final zzgqb zza(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzgqb zzb(zzgxn zzgxn) {
        this.zzb = zzgxn;
        return this;
    }

    public final zzgqb zzc(zzgqo zzgqo) {
        this.zza = zzgqo;
        return this;
    }

    public final zzgqd zzd() throws GeneralSecurityException {
        zzgxn zzgxn;
        zzgxm zzb2;
        zzgqo zzgqo = this.zza;
        if (zzgqo == null || (zzgxn = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        } else if (zzgqo.zzc() != zzgxn.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        } else if (zzgqo.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        } else if (this.zza.zza() || this.zzc == null) {
            if (this.zza.zzg() == zzgqm.zzd) {
                zzb2 = zzgxm.zzb(new byte[0]);
            } else if (this.zza.zzg() == zzgqm.zzc || this.zza.zzg() == zzgqm.zzb) {
                zzb2 = zzgxm.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
            } else if (this.zza.zzg() == zzgqm.zza) {
                zzb2 = zzgxm.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
            } else {
                throw new IllegalStateException("Unknown HmacParameters.Variant: ".concat(String.valueOf(String.valueOf(this.zza.zzg()))));
            }
            return new zzgqd(this.zza, this.zzb, zzb2, this.zzc, (zzgqc) null);
        } else {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
    }
}
