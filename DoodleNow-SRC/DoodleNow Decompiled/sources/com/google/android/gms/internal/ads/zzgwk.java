package com.google.android.gms.internal.ads;

import android.os.Build;
import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgwk implements zzgfj {
    private final SecretKey zza;
    private final byte[] zzb;

    private zzgwk(byte[] bArr, zzgxm zzgxm) throws GeneralSecurityException {
        if (zzgml.zza(2)) {
            zzgxk.zza(bArr.length);
            this.zza = new SecretKeySpec(bArr, "AES");
            this.zzb = zzgxm.zzc();
            return;
        }
        throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
    }

    public static zzgfj zzb(zzgib zzgib) throws GeneralSecurityException {
        return new zzgwk(zzgib.zzd().zzd(zzgfs.zza()), zzgib.zzc());
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Integer num;
        if (bArr != null) {
            byte[] bArr3 = this.zzb;
            int length = bArr.length;
            if (length < bArr3.length + 28) {
                throw new GeneralSecurityException("ciphertext too short");
            } else if (zzgpi.zzb(bArr3, bArr)) {
                byte[] bArr4 = new byte[12];
                System.arraycopy(bArr, this.zzb.length, bArr4, 0, 12);
                int i = zzglu.zza;
                if (!Objects.equals(System.getProperty("java.vendor"), "The Android Project")) {
                    num = null;
                } else {
                    num = Integer.valueOf(Build.VERSION.SDK_INT);
                }
                if (num != null) {
                    num.intValue();
                }
                GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, bArr4, 0, 12);
                SecretKey secretKey = this.zza;
                Cipher zza2 = zzglu.zza();
                zza2.init(2, secretKey, gCMParameterSpec);
                if (!(bArr2 == null || bArr2.length == 0)) {
                    zza2.updateAAD(bArr2);
                }
                int length2 = this.zzb.length;
                return zza2.doFinal(bArr, length2 + 12, (length - length2) - 12);
            } else {
                throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
            }
        } else {
            throw new NullPointerException("ciphertext is null");
        }
    }
}
