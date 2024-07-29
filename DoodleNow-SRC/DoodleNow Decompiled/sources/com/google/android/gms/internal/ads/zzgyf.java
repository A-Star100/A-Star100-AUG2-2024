package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
class zzgyf extends zzgye {
    protected final byte[] zza;

    zzgyf(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgyj) || zzd() != ((zzgyj) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzgyf)) {
            return obj.equals(this);
        }
        zzgyf zzgyf = (zzgyf) obj;
        int zzr = zzr();
        int zzr2 = zzgyf.zzr();
        if (zzr == 0 || zzr2 == 0 || zzr == zzr2) {
            return zzg(zzgyf, 0, zzd());
        }
        return false;
    }

    public byte zza(int i) {
        return this.zza[i];
    }

    /* access modifiers changed from: package-private */
    public byte zzb(int i) {
        return this.zza[i];
    }

    /* access modifiers changed from: protected */
    public int zzc() {
        return 0;
    }

    public int zzd() {
        return this.zza.length;
    }

    /* access modifiers changed from: protected */
    public void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zza, i, bArr, i2, i3);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzg(zzgyj zzgyj, int i, int i2) {
        if (i2 <= zzgyj.zzd()) {
            int i3 = i + i2;
            if (i3 > zzgyj.zzd()) {
                int zzd = zzgyj.zzd();
                throw new IllegalArgumentException("Ran off end of other: " + i + ", " + i2 + ", " + zzd);
            } else if (!(zzgyj instanceof zzgyf)) {
                return zzgyj.zzk(i, i3).equals(zzk(0, i2));
            } else {
                zzgyf zzgyf = (zzgyf) zzgyj;
                byte[] bArr = this.zza;
                byte[] bArr2 = zzgyf.zza;
                int zzc = zzc() + i2;
                int zzc2 = zzc();
                int zzc3 = zzgyf.zzc() + i;
                while (zzc2 < zzc) {
                    if (bArr[zzc2] != bArr2[zzc3]) {
                        return false;
                    }
                    zzc2++;
                    zzc3++;
                }
                return true;
            }
        } else {
            int zzd2 = zzd();
            throw new IllegalArgumentException("Length too large: " + i2 + zzd2);
        }
    }

    /* access modifiers changed from: protected */
    public final int zzi(int i, int i2, int i3) {
        return zzhai.zzb(i, this.zza, zzc() + i2, i3);
    }

    /* access modifiers changed from: protected */
    public final int zzj(int i, int i2, int i3) {
        int zzc = zzc() + i2;
        return zzhdm.zzf(i, this.zza, zzc, i3 + zzc);
    }

    public final zzgyj zzk(int i, int i2) {
        int zzq = zzq(i, i2, zzd());
        if (zzq == 0) {
            return zzgyj.zzb;
        }
        return new zzgyc(this.zza, zzc() + i, zzq);
    }

    public final zzgyt zzl() {
        return zzgyt.zzJ(this.zza, zzc(), zzd(), true);
    }

    /* access modifiers changed from: protected */
    public final String zzm(Charset charset) {
        return new String(this.zza, zzc(), zzd(), charset);
    }

    public final ByteBuffer zzn() {
        return ByteBuffer.wrap(this.zza, zzc(), zzd()).asReadOnlyBuffer();
    }

    /* access modifiers changed from: package-private */
    public final void zzo(zzgxy zzgxy) throws IOException {
        zzgxy.zza(this.zza, zzc(), zzd());
    }

    public final boolean zzp() {
        int zzc = zzc();
        return zzhdm.zzj(this.zza, zzc, zzd() + zzc);
    }
}
