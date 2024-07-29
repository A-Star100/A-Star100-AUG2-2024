package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzayz extends zzazd {
    public zzayz(zzaxp zzaxp, String str, String str2, zzata zzata, int i, int i2) {
        super(zzaxp, "5HcA415u1KU8m2yVlDZBhQQK+0IFNRmmWPxuAq0DnfPzSdJ/uWlnYMD1kKfkH6cZ", "u7Ufq5yuXkEXg69T8jpWuOOX55Q9g2DSVI1gtbNUvY8=", zzata, i, 48);
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zze.zzaa(zzaun.ENUM_FAILURE);
        boolean booleanValue = ((Boolean) this.zzf.invoke((Object) null, new Object[]{this.zzb.zzb()})).booleanValue();
        synchronized (this.zze) {
            if (booleanValue) {
                this.zze.zzaa(zzaun.ENUM_TRUE);
            } else {
                this.zze.zzaa(zzaun.ENUM_FALSE);
            }
        }
    }
}
