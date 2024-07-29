package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzqs extends zzdu {
    private int[] zzd;
    private int[] zze;

    zzqs() {
    }

    public final zzdr zzi(zzdr zzdr) throws zzds {
        int[] iArr = this.zzd;
        if (iArr == null) {
            return zzdr.zza;
        }
        if (zzdr.zzd == 2) {
            boolean z = zzdr.zzc != iArr.length;
            int i = 0;
            while (true) {
                int length = iArr.length;
                if (i >= length) {
                    return z ? new zzdr(zzdr.zzb, length, 2) : zzdr.zza;
                }
                int i2 = iArr[i];
                if (i2 < zzdr.zzc) {
                    z |= i2 != i;
                    i++;
                } else {
                    throw new zzds("Unhandled input format:", zzdr);
                }
            }
        } else {
            throw new zzds("Unhandled input format:", zzdr);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzk() {
        this.zze = this.zzd;
    }

    /* access modifiers changed from: protected */
    public final void zzm() {
        this.zze = null;
        this.zzd = null;
    }

    public final void zzo(int[] iArr) {
        this.zzd = iArr;
    }

    public final void zze(ByteBuffer byteBuffer) {
        int[] iArr = this.zze;
        iArr.getClass();
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        ByteBuffer zzj = zzj(((limit - position) / this.zzb.zze) * this.zzc.zze);
        while (position < limit) {
            for (int i : iArr) {
                zzj.putShort(byteBuffer.getShort(i + i + position));
            }
            position += this.zzb.zze;
        }
        byteBuffer.position(limit);
        zzj.flip();
    }
}
