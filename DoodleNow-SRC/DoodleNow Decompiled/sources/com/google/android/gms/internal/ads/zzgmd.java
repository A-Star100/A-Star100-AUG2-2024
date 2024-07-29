package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgmd implements zzgfj {
    private final byte[] zza;
    private final byte[] zzb;

    private zzgmd(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (!zzgml.zza(1)) {
            throw new GeneralSecurityException("Can not use ChaCha20Poly1305 in FIPS-mode.");
        } else if (!zzc()) {
            throw new GeneralSecurityException("JCE does not support algorithm: ChaCha20-Poly1305");
        } else if (bArr.length == 32) {
            this.zza = bArr;
            this.zzb = bArr2;
        } else {
            throw new InvalidKeyException("The key length in bytes must be 32.");
        }
    }

    public static zzgfj zzb(zzgkp zzgkp) throws GeneralSecurityException {
        return new zzgmd(zzgkp.zzd().zzd(zzgfs.zza()), zzgkp.zzc().zzc());
    }

    public static boolean zzc() {
        return zzglr.zzc() != null;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr != null) {
            byte[] bArr3 = this.zzb;
            int length = bArr.length;
            if (length < bArr3.length + 40) {
                throw new GeneralSecurityException("ciphertext too short");
            } else if (zzgpi.zzb(bArr3, bArr)) {
                byte[] bArr4 = new byte[24];
                System.arraycopy(bArr, this.zzb.length, bArr4, 0, 24);
                int[] zzd = zzgls.zzd(zzgls.zze(this.zza), zzgls.zze(bArr4));
                ByteBuffer order = ByteBuffer.allocate(zzd.length * 4).order(ByteOrder.LITTLE_ENDIAN);
                order.asIntBuffer().put(zzd);
                SecretKeySpec secretKeySpec = new SecretKeySpec(order.array(), "ChaCha20");
                byte[] bArr5 = new byte[12];
                System.arraycopy(bArr4, 16, bArr5, 4, 8);
                IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr5);
                Cipher zzc = zzglr.zzc();
                zzc.init(2, secretKeySpec, ivParameterSpec);
                if (!(bArr2 == null || bArr2.length == 0)) {
                    zzc.updateAAD(bArr2);
                }
                int length2 = this.zzb.length;
                return zzc.doFinal(bArr, length2 + 24, (length - length2) - 24);
            } else {
                throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
            }
        } else {
            throw new NullPointerException("ciphertext is null");
        }
    }
}
