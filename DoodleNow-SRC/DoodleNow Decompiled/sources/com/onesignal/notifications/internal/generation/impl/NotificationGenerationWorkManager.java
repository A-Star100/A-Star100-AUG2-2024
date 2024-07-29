package com.onesignal.notifications.internal.generation.impl;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkerParameters;
import com.onesignal.common.AndroidUtils;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.internal.common.NotificationFormatHelper;
import com.onesignal.notifications.internal.common.OSWorkManagerHelper;
import com.onesignal.notifications.internal.generation.INotificationGenerationWorkManager;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012B\u0005¢\u0006\u0002\u0010\u0002JB\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0016¨\u0006\u0013"}, d2 = {"Lcom/onesignal/notifications/internal/generation/impl/NotificationGenerationWorkManager;", "Lcom/onesignal/notifications/internal/generation/INotificationGenerationWorkManager;", "()V", "beginEnqueueingWork", "", "context", "Landroid/content/Context;", "osNotificationId", "", "androidNotificationId", "", "jsonPayload", "Lorg/json/JSONObject;", "timestamp", "", "isRestoring", "isHighPriority", "Companion", "NotificationGenerationWorker", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NotificationGenerationWorkManager.kt */
public final class NotificationGenerationWorkManager implements INotificationGenerationWorkManager {
    private static final String ANDROID_NOTIF_ID_WORKER_DATA_PARAM = "android_notif_id";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String IS_RESTORING_WORKER_DATA_PARAM = "is_restoring";
    private static final String JSON_PAYLOAD_WORKER_DATA_PARAM = "json_payload";
    private static final String OS_ID_DATA_PARAM = "os_notif_id";
    private static final String TIMESTAMP_WORKER_DATA_PARAM = "timestamp";
    /* access modifiers changed from: private */
    public static final ConcurrentHashMap<String, Boolean> notificationIds = new ConcurrentHashMap<>();

