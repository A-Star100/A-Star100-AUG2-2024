package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzcb;
import com.google.android.gms.ads.internal.client.zzcf;
import com.google.android.gms.ads.internal.client.zzfk;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.util.zzt;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfgi {
    public final zzfk zza;
    public final zzbni zzb;
    public final zzeoa zzc;
    public final zzl zzd;
    public final zzq zze;
    public final String zzf;
    public final ArrayList zzg;
    public final ArrayList zzh;
    public final zzbgt zzi;
    public final zzw zzj;
    public final int zzk;
    public final AdManagerAdViewOptions zzl;
    public final PublisherAdViewOptions zzm;
    public final zzcb zzn;
    public final zzffv zzo;
    public final boolean zzp;
    public final boolean zzq;
    public final Bundle zzr;
    public final zzcf zzs;

    /* synthetic */ zzfgi(zzfgg zzfgg, zzfgh zzfgh) {
        zzfk zzfk;
        zzbgt zzbgt;
        this.zze = zzfgg.zzb;
        this.zzf = zzfgg.zzc;
        this.zzs = zzfgg.zzt;
        int i = zzfgg.zza.zza;
        long j = zzfgg.zza.zzb;
        Bundle bundle = zzfgg.zza.zzc;
        int i2 = zzfgg.zza.zzd;
        List list = zzfgg.zza.zze;
        boolean z = zzfgg.zza.zzf;
        int i3 = zzfgg.zza.zzg;
        boolean z2 = true;
        if (!zzfgg.zza.zzh && !zzfgg.zze) {
            z2 = false;
        }
        this.zzd = new zzl(i, j, bundle, i2, list, z, i3, z2, zzfgg.zza.zzi, zzfgg.zza.zzj, zzfgg.zza.zzk, zzfgg.zza.zzl, zzfgg.zza.zzm, zzfgg.zza.zzn, zzfgg.zza.zzo, zzfgg.zza.zzp, zzfgg.zza.zzq, zzfgg.zza.zzr, zzfgg.zza.zzs, zzfgg.zza.zzt, zzfgg.zza.zzu, zzfgg.zza.zzv, zzt.zza(zzfgg.zza.zzw), zzfgg.zza.zzx, zzfgg.zza.zzy, zzfgg.zza.zzz);
        if (zzfgg.zzd != null) {
            zzfk = zzfgg.zzd;
        } else {
            zzfk = zzfgg.zzh != null ? zzfgg.zzh.zzf : null;
        }
        this.zza = zzfk;
        this.zzg = zzfgg.zzf;
        this.zzh = zzfgg.zzg;
        if (zzfgg.zzf == null) {
            zzbgt = null;
        } else {
            zzbgt = zzfgg.zzh == null ? new zzbgt(new NativeAdOptions.Builder().build()) : zzfgg.zzh;
        }
        this.zzi = zzbgt;
        this.zzj = zzfgg.zzi;
        this.zzk = zzfgg.zzm;
        this.zzl = zzfgg.zzj;
        this.zzm = zzfgg.zzk;
        this.zzn = zzfgg.zzl;
        this.zzb = zzfgg.zzn;
        this.zzo = new zzffv(zzfgg.zzo, (zzffu) null);
        this.zzp = zzfgg.zzp;
        this.zzc = zzfgg.zzq;
        this.zzq = zzfgg.zzr;
        this.zzr = zzfgg.zzs;
    }

    public final zzbiv zza() {
        PublisherAdViewOptions publisherAdViewOptions = this.zzm;
        if (publisherAdViewOptions == null && this.zzl == null) {
            return null;
        }
        if (publisherAdViewOptions != null) {
            return publisherAdViewOptions.zzb();
        }
        return this.zzl.zza();
    }

    public final boolean zzb() {
        zzbdq zzbdq = zzbdz.zzcZ;
        return this.zzf.matches((String) zzba.zzc().zza(zzbdq));
    }
}
