package com.google.android.gms.internal.ads;

import java.lang.reflect.Constructor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzacu implements zzacw {
    public static final /* synthetic */ zzacu zza = new zzacu();

    private /* synthetic */ zzacu() {
    }

    public final Constructor zza() {
        if (!Boolean.TRUE.equals(Class.forName("androidx.media3.decoder.flac.FlacLibrary").getMethod("isAvailable", new Class[0]).invoke((Object) null, new Object[0]))) {
            return null;
        }
        return Class.forName("androidx.media3.decoder.flac.FlacExtractor").asSubclass(zzadf.class).getConstructor(new Class[]{Integer.TYPE});
    }
}
