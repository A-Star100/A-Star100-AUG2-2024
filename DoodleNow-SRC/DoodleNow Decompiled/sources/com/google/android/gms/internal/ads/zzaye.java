package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzaye extends zzazd {
    public zzaye(zzaxp zzaxp, String str, String str2, zzata zzata, int i, int i2) {
        super(zzaxp, "2/TrxXzdli4Us4FPDPyGZmc5MrxtH8QgmFF/OAjS44SLVVLbzYRftaNDX3sVzVmu", "9ObkV+9nuY0gPBNLH25GoxM7YATuF1pi7IORvVFb3+Q=", zzata, i, 5);
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zze.zzn(-1);
        this.zze.zzm(-1);
        int[] iArr = (int[]) this.zzf.invoke((Object) null, new Object[]{this.zzb.zzb()});
        synchronized (this.zze) {
            this.zze.zzn((long) iArr[0]);
            this.zze.zzm((long) iArr[1]);
            int i = iArr[2];
            if (i != Integer.MIN_VALUE) {
                this.zze.zzl((long) i);
            }
        }
    }
}
