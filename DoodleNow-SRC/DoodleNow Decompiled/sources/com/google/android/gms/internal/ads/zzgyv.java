package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
abstract class zzgyv extends zzgza {
    final byte[] zza;
    final int zzb;
    int zzc;
    int zzd;

    zzgyv(int i) {
        super((zzgyz) null);
        if (i >= 0) {
            byte[] bArr = new byte[Math.max(i, 20)];
            this.zza = bArr;
            this.zzb = bArr.length;
            return;
        }
        throw new IllegalArgumentException("bufferSize must be >= 0");
    }

    public final int zzb() {
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
    }

    /* access modifiers changed from: package-private */
    public final void zzc(byte b) {
        int i = this.zzc;
        this.zzc = i + 1;
        this.zza[i] = b;
        this.zzd++;
    }

    /* access modifiers changed from: package-private */
    public final void zzd(int i) {
        int i2 = this.zzc;
        byte[] bArr = this.zza;
        bArr[i2] = (byte) (i & 255);
        bArr[i2 + 1] = (byte) ((i >> 8) & 255);
        bArr[i2 + 2] = (byte) ((i >> 16) & 255);
        this.zzc = i2 + 4;
        bArr[i2 + 3] = (byte) ((i >> 24) & 255);
        this.zzd += 4;
    }

    /* access modifiers changed from: package-private */
    public final void zze(long j) {
        int i = this.zzc;
        byte[] bArr = this.zza;
        bArr[i] = (byte) ((int) (j & 255));
        bArr[i + 1] = (byte) ((int) ((j >> 8) & 255));
        bArr[i + 2] = (byte) ((int) ((j >> 16) & 255));
        bArr[i + 3] = (byte) ((int) (255 & (j >> 24)));
        bArr[i + 4] = (byte) (((int) (j >> 32)) & 255);
        bArr[i + 5] = (byte) (((int) (j >> 40)) & 255);
        bArr[i + 6] = (byte) (((int) (j >> 48)) & 255);
        this.zzc = i + 8;
        bArr[i + 7] = (byte) (((int) (j >> 56)) & 255);
        this.zzd += 8;
    }

    /* access modifiers changed from: package-private */
    public final void zzf(int i) {
        if (zzgza.zzb) {
            long j = (long) this.zzc;
            while ((i & -128) != 0) {
                byte[] bArr = this.zza;
                int i2 = this.zzc;
                this.zzc = i2 + 1;
                zzhdh.zzq(bArr, (long) i2, (byte) ((i | 128) & 255));
                i >>>= 7;
            }
            byte[] bArr2 = this.zza;
            int i3 = this.zzc;
            this.zzc = i3 + 1;
            zzhdh.zzq(bArr2, (long) i3, (byte) i);
            this.zzd += (int) (((long) this.zzc) - j);
            return;
        }
        while ((i & -128) != 0) {
            byte[] bArr3 = this.zza;
            int i4 = this.zzc;
            this.zzc = i4 + 1;
            bArr3[i4] = (byte) ((i | 128) & 255);
            this.zzd++;
            i >>>= 7;
        }
        byte[] bArr4 = this.zza;
        int i5 = this.zzc;
        this.zzc = i5 + 1;
        bArr4[i5] = (byte) i;
        this.zzd++;
    }

    /* access modifiers changed from: package-private */
    public final void zzg(long j) {
        if (zzgza.zzb) {
            long j2 = (long) this.zzc;
            while (true) {
                int i = (int) j;
                if ((j & -128) == 0) {
                    byte[] bArr = this.zza;
                    int i2 = this.zzc;
                    this.zzc = i2 + 1;
                    zzhdh.zzq(bArr, (long) i2, (byte) i);
                    this.zzd += (int) (((long) this.zzc) - j2);
                    return;
                }
                byte[] bArr2 = this.zza;
                int i3 = this.zzc;
                this.zzc = i3 + 1;
                zzhdh.zzq(bArr2, (long) i3, (byte) ((i | 128) & 255));
                j >>>= 7;
            }
        } else {
            while (true) {
                int i4 = (int) j;
                if ((j & -128) == 0) {
                    byte[] bArr3 = this.zza;
                    int i5 = this.zzc;
                    this.zzc = i5 + 1;
                    bArr3[i5] = (byte) i4;
                    this.zzd++;
                    return;
                }
                byte[] bArr4 = this.zza;
                int i6 = this.zzc;
                this.zzc = i6 + 1;
                bArr4[i6] = (byte) ((i4 | 128) & 255);
                this.zzd++;
                j >>>= 7;
            }
        }
    }
}
