package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgiy extends zzggs {
    private final zzgjd zza;
    private final zzgxn zzb;
    private final zzgxm zzc;
    @Nullable
    private final Integer zzd;

    private zzgiy(zzgjd zzgjd, zzgxn zzgxn, zzgxm zzgxm, @Nullable Integer num) {
        this.zza = zzgjd;
        this.zzb = zzgxn;
        this.zzc = zzgxm;
        this.zzd = num;
    }

    public static zzgiy zza(zzgjc zzgjc, zzgxn zzgxn, @Nullable Integer num) throws GeneralSecurityException {
        zzgxm zzgxm;
        zzgjc zzgjc2 = zzgjc.zzc;
        if (zzgjc != zzgjc2 && num == null) {
            String obj = zzgjc.toString();
            throw new GeneralSecurityException("For given Variant " + obj + " the value of idRequirement must be non-null");
        } else if (zzgjc == zzgjc2 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        } else if (zzgxn.zza() == 32) {
            zzgjd zzc2 = zzgjd.zzc(zzgjc);
            if (zzc2.zzb() == zzgjc2) {
                zzgxm = zzgxm.zzb(new byte[0]);
            } else if (zzc2.zzb() == zzgjc.zzb) {
                zzgxm = zzgxm.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(num.intValue()).array());
            } else if (zzc2.zzb() == zzgjc.zza) {
                zzgxm = zzgxm.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
            } else {
                throw new IllegalStateException("Unknown Variant: ".concat(zzc2.zzb().toString()));
            }
            return new zzgiy(zzc2, zzgxn, zzgxm, num);
        } else {
            int zza2 = zzgxn.zza();
            throw new GeneralSecurityException("ChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + zza2);
        }
    }

    public final zzgjd zzb() {
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
