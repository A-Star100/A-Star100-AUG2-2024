package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzehu implements zzegp {
    private final Context zza;
    private final zzcsm zzb;
    /* access modifiers changed from: private */
    public View zzc;
    /* access modifiers changed from: private */
    public zzbqx zzd;

    public zzehu(Context context, zzcsm zzcsm) {
        this.zza = context;
        this.zzb = zzcsm;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzffz zzffz, zzffn zzffn, zzegm zzegm) throws zzfgp, zzekh {
        View view;
        if (!((Boolean) zzba.zzc().zza(zzbdz.zzhN)).booleanValue() || !zzffn.zzah) {
            view = this.zzc;
        } else {
            try {
                view = (View) ObjectWrapper.unwrap(this.zzd.zze());
                boolean zzf = this.zzd.zzf();
                if (view == null) {
                    throw new zzfgp(new Exception("BannerRtbAdapterWrapper interscrollerView should not be null"));
                } else if (zzf) {
                    try {
                        view = (View) zzgee.zzn(zzgee.zzh((Object) null), new zzehr(this, view, zzffn), zzcbr.zze).get();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new zzfgp(e);
                    }
                }
            } catch (RemoteException e2) {
                throw new zzfgp(e2);
            }
        }
        zzcrn zza2 = this.zzb.zza(new zzcul(zzffz, zzffn, zzegm.zza), new zzcrt(view, (zzcgm) null, new zzehq(zzegm), (zzffo) zzffn.zzv.get(0)));
        zza2.zzg().zza(view);
        ((zzeif) zzegm.zzc).zzc(zza2.zzi());
        return zza2.zza();
    }

    public final void zzb(zzffz zzffz, zzffn zzffn, zzegm zzegm) throws zzfgp {
        try {
            ((zzbsn) zzegm.zzb).zzq(zzffn.zzaa);
            if (!((Boolean) zzba.zzc().zza(zzbdz.zzhN)).booleanValue() || !zzffn.zzah) {
                ((zzbsn) zzegm.zzb).zzj(zzffn.zzV, zzffn.zzw.toString(), zzffz.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzeht(this, zzegm, (zzehs) null), (zzbqu) zzegm.zzc, zzffz.zza.zza.zze);
            } else {
                ((zzbsn) zzegm.zzb).zzk(zzffn.zzV, zzffn.zzw.toString(), zzffz.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzeht(this, zzegm, (zzehs) null), (zzbqu) zzegm.zzc, zzffz.zza.zza.zze);
            }
        } catch (RemoteException e) {
            throw new zzfgp(e);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(View view, zzffn zzffn, Object obj) throws Exception {
        return zzgee.zzh(zzcth.zza(this.zza, view, zzffn));
    }
}
