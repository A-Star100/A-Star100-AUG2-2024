package com.google.android.gms.ads.internal.util;

import android.content.Context;
import androidx.browser.trusted.sharing.ShareTarget;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzl;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.internal.ads.zzapy;
import com.google.android.gms.internal.ads.zzaqt;
import com.google.android.gms.internal.ads.zzare;
import com.google.android.gms.internal.ads.zzarw;
import com.google.android.gms.internal.ads.zzbdz;
import com.google.android.gms.internal.ads.zzcbw;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbq {
    @Deprecated
    public static final zzbl zza = new zzbi();
    private static zzaqt zzb;
    private static final Object zzc = new Object();

    public zzbq(Context context) {
        zzaqt zzaqt;
        context = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        synchronized (zzc) {
            if (zzb == null) {
                zzbdz.zza(context);
                if (!ClientLibraryUtils.isPackageSide()) {
                    if (((Boolean) zzba.zzc().zza(zzbdz.zzet)).booleanValue()) {
                        zzaqt = zzaz.zzb(context);
                        zzb = zzaqt;
                    }
                }
                zzaqt = zzarw.zza(context, (zzare) null);
                zzb = zzaqt;
            }
        }
    }

    public final ListenableFuture zza(String str) {
        zzcbw zzcbw = new zzcbw();
        zzb.zza(new zzbp(str, (Map) null, zzcbw));
        return zzcbw;
    }

    public final ListenableFuture zzb(int i, String str, Map map, byte[] bArr) {
        String str2 = str;
        zzbn zzbn = new zzbn((zzbm) null);
        zzbj zzbj = new zzbj(this, str2, zzbn);
        zzl zzl = new zzl((String) null);
        zzbk zzbk = new zzbk(this, i, str, zzbn, zzbj, bArr, map, zzl);
        if (zzl.zzk()) {
            try {
                zzl.zzd(str2, ShareTarget.METHOD_GET, zzbk.zzl(), zzbk.zzx());
            } catch (zzapy e) {
                zzm.zzj(e.getMessage());
            }
        }
        zzb.zza(zzbk);
        return zzbn;
    }
}
