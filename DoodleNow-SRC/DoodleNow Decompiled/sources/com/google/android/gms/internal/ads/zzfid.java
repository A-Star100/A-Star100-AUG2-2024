package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfid extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfid> CREATOR = new zzfie();
    @Nullable
    public final Context zza;
    public final zzfia zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final String zzf;
    public final int zzg;
    private final zzfia[] zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int[] zzl;
    private final int[] zzm;

    public zzfid(int i, int i2, int i3, int i4, String str, int i5, int i6) {
        zzfia[] values = zzfia.values();
        this.zzh = values;
        int[] zza2 = zzfib.zza();
        this.zzl = zza2;
        int[] zza3 = zzfic.zza();
        this.zzm = zza3;
        this.zza = null;
        this.zzi = i;
        this.zzb = values[i];
        this.zzc = i2;
        this.zzd = i3;
        this.zze = i4;
        this.zzf = str;
        this.zzj = i5;
        this.zzg = zza2[i5];
        this.zzk = i6;
        int i7 = zza3[i6];
    }

    @Nullable
    public static zzfid zza(zzfia zzfia, Context context) {
        if (zzfia == zzfia.Rewarded) {
            return new zzfid(context, zzfia, ((Integer) zzba.zzc().zza(zzbdz.zzgw)).intValue(), ((Integer) zzba.zzc().zza(zzbdz.zzgC)).intValue(), ((Integer) zzba.zzc().zza(zzbdz.zzgE)).intValue(), (String) zzba.zzc().zza(zzbdz.zzgG), (String) zzba.zzc().zza(zzbdz.zzgy), (String) zzba.zzc().zza(zzbdz.zzgA));
        } else if (zzfia == zzfia.Interstitial) {
            return new zzfid(context, zzfia, ((Integer) zzba.zzc().zza(zzbdz.zzgx)).intValue(), ((Integer) zzba.zzc().zza(zzbdz.zzgD)).intValue(), ((Integer) zzba.zzc().zza(zzbdz.zzgF)).intValue(), (String) zzba.zzc().zza(zzbdz.zzgH), (String) zzba.zzc().zza(zzbdz.zzgz), (String) zzba.zzc().zza(zzbdz.zzgB));
        } else if (zzfia != zzfia.AppOpen) {
            return null;
        } else {
            return new zzfid(context, zzfia, ((Integer) zzba.zzc().zza(zzbdz.zzgK)).intValue(), ((Integer) zzba.zzc().zza(zzbdz.zzgM)).intValue(), ((Integer) zzba.zzc().zza(zzbdz.zzgN)).intValue(), (String) zzba.zzc().zza(zzbdz.zzgI), (String) zzba.zzc().zza(zzbdz.zzgJ), (String) zzba.zzc().zza(zzbdz.zzgL));
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zzi;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        SafeParcelWriter.writeInt(parcel, 2, this.zzc);
        SafeParcelWriter.writeInt(parcel, 3, this.zzd);
        SafeParcelWriter.writeInt(parcel, 4, this.zze);
        SafeParcelWriter.writeString(parcel, 5, this.zzf, false);
        SafeParcelWriter.writeInt(parcel, 6, this.zzj);
        SafeParcelWriter.writeInt(parcel, 7, this.zzk);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    private zzfid(@Nullable Context context, zzfia zzfia, int i, int i2, int i3, String str, String str2, String str3) {
        int i4;
        this.zzh = zzfia.values();
        this.zzl = zzfib.zza();
        this.zzm = zzfic.zza();
        this.zza = context;
        this.zzi = zzfia.ordinal();
        this.zzb = zzfia;
        this.zzc = i;
        this.zzd = i2;
        this.zze = i3;
        this.zzf = str;
        if ("oldest".equals(str2)) {
            i4 = 1;
        } else if (!"lru".equals(str2) && "lfu".equals(str2)) {
            i4 = 3;
        } else {
            i4 = 2;
        }
        this.zzg = i4;
        this.zzj = i4 - 1;
        "onAdClosed".equals(str3);
        this.zzk = 0;
    }
}
