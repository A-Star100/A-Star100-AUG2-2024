package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcpw implements zzcyq, zzdae, zzczk, zza, zzczg, zzdge {
    /* access modifiers changed from: private */
    public final Context zza;
    private final Executor zzb;
    private final Executor zzc;
    private final ScheduledExecutorService zzd;
    /* access modifiers changed from: private */
    public final zzffz zze;
    /* access modifiers changed from: private */
    public final zzffn zzf;
    /* access modifiers changed from: private */
    public final zzfmp zzg;
    /* access modifiers changed from: private */
    public final zzfgu zzh;
    private final zzawo zzi;
    private final zzbfc zzj;
    private final zzflh zzk;
    private final WeakReference zzl;
    private final WeakReference zzm;
    private final zzcxs zzn;
    private boolean zzo;
    private final AtomicBoolean zzp = new AtomicBoolean();
    private final zzbfe zzq;

    zzcpw(Context context, Executor executor, Executor executor2, ScheduledExecutorService scheduledExecutorService, zzffz zzffz, zzffn zzffn, zzfmp zzfmp, zzfgu zzfgu, View view, zzcgm zzcgm, zzawo zzawo, zzbfc zzbfc, zzbfe zzbfe, zzflh zzflh, zzcxs zzcxs) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = executor2;
        this.zzd = scheduledExecutorService;
        this.zze = zzffz;
        this.zzf = zzffn;
        this.zzg = zzfmp;
        this.zzh = zzfgu;
        this.zzi = zzawo;
        View view2 = view;
        this.zzl = new WeakReference(view);
        zzcgm zzcgm2 = zzcgm;
        this.zzm = new WeakReference(zzcgm);
        this.zzj = zzbfc;
        this.zzq = zzbfe;
        this.zzk = zzflh;
        this.zzn = zzcxs;
    }

    /* access modifiers changed from: private */
    public final List zzu() {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzlb)).booleanValue()) {
            zzu.zzp();
            if (zzt.zzB(this.zza)) {
                zzu.zzp();
                Integer zzs = zzt.zzs(this.zza);
                if (zzs != null) {
                    Integer valueOf = Integer.valueOf(Math.min(zzs.intValue(), 20));
                    ArrayList arrayList = new ArrayList();
                    for (String parse : this.zzf.zzd) {
                        arrayList.add(Uri.parse(parse).buildUpon().appendQueryParameter("dspct", Integer.toString(valueOf.intValue())).toString());
                    }
                    return arrayList;
                }
            }
        }
        return this.zzf.zzd;
    }

    /* access modifiers changed from: private */
    public final void zzv() {
        String str;
        int i;
        List list = this.zzf.zzd;
        if (list != null && !list.isEmpty()) {
            if (((Boolean) zzba.zzc().zza(zzbdz.zzds)).booleanValue()) {
                str = this.zzi.zzc().zzh(this.zza, (View) this.zzl.get(), (Activity) null);
            } else {
                str = null;
            }
            if ((!((Boolean) zzba.zzc().zza(zzbdz.zzan)).booleanValue() || !this.zze.zzb.zzb.zzg) && ((Boolean) zzbfs.zzh.zze()).booleanValue()) {
                if (((Boolean) zzbfs.zzg.zze()).booleanValue() && ((i = this.zzf.zzb) == 1 || i == 2 || i == 5)) {
                    zzcgm zzcgm = (zzcgm) this.zzm.get();
                }
                zzgee.zzr((zzgdv) zzgee.zzo(zzgdv.zzu(zzgee.zzh((Object) null)), ((Long) zzba.zzc().zza(zzbdz.zzaV)).longValue(), TimeUnit.MILLISECONDS, this.zzd), new zzcpv(this, str), this.zzb);
                return;
            }
            this.zzh.zza(this.zzg.zzd(this.zze, this.zzf, false, str, (String) null, zzu()));
        }
    }

    private final void zzw(int i, int i2) {
        View view;
        if (i <= 0 || !((view = (View) this.zzl.get()) == null || view.getHeight() == 0 || view.getWidth() == 0)) {
            zzv();
        } else {
            this.zzd.schedule(new zzcpt(this, i, i2), (long) i2, TimeUnit.MILLISECONDS);
        }
    }

    public final void onAdClicked() {
        if ((!((Boolean) zzba.zzc().zza(zzbdz.zzan)).booleanValue() || !this.zze.zzb.zzb.zzg) && ((Boolean) zzbfs.zzd.zze()).booleanValue()) {
            zzgee.zzr(zzgee.zze(zzgdv.zzu(this.zzj.zza()), Throwable.class, zzcpq.zza, zzcbr.zzf), new zzcpu(this), this.zzb);
            return;
        }
        zzfgu zzfgu = this.zzh;
        zzfmp zzfmp = this.zzg;
        zzffz zzffz = this.zze;
        zzffn zzffn = this.zzf;
        Context context = this.zza;
        List zzc2 = zzfmp.zzc(zzffz, zzffn, zzffn.zzc);
        int i = 1;
        if (true == zzu.zzo().zzz(context)) {
            i = 2;
        }
        zzfgu.zzc(zzc2, i);
    }

    public final void zza() {
    }

    public final void zzb() {
    }

    public final void zzc() {
    }

    public final void zzds(zzbxq zzbxq, String str, String str2) {
        zzfmp zzfmp = this.zzg;
        zzffn zzffn = this.zzf;
        this.zzh.zza(zzfmp.zze(zzffn, zzffn.zzi, zzbxq));
    }

    public final void zze() {
        zzfmp zzfmp = this.zzg;
        zzffz zzffz = this.zze;
        zzffn zzffn = this.zzf;
        this.zzh.zza(zzfmp.zzc(zzffz, zzffn, zzffn.zzj));
    }

    public final void zzf() {
        zzfmp zzfmp = this.zzg;
        zzffz zzffz = this.zze;
        zzffn zzffn = this.zzf;
        this.zzh.zza(zzfmp.zzc(zzffz, zzffn, zzffn.zzh));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzn() {
        this.zzb.execute(new zzcps(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(int i, int i2) {
        zzw(i - 1, i2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp(int i, int i2) {
        this.zzb.execute(new zzcpr(this, i, i2));
    }

    public final void zzq(zze zze2) {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzbv)).booleanValue()) {
            this.zzh.zza(this.zzg.zzc(this.zze, this.zzf, zzfmp.zzf(2, zze2.zza, this.zzf.zzp)));
        }
    }

    public final void zzr() {
        if (this.zzp.compareAndSet(false, true)) {
            int intValue = ((Integer) zzba.zzc().zza(zzbdz.zzdB)).intValue();
            if (intValue > 0) {
                zzw(intValue, ((Integer) zzba.zzc().zza(zzbdz.zzdC)).intValue());
                return;
            }
            if (((Boolean) zzba.zzc().zza(zzbdz.zzdA)).booleanValue()) {
                this.zzc.execute(new zzcpp(this));
            } else {
                zzv();
            }
        }
    }

    public final synchronized void zzs() {
        zzcxs zzcxs;
        if (this.zzo) {
            ArrayList arrayList = new ArrayList(zzu());
            arrayList.addAll(this.zzf.zzg);
            this.zzh.zza(this.zzg.zzd(this.zze, this.zzf, true, (String) null, (String) null, arrayList));
        } else {
            zzfgu zzfgu = this.zzh;
            zzfmp zzfmp = this.zzg;
            zzffz zzffz = this.zze;
            zzffn zzffn = this.zzf;
            zzfgu.zza(zzfmp.zzc(zzffz, zzffn, zzffn.zzn));
            if (((Boolean) zzba.zzc().zza(zzbdz.zzdx)).booleanValue() && (zzcxs = this.zzn) != null) {
                List zzh2 = zzfmp.zzh(zzfmp.zzg(zzcxs.zzb().zzn, zzcxs.zza().zzg()), this.zzn.zza().zza());
                zzfgu zzfgu2 = this.zzh;
                zzfmp zzfmp2 = this.zzg;
                zzcxs zzcxs2 = this.zzn;
                zzfgu2.zza(zzfmp2.zzc(zzcxs2.zzc(), zzcxs2.zzb(), zzh2));
            }
            zzfgu zzfgu3 = this.zzh;
            zzfmp zzfmp3 = this.zzg;
            zzffz zzffz2 = this.zze;
            zzffn zzffn2 = this.zzf;
            zzfgu3.zza(zzfmp3.zzc(zzffz2, zzffn2, zzffn2.zzg));
        }
        this.zzo = true;
    }

    public final void zzt() {
        zzfmp zzfmp = this.zzg;
        zzffz zzffz = this.zze;
        zzffn zzffn = this.zzf;
        this.zzh.zza(zzfmp.zzc(zzffz, zzffn, zzffn.zzau));
    }
}
