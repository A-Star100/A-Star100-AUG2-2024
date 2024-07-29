package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdpf extends zzbhx {
    private final Context zza;
    private final zzdky zzb;
    private zzdly zzc;
    /* access modifiers changed from: private */
    public zzdkt zzd;

    public zzdpf(Context context, zzdky zzdky, zzdly zzdly, zzdkt zzdkt) {
        this.zza = context;
        this.zzb = zzdky;
        this.zzc = zzdly;
        this.zzd = zzdkt;
    }

    private final zzbgs zzd(String str) {
        return new zzdpe(this, NativeCustomFormatAd.ASSET_NAME_VIDEO);
    }

    public final zzdq zze() {
        return this.zzb.zzj();
    }

    public final zzbhb zzf() throws RemoteException {
        try {
            return this.zzd.zzc().zza();
        } catch (NullPointerException e) {
            zzu.zzo().zzw(e, "InternalNativeCustomTemplateAdShim.getMediaContent");
            return null;
        }
    }

    public final zzbhe zzg(String str) {
        return (zzbhe) this.zzb.zzh().get(str);
    }

    public final IObjectWrapper zzh() {
        return ObjectWrapper.wrap(this.zza);
    }

    public final String zzi() {
        return this.zzb.zzA();
    }

    public final String zzj(String str) {
        return (String) this.zzb.zzi().get(str);
    }

    public final List zzk() {
        try {
            SimpleArrayMap zzh = this.zzb.zzh();
            SimpleArrayMap zzi = this.zzb.zzi();
            String[] strArr = new String[(zzh.size() + zzi.size())];
            int i = 0;
            for (int i2 = 0; i2 < zzh.size(); i2++) {
                strArr[i] = (String) zzh.keyAt(i2);
                i++;
            }
            for (int i3 = 0; i3 < zzi.size(); i3++) {
                strArr[i] = (String) zzi.keyAt(i3);
                i++;
            }
            return Arrays.asList(strArr);
        } catch (NullPointerException e) {
            zzu.zzo().zzw(e, "InternalNativeCustomTemplateAdShim.getAvailableAssetNames");
            return new ArrayList();
        }
    }

    public final void zzl() {
        zzdkt zzdkt = this.zzd;
        if (zzdkt != null) {
            zzdkt.zzb();
        }
        this.zzd = null;
        this.zzc = null;
    }

    public final void zzm() {
        try {
            String zzC = this.zzb.zzC();
            if (Objects.equals(zzC, "Google")) {
                zzm.zzj("Illegal argument specified for omid partner name.");
            } else if (TextUtils.isEmpty(zzC)) {
                zzm.zzj("Not starting OMID session. OM partner name has not been configured.");
            } else {
                zzdkt zzdkt = this.zzd;
                if (zzdkt != null) {
                    zzdkt.zzf(zzC, false);
                }
            }
        } catch (NullPointerException e) {
            zzu.zzo().zzw(e, "InternalNativeCustomTemplateAdShim.initializeDisplayOpenMeasurement");
        }
    }

    public final void zzn(String str) {
        zzdkt zzdkt = this.zzd;
        if (zzdkt != null) {
            zzdkt.zzE(str);
        }
    }

    public final void zzo() {
        zzdkt zzdkt = this.zzd;
        if (zzdkt != null) {
            zzdkt.zzH();
        }
    }

    public final void zzp(IObjectWrapper iObjectWrapper) {
        zzdkt zzdkt;
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if ((unwrap instanceof View) && this.zzb.zzu() != null && (zzdkt = this.zzd) != null) {
            zzdkt.zzI((View) unwrap);
        }
    }

    public final boolean zzq() {
        zzdkt zzdkt = this.zzd;
        if ((zzdkt == null || zzdkt.zzV()) && this.zzb.zzr() != null && this.zzb.zzs() == null) {
            return true;
        }
        return false;
    }

    public final boolean zzr(IObjectWrapper iObjectWrapper) {
        zzdly zzdly;
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof ViewGroup) || (zzdly = this.zzc) == null || !zzdly.zzf((ViewGroup) unwrap)) {
            return false;
        }
        this.zzb.zzq().zzap(zzd(NativeCustomFormatAd.ASSET_NAME_VIDEO));
        return true;
    }

    public final boolean zzs(IObjectWrapper iObjectWrapper) {
        zzdly zzdly;
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof ViewGroup) || (zzdly = this.zzc) == null || !zzdly.zzg((ViewGroup) unwrap)) {
            return false;
        }
        this.zzb.zzs().zzap(zzd(NativeCustomFormatAd.ASSET_NAME_VIDEO));
        return true;
    }

    public final boolean zzt() {
        zzfmy zzu = this.zzb.zzu();
        if (zzu != null) {
            zzu.zzA().zzi(zzu);
            if (this.zzb.zzr() == null) {
                return true;
            }
            this.zzb.zzr().zzd("onSdkLoaded", new ArrayMap());
            return true;
        }
        zzm.zzj("Trying to start OMID session before creation.");
        return false;
    }
}
