package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.os.StrictMode;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.internal.ads.zzbvs;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzch {
    @Deprecated
    public static Object zza(Context context, Callable callable) {
        StrictMode.ThreadPolicy threadPolicy;
        try {
            threadPolicy = StrictMode.getThreadPolicy();
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
            Object call = callable.call();
            StrictMode.setThreadPolicy(threadPolicy);
            return call;
        } catch (Throwable th) {
            zzm.zzh("Unexpected exception.", th);
            zzbvs.zza(context).zzg(th, "StrictModeUtil.runWithLaxStrictMode");
            return null;
        }
    }
}
