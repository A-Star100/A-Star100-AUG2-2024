package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.google.android.exoplayer2.C;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzll {
    private final zzcu zza = new zzcu();
    private final zzcw zzb = new zzcw();
    private final zzmp zzc;
    private final zzev zzd;
    private long zze;
    private int zzf;
    private boolean zzg;
    private zzli zzh;
    private zzli zzi;
    private zzli zzj;
    private int zzk;
    private Object zzl;
    private long zzm;
    private final zzkr zzn;

    public zzll(zzmp zzmp, zzev zzev, zzkr zzkr) {
        this.zzc = zzmp;
        this.zzd = zzev;
        this.zzn = zzkr;
    }

    private final boolean zzA(zzcx zzcx, zzvh zzvh) {
        if (!zzC(zzvh)) {
            return false;
        }
        int i = zzcx.zzn(zzvh.zza, this.zza).zzd;
        if (zzcx.zze(i, this.zzb, 0).zzq == zzcx.zza(zzvh.zza)) {
            return true;
        }
        return false;
    }

    private final boolean zzB(zzcx zzcx) {
        zzli zzli = this.zzh;
        if (zzli == null) {
            return true;
        }
        int zza2 = zzcx.zza(zzli.zzb);
        while (true) {
            zza2 = zzcx.zzi(zza2, this.zza, this.zzb, this.zzf, this.zzg);
            while (true) {
                zzli.getClass();
                if (zzli.zzg() == null || zzli.zzf.zzg) {
                    zzli zzg2 = zzli.zzg();
                } else {
                    zzli = zzli.zzg();
                }
            }
            zzli zzg22 = zzli.zzg();
            if (zza2 == -1 || zzg22 == null || zzcx.zza(zzg22.zzb) != zza2) {
                boolean zzn2 = zzn(zzli);
                zzli.zzf = zzh(zzcx, zzli.zzf);
            } else {
                zzli = zzg22;
            }
        }
        boolean zzn22 = zzn(zzli);
        zzli.zzf = zzh(zzcx, zzli.zzf);
        if (!zzn22) {
            return true;
        }
        return false;
    }

    private static final boolean zzC(zzvh zzvh) {
        return !zzvh.zzb() && zzvh.zze == -1;
    }

    private final long zzs(zzcx zzcx, Object obj, int i) {
        zzcx.zzn(obj, this.zza);
        this.zza.zzi(i);
        this.zza.zzk(i);
        return 0;
    }

    private final zzlj zzt(zzcx zzcx, zzli zzli, long j) {
        long j2;
        zzcx zzcx2 = zzcx;
        zzlj zzlj = zzli.zzf;
        long zze2 = (zzli.zze() + zzlj.zze) - j;
        if (zzlj.zzg) {
            int zza2 = zzcx2.zza(zzlj.zza.zza);
            int i = this.zzf;
            boolean z = this.zzg;
            long j3 = 0;
            int zzi2 = zzcx.zzi(zza2, this.zza, this.zzb, i, z);
            if (zzi2 != -1) {
                int i2 = zzcx2.zzd(zzi2, this.zza, true).zzd;
                Object obj = this.zza.zzc;
                obj.getClass();
                long j4 = zzlj.zza.zzd;
                if (zzcx2.zze(i2, this.zzb, 0).zzp == zzi2) {
                    Pair zzm2 = zzcx.zzm(this.zzb, this.zza, i2, C.TIME_UNSET, Math.max(0, zze2));
                    if (zzm2 != null) {
                        obj = zzm2.first;
                        long longValue = ((Long) zzm2.second).longValue();
                        zzli zzg2 = zzli.zzg();
                        if (zzg2 == null || !zzg2.zzb.equals(obj)) {
                            j4 = this.zze;
                            this.zze = 1 + j4;
                        } else {
                            j4 = zzg2.zzf.zza.zzd;
                        }
                        j2 = longValue;
                        j3 = C.TIME_UNSET;
                    }
                } else {
                    j2 = 0;
                }
                zzvh zzx = zzx(zzcx, obj, j2, j4, this.zzb, this.zza);
                if (!(j3 == C.TIME_UNSET || zzlj.zzc == C.TIME_UNSET)) {
                    zzcx2.zzn(zzlj.zza.zza, this.zza).zzb();
                    this.zza.zzg();
                }
                return zzu(zzcx, zzx, j3, j2);
            }
        } else {
            zzvh zzvh = zzlj.zza;
            zzcx2.zzn(zzvh.zza, this.zza);
            if (zzvh.zzb()) {
                int i3 = zzvh.zzb;
                if (this.zza.zza(i3) != -1) {
                    int zzf2 = this.zza.zzf(i3, zzvh.zzc);
                    if (zzf2 < 0) {
                        return zzv(zzcx, zzvh.zza, i3, zzf2, zzlj.zzc, zzvh.zzd);
                    }
                    long j5 = zzlj.zzc;
                    if (j5 == C.TIME_UNSET) {
                        zzcw zzcw = this.zzb;
                        zzcu zzcu = this.zza;
                        Pair zzm3 = zzcx.zzm(zzcw, zzcu, zzcu.zzd, C.TIME_UNSET, Math.max(0, zze2));
                        if (zzm3 != null) {
                            j5 = ((Long) zzm3.second).longValue();
                        }
                    }
                    zzs(zzcx2, zzvh.zza, zzvh.zzb);
                    return zzw(zzcx, zzvh.zza, Math.max(0, j5), zzlj.zzc, zzvh.zzd);
                }
            } else {
                int i4 = zzvh.zze;
                if (i4 != -1) {
                    this.zza.zzm(i4);
                }
                zzcu zzcu2 = this.zza;
                int i5 = zzvh.zze;
                int zze3 = zzcu2.zze(i5);
                zzcu2.zzn(i5);
                if (zze3 != this.zza.zza(zzvh.zze)) {
                    return zzv(zzcx, zzvh.zza, zzvh.zze, zze3, zzlj.zze, zzvh.zzd);
                }
                zzs(zzcx2, zzvh.zza, zzvh.zze);
                return zzw(zzcx, zzvh.zza, 0, zzlj.zze, zzvh.zzd);
            }
        }
        return null;
    }

    private final zzlj zzu(zzcx zzcx, zzvh zzvh, long j, long j2) {
        zzvh zzvh2 = zzvh;
        zzcx zzcx2 = zzcx;
        zzcx.zzn(zzvh2.zza, this.zza);
        if (zzvh.zzb()) {
            return zzv(zzcx, zzvh2.zza, zzvh2.zzb, zzvh2.zzc, j, zzvh2.zzd);
        }
        return zzw(zzcx, zzvh2.zza, j2, j, zzvh2.zzd);
    }

    private final zzlj zzv(zzcx zzcx, Object obj, int i, int i2, long j, long j2) {
        zzvh zzvh = new zzvh(obj, i, i2, j2);
        long zzh2 = zzcx.zzn(zzvh.zza, this.zza).zzh(zzvh.zzb, zzvh.zzc);
        if (i2 == this.zza.zze(i)) {
            this.zza.zzj();
        }
        this.zza.zzn(zzvh.zzb);
        return new zzlj(zzvh, (zzh2 == C.TIME_UNSET || zzh2 > 0) ? 0 : Math.max(0, -1 + zzh2), j, C.TIME_UNSET, zzh2, false, false, false, false);
    }

    private final zzlj zzw(zzcx zzcx, Object obj, long j, long j2, long j3) {
        long j4;
        long j5;
        long j6;
        zzcx zzcx2 = zzcx;
        Object obj2 = obj;
        long j7 = j;
        zzcx2.zzn(obj2, this.zza);
        int zzc2 = this.zza.zzc(j7);
        if (zzc2 != -1) {
            this.zza.zzm(zzc2);
        }
        if (zzc2 == -1) {
            this.zza.zzb();
        } else {
            this.zza.zzn(zzc2);
        }
        zzvh zzvh = new zzvh(obj2, j3, zzc2);
        boolean zzC = zzC(zzvh);
        boolean zzA = zzA(zzcx2, zzvh);
        boolean zzz = zzz(zzcx2, zzvh, zzC);
        if (zzc2 != -1) {
            this.zza.zzn(zzc2);
        }
        if (zzc2 != -1) {
            this.zza.zzi(zzc2);
            j4 = 0;
        } else {
            j4 = -9223372036854775807L;
        }
        if (j4 != C.TIME_UNSET) {
            j6 = 0;
            j5 = 0;
        } else {
            j6 = j4;
            j5 = this.zza.zze;
        }
        if (j5 != C.TIME_UNSET && j7 >= j5) {
            j7 = Math.max(0, j5 - 1);
        }
        return new zzlj(zzvh, j7, j2, j6, j5, false, zzC, zzA, zzz);
    }

    private static zzvh zzx(zzcx zzcx, Object obj, long j, long j2, zzcw zzcw, zzcu zzcu) {
        zzcx zzcx2 = zzcx;
        Object obj2 = obj;
        long j3 = j;
        zzcu zzcu2 = zzcu;
        zzcx.zzn(obj, zzcu2);
        zzcw zzcw2 = zzcw;
        zzcx.zze(zzcu2.zzd, zzcw, 0);
        zzcx.zza(obj);
        zzcu.zzb();
        zzcx.zzn(obj, zzcu2);
        int zzd2 = zzcu2.zzd(j);
        if (zzd2 == -1) {
            long j4 = j2;
            return new zzvh(obj, j2, zzcu2.zzc(j));
        }
        long j5 = j2;
        return new zzvh(obj, zzd2, zzcu2.zze(zzd2), j2);
    }

    private final void zzy() {
        zzvh zzvh;
        zzfzk zzfzk = new zzfzk();
        for (zzli zzli = this.zzh; zzli != null; zzli = zzli.zzg()) {
            zzfzk.zzf(zzli.zzf.zza);
        }
        zzli zzli2 = this.zzi;
        if (zzli2 == null) {
            zzvh = null;
        } else {
            zzvh = zzli2.zzf.zza;
        }
        this.zzd.zzh(new zzlk(this, zzfzk, zzvh));
    }

    private final boolean zzz(zzcx zzcx, zzvh zzvh, boolean z) {
        int zza2 = zzcx.zza(zzvh.zza);
        if (!zzcx.zze(zzcx.zzd(zza2, this.zza, false).zzd, this.zzb, 0).zzj) {
            if (zzcx.zzi(zza2, this.zza, this.zzb, this.zzf, this.zzg) != -1 || !z) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final zzli zza() {
        zzli zzli = this.zzh;
        if (zzli == null) {
            return null;
        }
        if (zzli == this.zzi) {
            this.zzi = zzli.zzg();
        }
        zzli.zzn();
        int i = this.zzk - 1;
        this.zzk = i;
        if (i == 0) {
            this.zzj = null;
            zzli zzli2 = this.zzh;
            this.zzl = zzli2.zzb;
            this.zzm = zzli2.zzf.zza.zzd;
        }
        this.zzh = this.zzh.zzg();
        zzy();
        return this.zzh;
    }

    public final zzli zzb() {
        zzli zzli = this.zzi;
        zzek.zzb(zzli);
        this.zzi = zzli.zzg();
        zzy();
        zzli zzli2 = this.zzi;
        zzek.zzb(zzli2);
        return zzli2;
    }

    public final zzli zzd() {
        return this.zzj;
    }

    public final zzli zze() {
        return this.zzh;
    }

    public final zzli zzf() {
        return this.zzi;
    }

    public final zzlj zzg(long j, zzly zzly) {
        zzli zzli = this.zzj;
        if (zzli != null) {
            return zzt(zzly.zza, zzli, j);
        }
        return zzu(zzly.zza, zzly.zzb, zzly.zzc, zzly.zzr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzlj zzh(com.google.android.gms.internal.ads.zzcx r19, com.google.android.gms.internal.ads.zzlj r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            com.google.android.gms.internal.ads.zzvh r3 = r2.zza
            boolean r12 = zzC(r3)
            boolean r13 = r0.zzA(r1, r3)
            boolean r14 = r0.zzz(r1, r3, r12)
            com.google.android.gms.internal.ads.zzvh r4 = r2.zza
            java.lang.Object r4 = r4.zza
            com.google.android.gms.internal.ads.zzcu r5 = r0.zza
            r1.zzn(r4, r5)
            boolean r1 = r3.zzb()
            r4 = -1
            r5 = 0
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r1 != 0) goto L_0x0037
            int r1 = r3.zze
            if (r1 != r4) goto L_0x0030
            goto L_0x0037
        L_0x0030:
            com.google.android.gms.internal.ads.zzcu r9 = r0.zza
            r9.zzi(r1)
            r9 = r5
            goto L_0x0038
        L_0x0037:
            r9 = r7
        L_0x0038:
            boolean r1 = r3.zzb()
            if (r1 == 0) goto L_0x004b
            com.google.android.gms.internal.ads.zzcu r1 = r0.zza
            int r5 = r3.zzb
            int r6 = r3.zzc
            long r5 = r1.zzh(r5, r6)
        L_0x0048:
            r7 = r9
            r9 = r5
            goto L_0x0057
        L_0x004b:
            int r1 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r1 == 0) goto L_0x0052
            r7 = r5
            r9 = r7
            goto L_0x0057
        L_0x0052:
            com.google.android.gms.internal.ads.zzcu r1 = r0.zza
            long r5 = r1.zze
            goto L_0x0048
        L_0x0057:
            boolean r1 = r3.zzb()
            if (r1 == 0) goto L_0x0065
            com.google.android.gms.internal.ads.zzcu r1 = r0.zza
            int r4 = r3.zzb
            r1.zzn(r4)
            goto L_0x006e
        L_0x0065:
            int r1 = r3.zze
            if (r1 == r4) goto L_0x006e
            com.google.android.gms.internal.ads.zzcu r4 = r0.zza
            r4.zzn(r1)
        L_0x006e:
            com.google.android.gms.internal.ads.zzlj r15 = new com.google.android.gms.internal.ads.zzlj
            long r4 = r2.zzb
            long r1 = r2.zzc
            r11 = 0
            r16 = r1
            r1 = r15
            r2 = r3
            r3 = r4
            r5 = r16
            r1.<init>(r2, r3, r5, r7, r9, r11, r12, r13, r14)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzll.zzh(com.google.android.gms.internal.ads.zzcx, com.google.android.gms.internal.ads.zzlj):com.google.android.gms.internal.ads.zzlj");
    }

    public final zzvh zzi(zzcx zzcx, Object obj, long j) {
        long j2;
        int zza2;
        int i = zzcx.zzn(obj, this.zza).zzd;
        Object obj2 = this.zzl;
        if (obj2 == null || (zza2 = zzcx.zza(obj2)) == -1 || zzcx.zzd(zza2, this.zza, false).zzd != i) {
            zzli zzli = this.zzh;
            while (true) {
                if (zzli == null) {
                    zzli zzli2 = this.zzh;
                    while (true) {
                        if (zzli2 != null) {
                            int zza3 = zzcx.zza(zzli2.zzb);
                            if (zza3 != -1 && zzcx.zzd(zza3, this.zza, false).zzd == i) {
                                j2 = zzli2.zzf.zza.zzd;
                                break;
                            }
                            zzli2 = zzli2.zzg();
                        } else {
                            j2 = this.zze;
                            this.zze = 1 + j2;
                            if (this.zzh == null) {
                                this.zzl = obj;
                                this.zzm = j2;
                            }
                        }
                    }
                } else if (zzli.zzb.equals(obj)) {
                    j2 = zzli.zzf.zza.zzd;
                    break;
                } else {
                    zzli = zzli.zzg();
                }
            }
        } else {
            j2 = this.zzm;
        }
        long j3 = j2;
        zzcx.zzn(obj, this.zza);
        zzcx.zze(this.zza.zzd, this.zzb, 0);
        int zza4 = zzcx.zza(obj);
        Object obj3 = obj;
        while (true) {
            zzcw zzcw = this.zzb;
            if (zza4 < zzcw.zzp) {
                return zzx(zzcx, obj3, j, j3, zzcw, this.zza);
            }
            zzcx.zzd(zza4, this.zza, true);
            this.zza.zzb();
            zzcu zzcu = this.zza;
            if (zzcu.zzd(zzcu.zze) != -1) {
                obj3 = this.zza.zzc;
                obj3.getClass();
            }
            zza4--;
        }
    }

    public final void zzj() {
        if (this.zzk != 0) {
            zzli zzli = this.zzh;
            zzek.zzb(zzli);
            this.zzl = zzli.zzb;
            this.zzm = zzli.zzf.zza.zzd;
            while (zzli != null) {
                zzli.zzn();
                zzli = zzli.zzg();
            }
            this.zzh = null;
            this.zzj = null;
            this.zzi = null;
            this.zzk = 0;
            zzy();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzk(zzfzk zzfzk, zzvh zzvh) {
        this.zzc.zzS(zzfzk.zzi(), zzvh);
    }

    public final void zzl(long j) {
        zzli zzli = this.zzj;
        if (zzli != null) {
            zzli.zzm(j);
        }
    }

    public final boolean zzm(zzvf zzvf) {
        zzli zzli = this.zzj;
        return zzli != null && zzli.zza == zzvf;
    }

    public final boolean zzn(zzli zzli) {
        zzek.zzb(zzli);
        boolean z = false;
        if (zzli.equals(this.zzj)) {
            return false;
        }
        this.zzj = zzli;
        while (zzli.zzg() != null) {
            zzli = zzli.zzg();
            zzli.getClass();
            if (zzli == this.zzi) {
                this.zzi = this.zzh;
                z = true;
            }
            zzli.zzn();
            this.zzk--;
        }
        zzli zzli2 = this.zzj;
        zzli2.getClass();
        zzli2.zzo((zzli) null);
        zzy();
        return z;
    }

    public final boolean zzo() {
        zzli zzli = this.zzj;
        if (zzli == null) {
            return true;
        }
        if (zzli.zzf.zzi || !zzli.zzr() || this.zzj.zzf.zze == C.TIME_UNSET) {
            return false;
        }
        return this.zzk < 100;
    }

    public final boolean zzp(zzcx zzcx, long j, long j2) {
        zzlj zzlj;
        long j3;
        boolean z;
        zzcx zzcx2 = zzcx;
        zzli zzli = this.zzh;
        zzli zzli2 = null;
        while (zzli != null) {
            zzlj zzlj2 = zzli.zzf;
            if (zzli2 == null) {
                zzlj = zzh(zzcx2, zzlj2);
                long j4 = j;
            } else {
                zzlj zzt = zzt(zzcx2, zzli2, j);
                if (zzt == null) {
                    return !zzn(zzli2);
                }
                if (zzlj2.zzb != zzt.zzb || !zzlj2.zza.equals(zzt.zza)) {
                    return !zzn(zzli2);
                }
                zzlj = zzt;
            }
            zzli.zzf = zzlj.zza(zzlj2.zzc);
            long j5 = zzlj2.zze;
            int i = (j5 > C.TIME_UNSET ? 1 : (j5 == C.TIME_UNSET ? 0 : -1));
            long j6 = zzlj.zze;
            if (i == 0 || j5 == j6) {
                zzli2 = zzli;
                zzli = zzli.zzg();
            } else {
                zzli.zzq();
                long j7 = zzlj.zze;
                if (j7 == C.TIME_UNSET) {
                    j3 = Long.MAX_VALUE;
                } else {
                    j3 = j7 + zzli.zze();
                }
                if (zzli == this.zzi) {
                    boolean z2 = zzli.zzf.zzf;
                    if (j2 == Long.MIN_VALUE || j2 >= j3) {
                        z = true;
                        return zzn(zzli) && !z;
                    }
                }
                z = false;
                if (zzn(zzli)) {
                }
            }
        }
        return true;
    }

    public final boolean zzq(zzcx zzcx, int i) {
        this.zzf = i;
        return zzB(zzcx);
    }

    public final boolean zzr(zzcx zzcx, boolean z) {
        this.zzg = z;
        return zzB(zzcx);
    }

    public final zzli zzc(zzlj zzlj) {
        long j;
        zzli zzli = this.zzj;
        if (zzli == null) {
            j = MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US;
        } else {
            j = (zzli.zze() + zzli.zzf.zze) - zzlj.zzb;
        }
        zzli zzd2 = zzkz.zzd(this.zzn.zza, zzlj, j);
        zzli zzli2 = this.zzj;
        if (zzli2 != null) {
            zzli2.zzo(zzd2);
        } else {
            this.zzh = zzd2;
            this.zzi = zzd2;
        }
        this.zzl = null;
        this.zzj = zzd2;
        this.zzk++;
        zzy();
        return zzd2;
    }
}
