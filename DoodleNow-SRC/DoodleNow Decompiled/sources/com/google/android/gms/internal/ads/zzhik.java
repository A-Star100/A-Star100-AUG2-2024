package com.google.android.gms.internal.ads;

import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzhik extends zzhin {
    final Logger zza;

    public zzhik(String str) {
        this.zza = Logger.getLogger(str);
    }

    public final void zza(String str) {
        this.zza.logp(Level.FINE, "com.googlecode.mp4parser.util.JuliLogger", "logDebug", str);
    }
}
