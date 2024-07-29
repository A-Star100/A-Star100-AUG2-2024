package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzasa extends zzhig implements Closeable {
    private static final zzhin zza = zzhin.zzb(zzasa.class);

    public zzasa(zzhih zzhih, zzarz zzarz) throws IOException {
        zzf(zzhih, zzhih.zzc(), zzarz);
    }

    public final void close() throws IOException {
    }

    public final String toString() {
        String obj = this.zzd.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 7);
        sb.append("model(");
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }
}
