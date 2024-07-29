package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgrp implements zzggh {
    private final zzggh zza;
    private final zzgvv zzb;
    private final byte[] zzc;

    private zzgrp(zzggh zzggh, zzgvv zzgvv, byte[] bArr) {
        this.zza = zzggh;
        this.zzb = zzgvv;
        this.zzc = bArr;
    }

    public static zzggh zza(zzgnd zzgnd) throws GeneralSecurityException {
        byte[] bArr;
        zzgot zza2 = zzgnd.zza(zzgfs.zza());
        zzgum zza3 = zzgup.zza();
        zza3.zzb(zza2.zzg());
        zza3.zzc(zza2.zze());
        zza3.zza(zza2.zzb());
        zzggh zzggh = (zzggh) zzggm.zzb((zzgup) zza3.zzbr(), zzggh.class);
        zzgvv zzc2 = zza2.zzc();
        zzgvv zzgvv = zzgvv.UNKNOWN_PREFIX;
        int ordinal = zzc2.ordinal();
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal == 3) {
                    bArr = new byte[0];
                } else if (ordinal != 4) {
                    throw new GeneralSecurityException("unknown output prefix type");
                }
            }
            bArr = ByteBuffer.allocate(5).put((byte) 0).putInt(zzgnd.zzb().intValue()).array();
        } else {
            bArr = ByteBuffer.allocate(5).put((byte) 1).putInt(zzgnd.zzb().intValue()).array();
        }
        return new zzgrp(zzggh, zzc2, bArr);
    }
}
