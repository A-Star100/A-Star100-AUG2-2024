package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
public final /* synthetic */ class zzts implements Callable {
    public final /* synthetic */ SharedPrefManager zza;

    public /* synthetic */ zzts(SharedPrefManager sharedPrefManager) {
        this.zza = sharedPrefManager;
    }

    public final Object call() {
        return this.zza.getMlSdkInstanceId();
    }
}
