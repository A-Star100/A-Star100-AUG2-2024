package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzecy implements zzgdl {
    public static final /* synthetic */ zzecy zza = new zzecy();

    private /* synthetic */ zzecy() {
    }

    public final ListenableFuture zza(Object obj) {
        return zzgee.zzh(new ByteArrayInputStream(((JSONObject) obj).toString().getBytes(StandardCharsets.UTF_8)));
    }
}
