package com.onesignal.notifications.internal.generation.impl;

import com.onesignal.common.AndroidUtils;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.internal.Notification;
import com.onesignal.notifications.internal.common.NotificationGenerationJob;
import com.onesignal.notifications.internal.data.INotificationRepository;
import com.onesignal.notifications.internal.display.INotificationDisplayer;
import com.onesignal.notifications.internal.generation.INotificationGenerationProcessor;
import com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService;
import com.onesignal.notifications.internal.summary.INotificationSummaryManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ)\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0015H@ø\u0001\u0000¢\u0006\u0002\u0010#J\u0019\u0010$\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001dH@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ+\u0010%\u001a\u0004\u0018\u00010\u00152\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\u0015H@ø\u0001\u0000¢\u0006\u0002\u0010#J9\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u00152\u0006\u0010.\u001a\u00020/H@ø\u0001\u0000¢\u0006\u0002\u00100J!\u00101\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u0015H@ø\u0001\u0000¢\u0006\u0002\u00103J\u0010\u00104\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u001dH\u0002J\u0010\u00105\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u001dH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00066"}, d2 = {"Lcom/onesignal/notifications/internal/generation/impl/NotificationGenerationProcessor;", "Lcom/onesignal/notifications/internal/generation/INotificationGenerationProcessor;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_notificationDisplayer", "Lcom/onesignal/notifications/internal/display/INotificationDisplayer;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_dataController", "Lcom/onesignal/notifications/internal/data/INotificationRepository;", "_notificationSummaryManager", "Lcom/onesignal/notifications/internal/summary/INotificationSummaryManager;", "_lifecycleService", "Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleService;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/notifications/internal/display/INotificationDisplayer;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/notifications/internal/data/INotificationRepository;Lcom/onesignal/notifications/internal/summary/INotificationSummaryManager;Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleService;Lcom/onesignal/core/internal/time/ITime;)V", "getCustomJSONObject", "Lorg/json/JSONObject;", "jsonObject", "isDuplicateNotification", "", "notification", "Lcom/onesignal/notifications/internal/Notification;", "(Lcom/onesignal/notifications/internal/Notification;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isNotificationWithinTTL", "markNotificationAsDismissed", "", "notifiJob", "Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;", "(Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postProcessNotification", "notificationJob", "wasOpened", "wasDisplayed", "(Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processCollapseKey", "processHandlerResponse", "wantsToDisplay", "isRestoring", "processNotificationData", "context", "Landroid/content/Context;", "androidNotificationId", "", "jsonPayload", "timestamp", "", "(Landroid/content/Context;ILorg/json/JSONObject;ZJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveNotification", "opened", "(Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldDisplayNotification", "shouldFireForegroundHandlers", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NotificationGenerationProcessor.kt */
public final class NotificationGenerationProcessor implements INotificationGenerationProcessor {
    private final IApplicationService _applicationService;
    private final ConfigModelStore _configModelStore;
    private final INotificationRepository _dataController;
    /* access modifiers changed from: private */
    public final INotificationLifecycleService _lifecycleService;
    private final INotificationDisplayer _notificationDisplayer;
    private final INotificationSummaryManager _notificationSummaryManager;
    private final ITime _time;

