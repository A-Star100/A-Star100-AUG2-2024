package com.onesignal.notifications.internal.lifecycle.impl;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.onesignal.common.AndroidUtils;
import com.onesignal.common.events.CallbackProducer;
import com.onesignal.common.events.EventProducer;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.INotificationClickListener;
import com.onesignal.notifications.INotificationLifecycleListener;
import com.onesignal.notifications.INotificationReceivedEvent;
import com.onesignal.notifications.INotificationServiceExtension;
import com.onesignal.notifications.INotificationWillDisplayEvent;
import com.onesignal.notifications.internal.common.NotificationConstants;
import com.onesignal.notifications.internal.common.NotificationGenerationJob;
import com.onesignal.notifications.internal.common.NotificationHelper;
import com.onesignal.notifications.internal.lifecycle.INotificationLifecycleCallback;
import com.onesignal.notifications.internal.lifecycle.INotificationLifecycleEventHandler;
import com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\tH\u0016J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u000eH\u0016J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0012H\u0016J!\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H@ø\u0001\u0000¢\u0006\u0002\u0010#J\u0019\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\"H@ø\u0001\u0000¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020,H\u0016J!\u0010-\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0015H@ø\u0001\u0000¢\u0006\u0002\u0010.J\u0019\u0010/\u001a\u00020\u00172\u0006\u00100\u001a\u000201H@ø\u0001\u0000¢\u0006\u0002\u00102J\u0010\u00103\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\tH\u0016J\u0010\u00104\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u000eH\u0016J\u0010\u00105\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0012H\u0016J\u0012\u00106\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0010H\u0016J\u000e\u00107\u001a\u00020\u00172\u0006\u00108\u001a\u000209R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006:"}, d2 = {"Lcom/onesignal/notifications/internal/lifecycle/impl/NotificationLifecycleService;", "Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleService;", "applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/core/internal/time/ITime;)V", "extOpenedCallback", "Lcom/onesignal/common/events/EventProducer;", "Lcom/onesignal/notifications/INotificationClickListener;", "extRemoteReceivedCallback", "Lcom/onesignal/common/events/CallbackProducer;", "Lcom/onesignal/notifications/INotificationServiceExtension;", "extWillShowInForegroundCallback", "Lcom/onesignal/notifications/INotificationLifecycleListener;", "intLifecycleCallback", "Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleCallback;", "intLifecycleHandler", "Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleEventHandler;", "unprocessedOpenedNotifs", "Lkotlin/collections/ArrayDeque;", "Lorg/json/JSONArray;", "addExternalClickListener", "", "callback", "addExternalForegroundLifecycleListener", "listener", "addInternalNotificationLifecycleEventHandler", "handler", "canOpenNotification", "", "activity", "Landroid/app/Activity;", "data", "Lorg/json/JSONObject;", "(Landroid/app/Activity;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "canReceiveNotification", "jsonPayload", "(Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "externalNotificationWillShowInForeground", "willDisplayEvent", "Lcom/onesignal/notifications/INotificationWillDisplayEvent;", "externalRemoteNotificationReceived", "notificationReceivedEvent", "Lcom/onesignal/notifications/INotificationReceivedEvent;", "notificationOpened", "(Landroid/app/Activity;Lorg/json/JSONArray;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notificationReceived", "notificationJob", "Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;", "(Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeExternalClickListener", "removeExternalForegroundLifecycleListener", "removeInternalNotificationLifecycleEventHandler", "setInternalNotificationLifecycleCallback", "setupNotificationServiceExtension", "context", "Landroid/content/Context;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NotificationLifecycleService.kt */
public final class NotificationLifecycleService implements INotificationLifecycleService {
    private final ITime _time;
    private final EventProducer<INotificationClickListener> extOpenedCallback = new EventProducer<>();
    private final CallbackProducer<INotificationServiceExtension> extRemoteReceivedCallback = new CallbackProducer<>();
    private final EventProducer<INotificationLifecycleListener> extWillShowInForegroundCallback = new EventProducer<>();
    private final CallbackProducer<INotificationLifecycleCallback> intLifecycleCallback = new CallbackProducer<>();
    private final EventProducer<INotificationLifecycleEventHandler> intLifecycleHandler = new EventProducer<>();
    private final ArrayDeque<JSONArray> unprocessedOpenedNotifs = new ArrayDeque<>();

    public NotificationLifecycleService(IApplicationService iApplicationService, ITime iTime) {
        Intrinsics.checkNotNullParameter(iApplicationService, "applicationService");
        Intrinsics.checkNotNullParameter(iTime, "_time");
        this._time = iTime;
        setupNotificationServiceExtension(iApplicationService.getAppContext());
    }

