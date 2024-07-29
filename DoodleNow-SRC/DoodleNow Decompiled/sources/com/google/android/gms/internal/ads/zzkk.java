package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;
import android.view.TextureView;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzkk implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, zzabv, zzqg, zzxn, zzug, zzio, zzik {
    public static final /* synthetic */ int zzb = 0;
    final /* synthetic */ zzko zza;

    /* synthetic */ zzkk(zzko zzko, zzkj zzkj) {
        this.zza = zzko;
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        zzko.zzP(this.zza, surfaceTexture);
        this.zza.zzaf(i, i2);
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.zza.zzai((Object) null);
        this.zza.zzaf(0, 0);
        return true;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        this.zza.zzaf(i, i2);
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.zza.zzaf(i2, i3);
    }

    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.zza.zzaf(0, 0);
    }

    public final void zza(Exception exc) {
        this.zza.zzr.zzv(exc);
    }

    public final void zzb(String str, long j, long j2) {
        this.zza.zzr.zzw(str, j, j2);
    }

    public final void zzc(String str) {
        this.zza.zzr.zzx(str);
    }

    public final void zzd(zzir zzir) {
        this.zza.zzr.zzy(zzir);
        this.zza.zzL = null;
        this.zza.zzR = null;
    }

    public final void zze(zzir zzir) {
        this.zza.zzR = zzir;
        this.zza.zzr.zzz(zzir);
    }

    public final void zzf(zzam zzam, zzis zzis) {
        this.zza.zzL = zzam;
        this.zza.zzr.zzA(zzam, zzis);
    }

    public final void zzg(long j) {
        this.zza.zzr.zzB(j);
    }

    public final void zzh(Exception exc) {
        this.zza.zzr.zzC(exc);
    }

    public final void zzi(zzqh zzqh) {
        this.zza.zzr.zzD(zzqh);
    }

    public final void zzj(zzqh zzqh) {
        this.zza.zzr.zzE(zzqh);
    }

    public final void zzk(int i, long j, long j2) {
        this.zza.zzr.zzF(i, j, j2);
    }

    public final void zzl(int i, long j) {
        this.zza.zzr.zzG(i, j);
    }

    public final void zzm(Object obj, long j) {
        this.zza.zzr.zzH(obj, j);
        zzko zzko = this.zza;
        if (zzko.zzM == obj) {
            zzfb zzD = zzko.zzl;
            zzD.zzd(26, zzki.zza);
            zzD.zzc();
        }
    }

    public final void zzn(boolean z) {
        zzko zzko = this.zza;
        if (zzko.zzV != z) {
            zzko.zzV = z;
            zzfb zzD = this.zza.zzl;
            zzD.zzd(23, new zzkg(z));
            zzD.zzc();
        }
    }

    public final void zzo(Exception exc) {
        this.zza.zzr.zzI(exc);
    }

    public final void zzp(String str, long j, long j2) {
        this.zza.zzr.zzJ(str, j, j2);
    }

    public final void zzq(String str) {
        this.zza.zzr.zzK(str);
    }

    public final void zzr(zzir zzir) {
        this.zza.zzr.zzL(zzir);
        this.zza.zzK = null;
        this.zza.zzQ = null;
    }

    public final void zzs(zzir zzir) {
        this.zza.zzQ = zzir;
        this.zza.zzr.zzM(zzir);
    }

    public final void zzt(long j, int i) {
        this.zza.zzr.zzN(j, i);
    }

    public final void zzu(zzam zzam, zzis zzis) {
        this.zza.zzK = zzam;
        this.zza.zzr.zzO(zzam, zzis);
    }

    public final void zzv(zzdp zzdp) {
        this.zza.zzaa = zzdp;
        zzfb zzD = this.zza.zzl;
        zzD.zzd(25, new zzkh(zzdp));
        zzD.zzc();
    }
}
