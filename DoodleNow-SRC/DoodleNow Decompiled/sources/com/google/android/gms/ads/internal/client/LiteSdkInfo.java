package com.google.android.gms.ads.internal.client;

import android.content.Context;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbqk;
import com.google.android.gms.internal.ads.zzbqo;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public class LiteSdkInfo extends zzck {
    public LiteSdkInfo(Context context) {
    }

    public zzbqo getAdapterCreator() {
        return new zzbqk();
    }

    public zzen getLiteSdkVersion() {
        return new zzen(ModuleDescriptor.MODULE_VERSION, 241199000, "23.1.0");
    }
}
