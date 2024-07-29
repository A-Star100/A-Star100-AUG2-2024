package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import com.google.android.exoplayer2.C;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzko extends zzm implements zzjj {
    public static final /* synthetic */ int zzd = 0;
    private final zzmo zzA;
    private final long zzB;
    private int zzC;
    private int zzD;
    private boolean zzE;
    private int zzF;
    private zzmj zzG;
    private zzck zzH;
    private zzbv zzI;
    private zzbv zzJ;
    /* access modifiers changed from: private */
    public zzam zzK;
    /* access modifiers changed from: private */
    public zzam zzL;
    /* access modifiers changed from: private */
    public Object zzM;
    private Surface zzN;
    private int zzO;
    private zzfp zzP;
    /* access modifiers changed from: private */
    public zzir zzQ;
    /* access modifiers changed from: private */
    public zzir zzR;
    private int zzS;
    private zzk zzT;
    private float zzU;
    /* access modifiers changed from: private */
    public boolean zzV;
    private zzee zzW;
    private boolean zzX;
    private boolean zzY;
    private zzaa zzZ;
    /* access modifiers changed from: private */
    public zzdp zzaa;
    private zzbv zzab;
    private zzly zzac;
    private int zzad;
    private long zzae;
    private final zzjk zzaf;
    private zzxb zzag;
    final zzzg zzb;
    final zzck zzc;
    private final zzeo zze;
    private final Context zzf;
    private final zzco zzg;
    private final zzmf[] zzh;
    private final zzzf zzi;
    private final zzev zzj;
    private final zzkz zzk;
    /* access modifiers changed from: private */
    public final zzfb zzl;
    private final CopyOnWriteArraySet zzm;
    private final zzcu zzn;
    private final List zzo;
    private final boolean zzp;
    private final zzvg zzq;
    /* access modifiers changed from: private */
    public final zzmp zzr;
    private final Looper zzs;
    private final zzzn zzt;
    private final zzel zzu;
    private final zzkk zzv;
    private final zzkm zzw;
    private final zzil zzx;
    private final zzip zzy;
    private final zzmn zzz;

    static {
        zzbq.zzb("media3.exoplayer");
    }

    /* JADX WARNING: type inference failed for: r5v3, types: [java.lang.Object, com.google.android.gms.internal.ads.zzmp, com.google.android.gms.internal.ads.zzzm] */
    public zzko(zzji zzji, zzco zzco) {
        zzpb zza;
        zzji zzji2 = zzji;
        zzco zzco2 = zzco;
        zzeo zzeo = new zzeo(zzel.zza);
        this.zze = zzeo;
        try {
            String hexString = Integer.toHexString(System.identityHashCode(this));
            String str = zzfx.zze;
            zzfe.zze("ExoPlayerImpl", "Init " + hexString + " [AndroidXMedia3/1.3.0] [" + str + "]");
            Context applicationContext = zzji2.zza.getApplicationContext();
            this.zzf = applicationContext;
            ? apply = zzji2.zzh.apply(zzji2.zzb);
            this.zzr = apply;
            this.zzT = zzji2.zzj;
            this.zzO = zzji2.zzk;
            this.zzV = false;
            this.zzB = zzji2.zzo;
            zzkk zzkk = new zzkk(this, (zzkj) null);
            this.zzv = zzkk;
            zzkm zzkm = new zzkm((zzkl) null);
            this.zzw = zzkm;
            Handler handler = new Handler(zzji2.zzi);
            Handler handler2 = handler;
            zzmf[] zza2 = ((zzjb) zzji2.zzc).zza.zza(handler, zzkk, zzkk, zzkk, zzkk);
            this.zzh = zza2;
            int length = zza2.length;
            zzzf zzzf = (zzzf) zzji2.zze.zza();
            this.zzi = zzzf;
            this.zzq = zzji.zza(((zzjc) zzji2.zzd).zza);
            zzzr zzg2 = zzzr.zzg(((zzjf) zzji2.zzg).zza);
            this.zzt = zzg2;
            this.zzp = zzji2.zzl;
            this.zzG = zzji2.zzm;
            Looper looper = zzji2.zzi;
            this.zzs = looper;
            zzel zzel = zzji2.zzb;
            this.zzu = zzel;
            this.zzg = zzco2;
            zzfb zzfb = new zzfb(looper, zzel, new zzke(this));
            this.zzl = zzfb;
            CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
            this.zzm = copyOnWriteArraySet;
            this.zzo = new ArrayList();
            zzkm zzkm2 = zzkm;
            this.zzag = new zzxb(0);
            int length2 = zza2.length;
            CopyOnWriteArraySet copyOnWriteArraySet2 = copyOnWriteArraySet;
            zzzr zzzr = zzg2;
            zzfb zzfb2 = zzfb;
            zzzg zzzg = new zzzg(new zzmi[2], new zzyz[2], zzdk.zza, (Object) null);
            this.zzb = zzzg;
            this.zzn = new zzcu();
            zzci zzci = new zzci();
            zzci.zzc(1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 35, 22, 24, 27, 28, 32);
            zzzf.zzn();
            zzci.zzd(29, true);
            zzci.zzd(23, false);
            zzci.zzd(25, false);
            zzci.zzd(33, false);
            zzci.zzd(26, false);
            zzci.zzd(34, false);
            zzck zze2 = zzci.zze();
            this.zzc = zze2;
            zzci zzci2 = new zzci();
            zzci2.zzb(zze2);
            zzci2.zza(4);
            zzci2.zza(10);
            this.zzH = zzci2.zze();
            this.zzj = zzel.zzb(looper, (Handler.Callback) null);
            zzjk zzjk = new zzjk(this);
            this.zzaf = zzjk;
            this.zzac = zzly.zzg(zzzg);
            apply.zzR(zzco2, looper);
            if (zzfx.zza < 31) {
                zza = new zzpb(zzji2.zzr);
            } else {
                zza = zzkf.zza(applicationContext, this, zzji2.zzp, zzji2.zzr);
            }
            zzpb zzpb = zza;
            zzmj zzmj = this.zzG;
            zzfb zzfb3 = zzfb2;
            zziu zziu = zzji2.zzs;
            zzmj zzmj2 = zzmj;
            CopyOnWriteArraySet copyOnWriteArraySet3 = copyOnWriteArraySet2;
            Looper looper2 = looper;
            zzzg zzzg2 = zzzg;
            zzzr zzzr2 = zzzr;
            zzzf zzzf2 = zzzf;
            zzkm zzkm3 = zzkm2;
            zzkk zzkk2 = zzkk;
            this.zzk = new zzkz(zza2, zzzf, zzzg2, (zzlc) zzji2.zzf.zza(), zzzr2, 0, false, apply, zzmj2, zziu, zzji2.zzn, false, looper2, zzel, zzjk, zzpb, (Looper) null);
            this.zzU = 1.0f;
            this.zzI = zzbv.zza;
            zzbv zzbv = zzbv.zza;
            this.zzJ = zzbv;
            this.zzab = zzbv;
            int i = -1;
            this.zzad = -1;
            AudioManager audioManager = (AudioManager) applicationContext.getSystemService("audio");
            if (audioManager != null) {
                i = audioManager.generateAudioSessionId();
            }
            this.zzS = i;
            this.zzW = zzee.zza;
            this.zzX = true;
            apply.getClass();
            zzfb3.zzb(apply);
            zzzr2.zze(new Handler(looper2), apply);
            zzkk zzkk3 = zzkk2;
            copyOnWriteArraySet3.add(zzkk3);
            Handler handler3 = handler2;
            this.zzx = new zzil(zzji2.zza, handler3, zzkk3);
            this.zzy = new zzip(zzji2.zza, handler3, zzkk3);
            zzfx.zzG((Object) null, (Object) null);
            this.zzz = new zzmn(zzji2.zza);
            this.zzA = new zzmo(zzji2.zza);
            this.zzZ = new zzy(0).zza();
            this.zzaa = zzdp.zza;
            this.zzP = zzfp.zza;
            zzzf2.zzk(this.zzT);
            zzag(1, 10, Integer.valueOf(this.zzS));
            zzag(2, 10, Integer.valueOf(this.zzS));
            zzag(1, 3, this.zzT);
            zzag(2, 4, Integer.valueOf(this.zzO));
            zzag(2, 5, 0);
            zzag(1, 9, Boolean.valueOf(this.zzV));
            zzkm zzkm4 = zzkm3;
            zzag(2, 7, zzkm4);
            zzag(6, 8, zzkm4);
            zzeo.zze();
        } catch (Throwable th) {
            this.zze.zze();
            throw th;
        }
    }

    static /* bridge */ /* synthetic */ void zzP(zzko zzko, SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        zzko.zzai(surface);
        zzko.zzN = surface;
    }

    private final int zzW(zzly zzly) {
        if (zzly.zza.zzo()) {
            return this.zzad;
        }
        return zzly.zza.zzn(zzly.zzb.zza, this.zzn).zzd;
    }

    /* access modifiers changed from: private */
    public static int zzX(boolean z, int i) {
        return (!z || i == 1) ? 1 : 2;
    }

    private final long zzY(zzly zzly) {
        if (!zzly.zzb.zzb()) {
            return zzfx.zzu(zzZ(zzly));
        }
        zzly.zza.zzn(zzly.zzb.zza, this.zzn);
        if (zzly.zzc == C.TIME_UNSET) {
            long j = zzly.zza.zze(zzW(zzly), this.zza, 0).zzn;
            return zzfx.zzu(0);
        }
        int i = zzfx.zza;
        return zzfx.zzu(0) + zzfx.zzu(zzly.zzc);
    }

    private final long zzZ(zzly zzly) {
        if (zzly.zza.zzo()) {
            return zzfx.zzr(this.zzae);
        }
        boolean z = zzly.zzo;
        long j = zzly.zzr;
        if (zzly.zzb.zzb()) {
            return j;
        }
        zzab(zzly.zza, zzly.zzb, j);
        return j;
    }

    private static long zzaa(zzly zzly) {
        zzcw zzcw = new zzcw();
        zzcu zzcu = new zzcu();
        zzly.zza.zzn(zzly.zzb.zza, zzcu);
        long j = zzly.zzc;
        if (j != C.TIME_UNSET) {
            return j;
        }
        long j2 = zzly.zza.zze(zzcu.zzd, zzcw, 0).zzn;
        return 0;
    }

    private final long zzab(zzcx zzcx, zzvh zzvh, long j) {
        zzcx.zzn(zzvh.zza, this.zzn);
        return j;
    }

    private final Pair zzac(zzcx zzcx, int i, long j) {
        if (zzcx.zzo()) {
            this.zzad = i;
            if (j == C.TIME_UNSET) {
                j = 0;
            }
            this.zzae = j;
            return null;
        }
        if (i == -1 || i >= zzcx.zzc()) {
            i = zzcx.zzg(false);
            long j2 = zzcx.zze(i, this.zza, 0).zzn;
            j = zzfx.zzu(0);
        }
        return zzcx.zzl(this.zza, this.zzn, i, zzfx.zzr(j));
    }

    private final zzly zzad(zzly zzly, zzcx zzcx, Pair pair) {
        zzvh zzvh;
        zzxk zzxk;
        List list;
        int i;
        long j;
        zzcx zzcx2 = zzcx;
        Pair pair2 = pair;
        zzek.zzd(zzcx.zzo() || pair2 != null);
        zzcx zzcx3 = zzly.zza;
        long zzY2 = zzY(zzly);
        zzly zzf2 = zzly.zzf(zzcx);
        if (zzcx.zzo()) {
            zzvh zzh2 = zzly.zzh();
            long zzr2 = zzfx.zzr(this.zzae);
            zzly zza = zzf2.zzb(zzh2, zzr2, zzr2, zzr2, 0, zzxk.zza, this.zzb, zzfzn.zzm()).zza(zzh2);
            zza.zzp = zza.zzr;
            return zza;
        }
        Object obj = zzf2.zzb.zza;
        int i2 = zzfx.zza;
        boolean z = !obj.equals(pair2.first);
        if (z) {
            zzvh = new zzvh(pair2.first, -1);
        } else {
            zzvh = zzf2.zzb;
        }
        zzvh zzvh2 = zzvh;
        long longValue = ((Long) pair2.second).longValue();
        long zzr3 = zzfx.zzr(zzY2);
        if (!zzcx3.zzo()) {
            zzcx3.zzn(obj, this.zzn);
        }
        if (z || longValue < zzr3) {
            long j2 = longValue;
            zzvh zzvh3 = zzvh2;
            zzek.zzf(!zzvh3.zzb());
            if (z) {
                zzxk = zzxk.zza;
            } else {
                zzxk = zzf2.zzh;
            }
            zzxk zzxk2 = zzxk;
            zzzg zzzg = z ? this.zzb : zzf2.zzi;
            if (z) {
                list = zzfzn.zzm();
            } else {
                list = zzf2.zzj;
            }
            zzly zza2 = zzf2.zzb(zzvh3, j2, j2, j2, 0, zzxk2, zzzg, list).zza(zzvh3);
            zza2.zzp = j2;
            return zza2;
        } else if (i == 0) {
            int zza3 = zzcx2.zza(zzf2.zzk.zza);
            if (zza3 != -1 && zzcx2.zzd(zza3, this.zzn, false).zzd == zzcx2.zzn(zzvh2.zza, this.zzn).zzd) {
                return zzf2;
            }
            zzcx2.zzn(zzvh2.zza, this.zzn);
            if (zzvh2.zzb()) {
                j = this.zzn.zzh(zzvh2.zzb, zzvh2.zzc);
            } else {
                j = this.zzn.zze;
            }
            zzly zza4 = zzf2.zzb(zzvh2, zzf2.zzr, zzf2.zzr, zzf2.zzd, j - zzf2.zzr, zzf2.zzh, zzf2.zzi, zzf2.zzj).zza(zzvh2);
            zza4.zzp = j;
            return zza4;
        } else {
            zzvh zzvh4 = zzvh2;
            zzek.zzf(!zzvh4.zzb());
            long max = Math.max(0, zzf2.zzq - (longValue - zzr3));
            long j3 = zzf2.zzp;
            if (zzf2.zzk.equals(zzf2.zzb)) {
                j3 = longValue + max;
            }
            zzly zzb2 = zzf2.zzb(zzvh4, longValue, longValue, longValue, max, zzf2.zzh, zzf2.zzi, zzf2.zzj);
            zzb2.zzp = j3;
            return zzb2;
        }
    }

    private final zzmb zzae(zzma zzma) {
        int zzW2 = zzW(this.zzac);
        zzcx zzcx = this.zzac.zza;
        if (zzW2 == -1) {
            zzW2 = 0;
        }
        zzel zzel = this.zzu;
        zzkz zzkz = this.zzk;
        return new zzmb(zzkz, zzma, zzcx, zzW2, zzel, zzkz.zzb());
    }

    /* access modifiers changed from: private */
    public final void zzaf(int i, int i2) {
        if (i != this.zzP.zzb() || i2 != this.zzP.zza()) {
            this.zzP = new zzfp(i, i2);
            zzfb zzfb = this.zzl;
            zzfb.zzd(24, new zzkb(i, i2));
            zzfb.zzc();
            zzag(2, 14, new zzfp(i, i2));
        }
    }

    private final void zzag(int i, int i2, Object obj) {
        zzmf[] zzmfArr = this.zzh;
        int length = zzmfArr.length;
        for (int i3 = 0; i3 < 2; i3++) {
            zzmf zzmf = zzmfArr[i3];
            if (zzmf.zzb() == i) {
                zzmb zzae2 = zzae(zzmf);
                zzae2.zzf(i2);
                zzae2.zze(obj);
                zzae2.zzd();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zzah() {
        zzag(1, 2, Float.valueOf(this.zzU * this.zzy.zza()));
    }

    /* access modifiers changed from: private */
    public final void zzai(Object obj) {
        ArrayList<zzmb> arrayList = new ArrayList<>();
        zzmf[] zzmfArr = this.zzh;
        int length = zzmfArr.length;
        boolean z = false;
        for (int i = 0; i < 2; i++) {
            zzmf zzmf = zzmfArr[i];
            if (zzmf.zzb() == 2) {
                zzmb zzae2 = zzae(zzmf);
                zzae2.zzf(1);
                zzae2.zze(obj);
                zzae2.zzd();
                arrayList.add(zzae2);
            }
        }
        Object obj2 = this.zzM;
        if (!(obj2 == null || obj2 == obj)) {
            try {
                for (zzmb zzi2 : arrayList) {
                    zzi2.zzi(this.zzB);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
                z = true;
            }
            Object obj3 = this.zzM;
            Surface surface = this.zzN;
            if (obj3 == surface) {
                surface.release();
                this.zzN = null;
            }
        }
        this.zzM = obj;
        if (z) {
            zzaj(zziz.zzd(new zzla(3), 1003));
        }
    }

    private final void zzaj(zziz zziz) {
        zzly zzly = this.zzac;
        zzly zza = zzly.zza(zzly.zzb);
        zza.zzp = zza.zzr;
        zza.zzq = 0;
        zzly zze2 = zza.zze(1);
        if (zziz != null) {
            zze2 = zze2.zzd(zziz);
        }
        this.zzC++;
        this.zzk.zzo();
        zzal(zze2, 0, 1, false, 5, C.TIME_UNSET, -1, false);
    }

    /* access modifiers changed from: private */
    public final void zzak(boolean z, int i, int i2) {
        int i3 = 0;
        boolean z2 = z && i != -1;
        if (z2 && i != 1) {
            i3 = 1;
        }
        zzly zzly = this.zzac;
        if (zzly.zzl != z2 || zzly.zzm != i3) {
            this.zzC++;
            boolean z3 = zzly.zzo;
            zzly zzc2 = zzly.zzc(z2, i3);
            this.zzk.zzn(z2, i3);
            zzal(zzc2, 0, i2, false, 5, C.TIME_UNSET, -1, false);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x02e5  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x02eb  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x02f7  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0300  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x031e  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0332  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0342  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x035f  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x036c  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x037f  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0394  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x03aa  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x03dd  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x03df  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x03ea  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x03ef  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0412  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x042d  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0443  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0460  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0462  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x047a A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0484 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x048f A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x04a0 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x04ac A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x04c3 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x04d1 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x04e7  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01b9  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x026b  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x029e  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x02b6  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x02c3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzal(com.google.android.gms.internal.ads.zzly r44, int r45, int r46, boolean r47, int r48, long r49, int r51, boolean r52) {
        /*
            r43 = this;
            r0 = r43
            r1 = r44
            r2 = r48
            com.google.android.gms.internal.ads.zzly r3 = r0.zzac
            r0.zzac = r1
            com.google.android.gms.internal.ads.zzcx r4 = r3.zza
            com.google.android.gms.internal.ads.zzcx r5 = r1.zza
            boolean r4 = r4.equals(r5)
            r5 = 1
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r5)
            r4 = r4 ^ r5
            com.google.android.gms.internal.ads.zzcx r7 = r3.zza
            com.google.android.gms.internal.ads.zzcx r8 = r1.zza
            boolean r9 = r8.zzo()
            r11 = 3
            r12 = -1
            java.lang.Integer r13 = java.lang.Integer.valueOf(r12)
            r14 = 0
            r10 = 0
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r10)
            if (r9 == 0) goto L_0x003b
            boolean r9 = r7.zzo()
            if (r9 == 0) goto L_0x003b
            android.util.Pair r6 = new android.util.Pair
            r6.<init>(r12, r13)
            goto L_0x004f
        L_0x003b:
            boolean r9 = r8.zzo()
            boolean r10 = r7.zzo()
            if (r9 == r10) goto L_0x0053
            android.util.Pair r7 = new android.util.Pair
            java.lang.Integer r8 = java.lang.Integer.valueOf(r11)
            r7.<init>(r6, r8)
            r6 = r7
        L_0x004f:
            r7 = r47
            goto L_0x00da
        L_0x0053:
            com.google.android.gms.internal.ads.zzvh r9 = r3.zzb
            java.lang.Object r9 = r9.zza
            com.google.android.gms.internal.ads.zzcu r10 = r0.zzn
            com.google.android.gms.internal.ads.zzcu r9 = r7.zzn(r9, r10)
            int r9 = r9.zzd
            com.google.android.gms.internal.ads.zzcw r10 = r0.zza
            com.google.android.gms.internal.ads.zzcw r7 = r7.zze(r9, r10, r14)
            java.lang.Object r7 = r7.zzc
            com.google.android.gms.internal.ads.zzvh r9 = r1.zzb
            java.lang.Object r9 = r9.zza
            com.google.android.gms.internal.ads.zzcu r10 = r0.zzn
            com.google.android.gms.internal.ads.zzcu r9 = r8.zzn(r9, r10)
            int r9 = r9.zzd
            com.google.android.gms.internal.ads.zzcw r10 = r0.zza
            com.google.android.gms.internal.ads.zzcw r8 = r8.zze(r9, r10, r14)
            java.lang.Object r8 = r8.zzc
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x00a9
            if (r47 == 0) goto L_0x008c
            if (r2 != 0) goto L_0x0089
            r7 = r5
            r8 = r7
            r2 = 0
            goto L_0x0098
        L_0x0089:
            r7 = r5
            r8 = r7
            goto L_0x008e
        L_0x008c:
            r7 = 0
            r8 = 0
        L_0x008e:
            if (r7 == 0) goto L_0x0095
            if (r2 != r5) goto L_0x0095
            r7 = r8
            r8 = 2
            goto L_0x0098
        L_0x0095:
            if (r4 == 0) goto L_0x00a3
            r8 = r11
        L_0x0098:
            android.util.Pair r9 = new android.util.Pair
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r9.<init>(r6, r8)
            r6 = r9
            goto L_0x00da
        L_0x00a3:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x00a9:
            if (r47 == 0) goto L_0x00cd
            if (r2 != 0) goto L_0x00ca
            com.google.android.gms.internal.ads.zzvh r2 = r3.zzb
            long r7 = r2.zzd
            com.google.android.gms.internal.ads.zzvh r2 = r1.zzb
            long r9 = r2.zzd
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 >= 0) goto L_0x00c7
            android.util.Pair r2 = new android.util.Pair
            r7 = 0
            java.lang.Integer r8 = java.lang.Integer.valueOf(r7)
            r2.<init>(r6, r8)
            r6 = r2
            r7 = r5
            r2 = 0
            goto L_0x00da
        L_0x00c7:
            r2 = r5
            r6 = 0
            goto L_0x00cf
        L_0x00ca:
            r6 = r2
            r2 = r5
            goto L_0x00cf
        L_0x00cd:
            r6 = r2
            r2 = 0
        L_0x00cf:
            android.util.Pair r7 = new android.util.Pair
            r7.<init>(r12, r13)
            r42 = r7
            r7 = r2
            r2 = r6
            r6 = r42
        L_0x00da:
            java.lang.Object r8 = r6.first
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            java.lang.Object r6 = r6.second
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            if (r8 == 0) goto L_0x0113
            com.google.android.gms.internal.ads.zzcx r10 = r1.zza
            boolean r10 = r10.zzo()
            if (r10 != 0) goto L_0x010d
            com.google.android.gms.internal.ads.zzcx r10 = r1.zza
            com.google.android.gms.internal.ads.zzvh r12 = r1.zzb
            java.lang.Object r12 = r12.zza
            com.google.android.gms.internal.ads.zzcu r13 = r0.zzn
            com.google.android.gms.internal.ads.zzcu r10 = r10.zzn(r12, r13)
            int r10 = r10.zzd
            com.google.android.gms.internal.ads.zzcx r12 = r1.zza
            com.google.android.gms.internal.ads.zzcw r13 = r0.zza
            com.google.android.gms.internal.ads.zzcw r10 = r12.zze(r10, r13, r14)
            com.google.android.gms.internal.ads.zzbp r10 = r10.zze
            goto L_0x010e
        L_0x010d:
            r10 = 0
        L_0x010e:
            com.google.android.gms.internal.ads.zzbv r12 = com.google.android.gms.internal.ads.zzbv.zza
            r0.zzab = r12
            goto L_0x0114
        L_0x0113:
            r10 = 0
        L_0x0114:
            if (r8 != 0) goto L_0x0120
            java.util.List r12 = r3.zzj
            java.util.List r13 = r1.zzj
            boolean r12 = r12.equals(r13)
            if (r12 != 0) goto L_0x0152
        L_0x0120:
            com.google.android.gms.internal.ads.zzbv r12 = r0.zzab
            com.google.android.gms.internal.ads.zzbt r12 = r12.zza()
            java.util.List r13 = r1.zzj
            r9 = 0
        L_0x0129:
            int r11 = r13.size()
            if (r9 >= r11) goto L_0x014c
            java.lang.Object r11 = r13.get(r9)
            com.google.android.gms.internal.ads.zzby r11 = (com.google.android.gms.internal.ads.zzby) r11
            r5 = 0
        L_0x0136:
            int r14 = r11.zza()
            if (r5 >= r14) goto L_0x0146
            com.google.android.gms.internal.ads.zzbx r14 = r11.zzb(r5)
            r14.zza(r12)
            int r5 = r5 + 1
            goto L_0x0136
        L_0x0146:
            int r9 = r9 + 1
            r5 = 1
            r14 = 0
            goto L_0x0129
        L_0x014c:
            com.google.android.gms.internal.ads.zzbv r5 = r12.zzu()
            r0.zzab = r5
        L_0x0152:
            com.google.android.gms.internal.ads.zzcx r5 = r43.zzn()
            boolean r9 = r5.zzo()
            if (r9 == 0) goto L_0x015f
            com.google.android.gms.internal.ads.zzbv r5 = r0.zzab
            goto L_0x017c
        L_0x015f:
            int r9 = r43.zzd()
            com.google.android.gms.internal.ads.zzcw r11 = r0.zza
            r12 = 0
            com.google.android.gms.internal.ads.zzcw r5 = r5.zze(r9, r11, r12)
            com.google.android.gms.internal.ads.zzbp r5 = r5.zze
            com.google.android.gms.internal.ads.zzbv r9 = r0.zzab
            com.google.android.gms.internal.ads.zzbt r9 = r9.zza()
            com.google.android.gms.internal.ads.zzbv r5 = r5.zzg
            r9.zzb(r5)
            com.google.android.gms.internal.ads.zzbv r5 = r9.zzu()
        L_0x017c:
            com.google.android.gms.internal.ads.zzbv r9 = r0.zzI
            boolean r9 = r5.equals(r9)
            r11 = 1
            r9 = r9 ^ r11
            r0.zzI = r5
            boolean r5 = r3.zzl
            boolean r11 = r1.zzl
            if (r5 == r11) goto L_0x018e
            r5 = 1
            goto L_0x018f
        L_0x018e:
            r5 = 0
        L_0x018f:
            int r11 = r3.zze
            int r12 = r1.zze
            if (r11 == r12) goto L_0x0197
            r11 = 1
            goto L_0x0198
        L_0x0197:
            r11 = 0
        L_0x0198:
            if (r11 != 0) goto L_0x019c
            if (r5 == 0) goto L_0x019f
        L_0x019c:
            r43.zzam()
        L_0x019f:
            boolean r12 = r3.zzg
            boolean r13 = r1.zzg
            if (r12 == r13) goto L_0x01a7
            r12 = 1
            goto L_0x01a8
        L_0x01a7:
            r12 = 0
        L_0x01a8:
            if (r4 == 0) goto L_0x01b7
            com.google.android.gms.internal.ads.zzfb r4 = r0.zzl
            com.google.android.gms.internal.ads.zzjm r13 = new com.google.android.gms.internal.ads.zzjm
            r14 = r45
            r13.<init>(r1, r14)
            r14 = 0
            r4.zzd(r14, r13)
        L_0x01b7:
            if (r7 == 0) goto L_0x02e5
            com.google.android.gms.internal.ads.zzcu r7 = new com.google.android.gms.internal.ads.zzcu
            r7.<init>()
            com.google.android.gms.internal.ads.zzcx r13 = r3.zza
            boolean r13 = r13.zzo()
            if (r13 != 0) goto L_0x01f8
            com.google.android.gms.internal.ads.zzvh r13 = r3.zzb
            java.lang.Object r13 = r13.zza
            com.google.android.gms.internal.ads.zzcx r14 = r3.zza
            r14.zzn(r13, r7)
            int r14 = r7.zzd
            com.google.android.gms.internal.ads.zzcx r15 = r3.zza
            int r15 = r15.zza(r13)
            com.google.android.gms.internal.ads.zzcx r4 = r3.zza
            r48 = r13
            com.google.android.gms.internal.ads.zzcw r13 = r0.zza
            r18 = r11
            r19 = r12
            r11 = 0
            com.google.android.gms.internal.ads.zzcw r4 = r4.zze(r14, r13, r11)
            java.lang.Object r4 = r4.zzc
            com.google.android.gms.internal.ads.zzcw r11 = r0.zza
            com.google.android.gms.internal.ads.zzbp r11 = r11.zze
            r24 = r48
            r21 = r4
            r23 = r11
            r22 = r14
            r25 = r15
            goto L_0x0206
        L_0x01f8:
            r18 = r11
            r19 = r12
            r22 = r51
            r21 = 0
            r23 = 0
            r24 = 0
            r25 = -1
        L_0x0206:
            if (r2 != 0) goto L_0x0230
            com.google.android.gms.internal.ads.zzvh r4 = r3.zzb
            boolean r4 = r4.zzb()
            if (r4 == 0) goto L_0x021f
            com.google.android.gms.internal.ads.zzvh r4 = r3.zzb
            int r11 = r4.zzb
            int r4 = r4.zzc
            long r11 = r7.zzh(r11, r4)
            long r13 = zzaa(r3)
            goto L_0x0242
        L_0x021f:
            com.google.android.gms.internal.ads.zzvh r4 = r3.zzb
            int r4 = r4.zze
            r11 = -1
            if (r4 == r11) goto L_0x022d
            com.google.android.gms.internal.ads.zzly r4 = r0.zzac
            long r11 = zzaa(r4)
            goto L_0x0241
        L_0x022d:
            long r11 = r7.zze
            goto L_0x0241
        L_0x0230:
            com.google.android.gms.internal.ads.zzvh r4 = r3.zzb
            boolean r4 = r4.zzb()
            if (r4 == 0) goto L_0x023f
            long r11 = r3.zzr
            long r13 = zzaa(r3)
            goto L_0x0242
        L_0x023f:
            long r11 = r3.zzr
        L_0x0241:
            r13 = r11
        L_0x0242:
            com.google.android.gms.internal.ads.zzcn r4 = new com.google.android.gms.internal.ads.zzcn
            int r7 = com.google.android.gms.internal.ads.zzfx.zza
            com.google.android.gms.internal.ads.zzvh r7 = r3.zzb
            int r15 = r7.zzb
            int r7 = r7.zzc
            long r26 = com.google.android.gms.internal.ads.zzfx.zzu(r11)
            long r28 = com.google.android.gms.internal.ads.zzfx.zzu(r13)
            r20 = r4
            r30 = r15
            r31 = r7
            r20.<init>(r21, r22, r23, r24, r25, r26, r28, r30, r31)
            int r7 = r43.zzd()
            com.google.android.gms.internal.ads.zzly r11 = r0.zzac
            com.google.android.gms.internal.ads.zzcx r11 = r11.zza
            boolean r11 = r11.zzo()
            if (r11 != 0) goto L_0x029e
            com.google.android.gms.internal.ads.zzly r11 = r0.zzac
            com.google.android.gms.internal.ads.zzvh r12 = r11.zzb
            java.lang.Object r12 = r12.zza
            com.google.android.gms.internal.ads.zzcx r11 = r11.zza
            com.google.android.gms.internal.ads.zzcu r13 = r0.zzn
            r11.zzn(r12, r13)
            com.google.android.gms.internal.ads.zzly r11 = r0.zzac
            com.google.android.gms.internal.ads.zzcx r11 = r11.zza
            int r11 = r11.zza(r12)
            com.google.android.gms.internal.ads.zzly r13 = r0.zzac
            com.google.android.gms.internal.ads.zzcx r13 = r13.zza
            com.google.android.gms.internal.ads.zzcw r14 = r0.zza
            r47 = r11
            r15 = r12
            r11 = 0
            com.google.android.gms.internal.ads.zzcw r13 = r13.zze(r7, r14, r11)
            java.lang.Object r11 = r13.zzc
            com.google.android.gms.internal.ads.zzcw r12 = r0.zza
            com.google.android.gms.internal.ads.zzbp r12 = r12.zze
            r35 = r47
            r31 = r11
            r33 = r12
            r34 = r15
            goto L_0x02a6
        L_0x029e:
            r31 = 0
            r33 = 0
            r34 = 0
            r35 = -1
        L_0x02a6:
            long r36 = com.google.android.gms.internal.ads.zzfx.zzu(r49)
            com.google.android.gms.internal.ads.zzcn r11 = new com.google.android.gms.internal.ads.zzcn
            com.google.android.gms.internal.ads.zzly r12 = r0.zzac
            com.google.android.gms.internal.ads.zzvh r12 = r12.zzb
            boolean r12 = r12.zzb()
            if (r12 == 0) goto L_0x02c3
            com.google.android.gms.internal.ads.zzly r12 = r0.zzac
            long r12 = zzaa(r12)
            long r12 = com.google.android.gms.internal.ads.zzfx.zzu(r12)
            r38 = r12
            goto L_0x02c5
        L_0x02c3:
            r38 = r36
        L_0x02c5:
            com.google.android.gms.internal.ads.zzly r12 = r0.zzac
            com.google.android.gms.internal.ads.zzvh r12 = r12.zzb
            int r13 = r12.zzb
            int r12 = r12.zzc
            r30 = r11
            r32 = r7
            r40 = r13
            r41 = r12
            r30.<init>(r31, r32, r33, r34, r35, r36, r38, r40, r41)
            com.google.android.gms.internal.ads.zzfb r7 = r0.zzl
            com.google.android.gms.internal.ads.zzjr r12 = new com.google.android.gms.internal.ads.zzjr
            r12.<init>(r2, r4, r11)
            r2 = 11
            r7.zzd(r2, r12)
            goto L_0x02e9
        L_0x02e5:
            r18 = r11
            r19 = r12
        L_0x02e9:
            if (r8 == 0) goto L_0x02f7
            com.google.android.gms.internal.ads.zzfb r2 = r0.zzl
            com.google.android.gms.internal.ads.zzjt r4 = new com.google.android.gms.internal.ads.zzjt
            r4.<init>(r10, r6)
            r6 = 1
            r2.zzd(r6, r4)
            goto L_0x02f8
        L_0x02f7:
            r6 = 1
        L_0x02f8:
            com.google.android.gms.internal.ads.zziz r2 = r3.zzf
            com.google.android.gms.internal.ads.zziz r4 = r1.zzf
            r7 = 10
            if (r2 == r4) goto L_0x0318
            com.google.android.gms.internal.ads.zzfb r2 = r0.zzl
            com.google.android.gms.internal.ads.zzju r4 = new com.google.android.gms.internal.ads.zzju
            r4.<init>(r1)
            r2.zzd(r7, r4)
            com.google.android.gms.internal.ads.zziz r2 = r1.zzf
            if (r2 == 0) goto L_0x0318
            com.google.android.gms.internal.ads.zzfb r2 = r0.zzl
            com.google.android.gms.internal.ads.zzjv r4 = new com.google.android.gms.internal.ads.zzjv
            r4.<init>(r1)
            r2.zzd(r7, r4)
        L_0x0318:
            com.google.android.gms.internal.ads.zzzg r2 = r3.zzi
            com.google.android.gms.internal.ads.zzzg r4 = r1.zzi
            if (r2 == r4) goto L_0x0330
            com.google.android.gms.internal.ads.zzzf r2 = r0.zzi
            java.lang.Object r4 = r4.zze
            r2.zzq(r4)
            com.google.android.gms.internal.ads.zzfb r2 = r0.zzl
            com.google.android.gms.internal.ads.zzjw r4 = new com.google.android.gms.internal.ads.zzjw
            r4.<init>(r1)
            r8 = 2
            r2.zzd(r8, r4)
        L_0x0330:
            if (r9 == 0) goto L_0x0340
            com.google.android.gms.internal.ads.zzbv r2 = r0.zzI
            com.google.android.gms.internal.ads.zzfb r4 = r0.zzl
            com.google.android.gms.internal.ads.zzjx r8 = new com.google.android.gms.internal.ads.zzjx
            r8.<init>(r2)
            r2 = 14
            r4.zzd(r2, r8)
        L_0x0340:
            if (r19 == 0) goto L_0x034d
            com.google.android.gms.internal.ads.zzfb r2 = r0.zzl
            com.google.android.gms.internal.ads.zzjy r4 = new com.google.android.gms.internal.ads.zzjy
            r4.<init>(r1)
            r8 = 3
            r2.zzd(r8, r4)
        L_0x034d:
            if (r18 != 0) goto L_0x0351
            if (r5 == 0) goto L_0x035c
        L_0x0351:
            com.google.android.gms.internal.ads.zzfb r2 = r0.zzl
            com.google.android.gms.internal.ads.zzjz r4 = new com.google.android.gms.internal.ads.zzjz
            r4.<init>(r1)
            r8 = -1
            r2.zzd(r8, r4)
        L_0x035c:
            r2 = 4
            if (r18 == 0) goto L_0x0369
            com.google.android.gms.internal.ads.zzfb r4 = r0.zzl
            com.google.android.gms.internal.ads.zzka r8 = new com.google.android.gms.internal.ads.zzka
            r8.<init>(r1)
            r4.zzd(r2, r8)
        L_0x0369:
            r4 = 5
            if (r5 == 0) goto L_0x0378
            com.google.android.gms.internal.ads.zzfb r5 = r0.zzl
            com.google.android.gms.internal.ads.zzjn r8 = new com.google.android.gms.internal.ads.zzjn
            r9 = r46
            r8.<init>(r1, r9)
            r5.zzd(r4, r8)
        L_0x0378:
            int r5 = r3.zzm
            int r8 = r1.zzm
            r9 = 6
            if (r5 == r8) goto L_0x0389
            com.google.android.gms.internal.ads.zzfb r5 = r0.zzl
            com.google.android.gms.internal.ads.zzjo r8 = new com.google.android.gms.internal.ads.zzjo
            r8.<init>(r1)
            r5.zzd(r9, r8)
        L_0x0389:
            boolean r5 = r3.zzi()
            boolean r8 = r44.zzi()
            r10 = 7
            if (r5 == r8) goto L_0x039e
            com.google.android.gms.internal.ads.zzfb r5 = r0.zzl
            com.google.android.gms.internal.ads.zzjp r8 = new com.google.android.gms.internal.ads.zzjp
            r8.<init>(r1)
            r5.zzd(r10, r8)
        L_0x039e:
            com.google.android.gms.internal.ads.zzcg r5 = r3.zzn
            com.google.android.gms.internal.ads.zzcg r8 = r1.zzn
            boolean r5 = r5.equals(r8)
            r8 = 12
            if (r5 != 0) goto L_0x03b4
            com.google.android.gms.internal.ads.zzfb r5 = r0.zzl
            com.google.android.gms.internal.ads.zzjq r11 = new com.google.android.gms.internal.ads.zzjq
            r11.<init>(r1)
            r5.zzd(r8, r11)
        L_0x03b4:
            com.google.android.gms.internal.ads.zzck r5 = r0.zzH
            com.google.android.gms.internal.ads.zzco r11 = r0.zzg
            com.google.android.gms.internal.ads.zzck r12 = r0.zzc
            int r13 = com.google.android.gms.internal.ads.zzfx.zza
            boolean r13 = r11.zzx()
            r14 = r11
            com.google.android.gms.internal.ads.zzm r14 = (com.google.android.gms.internal.ads.zzm) r14
            com.google.android.gms.internal.ads.zzcx r15 = r14.zzn()
            boolean r17 = r15.zzo()
            if (r17 != 0) goto L_0x03df
            int r6 = r14.zzd()
            com.google.android.gms.internal.ads.zzcw r8 = r14.zza
            r9 = 0
            com.google.android.gms.internal.ads.zzcw r6 = r15.zze(r6, r8, r9)
            boolean r6 = r6.zzi
            if (r6 == 0) goto L_0x03df
            r6 = 1
            goto L_0x03e0
        L_0x03df:
            r6 = 0
        L_0x03e0:
            com.google.android.gms.internal.ads.zzcx r8 = r14.zzn()
            boolean r9 = r8.zzo()
            if (r9 == 0) goto L_0x03ef
            r9 = -1
            r10 = 0
            r16 = 0
            goto L_0x0406
        L_0x03ef:
            int r9 = r14.zzd()
            r14.zzh()
            r14.zzw()
            r10 = 0
            int r8 = r8.zzk(r9, r10, r10)
            r9 = -1
            if (r8 == r9) goto L_0x0404
            r16 = 1
            goto L_0x0406
        L_0x0404:
            r16 = r10
        L_0x0406:
            com.google.android.gms.internal.ads.zzcx r8 = r14.zzn()
            boolean r15 = r8.zzo()
            if (r15 == 0) goto L_0x0412
        L_0x0410:
            r8 = r10
            goto L_0x0423
        L_0x0412:
            int r15 = r14.zzd()
            r14.zzh()
            r14.zzw()
            int r8 = r8.zzj(r15, r10, r10)
            if (r8 == r9) goto L_0x0410
            r8 = 1
        L_0x0423:
            com.google.android.gms.internal.ads.zzcx r9 = r14.zzn()
            boolean r15 = r9.zzo()
            if (r15 != 0) goto L_0x0443
            int r15 = r14.zzd()
            com.google.android.gms.internal.ads.zzcw r10 = r14.zza
            r50 = r8
            r7 = 0
            com.google.android.gms.internal.ads.zzcw r9 = r9.zze(r15, r10, r7)
            boolean r9 = r9.zzb()
            if (r9 == 0) goto L_0x0447
            r9 = 1
            goto L_0x0448
        L_0x0443:
            r50 = r8
            r7 = 0
        L_0x0447:
            r9 = 0
        L_0x0448:
            com.google.android.gms.internal.ads.zzcx r10 = r14.zzn()
            boolean r15 = r10.zzo()
            if (r15 != 0) goto L_0x0462
            int r15 = r14.zzd()
            com.google.android.gms.internal.ads.zzcw r14 = r14.zza
            com.google.android.gms.internal.ads.zzcw r7 = r10.zze(r15, r14, r7)
            boolean r7 = r7.zzj
            if (r7 == 0) goto L_0x0462
            r7 = 1
            goto L_0x0463
        L_0x0462:
            r7 = 0
        L_0x0463:
            com.google.android.gms.internal.ads.zzcx r8 = r11.zzn()
            boolean r8 = r8.zzo()
            com.google.android.gms.internal.ads.zzci r10 = new com.google.android.gms.internal.ads.zzci
            r10.<init>()
            r10.zzb(r12)
            r11 = r13 ^ 1
            r10.zzd(r2, r11)
            if (r6 == 0) goto L_0x047e
            if (r13 != 0) goto L_0x047e
            r2 = 1
            goto L_0x047f
        L_0x047e:
            r2 = 0
        L_0x047f:
            r10.zzd(r4, r2)
            if (r16 == 0) goto L_0x0488
            if (r13 != 0) goto L_0x0488
            r2 = 1
            goto L_0x0489
        L_0x0488:
            r2 = 0
        L_0x0489:
            r4 = 6
            r10.zzd(r4, r2)
            if (r8 != 0) goto L_0x0499
            if (r16 != 0) goto L_0x0495
            if (r9 == 0) goto L_0x0495
            if (r6 == 0) goto L_0x0499
        L_0x0495:
            if (r13 != 0) goto L_0x0499
            r2 = 1
            goto L_0x049a
        L_0x0499:
            r2 = 0
        L_0x049a:
            r4 = 7
            r10.zzd(r4, r2)
            if (r50 == 0) goto L_0x04a4
            if (r13 != 0) goto L_0x04a4
            r2 = 1
            goto L_0x04a5
        L_0x04a4:
            r2 = 0
        L_0x04a5:
            r4 = 8
            r10.zzd(r4, r2)
            if (r8 != 0) goto L_0x04b6
            if (r50 != 0) goto L_0x04b2
            if (r9 == 0) goto L_0x04b6
            if (r7 == 0) goto L_0x04b6
        L_0x04b2:
            if (r13 != 0) goto L_0x04b6
            r7 = 1
            goto L_0x04b7
        L_0x04b6:
            r7 = 0
        L_0x04b7:
            r2 = 9
            r10.zzd(r2, r7)
            r2 = 10
            r10.zzd(r2, r11)
            if (r6 == 0) goto L_0x04c9
            if (r13 != 0) goto L_0x04c9
            r2 = 11
            r7 = 1
            goto L_0x04cc
        L_0x04c9:
            r2 = 11
            r7 = 0
        L_0x04cc:
            r10.zzd(r2, r7)
            if (r6 == 0) goto L_0x04d5
            if (r13 != 0) goto L_0x04d5
            r2 = 1
            goto L_0x04d6
        L_0x04d5:
            r2 = 0
        L_0x04d6:
            r4 = 12
            r10.zzd(r4, r2)
            com.google.android.gms.internal.ads.zzck r2 = r10.zze()
            r0.zzH = r2
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x04f3
            com.google.android.gms.internal.ads.zzfb r2 = r0.zzl
            com.google.android.gms.internal.ads.zzjl r4 = new com.google.android.gms.internal.ads.zzjl
            r4.<init>(r0)
            r5 = 13
            r2.zzd(r5, r4)
        L_0x04f3:
            com.google.android.gms.internal.ads.zzfb r2 = r0.zzl
            r2.zzc()
            boolean r2 = r3.zzo
            boolean r1 = r1.zzo
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzko.zzal(com.google.android.gms.internal.ads.zzly, int, int, boolean, int, long, int, boolean):void");
    }

    private final void zzam() {
        int zzf2 = zzf();
        if (zzf2 == 2 || zzf2 == 3) {
            zzan();
            boolean z = this.zzac.zzo;
            zzv();
            zzv();
        }
    }

    private final void zzan() {
        IllegalStateException illegalStateException;
        this.zze.zzb();
        if (Thread.currentThread() != this.zzs.getThread()) {
            String format = String.format(Locale.US, "Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://developer.android.com/guide/topics/media/issues/player-accessed-on-wrong-thread", new Object[]{Thread.currentThread().getName(), this.zzs.getThread().getName()});
            if (!this.zzX) {
                if (this.zzY) {
                    illegalStateException = null;
                } else {
                    illegalStateException = new IllegalStateException();
                }
                zzfe.zzg("ExoPlayerImpl", format, illegalStateException);
                this.zzY = true;
                return;
            }
            throw new IllegalStateException(format);
        }
    }

    public final void zzA(zzms zzms) {
        zzan();
        this.zzr.zzQ(zzms);
    }

    public final void zzB(zzvj zzvj) {
        zzan();
        List singletonList = Collections.singletonList(zzvj);
        zzan();
        zzan();
        zzW(this.zzac);
        zzk();
        this.zzC++;
        if (!this.zzo.isEmpty()) {
            int size = this.zzo.size();
            for (int i = size - 1; i >= 0; i--) {
                this.zzo.remove(i);
            }
            this.zzag = this.zzag.zzh(0, size);
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < singletonList.size(); i2++) {
            zzlv zzlv = new zzlv((zzvj) singletonList.get(i2), this.zzp);
            arrayList.add(zzlv);
            this.zzo.add(i2, new zzkn(zzlv.zzb, zzlv.zza));
        }
        this.zzag = this.zzag.zzg(0, arrayList.size());
        zzmd zzmd = new zzmd(this.zzo, this.zzag);
        if (zzmd.zzo() || zzmd.zzc() >= 0) {
            int zzg2 = zzmd.zzg(false);
            zzly zzad2 = zzad(this.zzac, zzmd, zzac(zzmd, zzg2, C.TIME_UNSET));
            int i3 = zzad2.zze;
            if (!(zzg2 == -1 || i3 == 1)) {
                i3 = 4;
                if (!zzmd.zzo() && zzg2 < zzmd.zzc()) {
                    i3 = 2;
                }
            }
            zzly zze2 = zzad2.zze(i3);
            this.zzk.zzq(arrayList, zzg2, zzfx.zzr(C.TIME_UNSET), this.zzag);
            zzal(zze2, 0, 1, !this.zzac.zzb.zza.equals(zze2.zzb.zza) && !this.zzac.zza.zzo(), 4, zzZ(zze2), -1, false);
            return;
        }
        throw new zzan(zzmd, -1, C.TIME_UNSET);
    }

    public final zziz zzE() {
        zzan();
        return this.zzac.zzf;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzS(zzkx zzkx) {
        long j;
        boolean z;
        int i = this.zzC - zzkx.zzb;
        this.zzC = i;
        boolean z2 = true;
        if (zzkx.zzc) {
            this.zzD = zzkx.zzd;
            this.zzE = true;
        }
        if (zzkx.zze) {
            this.zzF = zzkx.zzf;
        }
        if (i == 0) {
            zzcx zzcx = zzkx.zza.zza;
            if (!this.zzac.zza.zzo() && zzcx.zzo()) {
                this.zzad = -1;
                this.zzae = 0;
            }
            if (!zzcx.zzo()) {
                List zzw2 = ((zzmd) zzcx).zzw();
                zzek.zzf(zzw2.size() == this.zzo.size());
                for (int i2 = 0; i2 < zzw2.size(); i2++) {
                    ((zzkn) this.zzo.get(i2)).zzc((zzcx) zzw2.get(i2));
                }
            }
            if (this.zzE) {
                if (zzkx.zza.zzb.equals(this.zzac.zzb) && zzkx.zza.zzd == this.zzac.zzr) {
                    z2 = false;
                }
                if (!z2) {
                    j = -9223372036854775807L;
                } else if (zzcx.zzo() || zzkx.zza.zzb.zzb()) {
                    j = zzkx.zza.zzd;
                } else {
                    zzly zzly = zzkx.zza;
                    zzvh zzvh = zzly.zzb;
                    j = zzly.zzd;
                    zzab(zzcx, zzvh, j);
                }
                z = z2;
            } else {
                j = -9223372036854775807L;
                z = false;
            }
            this.zzE = false;
            zzal(zzkx.zza, 1, this.zzF, z, this.zzD, j, -1, false);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzT(zzkx zzkx) {
        this.zzj.zzh(new zzkd(this, zzkx));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzU(zzcl zzcl) {
        zzcl.zza(this.zzH);
    }

    public final void zza(int i, long j, int i2, boolean z) {
        zzan();
        zzek.zzd(i >= 0);
        this.zzr.zzu();
        zzcx zzcx = this.zzac.zza;
        if (zzcx.zzo() || i < zzcx.zzc()) {
            this.zzC++;
            if (zzx()) {
                zzfe.zzf("ExoPlayerImpl", "seekTo ignored because an ad is playing");
                zzkx zzkx = new zzkx(this.zzac);
                zzkx.zza(1);
                this.zzaf.zza.zzT(zzkx);
                return;
            }
            zzly zzly = this.zzac;
            int i3 = zzly.zze;
            if (i3 == 3 || (i3 == 4 && !zzcx.zzo())) {
                zzly = this.zzac.zze(2);
            }
            int zzd2 = zzd();
            zzly zzad2 = zzad(zzly, zzcx, zzac(zzcx, i, j));
            this.zzk.zzl(zzcx, i, zzfx.zzr(j));
            zzal(zzad2, 0, 1, true, 1, zzZ(zzad2), zzd2, false);
        }
    }

    public final int zzb() {
        zzan();
        if (zzx()) {
            return this.zzac.zzb.zzb;
        }
        return -1;
    }

    public final int zzc() {
        zzan();
        if (zzx()) {
            return this.zzac.zzb.zzc;
        }
        return -1;
    }

    public final int zzd() {
        zzan();
        int zzW2 = zzW(this.zzac);
        if (zzW2 == -1) {
            return 0;
        }
        return zzW2;
    }

    public final int zze() {
        zzan();
        if (this.zzac.zza.zzo()) {
            return 0;
        }
        zzly zzly = this.zzac;
        return zzly.zza.zza(zzly.zzb.zza);
    }

    public final int zzf() {
        zzan();
        return this.zzac.zze;
    }

    public final int zzg() {
        zzan();
        return this.zzac.zzm;
    }

    public final int zzh() {
        zzan();
        return 0;
    }

    public final long zzi() {
        zzan();
        if (zzx()) {
            zzly zzly = this.zzac;
            if (zzly.zzk.equals(zzly.zzb)) {
                return zzfx.zzu(this.zzac.zzp);
            }
            return zzl();
        }
        zzan();
        if (this.zzac.zza.zzo()) {
            return this.zzae;
        }
        zzly zzly2 = this.zzac;
        long j = 0;
        if (zzly2.zzk.zzd != zzly2.zzb.zzd) {
            return zzfx.zzu(zzly2.zza.zze(zzd(), this.zza, 0).zzo);
        }
        long j2 = zzly2.zzp;
        if (this.zzac.zzk.zzb()) {
            zzly zzly3 = this.zzac;
            zzly3.zza.zzn(zzly3.zzk.zza, this.zzn).zzi(this.zzac.zzk.zzb);
        } else {
            j = j2;
        }
        zzly zzly4 = this.zzac;
        zzab(zzly4.zza, zzly4.zzk, j);
        return zzfx.zzu(j);
    }

    public final long zzj() {
        zzan();
        return zzY(this.zzac);
    }

    public final long zzk() {
        zzan();
        return zzfx.zzu(zzZ(this.zzac));
    }

    public final long zzl() {
        zzan();
        if (!zzx()) {
            zzcx zzn2 = zzn();
            if (zzn2.zzo()) {
                return C.TIME_UNSET;
            }
            return zzfx.zzu(zzn2.zze(zzd(), this.zza, 0).zzo);
        }
        zzly zzly = this.zzac;
        zzvh zzvh = zzly.zzb;
        zzly.zza.zzn(zzvh.zza, this.zzn);
        return zzfx.zzu(this.zzn.zzh(zzvh.zzb, zzvh.zzc));
    }

    public final long zzm() {
        zzan();
        return zzfx.zzu(this.zzac.zzq);
    }

    public final zzcx zzn() {
        zzan();
        return this.zzac.zza;
    }

    public final zzdk zzo() {
        zzan();
        return this.zzac.zzi.zzd;
    }

    public final void zzp() {
        zzan();
        zzip zzip = this.zzy;
        boolean zzv2 = zzv();
        int i = 2;
        int zzb2 = zzip.zzb(zzv2, 2);
        zzak(zzv2, zzb2, zzX(zzv2, zzb2));
        zzly zzly = this.zzac;
        if (zzly.zze == 1) {
            zzly zzd2 = zzly.zzd((zziz) null);
            if (true == zzd2.zza.zzo()) {
                i = 4;
            }
            zzly zze2 = zzd2.zze(i);
            this.zzC++;
            this.zzk.zzk();
            zzal(zze2, 1, 1, false, 5, C.TIME_UNSET, -1, false);
        }
    }

    public final void zzq() {
        String hexString = Integer.toHexString(System.identityHashCode(this));
        String str = zzfx.zze;
        String zza = zzbq.zza();
        zzfe.zze("ExoPlayerImpl", "Release " + hexString + " [AndroidXMedia3/1.3.0] [" + str + "] [" + zza + "]");
        zzan();
        this.zzy.zzd();
        if (!this.zzk.zzp()) {
            zzfb zzfb = this.zzl;
            zzfb.zzd(10, zzkc.zza);
            zzfb.zzc();
        }
        this.zzl.zze();
        this.zzj.zze((Object) null);
        this.zzt.zzf(this.zzr);
        boolean z = this.zzac.zzo;
        zzly zze2 = this.zzac.zze(1);
        this.zzac = zze2;
        zzly zza2 = zze2.zza(zze2.zzb);
        this.zzac = zza2;
        zza2.zzp = zza2.zzr;
        this.zzac.zzq = 0;
        this.zzr.zzP();
        this.zzi.zzj();
        Surface surface = this.zzN;
        if (surface != null) {
            surface.release();
            this.zzN = null;
        }
        this.zzW = zzee.zza;
    }

    public final void zzr(boolean z) {
        zzan();
        int zzb2 = this.zzy.zzb(z, zzf());
        zzak(z, zzb2, zzX(z, zzb2));
    }

    public final void zzs(Surface surface) {
        zzan();
        zzai(surface);
        int i = surface == null ? 0 : -1;
        zzaf(i, i);
    }

    public final void zzt(float f) {
        zzan();
        float max = Math.max(0.0f, Math.min(f, 1.0f));
        if (this.zzU != max) {
            this.zzU = max;
            zzah();
            zzfb zzfb = this.zzl;
            zzfb.zzd(22, new zzjs(max));
            zzfb.zzc();
        }
    }

    public final void zzu() {
        zzan();
        this.zzy.zzb(zzv(), 1);
        zzaj((zziz) null);
        this.zzW = new zzee(zzfzn.zzm(), this.zzac.zzr);
    }

    public final boolean zzv() {
        zzan();
        return this.zzac.zzl;
    }

    public final boolean zzw() {
        zzan();
        return false;
    }

    public final boolean zzx() {
        zzan();
        return this.zzac.zzb.zzb();
    }

    public final int zzy() {
        zzan();
        int length = this.zzh.length;
        return 2;
    }

    public final void zzz(zzms zzms) {
        this.zzr.zzt(zzms);
    }
}
