package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zztm extends Exception {
    public final String zza;
    public final boolean zzb;
    public final zzti zzc;
    public final String zzd;
    public final zztm zze;

    public zztm(zzam zzam, Throwable th, boolean z, int i) {
        this("Decoder init failed: [" + i + "], " + zzam.toString(), th, zzam.zzm, false, (zzti) null, "androidx.media3.exoplayer.mediacodec.MediaCodecRenderer_neg_" + Math.abs(i), (zztm) null);
    }

    static /* bridge */ /* synthetic */ zztm zza(zztm zztm, zztm zztm2) {
        return new zztm(zztm.getMessage(), zztm.getCause(), zztm.zza, false, zztm.zzc, zztm.zzd, zztm2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zztm(com.google.android.gms.internal.ads.zzam r11, java.lang.Throwable r12, boolean r13, com.google.android.gms.internal.ads.zzti r14) {
        /*
            r10 = this;
            java.lang.String r13 = r14.zza
            java.lang.String r0 = r11.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Decoder init failed: "
            r1.<init>(r2)
            r1.append(r13)
            java.lang.String r13 = ", "
            r1.append(r13)
            r1.append(r0)
            java.lang.String r3 = r1.toString()
            java.lang.String r5 = r11.zzm
            int r11 = com.google.android.gms.internal.ads.zzfx.zza
            boolean r11 = r12 instanceof android.media.MediaCodec.CodecException
            if (r11 == 0) goto L_0x002c
            r11 = r12
            android.media.MediaCodec$CodecException r11 = (android.media.MediaCodec.CodecException) r11
            java.lang.String r11 = r11.getDiagnosticInfo()
            goto L_0x002d
        L_0x002c:
            r11 = 0
        L_0x002d:
            r8 = r11
            r6 = 0
            r9 = 0
            r2 = r10
            r4 = r12
            r7 = r14
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztm.<init>(com.google.android.gms.internal.ads.zzam, java.lang.Throwable, boolean, com.google.android.gms.internal.ads.zzti):void");
    }

    private zztm(String str, Throwable th, String str2, boolean z, zzti zzti, String str3, zztm zztm) {
        super(str, th);
        this.zza = str2;
        this.zzb = false;
        this.zzc = zzti;
        this.zzd = str3;
        this.zze = zztm;
    }
}
