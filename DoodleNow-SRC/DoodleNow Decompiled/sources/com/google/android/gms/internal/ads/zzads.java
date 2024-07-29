package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.audio.DtsUtil;
import com.google.android.exoplayer2.audio.OpusUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzads {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final long zzj;
    public final zzadr zzk;
    private final zzby zzl;

    private zzads(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, zzadr zzadr, zzby zzby) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = i5;
        this.zzf = zzi(i5);
        this.zzg = i6;
        this.zzh = i7;
        this.zzi = zzh(i7);
        this.zzj = j;
        this.zzk = zzadr;
        this.zzl = zzby;
    }

    public zzads(byte[] bArr, int i) {
        zzfn zzfn = new zzfn(bArr, bArr.length);
        zzfn.zzk(i * 8);
        this.zza = zzfn.zzd(16);
        this.zzb = zzfn.zzd(16);
        this.zzc = zzfn.zzd(24);
        this.zzd = zzfn.zzd(24);
        int zzd2 = zzfn.zzd(20);
        this.zze = zzd2;
        this.zzf = zzi(zzd2);
        this.zzg = zzfn.zzd(3) + 1;
        int zzd3 = zzfn.zzd(5) + 1;
        this.zzh = zzd3;
        this.zzi = zzh(zzd3);
        int zzd4 = zzfn.zzd(4);
        int zzd5 = zzfn.zzd(32);
        int i2 = zzfx.zza;
        this.zzj = ((((long) zzd4) & 4294967295L) << 32) | (((long) zzd5) & 4294967295L);
        this.zzk = null;
        this.zzl = null;
    }

    private static int zzh(int i) {
        if (i == 8) {
            return 1;
        }
        if (i == 12) {
            return 2;
        }
        if (i == 16) {
            return 4;
        }
        if (i != 20) {
            return i != 24 ? -1 : 6;
        }
        return 5;
    }

    private static int zzi(int i) {
        switch (i) {
            case 8000:
                return 4;
            case AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case 44100:
                return 9;
            case OpusUtil.SAMPLE_RATE:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case DtsUtil.DTS_MAX_RATE_BYTES_PER_SECOND:
                return 3;
            default:
                return -1;
        }
    }

    public final long zza() {
        long j = this.zzj;
        return j == 0 ? C.TIME_UNSET : (j * 1000000) / ((long) this.zze);
    }

    public final long zzb(long j) {
        return Math.max(0, Math.min((j * ((long) this.zze)) / 1000000, this.zzj - 1));
    }

    public final zzam zzc(byte[] bArr, zzby zzby) {
        bArr[4] = Byte.MIN_VALUE;
        zzby zzd2 = zzd(zzby);
        zzak zzak = new zzak();
        zzak.zzW(MimeTypes.AUDIO_FLAC);
        int i = this.zzd;
        if (i <= 0) {
            i = -1;
        }
        zzak.zzO(i);
        zzak.zzy(this.zzg);
        zzak.zzX(this.zze);
        zzak.zzQ(zzfx.zzl(this.zzh));
        zzak.zzL(Collections.singletonList(bArr));
        zzak.zzP(zzd2);
        return zzak.zzac();
    }

    public final zzby zzd(zzby zzby) {
        zzby zzby2 = this.zzl;
        return zzby2 == null ? zzby : zzby2.zzd(zzby);
    }

    public final zzads zze(List list) {
        return new zzads(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzg, this.zzh, this.zzj, this.zzk, zzd(new zzby(list)));
    }

    public final zzads zzf(zzadr zzadr) {
        return new zzads(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzg, this.zzh, this.zzj, zzadr, this.zzl);
    }

    public final zzads zzg(List list) {
        return new zzads(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzg, this.zzh, this.zzj, this.zzk, zzd(zzaes.zzb(list)));
    }
}
