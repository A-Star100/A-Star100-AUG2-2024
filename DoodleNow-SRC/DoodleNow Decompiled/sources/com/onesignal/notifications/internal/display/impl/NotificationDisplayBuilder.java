package com.onesignal.notifications.internal.display.impl;

import android.R;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.onesignal.common.AndroidUtils;
import com.onesignal.core.R;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.internal.bundle.impl.NotificationBundleProcessor;
import com.onesignal.notifications.internal.channels.INotificationChannelManager;
import com.onesignal.notifications.internal.common.NotificationConstants;
import com.onesignal.notifications.internal.common.NotificationHelper;
import com.onesignal.notifications.internal.display.INotificationDisplayBuilder;
import com.onesignal.notifications.receivers.NotificationDismissReceiver;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001:\u0001UB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J4\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001a0#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001a0#H\u0002J,\u0010%\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001a0#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001a0#H\u0002J4\u0010&\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\u00142\b\u0010,\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010-\u001a\u00020\u001e2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u000201H\u0016J\u0010\u00102\u001a\u00020\u00142\u0006\u00103\u001a\u00020\u0014H\u0002J\u0012\u00104\u001a\u0004\u0018\u0001052\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u00106\u001a\u00020/2\u0006\u00107\u001a\u000208H\u0016J\u0014\u00109\u001a\u0004\u0018\u00010\u00102\b\u0010:\u001a\u0004\u0018\u00010\u001aH\u0002J\u0012\u0010;\u001a\u0004\u0018\u00010\u00102\u0006\u0010<\u001a\u00020\u001aH\u0002J\u0012\u0010=\u001a\u0004\u0018\u00010\u00102\u0006\u0010>\u001a\u00020\u001aH\u0002J\u0010\u0010?\u001a\u00020\u00142\u0006\u0010:\u001a\u00020\u001aH\u0002J\b\u0010@\u001a\u00020\u0014H\u0016J\u0012\u0010A\u001a\u0004\u0018\u00010\u00102\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010B\u001a\u00020C2\u0006\u0010+\u001a\u00020\u0014H\u0016J\u0018\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u00142\u0006\u0010G\u001a\u00020CH\u0016J\u0012\u0010H\u001a\u00020\u00142\b\u0010I\u001a\u0004\u0018\u00010\u001aH\u0002J\u0010\u0010J\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010K\u001a\u00020L2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010M\u001a\u00020N2\u0006\u0010 \u001a\u00020!H\u0002J\u0012\u0010O\u001a\u00020\u001e2\b\u0010P\u001a\u0004\u0018\u00010*H\u0016J\u0014\u0010Q\u001a\u0004\u0018\u00010\u00102\b\u0010R\u001a\u0004\u0018\u00010\u0010H\u0002J\u0018\u0010S\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!2\u0006\u0010T\u001a\u00020*H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8BX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0018X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u001a8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006V"}, d2 = {"Lcom/onesignal/notifications/internal/display/impl/NotificationDisplayBuilder;", "Lcom/onesignal/notifications/internal/display/INotificationDisplayBuilder;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_notificationChannelManager", "Lcom/onesignal/notifications/internal/channels/INotificationChannelManager;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/notifications/internal/channels/INotificationChannelManager;)V", "contextResources", "Landroid/content/res/Resources;", "getContextResources", "()Landroid/content/res/Resources;", "currentContext", "Landroid/content/Context;", "getCurrentContext", "()Landroid/content/Context;", "defaultLargeIcon", "Landroid/graphics/Bitmap;", "getDefaultLargeIcon", "()Landroid/graphics/Bitmap;", "defaultSmallIconId", "", "getDefaultSmallIconId", "()I", "notificationDismissedClass", "Ljava/lang/Class;", "packageName", "", "getPackageName", "()Ljava/lang/String;", "addAlertButtons", "", "context", "fcmJson", "Lorg/json/JSONObject;", "buttonsLabels", "", "buttonsIds", "addCustomAlertButtons", "addNotificationActionButtons", "intentGenerator", "Lcom/onesignal/notifications/internal/display/impl/IntentGeneratorForAttachingToNotifications;", "mBuilder", "Landroidx/core/app/NotificationCompat$Builder;", "notificationId", "groupSummary", "addXiaomiSettings", "oneSignalNotificationBuilder", "Lcom/onesignal/notifications/internal/display/impl/NotificationDisplayBuilder$OneSignalNotificationBuilder;", "notification", "Landroid/app/Notification;", "convertOSToAndroidPriority", "priority", "getAccentColor", "Ljava/math/BigInteger;", "getBaseOneSignalNotificationBuilder", "notificationJob", "Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;", "getBitmap", "name", "getBitmapFromAssetsOrResourceName", "bitmapStr", "getBitmapFromURL", "location", "getDrawableId", "getGroupAlertBehavior", "getLargeIcon", "getNewBaseDismissIntent", "Landroid/content/Intent;", "getNewDismissActionPendingIntent", "Landroid/app/PendingIntent;", "requestCode", "intent", "getResourceIcon", "iconName", "getSmallIconId", "getTitle", "", "isSoundEnabled", "", "removeNotifyOptions", "builder", "resizeBitmapForLargeIconArea", "bitmap", "setAlertnessOptions", "notifBuilder", "OneSignalNotificationBuilder", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NotificationDisplayBuilder.kt */
public final class NotificationDisplayBuilder implements INotificationDisplayBuilder {
    private final IApplicationService _applicationService;
    private final INotificationChannelManager _notificationChannelManager;
    private final Class<?> notificationDismissedClass = NotificationDismissReceiver.class;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/onesignal/notifications/internal/display/impl/NotificationDisplayBuilder$OneSignalNotificationBuilder;", "", "()V", "compatBuilder", "Landroidx/core/app/NotificationCompat$Builder;", "getCompatBuilder", "()Landroidx/core/app/NotificationCompat$Builder;", "setCompatBuilder", "(Landroidx/core/app/NotificationCompat$Builder;)V", "hasLargeIcon", "", "getHasLargeIcon", "()Z", "setHasLargeIcon", "(Z)V", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: NotificationDisplayBuilder.kt */
    public static final class OneSignalNotificationBuilder {
        private NotificationCompat.Builder compatBuilder;
        private boolean hasLargeIcon;

