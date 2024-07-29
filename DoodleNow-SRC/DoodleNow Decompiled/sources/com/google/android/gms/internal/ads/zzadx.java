package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzadx {
    private final zzfo zza = new zzfo(10);

    public final zzby zza(zzadg zzadg, zzaha zzaha) throws IOException {
        zzby zzby = null;
        int i = 0;
        while (true) {
            try {
                ((zzact) zzadg).zzm(this.zza.zzM(), 0, 10, false);
                this.zza.zzK(0);
                if (this.zza.zzo() != 4801587) {
                    break;
                }
                this.zza.zzL(3);
                int zzl = this.zza.zzl();
                int i2 = zzl + 10;
                if (zzby == null) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(this.zza.zzM(), 0, bArr, 0, 10);
                    ((zzact) zzadg).zzm(bArr, 10, zzl, false);
                    zzby = zzahc.zza(bArr, i2, zzaha, new zzagd());
                } else {
                    ((zzact) zzadg).zzl(zzl, false);
                }
                i += i2;
            } catch (EOFException unused) {
            }
        }
        zzadg.zzj();
        ((zzact) zzadg).zzl(i, false);
        return zzby;
    }
}
