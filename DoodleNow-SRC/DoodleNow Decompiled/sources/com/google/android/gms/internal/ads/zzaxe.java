package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzaxe implements Application.ActivityLifecycleCallbacks {
    private final Application zza;
    private final WeakReference zzb;
    private boolean zzc = false;

    public zzaxe(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.zzb = new WeakReference(activityLifecycleCallbacks);
        this.zza = application;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(new zzaww(this, activity, bundle));
    }

    public final void onActivityDestroyed(Activity activity) {
        zza(new zzaxc(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        zza(new zzawz(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        zza(new zzawy(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zza(new zzaxb(this, activity, bundle));
    }

    public final void onActivityStarted(Activity activity) {
        zza(new zzawx(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        zza(new zzaxa(this, activity));
    }

    /* access modifiers changed from: protected */
    public final void zza(zzaxd zzaxd) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks) this.zzb.get();
            if (activityLifecycleCallbacks != null) {
                zzaxd.zza(activityLifecycleCallbacks);
            } else if (!this.zzc) {
                this.zza.unregisterActivityLifecycleCallbacks(this);
                this.zzc = true;
            }
        } catch (Exception unused) {
        }
    }
}