        public final NotificationCompat.Builder getCompatBuilder() {
            return this.compatBuilder;
        }

        public final boolean getHasLargeIcon() {
            return this.hasLargeIcon;
        }

        public final void setCompatBuilder(NotificationCompat.Builder builder) {
            this.compatBuilder = builder;
        }

        public final void setHasLargeIcon(boolean z) {
            this.hasLargeIcon = z;
        }
    }

    private final int convertOSToAndroidPriority(int i) {
        if (i > 9) {
            return 2;
        }
        if (i > 7) {
            return 1;
        }
        if (i > 4) {
            return 0;
        }
        return i > 2 ? -1 : -2;
    }

    public int getGroupAlertBehavior() {
        return Build.VERSION.SDK_INT >= 24 ? 2 : 1;
    }

    public NotificationDisplayBuilder(IApplicationService iApplicationService, INotificationChannelManager iNotificationChannelManager) {
        Intrinsics.checkNotNullParameter(iApplicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(iNotificationChannelManager, "_notificationChannelManager");
        this._applicationService = iApplicationService;
        this._notificationChannelManager = iNotificationChannelManager;
    }

    private final Resources getContextResources() {
        return this._applicationService.getAppContext().getResources();
    }

    private final Context getCurrentContext() {
        return this._applicationService.getAppContext();
    }

    private final String getPackageName() {
        return this._applicationService.getAppContext().getPackageName();
    }

    public CharSequence getTitle(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "fcmJson");
        CharSequence optString = jSONObject.optString("title", (String) null);
        if (optString != null) {
            return optString;
        }
        Context currentContext = getCurrentContext();
        Intrinsics.checkNotNull(currentContext);
        PackageManager packageManager = currentContext.getPackageManager();
        Context currentContext2 = getCurrentContext();
        Intrinsics.checkNotNull(currentContext2);
        CharSequence applicationLabel = packageManager.getApplicationLabel(currentContext2.getApplicationInfo());
        Intrinsics.checkNotNullExpressionValue(applicationLabel, "currentContext!!.package…cationInfo,\n            )");
        return applicationLabel;
    }

    public PendingIntent getNewDismissActionPendingIntent(int i, Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        PendingIntent broadcast = PendingIntent.getBroadcast(getCurrentContext(), i, intent, 201326592);
        Intrinsics.checkNotNullExpressionValue(broadcast, "getBroadcast(\n          …FLAG_IMMUTABLE,\n        )");
        return broadcast;
    }

