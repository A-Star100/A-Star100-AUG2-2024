package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzepd implements zzewr {
    private final zzgep zza;
    private final zzgep zzb;
    private final Context zzc;
    private final zzfgi zzd;
    private final View zze;

    public zzepd(zzgep zzgep, zzgep zzgep2, Context context, zzfgi zzfgi, ViewGroup viewGroup) {
        this.zza = zzgep;
        this.zzb = zzgep2;
        this.zzc = context;
        this.zzd = zzfgi;
        this.zze = viewGroup;
    }

    private final List zze() {
        ArrayList arrayList = new ArrayList();
        View view = this.zze;
        while (view != null) {
            ViewParent parent = view.getParent();
            if (parent == null) {
                break;
            }
            int indexOfChild = parent instanceof ViewGroup ? ((ViewGroup) parent).indexOfChild(view) : -1;
            Bundle bundle = new Bundle();
            bundle.putString("type", parent.getClass().getName());
            bundle.putInt("index_of_child", indexOfChild);
            arrayList.add(bundle);
            if (!(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        return arrayList;
    }

    public final int zza() {
        return 3;
    }

    public final ListenableFuture zzb() {
        zzbdz.zza(this.zzc);
        if (((Boolean) zzba.zzc().zza(zzbdz.zzkJ)).booleanValue()) {
            return this.zzb.zzb(new zzepb(this));
        }
        return this.zza.zzb(new zzepc(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzepe zzc() throws Exception {
        return new zzepe(this.zzc, this.zzd.zze, zze());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzepe zzd() throws Exception {
        return new zzepe(this.zzc, this.zzd.zze, zze());
    }
}
