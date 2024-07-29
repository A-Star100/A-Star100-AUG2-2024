package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.ads.internal.client.zzcb;
import com.google.android.gms.ads.internal.client.zzcf;
import com.google.android.gms.ads.internal.client.zzfk;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfgg {
    /* access modifiers changed from: private */
    public zzl zza;
    /* access modifiers changed from: private */
    public zzq zzb;
    /* access modifiers changed from: private */
    public String zzc;
    /* access modifiers changed from: private */
    public zzfk zzd;
    /* access modifiers changed from: private */
    public boolean zze;
    /* access modifiers changed from: private */
    public ArrayList zzf;
    /* access modifiers changed from: private */
    public ArrayList zzg;
    /* access modifiers changed from: private */
    public zzbgt zzh;
    /* access modifiers changed from: private */
    public zzw zzi;
    /* access modifiers changed from: private */
    public AdManagerAdViewOptions zzj;
    /* access modifiers changed from: private */
    public PublisherAdViewOptions zzk;
    /* access modifiers changed from: private */
    public zzcb zzl;
    /* access modifiers changed from: private */
    public int zzm = 1;
    /* access modifiers changed from: private */
    public zzbni zzn;
    /* access modifiers changed from: private */
    public final zzfft zzo = new zzfft();
    /* access modifiers changed from: private */
    public boolean zzp = false;
    /* access modifiers changed from: private */
    public zzeoa zzq;
    /* access modifiers changed from: private */
    public boolean zzr = false;
    /* access modifiers changed from: private */
    public Bundle zzs;
    /* access modifiers changed from: private */
    public zzcf zzt;

    public final zzfgg zzA(boolean z) {
        this.zze = z;
        return this;
    }

    public final zzfgg zzB(int i) {
        this.zzm = i;
        return this;
    }

    public final zzfgg zzC(zzbgt zzbgt) {
        this.zzh = zzbgt;
        return this;
    }

    public final zzfgg zzD(ArrayList arrayList) {
        this.zzf = arrayList;
        return this;
    }

    public final zzfgg zzE(ArrayList arrayList) {
        this.zzg = arrayList;
        return this;
    }

    public final zzfgg zzF(PublisherAdViewOptions publisherAdViewOptions) {
        this.zzk = publisherAdViewOptions;
        if (publisherAdViewOptions != null) {
            this.zze = publisherAdViewOptions.zzc();
            this.zzl = publisherAdViewOptions.zza();
        }
        return this;
    }

    public final zzfgg zzG(zzl zzl2) {
        this.zza = zzl2;
        return this;
    }

    public final zzfgg zzH(zzfk zzfk) {
        this.zzd = zzfk;
        return this;
    }

    public final zzfgi zzI() {
        Preconditions.checkNotNull(this.zzc, "ad unit must not be null");
        Preconditions.checkNotNull(this.zzb, "ad size must not be null");
        Preconditions.checkNotNull(this.zza, "ad request must not be null");
        return new zzfgi(this, (zzfgh) null);
    }

    public final String zzK() {
        return this.zzc;
    }

    public final boolean zzQ() {
        return this.zzp;
    }

    public final zzfgg zzS(zzcf zzcf) {
        this.zzt = zzcf;
        return this;
    }

    public final zzl zzf() {
        return this.zza;
    }

    public final zzq zzh() {
        return this.zzb;
    }

    public final zzfft zzp() {
        return this.zzo;
    }

    public final zzfgg zzq(zzfgi zzfgi) {
        this.zzo.zza(zzfgi.zzo.zza);
        this.zza = zzfgi.zzd;
        this.zzb = zzfgi.zze;
        this.zzt = zzfgi.zzs;
        this.zzc = zzfgi.zzf;
        this.zzd = zzfgi.zza;
        this.zzf = zzfgi.zzg;
        this.zzg = zzfgi.zzh;
        this.zzh = zzfgi.zzi;
        this.zzi = zzfgi.zzj;
        zzr(zzfgi.zzl);
        zzF(zzfgi.zzm);
        this.zzp = zzfgi.zzp;
        this.zzq = zzfgi.zzc;
        this.zzr = zzfgi.zzq;
        this.zzs = zzfgi.zzr;
        return this;
    }

    public final zzfgg zzr(AdManagerAdViewOptions adManagerAdViewOptions) {
        this.zzj = adManagerAdViewOptions;
        if (adManagerAdViewOptions != null) {
            this.zze = adManagerAdViewOptions.getManualImpressionsEnabled();
        }
        return this;
    }

    public final zzfgg zzs(zzq zzq2) {
        this.zzb = zzq2;
        return this;
    }

    public final zzfgg zzt(String str) {
        this.zzc = str;
        return this;
    }

    public final zzfgg zzu(zzw zzw) {
        this.zzi = zzw;
        return this;
    }

    public final zzfgg zzv(zzeoa zzeoa) {
        this.zzq = zzeoa;
        return this;
    }

    public final zzfgg zzw(zzbni zzbni) {
        this.zzn = zzbni;
        this.zzd = new zzfk(false, true, false);
        return this;
    }

    public final zzfgg zzx(boolean z) {
        this.zzp = z;
        return this;
    }

    public final zzfgg zzy(boolean z) {
        this.zzr = true;
        return this;
    }

    public final zzfgg zzz(Bundle bundle) {
        this.zzs = bundle;
        return this;
    }
}
