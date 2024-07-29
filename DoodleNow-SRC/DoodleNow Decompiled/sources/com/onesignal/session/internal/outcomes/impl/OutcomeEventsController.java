package com.onesignal.session.internal.outcomes.impl;

import com.onesignal.common.exceptions.BackendException;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.device.IDeviceService;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.session.internal.influence.IInfluenceManager;
import com.onesignal.session.internal.influence.Influence;
import com.onesignal.session.internal.influence.InfluenceChannel;
import com.onesignal.session.internal.influence.InfluenceType;
import com.onesignal.session.internal.outcomes.IOutcomeEventsController;
import com.onesignal.session.internal.session.ISessionLifecycleHandler;
import com.onesignal.session.internal.session.ISessionService;
import com.onesignal.user.internal.backend.SubscriptionObjectType;
import com.onesignal.user.internal.identity.IdentityModel;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.subscriptions.ISubscriptionManager;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BU\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018J/\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\u001b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH@ø\u0001\u0000¢\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020#H\u0016J\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0002J\u0019\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020+H@ø\u0001\u0000¢\u0006\u0002\u0010,J\u0010\u0010-\u001a\u00020#2\u0006\u0010*\u001a\u00020+H\u0002J\b\u0010.\u001a\u00020#H\u0002J\u0010\u0010/\u001a\u00020#2\u0006\u0010*\u001a\u00020+H\u0002J9\u00100\u001a\u0004\u0018\u0001012\u0006\u0010\u001f\u001a\u00020\u001b2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020&2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH@ø\u0001\u0000¢\u0006\u0002\u00105J\u001b\u00106\u001a\u0004\u0018\u0001012\u0006\u0010\u001f\u001a\u00020\u001bH@ø\u0001\u0000¢\u0006\u0002\u00107J#\u00108\u001a\u0004\u0018\u0001012\u0006\u0010\u001f\u001a\u00020\u001b2\u0006\u00102\u001a\u000203H@ø\u0001\u0000¢\u0006\u0002\u00109J\u0019\u0010:\u001a\u00020#2\u0006\u0010;\u001a\u00020+H@ø\u0001\u0000¢\u0006\u0002\u0010,J\u0011\u0010<\u001a\u00020#H@ø\u0001\u0000¢\u0006\u0002\u0010=J\u001b\u0010>\u001a\u0004\u0018\u0001012\u0006\u0010%\u001a\u00020&H@ø\u0001\u0000¢\u0006\u0002\u0010?J\u001b\u0010@\u001a\u0004\u0018\u0001012\u0006\u0010\u001f\u001a\u00020\u001bH@ø\u0001\u0000¢\u0006\u0002\u00107J)\u0010@\u001a\u0004\u0018\u0001012\u0006\u0010\u001f\u001a\u00020\u001b2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH@ø\u0001\u0000¢\u0006\u0002\u0010!J\u0018\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u001e2\u0006\u0010E\u001a\u00020CH\u0002J\b\u0010F\u001a\u00020#H\u0016R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006G"}, d2 = {"Lcom/onesignal/session/internal/outcomes/impl/OutcomeEventsController;", "Lcom/onesignal/session/internal/outcomes/IOutcomeEventsController;", "Lcom/onesignal/core/internal/startup/IStartableService;", "Lcom/onesignal/session/internal/session/ISessionLifecycleHandler;", "_session", "Lcom/onesignal/session/internal/session/ISessionService;", "_influenceManager", "Lcom/onesignal/session/internal/influence/IInfluenceManager;", "_outcomeEventsCache", "Lcom/onesignal/session/internal/outcomes/impl/IOutcomeEventsRepository;", "_outcomeEventsPreferences", "Lcom/onesignal/session/internal/outcomes/impl/IOutcomeEventsPreferences;", "_outcomeEventsBackend", "Lcom/onesignal/session/internal/outcomes/impl/IOutcomeEventsBackendService;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_identityModelStore", "Lcom/onesignal/user/internal/identity/IdentityModelStore;", "_subscriptionManager", "Lcom/onesignal/user/internal/subscriptions/ISubscriptionManager;", "_deviceService", "Lcom/onesignal/core/internal/device/IDeviceService;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/session/internal/session/ISessionService;Lcom/onesignal/session/internal/influence/IInfluenceManager;Lcom/onesignal/session/internal/outcomes/impl/IOutcomeEventsRepository;Lcom/onesignal/session/internal/outcomes/impl/IOutcomeEventsPreferences;Lcom/onesignal/session/internal/outcomes/impl/IOutcomeEventsBackendService;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/user/internal/identity/IdentityModelStore;Lcom/onesignal/user/internal/subscriptions/ISubscriptionManager;Lcom/onesignal/core/internal/device/IDeviceService;Lcom/onesignal/core/internal/time/ITime;)V", "unattributedUniqueOutcomeEventsSentOnSession", "", "", "getUniqueIds", "", "Lcom/onesignal/session/internal/influence/Influence;", "name", "influences", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onSessionActive", "", "onSessionEnded", "duration", "", "onSessionStarted", "removeDisabledInfluences", "requestMeasureOutcomeEvent", "eventParams", "Lcom/onesignal/session/internal/outcomes/impl/OutcomeEventParams;", "(Lcom/onesignal/session/internal/outcomes/impl/OutcomeEventParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveAttributedUniqueOutcomeNotifications", "saveUnattributedUniqueOutcomeEvents", "saveUniqueOutcome", "sendAndCreateOutcomeEvent", "Lcom/onesignal/session/internal/outcomes/impl/OutcomeEvent;", "weight", "", "sessionTime", "(Ljava/lang/String;FJLjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendOutcomeEvent", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendOutcomeEventWithValue", "(Ljava/lang/String;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendSavedOutcomeEvent", "event", "sendSavedOutcomes", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendSessionEndOutcomeEvent", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendUniqueOutcomeEvent", "sessionInfluences", "setSourceChannelIds", "Lcom/onesignal/session/internal/outcomes/impl/OutcomeSourceBody;", "influence", "sourceBody", "start", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: OutcomeEventsController.kt */
public final class OutcomeEventsController implements IOutcomeEventsController, IStartableService, ISessionLifecycleHandler {
    private final ConfigModelStore _configModelStore;
    private final IDeviceService _deviceService;
    private final IdentityModelStore _identityModelStore;
    private final IInfluenceManager _influenceManager;
    private final IOutcomeEventsBackendService _outcomeEventsBackend;
    /* access modifiers changed from: private */
    public final IOutcomeEventsRepository _outcomeEventsCache;
    private final IOutcomeEventsPreferences _outcomeEventsPreferences;
    private final ISessionService _session;
    private final ISubscriptionManager _subscriptionManager;
    private final ITime _time;
    private Set<String> unattributedUniqueOutcomeEventsSentOnSession = new LinkedHashSet();

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: OutcomeEventsController.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[InfluenceType.values().length];
            iArr[InfluenceType.DIRECT.ordinal()] = 1;
            iArr[InfluenceType.INDIRECT.ordinal()] = 2;
            iArr[InfluenceType.UNATTRIBUTED.ordinal()] = 3;
            iArr[InfluenceType.DISABLED.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[InfluenceChannel.values().length];
            iArr2[InfluenceChannel.IAM.ordinal()] = 1;
            iArr2[InfluenceChannel.NOTIFICATION.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public void onSessionActive() {
    }

    public void onSessionEnded(long j) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0058, code lost:
        r3 = kotlin.collections.CollectionsKt.toMutableSet(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public OutcomeEventsController(com.onesignal.session.internal.session.ISessionService r2, com.onesignal.session.internal.influence.IInfluenceManager r3, com.onesignal.session.internal.outcomes.impl.IOutcomeEventsRepository r4, com.onesignal.session.internal.outcomes.impl.IOutcomeEventsPreferences r5, com.onesignal.session.internal.outcomes.impl.IOutcomeEventsBackendService r6, com.onesignal.core.internal.config.ConfigModelStore r7, com.onesignal.user.internal.identity.IdentityModelStore r8, com.onesignal.user.internal.subscriptions.ISubscriptionManager r9, com.onesignal.core.internal.device.IDeviceService r10, com.onesignal.core.internal.time.ITime r11) {
        /*
            r1 = this;
            java.lang.String r0 = "_session"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "_influenceManager"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "_outcomeEventsCache"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "_outcomeEventsPreferences"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "_outcomeEventsBackend"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "_configModelStore"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "_identityModelStore"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "_subscriptionManager"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "_deviceService"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "_time"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r1.<init>()
            r1._session = r2
            r1._influenceManager = r3
            r1._outcomeEventsCache = r4
            r1._outcomeEventsPreferences = r5
            r1._outcomeEventsBackend = r6
            r1._configModelStore = r7
            r1._identityModelStore = r8
            r1._subscriptionManager = r9
            r1._deviceService = r10
            r1._time = r11
            java.util.LinkedHashSet r3 = new java.util.LinkedHashSet
            r3.<init>()
            java.util.Set r3 = (java.util.Set) r3
            r1.unattributedUniqueOutcomeEventsSentOnSession = r3
            java.util.Set r3 = r5.getUnattributedUniqueOutcomeEventsSentByChannel()
            if (r3 == 0) goto L_0x0060
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Set r3 = kotlin.collections.CollectionsKt.toMutableSet(r3)
            if (r3 != 0) goto L_0x0067
        L_0x0060:
            java.util.LinkedHashSet r3 = new java.util.LinkedHashSet
            r3.<init>()
            java.util.Set r3 = (java.util.Set) r3
        L_0x0067:
            r1.unattributedUniqueOutcomeEventsSentOnSession = r3
            r2.subscribe(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.<init>(com.onesignal.session.internal.session.ISessionService, com.onesignal.session.internal.influence.IInfluenceManager, com.onesignal.session.internal.outcomes.impl.IOutcomeEventsRepository, com.onesignal.session.internal.outcomes.impl.IOutcomeEventsPreferences, com.onesignal.session.internal.outcomes.impl.IOutcomeEventsBackendService, com.onesignal.core.internal.config.ConfigModelStore, com.onesignal.user.internal.identity.IdentityModelStore, com.onesignal.user.internal.subscriptions.ISubscriptionManager, com.onesignal.core.internal.device.IDeviceService, com.onesignal.core.internal.time.ITime):void");
    }

    public void start() {
        ThreadUtilsKt.suspendifyOnThread$default(0, new OutcomeEventsController$start$1(this, (Continuation<? super OutcomeEventsController$start$1>) null), 1, (Object) null);
    }

    public void onSessionStarted() {
        Logging.debug$default("OutcomeEventsController.sessionStarted: Cleaning outcomes for new session", (Throwable) null, 2, (Object) null);
        this.unattributedUniqueOutcomeEventsSentOnSession = new LinkedHashSet();
        saveUnattributedUniqueOutcomeEvents();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object sendSavedOutcomes(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$sendSavedOutcomes$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$sendSavedOutcomes$1 r0 = (com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$sendSavedOutcomes$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$sendSavedOutcomes$1 r0 = new com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$sendSavedOutcomes$1
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0045
            if (r2 == r4) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            java.lang.Object r2 = r0.L$1
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r4 = r0.L$0
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsController r4 = (com.onesignal.session.internal.outcomes.impl.OutcomeEventsController) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x005e
        L_0x0035:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x003d:
            java.lang.Object r2 = r0.L$0
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsController r2 = (com.onesignal.session.internal.outcomes.impl.OutcomeEventsController) r2
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0056
        L_0x0045:
            kotlin.ResultKt.throwOnFailure(r6)
            com.onesignal.session.internal.outcomes.impl.IOutcomeEventsRepository r6 = r5._outcomeEventsCache
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r6.getAllEventsToSend(r0)
            if (r6 != r1) goto L_0x0055
            return r1
        L_0x0055:
            r2 = r5
        L_0x0056:
            java.util.List r6 = (java.util.List) r6
            java.util.Iterator r6 = r6.iterator()
            r4 = r2
            r2 = r6
        L_0x005e:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L_0x0077
            java.lang.Object r6 = r2.next()
            com.onesignal.session.internal.outcomes.impl.OutcomeEventParams r6 = (com.onesignal.session.internal.outcomes.impl.OutcomeEventParams) r6
            r0.L$0 = r4
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r6 = r4.sendSavedOutcomeEvent(r6, r0)
            if (r6 != r1) goto L_0x005e
            return r1
        L_0x0077:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.sendSavedOutcomes(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0065 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object sendSavedOutcomeEvent(com.onesignal.session.internal.outcomes.impl.OutcomeEventParams r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$sendSavedOutcomeEvent$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$sendSavedOutcomeEvent$1 r0 = (com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$sendSavedOutcomeEvent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$sendSavedOutcomeEvent$1 r0 = new com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$sendSavedOutcomeEvent$1
            r0.<init>(r6, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            r5 = 2
            if (r2 == 0) goto L_0x0046
            if (r2 == r3) goto L_0x003a
            if (r2 != r5) goto L_0x0032
            java.lang.Object r7 = r0.L$0
            com.onesignal.session.internal.outcomes.impl.OutcomeEventParams r7 = (com.onesignal.session.internal.outcomes.impl.OutcomeEventParams) r7
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ BackendException -> 0x0066 }
            goto L_0x0099
        L_0x0032:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003a:
            java.lang.Object r7 = r0.L$1
            com.onesignal.session.internal.outcomes.impl.OutcomeEventParams r7 = (com.onesignal.session.internal.outcomes.impl.OutcomeEventParams) r7
            java.lang.Object r2 = r0.L$0
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsController r2 = (com.onesignal.session.internal.outcomes.impl.OutcomeEventsController) r2
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ BackendException -> 0x0066 }
            goto L_0x0057
        L_0x0046:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r6     // Catch:{ BackendException -> 0x0066 }
            r0.L$1 = r7     // Catch:{ BackendException -> 0x0066 }
            r0.label = r3     // Catch:{ BackendException -> 0x0066 }
            java.lang.Object r8 = r6.requestMeasureOutcomeEvent(r7, r0)     // Catch:{ BackendException -> 0x0066 }
            if (r8 != r1) goto L_0x0056
            return r1
        L_0x0056:
            r2 = r6
        L_0x0057:
            com.onesignal.session.internal.outcomes.impl.IOutcomeEventsRepository r8 = r2._outcomeEventsCache     // Catch:{ BackendException -> 0x0066 }
            r0.L$0 = r7     // Catch:{ BackendException -> 0x0066 }
            r0.L$1 = r4     // Catch:{ BackendException -> 0x0066 }
            r0.label = r5     // Catch:{ BackendException -> 0x0066 }
            java.lang.Object r7 = r8.deleteOldOutcomeEvent(r7, r0)     // Catch:{ BackendException -> 0x0066 }
            if (r7 != r1) goto L_0x0099
            return r1
        L_0x0066:
            r8 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "OutcomeEventsController.sendSavedOutcomeEvent: Sending outcome with name: "
            r0.<init>(r1)
            java.lang.String r7 = r7.getOutcomeId()
            r0.append(r7)
            java.lang.String r7 = " failed with status code: "
            r0.append(r7)
            int r7 = r8.getStatusCode()
            r0.append(r7)
            java.lang.String r7 = " and response: "
            r0.append(r7)
            java.lang.String r7 = r8.getResponse()
            r0.append(r7)
            java.lang.String r7 = "\nOutcome event was cached and will be reattempted on app cold start"
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            com.onesignal.debug.internal.logging.Logging.warn$default(r7, r4, r5, r4)
        L_0x0099:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.sendSavedOutcomeEvent(com.onesignal.session.internal.outcomes.impl.OutcomeEventParams, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object sendSessionEndOutcomeEvent(long j, Continuation<? super OutcomeEvent> continuation) {
        List<Influence> influences = this._influenceManager.getInfluences();
        for (Influence ids : influences) {
            if (ids.getIds() != null) {
                return sendAndCreateOutcomeEvent("os__session_duration", 0.0f, j, influences, continuation);
            }
        }
        return null;
    }

    public Object sendUniqueOutcomeEvent(String str, Continuation<? super OutcomeEvent> continuation) {
        return sendUniqueOutcomeEvent(str, this._influenceManager.getInfluences(), continuation);
    }

    public Object sendOutcomeEvent(String str, Continuation<? super OutcomeEvent> continuation) {
        return sendAndCreateOutcomeEvent(str, 0.0f, 0, this._influenceManager.getInfluences(), continuation);
    }

    public Object sendOutcomeEventWithValue(String str, float f, Continuation<? super OutcomeEvent> continuation) {
        return sendAndCreateOutcomeEvent(str, f, 0, this._influenceManager.getInfluences(), continuation);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object sendUniqueOutcomeEvent(java.lang.String r11, java.util.List<com.onesignal.session.internal.influence.Influence> r12, kotlin.coroutines.Continuation<? super com.onesignal.session.internal.outcomes.impl.OutcomeEvent> r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$sendUniqueOutcomeEvent$2
            if (r0 == 0) goto L_0x0014
            r0 = r13
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$sendUniqueOutcomeEvent$2 r0 = (com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$sendUniqueOutcomeEvent$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L_0x0019
        L_0x0014:
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$sendUniqueOutcomeEvent$2 r0 = new com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$sendUniqueOutcomeEvent$2
            r0.<init>(r10, r13)
        L_0x0019:
            r7 = r0
            java.lang.Object r13 = r7.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            java.lang.String r2 = "\n                    "
            java.lang.String r3 = "\n                    Outcome name: "
            r4 = 3
            r5 = 1
            r6 = 2
            r8 = 0
            if (r1 == 0) goto L_0x0054
            if (r1 == r5) goto L_0x0044
            if (r1 == r6) goto L_0x003f
            if (r1 != r4) goto L_0x0037
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x010a
        L_0x0037:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00cb
        L_0x0044:
            java.lang.Object r11 = r7.L$2
            java.util.List r11 = (java.util.List) r11
            java.lang.Object r12 = r7.L$1
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r1 = r7.L$0
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsController r1 = (com.onesignal.session.internal.outcomes.impl.OutcomeEventsController) r1
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0094
        L_0x0054:
            kotlin.ResultKt.throwOnFailure(r13)
            java.util.List r12 = r10.removeDisabledInfluences(r12)
            boolean r13 = r12.isEmpty()
            if (r13 == 0) goto L_0x0067
            java.lang.String r11 = "OutcomeEventsController.sendUniqueOutcomeEvent: Unique Outcome disabled for current session"
            com.onesignal.debug.internal.logging.Logging.debug$default(r11, r8, r6, r8)
            return r8
        L_0x0067:
            java.util.Iterator r13 = r12.iterator()
        L_0x006b:
            boolean r1 = r13.hasNext()
            if (r1 == 0) goto L_0x00cc
            java.lang.Object r1 = r13.next()
            com.onesignal.session.internal.influence.Influence r1 = (com.onesignal.session.internal.influence.Influence) r1
            com.onesignal.session.internal.influence.InfluenceType r1 = r1.getInfluenceType()
            boolean r1 = r1.isAttributed()
            if (r1 == 0) goto L_0x006b
            r7.L$0 = r10
            r7.L$1 = r11
            r7.L$2 = r12
            r7.label = r5
            java.lang.Object r13 = r10.getUniqueIds(r11, r12, r7)
            if (r13 != r0) goto L_0x0090
            return r0
        L_0x0090:
            r1 = r10
            r9 = r12
            r12 = r11
            r11 = r9
        L_0x0094:
            java.util.List r13 = (java.util.List) r13
            if (r13 != 0) goto L_0x00b7
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r0 = "\n                    Measure endpoint will not send because unique outcome already sent for: \n                    SessionInfluences: "
            r13.<init>(r0)
            r13.append(r11)
            r13.append(r3)
            r13.append(r12)
            r13.append(r2)
            java.lang.String r11 = r13.toString()
            java.lang.String r11 = kotlin.text.StringsKt.trimIndent(r11)
            com.onesignal.debug.internal.logging.Logging.debug$default(r11, r8, r6, r8)
            return r8
        L_0x00b7:
            r3 = 0
            r4 = 0
            r7.L$0 = r8
            r7.L$1 = r8
            r7.L$2 = r8
            r7.label = r6
            r2 = r12
            r6 = r13
            java.lang.Object r13 = r1.sendAndCreateOutcomeEvent(r2, r3, r4, r6, r7)
            if (r13 != r0) goto L_0x00cb
            return r0
        L_0x00cb:
            return r13
        L_0x00cc:
            java.util.Set<java.lang.String> r13 = r10.unattributedUniqueOutcomeEventsSentOnSession
            boolean r13 = r13.contains(r11)
            if (r13 == 0) goto L_0x00f5
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r13 = "\n                    Measure endpoint will not send because unique outcome already sent for: \n                    Session: "
            r12.<init>(r13)
            com.onesignal.session.internal.influence.InfluenceType r13 = com.onesignal.session.internal.influence.InfluenceType.UNATTRIBUTED
            r12.append(r13)
            r12.append(r3)
            r12.append(r11)
            r12.append(r2)
            java.lang.String r11 = r12.toString()
            java.lang.String r11 = kotlin.text.StringsKt.trimIndent(r11)
            com.onesignal.debug.internal.logging.Logging.debug$default(r11, r8, r6, r8)
            return r8
        L_0x00f5:
            java.util.Set<java.lang.String> r13 = r10.unattributedUniqueOutcomeEventsSentOnSession
            r13.add(r11)
            r3 = 0
            r5 = 0
            r7.label = r4
            r1 = r10
            r2 = r11
            r4 = r5
            r6 = r12
            java.lang.Object r13 = r1.sendAndCreateOutcomeEvent(r2, r3, r4, r6, r7)
            if (r13 != r0) goto L_0x010a
            return r0
        L_0x010a:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.sendUniqueOutcomeEvent(java.lang.String, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0154 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0155 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object sendAndCreateOutcomeEvent(java.lang.String r22, float r23, long r24, java.util.List<com.onesignal.session.internal.influence.Influence> r26, kotlin.coroutines.Continuation<? super com.onesignal.session.internal.outcomes.impl.OutcomeEvent> r27) {
        /*
            r21 = this;
            r1 = r21
            r0 = r27
            boolean r2 = r0 instanceof com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$sendAndCreateOutcomeEvent$1
            if (r2 == 0) goto L_0x0018
            r2 = r0
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$sendAndCreateOutcomeEvent$1 r2 = (com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$sendAndCreateOutcomeEvent$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r0 = r2.label
            int r0 = r0 - r4
            r2.label = r0
            goto L_0x001d
        L_0x0018:
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$sendAndCreateOutcomeEvent$1 r2 = new com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$sendAndCreateOutcomeEvent$1
            r2.<init>(r1, r0)
        L_0x001d:
            java.lang.Object r0 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 2
            r7 = 0
            if (r4 == 0) goto L_0x0057
            if (r4 == r5) goto L_0x003b
            if (r4 != r6) goto L_0x0033
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0155
        L_0x0033:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x003b:
            long r4 = r2.J$0
            java.lang.Object r8 = r2.L$2
            com.onesignal.session.internal.outcomes.impl.OutcomeEventParams r8 = (com.onesignal.session.internal.outcomes.impl.OutcomeEventParams) r8
            java.lang.Object r9 = r2.L$1
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r2.L$0
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsController r10 = (com.onesignal.session.internal.outcomes.impl.OutcomeEventsController) r10
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ BackendException -> 0x004e }
            goto L_0x00fd
        L_0x004e:
            r0 = move-exception
            r18 = r9
            r9 = r0
            r0 = r10
            r10 = r18
            goto L_0x0113
        L_0x0057:
            kotlin.ResultKt.throwOnFailure(r0)
            com.onesignal.core.internal.time.ITime r0 = r1._time
            long r8 = r0.getCurrentTimeMillis()
            r0 = 1000(0x3e8, float:1.401E-42)
            long r10 = (long) r0
            long r8 = r8 / r10
            r0 = r7
            com.onesignal.session.internal.outcomes.impl.OutcomeSourceBody r0 = (com.onesignal.session.internal.outcomes.impl.OutcomeSourceBody) r0
            java.util.Iterator r0 = r26.iterator()
            r4 = 0
            r10 = r7
            r11 = r10
        L_0x006e:
            boolean r12 = r0.hasNext()
            if (r12 == 0) goto L_0x00c1
            java.lang.Object r12 = r0.next()
            com.onesignal.session.internal.influence.Influence r12 = (com.onesignal.session.internal.influence.Influence) r12
            com.onesignal.session.internal.influence.InfluenceType r13 = r12.getInfluenceType()
            int[] r14 = com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.WhenMappings.$EnumSwitchMapping$0
            int r13 = r13.ordinal()
            r13 = r14[r13]
            r14 = 3
            if (r13 == r5) goto L_0x00b5
            if (r13 == r6) goto L_0x00a9
            if (r13 == r14) goto L_0x00a7
            r14 = 4
            if (r13 == r14) goto L_0x0091
            goto L_0x006e
        L_0x0091:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r14 = "OutcomeEventsController.sendAndCreateOutcomeEvent: Outcomes disabled for channel: "
            r13.<init>(r14)
            com.onesignal.session.internal.influence.InfluenceChannel r12 = r12.getInfluenceChannel()
            r13.append(r12)
            java.lang.String r12 = r13.toString()
            com.onesignal.debug.internal.logging.Logging.verbose$default(r12, r7, r6, r7)
            goto L_0x006e
        L_0x00a7:
            r4 = r5
            goto L_0x006e
        L_0x00a9:
            if (r11 != 0) goto L_0x00b0
            com.onesignal.session.internal.outcomes.impl.OutcomeSourceBody r11 = new com.onesignal.session.internal.outcomes.impl.OutcomeSourceBody
            r11.<init>(r7, r7, r14, r7)
        L_0x00b0:
            com.onesignal.session.internal.outcomes.impl.OutcomeSourceBody r11 = r1.setSourceChannelIds(r12, r11)
            goto L_0x006e
        L_0x00b5:
            if (r10 != 0) goto L_0x00bc
            com.onesignal.session.internal.outcomes.impl.OutcomeSourceBody r10 = new com.onesignal.session.internal.outcomes.impl.OutcomeSourceBody
            r10.<init>(r7, r7, r14, r7)
        L_0x00bc:
            com.onesignal.session.internal.outcomes.impl.OutcomeSourceBody r10 = r1.setSourceChannelIds(r12, r10)
            goto L_0x006e
        L_0x00c1:
            if (r10 != 0) goto L_0x00cd
            if (r11 != 0) goto L_0x00cd
            if (r4 != 0) goto L_0x00cd
            java.lang.String r0 = "OutcomeEventsController.sendAndCreateOutcomeEvent: Outcomes disabled for all channels"
            com.onesignal.debug.internal.logging.Logging.verbose$default(r0, r7, r6, r7)
            return r7
        L_0x00cd:
            com.onesignal.session.internal.outcomes.impl.OutcomeSource r12 = new com.onesignal.session.internal.outcomes.impl.OutcomeSource
            r12.<init>(r10, r11)
            com.onesignal.session.internal.outcomes.impl.OutcomeEventParams r4 = new com.onesignal.session.internal.outcomes.impl.OutcomeEventParams
            r16 = 0
            r10 = r4
            r11 = r22
            r13 = r23
            r14 = r24
            r10.<init>(r11, r12, r13, r14, r16)
            r2.L$0 = r1     // Catch:{ BackendException -> 0x0109 }
            r10 = r22
            r2.L$1 = r10     // Catch:{ BackendException -> 0x0107 }
            r2.L$2 = r4     // Catch:{ BackendException -> 0x0107 }
            r2.J$0 = r8     // Catch:{ BackendException -> 0x0107 }
            r2.label = r5     // Catch:{ BackendException -> 0x0107 }
            java.lang.Object r0 = r1.requestMeasureOutcomeEvent(r4, r2)     // Catch:{ BackendException -> 0x0107 }
            if (r0 != r3) goto L_0x00f3
            return r3
        L_0x00f3:
            r18 = r10
            r10 = r1
            r19 = r8
            r8 = r4
            r4 = r19
            r9 = r18
        L_0x00fd:
            r10.saveUniqueOutcome(r8)     // Catch:{ BackendException -> 0x004e }
            com.onesignal.session.internal.outcomes.impl.OutcomeEvent$Companion r0 = com.onesignal.session.internal.outcomes.impl.OutcomeEvent.Companion     // Catch:{ BackendException -> 0x004e }
            com.onesignal.session.internal.outcomes.impl.OutcomeEvent r0 = r0.fromOutcomeEventParamstoOutcomeEvent(r8)     // Catch:{ BackendException -> 0x004e }
            return r0
        L_0x0107:
            r0 = move-exception
            goto L_0x010c
        L_0x0109:
            r0 = move-exception
            r10 = r22
        L_0x010c:
            r18 = r8
            r9 = r0
            r0 = r1
            r8 = r4
            r4 = r18
        L_0x0113:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r12 = "OutcomeEventsController.sendAndCreateOutcomeEvent: Sending outcome with name: "
            r11.<init>(r12)
            r11.append(r10)
            java.lang.String r10 = " failed with status code: "
            r11.append(r10)
            int r10 = r9.getStatusCode()
            r11.append(r10)
            java.lang.String r10 = " and response: "
            r11.append(r10)
            java.lang.String r9 = r9.getResponse()
            r11.append(r9)
            java.lang.String r9 = "\nOutcome event was cached and will be reattempted on app cold start"
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            com.onesignal.debug.internal.logging.Logging.warn$default(r9, r7, r6, r7)
            r8.setTimestamp(r4)
            com.onesignal.session.internal.outcomes.impl.IOutcomeEventsRepository r0 = r0._outcomeEventsCache
            r2.L$0 = r7
            r2.L$1 = r7
            r2.L$2 = r7
            r2.label = r6
            java.lang.Object r0 = r0.saveOutcomeEvent(r8, r2)
            if (r0 != r3) goto L_0x0155
            return r3
        L_0x0155:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.sendAndCreateOutcomeEvent(java.lang.String, float, long, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final OutcomeSourceBody setSourceChannelIds(Influence influence, OutcomeSourceBody outcomeSourceBody) {
        int i = WhenMappings.$EnumSwitchMapping$1[influence.getInfluenceChannel().ordinal()];
        if (i == 1) {
            outcomeSourceBody.setInAppMessagesIds(influence.getIds());
        } else if (i == 2) {
            outcomeSourceBody.setNotificationIds(influence.getIds());
        }
        return outcomeSourceBody;
    }

    private final List<Influence> removeDisabledInfluences(List<Influence> list) {
        List<Influence> mutableList = CollectionsKt.toMutableList(list);
        for (Influence next : list) {
            if (next.getInfluenceType().isDisabled()) {
                Logging.debug$default("OutcomeEventsController.removeDisabledInfluences: Outcomes disabled for channel: " + next.getInfluenceChannel(), (Throwable) null, 2, (Object) null);
                mutableList.remove(next);
            }
        }
        return mutableList;
    }

    private final void saveUniqueOutcome(OutcomeEventParams outcomeEventParams) {
        if (outcomeEventParams.isUnattributed()) {
            saveUnattributedUniqueOutcomeEvents();
        } else {
            saveAttributedUniqueOutcomeNotifications(outcomeEventParams);
        }
    }

    private final void saveAttributedUniqueOutcomeNotifications(OutcomeEventParams outcomeEventParams) {
        ThreadUtilsKt.suspendifyOnThread(10, new OutcomeEventsController$saveAttributedUniqueOutcomeNotifications$1(this, outcomeEventParams, (Continuation<? super OutcomeEventsController$saveAttributedUniqueOutcomeNotifications$1>) null));
    }

    private final void saveUnattributedUniqueOutcomeEvents() {
        this._outcomeEventsPreferences.setUnattributedUniqueOutcomeEventsSentByChannel(this.unattributedUniqueOutcomeEventsSentOnSession);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004a A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getUniqueIds(java.lang.String r5, java.util.List<com.onesignal.session.internal.influence.Influence> r6, kotlin.coroutines.Continuation<? super java.util.List<com.onesignal.session.internal.influence.Influence>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$getUniqueIds$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$getUniqueIds$1 r0 = (com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$getUniqueIds$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$getUniqueIds$1 r0 = new com.onesignal.session.internal.outcomes.impl.OutcomeEventsController$getUniqueIds$1
            r0.<init>(r4, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0040
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r7)
            com.onesignal.session.internal.outcomes.impl.IOutcomeEventsRepository r7 = r4._outcomeEventsCache
            r0.label = r3
            java.lang.Object r7 = r7.getNotCachedUniqueInfluencesForOutcome(r5, r6, r0)
            if (r7 != r1) goto L_0x0040
            return r1
        L_0x0040:
            java.util.List r7 = (java.util.List) r7
            java.util.Collection r7 = (java.util.Collection) r7
            boolean r5 = r7.isEmpty()
            if (r5 == 0) goto L_0x004b
            r7 = 0
        L_0x004b:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.getUniqueIds(java.lang.String, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object requestMeasureOutcomeEvent(OutcomeEventParams outcomeEventParams, Continuation<? super Unit> continuation) {
        Boolean bool;
        String appId = ((ConfigModel) this._configModelStore.getModel()).getAppId();
        String id = this._subscriptionManager.getSubscriptions().getPush().getId();
        String value = SubscriptionObjectType.Companion.fromDeviceType(this._deviceService.getDeviceType()).getValue();
        if (id.length() == 0 || value.length() == 0) {
            throw new BackendException(0, (String) null, (Integer) null, 6, (DefaultConstructorMarker) null);
        }
        OutcomeEvent fromOutcomeEventParamstoOutcomeEvent = OutcomeEvent.Companion.fromOutcomeEventParamstoOutcomeEvent(outcomeEventParams);
        int i = WhenMappings.$EnumSwitchMapping$0[fromOutcomeEventParamstoOutcomeEvent.getSession().ordinal()];
        if (i == 1) {
            bool = Boxing.boxBoolean(true);
        } else if (i != 2) {
            bool = null;
        } else {
            bool = Boxing.boxBoolean(false);
        }
        Object sendOutcomeEvent = this._outcomeEventsBackend.sendOutcomeEvent(appId, ((IdentityModel) this._identityModelStore.getModel()).getOnesignalId(), id, value, bool, fromOutcomeEventParamstoOutcomeEvent, continuation);
        return sendOutcomeEvent == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? sendOutcomeEvent : Unit.INSTANCE;
    }
}
