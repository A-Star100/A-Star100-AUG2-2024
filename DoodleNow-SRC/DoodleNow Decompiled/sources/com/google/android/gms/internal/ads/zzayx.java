package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzayx extends zzazd {
    private final zzaxw zzi;
    private long zzj;

    public zzayx(zzaxp zzaxp, String str, String str2, zzata zzata, int i, int i2, zzaxw zzaxw) {
        super(zzaxp, "1LUIVO6lhWmBJfHw9DMAIriIU/Yodc7yYpCjENKu6ENqSuhgH3MJrJCpj/jKq6Pa", "V8P78mWO+MxnWR283vMX+BSDXEvrm8XlQCYXMpvUe5w=", zzata, i, 53);
        this.zzi = zzaxw;
        if (zzaxw != null) {
            this.zzj = zzaxw.zza();
        }
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        if (this.zzi != null) {
            this.zze.zzV(((Long) this.zzf.invoke((Object) null, new Object[]{Long.valueOf(this.zzj)})).longValue());
        }
    }
}
