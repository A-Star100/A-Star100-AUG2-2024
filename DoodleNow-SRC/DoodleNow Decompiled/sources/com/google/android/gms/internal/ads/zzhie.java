package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public abstract class zzhie extends zzhic implements zzasc {
    private int zza;

    protected zzhie(String str) {
        super("mvhd");
    }

    public final int zzh() {
        if (!this.zzc) {
            zzg();
        }
        return this.zza;
    }

    /* access modifiers changed from: protected */
    public final long zzi(ByteBuffer byteBuffer) {
        this.zza = zzasb.zzc(byteBuffer.get());
        zzasb.zzd(byteBuffer);
        byteBuffer.get();
        return 4;
    }
}
