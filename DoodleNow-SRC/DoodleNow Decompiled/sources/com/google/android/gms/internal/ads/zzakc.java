package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzakc {
    public final boolean zza;
    public final String zzb;
    public final zzael zzc;
    public final int zzd;
    public final byte[] zze;

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003a, code lost:
        if (r6.equals(com.google.android.exoplayer2.C.CENC_TYPE_cenc) != false) goto L_0x0052;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzakc(boolean r5, java.lang.String r6, int r7, byte[] r8, int r9, int r10, byte[] r11) {
        /*
            r4 = this;
            r4.<init>()
            r0 = 0
            r1 = 1
            if (r7 != 0) goto L_0x0009
            r2 = r1
            goto L_0x000a
        L_0x0009:
            r2 = r0
        L_0x000a:
            if (r11 != 0) goto L_0x000e
            r3 = r1
            goto L_0x000f
        L_0x000e:
            r3 = r0
        L_0x000f:
            r2 = r2 ^ r3
            com.google.android.gms.internal.ads.zzek.zzd(r2)
            r4.zza = r5
            r4.zzb = r6
            r4.zzd = r7
            r4.zze = r11
            com.google.android.gms.internal.ads.zzael r5 = new com.google.android.gms.internal.ads.zzael
            if (r6 != 0) goto L_0x0020
            goto L_0x0074
        L_0x0020:
            int r7 = r6.hashCode()
            r11 = 3
            r2 = 2
            switch(r7) {
                case 3046605: goto L_0x0047;
                case 3046671: goto L_0x003d;
                case 3049879: goto L_0x0034;
                case 3049895: goto L_0x002a;
                default: goto L_0x0029;
            }
        L_0x0029:
            goto L_0x0051
        L_0x002a:
            java.lang.String r7 = "cens"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L_0x0051
            r0 = r1
            goto L_0x0052
        L_0x0034:
            java.lang.String r7 = "cenc"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L_0x0051
            goto L_0x0052
        L_0x003d:
            java.lang.String r7 = "cbcs"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L_0x0051
            r0 = r11
            goto L_0x0052
        L_0x0047:
            java.lang.String r7 = "cbc1"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L_0x0051
            r0 = r2
            goto L_0x0052
        L_0x0051:
            r0 = -1
        L_0x0052:
            if (r0 == 0) goto L_0x0074
            if (r0 == r1) goto L_0x0074
            if (r0 == r2) goto L_0x0073
            if (r0 == r11) goto L_0x0073
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r11 = "Unsupported protection scheme type '"
            r7.<init>(r11)
            r7.append(r6)
            java.lang.String r6 = "'. Assuming AES-CTR crypto mode."
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            java.lang.String r7 = "TrackEncryptionBox"
            com.google.android.gms.internal.ads.zzfe.zzf(r7, r6)
            goto L_0x0074
        L_0x0073:
            r1 = r2
        L_0x0074:
            r5.<init>(r1, r8, r9, r10)
            r4.zzc = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzakc.<init>(boolean, java.lang.String, int, byte[], int, int, byte[]):void");
    }
}
