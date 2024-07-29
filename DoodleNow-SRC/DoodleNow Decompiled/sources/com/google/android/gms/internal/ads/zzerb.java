package com.google.android.gms.internal.ads;

import android.os.Build;
import android.os.Bundle;
import android.os.ext.SdkExtensions;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzerb implements zzewq {
    @Nullable
    private final Integer zza;

    private zzerb(@Nullable Integer num) {
        this.zza = num;
    }

    static /* bridge */ /* synthetic */ zzerb zzb() {
        if (!((Boolean) zzba.zzc().zza(zzbdz.zzjR)).booleanValue()) {
            return new zzerb((Integer) null);
        }
        zzu.zzp();
        int i = 0;
        if (Build.VERSION.SDK_INT >= 30 && SdkExtensions.getExtensionVersion(30) > 3) {
            i = SdkExtensions.getExtensionVersion(1000000);
        }
        return new zzerb(Integer.valueOf(i));
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Integer num = this.zza;
        Bundle bundle = (Bundle) obj;
        if (num != null) {
            bundle.putInt("aos", num.intValue());
        }
    }
}
