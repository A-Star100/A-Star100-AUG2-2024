package com.google.android.gms.internal.mlkit_common;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.config.EncoderConfig;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.mlkit:common@@18.9.0 */
public final class zzbs implements EncoderConfig {
    public static final /* synthetic */ int zza = 0;
    private static final ObjectEncoder zzb = zzbr.zza;
    private final Map zzc = new HashMap();
    private final Map zzd = new HashMap();
    private final ObjectEncoder zze = zzb;

    public final /* bridge */ /* synthetic */ EncoderConfig registerEncoder(Class cls, ObjectEncoder objectEncoder) {
        this.zzc.put(cls, objectEncoder);
        this.zzd.remove(cls);
        return this;
    }

    public final zzbt zza() {
        return new zzbt(new HashMap(this.zzc), new HashMap(this.zzd), this.zze);
    }

    public final /* bridge */ /* synthetic */ EncoderConfig registerEncoder(Class cls, ValueEncoder valueEncoder) {
        this.zzd.put(cls, valueEncoder);
        this.zzc.remove(cls);
        return this;
    }
}
