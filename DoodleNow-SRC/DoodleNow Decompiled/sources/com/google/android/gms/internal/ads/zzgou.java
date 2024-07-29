package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgou implements zzgoy {
    private final zzgxm zza;
    private final zzguu zzb;

    private zzgou(zzguu zzguu, zzgxm zzgxm) {
        this.zzb = zzguu;
        this.zza = zzgxm;
    }

    public static zzgou zza(zzguu zzguu) throws GeneralSecurityException {
        String zzi = zzguu.zzi();
        Charset charset = zzgpi.zza;
        byte[] bArr = new byte[zzi.length()];
        for (int i = 0; i < zzi.length(); i++) {
            char charAt = zzi.charAt(i);
            if (charAt < '!' || charAt > '~') {
                throw new GeneralSecurityException("Not a printable ASCII character: " + charAt);
            }
            bArr[i] = (byte) charAt;
        }
        return new zzgou(zzguu, zzgxm.zzb(bArr));
    }

    public static zzgou zzb(zzguu zzguu) {
        return new zzgou(zzguu, zzgpi.zza(zzguu.zzi()));
    }

    public final zzguu zzc() {
        return this.zzb;
    }

    public final zzgxm zzd() {
        return this.zza;
    }
}
