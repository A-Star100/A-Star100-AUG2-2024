package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzbcq extends PushbackInputStream {
    final /* synthetic */ zzbcr zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbcq(zzbcr zzbcr, InputStream inputStream, int i) {
        super(inputStream, 1);
        this.zza = zzbcr;
    }

    public final synchronized void close() throws IOException {
        zzbct.zze(this.zza.zzc);
        super.close();
    }
}
