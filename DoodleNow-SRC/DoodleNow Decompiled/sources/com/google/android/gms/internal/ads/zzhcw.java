package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzhcw extends RuntimeException {
    public zzhcw(zzhbl zzhbl) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final zzhak zza() {
        return new zzhak(getMessage());
    }
}
