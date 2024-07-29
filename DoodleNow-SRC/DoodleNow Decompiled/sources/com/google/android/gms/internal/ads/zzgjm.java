package com.google.android.gms.internal.ads;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgjm implements zzgfj {
    private static final byte[] zza = new byte[0];
    private static final Set zzb;
    private final String zzc;
    private final zzggi zzd;
    private final zzgfj zze;

    static {
        HashSet hashSet = new HashSet();
        hashSet.add("type.googleapis.com/google.crypto.tink.AesGcmKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        hashSet.add("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzb = Collections.unmodifiableSet(hashSet);
    }

    @Deprecated
    zzgjm(zzguu zzguu, zzgfj zzgfj) throws GeneralSecurityException {
        if (zzb.contains(zzguu.zzi())) {
            this.zzc = zzguu.zzi();
            zzgut zzc2 = zzguu.zzc(zzguu);
            zzc2.zza(zzgvv.RAW);
            this.zzd = zzggp.zza(((zzguu) zzc2.zzbr()).zzaV());
            this.zze = zzgfj;
            return;
        }
        String zzi = zzguu.zzi();
        throw new IllegalArgumentException("Unsupported DEK key type: " + zzi + ". Only Tink AEAD key types are supported.");
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int i = wrap.getInt();
            if (i <= 0 || i > bArr.length - 4) {
                throw new GeneralSecurityException("invalid ciphertext");
            }
            byte[] bArr3 = new byte[i];
            wrap.get(bArr3, 0, i);
            byte[] bArr4 = new byte[wrap.remaining()];
            wrap.get(bArr4, 0, wrap.remaining());
            byte[] zza2 = this.zze.zza(bArr3, zza);
            String str = this.zzc;
            zzgyj zzgyj = zzgyj.zzb;
            return ((zzgfj) zzgnr.zza().zzc(zzgnu.zzc().zza(zzgot.zza(str, zzgyj.zzv(zza2, 0, zza2.length), zzguo.SYMMETRIC, zzgvv.RAW, (Integer) null), zzgfs.zza()), zzgfj.class)).zza(bArr4, bArr2);
        } catch (IndexOutOfBoundsException | NegativeArraySizeException | BufferUnderflowException e) {
            throw new GeneralSecurityException("invalid ciphertext", e);
        }
    }
}
