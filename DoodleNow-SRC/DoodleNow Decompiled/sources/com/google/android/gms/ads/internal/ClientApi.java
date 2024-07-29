package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzbq;
import com.google.android.gms.ads.internal.client.zzbu;
import com.google.android.gms.ads.internal.client.zzcd;
import com.google.android.gms.ads.internal.client.zzco;
import com.google.android.gms.ads.internal.client.zzdj;
import com.google.android.gms.ads.internal.client.zzew;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzad;
import com.google.android.gms.ads.internal.overlay.zzaf;
import com.google.android.gms.ads.internal.overlay.zzag;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.ads.internal.overlay.zzu;
import com.google.android.gms.ads.internal.overlay.zzz;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbdz;
import com.google.android.gms.internal.ads.zzbhi;
import com.google.android.gms.internal.ads.zzbho;
import com.google.android.gms.internal.ads.zzblx;
import com.google.android.gms.internal.ads.zzbma;
import com.google.android.gms.internal.ads.zzbqo;
import com.google.android.gms.internal.ads.zzbui;
import com.google.android.gms.internal.ads.zzbup;
import com.google.android.gms.internal.ads.zzbxt;
import com.google.android.gms.internal.ads.zzbyj;
import com.google.android.gms.internal.ads.zzcap;
import com.google.android.gms.internal.ads.zzcik;
import com.google.android.gms.internal.ads.zzdls;
import com.google.android.gms.internal.ads.zzdlu;
import com.google.android.gms.internal.ads.zzdvq;
import com.google.android.gms.internal.ads.zzend;
import com.google.android.gms.internal.ads.zzfan;
import com.google.android.gms.internal.ads.zzfao;
import com.google.android.gms.internal.ads.zzfcb;
import com.google.android.gms.internal.ads.zzfds;
import com.google.android.gms.internal.ads.zzffg;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public class ClientApi extends zzcd {
    public final zzbq zzb(IObjectWrapper iObjectWrapper, String str, zzbqo zzbqo, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return new zzend(zzcik.zzb(context, zzbqo, i), context, str);
    }

    public final zzbu zzc(IObjectWrapper iObjectWrapper, zzq zzq, String str, zzbqo zzbqo, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfan zzt = zzcik.zzb(context, zzbqo, i).zzt();
        zzt.zza(str);
        zzt.zzb(context);
        zzfao zzc = zzt.zzc();
        if (i >= ((Integer) zzba.zzc().zza(zzbdz.zzfj)).intValue()) {
            return zzc.zza();
        }
        return new zzew();
    }

    public final zzbu zzd(IObjectWrapper iObjectWrapper, zzq zzq, String str, zzbqo zzbqo, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfcb zzu = zzcik.zzb(context, zzbqo, i).zzu();
        zzu.zzc(context);
        zzu.zza(zzq);
        zzu.zzb(str);
        return zzu.zzd().zza();
    }

    public final zzbu zze(IObjectWrapper iObjectWrapper, zzq zzq, String str, zzbqo zzbqo, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfds zzv = zzcik.zzb(context, zzbqo, i).zzv();
        zzv.zzc(context);
        zzv.zza(zzq);
        zzv.zzb(str);
        return zzv.zzd().zza();
    }

    public final zzbu zzf(IObjectWrapper iObjectWrapper, zzq zzq, String str, int i) {
        return new zzt((Context) ObjectWrapper.unwrap(iObjectWrapper), zzq, str, new VersionInfoParcel(241199000, i, true, false));
    }

    public final zzco zzg(IObjectWrapper iObjectWrapper, int i) {
        return zzcik.zzb((Context) ObjectWrapper.unwrap(iObjectWrapper), (zzbqo) null, i).zzc();
    }

    public final zzdj zzh(IObjectWrapper iObjectWrapper, zzbqo zzbqo, int i) {
        return zzcik.zzb((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbqo, i).zzm();
    }

    public final zzbhi zzi(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return new zzdlu((FrameLayout) ObjectWrapper.unwrap(iObjectWrapper), (FrameLayout) ObjectWrapper.unwrap(iObjectWrapper2), 241199000);
    }

    public final zzbho zzj(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        return new zzdls((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    public final zzbma zzk(IObjectWrapper iObjectWrapper, zzbqo zzbqo, int i, zzblx zzblx) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzdvq zzk = zzcik.zzb(context, zzbqo, i).zzk();
        zzk.zzb(context);
        zzk.zza(zzblx);
        return zzk.zzc().zzd();
    }

    public final zzbui zzl(IObjectWrapper iObjectWrapper, zzbqo zzbqo, int i) {
        return zzcik.zzb((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbqo, i).zzn();
    }

    public final zzbup zzm(IObjectWrapper iObjectWrapper) {
        Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
        AdOverlayInfoParcel zza = AdOverlayInfoParcel.zza(activity.getIntent());
        if (zza == null) {
            return new zzu(activity);
        }
        int i = zza.zzk;
        if (i == 1) {
            return new zzt(activity);
        }
        if (i == 2) {
            return new zzaf(activity);
        }
        if (i == 3) {
            return new zzag(activity);
        }
        if (i != 4) {
            return i != 5 ? new zzu(activity) : new zzad(activity);
        }
        return new zzz(activity, zza);
    }

    public final zzbxt zzn(IObjectWrapper iObjectWrapper, zzbqo zzbqo, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzffg zzw = zzcik.zzb(context, zzbqo, i).zzw();
        zzw.zzb(context);
        return zzw.zzc().zzb();
    }

    public final zzbyj zzo(IObjectWrapper iObjectWrapper, String str, zzbqo zzbqo, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzffg zzw = zzcik.zzb(context, zzbqo, i).zzw();
        zzw.zzb(context);
        zzw.zza(str);
        return zzw.zzc().zza();
    }

    public final zzcap zzp(IObjectWrapper iObjectWrapper, zzbqo zzbqo, int i) {
        return zzcik.zzb((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbqo, i).zzq();
    }
}
