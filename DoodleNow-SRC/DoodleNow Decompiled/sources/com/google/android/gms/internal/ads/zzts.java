package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzts implements zzub {
    public static final /* synthetic */ zzts zza = new zzts();

    private /* synthetic */ zzts() {
    }

    public final int zza(Object obj) {
        int i = zzuc.zza;
        String str = ((zzti) obj).zza;
        if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
            return 1;
        }
        if (zzfx.zza < 26) {
            return str.equals("OMX.MTK.AUDIO.DECODER.RAW") ? -1 : 0;
        }
        return 0;
    }
}
