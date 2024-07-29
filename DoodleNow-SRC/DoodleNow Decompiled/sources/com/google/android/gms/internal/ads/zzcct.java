package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.TextureView;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public abstract class zzcct extends TextureView implements zzcdq {
    protected final zzcdh zza = new zzcdh();
    protected final zzcdr zzb;

    public zzcct(Context context) {
        super(context);
        this.zzb = new zzcdr(context, this);
    }

    public void zzA(int i) {
    }

    public void zzB(int i) {
    }

    public void zzC(String str, String[] strArr, Integer num) {
        zzs(str);
    }

    public abstract int zza();

    public abstract int zzb();

    public abstract int zzc();

    public abstract int zzd();

    public abstract int zze();

    public abstract long zzf();

    public abstract long zzg();

    public abstract long zzh();

    public abstract String zzj();

    public abstract void zzn();

    public abstract void zzo();

    public abstract void zzp();

    public abstract void zzq(int i);

    public abstract void zzr(zzccs zzccs);

    public abstract void zzs(String str);

    public abstract void zzt();

    public abstract void zzu(float f, float f2);

    public Integer zzw() {
        return null;
    }

    public void zzx(int i) {
    }

    public void zzy(int i) {
    }

    public void zzz(int i) {
    }
}
