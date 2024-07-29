package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzayr extends zzazd {
    public zzayr(zzaxp zzaxp, String str, String str2, zzata zzata, int i, int i2) {
        super(zzaxp, "WfvM4SeNDVyFarUKUVpVTE2MRQkjnaN4GpgwC5lMrmyQkCennlTSSkgCAZvzOVXK", "Kq6mcF8LH4HqXGyg5/DR3VvLtDExNTPXoCRIPhkdOGM=", zzata, i, 3);
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        boolean booleanValue = ((Boolean) zzba.zzc().zza(zzbdz.zzcD)).booleanValue();
        zzawv zzawv = new zzawv((String) this.zzf.invoke((Object) null, new Object[]{this.zzb.zzb(), Boolean.valueOf(booleanValue)}));
        synchronized (this.zze) {
            this.zze.zzk(zzawv.zza);
            this.zze.zzH(zzawv.zzb);
        }
    }
}
