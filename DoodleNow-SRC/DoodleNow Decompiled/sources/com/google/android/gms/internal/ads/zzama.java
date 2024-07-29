package com.google.android.gms.internal.ads;

import android.graphics.Color;
import android.text.TextUtils;
import com.amazon.a.a.o.b.f;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzama {
    public final String zza;
    public final int zzb;
    public final Integer zzc;
    public final Integer zzd;
    public final float zze;
    public final boolean zzf;
    public final boolean zzg;
    public final boolean zzh;
    public final boolean zzi;
    public final int zzj;

    private zzama(String str, int i, Integer num, Integer num2, float f, boolean z, boolean z2, boolean z3, boolean z4, int i2) {
        this.zza = str;
        this.zzb = i;
        this.zzc = num;
        this.zzd = num2;
        this.zze = f;
        this.zzf = z;
        this.zzg = z2;
        this.zzh = z3;
        this.zzi = z4;
        this.zzj = i2;
    }

    public static zzama zzb(String str, zzaly zzaly) {
        int i;
        String str2 = str;
        zzaly zzaly2 = zzaly;
        zzek.zzd(str2.startsWith("Style:"));
        String[] split = TextUtils.split(str2.substring(6), f.a);
        int length = split.length;
        int i2 = zzaly2.zzk;
        if (length != i2) {
            zzfe.zzf("SsaStyle", String.format(Locale.US, "Skipping malformed 'Style:' line (expected %s values, found %s): '%s'", new Object[]{Integer.valueOf(i2), Integer.valueOf(length), str2}));
            return null;
        }
        try {
            String trim = split[zzaly2.zza].trim();
            int i3 = zzaly2.zzb;
            int zzd2 = i3 != -1 ? zzd(split[i3].trim()) : -1;
            int i4 = zzaly2.zzc;
            Integer zzc2 = i4 != -1 ? zzc(split[i4].trim()) : null;
            int i5 = zzaly2.zzd;
            Integer zzc3 = i5 != -1 ? zzc(split[i5].trim()) : null;
            int i6 = zzaly2.zze;
            float f = -3.4028235E38f;
            if (i6 != -1) {
                String trim2 = split[i6].trim();
                try {
                    f = Float.parseFloat(trim2);
                } catch (NumberFormatException e) {
                    zzfe.zzg("SsaStyle", "Failed to parse font size: '" + trim2 + "'", e);
                }
            }
            int i7 = zzaly2.zzf;
            boolean z = i7 != -1 && zze(split[i7].trim());
            int i8 = zzaly2.zzg;
            boolean z2 = i8 != -1 && zze(split[i8].trim());
            int i9 = zzaly2.zzh;
            boolean z3 = i9 != -1 && zze(split[i9].trim());
            int i10 = zzaly2.zzi;
            boolean z4 = i10 != -1 && zze(split[i10].trim());
            int i11 = zzaly2.zzj;
            if (i11 != -1) {
                String trim3 = split[i11].trim();
                try {
                    int parseInt = Integer.parseInt(trim3.trim());
                    if (parseInt == 1 || parseInt == 3) {
                        i = parseInt;
                        return new zzama(trim, zzd2, zzc2, zzc3, f, z, z2, z3, z4, i);
                    }
                } catch (NumberFormatException unused) {
                }
                zzfe.zzf("SsaStyle", "Ignoring unknown BorderStyle: ".concat(String.valueOf(trim3)));
            }
            i = -1;
            return new zzama(trim, zzd2, zzc2, zzc3, f, z, z2, z3, z4, i);
        } catch (RuntimeException e2) {
            zzfe.zzg("SsaStyle", "Skipping malformed 'Style:' line: '" + str2 + "'", e2);
            return null;
        }
    }

    public static Integer zzc(String str) {
        long j;
        try {
            if (str.startsWith("&H")) {
                j = Long.parseLong(str.substring(2), 16);
            } else {
                j = Long.parseLong(str);
            }
            zzek.zzd(j <= 4294967295L);
            return Integer.valueOf(Color.argb(zzgcl.zzb(((j >> 24) & 255) ^ 255), zzgcl.zzb(j & 255), zzgcl.zzb((j >> 8) & 255), zzgcl.zzb((j >> 16) & 255)));
        } catch (IllegalArgumentException e) {
            zzfe.zzg("SsaStyle", "Failed to parse color expression: '" + str + "'", e);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static int zzd(String str) {
        try {
            int parseInt = Integer.parseInt(str.trim());
            switch (parseInt) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    return parseInt;
            }
        } catch (NumberFormatException unused) {
        }
        zzfe.zzf("SsaStyle", "Ignoring unknown alignment: ".concat(String.valueOf(str)));
        return -1;
    }

    private static boolean zze(String str) {
        try {
            int parseInt = Integer.parseInt(str);
            return parseInt == 1 || parseInt == -1;
        } catch (NumberFormatException e) {
            zzfe.zzg("SsaStyle", "Failed to parse boolean value: '" + str + "'", e);
            return false;
        }
    }
}
