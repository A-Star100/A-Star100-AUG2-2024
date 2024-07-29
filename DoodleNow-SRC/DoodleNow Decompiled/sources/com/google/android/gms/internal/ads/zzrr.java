package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.drm.FrameworkMediaDrm$$ExternalSyntheticApiModelOutline0;
import com.google.android.exoplayer2.util.MimeTypes;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzrr implements zzqn {
    private static final Object zza = new Object();
    private static ExecutorService zzb;
    private static int zzc;
    private zzrh zzA;
    private zzcg zzB;
    private boolean zzC;
    private long zzD;
    private long zzE;
    private long zzF;
    private long zzG;
    private int zzH;
    private boolean zzI;
    private boolean zzJ;
    private long zzK;
    private float zzL;
    private ByteBuffer zzM;
    private int zzN;
    private ByteBuffer zzO;
    private boolean zzP;
    private boolean zzQ;
    /* access modifiers changed from: private */
    public boolean zzR;
    private int zzS;
    private zzl zzT;
    private zzpp zzU;
    /* access modifiers changed from: private */
    public long zzV;
    private boolean zzW;
    private boolean zzX;
    private Looper zzY;
    private long zzZ;
    private long zzaa;
    private Handler zzab;
    private final zzrf zzac;
    private final zzqv zzad;
    private final Context zzd;
    private final zzqs zze;
    private final zzsb zzf;
    private final zzfzn zzg;
    private final zzfzn zzh;
    private final zzeo zzi;
    private final zzqr zzj;
    private final ArrayDeque zzk;
    private zzrp zzl;
    private final zzrk zzm;
    private final zzrk zzn;
    private final zzrc zzo;
    private zzpb zzp;
    /* access modifiers changed from: private */
    public zzqk zzq;
    private zzre zzr;
    private zzre zzs;
    private zzdq zzt;
    /* access modifiers changed from: private */
    public AudioTrack zzu;
    private zzph zzv;
    private zzpo zzw;
    private zzrj zzx;
    private zzk zzy;
    private zzrh zzz;

    /* synthetic */ zzrr(zzrd zzrd, zzrq zzrq) {
        zzph zzph;
        Context zza2 = zzrd.zza;
        this.zzd = zza2;
        zzk zzk2 = zzk.zza;
        this.zzy = zzk2;
        if (zza2 != null) {
            zzph zzph2 = zzph.zza;
            int i = zzfx.zza;
            zzph = zzph.zzc(zza2, zzk2, (zzpp) null);
        } else {
            zzph = zzrd.zzb;
        }
        this.zzv = zzph;
        this.zzac = zzrd.zze;
        int i2 = zzfx.zza;
        this.zzo = zzrd.zzd;
        zzqv zzf2 = zzrd.zzf;
        zzf2.getClass();
        this.zzad = zzf2;
        zzeo zzeo = new zzeo(zzel.zza);
        this.zzi = zzeo;
        zzeo.zze();
        this.zzj = new zzqr(new zzrm(this, (zzrl) null));
        zzqs zzqs = new zzqs();
        this.zze = zzqs;
        zzsb zzsb = new zzsb();
        this.zzf = zzsb;
        this.zzg = zzfzn.zzp(new zzdx(), zzqs, zzsb);
        this.zzh = zzfzn.zzn(new zzsa());
        this.zzL = 1.0f;
        this.zzS = 0;
        this.zzT = new zzl(0, 0.0f);
        this.zzA = new zzrh(zzcg.zza, 0, 0, (zzrg) null);
        this.zzB = zzcg.zza;
        this.zzC = false;
        this.zzk = new ArrayDeque();
        this.zzm = new zzrk(100);
        this.zzn = new zzrk(100);
    }

    public static /* synthetic */ void zzG(zzrr zzrr) {
        if (zzrr.zzaa >= 300000) {
            ((zzrw) zzrr.zzq).zza.zzn = true;
            zzrr.zzaa = 0;
        }
    }

    static /* synthetic */ void zzH(AudioTrack audioTrack, zzqk zzqk, Handler handler, zzqh zzqh, zzeo zzeo) {
        try {
            audioTrack.flush();
            audioTrack.release();
            if (zzqk != null && handler.getLooper().getThread().isAlive()) {
                handler.post(new zzqx(zzqk, zzqh));
            }
            zzeo.zze();
            synchronized (zza) {
                int i = zzc - 1;
                zzc = i;
                if (i == 0) {
                    zzb.shutdown();
                    zzb = null;
                }
            }
        } catch (Throwable th) {
            if (zzqk != null && handler.getLooper().getThread().isAlive()) {
                handler.post(new zzqx(zzqk, zzqh));
            }
            zzeo.zze();
            synchronized (zza) {
                int i2 = zzc - 1;
                zzc = i2;
                if (i2 == 0) {
                    zzb.shutdown();
                    zzb = null;
                }
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    public final long zzK() {
        zzre zzre = this.zzs;
        return zzre.zzc == 0 ? this.zzD / ((long) zzre.zzb) : this.zzE;
    }

    /* access modifiers changed from: private */
    public final long zzL() {
        zzre zzre = this.zzs;
        if (zzre.zzc != 0) {
            return this.zzG;
        }
        long j = this.zzF;
        long j2 = (long) zzre.zzd;
        int i = zzfx.zza;
        return ((j + j2) - 1) / j2;
    }

    private final AudioTrack zzM(zzre zzre) throws zzqj {
        try {
            return zzre.zza(this.zzy, this.zzS);
        } catch (zzqj e) {
            zzqk zzqk = this.zzq;
            if (zzqk != null) {
                zzqk.zza(e);
            }
            throw e;
        }
    }

    private final void zzN(long j) {
        zzcg zzcg;
        boolean z;
        if (zzZ()) {
            zzrf zzrf = this.zzac;
            zzcg = this.zzB;
            zzrf.zzc(zzcg);
        } else {
            zzcg = zzcg.zza;
        }
        zzcg zzcg2 = zzcg;
        this.zzB = zzcg2;
        if (zzZ()) {
            zzrf zzrf2 = this.zzac;
            z = this.zzC;
            zzrf2.zzd(z);
        } else {
            z = false;
        }
        this.zzC = z;
        this.zzk.add(new zzrh(zzcg2, Math.max(0, j), zzfx.zzs(zzL(), this.zzs.zze), (zzrg) null));
        zzU();
        zzqk zzqk = this.zzq;
        if (zzqk != null) {
            ((zzrw) zzqk).zza.zzc.zzw(this.zzC);
        }
    }

    private final void zzO() {
        if (this.zzs.zzc()) {
            this.zzW = true;
        }
    }

    private final void zzP() {
        if (this.zzw == null && this.zzd != null) {
            this.zzY = Looper.myLooper();
            zzpo zzpo = new zzpo(this.zzd, new zzqz(this), this.zzy, this.zzU);
            this.zzw = zzpo;
            this.zzv = zzpo.zzc();
        }
    }

    private final void zzQ() {
        if (!this.zzQ) {
            this.zzQ = true;
            this.zzj.zzb(zzL());
            this.zzu.stop();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002e, code lost:
        if (r0.hasRemaining() == false) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0030, code lost:
        r2.zzt.zze(r2.zzM);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0026, code lost:
        r0 = r2.zzM;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0028, code lost:
        if (r0 == null) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzR(long r3) throws com.google.android.gms.internal.ads.zzqm {
        /*
            r2 = this;
            com.google.android.gms.internal.ads.zzdq r0 = r2.zzt
            boolean r0 = r0.zzh()
            if (r0 == 0) goto L_0x0039
        L_0x0008:
            com.google.android.gms.internal.ads.zzdq r0 = r2.zzt
            boolean r0 = r0.zzg()
            if (r0 != 0) goto L_0x0038
        L_0x0010:
            com.google.android.gms.internal.ads.zzdq r0 = r2.zzt
            java.nio.ByteBuffer r0 = r0.zzb()
            boolean r1 = r0.hasRemaining()
            if (r1 == 0) goto L_0x0026
            r2.zzV(r0, r3)
            boolean r0 = r0.hasRemaining()
            if (r0 == 0) goto L_0x0010
            goto L_0x0038
        L_0x0026:
            java.nio.ByteBuffer r0 = r2.zzM
            if (r0 == 0) goto L_0x0038
            boolean r0 = r0.hasRemaining()
            if (r0 == 0) goto L_0x0038
            com.google.android.gms.internal.ads.zzdq r0 = r2.zzt
            java.nio.ByteBuffer r1 = r2.zzM
            r0.zze(r1)
            goto L_0x0008
        L_0x0038:
            return
        L_0x0039:
            java.nio.ByteBuffer r0 = r2.zzM
            if (r0 != 0) goto L_0x003f
            java.nio.ByteBuffer r0 = com.google.android.gms.internal.ads.zzdt.zza
        L_0x003f:
            r2.zzV(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrr.zzR(long):void");
    }

    private final void zzS(zzcg zzcg) {
        zzrh zzrh = new zzrh(zzcg, C.TIME_UNSET, C.TIME_UNSET, (zzrg) null);
        if (zzX()) {
            this.zzz = zzrh;
        } else {
            this.zzA = zzrh;
        }
    }

    private final void zzT() {
        if (zzX()) {
            int i = zzfx.zza;
            this.zzu.setVolume(this.zzL);
        }
    }

    private final void zzU() {
        zzdq zzdq = this.zzs.zzi;
        this.zzt = zzdq;
        zzdq.zzc();
    }

    private final void zzV(ByteBuffer byteBuffer, long j) throws zzqm {
        zzqk zzqk;
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer2 = this.zzO;
            boolean z = false;
            if (byteBuffer2 != null) {
                zzek.zzd(byteBuffer2 == byteBuffer);
            } else {
                this.zzO = byteBuffer;
                int i = zzfx.zza;
            }
            int remaining = byteBuffer.remaining();
            int i2 = zzfx.zza;
            int write = this.zzu.write(byteBuffer, remaining, 1);
            this.zzV = SystemClock.elapsedRealtime();
            if (write < 0) {
                if ((zzfx.zza >= 24 && write == -6) || write == -32) {
                    if (zzL() <= 0) {
                        if (zzY(this.zzu)) {
                            zzO();
                        }
                    }
                    z = true;
                }
                zzqm zzqm = new zzqm(write, this.zzs.zza, z);
                zzqk zzqk2 = this.zzq;
                if (zzqk2 != null) {
                    zzqk2.zza(zzqm);
                }
                if (!zzqm.zzb) {
                    this.zzn.zzb(zzqm);
                } else {
                    this.zzv = zzph.zza;
                    throw zzqm;
                }
            } else {
                this.zzn.zza();
                if (zzY(this.zzu)) {
                    if (this.zzG > 0) {
                        this.zzX = false;
                    }
                    if (this.zzR && (zzqk = this.zzq) != null && write < remaining) {
                        zzrx zzrx = ((zzrw) zzqk).zza;
                        if (zzrx.zzm != null) {
                            zzrx.zzm.zza();
                        }
                    }
                }
                int i3 = this.zzs.zzc;
                if (i3 == 0) {
                    this.zzF += (long) write;
                }
                if (write == remaining) {
                    if (i3 != 0) {
                        if (byteBuffer == this.zzM) {
                            z = true;
                        }
                        zzek.zzf(z);
                        this.zzG += ((long) this.zzH) * ((long) this.zzN);
                    }
                    this.zzO = null;
                }
            }
        }
    }

    private final boolean zzW() throws zzqm {
        if (!this.zzt.zzh()) {
            ByteBuffer byteBuffer = this.zzO;
            if (byteBuffer == null) {
                return true;
            }
            zzV(byteBuffer, Long.MIN_VALUE);
            return this.zzO == null;
        }
        this.zzt.zzd();
        zzR(Long.MIN_VALUE);
        if (!this.zzt.zzg()) {
            return false;
        }
        ByteBuffer byteBuffer2 = this.zzO;
        if (byteBuffer2 != null) {
            return !byteBuffer2.hasRemaining();
        }
        return true;
    }

    private final boolean zzX() {
        return this.zzu != null;
    }

    private static boolean zzY(AudioTrack audioTrack) {
        return zzfx.zza >= 29 && FrameworkMediaDrm$$ExternalSyntheticApiModelOutline0.m(audioTrack);
    }

    private final boolean zzZ() {
        zzre zzre = this.zzs;
        if (zzre.zzc != 0) {
            return false;
        }
        int i = zzre.zza.zzB;
        return true;
    }

    public final boolean zzA(zzam zzam) {
        return zza(zzam) != 0;
    }

    public final void zzI(zzph zzph) {
        zzek.zzf(this.zzY == Looper.myLooper());
        if (!zzph.equals(this.zzv)) {
            this.zzv = zzph;
            zzqk zzqk = this.zzq;
            if (zzqk != null) {
                ((zzrw) zzqk).zza.zzB();
            }
        }
    }

    public final int zza(zzam zzam) {
        zzP();
        if (!MimeTypes.AUDIO_RAW.equals(zzam.zzm)) {
            return this.zzv.zzb(zzam, this.zzy) != null ? 2 : 0;
        }
        if (!zzfx.zzK(zzam.zzB)) {
            int i = zzam.zzB;
            zzfe.zzf("DefaultAudioSink", "Invalid PCM encoding: " + i);
            return 0;
        } else if (zzam.zzB != 2) {
            return 1;
        } else {
            return 2;
        }
    }

    public final long zzb(boolean z) {
        long j;
        if (!zzX() || this.zzJ) {
            return Long.MIN_VALUE;
        }
        long min = Math.min(this.zzj.zza(z), zzfx.zzs(zzL(), this.zzs.zze));
        while (!this.zzk.isEmpty() && min >= ((zzrh) this.zzk.getFirst()).zzc) {
            this.zzA = (zzrh) this.zzk.remove();
        }
        zzrh zzrh = this.zzA;
        long j2 = min - zzrh.zzc;
        if (zzrh.zza.equals(zzcg.zza)) {
            j = this.zzA.zzb + j2;
        } else if (this.zzk.isEmpty()) {
            j = this.zzac.zza(j2) + this.zzA.zzb;
        } else {
            zzrh zzrh2 = (zzrh) this.zzk.getFirst();
            j = zzrh2.zzb - zzfx.zzp(zzrh2.zzc - min, this.zzA.zza.zzc);
        }
        long zzb2 = this.zzac.zzb();
        long zzs2 = j + zzfx.zzs(zzb2, this.zzs.zze);
        long j3 = this.zzZ;
        if (zzb2 > j3) {
            long zzs3 = zzfx.zzs(zzb2 - j3, this.zzs.zze);
            this.zzZ = zzb2;
            this.zzaa += zzs3;
            if (this.zzab == null) {
                this.zzab = new Handler(Looper.myLooper());
            }
            this.zzab.removeCallbacksAndMessages((Object) null);
            this.zzab.postDelayed(new zzqy(this), 100);
        }
        return zzs2;
    }

    public final zzcg zzc() {
        return this.zzB;
    }

    public final zzps zzd(zzam zzam) {
        if (this.zzW) {
            return zzps.zza;
        }
        return this.zzad.zza(zzam, this.zzy);
    }

    public final void zze(zzam zzam, int i, int[] iArr) throws zzqi {
        zzdq zzdq;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        zzam zzam2 = zzam;
        zzP();
        if (MimeTypes.AUDIO_RAW.equals(zzam2.zzm)) {
            zzek.zzd(zzfx.zzK(zzam2.zzB));
            i7 = zzfx.zzm(zzam2.zzB, zzam2.zzz);
            zzfzk zzfzk = new zzfzk();
            int i11 = zzam2.zzB;
            zzfzk.zzh(this.zzg);
            zzfzk.zzg(this.zzac.zze());
            zzdq zzdq2 = new zzdq(zzfzk.zzi());
            if (zzdq2.equals(this.zzt)) {
                zzdq2 = this.zzt;
            }
            this.zzf.zzq(zzam2.zzC, zzam2.zzD);
            this.zze.zzo(iArr);
            try {
                zzdr zza2 = zzdq2.zza(new zzdr(zzam2.zzA, zzam2.zzz, zzam2.zzB));
                i4 = zza2.zzd;
                i3 = zza2.zzb;
                int i12 = zza2.zzc;
                i2 = zzfx.zzh(i12);
                zzdq = zzdq2;
                i5 = zzfx.zzm(i4, i12);
                i6 = 0;
            } catch (zzds e) {
                throw new zzqi((Throwable) e, zzam2);
            }
        } else {
            zzdq zzdq3 = new zzdq(zzfzn.zzm());
            int i13 = zzam2.zzA;
            zzps zzps = zzps.zza;
            Pair zzb2 = this.zzv.zzb(zzam2, this.zzy);
            if (zzb2 != null) {
                i4 = ((Integer) zzb2.first).intValue();
                zzdq = zzdq3;
                i7 = -1;
                i2 = ((Integer) zzb2.second).intValue();
                i5 = -1;
                i3 = i13;
                i6 = 2;
            } else {
                throw new zzqi("Unable to configure passthrough for: ".concat(String.valueOf(String.valueOf(zzam))), zzam2);
            }
        }
        if (i4 == 0) {
            throw new zzqi("Invalid output encoding (mode=" + i6 + ") for: " + String.valueOf(zzam), zzam2);
        } else if (i2 != 0) {
            int i14 = zzam2.zzi;
            if (MimeTypes.AUDIO_DTS_EXPRESS.equals(zzam2.zzm) && i14 == -1) {
                i14 = Ac3Util.E_AC3_MAX_RATE_BYTES_PER_SECOND;
            }
            int minBufferSize = AudioTrack.getMinBufferSize(i3, i2, i4);
            zzek.zzf(minBufferSize != -2);
            int i15 = i5 != -1 ? i5 : 1;
            int i16 = 250000;
            if (i6 == 0) {
                i8 = i6;
                i9 = Math.max(zzrt.zza(250000, i3, i15), Math.min(minBufferSize * 4, zzrt.zza(750000, i3, i15)));
            } else if (i6 != 1) {
                if (i4 == 5) {
                    i16 = 500000;
                } else if (i4 == 8) {
                    i16 = 1000000;
                    i4 = 8;
                }
                if (i14 != -1) {
                    i10 = zzgcd.zza(i14, 8, RoundingMode.CEILING);
                } else {
                    i10 = zzrt.zzb(i4);
                }
                i8 = i6;
                i9 = zzgcl.zzb((((long) i16) * ((long) i10)) / 1000000);
            } else {
                i8 = i6;
                i9 = zzgcl.zzb((((long) zzrt.zzb(i4)) * 50000000) / 1000000);
            }
            this.zzW = false;
            zzre zzre = new zzre(zzam, i7, i8, i5, i3, i2, i4, (((Math.max(minBufferSize, (int) ((double) i9)) + i15) - 1) / i15) * i15, zzdq, false, false, false);
            if (zzX()) {
                this.zzr = zzre;
            } else {
                this.zzs = zzre;
            }
        } else {
            throw new zzqi("Invalid output channel config (mode=" + i6 + ") for: " + String.valueOf(zzam), zzam2);
        }
    }

    public final void zzf() {
        zzrj zzrj;
        if (zzX()) {
            this.zzD = 0;
            this.zzE = 0;
            this.zzF = 0;
            this.zzG = 0;
            this.zzX = false;
            this.zzH = 0;
            this.zzA = new zzrh(this.zzB, 0, 0, (zzrg) null);
            this.zzK = 0;
            this.zzz = null;
            this.zzk.clear();
            this.zzM = null;
            this.zzN = 0;
            this.zzO = null;
            this.zzQ = false;
            this.zzP = false;
            this.zzf.zzp();
            zzU();
            if (this.zzj.zzh()) {
                this.zzu.pause();
            }
            if (zzY(this.zzu)) {
                zzrp zzrp = this.zzl;
                zzrp.getClass();
                zzrp.zzb(this.zzu);
            }
            int i = zzfx.zza;
            zzqh zzb2 = this.zzs.zzb();
            zzre zzre = this.zzr;
            if (zzre != null) {
                this.zzs = zzre;
                this.zzr = null;
            }
            this.zzj.zzc();
            if (zzfx.zza >= 24 && (zzrj = this.zzx) != null) {
                zzrj.zzb();
                this.zzx = null;
            }
            AudioTrack audioTrack = this.zzu;
            zzeo zzeo = this.zzi;
            zzqk zzqk = this.zzq;
            zzeo.zzc();
            Handler handler = new Handler(Looper.myLooper());
            synchronized (zza) {
                if (zzb == null) {
                    zzb = zzfx.zzE("ExoPlayer:AudioTrackReleaseThread");
                }
                zzc++;
                zzb.execute(new zzqw(audioTrack, zzqk, handler, zzb2, zzeo));
            }
            this.zzu = null;
        }
        this.zzn.zza();
        this.zzm.zza();
        this.zzZ = 0;
        this.zzaa = 0;
        Handler handler2 = this.zzab;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages((Object) null);
        }
    }

    public final void zzg() {
        this.zzI = true;
    }

    public final void zzh() {
        this.zzR = false;
        if (!zzX()) {
            return;
        }
        if (this.zzj.zzk() || zzY(this.zzu)) {
            this.zzu.pause();
        }
    }

    public final void zzi() {
        this.zzR = true;
        if (zzX()) {
            this.zzj.zzf();
            this.zzu.play();
        }
    }

    public final void zzj() throws zzqm {
        if (!this.zzP && zzX() && zzW()) {
            zzQ();
            this.zzP = true;
        }
    }

    public final void zzk() {
        zzpo zzpo = this.zzw;
        if (zzpo != null) {
            zzpo.zzi();
        }
    }

    public final void zzl() {
        zzf();
        zzfzn zzfzn = this.zzg;
        int size = zzfzn.size();
        for (int i = 0; i < size; i++) {
            ((zzdt) zzfzn.get(i)).zzf();
        }
        zzfzn zzfzn2 = this.zzh;
        int size2 = zzfzn2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            ((zzdt) zzfzn2.get(i2)).zzf();
        }
        zzdq zzdq = this.zzt;
        if (zzdq != null) {
            zzdq.zzf();
        }
        this.zzR = false;
        this.zzW = false;
    }

    public final void zzm(zzk zzk2) {
        if (!this.zzy.equals(zzk2)) {
            this.zzy = zzk2;
            zzpo zzpo = this.zzw;
            if (zzpo != null) {
                zzpo.zzg(zzk2);
            }
            zzf();
        }
    }

    public final void zzn(int i) {
        if (this.zzS != i) {
            this.zzS = i;
            zzf();
        }
    }

    public final void zzo(zzl zzl2) {
        if (!this.zzT.equals(zzl2)) {
            if (this.zzu != null) {
                int i = this.zzT.zza;
            }
            this.zzT = zzl2;
        }
    }

    public final void zzp(zzel zzel) {
        this.zzj.zze(zzel);
    }

    public final void zzq(zzqk zzqk) {
        this.zzq = zzqk;
    }

    public final void zzr(int i, int i2) {
        AudioTrack audioTrack = this.zzu;
        if (audioTrack != null) {
            zzY(audioTrack);
        }
    }

    public final void zzs(zzcg zzcg) {
        this.zzB = new zzcg(Math.max(0.1f, Math.min(zzcg.zzc, 8.0f)), Math.max(0.1f, Math.min(zzcg.zzd, 8.0f)));
        zzS(zzcg);
    }

    public final void zzt(zzpb zzpb) {
        this.zzp = zzpb;
    }

    public final void zzv(boolean z) {
        this.zzC = z;
        zzS(this.zzB);
    }

    public final void zzw(float f) {
        if (this.zzL != f) {
            this.zzL = f;
            zzT();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0251, code lost:
        r0 = 1024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0261, code lost:
        r11 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x02fa, code lost:
        r1.zzH = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x02fc, code lost:
        if (r0 == 0) goto L_0x02ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x02ff, code lost:
        return r11;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzx(java.nio.ByteBuffer r28, long r29, int r31) throws com.google.android.gms.internal.ads.zzqj, com.google.android.gms.internal.ads.zzqm {
        /*
            r27 = this;
            r1 = r27
            r2 = r28
            r3 = r29
            r5 = r31
            java.nio.ByteBuffer r0 = r1.zzM
            r7 = 0
            if (r0 == 0) goto L_0x0012
            if (r2 != r0) goto L_0x0010
            goto L_0x0012
        L_0x0010:
            r0 = r7
            goto L_0x0013
        L_0x0012:
            r0 = 1
        L_0x0013:
            com.google.android.gms.internal.ads.zzek.zzd(r0)
            com.google.android.gms.internal.ads.zzre r0 = r1.zzr
            r8 = 0
            if (r0 == 0) goto L_0x006f
            boolean r0 = r27.zzW()
            if (r0 != 0) goto L_0x0022
            return r7
        L_0x0022:
            com.google.android.gms.internal.ads.zzre r0 = r1.zzr
            com.google.android.gms.internal.ads.zzre r9 = r1.zzs
            int r10 = r9.zzc
            int r11 = r0.zzc
            if (r10 != r11) goto L_0x005f
            int r10 = r9.zzg
            int r11 = r0.zzg
            if (r10 != r11) goto L_0x005f
            int r10 = r9.zze
            int r11 = r0.zze
            if (r10 != r11) goto L_0x005f
            int r10 = r9.zzf
            int r11 = r0.zzf
            if (r10 != r11) goto L_0x005f
            int r10 = r9.zzd
            int r11 = r0.zzd
            if (r10 != r11) goto L_0x005f
            boolean r10 = r9.zzj
            boolean r10 = r0.zzj
            boolean r9 = r9.zzk
            boolean r9 = r0.zzk
            r1.zzs = r0
            r1.zzr = r8
            android.media.AudioTrack r0 = r1.zzu
            if (r0 == 0) goto L_0x006c
            boolean r0 = zzY(r0)
            if (r0 == 0) goto L_0x006c
            com.google.android.gms.internal.ads.zzre r0 = r1.zzs
            boolean r0 = r0.zzk
            goto L_0x006c
        L_0x005f:
            r27.zzQ()
            boolean r0 = r27.zzy()
            if (r0 == 0) goto L_0x0069
            return r7
        L_0x0069:
            r27.zzf()
        L_0x006c:
            r1.zzN(r3)
        L_0x006f:
            boolean r0 = r27.zzX()
            if (r0 == 0) goto L_0x0077
            goto L_0x016a
        L_0x0077:
            com.google.android.gms.internal.ads.zzeo r0 = r1.zzi     // Catch:{ zzqj -> 0x03c5 }
            boolean r0 = r0.zzd()     // Catch:{ zzqj -> 0x03c5 }
            if (r0 != 0) goto L_0x0080
            return r7
        L_0x0080:
            com.google.android.gms.internal.ads.zzre r0 = r1.zzs     // Catch:{ zzqj -> 0x008a }
            r0.getClass()
            android.media.AudioTrack r0 = r1.zzM(r0)     // Catch:{ zzqj -> 0x008a }
            goto L_0x00d2
        L_0x008a:
            r0 = move-exception
            r11 = r0
            com.google.android.gms.internal.ads.zzre r0 = r1.zzs     // Catch:{ zzqj -> 0x03c5 }
            int r12 = r0.zzh     // Catch:{ zzqj -> 0x03c5 }
            r13 = 1000000(0xf4240, float:1.401298E-39)
            if (r12 <= r13) goto L_0x03c1
            com.google.android.gms.internal.ads.zzre r12 = new com.google.android.gms.internal.ads.zzre     // Catch:{ zzqj -> 0x03c5 }
            com.google.android.gms.internal.ads.zzam r15 = r0.zza     // Catch:{ zzqj -> 0x03c5 }
            int r13 = r0.zzb     // Catch:{ zzqj -> 0x03c5 }
            int r14 = r0.zzc     // Catch:{ zzqj -> 0x03c5 }
            int r8 = r0.zzd     // Catch:{ zzqj -> 0x03c5 }
            int r7 = r0.zze     // Catch:{ zzqj -> 0x03c5 }
            int r6 = r0.zzf     // Catch:{ zzqj -> 0x03c5 }
            int r10 = r0.zzg     // Catch:{ zzqj -> 0x03c5 }
            r22 = 1000000(0xf4240, float:1.401298E-39)
            com.google.android.gms.internal.ads.zzdq r9 = r0.zzi     // Catch:{ zzqj -> 0x03c5 }
            r16 = r14
            boolean r14 = r0.zzj     // Catch:{ zzqj -> 0x03c5 }
            boolean r14 = r0.zzk     // Catch:{ zzqj -> 0x03c5 }
            boolean r0 = r0.zzl     // Catch:{ zzqj -> 0x03c5 }
            r24 = 0
            r25 = 0
            r26 = 0
            r0 = r16
            r14 = r12
            r16 = r13
            r17 = r0
            r18 = r8
            r19 = r7
            r20 = r6
            r21 = r10
            r23 = r9
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)     // Catch:{ zzqj -> 0x03c5 }
            android.media.AudioTrack r0 = r1.zzM(r12)     // Catch:{ zzqj -> 0x03bd }
            r1.zzs = r12     // Catch:{ zzqj -> 0x03bd }
        L_0x00d2:
            r1.zzu = r0     // Catch:{ zzqj -> 0x03c5 }
            boolean r0 = zzY(r0)     // Catch:{ zzqj -> 0x03c5 }
            if (r0 == 0) goto L_0x00f0
            android.media.AudioTrack r0 = r1.zzu     // Catch:{ zzqj -> 0x03c5 }
            com.google.android.gms.internal.ads.zzrp r6 = r1.zzl     // Catch:{ zzqj -> 0x03c5 }
            if (r6 != 0) goto L_0x00e7
            com.google.android.gms.internal.ads.zzrp r6 = new com.google.android.gms.internal.ads.zzrp     // Catch:{ zzqj -> 0x03c5 }
            r6.<init>(r1)     // Catch:{ zzqj -> 0x03c5 }
            r1.zzl = r6     // Catch:{ zzqj -> 0x03c5 }
        L_0x00e7:
            com.google.android.gms.internal.ads.zzrp r6 = r1.zzl     // Catch:{ zzqj -> 0x03c5 }
            r6.zza(r0)     // Catch:{ zzqj -> 0x03c5 }
            com.google.android.gms.internal.ads.zzre r0 = r1.zzs     // Catch:{ zzqj -> 0x03c5 }
            boolean r0 = r0.zzk     // Catch:{ zzqj -> 0x03c5 }
        L_0x00f0:
            int r0 = com.google.android.gms.internal.ads.zzfx.zza     // Catch:{ zzqj -> 0x03c5 }
            r6 = 31
            if (r0 < r6) goto L_0x00ff
            com.google.android.gms.internal.ads.zzpb r0 = r1.zzp     // Catch:{ zzqj -> 0x03c5 }
            if (r0 == 0) goto L_0x00ff
            android.media.AudioTrack r6 = r1.zzu     // Catch:{ zzqj -> 0x03c5 }
            com.google.android.gms.internal.ads.zzrb.zza(r6, r0)     // Catch:{ zzqj -> 0x03c5 }
        L_0x00ff:
            android.media.AudioTrack r0 = r1.zzu     // Catch:{ zzqj -> 0x03c5 }
            int r0 = r0.getAudioSessionId()     // Catch:{ zzqj -> 0x03c5 }
            r1.zzS = r0     // Catch:{ zzqj -> 0x03c5 }
            com.google.android.gms.internal.ads.zzqr r6 = r1.zzj     // Catch:{ zzqj -> 0x03c5 }
            android.media.AudioTrack r7 = r1.zzu     // Catch:{ zzqj -> 0x03c5 }
            com.google.android.gms.internal.ads.zzre r0 = r1.zzs     // Catch:{ zzqj -> 0x03c5 }
            int r8 = r0.zzc     // Catch:{ zzqj -> 0x03c5 }
            r9 = 2
            if (r8 != r9) goto L_0x0114
            r8 = 1
            goto L_0x0115
        L_0x0114:
            r8 = 0
        L_0x0115:
            int r9 = r0.zzg     // Catch:{ zzqj -> 0x03c5 }
            int r10 = r0.zzd     // Catch:{ zzqj -> 0x03c5 }
            int r11 = r0.zzh     // Catch:{ zzqj -> 0x03c5 }
            r6.zzd(r7, r8, r9, r10, r11)     // Catch:{ zzqj -> 0x03c5 }
            r27.zzT()     // Catch:{ zzqj -> 0x03c5 }
            com.google.android.gms.internal.ads.zzl r0 = r1.zzT     // Catch:{ zzqj -> 0x03c5 }
            int r0 = r0.zza     // Catch:{ zzqj -> 0x03c5 }
            com.google.android.gms.internal.ads.zzpp r0 = r1.zzU     // Catch:{ zzqj -> 0x03c5 }
            if (r0 == 0) goto L_0x013f
            int r6 = com.google.android.gms.internal.ads.zzfx.zza     // Catch:{ zzqj -> 0x03c5 }
            r7 = 23
            if (r6 < r7) goto L_0x013f
            android.media.AudioTrack r6 = r1.zzu     // Catch:{ zzqj -> 0x03c5 }
            com.google.android.gms.internal.ads.zzra.zza(r6, r0)     // Catch:{ zzqj -> 0x03c5 }
            com.google.android.gms.internal.ads.zzpo r0 = r1.zzw     // Catch:{ zzqj -> 0x03c5 }
            if (r0 == 0) goto L_0x013f
            com.google.android.gms.internal.ads.zzpp r6 = r1.zzU     // Catch:{ zzqj -> 0x03c5 }
            android.media.AudioDeviceInfo r6 = r6.zza     // Catch:{ zzqj -> 0x03c5 }
            r0.zzh(r6)     // Catch:{ zzqj -> 0x03c5 }
        L_0x013f:
            int r0 = com.google.android.gms.internal.ads.zzfx.zza     // Catch:{ zzqj -> 0x03c5 }
            r6 = 24
            if (r0 < r6) goto L_0x0152
            com.google.android.gms.internal.ads.zzpo r0 = r1.zzw     // Catch:{ zzqj -> 0x03c5 }
            if (r0 == 0) goto L_0x0152
            com.google.android.gms.internal.ads.zzrj r6 = new com.google.android.gms.internal.ads.zzrj     // Catch:{ zzqj -> 0x03c5 }
            android.media.AudioTrack r7 = r1.zzu     // Catch:{ zzqj -> 0x03c5 }
            r6.<init>(r7, r0)     // Catch:{ zzqj -> 0x03c5 }
            r1.zzx = r6     // Catch:{ zzqj -> 0x03c5 }
        L_0x0152:
            r6 = 1
            r1.zzJ = r6     // Catch:{ zzqj -> 0x03c5 }
            com.google.android.gms.internal.ads.zzqk r0 = r1.zzq     // Catch:{ zzqj -> 0x03c5 }
            if (r0 == 0) goto L_0x016a
            com.google.android.gms.internal.ads.zzre r6 = r1.zzs     // Catch:{ zzqj -> 0x03c5 }
            com.google.android.gms.internal.ads.zzqh r6 = r6.zzb()     // Catch:{ zzqj -> 0x03c5 }
            com.google.android.gms.internal.ads.zzrw r0 = (com.google.android.gms.internal.ads.zzrw) r0     // Catch:{ zzqj -> 0x03c5 }
            com.google.android.gms.internal.ads.zzrx r0 = r0.zza     // Catch:{ zzqj -> 0x03c5 }
            com.google.android.gms.internal.ads.zzqf r0 = r0.zzc     // Catch:{ zzqj -> 0x03c5 }
            r0.zzc(r6)     // Catch:{ zzqj -> 0x03c5 }
        L_0x016a:
            com.google.android.gms.internal.ads.zzrk r0 = r1.zzm
            r0.zza()
            boolean r0 = r1.zzJ
            r6 = 0
            if (r0 == 0) goto L_0x018a
            long r8 = java.lang.Math.max(r6, r3)
            r1.zzK = r8
            r8 = 0
            r1.zzI = r8
            r1.zzJ = r8
            r1.zzN(r3)
            boolean r0 = r1.zzR
            if (r0 == 0) goto L_0x018a
            r27.zzi()
        L_0x018a:
            com.google.android.gms.internal.ads.zzqr r0 = r1.zzj
            long r8 = r27.zzL()
            boolean r0 = r0.zzj(r8)
            if (r0 != 0) goto L_0x0198
            r8 = 0
            return r8
        L_0x0198:
            java.nio.ByteBuffer r0 = r1.zzM
            if (r0 != 0) goto L_0x0390
            java.nio.ByteOrder r0 = r28.order()
            java.nio.ByteOrder r8 = java.nio.ByteOrder.LITTLE_ENDIAN
            if (r0 != r8) goto L_0x01a6
            r0 = 1
            goto L_0x01a7
        L_0x01a6:
            r0 = 0
        L_0x01a7:
            com.google.android.gms.internal.ads.zzek.zzd(r0)
            boolean r0 = r28.hasRemaining()
            if (r0 != 0) goto L_0x01b2
            r8 = 1
            return r8
        L_0x01b2:
            com.google.android.gms.internal.ads.zzre r0 = r1.zzs
            int r8 = r0.zzc
            if (r8 == 0) goto L_0x0300
            int r8 = r1.zzH
            if (r8 != 0) goto L_0x0300
            int r0 = r0.zzg
            r8 = -2
            r9 = 16
            r10 = 1024(0x400, float:1.435E-42)
            r11 = -1
            switch(r0) {
                case 5: goto L_0x02f5;
                case 6: goto L_0x02f5;
                case 7: goto L_0x026a;
                case 8: goto L_0x026a;
                case 9: goto L_0x0253;
                case 10: goto L_0x0251;
                case 11: goto L_0x024e;
                case 12: goto L_0x024e;
                case 13: goto L_0x01c7;
                case 14: goto L_0x01ff;
                case 15: goto L_0x01fc;
                case 16: goto L_0x0251;
                case 17: goto L_0x01e1;
                case 18: goto L_0x02f5;
                case 19: goto L_0x01c7;
                case 20: goto L_0x01db;
                default: goto L_0x01c7;
            }
        L_0x01c7:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Unexpected audio encoding: "
            r3.<init>(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        L_0x01db:
            int r0 = com.google.android.gms.internal.ads.zzaeb.zzb(r28)
            goto L_0x0261
        L_0x01e1:
            int r0 = com.google.android.gms.internal.ads.zzach.zza
            byte[] r0 = new byte[r9]
            int r8 = r28.position()
            r2.get(r0)
            r2.position(r8)
            com.google.android.gms.internal.ads.zzfn r8 = new com.google.android.gms.internal.ads.zzfn
            r8.<init>(r0, r9)
            com.google.android.gms.internal.ads.zzacg r0 = com.google.android.gms.internal.ads.zzach.zza(r8)
            int r0 = r0.zzc
            goto L_0x0261
        L_0x01fc:
            r0 = 512(0x200, float:7.175E-43)
            goto L_0x0261
        L_0x01ff:
            int r0 = com.google.android.gms.internal.ads.zzace.zza
            int r0 = r28.position()
            int r10 = r28.limit()
            int r10 = r10 + -10
            r12 = r0
        L_0x020c:
            if (r12 > r10) goto L_0x021f
            int r13 = r12 + 4
            int r13 = com.google.android.gms.internal.ads.zzfx.zzi(r2, r13)
            r13 = r13 & r8
            r14 = -126718022(0xfffffffff8726fba, float:-1.966878E34)
            if (r13 != r14) goto L_0x021c
            int r12 = r12 - r0
            goto L_0x0220
        L_0x021c:
            int r12 = r12 + 1
            goto L_0x020c
        L_0x021f:
            r12 = r11
        L_0x0220:
            if (r12 != r11) goto L_0x0224
            r0 = 0
            goto L_0x0261
        L_0x0224:
            int r0 = r28.position()
            int r0 = r0 + r12
            int r0 = r0 + 7
            byte r0 = r2.get(r0)
            r0 = r0 & 255(0xff, float:3.57E-43)
            int r8 = r28.position()
            int r8 = r8 + r12
            r10 = 187(0xbb, float:2.62E-43)
            if (r0 != r10) goto L_0x023d
            r0 = 9
            goto L_0x023f
        L_0x023d:
            r0 = 8
        L_0x023f:
            int r8 = r8 + r0
            byte r0 = r2.get(r8)
            int r0 = r0 >> 4
            r0 = r0 & 7
            r8 = 40
            int r0 = r8 << r0
            int r0 = r0 * r9
            goto L_0x0261
        L_0x024e:
            r0 = 2048(0x800, float:2.87E-42)
            goto L_0x0261
        L_0x0251:
            r0 = r10
            goto L_0x0261
        L_0x0253:
            int r0 = r28.position()
            int r0 = com.google.android.gms.internal.ads.zzfx.zzi(r2, r0)
            int r0 = com.google.android.gms.internal.ads.zzaea.zzc(r0)
            if (r0 == r11) goto L_0x0264
        L_0x0261:
            r11 = 1
            goto L_0x02fa
        L_0x0264:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>()
            throw r0
        L_0x026a:
            int r0 = com.google.android.gms.internal.ads.zzadc.zza
            r9 = 0
            int r0 = r2.getInt(r9)
            r12 = -233094848(0xfffffffff21b4140, float:-3.0751398E30)
            if (r0 == r12) goto L_0x02f2
            int r0 = r2.getInt(r9)
            r12 = -398277519(0xffffffffe842c471, float:-3.6790512E24)
            if (r0 != r12) goto L_0x0280
            goto L_0x0251
        L_0x0280:
            int r0 = r2.getInt(r9)
            r9 = 622876772(0x25205864, float:1.3907736E-16)
            if (r0 != r9) goto L_0x028c
            r0 = 4096(0x1000, float:5.74E-42)
            goto L_0x0261
        L_0x028c:
            int r0 = r28.position()
            byte r9 = r2.get(r0)
            if (r9 == r8) goto L_0x02d9
            if (r9 == r11) goto L_0x02c2
            r8 = 31
            if (r9 == r8) goto L_0x02b0
            int r8 = r0 + 4
            int r0 = r0 + 5
            byte r8 = r2.get(r8)
            r9 = 1
            r8 = r8 & r9
            int r8 = r8 << 6
            byte r0 = r2.get(r0)
            r0 = r0 & 252(0xfc, float:3.53E-43)
            r9 = 2
            goto L_0x02d5
        L_0x02b0:
            r9 = 2
            int r8 = r0 + 5
            byte r8 = r2.get(r8)
            r8 = r8 & 7
            int r8 = r8 << 4
            int r0 = r0 + 6
            byte r0 = r2.get(r0)
            goto L_0x02d3
        L_0x02c2:
            r9 = 2
            int r8 = r0 + 4
            byte r8 = r2.get(r8)
            r8 = r8 & 7
            int r8 = r8 << 4
            int r0 = r0 + 7
            byte r0 = r2.get(r0)
        L_0x02d3:
            r0 = r0 & 60
        L_0x02d5:
            int r0 = r0 >> r9
            r0 = r0 | r8
            r11 = 1
            goto L_0x02ee
        L_0x02d9:
            r9 = 2
            int r8 = r0 + 4
            int r0 = r0 + 5
            byte r0 = r2.get(r0)
            r11 = 1
            r0 = r0 & r11
            int r0 = r0 << 6
            byte r8 = r2.get(r8)
            r8 = r8 & 252(0xfc, float:3.53E-43)
            int r8 = r8 >> r9
            r0 = r0 | r8
        L_0x02ee:
            int r0 = r0 + r11
            int r0 = r0 * 32
            goto L_0x02fa
        L_0x02f2:
            r11 = 1
            r0 = r10
            goto L_0x02fa
        L_0x02f5:
            r11 = 1
            int r0 = com.google.android.gms.internal.ads.zzace.zza(r28)
        L_0x02fa:
            r1.zzH = r0
            if (r0 == 0) goto L_0x02ff
            goto L_0x0300
        L_0x02ff:
            return r11
        L_0x0300:
            com.google.android.gms.internal.ads.zzrh r0 = r1.zzz
            if (r0 == 0) goto L_0x0312
            boolean r0 = r27.zzW()
            if (r0 != 0) goto L_0x030c
            r8 = 0
            return r8
        L_0x030c:
            r1.zzN(r3)
            r8 = 0
            r1.zzz = r8
        L_0x0312:
            long r8 = r1.zzK
            com.google.android.gms.internal.ads.zzre r0 = r1.zzs
            long r10 = r27.zzK()
            com.google.android.gms.internal.ads.zzsb r12 = r1.zzf
            long r12 = r12.zzo()
            long r10 = r10 - r12
            com.google.android.gms.internal.ads.zzam r0 = r0.zza
            int r0 = r0.zzA
            long r10 = com.google.android.gms.internal.ads.zzfx.zzs(r10, r0)
            long r8 = r8 + r10
            boolean r0 = r1.zzI
            if (r0 != 0) goto L_0x034a
            long r10 = r8 - r3
            long r10 = java.lang.Math.abs(r10)
            r12 = 200000(0x30d40, double:9.8813E-319)
            int r0 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r0 <= 0) goto L_0x034a
            com.google.android.gms.internal.ads.zzqk r0 = r1.zzq
            if (r0 == 0) goto L_0x0347
            com.google.android.gms.internal.ads.zzql r10 = new com.google.android.gms.internal.ads.zzql
            r10.<init>(r3, r8)
            r0.zza(r10)
        L_0x0347:
            r10 = 1
            r1.zzI = r10
        L_0x034a:
            boolean r0 = r1.zzI
            if (r0 == 0) goto L_0x0371
            boolean r0 = r27.zzW()
            r10 = 0
            if (r0 != 0) goto L_0x0356
            return r10
        L_0x0356:
            long r8 = r3 - r8
            long r11 = r1.zzK
            long r11 = r11 + r8
            r1.zzK = r11
            r1.zzI = r10
            r1.zzN(r3)
            com.google.android.gms.internal.ads.zzqk r0 = r1.zzq
            if (r0 == 0) goto L_0x0371
            int r6 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r6 == 0) goto L_0x0371
            com.google.android.gms.internal.ads.zzrw r0 = (com.google.android.gms.internal.ads.zzrw) r0
            com.google.android.gms.internal.ads.zzrx r0 = r0.zza
            r0.zzao()
        L_0x0371:
            com.google.android.gms.internal.ads.zzre r0 = r1.zzs
            int r0 = r0.zzc
            if (r0 != 0) goto L_0x0382
            long r6 = r1.zzD
            int r0 = r28.remaining()
            long r8 = (long) r0
            long r6 = r6 + r8
            r1.zzD = r6
            goto L_0x038c
        L_0x0382:
            long r6 = r1.zzE
            int r0 = r1.zzH
            long r8 = (long) r0
            long r10 = (long) r5
            long r8 = r8 * r10
            long r6 = r6 + r8
            r1.zzE = r6
        L_0x038c:
            r1.zzM = r2
            r1.zzN = r5
        L_0x0390:
            r1.zzR(r3)
            java.nio.ByteBuffer r0 = r1.zzM
            boolean r0 = r0.hasRemaining()
            if (r0 != 0) goto L_0x03a3
            r2 = 0
            r1.zzM = r2
            r2 = 0
            r1.zzN = r2
            r3 = 1
            return r3
        L_0x03a3:
            r2 = 0
            r3 = 1
            com.google.android.gms.internal.ads.zzqr r0 = r1.zzj
            long r4 = r27.zzL()
            boolean r0 = r0.zzi(r4)
            if (r0 == 0) goto L_0x03bc
            java.lang.String r0 = "DefaultAudioSink"
            java.lang.String r2 = "Resetting stalled audio track"
            com.google.android.gms.internal.ads.zzfe.zzf(r0, r2)
            r27.zzf()
            return r3
        L_0x03bc:
            return r2
        L_0x03bd:
            r0 = move-exception
            r11.addSuppressed(r0)     // Catch:{ zzqj -> 0x03c5 }
        L_0x03c1:
            r27.zzO()     // Catch:{ zzqj -> 0x03c5 }
            throw r11     // Catch:{ zzqj -> 0x03c5 }
        L_0x03c5:
            r0 = move-exception
            boolean r2 = r0.zzb
            if (r2 != 0) goto L_0x03d1
            com.google.android.gms.internal.ads.zzrk r2 = r1.zzm
            r2.zzb(r0)
            r2 = 0
            return r2
        L_0x03d1:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrr.zzx(java.nio.ByteBuffer, long, int):boolean");
    }

    public final boolean zzy() {
        return zzX() && this.zzj.zzg(zzL());
    }

    public final boolean zzz() {
        if (!zzX()) {
            return true;
        }
        if (this.zzP) {
            return !zzy();
        }
        return false;
    }

    public final void zzu(AudioDeviceInfo audioDeviceInfo) {
        zzpp zzpp;
        if (audioDeviceInfo == null) {
            zzpp = null;
        } else {
            zzpp = new zzpp(audioDeviceInfo);
        }
        this.zzU = zzpp;
        zzpo zzpo = this.zzw;
        if (zzpo != null) {
            zzpo.zzh(audioDeviceInfo);
        }
        AudioTrack audioTrack = this.zzu;
        if (audioTrack != null) {
            zzra.zza(audioTrack, this.zzU);
        }
    }
}
