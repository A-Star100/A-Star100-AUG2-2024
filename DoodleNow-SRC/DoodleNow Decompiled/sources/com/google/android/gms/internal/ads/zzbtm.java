package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.facebook.hermes.intl.Constants;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.common.util.CollectionUtils;
import com.onesignal.inAppMessages.internal.display.impl.WebViewManager;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbtm extends zzbts {
    static final Set zza = CollectionUtils.setOf("top-left", "top-right", "top-center", TtmlNode.CENTER, "bottom-left", "bottom-right", "bottom-center");
    private String zzb = "top-right";
    private boolean zzc = true;
    private int zzd = 0;
    private int zze = 0;
    private int zzf = -1;
    private int zzg = 0;
    private int zzh = 0;
    private int zzi = -1;
    private final Object zzj = new Object();
    private final zzcgm zzk;
    private final Activity zzl;
    private zzcie zzm;
    private ImageView zzn;
    private LinearLayout zzo;
    private final zzbtt zzp;
    private PopupWindow zzq;
    private RelativeLayout zzr;
    private ViewGroup zzs;

    public zzbtm(zzcgm zzcgm, zzbtt zzbtt) {
        super(zzcgm, WebViewManager.EVENT_TYPE_RESIZE);
        this.zzk = zzcgm;
        this.zzl = zzcgm.zzi();
        this.zzp = zzbtt;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzm */
    public final void zzc(boolean z) {
        this.zzq.dismiss();
        this.zzr.removeView((View) this.zzk);
        ViewGroup viewGroup = this.zzs;
        if (viewGroup != null) {
            viewGroup.removeView(this.zzn);
            this.zzs.addView((View) this.zzk);
            this.zzk.zzah(this.zzm);
        }
        if (z) {
            zzl(Constants.COLLATION_DEFAULT);
            zzbtt zzbtt = this.zzp;
            if (zzbtt != null) {
                zzbtt.zzb();
            }
        }
        this.zzq = null;
        this.zzr = null;
        this.zzs = null;
        this.zzo = null;
    }

    public final void zza(boolean z) {
        synchronized (this.zzj) {
            if (this.zzq != null) {
                if (!((Boolean) zzba.zzc().zza(zzbdz.zzky)).booleanValue() || Looper.getMainLooper().getThread() == Thread.currentThread()) {
                    zzc(z);
                } else {
                    zzcbr.zze.zza(new zzbtk(this, z));
                }
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0202 A[Catch:{ RuntimeException -> 0x0436 }] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0203 A[Catch:{ RuntimeException -> 0x0436 }] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0267 A[Catch:{ RuntimeException -> 0x0436 }] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x026e A[Catch:{ RuntimeException -> 0x0436 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(java.util.Map r19) {
        /*
            r18 = this;
            r1 = r18
            r0 = r19
            java.lang.String r2 = "Cannot show popup window: "
            java.lang.Object r3 = r1.zzj
            monitor-enter(r3)
            android.app.Activity r4 = r1.zzl     // Catch:{ all -> 0x0483 }
            if (r4 != 0) goto L_0x0014
            java.lang.String r0 = "Not an activity context. Cannot resize."
            r1.zzh(r0)     // Catch:{ all -> 0x0483 }
            monitor-exit(r3)     // Catch:{ all -> 0x0483 }
            return
        L_0x0014:
            com.google.android.gms.internal.ads.zzcgm r4 = r1.zzk     // Catch:{ all -> 0x0483 }
            com.google.android.gms.internal.ads.zzcie r4 = r4.zzO()     // Catch:{ all -> 0x0483 }
            if (r4 != 0) goto L_0x0023
            java.lang.String r0 = "Webview is not yet available, size is not set."
            r1.zzh(r0)     // Catch:{ all -> 0x0483 }
            monitor-exit(r3)     // Catch:{ all -> 0x0483 }
            return
        L_0x0023:
            com.google.android.gms.internal.ads.zzcgm r4 = r1.zzk     // Catch:{ all -> 0x0483 }
            com.google.android.gms.internal.ads.zzcie r4 = r4.zzO()     // Catch:{ all -> 0x0483 }
            boolean r4 = r4.zzi()     // Catch:{ all -> 0x0483 }
            if (r4 == 0) goto L_0x0036
            java.lang.String r0 = "Is interstitial. Cannot resize an interstitial."
            r1.zzh(r0)     // Catch:{ all -> 0x0483 }
            monitor-exit(r3)     // Catch:{ all -> 0x0483 }
            return
        L_0x0036:
            com.google.android.gms.internal.ads.zzcgm r4 = r1.zzk     // Catch:{ all -> 0x0483 }
            boolean r4 = r4.zzaC()     // Catch:{ all -> 0x0483 }
            if (r4 == 0) goto L_0x0045
            java.lang.String r0 = "Cannot resize an expanded banner."
            r1.zzh(r0)     // Catch:{ all -> 0x0483 }
            monitor-exit(r3)     // Catch:{ all -> 0x0483 }
            return
        L_0x0045:
            java.lang.String r4 = "width"
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x0483 }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ all -> 0x0483 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0483 }
            if (r4 != 0) goto L_0x0064
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch:{ all -> 0x0483 }
            java.lang.String r4 = "width"
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x0483 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0483 }
            int r4 = com.google.android.gms.ads.internal.util.zzt.zzO(r4)     // Catch:{ all -> 0x0483 }
            r1.zzi = r4     // Catch:{ all -> 0x0483 }
        L_0x0064:
            java.lang.String r4 = "height"
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x0483 }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ all -> 0x0483 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0483 }
            if (r4 != 0) goto L_0x0083
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch:{ all -> 0x0483 }
            java.lang.String r4 = "height"
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x0483 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0483 }
            int r4 = com.google.android.gms.ads.internal.util.zzt.zzO(r4)     // Catch:{ all -> 0x0483 }
            r1.zzf = r4     // Catch:{ all -> 0x0483 }
        L_0x0083:
            java.lang.String r4 = "offsetX"
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x0483 }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ all -> 0x0483 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0483 }
            if (r4 != 0) goto L_0x00a2
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch:{ all -> 0x0483 }
            java.lang.String r4 = "offsetX"
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x0483 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0483 }
            int r4 = com.google.android.gms.ads.internal.util.zzt.zzO(r4)     // Catch:{ all -> 0x0483 }
            r1.zzg = r4     // Catch:{ all -> 0x0483 }
        L_0x00a2:
            java.lang.String r4 = "offsetY"
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x0483 }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ all -> 0x0483 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0483 }
            if (r4 != 0) goto L_0x00c1
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch:{ all -> 0x0483 }
            java.lang.String r4 = "offsetY"
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x0483 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0483 }
            int r4 = com.google.android.gms.ads.internal.util.zzt.zzO(r4)     // Catch:{ all -> 0x0483 }
            r1.zzh = r4     // Catch:{ all -> 0x0483 }
        L_0x00c1:
            java.lang.String r4 = "allowOffscreen"
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x0483 }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ all -> 0x0483 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0483 }
            if (r4 != 0) goto L_0x00dd
            java.lang.String r4 = "allowOffscreen"
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x0483 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0483 }
            boolean r4 = java.lang.Boolean.parseBoolean(r4)     // Catch:{ all -> 0x0483 }
            r1.zzc = r4     // Catch:{ all -> 0x0483 }
        L_0x00dd:
            java.lang.String r4 = "customClosePosition"
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0483 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0483 }
            boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0483 }
            if (r4 != 0) goto L_0x00ed
            r1.zzb = r0     // Catch:{ all -> 0x0483 }
        L_0x00ed:
            int r0 = r1.zzi     // Catch:{ all -> 0x0483 }
            if (r0 < 0) goto L_0x047c
            int r0 = r1.zzf     // Catch:{ all -> 0x0483 }
            if (r0 < 0) goto L_0x047c
            android.app.Activity r0 = r1.zzl     // Catch:{ all -> 0x0483 }
            android.view.Window r0 = r0.getWindow()     // Catch:{ all -> 0x0483 }
            if (r0 == 0) goto L_0x0475
            android.view.View r4 = r0.getDecorView()     // Catch:{ all -> 0x0483 }
            if (r4 != 0) goto L_0x0105
            goto L_0x0475
        L_0x0105:
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch:{ all -> 0x0483 }
            android.app.Activity r4 = r1.zzl     // Catch:{ all -> 0x0483 }
            int[] r4 = com.google.android.gms.ads.internal.util.zzt.zzV(r4)     // Catch:{ all -> 0x0483 }
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch:{ all -> 0x0483 }
            android.app.Activity r5 = r1.zzl     // Catch:{ all -> 0x0483 }
            int[] r5 = com.google.android.gms.ads.internal.util.zzt.zzR(r5)     // Catch:{ all -> 0x0483 }
            r6 = 0
            r7 = r4[r6]     // Catch:{ all -> 0x0483 }
            r8 = 1
            r4 = r4[r8]     // Catch:{ all -> 0x0483 }
            int r9 = r1.zzi     // Catch:{ all -> 0x0483 }
            r10 = 5
            r11 = 4
            r12 = 3
            r14 = 2
            r15 = 50
            r16 = 0
            if (r9 < r15) goto L_0x0260
            if (r9 <= r7) goto L_0x012d
            goto L_0x0260
        L_0x012d:
            int r13 = r1.zzf     // Catch:{ all -> 0x0483 }
            if (r13 < r15) goto L_0x025a
            if (r13 <= r4) goto L_0x0135
            goto L_0x025a
        L_0x0135:
            if (r13 != r4) goto L_0x0140
            if (r9 != r7) goto L_0x0140
            java.lang.String r4 = "Cannot resize to a full-screen ad."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r4)     // Catch:{ all -> 0x0483 }
            goto L_0x0265
        L_0x0140:
            boolean r4 = r1.zzc     // Catch:{ all -> 0x0483 }
            if (r4 == 0) goto L_0x0217
            java.lang.String r4 = r1.zzb     // Catch:{ all -> 0x0483 }
            int r17 = r4.hashCode()     // Catch:{ all -> 0x0483 }
            switch(r17) {
                case -1364013995: goto L_0x0180;
                case -1012429441: goto L_0x0176;
                case -655373719: goto L_0x016c;
                case 1163912186: goto L_0x0162;
                case 1288627767: goto L_0x0158;
                case 1755462605: goto L_0x014e;
                default: goto L_0x014d;
            }
        L_0x014d:
            goto L_0x018a
        L_0x014e:
            java.lang.String r6 = "top-center"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x018a
            r4 = r8
            goto L_0x018b
        L_0x0158:
            java.lang.String r6 = "bottom-center"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x018a
            r4 = r11
            goto L_0x018b
        L_0x0162:
            java.lang.String r6 = "bottom-right"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x018a
            r4 = r10
            goto L_0x018b
        L_0x016c:
            java.lang.String r6 = "bottom-left"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x018a
            r4 = r12
            goto L_0x018b
        L_0x0176:
            java.lang.String r6 = "top-left"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x018a
            r4 = 0
            goto L_0x018b
        L_0x0180:
            java.lang.String r6 = "center"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x018a
            r4 = r14
            goto L_0x018b
        L_0x018a:
            r4 = -1
        L_0x018b:
            if (r4 == 0) goto L_0x01ea
            if (r4 == r8) goto L_0x01dc
            if (r4 == r14) goto L_0x01c8
            if (r4 == r12) goto L_0x01bb
            if (r4 == r11) goto L_0x01ad
            if (r4 == r10) goto L_0x01a2
            int r4 = r1.zzd     // Catch:{ all -> 0x0483 }
            int r6 = r1.zzg     // Catch:{ all -> 0x0483 }
            int r4 = r4 + r6
            int r4 = r4 + r9
            int r4 = r4 + -50
            int r6 = r1.zze     // Catch:{ all -> 0x0483 }
            goto L_0x01e7
        L_0x01a2:
            int r4 = r1.zzd     // Catch:{ all -> 0x0483 }
            int r6 = r1.zzg     // Catch:{ all -> 0x0483 }
            int r4 = r4 + r6
            int r4 = r4 + r9
            int r4 = r4 + -50
            int r6 = r1.zze     // Catch:{ all -> 0x0483 }
            goto L_0x01b8
        L_0x01ad:
            int r4 = r1.zzd     // Catch:{ all -> 0x0483 }
            int r6 = r1.zzg     // Catch:{ all -> 0x0483 }
            int r9 = r9 >> r8
            int r4 = r4 + r6
            int r4 = r4 + r9
            int r4 = r4 + -25
            int r6 = r1.zze     // Catch:{ all -> 0x0483 }
        L_0x01b8:
            int r9 = r1.zzh     // Catch:{ all -> 0x0483 }
            goto L_0x01c3
        L_0x01bb:
            int r4 = r1.zzd     // Catch:{ all -> 0x0483 }
            int r6 = r1.zzg     // Catch:{ all -> 0x0483 }
            int r4 = r4 + r6
            int r6 = r1.zze     // Catch:{ all -> 0x0483 }
            goto L_0x01b8
        L_0x01c3:
            int r6 = r6 + r9
            int r6 = r6 + r13
            int r6 = r6 + -50
            goto L_0x01f3
        L_0x01c8:
            int r4 = r1.zzd     // Catch:{ all -> 0x0483 }
            int r6 = r1.zzg     // Catch:{ all -> 0x0483 }
            int r9 = r9 >> r8
            int r4 = r4 + r6
            int r4 = r4 + r9
            int r4 = r4 + -25
            int r6 = r1.zze     // Catch:{ all -> 0x0483 }
            int r9 = r1.zzh     // Catch:{ all -> 0x0483 }
            int r6 = r6 + r9
            int r9 = r13 >> 1
            int r6 = r6 + r9
            int r6 = r6 + -25
            goto L_0x01f3
        L_0x01dc:
            int r4 = r1.zzd     // Catch:{ all -> 0x0483 }
            int r6 = r1.zzg     // Catch:{ all -> 0x0483 }
            int r9 = r9 >> r8
            int r4 = r4 + r6
            int r4 = r4 + r9
            int r4 = r4 + -25
            int r6 = r1.zze     // Catch:{ all -> 0x0483 }
        L_0x01e7:
            int r9 = r1.zzh     // Catch:{ all -> 0x0483 }
            goto L_0x01f2
        L_0x01ea:
            int r4 = r1.zzd     // Catch:{ all -> 0x0483 }
            int r6 = r1.zzg     // Catch:{ all -> 0x0483 }
            int r4 = r4 + r6
            int r6 = r1.zze     // Catch:{ all -> 0x0483 }
            goto L_0x01e7
        L_0x01f2:
            int r6 = r6 + r9
        L_0x01f3:
            if (r4 < 0) goto L_0x0265
            int r4 = r4 + r15
            if (r4 > r7) goto L_0x0265
            r4 = 0
            r7 = r5[r4]     // Catch:{ all -> 0x0483 }
            if (r6 < r7) goto L_0x0265
            int r6 = r6 + r15
            r4 = r5[r8]     // Catch:{ all -> 0x0483 }
            if (r6 <= r4) goto L_0x0203
            goto L_0x0265
        L_0x0203:
            int[] r4 = new int[r14]     // Catch:{ all -> 0x0483 }
            int r5 = r1.zzd     // Catch:{ all -> 0x0483 }
            int r6 = r1.zzg     // Catch:{ all -> 0x0483 }
            int r5 = r5 + r6
            r6 = 0
            r4[r6] = r5     // Catch:{ all -> 0x0483 }
            int r5 = r1.zze     // Catch:{ all -> 0x0483 }
            int r6 = r1.zzh     // Catch:{ all -> 0x0483 }
            int r5 = r5 + r6
            r4[r8] = r5     // Catch:{ all -> 0x0483 }
            r16 = r4
            goto L_0x0265
        L_0x0217:
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch:{ all -> 0x0483 }
            android.app.Activity r4 = r1.zzl     // Catch:{ all -> 0x0483 }
            int[] r4 = com.google.android.gms.ads.internal.util.zzt.zzV(r4)     // Catch:{ all -> 0x0483 }
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch:{ all -> 0x0483 }
            android.app.Activity r5 = r1.zzl     // Catch:{ all -> 0x0483 }
            int[] r5 = com.google.android.gms.ads.internal.util.zzt.zzR(r5)     // Catch:{ all -> 0x0483 }
            r6 = 0
            r4 = r4[r6]     // Catch:{ all -> 0x0483 }
            int r6 = r1.zzd     // Catch:{ all -> 0x0483 }
            int r7 = r1.zzg     // Catch:{ all -> 0x0483 }
            int r6 = r6 + r7
            int r7 = r1.zze     // Catch:{ all -> 0x0483 }
            int r9 = r1.zzh     // Catch:{ all -> 0x0483 }
            int r7 = r7 + r9
            if (r6 >= 0) goto L_0x023b
            r4 = 0
        L_0x0239:
            r6 = 0
            goto L_0x0245
        L_0x023b:
            int r9 = r1.zzi     // Catch:{ all -> 0x0483 }
            int r13 = r6 + r9
            if (r13 <= r4) goto L_0x0243
            int r4 = r4 - r9
            goto L_0x0239
        L_0x0243:
            r4 = r6
            goto L_0x0239
        L_0x0245:
            r9 = r5[r6]     // Catch:{ all -> 0x0483 }
            if (r7 >= r9) goto L_0x024b
            r7 = r9
            goto L_0x0255
        L_0x024b:
            int r6 = r1.zzf     // Catch:{ all -> 0x0483 }
            int r9 = r7 + r6
            r5 = r5[r8]     // Catch:{ all -> 0x0483 }
            if (r9 <= r5) goto L_0x0255
            int r7 = r5 - r6
        L_0x0255:
            int[] r16 = new int[]{r4, r7}     // Catch:{ all -> 0x0483 }
            goto L_0x0265
        L_0x025a:
            java.lang.String r4 = "Height is too small or too large."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r4)     // Catch:{ all -> 0x0483 }
            goto L_0x0265
        L_0x0260:
            java.lang.String r4 = "Width is too small or too large."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r4)     // Catch:{ all -> 0x0483 }
        L_0x0265:
            if (r16 != 0) goto L_0x026e
            java.lang.String r0 = "Resize location out of screen or close button is not visible."
            r1.zzh(r0)     // Catch:{ all -> 0x0483 }
            monitor-exit(r3)     // Catch:{ all -> 0x0483 }
            return
        L_0x026e:
            com.google.android.gms.ads.internal.client.zzay.zzb()     // Catch:{ all -> 0x0483 }
            android.app.Activity r4 = r1.zzl     // Catch:{ all -> 0x0483 }
            int r5 = r1.zzi     // Catch:{ all -> 0x0483 }
            int r4 = com.google.android.gms.ads.internal.util.client.zzf.zzy(r4, r5)     // Catch:{ all -> 0x0483 }
            com.google.android.gms.ads.internal.client.zzay.zzb()     // Catch:{ all -> 0x0483 }
            android.app.Activity r5 = r1.zzl     // Catch:{ all -> 0x0483 }
            int r6 = r1.zzf     // Catch:{ all -> 0x0483 }
            int r5 = com.google.android.gms.ads.internal.util.client.zzf.zzy(r5, r6)     // Catch:{ all -> 0x0483 }
            com.google.android.gms.internal.ads.zzcgm r6 = r1.zzk     // Catch:{ all -> 0x0483 }
            android.view.View r6 = (android.view.View) r6     // Catch:{ all -> 0x0483 }
            android.view.ViewParent r6 = r6.getParent()     // Catch:{ all -> 0x0483 }
            if (r6 == 0) goto L_0x046e
            boolean r7 = r6 instanceof android.view.ViewGroup     // Catch:{ all -> 0x0483 }
            if (r7 == 0) goto L_0x046e
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6     // Catch:{ all -> 0x0483 }
            com.google.android.gms.internal.ads.zzcgm r7 = r1.zzk     // Catch:{ all -> 0x0483 }
            android.view.View r7 = (android.view.View) r7     // Catch:{ all -> 0x0483 }
            r6.removeView(r7)     // Catch:{ all -> 0x0483 }
            android.widget.PopupWindow r7 = r1.zzq     // Catch:{ all -> 0x0483 }
            if (r7 != 0) goto L_0x02d9
            r1.zzs = r6     // Catch:{ all -> 0x0483 }
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch:{ all -> 0x0483 }
            com.google.android.gms.internal.ads.zzcgm r6 = r1.zzk     // Catch:{ all -> 0x0483 }
            r7 = r6
            android.view.View r7 = (android.view.View) r7     // Catch:{ all -> 0x0483 }
            r7.setDrawingCacheEnabled(r8)     // Catch:{ all -> 0x0483 }
            r7 = r6
            android.view.View r7 = (android.view.View) r7     // Catch:{ all -> 0x0483 }
            android.graphics.Bitmap r7 = r7.getDrawingCache()     // Catch:{ all -> 0x0483 }
            android.graphics.Bitmap r7 = android.graphics.Bitmap.createBitmap(r7)     // Catch:{ all -> 0x0483 }
            android.view.View r6 = (android.view.View) r6     // Catch:{ all -> 0x0483 }
            r9 = 0
            r6.setDrawingCacheEnabled(r9)     // Catch:{ all -> 0x0483 }
            android.widget.ImageView r6 = new android.widget.ImageView     // Catch:{ all -> 0x0483 }
            android.app.Activity r9 = r1.zzl     // Catch:{ all -> 0x0483 }
            r6.<init>(r9)     // Catch:{ all -> 0x0483 }
            r1.zzn = r6     // Catch:{ all -> 0x0483 }
            r6.setImageBitmap(r7)     // Catch:{ all -> 0x0483 }
            com.google.android.gms.internal.ads.zzcgm r6 = r1.zzk     // Catch:{ all -> 0x0483 }
            com.google.android.gms.internal.ads.zzcie r6 = r6.zzO()     // Catch:{ all -> 0x0483 }
            r1.zzm = r6     // Catch:{ all -> 0x0483 }
            android.view.ViewGroup r6 = r1.zzs     // Catch:{ all -> 0x0483 }
            android.widget.ImageView r7 = r1.zzn     // Catch:{ all -> 0x0483 }
            r6.addView(r7)     // Catch:{ all -> 0x0483 }
            goto L_0x02dc
        L_0x02d9:
            r7.dismiss()     // Catch:{ all -> 0x0483 }
        L_0x02dc:
            android.widget.RelativeLayout r6 = new android.widget.RelativeLayout     // Catch:{ all -> 0x0483 }
            android.app.Activity r7 = r1.zzl     // Catch:{ all -> 0x0483 }
            r6.<init>(r7)     // Catch:{ all -> 0x0483 }
            r1.zzr = r6     // Catch:{ all -> 0x0483 }
            r7 = 0
            r6.setBackgroundColor(r7)     // Catch:{ all -> 0x0483 }
            android.widget.RelativeLayout r6 = r1.zzr     // Catch:{ all -> 0x0483 }
            android.view.ViewGroup$LayoutParams r7 = new android.view.ViewGroup$LayoutParams     // Catch:{ all -> 0x0483 }
            r7.<init>(r4, r5)     // Catch:{ all -> 0x0483 }
            r6.setLayoutParams(r7)     // Catch:{ all -> 0x0483 }
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch:{ all -> 0x0483 }
            android.widget.RelativeLayout r6 = r1.zzr     // Catch:{ all -> 0x0483 }
            android.widget.PopupWindow r7 = new android.widget.PopupWindow     // Catch:{ all -> 0x0483 }
            r9 = 0
            r7.<init>(r6, r4, r5, r9)     // Catch:{ all -> 0x0483 }
            r1.zzq = r7     // Catch:{ all -> 0x0483 }
            r7.setOutsideTouchable(r9)     // Catch:{ all -> 0x0483 }
            android.widget.PopupWindow r6 = r1.zzq     // Catch:{ all -> 0x0483 }
            r6.setTouchable(r8)     // Catch:{ all -> 0x0483 }
            android.widget.PopupWindow r6 = r1.zzq     // Catch:{ all -> 0x0483 }
            boolean r7 = r1.zzc     // Catch:{ all -> 0x0483 }
            r7 = r7 ^ r8
            r6.setClippingEnabled(r7)     // Catch:{ all -> 0x0483 }
            android.widget.RelativeLayout r6 = r1.zzr     // Catch:{ all -> 0x0483 }
            com.google.android.gms.internal.ads.zzcgm r7 = r1.zzk     // Catch:{ all -> 0x0483 }
            android.view.View r7 = (android.view.View) r7     // Catch:{ all -> 0x0483 }
            r9 = -1
            r6.addView(r7, r9, r9)     // Catch:{ all -> 0x0483 }
            android.widget.LinearLayout r6 = new android.widget.LinearLayout     // Catch:{ all -> 0x0483 }
            android.app.Activity r7 = r1.zzl     // Catch:{ all -> 0x0483 }
            r6.<init>(r7)     // Catch:{ all -> 0x0483 }
            r1.zzo = r6     // Catch:{ all -> 0x0483 }
            android.widget.RelativeLayout$LayoutParams r6 = new android.widget.RelativeLayout$LayoutParams     // Catch:{ all -> 0x0483 }
            com.google.android.gms.ads.internal.client.zzay.zzb()     // Catch:{ all -> 0x0483 }
            android.app.Activity r7 = r1.zzl     // Catch:{ all -> 0x0483 }
            int r7 = com.google.android.gms.ads.internal.util.client.zzf.zzy(r7, r15)     // Catch:{ all -> 0x0483 }
            com.google.android.gms.ads.internal.client.zzay.zzb()     // Catch:{ all -> 0x0483 }
            android.app.Activity r13 = r1.zzl     // Catch:{ all -> 0x0483 }
            int r13 = com.google.android.gms.ads.internal.util.client.zzf.zzy(r13, r15)     // Catch:{ all -> 0x0483 }
            r6.<init>(r7, r13)     // Catch:{ all -> 0x0483 }
            java.lang.String r7 = r1.zzb     // Catch:{ all -> 0x0483 }
            int r13 = r7.hashCode()     // Catch:{ all -> 0x0483 }
            switch(r13) {
                case -1364013995: goto L_0x0376;
                case -1012429441: goto L_0x036c;
                case -655373719: goto L_0x0362;
                case 1163912186: goto L_0x0358;
                case 1288627767: goto L_0x034e;
                case 1755462605: goto L_0x0344;
                default: goto L_0x0343;
            }
        L_0x0343:
            goto L_0x0380
        L_0x0344:
            java.lang.String r13 = "top-center"
            boolean r7 = r7.equals(r13)
            if (r7 == 0) goto L_0x0380
            r13 = r8
            goto L_0x0381
        L_0x034e:
            java.lang.String r13 = "bottom-center"
            boolean r7 = r7.equals(r13)
            if (r7 == 0) goto L_0x0380
            r13 = r11
            goto L_0x0381
        L_0x0358:
            java.lang.String r13 = "bottom-right"
            boolean r7 = r7.equals(r13)
            if (r7 == 0) goto L_0x0380
            r13 = r10
            goto L_0x0381
        L_0x0362:
            java.lang.String r13 = "bottom-left"
            boolean r7 = r7.equals(r13)
            if (r7 == 0) goto L_0x0380
            r13 = r12
            goto L_0x0381
        L_0x036c:
            java.lang.String r13 = "top-left"
            boolean r7 = r7.equals(r13)
            if (r7 == 0) goto L_0x0380
            r13 = 0
            goto L_0x0381
        L_0x0376:
            java.lang.String r13 = "center"
            boolean r7 = r7.equals(r13)
            if (r7 == 0) goto L_0x0380
            r13 = r14
            goto L_0x0381
        L_0x0380:
            r13 = r9
        L_0x0381:
            r7 = 9
            r9 = 10
            if (r13 == 0) goto L_0x03c0
            r15 = 14
            if (r13 == r8) goto L_0x03b9
            if (r13 == r14) goto L_0x03b3
            r14 = 12
            if (r13 == r12) goto L_0x03ac
            if (r13 == r11) goto L_0x03a5
            r7 = 11
            if (r13 == r10) goto L_0x039e
            r6.addRule(r9)     // Catch:{ all -> 0x0483 }
            r6.addRule(r7)     // Catch:{ all -> 0x0483 }
            goto L_0x03c6
        L_0x039e:
            r6.addRule(r14)     // Catch:{ all -> 0x0483 }
            r6.addRule(r7)     // Catch:{ all -> 0x0483 }
            goto L_0x03c6
        L_0x03a5:
            r6.addRule(r14)     // Catch:{ all -> 0x0483 }
            r6.addRule(r15)     // Catch:{ all -> 0x0483 }
            goto L_0x03c6
        L_0x03ac:
            r6.addRule(r14)     // Catch:{ all -> 0x0483 }
            r6.addRule(r7)     // Catch:{ all -> 0x0483 }
            goto L_0x03c6
        L_0x03b3:
            r7 = 13
            r6.addRule(r7)     // Catch:{ all -> 0x0483 }
            goto L_0x03c6
        L_0x03b9:
            r6.addRule(r9)     // Catch:{ all -> 0x0483 }
            r6.addRule(r15)     // Catch:{ all -> 0x0483 }
            goto L_0x03c6
        L_0x03c0:
            r6.addRule(r9)     // Catch:{ all -> 0x0483 }
            r6.addRule(r7)     // Catch:{ all -> 0x0483 }
        L_0x03c6:
            android.widget.LinearLayout r7 = r1.zzo     // Catch:{ all -> 0x0483 }
            com.google.android.gms.internal.ads.zzbtl r9 = new com.google.android.gms.internal.ads.zzbtl     // Catch:{ all -> 0x0483 }
            r9.<init>(r1)     // Catch:{ all -> 0x0483 }
            r7.setOnClickListener(r9)     // Catch:{ all -> 0x0483 }
            android.widget.LinearLayout r7 = r1.zzo     // Catch:{ all -> 0x0483 }
            java.lang.String r9 = "Close button"
            r7.setContentDescription(r9)     // Catch:{ all -> 0x0483 }
            android.widget.RelativeLayout r7 = r1.zzr     // Catch:{ all -> 0x0483 }
            android.widget.LinearLayout r9 = r1.zzo     // Catch:{ all -> 0x0483 }
            r7.addView(r9, r6)     // Catch:{ all -> 0x0483 }
            android.widget.PopupWindow r6 = r1.zzq     // Catch:{ RuntimeException -> 0x0436 }
            android.view.View r0 = r0.getDecorView()     // Catch:{ RuntimeException -> 0x0436 }
            com.google.android.gms.ads.internal.client.zzay.zzb()     // Catch:{ RuntimeException -> 0x0436 }
            android.app.Activity r7 = r1.zzl     // Catch:{ RuntimeException -> 0x0436 }
            r9 = 0
            r10 = r16[r9]     // Catch:{ RuntimeException -> 0x0436 }
            int r7 = com.google.android.gms.ads.internal.util.client.zzf.zzy(r7, r10)     // Catch:{ RuntimeException -> 0x0436 }
            com.google.android.gms.ads.internal.client.zzay.zzb()     // Catch:{ RuntimeException -> 0x0436 }
            android.app.Activity r9 = r1.zzl     // Catch:{ RuntimeException -> 0x0436 }
            r10 = r16[r8]     // Catch:{ RuntimeException -> 0x0436 }
            int r9 = com.google.android.gms.ads.internal.util.client.zzf.zzy(r9, r10)     // Catch:{ RuntimeException -> 0x0436 }
            r10 = 0
            r6.showAtLocation(r0, r10, r7, r9)     // Catch:{ RuntimeException -> 0x0436 }
            r0 = r16[r10]     // Catch:{ all -> 0x0483 }
            r2 = r16[r8]     // Catch:{ all -> 0x0483 }
            com.google.android.gms.internal.ads.zzbtt r6 = r1.zzp     // Catch:{ all -> 0x0483 }
            if (r6 == 0) goto L_0x040e
            int r7 = r1.zzi     // Catch:{ all -> 0x0483 }
            int r9 = r1.zzf     // Catch:{ all -> 0x0483 }
            r6.zza(r0, r2, r7, r9)     // Catch:{ all -> 0x0483 }
        L_0x040e:
            com.google.android.gms.internal.ads.zzcgm r0 = r1.zzk     // Catch:{ all -> 0x0483 }
            com.google.android.gms.internal.ads.zzcie r2 = com.google.android.gms.internal.ads.zzcie.zzb(r4, r5)     // Catch:{ all -> 0x0483 }
            r0.zzah(r2)     // Catch:{ all -> 0x0483 }
            r0 = 0
            r2 = r16[r0]     // Catch:{ all -> 0x0483 }
            r4 = r16[r8]     // Catch:{ all -> 0x0483 }
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch:{ all -> 0x0483 }
            android.app.Activity r5 = r1.zzl     // Catch:{ all -> 0x0483 }
            int[] r5 = com.google.android.gms.ads.internal.util.zzt.zzR(r5)     // Catch:{ all -> 0x0483 }
            r0 = r5[r0]     // Catch:{ all -> 0x0483 }
            int r4 = r4 - r0
            int r0 = r1.zzi     // Catch:{ all -> 0x0483 }
            int r5 = r1.zzf     // Catch:{ all -> 0x0483 }
            r1.zzk(r2, r4, r0, r5)     // Catch:{ all -> 0x0483 }
            java.lang.String r0 = "resized"
            r1.zzl(r0)     // Catch:{ all -> 0x0483 }
            monitor-exit(r3)     // Catch:{ all -> 0x0483 }
            return
        L_0x0436:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0483 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0483 }
            r4.<init>(r2)     // Catch:{ all -> 0x0483 }
            r4.append(r0)     // Catch:{ all -> 0x0483 }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x0483 }
            r1.zzh(r0)     // Catch:{ all -> 0x0483 }
            android.widget.RelativeLayout r0 = r1.zzr     // Catch:{ all -> 0x0483 }
            com.google.android.gms.internal.ads.zzcgm r2 = r1.zzk     // Catch:{ all -> 0x0483 }
            android.view.View r2 = (android.view.View) r2     // Catch:{ all -> 0x0483 }
            r0.removeView(r2)     // Catch:{ all -> 0x0483 }
            android.view.ViewGroup r0 = r1.zzs     // Catch:{ all -> 0x0483 }
            if (r0 == 0) goto L_0x046c
            android.widget.ImageView r2 = r1.zzn     // Catch:{ all -> 0x0483 }
            r0.removeView(r2)     // Catch:{ all -> 0x0483 }
            android.view.ViewGroup r0 = r1.zzs     // Catch:{ all -> 0x0483 }
            com.google.android.gms.internal.ads.zzcgm r2 = r1.zzk     // Catch:{ all -> 0x0483 }
            android.view.View r2 = (android.view.View) r2     // Catch:{ all -> 0x0483 }
            r0.addView(r2)     // Catch:{ all -> 0x0483 }
            com.google.android.gms.internal.ads.zzcgm r0 = r1.zzk     // Catch:{ all -> 0x0483 }
            com.google.android.gms.internal.ads.zzcie r2 = r1.zzm     // Catch:{ all -> 0x0483 }
            r0.zzah(r2)     // Catch:{ all -> 0x0483 }
        L_0x046c:
            monitor-exit(r3)     // Catch:{ all -> 0x0483 }
            return
        L_0x046e:
            java.lang.String r0 = "Webview is detached, probably in the middle of a resize or expand."
            r1.zzh(r0)     // Catch:{ all -> 0x0483 }
            monitor-exit(r3)     // Catch:{ all -> 0x0483 }
            return
        L_0x0475:
            java.lang.String r0 = "Activity context is not ready, cannot get window or decor view."
            r1.zzh(r0)     // Catch:{ all -> 0x0483 }
            monitor-exit(r3)     // Catch:{ all -> 0x0483 }
            return
        L_0x047c:
            java.lang.String r0 = "Invalid width and height options. Cannot resize."
            r1.zzh(r0)     // Catch:{ all -> 0x0483 }
            monitor-exit(r3)     // Catch:{ all -> 0x0483 }
            return
        L_0x0483:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0483 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbtm.zzb(java.util.Map):void");
    }

    public final void zzd(int i, int i2, boolean z) {
        synchronized (this.zzj) {
            this.zzd = i;
            this.zze = i2;
        }
    }

    public final void zze(int i, int i2) {
        this.zzd = i;
        this.zze = i2;
    }

    public final boolean zzf() {
        boolean z;
        synchronized (this.zzj) {
            z = this.zzq != null;
        }
        return z;
    }
}
