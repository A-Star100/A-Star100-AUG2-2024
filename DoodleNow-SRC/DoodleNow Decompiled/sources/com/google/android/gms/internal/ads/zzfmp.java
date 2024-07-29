package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzl;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfmp {
    private final zzekd zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final Context zze;
    private final zzfga zzf;
    private final zzfgb zzg;
    private final Clock zzh;
    private final zzawo zzi;

    public zzfmp(zzekd zzekd, VersionInfoParcel versionInfoParcel, String str, String str2, Context context, zzfga zzfga, zzfgb zzfgb, Clock clock, zzawo zzawo) {
        this.zza = zzekd;
        this.zzb = versionInfoParcel.afmaVersion;
        this.zzc = str;
        this.zzd = str2;
        this.zze = context;
        this.zzf = zzfga;
        this.zzg = zzfgb;
        this.zzh = clock;
        this.zzi = zzawo;
    }

    public static final List zzf(int i, int i2, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(zzj((String) it.next(), "@gw_mpe@", "2." + i2));
        }
        return arrayList;
    }

    public static final List zzg(List list, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(zzj((String) it.next(), "@gw_adnetstatus@", str));
        }
        return arrayList;
    }

    public static final List zzh(List list, long j) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(zzj((String) it.next(), "@gw_ttr@", Long.toString(j, 10)));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static String zzi(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return zzl.zzk() ? "fakeForAdDebugLog" : str;
    }

    private static String zzj(String str, String str2, String str3) {
        if (true == TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        return str.replaceAll(str2, str3);
    }

    public final List zzc(zzffz zzffz, zzffn zzffn, List list) {
        return zzd(zzffz, zzffn, false, "", "", list);
    }

    public final List zzd(zzffz zzffz, zzffn zzffn, boolean z, String str, String str2, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            boolean z2 = true;
            String zzj = zzj(zzj(zzj((String) it.next(), "@gw_adlocid@", zzffz.zza.zza.zzf), "@gw_adnetrefresh@", true != z ? SessionDescription.SUPPORTED_SDP_VERSION : "1"), "@gw_sdkver@", this.zzb);
            if (zzffn != null) {
                zzj = zzcaf.zzc(zzj(zzj(zzj(zzj, "@gw_qdata@", zzffn.zzz), "@gw_adnetid@", zzffn.zzy), "@gw_allocid@", zzffn.zzx), this.zze, zzffn.zzX);
            }
            String zzj2 = zzj(zzj(zzj(zzj(zzj, "@gw_adnetstatus@", this.zza.zzg()), "@gw_ttr@", Long.toString(this.zza.zza(), 10)), "@gw_seqnum@", this.zzc), "@gw_sessid@", this.zzd);
            boolean z3 = false;
            if (((Boolean) zzba.zzc().zza(zzbdz.zzds)).booleanValue() && !TextUtils.isEmpty(str)) {
                z3 = true;
            }
            boolean z4 = !TextUtils.isEmpty(str2);
            if (z3) {
                z2 = z4;
            } else if (!z4) {
                arrayList.add(zzj2);
            }
            if (this.zzi.zzf(Uri.parse(zzj2))) {
                Uri.Builder buildUpon = Uri.parse(zzj2).buildUpon();
                if (z3) {
                    buildUpon = buildUpon.appendQueryParameter("ms", str);
                }
                if (z2) {
                    buildUpon = buildUpon.appendQueryParameter("attok", str2);
                }
                zzj2 = buildUpon.build().toString();
            }
            arrayList.add(zzj2);
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x005f A[LOOP:0: B:12:0x0059->B:14:0x005f, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List zze(com.google.android.gms.internal.ads.zzffn r10, java.util.List r11, com.google.android.gms.internal.ads.zzbxq r12) {
        /*
            r9 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.google.android.gms.common.util.Clock r1 = r9.zzh
            long r1 = r1.currentTimeMillis()
            java.lang.String r3 = r12.zzc()     // Catch:{ RemoteException -> 0x00a8 }
            int r12 = r12.zzb()     // Catch:{ RemoteException -> 0x00a8 }
            java.lang.String r12 = java.lang.Integer.toString(r12)     // Catch:{ RemoteException -> 0x00a8 }
            com.google.android.gms.internal.ads.zzbdq r4 = com.google.android.gms.internal.ads.zzbdz.zzdt
            com.google.android.gms.internal.ads.zzbdx r5 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r4 = r5.zza(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x0035
            com.google.android.gms.internal.ads.zzfgb r4 = r9.zzg
            if (r4 != 0) goto L_0x0032
            com.google.android.gms.internal.ads.zzfwm r4 = com.google.android.gms.internal.ads.zzfwm.zzc()
            goto L_0x003b
        L_0x0032:
            com.google.android.gms.internal.ads.zzfga r4 = r4.zza
            goto L_0x0037
        L_0x0035:
            com.google.android.gms.internal.ads.zzfga r4 = r9.zzf
        L_0x0037:
            com.google.android.gms.internal.ads.zzfwm r4 = com.google.android.gms.internal.ads.zzfwm.zzd(r4)
        L_0x003b:
            com.google.android.gms.internal.ads.zzfmn r5 = com.google.android.gms.internal.ads.zzfmn.zza
            com.google.android.gms.internal.ads.zzfwm r5 = r4.zza(r5)
            java.lang.String r6 = ""
            java.lang.Object r5 = r5.zzb(r6)
            java.lang.String r5 = (java.lang.String) r5
            com.google.android.gms.internal.ads.zzfmo r7 = com.google.android.gms.internal.ads.zzfmo.zza
            com.google.android.gms.internal.ads.zzfwm r4 = r4.zza(r7)
            java.lang.Object r4 = r4.zzb(r6)
            java.lang.String r4 = (java.lang.String) r4
            java.util.Iterator r11 = r11.iterator()
        L_0x0059:
            boolean r6 = r11.hasNext()
            if (r6 == 0) goto L_0x00a7
            java.lang.Object r6 = r11.next()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r7 = android.net.Uri.encode(r5)
            java.lang.String r8 = "@gw_rwd_userid@"
            java.lang.String r6 = zzj(r6, r8, r7)
            java.lang.String r7 = android.net.Uri.encode(r4)
            java.lang.String r8 = "@gw_rwd_custom_data@"
            java.lang.String r6 = zzj(r6, r8, r7)
            java.lang.String r7 = java.lang.Long.toString(r1)
            java.lang.String r8 = "@gw_tmstmp@"
            java.lang.String r6 = zzj(r6, r8, r7)
            java.lang.String r7 = android.net.Uri.encode(r3)
            java.lang.String r8 = "@gw_rwd_itm@"
            java.lang.String r6 = zzj(r6, r8, r7)
            java.lang.String r7 = "@gw_rwd_amt@"
            java.lang.String r6 = zzj(r6, r7, r12)
            java.lang.String r7 = r9.zzb
            java.lang.String r8 = "@gw_sdkver@"
            java.lang.String r6 = zzj(r6, r8, r7)
            android.content.Context r7 = r9.zze
            boolean r8 = r10.zzX
            java.lang.String r6 = com.google.android.gms.internal.ads.zzcaf.zzc(r6, r7, r8)
            r0.add(r6)
            goto L_0x0059
        L_0x00a7:
            return r0
        L_0x00a8:
            r10 = move-exception
            java.lang.String r11 = "Unable to determine award type and amount."
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r11, r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfmp.zze(com.google.android.gms.internal.ads.zzffn, java.util.List, com.google.android.gms.internal.ads.zzbxq):java.util.List");
    }
}
