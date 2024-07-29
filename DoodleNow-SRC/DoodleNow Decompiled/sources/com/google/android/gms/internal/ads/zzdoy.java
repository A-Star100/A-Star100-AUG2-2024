package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdoy extends zzbnk implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzbgq {
    private View zza;
    private zzdq zzb;
    private zzdkt zzc;
    private boolean zzd = false;
    private boolean zze = false;

    public zzdoy(zzdkt zzdkt, zzdky zzdky) {
        this.zza = zzdky.zzf();
        this.zzb = zzdky.zzj();
        this.zzc = zzdkt;
        if (zzdky.zzs() != null) {
            zzdky.zzs().zzan(this);
        }
    }

    private final void zzg() {
        View view;
        zzdkt zzdkt = this.zzc;
        if (zzdkt != null && (view = this.zza) != null) {
            zzdkt.zzA(view, Collections.emptyMap(), Collections.emptyMap(), zzdkt.zzW(this.zza));
        }
    }

    private final void zzh() {
        View view = this.zza;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.zza);
            }
        }
    }

    private static final void zzi(zzbno zzbno, int i) {
        try {
            zzbno.zze(i);
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onGlobalLayout() {
        zzg();
    }

    public final void onScrollChanged() {
        zzg();
    }

    public final zzdq zzb() throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (!this.zzd) {
            return this.zzb;
        }
        zzm.zzg("getVideoController: Instream ad should not be used after destroyed");
        return null;
    }

    public final zzbhb zzc() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzd) {
            zzm.zzg("getVideoController: Instream ad should not be used after destroyed");
            return null;
        }
        zzdkt zzdkt = this.zzc;
        if (zzdkt == null || zzdkt.zzc() == null) {
            return null;
        }
        return zzdkt.zzc().zza();
    }

    public final void zzd() throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzh();
        zzdkt zzdkt = this.zzc;
        if (zzdkt != null) {
            zzdkt.zzb();
        }
        this.zzc = null;
        this.zza = null;
        this.zzb = null;
        this.zzd = true;
    }

    public final void zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzf(iObjectWrapper, new zzdox(this));
    }

    public final void zzf(IObjectWrapper iObjectWrapper, zzbno zzbno) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzd) {
            zzm.zzg("Instream ad can not be shown after destroy().");
            zzi(zzbno, 2);
            return;
        }
        View view = this.zza;
        if (view == null || this.zzb == null) {
            zzm.zzg("Instream internal error: ".concat(view == null ? "can not get video view." : "can not get video controller."));
            zzi(zzbno, 0);
        } else if (this.zze) {
            zzm.zzg("Instream ad should not be used again.");
            zzi(zzbno, 1);
        } else {
            this.zze = true;
            zzh();
            ((ViewGroup) ObjectWrapper.unwrap(iObjectWrapper)).addView(this.zza, new ViewGroup.LayoutParams(-1, -1));
            zzu.zzx();
            zzcce.zza(this.zza, this);
            zzu.zzx();
            zzcce.zzb(this.zza, this);
            zzg();
            try {
                zzbno.zzf();
            } catch (RemoteException e) {
                zzm.zzl("#007 Could not call remote method.", e);
            }
        }
    }
}
