package com.google.android.gms.internal.ads;

import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzamh implements zzalh {
    static final Pattern zza = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");
    static final Pattern zzb = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    private static final Pattern zzc = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final Pattern zzd = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    private static final Pattern zze = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    private static final Pattern zzf = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");
    private static final Pattern zzg = Pattern.compile("^(\\d+) (\\d+)$");
    private static final zzamf zzh = new zzamf(30.0f, 1, 1);
    private final XmlPullParserFactory zzi;

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c7, code lost:
        if (r13.equals("s") != false) goto L_0x00f3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0110  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long zzc(java.lang.String r13, com.google.android.gms.internal.ads.zzamf r14) throws com.google.android.gms.internal.ads.zzald {
        /*
            java.util.regex.Pattern r0 = zzc
            java.util.regex.Matcher r0 = r0.matcher(r13)
            boolean r1 = r0.matches()
            r2 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            r4 = 5
            r5 = 4
            r6 = 3
            r7 = 2
            r8 = 1
            if (r1 == 0) goto L_0x007c
            java.lang.String r13 = r0.group(r8)
            r13.getClass()
            long r8 = java.lang.Long.parseLong(r13)
            r10 = 3600(0xe10, double:1.7786E-320)
            long r8 = r8 * r10
            java.lang.String r13 = r0.group(r7)
            r13.getClass()
            double r7 = (double) r8
            long r9 = java.lang.Long.parseLong(r13)
            r11 = 60
            long r9 = r9 * r11
            java.lang.String r13 = r0.group(r6)
            r13.getClass()
            double r9 = (double) r9
            double r7 = r7 + r9
            long r9 = java.lang.Long.parseLong(r13)
            double r9 = (double) r9
            java.lang.String r13 = r0.group(r5)
            r5 = 0
            if (r13 == 0) goto L_0x004e
            double r11 = java.lang.Double.parseDouble(r13)
            goto L_0x004f
        L_0x004e:
            r11 = r5
        L_0x004f:
            double r7 = r7 + r9
            java.lang.String r13 = r0.group(r4)
            if (r13 == 0) goto L_0x0060
            long r9 = java.lang.Long.parseLong(r13)
            float r13 = (float) r9
            float r1 = r14.zza
            float r13 = r13 / r1
            double r9 = (double) r13
            goto L_0x0061
        L_0x0060:
            r9 = r5
        L_0x0061:
            double r7 = r7 + r11
            r13 = 6
            java.lang.String r13 = r0.group(r13)
            if (r13 == 0) goto L_0x0077
            long r0 = java.lang.Long.parseLong(r13)
            double r0 = (double) r0
            int r13 = r14.zzb
            double r4 = (double) r13
            float r13 = r14.zza
            double r13 = (double) r13
            double r0 = r0 / r4
            double r5 = r0 / r13
        L_0x0077:
            double r7 = r7 + r9
            double r7 = r7 + r5
            double r7 = r7 * r2
            long r13 = (long) r7
            return r13
        L_0x007c:
            java.util.regex.Pattern r0 = zzd
            java.util.regex.Matcher r0 = r0.matcher(r13)
            boolean r1 = r0.matches()
            if (r1 == 0) goto L_0x0119
            java.lang.String r13 = r0.group(r8)
            r13.getClass()
            double r9 = java.lang.Double.parseDouble(r13)
            java.lang.String r13 = r0.group(r7)
            r13.getClass()
            int r0 = r13.hashCode()
            r1 = 102(0x66, float:1.43E-43)
            if (r0 == r1) goto L_0x00e8
            r1 = 104(0x68, float:1.46E-43)
            if (r0 == r1) goto L_0x00de
            r1 = 109(0x6d, float:1.53E-43)
            if (r0 == r1) goto L_0x00d4
            r1 = 3494(0xda6, float:4.896E-42)
            if (r0 == r1) goto L_0x00ca
            r1 = 115(0x73, float:1.61E-43)
            if (r0 == r1) goto L_0x00c1
            r1 = 116(0x74, float:1.63E-43)
            if (r0 == r1) goto L_0x00b7
            goto L_0x00f2
        L_0x00b7:
            java.lang.String r0 = "t"
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L_0x00f2
            r7 = r4
            goto L_0x00f3
        L_0x00c1:
            java.lang.String r0 = "s"
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L_0x00f2
            goto L_0x00f3
        L_0x00ca:
            java.lang.String r0 = "ms"
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L_0x00f2
            r7 = r6
            goto L_0x00f3
        L_0x00d4:
            java.lang.String r0 = "m"
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L_0x00f2
            r7 = r8
            goto L_0x00f3
        L_0x00de:
            java.lang.String r0 = "h"
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L_0x00f2
            r7 = 0
            goto L_0x00f3
        L_0x00e8:
            java.lang.String r0 = "f"
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L_0x00f2
            r7 = r5
            goto L_0x00f3
        L_0x00f2:
            r7 = -1
        L_0x00f3:
            if (r7 == 0) goto L_0x0110
            if (r7 == r8) goto L_0x010d
            if (r7 == r6) goto L_0x0106
            if (r7 == r5) goto L_0x0102
            if (r7 == r4) goto L_0x00fe
            goto L_0x0116
        L_0x00fe:
            int r13 = r14.zzc
            double r13 = (double) r13
            goto L_0x010b
        L_0x0102:
            float r13 = r14.zza
            double r13 = (double) r13
            goto L_0x010b
        L_0x0106:
            r13 = 4652007308841189376(0x408f400000000000, double:1000.0)
        L_0x010b:
            double r9 = r9 / r13
            goto L_0x0116
        L_0x010d:
            r13 = 4633641066610819072(0x404e000000000000, double:60.0)
            goto L_0x0115
        L_0x0110:
            r13 = 4660134898793709568(0x40ac200000000000, double:3600.0)
        L_0x0115:
            double r9 = r9 * r13
        L_0x0116:
            double r9 = r9 * r2
            long r13 = (long) r9
            return r13
        L_0x0119:
            java.lang.String r13 = java.lang.String.valueOf(r13)
            com.google.android.gms.internal.ads.zzald r14 = new com.google.android.gms.internal.ads.zzald
            java.lang.String r0 = "Malformed time expression: "
            java.lang.String r13 = r0.concat(r13)
            r14.<init>(r13)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamh.zzc(java.lang.String, com.google.android.gms.internal.ads.zzamf):long");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.text.Layout.Alignment zzd(java.lang.String r5) {
        /*
            java.lang.String r5 = com.google.android.gms.internal.ads.zzfvx.zza(r5)
            int r0 = r5.hashCode()
            r1 = 4
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r0) {
                case -1364013995: goto L_0x0038;
                case 100571: goto L_0x002e;
                case 3317767: goto L_0x0024;
                case 108511772: goto L_0x001a;
                case 109757538: goto L_0x0010;
                default: goto L_0x000f;
            }
        L_0x000f:
            goto L_0x0042
        L_0x0010:
            java.lang.String r0 = "start"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0042
            r5 = r4
            goto L_0x0043
        L_0x001a:
            java.lang.String r0 = "right"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0042
            r5 = r3
            goto L_0x0043
        L_0x0024:
            java.lang.String r0 = "left"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0042
            r5 = 0
            goto L_0x0043
        L_0x002e:
            java.lang.String r0 = "end"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0042
            r5 = r2
            goto L_0x0043
        L_0x0038:
            java.lang.String r0 = "center"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0042
            r5 = r1
            goto L_0x0043
        L_0x0042:
            r5 = -1
        L_0x0043:
            if (r5 == 0) goto L_0x0055
            if (r5 == r4) goto L_0x0055
            if (r5 == r3) goto L_0x0052
            if (r5 == r2) goto L_0x0052
            if (r5 == r1) goto L_0x004f
            r5 = 0
            return r5
        L_0x004f:
            android.text.Layout$Alignment r5 = android.text.Layout.Alignment.ALIGN_CENTER
            return r5
        L_0x0052:
            android.text.Layout$Alignment r5 = android.text.Layout.Alignment.ALIGN_OPPOSITE
            return r5
        L_0x0055:
            android.text.Layout$Alignment r5 = android.text.Layout.Alignment.ALIGN_NORMAL
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamh.zzd(java.lang.String):android.text.Layout$Alignment");
    }

    private static zzamk zze(zzamk zzamk) {
        return zzamk == null ? new zzamk() : zzamk;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzamk zzf(org.xmlpull.v1.XmlPullParser r14, com.google.android.gms.internal.ads.zzamk r15) {
        /*
            int r0 = r14.getAttributeCount()
            r1 = 0
            r2 = r1
        L_0x0006:
            if (r2 >= r0) goto L_0x03e5
            java.lang.String r3 = r14.getAttributeValue(r2)
            java.lang.String r4 = r14.getAttributeName(r2)
            int r5 = r4.hashCode()
            r6 = 5
            r7 = 4
            r8 = -1
            r9 = 3
            r10 = 2
            r11 = 1
            switch(r5) {
                case -1550943582: goto L_0x00b8;
                case -1224696685: goto L_0x00ae;
                case -1065511464: goto L_0x00a4;
                case -879295043: goto L_0x0099;
                case -734428249: goto L_0x008f;
                case 3355: goto L_0x0085;
                case 3511770: goto L_0x007a;
                case 94842723: goto L_0x0070;
                case 109403361: goto L_0x0065;
                case 110138194: goto L_0x0059;
                case 365601008: goto L_0x004e;
                case 921125321: goto L_0x0042;
                case 1115953443: goto L_0x0036;
                case 1287124693: goto L_0x002b;
                case 1754920356: goto L_0x001f;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x00c2
        L_0x001f:
            java.lang.String r5 = "multiRowAlign"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x00c2
            r4 = 8
            goto L_0x00c3
        L_0x002b:
            java.lang.String r5 = "backgroundColor"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x00c2
            r4 = r11
            goto L_0x00c3
        L_0x0036:
            java.lang.String r5 = "rubyPosition"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x00c2
            r4 = 11
            goto L_0x00c3
        L_0x0042:
            java.lang.String r5 = "textEmphasis"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x00c2
            r4 = 13
            goto L_0x00c3
        L_0x004e:
            java.lang.String r5 = "fontSize"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x00c2
            r4 = r7
            goto L_0x00c3
        L_0x0059:
            java.lang.String r5 = "textCombine"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x00c2
            r4 = 9
            goto L_0x00c3
        L_0x0065:
            java.lang.String r5 = "shear"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x00c2
            r4 = 14
            goto L_0x00c3
        L_0x0070:
            java.lang.String r5 = "color"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x00c2
            r4 = r10
            goto L_0x00c3
        L_0x007a:
            java.lang.String r5 = "ruby"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x00c2
            r4 = 10
            goto L_0x00c3
        L_0x0085:
            java.lang.String r5 = "id"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x00c2
            r4 = r1
            goto L_0x00c3
        L_0x008f:
            java.lang.String r5 = "fontWeight"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x00c2
            r4 = r6
            goto L_0x00c3
        L_0x0099:
            java.lang.String r5 = "textDecoration"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x00c2
            r4 = 12
            goto L_0x00c3
        L_0x00a4:
            java.lang.String r5 = "textAlign"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x00c2
            r4 = 7
            goto L_0x00c3
        L_0x00ae:
            java.lang.String r5 = "fontFamily"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x00c2
            r4 = r9
            goto L_0x00c3
        L_0x00b8:
            java.lang.String r5 = "fontStyle"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x00c2
            r4 = 6
            goto L_0x00c3
        L_0x00c2:
            r4 = r8
        L_0x00c3:
            java.lang.String r5 = "TtmlParser"
            switch(r4) {
                case 0: goto L_0x03ce;
                case 1: goto L_0x03b4;
                case 2: goto L_0x039a;
                case 3: goto L_0x0392;
                case 4: goto L_0x02b1;
                case 5: goto L_0x02a2;
                case 6: goto L_0x0293;
                case 7: goto L_0x0286;
                case 8: goto L_0x0279;
                case 9: goto L_0x023b;
                case 10: goto L_0x01c2;
                case 11: goto L_0x0184;
                case 12: goto L_0x0123;
                case 13: goto L_0x0116;
                case 14: goto L_0x00ca;
                default: goto L_0x00c8;
            }
        L_0x00c8:
            goto L_0x03e1
        L_0x00ca:
            com.google.android.gms.internal.ads.zzamk r15 = zze(r15)
            java.util.regex.Pattern r4 = zza
            java.util.regex.Matcher r4 = r4.matcher(r3)
            boolean r6 = r4.matches()
            r7 = 2139095039(0x7f7fffff, float:3.4028235E38)
            if (r6 != 0) goto L_0x00eb
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "Invalid value for shear: "
            java.lang.String r3 = r4.concat(r3)
            com.google.android.gms.internal.ads.zzfe.zzf(r5, r3)
            goto L_0x0111
        L_0x00eb:
            java.lang.String r4 = r4.group(r11)     // Catch:{ NumberFormatException -> 0x0103 }
            r4.getClass()
            float r4 = java.lang.Float.parseFloat(r4)     // Catch:{ NumberFormatException -> 0x0103 }
            r6 = -1027080192(0xffffffffc2c80000, float:-100.0)
            float r4 = java.lang.Math.max(r6, r4)     // Catch:{ NumberFormatException -> 0x0103 }
            r6 = 1120403456(0x42c80000, float:100.0)
            float r7 = java.lang.Math.min(r6, r4)     // Catch:{ NumberFormatException -> 0x0103 }
            goto L_0x0111
        L_0x0103:
            r4 = move-exception
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r6 = "Failed to parse shear: "
            java.lang.String r3 = r6.concat(r3)
            com.google.android.gms.internal.ads.zzfe.zzg(r5, r3, r4)
        L_0x0111:
            r15.zzy(r7)
            goto L_0x03e1
        L_0x0116:
            com.google.android.gms.internal.ads.zzamk r15 = zze(r15)
            com.google.android.gms.internal.ads.zzamd r3 = com.google.android.gms.internal.ads.zzamd.zza(r3)
            r15.zzB(r3)
            goto L_0x03e1
        L_0x0123:
            java.lang.String r3 = com.google.android.gms.internal.ads.zzfvx.zza(r3)
            int r4 = r3.hashCode()
            switch(r4) {
                case -1461280213: goto L_0x014d;
                case -1026963764: goto L_0x0143;
                case 913457136: goto L_0x0139;
                case 1679736913: goto L_0x012f;
                default: goto L_0x012e;
            }
        L_0x012e:
            goto L_0x0156
        L_0x012f:
            java.lang.String r4 = "linethrough"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0156
            r8 = r1
            goto L_0x0156
        L_0x0139:
            java.lang.String r4 = "nolinethrough"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0156
            r8 = r11
            goto L_0x0156
        L_0x0143:
            java.lang.String r4 = "underline"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0156
            r8 = r10
            goto L_0x0156
        L_0x014d:
            java.lang.String r4 = "nounderline"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0156
            r8 = r9
        L_0x0156:
            if (r8 == 0) goto L_0x017b
            if (r8 == r11) goto L_0x0172
            if (r8 == r10) goto L_0x0169
            if (r8 == r9) goto L_0x0160
            goto L_0x03e1
        L_0x0160:
            com.google.android.gms.internal.ads.zzamk r15 = zze(r15)
            r15.zzC(r1)
            goto L_0x03e1
        L_0x0169:
            com.google.android.gms.internal.ads.zzamk r15 = zze(r15)
            r15.zzC(r11)
            goto L_0x03e1
        L_0x0172:
            com.google.android.gms.internal.ads.zzamk r15 = zze(r15)
            r15.zzu(r1)
            goto L_0x03e1
        L_0x017b:
            com.google.android.gms.internal.ads.zzamk r15 = zze(r15)
            r15.zzu(r11)
            goto L_0x03e1
        L_0x0184:
            java.lang.String r3 = com.google.android.gms.internal.ads.zzfvx.zza(r3)
            int r4 = r3.hashCode()
            r5 = -1392885889(0xffffffffacfa3f7f, float:-7.112477E-12)
            if (r4 == r5) goto L_0x01a1
            r5 = 92734940(0x58705dc, float:1.2697491E-35)
            if (r4 == r5) goto L_0x0197
            goto L_0x01aa
        L_0x0197:
            java.lang.String r4 = "after"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x01aa
            r8 = r11
            goto L_0x01aa
        L_0x01a1:
            java.lang.String r4 = "before"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x01aa
            r8 = r1
        L_0x01aa:
            if (r8 == 0) goto L_0x01b9
            if (r8 == r11) goto L_0x01b0
            goto L_0x03e1
        L_0x01b0:
            com.google.android.gms.internal.ads.zzamk r15 = zze(r15)
            r15.zzw(r10)
            goto L_0x03e1
        L_0x01b9:
            com.google.android.gms.internal.ads.zzamk r15 = zze(r15)
            r15.zzw(r11)
            goto L_0x03e1
        L_0x01c2:
            java.lang.String r3 = com.google.android.gms.internal.ads.zzfvx.zza(r3)
            int r4 = r3.hashCode()
            switch(r4) {
                case -618561360: goto L_0x0200;
                case -410956671: goto L_0x01f6;
                case -250518009: goto L_0x01ec;
                case -136074796: goto L_0x01e2;
                case 3016401: goto L_0x01d8;
                case 3556653: goto L_0x01ce;
                default: goto L_0x01cd;
            }
        L_0x01cd:
            goto L_0x0209
        L_0x01ce:
            java.lang.String r4 = "text"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0209
            r8 = r9
            goto L_0x0209
        L_0x01d8:
            java.lang.String r4 = "base"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0209
            r8 = r11
            goto L_0x0209
        L_0x01e2:
            java.lang.String r4 = "textContainer"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0209
            r8 = r7
            goto L_0x0209
        L_0x01ec:
            java.lang.String r4 = "delimiter"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0209
            r8 = r6
            goto L_0x0209
        L_0x01f6:
            java.lang.String r4 = "container"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0209
            r8 = r1
            goto L_0x0209
        L_0x0200:
            java.lang.String r4 = "baseContainer"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0209
            r8 = r10
        L_0x0209:
            if (r8 == 0) goto L_0x0232
            if (r8 == r11) goto L_0x0229
            if (r8 == r10) goto L_0x0229
            if (r8 == r9) goto L_0x0220
            if (r8 == r7) goto L_0x0220
            if (r8 == r6) goto L_0x0217
            goto L_0x03e1
        L_0x0217:
            com.google.android.gms.internal.ads.zzamk r15 = zze(r15)
            r15.zzx(r7)
            goto L_0x03e1
        L_0x0220:
            com.google.android.gms.internal.ads.zzamk r15 = zze(r15)
            r15.zzx(r9)
            goto L_0x03e1
        L_0x0229:
            com.google.android.gms.internal.ads.zzamk r15 = zze(r15)
            r15.zzx(r10)
            goto L_0x03e1
        L_0x0232:
            com.google.android.gms.internal.ads.zzamk r15 = zze(r15)
            r15.zzx(r11)
            goto L_0x03e1
        L_0x023b:
            java.lang.String r3 = com.google.android.gms.internal.ads.zzfvx.zza(r3)
            int r4 = r3.hashCode()
            r5 = 96673(0x179a1, float:1.35468E-40)
            if (r4 == r5) goto L_0x0258
            r5 = 3387192(0x33af38, float:4.746467E-39)
            if (r4 == r5) goto L_0x024e
            goto L_0x0261
        L_0x024e:
            java.lang.String r4 = "none"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0261
            r8 = r1
            goto L_0x0261
        L_0x0258:
            java.lang.String r4 = "all"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0261
            r8 = r11
        L_0x0261:
            if (r8 == 0) goto L_0x0270
            if (r8 == r11) goto L_0x0267
            goto L_0x03e1
        L_0x0267:
            com.google.android.gms.internal.ads.zzamk r15 = zze(r15)
            r15.zzA(r11)
            goto L_0x03e1
        L_0x0270:
            com.google.android.gms.internal.ads.zzamk r15 = zze(r15)
            r15.zzA(r1)
            goto L_0x03e1
        L_0x0279:
            com.google.android.gms.internal.ads.zzamk r15 = zze(r15)
            android.text.Layout$Alignment r3 = zzd(r3)
            r15.zzv(r3)
            goto L_0x03e1
        L_0x0286:
            com.google.android.gms.internal.ads.zzamk r15 = zze(r15)
            android.text.Layout$Alignment r3 = zzd(r3)
            r15.zzz(r3)
            goto L_0x03e1
        L_0x0293:
            com.google.android.gms.internal.ads.zzamk r15 = zze(r15)
            java.lang.String r4 = "italic"
            boolean r3 = r4.equalsIgnoreCase(r3)
            r15.zzt(r3)
            goto L_0x03e1
        L_0x02a2:
            com.google.android.gms.internal.ads.zzamk r15 = zze(r15)
            java.lang.String r4 = "bold"
            boolean r3 = r4.equalsIgnoreCase(r3)
            r15.zzn(r3)
            goto L_0x03e1
        L_0x02b1:
            com.google.android.gms.internal.ads.zzamk r15 = zze(r15)     // Catch:{ zzald -> 0x0384 }
            java.lang.String r4 = "\\s+"
            int r6 = com.google.android.gms.internal.ads.zzfx.zza     // Catch:{ zzald -> 0x0384 }
            java.lang.String[] r4 = r3.split(r4, r8)     // Catch:{ zzald -> 0x0384 }
            int r6 = r4.length     // Catch:{ zzald -> 0x0384 }
            if (r6 != r11) goto L_0x02c7
            java.util.regex.Pattern r4 = zze     // Catch:{ zzald -> 0x0384 }
            java.util.regex.Matcher r4 = r4.matcher(r3)     // Catch:{ zzald -> 0x0384 }
            goto L_0x02d6
        L_0x02c7:
            if (r6 != r10) goto L_0x0368
            java.util.regex.Pattern r6 = zze     // Catch:{ zzald -> 0x0384 }
            r4 = r4[r11]     // Catch:{ zzald -> 0x0384 }
            java.util.regex.Matcher r4 = r6.matcher(r4)     // Catch:{ zzald -> 0x0384 }
            java.lang.String r6 = "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first."
            com.google.android.gms.internal.ads.zzfe.zzf(r5, r6)     // Catch:{ zzald -> 0x0384 }
        L_0x02d6:
            boolean r6 = r4.matches()     // Catch:{ zzald -> 0x0384 }
            java.lang.String r7 = "'."
            if (r6 == 0) goto L_0x034e
            java.lang.String r6 = r4.group(r9)     // Catch:{ zzald -> 0x0384 }
            r6.getClass()
            int r12 = r6.hashCode()     // Catch:{ zzald -> 0x0384 }
            r13 = 37
            if (r12 == r13) goto L_0x030a
            r13 = 3240(0xca8, float:4.54E-42)
            if (r12 == r13) goto L_0x0300
            r13 = 3592(0xe08, float:5.033E-42)
            if (r12 == r13) goto L_0x02f6
            goto L_0x0313
        L_0x02f6:
            java.lang.String r12 = "px"
            boolean r12 = r6.equals(r12)
            if (r12 == 0) goto L_0x0313
            r8 = r1
            goto L_0x0313
        L_0x0300:
            java.lang.String r12 = "em"
            boolean r12 = r6.equals(r12)
            if (r12 == 0) goto L_0x0313
            r8 = r11
            goto L_0x0313
        L_0x030a:
            java.lang.String r12 = "%"
            boolean r12 = r6.equals(r12)
            if (r12 == 0) goto L_0x0313
            r8 = r10
        L_0x0313:
            if (r8 == 0) goto L_0x033b
            if (r8 == r11) goto L_0x0337
            if (r8 != r10) goto L_0x031d
            r15.zzr(r9)     // Catch:{ zzald -> 0x0384 }
            goto L_0x033e
        L_0x031d:
            com.google.android.gms.internal.ads.zzald r4 = new com.google.android.gms.internal.ads.zzald     // Catch:{ zzald -> 0x0384 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ zzald -> 0x0384 }
            r8.<init>()     // Catch:{ zzald -> 0x0384 }
            java.lang.String r9 = "Invalid unit for fontSize: '"
            r8.append(r9)     // Catch:{ zzald -> 0x0384 }
            r8.append(r6)     // Catch:{ zzald -> 0x0384 }
            r8.append(r7)     // Catch:{ zzald -> 0x0384 }
            java.lang.String r6 = r8.toString()     // Catch:{ zzald -> 0x0384 }
            r4.<init>(r6)     // Catch:{ zzald -> 0x0384 }
            throw r4     // Catch:{ zzald -> 0x0384 }
        L_0x0337:
            r15.zzr(r10)     // Catch:{ zzald -> 0x0384 }
            goto L_0x033e
        L_0x033b:
            r15.zzr(r11)     // Catch:{ zzald -> 0x0384 }
        L_0x033e:
            java.lang.String r4 = r4.group(r11)     // Catch:{ zzald -> 0x0384 }
            r4.getClass()
            float r4 = java.lang.Float.parseFloat(r4)     // Catch:{ zzald -> 0x0384 }
            r15.zzq(r4)     // Catch:{ zzald -> 0x0384 }
            goto L_0x03e1
        L_0x034e:
            com.google.android.gms.internal.ads.zzald r4 = new com.google.android.gms.internal.ads.zzald     // Catch:{ zzald -> 0x0384 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ zzald -> 0x0384 }
            r6.<init>()     // Catch:{ zzald -> 0x0384 }
            java.lang.String r8 = "Invalid expression for fontSize: '"
            r6.append(r8)     // Catch:{ zzald -> 0x0384 }
            r6.append(r3)     // Catch:{ zzald -> 0x0384 }
            r6.append(r7)     // Catch:{ zzald -> 0x0384 }
            java.lang.String r6 = r6.toString()     // Catch:{ zzald -> 0x0384 }
            r4.<init>(r6)     // Catch:{ zzald -> 0x0384 }
            throw r4     // Catch:{ zzald -> 0x0384 }
        L_0x0368:
            com.google.android.gms.internal.ads.zzald r4 = new com.google.android.gms.internal.ads.zzald     // Catch:{ zzald -> 0x0384 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ zzald -> 0x0384 }
            r7.<init>()     // Catch:{ zzald -> 0x0384 }
            java.lang.String r8 = "Invalid number of entries for fontSize: "
            r7.append(r8)     // Catch:{ zzald -> 0x0384 }
            r7.append(r6)     // Catch:{ zzald -> 0x0384 }
            java.lang.String r6 = "."
            r7.append(r6)     // Catch:{ zzald -> 0x0384 }
            java.lang.String r6 = r7.toString()     // Catch:{ zzald -> 0x0384 }
            r4.<init>(r6)     // Catch:{ zzald -> 0x0384 }
            throw r4     // Catch:{ zzald -> 0x0384 }
        L_0x0384:
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "Failed parsing fontSize value: "
            java.lang.String r3 = r4.concat(r3)
            com.google.android.gms.internal.ads.zzfe.zzf(r5, r3)
            goto L_0x03e1
        L_0x0392:
            com.google.android.gms.internal.ads.zzamk r15 = zze(r15)
            r15.zzp(r3)
            goto L_0x03e1
        L_0x039a:
            com.google.android.gms.internal.ads.zzamk r15 = zze(r15)
            int r4 = com.google.android.gms.internal.ads.zzen.zzb(r3)     // Catch:{ IllegalArgumentException -> 0x03a6 }
            r15.zzo(r4)     // Catch:{ IllegalArgumentException -> 0x03a6 }
            goto L_0x03e1
        L_0x03a6:
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "Failed parsing color value: "
            java.lang.String r3 = r4.concat(r3)
            com.google.android.gms.internal.ads.zzfe.zzf(r5, r3)
            goto L_0x03e1
        L_0x03b4:
            com.google.android.gms.internal.ads.zzamk r15 = zze(r15)
            int r4 = com.google.android.gms.internal.ads.zzen.zzb(r3)     // Catch:{ IllegalArgumentException -> 0x03c0 }
            r15.zzm(r4)     // Catch:{ IllegalArgumentException -> 0x03c0 }
            goto L_0x03e1
        L_0x03c0:
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "Failed parsing background value: "
            java.lang.String r3 = r4.concat(r3)
            com.google.android.gms.internal.ads.zzfe.zzf(r5, r3)
            goto L_0x03e1
        L_0x03ce:
            java.lang.String r4 = r14.getName()
            java.lang.String r5 = "style"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x03e1
            com.google.android.gms.internal.ads.zzamk r15 = zze(r15)
            r15.zzs(r3)
        L_0x03e1:
            int r2 = r2 + 1
            goto L_0x0006
        L_0x03e5:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamh.zzf(org.xmlpull.v1.XmlPullParser, com.google.android.gms.internal.ads.zzamk):com.google.android.gms.internal.ads.zzamk");
    }

    private static String[] zzg(String str) {
        String trim = str.trim();
        if (trim.isEmpty()) {
            return new String[0];
        }
        int i = zzfx.zza;
        return trim.split("\\s+", -1);
    }

    public final void zza(byte[] bArr, int i, int i2, zzalg zzalg, zzep zzep) {
        zzalb.zza(zzb(bArr, i, i2), zzalg, zzep);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: com.google.android.gms.internal.ads.zzamf} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v35, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v37, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v40, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v46, resolved type: com.google.android.gms.internal.ads.zzamf} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v51, resolved type: com.google.android.gms.internal.ads.zzamf} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v91, resolved type: int} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x026f A[Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }, LOOP:1: B:129:0x026f->B:291:0x04e9, LOOP_START, PHI: r2 r5 r11 
      PHI: (r2v42 java.lang.String) = (r2v16 java.lang.String), (r2v43 java.lang.String) binds: [B:128:0x026d, B:291:0x04e9] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r5v7 java.util.HashMap) = (r5v1 java.util.HashMap), (r5v8 java.util.HashMap) binds: [B:128:0x026d, B:291:0x04e9] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r11v11 com.google.android.gms.internal.ads.zzamf) = (r11v5 com.google.android.gms.internal.ads.zzamf), (r11v12 com.google.android.gms.internal.ads.zzamf) binds: [B:128:0x026d, B:291:0x04e9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x041f  */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x042a  */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x0443 A[Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x047e  */
    /* JADX WARNING: Removed duplicated region for block: B:274:0x0485  */
    /* JADX WARNING: Removed duplicated region for block: B:287:0x04d8 A[Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x04e9 A[LOOP:1: B:129:0x026f->B:291:0x04e9, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:292:0x04f1  */
    /* JADX WARNING: Removed duplicated region for block: B:442:0x04e3 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0181 A[Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01dc A[SYNTHETIC, Splitter:B:96:0x01dc] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzalc zzb(byte[] r42, int r43, int r44) {
        /*
            r41 = this;
            java.lang.String r1 = ""
            java.lang.String r2 = "http://www.w3.org/ns/ttml#parameter"
            r3 = r41
            org.xmlpull.v1.XmlPullParserFactory r4 = r3.zzi     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            org.xmlpull.v1.XmlPullParser r4 = r4.newPullParser()     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            r5.<init>()     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            r6.<init>()     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            r7.<init>()     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            com.google.android.gms.internal.ads.zzami r15 = new com.google.android.gms.internal.ads.zzami     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            java.lang.String r9 = ""
            r17 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            r18 = -2147483648(0xffffffff80000000, float:-0.0)
            r8 = r15
            r10 = r17
            r11 = r17
            r12 = r18
            r13 = r18
            r14 = r17
            r19 = r15
            r15 = r17
            r16 = r18
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            r8 = r19
            r6.put(r1, r8)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            java.io.ByteArrayInputStream r8 = new java.io.ByteArrayInputStream     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            r9 = r42
            r10 = r43
            r11 = r44
            r8.<init>(r9, r10, r11)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            r9 = 0
            r4.setInput(r8, r9)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            java.util.ArrayDeque r8 = new java.util.ArrayDeque     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            r8.<init>()     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            int r10 = r4.getEventType()     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            com.google.android.gms.internal.ads.zzamf r11 = zzh     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            r14 = r9
            r16 = r14
            r15 = 0
            r17 = 15
        L_0x005d:
            r12 = 1
            if (r10 == r12) goto L_0x06b3
            java.lang.Object r18 = r8.peek()     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            r9 = r18
            com.google.android.gms.internal.ads.zzame r9 = (com.google.android.gms.internal.ads.zzame) r9     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            r12 = 2
            if (r15 != 0) goto L_0x0685
            java.lang.String r13 = r4.getName()     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            r20 = r1
            java.lang.String r1 = "tt"
            if (r10 != r12) goto L_0x0641
            boolean r10 = r1.equals(r13)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            r21 = 1065353216(0x3f800000, float:1.0)
            java.lang.String r12 = "TtmlParser"
            if (r10 == 0) goto L_0x01c2
            java.lang.String r10 = "frameRate"
            java.lang.String r10 = r4.getAttributeValue(r2, r10)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            if (r10 == 0) goto L_0x008c
            int r10 = java.lang.Integer.parseInt(r10)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            goto L_0x008e
        L_0x008c:
            r10 = 30
        L_0x008e:
            java.lang.String r11 = "frameRateMultiplier"
            java.lang.String r11 = r4.getAttributeValue(r2, r11)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            java.lang.String r3 = " "
            if (r11 == 0) goto L_0x00c2
            int r16 = com.google.android.gms.internal.ads.zzfx.zza     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            r23 = r14
            r14 = -1
            java.lang.String[] r11 = r11.split(r3, r14)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            int r14 = r11.length     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            r24 = r15
            r15 = 2
            if (r14 != r15) goto L_0x00a9
            r14 = 1
            goto L_0x00aa
        L_0x00a9:
            r14 = 0
        L_0x00aa:
            java.lang.String r15 = "frameRateMultiplier doesn't have 2 parts"
            com.google.android.gms.internal.ads.zzek.zze(r14, r15)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            r14 = 0
            r15 = r11[r14]     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            int r15 = java.lang.Integer.parseInt(r15)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            float r15 = (float) r15     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            r16 = 1
            r11 = r11[r16]     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            int r11 = java.lang.Integer.parseInt(r11)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            float r11 = (float) r11     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            float r15 = r15 / r11
            goto L_0x00c9
        L_0x00c2:
            r23 = r14
            r24 = r15
            r14 = 0
            r15 = r21
        L_0x00c9:
            com.google.android.gms.internal.ads.zzamf r11 = zzh     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            int r14 = r11.zzb     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            r16 = r14
            java.lang.String r14 = "subFrameRate"
            java.lang.String r14 = r4.getAttributeValue(r2, r14)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            if (r14 == 0) goto L_0x00dc
            int r14 = java.lang.Integer.parseInt(r14)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            goto L_0x00de
        L_0x00dc:
            r14 = r16
        L_0x00de:
            int r11 = r11.zzc     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            r16 = r11
            java.lang.String r11 = "tickRate"
            java.lang.String r11 = r4.getAttributeValue(r2, r11)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            if (r11 == 0) goto L_0x00f1
            int r11 = java.lang.Integer.parseInt(r11)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            r25 = r8
            goto L_0x00f5
        L_0x00f1:
            r25 = r8
            r11 = r16
        L_0x00f5:
            com.google.android.gms.internal.ads.zzamf r8 = new com.google.android.gms.internal.ads.zzamf     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            float r10 = (float) r10     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            float r10 = r10 * r15
            r8.<init>(r10, r14, r11)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            java.lang.String r10 = "cellResolution"
            java.lang.String r10 = r4.getAttributeValue(r2, r10)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            if (r10 != 0) goto L_0x010c
        L_0x0104:
            r26 = r2
            r16 = r8
        L_0x0108:
            r15 = 15
            goto L_0x0177
        L_0x010c:
            java.util.regex.Pattern r11 = zzg     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            java.util.regex.Matcher r11 = r11.matcher(r10)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            boolean r14 = r11.matches()     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            if (r14 != 0) goto L_0x0122
            java.lang.String r3 = "Ignoring malformed cell resolution: "
            java.lang.String r3 = r3.concat(r10)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            com.google.android.gms.internal.ads.zzfe.zzf(r12, r3)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            goto L_0x0104
        L_0x0122:
            r14 = 1
            java.lang.String r15 = r11.group(r14)     // Catch:{ NumberFormatException -> 0x0169 }
            r15.getClass()
            int r14 = java.lang.Integer.parseInt(r15)     // Catch:{ NumberFormatException -> 0x0169 }
            r15 = 2
            java.lang.String r11 = r11.group(r15)     // Catch:{ NumberFormatException -> 0x0169 }
            r11.getClass()
            int r11 = java.lang.Integer.parseInt(r11)     // Catch:{ NumberFormatException -> 0x0169 }
            if (r14 == 0) goto L_0x0148
            if (r11 == 0) goto L_0x0143
            r26 = r2
            r15 = r11
            r11 = 1
            goto L_0x014c
        L_0x0143:
            r26 = r2
            r11 = 0
            r15 = 0
            goto L_0x014c
        L_0x0148:
            r26 = r2
            r15 = r11
            r11 = 0
        L_0x014c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x016b }
            r2.<init>()     // Catch:{ NumberFormatException -> 0x016b }
            r16 = r8
            java.lang.String r8 = "Invalid cell resolution "
            r2.append(r8)     // Catch:{ NumberFormatException -> 0x016d }
            r2.append(r14)     // Catch:{ NumberFormatException -> 0x016d }
            r2.append(r3)     // Catch:{ NumberFormatException -> 0x016d }
            r2.append(r15)     // Catch:{ NumberFormatException -> 0x016d }
            java.lang.String r2 = r2.toString()     // Catch:{ NumberFormatException -> 0x016d }
            com.google.android.gms.internal.ads.zzek.zze(r11, r2)     // Catch:{ NumberFormatException -> 0x016d }
            goto L_0x0177
        L_0x0169:
            r26 = r2
        L_0x016b:
            r16 = r8
        L_0x016d:
            java.lang.String r2 = "Ignoring malformed cell resolution: "
            java.lang.String r2 = r2.concat(r10)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            com.google.android.gms.internal.ads.zzfe.zzf(r12, r2)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            goto L_0x0108
        L_0x0177:
            java.lang.String r2 = "extent"
            java.lang.String r2 = com.google.android.gms.internal.ads.zzfy.zza(r4, r2)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            if (r2 != 0) goto L_0x0181
        L_0x017f:
            r10 = 0
            goto L_0x01bf
        L_0x0181:
            java.util.regex.Pattern r3 = zzf     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            java.util.regex.Matcher r3 = r3.matcher(r2)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            boolean r8 = r3.matches()     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            if (r8 != 0) goto L_0x0197
            java.lang.String r3 = "Ignoring non-pixel tts extent: "
            java.lang.String r2 = r3.concat(r2)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            com.google.android.gms.internal.ads.zzfe.zzf(r12, r2)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            goto L_0x017f
        L_0x0197:
            r8 = 1
            java.lang.String r10 = r3.group(r8)     // Catch:{ NumberFormatException -> 0x01b5 }
            r10.getClass()
            int r8 = java.lang.Integer.parseInt(r10)     // Catch:{ NumberFormatException -> 0x01b5 }
            r10 = 2
            java.lang.String r3 = r3.group(r10)     // Catch:{ NumberFormatException -> 0x01b5 }
            r3.getClass()
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x01b5 }
            com.google.android.gms.internal.ads.zzamg r10 = new com.google.android.gms.internal.ads.zzamg     // Catch:{ NumberFormatException -> 0x01b5 }
            r10.<init>(r8, r3)     // Catch:{ NumberFormatException -> 0x01b5 }
            goto L_0x01bf
        L_0x01b5:
            java.lang.String r3 = "Ignoring malformed tts extent: "
            java.lang.String r2 = r3.concat(r2)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            com.google.android.gms.internal.ads.zzfe.zzf(r12, r2)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            goto L_0x017f
        L_0x01bf:
            r11 = r16
            goto L_0x01ce
        L_0x01c2:
            r26 = r2
            r25 = r8
            r23 = r14
            r24 = r15
            r10 = r16
            r15 = r17
        L_0x01ce:
            boolean r1 = r13.equals(r1)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            java.lang.String r2 = "metadata"
            java.lang.String r3 = "region"
            java.lang.String r8 = "head"
            java.lang.String r14 = "style"
            if (r1 != 0) goto L_0x0269
            boolean r1 = r13.equals(r8)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            if (r1 != 0) goto L_0x0269
            java.lang.String r1 = "body"
            boolean r1 = r13.equals(r1)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            if (r1 != 0) goto L_0x0269
            java.lang.String r1 = "div"
            boolean r1 = r13.equals(r1)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            if (r1 != 0) goto L_0x0269
            java.lang.String r1 = "p"
            boolean r1 = r13.equals(r1)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            if (r1 != 0) goto L_0x0269
            java.lang.String r1 = "span"
            boolean r1 = r13.equals(r1)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            if (r1 != 0) goto L_0x0269
            java.lang.String r1 = "br"
            boolean r1 = r13.equals(r1)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            if (r1 != 0) goto L_0x0269
            boolean r1 = r13.equals(r14)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            if (r1 != 0) goto L_0x0269
            java.lang.String r1 = "styling"
            boolean r1 = r13.equals(r1)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            if (r1 != 0) goto L_0x0269
            java.lang.String r1 = "layout"
            boolean r1 = r13.equals(r1)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            if (r1 != 0) goto L_0x0269
            boolean r1 = r13.equals(r3)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            if (r1 != 0) goto L_0x0269
            boolean r1 = r13.equals(r2)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            if (r1 != 0) goto L_0x0269
            java.lang.String r1 = "image"
            boolean r1 = r13.equals(r1)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            if (r1 != 0) goto L_0x0269
            java.lang.String r1 = "data"
            boolean r1 = r13.equals(r1)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            if (r1 != 0) goto L_0x0269
            java.lang.String r1 = "information"
            boolean r1 = r13.equals(r1)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            if (r1 == 0) goto L_0x0245
            goto L_0x0269
        L_0x0245:
            java.lang.String r1 = r4.getName()     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            r2.<init>()     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            java.lang.String r3 = "Ignoring unsupported tag: "
            r2.append(r3)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            r2.append(r1)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            java.lang.String r1 = r2.toString()     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            com.google.android.gms.internal.ads.zzfe.zze(r12, r1)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            r2 = r5
            r16 = r10
            r17 = r15
            r14 = r23
            r3 = r25
            r15 = 1
            goto L_0x06a1
        L_0x0269:
            boolean r1 = r8.equals(r13)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            if (r1 == 0) goto L_0x04f1
        L_0x026f:
            r4.next()     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            boolean r1 = com.google.android.gms.internal.ads.zzfy.zzc(r4, r14)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            if (r1 == 0) goto L_0x02af
            java.lang.String r1 = com.google.android.gms.internal.ads.zzfy.zza(r4, r14)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            com.google.android.gms.internal.ads.zzamk r9 = new com.google.android.gms.internal.ads.zzamk     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            r9.<init>()     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            com.google.android.gms.internal.ads.zzamk r9 = zzf(r4, r9)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            if (r1 == 0) goto L_0x02a3
            java.lang.String[] r1 = zzg(r1)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            int r13 = r1.length     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            r16 = r11
            r11 = 0
        L_0x028f:
            if (r11 >= r13) goto L_0x02a5
            r17 = r13
            r13 = r1[r11]     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            java.lang.Object r13 = r5.get(r13)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            com.google.android.gms.internal.ads.zzamk r13 = (com.google.android.gms.internal.ads.zzamk) r13     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            r9.zzl(r13)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            int r11 = r11 + 1
            r13 = r17
            goto L_0x028f
        L_0x02a3:
            r16 = r11
        L_0x02a5:
            java.lang.String r1 = r9.zzE()     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            if (r1 == 0) goto L_0x02dd
            r5.put(r1, r9)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            goto L_0x02dd
        L_0x02af:
            r16 = r11
            boolean r1 = com.google.android.gms.internal.ads.zzfy.zzc(r4, r3)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            java.lang.String r9 = "id"
            if (r1 != 0) goto L_0x02e3
            boolean r1 = com.google.android.gms.internal.ads.zzfy.zzc(r4, r2)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            if (r1 == 0) goto L_0x02dd
        L_0x02bf:
            r4.next()     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            java.lang.String r1 = "image"
            boolean r1 = com.google.android.gms.internal.ads.zzfy.zzc(r4, r1)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            if (r1 == 0) goto L_0x02d7
            java.lang.String r1 = com.google.android.gms.internal.ads.zzfy.zza(r4, r9)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            if (r1 == 0) goto L_0x02d7
            java.lang.String r11 = r4.nextText()     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            r7.put(r1, r11)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
        L_0x02d7:
            boolean r1 = com.google.android.gms.internal.ads.zzfy.zzb(r4, r2)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            if (r1 == 0) goto L_0x02bf
        L_0x02dd:
            r17 = r2
            r38 = r5
            goto L_0x04dd
        L_0x02e3:
            java.lang.String r28 = com.google.android.gms.internal.ads.zzfy.zza(r4, r9)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            if (r28 != 0) goto L_0x02f0
            r17 = r2
            r38 = r5
        L_0x02ed:
            r1 = 0
            goto L_0x04d6
        L_0x02f0:
            java.lang.String r1 = "origin"
            java.lang.String r1 = com.google.android.gms.internal.ads.zzfy.zza(r4, r1)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            if (r1 == 0) goto L_0x04cb
            java.util.regex.Pattern r9 = zzb     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            java.util.regex.Matcher r11 = r9.matcher(r1)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            java.util.regex.Pattern r13 = zzf     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            r17 = r2
            java.util.regex.Matcher r2 = r13.matcher(r1)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            boolean r18 = r11.matches()     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            r22 = 1120403456(0x42c80000, float:100.0)
            if (r18 == 0) goto L_0x0339
            r38 = r5
            r5 = 1
            java.lang.String r2 = r11.group(r5)     // Catch:{ NumberFormatException -> 0x032f }
            r2.getClass()
            float r2 = java.lang.Float.parseFloat(r2)     // Catch:{ NumberFormatException -> 0x032f }
            float r2 = r2 / r22
            r5 = 2
            java.lang.String r11 = r11.group(r5)     // Catch:{ NumberFormatException -> 0x032f }
            r11.getClass()
            float r5 = java.lang.Float.parseFloat(r11)     // Catch:{ NumberFormatException -> 0x032f }
            float r5 = r5 / r22
            r29 = r2
            goto L_0x0372
        L_0x032f:
            java.lang.String r2 = "Ignoring region with malformed origin: "
            java.lang.String r1 = r2.concat(r1)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            com.google.android.gms.internal.ads.zzfe.zzf(r12, r1)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            goto L_0x02ed
        L_0x0339:
            r38 = r5
            boolean r5 = r2.matches()     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            if (r5 == 0) goto L_0x04c0
            if (r10 != 0) goto L_0x034d
            java.lang.String r2 = "Ignoring region with missing tts:extent: "
            java.lang.String r1 = r2.concat(r1)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            com.google.android.gms.internal.ads.zzfe.zzf(r12, r1)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            goto L_0x02ed
        L_0x034d:
            r5 = 1
            java.lang.String r11 = r2.group(r5)     // Catch:{ NumberFormatException -> 0x04b5 }
            r11.getClass()
            int r5 = java.lang.Integer.parseInt(r11)     // Catch:{ NumberFormatException -> 0x04b5 }
            r11 = 2
            java.lang.String r2 = r2.group(r11)     // Catch:{ NumberFormatException -> 0x04b5 }
            r2.getClass()
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ NumberFormatException -> 0x04b5 }
            float r5 = (float) r5     // Catch:{ NumberFormatException -> 0x04b5 }
            int r11 = r10.zza     // Catch:{ NumberFormatException -> 0x04b5 }
            float r11 = (float) r11     // Catch:{ NumberFormatException -> 0x04b5 }
            float r5 = r5 / r11
            float r2 = (float) r2     // Catch:{ NumberFormatException -> 0x04b5 }
            int r11 = r10.zzb     // Catch:{ NumberFormatException -> 0x04b5 }
            float r11 = (float) r11
            float r2 = r2 / r11
            r29 = r5
            r5 = r2
        L_0x0372:
            java.lang.String r2 = "extent"
            java.lang.String r2 = com.google.android.gms.internal.ads.zzfy.zza(r4, r2)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            if (r2 == 0) goto L_0x04ae
            java.util.regex.Matcher r9 = r9.matcher(r2)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            java.util.regex.Matcher r2 = r13.matcher(r2)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            boolean r11 = r9.matches()     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            if (r11 == 0) goto L_0x03b4
            r11 = 1
            java.lang.String r2 = r9.group(r11)     // Catch:{ NumberFormatException -> 0x03a9 }
            r2.getClass()
            float r2 = java.lang.Float.parseFloat(r2)     // Catch:{ NumberFormatException -> 0x03a9 }
            float r2 = r2 / r22
            r11 = 2
            java.lang.String r9 = r9.group(r11)     // Catch:{ NumberFormatException -> 0x03a9 }
            r9.getClass()
            float r1 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x03a9 }
            float r1 = r1 / r22
            r34 = r1
            r33 = r2
            goto L_0x03ed
        L_0x03a9:
            java.lang.String r2 = "Ignoring region with malformed extent: "
            java.lang.String r1 = r2.concat(r1)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            com.google.android.gms.internal.ads.zzfe.zzf(r12, r1)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            goto L_0x02ed
        L_0x03b4:
            boolean r9 = r2.matches()     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            if (r9 == 0) goto L_0x04a3
            if (r10 != 0) goto L_0x03c7
            java.lang.String r2 = "Ignoring region with missing tts:extent: "
            java.lang.String r1 = r2.concat(r1)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            com.google.android.gms.internal.ads.zzfe.zzf(r12, r1)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            goto L_0x02ed
        L_0x03c7:
            r9 = 1
            java.lang.String r11 = r2.group(r9)     // Catch:{ NumberFormatException -> 0x0498 }
            r11.getClass()
            int r9 = java.lang.Integer.parseInt(r11)     // Catch:{ NumberFormatException -> 0x0498 }
            r11 = 2
            java.lang.String r2 = r2.group(r11)     // Catch:{ NumberFormatException -> 0x0498 }
            r2.getClass()
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ NumberFormatException -> 0x0498 }
            float r9 = (float) r9     // Catch:{ NumberFormatException -> 0x0498 }
            int r11 = r10.zza     // Catch:{ NumberFormatException -> 0x0498 }
            float r11 = (float) r11     // Catch:{ NumberFormatException -> 0x0498 }
            float r9 = r9 / r11
            float r2 = (float) r2     // Catch:{ NumberFormatException -> 0x0498 }
            int r1 = r10.zzb     // Catch:{ NumberFormatException -> 0x0498 }
            float r1 = (float) r1
            float r2 = r2 / r1
            r34 = r2
            r33 = r9
        L_0x03ed:
            java.lang.String r1 = "displayAlign"
            java.lang.String r1 = com.google.android.gms.internal.ads.zzfy.zza(r4, r1)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            if (r1 == 0) goto L_0x0434
            java.lang.String r1 = com.google.android.gms.internal.ads.zzfvx.zza(r1)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            int r2 = r1.hashCode()     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            r9 = -1364013995(0xffffffffaeb2cc55, float:-8.1307995E-11)
            if (r2 == r9) goto L_0x0412
            r9 = 92734940(0x58705dc, float:1.2697491E-35)
            if (r2 == r9) goto L_0x0408
            goto L_0x041c
        L_0x0408:
            java.lang.String r2 = "after"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x041c
            r1 = 1
            goto L_0x041d
        L_0x0412:
            java.lang.String r2 = "center"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x041c
            r1 = 0
            goto L_0x041d
        L_0x041c:
            r1 = -1
        L_0x041d:
            if (r1 == 0) goto L_0x042a
            r2 = 1
            if (r1 == r2) goto L_0x0423
            goto L_0x0434
        L_0x0423:
            float r5 = r5 + r34
            r30 = r5
            r32 = 2
            goto L_0x0438
        L_0x042a:
            r1 = 1073741824(0x40000000, float:2.0)
            float r1 = r34 / r1
            float r5 = r5 + r1
            r30 = r5
            r32 = 1
            goto L_0x0438
        L_0x0434:
            r30 = r5
            r32 = 0
        L_0x0438:
            float r1 = (float) r15
            float r36 = r21 / r1
            java.lang.String r1 = "writingMode"
            java.lang.String r1 = com.google.android.gms.internal.ads.zzfy.zza(r4, r1)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            if (r1 == 0) goto L_0x0488
            java.lang.String r1 = com.google.android.gms.internal.ads.zzfvx.zza(r1)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            int r2 = r1.hashCode()     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            r5 = 3694(0xe6e, float:5.176E-42)
            if (r2 == r5) goto L_0x046e
            r5 = 3553396(0x363874, float:4.979368E-39)
            if (r2 == r5) goto L_0x0464
            r5 = 3553576(0x363928, float:4.97962E-39)
            if (r2 == r5) goto L_0x045a
            goto L_0x0478
        L_0x045a:
            java.lang.String r2 = "tbrl"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0478
            r1 = 2
            goto L_0x0479
        L_0x0464:
            java.lang.String r2 = "tblr"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0478
            r1 = 1
            goto L_0x0479
        L_0x046e:
            java.lang.String r2 = "tb"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0478
            r1 = 0
            goto L_0x0479
        L_0x0478:
            r1 = -1
        L_0x0479:
            if (r1 == 0) goto L_0x0485
            r2 = 1
            if (r1 == r2) goto L_0x0485
            r2 = 2
            if (r1 == r2) goto L_0x0482
            goto L_0x0488
        L_0x0482:
            r37 = 1
            goto L_0x048c
        L_0x0485:
            r37 = 2
            goto L_0x048c
        L_0x0488:
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r37 = r1
        L_0x048c:
            com.google.android.gms.internal.ads.zzami r1 = new com.google.android.gms.internal.ads.zzami     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            r31 = 0
            r35 = 1
            r27 = r1
            r27.<init>(r28, r29, r30, r31, r32, r33, r34, r35, r36, r37)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            goto L_0x04d6
        L_0x0498:
            java.lang.String r2 = "Ignoring region with malformed extent: "
            java.lang.String r1 = r2.concat(r1)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            com.google.android.gms.internal.ads.zzfe.zzf(r12, r1)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            goto L_0x02ed
        L_0x04a3:
            java.lang.String r2 = "Ignoring region with unsupported extent: "
            java.lang.String r1 = r2.concat(r1)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            com.google.android.gms.internal.ads.zzfe.zzf(r12, r1)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            goto L_0x02ed
        L_0x04ae:
            java.lang.String r1 = "Ignoring region without an extent"
            com.google.android.gms.internal.ads.zzfe.zzf(r12, r1)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            goto L_0x02ed
        L_0x04b5:
            java.lang.String r2 = "Ignoring region with malformed origin: "
            java.lang.String r1 = r2.concat(r1)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            com.google.android.gms.internal.ads.zzfe.zzf(r12, r1)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            goto L_0x02ed
        L_0x04c0:
            java.lang.String r2 = "Ignoring region with unsupported origin: "
            java.lang.String r1 = r2.concat(r1)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            com.google.android.gms.internal.ads.zzfe.zzf(r12, r1)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            goto L_0x02ed
        L_0x04cb:
            r17 = r2
            r38 = r5
            java.lang.String r1 = "Ignoring region without an origin"
            com.google.android.gms.internal.ads.zzfe.zzf(r12, r1)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            goto L_0x02ed
        L_0x04d6:
            if (r1 == 0) goto L_0x04dd
            java.lang.String r2 = r1.zza     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            r6.put(r2, r1)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
        L_0x04dd:
            boolean r1 = com.google.android.gms.internal.ads.zzfy.zzb(r4, r8)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            if (r1 == 0) goto L_0x04e9
            r8 = r16
            r3 = r25
            goto L_0x0619
        L_0x04e9:
            r11 = r16
            r2 = r17
            r5 = r38
            goto L_0x026f
        L_0x04f1:
            r38 = r5
            r16 = r11
            int r1 = r4.getAttributeCount()     // Catch:{ zzald -> 0x0629 }
            r2 = 0
            com.google.android.gms.internal.ads.zzamk r32 = zzf(r4, r2)     // Catch:{ zzald -> 0x0629 }
            r27 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r33 = r2
            r35 = r33
            r34 = r20
            r29 = r27
            r36 = r29
            r39 = r36
            r5 = 0
        L_0x0510:
            if (r5 >= r1) goto L_0x05c2
            java.lang.String r8 = r4.getAttributeName(r5)     // Catch:{ zzald -> 0x05b9 }
            java.lang.String r11 = r4.getAttributeValue(r5)     // Catch:{ zzald -> 0x05b9 }
            int r13 = r8.hashCode()     // Catch:{ zzald -> 0x05b9 }
            r2 = 5
            switch(r13) {
                case -934795532: goto L_0x0553;
                case 99841: goto L_0x0549;
                case 100571: goto L_0x053f;
                case 93616297: goto L_0x0535;
                case 109780401: goto L_0x052d;
                case 1292595405: goto L_0x0523;
                default: goto L_0x0522;
            }
        L_0x0522:
            goto L_0x055b
        L_0x0523:
            java.lang.String r13 = "backgroundImage"
            boolean r8 = r8.equals(r13)
            if (r8 == 0) goto L_0x055b
            r8 = r2
            goto L_0x055c
        L_0x052d:
            boolean r8 = r8.equals(r14)
            if (r8 == 0) goto L_0x055b
            r8 = 3
            goto L_0x055c
        L_0x0535:
            java.lang.String r13 = "begin"
            boolean r8 = r8.equals(r13)
            if (r8 == 0) goto L_0x055b
            r8 = 0
            goto L_0x055c
        L_0x053f:
            java.lang.String r13 = "end"
            boolean r8 = r8.equals(r13)
            if (r8 == 0) goto L_0x055b
            r8 = 1
            goto L_0x055c
        L_0x0549:
            java.lang.String r13 = "dur"
            boolean r8 = r8.equals(r13)
            if (r8 == 0) goto L_0x055b
            r8 = 2
            goto L_0x055c
        L_0x0553:
            boolean r8 = r8.equals(r3)
            if (r8 == 0) goto L_0x055b
            r8 = 4
            goto L_0x055c
        L_0x055b:
            r8 = -1
        L_0x055c:
            if (r8 == 0) goto L_0x05ab
            r13 = 1
            if (r8 == r13) goto L_0x05a3
            r13 = 2
            if (r8 == r13) goto L_0x059b
            r13 = 3
            if (r8 == r13) goto L_0x0589
            r13 = 4
            if (r8 == r13) goto L_0x057f
            if (r8 == r2) goto L_0x056e
        L_0x056c:
            r2 = 1
            goto L_0x0593
        L_0x056e:
            java.lang.String r2 = "#"
            boolean r2 = r11.startsWith(r2)     // Catch:{ zzald -> 0x057c }
            if (r2 == 0) goto L_0x056c
            r2 = 1
            java.lang.String r35 = r11.substring(r2)     // Catch:{ zzald -> 0x0596 }
            goto L_0x0593
        L_0x057c:
            r0 = move-exception
            r2 = 1
            goto L_0x0597
        L_0x057f:
            r2 = 1
            boolean r8 = r6.containsKey(r11)     // Catch:{ zzald -> 0x0596 }
            if (r8 == 0) goto L_0x0593
            r34 = r11
            goto L_0x0593
        L_0x0589:
            r2 = 1
            java.lang.String[] r8 = zzg(r11)     // Catch:{ zzald -> 0x0596 }
            int r11 = r8.length     // Catch:{ zzald -> 0x0596 }
            if (r11 <= 0) goto L_0x0593
            r33 = r8
        L_0x0593:
            r8 = r16
            goto L_0x05b2
        L_0x0596:
            r0 = move-exception
        L_0x0597:
            r1 = r0
            r8 = r16
            goto L_0x05be
        L_0x059b:
            r8 = r16
            r2 = 1
            long r39 = zzc(r11, r8)     // Catch:{ zzald -> 0x05e3 }
            goto L_0x05b2
        L_0x05a3:
            r2 = r13
            r8 = r16
            long r29 = zzc(r11, r8)     // Catch:{ zzald -> 0x05e3 }
            goto L_0x05b2
        L_0x05ab:
            r8 = r16
            r2 = 1
            long r36 = zzc(r11, r8)     // Catch:{ zzald -> 0x05e3 }
        L_0x05b2:
            int r5 = r5 + 1
            r16 = r8
            r2 = 0
            goto L_0x0510
        L_0x05b9:
            r0 = move-exception
            r8 = r16
            r2 = 1
        L_0x05bd:
            r1 = r0
        L_0x05be:
            r3 = r25
            goto L_0x0630
        L_0x05c2:
            r8 = r16
            r2 = 1
            if (r9 == 0) goto L_0x05e5
            long r13 = r9.zzd     // Catch:{ zzald -> 0x05e3 }
            int r1 = (r13 > r27 ? 1 : (r13 == r27 ? 0 : -1))
            if (r1 == 0) goto L_0x05e1
            int r1 = (r36 > r27 ? 1 : (r36 == r27 ? 0 : -1))
            if (r1 == 0) goto L_0x05d4
            long r36 = r36 + r13
            goto L_0x05d6
        L_0x05d4:
            r36 = r27
        L_0x05d6:
            int r1 = (r29 > r27 ? 1 : (r29 == r27 ? 0 : -1))
            if (r1 == 0) goto L_0x05dd
            long r29 = r29 + r13
            goto L_0x05e1
        L_0x05dd:
            r1 = r9
            r29 = r27
            goto L_0x05e6
        L_0x05e1:
            r1 = r9
            goto L_0x05e6
        L_0x05e3:
            r0 = move-exception
            goto L_0x05bd
        L_0x05e5:
            r1 = 0
        L_0x05e6:
            int r3 = (r29 > r27 ? 1 : (r29 == r27 ? 0 : -1))
            if (r3 != 0) goto L_0x0601
            int r3 = (r39 > r27 ? 1 : (r39 == r27 ? 0 : -1))
            if (r3 == 0) goto L_0x05f3
            long r39 = r36 + r39
            r30 = r39
            goto L_0x0603
        L_0x05f3:
            if (r1 == 0) goto L_0x05fe
            long r13 = r1.zze     // Catch:{ zzald -> 0x05e3 }
            int r3 = (r13 > r27 ? 1 : (r13 == r27 ? 0 : -1))
            if (r3 == 0) goto L_0x05fe
            r30 = r13
            goto L_0x0603
        L_0x05fe:
            r30 = r27
            goto L_0x0603
        L_0x0601:
            r30 = r29
        L_0x0603:
            java.lang.String r27 = r4.getName()     // Catch:{ zzald -> 0x0625 }
            r28 = r36
            r36 = r1
            com.google.android.gms.internal.ads.zzame r1 = com.google.android.gms.internal.ads.zzame.zzb(r27, r28, r30, r32, r33, r34, r35, r36)     // Catch:{ zzald -> 0x0625 }
            r3 = r25
            r3.push(r1)     // Catch:{ zzald -> 0x0623 }
            if (r9 == 0) goto L_0x0619
            r9.zzf(r1)     // Catch:{ zzald -> 0x0623 }
        L_0x0619:
            r11 = r8
            r16 = r10
            r17 = r15
            r14 = r23
            r15 = r24
            goto L_0x063d
        L_0x0623:
            r0 = move-exception
            goto L_0x062f
        L_0x0625:
            r0 = move-exception
            r3 = r25
            goto L_0x062f
        L_0x0629:
            r0 = move-exception
            r8 = r16
            r3 = r25
            r2 = 1
        L_0x062f:
            r1 = r0
        L_0x0630:
            java.lang.String r5 = "Suppressing parser error"
            com.google.android.gms.internal.ads.zzfe.zzg(r12, r5, r1)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            r11 = r8
            r16 = r10
            r17 = r15
            r14 = r23
            r15 = r2
        L_0x063d:
            r2 = r38
            goto L_0x06a1
        L_0x0641:
            r26 = r2
            r38 = r5
            r3 = r8
            r23 = r14
            r24 = r15
            r2 = 4
            if (r10 != r2) goto L_0x065c
            r9.getClass()
            java.lang.String r1 = r4.getText()     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            com.google.android.gms.internal.ads.zzame r1 = com.google.android.gms.internal.ads.zzame.zzc(r1)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            r9.zzf(r1)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            goto L_0x0682
        L_0x065c:
            r2 = 3
            if (r10 != r2) goto L_0x0682
            java.lang.String r2 = r4.getName()     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            boolean r1 = r2.equals(r1)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            if (r1 == 0) goto L_0x067a
            com.google.android.gms.internal.ads.zzaml r14 = new com.google.android.gms.internal.ads.zzaml     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            java.lang.Object r1 = r3.peek()     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            com.google.android.gms.internal.ads.zzame r1 = (com.google.android.gms.internal.ads.zzame) r1     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            r1.getClass()
            r2 = r38
            r14.<init>(r1, r2, r6, r7)     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            goto L_0x067e
        L_0x067a:
            r2 = r38
            r14 = r23
        L_0x067e:
            r3.pop()     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            goto L_0x069f
        L_0x0682:
            r2 = r38
            goto L_0x069d
        L_0x0685:
            r20 = r1
            r26 = r2
            r2 = r5
            r3 = r8
            r1 = r12
            r23 = r14
            r24 = r15
            if (r10 != r1) goto L_0x0697
            int r15 = r24 + 1
        L_0x0694:
            r14 = r23
            goto L_0x06a1
        L_0x0697:
            r1 = 3
            if (r10 != r1) goto L_0x069d
            int r15 = r24 + -1
            goto L_0x0694
        L_0x069d:
            r14 = r23
        L_0x069f:
            r15 = r24
        L_0x06a1:
            r4.next()     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            int r10 = r4.getEventType()     // Catch:{ XmlPullParserException -> 0x06c3, IOException -> 0x06b9 }
            r5 = r2
            r8 = r3
            r1 = r20
            r2 = r26
            r9 = 0
            r3 = r41
            goto L_0x005d
        L_0x06b3:
            r23 = r14
            r23.getClass()
            return r23
        L_0x06b9:
            r0 = move-exception
            r1 = r0
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "Unexpected error when reading input."
            r2.<init>(r3, r1)
            throw r2
        L_0x06c3:
            r0 = move-exception
            r1 = r0
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "Unable to decode source"
            r2.<init>(r3, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamh.zzb(byte[], int, int):com.google.android.gms.internal.ads.zzalc");
    }

    public zzamh() {
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            this.zzi = newInstance;
            newInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }
}