    public void addInternalNotificationLifecycleEventHandler(INotificationLifecycleEventHandler iNotificationLifecycleEventHandler) {
        Intrinsics.checkNotNullParameter(iNotificationLifecycleEventHandler, "handler");
        this.intLifecycleHandler.subscribe(iNotificationLifecycleEventHandler);
    }

    public void removeInternalNotificationLifecycleEventHandler(INotificationLifecycleEventHandler iNotificationLifecycleEventHandler) {
        Intrinsics.checkNotNullParameter(iNotificationLifecycleEventHandler, "handler");
        this.intLifecycleHandler.unsubscribe(iNotificationLifecycleEventHandler);
    }

    public void setInternalNotificationLifecycleCallback(INotificationLifecycleCallback iNotificationLifecycleCallback) {
        this.intLifecycleCallback.set(iNotificationLifecycleCallback);
    }

    public void addExternalForegroundLifecycleListener(INotificationLifecycleListener iNotificationLifecycleListener) {
        Intrinsics.checkNotNullParameter(iNotificationLifecycleListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.extWillShowInForegroundCallback.subscribe(iNotificationLifecycleListener);
    }

    public void removeExternalForegroundLifecycleListener(INotificationLifecycleListener iNotificationLifecycleListener) {
        Intrinsics.checkNotNullParameter(iNotificationLifecycleListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.extWillShowInForegroundCallback.unsubscribe(iNotificationLifecycleListener);
    }

    public void addExternalClickListener(INotificationClickListener iNotificationClickListener) {
        Intrinsics.checkNotNullParameter(iNotificationClickListener, "callback");
        this.extOpenedCallback.subscribe(iNotificationClickListener);
        if (this.extOpenedCallback.getHasSubscribers() && CollectionsKt.any(this.unprocessedOpenedNotifs)) {
            Iterator it = this.unprocessedOpenedNotifs.iterator();
            while (it.hasNext()) {
                this.extOpenedCallback.fireOnMain(new NotificationLifecycleService$addExternalClickListener$1(NotificationHelper.INSTANCE.generateNotificationOpenedResult$com_onesignal_notifications((JSONArray) it.next(), this._time)));
            }
        }
    }

    public void removeExternalClickListener(INotificationClickListener iNotificationClickListener) {
        Intrinsics.checkNotNullParameter(iNotificationClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.extOpenedCallback.unsubscribe(iNotificationClickListener);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object canReceiveNotification(org.json.JSONObject r7, kotlin.coroutines.Continuation<? super java.lang.Boolean> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$canReceiveNotification$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$canReceiveNotification$1 r0 = (com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$canReceiveNotification$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$canReceiveNotification$1 r0 = new com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$canReceiveNotification$1
            r0.<init>(r6, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r7 = r0.L$0
            kotlin.jvm.internal.Ref$BooleanRef r7 = (kotlin.jvm.internal.Ref.BooleanRef) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0056
        L_0x002e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.jvm.internal.Ref$BooleanRef r8 = new kotlin.jvm.internal.Ref$BooleanRef
            r8.<init>()
            r8.element = r3
            com.onesignal.common.events.CallbackProducer<com.onesignal.notifications.internal.lifecycle.INotificationLifecycleCallback> r2 = r6.intLifecycleCallback
            com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$canReceiveNotification$2 r4 = new com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$canReceiveNotification$2
            r5 = 0
            r4.<init>(r8, r7, r5)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r7 = r2.suspendingFire(r4, r0)
            if (r7 != r1) goto L_0x0055
            return r1
        L_0x0055:
            r7 = r8
        L_0x0056:
            boolean r7 = r7.element
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService.canReceiveNotification(org.json.JSONObject, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object notificationReceived(NotificationGenerationJob notificationGenerationJob, Continuation<? super Unit> continuation) {
        Object suspendingFire = this.intLifecycleHandler.suspendingFire(new NotificationLifecycleService$notificationReceived$2(notificationGenerationJob, (Continuation<? super NotificationLifecycleService$notificationReceived$2>) null), continuation);
        return suspendingFire == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? suspendingFire : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object canOpenNotification(android.app.Activity r7, org.json.JSONObject r8, kotlin.coroutines.Continuation<? super java.lang.Boolean> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$canOpenNotification$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$canOpenNotification$1 r0 = (com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$canOpenNotification$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$canOpenNotification$1 r0 = new com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$canOpenNotification$1
            r0.<init>(r6, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r7 = r0.L$0
            kotlin.jvm.internal.Ref$BooleanRef r7 = (kotlin.jvm.internal.Ref.BooleanRef) r7
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x005c
        L_0x002e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlin.jvm.internal.Ref$BooleanRef r9 = new kotlin.jvm.internal.Ref$BooleanRef
            r9.<init>()
            com.onesignal.common.events.EventProducer<com.onesignal.notifications.INotificationClickListener> r2 = r6.extOpenedCallback
            boolean r2 = r2.getHasSubscribers()
            r9.element = r2
            com.onesignal.common.events.CallbackProducer<com.onesignal.notifications.internal.lifecycle.INotificationLifecycleCallback> r2 = r6.intLifecycleCallback
            com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$canOpenNotification$2 r4 = new com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$canOpenNotification$2
            r5 = 0
            r4.<init>(r9, r7, r8, r5)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r0.L$0 = r9
            r0.label = r3
            java.lang.Object r7 = r2.suspendingFire(r4, r0)
            if (r7 != r1) goto L_0x005b
            return r1
        L_0x005b:
            r7 = r9
        L_0x005c:
            boolean r7 = r7.element
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService.canOpenNotification(android.app.Activity, org.json.JSONObject, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: org.json.JSONArray} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object notificationOpened(android.app.Activity r6, org.json.JSONArray r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$notificationOpened$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$notificationOpened$1 r0 = (com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$notificationOpened$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$notificationOpened$1 r0 = new com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$notificationOpened$1
            r0.<init>(r5, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r6 = r0.L$1
            r7 = r6
            org.json.JSONArray r7 = (org.json.JSONArray) r7
            java.lang.Object r6 = r0.L$0
            com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService r6 = (com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0056
        L_0x0033:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r8)
            com.onesignal.common.events.EventProducer<com.onesignal.notifications.internal.lifecycle.INotificationLifecycleEventHandler> r8 = r5.intLifecycleHandler
            com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$notificationOpened$2 r2 = new com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$notificationOpened$2
            r4 = 0
            r2.<init>(r6, r7, r4)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r0.L$0 = r5
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r6 = r8.suspendingFire(r2, r0)
            if (r6 != r1) goto L_0x0055
            return r1
        L_0x0055:
            r6 = r5
        L_0x0056:
            com.onesignal.common.events.EventProducer<com.onesignal.notifications.INotificationClickListener> r8 = r6.extOpenedCallback
            boolean r8 = r8.getHasSubscribers()
            if (r8 == 0) goto L_0x0073
            com.onesignal.notifications.internal.common.NotificationHelper r8 = com.onesignal.notifications.internal.common.NotificationHelper.INSTANCE
            com.onesignal.core.internal.time.ITime r0 = r6._time
            com.onesignal.notifications.internal.NotificationClickEvent r7 = r8.generateNotificationOpenedResult$com_onesignal_notifications(r7, r0)
            com.onesignal.common.events.EventProducer<com.onesignal.notifications.INotificationClickListener> r6 = r6.extOpenedCallback
            com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$notificationOpened$3 r8 = new com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService$notificationOpened$3
            r8.<init>(r7)
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            r6.fireOnMain(r8)
            goto L_0x0078
        L_0x0073:
            kotlin.collections.ArrayDeque<org.json.JSONArray> r6 = r6.unprocessedOpenedNotifs
            r6.add(r7)
        L_0x0078:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService.notificationOpened(android.app.Activity, org.json.JSONArray, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void externalRemoteNotificationReceived(INotificationReceivedEvent iNotificationReceivedEvent) {
        Intrinsics.checkNotNullParameter(iNotificationReceivedEvent, "notificationReceivedEvent");
        this.extRemoteReceivedCallback.fire(new NotificationLifecycleService$externalRemoteNotificationReceived$1(iNotificationReceivedEvent));
    }

    public void externalNotificationWillShowInForeground(INotificationWillDisplayEvent iNotificationWillDisplayEvent) {
        Intrinsics.checkNotNullParameter(iNotificationWillDisplayEvent, "willDisplayEvent");
        this.extWillShowInForegroundCallback.fire(new NotificationLifecycleService$externalNotificationWillShowInForeground$1(iNotificationWillDisplayEvent));
    }

    public final void setupNotificationServiceExtension(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String manifestMeta = AndroidUtils.INSTANCE.getManifestMeta(context, NotificationConstants.EXTENSION_SERVICE_META_DATA_TAG_NAME);
        if (manifestMeta == null) {
            Logging.verbose$default("No class found, not setting up OSRemoteNotificationReceivedHandler", (Throwable) null, 2, (Object) null);
            return;
        }
        Logging.verbose$default("Found class: " + manifestMeta + ", attempting to call constructor", (Throwable) null, 2, (Object) null);
        try {
            Object newInstance = Class.forName(manifestMeta).newInstance();
            if ((newInstance instanceof INotificationServiceExtension) && !this.extRemoteReceivedCallback.getHasCallback()) {
                this.extRemoteReceivedCallback.set(newInstance);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e2) {
            e2.printStackTrace();
        } catch (ClassNotFoundException e3) {
            e3.printStackTrace();
        }
    }
}
