package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdp;
import com.google.android.gms.ads.internal.client.zzdt;
import com.google.android.gms.ads.internal.client.zzfk;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzchm extends zzdp {
    private final zzcdn zza;
    private final Object zzb = new Object();
    private final boolean zzc;
    private final boolean zzd;
    private int zze;
    private zzdt zzf;
    private boolean zzg;
    private boolean zzh = true;
    private float zzi;
    private float zzj;
    private float zzk;
    private boolean zzl;
    private boolean zzm;
    private zzbim zzn;

    public zzchm(zzcdn zzcdn, float f, boolean z, boolean z2) {
        this.zza = zzcdn;
        this.zzi = f;
        this.zzc = z;
        this.zzd = z2;
    }

    private final void zzw(int i, int i2, boolean z, boolean z2) {
        zzcbr.zze.execute(new zzchl(this, i, i2, z, z2));
    }

    private final void zzx(String str, Map map) {
        HashMap hashMap = map == null ? new HashMap() : new HashMap(map);
        hashMap.put("action", str);
        zzcbr.zze.execute(new zzchk(this, hashMap));
    }

    public final void zzc(float f, float f2, int i, boolean z, float f3) {
        boolean z2;
        boolean z3;
        int i2;
        synchronized (this.zzb) {
            z2 = true;
            if (f2 == this.zzi) {
                if (f3 == this.zzk) {
                    z2 = false;
                }
            }
            this.zzi = f2;
            this.zzj = f;
            z3 = this.zzh;
            this.zzh = z;
            i2 = this.zze;
            this.zze = i;
            float f4 = this.zzk;
            this.zzk = f3;
            if (Math.abs(f3 - f4) > 1.0E-4f) {
                this.zza.zzF().invalidate();
            }
        }
        if (z2) {
            try {
                zzbim zzbim = this.zzn;
                if (zzbim != null) {
                    zzbim.zze();
                }
            } catch (RemoteException e) {
                zzm.zzl("#007 Could not call remote method.", e);
            }
        }
        zzw(i2, i, z3, z);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(int i, int i2, boolean z, boolean z2) {
        boolean z3;
        int i3;
        boolean z4;
        zzdt zzdt;
        zzdt zzdt2;
        zzdt zzdt3;
        synchronized (this.zzb) {
            boolean z5 = this.zzg;
            boolean z6 = false;
            if (z5 || i2 != 1) {
                i3 = i2;
                z3 = false;
            } else {
                i2 = 1;
                i3 = 1;
                z3 = true;
            }
            boolean z7 = i != i2;
            if (!z7 || i3 != 1) {
                z4 = false;
            } else {
                z4 = true;
                i3 = 1;
            }
            boolean z8 = z7 && i3 == 2;
            boolean z9 = z7 && i3 == 3;
            if (z5 || z3) {
                z6 = true;
            }
            this.zzg = z6;
            if (z3) {
                try {
                    zzdt zzdt4 = this.zzf;
                    if (zzdt4 != null) {
                        zzdt4.zzi();
                    }
                } catch (RemoteException e) {
                    zzm.zzl("#007 Could not call remote method.", e);
                }
            }
            if (z4 && (zzdt3 = this.zzf) != null) {
                zzdt3.zzh();
            }
            if (z8 && (zzdt2 = this.zzf) != null) {
                zzdt2.zzg();
            }
            if (z9) {
                zzdt zzdt5 = this.zzf;
                if (zzdt5 != null) {
                    zzdt5.zze();
                }
                this.zza.zzw();
            }
            if (!(z == z2 || (zzdt = this.zzf) == null)) {
                zzdt.zzf(z2);
            }
        }
    }

    public final float zze() {
        float f;
        synchronized (this.zzb) {
            f = this.zzk;
        }
        return f;
    }

    public final float zzf() {
        float f;
        synchronized (this.zzb) {
            f = this.zzj;
        }
        return f;
    }

    public final float zzg() {
        float f;
        synchronized (this.zzb) {
            f = this.zzi;
        }
        return f;
    }

    public final int zzh() {
        int i;
        synchronized (this.zzb) {
            i = this.zze;
        }
        return i;
    }

    public final zzdt zzi() throws RemoteException {
        zzdt zzdt;
        synchronized (this.zzb) {
            zzdt = this.zzf;
        }
        return zzdt;
    }

    public final void zzj(boolean z) {
        zzx(true != z ? "unmute" : "mute", (Map) null);
    }

    public final void zzk() {
        zzx("pause", (Map) null);
    }

    public final void zzl() {
        zzx("play", (Map) null);
    }

    public final void zzm(zzdt zzdt) {
        synchronized (this.zzb) {
            this.zzf = zzdt;
        }
    }

    public final void zzn() {
        zzx("stop", (Map) null);
    }

    public final boolean zzo() {
        boolean z;
        Object obj = this.zzb;
        boolean zzp = zzp();
        synchronized (obj) {
            z = false;
            if (!zzp) {
                try {
                    if (this.zzm && this.zzd) {
                        z = true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return z;
    }

    public final boolean zzp() {
        boolean z;
        synchronized (this.zzb) {
            z = false;
            if (this.zzc && this.zzl) {
                z = true;
            }
        }
        return z;
    }

    public final boolean zzq() {
        boolean z;
        synchronized (this.zzb) {
            z = this.zzh;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzr(Map map) {
        this.zza.zzd("pubVideoCmd", map);
    }

    public final void zzs(zzfk zzfk) {
        Object obj = this.zzb;
        boolean z = zzfk.zza;
        boolean z2 = zzfk.zzb;
        boolean z3 = zzfk.zzc;
        synchronized (obj) {
            this.zzl = z2;
            this.zzm = z3;
        }
        zzx("initialState", CollectionUtils.mapOf("muteStart", true != z ? SessionDescription.SUPPORTED_SDP_VERSION : "1", "customControlsRequested", true != z2 ? SessionDescription.SUPPORTED_SDP_VERSION : "1", "clickToExpandRequested", true != z3 ? SessionDescription.SUPPORTED_SDP_VERSION : "1"));
    }

    public final void zzt(float f) {
        synchronized (this.zzb) {
            this.zzj = f;
        }
    }

    public final void zzu() {
        boolean z;
        int i;
        synchronized (this.zzb) {
            z = this.zzh;
            i = this.zze;
            this.zze = 3;
        }
        zzw(i, 3, z, z);
    }

    public final void zzv(zzbim zzbim) {
        synchronized (this.zzb) {
            this.zzn = zzbim;
        }
    }
}
