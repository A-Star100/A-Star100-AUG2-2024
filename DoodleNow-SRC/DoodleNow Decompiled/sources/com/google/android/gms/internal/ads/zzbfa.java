package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsSession;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.ads.query.QueryInfo;
import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbfa {
    private final ScheduledExecutorService zza;
    private Runnable zzb;
    private zzbex zzc;
    /* access modifiers changed from: private */
    public CustomTabsSession zzd;
    private String zze;
    private long zzf = 0;
    private long zzg;
    private JSONArray zzh;
    private Context zzi;

    public zzbfa(ScheduledExecutorService scheduledExecutorService) {
        this.zza = scheduledExecutorService;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0049, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbdz.zzjH)).booleanValue() != false) goto L_0x004b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzj() {
        /*
            r5 = this;
            com.google.android.gms.internal.ads.zzbex r0 = r5.zzc
            if (r0 != 0) goto L_0x000a
            java.lang.String r0 = "PACT callback is not present, please initialize the PawCustomTabsImpl."
            com.google.android.gms.ads.internal.util.client.zzm.zzg(r0)
            return
        L_0x000a:
            java.lang.Boolean r0 = r0.zza()
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0015
            return
        L_0x0015:
            java.lang.String r0 = r5.zze
            if (r0 == 0) goto L_0x0070
            androidx.browser.customtabs.CustomTabsSession r0 = r5.zzd
            if (r0 == 0) goto L_0x0070
            java.util.concurrent.ScheduledExecutorService r0 = r5.zza
            if (r0 == 0) goto L_0x0070
            long r0 = r5.zzf
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x002a
            goto L_0x0039
        L_0x002a:
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzu.zzB()
            long r0 = r0.elapsedRealtime()
            long r2 = r5.zzf
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x0039
            goto L_0x004b
        L_0x0039:
            com.google.android.gms.internal.ads.zzbdq r0 = com.google.android.gms.internal.ads.zzbdz.zzjH
            com.google.android.gms.internal.ads.zzbdx r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0070
        L_0x004b:
            androidx.browser.customtabs.CustomTabsSession r0 = r5.zzd
            java.lang.String r1 = r5.zze
            android.net.Uri r1 = android.net.Uri.parse(r1)
            r0.requestPostMessageChannel(r1)
            java.util.concurrent.ScheduledExecutorService r0 = r5.zza
            java.lang.Runnable r1 = r5.zzb
            com.google.android.gms.internal.ads.zzbdq r2 = com.google.android.gms.internal.ads.zzbdz.zzjI
            com.google.android.gms.internal.ads.zzbdx r3 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r2 = r3.zza(r2)
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS
            r0.schedule(r1, r2, r4)
            return
        L_0x0070:
            java.lang.String r0 = "PACT max retry connection duration timed out"
            com.google.android.gms.ads.internal.util.zze.zza(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbfa.zzj():void");
    }

    private final void zzk(JSONObject jSONObject) {
        try {
            if (this.zzh == null) {
                this.zzh = new JSONArray((String) zzba.zzc().zza(zzbdz.zzjK));
            }
            jSONObject.put("eids", this.zzh);
        } catch (JSONException e) {
            zzm.zzh("Error fetching the PACT active eids JSON: ", e);
        }
    }

    @Nullable
    public final CustomTabsSession zzb() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final JSONObject zzc(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("paw_id", str);
        jSONObject.put("error", str2);
        zzk(jSONObject);
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    public final JSONObject zzd(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("paw_id", str);
        jSONObject.put("signal", str2);
        zzk(jSONObject);
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    public final void zzf() {
        this.zzf = zzu.zzB().elapsedRealtime() + ((long) ((Integer) zzba.zzc().zza(zzbdz.zzjG)).intValue());
        if (this.zzb == null) {
            this.zzb = new zzbey(this);
        }
        zzj();
    }

    /* access modifiers changed from: package-private */
    public final void zzh(String str) {
        try {
            CustomTabsSession customTabsSession = this.zzd;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("gsppack", true);
            jSONObject.put("fpt", new Date(this.zzg).toString());
            zzk(jSONObject);
            customTabsSession.postMessage(jSONObject.toString(), (Bundle) null);
            Bundle bundle = new Bundle();
            bundle.putString("query_info_type", "requester_type_6");
            QueryInfo.generate(this.zzi, AdFormat.BANNER, ((AdRequest.Builder) new AdRequest.Builder().addNetworkExtrasBundle(AdMobAdapter.class, bundle)).build(), new zzbez(this, str));
        } catch (JSONException e) {
            zzm.zzh("Error creating JSON: ", e);
        }
    }

    public final void zzi(long j) {
        this.zzg = j;
    }

    public final void zzg(@Nonnull Context context, @Nonnull CustomTabsClient customTabsClient, @Nonnull String str, @Nullable CustomTabsCallback customTabsCallback) {
        if (context == null) {
            throw new IllegalArgumentException("App Context parameter is null");
        } else if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Origin parameter is empty or null");
        } else if (customTabsClient != null) {
            this.zzi = context;
            this.zze = str;
            zzbex zzbex = new zzbex(this, customTabsCallback);
            this.zzc = zzbex;
            CustomTabsSession newSession = customTabsClient.newSession(zzbex);
            this.zzd = newSession;
            if (newSession == null) {
                zzm.zzg("CustomTabsClient failed to create new session.");
            }
        } else {
            throw new IllegalArgumentException("CustomTabsClient parameter is null");
        }
    }
}
