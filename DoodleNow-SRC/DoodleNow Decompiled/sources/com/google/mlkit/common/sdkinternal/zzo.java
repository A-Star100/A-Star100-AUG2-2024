package com.google.mlkit.common.sdkinternal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.OptionalModuleApi;

/* compiled from: com.google.mlkit:common@@18.9.0 */
public final /* synthetic */ class zzo implements OptionalModuleApi {
    public final /* synthetic */ Feature[] zza;

    public /* synthetic */ zzo(Feature[] featureArr) {
        this.zza = featureArr;
    }

    public final Feature[] getOptionalFeatures() {
        Feature[] featureArr = this.zza;
        Feature[] featureArr2 = OptionalModuleUtils.EMPTY_FEATURES;
        return featureArr;
    }
}
