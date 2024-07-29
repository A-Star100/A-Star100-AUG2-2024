package com.google.android.gms.internal.ads;

import android.os.AsyncTask;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public abstract class zzfpb extends AsyncTask {
    private zzfpc zza;
    protected final zzfot zzd;

    public zzfpb(zzfot zzfot) {
        this.zzd = zzfot;
    }

    /* access modifiers changed from: protected */
    /* renamed from: zza */
    public void onPostExecute(String str) {
        zzfpc zzfpc = this.zza;
        if (zzfpc != null) {
            zzfpc.zza(this);
        }
    }

    public final void zzb(zzfpc zzfpc) {
        this.zza = zzfpc;
    }
}
