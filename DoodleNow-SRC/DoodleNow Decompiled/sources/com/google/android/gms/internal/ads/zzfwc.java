package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public abstract class zzfwc implements zzfws {
    protected zzfwc() {
    }

    public static zzfwc zzc(char c) {
        return new zzfvz(c);
    }

    @Deprecated
    public final /* synthetic */ boolean zza(Object obj) {
        return zzb(((Character) obj).charValue());
    }

    public abstract boolean zzb(char c);
}
