package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfmz {
    private final zzfnh zza;
    private final zzfnh zzb;
    private final zzfnd zzc;
    private final zzfng zzd;

    private zzfmz(zzfnd zzfnd, zzfng zzfng, zzfnh zzfnh, zzfnh zzfnh2, boolean z) {
        this.zzc = zzfnd;
        this.zzd = zzfng;
        this.zza = zzfnh;
        if (zzfnh2 == null) {
            this.zzb = zzfnh.NONE;
        } else {
            this.zzb = zzfnh2;
        }
    }

    public static zzfmz zza(zzfnd zzfnd, zzfng zzfng, zzfnh zzfnh, zzfnh zzfnh2, boolean z) {
        zzfop.zzb(zzfng, "ImpressionType is null");
        zzfop.zzb(zzfnh, "Impression owner is null");
        if (zzfnh == zzfnh.NONE) {
            throw new IllegalArgumentException("Impression owner is none");
        } else if (zzfnd == zzfnd.DEFINED_BY_JAVASCRIPT && zzfnh == zzfnh.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        } else if (zzfng != zzfng.DEFINED_BY_JAVASCRIPT || zzfnh != zzfnh.NATIVE) {
            return new zzfmz(zzfnd, zzfng, zzfnh, zzfnh2, true);
        } else {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        }
    }

    public final JSONObject zzb() {
        JSONObject jSONObject = new JSONObject();
        zzfok.zze(jSONObject, "impressionOwner", this.zza);
        zzfok.zze(jSONObject, "mediaEventsOwner", this.zzb);
        zzfok.zze(jSONObject, "creativeType", this.zzc);
        zzfok.zze(jSONObject, "impressionType", this.zzd);
        zzfok.zze(jSONObject, "isolateVerificationScripts", true);
        return jSONObject;
    }
}