    public NotificationGenerationProcessor(IApplicationService iApplicationService, INotificationDisplayer iNotificationDisplayer, ConfigModelStore configModelStore, INotificationRepository iNotificationRepository, INotificationSummaryManager iNotificationSummaryManager, INotificationLifecycleService iNotificationLifecycleService, ITime iTime) {
        Intrinsics.checkNotNullParameter(iApplicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(iNotificationDisplayer, "_notificationDisplayer");
        Intrinsics.checkNotNullParameter(configModelStore, "_configModelStore");
        Intrinsics.checkNotNullParameter(iNotificationRepository, "_dataController");
        Intrinsics.checkNotNullParameter(iNotificationSummaryManager, "_notificationSummaryManager");
        Intrinsics.checkNotNullParameter(iNotificationLifecycleService, "_lifecycleService");
        Intrinsics.checkNotNullParameter(iTime, "_time");
        this._applicationService = iApplicationService;
        this._notificationDisplayer = iNotificationDisplayer;
        this._configModelStore = configModelStore;
        this._dataController = iNotificationRepository;
        this._notificationSummaryManager = iNotificationSummaryManager;
        this._lifecycleService = iNotificationLifecycleService;
        this._time = iTime;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v47, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v25, resolved type: kotlin.jvm.internal.Ref$BooleanRef} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v48, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v21, resolved type: com.onesignal.notifications.internal.common.NotificationGenerationJob} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v49, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v11, resolved type: com.onesignal.notifications.internal.Notification} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v50, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v0, resolved type: com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v54, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v15, resolved type: kotlin.jvm.internal.Ref$BooleanRef} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v55, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v7, resolved type: com.onesignal.notifications.internal.common.NotificationGenerationJob} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v56, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v30, resolved type: com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor} */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x02ce, code lost:
        r0 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x02d0, code lost:
        r0 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x02d5, code lost:
        if (r14.isRestoring() == false) goto L_0x02d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x02d7, code lost:
        if (r5 == 0) goto L_0x02da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x02da, code lost:
        r11 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x02db, code lost:
        r3.L$0 = null;
        r3.L$1 = null;
        r3.L$2 = null;
        r3.L$3 = null;
        r3.Z$0 = r0;
        r3.label = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x02ee, code lost:
        if (r13.postProcessNotification(r14, false, r11, r3) == r4) goto L_0x02f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x02f0, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x02f1, code lost:
        if (r0 != false) goto L_0x02f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x02f3, code lost:
        r3.L$0 = null;
        r3.L$1 = null;
        r3.L$2 = null;
        r3.L$3 = null;
        r3.label = 9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0305, code lost:
        if (kotlinx.coroutines.DelayKt.delay(100, r3) == r4) goto L_0x0307;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0307, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x030a, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x030d, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0310, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0129, code lost:
        if (((java.lang.Boolean) r2).booleanValue() != false) goto L_0x012e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x012d, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x012e, code lost:
        r2 = new com.onesignal.notifications.internal.Notification((java.util.List<com.onesignal.notifications.internal.Notification>) null, r8, r6, r5._time);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0135, code lost:
        if (r0 != false) goto L_0x0169;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0137, code lost:
        r3.L$0 = r5;
        r3.L$1 = r13;
        r3.L$2 = r8;
        r3.L$3 = r2;
        r3.Z$0 = r0;
        r3.J$0 = r14;
        r3.label = 2;
        r6 = r5.isDuplicateNotification(r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0149, code lost:
        if (r6 != r4) goto L_0x014c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x014b, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x014c, code lost:
        r17 = r5;
        r5 = r2;
        r2 = r6;
        r6 = r17;
        r15 = r13;
        r13 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x015d, code lost:
        if (((java.lang.Boolean) r2).booleanValue() == false) goto L_0x0162;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0161, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0162, code lost:
        r2 = r0;
        r17 = r13;
        r13 = r15;
        r14 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0169, code lost:
        r6 = r5;
        r5 = r2;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x016c, code lost:
        r7 = new com.onesignal.notifications.internal.common.NotificationGenerationJob(r5, r8);
        r7.setShownTimeStamp(kotlin.coroutines.jvm.internal.Boxing.boxLong(r14));
        r7.setRestoring(r2);
        r8 = new kotlin.jvm.internal.Ref.BooleanRef();
        r8.element = true;
        com.onesignal.debug.internal.logging.Logging.info$default("Fire remoteNotificationReceived", (java.lang.Throwable) null, 2, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        r3.L$0 = r6;
        r3.L$1 = r5;
        r3.L$2 = r7;
        r3.L$3 = r8;
        r3.Z$0 = r2;
        r3.I$0 = 0;
        r3.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x01b5, code lost:
        if (kotlinx.coroutines.TimeoutKt.withTimeout(30000, new com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processNotificationData$2(r6, new com.onesignal.notifications.internal.NotificationReceivedEvent(r13, r5), r8, r5, (kotlin.coroutines.Continuation<? super com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processNotificationData$2>) null), r3) != r4) goto L_0x01b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x01b7, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x01b8, code lost:
        r15 = r5;
        r14 = r7;
        r13 = r8;
        r5 = 0;
        r8 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01be, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x01bf, code lost:
        r15 = r5;
        r14 = r7;
        r13 = r8;
        r5 = 0;
        r8 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01ca, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01cb, code lost:
        r15 = r5;
        r14 = r7;
        r13 = r8;
        r5 = 0;
        r8 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0201, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0202, code lost:
        r7 = r13;
        r13 = r6;
        r6 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0205, code lost:
        r2 = (java.lang.Boolean) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0207, code lost:
        if (r2 != null) goto L_0x0209;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0209, code lost:
        r0 = r2.booleanValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x020d, code lost:
        if (r0 != false) goto L_0x020f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0213, code lost:
        if (r13.shouldFireForegroundHandlers(r14) != false) goto L_0x0215;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0215, code lost:
        com.onesignal.debug.internal.logging.Logging.info$default("Fire notificationWillShowInForegroundHandler", (java.lang.Throwable) null, 2, (java.lang.Object) null);
        r7.element = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        r3.L$0 = r13;
        r3.L$1 = r14;
        r3.L$2 = r7;
        r3.L$3 = null;
        r3.Z$0 = r6;
        r3.I$0 = r5;
        r3.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x024e, code lost:
        if (kotlinx.coroutines.TimeoutKt.withTimeout(30000, new com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processNotificationData$3(r13, new com.onesignal.notifications.internal.NotificationWillDisplayEvent(r14.getNotification()), r7, r15, (kotlin.coroutines.Continuation<? super com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processNotificationData$3>) null), r3) == r4) goto L_0x0250;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0250, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0251, code lost:
        r10 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0253, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0254, code lost:
        r10 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x025b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x025c, code lost:
        r10 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x025d, code lost:
        com.onesignal.debug.internal.logging.Logging.info("notificationWillShowInForegroundHandler timed out, continuing with wantsToDisplay=" + r7.element + '.', r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0293, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0298, code lost:
        r14 = r6;
        r6 = r7;
        r17 = r2.booleanValue();
        r2 = r0;
        r0 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x02a6, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x02a7, code lost:
        r2 = r5;
        r5 = r6;
        r6 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x02aa, code lost:
        if (r0 == false) goto L_0x02ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x02ac, code lost:
        r0 = r6._notificationDisplayer;
        r3.L$0 = r6;
        r3.L$1 = r14;
        r3.L$2 = null;
        r3.L$3 = null;
        r3.Z$0 = r5;
        r3.label = 7;
        r2 = r0.displayNotification(r14, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x02bf, code lost:
        if (r2 == r4) goto L_0x02c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x02c1, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x02c2, code lost:
        r0 = r5;
        r5 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x02c4, code lost:
        r2 = ((java.lang.Boolean) r2).booleanValue();
        r14 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x02cb, code lost:
        r13 = r6;
        r5 = r2;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x02ce  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x02d7  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x02f3  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x030b  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0201 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0202  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0293 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0298  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x02a4  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x02ac  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object processNotificationData(android.content.Context r21, int r22, org.json.JSONObject r23, boolean r24, long r25, kotlin.coroutines.Continuation<? super kotlin.Unit> r27) {
        /*
            r20 = this;
            r1 = r20
            r0 = r23
            r2 = r27
            boolean r3 = r2 instanceof com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processNotificationData$1
            if (r3 == 0) goto L_0x001a
            r3 = r2
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processNotificationData$1 r3 = (com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processNotificationData$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001f
        L_0x001a:
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processNotificationData$1 r3 = new com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processNotificationData$1
            r3.<init>(r1, r2)
        L_0x001f:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r9 = 0
            r10 = 2
            r11 = 1
            r12 = 0
            switch(r5) {
                case 0: goto L_0x00fc;
                case 1: goto L_0x00e0;
                case 2: goto L_0x00c7;
                case 3: goto L_0x009d;
                case 4: goto L_0x0080;
                case 5: goto L_0x0062;
                case 6: goto L_0x0051;
                case 7: goto L_0x0042;
                case 8: goto L_0x003b;
                case 9: goto L_0x0036;
                default: goto L_0x002e;
            }
        L_0x002e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x0308
        L_0x003b:
            boolean r0 = r3.Z$0
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x02f1
        L_0x0042:
            boolean r0 = r3.Z$0
            java.lang.Object r5 = r3.L$1
            com.onesignal.notifications.internal.common.NotificationGenerationJob r5 = (com.onesignal.notifications.internal.common.NotificationGenerationJob) r5
            java.lang.Object r6 = r3.L$0
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor r6 = (com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor) r6
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x02c4
        L_0x0051:
            int r0 = r3.I$0
            boolean r5 = r3.Z$0
            java.lang.Object r6 = r3.L$1
            com.onesignal.notifications.internal.common.NotificationGenerationJob r6 = (com.onesignal.notifications.internal.common.NotificationGenerationJob) r6
            java.lang.Object r7 = r3.L$0
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor r7 = (com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor) r7
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x0294
        L_0x0062:
            int r5 = r3.I$0
            boolean r6 = r3.Z$0
            java.lang.Object r0 = r3.L$2
            r7 = r0
            kotlin.jvm.internal.Ref$BooleanRef r7 = (kotlin.jvm.internal.Ref.BooleanRef) r7
            java.lang.Object r0 = r3.L$1
            r10 = r0
            com.onesignal.notifications.internal.common.NotificationGenerationJob r10 = (com.onesignal.notifications.internal.common.NotificationGenerationJob) r10
            java.lang.Object r0 = r3.L$0
            r13 = r0
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor r13 = (com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor) r13
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ TimeoutCancellationException -> 0x007d, all -> 0x007a }
            goto L_0x0277
        L_0x007a:
            r0 = move-exception
            goto L_0x0255
        L_0x007d:
            r0 = move-exception
            goto L_0x025d
        L_0x0080:
            int r0 = r3.I$0
            boolean r5 = r3.Z$0
            java.lang.Object r13 = r3.L$3
            kotlin.jvm.internal.Ref$BooleanRef r13 = (kotlin.jvm.internal.Ref.BooleanRef) r13
            java.lang.Object r14 = r3.L$2
            com.onesignal.notifications.internal.common.NotificationGenerationJob r14 = (com.onesignal.notifications.internal.common.NotificationGenerationJob) r14
            java.lang.Object r15 = r3.L$1
            com.onesignal.notifications.internal.Notification r15 = (com.onesignal.notifications.internal.Notification) r15
            java.lang.Object r8 = r3.L$0
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor r8 = (com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor) r8
            kotlin.ResultKt.throwOnFailure(r2)
            r6 = r5
            r7 = r13
            r5 = r0
            r13 = r8
            goto L_0x0205
        L_0x009d:
            int r5 = r3.I$0
            boolean r8 = r3.Z$0
            java.lang.Object r0 = r3.L$3
            r13 = r0
            kotlin.jvm.internal.Ref$BooleanRef r13 = (kotlin.jvm.internal.Ref.BooleanRef) r13
            java.lang.Object r0 = r3.L$2
            r14 = r0
            com.onesignal.notifications.internal.common.NotificationGenerationJob r14 = (com.onesignal.notifications.internal.common.NotificationGenerationJob) r14
            java.lang.Object r0 = r3.L$1
            r15 = r0
            com.onesignal.notifications.internal.Notification r15 = (com.onesignal.notifications.internal.Notification) r15
            java.lang.Object r0 = r3.L$0
            r16 = r0
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor r16 = (com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor) r16
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ TimeoutCancellationException -> 0x00c2, all -> 0x00bd }
            r6 = r16
            goto L_0x01ea
        L_0x00bd:
            r0 = move-exception
            r6 = r16
            goto L_0x01c4
        L_0x00c2:
            r0 = move-exception
            r6 = r16
            goto L_0x01d0
        L_0x00c7:
            long r13 = r3.J$0
            boolean r0 = r3.Z$0
            java.lang.Object r5 = r3.L$3
            com.onesignal.notifications.internal.Notification r5 = (com.onesignal.notifications.internal.Notification) r5
            java.lang.Object r8 = r3.L$2
            org.json.JSONObject r8 = (org.json.JSONObject) r8
            java.lang.Object r15 = r3.L$1
            android.content.Context r15 = (android.content.Context) r15
            java.lang.Object r6 = r3.L$0
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor r6 = (com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor) r6
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x0157
        L_0x00e0:
            long r5 = r3.J$0
            boolean r0 = r3.Z$0
            int r7 = r3.I$0
            java.lang.Object r8 = r3.L$2
            org.json.JSONObject r8 = (org.json.JSONObject) r8
            java.lang.Object r13 = r3.L$1
            android.content.Context r13 = (android.content.Context) r13
            java.lang.Object r14 = r3.L$0
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor r14 = (com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor) r14
            kotlin.ResultKt.throwOnFailure(r2)
            r17 = r5
            r6 = r7
            r5 = r14
            r14 = r17
            goto L_0x0123
        L_0x00fc:
            kotlin.ResultKt.throwOnFailure(r2)
            com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService r2 = r1._lifecycleService
            r3.L$0 = r1
            r5 = r21
            r3.L$1 = r5
            r3.L$2 = r0
            r6 = r22
            r3.I$0 = r6
            r7 = r24
            r3.Z$0 = r7
            r13 = r25
            r3.J$0 = r13
            r3.label = r11
            java.lang.Object r2 = r2.canReceiveNotification(r0, r3)
            if (r2 != r4) goto L_0x011e
            return r4
        L_0x011e:
            r8 = r0
            r0 = r7
            r14 = r13
            r13 = r5
            r5 = r1
        L_0x0123:
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L_0x012e
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x012e:
            com.onesignal.notifications.internal.Notification r2 = new com.onesignal.notifications.internal.Notification
            com.onesignal.core.internal.time.ITime r7 = r5._time
            r2.<init>(r12, r8, r6, r7)
            if (r0 != 0) goto L_0x0169
            r3.L$0 = r5
            r3.L$1 = r13
            r3.L$2 = r8
            r3.L$3 = r2
            r3.Z$0 = r0
            r3.J$0 = r14
            r3.label = r10
            java.lang.Object r6 = r5.isDuplicateNotification(r2, r3)
            if (r6 != r4) goto L_0x014c
            return r4
        L_0x014c:
            r17 = r5
            r5 = r2
            r2 = r6
            r6 = r17
            r18 = r14
            r15 = r13
            r13 = r18
        L_0x0157:
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x0162
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0162:
            r2 = r0
            r17 = r13
            r13 = r15
            r14 = r17
            goto L_0x016c
        L_0x0169:
            r6 = r5
            r5 = r2
            r2 = r0
        L_0x016c:
            com.onesignal.notifications.internal.common.NotificationGenerationJob r7 = new com.onesignal.notifications.internal.common.NotificationGenerationJob
            r7.<init>((com.onesignal.notifications.internal.Notification) r5, (org.json.JSONObject) r8)
            java.lang.Long r0 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r14)
            r7.setShownTimeStamp(r0)
            r7.setRestoring(r2)
            kotlin.jvm.internal.Ref$BooleanRef r8 = new kotlin.jvm.internal.Ref$BooleanRef
            r8.<init>()
            r8.element = r11
            java.lang.String r0 = "Fire remoteNotificationReceived"
            com.onesignal.debug.internal.logging.Logging.info$default(r0, r12, r10, r12)
            com.onesignal.notifications.internal.NotificationReceivedEvent r0 = new com.onesignal.notifications.internal.NotificationReceivedEvent     // Catch:{ TimeoutCancellationException -> 0x01ca, all -> 0x01be }
            r0.<init>(r13, r5)     // Catch:{ TimeoutCancellationException -> 0x01ca, all -> 0x01be }
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processNotificationData$2 r13 = new com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processNotificationData$2     // Catch:{ TimeoutCancellationException -> 0x01ca, all -> 0x01be }
            r14 = 0
            r21 = r13
            r22 = r6
            r23 = r0
            r24 = r8
            r25 = r5
            r26 = r14
            r21.<init>(r22, r23, r24, r25, r26)     // Catch:{ TimeoutCancellationException -> 0x01ca, all -> 0x01be }
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13     // Catch:{ TimeoutCancellationException -> 0x01ca, all -> 0x01be }
            r3.L$0 = r6     // Catch:{ TimeoutCancellationException -> 0x01ca, all -> 0x01be }
            r3.L$1 = r5     // Catch:{ TimeoutCancellationException -> 0x01ca, all -> 0x01be }
            r3.L$2 = r7     // Catch:{ TimeoutCancellationException -> 0x01ca, all -> 0x01be }
            r3.L$3 = r8     // Catch:{ TimeoutCancellationException -> 0x01ca, all -> 0x01be }
            r3.Z$0 = r2     // Catch:{ TimeoutCancellationException -> 0x01ca, all -> 0x01be }
            r3.I$0 = r9     // Catch:{ TimeoutCancellationException -> 0x01ca, all -> 0x01be }
            r0 = 3
            r3.label = r0     // Catch:{ TimeoutCancellationException -> 0x01ca, all -> 0x01be }
            r14 = 30000(0x7530, double:1.4822E-319)
            java.lang.Object r0 = kotlinx.coroutines.TimeoutKt.withTimeout(r14, r13, r3)     // Catch:{ TimeoutCancellationException -> 0x01ca, all -> 0x01be }
            if (r0 != r4) goto L_0x01b8
            return r4
        L_0x01b8:
            r15 = r5
            r14 = r7
            r13 = r8
            r5 = r9
            r8 = r2
            goto L_0x01ea
        L_0x01be:
            r0 = move-exception
            r15 = r5
            r14 = r7
            r13 = r8
            r5 = r9
            r8 = r2
        L_0x01c4:
            java.lang.String r2 = "remoteNotificationReceived threw an exception. Displaying normal OneSignal notification."
            com.onesignal.debug.internal.logging.Logging.error(r2, r0)
            goto L_0x01ea
        L_0x01ca:
            r0 = move-exception
            r15 = r5
            r14 = r7
            r13 = r8
            r5 = r9
            r8 = r2
        L_0x01d0:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r7 = "remoteNotificationReceived timed out, continuing with wantsToDisplay="
            r2.<init>(r7)
            boolean r7 = r13.element
            r2.append(r7)
            r7 = 46
            r2.append(r7)
            java.lang.String r2 = r2.toString()
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            com.onesignal.debug.internal.logging.Logging.error(r2, r0)
        L_0x01ea:
            boolean r0 = r13.element
            r3.L$0 = r6
            r3.L$1 = r15
            r3.L$2 = r14
            r3.L$3 = r13
            r3.Z$0 = r8
            r3.I$0 = r5
            r2 = 4
            r3.label = r2
            java.lang.Object r2 = r6.processHandlerResponse(r14, r0, r8, r3)
            if (r2 != r4) goto L_0x0202
            return r4
        L_0x0202:
            r7 = r13
            r13 = r6
            r6 = r8
        L_0x0205:
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            if (r2 == 0) goto L_0x030e
            boolean r0 = r2.booleanValue()
            if (r0 == 0) goto L_0x02d0
            boolean r2 = r13.shouldFireForegroundHandlers(r14)
            if (r2 == 0) goto L_0x02a7
            java.lang.String r0 = "Fire notificationWillShowInForegroundHandler"
            com.onesignal.debug.internal.logging.Logging.info$default(r0, r12, r10, r12)
            r7.element = r11
            com.onesignal.notifications.internal.NotificationWillDisplayEvent r0 = new com.onesignal.notifications.internal.NotificationWillDisplayEvent     // Catch:{ TimeoutCancellationException -> 0x025b, all -> 0x0253 }
            com.onesignal.notifications.internal.Notification r2 = r14.getNotification()     // Catch:{ TimeoutCancellationException -> 0x025b, all -> 0x0253 }
            r0.<init>(r2)     // Catch:{ TimeoutCancellationException -> 0x025b, all -> 0x0253 }
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processNotificationData$3 r2 = new com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processNotificationData$3     // Catch:{ TimeoutCancellationException -> 0x025b, all -> 0x0253 }
            r8 = 0
            r21 = r2
            r22 = r13
            r23 = r0
            r24 = r7
            r25 = r15
            r26 = r8
            r21.<init>(r22, r23, r24, r25, r26)     // Catch:{ TimeoutCancellationException -> 0x025b, all -> 0x0253 }
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2     // Catch:{ TimeoutCancellationException -> 0x025b, all -> 0x0253 }
            r3.L$0 = r13     // Catch:{ TimeoutCancellationException -> 0x025b, all -> 0x0253 }
            r3.L$1 = r14     // Catch:{ TimeoutCancellationException -> 0x025b, all -> 0x0253 }
            r3.L$2 = r7     // Catch:{ TimeoutCancellationException -> 0x025b, all -> 0x0253 }
            r3.L$3 = r12     // Catch:{ TimeoutCancellationException -> 0x025b, all -> 0x0253 }
            r3.Z$0 = r6     // Catch:{ TimeoutCancellationException -> 0x025b, all -> 0x0253 }
            r3.I$0 = r5     // Catch:{ TimeoutCancellationException -> 0x025b, all -> 0x0253 }
            r0 = 5
            r3.label = r0     // Catch:{ TimeoutCancellationException -> 0x025b, all -> 0x0253 }
            r9 = 30000(0x7530, double:1.4822E-319)
            java.lang.Object r0 = kotlinx.coroutines.TimeoutKt.withTimeout(r9, r2, r3)     // Catch:{ TimeoutCancellationException -> 0x025b, all -> 0x0253 }
            if (r0 != r4) goto L_0x0251
            return r4
        L_0x0251:
            r10 = r14
            goto L_0x0277
        L_0x0253:
            r0 = move-exception
            r10 = r14
        L_0x0255:
            java.lang.String r2 = "notificationWillShowInForegroundHandler threw an exception. Displaying normal OneSignal notification."
            com.onesignal.debug.internal.logging.Logging.error(r2, r0)
            goto L_0x0277
        L_0x025b:
            r0 = move-exception
            r10 = r14
        L_0x025d:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r9 = "notificationWillShowInForegroundHandler timed out, continuing with wantsToDisplay="
            r2.<init>(r9)
            boolean r9 = r7.element
            r2.append(r9)
            r9 = 46
            r2.append(r9)
            java.lang.String r2 = r2.toString()
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            com.onesignal.debug.internal.logging.Logging.info(r2, r0)
        L_0x0277:
            r0 = r5
            r5 = r6
            r2 = r7
            r6 = r10
            r7 = r13
            boolean r2 = r2.element
            r3.L$0 = r7
            r3.L$1 = r6
            r3.L$2 = r12
            r3.L$3 = r12
            r3.Z$0 = r5
            r3.I$0 = r0
            r9 = 6
            r3.label = r9
            java.lang.Object r2 = r7.processHandlerResponse(r6, r2, r5, r3)
            if (r2 != r4) goto L_0x0294
            return r4
        L_0x0294:
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            if (r2 == 0) goto L_0x02a4
            boolean r2 = r2.booleanValue()
            r14 = r6
            r6 = r7
            r17 = r2
            r2 = r0
            r0 = r17
            goto L_0x02aa
        L_0x02a4:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x02a7:
            r2 = r5
            r5 = r6
            r6 = r13
        L_0x02aa:
            if (r0 == 0) goto L_0x02ce
            com.onesignal.notifications.internal.display.INotificationDisplayer r0 = r6._notificationDisplayer
            r3.L$0 = r6
            r3.L$1 = r14
            r3.L$2 = r12
            r3.L$3 = r12
            r3.Z$0 = r5
            r2 = 7
            r3.label = r2
            java.lang.Object r2 = r0.displayNotification(r14, r3)
            if (r2 != r4) goto L_0x02c2
            return r4
        L_0x02c2:
            r0 = r5
            r5 = r14
        L_0x02c4:
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            r14 = r5
        L_0x02cb:
            r13 = r6
            r5 = r2
            goto L_0x02d1
        L_0x02ce:
            r0 = r5
            goto L_0x02cb
        L_0x02d0:
            r0 = r6
        L_0x02d1:
            boolean r2 = r14.isRestoring()
            if (r2 != 0) goto L_0x02f1
            if (r5 == 0) goto L_0x02da
            goto L_0x02db
        L_0x02da:
            r11 = 0
        L_0x02db:
            r3.L$0 = r12
            r3.L$1 = r12
            r3.L$2 = r12
            r3.L$3 = r12
            r3.Z$0 = r0
            r2 = 8
            r3.label = r2
            r2 = 0
            java.lang.Object r2 = r13.postProcessNotification(r14, r2, r11, r3)
            if (r2 != r4) goto L_0x02f1
            return r4
        L_0x02f1:
            if (r0 == 0) goto L_0x030b
            r3.L$0 = r12
            r3.L$1 = r12
            r3.L$2 = r12
            r3.L$3 = r12
            r0 = 9
            r3.label = r0
            r5 = 100
            java.lang.Object r0 = kotlinx.coroutines.DelayKt.delay(r5, r3)
            if (r0 != r4) goto L_0x0308
            return r4
        L_0x0308:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x030b:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x030e:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.processNotificationData(android.content.Context, int, org.json.JSONObject, boolean, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object processHandlerResponse(com.onesignal.notifications.internal.common.NotificationGenerationJob r8, boolean r9, boolean r10, kotlin.coroutines.Continuation<? super java.lang.Boolean> r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processHandlerResponse$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processHandlerResponse$1 r0 = (com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processHandlerResponse$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processHandlerResponse$1 r0 = new com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processHandlerResponse$1
            r0.<init>(r7, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 0
            r6 = 1
            if (r2 == 0) goto L_0x0046
            if (r2 == r6) goto L_0x003a
            if (r2 == r4) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            goto L_0x0036
        L_0x002e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x009d
        L_0x003a:
            java.lang.Object r8 = r0.L$1
            com.onesignal.notifications.internal.common.NotificationGenerationJob r8 = (com.onesignal.notifications.internal.common.NotificationGenerationJob) r8
            java.lang.Object r9 = r0.L$0
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor r9 = (com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor) r9
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0073
        L_0x0046:
            kotlin.ResultKt.throwOnFailure(r11)
            if (r9 == 0) goto L_0x0086
            com.onesignal.common.AndroidUtils r9 = com.onesignal.common.AndroidUtils.INSTANCE
            com.onesignal.notifications.internal.Notification r11 = r8.getNotification()
            java.lang.String r11 = r11.getBody()
            boolean r9 = r9.isStringNotEmpty(r11)
            com.onesignal.notifications.internal.Notification r11 = r8.getNotification()
            boolean r11 = r7.isNotificationWithinTTL(r11)
            if (r9 == 0) goto L_0x0086
            if (r11 == 0) goto L_0x0086
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r6
            java.lang.Object r9 = r7.processCollapseKey(r8, r0)
            if (r9 != r1) goto L_0x0072
            return r1
        L_0x0072:
            r9 = r7
        L_0x0073:
            boolean r9 = r9.shouldDisplayNotification(r8)
            if (r9 == 0) goto L_0x0081
            r8.setNotificationToDisplay(r6)
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            return r8
        L_0x0081:
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r8
        L_0x0086:
            if (r10 == 0) goto L_0x0091
            r0.label = r4
            java.lang.Object r8 = r7.markNotificationAsDismissed(r8, r0)
            if (r8 != r1) goto L_0x009d
            return r1
        L_0x0091:
            r8.setNotificationToDisplay(r5)
            r0.label = r3
            java.lang.Object r8 = r7.postProcessNotification(r8, r6, r5, r0)
            if (r8 != r1) goto L_0x009d
            return r1
        L_0x009d:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.processHandlerResponse(com.onesignal.notifications.internal.common.NotificationGenerationJob, boolean, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean isNotificationWithinTTL(Notification notification) {
        if (!((ConfigModel) this._configModelStore.getModel()).getRestoreTTLFilter()) {
            return true;
        }
        if (notification.getSentTime() + ((long) notification.getTtl()) > this._time.getCurrentTimeMillis() / ((long) 1000)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final Object isDuplicateNotification(Notification notification, Continuation<? super Boolean> continuation) {
        return this._dataController.doesNotificationExist(notification.getNotificationId(), continuation);
    }

    private final boolean shouldDisplayNotification(NotificationGenerationJob notificationGenerationJob) {
        return notificationGenerationJob.hasExtender() || AndroidUtils.INSTANCE.isStringNotEmpty(notificationGenerationJob.getJsonPayload().optString("alert"));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object postProcessNotification(com.onesignal.notifications.internal.common.NotificationGenerationJob r7, boolean r8, boolean r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r6 = this;
            boolean r0 = r10 instanceof com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$postProcessNotification$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$postProcessNotification$1 r0 = (com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$postProcessNotification$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$postProcessNotification$1 r0 = new com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$postProcessNotification$1
            r0.<init>(r6, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x004a
            if (r2 == r5) goto L_0x003c
            if (r2 == r4) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x007f
        L_0x0030:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x006d
        L_0x003c:
            boolean r9 = r0.Z$0
            java.lang.Object r7 = r0.L$1
            com.onesignal.notifications.internal.common.NotificationGenerationJob r7 = (com.onesignal.notifications.internal.common.NotificationGenerationJob) r7
            java.lang.Object r8 = r0.L$0
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor r8 = (com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor) r8
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x005d
        L_0x004a:
            kotlin.ResultKt.throwOnFailure(r10)
            r0.L$0 = r6
            r0.L$1 = r7
            r0.Z$0 = r9
            r0.label = r5
            java.lang.Object r8 = r6.saveNotification(r7, r8, r0)
            if (r8 != r1) goto L_0x005c
            return r1
        L_0x005c:
            r8 = r6
        L_0x005d:
            r10 = 0
            if (r9 != 0) goto L_0x0070
            r0.L$0 = r10
            r0.L$1 = r10
            r0.label = r4
            java.lang.Object r7 = r8.markNotificationAsDismissed(r7, r0)
            if (r7 != r1) goto L_0x006d
            return r1
        L_0x006d:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x0070:
            com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService r8 = r8._lifecycleService
            r0.L$0 = r10
            r0.L$1 = r10
            r0.label = r3
            java.lang.Object r7 = r8.notificationReceived(r7, r0)
            if (r7 != r1) goto L_0x007f
            return r1
        L_0x007f:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.postProcessNotification(com.onesignal.notifications.internal.common.NotificationGenerationJob, boolean, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object saveNotification(com.onesignal.notifications.internal.common.NotificationGenerationJob r18, boolean r19, kotlin.coroutines.Continuation<? super kotlin.Unit> r20) {
        /*
            r17 = this;
            r1 = r17
            r0 = r20
            java.lang.String r2 = "collapse_key"
            boolean r3 = r0 instanceof com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$saveNotification$1
            if (r3 == 0) goto L_0x001a
            r3 = r0
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$saveNotification$1 r3 = (com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$saveNotification$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r0 = r3.label
            int r0 = r0 - r5
            r3.label = r0
            goto L_0x001f
        L_0x001a:
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$saveNotification$1 r3 = new com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$saveNotification$1
            r3.<init>(r1, r0)
        L_0x001f:
            java.lang.Object r0 = r3.result
            java.lang.Object r15 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r3.label
            r5 = 1
            if (r4 == 0) goto L_0x003c
            if (r4 != r5) goto L_0x0034
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ JSONException -> 0x0031 }
            goto L_0x00f4
        L_0x0031:
            r0 = move-exception
            goto L_0x00f1
        L_0x0034:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r4 = "Saving Notification job: "
            r0.<init>(r4)
            r4 = r18
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            r6 = 2
            r7 = 0
            com.onesignal.debug.internal.logging.Logging.debug$default(r0, r7, r6, r7)
            org.json.JSONObject r0 = r18.getJsonPayload()
            org.json.JSONObject r6 = r1.getCustomJSONObject(r0)     // Catch:{ JSONException -> 0x0031 }
            boolean r8 = r0.has(r2)     // Catch:{ JSONException -> 0x0031 }
            if (r8 == 0) goto L_0x0073
            java.lang.String r8 = "do_not_collapse"
            java.lang.String r9 = r0.optString(r2)     // Catch:{ JSONException -> 0x0031 }
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)     // Catch:{ JSONException -> 0x0031 }
            if (r8 != 0) goto L_0x0073
            java.lang.String r2 = r0.optString(r2)     // Catch:{ JSONException -> 0x0031 }
            goto L_0x0077
        L_0x0073:
            r2 = r7
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ JSONException -> 0x0031 }
            r2 = r7
        L_0x0077:
            java.lang.String r8 = "google.sent_time"
            com.onesignal.core.internal.time.ITime r9 = r1._time     // Catch:{ JSONException -> 0x0031 }
            long r9 = r9.getCurrentTimeMillis()     // Catch:{ JSONException -> 0x0031 }
            long r8 = r0.optLong(r8, r9)     // Catch:{ JSONException -> 0x0031 }
            r10 = 1000(0x3e8, double:4.94E-321)
            long r8 = r8 / r10
            java.lang.String r10 = "google.ttl"
            r11 = 259200(0x3f480, float:3.63217E-40)
            int r10 = r0.optInt(r10, r11)     // Catch:{ JSONException -> 0x0031 }
            long r10 = (long) r10     // Catch:{ JSONException -> 0x0031 }
            long r13 = r8 + r10
            com.onesignal.notifications.internal.data.INotificationRepository r8 = r1._dataController     // Catch:{ JSONException -> 0x0031 }
            java.lang.String r9 = "i"
            java.lang.String r6 = r6.optString(r9)     // Catch:{ JSONException -> 0x0031 }
            java.lang.String r9 = "customJSON.optString(\"i\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r9)     // Catch:{ JSONException -> 0x0031 }
            java.lang.String r9 = "grp"
            java.lang.String r9 = com.onesignal.common.JSONObjectExtensionsKt.safeString(r0, r9)     // Catch:{ JSONException -> 0x0031 }
            boolean r10 = r18.isNotificationToDisplay()     // Catch:{ JSONException -> 0x0031 }
            int r11 = r18.getAndroidId()     // Catch:{ JSONException -> 0x0031 }
            java.lang.CharSequence r12 = r18.getTitle()     // Catch:{ JSONException -> 0x0031 }
            if (r12 == 0) goto L_0x00bc
            java.lang.CharSequence r12 = r18.getTitle()     // Catch:{ JSONException -> 0x0031 }
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ JSONException -> 0x0031 }
            goto L_0x00bd
        L_0x00bc:
            r12 = r7
        L_0x00bd:
            java.lang.CharSequence r16 = r18.getBody()     // Catch:{ JSONException -> 0x0031 }
            if (r16 == 0) goto L_0x00ce
            java.lang.CharSequence r4 = r18.getBody()     // Catch:{ JSONException -> 0x0031 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ JSONException -> 0x0031 }
            r16 = r4
            goto L_0x00d0
        L_0x00ce:
            r16 = r7
        L_0x00d0:
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x0031 }
            java.lang.String r4 = "jsonPayload.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)     // Catch:{ JSONException -> 0x0031 }
            r3.label = r5     // Catch:{ JSONException -> 0x0031 }
            r4 = r8
            r5 = r6
            r6 = r9
            r7 = r2
            r8 = r10
            r9 = r19
            r10 = r11
            r11 = r12
            r12 = r16
            r2 = r15
            r15 = r0
            r16 = r3
            java.lang.Object r0 = r4.createNotification(r5, r6, r7, r8, r9, r10, r11, r12, r13, r15, r16)     // Catch:{ JSONException -> 0x0031 }
            if (r0 != r2) goto L_0x00f4
            return r2
        L_0x00f1:
            r0.printStackTrace()
        L_0x00f4:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.saveNotification(com.onesignal.notifications.internal.common.NotificationGenerationJob, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object markNotificationAsDismissed(com.onesignal.notifications.internal.common.NotificationGenerationJob r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$markNotificationAsDismissed$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$markNotificationAsDismissed$1 r0 = (com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$markNotificationAsDismissed$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$markNotificationAsDismissed$1 r0 = new com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$markNotificationAsDismissed$1
            r0.<init>(r6, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 2
            r5 = 0
            if (r2 == 0) goto L_0x0042
            if (r2 == r3) goto L_0x0036
            if (r2 != r4) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x008e
        L_0x002e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0036:
            java.lang.Object r7 = r0.L$1
            com.onesignal.notifications.internal.common.NotificationGenerationJob r7 = (com.onesignal.notifications.internal.common.NotificationGenerationJob) r7
            java.lang.Object r2 = r0.L$0
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor r2 = (com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0073
        L_0x0042:
            kotlin.ResultKt.throwOnFailure(r8)
            boolean r8 = r7.isNotificationToDisplay()
            if (r8 != 0) goto L_0x004e
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x004e:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r2 = "Marking restored or disabled notifications as dismissed: "
            r8.<init>(r2)
            r8.append(r7)
            java.lang.String r8 = r8.toString()
            com.onesignal.debug.internal.logging.Logging.debug$default(r8, r5, r4, r5)
            com.onesignal.notifications.internal.data.INotificationRepository r8 = r6._dataController
            int r2 = r7.getAndroidId()
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r8 = r8.markAsDismissed(r2, r0)
            if (r8 != r1) goto L_0x0072
            return r1
        L_0x0072:
            r2 = r6
        L_0x0073:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x0091
            com.onesignal.notifications.internal.summary.INotificationSummaryManager r8 = r2._notificationSummaryManager
            int r7 = r7.getAndroidId()
            r0.L$0 = r5
            r0.L$1 = r5
            r0.label = r4
            java.lang.Object r7 = r8.updatePossibleDependentSummaryOnDismiss(r7, r0)
            if (r7 != r1) goto L_0x008e
            return r1
        L_0x008e:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x0091:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.markNotificationAsDismissed(com.onesignal.notifications.internal.common.NotificationGenerationJob, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object processCollapseKey(com.onesignal.notifications.internal.common.NotificationGenerationJob r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processCollapseKey$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processCollapseKey$1 r0 = (com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processCollapseKey$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processCollapseKey$1 r0 = new com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor$processCollapseKey$1
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r6 = r0.L$0
            com.onesignal.notifications.internal.common.NotificationGenerationJob r6 = (com.onesignal.notifications.internal.common.NotificationGenerationJob) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0079
        L_0x002e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r7)
            boolean r7 = r6.isRestoring()
            if (r7 == 0) goto L_0x0042
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0042:
            org.json.JSONObject r7 = r6.getJsonPayload()
            java.lang.String r2 = "collapse_key"
            boolean r7 = r7.has(r2)
            if (r7 == 0) goto L_0x008b
            org.json.JSONObject r7 = r6.getJsonPayload()
            java.lang.String r7 = r7.optString(r2)
            java.lang.String r4 = "do_not_collapse"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x005f
            goto L_0x008b
        L_0x005f:
            org.json.JSONObject r7 = r6.getJsonPayload()
            java.lang.String r7 = r7.optString(r2)
            com.onesignal.notifications.internal.data.INotificationRepository r2 = r5._dataController
            java.lang.String r4 = "collapseId"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r4)
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r7 = r2.getAndroidIdFromCollapseKey(r7, r0)
            if (r7 != r1) goto L_0x0079
            return r1
        L_0x0079:
            java.lang.Integer r7 = (java.lang.Integer) r7
            if (r7 == 0) goto L_0x0088
            com.onesignal.notifications.internal.Notification r6 = r6.getNotification()
            int r7 = r7.intValue()
            r6.setAndroidNotificationId(r7)
        L_0x0088:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x008b:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.processCollapseKey(com.onesignal.notifications.internal.common.NotificationGenerationJob, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final JSONObject getCustomJSONObject(JSONObject jSONObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        return new JSONObject(jSONObject.optString("custom"));
    }

    private final boolean shouldFireForegroundHandlers(NotificationGenerationJob notificationGenerationJob) {
        if (!this._applicationService.isInForeground()) {
            Logging.info$default("App is in background, show notification", (Throwable) null, 2, (Object) null);
            return false;
        } else if (!notificationGenerationJob.isRestoring()) {
            return true;
        } else {
            Logging.info$default("Not firing notificationWillShowInForegroundHandler for restored notifications", (Throwable) null, 2, (Object) null);
            return false;
        }
    }
}
