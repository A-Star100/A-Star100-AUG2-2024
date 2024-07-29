package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzbd;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbpb extends zzccd {
    private final Object zza = new Object();
    private final zzbd zzb;
    private boolean zzc;
    private int zzd;

    public zzbpb(zzbd zzbd) {
        this.zzb = zzbd;
        this.zzc = false;
        this.zzd = 0;
    }

    public final zzbow zza() {
        zzbow zzbow = new zzbow(this);
        zze.zza("createNewReference: Trying to acquire lock");
        synchronized (this.zza) {
            zze.zza("createNewReference: Lock acquired");
            zzj(new zzbox(this, zzbow), new zzboy(this, zzbow));
            Preconditions.checkState(this.zzd >= 0);
            this.zzd++;
        }
        zze.zza("createNewReference: Lock released");
        return zzbow;
    }

    public final void zzb() {
        zze.zza("markAsDestroyable: Trying to acquire lock");
        synchronized (this.zza) {
            zze.zza("markAsDestroyable: Lock acquired");
            Preconditions.checkState(this.zzd >= 0);
            zze.zza("Releasing root reference. JS Engine will be destroyed once other references are released.");
            this.zzc = true;
            zzc();
        }
        zze.zza("markAsDestroyable: Lock released");
    }

    /* access modifiers changed from: protected */
    public final void zzc() {
        zze.zza("maybeDestroy: Trying to acquire lock");
        synchronized (this.zza) {
            zze.zza("maybeDestroy: Lock acquired");
            Preconditions.checkState(this.zzd >= 0);
            if (!this.zzc || this.zzd != 0) {
                zze.zza("There are still references to the engine. Not destroying.");
            } else {
                zze.zza("No reference is left (including root). Cleaning up engine.");
                zzj(new zzbpa(this), new zzcbz());
            }
        }
        zze.zza("maybeDestroy: Lock released");
    }

    /* access modifiers changed from: protected */
    public final void zzd() {
        zze.zza("releaseOneReference: Trying to acquire lock");
        synchronized (this.zza) {
            zze.zza("releaseOneReference: Lock acquired");
            Preconditions.checkState(this.zzd > 0);
            zze.zza("Releasing 1 reference for JS Engine");
            this.zzd--;
            zzc();
        }
        zze.zza("releaseOneReference: Lock released");
    }
}
