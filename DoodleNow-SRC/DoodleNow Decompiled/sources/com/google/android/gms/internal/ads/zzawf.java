package com.google.android.gms.internal.ads;

import java.io.File;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzawf implements zzfro {
    final /* synthetic */ zzfpi zza;

    zzawf(zzawh zzawh, zzfpi zzfpi) {
        this.zza = zzfpi;
    }

    public final boolean zza(File file) {
        try {
            return this.zza.zza(file);
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
