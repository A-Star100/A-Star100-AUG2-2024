package com.google.android.gms.internal.ads;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgfk {
    private final InputStream zza;

    private zzgfk(InputStream inputStream) {
        this.zza = inputStream;
    }

    public static zzgfk zzb(byte[] bArr) {
        return new zzgfk(new ByteArrayInputStream(bArr));
    }

    public final zzgvc zza() throws IOException {
        try {
            return zzgvc.zzg(this.zza, zzgzf.zza());
        } finally {
            this.zza.close();
        }
    }
}
