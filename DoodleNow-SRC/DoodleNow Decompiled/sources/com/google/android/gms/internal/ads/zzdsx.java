package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.internal.ads.zzbdg;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdsx implements zzdbl, zzdae, zzcyt, zzczk, zza, zzddx {
    private final zzbcx zza;
    private boolean zzb = false;

    public zzdsx(zzbcx zzbcx, @Nullable zzfdi zzfdi) {
        this.zza = zzbcx;
        zzbcx.zzb(zzbcz.AD_REQUEST);
        if (zzfdi != null) {
            zzbcx.zzb(zzbcz.REQUEST_IS_PREFETCH);
        }
    }

    public final synchronized void onAdClicked() {
        if (!this.zzb) {
            this.zza.zzb(zzbcz.AD_FIRST_CLICK);
            this.zzb = true;
            return;
        }
        this.zza.zzb(zzbcz.AD_SUBSEQUENT_CLICK);
    }

    public final void zzdB(zze zze) {
        switch (zze.zza) {
            case 1:
                this.zza.zzb(zzbcz.AD_FAILED_TO_LOAD_INVALID_REQUEST);
                return;
            case 2:
                this.zza.zzb(zzbcz.AD_FAILED_TO_LOAD_NETWORK_ERROR);
                return;
            case 3:
                this.zza.zzb(zzbcz.AD_FAILED_TO_LOAD_NO_FILL);
                return;
            case 4:
                this.zza.zzb(zzbcz.AD_FAILED_TO_LOAD_TIMEOUT);
                return;
            case 5:
                this.zza.zzb(zzbcz.AD_FAILED_TO_LOAD_CANCELLED);
                return;
            case 6:
                this.zza.zzb(zzbcz.AD_FAILED_TO_LOAD_NO_ERROR);
                return;
            case 7:
                this.zza.zzb(zzbcz.AD_FAILED_TO_LOAD_NOT_FOUND);
                return;
            default:
                this.zza.zzb(zzbcz.AD_FAILED_TO_LOAD);
                return;
        }
    }

    public final void zzdn(zzbxd zzbxd) {
    }

    public final void zzdo(zzffz zzffz) {
        this.zza.zzc(new zzdst(zzffz));
    }

    public final void zzh() {
        this.zza.zzb(zzbcz.REQUEST_FAILED_TO_LOAD_FROM_CACHE);
    }

    public final void zzi(zzbdg.zzb zzb2) {
        this.zza.zzc(new zzdsw(zzb2));
        this.zza.zzb(zzbcz.REQUEST_LOADED_FROM_CACHE);
    }

    public final void zzj(zzbdg.zzb zzb2) {
        this.zza.zzc(new zzdsu(zzb2));
        this.zza.zzb(zzbcz.REQUEST_SAVED_TO_CACHE);
    }

    public final void zzl(boolean z) {
        zzbcz zzbcz;
        if (z) {
            zzbcz = zzbcz.NOTIFIED_CACHE_HIT_TO_SERVICE_SUCCEEDED;
        } else {
            zzbcz = zzbcz.NOTIFIED_CACHE_HIT_TO_SERVICE_FAILED;
        }
        this.zza.zzb(zzbcz);
    }

    public final void zzm(zzbdg.zzb zzb2) {
        this.zza.zzc(new zzdsv(zzb2));
        this.zza.zzb(zzbcz.REQUEST_PREFETCH_INTERCEPTED);
    }

    public final void zzn(boolean z) {
        zzbcz zzbcz;
        if (z) {
            zzbcz = zzbcz.REQUESTED_CACHE_KEY_FROM_SERVICE_SUCCEEDED;
        } else {
            zzbcz = zzbcz.REQUESTED_CACHE_KEY_FROM_SERVICE_FAILED;
        }
        this.zza.zzb(zzbcz);
    }

    public final synchronized void zzr() {
        this.zza.zzb(zzbcz.AD_IMPRESSION);
    }

    public final void zzs() {
        this.zza.zzb(zzbcz.AD_LOADED);
    }
}
