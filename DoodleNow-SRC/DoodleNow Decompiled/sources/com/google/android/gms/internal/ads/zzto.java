package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.Trace;
import com.amazon.a.a.o.b.f;
import com.facebook.hermes.intl.Constants;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public abstract class zzto extends zziq {
    private static final byte[] zzb = {0, 0, 1, 103, 66, -64, Ascii.VT, -38, 37, -112, 0, 0, 1, 104, -50, Ascii.SI, 19, 32, 0, 0, 1, 101, -120, -124, Ascii.CR, -50, 113, Ascii.CAN, -96, 0, 47, -65, Ascii.FS, 49, -61, 39, 93, 120};
    private boolean zzA;
    private boolean zzB;
    private boolean zzC;
    private boolean zzD;
    private boolean zzE;
    private boolean zzF;
    private long zzG;
    private int zzH;
    private int zzI;
    private ByteBuffer zzJ;
    private boolean zzK;
    private boolean zzL;
    private boolean zzM;
    private boolean zzN;
    private boolean zzO;
    private boolean zzP;
    private int zzQ;
    private int zzR;
    private int zzS;
    private boolean zzT;
    private boolean zzU;
    private boolean zzV;
    private long zzW;
    private long zzX;
    private boolean zzY;
    private boolean zzZ;
    protected zzir zza;
    private boolean zzaa;
    private zztn zzab;
    private long zzac;
    private boolean zzad;
    private zzsn zzae;
    private zzsn zzaf;
    private final zzte zzc;
    private final zztq zzd;
    private final float zze;
    private final zzih zzf = new zzih(0, 0);
    private final zzih zzg = new zzih(0, 0);
    private final zzih zzh = new zzih(2, 0);
    private final zztb zzi;
    private final MediaCodec.BufferInfo zzj;
    private final ArrayDeque zzk;
    private final zzry zzl;
    private zzam zzm;
    private zzam zzn;
    private MediaCrypto zzo;
    private long zzp;
    private float zzq;
    private zztf zzr;
    private zzam zzs;
    private MediaFormat zzt;
    private boolean zzu;
    private float zzv;
    private ArrayDeque zzw;
    private zztm zzx;
    private zzti zzy;
    private int zzz;

    public zzto(int i, zzte zzte, zztq zztq, boolean z, float f) {
        super(i);
        this.zzc = zzte;
        zztq.getClass();
        this.zzd = zztq;
        this.zze = f;
        zztb zztb = new zztb();
        this.zzi = zztb;
        this.zzj = new MediaCodec.BufferInfo();
        this.zzq = 1.0f;
        this.zzp = C.TIME_UNSET;
        this.zzk = new ArrayDeque();
        this.zzab = zztn.zza;
        zztb.zzi(0);
        zztb.zzc.order(ByteOrder.nativeOrder());
        this.zzl = new zzry();
        this.zzv = -1.0f;
        this.zzz = 0;
        this.zzQ = 0;
        this.zzH = -1;
        this.zzI = -1;
        this.zzG = C.TIME_UNSET;
        this.zzW = C.TIME_UNSET;
        this.zzX = C.TIME_UNSET;
        this.zzac = C.TIME_UNSET;
        this.zzR = 0;
        this.zzS = 0;
        this.zza = new zzir();
    }

    protected static boolean zzaL(zzam zzam) {
        return zzam.zzG == 0;
    }

    private final void zzaM() {
        this.zzH = -1;
        this.zzg.zzc = null;
    }

    private final void zzaN() {
        this.zzI = -1;
        this.zzJ = null;
    }

    private final void zzaO(zztn zztn) {
        this.zzab = zztn;
        if (zztn.zzd != C.TIME_UNSET) {
            this.zzad = true;
        }
    }

    private final void zzaP() throws zziz {
        zzsn zzsn = this.zzaf;
        zzsn.getClass();
        this.zzae = zzsn;
        this.zzR = 0;
        this.zzS = 0;
    }

    private final boolean zzaQ() throws zziz {
        if (this.zzT) {
            this.zzR = 1;
            if (this.zzB) {
                this.zzS = 3;
                return false;
            }
            this.zzS = 2;
        } else {
            zzaP();
        }
        return true;
    }

    private final boolean zzaR() throws zziz {
        zztf zztf = this.zzr;
        if (zztf == null || this.zzR == 2 || this.zzY) {
            return false;
        }
        if (this.zzH < 0) {
            int zza2 = zztf.zza();
            this.zzH = zza2;
            if (zza2 < 0) {
                return false;
            }
            this.zzg.zzc = zztf.zzf(zza2);
            this.zzg.zzb();
        }
        if (this.zzR == 1) {
            if (!this.zzF) {
                this.zzU = true;
                zztf.zzj(this.zzH, 0, 0, 0, 4);
                zzaM();
            }
            this.zzR = 2;
            return false;
        } else if (this.zzD) {
            this.zzD = false;
            ByteBuffer byteBuffer = this.zzg.zzc;
            byteBuffer.getClass();
            byteBuffer.put(zzb);
            zztf.zzj(this.zzH, 0, 38, 0, 0);
            zzaM();
            this.zzT = true;
            return true;
        } else {
            if (this.zzQ == 1) {
                int i = 0;
                while (true) {
                    zzam zzam = this.zzs;
                    zzam.getClass();
                    if (i >= zzam.zzo.size()) {
                        break;
                    }
                    ByteBuffer byteBuffer2 = this.zzg.zzc;
                    byteBuffer2.getClass();
                    byteBuffer2.put((byte[]) this.zzs.zzo.get(i));
                    i++;
                }
                this.zzQ = 2;
            }
            ByteBuffer byteBuffer3 = this.zzg.zzc;
            byteBuffer3.getClass();
            int position = byteBuffer3.position();
            zzlb zzcX = zzcX();
            try {
                int zzcV = zzcV(zzcX, this.zzg, 0);
                if (zzcV == -3) {
                    if (zzQ()) {
                        this.zzX = this.zzW;
                    }
                    return false;
                } else if (zzcV == -5) {
                    if (this.zzQ == 2) {
                        this.zzg.zzb();
                        this.zzQ = 1;
                    }
                    zzac(zzcX);
                    return true;
                } else {
                    zzih zzih = this.zzg;
                    if (zzih.zzf()) {
                        this.zzX = this.zzW;
                        if (this.zzQ == 2) {
                            zzih.zzb();
                            this.zzQ = 1;
                        }
                        this.zzY = true;
                        if (!this.zzT) {
                            zzao();
                            return false;
                        }
                        try {
                            if (!this.zzF) {
                                this.zzU = true;
                                zztf.zzj(this.zzH, 0, 0, 0, 4);
                                zzaM();
                            }
                            return false;
                        } catch (MediaCodec.CryptoException e) {
                            throw zzi(e, this.zzm, false, zzfx.zzj(e.getErrorCode()));
                        }
                    } else if (this.zzT || zzih.zzg()) {
                        boolean zzk2 = zzih.zzk();
                        if (zzk2) {
                            zzih.zzb.zzb(position);
                        }
                        long j = this.zzg.zze;
                        if (this.zzaa) {
                            if (!this.zzk.isEmpty()) {
                                zzfu zzfu = ((zztn) this.zzk.peekLast()).zze;
                                zzam zzam2 = this.zzm;
                                zzam2.getClass();
                                zzfu.zzd(j, zzam2);
                            } else {
                                zzfu zzfu2 = this.zzab.zze;
                                zzam zzam3 = this.zzm;
                                zzam3.getClass();
                                zzfu2.zzd(j, zzam3);
                            }
                            this.zzaa = false;
                        }
                        long max = Math.max(this.zzW, j);
                        this.zzW = max;
                        if (zzQ() || this.zzg.zzh()) {
                            this.zzX = max;
                        }
                        this.zzg.zzj();
                        zzih zzih2 = this.zzg;
                        if (zzih2.zze()) {
                            zzaj(zzih2);
                        }
                        zzaB(this.zzg);
                        zzat(this.zzg);
                        if (zzk2) {
                            try {
                                zztf.zzk(this.zzH, 0, this.zzg.zzb, j, 0);
                            } catch (MediaCodec.CryptoException e2) {
                                throw zzi(e2, this.zzm, false, zzfx.zzj(e2.getErrorCode()));
                            }
                        } else {
                            int i2 = this.zzH;
                            ByteBuffer byteBuffer4 = this.zzg.zzc;
                            byteBuffer4.getClass();
                            zztf.zzj(i2, 0, byteBuffer4.limit(), j, 0);
                        }
                        zzaM();
                        this.zzT = true;
                        this.zzQ = 0;
                        this.zza.zzc++;
                        return true;
                    } else {
                        zzih.zzb();
                        if (this.zzQ == 2) {
                            this.zzQ = 1;
                        }
                        return true;
                    }
                }
            } catch (zzig e3) {
                zzak(e3);
                zzaU(0);
                zzah();
                return true;
            }
        }
    }

    private final boolean zzaS() {
        return this.zzI >= 0;
    }

    private final boolean zzaT(long j, long j2) {
        if (j2 >= j) {
            return false;
        }
        zzam zzam = this.zzn;
        if (zzam == null || !Objects.equals(zzam.zzm, MimeTypes.AUDIO_OPUS)) {
            return true;
        }
        return !zzaeb.zzf(j, j2);
    }

    private final boolean zzaU(int i) throws zziz {
        zzih zzih = this.zzf;
        zzlb zzcX = zzcX();
        zzih.zzb();
        int zzcV = zzcV(zzcX, this.zzf, i | 4);
        if (zzcV == -5) {
            zzac(zzcX);
            return true;
        } else if (zzcV != -4 || !this.zzf.zzf()) {
            return false;
        } else {
            this.zzY = true;
            zzao();
            return false;
        }
    }

    private final boolean zzaV(long j) {
        if (this.zzp == C.TIME_UNSET) {
            return true;
        }
        zzh();
        return SystemClock.elapsedRealtime() - j < this.zzp;
    }

    private final boolean zzaW(zzam zzam) throws zziz {
        if (!(zzfx.zza < 23 || this.zzr == null || this.zzS == 3 || zzcU() == 0)) {
            float f = this.zzq;
            zzam.getClass();
            float zzZ2 = zzZ(f, zzam, zzT());
            float f2 = this.zzv;
            if (f2 != zzZ2) {
                if (zzZ2 == -1.0f) {
                    zzae();
                    return false;
                } else if (f2 != -1.0f || zzZ2 > this.zze) {
                    Bundle bundle = new Bundle();
                    bundle.putFloat("operating-rate", zzZ2);
                    zztf zztf = this.zzr;
                    zztf.getClass();
                    zztf.zzp(bundle);
                    this.zzv = zzZ2;
                }
            }
        }
        return true;
    }

    private final void zzad() {
        this.zzO = false;
        this.zzi.zzb();
        this.zzh.zzb();
        this.zzN = false;
        this.zzM = false;
        this.zzl.zzb();
    }

    private final void zzae() throws zziz {
        if (this.zzT) {
            this.zzR = 1;
            this.zzS = 3;
            return;
        }
        zzaD();
        zzaz();
    }

    private final void zzah() {
        try {
            zztf zztf = this.zzr;
            zzek.zzb(zztf);
            zztf.zzi();
        } finally {
            zzaE();
        }
    }

    /* access modifiers changed from: protected */
    public void zzC() {
        try {
            zzad();
            zzaD();
        } finally {
            this.zzaf = null;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0036, code lost:
        if (r5 >= r1) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzF(com.google.android.gms.internal.ads.zzam[] r13, long r14, long r16, com.google.android.gms.internal.ads.zzvh r18) throws com.google.android.gms.internal.ads.zziz {
        /*
            r12 = this;
            r0 = r12
            com.google.android.gms.internal.ads.zztn r1 = r0.zzab
            long r1 = r1.zzd
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x0020
            com.google.android.gms.internal.ads.zztn r1 = new com.google.android.gms.internal.ads.zztn
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r5 = r1
            r8 = r14
            r10 = r16
            r5.<init>(r6, r8, r10)
            r12.zzaO(r1)
            return
        L_0x0020:
            java.util.ArrayDeque r1 = r0.zzk
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0055
            long r1 = r0.zzW
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0038
            long r5 = r0.zzac
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 == 0) goto L_0x0055
            int r1 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r1 < 0) goto L_0x0055
        L_0x0038:
            com.google.android.gms.internal.ads.zztn r1 = new com.google.android.gms.internal.ads.zztn
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r5 = r1
            r8 = r14
            r10 = r16
            r5.<init>(r6, r8, r10)
            r12.zzaO(r1)
            com.google.android.gms.internal.ads.zztn r1 = r0.zzab
            long r1 = r1.zzd
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x0054
            r12.zzap()
        L_0x0054:
            return
        L_0x0055:
            java.util.ArrayDeque r1 = r0.zzk
            com.google.android.gms.internal.ads.zztn r9 = new com.google.android.gms.internal.ads.zztn
            long r3 = r0.zzW
            r2 = r9
            r5 = r14
            r7 = r16
            r2.<init>(r3, r5, r7)
            r1.add(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzto.zzF(com.google.android.gms.internal.ads.zzam[], long, long, com.google.android.gms.internal.ads.zzvh):void");
    }

    public void zzM(float f, float f2) throws zziz {
        this.zzq = f2;
        zzaW(this.zzs);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: com.google.android.gms.internal.ads.zzto} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v8, resolved type: com.google.android.gms.internal.ads.zzto} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v18, resolved type: com.google.android.gms.internal.ads.zzto} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: android.media.MediaCodec$BufferInfo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v27, resolved type: com.google.android.gms.internal.ads.zzto} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v28, resolved type: com.google.android.gms.internal.ads.zzto} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v29, resolved type: android.media.MediaFormat} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v101, resolved type: com.google.android.gms.internal.ads.zzto} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v32, resolved type: com.google.android.gms.internal.ads.zzam} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v105, resolved type: com.google.android.gms.internal.ads.zzto} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v106, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v107, resolved type: com.google.android.gms.internal.ads.zzto} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v109, resolved type: com.google.android.gms.internal.ads.zzto} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v110, resolved type: com.google.android.gms.internal.ads.zzto} */
    /* JADX WARNING: type inference failed for: r19v0 */
    /* JADX WARNING: type inference failed for: r19v1 */
    /* JADX WARNING: type inference failed for: r19v2 */
    /* JADX WARNING: type inference failed for: r1v31, types: [android.media.MediaFormat] */
    /* JADX WARNING: type inference failed for: r19v17 */
    /* JADX WARNING: type inference failed for: r19v18 */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:212|213|214|215|216|(1:218)|219) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:134|135|(1:137)(0)|160|300|(1:239)|243|255|256) */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01a1, code lost:
        r15.zzN = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0200, code lost:
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:?, code lost:
        zzao();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0205, code lost:
        if (r15.zzZ != false) goto L_0x0207;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0207, code lost:
        zzaD();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x024e, code lost:
        r2 = r9;
        r19 = r13;
        r1 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x02ec, code lost:
        if (r15.zzn != null) goto L_0x02ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x0341, code lost:
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:?, code lost:
        zzao();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x0344, code lost:
        r15 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x0346, code lost:
        r19 = r19;
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x0348, code lost:
        if (r15.zzZ != false) goto L_0x034a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x034a, code lost:
        zzaD();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x034d, code lost:
        r1 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x0351, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x0352, code lost:
        r15 = r23;
        r19 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x03c1, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x03c2, code lost:
        r19 = r19;
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0092, code lost:
        r14 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r15.zzZ = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0095, code lost:
        r13 = false;
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0098, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0099, code lost:
        r2 = true;
        r1 = r15;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:134:0x0200 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:212:0x0341 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x037f  */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x03a0 A[Catch:{ IllegalStateException -> 0x03e2 }, LOOP:2: B:122:0x01e6->B:237:0x03a0, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x03ac A[Catch:{ IllegalStateException -> 0x03e2 }, LOOP:3: B:239:0x03ac->B:242:0x03b6, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x03f1  */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x0414  */
    /* JADX WARNING: Removed duplicated region for block: B:273:0x0416  */
    /* JADX WARNING: Removed duplicated region for block: B:275:0x041a  */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x039f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:297:0x03a9 A[SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:132:0x01f9=Splitter:B:132:0x01f9, B:32:0x008e=Splitter:B:32:0x008e} */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzV(long r24, long r26) throws com.google.android.gms.internal.ads.zziz {
        /*
            r23 = this;
            r15 = r23
            r14 = 1
            r13 = 0
            boolean r0 = r15.zzZ     // Catch:{ IllegalStateException -> 0x03e5 }
            if (r0 == 0) goto L_0x000c
            r23.zzaq()     // Catch:{ IllegalStateException -> 0x03e5 }
            return
        L_0x000c:
            com.google.android.gms.internal.ads.zzam r0 = r15.zzm     // Catch:{ IllegalStateException -> 0x03e5 }
            r11 = 2
            if (r0 != 0) goto L_0x0019
            boolean r0 = r15.zzaU(r11)     // Catch:{ IllegalStateException -> 0x03e5 }
            if (r0 == 0) goto L_0x0018
            goto L_0x0019
        L_0x0018:
            return
        L_0x0019:
            r23.zzaz()     // Catch:{ IllegalStateException -> 0x03e5 }
            boolean r0 = r15.zzM     // Catch:{ IllegalStateException -> 0x03e5 }
            if (r0 == 0) goto L_0x01d6
            java.lang.String r0 = "bypassRender"
            android.os.Trace.beginSection(r0)     // Catch:{ IllegalStateException -> 0x03e5 }
        L_0x0025:
            boolean r0 = r15.zzZ     // Catch:{ IllegalStateException -> 0x03e5 }
            r0 = r0 ^ r14
            com.google.android.gms.internal.ads.zzek.zzf(r0)     // Catch:{ IllegalStateException -> 0x03e5 }
            com.google.android.gms.internal.ads.zztb r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x03e5 }
            boolean r1 = r0.zzp()     // Catch:{ IllegalStateException -> 0x03e5 }
            if (r1 == 0) goto L_0x008e
            java.nio.ByteBuffer r7 = r0.zzc     // Catch:{ IllegalStateException -> 0x0087 }
            int r8 = r15.zzI     // Catch:{ IllegalStateException -> 0x0087 }
            int r10 = r0.zzl()     // Catch:{ IllegalStateException -> 0x0087 }
            long r11 = r0.zze     // Catch:{ IllegalStateException -> 0x0087 }
            long r1 = r23.zzf()     // Catch:{ IllegalStateException -> 0x0087 }
            long r3 = r0.zzm()     // Catch:{ IllegalStateException -> 0x0087 }
            boolean r0 = r15.zzaT(r1, r3)     // Catch:{ IllegalStateException -> 0x0087 }
            com.google.android.gms.internal.ads.zztb r1 = r15.zzi     // Catch:{ IllegalStateException -> 0x0087 }
            boolean r16 = r1.zzf()     // Catch:{ IllegalStateException -> 0x0087 }
            com.google.android.gms.internal.ads.zzam r9 = r15.zzn     // Catch:{ IllegalStateException -> 0x0087 }
            r9.getClass()
            r6 = 0
            r17 = 0
            r1 = r23
            r2 = r24
            r4 = r26
            r18 = r9
            r9 = r17
            r13 = r0
            r14 = r16
            r15 = r18
            boolean r0 = r1.zzar(r2, r4, r6, r7, r8, r9, r10, r11, r13, r14, r15)     // Catch:{ IllegalStateException -> 0x0083 }
            if (r0 == 0) goto L_0x007d
            r15 = r23
            com.google.android.gms.internal.ads.zztb r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x0087 }
            long r0 = r0.zzm()     // Catch:{ IllegalStateException -> 0x0087 }
            r15.zzaA(r0)     // Catch:{ IllegalStateException -> 0x0087 }
            com.google.android.gms.internal.ads.zztb r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x0087 }
            r0.zzb()     // Catch:{ IllegalStateException -> 0x0087 }
            goto L_0x008e
        L_0x007d:
            r15 = r23
            r13 = 0
            r14 = 1
            goto L_0x01c4
        L_0x0083:
            r0 = move-exception
            r15 = r23
            goto L_0x0088
        L_0x0087:
            r0 = move-exception
        L_0x0088:
            r1 = r15
            r2 = 1
        L_0x008a:
            r19 = 0
            goto L_0x03ea
        L_0x008e:
            boolean r0 = r15.zzY     // Catch:{ IllegalStateException -> 0x01d1 }
            if (r0 == 0) goto L_0x009c
            r14 = 1
            r15.zzZ = r14     // Catch:{ IllegalStateException -> 0x0098 }
            r13 = 0
            goto L_0x01c4
        L_0x0098:
            r0 = move-exception
            r2 = r14
            r1 = r15
            goto L_0x008a
        L_0x009c:
            r14 = 1
            boolean r0 = r15.zzN     // Catch:{ IllegalStateException -> 0x01cd }
            if (r0 == 0) goto L_0x00b0
            com.google.android.gms.internal.ads.zztb r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x01cd }
            com.google.android.gms.internal.ads.zzih r1 = r15.zzh     // Catch:{ IllegalStateException -> 0x01cd }
            boolean r0 = r0.zzo(r1)     // Catch:{ IllegalStateException -> 0x01cd }
            com.google.android.gms.internal.ads.zzek.zzf(r0)     // Catch:{ IllegalStateException -> 0x01cd }
            r13 = 0
            r15.zzN = r13     // Catch:{ IllegalStateException -> 0x03e5 }
            goto L_0x00b1
        L_0x00b0:
            r13 = 0
        L_0x00b1:
            boolean r0 = r15.zzO     // Catch:{ IllegalStateException -> 0x03e5 }
            if (r0 == 0) goto L_0x00c9
            com.google.android.gms.internal.ads.zztb r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x03e5 }
            boolean r0 = r0.zzp()     // Catch:{ IllegalStateException -> 0x03e5 }
            if (r0 != 0) goto L_0x0025
            r23.zzad()     // Catch:{ IllegalStateException -> 0x03e5 }
            r15.zzO = r13     // Catch:{ IllegalStateException -> 0x03e5 }
            r23.zzaz()     // Catch:{ IllegalStateException -> 0x03e5 }
            boolean r0 = r15.zzM     // Catch:{ IllegalStateException -> 0x03e5 }
            if (r0 == 0) goto L_0x01c4
        L_0x00c9:
            boolean r0 = r15.zzY     // Catch:{ IllegalStateException -> 0x03e5 }
            r0 = r0 ^ r14
            com.google.android.gms.internal.ads.zzek.zzf(r0)     // Catch:{ IllegalStateException -> 0x03e5 }
            com.google.android.gms.internal.ads.zzlb r0 = r23.zzcX()     // Catch:{ IllegalStateException -> 0x03e5 }
            com.google.android.gms.internal.ads.zzih r1 = r15.zzh     // Catch:{ IllegalStateException -> 0x03e5 }
            r1.zzb()     // Catch:{ IllegalStateException -> 0x03e5 }
        L_0x00d8:
            com.google.android.gms.internal.ads.zzih r1 = r15.zzh     // Catch:{ IllegalStateException -> 0x03e5 }
            r1.zzb()     // Catch:{ IllegalStateException -> 0x03e5 }
            com.google.android.gms.internal.ads.zzih r1 = r15.zzh     // Catch:{ IllegalStateException -> 0x03e5 }
            int r1 = r15.zzcV(r0, r1, r13)     // Catch:{ IllegalStateException -> 0x03e5 }
            r2 = -5
            if (r1 == r2) goto L_0x01a4
            r2 = -4
            if (r1 == r2) goto L_0x00eb
            goto L_0x01a7
        L_0x00eb:
            com.google.android.gms.internal.ads.zzih r1 = r15.zzh     // Catch:{ IllegalStateException -> 0x03e5 }
            boolean r1 = r1.zzf()     // Catch:{ IllegalStateException -> 0x03e5 }
            if (r1 == 0) goto L_0x00f7
            r15.zzY = r14     // Catch:{ IllegalStateException -> 0x03e5 }
            goto L_0x01a7
        L_0x00f7:
            boolean r1 = r15.zzaa     // Catch:{ IllegalStateException -> 0x03e5 }
            java.lang.String r2 = "audio/opus"
            if (r1 == 0) goto L_0x013e
            com.google.android.gms.internal.ads.zzam r1 = r15.zzm     // Catch:{ IllegalStateException -> 0x03e5 }
            r1.getClass()
            r15.zzn = r1     // Catch:{ IllegalStateException -> 0x03e5 }
            java.lang.String r1 = r1.zzm     // Catch:{ IllegalStateException -> 0x03e5 }
            boolean r1 = java.util.Objects.equals(r1, r2)     // Catch:{ IllegalStateException -> 0x03e5 }
            if (r1 == 0) goto L_0x0136
            com.google.android.gms.internal.ads.zzam r1 = r15.zzn     // Catch:{ IllegalStateException -> 0x03e5 }
            java.util.List r1 = r1.zzo     // Catch:{ IllegalStateException -> 0x03e5 }
            boolean r1 = r1.isEmpty()     // Catch:{ IllegalStateException -> 0x03e5 }
            if (r1 != 0) goto L_0x0136
            com.google.android.gms.internal.ads.zzam r1 = r15.zzn     // Catch:{ IllegalStateException -> 0x03e5 }
            java.util.List r1 = r1.zzo     // Catch:{ IllegalStateException -> 0x03e5 }
            java.lang.Object r1 = r1.get(r13)     // Catch:{ IllegalStateException -> 0x03e5 }
            byte[] r1 = (byte[]) r1     // Catch:{ IllegalStateException -> 0x03e5 }
            int r1 = com.google.android.gms.internal.ads.zzaeb.zza(r1)     // Catch:{ IllegalStateException -> 0x03e5 }
            com.google.android.gms.internal.ads.zzam r3 = r15.zzn     // Catch:{ IllegalStateException -> 0x03e5 }
            r3.getClass()
            com.google.android.gms.internal.ads.zzak r3 = r3.zzb()     // Catch:{ IllegalStateException -> 0x03e5 }
            r3.zzF(r1)     // Catch:{ IllegalStateException -> 0x03e5 }
            com.google.android.gms.internal.ads.zzam r1 = r3.zzac()     // Catch:{ IllegalStateException -> 0x03e5 }
            r15.zzn = r1     // Catch:{ IllegalStateException -> 0x03e5 }
        L_0x0136:
            com.google.android.gms.internal.ads.zzam r1 = r15.zzn     // Catch:{ IllegalStateException -> 0x03e5 }
            r3 = 0
            r15.zzan(r1, r3)     // Catch:{ IllegalStateException -> 0x03e5 }
            r15.zzaa = r13     // Catch:{ IllegalStateException -> 0x03e5 }
        L_0x013e:
            com.google.android.gms.internal.ads.zzih r1 = r15.zzh     // Catch:{ IllegalStateException -> 0x03e5 }
            r1.zzj()     // Catch:{ IllegalStateException -> 0x03e5 }
            com.google.android.gms.internal.ads.zzam r1 = r15.zzn     // Catch:{ IllegalStateException -> 0x03e5 }
            if (r1 == 0) goto L_0x0178
            java.lang.String r1 = r1.zzm     // Catch:{ IllegalStateException -> 0x03e5 }
            boolean r1 = java.util.Objects.equals(r1, r2)     // Catch:{ IllegalStateException -> 0x03e5 }
            if (r1 == 0) goto L_0x0178
            com.google.android.gms.internal.ads.zzih r1 = r15.zzh     // Catch:{ IllegalStateException -> 0x03e5 }
            boolean r2 = r1.zze()     // Catch:{ IllegalStateException -> 0x03e5 }
            if (r2 == 0) goto L_0x015e
            com.google.android.gms.internal.ads.zzam r2 = r15.zzn     // Catch:{ IllegalStateException -> 0x03e5 }
            r1.zza = r2     // Catch:{ IllegalStateException -> 0x03e5 }
            r15.zzaj(r1)     // Catch:{ IllegalStateException -> 0x03e5 }
        L_0x015e:
            long r1 = r23.zzf()     // Catch:{ IllegalStateException -> 0x03e5 }
            com.google.android.gms.internal.ads.zzih r3 = r15.zzh     // Catch:{ IllegalStateException -> 0x03e5 }
            long r4 = r3.zze     // Catch:{ IllegalStateException -> 0x03e5 }
            boolean r1 = com.google.android.gms.internal.ads.zzaeb.zzf(r1, r4)     // Catch:{ IllegalStateException -> 0x03e5 }
            if (r1 == 0) goto L_0x0178
            com.google.android.gms.internal.ads.zzry r1 = r15.zzl     // Catch:{ IllegalStateException -> 0x03e5 }
            com.google.android.gms.internal.ads.zzam r2 = r15.zzn     // Catch:{ IllegalStateException -> 0x03e5 }
            r2.getClass()
            java.util.List r2 = r2.zzo     // Catch:{ IllegalStateException -> 0x03e5 }
            r1.zza(r3, r2)     // Catch:{ IllegalStateException -> 0x03e5 }
        L_0x0178:
            com.google.android.gms.internal.ads.zztb r1 = r15.zzi     // Catch:{ IllegalStateException -> 0x03e5 }
            boolean r2 = r1.zzp()     // Catch:{ IllegalStateException -> 0x03e5 }
            if (r2 != 0) goto L_0x0181
            goto L_0x0197
        L_0x0181:
            long r2 = r23.zzf()     // Catch:{ IllegalStateException -> 0x03e5 }
            long r4 = r1.zzm()     // Catch:{ IllegalStateException -> 0x03e5 }
            boolean r1 = r15.zzaT(r2, r4)     // Catch:{ IllegalStateException -> 0x03e5 }
            com.google.android.gms.internal.ads.zzih r4 = r15.zzh     // Catch:{ IllegalStateException -> 0x03e5 }
            long r4 = r4.zze     // Catch:{ IllegalStateException -> 0x03e5 }
            boolean r2 = r15.zzaT(r2, r4)     // Catch:{ IllegalStateException -> 0x03e5 }
            if (r1 != r2) goto L_0x01a1
        L_0x0197:
            com.google.android.gms.internal.ads.zztb r1 = r15.zzi     // Catch:{ IllegalStateException -> 0x03e5 }
            com.google.android.gms.internal.ads.zzih r2 = r15.zzh     // Catch:{ IllegalStateException -> 0x03e5 }
            boolean r1 = r1.zzo(r2)     // Catch:{ IllegalStateException -> 0x03e5 }
            if (r1 != 0) goto L_0x00d8
        L_0x01a1:
            r15.zzN = r14     // Catch:{ IllegalStateException -> 0x03e5 }
            goto L_0x01a7
        L_0x01a4:
            r15.zzac(r0)     // Catch:{ IllegalStateException -> 0x03e5 }
        L_0x01a7:
            com.google.android.gms.internal.ads.zztb r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x03e5 }
            boolean r1 = r0.zzp()     // Catch:{ IllegalStateException -> 0x03e5 }
            if (r1 == 0) goto L_0x01b2
            r0.zzj()     // Catch:{ IllegalStateException -> 0x03e5 }
        L_0x01b2:
            com.google.android.gms.internal.ads.zztb r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x03e5 }
            boolean r0 = r0.zzp()     // Catch:{ IllegalStateException -> 0x03e5 }
            if (r0 != 0) goto L_0x0025
            boolean r0 = r15.zzY     // Catch:{ IllegalStateException -> 0x03e5 }
            if (r0 != 0) goto L_0x0025
            boolean r0 = r15.zzO     // Catch:{ IllegalStateException -> 0x03e5 }
            if (r0 == 0) goto L_0x01c4
            goto L_0x0025
        L_0x01c4:
            android.os.Trace.endSection()     // Catch:{ IllegalStateException -> 0x03e5 }
            r19 = r13
            r2 = r14
            r1 = r15
            goto L_0x03da
        L_0x01cd:
            r0 = move-exception
            r13 = 0
            goto L_0x03e6
        L_0x01d1:
            r0 = move-exception
            r13 = 0
            r14 = 1
            goto L_0x03e6
        L_0x01d6:
            com.google.android.gms.internal.ads.zztf r0 = r15.zzr     // Catch:{ IllegalStateException -> 0x03e5 }
            if (r0 == 0) goto L_0x03c8
            r23.zzh()     // Catch:{ IllegalStateException -> 0x03c3 }
            long r9 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IllegalStateException -> 0x03c3 }
            java.lang.String r0 = "drainAndFeed"
            android.os.Trace.beginSection(r0)     // Catch:{ IllegalStateException -> 0x03c3 }
        L_0x01e6:
            com.google.android.gms.internal.ads.zztf r6 = r15.zzr     // Catch:{ IllegalStateException -> 0x03c3 }
            r6.getClass()
            boolean r0 = r23.zzaS()     // Catch:{ IllegalStateException -> 0x03c3 }
            if (r0 != 0) goto L_0x02fc
            boolean r0 = r15.zzC     // Catch:{ IllegalStateException -> 0x03e5 }
            if (r0 == 0) goto L_0x020b
            boolean r0 = r15.zzU     // Catch:{ IllegalStateException -> 0x03e5 }
            if (r0 == 0) goto L_0x020b
            android.media.MediaCodec$BufferInfo r0 = r15.zzj     // Catch:{ IllegalStateException -> 0x0200 }
            int r0 = r6.zzb(r0)     // Catch:{ IllegalStateException -> 0x0200 }
            goto L_0x0211
        L_0x0200:
            r23.zzao()     // Catch:{ IllegalStateException -> 0x03e5 }
            boolean r0 = r15.zzZ     // Catch:{ IllegalStateException -> 0x03e5 }
            if (r0 == 0) goto L_0x024e
            r23.zzaD()     // Catch:{ IllegalStateException -> 0x03e5 }
            goto L_0x024e
        L_0x020b:
            android.media.MediaCodec$BufferInfo r0 = r15.zzj     // Catch:{ IllegalStateException -> 0x03e5 }
            int r0 = r6.zzb(r0)     // Catch:{ IllegalStateException -> 0x03e5 }
        L_0x0211:
            if (r0 >= 0) goto L_0x0254
            r1 = -2
            if (r0 != r1) goto L_0x023f
            r15.zzV = r14     // Catch:{ IllegalStateException -> 0x03e5 }
            com.google.android.gms.internal.ads.zztf r0 = r15.zzr     // Catch:{ IllegalStateException -> 0x03e5 }
            r0.getClass()
            android.media.MediaFormat r0 = r0.zzc()     // Catch:{ IllegalStateException -> 0x03e5 }
            int r1 = r15.zzz     // Catch:{ IllegalStateException -> 0x03e5 }
            if (r1 == 0) goto L_0x023a
            java.lang.String r1 = "width"
            int r1 = r0.getInteger(r1)     // Catch:{ IllegalStateException -> 0x03e5 }
            r2 = 32
            if (r1 != r2) goto L_0x023a
            java.lang.String r1 = "height"
            int r1 = r0.getInteger(r1)     // Catch:{ IllegalStateException -> 0x03e5 }
            if (r1 != r2) goto L_0x023a
            r15.zzE = r14     // Catch:{ IllegalStateException -> 0x03e5 }
            goto L_0x025d
        L_0x023a:
            r15.zzt = r0     // Catch:{ IllegalStateException -> 0x03e5 }
            r15.zzu = r14     // Catch:{ IllegalStateException -> 0x03e5 }
            goto L_0x025d
        L_0x023f:
            boolean r0 = r15.zzF     // Catch:{ IllegalStateException -> 0x03e5 }
            if (r0 == 0) goto L_0x024e
            boolean r0 = r15.zzY     // Catch:{ IllegalStateException -> 0x03e5 }
            if (r0 != 0) goto L_0x024b
            int r0 = r15.zzR     // Catch:{ IllegalStateException -> 0x03e5 }
            if (r0 != r11) goto L_0x024e
        L_0x024b:
            r23.zzao()     // Catch:{ IllegalStateException -> 0x03e5 }
        L_0x024e:
            r2 = r9
            r19 = r13
            r1 = r15
            goto L_0x03ac
        L_0x0254:
            boolean r1 = r15.zzE     // Catch:{ IllegalStateException -> 0x03e5 }
            if (r1 == 0) goto L_0x0265
            r15.zzE = r13     // Catch:{ IllegalStateException -> 0x03e5 }
            r6.zzn(r0, r13)     // Catch:{ IllegalStateException -> 0x03e5 }
        L_0x025d:
            r2 = r9
            r16 = r11
            r19 = r13
            r1 = r15
            goto L_0x0399
        L_0x0265:
            android.media.MediaCodec$BufferInfo r1 = r15.zzj     // Catch:{ IllegalStateException -> 0x03e5 }
            int r1 = r1.size     // Catch:{ IllegalStateException -> 0x03e5 }
            if (r1 != 0) goto L_0x0277
            android.media.MediaCodec$BufferInfo r1 = r15.zzj     // Catch:{ IllegalStateException -> 0x03e5 }
            int r1 = r1.flags     // Catch:{ IllegalStateException -> 0x03e5 }
            r1 = r1 & 4
            if (r1 == 0) goto L_0x0277
            r23.zzao()     // Catch:{ IllegalStateException -> 0x03e5 }
            goto L_0x024e
        L_0x0277:
            r15.zzI = r0     // Catch:{ IllegalStateException -> 0x03e5 }
            java.nio.ByteBuffer r0 = r6.zzg(r0)     // Catch:{ IllegalStateException -> 0x03e5 }
            r15.zzJ = r0     // Catch:{ IllegalStateException -> 0x03e5 }
            if (r0 == 0) goto L_0x0296
            android.media.MediaCodec$BufferInfo r1 = r15.zzj     // Catch:{ IllegalStateException -> 0x03e5 }
            int r1 = r1.offset     // Catch:{ IllegalStateException -> 0x03e5 }
            r0.position(r1)     // Catch:{ IllegalStateException -> 0x03e5 }
            java.nio.ByteBuffer r0 = r15.zzJ     // Catch:{ IllegalStateException -> 0x03e5 }
            android.media.MediaCodec$BufferInfo r1 = r15.zzj     // Catch:{ IllegalStateException -> 0x03e5 }
            int r1 = r1.offset     // Catch:{ IllegalStateException -> 0x03e5 }
            android.media.MediaCodec$BufferInfo r2 = r15.zzj     // Catch:{ IllegalStateException -> 0x03e5 }
            int r2 = r2.size     // Catch:{ IllegalStateException -> 0x03e5 }
            int r1 = r1 + r2
            r0.limit(r1)     // Catch:{ IllegalStateException -> 0x03e5 }
        L_0x0296:
            android.media.MediaCodec$BufferInfo r0 = r15.zzj     // Catch:{ IllegalStateException -> 0x03e5 }
            long r0 = r0.presentationTimeUs     // Catch:{ IllegalStateException -> 0x03e5 }
            long r2 = r23.zzf()     // Catch:{ IllegalStateException -> 0x03e5 }
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x02a4
            r0 = r14
            goto L_0x02a5
        L_0x02a4:
            r0 = r13
        L_0x02a5:
            r15.zzK = r0     // Catch:{ IllegalStateException -> 0x03e5 }
            long r0 = r15.zzX     // Catch:{ IllegalStateException -> 0x03e5 }
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x02bc
            android.media.MediaCodec$BufferInfo r2 = r15.zzj     // Catch:{ IllegalStateException -> 0x03e5 }
            long r2 = r2.presentationTimeUs     // Catch:{ IllegalStateException -> 0x03e5 }
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x02bc
            r0 = r14
            goto L_0x02bd
        L_0x02bc:
            r0 = r13
        L_0x02bd:
            r15.zzL = r0     // Catch:{ IllegalStateException -> 0x03e5 }
            android.media.MediaCodec$BufferInfo r0 = r15.zzj     // Catch:{ IllegalStateException -> 0x03e5 }
            long r0 = r0.presentationTimeUs     // Catch:{ IllegalStateException -> 0x03e5 }
            com.google.android.gms.internal.ads.zztn r2 = r15.zzab     // Catch:{ IllegalStateException -> 0x03e5 }
            com.google.android.gms.internal.ads.zzfu r2 = r2.zze     // Catch:{ IllegalStateException -> 0x03e5 }
            java.lang.Object r0 = r2.zzc(r0)     // Catch:{ IllegalStateException -> 0x03e5 }
            com.google.android.gms.internal.ads.zzam r0 = (com.google.android.gms.internal.ads.zzam) r0     // Catch:{ IllegalStateException -> 0x03e5 }
            if (r0 != 0) goto L_0x02e1
            boolean r1 = r15.zzad     // Catch:{ IllegalStateException -> 0x03e5 }
            if (r1 == 0) goto L_0x02e1
            android.media.MediaFormat r1 = r15.zzt     // Catch:{ IllegalStateException -> 0x03e5 }
            if (r1 == 0) goto L_0x02e1
            com.google.android.gms.internal.ads.zztn r0 = r15.zzab     // Catch:{ IllegalStateException -> 0x03e5 }
            com.google.android.gms.internal.ads.zzfu r0 = r0.zze     // Catch:{ IllegalStateException -> 0x03e5 }
            java.lang.Object r0 = r0.zzb()     // Catch:{ IllegalStateException -> 0x03e5 }
            com.google.android.gms.internal.ads.zzam r0 = (com.google.android.gms.internal.ads.zzam) r0     // Catch:{ IllegalStateException -> 0x03e5 }
        L_0x02e1:
            if (r0 == 0) goto L_0x02e6
            r15.zzn = r0     // Catch:{ IllegalStateException -> 0x03e5 }
            goto L_0x02ee
        L_0x02e6:
            boolean r0 = r15.zzu     // Catch:{ IllegalStateException -> 0x03e5 }
            if (r0 == 0) goto L_0x02fc
            com.google.android.gms.internal.ads.zzam r0 = r15.zzn     // Catch:{ IllegalStateException -> 0x03e5 }
            if (r0 == 0) goto L_0x02fc
        L_0x02ee:
            com.google.android.gms.internal.ads.zzam r0 = r15.zzn     // Catch:{ IllegalStateException -> 0x03e5 }
            r0.getClass()
            android.media.MediaFormat r1 = r15.zzt     // Catch:{ IllegalStateException -> 0x03e5 }
            r15.zzan(r0, r1)     // Catch:{ IllegalStateException -> 0x03e5 }
            r15.zzu = r13     // Catch:{ IllegalStateException -> 0x03e5 }
            r15.zzad = r13     // Catch:{ IllegalStateException -> 0x03e5 }
        L_0x02fc:
            boolean r0 = r15.zzC     // Catch:{ IllegalStateException -> 0x03c3 }
            if (r0 == 0) goto L_0x0356
            boolean r0 = r15.zzU     // Catch:{ IllegalStateException -> 0x03c3 }
            if (r0 == 0) goto L_0x0356
            java.nio.ByteBuffer r7 = r15.zzJ     // Catch:{ IllegalStateException -> 0x033d }
            int r8 = r15.zzI     // Catch:{ IllegalStateException -> 0x033d }
            android.media.MediaCodec$BufferInfo r0 = r15.zzj     // Catch:{ IllegalStateException -> 0x033d }
            int r0 = r0.flags     // Catch:{ IllegalStateException -> 0x033d }
            android.media.MediaCodec$BufferInfo r1 = r15.zzj     // Catch:{ IllegalStateException -> 0x033d }
            long r4 = r1.presentationTimeUs     // Catch:{ IllegalStateException -> 0x033d }
            boolean r12 = r15.zzK     // Catch:{ IllegalStateException -> 0x033d }
            boolean r2 = r15.zzL     // Catch:{ IllegalStateException -> 0x033d }
            com.google.android.gms.internal.ads.zzam r3 = r15.zzn     // Catch:{ IllegalStateException -> 0x033d }
            r3.getClass()
            r16 = 1
            r1 = r23
            r17 = r2
            r18 = r3
            r2 = r24
            r19 = r4
            r4 = r26
            r21 = r9
            r9 = r0
            r10 = r16
            r16 = r11
            r0 = r12
            r11 = r19
            r19 = r13
            r13 = r0
            r14 = r17
            r15 = r18
            boolean r0 = r1.zzar(r2, r4, r6, r7, r8, r9, r10, r11, r13, r14, r15)     // Catch:{ IllegalStateException -> 0x0341 }
            goto L_0x037d
        L_0x033d:
            r21 = r9
            r19 = r13
        L_0x0341:
            r23.zzao()     // Catch:{ IllegalStateException -> 0x0351 }
            r15 = r23
            boolean r0 = r15.zzZ     // Catch:{ IllegalStateException -> 0x03c1 }
            if (r0 == 0) goto L_0x034d
            r23.zzaD()     // Catch:{ IllegalStateException -> 0x03c1 }
        L_0x034d:
            r1 = r15
        L_0x034e:
            r2 = r21
            goto L_0x03ac
        L_0x0351:
            r0 = move-exception
            r15 = r23
            goto L_0x03c6
        L_0x0356:
            r21 = r9
            r16 = r11
            r19 = r13
            java.nio.ByteBuffer r7 = r15.zzJ     // Catch:{ IllegalStateException -> 0x03c1 }
            int r8 = r15.zzI     // Catch:{ IllegalStateException -> 0x03c1 }
            android.media.MediaCodec$BufferInfo r0 = r15.zzj     // Catch:{ IllegalStateException -> 0x03c1 }
            int r9 = r0.flags     // Catch:{ IllegalStateException -> 0x03c1 }
            android.media.MediaCodec$BufferInfo r0 = r15.zzj     // Catch:{ IllegalStateException -> 0x03c1 }
            long r11 = r0.presentationTimeUs     // Catch:{ IllegalStateException -> 0x03c1 }
            boolean r13 = r15.zzK     // Catch:{ IllegalStateException -> 0x03c1 }
            boolean r14 = r15.zzL     // Catch:{ IllegalStateException -> 0x03c1 }
            com.google.android.gms.internal.ads.zzam r0 = r15.zzn     // Catch:{ IllegalStateException -> 0x03c1 }
            r0.getClass()
            r10 = 1
            r1 = r23
            r2 = r24
            r4 = r26
            r15 = r0
            boolean r0 = r1.zzar(r2, r4, r6, r7, r8, r9, r10, r11, r13, r14, r15)     // Catch:{ IllegalStateException -> 0x03bd }
        L_0x037d:
            if (r0 == 0) goto L_0x03a9
            r1 = r23
            android.media.MediaCodec$BufferInfo r0 = r1.zzj     // Catch:{ IllegalStateException -> 0x03e2 }
            long r2 = r0.presentationTimeUs     // Catch:{ IllegalStateException -> 0x03e2 }
            r1.zzaA(r2)     // Catch:{ IllegalStateException -> 0x03e2 }
            android.media.MediaCodec$BufferInfo r0 = r1.zzj     // Catch:{ IllegalStateException -> 0x03e2 }
            int r0 = r0.flags     // Catch:{ IllegalStateException -> 0x03e2 }
            r0 = r0 & 4
            r23.zzaN()     // Catch:{ IllegalStateException -> 0x03e2 }
            if (r0 == 0) goto L_0x0397
            r23.zzao()     // Catch:{ IllegalStateException -> 0x03e2 }
            goto L_0x034e
        L_0x0397:
            r2 = r21
        L_0x0399:
            boolean r0 = r1.zzaV(r2)     // Catch:{ IllegalStateException -> 0x03e2 }
            if (r0 != 0) goto L_0x03a0
            goto L_0x03ac
        L_0x03a0:
            r15 = r1
            r9 = r2
            r11 = r16
            r13 = r19
            r14 = 1
            goto L_0x01e6
        L_0x03a9:
            r1 = r23
            goto L_0x034e
        L_0x03ac:
            boolean r0 = r23.zzaR()     // Catch:{ IllegalStateException -> 0x03e2 }
            if (r0 == 0) goto L_0x03b8
            boolean r0 = r1.zzaV(r2)     // Catch:{ IllegalStateException -> 0x03e2 }
            if (r0 != 0) goto L_0x03ac
        L_0x03b8:
            android.os.Trace.endSection()     // Catch:{ IllegalStateException -> 0x03e2 }
            r2 = 1
            goto L_0x03da
        L_0x03bd:
            r0 = move-exception
            r1 = r23
            goto L_0x03e3
        L_0x03c1:
            r0 = move-exception
            goto L_0x03c6
        L_0x03c3:
            r0 = move-exception
            r19 = r13
        L_0x03c6:
            r1 = r15
            goto L_0x03e3
        L_0x03c8:
            r19 = r13
            r1 = r15
            com.google.android.gms.internal.ads.zzir r0 = r1.zza     // Catch:{ IllegalStateException -> 0x03e2 }
            int r2 = r0.zzd     // Catch:{ IllegalStateException -> 0x03e2 }
            int r3 = r23.zzd(r24)     // Catch:{ IllegalStateException -> 0x03e2 }
            int r2 = r2 + r3
            r0.zzd = r2     // Catch:{ IllegalStateException -> 0x03e2 }
            r2 = 1
            r1.zzaU(r2)     // Catch:{ IllegalStateException -> 0x03e0 }
        L_0x03da:
            com.google.android.gms.internal.ads.zzir r0 = r1.zza     // Catch:{ IllegalStateException -> 0x03e0 }
            r0.zza()     // Catch:{ IllegalStateException -> 0x03e0 }
            return
        L_0x03e0:
            r0 = move-exception
            goto L_0x03ea
        L_0x03e2:
            r0 = move-exception
        L_0x03e3:
            r2 = 1
            goto L_0x03ea
        L_0x03e5:
            r0 = move-exception
        L_0x03e6:
            r19 = r13
            r2 = r14
            r1 = r15
        L_0x03ea:
            int r3 = com.google.android.gms.internal.ads.zzfx.zza
            boolean r3 = r0 instanceof android.media.MediaCodec.CodecException
            if (r3 == 0) goto L_0x03f1
            goto L_0x0406
        L_0x03f1:
            java.lang.StackTraceElement[] r4 = r0.getStackTrace()
            int r5 = r4.length
            if (r5 <= 0) goto L_0x042c
            r4 = r4[r19]
            java.lang.String r4 = r4.getClassName()
            java.lang.String r5 = "android.media.MediaCodec"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x042c
        L_0x0406:
            r1.zzak(r0)
            if (r3 == 0) goto L_0x0416
            r3 = r0
            android.media.MediaCodec$CodecException r3 = (android.media.MediaCodec.CodecException) r3
            boolean r3 = r3.isRecoverable()
            if (r3 == 0) goto L_0x0416
            r14 = r2
            goto L_0x0418
        L_0x0416:
            r14 = r19
        L_0x0418:
            if (r14 == 0) goto L_0x041d
            r23.zzaD()
        L_0x041d:
            com.google.android.gms.internal.ads.zzti r2 = r1.zzy
            com.google.android.gms.internal.ads.zzth r0 = r1.zzax(r0, r2)
            com.google.android.gms.internal.ads.zzam r2 = r1.zzm
            r3 = 4003(0xfa3, float:5.61E-42)
            com.google.android.gms.internal.ads.zziz r0 = r1.zzi(r0, r2, r14, r3)
            throw r0
        L_0x042c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzto.zzV(long, long):void");
    }

    public boolean zzW() {
        return this.zzZ;
    }

    public boolean zzX() {
        if (this.zzm == null) {
            return false;
        }
        if (zzS() || zzaS()) {
            return true;
        }
        if (this.zzG == C.TIME_UNSET) {
            return false;
        }
        zzh();
        return SystemClock.elapsedRealtime() < this.zzG;
    }

    public final int zzY(zzam zzam) throws zziz {
        try {
            return zzaa(this.zzd, zzam);
        } catch (zztw e) {
            throw zzi(e, zzam, false, PlaybackException.ERROR_CODE_DECODER_QUERY_FAILED);
        }
    }

    /* access modifiers changed from: protected */
    public float zzZ(float f, zzam zzam, zzam[] zzamArr) {
        throw null;
    }

    /* access modifiers changed from: protected */
    public void zzaA(long j) {
        this.zzac = j;
        while (!this.zzk.isEmpty() && j >= ((zztn) this.zzk.peek()).zzb) {
            zztn zztn = (zztn) this.zzk.poll();
            zztn.getClass();
            zzaO(zztn);
            zzap();
        }
    }

    /* access modifiers changed from: protected */
    public void zzaB(zzih zzih) throws zziz {
    }

    /* access modifiers changed from: protected */
    public void zzaC(zzam zzam) throws zziz {
    }

    /* access modifiers changed from: protected */
    public final void zzaD() {
        try {
            zztf zztf = this.zzr;
            if (zztf != null) {
                zztf.zzl();
                this.zza.zzb++;
                zzti zzti = this.zzy;
                zzti.getClass();
                zzam(zzti.zza);
            }
        } finally {
            this.zzr = null;
            this.zzo = null;
            this.zzae = null;
            zzaF();
        }
    }

    /* access modifiers changed from: protected */
    public void zzaE() {
        zzaM();
        zzaN();
        this.zzG = C.TIME_UNSET;
        this.zzU = false;
        this.zzT = false;
        this.zzD = false;
        this.zzE = false;
        this.zzK = false;
        this.zzL = false;
        this.zzW = C.TIME_UNSET;
        this.zzX = C.TIME_UNSET;
        this.zzac = C.TIME_UNSET;
        this.zzR = 0;
        this.zzS = 0;
        this.zzQ = this.zzP ? 1 : 0;
    }

    /* access modifiers changed from: protected */
    public final void zzaF() {
        zzaE();
        this.zzw = null;
        this.zzy = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = false;
        this.zzV = false;
        this.zzv = -1.0f;
        this.zzz = 0;
        this.zzA = false;
        this.zzB = false;
        this.zzC = false;
        this.zzF = false;
        this.zzP = false;
        this.zzQ = 0;
    }

    /* access modifiers changed from: protected */
    public final boolean zzaG() throws zziz {
        boolean zzaH = zzaH();
        if (zzaH) {
            zzaz();
        }
        return zzaH;
    }

    /* access modifiers changed from: protected */
    public final boolean zzaH() {
        if (this.zzr == null) {
            return false;
        }
        int i = this.zzS;
        if (i == 3 || ((this.zzA && !this.zzV) || (this.zzB && this.zzU))) {
            zzaD();
            return true;
        }
        if (i == 2) {
            zzek.zzf(zzfx.zza >= 23);
            if (zzfx.zza >= 23) {
                try {
                    zzaP();
                } catch (zziz e) {
                    zzfe.zzg("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e);
                    zzaD();
                    return true;
                }
            }
        }
        zzah();
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean zzaI() {
        return this.zzM;
    }

    /* access modifiers changed from: protected */
    public final boolean zzaJ(zzam zzam) {
        return this.zzaf == null && zzas(zzam);
    }

    /* access modifiers changed from: protected */
    public boolean zzaK(zzti zzti) {
        return true;
    }

    /* access modifiers changed from: protected */
    public abstract int zzaa(zztq zztq, zzam zzam) throws zztw;

    /* access modifiers changed from: protected */
    public zzis zzab(zzti zzti, zzam zzam, zzam zzam2) {
        throw null;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0068, code lost:
        if (zzaQ() == false) goto L_0x00be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0094, code lost:
        if (zzaQ() == false) goto L_0x00be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00a7, code lost:
        if (zzaQ() == false) goto L_0x00be;
     */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d5 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.ads.zzis zzac(com.google.android.gms.internal.ads.zzlb r12) throws com.google.android.gms.internal.ads.zziz {
        /*
            r11 = this;
            r0 = 1
            r11.zzaa = r0
            com.google.android.gms.internal.ads.zzam r4 = r12.zza
            r4.getClass()
            java.lang.String r1 = r4.zzm
            r2 = 0
            if (r1 == 0) goto L_0x00e5
            com.google.android.gms.internal.ads.zzsn r12 = r12.zzb
            r11.zzaf = r12
            r11.zzm = r4
            boolean r12 = r11.zzM
            r1 = 0
            if (r12 == 0) goto L_0x001b
            r11.zzO = r0
            return r1
        L_0x001b:
            com.google.android.gms.internal.ads.zztf r12 = r11.zzr
            if (r12 != 0) goto L_0x0025
            r11.zzw = r1
            r11.zzaz()
            return r1
        L_0x0025:
            com.google.android.gms.internal.ads.zzti r1 = r11.zzy
            r1.getClass()
            com.google.android.gms.internal.ads.zzam r3 = r11.zzs
            r3.getClass()
            com.google.android.gms.internal.ads.zzsn r5 = r11.zzae
            com.google.android.gms.internal.ads.zzsn r6 = r11.zzaf
            if (r5 != r6) goto L_0x00d6
            if (r6 == r5) goto L_0x0039
            r5 = r0
            goto L_0x003a
        L_0x0039:
            r5 = r2
        L_0x003a:
            if (r5 == 0) goto L_0x0045
            int r6 = com.google.android.gms.internal.ads.zzfx.zza
            r7 = 23
            if (r6 < r7) goto L_0x0043
            goto L_0x0045
        L_0x0043:
            r6 = r2
            goto L_0x0046
        L_0x0045:
            r6 = r0
        L_0x0046:
            com.google.android.gms.internal.ads.zzek.zzf(r6)
            com.google.android.gms.internal.ads.zzis r6 = r11.zzab(r1, r3, r4)
            int r7 = r6.zzd
            r8 = 3
            if (r7 == 0) goto L_0x00ba
            r9 = 16
            r10 = 2
            if (r7 == r0) goto L_0x0097
            if (r7 == r10) goto L_0x006b
            boolean r0 = r11.zzaW(r4)
            if (r0 != 0) goto L_0x0060
            goto L_0x009d
        L_0x0060:
            r11.zzs = r4
            if (r5 == 0) goto L_0x00bd
            boolean r0 = r11.zzaQ()
            if (r0 != 0) goto L_0x00bd
            goto L_0x00be
        L_0x006b:
            boolean r7 = r11.zzaW(r4)
            if (r7 != 0) goto L_0x0072
            goto L_0x009d
        L_0x0072:
            r11.zzP = r0
            r11.zzQ = r0
            int r7 = r11.zzz
            if (r7 == r10) goto L_0x008a
            if (r7 != r0) goto L_0x0089
            int r7 = r4.zzr
            int r9 = r3.zzr
            if (r7 != r9) goto L_0x0089
            int r7 = r4.zzs
            int r9 = r3.zzs
            if (r7 != r9) goto L_0x0089
            goto L_0x008a
        L_0x0089:
            r0 = r2
        L_0x008a:
            r11.zzD = r0
            r11.zzs = r4
            if (r5 == 0) goto L_0x00bd
            boolean r0 = r11.zzaQ()
            if (r0 != 0) goto L_0x00bd
            goto L_0x00be
        L_0x0097:
            boolean r7 = r11.zzaW(r4)
            if (r7 != 0) goto L_0x009f
        L_0x009d:
            r10 = r9
            goto L_0x00be
        L_0x009f:
            r11.zzs = r4
            if (r5 == 0) goto L_0x00aa
            boolean r0 = r11.zzaQ()
            if (r0 != 0) goto L_0x00bd
            goto L_0x00be
        L_0x00aa:
            boolean r5 = r11.zzT
            if (r5 == 0) goto L_0x00bd
            r11.zzR = r0
            boolean r5 = r11.zzB
            if (r5 == 0) goto L_0x00b7
            r11.zzS = r8
            goto L_0x00be
        L_0x00b7:
            r11.zzS = r0
            goto L_0x00bd
        L_0x00ba:
            r11.zzae()
        L_0x00bd:
            r10 = r2
        L_0x00be:
            int r0 = r6.zzd
            if (r0 == 0) goto L_0x00d5
            com.google.android.gms.internal.ads.zztf r0 = r11.zzr
            if (r0 != r12) goto L_0x00ca
            int r12 = r11.zzS
            if (r12 != r8) goto L_0x00d5
        L_0x00ca:
            java.lang.String r2 = r1.zza
            com.google.android.gms.internal.ads.zzis r12 = new com.google.android.gms.internal.ads.zzis
            r5 = 0
            r1 = r12
            r6 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            return r12
        L_0x00d5:
            return r6
        L_0x00d6:
            r11.zzae()
            java.lang.String r2 = r1.zza
            com.google.android.gms.internal.ads.zzis r12 = new com.google.android.gms.internal.ads.zzis
            r5 = 0
            r6 = 128(0x80, float:1.794E-43)
            r1 = r12
            r1.<init>(r2, r3, r4, r5, r6)
            return r12
        L_0x00e5:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Sample MIME type is null."
            r12.<init>(r0)
            r0 = 4005(0xfa5, float:5.612E-42)
            com.google.android.gms.internal.ads.zziz r12 = r11.zzi(r12, r4, r2, r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzto.zzac(com.google.android.gms.internal.ads.zzlb):com.google.android.gms.internal.ads.zzis");
    }

    /* access modifiers changed from: protected */
    public abstract zztd zzaf(zzti zzti, zzam zzam, MediaCrypto mediaCrypto, float f);

    /* access modifiers changed from: protected */
    public abstract List zzag(zztq zztq, zzam zzam, boolean z) throws zztw;

    /* access modifiers changed from: protected */
    public void zzaj(zzih zzih) throws zziz {
        throw null;
    }

    /* access modifiers changed from: protected */
    public void zzak(Exception exc) {
        throw null;
    }

    /* access modifiers changed from: protected */
    public void zzal(String str, zztd zztd, long j, long j2) {
        throw null;
    }

    /* access modifiers changed from: protected */
    public void zzam(String str) {
        throw null;
    }

    /* access modifiers changed from: protected */
    public void zzan(zzam zzam, MediaFormat mediaFormat) throws zziz {
        throw null;
    }

    /* access modifiers changed from: protected */
    public void zzap() {
    }

    /* access modifiers changed from: protected */
    public void zzaq() throws zziz {
    }

    /* access modifiers changed from: protected */
    public abstract boolean zzar(long j, long j2, zztf zztf, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, zzam zzam) throws zziz;

    /* access modifiers changed from: protected */
    public boolean zzas(zzam zzam) {
        return false;
    }

    /* access modifiers changed from: protected */
    public int zzat(zzih zzih) {
        return 0;
    }

    /* access modifiers changed from: protected */
    public final long zzau() {
        return this.zzab.zzd;
    }

    /* access modifiers changed from: protected */
    public final long zzav() {
        return this.zzab.zzc;
    }

    /* access modifiers changed from: protected */
    public final zztf zzaw() {
        return this.zzr;
    }

    /* access modifiers changed from: protected */
    public zzth zzax(Throwable th, zzti zzti) {
        return new zzth(th, zzti);
    }

    /* access modifiers changed from: protected */
    public final zzti zzay() {
        return this.zzy;
    }

    /* access modifiers changed from: protected */
    public final void zzaz() throws zziz {
        zzam zzam;
        zzam zzam2;
        if (this.zzr == null && !this.zzM && (zzam = this.zzm) != null) {
            if (zzaJ(zzam)) {
                zzad();
                String str = zzam.zzm;
                if (MimeTypes.AUDIO_AAC.equals(str) || MimeTypes.AUDIO_MPEG.equals(str) || MimeTypes.AUDIO_OPUS.equals(str)) {
                    this.zzi.zzn(32);
                } else {
                    this.zzi.zzn(1);
                }
                this.zzM = true;
                return;
            }
            zzsn zzsn = this.zzaf;
            this.zzae = zzsn;
            if (zzsn != null) {
                zzek.zzf(true);
                zzsn zzsn2 = this.zzae;
                boolean z = zzso.zza;
                zzsn2.zza();
            }
            try {
                if (this.zzae != null) {
                    zzek.zzb(zzam.zzm);
                }
                zzam2 = this.zzm;
                zzam2.getClass();
                if (this.zzw == null) {
                    List zzag = zzag(this.zzd, zzam2, false);
                    zzag.isEmpty();
                    this.zzw = new ArrayDeque();
                    if (!zzag.isEmpty()) {
                        this.zzw.add((zzti) zzag.get(0));
                    }
                    this.zzx = null;
                }
                if (!this.zzw.isEmpty()) {
                    ArrayDeque arrayDeque = this.zzw;
                    arrayDeque.getClass();
                    zzti zzti = (zzti) arrayDeque.peekFirst();
                    while (this.zzr == null) {
                        zzti zzti2 = (zzti) arrayDeque.peekFirst();
                        zzti2.getClass();
                        if (zzaK(zzti2)) {
                            try {
                                zzai(zzti2, (MediaCrypto) null);
                            } catch (Exception e) {
                                if (zzti2 == zzti) {
                                    zzfe.zzf("MediaCodecRenderer", "Preferred decoder instantiation failed. Sleeping for 50ms then retrying.");
                                    Thread.sleep(50);
                                    zzai(zzti2, (MediaCrypto) null);
                                } else {
                                    throw e;
                                }
                            } catch (Exception e2) {
                                zzfe.zzg("MediaCodecRenderer", "Failed to initialize decoder: ".concat(zzti2.zza), e2);
                                arrayDeque.removeFirst();
                                zztm zztm = new zztm(zzam2, (Throwable) e2, false, zzti2);
                                zzak(zztm);
                                zztm zztm2 = this.zzx;
                                if (zztm2 == null) {
                                    this.zzx = zztm;
                                } else {
                                    this.zzx = zztm.zza(zztm2, zztm);
                                }
                                if (arrayDeque.isEmpty()) {
                                    throw this.zzx;
                                }
                            }
                        } else {
                            return;
                        }
                    }
                    this.zzw = null;
                    return;
                }
                throw new zztm(zzam2, (Throwable) null, false, -49999);
            } catch (zztw e3) {
                throw new zztm(zzam2, (Throwable) e3, false, -49998);
            } catch (zztm e4) {
                throw zzi(e4, zzam, false, PlaybackException.ERROR_CODE_DECODER_INIT_FAILED);
            }
        }
    }

    public final int zze() {
        return 8;
    }

    /* access modifiers changed from: protected */
    public void zzw() {
        this.zzm = null;
        zzaO(zztn.zza);
        this.zzk.clear();
        zzaH();
    }

    /* access modifiers changed from: protected */
    public void zzx(boolean z, boolean z2) throws zziz {
        this.zza = new zzir();
    }

    /* access modifiers changed from: protected */
    public void zzz(long j, boolean z) throws zziz {
        this.zzY = false;
        this.zzZ = false;
        if (this.zzM) {
            this.zzi.zzb();
            this.zzh.zzb();
            this.zzN = false;
            this.zzl.zzb();
        } else {
            zzaG();
        }
        zzfu zzfu = this.zzab.zze;
        if (zzfu.zza() > 0) {
            this.zzaa = true;
        }
        zzfu.zze();
        this.zzk.clear();
    }

    private final void zzao() throws zziz {
        int i = this.zzS;
        if (i == 1) {
            zzah();
        } else if (i == 2) {
            zzah();
            zzaP();
        } else if (i != 3) {
            this.zzZ = true;
            zzaq();
        } else {
            zzaD();
            zzaz();
        }
    }

    /* JADX INFO: finally extract failed */
    private final void zzai(zzti zzti, MediaCrypto mediaCrypto) throws Exception {
        float f;
        long j;
        zztd zztd;
        boolean z;
        int i;
        boolean z2;
        long j2;
        zzti zzti2 = zzti;
        zzam zzam = this.zzm;
        zzam.getClass();
        String str = zzti2.zza;
        if (zzfx.zza < 23) {
            f = -1.0f;
        } else {
            f = zzZ(this.zzq, zzam, zzT());
        }
        if (f <= this.zze) {
            f = -1.0f;
        }
        zzaC(zzam);
        zzh();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        zztd zzaf2 = zzaf(zzti2, zzam, (MediaCrypto) null, f);
        if (zzfx.zza >= 31) {
            zztl.zza(zzaf2, zzn());
        }
        try {
            Trace.beginSection("createCodec:" + str);
            this.zzr = this.zzc.zzd(zzaf2);
            Trace.endSection();
            zzh();
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            if (!zzti2.zze(zzam)) {
                Object[] objArr = new Object[2];
                StringBuilder sb = new StringBuilder();
                sb.append("id=");
                sb.append(zzam.zzb);
                sb.append(", mimeType=");
                sb.append(zzam.zzm);
                if (zzam.zzl != null) {
                    sb.append(", container=");
                    sb.append(zzam.zzl);
                }
                if (zzam.zzi != -1) {
                    sb.append(", bitrate=");
                    sb.append(zzam.zzi);
                }
                if (zzam.zzj != null) {
                    sb.append(", codecs=");
                    sb.append(zzam.zzj);
                }
                if (zzam.zzp != null) {
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    int i2 = 0;
                    while (true) {
                        zzae zzae2 = zzam.zzp;
                        zztd = zzaf2;
                        if (i2 >= zzae2.zzb) {
                            break;
                        }
                        UUID uuid = zzae2.zza(i2).zza;
                        if (uuid.equals(zzo.zzb)) {
                            linkedHashSet.add(C.CENC_TYPE_cenc);
                        } else if (uuid.equals(zzo.zzc)) {
                            linkedHashSet.add("clearkey");
                        } else if (uuid.equals(zzo.zze)) {
                            linkedHashSet.add("playready");
                        } else if (uuid.equals(zzo.zzd)) {
                            linkedHashSet.add("widevine");
                        } else if (uuid.equals(zzo.zza)) {
                            linkedHashSet.add("universal");
                        } else {
                            j2 = elapsedRealtime;
                            linkedHashSet.add("unknown (" + uuid.toString() + ")");
                            i2++;
                            zzaf2 = zztd;
                            elapsedRealtime = j2;
                        }
                        j2 = elapsedRealtime;
                        i2++;
                        zzaf2 = zztd;
                        elapsedRealtime = j2;
                    }
                    j = elapsedRealtime;
                    sb.append(", drm=[");
                    zzfwg.zzb(sb, linkedHashSet, f.a);
                    sb.append(AbstractJsonLexerKt.END_LIST);
                } else {
                    zztd = zzaf2;
                    j = elapsedRealtime;
                }
                if (!(zzam.zzr == -1 || zzam.zzs == -1)) {
                    sb.append(", res=");
                    sb.append(zzam.zzr);
                    sb.append("x");
                    sb.append(zzam.zzs);
                }
                zzt zzt2 = zzam.zzy;
                if (zzt2 != null && (zzt2.zze() || zzt2.zzf())) {
                    sb.append(", color=");
                    sb.append(zzam.zzy.zzd());
                }
                if (zzam.zzt != -1.0f) {
                    sb.append(", fps=");
                    sb.append(zzam.zzt);
                }
                if (zzam.zzz != -1) {
                    sb.append(", channels=");
                    sb.append(zzam.zzz);
                }
                if (zzam.zzA != -1) {
                    sb.append(", sample_rate=");
                    sb.append(zzam.zzA);
                }
                if (zzam.zzd != null) {
                    sb.append(", language=");
                    sb.append(zzam.zzd);
                }
                if (zzam.zzc != null) {
                    sb.append(", label=");
                    sb.append(zzam.zzc);
                }
                if (zzam.zze != 0) {
                    sb.append(", selectionFlags=[");
                    int i3 = zzam.zze;
                    ArrayList arrayList = new ArrayList();
                    if ((i3 & 1) != 0) {
                        arrayList.add(Constants.COLLATION_DEFAULT);
                    }
                    if ((i3 & 2) != 0) {
                        arrayList.add("forced");
                    }
                    zzfwg.zzb(sb, arrayList, f.a);
                    sb.append("]");
                }
                if (zzam.zzf != 0) {
                    sb.append(", roleFlags=[");
                    int i4 = zzam.zzf;
                    ArrayList arrayList2 = new ArrayList();
                    if ((i4 & 1) != 0) {
                        arrayList2.add("main");
                    }
                    if ((i4 & 2) != 0) {
                        arrayList2.add("alt");
                    }
                    if ((i4 & 4) != 0) {
                        arrayList2.add("supplementary");
                    }
                    if ((i4 & 8) != 0) {
                        arrayList2.add("commentary");
                    }
                    if ((i4 & 16) != 0) {
                        arrayList2.add("dub");
                    }
                    if ((i4 & 32) != 0) {
                        arrayList2.add("emergency");
                    }
                    if ((i4 & 64) != 0) {
                        arrayList2.add("caption");
                    }
                    if ((i4 & 128) != 0) {
                        arrayList2.add("subtitle");
                    }
                    if ((i4 & 256) != 0) {
                        arrayList2.add("sign");
                    }
                    if ((i4 & 512) != 0) {
                        arrayList2.add("describes-video");
                    }
                    if ((i4 & 1024) != 0) {
                        arrayList2.add("describes-music");
                    }
                    if ((i4 & 2048) != 0) {
                        arrayList2.add("enhanced-intelligibility");
                    }
                    if ((i4 & 4096) != 0) {
                        arrayList2.add("transcribes-dialog");
                    }
                    if ((i4 & 8192) != 0) {
                        arrayList2.add("easy-read");
                    }
                    if ((i4 & 16384) != 0) {
                        arrayList2.add("trick-play");
                    }
                    zzfwg.zzb(sb, arrayList2, f.a);
                    sb.append("]");
                }
                z = false;
                objArr[0] = sb.toString();
                objArr[1] = str;
                zzfe.zzf("MediaCodecRenderer", String.format(Locale.US, "Format exceeds selected codec's capabilities [%s, %s]", objArr));
            } else {
                zztd = zzaf2;
                j = elapsedRealtime;
                z = false;
            }
            this.zzy = zzti2;
            this.zzv = f;
            this.zzs = zzam;
            if (zzfx.zza > 25 || !"OMX.Exynos.avc.dec.secure".equals(str) || (!zzfx.zzd.startsWith("SM-T585") && !zzfx.zzd.startsWith("SM-A510") && !zzfx.zzd.startsWith("SM-A520") && !zzfx.zzd.startsWith("SM-J700"))) {
                i = (zzfx.zza >= 24 || (!"OMX.Nvidia.h264.decode".equals(str) && !"OMX.Nvidia.h264.decode.secure".equals(str)) || (!"flounder".equals(zzfx.zzb) && !"flounder_lte".equals(zzfx.zzb) && !"grouper".equals(zzfx.zzb) && !"tilapia".equals(zzfx.zzb))) ? z : 1;
            } else {
                i = 2;
            }
            this.zzz = i;
            this.zzs.getClass();
            this.zzA = (zzfx.zza != 29 || !"c2.android.aac.decoder".equals(str)) ? z : true;
            this.zzB = (zzfx.zza > 23 || !"OMX.google.vorbis.decoder".equals(str)) ? z : true;
            this.zzC = (zzfx.zza != 21 || !"OMX.google.aac.decoder".equals(str)) ? z : true;
            String str2 = zzti2.zza;
            if ((zzfx.zza > 25 || !"OMX.rk.video_decoder.avc".equals(str2)) && ((zzfx.zza > 29 || (!"OMX.broadcom.video_decoder.tunnel".equals(str2) && !"OMX.broadcom.video_decoder.tunnel.secure".equals(str2) && !"OMX.bcm.vdec.avc.tunnel".equals(str2) && !"OMX.bcm.vdec.avc.tunnel.secure".equals(str2) && !"OMX.bcm.vdec.hevc.tunnel".equals(str2) && !"OMX.bcm.vdec.hevc.tunnel.secure".equals(str2))) && (!"Amazon".equals(zzfx.zzc) || !"AFTS".equals(zzfx.zzd) || !zzti2.zzf))) {
                z2 = z;
            } else {
                z2 = true;
            }
            this.zzF = z2;
            this.zzr.getClass();
            if (zzcU() == 2) {
                zzh();
                this.zzG = SystemClock.elapsedRealtime() + 1000;
            }
            this.zza.zza++;
            zzal(str, zztd, elapsedRealtime2, elapsedRealtime2 - j);
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }
}