    public Intent getNewBaseDismissIntent(int i) {
        Intent putExtra = new Intent(getCurrentContext(), this.notificationDismissedClass).putExtra(NotificationConstants.BUNDLE_KEY_ANDROID_NOTIFICATION_ID, i).putExtra("dismissed", true);
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(currentContext, n…tExtra(\"dismissed\", true)");
        return putExtra;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0086 */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x008c A[Catch:{ all -> 0x009e }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x009a A[Catch:{ all -> 0x009e }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ce A[SYNTHETIC, Splitter:B:29:0x00ce] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.onesignal.notifications.internal.display.impl.NotificationDisplayBuilder.OneSignalNotificationBuilder getBaseOneSignalNotificationBuilder(com.onesignal.notifications.internal.common.NotificationGenerationJob r10) {
        /*
            r9 = this;
            java.lang.String r0 = "vis"
            java.lang.String r1 = "notificationJob"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r1)
            org.json.JSONObject r1 = r10.getJsonPayload()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            com.onesignal.notifications.internal.display.impl.NotificationDisplayBuilder$OneSignalNotificationBuilder r2 = new com.onesignal.notifications.internal.display.impl.NotificationDisplayBuilder$OneSignalNotificationBuilder
            r2.<init>()
            com.onesignal.notifications.internal.channels.INotificationChannelManager r3 = r9._notificationChannelManager     // Catch:{ all -> 0x0026 }
            java.lang.String r3 = r3.createNotificationChannel(r10)     // Catch:{ all -> 0x0026 }
            androidx.core.app.NotificationCompat$Builder r4 = new androidx.core.app.NotificationCompat$Builder     // Catch:{ all -> 0x0026 }
            android.content.Context r5 = r9.getCurrentContext()     // Catch:{ all -> 0x0026 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)     // Catch:{ all -> 0x0026 }
            r4.<init>((android.content.Context) r5, (java.lang.String) r3)     // Catch:{ all -> 0x0026 }
            goto L_0x0032
        L_0x0026:
            androidx.core.app.NotificationCompat$Builder r4 = new androidx.core.app.NotificationCompat$Builder
            android.content.Context r3 = r9.getCurrentContext()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            r4.<init>(r3)
        L_0x0032:
            java.lang.String r3 = "alert"
            r5 = 0
            java.lang.String r3 = r1.optString(r3, r5)
            r6 = 1
            androidx.core.app.NotificationCompat$Builder r7 = r4.setAutoCancel(r6)
            int r8 = r9.getSmallIconId(r1)
            androidx.core.app.NotificationCompat$Builder r7 = r7.setSmallIcon((int) r8)
            androidx.core.app.NotificationCompat$BigTextStyle r8 = new androidx.core.app.NotificationCompat$BigTextStyle
            r8.<init>()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            androidx.core.app.NotificationCompat$BigTextStyle r8 = r8.bigText(r3)
            androidx.core.app.NotificationCompat$Style r8 = (androidx.core.app.NotificationCompat.Style) r8
            androidx.core.app.NotificationCompat$Builder r7 = r7.setStyle(r8)
            androidx.core.app.NotificationCompat$Builder r7 = r7.setContentText(r3)
            r7.setTicker(r3)
            int r7 = android.os.Build.VERSION.SDK_INT
            r8 = 24
            if (r7 < r8) goto L_0x0072
            java.lang.String r7 = "title"
            java.lang.String r7 = r1.optString(r7)
            java.lang.String r8 = ""
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r7 != 0) goto L_0x0079
        L_0x0072:
            java.lang.CharSequence r7 = r9.getTitle(r1)
            r4.setContentTitle(r7)
        L_0x0079:
            java.math.BigInteger r7 = r9.getAccentColor(r1)     // Catch:{ all -> 0x0086 }
            if (r7 == 0) goto L_0x0086
            int r7 = r7.intValue()     // Catch:{ all -> 0x0086 }
            r4.setColor(r7)     // Catch:{ all -> 0x0086 }
        L_0x0086:
            boolean r7 = r1.has(r0)     // Catch:{ all -> 0x009e }
            if (r7 == 0) goto L_0x009a
            java.lang.String r0 = r1.optString(r0)     // Catch:{ all -> 0x009e }
            java.lang.String r7 = "fcmJson.optString(\"vis\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r7)     // Catch:{ all -> 0x009e }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ all -> 0x009e }
            goto L_0x009b
        L_0x009a:
            r0 = r6
        L_0x009b:
            r4.setVisibility(r0)     // Catch:{ all -> 0x009e }
        L_0x009e:
            android.graphics.Bitmap r0 = r9.getLargeIcon(r1)
            if (r0 == 0) goto L_0x00aa
            r2.setHasLargeIcon(r6)
            r4.setLargeIcon((android.graphics.Bitmap) r0)
        L_0x00aa:
            java.lang.String r0 = "bicon"
            java.lang.String r0 = r1.optString(r0, r5)
            android.graphics.Bitmap r0 = r9.getBitmap(r0)
            if (r0 == 0) goto L_0x00c8
            androidx.core.app.NotificationCompat$BigPictureStyle r5 = new androidx.core.app.NotificationCompat$BigPictureStyle
            r5.<init>()
            androidx.core.app.NotificationCompat$BigPictureStyle r0 = r5.bigPicture((android.graphics.Bitmap) r0)
            androidx.core.app.NotificationCompat$BigPictureStyle r0 = r0.setSummaryText(r3)
            androidx.core.app.NotificationCompat$Style r0 = (androidx.core.app.NotificationCompat.Style) r0
            r4.setStyle(r0)
        L_0x00c8:
            java.lang.Long r0 = r10.getShownTimeStamp()
            if (r0 == 0) goto L_0x00df
            java.lang.Long r10 = r10.getShownTimeStamp()     // Catch:{ all -> 0x00df }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)     // Catch:{ all -> 0x00df }
            long r5 = r10.longValue()     // Catch:{ all -> 0x00df }
            r7 = 1000(0x3e8, double:4.94E-321)
            long r5 = r5 * r7
            r4.setWhen(r5)     // Catch:{ all -> 0x00df }
        L_0x00df:
            r9.setAlertnessOptions(r1, r4)
            r2.setCompatBuilder(r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.display.impl.NotificationDisplayBuilder.getBaseOneSignalNotificationBuilder(com.onesignal.notifications.internal.common.NotificationGenerationJob):com.onesignal.notifications.internal.display.impl.NotificationDisplayBuilder$OneSignalNotificationBuilder");
    }

    private final void setAlertnessOptions(JSONObject jSONObject, NotificationCompat.Builder builder) {
        int convertOSToAndroidPriority = convertOSToAndroidPriority(jSONObject.optInt("pri", 6));
        builder.setPriority(convertOSToAndroidPriority);
        if (convertOSToAndroidPriority >= 0) {
            int i = 4;
            if (jSONObject.has("ledc") && jSONObject.optInt("led", 1) == 1) {
                try {
                    builder.setLights(new BigInteger(jSONObject.optString("ledc"), 16).intValue(), 2000, 5000);
                    i = 0;
                } catch (Throwable unused) {
                }
            }
            if (jSONObject.optInt("vib", 1) == 1) {
                if (jSONObject.has("vib_pt")) {
                    long[] parseVibrationPattern = NotificationHelper.INSTANCE.parseVibrationPattern(jSONObject);
                    if (parseVibrationPattern != null) {
                        builder.setVibrate(parseVibrationPattern);
                    }
                } else {
                    i |= 2;
                }
            }
            if (isSoundEnabled(jSONObject)) {
                NotificationHelper notificationHelper = NotificationHelper.INSTANCE;
                Context currentContext = getCurrentContext();
                Intrinsics.checkNotNull(currentContext);
                Uri soundUri = notificationHelper.getSoundUri(currentContext, jSONObject.optString("sound", (String) null));
                if (soundUri != null) {
                    builder.setSound(soundUri);
                } else {
                    i |= 1;
                }
            }
            builder.setDefaults(i);
        }
    }

    public void removeNotifyOptions(NotificationCompat.Builder builder) {
        Intrinsics.checkNotNull(builder);
        builder.setOnlyAlertOnce(true).setDefaults(0).setSound((Uri) null).setVibrate((long[]) null).setTicker((CharSequence) null);
    }

    public void addXiaomiSettings(OneSignalNotificationBuilder oneSignalNotificationBuilder, Notification notification) {
        Intrinsics.checkNotNullParameter(notification, OneSignalDbContract.NotificationTable.TABLE_NAME);
        Intrinsics.checkNotNull(oneSignalNotificationBuilder);
        if (oneSignalNotificationBuilder.getHasLargeIcon()) {
            try {
                Object newInstance = Class.forName("android.app.MiuiNotification").newInstance();
                Field declaredField = newInstance.getClass().getDeclaredField("customizedIcon");
                declaredField.setAccessible(true);
                declaredField.set(newInstance, true);
                Field field = notification.getClass().getField("extraNotification");
                field.setAccessible(true);
                field.set(notification, newInstance);
            } catch (Throwable unused) {
            }
        }
    }

    private final Bitmap getLargeIcon(JSONObject jSONObject) {
        Bitmap bitmap = getBitmap(jSONObject.optString("licon"));
        if (bitmap == null) {
            bitmap = getBitmapFromAssetsOrResourceName("ic_onesignal_large_icon_default");
        }
        if (bitmap != null) {
            return resizeBitmapForLargeIconArea(bitmap);
        }
        Bitmap bitmap2 = null;
        return null;
    }

    public Bitmap getDefaultLargeIcon() {
        return resizeBitmapForLargeIconArea(getBitmapFromAssetsOrResourceName("ic_onesignal_large_icon_default"));
    }

    private final Bitmap resizeBitmapForLargeIconArea(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            Resources contextResources = getContextResources();
            Intrinsics.checkNotNull(contextResources);
            int dimension = (int) contextResources.getDimension(R.dimen.notification_large_icon_height);
            Resources contextResources2 = getContextResources();
            Intrinsics.checkNotNull(contextResources2);
            int dimension2 = (int) contextResources2.getDimension(R.dimen.notification_large_icon_width);
            int height = bitmap.getHeight();
            int width = bitmap.getWidth();
            if (width <= dimension2 && height <= dimension) {
                return bitmap;
            }
            if (height > width) {
                dimension2 = (int) (((float) dimension) * (((float) width) / ((float) height)));
            } else if (width > height) {
                dimension = (int) (((float) dimension2) * (((float) height) / ((float) width)));
            }
            return Bitmap.createScaledBitmap(bitmap, dimension2, dimension, true);
        } catch (Throwable unused) {
            return bitmap;
        }
    }

    private final Bitmap getBitmapFromAssetsOrResourceName(String str) {
        Bitmap bitmap;
        try {
            Context currentContext = getCurrentContext();
            Intrinsics.checkNotNull(currentContext);
            bitmap = BitmapFactory.decodeStream(currentContext.getAssets().open(str));
        } catch (Throwable unused) {
            bitmap = null;
        }
        if (bitmap != null) {
            return bitmap;
        }
        try {
            for (String str2 : Arrays.asList(new String[]{".png", ".webp", ".jpg", ".gif", ".bmp"})) {
                try {
                    Context currentContext2 = getCurrentContext();
                    Intrinsics.checkNotNull(currentContext2);
                    bitmap = BitmapFactory.decodeStream(currentContext2.getAssets().open(str + str2));
                    continue;
                } catch (Throwable unused2) {
                }
                if (bitmap != null) {
                    return bitmap;
                }
            }
            int resourceIcon = getResourceIcon(str);
            if (resourceIcon != 0) {
                return BitmapFactory.decodeResource(getContextResources(), resourceIcon);
            }
        } catch (Throwable unused3) {
        }
        return null;
    }

    private final Bitmap getBitmapFromURL(String str) {
        try {
            return BitmapFactory.decodeStream(new URL(str).openConnection().getInputStream());
        } catch (Throwable th) {
            Logging.warn("Could not download image!", th);
            return null;
        }
    }

    private final int getSmallIconId(JSONObject jSONObject) {
        int resourceIcon = getResourceIcon(jSONObject.optString("sicon", (String) null));
        return resourceIcon != 0 ? resourceIcon : getDefaultSmallIconId();
    }

    public int getDefaultSmallIconId() {
        int drawableId = getDrawableId("ic_stat_onesignal_default");
        if (drawableId != 0) {
            return drawableId;
        }
        int drawableId2 = getDrawableId("corona_statusbar_icon_default");
        if (drawableId2 != 0) {
            return drawableId2;
        }
        int drawableId3 = getDrawableId("ic_os_notification_fallback_white_24dp");
        if (drawableId3 != 0) {
            return drawableId3;
        }
        return 17301598;
    }

    private final int getDrawableId(String str) {
        Resources contextResources = getContextResources();
        Intrinsics.checkNotNull(contextResources);
        return contextResources.getIdentifier(str, "drawable", getPackageName());
    }

    private final boolean isSoundEnabled(JSONObject jSONObject) {
        String optString = jSONObject.optString("sound", (String) null);
        return !Intrinsics.areEqual((Object) "null", (Object) optString) && !Intrinsics.areEqual((Object) "nil", (Object) optString);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|(2:4|5)|6|7|(2:9|10)|11|12|(2:14|15)|16) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0015 */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003b A[Catch:{ all -> 0x0041 }] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0025 A[Catch:{ all -> 0x002b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.math.BigInteger getAccentColor(org.json.JSONObject r5) {
        /*
            r4 = this;
            java.lang.String r0 = "bgac"
            r1 = 16
            r2 = 0
            boolean r3 = r5.has(r0)     // Catch:{ all -> 0x0015 }
            if (r3 == 0) goto L_0x0015
            java.math.BigInteger r3 = new java.math.BigInteger     // Catch:{ all -> 0x0015 }
            java.lang.String r5 = r5.optString(r0, r2)     // Catch:{ all -> 0x0015 }
            r3.<init>(r5, r1)     // Catch:{ all -> 0x0015 }
            return r3
        L_0x0015:
            com.onesignal.common.AndroidUtils r5 = com.onesignal.common.AndroidUtils.INSTANCE     // Catch:{ all -> 0x002b }
            com.onesignal.core.internal.application.IApplicationService r0 = r4._applicationService     // Catch:{ all -> 0x002b }
            android.content.Context r0 = r0.getAppContext()     // Catch:{ all -> 0x002b }
            java.lang.String r3 = "onesignal_notification_accent_color"
            java.lang.String r5 = r5.getResourceString(r0, r3, r2)     // Catch:{ all -> 0x002b }
            if (r5 == 0) goto L_0x002b
            java.math.BigInteger r0 = new java.math.BigInteger     // Catch:{ all -> 0x002b }
            r0.<init>(r5, r1)     // Catch:{ all -> 0x002b }
            return r0
        L_0x002b:
            com.onesignal.common.AndroidUtils r5 = com.onesignal.common.AndroidUtils.INSTANCE     // Catch:{ all -> 0x0041 }
            com.onesignal.core.internal.application.IApplicationService r0 = r4._applicationService     // Catch:{ all -> 0x0041 }
            android.content.Context r0 = r0.getAppContext()     // Catch:{ all -> 0x0041 }
            java.lang.String r3 = "com.onesignal.NotificationAccentColor.DEFAULT"
            java.lang.String r5 = r5.getManifestMeta(r0, r3)     // Catch:{ all -> 0x0041 }
            if (r5 == 0) goto L_0x0041
            java.math.BigInteger r0 = new java.math.BigInteger     // Catch:{ all -> 0x0041 }
            r0.<init>(r5, r1)     // Catch:{ all -> 0x0041 }
            return r0
        L_0x0041:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.display.impl.NotificationDisplayBuilder.getAccentColor(org.json.JSONObject):java.math.BigInteger");
    }

    public void addNotificationActionButtons(JSONObject jSONObject, IntentGeneratorForAttachingToNotifications intentGeneratorForAttachingToNotifications, NotificationCompat.Builder builder, int i, String str) {
        int i2;
        JSONObject jSONObject2 = jSONObject;
        IntentGeneratorForAttachingToNotifications intentGeneratorForAttachingToNotifications2 = intentGeneratorForAttachingToNotifications;
        int i3 = i;
        String str2 = str;
        Intrinsics.checkNotNullParameter(jSONObject2, "fcmJson");
        Intrinsics.checkNotNullParameter(intentGeneratorForAttachingToNotifications2, "intentGenerator");
        try {
            JSONObject jSONObject3 = new JSONObject(jSONObject2.optString("custom"));
            if (jSONObject3.has("a")) {
                JSONObject jSONObject4 = jSONObject3.getJSONObject("a");
                if (jSONObject4.has("actionButtons")) {
                    JSONArray jSONArray = jSONObject4.getJSONArray("actionButtons");
                    int length = jSONArray.length();
                    for (int i4 = 0; i4 < length; i4++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i4);
                        JSONObject jSONObject5 = new JSONObject(jSONObject.toString());
                        Intent newBaseIntent = intentGeneratorForAttachingToNotifications2.getNewBaseIntent(i3);
                        newBaseIntent.setAction("" + i4);
                        newBaseIntent.putExtra("action_button", true);
                        jSONObject5.put(NotificationConstants.GENERATE_NOTIFICATION_BUNDLE_KEY_ACTION_ID, optJSONObject.optString("id"));
                        newBaseIntent.putExtra(NotificationConstants.BUNDLE_KEY_ONESIGNAL_DATA, jSONObject5.toString());
                        if (str2 != null) {
                            newBaseIntent.putExtra("summary", str2);
                        } else if (jSONObject2.has("grp")) {
                            newBaseIntent.putExtra("grp", jSONObject2.optString("grp"));
                        }
                        PendingIntent newActionPendingIntent = intentGeneratorForAttachingToNotifications2.getNewActionPendingIntent(i3, newBaseIntent);
                        if (optJSONObject.has("icon")) {
                            try {
                                i2 = getResourceIcon(optJSONObject.optString("icon"));
                            } catch (Throwable th) {
                                th = th;
                                th.printStackTrace();
                            }
                        } else {
                            i2 = 0;
                        }
                        Intrinsics.checkNotNull(builder);
                        builder.addAction(i2, optJSONObject.optString("text"), newActionPendingIntent);
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            th.printStackTrace();
        }
    }

    private final void addAlertButtons(Context context, JSONObject jSONObject, List<String> list, List<String> list2) {
        try {
            addCustomAlertButtons(jSONObject, list, list2);
        } catch (Throwable th) {
            Logging.error("Failed to parse JSON for custom buttons for alert dialog.", th);
        }
        if (list.size() == 0 || list.size() < 3) {
            String resourceString = AndroidUtils.INSTANCE.getResourceString(context, "onesignal_in_app_alert_ok_button_text", "Ok");
            Intrinsics.checkNotNull(resourceString);
            list.add(resourceString);
            list2.add(NotificationBundleProcessor.DEFAULT_ACTION);
        }
    }

    private final void addCustomAlertButtons(JSONObject jSONObject, List<String> list, List<String> list2) throws JSONException {
        JSONObject jSONObject2 = new JSONObject(jSONObject.optString("custom"));
        if (jSONObject2.has("a")) {
            JSONObject jSONObject3 = jSONObject2.getJSONObject("a");
            if (jSONObject3.has("actionButtons")) {
                JSONArray optJSONArray = jSONObject3.optJSONArray("actionButtons");
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject4 = optJSONArray.getJSONObject(i);
                    String optString = jSONObject4.optString("text");
                    Intrinsics.checkNotNullExpressionValue(optString, "button.optString(\"text\")");
                    list.add(optString);
                    String optString2 = jSONObject4.optString("id");
                    Intrinsics.checkNotNullExpressionValue(optString2, "button.optString(\"id\")");
                    list2.add(optString2);
                }
            }
        }
    }

    private final Bitmap getBitmap(String str) {
        if (str == null) {
            return null;
        }
        CharSequence charSequence = str;
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) charSequence.charAt(!z ? i : length), 32) <= 0;
            if (!z) {
                if (!z2) {
                    z = true;
                } else {
                    i++;
                }
            } else if (!z2) {
                break;
            } else {
                length--;
            }
        }
        String obj = charSequence.subSequence(i, length + 1).toString();
        if (StringsKt.startsWith$default(obj, "http://", false, 2, (Object) null) || StringsKt.startsWith$default(obj, "https://", false, 2, (Object) null)) {
            return getBitmapFromURL(obj);
        }
        return getBitmapFromAssetsOrResourceName(str);
    }

    private final int getResourceIcon(String str) {
        if (str == null) {
            return 0;
        }
        CharSequence charSequence = str;
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) charSequence.charAt(!z ? i : length), 32) <= 0;
            if (!z) {
                if (!z2) {
                    z = true;
                } else {
                    i++;
                }
            } else if (!z2) {
                break;
            } else {
                length--;
            }
        }
        String obj = charSequence.subSequence(i, length + 1).toString();
        if (!AndroidUtils.INSTANCE.isValidResourceName(obj)) {
            return 0;
        }
        int drawableId = getDrawableId(obj);
        if (drawableId != 0) {
            return drawableId;
        }
        try {
            return R.drawable.class.getField(str).getInt((Object) null);
        } catch (Throwable unused) {
            return 0;
        }
    }
}
