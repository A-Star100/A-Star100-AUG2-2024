package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgxj implements zzggh {
    private static final byte[] zza = {0};
    private final zzgsa zzb;
    private final int zzc;
    private final byte[] zzd;
    private final byte[] zze;

    private zzgxj(zzgpm zzgpm) throws GeneralSecurityException {
        this.zzb = new zzgxg(zzgpm.zzd().zzd(zzgfs.zza()));
        this.zzc = zzgpm.zzb().zzb();
        this.zzd = zzgpm.zzc().zzc();
        if (zzgpm.zzb().zzf().equals(zzgpt.zzc)) {
            this.zze = Arrays.copyOf(zza, 1);
        } else {
            this.zze = new byte[0];
        }
    }

    public static zzggh zza(zzgpm zzgpm) throws GeneralSecurityException {
        return new zzgxj(zzgpm);
    }

    public static zzggh zzb(zzgqd zzgqd) throws GeneralSecurityException {
        return new zzgxj(zzgqd);
    }

    public final byte[] zzc(byte[] bArr) throws GeneralSecurityException {
        byte[] bArr2 = this.zze;
        if (bArr2.length > 0) {
            return zzgwl.zzb(this.zzd, this.zzb.zza(zzgwl.zzb(bArr, bArr2), this.zzc));
        }
        return zzgwl.zzb(this.zzd, this.zzb.zza(bArr, this.zzc));
    }

    private zzgxj(zzgqd zzgqd) throws GeneralSecurityException {
        String valueOf = String.valueOf(String.valueOf(zzgqd.zzb().zzf()));
        this.zzb = new zzgxi("HMAC".concat(valueOf), new SecretKeySpec(zzgqd.zzd().zzd(zzgfs.zza()), "HMAC"));
        this.zzc = zzgqd.zzb().zzb();
        this.zzd = zzgqd.zzc().zzc();
        if (zzgqd.zzb().zzg().equals(zzgqm.zzc)) {
            this.zze = Arrays.copyOf(zza, 1);
        } else {
            this.zze = new byte[0];
        }
    }

    public zzgxj(zzgsa zzgsa, int i) throws GeneralSecurityException {
        this.zzb = zzgsa;
        this.zzc = i;
        this.zzd = new byte[0];
        this.zze = new byte[0];
        zzgsa.zza(new byte[0], i);
    }
}
