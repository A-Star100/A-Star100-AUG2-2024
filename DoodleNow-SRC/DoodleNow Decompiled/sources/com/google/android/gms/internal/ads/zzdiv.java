package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.collection.ArrayMap;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.ads.zzbdg;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdiv implements zzdae, zzp, zzczk {
    zzfmy zza;
    private final Context zzb;
    private final zzcgm zzc;
    private final zzffn zzd;
    private final VersionInfoParcel zze;
    private final zzbdg.zza.C0013zza zzf;

    public zzdiv(Context context, zzcgm zzcgm, zzffn zzffn, VersionInfoParcel versionInfoParcel, zzbdg.zza.C0013zza zza2) {
        this.zzb = context;
        this.zzc = zzcgm;
        this.zzd = zzffn;
        this.zze = versionInfoParcel;
        this.zzf = zza2;
    }

    public final void zzdH() {
    }

    public final void zzdk() {
    }

    public final void zzdq() {
    }

    public final void zzdr() {
        if (this.zza != null && this.zzc != null) {
            if (!((Boolean) zzba.zzc().zza(zzbdz.zzfb)).booleanValue()) {
                this.zzc.zzd("onSdkImpression", new ArrayMap());
            }
        }
    }

    public final void zzdt() {
    }

    public final void zzdu(int i) {
        this.zza = null;
    }

    public final void zzr() {
        if (this.zza != null && this.zzc != null) {
            if (((Boolean) zzba.zzc().zza(zzbdz.zzfb)).booleanValue()) {
                this.zzc.zzd("onSdkImpression", new ArrayMap());
            }
        }
    }

    public final void zzs() {
        zzegd zzegd;
        zzege zzege;
        zzege zzege2;
        zzbdg.zza.C0013zza zza2 = this.zzf;
        if ((zza2 == zzbdg.zza.C0013zza.REWARD_BASED_VIDEO_AD || zza2 == zzbdg.zza.C0013zza.INTERSTITIAL || zza2 == zzbdg.zza.C0013zza.APP_OPEN) && this.zzd.zzU && this.zzc != null) {
            if (zzu.zzA().zzj(this.zzb)) {
                VersionInfoParcel versionInfoParcel = this.zze;
                String str = versionInfoParcel.buddyApkVersion + "." + versionInfoParcel.clientJarVersion;
                zzfgl zzfgl = this.zzd.zzW;
                String zza3 = zzfgl.zza();
                if (zzfgl.zzb() == 1) {
                    zzegd = zzegd.VIDEO;
                    zzege = zzege.DEFINED_BY_JAVASCRIPT;
                } else {
                    if (this.zzd.zzZ == 2) {
                        zzege2 = zzege.UNSPECIFIED;
                    } else {
                        zzege2 = zzege.BEGIN_TO_RENDER;
                    }
                    zzege = zzege2;
                    zzegd = zzegd.HTML_DISPLAY;
                }
                zzfmy zza4 = zzu.zzA().zza(str, this.zzc.zzG(), "", "javascript", zza3, zzege, zzegd, this.zzd.zzam);
                this.zza = zza4;
                if (zza4 != null) {
                    zzu.zzA().zzh(this.zza, (View) this.zzc);
                    this.zzc.zzaq(this.zza);
                    zzu.zzA().zzi(this.zza);
                    this.zzc.zzd("onSdkLoaded", new ArrayMap());
                }
            }
        }
    }
}
