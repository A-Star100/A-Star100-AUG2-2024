package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.amazon.a.a.o.b;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzy;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.client.zzr;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import com.onesignal.inAppMessages.internal.InAppMessageContent;
import com.onesignal.notifications.internal.bundle.impl.NotificationBundleProcessor;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzblk implements zzbky {
    private final zzb zza;
    private final zzduh zzb;
    private final zzr zzc;
    private final zzbtm zzd;
    private final zzefd zze;
    private final zzcpk zzf;
    private zzy zzg = null;
    private final zzgep zzh = zzcbr.zzf;

    public zzblk(zzb zzb2, zzbtm zzbtm, zzefd zzefd, zzduh zzduh, zzcpk zzcpk) {
        this.zza = zzb2;
        this.zzd = zzbtm;
        this.zze = zzefd;
        this.zzb = zzduh;
        this.zzc = new zzr((String) null);
        this.zzf = zzcpk;
    }

    public static int zzb(Map map) {
        String str = (String) map.get(NotificationBundleProcessor.PUSH_MINIFIED_BUTTONS_LIST);
        if (str == null) {
            return -1;
        }
        if ("p".equalsIgnoreCase(str)) {
            return 7;
        }
        if ("l".equalsIgnoreCase(str)) {
            return 6;
        }
        return "c".equalsIgnoreCase(str) ? 14 : -1;
    }

    static Uri zzc(Context context, zzawo zzawo, Uri uri, View view, Activity activity, zzfgm zzfgm) {
        if (zzawo == null) {
            return uri;
        }
        try {
            if (!((Boolean) zzba.zzc().zza(zzbdz.zzlF)).booleanValue() || zzfgm == null) {
                if (zzawo.zze(uri)) {
                    return zzawo.zza(uri, context, view, activity);
                }
                return uri;
            } else if (zzawo.zze(uri)) {
                return zzfgm.zza(uri, context, view, activity);
            } else {
                return uri;
            }
        } catch (zzawp unused) {
            return uri;
        } catch (Exception e) {
            zzu.zzo().zzw(e, "OpenGmsgHandler.maybeAddClickSignalsToUri");
            return uri;
        }
    }

    static Uri zzd(Uri uri) {
        try {
            if (uri.getQueryParameter("aclk_ms") != null) {
                return uri.buildUpon().appendQueryParameter("aclk_upms", String.valueOf(SystemClock.uptimeMillis())).build();
            }
        } catch (UnsupportedOperationException e) {
            zzm.zzh("Error adding click uptime parameter to url: ".concat(String.valueOf(uri.toString())), e);
        }
        return uri;
    }

    public static boolean zzf(Map map) {
        return "1".equals(map.get("custom_close"));
    }

    /* access modifiers changed from: private */
    public final void zzh(String str, zza zza2, Map map, String str2) {
        String str3;
        boolean z;
        Object obj;
        HashMap hashMap;
        Object obj2;
        boolean z2;
        zza zza3 = zza2;
        Map map2 = map;
        String str4 = str2;
        zzcgm zzcgm = (zzcgm) zza3;
        zzffn zzD = zzcgm.zzD();
        zzffq zzP = zzcgm.zzP();
        boolean z3 = false;
        if (zzD == null || zzP == null) {
            str3 = "";
            z = false;
        } else {
            String str5 = zzP.zzb;
            z = zzD.zzaj;
            str3 = str5;
        }
        boolean z4 = !((Boolean) zzba.zzc().zza(zzbdz.zzkt)).booleanValue() || !map2.containsKey("sc") || !((String) map2.get("sc")).equals(SessionDescription.SUPPORTED_SDP_VERSION);
        if ("expand".equalsIgnoreCase(str4)) {
            if (zzcgm.zzaC()) {
                zzm.zzj("Cannot expand WebView that is already expanded.");
                return;
            }
            zzk(false);
            ((zzchu) zza3).zzaH(zzf(map), zzb(map), z4);
        } else if ("webapp".equalsIgnoreCase(str4)) {
            zzk(false);
            if (((Boolean) zzba.zzc().zza(zzbdz.zzlA)).booleanValue() && Objects.equals(map2.get("is_allowed_for_lock_screen"), "1")) {
                z3 = true;
            }
            if (str != null) {
                ((zzchu) zza3).zzaJ(zzf(map), zzb(map), str, z4, z3);
            } else {
                ((zzchu) zza3).zzaI(zzf(map), zzb(map), (String) map2.get(InAppMessageContent.HTML), (String) map2.get("baseurl"), z4);
            }
        } else if ("chrome_custom_tab".equalsIgnoreCase(str4)) {
            zzcgm.getContext();
            if (((Boolean) zzba.zzc().zza(zzbdz.zzey)).booleanValue()) {
                if (((Boolean) zzba.zzc().zza(zzbdz.zzeC)).booleanValue()) {
                    zze.zza("User opt out chrome custom tab.");
                } else {
                    z3 = true;
                }
            }
            boolean zzg2 = zzbew.zzg(zzcgm.getContext());
            if (z3) {
                if (!zzg2) {
                    zzm(4);
                } else {
                    zzk(true);
                    if (TextUtils.isEmpty(str)) {
                        zzm.zzj("Cannot open browser with null or empty url");
                        zzm(7);
                        return;
                    }
                    Uri zzd2 = zzd(zzc(zzcgm.getContext(), zzcgm.zzI(), Uri.parse(str), zzcgm.zzF(), zzcgm.zzi(), zzcgm.zzQ()));
                    if (!z || this.zze == null || !zzl(zza3, zzcgm.getContext(), zzd2.toString(), str3)) {
                        this.zzg = new zzblh(this);
                        ((zzchu) zza3).zzaF(new zzc((String) null, zzd2.toString(), (String) null, (String) null, (String) null, (String) null, (String) null, (Intent) null, ObjectWrapper.wrap(this.zzg).asBinder(), true), z4);
                        return;
                    }
                    return;
                }
            }
            map2.put("use_first_package", b.ac);
            map2.put("use_running_process", b.ac);
            zzj(zza2, map, z, str3, z4);
        } else if ("app".equalsIgnoreCase(str4) && b.ac.equalsIgnoreCase((String) map2.get("system_browser"))) {
            zzj(zza2, map, z, str3, z4);
        } else if ("open_app".equalsIgnoreCase(str4)) {
            if (((Boolean) zzba.zzc().zza(zzbdz.zzii)).booleanValue()) {
                zzk(true);
                String str6 = (String) map2.get("p");
                if (str6 == null) {
                    zzm.zzj("Package name missing from open app action.");
                } else if (!z || this.zze == null || !zzl(zza3, zzcgm.getContext(), str6, str3)) {
                    PackageManager packageManager = zzcgm.getContext().getPackageManager();
                    if (packageManager == null) {
                        zzm.zzj("Cannot get package manager from open app action.");
                        return;
                    }
                    Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str6);
                    if (launchIntentForPackage != null) {
                        ((zzchu) zza3).zzaF(new zzc(launchIntentForPackage, this.zzg), z4);
                    }
                }
            }
        } else {
            zzk(true);
            String str7 = (String) map2.get("intent_url");
            Intent intent = null;
            if (!TextUtils.isEmpty(str7)) {
                try {
                    intent = Intent.parseUri(str7, 0);
                } catch (URISyntaxException e) {
                    zzm.zzh("Error parsing the url: ".concat(String.valueOf(str7)), e);
                }
            }
            Intent intent2 = intent;
            if (!(intent2 == null || intent2.getData() == null)) {
                Uri data = intent2.getData();
                if (!Uri.EMPTY.equals(data)) {
                    Uri zzd3 = zzd(zzc(zzcgm.getContext(), zzcgm.zzI(), data, zzcgm.zzF(), zzcgm.zzi(), zzcgm.zzQ()));
                    if (!TextUtils.isEmpty(intent2.getType())) {
                        if (((Boolean) zzba.zzc().zza(zzbdz.zzij)).booleanValue()) {
                            intent2.setDataAndType(zzd3, intent2.getType());
                        }
                    }
                    intent2.setData(zzd3);
                }
            }
            boolean z5 = ((Boolean) zzba.zzc().zza(zzbdz.zziA)).booleanValue() && "intent_async".equalsIgnoreCase(str4) && map2.containsKey("event_id");
            HashMap hashMap2 = new HashMap();
            if (z5) {
                zzbli zzbli = r1;
                boolean z6 = z4;
                HashMap hashMap3 = hashMap2;
                obj2 = "event_id";
                obj = "p";
                hashMap = hashMap3;
                zzbli zzbli2 = new zzbli(this, z6, zza2, hashMap3, map);
                this.zzg = zzbli;
                z2 = false;
            } else {
                obj2 = "event_id";
                obj = "p";
                hashMap = hashMap2;
                z2 = z4;
            }
            if (intent2 == null) {
                String uri = !TextUtils.isEmpty(str) ? zzd(zzc(zzcgm.getContext(), zzcgm.zzI(), Uri.parse(str), zzcgm.zzF(), zzcgm.zzi(), zzcgm.zzQ())).toString() : str;
                if (!z || this.zze == null || !zzl(zza3, zzcgm.getContext(), uri, str3)) {
                    ((zzchu) zza3).zzaF(new zzc((String) map2.get("i"), uri, (String) map2.get("m"), (String) map2.get(obj), (String) map2.get("c"), (String) map2.get("f"), (String) map2.get("e"), this.zzg), z2);
                } else if (z5) {
                    hashMap.put((String) map2.get(obj2), true);
                    ((zzbnt) zza3).zzd("openIntentAsync", hashMap);
                }
            } else if (!z || this.zze == null || !zzl(zza3, zzcgm.getContext(), intent2.getData().toString(), str3)) {
                ((zzchu) zza3).zzaF(new zzc(intent2, this.zzg), z2);
            } else if (z5) {
                hashMap.put((String) map2.get(obj2), true);
                ((zzbnt) zza3).zzd("openIntentAsync", hashMap);
            }
        }
    }

    private final void zzi(Context context, String str, String str2) {
        this.zze.zzc(str);
        zzduh zzduh = this.zzb;
        if (zzduh != null) {
            zzefo.zzc(context, zzduh, this.zze, str, "dialog_not_shown", zzfzq.zze("dialog_not_shown_reason", str2));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v0, resolved type: android.content.Intent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v2, resolved type: android.content.Intent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: android.net.Uri} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v7, resolved type: android.content.Intent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v8, resolved type: android.content.Intent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v9, resolved type: android.content.Intent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v10, resolved type: android.content.Intent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v11, resolved type: android.content.Intent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v12, resolved type: android.content.Intent} */
    /* JADX WARNING: type inference failed for: r16v1, types: [android.net.Uri] */
    /* JADX WARNING: type inference failed for: r16v6, types: [android.net.Uri] */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0105, code lost:
        if (com.google.android.gms.internal.ads.zzblj.zzc(r2, r11, r12, r13, r14) == null) goto L_0x0107;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzj(com.google.android.gms.ads.internal.client.zza r20, java.util.Map r21, boolean r22, java.lang.String r23, boolean r24) {
        /*
            r19 = this;
            r1 = r19
            r0 = r20
            r2 = r21
            r3 = 1
            r1.zzk(r3)
            r4 = r0
            com.google.android.gms.internal.ads.zzcgm r4 = (com.google.android.gms.internal.ads.zzcgm) r4
            android.content.Context r11 = r4.getContext()
            com.google.android.gms.internal.ads.zzawo r12 = r4.zzI()
            android.view.View r13 = r4.zzF()
            com.google.android.gms.internal.ads.zzfgm r14 = r4.zzQ()
            java.lang.String r5 = "activity"
            java.lang.Object r5 = r11.getSystemService(r5)
            r15 = r5
            android.app.ActivityManager r15 = (android.app.ActivityManager) r15
            java.lang.String r5 = "u"
            java.lang.Object r5 = r2.get(r5)
            java.lang.String r5 = (java.lang.String) r5
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            r16 = 0
            if (r6 == 0) goto L_0x003a
        L_0x0036:
            r2 = r16
            goto L_0x016d
        L_0x003a:
            android.net.Uri r7 = android.net.Uri.parse(r5)
            r9 = 0
            r5 = r11
            r6 = r12
            r8 = r13
            r10 = r14
            android.net.Uri r5 = zzc(r5, r6, r7, r8, r9, r10)
            android.net.Uri r5 = zzd(r5)
            java.lang.String r6 = "use_first_package"
            java.lang.Object r6 = r2.get(r6)
            java.lang.String r6 = (java.lang.String) r6
            boolean r17 = java.lang.Boolean.parseBoolean(r6)
            java.lang.String r6 = "use_running_process"
            java.lang.Object r6 = r2.get(r6)
            java.lang.String r6 = (java.lang.String) r6
            boolean r18 = java.lang.Boolean.parseBoolean(r6)
            java.lang.String r6 = "use_custom_tabs"
            java.lang.Object r2 = r2.get(r6)
            java.lang.String r2 = (java.lang.String) r2
            boolean r2 = java.lang.Boolean.parseBoolean(r2)
            r10 = 0
            if (r2 != 0) goto L_0x0086
            com.google.android.gms.internal.ads.zzbdq r2 = com.google.android.gms.internal.ads.zzbdz.zzew
            com.google.android.gms.internal.ads.zzbdx r6 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r2 = r6.zza(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x0085
            goto L_0x0086
        L_0x0085:
            r3 = r10
        L_0x0086:
            java.lang.String r2 = r5.getScheme()
            java.lang.String r6 = "http"
            boolean r2 = r6.equalsIgnoreCase(r2)
            java.lang.String r7 = "https"
            if (r2 == 0) goto L_0x00a3
            android.net.Uri$Builder r2 = r5.buildUpon()
            android.net.Uri$Builder r2 = r2.scheme(r7)
            android.net.Uri r16 = r2.build()
        L_0x00a0:
            r2 = r16
            goto L_0x00ba
        L_0x00a3:
            java.lang.String r2 = r5.getScheme()
            boolean r2 = r7.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x00a0
            android.net.Uri$Builder r2 = r5.buildUpon()
            android.net.Uri$Builder r2 = r2.scheme(r6)
            android.net.Uri r16 = r2.build()
            goto L_0x00a0
        L_0x00ba:
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            android.content.Intent r8 = com.google.android.gms.internal.ads.zzblj.zza(r5, r11, r12, r13, r14)
            android.content.Intent r2 = com.google.android.gms.internal.ads.zzblj.zza(r2, r11, r12, r13, r14)
            if (r3 == 0) goto L_0x00d5
            com.google.android.gms.ads.internal.zzu.zzp()
            com.google.android.gms.ads.internal.util.zzt.zzo(r11, r8)
            com.google.android.gms.ads.internal.zzu.zzp()
            com.google.android.gms.ads.internal.util.zzt.zzo(r11, r2)
        L_0x00d5:
            r5 = r8
            r6 = r9
            r7 = r11
            r3 = r8
            r8 = r12
            r21 = r9
            r9 = r13
            r0 = r10
            r10 = r14
            android.content.pm.ResolveInfo r6 = com.google.android.gms.internal.ads.zzblj.zzd(r5, r6, r7, r8, r9, r10)
            if (r6 == 0) goto L_0x00f0
            r5 = r3
            r7 = r11
            r8 = r12
            r9 = r13
            r10 = r14
            android.content.Intent r16 = com.google.android.gms.internal.ads.zzblj.zzb(r5, r6, r7, r8, r9, r10)
            goto L_0x0036
        L_0x00f0:
            if (r2 == 0) goto L_0x0107
            android.content.pm.ResolveInfo r6 = com.google.android.gms.internal.ads.zzblj.zzc(r2, r11, r12, r13, r14)
            if (r6 == 0) goto L_0x0107
            r5 = r3
            r7 = r11
            r8 = r12
            r9 = r13
            r10 = r14
            android.content.Intent r2 = com.google.android.gms.internal.ads.zzblj.zzb(r5, r6, r7, r8, r9, r10)
            android.content.pm.ResolveInfo r5 = com.google.android.gms.internal.ads.zzblj.zzc(r2, r11, r12, r13, r14)
            if (r5 != 0) goto L_0x016d
        L_0x0107:
            boolean r2 = r21.isEmpty()
            if (r2 == 0) goto L_0x010f
            goto L_0x016c
        L_0x010f:
            if (r18 == 0) goto L_0x0156
            if (r15 == 0) goto L_0x0156
            java.util.List r2 = r15.getRunningAppProcesses()
            if (r2 == 0) goto L_0x0156
            int r5 = r21.size()
            r10 = r0
        L_0x011e:
            if (r10 >= r5) goto L_0x0156
            r6 = r21
            java.lang.Object r7 = r6.get(r10)
            android.content.pm.ResolveInfo r7 = (android.content.pm.ResolveInfo) r7
            java.util.Iterator r8 = r2.iterator()
        L_0x012c:
            boolean r9 = r8.hasNext()
            int r15 = r10 + 1
            if (r9 == 0) goto L_0x0152
            java.lang.Object r9 = r8.next()
            android.app.ActivityManager$RunningAppProcessInfo r9 = (android.app.ActivityManager.RunningAppProcessInfo) r9
            java.lang.String r9 = r9.processName
            android.content.pm.ActivityInfo r15 = r7.activityInfo
            java.lang.String r15 = r15.packageName
            boolean r9 = r9.equals(r15)
            if (r9 == 0) goto L_0x012c
            r5 = r3
            r6 = r7
            r7 = r11
            r8 = r12
            r9 = r13
            r10 = r14
            android.content.Intent r16 = com.google.android.gms.internal.ads.zzblj.zzb(r5, r6, r7, r8, r9, r10)
            goto L_0x0036
        L_0x0152:
            r21 = r6
            r10 = r15
            goto L_0x011e
        L_0x0156:
            r6 = r21
            if (r17 == 0) goto L_0x016c
            java.lang.Object r0 = r6.get(r0)
            r6 = r0
            android.content.pm.ResolveInfo r6 = (android.content.pm.ResolveInfo) r6
            r5 = r3
            r7 = r11
            r8 = r12
            r9 = r13
            r10 = r14
            android.content.Intent r16 = com.google.android.gms.internal.ads.zzblj.zzb(r5, r6, r7, r8, r9, r10)
            goto L_0x0036
        L_0x016c:
            r2 = r3
        L_0x016d:
            if (r22 == 0) goto L_0x018d
            com.google.android.gms.internal.ads.zzefd r0 = r1.zze
            if (r0 == 0) goto L_0x018d
            if (r2 == 0) goto L_0x018d
            android.content.Context r0 = r4.getContext()
            android.net.Uri r3 = r2.getData()
            java.lang.String r3 = r3.toString()
            r4 = r20
            r5 = r23
            boolean r0 = r1.zzl(r4, r0, r3, r5)
            if (r0 != 0) goto L_0x018c
            goto L_0x018f
        L_0x018c:
            return
        L_0x018d:
            r4 = r20
        L_0x018f:
            r0 = r4
            com.google.android.gms.internal.ads.zzchu r0 = (com.google.android.gms.internal.ads.zzchu) r0     // Catch:{ ActivityNotFoundException -> 0x019f }
            com.google.android.gms.ads.internal.overlay.zzc r3 = new com.google.android.gms.ads.internal.overlay.zzc     // Catch:{ ActivityNotFoundException -> 0x019f }
            com.google.android.gms.ads.internal.overlay.zzy r4 = r1.zzg     // Catch:{ ActivityNotFoundException -> 0x019f }
            r3.<init>(r2, r4)     // Catch:{ ActivityNotFoundException -> 0x019f }
            r2 = r24
            r0.zzaF(r3, r2)     // Catch:{ ActivityNotFoundException -> 0x019f }
            return
        L_0x019f:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzblk.zzj(com.google.android.gms.ads.internal.client.zza, java.util.Map, boolean, java.lang.String, boolean):void");
    }

    private final void zzk(boolean z) {
        zzbtm zzbtm = this.zzd;
        if (zzbtm != null) {
            zzbtm.zza(z);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x008f, code lost:
        if (r2 != false) goto L_0x0098;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzl(com.google.android.gms.ads.internal.client.zza r9, android.content.Context r10, java.lang.String r11, java.lang.String r12) {
        /*
            r8 = this;
            com.google.android.gms.internal.ads.zzduh r1 = r8.zzb
            if (r1 == 0) goto L_0x0012
            com.google.android.gms.internal.ads.zzefd r2 = r8.zze
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            java.lang.String r4 = "offline_open"
            r0 = r10
            r3 = r12
            com.google.android.gms.internal.ads.zzefo.zzc(r0, r1, r2, r3, r4, r5)
        L_0x0012:
            com.google.android.gms.internal.ads.zzcbh r0 = com.google.android.gms.ads.internal.zzu.zzo()
            boolean r0 = r0.zzz(r10)
            r1 = 0
            if (r0 == 0) goto L_0x0025
            com.google.android.gms.internal.ads.zzefd r9 = r8.zze
            com.google.android.gms.ads.internal.util.client.zzr r10 = r8.zzc
            r9.zzh(r10, r12)
            return r1
        L_0x0025:
            com.google.android.gms.ads.internal.zzu.zzp()
            com.google.android.gms.ads.internal.util.zzbt r0 = com.google.android.gms.ads.internal.util.zzt.zzz(r10)
            com.google.android.gms.ads.internal.zzu.zzp()
            androidx.core.app.NotificationManagerCompat r2 = androidx.core.app.NotificationManagerCompat.from(r10)
            boolean r2 = r2.areNotificationsEnabled()
            java.lang.String r3 = "offline_notification_channel"
            com.google.android.gms.ads.internal.util.zzab r4 = com.google.android.gms.ads.internal.zzu.zzq()
            boolean r3 = r4.zzi(r10, r3)
            r4 = r9
            com.google.android.gms.internal.ads.zzcgm r4 = (com.google.android.gms.internal.ads.zzcgm) r4
            com.google.android.gms.internal.ads.zzcie r5 = r4.zzO()
            boolean r5 = r5.zzi()
            r6 = 1
            if (r5 == 0) goto L_0x0057
            android.app.Activity r5 = r4.zzi()
            if (r5 != 0) goto L_0x0057
            r5 = r6
            goto L_0x0058
        L_0x0057:
            r5 = r1
        L_0x0058:
            if (r2 != 0) goto L_0x0098
            com.google.android.gms.ads.internal.zzu.zzp()
            androidx.core.app.NotificationManagerCompat r2 = androidx.core.app.NotificationManagerCompat.from(r10)
            boolean r2 = r2.areNotificationsEnabled()
            if (r2 == 0) goto L_0x0068
            goto L_0x0092
        L_0x0068:
            int r2 = android.os.Build.VERSION.SDK_INT
            r7 = 33
            if (r2 >= r7) goto L_0x007f
            com.google.android.gms.internal.ads.zzbdq r2 = com.google.android.gms.internal.ads.zzbdz.zzit
            com.google.android.gms.internal.ads.zzbdx r7 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r2 = r7.zza(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            goto L_0x008f
        L_0x007f:
            com.google.android.gms.internal.ads.zzbdq r2 = com.google.android.gms.internal.ads.zzbdz.zzis
            com.google.android.gms.internal.ads.zzbdx r7 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r2 = r7.zza(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
        L_0x008f:
            if (r2 == 0) goto L_0x0092
            goto L_0x0098
        L_0x0092:
            java.lang.String r9 = "notifications_disabled"
            r8.zzi(r10, r12, r9)
            return r1
        L_0x0098:
            if (r3 == 0) goto L_0x00a0
            java.lang.String r9 = "notification_channel_disabled"
            r8.zzi(r10, r12, r9)
            return r1
        L_0x00a0:
            if (r0 != 0) goto L_0x00a8
            java.lang.String r9 = "work_manager_unavailable"
            r8.zzi(r10, r12, r9)
            return r1
        L_0x00a8:
            if (r5 == 0) goto L_0x00b0
            java.lang.String r9 = "ad_no_activity"
            r8.zzi(r10, r12, r9)
            return r1
        L_0x00b0:
            com.google.android.gms.internal.ads.zzbdq r0 = com.google.android.gms.internal.ads.zzbdz.zziq
            com.google.android.gms.internal.ads.zzbdx r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r2.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x00c8
            java.lang.String r9 = "notification_flow_disabled"
            r8.zzi(r10, r12, r9)
            return r1
        L_0x00c8:
            com.google.android.gms.ads.internal.overlay.zzm r0 = r4.zzL()
            if (r0 == 0) goto L_0x00fe
            android.app.Activity r0 = r4.zzi()
            if (r0 == 0) goto L_0x00fe
            com.google.android.gms.internal.ads.zzefp r0 = com.google.android.gms.internal.ads.zzefq.zze()
            android.app.Activity r2 = r4.zzi()
            r0.zza(r2)
            r2 = 0
            r0.zzb(r2)
            r0.zzc(r12)
            r0.zzd(r11)
            com.google.android.gms.internal.ads.zzefq r11 = r0.zze()
            com.google.android.gms.ads.internal.overlay.zzm r0 = r4.zzL()     // Catch:{ Exception -> 0x00f5 }
            r0.zzf(r11)     // Catch:{ Exception -> 0x00f5 }
            goto L_0x0106
        L_0x00f5:
            r9 = move-exception
            java.lang.String r9 = r9.getMessage()
            r8.zzi(r10, r12, r9)
            return r1
        L_0x00fe:
            r10 = r9
            com.google.android.gms.internal.ads.zzchu r10 = (com.google.android.gms.internal.ads.zzchu) r10
            r0 = 14
            r10.zzaG(r12, r11, r0)
        L_0x0106:
            r9.onAdClicked()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzblk.zzl(com.google.android.gms.ads.internal.client.zza, android.content.Context, java.lang.String, java.lang.String):boolean");
    }

    /* access modifiers changed from: private */
    public final void zzm(int i) {
        String str;
        zzduh zzduh = this.zzb;
        if (zzduh != null) {
            zzdug zza2 = zzduh.zza();
            zza2.zzb("action", "cct_action");
            switch (i) {
                case 2:
                    str = "CONTEXT_NOT_AN_ACTIVITY";
                    break;
                case 3:
                    str = "CONTEXT_NULL";
                    break;
                case 4:
                    str = "CCT_NOT_SUPPORTED";
                    break;
                case 5:
                    str = "CCT_READY_TO_OPEN";
                    break;
                case 6:
                    str = "ACTIVITY_NOT_FOUND";
                    break;
                case 7:
                    str = "EMPTY_URL";
                    break;
                case 8:
                    str = "UNKNOWN";
                    break;
                default:
                    str = "WRONG_EXP_SETUP";
                    break;
            }
            zza2.zzb("cct_open_status", str);
            zza2.zzf();
        }
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        ListenableFuture listenableFuture;
        zza zza2 = (zza) obj;
        String zzc2 = zzcaf.zzc((String) map.get("u"), ((zzcgm) zza2).getContext(), true);
        String str = (String) map.get("a");
        if (str == null) {
            zzm.zzj("Action missing from an open GMSG.");
            return;
        }
        zzb zzb2 = this.zza;
        if (zzb2 == null || zzb2.zzc()) {
            if (!((Boolean) zzba.zzc().zza(zzbdz.zzjR)).booleanValue() || this.zzf == null || !zzcpk.zzj(zzc2)) {
                listenableFuture = zzgee.zzh(zzc2);
            } else {
                listenableFuture = this.zzf.zzb(zzc2, zzay.zze());
            }
            zzgee.zzr(listenableFuture, new zzblg(this, zza2, map, str), this.zzh);
            return;
        }
        zzb2.zzb(zzc2);
    }
}
