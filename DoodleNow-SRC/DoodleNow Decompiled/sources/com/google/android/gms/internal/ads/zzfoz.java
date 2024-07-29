package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfoz implements zzfnz {
    private static final zzfoz zza = new zzfoz();
    private static final Handler zzb = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public static Handler zzc = null;
    /* access modifiers changed from: private */
    public static final Runnable zzd = new zzfov();
    /* access modifiers changed from: private */
    public static final Runnable zze = new zzfow();
    private final List zzf = new ArrayList();
    private int zzg;
    private boolean zzh = false;
    private final List zzi = new ArrayList();
    private final zzfob zzj = new zzfob();
    private final zzfos zzk = new zzfos();
    /* access modifiers changed from: private */
    public final zzfot zzl = new zzfot(new zzfpc());
    private long zzm;

    zzfoz() {
    }

    public static zzfoz zzd() {
        return zza;
    }

    static /* bridge */ /* synthetic */ void zzg(zzfoz zzfoz) {
        zzfoz.zzg = 0;
        zzfoz.zzi.clear();
        zzfoz.zzh = false;
        for (zzfnc zzfnc : zzfnq.zza().zzb()) {
        }
        zzfoz.zzm = System.nanoTime();
        zzfoz.zzk.zzi();
        long nanoTime = System.nanoTime();
        zzfoa zza2 = zzfoz.zzj.zza();
        if (zzfoz.zzk.zze().size() > 0) {
            Iterator it = zzfoz.zzk.zze().iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                JSONObject zza3 = zza2.zza((View) null);
                View zza4 = zzfoz.zzk.zza(str);
                zzfoa zzb2 = zzfoz.zzj.zzb();
                String zzc2 = zzfoz.zzk.zzc(str);
                if (zzc2 != null) {
                    JSONObject zza5 = zzb2.zza(zza4);
                    zzfok.zzb(zza5, str);
                    try {
                        zza5.put("notVisibleReason", zzc2);
                    } catch (JSONException e) {
                        zzfol.zza("Error with setting not visible reason", e);
                    }
                    zzfok.zzc(zza3, zza5);
                }
                zzfok.zzf(zza3);
                HashSet hashSet = new HashSet();
                hashSet.add(str);
                zzfoz.zzl.zzc(zza3, hashSet, nanoTime);
            }
        }
        if (zzfoz.zzk.zzf().size() > 0) {
            JSONObject zza6 = zza2.zza((View) null);
            zzfoz.zzk((View) null, zza2, zza6, 1, false);
            zzfok.zzf(zza6);
            zzfoz.zzl.zzd(zza6, zzfoz.zzk.zzf(), nanoTime);
            boolean z = zzfoz.zzh;
        } else {
            zzfoz.zzl.zzb();
        }
        zzfoz.zzk.zzg();
        long nanoTime2 = System.nanoTime() - zzfoz.zzm;
        if (zzfoz.zzf.size() > 0) {
            for (zzfoy zzfoy : zzfoz.zzf) {
                int i = zzfoz.zzg;
                TimeUnit.NANOSECONDS.toMillis(nanoTime2);
                zzfoy.zzb();
                if (zzfoy instanceof zzfox) {
                    int i2 = zzfoz.zzg;
                    ((zzfox) zzfoy).zza();
                }
            }
        }
    }

    private final void zzk(View view, zzfoa zzfoa, JSONObject jSONObject, int i, boolean z) {
        boolean z2 = true;
        if (i != 1) {
            z2 = false;
        }
        zzfoa.zzb(view, jSONObject, this, z2, z);
    }

    private static final void zzl() {
        Handler handler = zzc;
        if (handler != null) {
            handler.removeCallbacks(zze);
            zzc = null;
        }
    }

    public final void zza(View view, zzfoa zzfoa, JSONObject jSONObject, boolean z) {
        int zzk2;
        boolean z2;
        if (zzfoq.zza(view) == null && (zzk2 = this.zzk.zzk(view)) != 3) {
            JSONObject zza2 = zzfoa.zza(view);
            zzfok.zzc(jSONObject, zza2);
            String zzd2 = this.zzk.zzd(view);
            if (zzd2 != null) {
                zzfok.zzb(zza2, zzd2);
                try {
                    zza2.put("hasWindowFocus", Boolean.valueOf(this.zzk.zzj(view)));
                } catch (JSONException e) {
                    zzfol.zza("Error with setting has window focus", e);
                }
                this.zzk.zzh();
            } else {
                zzfor zzb2 = this.zzk.zzb(view);
                if (zzb2 != null) {
                    zzfnt zza3 = zzb2.zza();
                    JSONArray jSONArray = new JSONArray();
                    ArrayList zzb3 = zzb2.zzb();
                    int size = zzb3.size();
                    for (int i = 0; i < size; i++) {
                        jSONArray.put((String) zzb3.get(i));
                    }
                    try {
                        zza2.put("isFriendlyObstructionFor", jSONArray);
                        zza2.put("friendlyObstructionClass", zza3.zzd());
                        zza2.put("friendlyObstructionPurpose", zza3.zza());
                        zza2.put("friendlyObstructionReason", zza3.zzc());
                    } catch (JSONException e2) {
                        zzfol.zza("Error with setting friendly obstruction", e2);
                    }
                    z2 = true;
                } else {
                    z2 = false;
                }
                zzk(view, zzfoa, zza2, zzk2, z || z2);
            }
            this.zzg++;
        }
    }

    public final void zzh() {
        zzl();
    }

    public final void zzi() {
        if (zzc == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            zzc = handler;
            handler.post(zzd);
            zzc.postDelayed(zze, 200);
        }
    }

    public final void zzj() {
        zzl();
        this.zzf.clear();
        zzb.post(new zzfou(this));
    }
}
