package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgwn implements zzgfj {
    private final zzgxf zza;
    private final zzggh zzb;
    private final int zzc;
    private final byte[] zzd;

    private zzgwn(zzgxf zzgxf, zzggh zzggh, int i, byte[] bArr) {
        this.zza = zzgxf;
        this.zzb = zzggh;
        this.zzc = i;
        this.zzd = bArr;
    }

    public static zzgfj zzb(zzghb zzghb) throws GeneralSecurityException {
        zzgwg zzgwg = new zzgwg(zzghb.zzd().zzd(zzgfs.zza()), zzghb.zzb().zzd());
        String valueOf = String.valueOf(String.valueOf(zzghb.zzb().zzg()));
        return new zzgwn(zzgwg, new zzgxj(new zzgxi("HMAC".concat(valueOf), new SecretKeySpec(zzghb.zze().zzd(zzgfs.zza()), "HMAC")), zzghb.zzb().zze()), zzghb.zzb().zze(), zzghb.zzc().zzc());
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzd;
        int i = this.zzc;
        int length = bArr3.length;
        int length2 = bArr.length;
        if (length2 < i + length) {
            throw new GeneralSecurityException("Decryption failed (ciphertext too short).");
        } else if (zzgpi.zzb(bArr3, bArr)) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, this.zzd.length, length2 - this.zzc);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, length2 - this.zzc, length2);
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            byte[] copyOf = Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8);
            byte[][] bArr4 = {bArr2, copyOfRange, copyOf};
            if (MessageDigest.isEqual(((zzgxj) this.zzb).zzc(zzgwl.zzb(bArr4)), copyOfRange2)) {
                return this.zza.zza(copyOfRange);
            }
            throw new GeneralSecurityException("invalid MAC");
        } else {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
    }
}
