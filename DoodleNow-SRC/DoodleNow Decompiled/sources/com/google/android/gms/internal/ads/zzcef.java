package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.revenuecat.purchases.common.Constants;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcef extends zzcct implements TextureView.SurfaceTextureListener, zzcdd {
    private final zzcdn zzc;
    private final zzcdo zzd;
    private final zzcdm zze;
    private zzccs zzf;
    private Surface zzg;
    private zzcde zzh;
    private String zzi;
    private String[] zzj;
    private boolean zzk;
    private int zzl = 1;
    private zzcdl zzm;
    private final boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private int zzq;
    private int zzr;
    private float zzs;

    public zzcef(Context context, zzcdo zzcdo, zzcdn zzcdn, boolean z, boolean z2, zzcdm zzcdm) {
        super(context);
        this.zzc = zzcdn;
        this.zzd = zzcdo;
        this.zzn = z;
        this.zze = zzcdm;
        setSurfaceTextureListener(this);
        zzcdo.zza(this);
    }

    private static String zzT(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        return str + "/" + canonicalName + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + message;
    }

    private final void zzU() {
        zzcde zzcde = this.zzh;
        if (zzcde != null) {
            zzcde.zzQ(true);
        }
    }

    private final void zzV() {
        if (!this.zzo) {
            this.zzo = true;
            zzt.zza.post(new zzcee(this));
            zzn();
            this.zzd.zzb();
            if (this.zzp) {
                zzp();
            }
        }
    }

    private final void zzX() {
        zzcde zzcde = this.zzh;
        if (zzcde != null) {
            zzcde.zzQ(false);
        }
    }

    private final void zzY() {
        if (this.zzh != null) {
            zzZ((Surface) null, true);
            zzcde zzcde = this.zzh;
            if (zzcde != null) {
                zzcde.zzL((zzcdd) null);
                this.zzh.zzH();
                this.zzh = null;
            }
            this.zzl = 1;
            this.zzk = false;
            this.zzo = false;
            this.zzp = false;
        }
    }

    private final void zzZ(Surface surface, boolean z) {
        zzcde zzcde = this.zzh;
        if (zzcde != null) {
            try {
                zzcde.zzS(surface, z);
            } catch (IOException e) {
                zzm.zzk("", e);
            }
        } else {
            zzm.zzj("Trying to set surface before player is initialized.");
        }
    }

    private final void zzaa() {
        zzab(this.zzq, this.zzr);
    }

    private final void zzab(int i, int i2) {
        float f = i2 > 0 ? ((float) i) / ((float) i2) : 1.0f;
        if (this.zzs != f) {
            this.zzs = f;
            requestLayout();
        }
    }

    private final boolean zzac() {
        return zzad() && this.zzl != 1;
    }

    private final boolean zzad() {
        zzcde zzcde = this.zzh;
        return zzcde != null && zzcde.zzV() && !this.zzk;
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f = this.zzs;
        if (f != 0.0f && this.zzm == null) {
            float f2 = (float) measuredWidth;
            float f3 = f2 / ((float) measuredHeight);
            if (f > f3) {
                measuredHeight = (int) (f2 / f);
            }
            if (f < f3) {
                measuredWidth = (int) (((float) measuredHeight) * f);
            }
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
        zzcdl zzcdl = this.zzm;
        if (zzcdl != null) {
            zzcdl.zzc(measuredWidth, measuredHeight);
        }
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.zzn) {
            zzcdl zzcdl = new zzcdl(getContext());
            this.zzm = zzcdl;
            zzcdl.zzd(surfaceTexture, i, i2);
            this.zzm.start();
            SurfaceTexture zzb = this.zzm.zzb();
            if (zzb != null) {
                surfaceTexture = zzb;
            } else {
                this.zzm.zze();
                this.zzm = null;
            }
        }
        Surface surface = new Surface(surfaceTexture);
        this.zzg = surface;
        if (this.zzh == null) {
            zzW(false, (Integer) null);
        } else {
            zzZ(surface, true);
            if (!this.zze.zza) {
                zzU();
            }
        }
        if (this.zzq == 0 || this.zzr == 0) {
            zzab(i, i2);
        } else {
            zzaa();
        }
        zzt.zza.post(new zzceb(this));
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzo();
        zzcdl zzcdl = this.zzm;
        if (zzcdl != null) {
            zzcdl.zze();
            this.zzm = null;
        }
        if (this.zzh != null) {
            zzX();
            Surface surface = this.zzg;
            if (surface != null) {
                surface.release();
            }
            this.zzg = null;
            zzZ((Surface) null, true);
        }
        zzt.zza.post(new zzcdx(this));
        return true;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        zzcdl zzcdl = this.zzm;
        if (zzcdl != null) {
            zzcdl.zzc(i, i2);
        }
        zzt.zza.post(new zzcdw(this, i, i2));
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzd.zzf(this);
        this.zza.zza(surfaceTexture, this.zzf);
    }

    /* access modifiers changed from: protected */
    public final void onWindowVisibilityChanged(int i) {
        zze.zza("AdExoPlayerView3 window visibility changed to " + i);
        zzt.zza.post(new zzcdv(this, i));
        super.onWindowVisibilityChanged(i);
    }

    public final void zzA(int i) {
        zzcde zzcde = this.zzh;
        if (zzcde != null) {
            zzcde.zzN(i);
        }
    }

    public final void zzB(int i) {
        zzcde zzcde = this.zzh;
        if (zzcde != null) {
            zzcde.zzR(i);
        }
    }

    public final void zzD(int i, int i2) {
        this.zzq = i;
        this.zzr = i2;
        zzaa();
    }

    /* access modifiers changed from: package-private */
    public final zzcde zzE(Integer num) {
        zzcdm zzcdm = this.zze;
        zzcdn zzcdn = this.zzc;
        zzcfz zzcfz = new zzcfz(zzcdn.getContext(), zzcdm, zzcdn, num);
        zzm.zzi("ExoPlayerAdapter initialized.");
        return zzcfz;
    }

    /* access modifiers changed from: package-private */
    public final String zzF() {
        zzcdn zzcdn = this.zzc;
        return zzu.zzp().zzc(zzcdn.getContext(), zzcdn.zzn().afmaVersion);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzG(String str) {
        zzccs zzccs = this.zzf;
        if (zzccs != null) {
            zzccs.zzb("ExoPlayerAdapter error", str);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzH() {
        zzccs zzccs = this.zzf;
        if (zzccs != null) {
            zzccs.zza();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzI() {
        zzccs zzccs = this.zzf;
        if (zzccs != null) {
            zzccs.zzf();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzJ(boolean z, long j) {
        this.zzc.zzv(z, j);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzK(String str) {
        zzccs zzccs = this.zzf;
        if (zzccs != null) {
            zzccs.zzc("ExoPlayerAdapter exception", str);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzL() {
        zzccs zzccs = this.zzf;
        if (zzccs != null) {
            zzccs.zzg();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzM() {
        zzccs zzccs = this.zzf;
        if (zzccs != null) {
            zzccs.zzh();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzN() {
        zzccs zzccs = this.zzf;
        if (zzccs != null) {
            zzccs.zzi();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzO(int i, int i2) {
        zzccs zzccs = this.zzf;
        if (zzccs != null) {
            zzccs.zzj(i, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzP() {
        float zza = this.zzb.zza();
        zzcde zzcde = this.zzh;
        if (zzcde != null) {
            try {
                zzcde.zzT(zza, false);
            } catch (IOException e) {
                zzm.zzk("", e);
            }
        } else {
            zzm.zzj("Trying to set volume before player is initialized.");
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzQ(int i) {
        zzccs zzccs = this.zzf;
        if (zzccs != null) {
            zzccs.onWindowVisibilityChanged(i);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzR() {
        zzccs zzccs = this.zzf;
        if (zzccs != null) {
            zzccs.zzd();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzS() {
        zzccs zzccs = this.zzf;
        if (zzccs != null) {
            zzccs.zze();
        }
    }

    public final int zza() {
        if (zzac()) {
            return (int) this.zzh.zzy();
        }
        return 0;
    }

    public final int zzb() {
        zzcde zzcde = this.zzh;
        if (zzcde != null) {
            return zzcde.zzr();
        }
        return -1;
    }

    public final int zzc() {
        if (zzac()) {
            return (int) this.zzh.zzz();
        }
        return 0;
    }

    public final int zzd() {
        return this.zzr;
    }

    public final int zze() {
        return this.zzq;
    }

    public final long zzf() {
        zzcde zzcde = this.zzh;
        if (zzcde != null) {
            return zzcde.zzx();
        }
        return -1;
    }

    public final long zzg() {
        zzcde zzcde = this.zzh;
        if (zzcde != null) {
            return zzcde.zzA();
        }
        return -1;
    }

    public final long zzh() {
        zzcde zzcde = this.zzh;
        if (zzcde != null) {
            return zzcde.zzB();
        }
        return -1;
    }

    public final void zzi(boolean z, long j) {
        if (this.zzc != null) {
            zzcbr.zze.execute(new zzcdy(this, z, j));
        }
    }

    public final String zzj() {
        return "ExoPlayer/2".concat(true != this.zzn ? "" : " spherical");
    }

    public final void zzk(String str, Exception exc) {
        String zzT = zzT(str, exc);
        zzm.zzj("ExoPlayerAdapter error: ".concat(zzT));
        this.zzk = true;
        if (this.zze.zza) {
            zzX();
        }
        zzt.zza.post(new zzcec(this, zzT));
        zzu.zzo().zzv(exc, "AdExoPlayerView.onError");
    }

    public final void zzl(String str, Exception exc) {
        String zzT = zzT("onLoadException", exc);
        zzm.zzj("ExoPlayerAdapter exception: ".concat(zzT));
        zzu.zzo().zzv(exc, "AdExoPlayerView.onException");
        zzt.zza.post(new zzcdz(this, zzT));
    }

    public final void zzm(int i) {
        if (this.zzl != i) {
            this.zzl = i;
            if (i == 3) {
                zzV();
            } else if (i == 4) {
                if (this.zze.zza) {
                    zzX();
                }
                this.zzd.zze();
                this.zzb.zzc();
                zzt.zza.post(new zzced(this));
            }
        }
    }

    public final void zzn() {
        zzt.zza.post(new zzcdu(this));
    }

    public final void zzo() {
        if (zzac()) {
            if (this.zze.zza) {
                zzX();
            }
            this.zzh.zzO(false);
            this.zzd.zze();
            this.zzb.zzc();
            zzt.zza.post(new zzcea(this));
        }
    }

    public final void zzp() {
        if (zzac()) {
            if (this.zze.zza) {
                zzU();
            }
            this.zzh.zzO(true);
            this.zzd.zzc();
            this.zzb.zzb();
            this.zza.zzb();
            zzt.zza.post(new zzcdt(this));
            return;
        }
        this.zzp = true;
    }

    public final void zzq(int i) {
        if (zzac()) {
            this.zzh.zzI((long) i);
        }
    }

    public final void zzr(zzccs zzccs) {
        this.zzf = zzccs;
    }

    public final void zzs(String str) {
        if (str != null) {
            zzC(str, (String[]) null, (Integer) null);
        }
    }

    public final void zzt() {
        if (zzad()) {
            this.zzh.zzU();
            zzY();
        }
        this.zzd.zze();
        this.zzb.zzc();
        this.zzd.zzd();
    }

    public final void zzu(float f, float f2) {
        zzcdl zzcdl = this.zzm;
        if (zzcdl != null) {
            zzcdl.zzf(f, f2);
        }
    }

    public final void zzv() {
        zzt.zza.post(new zzcds(this));
    }

    public final Integer zzw() {
        zzcde zzcde = this.zzh;
        if (zzcde != null) {
            return zzcde.zzC();
        }
        return null;
    }

    public final void zzx(int i) {
        zzcde zzcde = this.zzh;
        if (zzcde != null) {
            zzcde.zzJ(i);
        }
    }

    public final void zzy(int i) {
        zzcde zzcde = this.zzh;
        if (zzcde != null) {
            zzcde.zzK(i);
        }
    }

    public final void zzz(int i) {
        zzcde zzcde = this.zzh;
        if (zzcde != null) {
            zzcde.zzM(i);
        }
    }

    public final void zzC(String str, String[] strArr, Integer num) {
        if (str != null) {
            if (strArr == null) {
                this.zzj = new String[]{str};
            } else {
                this.zzj = (String[]) Arrays.copyOf(strArr, strArr.length);
            }
            String str2 = this.zzi;
            boolean z = false;
            if (this.zze.zzl && str2 != null && !str.equals(str2) && this.zzl == 4) {
                z = true;
            }
            this.zzi = str;
            zzW(z, num);
        }
    }

    private final void zzW(boolean z, Integer num) {
        zzcde zzcde = this.zzh;
        if (zzcde != null && !z) {
            zzcde.zzP(num);
        } else if (this.zzi != null && this.zzg != null) {
            if (z) {
                if (zzad()) {
                    zzcde.zzU();
                    zzY();
                } else {
                    zzm.zzj("No valid ExoPlayerAdapter exists when switch source.");
                    return;
                }
            }
            if (this.zzi.startsWith("cache:")) {
                zzcey zzp2 = this.zzc.zzp(this.zzi);
                if (zzp2 instanceof zzcfh) {
                    zzcde zza = ((zzcfh) zzp2).zza();
                    this.zzh = zza;
                    zza.zzP(num);
                    if (!this.zzh.zzV()) {
                        zzm.zzj("Precached video player has been released.");
                        return;
                    }
                } else if (zzp2 instanceof zzcfe) {
                    zzcfe zzcfe = (zzcfe) zzp2;
                    String zzF = zzF();
                    ByteBuffer zzk2 = zzcfe.zzk();
                    boolean zzl2 = zzcfe.zzl();
                    String zzi2 = zzcfe.zzi();
                    if (zzi2 == null) {
                        zzm.zzj("Stream cache URL is null.");
                        return;
                    }
                    zzcde zzE = zzE(num);
                    this.zzh = zzE;
                    zzE.zzG(new Uri[]{Uri.parse(zzi2)}, zzF, zzk2, zzl2);
                } else {
                    zzm.zzj("Stream cache miss: ".concat(String.valueOf(this.zzi)));
                    return;
                }
            } else {
                this.zzh = zzE(num);
                String zzF2 = zzF();
                Uri[] uriArr = new Uri[this.zzj.length];
                int i = 0;
                while (true) {
                    String[] strArr = this.zzj;
                    if (i >= strArr.length) {
                        break;
                    }
                    uriArr[i] = Uri.parse(strArr[i]);
                    i++;
                }
                this.zzh.zzF(uriArr, zzF2);
            }
            this.zzh.zzL(this);
            zzZ(this.zzg, false);
            if (this.zzh.zzV()) {
                int zzt = this.zzh.zzt();
                this.zzl = zzt;
                if (zzt == 3) {
                    zzV();
                }
            }
        }
    }
}
