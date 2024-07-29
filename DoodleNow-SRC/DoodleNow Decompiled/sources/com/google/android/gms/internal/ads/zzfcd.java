package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzfcd implements zzgdl {
    public final /* synthetic */ zzfcf zza;
    public final /* synthetic */ zzfif zzb;
    public final /* synthetic */ zzcvd zzc;

    public /* synthetic */ zzfcd(zzfcf zzfcf, zzfif zzfif, zzcvd zzcvd) {
        this.zza = zzfcf;
        this.zzb = zzfif;
        this.zzc = zzcvd;
    }

    public final ListenableFuture zza(Object obj) {
        zzffz zzffz = (zzffz) obj;
        this.zzb.zzb = zzffz;
        Iterator it = zzffz.zzb.zza.iterator();
        boolean z = false;
        loop0:
        while (true) {
            if (it.hasNext()) {
                Iterator it2 = ((zzffn) it.next()).zza.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (!((String) it2.next()).contains("FirstPartyRenderer")) {
                            break loop0;
                        }
                        z = true;
                    }
                }
            } else if (z) {
                return this.zzc.zzi(zzgee.zzh(zzffz));
            }
        }
        return zzgee.zzh((Object) null);
    }
}
