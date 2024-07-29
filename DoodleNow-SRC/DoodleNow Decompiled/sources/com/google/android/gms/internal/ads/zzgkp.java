package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgkp extends zzggs {
    private final zzgkv zza;
    private final zzgxn zzb;
    private final zzgxm zzc;
    @Nullable
    private final Integer zzd;

    private zzgkp(zzgkv zzgkv, zzgxn zzgxn, zzgxm zzgxm, @Nullable Integer num) {
        this.zza = zzgkv;
        this.zzb = zzgxn;
        this.zzc = zzgxm;
        this.zzd = num;
    }

    public static zzgkp zza(zzgku zzgku, zzgxn zzgxn, @Nullable Integer num) throws GeneralSecurityException {
        zzgxm zzgxm;
        zzgku zzgku2 = zzgku.zzc;
        if (zzgku != zzgku2 && num == null) {
            String obj = zzgku.toString();
            throw new GeneralSecurityException("For given Variant " + obj + " the value of idRequirement must be non-null");
        } else if (zzgku == zzgku2 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        } else if (zzgxn.zza() == 32) {
            zzgkv zzc2 = zzgkv.zzc(zzgku);
            if (zzc2.zzb() == zzgku2) {
                zzgxm = zzgxm.zzb(new byte[0]);
            } else if (zzc2.zzb() == zzgku.zzb) {
                zzgxm = zzgxm.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(num.intValue()).array());
            } else if (zzc2.zzb() == zzgku.zza) {
                zzgxm = zzgxm.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
            } else {
                throw new IllegalStateException("Unknown Variant: ".concat(zzc2.zzb().toString()));
            }
            return new zzgkp(zzc2, zzgxn, zzgxm, num);
        } else {
            int zza2 = zzgxn.zza();
            throw new GeneralSecurityException("XChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + zza2);
        }
    }

    public final zzgkv zzb() {
        return this.zza;
    }

    public final zzgxm zzc() {
        return this.zzc;
    }

    public final zzgxn zzd() {
        return this.zzb;
    }

    @Nullable
    public final Integer zze() {
        return this.zzd;
    }
}
