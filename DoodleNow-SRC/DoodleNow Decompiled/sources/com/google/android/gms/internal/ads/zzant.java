package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzant implements zzano {
    private static final float[] zza = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};
    private final zzapd zzb;
    private final zzfo zzc;
    private final boolean[] zzd;
    private final zzanr zze;
    private final zzaod zzf;
    private zzans zzg;
    private long zzh;
    private String zzi;
    private zzaem zzj;
    private boolean zzk;
    private long zzl;

    public zzant() {
        this((zzapd) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x012e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzfo r18) {
        /*
            r17 = this;
            r0 = r17
            com.google.android.gms.internal.ads.zzans r1 = r0.zzg
            com.google.android.gms.internal.ads.zzek.zzb(r1)
            com.google.android.gms.internal.ads.zzaem r1 = r0.zzj
            com.google.android.gms.internal.ads.zzek.zzb(r1)
            int r1 = r18.zzd()
            int r2 = r18.zze()
            byte[] r3 = r18.zzM()
            long r4 = r0.zzh
            int r6 = r18.zzb()
            long r6 = (long) r6
            long r4 = r4 + r6
            r0.zzh = r4
            com.google.android.gms.internal.ads.zzaem r4 = r0.zzj
            int r5 = r18.zzb()
            r6 = r18
            r4.zzq(r6, r5)
        L_0x002d:
            boolean[] r4 = r0.zzd
            int r4 = com.google.android.gms.internal.ads.zzgl.zza(r3, r1, r2, r4)
            if (r4 != r2) goto L_0x004b
            boolean r4 = r0.zzk
            if (r4 != 0) goto L_0x003e
            com.google.android.gms.internal.ads.zzanr r4 = r0.zze
            r4.zza(r3, r1, r2)
        L_0x003e:
            com.google.android.gms.internal.ads.zzans r4 = r0.zzg
            r4.zza(r3, r1, r2)
            com.google.android.gms.internal.ads.zzaod r4 = r0.zzf
            if (r4 == 0) goto L_0x004a
            r4.zza(r3, r1, r2)
        L_0x004a:
            return
        L_0x004b:
            byte[] r5 = r18.zzM()
            int r7 = r4 + 3
            byte r5 = r5[r7]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r8 = r4 - r1
            boolean r9 = r0.zzk
            if (r9 != 0) goto L_0x0180
            if (r8 <= 0) goto L_0x0062
            com.google.android.gms.internal.ads.zzanr r9 = r0.zze
            r9.zza(r3, r1, r4)
        L_0x0062:
            if (r8 >= 0) goto L_0x0066
            int r9 = -r8
            goto L_0x0067
        L_0x0066:
            r9 = 0
        L_0x0067:
            com.google.android.gms.internal.ads.zzanr r12 = r0.zze
            boolean r9 = r12.zzc(r5, r9)
            if (r9 == 0) goto L_0x0180
            com.google.android.gms.internal.ads.zzaem r9 = r0.zzj
            com.google.android.gms.internal.ads.zzanr r12 = r0.zze
            int r13 = r12.zzb
            java.lang.String r14 = r0.zzi
            r14.getClass()
            byte[] r15 = r12.zzc
            int r12 = r12.zza
            byte[] r12 = java.util.Arrays.copyOf(r15, r12)
            com.google.android.gms.internal.ads.zzfn r15 = new com.google.android.gms.internal.ads.zzfn
            int r10 = r12.length
            r15.<init>(r12, r10)
            r15.zzn(r13)
            r10 = 4
            r15.zzn(r10)
            r15.zzl()
            r13 = 8
            r15.zzm(r13)
            boolean r16 = r15.zzo()
            r11 = 3
            if (r16 == 0) goto L_0x00a4
            r15.zzm(r10)
            r15.zzm(r11)
        L_0x00a4:
            int r10 = r15.zzd(r10)
            r16 = 1065353216(0x3f800000, float:1.0)
            java.lang.String r11 = "Invalid aspect ratio"
            java.lang.String r13 = "H263Reader"
            r6 = 15
            if (r10 != r6) goto L_0x00c7
            r6 = 8
            int r10 = r15.zzd(r6)
            int r6 = r15.zzd(r6)
            if (r6 != 0) goto L_0x00c2
            com.google.android.gms.internal.ads.zzfe.zzf(r13, r11)
            goto L_0x00d2
        L_0x00c2:
            float r10 = (float) r10
            float r6 = (float) r6
            float r16 = r10 / r6
            goto L_0x00d2
        L_0x00c7:
            r6 = 7
            if (r10 >= r6) goto L_0x00cf
            float[] r6 = zza
            r16 = r6[r10]
            goto L_0x00d2
        L_0x00cf:
            com.google.android.gms.internal.ads.zzfe.zzf(r13, r11)
        L_0x00d2:
            r6 = r16
            boolean r10 = r15.zzo()
            r11 = 2
            if (r10 == 0) goto L_0x0110
            r15.zzm(r11)
            r10 = 1
            r15.zzm(r10)
            boolean r10 = r15.zzo()
            if (r10 == 0) goto L_0x0110
            r10 = 15
            r15.zzm(r10)
            r15.zzl()
            r15.zzm(r10)
            r15.zzl()
            r15.zzm(r10)
            r15.zzl()
            r11 = 3
            r15.zzm(r11)
            r11 = 11
            r15.zzm(r11)
            r15.zzl()
            r15.zzm(r10)
            r15.zzl()
            r10 = 2
            goto L_0x0111
        L_0x0110:
            r10 = r11
        L_0x0111:
            int r10 = r15.zzd(r10)
            if (r10 == 0) goto L_0x011c
            java.lang.String r10 = "Unhandled video object layer shape"
            com.google.android.gms.internal.ads.zzfe.zzf(r13, r10)
        L_0x011c:
            r15.zzl()
            r10 = 16
            int r10 = r15.zzd(r10)
            r15.zzl()
            boolean r11 = r15.zzo()
            if (r11 == 0) goto L_0x0143
            if (r10 != 0) goto L_0x0136
            java.lang.String r10 = "Invalid vop_increment_time_resolution"
            com.google.android.gms.internal.ads.zzfe.zzf(r13, r10)
            goto L_0x0143
        L_0x0136:
            int r10 = r10 + -1
            r11 = 0
        L_0x0139:
            if (r10 <= 0) goto L_0x0140
            int r10 = r10 >> 1
            int r11 = r11 + 1
            goto L_0x0139
        L_0x0140:
            r15.zzm(r11)
        L_0x0143:
            r15.zzl()
            r10 = 13
            int r11 = r15.zzd(r10)
            r15.zzl()
            int r10 = r15.zzd(r10)
            r15.zzl()
            r15.zzl()
            com.google.android.gms.internal.ads.zzak r13 = new com.google.android.gms.internal.ads.zzak
            r13.<init>()
            r13.zzK(r14)
            java.lang.String r14 = "video/mp4v-es"
            r13.zzW(r14)
            r13.zzab(r11)
            r13.zzI(r10)
            r13.zzS(r6)
            java.util.List r6 = java.util.Collections.singletonList(r12)
            r13.zzL(r6)
            com.google.android.gms.internal.ads.zzam r6 = r13.zzac()
            r9.zzl(r6)
            r6 = 1
            r0.zzk = r6
        L_0x0180:
            com.google.android.gms.internal.ads.zzans r6 = r0.zzg
            r6.zza(r3, r1, r4)
            com.google.android.gms.internal.ads.zzaod r6 = r0.zzf
            if (r6 == 0) goto L_0x01cc
            if (r8 <= 0) goto L_0x0190
            r6.zza(r3, r1, r4)
            r10 = 0
            goto L_0x0191
        L_0x0190:
            int r10 = -r8
        L_0x0191:
            com.google.android.gms.internal.ads.zzaod r1 = r0.zzf
            boolean r1 = r1.zzd(r10)
            if (r1 == 0) goto L_0x01b7
            com.google.android.gms.internal.ads.zzaod r1 = r0.zzf
            byte[] r6 = r1.zza
            int r1 = r1.zzb
            int r1 = com.google.android.gms.internal.ads.zzgl.zzb(r6, r1)
            com.google.android.gms.internal.ads.zzfo r6 = r0.zzc
            int r8 = com.google.android.gms.internal.ads.zzfx.zza
            com.google.android.gms.internal.ads.zzaod r8 = r0.zzf
            byte[] r8 = r8.zza
            r6.zzI(r8, r1)
            com.google.android.gms.internal.ads.zzapd r1 = r0.zzb
            long r8 = r0.zzl
            com.google.android.gms.internal.ads.zzfo r6 = r0.zzc
            r1.zza(r8, r6)
        L_0x01b7:
            r1 = 178(0xb2, float:2.5E-43)
            if (r5 != r1) goto L_0x01cc
            byte[] r5 = r18.zzM()
            int r6 = r4 + 2
            byte r5 = r5[r6]
            r6 = 1
            if (r5 != r6) goto L_0x01cb
            com.google.android.gms.internal.ads.zzaod r5 = r0.zzf
            r5.zzc(r1)
        L_0x01cb:
            r5 = r1
        L_0x01cc:
            int r1 = r2 - r4
            long r8 = r0.zzh
            long r10 = (long) r1
            long r8 = r8 - r10
            com.google.android.gms.internal.ads.zzans r4 = r0.zzg
            boolean r6 = r0.zzk
            r4.zzb(r8, r1, r6)
            com.google.android.gms.internal.ads.zzans r1 = r0.zzg
            long r8 = r0.zzl
            r1.zzc(r5, r8)
            r6 = r18
            r1 = r7
            goto L_0x002d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzant.zza(com.google.android.gms.internal.ads.zzfo):void");
    }

    public final void zzb(zzadi zzadi, zzapa zzapa) {
        zzapa.zzc();
        this.zzi = zzapa.zzb();
        zzaem zzw = zzadi.zzw(zzapa.zza(), 2);
        this.zzj = zzw;
        this.zzg = new zzans(zzw);
        zzapd zzapd = this.zzb;
        if (zzapd != null) {
            zzapd.zzb(zzadi, zzapa);
        }
    }

    public final void zzc(boolean z) {
        zzek.zzb(this.zzg);
        if (z) {
            this.zzg.zzb(this.zzh, 0, this.zzk);
            this.zzg.zzd();
        }
    }

    public final void zzd(long j, int i) {
        this.zzl = j;
    }

    public final void zze() {
        zzgl.zzf(this.zzd);
        this.zze.zzb();
        zzans zzans = this.zzg;
        if (zzans != null) {
            zzans.zzd();
        }
        zzaod zzaod = this.zzf;
        if (zzaod != null) {
            zzaod.zzb();
        }
        this.zzh = 0;
        this.zzl = C.TIME_UNSET;
    }

    zzant(zzapd zzapd) {
        zzfo zzfo;
        this.zzb = zzapd;
        this.zzd = new boolean[4];
        this.zze = new zzanr(128);
        this.zzl = C.TIME_UNSET;
        if (zzapd != null) {
            this.zzf = new zzaod(178, 128);
            zzfo = new zzfo();
        } else {
            zzfo = null;
            this.zzf = null;
        }
        this.zzc = zzfo;
    }
}
