package com.google.android.gms.internal.ads;

import android.content.pm.ApkChecksum;
import android.content.pm.PackageManager$OnChecksumsReadyListener;
import com.google.android.material.chip.Chip$$ExternalSyntheticApiModelOutline0;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzazf implements PackageManager$OnChecksumsReadyListener {
    public final /* synthetic */ zzgex zza;

    public /* synthetic */ zzazf(zzgex zzgex) {
        this.zza = zzgex;
    }

    public final void onChecksumsReady(List list) {
        zzgex zzgex = this.zza;
        if (list == null) {
            zzgex.zzc((Object) null);
            return;
        }
        try {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ApkChecksum m = Chip$$ExternalSyntheticApiModelOutline0.m(list.get(i));
                if (Chip$$ExternalSyntheticApiModelOutline0.m(m) == 8) {
                    zzgex.zzc(zzaxs.zzb(Chip$$ExternalSyntheticApiModelOutline0.m(m)));
                    return;
                }
            }
            zzgex.zzc((Object) null);
        } catch (Throwable unused) {
            zzgex.zzc((Object) null);
        }
    }
}
