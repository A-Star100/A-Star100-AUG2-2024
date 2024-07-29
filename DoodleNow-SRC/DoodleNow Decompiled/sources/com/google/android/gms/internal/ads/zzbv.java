package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbv {
    private static final String zzA = Integer.toString(0, 36);
    private static final String zzB = Integer.toString(1, 36);
    private static final String zzC = Integer.toString(2, 36);
    private static final String zzD = Integer.toString(3, 36);
    private static final String zzE = Integer.toString(4, 36);
    private static final String zzF = Integer.toString(5, 36);
    private static final String zzG = Integer.toString(6, 36);
    private static final String zzH = Integer.toString(8, 36);
    private static final String zzI = Integer.toString(9, 36);
    private static final String zzJ = Integer.toString(10, 36);
    private static final String zzK = Integer.toString(11, 36);
    private static final String zzL = Integer.toString(12, 36);
    private static final String zzM = Integer.toString(13, 36);
    private static final String zzN = Integer.toString(14, 36);
    private static final String zzO = Integer.toString(15, 36);
    private static final String zzP = Integer.toString(16, 36);
    private static final String zzQ = Integer.toString(17, 36);
    private static final String zzR = Integer.toString(18, 36);
    private static final String zzS = Integer.toString(19, 36);
    private static final String zzT = Integer.toString(20, 36);
    private static final String zzU = Integer.toString(21, 36);
    private static final String zzV = Integer.toString(22, 36);
    private static final String zzW = Integer.toString(23, 36);
    private static final String zzX = Integer.toString(24, 36);
    private static final String zzY = Integer.toString(25, 36);
    private static final String zzZ = Integer.toString(26, 36);
    public static final zzbv zza = new zzbv(new zzbt());
    private static final String zzaa = Integer.toString(27, 36);
    private static final String zzab = Integer.toString(28, 36);
    private static final String zzac = Integer.toString(29, 36);
    private static final String zzad = Integer.toString(30, 36);
    private static final String zzae = Integer.toString(31, 36);
    private static final String zzaf = Integer.toString(32, 36);
    private static final String zzag = Integer.toString(1000, 36);
    @Deprecated
    public static final zzn zzb = zzbr.zza;
    public final CharSequence zzc;
    public final CharSequence zzd;
    public final CharSequence zze;
    public final CharSequence zzf;
    public final CharSequence zzg;
    public final byte[] zzh;
    public final Integer zzi;
    public final Integer zzj;
    public final Integer zzk;
    @Deprecated
    public final Integer zzl;
    public final Boolean zzm;
    @Deprecated
    public final Integer zzn;
    public final Integer zzo;
    public final Integer zzp;
    public final Integer zzq;
    public final Integer zzr;
    public final Integer zzs;
    public final Integer zzt;
    public final CharSequence zzu;
    public final CharSequence zzv;
    public final CharSequence zzw;
    public final CharSequence zzx;
    public final CharSequence zzy;
    public final Integer zzz;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: int} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v12 */
    /* JADX WARNING: type inference failed for: r3v14 */
    /* JADX WARNING: type inference failed for: r3v15 */
    /* JADX WARNING: type inference failed for: r3v16 */
    /* JADX WARNING: type inference failed for: r3v17 */
    /* JADX WARNING: type inference failed for: r3v18 */
    /* JADX WARNING: type inference failed for: r3v19 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzbv(com.google.android.gms.internal.ads.zzbt r8) {
        /*
            r7 = this;
            r7.<init>()
            java.lang.Boolean r0 = r8.zzk
            java.lang.Integer r1 = r8.zzj
            java.lang.Integer r2 = r8.zzw
            r3 = 1
            r4 = -1
            r5 = 0
            if (r0 == 0) goto L_0x0042
            boolean r6 = r0.booleanValue()
            if (r6 != 0) goto L_0x0020
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            goto L_0x0076
        L_0x0020:
            if (r1 == 0) goto L_0x0028
            int r6 = r1.intValue()
            if (r6 != r4) goto L_0x0076
        L_0x0028:
            if (r2 == 0) goto L_0x003c
            int r1 = r2.intValue()
            switch(r1) {
                case 1: goto L_0x003d;
                case 2: goto L_0x003d;
                case 3: goto L_0x003d;
                case 4: goto L_0x003d;
                case 5: goto L_0x003d;
                case 6: goto L_0x003d;
                case 7: goto L_0x003d;
                case 8: goto L_0x003d;
                case 9: goto L_0x003d;
                case 10: goto L_0x003d;
                case 11: goto L_0x003d;
                case 12: goto L_0x003d;
                case 13: goto L_0x003d;
                case 14: goto L_0x003d;
                case 15: goto L_0x003d;
                case 16: goto L_0x003d;
                case 17: goto L_0x003d;
                case 18: goto L_0x003d;
                case 19: goto L_0x003d;
                case 20: goto L_0x0031;
                case 21: goto L_0x003a;
                case 22: goto L_0x0038;
                case 23: goto L_0x0036;
                case 24: goto L_0x0034;
                case 25: goto L_0x0032;
                default: goto L_0x0031;
            }
        L_0x0031:
            goto L_0x003c
        L_0x0032:
            r3 = 6
            goto L_0x003d
        L_0x0034:
            r3 = 5
            goto L_0x003d
        L_0x0036:
            r3 = 4
            goto L_0x003d
        L_0x0038:
            r3 = 3
            goto L_0x003d
        L_0x003a:
            r3 = 2
            goto L_0x003d
        L_0x003c:
            r3 = r5
        L_0x003d:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            goto L_0x0076
        L_0x0042:
            if (r1 == 0) goto L_0x0075
            int r0 = r1.intValue()
            if (r0 == r4) goto L_0x004b
            goto L_0x004c
        L_0x004b:
            r3 = r5
        L_0x004c:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r3)
            boolean r3 = r0.booleanValue()
            if (r3 == 0) goto L_0x0076
            if (r2 != 0) goto L_0x0076
            int r2 = r1.intValue()
            switch(r2) {
                case 1: goto L_0x0070;
                case 2: goto L_0x006e;
                case 3: goto L_0x006b;
                case 4: goto L_0x0068;
                case 5: goto L_0x0065;
                case 6: goto L_0x0062;
                default: goto L_0x005f;
            }
        L_0x005f:
            r5 = 20
            goto L_0x0070
        L_0x0062:
            r5 = 25
            goto L_0x0070
        L_0x0065:
            r5 = 24
            goto L_0x0070
        L_0x0068:
            r5 = 23
            goto L_0x0070
        L_0x006b:
            r5 = 22
            goto L_0x0070
        L_0x006e:
            r5 = 21
        L_0x0070:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
            goto L_0x0076
        L_0x0075:
            r1 = 0
        L_0x0076:
            java.lang.CharSequence r3 = r8.zza
            r7.zzc = r3
            java.lang.CharSequence r3 = r8.zzb
            r7.zzd = r3
            java.lang.CharSequence r3 = r8.zzc
            r7.zze = r3
            java.lang.CharSequence r3 = r8.zzd
            r7.zzf = r3
            java.lang.CharSequence r3 = r8.zze
            r7.zzg = r3
            byte[] r3 = r8.zzf
            r7.zzh = r3
            java.lang.Integer r3 = r8.zzg
            r7.zzi = r3
            java.lang.Integer r3 = r8.zzh
            r7.zzj = r3
            java.lang.Integer r3 = r8.zzi
            r7.zzk = r3
            r7.zzl = r1
            r7.zzm = r0
            java.lang.Integer r0 = r8.zzl
            r7.zzn = r0
            java.lang.Integer r0 = r8.zzl
            r7.zzo = r0
            java.lang.Integer r0 = r8.zzm
            r7.zzp = r0
            java.lang.Integer r0 = r8.zzn
            r7.zzq = r0
            java.lang.Integer r0 = r8.zzo
            r7.zzr = r0
            java.lang.Integer r0 = r8.zzp
            r7.zzs = r0
            java.lang.Integer r0 = r8.zzq
            r7.zzt = r0
            java.lang.CharSequence r0 = r8.zzr
            r7.zzu = r0
            java.lang.CharSequence r0 = r8.zzs
            r7.zzv = r0
            java.lang.CharSequence r0 = r8.zzt
            r7.zzw = r0
            java.lang.CharSequence r0 = r8.zzu
            r7.zzx = r0
            java.lang.CharSequence r8 = r8.zzv
            r7.zzy = r8
            r7.zzz = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbv.<init>(com.google.android.gms.internal.ads.zzbt):void");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzbv zzbv = (zzbv) obj;
            return zzfx.zzG(this.zzc, zzbv.zzc) && zzfx.zzG(this.zzd, zzbv.zzd) && zzfx.zzG(this.zze, zzbv.zze) && zzfx.zzG(this.zzf, zzbv.zzf) && zzfx.zzG((Object) null, (Object) null) && zzfx.zzG((Object) null, (Object) null) && zzfx.zzG(this.zzg, zzbv.zzg) && zzfx.zzG((Object) null, (Object) null) && zzfx.zzG((Object) null, (Object) null) && Arrays.equals(this.zzh, zzbv.zzh) && zzfx.zzG(this.zzi, zzbv.zzi) && zzfx.zzG((Object) null, (Object) null) && zzfx.zzG(this.zzj, zzbv.zzj) && zzfx.zzG(this.zzk, zzbv.zzk) && zzfx.zzG(this.zzl, zzbv.zzl) && zzfx.zzG(this.zzm, zzbv.zzm) && zzfx.zzG((Object) null, (Object) null) && zzfx.zzG(this.zzo, zzbv.zzo) && zzfx.zzG(this.zzp, zzbv.zzp) && zzfx.zzG(this.zzq, zzbv.zzq) && zzfx.zzG(this.zzr, zzbv.zzr) && zzfx.zzG(this.zzs, zzbv.zzs) && zzfx.zzG(this.zzt, zzbv.zzt) && zzfx.zzG(this.zzu, zzbv.zzu) && zzfx.zzG(this.zzv, zzbv.zzv) && zzfx.zzG(this.zzw, zzbv.zzw) && zzfx.zzG((Object) null, (Object) null) && zzfx.zzG((Object) null, (Object) null) && zzfx.zzG(this.zzx, zzbv.zzx) && zzfx.zzG((Object) null, (Object) null) && zzfx.zzG(this.zzy, zzbv.zzy) && zzfx.zzG(this.zzz, zzbv.zzz);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzc, this.zzd, this.zze, this.zzf, null, null, this.zzg, null, null, Integer.valueOf(Arrays.hashCode(this.zzh)), this.zzi, null, this.zzj, this.zzk, this.zzl, this.zzm, null, this.zzo, this.zzp, this.zzq, this.zzr, this.zzs, this.zzt, this.zzu, this.zzv, this.zzw, null, null, this.zzx, null, this.zzy, this.zzz});
    }

    public final zzbt zza() {
        return new zzbt(this, (zzbs) null);
    }
}
