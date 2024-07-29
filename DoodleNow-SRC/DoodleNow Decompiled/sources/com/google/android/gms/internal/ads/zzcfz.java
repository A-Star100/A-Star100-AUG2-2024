package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.view.Surface;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzt;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcfz extends zzcde implements zzhy, zzms {
    public static final /* synthetic */ int zza = 0;
    private final Context zzb;
    private final zzcfk zzc;
    private final zzyx zzd;
    private final zzcdm zze;
    private final WeakReference zzf;
    private final zzwn zzg;
    private zzjj zzh;
    private ByteBuffer zzi;
    private boolean zzj;
    private zzcdd zzk;
    private int zzl;
    private int zzm;
    private long zzn;
    private final String zzo;
    private final int zzp;
    private final Object zzq = new Object();
    private Integer zzr;
    private final ArrayList zzs;
    private volatile zzcfm zzt;
    private final Set zzu = new HashSet();

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00e3, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbdz.zzbQ)).booleanValue() == false) goto L_0x00e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00e7, code lost:
        if (r5.zzj == false) goto L_0x00e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00e9, code lost:
        r7 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00ec, code lost:
        if (r5.zzm == false) goto L_0x00f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00ee, code lost:
        r6 = new com.google.android.gms.internal.ads.zzcfq(r3, r4, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00f6, code lost:
        if (r5.zzi <= 0) goto L_0x00fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00f8, code lost:
        r6 = new com.google.android.gms.internal.ads.zzcfr(r3, r4, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00fe, code lost:
        r6 = new com.google.android.gms.internal.ads.zzcfs(r3, r4, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0105, code lost:
        if (r5.zzj == false) goto L_0x010e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0107, code lost:
        r5 = new com.google.android.gms.internal.ads.zzcft(r3, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x010e, code lost:
        r5 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x010f, code lost:
        r4 = r3.zzi;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0111, code lost:
        if (r4 == null) goto L_0x012c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0117, code lost:
        if (r4.limit() <= 0) goto L_0x012c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0119, code lost:
        r4 = new byte[r3.zzi.limit()];
        r3.zzi.get(r4);
        r5 = new com.google.android.gms.internal.ads.zzcfu(r5, r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzcfz(android.content.Context r4, com.google.android.gms.internal.ads.zzcdm r5, com.google.android.gms.internal.ads.zzcdn r6, java.lang.Integer r7) {
        /*
            r3 = this;
            r3.<init>()
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            r3.zzq = r0
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r3.zzu = r0
            r3.zzb = r4
            r3.zze = r5
            r3.zzr = r7
            java.lang.ref.WeakReference r7 = new java.lang.ref.WeakReference
            r7.<init>(r6)
            r3.zzf = r7
            com.google.android.gms.internal.ads.zzcfk r7 = new com.google.android.gms.internal.ads.zzcfk
            r7.<init>()
            r3.zzc = r7
            com.google.android.gms.internal.ads.zzyx r0 = new com.google.android.gms.internal.ads.zzyx
            r0.<init>(r4)
            r3.zzd = r0
            boolean r1 = com.google.android.gms.ads.internal.util.zze.zzc()
            if (r1 == 0) goto L_0x003f
            java.lang.String r1 = r3.toString()
            java.lang.String r2 = "SimpleExoPlayerAdapter initialize "
            java.lang.String r1 = r2.concat(r1)
            com.google.android.gms.ads.internal.util.zze.zza(r1)
        L_0x003f:
            java.util.concurrent.atomic.AtomicInteger r1 = zzD()
            r1.incrementAndGet()
            com.google.android.gms.internal.ads.zzmk r1 = new com.google.android.gms.internal.ads.zzmk
            com.google.android.gms.internal.ads.zzcfw r2 = new com.google.android.gms.internal.ads.zzcfw
            r2.<init>(r3)
            r1.<init>(r4, r2)
            r1.zzb(r0)
            r1.zza(r7)
            com.google.android.gms.internal.ads.zzml r7 = r1.zzc()
            r3.zzh = r7
            r7.zzz(r3)
            r7 = 0
            r3.zzl = r7
            r0 = 0
            r3.zzn = r0
            r3.zzm = r7
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r3.zzs = r0
            r0 = 0
            r3.zzt = r0
            if (r6 == 0) goto L_0x0078
            java.lang.String r0 = r6.zzr()
        L_0x0078:
            com.google.android.gms.internal.ads.zzfwm r0 = com.google.android.gms.internal.ads.zzfwm.zzd(r0)
            java.lang.String r1 = ""
            java.lang.Object r0 = r0.zzb(r1)
            java.lang.String r0 = (java.lang.String) r0
            r3.zzo = r0
            if (r6 == 0) goto L_0x008d
            int r0 = r6.zzf()
            goto L_0x008e
        L_0x008d:
            r0 = r7
        L_0x008e:
            r3.zzp = r0
            com.google.android.gms.internal.ads.zzwn r0 = new com.google.android.gms.internal.ads.zzwn
            com.google.android.gms.ads.internal.util.zzt r1 = com.google.android.gms.ads.internal.zzu.zzp()
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r6 = r6.zzn()
            java.lang.String r6 = r6.afmaVersion
            java.lang.String r4 = r1.zzc(r4, r6)
            boolean r6 = r3.zzj
            if (r6 == 0) goto L_0x00c0
            java.nio.ByteBuffer r6 = r3.zzi
            int r6 = r6.limit()
            if (r6 <= 0) goto L_0x00c0
            java.nio.ByteBuffer r4 = r3.zzi
            int r4 = r4.limit()
            byte[] r4 = new byte[r4]
            java.nio.ByteBuffer r5 = r3.zzi
            r5.get(r4)
            com.google.android.gms.internal.ads.zzcfo r5 = new com.google.android.gms.internal.ads.zzcfo
            r5.<init>(r4)
            goto L_0x012c
        L_0x00c0:
            com.google.android.gms.internal.ads.zzbdq r6 = com.google.android.gms.internal.ads.zzbdz.zzbY
            com.google.android.gms.internal.ads.zzbdx r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r6 = r1.zza(r6)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            r1 = 1
            if (r6 == 0) goto L_0x00e5
            com.google.android.gms.internal.ads.zzbdq r6 = com.google.android.gms.internal.ads.zzbdz.zzbQ
            com.google.android.gms.internal.ads.zzbdx r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r6 = r2.zza(r6)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 != 0) goto L_0x00e9
        L_0x00e5:
            boolean r6 = r5.zzj
            if (r6 != 0) goto L_0x00ea
        L_0x00e9:
            r7 = r1
        L_0x00ea:
            boolean r6 = r5.zzm
            if (r6 == 0) goto L_0x00f4
            com.google.android.gms.internal.ads.zzcfq r6 = new com.google.android.gms.internal.ads.zzcfq
            r6.<init>(r3, r4, r7)
            goto L_0x0103
        L_0x00f4:
            int r6 = r5.zzi
            if (r6 <= 0) goto L_0x00fe
            com.google.android.gms.internal.ads.zzcfr r6 = new com.google.android.gms.internal.ads.zzcfr
            r6.<init>(r3, r4, r7)
            goto L_0x0103
        L_0x00fe:
            com.google.android.gms.internal.ads.zzcfs r6 = new com.google.android.gms.internal.ads.zzcfs
            r6.<init>(r3, r4, r7)
        L_0x0103:
            boolean r4 = r5.zzj
            if (r4 == 0) goto L_0x010e
            com.google.android.gms.internal.ads.zzcft r4 = new com.google.android.gms.internal.ads.zzcft
            r4.<init>(r3, r6)
            r5 = r4
            goto L_0x010f
        L_0x010e:
            r5 = r6
        L_0x010f:
            java.nio.ByteBuffer r4 = r3.zzi
            if (r4 == 0) goto L_0x012c
            int r4 = r4.limit()
            if (r4 <= 0) goto L_0x012c
            java.nio.ByteBuffer r4 = r3.zzi
            int r4 = r4.limit()
            byte[] r4 = new byte[r4]
            java.nio.ByteBuffer r6 = r3.zzi
            r6.get(r4)
            com.google.android.gms.internal.ads.zzcfu r6 = new com.google.android.gms.internal.ads.zzcfu
            r6.<init>(r5, r4)
            r5 = r6
        L_0x012c:
            com.google.android.gms.internal.ads.zzbdq r4 = com.google.android.gms.internal.ads.zzbdz.zzo
            com.google.android.gms.internal.ads.zzbdx r6 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r4 = r6.zza(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x0141
            com.google.android.gms.internal.ads.zzcfy r4 = com.google.android.gms.internal.ads.zzcfy.zza
            goto L_0x0143
        L_0x0141:
            com.google.android.gms.internal.ads.zzcfp r4 = com.google.android.gms.internal.ads.zzcfp.zza
        L_0x0143:
            com.google.android.gms.internal.ads.zzwm r6 = new com.google.android.gms.internal.ads.zzwm
            r6.<init>(r4)
            r0.<init>(r5, r6)
            r3.zzg = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcfz.<init>(android.content.Context, com.google.android.gms.internal.ads.zzcdm, com.google.android.gms.internal.ads.zzcdn, java.lang.Integer):void");
    }

    private final boolean zzad() {
        return this.zzt != null && this.zzt.zzq();
    }

    public final void finalize() {
        zzD().decrementAndGet();
        if (zze.zzc()) {
            zze.zza("SimpleExoPlayerAdapter finalize ".concat(toString()));
        }
    }

    public final long zzA() {
        if (!zzad()) {
            return (long) this.zzl;
        }
        return 0;
    }

    public final long zzB() {
        if (zzad()) {
            return this.zzt.zzl();
        }
        synchronized (this.zzq) {
            while (!this.zzs.isEmpty()) {
                long j = this.zzn;
                Map zze2 = ((zzht) this.zzs.remove(0)).zze();
                long j2 = 0;
                if (zze2 != null) {
                    Iterator it = zze2.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry entry = (Map.Entry) it.next();
                        if (entry != null) {
                            try {
                                if (!(entry.getKey() == null || !zzfvx.zzc("content-length", (CharSequence) entry.getKey()) || entry.getValue() == null || ((List) entry.getValue()).get(0) == null)) {
                                    j2 = Long.parseLong((String) ((List) entry.getValue()).get(0));
                                    break;
                                }
                            } catch (NumberFormatException unused) {
                                continue;
                            }
                        }
                    }
                }
                this.zzn = j + j2;
            }
        }
        return this.zzn;
    }

    public final Integer zzC() {
        return this.zzr;
    }

    public final void zzF(Uri[] uriArr, String str) {
        zzG(uriArr, str, ByteBuffer.allocate(0), false);
    }

    public final void zzH() {
        zzjj zzjj = this.zzh;
        if (zzjj != null) {
            zzjj.zzA(this);
            this.zzh.zzq();
            this.zzh = null;
            zzE().decrementAndGet();
        }
    }

    public final void zzI(long j) {
        zzm zzm2 = (zzm) this.zzh;
        zzm2.zza(zzm2.zzd(), j, 5, false);
    }

    public final void zzJ(int i) {
        this.zzc.zzk(i);
    }

    public final void zzK(int i) {
        this.zzc.zzl(i);
    }

    public final void zzL(zzcdd zzcdd) {
        this.zzk = zzcdd;
    }

    public final void zzM(int i) {
        this.zzc.zzm(i);
    }

    public final void zzN(int i) {
        this.zzc.zzn(i);
    }

    public final void zzO(boolean z) {
        this.zzh.zzr(z);
    }

    public final void zzP(Integer num) {
        this.zzr = num;
    }

    public final void zzQ(boolean z) {
        if (this.zzh != null) {
            int i = 0;
            while (true) {
                this.zzh.zzy();
                if (i < 2) {
                    zzyx zzyx = this.zzd;
                    zzyj zzc2 = zzyx.zzf().zzc();
                    zzc2.zzp(i, !z);
                    zzyx.zzl(zzc2);
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public final void zzR(int i) {
        for (WeakReference weakReference : this.zzu) {
            zzcfj zzcfj = (zzcfj) weakReference.get();
            if (zzcfj != null) {
                zzcfj.zzm(i);
            }
        }
    }

    public final void zzS(Surface surface, boolean z) {
        zzjj zzjj = this.zzh;
        if (zzjj != null) {
            zzjj.zzs(surface);
        }
    }

    public final void zzT(float f, boolean z) {
        zzjj zzjj = this.zzh;
        if (zzjj != null) {
            zzjj.zzt(f);
        }
    }

    public final void zzU() {
        this.zzh.zzu();
    }

    public final boolean zzV() {
        return this.zzh != null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzgv zzW(String str, boolean z) {
        zzcfz zzcfz = true != z ? null : this;
        zzcdm zzcdm = this.zze;
        return new zzcgc(str, zzcfz, zzcdm.zzd, zzcdm.zzf, zzcdm.zzn, zzcdm.zzo);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzgv zzX(String str, boolean z) {
        zzcfz zzcfz = true != z ? null : this;
        zzcdm zzcdm = this.zze;
        zzcfj zzcfj = new zzcfj(str, zzcfz, zzcdm.zzd, zzcdm.zzf, zzcdm.zzi);
        this.zzu.add(new WeakReference(zzcfj));
        return zzcfj;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzgv zzY(String str, boolean z) {
        zzhe zzhe = new zzhe();
        zzhe.zzf(str);
        zzhe.zze(true != z ? null : this);
        zzhe.zzc(this.zze.zzd);
        zzhe.zzd(this.zze.zzf);
        zzhe.zzb(true);
        return zzhe.zza();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzgv zzZ(zzgu zzgu) {
        zzgv zza2 = zzgu.zza();
        zzcfx zzcfx = new zzcfx(this);
        return new zzcfm(this.zzb, zza2, this.zzo, this.zzp, this, zzcfx);
    }

    public final void zza(zzgv zzgv, zzhb zzhb, boolean z, int i) {
        this.zzl += i;
    }

    /* access modifiers changed from: package-private */
    public final zzvj zzaa(Uri uri) {
        zzar zzar = new zzar();
        zzar.zzb(uri);
        zzbp zzc2 = zzar.zzc();
        zzwn zzwn = this.zzg;
        zzwn.zza(this.zze.zzg);
        return zzwn.zzb(zzc2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzab(boolean z, long j) {
        zzcdd zzcdd = this.zzk;
        if (zzcdd != null) {
            zzcdd.zzi(z, j);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzmf[] zzac(Handler handler, zzabv zzabv, zzqg zzqg, zzxn zzxn, zzug zzug) {
        zztq zztq = zztq.zzb;
        Context context = this.zzb;
        zzrx zzrx = new zzrx(context, new zztc(context), zztq, false, handler, zzqg, new zzrd(context).zzd());
        zztq zztq2 = zztq.zzb;
        Context context2 = this.zzb;
        return new zzmf[]{zzrx, new zzaaw(context2, new zztc(context2), zztq2, 0, false, handler, zzabv, -1, 30.0f)};
    }

    public final void zzb(zzgv zzgv, zzhb zzhb, boolean z) {
    }

    public final void zzc(zzgv zzgv, zzhb zzhb, boolean z) {
    }

    public final void zzd(zzgv zzgv, zzhb zzhb, boolean z) {
        if (zzgv instanceof zzht) {
            synchronized (this.zzq) {
                this.zzs.add((zzht) zzgv);
            }
        } else if (zzgv instanceof zzcfm) {
            this.zzt = (zzcfm) zzgv;
            zzcdn zzcdn = (zzcdn) this.zzf.get();
            if (((Boolean) zzba.zzc().zza(zzbdz.zzbQ)).booleanValue() && zzcdn != null && this.zzt.zzn()) {
                HashMap hashMap = new HashMap();
                hashMap.put("gcacheHit", String.valueOf(this.zzt.zzp()));
                hashMap.put("gcacheDownloaded", String.valueOf(this.zzt.zzo()));
                zzt.zza.post(new zzcfv(zzcdn, hashMap));
            }
        }
    }

    public final void zze(zzmq zzmq, zzam zzam, zzis zzis) {
        zzcdn zzcdn = (zzcdn) this.zzf.get();
        if (((Boolean) zzba.zzc().zza(zzbdz.zzbQ)).booleanValue() && zzcdn != null) {
            HashMap hashMap = new HashMap();
            String str = zzam.zzl;
            if (str != null) {
                hashMap.put("audioMime", str);
            }
            String str2 = zzam.zzm;
            if (str2 != null) {
                hashMap.put("audioSampleMime", str2);
            }
            String str3 = zzam.zzj;
            if (str3 != null) {
                hashMap.put("audioCodec", str3);
            }
            zzcdn.zzd("onMetadataEvent", hashMap);
        }
    }

    public final /* synthetic */ void zzf(zzmq zzmq, int i, long j, long j2) {
    }

    public final /* synthetic */ void zzg(zzmq zzmq, zzvd zzvd) {
    }

    public final void zzh(zzmq zzmq, int i, long j) {
        this.zzm += i;
    }

    public final /* synthetic */ void zzi(zzco zzco, zzmr zzmr) {
    }

    public final void zzj(zzmq zzmq, zzuy zzuy, zzvd zzvd, IOException iOException, boolean z) {
        zzcdd zzcdd = this.zzk;
        if (zzcdd == null) {
            return;
        }
        if (this.zze.zzk) {
            zzcdd.zzl("onLoadException", iOException);
        } else {
            zzcdd.zzk("onLoadError", iOException);
        }
    }

    public final void zzk(zzmq zzmq, int i) {
        zzcdd zzcdd = this.zzk;
        if (zzcdd != null) {
            zzcdd.zzm(i);
        }
    }

    public final void zzl(zzmq zzmq, zzce zzce) {
        zzcdd zzcdd = this.zzk;
        if (zzcdd != null) {
            zzcdd.zzk("onPlayerError", zzce);
        }
    }

    public final /* synthetic */ void zzm(zzmq zzmq, zzcn zzcn, zzcn zzcn2, int i) {
    }

    public final void zzn(zzmq zzmq, Object obj, long j) {
        zzcdd zzcdd = this.zzk;
        if (zzcdd != null) {
            zzcdd.zzv();
        }
    }

    public final /* synthetic */ void zzo(zzmq zzmq, zzir zzir) {
    }

    public final void zzp(zzmq zzmq, zzam zzam, zzis zzis) {
        zzcdn zzcdn = (zzcdn) this.zzf.get();
        if (((Boolean) zzba.zzc().zza(zzbdz.zzbQ)).booleanValue() && zzcdn != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("frameRate", String.valueOf(zzam.zzt));
            hashMap.put("bitRate", String.valueOf(zzam.zzi));
            int i = zzam.zzr;
            int i2 = zzam.zzs;
            hashMap.put("resolution", i + "x" + i2);
            String str = zzam.zzl;
            if (str != null) {
                hashMap.put("videoMime", str);
            }
            String str2 = zzam.zzm;
            if (str2 != null) {
                hashMap.put("videoSampleMime", str2);
            }
            String str3 = zzam.zzj;
            if (str3 != null) {
                hashMap.put("videoCodec", str3);
            }
            zzcdn.zzd("onMetadataEvent", hashMap);
        }
    }

    public final void zzq(zzmq zzmq, zzdp zzdp) {
        zzcdd zzcdd = this.zzk;
        if (zzcdd != null) {
            zzcdd.zzD(zzdp.zzc, zzdp.zzd);
        }
    }

    public final int zzr() {
        return this.zzm;
    }

    public final int zzt() {
        return this.zzh.zzf();
    }

    public final long zzv() {
        return this.zzh.zzi();
    }

    public final long zzw() {
        return (long) this.zzl;
    }

    public final long zzx() {
        if (zzad() && this.zzt.zzp()) {
            return Math.min((long) this.zzl, this.zzt.zzk());
        }
        return 0;
    }

    public final long zzy() {
        return this.zzh.zzk();
    }

    public final long zzz() {
        return this.zzh.zzl();
    }

    public final void zzG(Uri[] uriArr, String str, ByteBuffer byteBuffer, boolean z) {
        zzvj zzvj;
        if (this.zzh != null) {
            this.zzi = byteBuffer;
            this.zzj = z;
            int length = uriArr.length;
            if (length == 1) {
                zzvj = zzaa(uriArr[0]);
            } else {
                zzvj[] zzvjArr = new zzvj[length];
                for (int i = 0; i < uriArr.length; i++) {
                    zzvjArr[i] = zzaa(uriArr[i]);
                }
                zzvj = new zzvy(false, false, zzvjArr);
            }
            this.zzh.zzB(zzvj);
            this.zzh.zzp();
            zzE().incrementAndGet();
        }
    }
}
