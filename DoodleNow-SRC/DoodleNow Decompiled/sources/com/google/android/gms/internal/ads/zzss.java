package com.google.android.gms.internal.ads;

import android.os.HandlerThread;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzss implements zzte {
    private final zzfxh zzb;
    private final zzfxh zzc;
    private boolean zzd = true;

    public zzss(int i) {
        zzsq zzsq = new zzsq(i);
        zzsr zzsr = new zzsr(i);
        this.zzb = zzsq;
        this.zzc = zzsr;
    }

    static /* synthetic */ HandlerThread zza(int i) {
        return new HandlerThread(zzsu.zzr(i, "ExoPlayer:MediaCodecAsyncAdapter:"));
    }

    static /* synthetic */ HandlerThread zzb(int i) {
        return new HandlerThread(zzsu.zzr(i, "ExoPlayer:MediaCodecQueueingThread:"));
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzsu zzc(com.google.android.gms.internal.ads.zztd r7) throws java.io.IOException {
        /*
            r6 = this;
            java.lang.String r0 = "createCodec:"
            com.google.android.gms.internal.ads.zzti r1 = r7.zza
            java.lang.String r1 = r1.zza
            r2 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0065 }
            r3.<init>(r0)     // Catch:{ Exception -> 0x0065 }
            r3.append(r1)     // Catch:{ Exception -> 0x0065 }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x0065 }
            android.os.Trace.beginSection(r0)     // Catch:{ Exception -> 0x0065 }
            android.media.MediaCodec r0 = android.media.MediaCodec.createByCodecName(r1)     // Catch:{ Exception -> 0x0065 }
            boolean r1 = r6.zzd     // Catch:{ Exception -> 0x0063 }
            if (r1 == 0) goto L_0x0036
            com.google.android.gms.internal.ads.zzam r1 = r7.zzc     // Catch:{ Exception -> 0x0063 }
            int r3 = com.google.android.gms.internal.ads.zzfx.zza     // Catch:{ Exception -> 0x0063 }
            r4 = 34
            if (r3 >= r4) goto L_0x0027
            goto L_0x0036
        L_0x0027:
            java.lang.String r1 = r1.zzm     // Catch:{ Exception -> 0x0063 }
            boolean r1 = com.google.android.gms.internal.ads.zzcb.zzh(r1)     // Catch:{ Exception -> 0x0063 }
            if (r1 == 0) goto L_0x0036
            com.google.android.gms.internal.ads.zzuf r1 = new com.google.android.gms.internal.ads.zzuf     // Catch:{ Exception -> 0x0063 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0063 }
            r3 = 4
            goto L_0x0046
        L_0x0036:
            com.google.android.gms.internal.ads.zzsy r1 = new com.google.android.gms.internal.ads.zzsy     // Catch:{ Exception -> 0x0063 }
            com.google.android.gms.internal.ads.zzfxh r3 = r6.zzc     // Catch:{ Exception -> 0x0063 }
            com.google.android.gms.internal.ads.zzsr r3 = (com.google.android.gms.internal.ads.zzsr) r3     // Catch:{ Exception -> 0x0063 }
            int r3 = r3.zza     // Catch:{ Exception -> 0x0063 }
            android.os.HandlerThread r3 = zzb(r3)     // Catch:{ Exception -> 0x0063 }
            r1.<init>(r0, r3)     // Catch:{ Exception -> 0x0063 }
            r3 = 0
        L_0x0046:
            com.google.android.gms.internal.ads.zzsu r4 = new com.google.android.gms.internal.ads.zzsu     // Catch:{ Exception -> 0x0063 }
            com.google.android.gms.internal.ads.zzfxh r5 = r6.zzb     // Catch:{ Exception -> 0x0063 }
            com.google.android.gms.internal.ads.zzsq r5 = (com.google.android.gms.internal.ads.zzsq) r5     // Catch:{ Exception -> 0x0063 }
            int r5 = r5.zza     // Catch:{ Exception -> 0x0063 }
            android.os.HandlerThread r5 = zza(r5)     // Catch:{ Exception -> 0x0063 }
            r4.<init>(r0, r5, r1, r2)     // Catch:{ Exception -> 0x0063 }
            android.os.Trace.endSection()     // Catch:{ Exception -> 0x0060 }
            android.media.MediaFormat r1 = r7.zzb     // Catch:{ Exception -> 0x0060 }
            android.view.Surface r7 = r7.zzd     // Catch:{ Exception -> 0x0060 }
            com.google.android.gms.internal.ads.zzsu.zzh(r4, r1, r7, r2, r3)     // Catch:{ Exception -> 0x0060 }
            return r4
        L_0x0060:
            r7 = move-exception
            r2 = r4
            goto L_0x0067
        L_0x0063:
            r7 = move-exception
            goto L_0x0067
        L_0x0065:
            r7 = move-exception
            r0 = r2
        L_0x0067:
            if (r2 != 0) goto L_0x006f
            if (r0 == 0) goto L_0x0072
            r0.release()
            goto L_0x0072
        L_0x006f:
            r2.zzl()
        L_0x0072:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzss.zzc(com.google.android.gms.internal.ads.zztd):com.google.android.gms.internal.ads.zzsu");
    }

    public final /* bridge */ /* synthetic */ zztf zzd(zztd zztd) throws IOException {
        throw null;
    }

    public final void zze(boolean z) {
        this.zzd = true;
    }
}
