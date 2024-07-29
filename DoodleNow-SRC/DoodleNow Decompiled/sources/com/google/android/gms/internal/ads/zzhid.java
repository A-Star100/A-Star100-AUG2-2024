package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public class zzhid extends zzhig implements zzasc {
    zzasd zza;
    protected final String zzb = "moov";

    public zzhid(String str) {
    }

    public final String zza() {
        return this.zzb;
    }

    public final void zzb(zzhih zzhih, ByteBuffer byteBuffer, long j, zzarz zzarz) throws IOException {
        zzhih.zzb();
        byteBuffer.remaining();
        byteBuffer.remaining();
        this.zzd = zzhih;
        this.zzf = zzhih.zzb();
        zzhih.zze(zzhih.zzb() + j);
        this.zzg = zzhih.zzb();
        this.zzc = zzarz;
    }

    public final void zzc(zzasd zzasd) {
        this.zza = zzasd;
    }
}
