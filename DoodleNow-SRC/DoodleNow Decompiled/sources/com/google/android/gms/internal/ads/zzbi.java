package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.exoplayer2.C;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbi {
    @Deprecated
    public static final zzn zza = zzbg.zza;
    private static final String zzl = Integer.toString(0, 36);
    private static final String zzm = Integer.toString(1, 36);
    private static final String zzn = Integer.toString(2, 36);
    private static final String zzo = Integer.toString(3, 36);
    private static final String zzp = Integer.toString(4, 36);
    private static final String zzq = Integer.toString(5, 36);
    private static final String zzr = Integer.toString(6, 36);
    private static final String zzs = Integer.toString(7, 36);
    public final Uri zzb;
    public final String zzc = null;
    public final zzbb zzd = null;
    public final zzaq zze = null;
    public final List zzf;
    public final String zzg;
    public final zzfzn zzh;
    @Deprecated
    public final List zzi;
    public final Object zzj;
    public final long zzk;

    /* synthetic */ zzbi(Uri uri, String str, zzbb zzbb, zzaq zzaq, List list, String str2, zzfzn zzfzn, Object obj, long j, zzbh zzbh) {
        this.zzb = uri;
        int i = zzcb.zza;
        this.zzf = list;
        this.zzg = null;
        this.zzh = zzfzn;
        zzfzk zzfzk = new zzfzk();
        if (zzfzn.size() <= 0) {
            this.zzi = zzfzk.zzi();
            this.zzj = null;
            this.zzk = C.TIME_UNSET;
            return;
        }
        zzbn zzbn = (zzbn) zzfzn.get(0);
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbi)) {
            return false;
        }
        zzbi zzbi = (zzbi) obj;
        if (this.zzb.equals(zzbi.zzb)) {
            String str = zzbi.zzc;
            if (zzfx.zzG((Object) null, (Object) null)) {
                zzbb zzbb = zzbi.zzd;
                if (zzfx.zzG((Object) null, (Object) null)) {
                    zzaq zzaq = zzbi.zze;
                    if (zzfx.zzG((Object) null, (Object) null) && this.zzf.equals(zzbi.zzf)) {
                        String str2 = zzbi.zzg;
                        if (zzfx.zzG((Object) null, (Object) null) && this.zzh.equals(zzbi.zzh)) {
                            Object obj2 = zzbi.zzj;
                            if (zzfx.zzG((Object) null, (Object) null)) {
                                Long valueOf = Long.valueOf(C.TIME_UNSET);
                                long j = zzbi.zzk;
                                if (zzfx.zzG(valueOf, valueOf)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return (int) ((((long) (((((this.zzb.hashCode() * 923521) + this.zzf.hashCode()) * 961) + this.zzh.hashCode()) * 31)) * 31) + C.TIME_UNSET);
    }
}
