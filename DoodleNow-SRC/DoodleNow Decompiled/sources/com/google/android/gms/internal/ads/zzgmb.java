package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgmb implements zzgfj {
    private final zzgfj zza;
    private final zzgvv zzb;
    private final byte[] zzc;

    private zzgmb(zzgfj zzgfj, zzgvv zzgvv, byte[] bArr) {
        this.zza = zzgfj;
        this.zzb = zzgvv;
        this.zzc = bArr;
    }

    public static zzgfj zzb(zzgnd zzgnd) throws GeneralSecurityException {
        byte[] bArr;
        zzgot zza2 = zzgnd.zza(zzgfs.zza());
        zzgum zza3 = zzgup.zza();
        zza3.zzb(zza2.zzg());
        zza3.zzc(zza2.zze());
        zza3.zza(zza2.zzb());
        zzgfj zzgfj = (zzgfj) zzggm.zzb((zzgup) zza3.zzbr(), zzgfj.class);
        zzgvv zzc2 = zza2.zzc();
        zzgvv zzgvv = zzgvv.UNKNOWN_PREFIX;
        int ordinal = zzc2.ordinal();
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal == 3) {
                    bArr = new byte[0];
                } else if (ordinal != 4) {
                    throw new GeneralSecurityException("unknown output prefix type ".concat(String.valueOf(String.valueOf(zzc2))));
                }
            }
            bArr = ByteBuffer.allocate(5).put((byte) 0).putInt(zzgnd.zzb().intValue()).array();
        } else {
            bArr = ByteBuffer.allocate(5).put((byte) 1).putInt(zzgnd.zzb().intValue()).array();
        }
        return new zzgmb(zzgfj, zzc2, bArr);
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (this.zzb == zzgvv.RAW) {
            return this.zza.zza(bArr, bArr2);
        }
        if (zzgpi.zzb(this.zzc, bArr)) {
            return this.zza.zza(Arrays.copyOfRange(bArr, 5, bArr.length), bArr2);
        }
        throw new GeneralSecurityException("wrong prefix");
    }
}
