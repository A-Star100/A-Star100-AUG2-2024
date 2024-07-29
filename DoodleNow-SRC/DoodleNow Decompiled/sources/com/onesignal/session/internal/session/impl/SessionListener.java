package com.onesignal.session.internal.session.impl;

import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.operations.IOperationRepo;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.session.internal.outcomes.IOutcomeEventsController;
import com.onesignal.session.internal.session.ISessionLifecycleHandler;
import com.onesignal.session.internal.session.ISessionService;
import com.onesignal.user.internal.identity.IdentityModel;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.operations.TrackSessionEndOperation;
import com.onesignal.user.internal.operations.TrackSessionStartOperation;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00152\u00020\u00012\u00020\u0002:\u0001\u0015B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/onesignal/session/internal/session/impl/SessionListener;", "Lcom/onesignal/core/internal/startup/IStartableService;", "Lcom/onesignal/session/internal/session/ISessionLifecycleHandler;", "_operationRepo", "Lcom/onesignal/core/internal/operations/IOperationRepo;", "_sessionService", "Lcom/onesignal/session/internal/session/ISessionService;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_identityModelStore", "Lcom/onesignal/user/internal/identity/IdentityModelStore;", "_outcomeEventsController", "Lcom/onesignal/session/internal/outcomes/IOutcomeEventsController;", "(Lcom/onesignal/core/internal/operations/IOperationRepo;Lcom/onesignal/session/internal/session/ISessionService;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/user/internal/identity/IdentityModelStore;Lcom/onesignal/session/internal/outcomes/IOutcomeEventsController;)V", "onSessionActive", "", "onSessionEnded", "duration", "", "onSessionStarted", "start", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SessionListener.kt */
public final class SessionListener implements IStartableService, ISessionLifecycleHandler {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long SECONDS_IN_A_DAY = 86400;
    private final ConfigModelStore _configModelStore;
    private final IdentityModelStore _identityModelStore;
    private final IOperationRepo _operationRepo;
    /* access modifiers changed from: private */
    public final IOutcomeEventsController _outcomeEventsController;
    private final ISessionService _sessionService;

    public void onSessionActive() {
    }

    public SessionListener(IOperationRepo iOperationRepo, ISessionService iSessionService, ConfigModelStore configModelStore, IdentityModelStore identityModelStore, IOutcomeEventsController iOutcomeEventsController) {
        Intrinsics.checkNotNullParameter(iOperationRepo, "_operationRepo");
        Intrinsics.checkNotNullParameter(iSessionService, "_sessionService");
        Intrinsics.checkNotNullParameter(configModelStore, "_configModelStore");
        Intrinsics.checkNotNullParameter(identityModelStore, "_identityModelStore");
        Intrinsics.checkNotNullParameter(iOutcomeEventsController, "_outcomeEventsController");
        this._operationRepo = iOperationRepo;
        this._sessionService = iSessionService;
        this._configModelStore = configModelStore;
        this._identityModelStore = identityModelStore;
        this._outcomeEventsController = iOutcomeEventsController;
    }

    public void start() {
        this._sessionService.subscribe(this);
    }

    public void onSessionStarted() {
        IOperationRepo.DefaultImpls.enqueue$default(this._operationRepo, new TrackSessionStartOperation(((ConfigModel) this._configModelStore.getModel()).getAppId(), ((IdentityModel) this._identityModelStore.getModel()).getOnesignalId()), false, 2, (Object) null);
    }

    public void onSessionEnded(long j) {
        long j2 = j / ((long) 1000);
        if (j2 < 1 || j2 > SECONDS_IN_A_DAY) {
            Logging.error$default("SessionListener.onSessionEnded sending duration of " + j2 + " seconds", (Throwable) null, 2, (Object) null);
        }
        IOperationRepo.DefaultImpls.enqueue$default(this._operationRepo, new TrackSessionEndOperation(((ConfigModel) this._configModelStore.getModel()).getAppId(), ((IdentityModel) this._identityModelStore.getModel()).getOnesignalId(), j2), false, 2, (Object) null);
        ThreadUtilsKt.suspendifyOnThread$default(0, new SessionListener$onSessionEnded$1(this, j2, (Continuation<? super SessionListener$onSessionEnded$1>) null), 1, (Object) null);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/onesignal/session/internal/session/impl/SessionListener$Companion;", "", "()V", "SECONDS_IN_A_DAY", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SessionListener.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
