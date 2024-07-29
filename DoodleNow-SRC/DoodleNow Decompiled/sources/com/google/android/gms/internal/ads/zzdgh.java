package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdgh extends zzdee implements zzazy {
    private final Map zzb = new WeakHashMap(1);
    private final Context zzc;
    private final zzffn zzd;

    public zzdgh(Context context, Set set, zzffn zzffn) {
        super(set);
        this.zzc = context;
        this.zzd = zzffn;
    }

    public final synchronized void zza(View view) {
        zzazz zzazz = (zzazz) this.zzb.get(view);
        if (zzazz == null) {
            zzazz zzazz2 = new zzazz(this.zzc, view);
            zzazz2.zzc(this);
            this.zzb.put(view, zzazz2);
            zzazz = zzazz2;
        }
        if (this.zzd.zzY) {
            if (((Boolean) zzba.zzc().zza(zzbdz.zzbo)).booleanValue()) {
                zzazz.zzg(((Long) zzba.zzc().zza(zzbdz.zzbn)).longValue());
                return;
            }
        }
        zzazz.zzf();
    }

    public final synchronized void zzb(View view) {
        if (this.zzb.containsKey(view)) {
            ((zzazz) this.zzb.get(view)).zze(this);
            this.zzb.remove(view);
        }
    }

    public final synchronized void zzdp(zzazx zzazx) {
        zzq(new zzdgg(zzazx));
    }
}
