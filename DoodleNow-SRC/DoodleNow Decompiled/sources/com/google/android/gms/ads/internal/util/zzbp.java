package com.google.android.gms.ads.internal.util;

import androidx.browser.trusted.sharing.ShareTarget;
import com.google.android.gms.ads.internal.util.client.zzl;
import com.google.android.gms.internal.ads.zzaqm;
import com.google.android.gms.internal.ads.zzaqq;
import com.google.android.gms.internal.ads.zzaqw;
import com.google.android.gms.internal.ads.zzarn;
import com.google.android.gms.internal.ads.zzcbw;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbp extends zzaqq {
    private final zzcbw zza;
    private final zzl zzb;

    public zzbp(String str, Map map, zzcbw zzcbw) {
        super(0, str, new zzbo(zzcbw));
        this.zza = zzcbw;
        zzl zzl = new zzl((String) null);
        this.zzb = zzl;
        zzl.zzd(str, ShareTarget.METHOD_GET, (Map) null, (byte[]) null);
    }

    /* access modifiers changed from: protected */
    public final zzaqw zzh(zzaqm zzaqm) {
        return zzaqw.zzb(zzaqm, zzarn.zzb(zzaqm));
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void zzo(Object obj) {
        zzaqm zzaqm = (zzaqm) obj;
        this.zzb.zzf(zzaqm.zzc, zzaqm.zza);
        byte[] bArr = zzaqm.zzb;
        if (zzl.zzk() && bArr != null) {
            this.zzb.zzh(bArr);
        }
        this.zza.zzc(zzaqm);
    }
}
