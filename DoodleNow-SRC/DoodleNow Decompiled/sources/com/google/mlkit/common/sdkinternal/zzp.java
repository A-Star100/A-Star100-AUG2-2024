package com.google.mlkit.common.sdkinternal;

import android.util.Log;
import com.google.android.gms.tasks.OnFailureListener;

/* compiled from: com.google.mlkit:common@@18.9.0 */
public final /* synthetic */ class zzp implements OnFailureListener {
    public static final /* synthetic */ zzp zza = new zzp();

    private /* synthetic */ zzp() {
    }

    public final void onFailure(Exception exc) {
        Log.e("OptionalModuleUtils", "Failed to check feature availability", exc);
    }
}
