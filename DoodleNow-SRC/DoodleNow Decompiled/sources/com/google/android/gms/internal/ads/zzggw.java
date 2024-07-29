package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzggw implements zzgfj {
    private final zzgos zza;
    private final zzgrt zzb;
    private final zzgrt zzc;

    /* synthetic */ zzggw(zzgos zzgos, zzggv zzggv) {
        zzgrt zzgrt;
        this.zza = zzgos;
        if (zzgos.zzg()) {
            zzgru zzb2 = zzgnp.zza().zzb();
            zzgrz zza2 = zzgnh.zza(zzgos);
            this.zzb = zzb2.zza(zza2, "aead", "encrypt");
            zzgrt = zzb2.zza(zza2, "aead", "decrypt");
        } else {
            zzgrt = zzgnh.zza;
            this.zzb = zzgrt;
        }
        this.zzc = zzgrt;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length > 5) {
            for (zzgoq zzgoq : this.zza.zzf(Arrays.copyOf(bArr, 5))) {
                try {
                    byte[] zza2 = ((zzgfj) zzgoq.zze()).zza(bArr, bArr2);
                    zzgoq.zza();
                    int length = bArr.length;
                    return zza2;
                } catch (GeneralSecurityException unused) {
                }
            }
        }
        for (zzgoq zzgoq2 : this.zza.zzf(zzgfo.zza)) {
            try {
                byte[] zza3 = ((zzgfj) zzgoq2.zze()).zza(bArr, bArr2);
                zzgoq2.zza();
                int length2 = bArr.length;
                return zza3;
            } catch (GeneralSecurityException unused2) {
            }
        }
        throw new GeneralSecurityException("decryption failed");
    }
}
