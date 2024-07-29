package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.io.IOException;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public abstract class zzup extends zzuh {
    private final HashMap zza = new HashMap();
    private Handler zzb;
    private zzhy zzc;

    protected zzup() {
    }

    /* access modifiers changed from: protected */
    public abstract void zzA(Object obj, zzvj zzvj, zzcx zzcx);

    /* access modifiers changed from: protected */
    public final void zzB(Object obj, zzvj zzvj) {
        zzek.zzd(!this.zza.containsKey(obj));
        zzum zzum = new zzum(this, obj);
        zzun zzun = new zzun(this, obj);
        this.zza.put(obj, new zzuo(zzvj, zzum, zzun));
        Handler handler = this.zzb;
        handler.getClass();
        zzvj.zzh(handler, zzun);
        Handler handler2 = this.zzb;
        handler2.getClass();
        zzvj.zzg(handler2, zzun);
        zzvj.zzm(zzum, this.zzc, zzb());
        if (!zzu()) {
            zzvj.zzi(zzum);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzj() {
        for (zzuo zzuo : this.zza.values()) {
            zzuo.zza.zzi(zzuo.zzb);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzl() {
        for (zzuo zzuo : this.zza.values()) {
            zzuo.zza.zzk(zzuo.zzb);
        }
    }

    /* access modifiers changed from: protected */
    public void zzn(zzhy zzhy) {
        this.zzc = zzhy;
        this.zzb = zzfx.zzx((Handler.Callback) null);
    }

    /* access modifiers changed from: protected */
    public void zzq() {
        for (zzuo zzuo : this.zza.values()) {
            zzuo.zza.zzp(zzuo.zzb);
            zzuo.zza.zzs(zzuo.zzc);
            zzuo.zza.zzr(zzuo.zzc);
        }
        this.zza.clear();
    }

    /* access modifiers changed from: protected */
    public int zzw(Object obj, int i) {
        return 0;
    }

    /* access modifiers changed from: protected */
    public long zzx(Object obj, long j, zzvh zzvh) {
        return j;
    }

    /* access modifiers changed from: protected */
    public zzvh zzy(Object obj, zzvh zzvh) {
        throw null;
    }

    public void zzz() throws IOException {
        for (zzuo zzuo : this.zza.values()) {
            zzuo.zza.zzz();
        }
    }
}
