package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzbco implements Runnable {
    public final /* synthetic */ zzbcr zza;
    public final /* synthetic */ zzbci zzb;
    public final /* synthetic */ zzbcj zzc;
    public final /* synthetic */ zzcbw zzd;

    public /* synthetic */ zzbco(zzbcr zzbcr, zzbci zzbci, zzbcj zzbcj, zzcbw zzcbw) {
        this.zza = zzbcr;
        this.zzb = zzbci;
        this.zzc = zzbcj;
        this.zzd = zzcbw;
    }

    public final void run() {
        zzbcg zzbcg;
        zzbcr zzbcr = this.zza;
        zzbci zzbci = this.zzb;
        zzcbw zzcbw = this.zzd;
        try {
            zzbcl zzq = zzbci.zzq();
            boolean zzp = zzbci.zzp();
            zzbcj zzbcj = this.zzc;
            if (zzp) {
                zzbcg = zzq.zzg(zzbcj);
            } else {
                zzbcg = zzq.zzf(zzbcj);
            }
            if (!zzbcg.zze()) {
                zzcbw.zzd(new RuntimeException("No entry contents."));
                zzbct.zze(zzbcr.zzc);
                return;
            }
            zzbcq zzbcq = new zzbcq(zzbcr, zzbcg.zzc(), 1);
            int read = zzbcq.read();
            if (read != -1) {
                zzbcq.unread(read);
                zzcbw.zzc(zzbcv.zzb(zzbcq, zzbcg.zzd(), zzbcg.zzg(), zzbcg.zza(), zzbcg.zzf()));
                return;
            }
            throw new IOException("Unable to read from cache.");
        } catch (RemoteException | IOException e) {
            zzm.zzh("Unable to obtain a cache service instance.", e);
            zzcbw.zzd(e);
            zzbct.zze(zzbcr.zzc);
        }
    }
}
