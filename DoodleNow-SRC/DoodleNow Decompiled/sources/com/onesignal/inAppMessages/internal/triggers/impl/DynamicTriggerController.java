package com.onesignal.inAppMessages.internal.triggers.impl;

import com.onesignal.common.events.EventProducer;
import com.onesignal.common.events.IEventNotifier;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.inAppMessages.internal.Trigger;
import com.onesignal.inAppMessages.internal.state.InAppStateService;
import com.onesignal.inAppMessages.internal.triggers.ITriggerHandler;
import com.onesignal.session.internal.session.ISessionService;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017J \u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0018\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u001aH\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0002H\u0016J\u0010\u0010$\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/onesignal/inAppMessages/internal/triggers/impl/DynamicTriggerController;", "Lcom/onesignal/common/events/IEventNotifier;", "Lcom/onesignal/inAppMessages/internal/triggers/ITriggerHandler;", "_state", "Lcom/onesignal/inAppMessages/internal/state/InAppStateService;", "_session", "Lcom/onesignal/session/internal/session/ISessionService;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/inAppMessages/internal/state/InAppStateService;Lcom/onesignal/session/internal/session/ISessionService;Lcom/onesignal/core/internal/time/ITime;)V", "events", "Lcom/onesignal/common/events/EventProducer;", "getEvents", "()Lcom/onesignal/common/events/EventProducer;", "hasSubscribers", "", "getHasSubscribers", "()Z", "scheduledMessages", "", "", "dynamicTriggerShouldFire", "trigger", "Lcom/onesignal/inAppMessages/internal/Trigger;", "evaluateTimeIntervalWithOperator", "timeInterval", "", "currentTimeInterval", "operator", "Lcom/onesignal/inAppMessages/internal/Trigger$OSTriggerOperator;", "roughlyEqual", "left", "right", "subscribe", "", "handler", "unsubscribe", "Companion", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: DynamicTriggerController.kt */
public final class DynamicTriggerController implements IEventNotifier<ITriggerHandler> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long DEFAULT_LAST_IN_APP_TIME_AGO = 999999;
    private static final double REQUIRED_ACCURACY = 0.3d;
    private final ISessionService _session;
    private final InAppStateService _state;
    private final ITime _time;
    private final EventProducer<ITriggerHandler> events = new EventProducer<>();
    /* access modifiers changed from: private */
    public final List<String> scheduledMessages = new ArrayList();

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: DynamicTriggerController.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Trigger.OSTriggerKind.values().length];
            iArr[Trigger.OSTriggerKind.SESSION_TIME.ordinal()] = 1;
            iArr[Trigger.OSTriggerKind.TIME_SINCE_LAST_IN_APP.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[Trigger.OSTriggerOperator.values().length];
            iArr2[Trigger.OSTriggerOperator.LESS_THAN.ordinal()] = 1;
            iArr2[Trigger.OSTriggerOperator.LESS_THAN_OR_EQUAL_TO.ordinal()] = 2;
            iArr2[Trigger.OSTriggerOperator.GREATER_THAN.ordinal()] = 3;
            iArr2[Trigger.OSTriggerOperator.GREATER_THAN_OR_EQUAL_TO.ordinal()] = 4;
            iArr2[Trigger.OSTriggerOperator.EQUAL_TO.ordinal()] = 5;
            iArr2[Trigger.OSTriggerOperator.NOT_EQUAL_TO.ordinal()] = 6;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public final EventProducer<ITriggerHandler> getEvents() {
        return this.events;
    }

    public DynamicTriggerController(InAppStateService inAppStateService, ISessionService iSessionService, ITime iTime) {
        Intrinsics.checkNotNullParameter(inAppStateService, "_state");
        Intrinsics.checkNotNullParameter(iSessionService, "_session");
        Intrinsics.checkNotNullParameter(iTime, "_time");
        this._state = inAppStateService;
        this._session = iSessionService;
        this._time = iTime;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0096  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean dynamicTriggerShouldFire(com.onesignal.inAppMessages.internal.Trigger r18) {
        /*
            r17 = this;
            r7 = r17
            java.lang.String r0 = "trigger"
            r1 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.Object r0 = r18.getValue()
            r8 = 0
            if (r0 != 0) goto L_0x0011
            return r8
        L_0x0011:
            java.util.List<java.lang.String> r9 = r7.scheduledMessages
            monitor-enter(r9)
            java.lang.Object r0 = r18.getValue()     // Catch:{ all -> 0x00bd }
            boolean r0 = r0 instanceof java.lang.Number     // Catch:{ all -> 0x00bd }
            if (r0 != 0) goto L_0x001e
            monitor-exit(r9)
            return r8
        L_0x001e:
            com.onesignal.inAppMessages.internal.Trigger$OSTriggerKind r0 = r18.getKind()     // Catch:{ all -> 0x00bd }
            int[] r2 = com.onesignal.inAppMessages.internal.triggers.impl.DynamicTriggerController.WhenMappings.$EnumSwitchMapping$0     // Catch:{ all -> 0x00bd }
            int r0 = r0.ordinal()     // Catch:{ all -> 0x00bd }
            r0 = r2[r0]     // Catch:{ all -> 0x00bd }
            r10 = 1
            if (r0 == r10) goto L_0x0054
            r2 = 2
            if (r0 == r2) goto L_0x0033
            r13 = 0
            goto L_0x0062
        L_0x0033:
            com.onesignal.inAppMessages.internal.state.InAppStateService r0 = r7._state     // Catch:{ all -> 0x00bd }
            java.lang.String r0 = r0.getInAppMessageIdShowing()     // Catch:{ all -> 0x00bd }
            if (r0 == 0) goto L_0x003d
            monitor-exit(r9)
            return r8
        L_0x003d:
            com.onesignal.inAppMessages.internal.state.InAppStateService r0 = r7._state     // Catch:{ all -> 0x00bd }
            java.lang.Long r0 = r0.getLastTimeInAppDismissed()     // Catch:{ all -> 0x00bd }
            if (r0 != 0) goto L_0x0049
            r2 = 999999(0xf423f, double:4.94065E-318)
            goto L_0x0061
        L_0x0049:
            com.onesignal.core.internal.time.ITime r2 = r7._time     // Catch:{ all -> 0x00bd }
            long r2 = r2.getCurrentTimeMillis()     // Catch:{ all -> 0x00bd }
            long r4 = r0.longValue()     // Catch:{ all -> 0x00bd }
            goto L_0x0060
        L_0x0054:
            com.onesignal.core.internal.time.ITime r0 = r7._time     // Catch:{ all -> 0x00bd }
            long r2 = r0.getCurrentTimeMillis()     // Catch:{ all -> 0x00bd }
            com.onesignal.session.internal.session.ISessionService r0 = r7._session     // Catch:{ all -> 0x00bd }
            long r4 = r0.getStartTime()     // Catch:{ all -> 0x00bd }
        L_0x0060:
            long r2 = r2 - r4
        L_0x0061:
            r13 = r2
        L_0x0062:
            java.lang.String r0 = r18.getTriggerId()     // Catch:{ all -> 0x00bd }
            java.lang.Object r2 = r18.getValue()     // Catch:{ all -> 0x00bd }
            java.lang.Number r2 = (java.lang.Number) r2     // Catch:{ all -> 0x00bd }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)     // Catch:{ all -> 0x00bd }
            double r2 = r2.doubleValue()     // Catch:{ all -> 0x00bd }
            r4 = 1000(0x3e8, float:1.401E-42)
            double r4 = (double) r4     // Catch:{ all -> 0x00bd }
            double r2 = r2 * r4
            long r4 = (long) r2     // Catch:{ all -> 0x00bd }
            double r2 = (double) r4     // Catch:{ all -> 0x00bd }
            double r11 = (double) r13     // Catch:{ all -> 0x00bd }
            com.onesignal.inAppMessages.internal.Trigger$OSTriggerOperator r6 = r18.getOperatorType()     // Catch:{ all -> 0x00bd }
            r1 = r17
            r15 = r4
            r4 = r11
            boolean r1 = r1.evaluateTimeIntervalWithOperator(r2, r4, r6)     // Catch:{ all -> 0x00bd }
            if (r1 == 0) goto L_0x0096
            com.onesignal.common.events.EventProducer<com.onesignal.inAppMessages.internal.triggers.ITriggerHandler> r1 = r7.events     // Catch:{ all -> 0x00bd }
            com.onesignal.inAppMessages.internal.triggers.impl.DynamicTriggerController$dynamicTriggerShouldFire$1$1 r2 = new com.onesignal.inAppMessages.internal.triggers.impl.DynamicTriggerController$dynamicTriggerShouldFire$1$1     // Catch:{ all -> 0x00bd }
            r2.<init>(r0)     // Catch:{ all -> 0x00bd }
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2     // Catch:{ all -> 0x00bd }
            r1.fire(r2)     // Catch:{ all -> 0x00bd }
            monitor-exit(r9)
            return r10
        L_0x0096:
            long r4 = r15 - r13
            r1 = 0
            int r1 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r1 > 0) goto L_0x00a0
            monitor-exit(r9)
            return r8
        L_0x00a0:
            java.util.List<java.lang.String> r1 = r7.scheduledMessages     // Catch:{ all -> 0x00bd }
            boolean r1 = r1.contains(r0)     // Catch:{ all -> 0x00bd }
            if (r1 == 0) goto L_0x00aa
            monitor-exit(r9)
            return r8
        L_0x00aa:
            com.onesignal.inAppMessages.internal.triggers.impl.DynamicTriggerTimer r1 = com.onesignal.inAppMessages.internal.triggers.impl.DynamicTriggerTimer.INSTANCE     // Catch:{ all -> 0x00bd }
            com.onesignal.inAppMessages.internal.triggers.impl.DynamicTriggerController$dynamicTriggerShouldFire$1$2 r2 = new com.onesignal.inAppMessages.internal.triggers.impl.DynamicTriggerController$dynamicTriggerShouldFire$1$2     // Catch:{ all -> 0x00bd }
            r2.<init>(r7, r0)     // Catch:{ all -> 0x00bd }
            java.util.TimerTask r2 = (java.util.TimerTask) r2     // Catch:{ all -> 0x00bd }
            r1.scheduleTrigger(r2, r0, r4)     // Catch:{ all -> 0x00bd }
            java.util.List<java.lang.String> r1 = r7.scheduledMessages     // Catch:{ all -> 0x00bd }
            r1.add(r0)     // Catch:{ all -> 0x00bd }
            monitor-exit(r9)
            return r8
        L_0x00bd:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.triggers.impl.DynamicTriggerController.dynamicTriggerShouldFire(com.onesignal.inAppMessages.internal.Trigger):boolean");
    }

    private final boolean evaluateTimeIntervalWithOperator(double d, double d2, Trigger.OSTriggerOperator oSTriggerOperator) {
        switch (WhenMappings.$EnumSwitchMapping$1[oSTriggerOperator.ordinal()]) {
            case 1:
                if (d2 < d) {
                    return true;
                }
                break;
            case 2:
                if (d2 <= d || roughlyEqual(d, d2)) {
                    return true;
                }
            case 3:
                if (d2 >= d) {
                    return true;
                }
                break;
            case 4:
                if (d2 >= d || roughlyEqual(d, d2)) {
                    return true;
                }
            case 5:
                return roughlyEqual(d, d2);
            case 6:
                if (!roughlyEqual(d, d2)) {
                    return true;
                }
                break;
            default:
                Logging.error$default("Attempted to apply an invalid operator on a time-based in-app-message trigger: " + oSTriggerOperator, (Throwable) null, 2, (Object) null);
                break;
        }
        return false;
    }

    private final boolean roughlyEqual(double d, double d2) {
        return Math.abs(d - d2) < REQUIRED_ACCURACY;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/onesignal/inAppMessages/internal/triggers/impl/DynamicTriggerController$Companion;", "", "()V", "DEFAULT_LAST_IN_APP_TIME_AGO", "", "REQUIRED_ACCURACY", "", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: DynamicTriggerController.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void subscribe(ITriggerHandler iTriggerHandler) {
        Intrinsics.checkNotNullParameter(iTriggerHandler, "handler");
        this.events.subscribe(iTriggerHandler);
    }

    public void unsubscribe(ITriggerHandler iTriggerHandler) {
        Intrinsics.checkNotNullParameter(iTriggerHandler, "handler");
        this.events.unsubscribe(iTriggerHandler);
    }

    public boolean getHasSubscribers() {
        return this.events.getHasSubscribers();
    }
}
