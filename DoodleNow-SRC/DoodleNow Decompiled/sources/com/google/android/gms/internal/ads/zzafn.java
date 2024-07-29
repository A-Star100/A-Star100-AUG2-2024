package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzafn extends zzafs {
    private static final int[] zzb = {5512, 11025, 22050, 44100};
    private boolean zzc;
    private boolean zzd;
    private int zze;

    public zzafn(zzaem zzaem) {
        super(zzaem);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzfo zzfo) throws zzafr {
        if (!this.zzc) {
            int zzm = zzfo.zzm();
            int i = zzm >> 4;
            this.zze = i;
            if (i == 2) {
                int i2 = zzb[(zzm >> 2) & 3];
                zzak zzak = new zzak();
                zzak.zzW(MimeTypes.AUDIO_MPEG);
                zzak.zzy(1);
                zzak.zzX(i2);
                this.zza.zzl(zzak.zzac());
                this.zzd = true;
            } else if (i == 7 || i == 8) {
                zzak zzak2 = new zzak();
                zzak2.zzW(i == 7 ? MimeTypes.AUDIO_ALAW : MimeTypes.AUDIO_MLAW);
                zzak2.zzy(1);
                zzak2.zzX(8000);
                this.zza.zzl(zzak2.zzac());
                this.zzd = true;
            } else if (i != 10) {
                throw new zzafr("Audio format not supported: " + i);
            }
            this.zzc = true;
        } else {
            zzfo.zzL(1);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean zzb(zzfo zzfo, long j) throws zzcc {
        if (this.zze == 2) {
            int zzb2 = zzfo.zzb();
            this.zza.zzq(zzfo, zzb2);
            this.zza.zzs(j, 1, zzb2, 0, (zzael) null);
            return true;
        }
        int zzm = zzfo.zzm();
        if (zzm == 0 && !this.zzd) {
            int zzb3 = zzfo.zzb();
            byte[] bArr = new byte[zzb3];
            zzfo.zzG(bArr, 0, zzb3);
            zzaca zza = zzacb.zza(bArr);
            zzak zzak = new zzak();
            zzak.zzW(MimeTypes.AUDIO_AAC);
            zzak.zzz(zza.zzc);
            zzak.zzy(zza.zzb);
            zzak.zzX(zza.zza);
            zzak.zzL(Collections.singletonList(bArr));
            this.zza.zzl(zzak.zzac());
            this.zzd = true;
            return false;
        } else if (this.zze == 10 && zzm != 1) {
            return false;
        } else {
            int zzb4 = zzfo.zzb();
            this.zza.zzq(zzfo, zzb4);
            this.zza.zzs(j, 1, zzb4, 0, (zzael) null);
            return true;
        }
    }
}
