package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzayt extends zzazd {
    private List zzi = null;
    private final Context zzj;

    public zzayt(zzaxp zzaxp, String str, String str2, zzata zzata, int i, int i2, Context context) {
        super(zzaxp, "/W2ZEuHT/JiI5/Zhh6jV6ATrrvF8IBtmITl+4IJczntAr46Ow/LitCqqOR0RyWN9", "0yxvRSsGg+/BBPRqwe1F54W0T+vv1NRnE+jebtT36Vo=", zzata, i, 31);
        this.zzj = context;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zze.zzad(-1);
        this.zze.zzY(-1);
        Context context = this.zzj;
        if (context == null) {
            context = this.zzb.zzb();
        }
        if (this.zzi == null) {
            this.zzi = (List) this.zzf.invoke((Object) null, new Object[]{context});
        }
        List list = this.zzi;
        if (list != null && list.size() == 2) {
            synchronized (this.zze) {
                this.zze.zzad(((Long) this.zzi.get(0)).longValue());
                this.zze.zzY(((Long) this.zzi.get(1)).longValue());
            }
        }
    }
}
