package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgxl implements zzgfj {
    private final zzgma zza;
    private final byte[] zzb;

    private zzgxl(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        this.zza = new zzgma(bArr);
        this.zzb = bArr2;
    }

    public static zzgfj zzb(zzgkp zzgkp) throws GeneralSecurityException {
        return new zzgxl(zzgkp.zzd().zzd(zzgfs.zza()), zzgkp.zzc().zzc());
    }

    private final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        if (length >= 40) {
            byte[] copyOf = Arrays.copyOf(bArr, 24);
            return this.zza.zzb(ByteBuffer.wrap(bArr, 24, length - 24), copyOf, bArr2);
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
