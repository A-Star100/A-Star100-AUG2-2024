package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzala implements zzalf {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(com.google.android.gms.internal.ads.zzam r4) {
        /*
            r3 = this;
            java.lang.String r4 = r4.zzm
            if (r4 == 0) goto L_0x0068
            int r0 = r4.hashCode()
            r1 = 1
            r2 = 2
            switch(r0) {
                case -1351681404: goto L_0x0054;
                case -1248334819: goto L_0x004a;
                case -1026075066: goto L_0x0040;
                case -1004728940: goto L_0x0036;
                case 691401887: goto L_0x002c;
                case 822864842: goto L_0x0022;
                case 1668750253: goto L_0x0018;
                case 1693976202: goto L_0x000e;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x005e
        L_0x000e:
            java.lang.String r0 = "application/ttml+xml"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x005e
            r0 = 7
            goto L_0x005f
        L_0x0018:
            java.lang.String r0 = "application/x-subrip"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x005e
            r0 = 3
            goto L_0x005f
        L_0x0022:
            java.lang.String r0 = "text/x-ssa"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x005e
            r0 = 0
            goto L_0x005f
        L_0x002c:
            java.lang.String r0 = "application/x-quicktime-tx3g"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x005e
            r0 = 4
            goto L_0x005f
        L_0x0036:
            java.lang.String r0 = "text/vtt"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x005e
            r0 = r1
            goto L_0x005f
        L_0x0040:
            java.lang.String r0 = "application/x-mp4-vtt"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x005e
            r0 = r2
            goto L_0x005f
        L_0x004a:
            java.lang.String r0 = "application/pgs"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x005e
            r0 = 5
            goto L_0x005f
        L_0x0054:
            java.lang.String r0 = "application/dvbsubs"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x005e
            r0 = 6
            goto L_0x005f
        L_0x005e:
            r0 = -1
        L_0x005f:
            switch(r0) {
                case 0: goto L_0x0067;
                case 1: goto L_0x0067;
                case 2: goto L_0x0066;
                case 3: goto L_0x0065;
                case 4: goto L_0x0064;
                case 5: goto L_0x0064;
                case 6: goto L_0x0064;
                case 7: goto L_0x0063;
                default: goto L_0x0062;
            }
        L_0x0062:
            goto L_0x0068
        L_0x0063:
            return r1
        L_0x0064:
            return r2
        L_0x0065:
            return r1
        L_0x0066:
            return r2
        L_0x0067:
            return r1
        L_0x0068:
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Unsupported MIME type: "
            java.lang.String r4 = r1.concat(r4)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzala.zza(com.google.android.gms.internal.ads.zzam):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzalh zzb(com.google.android.gms.internal.ads.zzam r3) {
        /*
            r2 = this;
            java.lang.String r0 = r3.zzm
            if (r0 == 0) goto L_0x0097
            int r1 = r0.hashCode()
            switch(r1) {
                case -1351681404: goto L_0x0052;
                case -1248334819: goto L_0x0048;
                case -1026075066: goto L_0x003e;
                case -1004728940: goto L_0x0034;
                case 691401887: goto L_0x002a;
                case 822864842: goto L_0x0020;
                case 1668750253: goto L_0x0016;
                case 1693976202: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x005c
        L_0x000c:
            java.lang.String r1 = "application/ttml+xml"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x005c
            r1 = 7
            goto L_0x005d
        L_0x0016:
            java.lang.String r1 = "application/x-subrip"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x005c
            r1 = 3
            goto L_0x005d
        L_0x0020:
            java.lang.String r1 = "text/x-ssa"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x005c
            r1 = 0
            goto L_0x005d
        L_0x002a:
            java.lang.String r1 = "application/x-quicktime-tx3g"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x005c
            r1 = 4
            goto L_0x005d
        L_0x0034:
            java.lang.String r1 = "text/vtt"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x005c
            r1 = 1
            goto L_0x005d
        L_0x003e:
            java.lang.String r1 = "application/x-mp4-vtt"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x005c
            r1 = 2
            goto L_0x005d
        L_0x0048:
            java.lang.String r1 = "application/pgs"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x005c
            r1 = 5
            goto L_0x005d
        L_0x0052:
            java.lang.String r1 = "application/dvbsubs"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x005c
            r1 = 6
            goto L_0x005d
        L_0x005c:
            r1 = -1
        L_0x005d:
            switch(r1) {
                case 0: goto L_0x008f;
                case 1: goto L_0x0089;
                case 2: goto L_0x0083;
                case 3: goto L_0x007d;
                case 4: goto L_0x0075;
                case 5: goto L_0x006f;
                case 6: goto L_0x0067;
                case 7: goto L_0x0061;
                default: goto L_0x0060;
            }
        L_0x0060:
            goto L_0x0097
        L_0x0061:
            com.google.android.gms.internal.ads.zzamh r3 = new com.google.android.gms.internal.ads.zzamh
            r3.<init>()
            return r3
        L_0x0067:
            com.google.android.gms.internal.ads.zzalt r0 = new com.google.android.gms.internal.ads.zzalt
            java.util.List r3 = r3.zzo
            r0.<init>(r3)
            return r0
        L_0x006f:
            com.google.android.gms.internal.ads.zzalv r3 = new com.google.android.gms.internal.ads.zzalv
            r3.<init>()
            return r3
        L_0x0075:
            com.google.android.gms.internal.ads.zzamm r0 = new com.google.android.gms.internal.ads.zzamm
            java.util.List r3 = r3.zzo
            r0.<init>(r3)
            return r0
        L_0x007d:
            com.google.android.gms.internal.ads.zzamb r3 = new com.google.android.gms.internal.ads.zzamb
            r3.<init>()
            return r3
        L_0x0083:
            com.google.android.gms.internal.ads.zzamn r3 = new com.google.android.gms.internal.ads.zzamn
            r3.<init>()
            return r3
        L_0x0089:
            com.google.android.gms.internal.ads.zzamy r3 = new com.google.android.gms.internal.ads.zzamy
            r3.<init>()
            return r3
        L_0x008f:
            com.google.android.gms.internal.ads.zzalx r0 = new com.google.android.gms.internal.ads.zzalx
            java.util.List r3 = r3.zzo
            r0.<init>(r3)
            return r0
        L_0x0097:
            java.lang.String r3 = java.lang.String.valueOf(r0)
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Unsupported MIME type: "
            java.lang.String r3 = r1.concat(r3)
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzala.zzb(com.google.android.gms.internal.ads.zzam):com.google.android.gms.internal.ads.zzalh");
    }

    public final boolean zzc(zzam zzam) {
        String str = zzam.zzm;
        return Objects.equals(str, MimeTypes.TEXT_SSA) || Objects.equals(str, MimeTypes.TEXT_VTT) || Objects.equals(str, MimeTypes.APPLICATION_MP4VTT) || Objects.equals(str, MimeTypes.APPLICATION_SUBRIP) || Objects.equals(str, MimeTypes.APPLICATION_TX3G) || Objects.equals(str, MimeTypes.APPLICATION_PGS) || Objects.equals(str, MimeTypes.APPLICATION_DVBSUBS) || Objects.equals(str, MimeTypes.APPLICATION_TTML);
    }
}
