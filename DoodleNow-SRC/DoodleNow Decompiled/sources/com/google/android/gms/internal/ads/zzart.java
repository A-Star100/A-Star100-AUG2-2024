package com.google.android.gms.internal.ads;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzart extends ByteArrayOutputStream {
    private final zzarh zza;

    public zzart(zzarh zzarh, int i) {
        this.zza = zzarh;
        this.buf = zzarh.zzb(Math.max(i, 256));
    }

    private final void zza(int i) {
        if (this.count + i > this.buf.length) {
            zzarh zzarh = this.zza;
            int i2 = this.count + i;
            byte[] zzb = zzarh.zzb(i2 + i2);
            System.arraycopy(this.buf, 0, zzb, 0, this.count);
            this.zza.zza(this.buf);
            this.buf = zzb;
        }
    }

    public final void close() throws IOException {
        this.zza.zza(this.buf);
        this.buf = null;
        super.close();
    }

    public final void finalize() {
        this.zza.zza(this.buf);
    }

    public final synchronized void write(int i) {
        zza(1);
        super.write(i);
    }

    public final synchronized void write(byte[] bArr, int i, int i2) {
        zza(i2);
        super.write(bArr, i, i2);
    }
}
