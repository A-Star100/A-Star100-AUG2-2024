package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.Base64;
import com.amazon.a.a.o.b.f;
import java.io.IOException;
import java.net.URLDecoder;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgt extends zzgp {
    private zzhb zza;
    private byte[] zzb;
    private int zzc;
    private int zzd;

    public zzgt() {
        super(false);
    }

    public final int zza(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.zzd;
        if (i3 == 0) {
            return -1;
        }
        int min = Math.min(i2, i3);
        byte[] bArr2 = this.zzb;
        int i4 = zzfx.zza;
        System.arraycopy(bArr2, this.zzc, bArr, i, min);
        this.zzc += min;
        this.zzd -= min;
        zzg(min);
        return min;
    }

    public final long zzb(zzhb zzhb) throws IOException {
        zzi(zzhb);
        this.zza = zzhb;
        Uri normalizeScheme = zzhb.zza.normalizeScheme();
        String scheme = normalizeScheme.getScheme();
        zzek.zze("data".equals(scheme), "Unsupported scheme: ".concat(String.valueOf(scheme)));
        String schemeSpecificPart = normalizeScheme.getSchemeSpecificPart();
        int i = zzfx.zza;
        String[] split = schemeSpecificPart.split(f.a, -1);
        if (split.length == 2) {
            String str = split[1];
            if (split[0].contains(";base64")) {
                try {
                    this.zzb = Base64.decode(str, 0);
                } catch (IllegalArgumentException e) {
                    throw zzcc.zzb("Error while parsing Base64 encoded string: ".concat(String.valueOf(str)), e);
                }
            } else {
                this.zzb = URLDecoder.decode(str, zzfwd.zza.name()).getBytes(zzfwd.zzc);
            }
            long j = zzhb.zze;
            int length = this.zzb.length;
            if (j <= ((long) length)) {
                int i2 = (int) j;
                this.zzc = i2;
                int i3 = length - i2;
                this.zzd = i3;
                long j2 = zzhb.zzf;
                if (j2 != -1) {
                    this.zzd = (int) Math.min((long) i3, j2);
                }
                zzj(zzhb);
                long j3 = zzhb.zzf;
                return j3 != -1 ? j3 : (long) this.zzd;
            }
            this.zzb = null;
            throw new zzgw(2008);
        }
        throw zzcc.zzb("Unexpected URI format: ".concat(String.valueOf(String.valueOf(normalizeScheme))), (Throwable) null);
    }

    public final Uri zzc() {
        zzhb zzhb = this.zza;
        if (zzhb != null) {
            return zzhb.zza;
        }
        return null;
    }

    public final void zzd() {
        if (this.zzb != null) {
            this.zzb = null;
            zzh();
        }
        this.zza = null;
    }
}
