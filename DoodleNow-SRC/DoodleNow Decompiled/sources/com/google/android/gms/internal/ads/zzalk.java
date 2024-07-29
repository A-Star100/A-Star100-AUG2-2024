package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.exoplayer2.C;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzalk implements zzaem {
    private final zzaem zza;
    private final zzalf zzb;
    private final zzaky zzc = new zzaky();
    private final zzfo zzd = new zzfo();
    private int zze = 0;
    private int zzf = 0;
    private byte[] zzg = zzfx.zzf;
    private zzalh zzh;
    private zzam zzi;

    public zzalk(zzaem zzaem, zzalf zzalf) {
        this.zza = zzaem;
        this.zzb = zzalf;
    }

    private final void zzb(int i) {
        byte[] bArr;
        int length = this.zzg.length;
        int i2 = this.zzf;
        if (length - i2 < i) {
            int i3 = i2 - this.zze;
            int max = Math.max(i3 + i3, i + i3);
            byte[] bArr2 = this.zzg;
            if (max <= bArr2.length) {
                bArr = bArr2;
            } else {
                bArr = new byte[max];
            }
            System.arraycopy(bArr2, this.zze, bArr, 0, i3);
            this.zze = 0;
            this.zzf = i3;
            this.zzg = bArr;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(long j, int i, zzakz zzakz) {
        zzek.zzb(this.zzi);
        zzfzn<zzec> zzfzn = zzakz.zza;
        long j2 = zzakz.zzc;
        ArrayList arrayList = new ArrayList(zzfzn.size());
        for (zzec zza2 : zzfzn) {
            arrayList.add(zza2.zza());
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("c", arrayList);
        bundle.putLong("d", j2);
        Parcel obtain = Parcel.obtain();
        obtain.writeBundle(bundle);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        zzfo zzfo = this.zzd;
        int length = marshall.length;
        zzfo.zzI(marshall, length);
        this.zza.zzq(this.zzd, length);
        int i2 = i & Integer.MAX_VALUE;
        long j3 = zzakz.zzb;
        if (j3 == C.TIME_UNSET) {
            zzek.zzf(this.zzi.zzq == Long.MAX_VALUE);
        } else {
            long j4 = this.zzi.zzq;
            j = j4 == Long.MAX_VALUE ? j + j3 : j3 + j4;
        }
        this.zza.zzs(j, i2, length, 0, (zzael) null);
    }

    public final /* synthetic */ int zzf(zzu zzu, int i, boolean z) {
        return zzaek.zza(this, zzu, i, z);
    }

    public final int zzg(zzu zzu, int i, boolean z, int i2) throws IOException {
        if (this.zzh == null) {
            return this.zza.zzg(zzu, i, z, 0);
        }
        zzb(i);
        int zza2 = zzu.zza(this.zzg, this.zzf, i);
        if (zza2 != -1) {
            this.zzf += zza2;
            return zza2;
        } else if (z) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    public final void zzl(zzam zzam) {
        String str = zzam.zzm;
        str.getClass();
        zzek.zzd(zzcb.zzb(str) == 3);
        if (!zzam.equals(this.zzi)) {
            this.zzi = zzam;
            this.zzh = this.zzb.zzc(zzam) ? this.zzb.zzb(zzam) : null;
        }
        if (this.zzh == null) {
            this.zza.zzl(zzam);
            return;
        }
        zzaem zzaem = this.zza;
        zzak zzb2 = zzam.zzb();
        zzb2.zzW("application/x-media3-cues");
        zzb2.zzz(zzam.zzm);
        zzb2.zzaa(Long.MAX_VALUE);
        zzb2.zzD(this.zzb.zza(zzam));
        zzaem.zzl(zzb2.zzac());
    }

    public final /* synthetic */ void zzq(zzfo zzfo, int i) {
        zzaek.zzb(this, zzfo, i);
    }

    public final void zzr(zzfo zzfo, int i, int i2) {
        if (this.zzh == null) {
            this.zza.zzr(zzfo, i, i2);
            return;
        }
        zzb(i);
        zzfo.zzG(this.zzg, this.zzf, i);
        this.zzf += i;
    }

    public final void zzs(long j, int i, int i2, int i3, zzael zzael) {
        if (this.zzh == null) {
            this.zza.zzs(j, i, i2, i3, zzael);
            return;
        }
        zzek.zze(zzael == null, "DRM on subtitles is not supported");
        int i4 = (this.zzf - i3) - i2;
        this.zzh.zza(this.zzg, i4, i2, zzalg.zza(), new zzalj(this, j, i));
        int i5 = i4 + i2;
        this.zze = i5;
        if (i5 == this.zzf) {
            this.zze = 0;
            this.zzf = 0;
        }
    }
}
