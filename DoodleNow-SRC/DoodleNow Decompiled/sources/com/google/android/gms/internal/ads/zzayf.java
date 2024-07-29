package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzayf extends zzazd {
    private static volatile Long zzi;
    private static final Object zzj = new Object();

    public zzayf(zzaxp zzaxp, String str, String str2, zzata zzata, int i, int i2) {
        super(zzaxp, "KvkOAolI09ZSAixqGUOtipMDBdKXVlslzVnQOpfDZOEJW+xbFKrK173Gu3h1RVkI", "SkMlFTLt8H3eQLYvgf87g2pXBfp4xPpxL3RMs974XSU=", zzata, i, 44);
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        if (zzi == null) {
            synchronized (zzj) {
                if (zzi == null) {
                    zzi = (Long) this.zzf.invoke((Object) null, new Object[0]);
                }
            }
        }
        synchronized (this.zze) {
            this.zze.zzp(zzi.longValue());
        }
    }
}
