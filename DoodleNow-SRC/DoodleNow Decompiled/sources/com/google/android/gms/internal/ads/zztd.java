package com.google.android.gms.internal.ads;

import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zztd {
    public final zzti zza;
    public final MediaFormat zzb;
    public final zzam zzc;
    public final Surface zzd;
    public final MediaCrypto zze = null;

    private zztd(zzti zzti, MediaFormat mediaFormat, zzam zzam, Surface surface, MediaCrypto mediaCrypto, int i) {
        this.zza = zzti;
        this.zzb = mediaFormat;
        this.zzc = zzam;
        this.zzd = surface;
    }

    public static zztd zza(zzti zzti, MediaFormat mediaFormat, zzam zzam, MediaCrypto mediaCrypto) {
        return new zztd(zzti, mediaFormat, zzam, (Surface) null, (MediaCrypto) null, 0);
    }

    public static zztd zzb(zzti zzti, MediaFormat mediaFormat, zzam zzam, Surface surface, MediaCrypto mediaCrypto) {
        return new zztd(zzti, mediaFormat, zzam, surface, (MediaCrypto) null, 0);
    }
}
