package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbdz;
import com.google.android.gms.internal.ads.zzbjo;
import com.google.android.gms.internal.ads.zzbjq;
import com.google.android.gms.internal.ads.zzbui;
import com.google.android.gms.internal.ads.zzcgm;
import com.google.android.gms.internal.ads.zzczd;
import com.google.android.gms.internal.ads.zzdgn;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class AdOverlayInfoParcel extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<AdOverlayInfoParcel> CREATOR = new zzo();
    public final zzc zza;
    public final zza zzb;
    public final zzp zzc;
    public final zzcgm zzd;
    public final zzbjq zze;
    public final String zzf;
    public final boolean zzg;
    public final String zzh;
    public final zzaa zzi;
    public final int zzj;
    public final int zzk;
    public final String zzl;
    public final VersionInfoParcel zzm;
    public final String zzn;
    public final zzk zzo;
    public final zzbjo zzp;
    public final String zzq;
    public final String zzr;
    public final String zzs;
    public final zzczd zzt;
    public final zzdgn zzu;
    public final zzbui zzv;
    public final boolean zzw;

    public AdOverlayInfoParcel(zza zza2, zzp zzp2, zzbjo zzbjo, zzbjq zzbjq, zzaa zzaa, zzcgm zzcgm, boolean z, int i, String str, VersionInfoParcel versionInfoParcel, zzdgn zzdgn, zzbui zzbui, boolean z2) {
        this.zza = null;
        this.zzb = zza2;
        this.zzc = zzp2;
        this.zzd = zzcgm;
        this.zzp = zzbjo;
        this.zze = zzbjq;
        this.zzf = null;
        this.zzg = z;
        this.zzh = null;
        this.zzi = zzaa;
        this.zzj = i;
        this.zzk = 3;
        this.zzl = str;
        this.zzm = versionInfoParcel;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = zzdgn;
        this.zzv = zzbui;
        this.zzw = z2;
    }

    public static AdOverlayInfoParcel zza(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception unused) {
            return null;
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        zzc zzc2 = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, zzc2, i, false);
        SafeParcelWriter.writeIBinder(parcel, 3, ObjectWrapper.wrap(this.zzb).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 4, ObjectWrapper.wrap(this.zzc).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 5, ObjectWrapper.wrap(this.zzd).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 6, ObjectWrapper.wrap(this.zze).asBinder(), false);
        SafeParcelWriter.writeString(parcel, 7, this.zzf, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzg);
        SafeParcelWriter.writeString(parcel, 9, this.zzh, false);
        SafeParcelWriter.writeIBinder(parcel, 10, ObjectWrapper.wrap(this.zzi).asBinder(), false);
        SafeParcelWriter.writeInt(parcel, 11, this.zzj);
        SafeParcelWriter.writeInt(parcel, 12, this.zzk);
        SafeParcelWriter.writeString(parcel, 13, this.zzl, false);
        SafeParcelWriter.writeParcelable(parcel, 14, this.zzm, i, false);
        SafeParcelWriter.writeString(parcel, 16, this.zzn, false);
        SafeParcelWriter.writeParcelable(parcel, 17, this.zzo, i, false);
        SafeParcelWriter.writeIBinder(parcel, 18, ObjectWrapper.wrap(this.zzp).asBinder(), false);
        SafeParcelWriter.writeString(parcel, 19, this.zzq, false);
        SafeParcelWriter.writeString(parcel, 24, this.zzr, false);
        SafeParcelWriter.writeString(parcel, 25, this.zzs, false);
        SafeParcelWriter.writeIBinder(parcel, 26, ObjectWrapper.wrap(this.zzt).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 27, ObjectWrapper.wrap(this.zzu).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 28, ObjectWrapper.wrap(this.zzv).asBinder(), false);
        SafeParcelWriter.writeBoolean(parcel, 29, this.zzw);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public AdOverlayInfoParcel(zza zza2, zzp zzp2, zzbjo zzbjo, zzbjq zzbjq, zzaa zzaa, zzcgm zzcgm, boolean z, int i, String str, String str2, VersionInfoParcel versionInfoParcel, zzdgn zzdgn, zzbui zzbui) {
        this.zza = null;
        this.zzb = zza2;
        this.zzc = zzp2;
        this.zzd = zzcgm;
        this.zzp = zzbjo;
        this.zze = zzbjq;
        this.zzf = str2;
        this.zzg = z;
        this.zzh = str;
        this.zzi = zzaa;
        this.zzj = i;
        this.zzk = 3;
        this.zzl = null;
        this.zzm = versionInfoParcel;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = zzdgn;
        this.zzv = zzbui;
        this.zzw = false;
    }

    public AdOverlayInfoParcel(zza zza2, zzp zzp2, zzaa zzaa, zzcgm zzcgm, int i, VersionInfoParcel versionInfoParcel, String str, zzk zzk2, String str2, String str3, String str4, zzczd zzczd, zzbui zzbui) {
        this.zza = null;
        this.zzb = null;
        this.zzc = zzp2;
        this.zzd = zzcgm;
        this.zzp = null;
        this.zze = null;
        this.zzg = false;
        if (((Boolean) zzba.zzc().zza(zzbdz.zzaI)).booleanValue()) {
            this.zzf = null;
            this.zzh = null;
        } else {
            this.zzf = str2;
            this.zzh = str3;
        }
        this.zzi = null;
        this.zzj = i;
        this.zzk = 1;
        this.zzl = null;
        this.zzm = versionInfoParcel;
        this.zzn = str;
        this.zzo = zzk2;
        this.zzq = null;
        this.zzr = null;
        this.zzs = str4;
        this.zzt = zzczd;
        this.zzu = null;
        this.zzv = zzbui;
        this.zzw = false;
    }

    public AdOverlayInfoParcel(zza zza2, zzp zzp2, zzaa zzaa, zzcgm zzcgm, boolean z, int i, VersionInfoParcel versionInfoParcel, zzdgn zzdgn, zzbui zzbui) {
        this.zza = null;
        this.zzb = zza2;
        this.zzc = zzp2;
        this.zzd = zzcgm;
        this.zzp = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = z;
        this.zzh = null;
        this.zzi = zzaa;
        this.zzj = i;
        this.zzk = 2;
        this.zzl = null;
        this.zzm = versionInfoParcel;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = zzdgn;
        this.zzv = zzbui;
        this.zzw = false;
    }

    AdOverlayInfoParcel(zzc zzc2, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4, String str, boolean z, String str2, IBinder iBinder5, int i, int i2, String str3, VersionInfoParcel versionInfoParcel, String str4, zzk zzk2, IBinder iBinder6, String str5, String str6, String str7, IBinder iBinder7, IBinder iBinder8, IBinder iBinder9, boolean z2) {
        this.zza = zzc2;
        this.zzb = (zza) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder));
        this.zzc = (zzp) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder2));
        this.zzd = (zzcgm) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder3));
        this.zzp = (zzbjo) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder6));
        this.zze = (zzbjq) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder4));
        this.zzf = str;
        this.zzg = z;
        this.zzh = str2;
        this.zzi = (zzaa) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder5));
        this.zzj = i;
        this.zzk = i2;
        this.zzl = str3;
        this.zzm = versionInfoParcel;
        this.zzn = str4;
        this.zzo = zzk2;
        this.zzq = str5;
        this.zzr = str6;
        this.zzs = str7;
        this.zzt = (zzczd) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder7));
        this.zzu = (zzdgn) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder8));
        this.zzv = (zzbui) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder9));
        this.zzw = z2;
    }

    public AdOverlayInfoParcel(zzc zzc2, zza zza2, zzp zzp2, zzaa zzaa, VersionInfoParcel versionInfoParcel, zzcgm zzcgm, zzdgn zzdgn) {
        this.zza = zzc2;
        this.zzb = zza2;
        this.zzc = zzp2;
        this.zzd = zzcgm;
        this.zzp = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = false;
        this.zzh = null;
        this.zzi = zzaa;
        this.zzj = -1;
        this.zzk = 4;
        this.zzl = null;
        this.zzm = versionInfoParcel;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = zzdgn;
        this.zzv = null;
        this.zzw = false;
    }

    public AdOverlayInfoParcel(zzp zzp2, zzcgm zzcgm, int i, VersionInfoParcel versionInfoParcel) {
        this.zzc = zzp2;
        this.zzd = zzcgm;
        this.zzj = 1;
        this.zzm = versionInfoParcel;
        this.zza = null;
        this.zzb = null;
        this.zzp = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = false;
        this.zzh = null;
        this.zzi = null;
        this.zzk = 1;
        this.zzl = null;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
        this.zzv = null;
        this.zzw = false;
    }

    public AdOverlayInfoParcel(zzcgm zzcgm, VersionInfoParcel versionInfoParcel, String str, String str2, int i, zzbui zzbui) {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        this.zzd = zzcgm;
        this.zzp = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = false;
        this.zzh = null;
        this.zzi = null;
        this.zzj = 14;
        this.zzk = 5;
        this.zzl = null;
        this.zzm = versionInfoParcel;
        this.zzn = null;
        this.zzo = null;
        this.zzq = str;
        this.zzr = str2;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
        this.zzv = zzbui;
        this.zzw = false;
    }
}
