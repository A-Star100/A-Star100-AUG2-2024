package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
final class zzgyw extends zzgza {
    private final byte[] zza;
    private final int zzb;
    private int zzc;

    zzgyw(byte[] bArr, int i, int i2) {
        super((zzgyz) null);
        int length = bArr.length;
        if (((length - i2) | i2) >= 0) {
            this.zza = bArr;
            this.zzc = 0;
            this.zzb = i2;
            return;
        }
        throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(length), 0, Integer.valueOf(i2)}));
    }

    public final void zzL() {
    }

    public final void zzM(byte b) throws IOException {
        try {
            byte[] bArr = this.zza;
            int i = this.zzc;
            this.zzc = i + 1;
            bArr[i] = b;
        } catch (IndexOutOfBoundsException e) {
            throw new zzgyx(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1}), e);
        }
    }

    public final void zzN(int i, boolean z) throws IOException {
        zzu(i << 3);
        zzM(z ? (byte) 1 : 0);
    }

    public final void zzO(int i, zzgyj zzgyj) throws IOException {
        zzu((i << 3) | 2);
        zzu(zzgyj.zzd());
        zzgyj.zzo(this);
    }

    public final void zza(byte[] bArr, int i, int i2) throws IOException {
        zze(bArr, i, i2);
    }

    public final int zzb() {
        return this.zzb - this.zzc;
    }

    public final void zze(byte[] bArr, int i, int i2) throws IOException {
        try {
            System.arraycopy(bArr, i, this.zza, this.zzc, i2);
            this.zzc += i2;
        } catch (IndexOutOfBoundsException e) {
            throw new zzgyx(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), Integer.valueOf(i2)}), e);
        }
    }

    public final void zzh(int i, int i2) throws IOException {
        zzu((i << 3) | 5);
        zzi(i2);
    }

    public final void zzi(int i) throws IOException {
        try {
            byte[] bArr = this.zza;
            int i2 = this.zzc;
            bArr[i2] = (byte) (i & 255);
            bArr[i2 + 1] = (byte) ((i >> 8) & 255);
            bArr[i2 + 2] = (byte) ((i >> 16) & 255);
            this.zzc = i2 + 4;
            bArr[i2 + 3] = (byte) ((i >> 24) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new zzgyx(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1}), e);
        }
    }

    public final void zzj(int i, long j) throws IOException {
        zzu((i << 3) | 1);
        zzk(j);
    }

    public final void zzk(long j) throws IOException {
        try {
            byte[] bArr = this.zza;
            int i = this.zzc;
            bArr[i] = (byte) (((int) j) & 255);
            bArr[i + 1] = (byte) (((int) (j >> 8)) & 255);
            bArr[i + 2] = (byte) (((int) (j >> 16)) & 255);
            bArr[i + 3] = (byte) (((int) (j >> 24)) & 255);
            bArr[i + 4] = (byte) (((int) (j >> 32)) & 255);
            bArr[i + 5] = (byte) (((int) (j >> 40)) & 255);
            bArr[i + 6] = (byte) (((int) (j >> 48)) & 255);
            this.zzc = i + 8;
            bArr[i + 7] = (byte) (((int) (j >> 56)) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new zzgyx(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1}), e);
        }
    }

    public final void zzl(int i, int i2) throws IOException {
        zzu(i << 3);
        zzm(i2);
    }

    public final void zzm(int i) throws IOException {
        if (i >= 0) {
            zzu(i);
        } else {
            zzw((long) i);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzn(int i, zzhbl zzhbl, zzhcg zzhcg) throws IOException {
        zzu((i << 3) | 2);
        zzu(((zzgxq) zzhbl).zzaM(zzhcg));
        zzhcg.zzm(zzhbl, this.zze);
    }

    public final void zzo(int i, zzhbl zzhbl) throws IOException {
        zzu(11);
        zzt(2, i);
        zzu(26);
        zzu(zzhbl.zzaY());
        zzhbl.zzda(this);
        zzu(12);
    }

    public final void zzp(int i, zzgyj zzgyj) throws IOException {
        zzu(11);
        zzt(2, i);
        zzO(3, zzgyj);
        zzu(12);
    }

    public final void zzq(int i, String str) throws IOException {
        zzu((i << 3) | 2);
        zzr(str);
    }

    public final void zzr(String str) throws IOException {
        int i = this.zzc;
        try {
            int zzD = zzD(str.length() * 3);
            int zzD2 = zzD(str.length());
            if (zzD2 == zzD) {
                int i2 = i + zzD2;
                this.zzc = i2;
                int zzd = zzhdm.zzd(str, this.zza, i2, this.zzb - i2);
                this.zzc = i;
                zzu((zzd - i) - zzD2);
                this.zzc = zzd;
                return;
            }
            zzu(zzhdm.zze(str));
            byte[] bArr = this.zza;
            int i3 = this.zzc;
            this.zzc = zzhdm.zzd(str, bArr, i3, this.zzb - i3);
        } catch (zzhdl e) {
            this.zzc = i;
            zzH(str, e);
        } catch (IndexOutOfBoundsException e2) {
            throw new zzgyx(e2);
        }
    }

    public final void zzs(int i, int i2) throws IOException {
        zzu((i << 3) | i2);
    }

    public final void zzt(int i, int i2) throws IOException {
        zzu(i << 3);
        zzu(i2);
    }

    public final void zzv(int i, long j) throws IOException {
        zzu(i << 3);
        zzw(j);
    }

    public final void zzu(int i) throws IOException {
        while ((i & -128) != 0) {
            byte[] bArr = this.zza;
            int i2 = this.zzc;
            this.zzc = i2 + 1;
            bArr[i2] = (byte) ((i | 128) & 255);
            i >>>= 7;
        }
        try {
            byte[] bArr2 = this.zza;
            int i3 = this.zzc;
            this.zzc = i3 + 1;
            bArr2[i3] = (byte) i;
        } catch (IndexOutOfBoundsException e) {
            throw new zzgyx(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1}), e);
        }
    }

    public final void zzw(long j) throws IOException {
        if (!zzgza.zzb || this.zzb - this.zzc < 10) {
            while ((j & -128) != 0) {
                byte[] bArr = this.zza;
                int i = this.zzc;
                this.zzc = i + 1;
                bArr[i] = (byte) ((((int) j) | 128) & 255);
                j >>>= 7;
            }
            try {
                byte[] bArr2 = this.zza;
                int i2 = this.zzc;
                this.zzc = i2 + 1;
                bArr2[i2] = (byte) ((int) j);
            } catch (IndexOutOfBoundsException e) {
                throw new zzgyx(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1}), e);
            }
        } else {
            while (true) {
                int i3 = (int) j;
                if ((j & -128) == 0) {
                    byte[] bArr3 = this.zza;
                    int i4 = this.zzc;
                    this.zzc = i4 + 1;
                    zzhdh.zzq(bArr3, (long) i4, (byte) i3);
                    return;
                }
                byte[] bArr4 = this.zza;
                int i5 = this.zzc;
                this.zzc = i5 + 1;
                zzhdh.zzq(bArr4, (long) i5, (byte) ((i3 | 128) & 255));
                j >>>= 7;
            }
        }
    }
}
