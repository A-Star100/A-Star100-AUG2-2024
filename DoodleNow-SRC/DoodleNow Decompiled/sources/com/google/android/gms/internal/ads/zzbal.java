package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzbal implements Application.ActivityLifecycleCallbacks {
    private final Application zza;
    private final WeakReference zzb;
    private boolean zzc = false;

    public zzbal(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.zzb = new WeakReference(activityLifecycleCallbacks);
        this.zza = application;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(new zzbad(this, activity, bundle));
    }

    public final void onActivityDestroyed(Activity activity) {
        zza(new zzbaj(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        zza(new zzbag(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        zza(new zzbaf(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zza(new zzbai(this, activity, bundle));
    }

    public final void onActivityStarted(Activity activity) {
        zza(new zzbae(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        zza(new zzbah(this, activity));
    }

    /* access modifiers changed from: protected */
    public final void zza(zzbak zzbak) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks) this.zzb.get();
            if (activityLifecycleCallbacks != null) {
                zzbak.zza(activityLifecycleCallbacks);
            } else if (!this.zzc) {
                this.zza.unregisterActivityLifecycleCallbacks(this);
                this.zzc = true;
            }
        } catch (Exception e) {
            zzm.zzh("Error while dispatching lifecycle callback.", e);
        }
    }
}
