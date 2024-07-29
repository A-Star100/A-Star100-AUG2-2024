package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzsa extends zzdu {
    private static final int zzd = Float.floatToIntBits(Float.NaN);

    zzsa() {
    }

    private static void zzo(int i, ByteBuffer byteBuffer) {
        int floatToIntBits = Float.floatToIntBits((float) (((double) i) * 4.656612875245797E-10d));
        if (floatToIntBits == zzd) {
            floatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(floatToIntBits);
    }

    public final void zze(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        int i2 = this.zzb.zzd;
        if (i2 == 21) {
            byteBuffer2 = zzj((i / 3) * 4);
            while (position < limit) {
                zzo(((byteBuffer.get(position) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << Ascii.DLE) | ((byteBuffer.get(position + 2) & 255) << Ascii.CAN), byteBuffer2);
                position += 3;
            }
        } else if (i2 == 22) {
            byteBuffer2 = zzj(i);
            while (position < limit) {
                zzo((byteBuffer.get(position) & 255) | ((byteBuffer.get(position + 1) & 255) << 8) | ((byteBuffer.get(position + 2) & 255) << Ascii.DLE) | ((byteBuffer.get(position + 3) & 255) << Ascii.CAN), byteBuffer2);
                position += 4;
            }
        } else if (i2 == 1342177280) {
            byteBuffer2 = zzj((i / 3) * 4);
            while (position < limit) {
                zzo(((byteBuffer.get(position + 2) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << Ascii.DLE) | ((byteBuffer.get(position) & 255) << Ascii.CAN), byteBuffer2);
                position += 3;
            }
        } else if (i2 == 1610612736) {
            byteBuffer2 = zzj(i);
            while (position < limit) {
                zzo((byteBuffer.get(position + 3) & 255) | ((byteBuffer.get(position + 2) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << Ascii.DLE) | ((byteBuffer.get(position) & 255) << Ascii.CAN), byteBuffer2);
                position += 4;
            }
        } else {
            throw new IllegalStateException();
        }
        byteBuffer.position(byteBuffer.limit());
        byteBuffer2.flip();
    }

    public final zzdr zzi(zzdr zzdr) throws zzds {
        int i = zzdr.zzd;
        int i2 = zzfx.zza;
        if (i == 21 || i == 1342177280 || i == 22 || i == 1610612736) {
            return new zzdr(zzdr.zzb, zzdr.zzc, 4);
        }
        if (i == 4) {
            return zzdr.zza;
        }
        throw new zzds("Unhandled input format:", zzdr);
    }
}
