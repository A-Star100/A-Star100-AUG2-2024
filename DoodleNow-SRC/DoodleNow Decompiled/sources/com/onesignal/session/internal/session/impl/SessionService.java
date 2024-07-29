package com.onesignal.session.internal.session.impl;

import com.onesignal.common.events.EventProducer;
import com.onesignal.core.internal.application.IApplicationLifecycleHandler;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.background.IBackgroundService;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.session.internal.session.ISessionLifecycleHandler;
import com.onesignal.session.internal.session.ISessionService;
import com.onesignal.session.internal.session.SessionModel;
import com.onesignal.session.internal.session.SessionModelStore;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B%\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0011\u0010!\u001a\u00020\"H@ø\u0001\u0000¢\u0006\u0002\u0010#J\u0010\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\u0011H\u0016J\b\u0010&\u001a\u00020\"H\u0016J\b\u0010'\u001a\u00020\"H\u0016J\u0010\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\u001cH\u0016J\u0010\u0010*\u001a\u00020\"2\u0006\u0010)\u001a\u00020\u001cH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 \u0002\u0004\n\u0002\b\u0019¨\u0006+"}, d2 = {"Lcom/onesignal/session/internal/session/impl/SessionService;", "Lcom/onesignal/session/internal/session/ISessionService;", "Lcom/onesignal/core/internal/startup/IStartableService;", "Lcom/onesignal/core/internal/background/IBackgroundService;", "Lcom/onesignal/core/internal/application/IApplicationLifecycleHandler;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_sessionModelStore", "Lcom/onesignal/session/internal/session/SessionModelStore;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/session/internal/session/SessionModelStore;Lcom/onesignal/core/internal/time/ITime;)V", "config", "Lcom/onesignal/core/internal/config/ConfigModel;", "hasSubscribers", "", "getHasSubscribers", "()Z", "scheduleBackgroundRunIn", "", "getScheduleBackgroundRunIn", "()Ljava/lang/Long;", "session", "Lcom/onesignal/session/internal/session/SessionModel;", "sessionLifeCycleNotifier", "Lcom/onesignal/common/events/EventProducer;", "Lcom/onesignal/session/internal/session/ISessionLifecycleHandler;", "shouldFireOnSubscribe", "startTime", "getStartTime", "()J", "backgroundRun", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onFocus", "firedOnSubscribe", "onUnfocused", "start", "subscribe", "handler", "unsubscribe", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SessionService.kt */
public final class SessionService implements ISessionService, IStartableService, IBackgroundService, IApplicationLifecycleHandler {
    private final IApplicationService _applicationService;
    private final ConfigModelStore _configModelStore;
    private final SessionModelStore _sessionModelStore;
    private final ITime _time;
    private ConfigModel config;
    private SessionModel session;
    private final EventProducer<ISessionLifecycleHandler> sessionLifeCycleNotifier = new EventProducer<>();
    private boolean shouldFireOnSubscribe;

    public SessionService(IApplicationService iApplicationService, ConfigModelStore configModelStore, SessionModelStore sessionModelStore, ITime iTime) {
        Intrinsics.checkNotNullParameter(iApplicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(configModelStore, "_configModelStore");
        Intrinsics.checkNotNullParameter(sessionModelStore, "_sessionModelStore");
        Intrinsics.checkNotNullParameter(iTime, "_time");
        this._applicationService = iApplicationService;
        this._configModelStore = configModelStore;
        this._sessionModelStore = sessionModelStore;
        this._time = iTime;
    }

    public long getStartTime() {
        SessionModel sessionModel = this.session;
        Intrinsics.checkNotNull(sessionModel);
        return sessionModel.getStartTime();
    }

    public Long getScheduleBackgroundRunIn() {
        SessionModel sessionModel = this.session;
        Intrinsics.checkNotNull(sessionModel);
        if (!sessionModel.isValid()) {
            return null;
        }
        ConfigModel configModel = this.config;
        Intrinsics.checkNotNull(configModel);
        return Long.valueOf(configModel.getSessionFocusTimeout());
    }

    public void start() {
        this.session = (SessionModel) this._sessionModelStore.getModel();
        this.config = (ConfigModel) this._configModelStore.getModel();
        SessionModel sessionModel = this.session;
        Intrinsics.checkNotNull(sessionModel);
        sessionModel.setValid(false);
        this._applicationService.addApplicationLifecycleHandler(this);
    }

    public Object backgroundRun(Continuation<? super Unit> continuation) {
        SessionModel sessionModel = this.session;
        Intrinsics.checkNotNull(sessionModel);
        long activeDuration = sessionModel.getActiveDuration();
        Logging.debug$default("SessionService.backgroundRun: Session ended. activeDuration: " + activeDuration, (Throwable) null, 2, (Object) null);
        SessionModel sessionModel2 = this.session;
        Intrinsics.checkNotNull(sessionModel2);
        sessionModel2.setValid(false);
        this.sessionLifeCycleNotifier.fire(new SessionService$backgroundRun$2(activeDuration));
        SessionModel sessionModel3 = this.session;
        Intrinsics.checkNotNull(sessionModel3);
        sessionModel3.setActiveDuration(0);
        return Unit.INSTANCE;
    }

    public void onFocus(boolean z) {
        LogLevel logLevel = LogLevel.DEBUG;
        Logging.log(logLevel, "SessionService.onFocus() - fired from start: " + z);
        SessionModel sessionModel = this.session;
        Intrinsics.checkNotNull(sessionModel);
        if (!sessionModel.isValid()) {
            this.shouldFireOnSubscribe = z;
            SessionModel sessionModel2 = this.session;
            Intrinsics.checkNotNull(sessionModel2);
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
            sessionModel2.setSessionId(uuid);
            SessionModel sessionModel3 = this.session;
            Intrinsics.checkNotNull(sessionModel3);
            sessionModel3.setStartTime(this._time.getCurrentTimeMillis());
            SessionModel sessionModel4 = this.session;
            Intrinsics.checkNotNull(sessionModel4);
            SessionModel sessionModel5 = this.session;
            Intrinsics.checkNotNull(sessionModel5);
            sessionModel4.setFocusTime(sessionModel5.getStartTime());
            SessionModel sessionModel6 = this.session;
            Intrinsics.checkNotNull(sessionModel6);
            sessionModel6.setValid(true);
            StringBuilder sb = new StringBuilder("SessionService: New session started at ");
            SessionModel sessionModel7 = this.session;
            Intrinsics.checkNotNull(sessionModel7);
            sb.append(sessionModel7.getStartTime());
            Logging.debug$default(sb.toString(), (Throwable) null, 2, (Object) null);
            this.sessionLifeCycleNotifier.fire(SessionService$onFocus$1.INSTANCE);
            return;
        }
        SessionModel sessionModel8 = this.session;
        Intrinsics.checkNotNull(sessionModel8);
        sessionModel8.setFocusTime(this._time.getCurrentTimeMillis());
        this.sessionLifeCycleNotifier.fire(SessionService$onFocus$2.INSTANCE);
    }

    public void onUnfocused() {
        long currentTimeMillis = this._time.getCurrentTimeMillis();
        SessionModel sessionModel = this.session;
        Intrinsics.checkNotNull(sessionModel);
        long focusTime = currentTimeMillis - sessionModel.getFocusTime();
        SessionModel sessionModel2 = this.session;
        Intrinsics.checkNotNull(sessionModel2);
        sessionModel2.setActiveDuration(sessionModel2.getActiveDuration() + focusTime);
        LogLevel logLevel = LogLevel.DEBUG;
        StringBuilder sb = new StringBuilder("SessionService.onUnfocused adding time ");
        sb.append(focusTime);
        sb.append(" for total: ");
        SessionModel sessionModel3 = this.session;
        Intrinsics.checkNotNull(sessionModel3);
        sb.append(sessionModel3.getActiveDuration());
        Logging.log(logLevel, sb.toString());
    }

    public void subscribe(ISessionLifecycleHandler iSessionLifecycleHandler) {
        Intrinsics.checkNotNullParameter(iSessionLifecycleHandler, "handler");
        this.sessionLifeCycleNotifier.subscribe(iSessionLifecycleHandler);
        if (this.shouldFireOnSubscribe) {
            iSessionLifecycleHandler.onSessionStarted();
        }
    }

    public void unsubscribe(ISessionLifecycleHandler iSessionLifecycleHandler) {
        Intrinsics.checkNotNullParameter(iSessionLifecycleHandler, "handler");
        this.sessionLifeCycleNotifier.unsubscribe(iSessionLifecycleHandler);
    }

    public boolean getHasSubscribers() {
        return this.sessionLifeCycleNotifier.getHasSubscribers();
    }
}
