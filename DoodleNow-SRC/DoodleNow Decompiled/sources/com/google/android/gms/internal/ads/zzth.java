package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public class zzth extends zzif {
    public final zzti zza;
    public final String zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzth(Throwable th, zzti zzti) {
        super("Decoder failed: ".concat(String.valueOf(zzti == null ? null : zzti.zza)), th);
        String str = null;
        this.zza = zzti;
        int i = zzfx.zza;
        this.zzb = th instanceof MediaCodec.CodecException ? ((MediaCodec.CodecException) th).getDiagnosticInfo() : str;
    }
}
