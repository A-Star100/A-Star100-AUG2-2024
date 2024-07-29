package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzayn extends zzazd {
    private final zzaxh zzi;

    public zzayn(zzaxp zzaxp, String str, String str2, zzata zzata, int i, int i2, zzaxh zzaxh) {
        super(zzaxp, "QcEEfK1PwFv2Eb+NZQ+4kWKAUUVvycYqoBzmAjBexJV/sKEjaFlajeD5MAZYWXy5", "361aY1ErIwpwsXwpamiiDSCpkl/IcdBM93dd8sW9a/Y=", zzata, i, 94);
        this.zzi = zzaxh;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        int intValue = ((Integer) this.zzf.invoke((Object) null, new Object[]{this.zzi.zza()})).intValue();
        synchronized (this.zze) {
            this.zze.zzD(zzats.zzb(intValue));
        }
    }
}
