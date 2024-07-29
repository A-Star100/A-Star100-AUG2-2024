package com.google.android.gms.ads.internal.util;

import com.google.android.gms.ads.internal.util.client.zzl;
import com.google.android.gms.internal.ads.zzapy;
import com.google.android.gms.internal.ads.zzaqu;
import com.google.android.gms.internal.ads.zzaqv;
import com.google.android.gms.internal.ads.zzaru;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzbk extends zzaru {
    final /* synthetic */ byte[] zza;
    final /* synthetic */ Map zzb;
    final /* synthetic */ zzl zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbk(zzbq zzbq, int i, String str, zzaqv zzaqv, zzaqu zzaqu, byte[] bArr, Map map, zzl zzl) {
        super(i, str, zzaqv, zzaqu);
        this.zza = bArr;
        this.zzb = map;
        this.zzc = zzl;
    }

    public final Map zzl() throws zzapy {
        Map map = this.zzb;
        return map == null ? Collections.emptyMap() : map;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void zzo(Object obj) {
        zzo((String) obj);
    }

    public final byte[] zzx() throws zzapy {
        byte[] bArr = this.zza;
        if (bArr == null) {
            return null;
        }
        return bArr;
    }

    /* access modifiers changed from: protected */
    public final void zzz(String str) {
        this.zzc.zzg(str);
        super.zzo(str);
    }
}
