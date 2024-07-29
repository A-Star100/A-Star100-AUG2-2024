package com.google.android.gms.internal.ads;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0;
import com.amazon.a.a.o.b.f;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzye extends zzyt implements Comparable {
    private final int zze;
    private final boolean zzf;
    private final String zzg;
    private final zzyl zzh;
    private final boolean zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final boolean zzm;
    private final int zzn;
    private final int zzo;
    private final boolean zzp;
    private final int zzq;
    private final int zzr;
    private final int zzs;
    private final int zzt;
    private final boolean zzu;
    private final boolean zzv;

    public zzye(int i, zzcz zzcz, int i2, zzyl zzyl, int i3, boolean z, zzfws zzfws, int i4) {
        super(i, zzcz, i2);
        int i5;
        int i6;
        String[] strArr;
        int i7;
        boolean z2;
        this.zzh = zzyl;
        int i8 = 1;
        int i9 = true != zzyl.zzR ? 16 : 24;
        boolean z3 = zzyl.zzN;
        this.zzg = zzyx.zzh(this.zzd.zzd);
        this.zzi = zzyx.zzo(i3, false);
        int i10 = 0;
        while (true) {
            i5 = Integer.MAX_VALUE;
            if (i10 >= zzyl.zzq.size()) {
                i6 = 0;
                i10 = Integer.MAX_VALUE;
                break;
            }
            i6 = zzyx.zzc(this.zzd, (String) zzyl.zzq.get(i10), false);
            if (i6 > 0) {
                break;
            }
            i10++;
        }
        this.zzk = i10;
        this.zzj = i6;
        int i11 = this.zzd.zzf;
        int i12 = zzyl.zzr;
        this.zzl = zzyx.zzb(i11, 0);
        zzam zzam = this.zzd;
        int i13 = zzam.zzf;
        this.zzm = i13 == 0 || (i13 & 1) != 0;
        this.zzp = 1 == (zzam.zze & 1);
        this.zzq = zzam.zzz;
        this.zzr = zzam.zzA;
        this.zzs = zzam.zzi;
        if (zzam.zzi != -1) {
            int i14 = zzyl.zzt;
        }
        if (zzam.zzz != -1) {
            int i15 = zzyl.zzs;
        }
        this.zzf = zzfws.zza(zzam);
        Configuration configuration = Resources.getSystem().getConfiguration();
        if (zzfx.zza >= 24) {
            strArr = ComponentDialog$$ExternalSyntheticApiModelOutline0.m(ComponentDialog$$ExternalSyntheticApiModelOutline0.m(configuration)).split(f.a, -1);
        } else {
            strArr = new String[]{configuration.locale.toLanguageTag()};
        }
        for (int i16 = 0; i16 < strArr.length; i16++) {
            strArr[i16] = zzfx.zzD(strArr[i16]);
        }
        int i17 = 0;
        while (true) {
            if (i17 >= strArr.length) {
                i7 = 0;
                i17 = Integer.MAX_VALUE;
                break;
            }
            i7 = zzyx.zzc(this.zzd, strArr[i17], false);
            if (i7 > 0) {
                break;
            }
            i17++;
        }
        this.zzn = i17;
        this.zzo = i7;
        int i18 = 0;
        while (true) {
            if (i18 < zzyl.zzu.size()) {
                String str = this.zzd.zzm;
                if (str != null && str.equals(zzyl.zzu.get(i18))) {
                    i5 = i18;
                    break;
                }
                i18++;
            } else {
                break;
            }
        }
        this.zzt = i5;
        this.zzu = (i3 & BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT) == 128;
        this.zzv = (i3 & 64) == 64;
        zzyl zzyl2 = this.zzh;
        if (zzyx.zzo(i3, zzyl2.zzT) && ((z2 = this.zzf) || zzyl2.zzM)) {
            zzde zzde = zzyl2.zzv;
            if (zzyx.zzo(i3, false) && z2 && this.zzd.zzi != -1) {
                boolean z4 = zzyl2.zzC;
                boolean z5 = zzyl2.zzB;
                if ((zzyl2.zzV || !z) && (i9 & i3) != 0) {
                    i8 = 2;
                }
            }
        } else {
            i8 = 0;
        }
        this.zze = i8;
    }

    /* renamed from: zza */
    public final int compareTo(zzye zzye) {
        zzgay zza = (!this.zzf || !this.zzi) ? zzyx.zzb.zza() : zzyx.zzb;
        zzfzc zzd = zzfzc.zzk().zze(this.zzi, zzye.zzi).zzd(Integer.valueOf(this.zzk), Integer.valueOf(zzye.zzk), zzgay.zzc().zza()).zzb(this.zzj, zzye.zzj).zzb(this.zzl, zzye.zzl).zze(this.zzp, zzye.zzp).zze(this.zzm, zzye.zzm).zzd(Integer.valueOf(this.zzn), Integer.valueOf(zzye.zzn), zzgay.zzc().zza()).zzb(this.zzo, zzye.zzo).zze(this.zzf, zzye.zzf).zzd(Integer.valueOf(this.zzt), Integer.valueOf(zzye.zzt), zzgay.zzc().zza());
        boolean z = this.zzh.zzB;
        zzfzc zzd2 = zzd.zze(this.zzu, zzye.zzu).zze(this.zzv, zzye.zzv).zzd(Integer.valueOf(this.zzq), Integer.valueOf(zzye.zzq), zza).zzd(Integer.valueOf(this.zzr), Integer.valueOf(zzye.zzr), zza);
        if (zzfx.zzG(this.zzg, zzye.zzg)) {
            zzd2 = zzd2.zzd(Integer.valueOf(this.zzs), Integer.valueOf(zzye.zzs), zza);
        }
        return zzd2.zza();
    }

    public final int zzb() {
        return this.zze;
    }

    public final /* bridge */ /* synthetic */ boolean zzc(zzyt zzyt) {
        String str;
        zzye zzye = (zzye) zzyt;
        boolean z = this.zzh.zzP;
        zzam zzam = this.zzd;
        int i = zzam.zzz;
        if (i == -1) {
            return false;
        }
        zzam zzam2 = zzye.zzd;
        if (i != zzam2.zzz || (str = zzam.zzm) == null || !TextUtils.equals(str, zzam2.zzm)) {
            return false;
        }
        zzyl zzyl = this.zzh;
        boolean z2 = zzyl.zzO;
        int i2 = this.zzd.zzA;
        if (i2 == -1 || i2 != zzye.zzd.zzA) {
            return false;
        }
        boolean z3 = zzyl.zzQ;
        return this.zzu == zzye.zzu && this.zzv == zzye.zzv;
    }
}
