package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public abstract class zzhic implements zzasc {
    private static final zzhin zza = zzhin.zzb(zzhic.class);
    protected final String zzb;
    boolean zzc;
    boolean zzd;
    long zze;
    long zzf = -1;
    zzhih zzg;
    private zzasd zzh;
    private ByteBuffer zzi;
    private ByteBuffer zzj = null;

    protected zzhic(String str) {
        this.zzb = str;
        this.zzd = true;
        this.zzc = true;
    }

    private final synchronized void zzd() {
        String str;
        if (!this.zzd) {
            try {
                zzhin zzhin = zza;
                String str2 = this.zzb;
                if (str2.length() != 0) {
                    str = "mem mapping ".concat(str2);
                } else {
                    str = new String("mem mapping ");
                }
                zzhin.zza(str);
                this.zzi = this.zzg.zzd(this.zze, this.zzf);
                this.zzd = true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public final String zza() {
        return this.zzb;
    }

    public final void zzb(zzhih zzhih, ByteBuffer byteBuffer, long j, zzarz zzarz) throws IOException {
        this.zze = zzhih.zzb();
        byteBuffer.remaining();
        this.zzf = j;
        this.zzg = zzhih;
        zzhih.zze(zzhih.zzb() + j);
        this.zzd = false;
        this.zzc = false;
        zzg();
    }

    public final void zzc(zzasd zzasd) {
        this.zzh = zzasd;
    }

    /* access modifiers changed from: protected */
    public abstract void zzf(ByteBuffer byteBuffer);

    public final synchronized void zzg() {
        String str;
        zzd();
        zzhin zzhin = zza;
        String str2 = this.zzb;
        if (str2.length() != 0) {
            str = "parsing details of ".concat(str2);
        } else {
            str = new String("parsing details of ");
        }
        zzhin.zza(str);
        ByteBuffer byteBuffer = this.zzi;
        if (byteBuffer != null) {
            this.zzc = true;
            byteBuffer.rewind();
            zzf(byteBuffer);
            if (byteBuffer.remaining() > 0) {
                this.zzj = byteBuffer.slice();
            }
            this.zzi = null;
        }
    }
}
