package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import androidx.work.WorkRequest;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzwk implements zzvf, zzadi, zzzt, zzzy, zzww {
    /* access modifiers changed from: private */
    public static final Map zzb;
    /* access modifiers changed from: private */
    public static final zzam zzc;
    /* access modifiers changed from: private */
    public long zzA;
    private boolean zzB;
    private int zzC;
    private boolean zzD;
    private boolean zzE;
    private int zzF;
    private boolean zzG;
    private long zzH;
    private long zzI;
    private boolean zzJ;
    private int zzK;
    private boolean zzL;
    private boolean zzM;
    private final zzzs zzN;
    private final zzzo zzO;
    private final Uri zzd;
    private final zzgv zze;
    private final zzsm zzf;
    private final zzvq zzg;
    private final zzsg zzh;
    private final zzwg zzi;
    /* access modifiers changed from: private */
    public final long zzj;
    private final zzaab zzk = new zzaab("ProgressiveMediaPeriod");
    private final zzvz zzl;
    private final zzeo zzm;
    private final Runnable zzn;
    /* access modifiers changed from: private */
    public final Runnable zzo;
    /* access modifiers changed from: private */
    public final Handler zzp;
    private final boolean zzq;
    private zzve zzr;
    /* access modifiers changed from: private */
    public zzagm zzs;
    private zzwx[] zzt;
    private zzwi[] zzu;
    private boolean zzv;
    private boolean zzw;
    private boolean zzx;
    private zzwj zzy;
    private zzaef zzz;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_NAME, "1");
        zzb = Collections.unmodifiableMap(hashMap);
        zzak zzak = new zzak();
        zzak.zzK("icy");
        zzak.zzW(MimeTypes.APPLICATION_ICY);
        zzc = zzak.zzac();
    }

    public zzwk(Uri uri, zzgv zzgv, zzvz zzvz, zzsm zzsm, zzsg zzsg, zzzs zzzs, zzvq zzvq, zzwg zzwg, zzzo zzzo, String str, int i, long j) {
        this.zzd = uri;
        this.zze = zzgv;
        this.zzf = zzsm;
        this.zzh = zzsg;
        this.zzN = zzzs;
        this.zzg = zzvq;
        this.zzi = zzwg;
        this.zzO = zzzo;
        this.zzj = (long) i;
        this.zzl = zzvz;
        this.zzA = j;
        this.zzq = j != C.TIME_UNSET;
        this.zzm = new zzeo(zzel.zza);
        this.zzn = new zzwb(this);
        this.zzo = new zzwc(this);
        this.zzp = zzfx.zzx((Handler.Callback) null);
        this.zzu = new zzwi[0];
        this.zzt = new zzwx[0];
        this.zzI = C.TIME_UNSET;
        this.zzC = 1;
    }

    private final int zzQ() {
        int i = 0;
        for (zzwx zzd2 : this.zzt) {
            i += zzd2.zzd();
        }
        return i;
    }

    /* access modifiers changed from: private */
    public final long zzR(boolean z) {
        int i = 0;
        long j = Long.MIN_VALUE;
        while (true) {
            zzwx[] zzwxArr = this.zzt;
            if (i >= zzwxArr.length) {
                return j;
            }
            if (!z) {
                zzwj zzwj = this.zzy;
                zzwj.getClass();
                if (!zzwj.zzc[i]) {
                    i++;
                }
            }
            j = Math.max(j, zzwxArr[i].zzh());
            i++;
        }
    }

    private final zzaem zzS(zzwi zzwi) {
        int length = this.zzt.length;
        for (int i = 0; i < length; i++) {
            if (zzwi.equals(this.zzu[i])) {
                return this.zzt[i];
            }
        }
        zzwx zzwx = new zzwx(this.zzO, this.zzf, this.zzh);
        zzwx.zzu(this);
        int i2 = length + 1;
        zzwi[] zzwiArr = (zzwi[]) Arrays.copyOf(this.zzu, i2);
        zzwiArr[length] = zzwi;
        int i3 = zzfx.zza;
        this.zzu = zzwiArr;
        zzwx[] zzwxArr = (zzwx[]) Arrays.copyOf(this.zzt, i2);
        zzwxArr[length] = zzwx;
        this.zzt = zzwxArr;
        return zzwx;
    }

    @EnsuresNonNull({"trackState", "seekMap"})
    private final void zzT() {
        zzek.zzf(this.zzw);
        this.zzy.getClass();
        this.zzz.getClass();
    }

    /* access modifiers changed from: private */
    public final void zzU() {
        int i;
        zzby zzby;
        if (!this.zzM && !this.zzw && this.zzv && this.zzz != null) {
            zzwx[] zzwxArr = this.zzt;
            int length = zzwxArr.length;
            int i2 = 0;
            while (i2 < length) {
                if (zzwxArr[i2].zzi() != null) {
                    i2++;
                } else {
                    return;
                }
            }
            this.zzm.zzc();
            int length2 = this.zzt.length;
            zzcz[] zzczArr = new zzcz[length2];
            boolean[] zArr = new boolean[length2];
            for (int i3 = 0; i3 < length2; i3++) {
                zzam zzi2 = this.zzt[i3].zzi();
                zzi2.getClass();
                String str = zzi2.zzm;
                boolean zzg2 = zzcb.zzg(str);
                boolean z = zzg2 || zzcb.zzh(str);
                zArr[i3] = z;
                this.zzx = z | this.zzx;
                zzagm zzagm = this.zzs;
                if (zzagm != null) {
                    if (zzg2 || this.zzu[i3].zzb) {
                        zzby zzby2 = zzi2.zzk;
                        if (zzby2 == null) {
                            zzby = new zzby(C.TIME_UNSET, zzagm);
                        } else {
                            zzby = zzby2.zzc(zzagm);
                        }
                        zzak zzb2 = zzi2.zzb();
                        zzb2.zzP(zzby);
                        zzi2 = zzb2.zzac();
                    }
                    if (zzg2 && zzi2.zzg == -1 && zzi2.zzh == -1 && (i = zzagm.zza) != -1) {
                        zzak zzb3 = zzi2.zzb();
                        zzb3.zzx(i);
                        zzi2 = zzb3.zzac();
                    }
                }
                zzczArr[i3] = new zzcz(Integer.toString(i3), zzi2.zzc(this.zzf.zza(zzi2)));
            }
            this.zzy = new zzwj(new zzxk(zzczArr), zArr);
            this.zzw = true;
            zzve zzve = this.zzr;
            zzve.getClass();
            zzve.zzi(this);
        }
    }

    private final void zzV(int i) {
        zzT();
        zzwj zzwj = this.zzy;
        boolean[] zArr = zzwj.zzd;
        if (!zArr[i]) {
            zzam zzb2 = zzwj.zza.zzb(i).zzb(0);
            this.zzg.zzc(new zzvd(1, zzcb.zzb(zzb2.zzm), zzb2, 0, (Object) null, zzfx.zzu(this.zzH), C.TIME_UNSET));
            zArr[i] = true;
        }
    }

    private final void zzW(int i) {
        zzT();
        boolean[] zArr = this.zzy.zzb;
        if (this.zzJ && zArr[i] && !this.zzt[i].zzx(false)) {
            this.zzI = 0;
            this.zzJ = false;
            this.zzE = true;
            this.zzH = 0;
            this.zzK = 0;
            for (zzwx zzp2 : this.zzt) {
                zzp2.zzp(false);
            }
            zzve zzve = this.zzr;
            zzve.getClass();
            zzve.zzg(this);
        }
    }

    private final void zzX() {
        zzwf zzwf = new zzwf(this, this.zzd, this.zze, this.zzl, this, this.zzm);
        if (this.zzw) {
            zzek.zzf(zzY());
            long j = this.zzA;
            if (j == C.TIME_UNSET || this.zzI <= j) {
                zzaef zzaef = this.zzz;
                zzaef.getClass();
                zzwf.zzf(zzwf, zzaef.zzg(this.zzI).zza.zzc, this.zzI);
                for (zzwx zzt2 : this.zzt) {
                    zzt2.zzt(this.zzI);
                }
                this.zzI = C.TIME_UNSET;
            } else {
                this.zzL = true;
                this.zzI = C.TIME_UNSET;
                return;
            }
        }
        this.zzK = zzQ();
        long zza = this.zzk.zza(zzwf, this, zzzs.zza(this.zzC));
        zzhb zzd2 = zzwf.zzl;
        this.zzg.zzg(new zzuy(zzwf.zzb, zzd2, zzd2.zza, Collections.emptyMap(), zza, 0, 0), new zzvd(1, -1, (zzam) null, 0, (Object) null, zzfx.zzu(zzwf.zzk), zzfx.zzu(this.zzA)));
    }

    private final boolean zzY() {
        return this.zzI != C.TIME_UNSET;
    }

    private final boolean zzZ() {
        return this.zzE || zzY();
    }

    public final void zzD() {
        this.zzv = true;
        this.zzp.post(this.zzn);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzF() {
        this.zzG = true;
    }

    /* access modifiers changed from: package-private */
    public final void zzH() throws IOException {
        this.zzk.zzi(zzzs.zza(this.zzC));
    }

    /* access modifiers changed from: package-private */
    public final void zzI(int i) throws IOException {
        this.zzt[i].zzm();
        zzH();
    }

    public final /* bridge */ /* synthetic */ void zzJ(zzzx zzzx, long j, long j2, boolean z) {
        zzwf zzwf = (zzwf) zzzx;
        zzhx zze2 = zzwf.zzd;
        zzuy zzuy = new zzuy(zzwf.zzb, zzwf.zzl, zze2.zzh(), zze2.zzi(), j, j2, zze2.zzg());
        long unused = zzwf.zzb;
        long zzc2 = zzwf.zzk;
        long j3 = this.zzA;
        long zzu2 = zzfx.zzu(zzc2);
        long zzu3 = zzfx.zzu(j3);
        zzvd zzvd = r5;
        zzvd zzvd2 = new zzvd(1, -1, (zzam) null, 0, (Object) null, zzu2, zzu3);
        this.zzg.zzd(zzuy, zzvd);
        if (!z) {
            for (zzwx zzp2 : this.zzt) {
                zzp2.zzp(false);
            }
            if (this.zzF > 0) {
                zzve zzve = this.zzr;
                zzve.getClass();
                zzve.zzg(this);
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzK(zzzx zzzx, long j, long j2) {
        zzaef zzaef;
        if (this.zzA == C.TIME_UNSET && (zzaef = this.zzz) != null) {
            boolean zzh2 = zzaef.zzh();
            long zzR = zzR(true);
            long j3 = zzR == Long.MIN_VALUE ? 0 : zzR + WorkRequest.MIN_BACKOFF_MILLIS;
            this.zzA = j3;
            this.zzi.zza(j3, zzh2, this.zzB);
        }
        zzwf zzwf = (zzwf) zzzx;
        zzhx zze2 = zzwf.zzd;
        long zzb2 = zzwf.zzb;
        zzhb zzd2 = zzwf.zzl;
        Uri zzh3 = zze2.zzh();
        Map zzi2 = zze2.zzi();
        long zzg2 = zze2.zzg();
        zzuy zzuy = r4;
        zzuy zzuy2 = new zzuy(zzb2, zzd2, zzh3, zzi2, j, j2, zzg2);
        long unused = zzwf.zzb;
        this.zzg.zze(zzuy, new zzvd(1, -1, (zzam) null, 0, (Object) null, zzfx.zzu(zzwf.zzk), zzfx.zzu(this.zzA)));
        this.zzL = true;
        zzve zzve = this.zzr;
        zzve.getClass();
        zzve.zzg(this);
    }

    public final void zzL() {
        for (zzwx zzo2 : this.zzt) {
            zzo2.zzo();
        }
        this.zzl.zze();
    }

    public final void zzM(zzam zzam) {
        this.zzp.post(this.zzn);
    }

    public final void zzN() {
        if (this.zzw) {
            for (zzwx zzn2 : this.zzt) {
                zzn2.zzn();
            }
        }
        this.zzk.zzj(this);
        this.zzp.removeCallbacksAndMessages((Object) null);
        this.zzr = null;
        this.zzM = true;
    }

    public final void zzO(zzaef zzaef) {
        this.zzp.post(new zzwd(this, zzaef));
    }

    /* access modifiers changed from: package-private */
    public final boolean zzP(int i) {
        return !zzZ() && this.zzt[i].zzx(this.zzL);
    }

    public final long zza(long j, zzmj zzmj) {
        long j2 = j;
        zzmj zzmj2 = zzmj;
        zzT();
        if (!this.zzz.zzh()) {
            return 0;
        }
        zzaed zzg2 = this.zzz.zzg(j2);
        zzaeg zzaeg = zzg2.zza;
        zzaeg zzaeg2 = zzg2.zzb;
        long j3 = zzmj2.zzf;
        if (j3 == 0) {
            if (zzmj2.zzg == 0) {
                return j2;
            }
            j3 = 0;
        }
        long j4 = zzaeg.zzb;
        int i = zzfx.zza;
        long j5 = j2 - j3;
        long j6 = zzmj2.zzg;
        long j7 = j2 + j6;
        long j8 = j2 ^ j7;
        long j9 = j6 ^ j7;
        if (((j2 ^ j3) & (j2 ^ j5)) < 0) {
            j5 = Long.MIN_VALUE;
        }
        if ((j8 & j9) < 0) {
            j7 = Long.MAX_VALUE;
        }
        boolean z = true;
        boolean z2 = j5 <= j4 && j4 <= j7;
        long j10 = zzaeg2.zzb;
        if (j5 > j10 || j10 > j7) {
            z = false;
        }
        if (z2 && z) {
            if (Math.abs(j4 - j2) > Math.abs(j10 - j2)) {
                return j10;
            }
        } else if (!z2) {
            return z ? j10 : j5;
        }
        return j4;
    }

    public final long zzb() {
        long j;
        zzT();
        if (this.zzL || this.zzF == 0) {
            return Long.MIN_VALUE;
        }
        if (zzY()) {
            return this.zzI;
        }
        if (this.zzx) {
            int length = this.zzt.length;
            j = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                zzwj zzwj = this.zzy;
                if (zzwj.zzb[i] && zzwj.zzc[i] && !this.zzt[i].zzw()) {
                    j = Math.min(j, this.zzt[i].zzh());
                }
            }
        } else {
            j = Long.MAX_VALUE;
        }
        if (j == Long.MAX_VALUE) {
            j = zzR(false);
        }
        return j == Long.MIN_VALUE ? this.zzH : j;
    }

    public final long zzc() {
        return zzb();
    }

    public final long zzd() {
        if (!this.zzE) {
            return C.TIME_UNSET;
        }
        if (!this.zzL && zzQ() <= this.zzK) {
            return C.TIME_UNSET;
        }
        this.zzE = false;
        return this.zzH;
    }

    public final long zze(long j) {
        boolean z;
        zzT();
        boolean[] zArr = this.zzy.zzb;
        if (true != this.zzz.zzh()) {
            j = 0;
        }
        this.zzE = false;
        this.zzH = j;
        if (zzY()) {
            this.zzI = j;
            return j;
        }
        if (this.zzC != 7) {
            int length = this.zzt.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                zzwx zzwx = this.zzt[i];
                if (this.zzq) {
                    z = zzwx.zzy(zzwx.zza());
                } else {
                    z = zzwx.zzz(j, false);
                }
                if (!z && (zArr[i] || !this.zzx)) {
                    break;
                }
                i++;
            }
            return j;
        }
        this.zzJ = false;
        this.zzI = j;
        this.zzL = false;
        zzaab zzaab = this.zzk;
        if (zzaab.zzl()) {
            for (zzwx zzk2 : this.zzt) {
                zzk2.zzk();
            }
            this.zzk.zzg();
        } else {
            zzaab.zzh();
            for (zzwx zzp2 : this.zzt) {
                zzp2.zzp(false);
            }
        }
        return j;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003e, code lost:
        if (r2 == 0) goto L_0x0047;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00d8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzf(com.google.android.gms.internal.ads.zzyz[] r8, boolean[] r9, com.google.android.gms.internal.ads.zzwy[] r10, boolean[] r11, long r12) {
        /*
            r7 = this;
            r7.zzT()
            com.google.android.gms.internal.ads.zzwj r0 = r7.zzy
            com.google.android.gms.internal.ads.zzxk r1 = r0.zza
            boolean[] r0 = r0.zzc
            int r2 = r7.zzF
            r3 = 0
            r4 = r3
        L_0x000d:
            int r5 = r8.length
            if (r4 >= r5) goto L_0x0035
            r5 = r10[r4]
            if (r5 == 0) goto L_0x0032
            r6 = r8[r4]
            if (r6 == 0) goto L_0x001c
            boolean r6 = r9[r4]
            if (r6 != 0) goto L_0x0032
        L_0x001c:
            com.google.android.gms.internal.ads.zzwh r5 = (com.google.android.gms.internal.ads.zzwh) r5
            int r5 = r5.zzb
            boolean r6 = r0[r5]
            com.google.android.gms.internal.ads.zzek.zzf(r6)
            int r6 = r7.zzF
            int r6 = r6 + -1
            r7.zzF = r6
            r0[r5] = r3
            r5 = 0
            r10[r4] = r5
        L_0x0032:
            int r4 = r4 + 1
            goto L_0x000d
        L_0x0035:
            boolean r9 = r7.zzq
            r4 = 1
            if (r9 != 0) goto L_0x004c
            boolean r9 = r7.zzD
            if (r9 == 0) goto L_0x0041
            if (r2 != 0) goto L_0x004c
            goto L_0x0047
        L_0x0041:
            r5 = 0
            int r9 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r9 == 0) goto L_0x0049
        L_0x0047:
            r9 = r4
            goto L_0x004d
        L_0x0049:
            r9 = r3
            r12 = r5
            goto L_0x004d
        L_0x004c:
            r9 = r3
        L_0x004d:
            r2 = r3
        L_0x004e:
            int r5 = r8.length
            if (r2 >= r5) goto L_0x00a7
            r5 = r10[r2]
            if (r5 != 0) goto L_0x00a4
            r5 = r8[r2]
            if (r5 == 0) goto L_0x00a4
            int r6 = r5.zzc()
            if (r6 != r4) goto L_0x0061
            r6 = r4
            goto L_0x0062
        L_0x0061:
            r6 = r3
        L_0x0062:
            com.google.android.gms.internal.ads.zzek.zzf(r6)
            int r6 = r5.zza(r3)
            if (r6 != 0) goto L_0x006d
            r6 = r4
            goto L_0x006e
        L_0x006d:
            r6 = r3
        L_0x006e:
            com.google.android.gms.internal.ads.zzek.zzf(r6)
            com.google.android.gms.internal.ads.zzcz r5 = r5.zze()
            int r5 = r1.zza(r5)
            boolean r6 = r0[r5]
            r6 = r6 ^ r4
            com.google.android.gms.internal.ads.zzek.zzf(r6)
            int r6 = r7.zzF
            int r6 = r6 + r4
            r7.zzF = r6
            r0[r5] = r4
            com.google.android.gms.internal.ads.zzwh r6 = new com.google.android.gms.internal.ads.zzwh
            r6.<init>(r7, r5)
            r10[r2] = r6
            r11[r2] = r4
            if (r9 != 0) goto L_0x00a4
            com.google.android.gms.internal.ads.zzwx[] r9 = r7.zzt
            r9 = r9[r5]
            int r5 = r9.zzb()
            if (r5 == 0) goto L_0x00a3
            boolean r9 = r9.zzz(r12, r4)
            if (r9 != 0) goto L_0x00a3
            r9 = r4
            goto L_0x00a4
        L_0x00a3:
            r9 = r3
        L_0x00a4:
            int r2 = r2 + 1
            goto L_0x004e
        L_0x00a7:
            int r8 = r7.zzF
            if (r8 != 0) goto L_0x00d8
            r7.zzJ = r3
            r7.zzE = r3
            com.google.android.gms.internal.ads.zzaab r8 = r7.zzk
            boolean r8 = r8.zzl()
            if (r8 == 0) goto L_0x00ca
            com.google.android.gms.internal.ads.zzwx[] r8 = r7.zzt
            int r9 = r8.length
        L_0x00ba:
            if (r3 >= r9) goto L_0x00c4
            r10 = r8[r3]
            r10.zzk()
            int r3 = r3 + 1
            goto L_0x00ba
        L_0x00c4:
            com.google.android.gms.internal.ads.zzaab r8 = r7.zzk
            r8.zzg()
            goto L_0x00ea
        L_0x00ca:
            com.google.android.gms.internal.ads.zzwx[] r8 = r7.zzt
            int r9 = r8.length
            r10 = r3
        L_0x00ce:
            if (r10 >= r9) goto L_0x00ea
            r11 = r8[r10]
            r11.zzp(r3)
            int r10 = r10 + 1
            goto L_0x00ce
        L_0x00d8:
            if (r9 == 0) goto L_0x00ea
            long r12 = r7.zze(r12)
        L_0x00de:
            int r8 = r10.length
            if (r3 >= r8) goto L_0x00ea
            r8 = r10[r3]
            if (r8 == 0) goto L_0x00e7
            r11[r3] = r4
        L_0x00e7:
            int r3 = r3 + 1
            goto L_0x00de
        L_0x00ea:
            r7.zzD = r4
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzwk.zzf(com.google.android.gms.internal.ads.zzyz[], boolean[], com.google.android.gms.internal.ads.zzwy[], boolean[], long):long");
    }

    /* access modifiers changed from: package-private */
    public final int zzg(int i, zzlb zzlb, zzih zzih, int i2) {
        if (zzZ()) {
            return -3;
        }
        zzV(i);
        int zze2 = this.zzt[i].zze(zzlb, zzih, i2, this.zzL);
        if (zze2 == -3) {
            zzW(i);
        }
        return zze2;
    }

    public final zzxk zzh() {
        zzT();
        return this.zzy.zza;
    }

    /* access modifiers changed from: package-private */
    public final int zzi(int i, long j) {
        if (zzZ()) {
            return 0;
        }
        zzV(i);
        zzwx zzwx = this.zzt[i];
        int zzc2 = zzwx.zzc(j, this.zzL);
        zzwx.zzv(zzc2);
        if (zzc2 != 0) {
            return zzc2;
        }
        zzW(i);
        return 0;
    }

    public final void zzj(long j, boolean z) {
        if (!this.zzq) {
            zzT();
            if (!zzY()) {
                boolean[] zArr = this.zzy.zzc;
                int length = this.zzt.length;
                for (int i = 0; i < length; i++) {
                    this.zzt[i].zzj(j, false, zArr[i]);
                }
            }
        }
    }

    public final void zzk() throws IOException {
        zzH();
        if (this.zzL && !this.zzw) {
            throw zzcc.zza("Loading finished before preparation is complete.", (Throwable) null);
        }
    }

    public final void zzl(zzve zzve, long j) {
        this.zzr = zzve;
        this.zzm.zze();
        zzX();
    }

    public final void zzm(long j) {
    }

    public final boolean zzo(zzlg zzlg) {
        if (this.zzL) {
            return false;
        }
        zzaab zzaab = this.zzk;
        if (zzaab.zzk() || this.zzJ) {
            return false;
        }
        if (this.zzw && this.zzF == 0) {
            return false;
        }
        boolean zze2 = this.zzm.zze();
        if (zzaab.zzl()) {
            return zze2;
        }
        zzX();
        return true;
    }

    public final boolean zzp() {
        return this.zzk.zzl() && this.zzm.zzd();
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00e3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ com.google.android.gms.internal.ads.zzzv zzu(com.google.android.gms.internal.ads.zzzx r22, long r23, long r25, java.io.IOException r27, int r28) {
        /*
            r21 = this;
            r0 = r21
            r1 = r27
            r2 = r22
            com.google.android.gms.internal.ads.zzwf r2 = (com.google.android.gms.internal.ads.zzwf) r2
            com.google.android.gms.internal.ads.zzhx r3 = r2.zzd
            com.google.android.gms.internal.ads.zzuy r14 = new com.google.android.gms.internal.ads.zzuy
            long r5 = r2.zzb
            com.google.android.gms.internal.ads.zzhb r7 = r2.zzl
            android.net.Uri r8 = r3.zzh()
            java.util.Map r9 = r3.zzi()
            long r15 = r3.zzg()
            r4 = r14
            r10 = r23
            r12 = r25
            r3 = r14
            r14 = r15
            r4.<init>(r5, r7, r8, r9, r10, r12, r14)
            long unused = r2.zzk
            int r4 = com.google.android.gms.internal.ads.zzfx.zza
            boolean r4 = r1 instanceof com.google.android.gms.internal.ads.zzcc
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 != 0) goto L_0x0068
            boolean r4 = r1 instanceof java.io.FileNotFoundException
            if (r4 != 0) goto L_0x0068
            boolean r4 = r1 instanceof com.google.android.gms.internal.ads.zzho
            if (r4 != 0) goto L_0x0068
            boolean r4 = r1 instanceof com.google.android.gms.internal.ads.zzaaa
            if (r4 != 0) goto L_0x0068
            r4 = r1
        L_0x0047:
            if (r4 == 0) goto L_0x005c
            boolean r7 = r4 instanceof com.google.android.gms.internal.ads.zzgw
            if (r7 == 0) goto L_0x0057
            r7 = r4
            com.google.android.gms.internal.ads.zzgw r7 = (com.google.android.gms.internal.ads.zzgw) r7
            int r7 = r7.zza
            r8 = 2008(0x7d8, float:2.814E-42)
            if (r7 != r8) goto L_0x0057
            goto L_0x0068
        L_0x0057:
            java.lang.Throwable r4 = r4.getCause()
            goto L_0x0047
        L_0x005c:
            int r4 = r28 + -1
            int r4 = r4 * 1000
            r7 = 5000(0x1388, float:7.006E-42)
            int r4 = java.lang.Math.min(r4, r7)
            long r7 = (long) r4
            goto L_0x0069
        L_0x0068:
            r7 = r5
        L_0x0069:
            int r4 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            r9 = 1
            if (r4 != 0) goto L_0x0071
            com.google.android.gms.internal.ads.zzzv r4 = com.google.android.gms.internal.ads.zzaab.zzd
            goto L_0x00bd
        L_0x0071:
            int r4 = r21.zzQ()
            int r10 = r0.zzK
            r11 = 0
            if (r4 <= r10) goto L_0x007c
            r10 = r9
            goto L_0x007d
        L_0x007c:
            r10 = r11
        L_0x007d:
            boolean r12 = r0.zzG
            if (r12 != 0) goto L_0x00b7
            com.google.android.gms.internal.ads.zzaef r12 = r0.zzz
            if (r12 == 0) goto L_0x008e
            long r12 = r12.zza()
            int r5 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r5 == 0) goto L_0x008e
            goto L_0x00b7
        L_0x008e:
            boolean r4 = r0.zzw
            if (r4 == 0) goto L_0x009d
            boolean r5 = r21.zzZ()
            if (r5 != 0) goto L_0x009d
            r0.zzJ = r9
            com.google.android.gms.internal.ads.zzzv r4 = com.google.android.gms.internal.ads.zzaab.zzc
            goto L_0x00bd
        L_0x009d:
            r0.zzE = r4
            r4 = 0
            r0.zzH = r4
            r0.zzK = r11
            com.google.android.gms.internal.ads.zzwx[] r6 = r0.zzt
            int r12 = r6.length
            r13 = r11
        L_0x00a9:
            if (r13 >= r12) goto L_0x00b3
            r14 = r6[r13]
            r14.zzp(r11)
            int r13 = r13 + 1
            goto L_0x00a9
        L_0x00b3:
            com.google.android.gms.internal.ads.zzwf.zzf(r2, r4, r4)
            goto L_0x00b9
        L_0x00b7:
            r0.zzK = r4
        L_0x00b9:
            com.google.android.gms.internal.ads.zzzv r4 = com.google.android.gms.internal.ads.zzaab.zzb(r10, r7)
        L_0x00bd:
            boolean r5 = r4.zzc()
            r5 = r5 ^ r9
            com.google.android.gms.internal.ads.zzvq r6 = r0.zzg
            long r7 = r2.zzk
            long r9 = r0.zzA
            long r17 = com.google.android.gms.internal.ads.zzfx.zzu(r7)
            long r19 = com.google.android.gms.internal.ads.zzfx.zzu(r9)
            com.google.android.gms.internal.ads.zzvd r7 = new com.google.android.gms.internal.ads.zzvd
            r12 = 1
            r13 = -1
            r14 = 0
            r15 = 0
            r16 = 0
            r11 = r7
            r11.<init>(r12, r13, r14, r15, r16, r17, r19)
            r6.zzf(r3, r7, r1, r5)
            if (r5 == 0) goto L_0x00e6
            long unused = r2.zzb
        L_0x00e6:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzwk.zzu(com.google.android.gms.internal.ads.zzzx, long, long, java.io.IOException, int):com.google.android.gms.internal.ads.zzzv");
    }

    /* access modifiers changed from: package-private */
    public final zzaem zzv() {
        return zzS(new zzwi(0, true));
    }

    public final zzaem zzw(int i, int i2) {
        return zzS(new zzwi(i, false));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzE() {
        if (!this.zzM) {
            zzve zzve = this.zzr;
            zzve.getClass();
            zzve.zzg(this);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzG(zzaef zzaef) {
        zzaef zzaef2;
        if (this.zzs == null) {
            zzaef2 = zzaef;
        } else {
            zzaef2 = new zzaee(C.TIME_UNSET, 0);
        }
        this.zzz = zzaef2;
        if (zzaef.zza() == C.TIME_UNSET && this.zzA != C.TIME_UNSET) {
            this.zzz = new zzwe(this, this.zzz);
        }
        this.zzA = this.zzz.zza();
        boolean z = false;
        int i = 1;
        if (!this.zzG && zzaef.zza() == C.TIME_UNSET) {
            z = true;
        }
        this.zzB = z;
        if (true == z) {
            i = 7;
        }
        this.zzC = i;
        this.zzi.zza(this.zzA, zzaef.zzh(), this.zzB);
        if (!this.zzw) {
            zzU();
        }
    }
}