    public boolean beginEnqueueingWork(Context context, String str, int i, JSONObject jSONObject, long j, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "osNotificationId");
        String oSNotificationIdFromJson = NotificationFormatHelper.INSTANCE.getOSNotificationIdFromJson(jSONObject);
        if (oSNotificationIdFromJson == null) {
            Logging.debug$default("Notification beginEnqueueingWork with id null", (Throwable) null, 2, (Object) null);
            return false;
        } else if (!Companion.addNotificationIdProcessed(oSNotificationIdFromJson)) {
            Logging.debug$default("Notification beginEnqueueingWork with id duplicated", (Throwable) null, 2, (Object) null);
            return true;
        } else {
            Data build = new Data.Builder().putString(OS_ID_DATA_PARAM, oSNotificationIdFromJson).putInt(ANDROID_NOTIF_ID_WORKER_DATA_PARAM, i).putString(JSON_PAYLOAD_WORKER_DATA_PARAM, String.valueOf(jSONObject)).putLong("timestamp", j).putBoolean(IS_RESTORING_WORKER_DATA_PARAM, z).build();
            Intrinsics.checkNotNullExpressionValue(build, "Builder()\n              …\n                .build()");
            Logging.debug$default("NotificationWorkManager enqueueing notification work with notificationId: " + str + " and jsonPayload: " + jSONObject, (Throwable) null, 2, (Object) null);
            OSWorkManagerHelper.INSTANCE.getInstance(context).enqueueUniqueWork(str, ExistingWorkPolicy.KEEP, (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(NotificationGenerationWorker.class).setInputData(build)).build());
            return true;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/onesignal/notifications/internal/generation/impl/NotificationGenerationWorkManager$NotificationGenerationWorker;", "Landroidx/work/CoroutineWorker;", "context", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: NotificationGenerationWorkManager.kt */
    public static final class NotificationGenerationWorker extends CoroutineWorker {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NotificationGenerationWorker(Context context, WorkerParameters workerParameters) {
            super(context, workerParameters);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(workerParameters, "workerParams");
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x004c  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0033  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object doWork(kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> r21) {
            /*
                r20 = this;
                r0 = r21
                java.lang.String r1 = "Error occurred doing work for job with id: "
                java.lang.String r2 = "NotificationWorker running doWork with data: "
                boolean r3 = r0 instanceof com.onesignal.notifications.internal.generation.impl.NotificationGenerationWorkManager$NotificationGenerationWorker$doWork$1
                if (r3 == 0) goto L_0x001c
                r3 = r0
                com.onesignal.notifications.internal.generation.impl.NotificationGenerationWorkManager$NotificationGenerationWorker$doWork$1 r3 = (com.onesignal.notifications.internal.generation.impl.NotificationGenerationWorkManager$NotificationGenerationWorker$doWork$1) r3
                int r4 = r3.label
                r5 = -2147483648(0xffffffff80000000, float:-0.0)
                r4 = r4 & r5
                if (r4 == 0) goto L_0x001c
                int r0 = r3.label
                int r0 = r0 - r5
                r3.label = r0
                r4 = r20
                goto L_0x0023
            L_0x001c:
                com.onesignal.notifications.internal.generation.impl.NotificationGenerationWorkManager$NotificationGenerationWorker$doWork$1 r3 = new com.onesignal.notifications.internal.generation.impl.NotificationGenerationWorkManager$NotificationGenerationWorker$doWork$1
                r4 = r20
                r3.<init>(r4, r0)
            L_0x0023:
                r12 = r3
                java.lang.Object r0 = r12.result
                java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r5 = r12.label
                java.lang.String r13 = "failure()"
                java.lang.String r14 = "success()"
                r6 = 1
                if (r5 == 0) goto L_0x004c
                if (r5 != r6) goto L_0x0044
                java.lang.Object r2 = r12.L$0
                java.lang.String r2 = (java.lang.String) r2
                kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ JSONException -> 0x0041 }
                goto L_0x00df
            L_0x003e:
                r0 = move-exception
                goto L_0x0115
            L_0x0041:
                r0 = move-exception
                goto L_0x00f4
            L_0x0044:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L_0x004c:
                kotlin.ResultKt.throwOnFailure(r0)
                android.content.Context r0 = r20.getApplicationContext()
                java.lang.String r5 = "applicationContext"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)
                boolean r0 = com.onesignal.OneSignal.initWithContext(r0)
                if (r0 != 0) goto L_0x0066
                androidx.work.ListenableWorker$Result r0 = androidx.work.ListenableWorker.Result.success()
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r14)
                return r0
            L_0x0066:
                com.onesignal.OneSignal r0 = com.onesignal.OneSignal.INSTANCE
                com.onesignal.common.services.IServiceProvider r0 = r0.getServices()
                java.lang.Class<com.onesignal.notifications.internal.generation.INotificationGenerationProcessor> r7 = com.onesignal.notifications.internal.generation.INotificationGenerationProcessor.class
                java.lang.Object r0 = r0.getService(r7)
                com.onesignal.notifications.internal.generation.INotificationGenerationProcessor r0 = (com.onesignal.notifications.internal.generation.INotificationGenerationProcessor) r0
                androidx.work.Data r7 = r20.getInputData()
                java.lang.String r8 = "inputData"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
                java.lang.String r8 = "os_notif_id"
                java.lang.String r15 = r7.getString(r8)
                if (r15 != 0) goto L_0x008d
                androidx.work.ListenableWorker$Result r0 = androidx.work.ListenableWorker.Result.failure()
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r13)
                return r0
            L_0x008d:
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x00f2, all -> 0x00ef }
                r8.<init>(r2)     // Catch:{ JSONException -> 0x00f2, all -> 0x00ef }
                r8.append(r7)     // Catch:{ JSONException -> 0x00f2, all -> 0x00ef }
                java.lang.String r2 = r8.toString()     // Catch:{ JSONException -> 0x00f2, all -> 0x00ef }
                r8 = 2
                r9 = 0
                com.onesignal.debug.internal.logging.Logging.debug$default(r2, r9, r8, r9)     // Catch:{ JSONException -> 0x00f2, all -> 0x00ef }
                java.lang.String r2 = "android_notif_id"
                r8 = 0
                int r2 = r7.getInt(r2, r8)     // Catch:{ JSONException -> 0x00f2, all -> 0x00ef }
                org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00f2, all -> 0x00ef }
                java.lang.String r10 = "json_payload"
                java.lang.String r10 = r7.getString(r10)     // Catch:{ JSONException -> 0x00f2, all -> 0x00ef }
                r9.<init>(r10)     // Catch:{ JSONException -> 0x00f2, all -> 0x00ef }
                java.lang.String r10 = "timestamp"
                long r16 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x00f2, all -> 0x00ef }
                r18 = 1000(0x3e8, double:4.94E-321)
                r11 = r9
                long r8 = r16 / r18
                long r16 = r7.getLong(r10, r8)     // Catch:{ JSONException -> 0x00f2, all -> 0x00ef }
                java.lang.String r8 = "is_restoring"
                r9 = 0
                boolean r9 = r7.getBoolean(r8, r9)     // Catch:{ JSONException -> 0x00f2, all -> 0x00ef }
                android.content.Context r7 = r20.getApplicationContext()     // Catch:{ JSONException -> 0x00f2, all -> 0x00ef }
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r5)     // Catch:{ JSONException -> 0x00f2, all -> 0x00ef }
                r12.L$0 = r15     // Catch:{ JSONException -> 0x00f2, all -> 0x00ef }
                r12.label = r6     // Catch:{ JSONException -> 0x00f2, all -> 0x00ef }
                r5 = r0
                r6 = r7
                r7 = r2
                r8 = r11
                r10 = r16
                java.lang.Object r0 = r5.processNotificationData(r6, r7, r8, r9, r10, r12)     // Catch:{ JSONException -> 0x00f2, all -> 0x00ef }
                if (r0 != r3) goto L_0x00de
                return r3
            L_0x00de:
                r2 = r15
            L_0x00df:
                com.onesignal.notifications.internal.generation.impl.NotificationGenerationWorkManager$Companion r0 = com.onesignal.notifications.internal.generation.impl.NotificationGenerationWorkManager.Companion
                kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
                r0.removeNotificationIdProcessed(r2)
                androidx.work.ListenableWorker$Result r0 = androidx.work.ListenableWorker.Result.success()
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r14)
                return r0
            L_0x00ef:
                r0 = move-exception
                r2 = r15
                goto L_0x0115
            L_0x00f2:
                r0 = move-exception
                r2 = r15
            L_0x00f4:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x003e }
                r3.<init>(r1)     // Catch:{ all -> 0x003e }
                r3.append(r2)     // Catch:{ all -> 0x003e }
                java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x003e }
                java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ all -> 0x003e }
                com.onesignal.debug.internal.logging.Logging.error(r1, r0)     // Catch:{ all -> 0x003e }
                androidx.work.ListenableWorker$Result r0 = androidx.work.ListenableWorker.Result.failure()     // Catch:{ all -> 0x003e }
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r13)     // Catch:{ all -> 0x003e }
                com.onesignal.notifications.internal.generation.impl.NotificationGenerationWorkManager$Companion r1 = com.onesignal.notifications.internal.generation.impl.NotificationGenerationWorkManager.Companion
                kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
                r1.removeNotificationIdProcessed(r2)
                return r0
            L_0x0115:
                com.onesignal.notifications.internal.generation.impl.NotificationGenerationWorkManager$Companion r1 = com.onesignal.notifications.internal.generation.impl.NotificationGenerationWorkManager.Companion
                kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
                r1.removeNotificationIdProcessed(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.generation.impl.NotificationGenerationWorkManager.NotificationGenerationWorker.doWork(kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/onesignal/notifications/internal/generation/impl/NotificationGenerationWorkManager$Companion;", "", "()V", "ANDROID_NOTIF_ID_WORKER_DATA_PARAM", "", "IS_RESTORING_WORKER_DATA_PARAM", "JSON_PAYLOAD_WORKER_DATA_PARAM", "OS_ID_DATA_PARAM", "TIMESTAMP_WORKER_DATA_PARAM", "notificationIds", "Ljava/util/concurrent/ConcurrentHashMap;", "", "addNotificationIdProcessed", "osNotificationId", "removeNotificationIdProcessed", "", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: NotificationGenerationWorkManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean addNotificationIdProcessed(String str) {
            Intrinsics.checkNotNullParameter(str, "osNotificationId");
            if (AndroidUtils.INSTANCE.isStringNotEmpty(str)) {
                if (NotificationGenerationWorkManager.notificationIds.contains(str)) {
                    Logging.debug$default("OSNotificationWorkManager notification with notificationId: " + str + " already queued", (Throwable) null, 2, (Object) null);
                    return false;
                }
                NotificationGenerationWorkManager.notificationIds.put(str, true);
            }
            return true;
        }

        public final void removeNotificationIdProcessed(String str) {
            Intrinsics.checkNotNullParameter(str, "osNotificationId");
            if (AndroidUtils.INSTANCE.isStringNotEmpty(str)) {
                NotificationGenerationWorkManager.notificationIds.remove(str);
            }
        }
    }
}
