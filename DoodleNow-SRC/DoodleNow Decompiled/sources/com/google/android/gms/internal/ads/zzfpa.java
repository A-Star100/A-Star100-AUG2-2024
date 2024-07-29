package com.google.android.gms.internal.ads;

import java.util.HashSet;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public abstract class zzfpa extends zzfpb {
    protected final HashSet zza;
    protected final JSONObject zzb;
    protected final long zzc;

    public zzfpa(zzfot zzfot, HashSet hashSet, JSONObject jSONObject, long j) {
        super(zzfot);
        this.zza = new HashSet(hashSet);
        this.zzb = jSONObject;
        this.zzc = j;
    }
}
