package com.google.android.gms.internal.ads;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzagg {
    private final ByteArrayOutputStream zza;
    private final DataOutputStream zzb;

    public zzagg() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.zza = byteArrayOutputStream;
        this.zzb = new DataOutputStream(byteArrayOutputStream);
    }

    private static void zzb(DataOutputStream dataOutputStream, String str) throws IOException {
        dataOutputStream.writeBytes(str);
        dataOutputStream.writeByte(0);
    }

    public final byte[] zza(zzagf zzagf) {
        this.zza.reset();
        try {
            zzb(this.zzb, zzagf.zza);
            String str = zzagf.zzb;
            if (str == null) {
                str = "";
            }
            zzb(this.zzb, str);
            this.zzb.writeLong(zzagf.zzc);
            this.zzb.writeLong(zzagf.zzd);
            this.zzb.write(zzagf.zze);
            this.zzb.flush();
            return this.zza.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
