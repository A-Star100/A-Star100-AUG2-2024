package com.google.android.gms.internal.ads;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzayq extends zzazd {
    private static volatile String zzi;
    private static final Object zzj = new Object();

    public zzayq(zzaxp zzaxp, String str, String str2, zzata zzata, int i, int i2) {
        super(zzaxp, "+pOuZc4XP/KXmz3ZcR0Th/zrptiqFMKeADXdr6ffDtBODTAlpCvFIUU/DK0sXoAh", "l4qa5EABhdRHJHltXD4U8dy0wNZl4oyoZ9TbFONnMI4=", zzata, i, 1);
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zze.zzG(ExifInterface.LONGITUDE_EAST);
        if (zzi == null) {
            synchronized (zzj) {
                if (zzi == null) {
                    zzi = (String) this.zzf.invoke((Object) null, new Object[0]);
                }
            }
        }
        synchronized (this.zze) {
            this.zze.zzG(zzi);
        }
    }
}
