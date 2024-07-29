package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgwm implements zzgfj {
    private final zzglx zza;
    private final byte[] zzb;

    private zzgwm(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        this.zza = new zzglx(bArr);
        this.zzb = bArr2;
    }

    public static zzgfj zzb(zzgiy zzgiy) throws GeneralSecurityException {
        return new zzgwm(zzgiy.zzd().zzd(zzgfs.zza()), zzgiy.zzc().zzc());
    }

    private final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        if (length >= 28) {
            byte[] copyOf = Arrays.copyOf(bArr, 12);
            return this.zza.zzb(ByteBuffer.wrap(bArr, 12, length - 12), copyOf, bArr2);
        }
        throw new GeneralSecurityException("ciphertext too short");
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzb;
        if (bArr3.length == 0) {
            return zzc(bArr, bArr2);
        }
        if (zzgpi.zzb(bArr3, bArr)) {
            byte[] bArr4 = this.zzb;
            return zzc(Arrays.copyOfRange(bArr, bArr4.length, bArr.length), bArr2);
        }
        throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
    }
}
