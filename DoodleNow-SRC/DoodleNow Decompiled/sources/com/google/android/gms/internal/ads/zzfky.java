package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.IBinder;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.zzu;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfky implements zzfkw {
    private final Context zza;
    /* access modifiers changed from: private */
    public final zzflo zzb;
    /* access modifiers changed from: private */
    public long zzc = 0;
    /* access modifiers changed from: private */
    public long zzd = -1;
    /* access modifiers changed from: private */
    public boolean zze = false;
    /* access modifiers changed from: private */
    public zzflq zzf = zzflq.FORMAT_UNKNOWN;
    /* access modifiers changed from: private */
    public zzfls zzg = zzfls.ORIENTATION_UNKNOWN;
    /* access modifiers changed from: private */
    public int zzh = 0;
    /* access modifiers changed from: private */
    public String zzi = "";
    /* access modifiers changed from: private */
    public String zzj = "";
    /* access modifiers changed from: private */
    public String zzk = "";
    /* access modifiers changed from: private */
    public String zzl = "";
    /* access modifiers changed from: private */
    public String zzm = "";
    /* access modifiers changed from: private */
    public String zzn = "";
    /* access modifiers changed from: private */
    public String zzo = "";
    private boolean zzp = false;
    private boolean zzq = false;

    zzfky(Context context, zzflo zzflo) {
        this.zza = context;
        this.zzb = zzflo;
    }

    public final /* bridge */ /* synthetic */ zzfkw zza(zze zze2) {
        zzq(zze2);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzfkw zzb(zzffy zzffy) {
        zzr(zzffy);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzfkw zzc(String str) {
        zzs(str);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzfkw zzd(zzflq zzflq) {
        zzt(zzflq);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzfkw zze(String str) {
        zzu(str);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzfkw zzf(String str) {
        zzv(str);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzfkw zzg(boolean z) {
        zzw(z);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzfkw zzh(Throwable th) {
        zzx(th);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzfkw zzi() {
        zzy();
        return this;
    }

    public final /* bridge */ /* synthetic */ zzfkw zzj() {
        zzz();
        return this;
    }

    public final synchronized boolean zzk() {
        return this.zzq;
    }

    public final boolean zzl() {
        return !TextUtils.isEmpty(this.zzk);
    }

    public final synchronized zzfla zzm() {
        if (this.zzp) {
            return null;
        }
        this.zzp = true;
        if (!this.zzq) {
            zzy();
        }
        if (this.zzd < 0) {
            zzz();
        }
        return new zzfla(this, (zzfkz) null);
    }

    public final synchronized zzfky zzq(zze zze2) {
        IBinder iBinder = zze2.zze;
        if (iBinder != null) {
            zzcyj zzcyj = (zzcyj) iBinder;
            String zzk2 = zzcyj.zzk();
            if (!TextUtils.isEmpty(zzk2)) {
                this.zzi = zzk2;
            }
            String zzi2 = zzcyj.zzi();
            if (!TextUtils.isEmpty(zzi2)) {
                this.zzj = zzi2;
            }
        }
        return this;
    }

    public final synchronized zzfky zzr(zzffy zzffy) {
        if (!TextUtils.isEmpty(zzffy.zzb.zzb)) {
            this.zzi = zzffy.zzb.zzb;
        }
        Iterator it = zzffy.zza.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            zzffn zzffn = (zzffn) it.next();
            if (!TextUtils.isEmpty(zzffn.zzac)) {
                this.zzj = zzffn.zzac;
                break;
            }
        }
        return this;
    }

    public final synchronized zzfky zzs(String str) {
        if (((Boolean) zzba.zzc().zza(zzbdz.zziJ)).booleanValue()) {
            this.zzo = str;
        }
        return this;
    }

    public final synchronized zzfky zzt(zzflq zzflq) {
        this.zzf = zzflq;
        return this;
    }

    public final synchronized zzfky zzu(String str) {
        this.zzk = str;
        return this;
    }

    public final synchronized zzfky zzv(String str) {
        this.zzl = str;
        return this;
    }

    public final synchronized zzfky zzw(boolean z) {
        this.zze = z;
        return this;
    }

    public final synchronized zzfky zzx(Throwable th) {
        if (((Boolean) zzba.zzc().zza(zzbdz.zziJ)).booleanValue()) {
            this.zzn = zzbvs.zze(th);
            this.zzm = (String) zzfxe.zzc(zzfwc.zzc(10)).zzd(zzbvs.zzd(th)).iterator().next();
        }
        return this;
    }

    public final synchronized zzfky zzy() {
        zzfls zzfls;
        this.zzh = zzu.zzq().zzm(this.zza);
        Resources resources = this.zza.getResources();
        if (resources == null) {
            zzfls = zzfls.ORIENTATION_UNKNOWN;
        } else {
            Configuration configuration = resources.getConfiguration();
            if (configuration == null) {
                zzfls = zzfls.ORIENTATION_UNKNOWN;
            } else if (configuration.orientation == 2) {
                zzfls = zzfls.ORIENTATION_LANDSCAPE;
            } else {
                zzfls = zzfls.ORIENTATION_PORTRAIT;
            }
        }
        this.zzg = zzfls;
        this.zzc = zzu.zzB().elapsedRealtime();
        this.zzq = true;
        return this;
    }

    public final synchronized zzfky zzz() {
        this.zzd = zzu.zzB().elapsedRealtime();
        return this;
    }
}
