package com.google.mlkit.common.sdkinternal;

import android.content.Context;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* compiled from: com.google.mlkit:common@@18.9.0 */
public final /* synthetic */ class zzs implements ComponentFactory {
    public static final /* synthetic */ zzs zza = new zzs();

    private /* synthetic */ zzs() {
    }

    public final Object create(ComponentContainer componentContainer) {
        return new SharedPrefManager((Context) componentContainer.get(Context.class));
    }
}
