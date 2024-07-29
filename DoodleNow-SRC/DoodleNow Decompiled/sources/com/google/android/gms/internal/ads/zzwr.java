package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzwr {
    private final zzfo zza = new zzfo(32);
    private zzwq zzb;
    private zzwq zzc;
    private zzwq zzd;
    private long zze;
    private final zzzo zzf;

    public zzwr(zzzo zzzo) {
        this.zzf = zzzo;
        zzwq zzwq = new zzwq(0, 65536);
        this.zzb = zzwq;
        this.zzc = zzwq;
        this.zzd = zzwq;
    }

    private final int zzi(int i) {
        zzwq zzwq = this.zzd;
        if (zzwq.zzc == null) {
            zzzh zzb2 = this.zzf.zzb();
            zzwq zzwq2 = new zzwq(this.zzd.zzb, 65536);
            zzwq.zzc = zzb2;
            zzwq.zzd = zzwq2;
        }
        return Math.min(i, (int) (this.zzd.zzb - this.zze));
    }

    private static zzwq zzj(zzwq zzwq, long j) {
        while (j >= zzwq.zzb) {
            zzwq = zzwq.zzd;
        }
        return zzwq;
    }

    private static zzwq zzk(zzwq zzwq, long j, ByteBuffer byteBuffer, int i) {
        zzwq zzj = zzj(zzwq, j);
        while (i > 0) {
            int min = Math.min(i, (int) (zzj.zzb - j));
            byteBuffer.put(zzj.zzc.zza, zzj.zza(j), min);
            i -= min;
            j += (long) min;
            if (j == zzj.zzb) {
                zzj = zzj.zzd;
            }
        }
        return zzj;
    }

    private static zzwq zzl(zzwq zzwq, long j, byte[] bArr, int i) {
        zzwq zzj = zzj(zzwq, j);
        int i2 = i;
        while (i2 > 0) {
            int min = Math.min(i2, (int) (zzj.zzb - j));
            System.arraycopy(zzj.zzc.zza, zzj.zza(j), bArr, i - i2, min);
            i2 -= min;
            j += (long) min;
            if (j == zzj.zzb) {
                zzj = zzj.zzd;
            }
        }
        return zzj;
    }

    private static zzwq zzm(zzwq zzwq, zzih zzih, zzwt zzwt, zzfo zzfo) {
        zzwq zzwq2;
        zzih zzih2 = zzih;
        zzwt zzwt2 = zzwt;
        zzfo zzfo2 = zzfo;
        if (zzih.zzk()) {
            long j = zzwt2.zzb;
            int i = 1;
            zzfo2.zzH(1);
            zzwq zzl = zzl(zzwq, j, zzfo.zzM(), 1);
            long j2 = j + 1;
            byte b = zzfo.zzM()[0];
            byte b2 = b & 128;
            byte b3 = b & Byte.MAX_VALUE;
            zzie zzie = zzih2.zzb;
            byte[] bArr = zzie.zza;
            if (bArr == null) {
                zzie.zza = new byte[16];
            } else {
                Arrays.fill(bArr, (byte) 0);
            }
            boolean z = b2 != 0;
            zzwq2 = zzl(zzl, j2, zzie.zza, b3);
            long j3 = j2 + ((long) b3);
            if (z) {
                zzfo2.zzH(2);
                zzwq2 = zzl(zzwq2, j3, zzfo.zzM(), 2);
                j3 += 2;
                i = zzfo.zzq();
            }
            int i2 = i;
            int[] iArr = zzie.zzd;
            if (iArr == null || iArr.length < i2) {
                iArr = new int[i2];
            }
            int[] iArr2 = iArr;
            int[] iArr3 = zzie.zze;
            if (iArr3 == null || iArr3.length < i2) {
                iArr3 = new int[i2];
            }
            int[] iArr4 = iArr3;
            if (z) {
                int i3 = i2 * 6;
                zzfo2.zzH(i3);
                zzwq2 = zzl(zzwq2, j3, zzfo.zzM(), i3);
                j3 += (long) i3;
                zzfo2.zzK(0);
                for (int i4 = 0; i4 < i2; i4++) {
                    iArr2[i4] = zzfo.zzq();
                    iArr4[i4] = zzfo.zzp();
                }
            } else {
                iArr2[0] = 0;
                iArr4[0] = zzwt2.zza - ((int) (j3 - zzwt2.zzb));
            }
            zzael zzael = zzwt2.zzc;
            int i5 = zzfx.zza;
            zzie.zzc(i2, iArr2, iArr4, zzael.zzb, zzie.zza, zzael.zza, zzael.zzc, zzael.zzd);
            long j4 = zzwt2.zzb;
            int i6 = (int) (j3 - j4);
            zzwt2.zzb = j4 + ((long) i6);
            zzwt2.zza -= i6;
        } else {
            zzwq2 = zzwq;
        }
        if (zzih.zze()) {
            zzfo2.zzH(4);
            zzwq zzl2 = zzl(zzwq2, zzwt2.zzb, zzfo.zzM(), 4);
            int zzp = zzfo.zzp();
            zzwt2.zzb += 4;
            zzwt2.zza -= 4;
            zzih2.zzi(zzp);
            zzwq zzk = zzk(zzl2, zzwt2.zzb, zzih2.zzc, zzp);
            zzwt2.zzb += (long) zzp;
            int i7 = zzwt2.zza - zzp;
            zzwt2.zza = i7;
            ByteBuffer byteBuffer = zzih2.zzf;
            if (byteBuffer == null || byteBuffer.capacity() < i7) {
                zzih2.zzf = ByteBuffer.allocate(i7);
            } else {
                zzih2.zzf.clear();
            }
            return zzk(zzk, zzwt2.zzb, zzih2.zzf, zzwt2.zza);
        }
        zzih2.zzi(zzwt2.zza);
        return zzk(zzwq2, zzwt2.zzb, zzih2.zzc, zzwt2.zza);
    }

    private final void zzn(int i) {
        long j = this.zze + ((long) i);
        this.zze = j;
        zzwq zzwq = this.zzd;
        if (j == zzwq.zzb) {
            this.zzd = zzwq.zzd;
        }
    }

    public final int zza(zzu zzu, int i, boolean z) throws IOException {
        int zzi = zzi(i);
        zzwq zzwq = this.zzd;
        int zza2 = zzu.zza(zzwq.zzc.zza, zzwq.zza(this.zze), zzi);
        if (zza2 != -1) {
            zzn(zza2);
            return zza2;
        } else if (z) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    public final long zzb() {
        return this.zze;
    }

    public final void zzc(long j) {
        zzwq zzwq;
        if (j != -1) {
            while (true) {
                zzwq = this.zzb;
                if (j < zzwq.zzb) {
                    break;
                }
                this.zzf.zzc(zzwq.zzc);
                this.zzb = this.zzb.zzb();
            }
            if (this.zzc.zza < zzwq.zza) {
                this.zzc = zzwq;
            }
        }
    }

    public final void zzd(zzih zzih, zzwt zzwt) {
        zzm(this.zzc, zzih, zzwt, this.zza);
    }

    public final void zze(zzih zzih, zzwt zzwt) {
        this.zzc = zzm(this.zzc, zzih, zzwt, this.zza);
    }

    public final void zzf() {
        zzwq zzwq = this.zzb;
        if (zzwq.zzc != null) {
            this.zzf.zzd(zzwq);
            zzwq.zzb();
        }
        this.zzb.zze(0, 65536);
        zzwq zzwq2 = this.zzb;
        this.zzc = zzwq2;
        this.zzd = zzwq2;
        this.zze = 0;
        this.zzf.zzg();
    }

    public final void zzg() {
        this.zzc = this.zzb;
    }

    public final void zzh(zzfo zzfo, int i) {
        while (i > 0) {
            int zzi = zzi(i);
            zzwq zzwq = this.zzd;
            zzfo.zzG(zzwq.zzc.zza, zzwq.zza(this.zze), zzi);
            i -= zzi;
            zzn(zzi);
        }
    }
}
