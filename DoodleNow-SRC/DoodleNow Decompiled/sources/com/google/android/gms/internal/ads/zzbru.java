package com.google.android.gms.internal.ads;

import android.location.Location;
import androidx.exifinterface.media.ExifInterface;
import com.amazon.a.a.o.b;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.internal.client.zzej;
import com.google.android.gms.ads.internal.client.zzfk;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.revenuecat.purchases.common.Constants;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbru implements NativeMediationAdRequest {
    private final Date zza;
    private final int zzb;
    private final Set zzc;
    private final boolean zzd;
    private final Location zze;
    private final int zzf;
    private final zzbgt zzg;
    private final List zzh = new ArrayList();
    private final boolean zzi;
    private final Map zzj = new HashMap();
    private final String zzk;

    public zzbru(Date date, int i, Set set, Location location, boolean z, int i2, zzbgt zzbgt, List list, boolean z2, int i3, String str) {
        this.zza = date;
        this.zzb = i;
        this.zzc = set;
        this.zze = location;
        this.zzd = z;
        this.zzf = i2;
        this.zzg = zzbgt;
        this.zzi = z2;
        this.zzk = str;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (str2.startsWith("custom:")) {
                    String[] split = str2.split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, 3);
                    if (split.length == 3) {
                        if (b.ac.equals(split[2])) {
                            this.zzj.put(split[1], true);
                        } else if ("false".equals(split[2])) {
                            this.zzj.put(split[1], false);
                        }
                    }
                } else {
                    this.zzh.add(str2);
                }
            }
        }
    }

    public final float getAdVolume() {
        return zzej.zzf().zza();
    }

    @Deprecated
    public final Date getBirthday() {
        return this.zza;
    }

    @Deprecated
    public final int getGender() {
        return this.zzb;
    }

    public final Set<String> getKeywords() {
        return this.zzc;
    }

    public final Location getLocation() {
        return this.zze;
    }

    public final NativeAdOptions getNativeAdOptions() {
        NativeAdOptions.Builder builder = new NativeAdOptions.Builder();
        zzbgt zzbgt = this.zzg;
        if (zzbgt == null) {
            return builder.build();
        }
        int i = zzbgt.zza;
        if (i != 2) {
            if (i != 3) {
                if (i == 4) {
                    builder.setRequestCustomMuteThisAd(zzbgt.zzg);
                    builder.setMediaAspectRatio(zzbgt.zzh);
                }
                builder.setReturnUrlsForImageAssets(zzbgt.zzb);
                builder.setImageOrientation(zzbgt.zzc);
                builder.setRequestMultipleImages(zzbgt.zzd);
                return builder.build();
            }
            zzfk zzfk = zzbgt.zzf;
            if (zzfk != null) {
                builder.setVideoOptions(new VideoOptions(zzfk));
            }
        }
        builder.setAdChoicesPlacement(zzbgt.zze);
        builder.setReturnUrlsForImageAssets(zzbgt.zzb);
        builder.setImageOrientation(zzbgt.zzc);
        builder.setRequestMultipleImages(zzbgt.zzd);
        return builder.build();
    }

    public final com.google.android.gms.ads.nativead.NativeAdOptions getNativeAdRequestOptions() {
        return zzbgt.zza(this.zzg);
    }

    public final boolean isAdMuted() {
        return zzej.zzf().zzw();
    }

    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.zzi;
    }

    public final boolean isTesting() {
        return this.zzd;
    }

    public final boolean isUnifiedNativeAdRequested() {
        return this.zzh.contains("6");
    }

    public final int taggedForChildDirectedTreatment() {
        return this.zzf;
    }

    public final Map zza() {
        return this.zzj;
    }

    public final boolean zzb() {
        return this.zzh.contains(ExifInterface.GPS_MEASUREMENT_3D);
    }
}
