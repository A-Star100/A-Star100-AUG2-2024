package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzayg extends zzazd {
    private final long zzi;

    public zzayg(zzaxp zzaxp, String str, String str2, zzata zzata, long j, int i, int i2) {
        super(zzaxp, "Rx5KxmHu63h8QT7T4cYR2mu7F4LQnYkocG/Azb9HP8ZHyjUHnRxxCuB99BIp3kbl", "3fysZeGzwX+hqd2f4+qtlSho+oF+DeFl9kzKrTFOSWo=", zzata, i, 25);
        this.zzi = j;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.zzf.invoke((Object) null, new Object[0])).longValue();
        synchronized (this.zze) {
            this.zze.zzv(longValue);
            long j = this.zzi;
            if (j != 0) {
                this.zze.zzZ(longValue - j);
                this.zze.zzab(this.zzi);
            }
        }
    }
}
