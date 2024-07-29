package com.onesignal.session.internal.influence.impl;

import com.onesignal.common.JSONUtils;
import com.onesignal.core.internal.application.AppEntryAction;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.session.internal.influence.IInfluenceManager;
import com.onesignal.session.internal.influence.Influence;
import com.onesignal.session.internal.influence.InfluenceType;
import com.onesignal.session.internal.session.ISessionLifecycleHandler;
import com.onesignal.session.internal.session.ISessionService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u001c\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u001fH\u0002J\u0012\u0010&\u001a\u0004\u0018\u00010\u00102\u0006\u0010#\u001a\u00020$H\u0002J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\u001fH\u0016J\u0010\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020\u001fH\u0016J\b\u0010,\u001a\u00020\"H\u0016J\u0010\u0010-\u001a\u00020\"2\u0006\u0010)\u001a\u00020\u001fH\u0016J\u0010\u0010.\u001a\u00020\"2\u0006\u0010+\u001a\u00020\u001fH\u0016J\b\u0010/\u001a\u00020\"H\u0016J\u0010\u00100\u001a\u00020\"2\u0006\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u00020\"H\u0016J\u0010\u00104\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J,\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00102\u0006\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010\u001f2\b\u0010;\u001a\u0004\u0018\u00010<H\u0002J,\u0010=\u001a\u0002062\u0006\u00107\u001a\u00020\u00102\u0006\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010\u001f2\b\u0010;\u001a\u0004\u0018\u00010<H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00108BX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0012R\u0014\u0010\u001b\u001a\u00020\u00108BX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0017R\u001a\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001eX\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/onesignal/session/internal/influence/impl/InfluenceManager;", "Lcom/onesignal/session/internal/influence/IInfluenceManager;", "Lcom/onesignal/session/internal/session/ISessionLifecycleHandler;", "_sessionService", "Lcom/onesignal/session/internal/session/ISessionService;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "preferences", "Lcom/onesignal/core/internal/preferences/IPreferencesService;", "timeProvider", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/session/internal/session/ISessionService;Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/core/internal/preferences/IPreferencesService;Lcom/onesignal/core/internal/time/ITime;)V", "channels", "", "Lcom/onesignal/session/internal/influence/impl/IChannelTracker;", "getChannels", "()Ljava/util/List;", "dataRepository", "Lcom/onesignal/session/internal/influence/impl/InfluenceDataRepository;", "iAMChannelTracker", "getIAMChannelTracker", "()Lcom/onesignal/session/internal/influence/impl/IChannelTracker;", "influences", "Lcom/onesignal/session/internal/influence/Influence;", "getInfluences", "notificationChannelTracker", "getNotificationChannelTracker", "trackers", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/onesignal/session/internal/influence/impl/ChannelTracker;", "attemptSessionUpgrade", "", "entryAction", "Lcom/onesignal/core/internal/application/AppEntryAction;", "directId", "getChannelByEntryAction", "getChannelsToResetByEntryAction", "onDirectInfluenceFromIAM", "messageId", "onDirectInfluenceFromNotification", "notificationId", "onInAppMessageDismissed", "onInAppMessageDisplayed", "onNotificationReceived", "onSessionActive", "onSessionEnded", "duration", "", "onSessionStarted", "restartSessionTrackersIfNeeded", "setSessionTracker", "", "channelTracker", "influenceType", "Lcom/onesignal/session/internal/influence/InfluenceType;", "directNotificationId", "indirectNotificationIds", "Lorg/json/JSONArray;", "willChangeSessionTracker", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: InfluenceManager.kt */
public final class InfluenceManager implements IInfluenceManager, ISessionLifecycleHandler {
    private final IApplicationService _applicationService;
    private final ConfigModelStore _configModelStore;
    private final ISessionService _sessionService;
    private final InfluenceDataRepository dataRepository;
    private final ConcurrentHashMap<String, ChannelTracker> trackers;

    public void onSessionEnded(long j) {
    }

    public InfluenceManager(ISessionService iSessionService, IApplicationService iApplicationService, ConfigModelStore configModelStore, IPreferencesService iPreferencesService, ITime iTime) {
        Intrinsics.checkNotNullParameter(iSessionService, "_sessionService");
        Intrinsics.checkNotNullParameter(iApplicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(configModelStore, "_configModelStore");
        Intrinsics.checkNotNullParameter(iPreferencesService, "preferences");
        Intrinsics.checkNotNullParameter(iTime, "timeProvider");
        this._sessionService = iSessionService;
        this._applicationService = iApplicationService;
        this._configModelStore = configModelStore;
        ConcurrentHashMap<String, ChannelTracker> concurrentHashMap = new ConcurrentHashMap<>();
        this.trackers = concurrentHashMap;
        InfluenceDataRepository influenceDataRepository = new InfluenceDataRepository(iPreferencesService, configModelStore);
        this.dataRepository = influenceDataRepository;
        concurrentHashMap.put(InfluenceConstants.INSTANCE.getIAM_TAG(), new InAppMessageTracker(influenceDataRepository, iTime));
        concurrentHashMap.put(InfluenceConstants.INSTANCE.getNOTIFICATION_TAG(), new NotificationTracker(influenceDataRepository, iTime));
        iSessionService.subscribe(this);
        Collection<ChannelTracker> values = concurrentHashMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "trackers.values");
        for (ChannelTracker initInfluencedTypeFromCache : values) {
            initInfluencedTypeFromCache.initInfluencedTypeFromCache();
        }
    }

    public List<Influence> getInfluences() {
        Collection<ChannelTracker> values = this.trackers.values();
        Intrinsics.checkNotNullExpressionValue(values, "trackers.values");
        Iterable<ChannelTracker> iterable = values;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ChannelTracker currentSessionInfluence : iterable) {
            arrayList.add(currentSessionInfluence.getCurrentSessionInfluence());
        }
        return (List) arrayList;
    }

    private final IChannelTracker getIAMChannelTracker() {
        ChannelTracker channelTracker = this.trackers.get(InfluenceConstants.INSTANCE.getIAM_TAG());
        Intrinsics.checkNotNull(channelTracker);
        return channelTracker;
    }

    private final IChannelTracker getNotificationChannelTracker() {
        ChannelTracker channelTracker = this.trackers.get(InfluenceConstants.INSTANCE.getNOTIFICATION_TAG());
        Intrinsics.checkNotNull(channelTracker);
        return channelTracker;
    }

    private final List<IChannelTracker> getChannels() {
        List<IChannelTracker> arrayList = new ArrayList<>();
        arrayList.add(getNotificationChannelTracker());
        arrayList.add(getIAMChannelTracker());
        return arrayList;
    }

    public void onSessionStarted() {
        restartSessionTrackersIfNeeded(this._applicationService.getEntryState());
    }

    public void onSessionActive() {
        attemptSessionUpgrade$default(this, this._applicationService.getEntryState(), (String) null, 2, (Object) null);
    }

    private final IChannelTracker getChannelByEntryAction(AppEntryAction appEntryAction) {
        if (appEntryAction.isNotificationClick()) {
            return getNotificationChannelTracker();
        }
        return null;
    }

    private final List<IChannelTracker> getChannelsToResetByEntryAction(AppEntryAction appEntryAction) {
        List<IChannelTracker> arrayList = new ArrayList<>();
        if (appEntryAction.isAppClose()) {
            return arrayList;
        }
        IChannelTracker notificationChannelTracker = appEntryAction.isAppOpen() ? getNotificationChannelTracker() : null;
        if (notificationChannelTracker != null) {
            arrayList.add(notificationChannelTracker);
        }
        arrayList.add(getIAMChannelTracker());
        return arrayList;
    }

    public void onNotificationReceived(String str) {
        Intrinsics.checkNotNullParameter(str, "notificationId");
        Logging.debug$default("InfluenceManager.onNotificationReceived(notificationId: " + str + ')', (Throwable) null, 2, (Object) null);
        if (str.length() != 0) {
            getNotificationChannelTracker().saveLastId(str);
        }
    }

    public void onDirectInfluenceFromNotification(String str) {
        Intrinsics.checkNotNullParameter(str, "notificationId");
        Logging.debug$default("InfluenceManager.onDirectInfluenceFromNotification(notificationId: " + str + ')', (Throwable) null, 2, (Object) null);
        if (str.length() != 0) {
            attemptSessionUpgrade(AppEntryAction.NOTIFICATION_CLICK, str);
        }
    }

    public void onInAppMessageDisplayed(String str) {
        Intrinsics.checkNotNullParameter(str, "messageId");
        Logging.debug$default("InfluenceManager.onInAppMessageReceived(messageId: " + str + ')', (Throwable) null, 2, (Object) null);
        IChannelTracker iAMChannelTracker = getIAMChannelTracker();
        iAMChannelTracker.saveLastId(str);
        iAMChannelTracker.resetAndInitInfluence();
    }

    public void onDirectInfluenceFromIAM(String str) {
        Intrinsics.checkNotNullParameter(str, "messageId");
        Logging.debug$default("InfluenceManager.onDirectInfluenceFromIAM(messageId: " + str + ')', (Throwable) null, 2, (Object) null);
        setSessionTracker(getIAMChannelTracker(), InfluenceType.DIRECT, str, (JSONArray) null);
    }

    public void onInAppMessageDismissed() {
        Logging.debug$default("InfluenceManager.onInAppMessageDismissed()", (Throwable) null, 2, (Object) null);
        getIAMChannelTracker().resetAndInitInfluence();
    }

    private final void restartSessionTrackersIfNeeded(AppEntryAction appEntryAction) {
        boolean z;
        List<IChannelTracker> channelsToResetByEntryAction = getChannelsToResetByEntryAction(appEntryAction);
        List arrayList = new ArrayList();
        Logging.debug$default("InfluenceManager.restartSessionIfNeeded(entryAction: " + appEntryAction + "):\n channelTrackers: " + channelsToResetByEntryAction, (Throwable) null, 2, (Object) null);
        for (IChannelTracker next : channelsToResetByEntryAction) {
            JSONArray lastReceivedIds = next.getLastReceivedIds();
            Logging.debug$default("InfluenceManager.restartSessionIfNeeded: lastIds: " + lastReceivedIds, (Throwable) null, 2, (Object) null);
            Influence currentSessionInfluence = next.getCurrentSessionInfluence();
            if (lastReceivedIds.length() > 0) {
                z = setSessionTracker(next, InfluenceType.INDIRECT, (String) null, lastReceivedIds);
            } else {
                z = setSessionTracker(next, InfluenceType.UNATTRIBUTED, (String) null, (JSONArray) null);
            }
            if (z) {
                arrayList.add(currentSessionInfluence);
            }
        }
    }

    private final boolean setSessionTracker(IChannelTracker iChannelTracker, InfluenceType influenceType, String str, JSONArray jSONArray) {
        if (!willChangeSessionTracker(iChannelTracker, influenceType, str, jSONArray)) {
            return false;
        }
        Logging.debug$default(StringsKt.trimIndent("\n            ChannelTracker changed: " + iChannelTracker.getIdTag() + "\n            from:\n            influenceType: " + iChannelTracker.getInfluenceType() + ", directNotificationId: " + iChannelTracker.getDirectId() + ", indirectNotificationIds: " + iChannelTracker.getIndirectIds() + "\n            to:\n            influenceType: " + influenceType + ", directNotificationId: " + str + ", indirectNotificationIds: " + jSONArray + "\n            "), (Throwable) null, 2, (Object) null);
        iChannelTracker.setInfluenceType(influenceType);
        iChannelTracker.setDirectId(str);
        iChannelTracker.setIndirectIds(jSONArray);
        iChannelTracker.cacheState();
        StringBuilder sb = new StringBuilder("InfluenceManager.setSessionTracker: Trackers changed to: ");
        sb.append(getChannels());
        Logging.debug$default(sb.toString(), (Throwable) null, 2, (Object) null);
        return true;
    }

    private final boolean willChangeSessionTracker(IChannelTracker iChannelTracker, InfluenceType influenceType, String str, JSONArray jSONArray) {
        if (influenceType != iChannelTracker.getInfluenceType()) {
            return true;
        }
        InfluenceType influenceType2 = iChannelTracker.getInfluenceType();
        if (influenceType2 != null && influenceType2.isDirect() && iChannelTracker.getDirectId() != null && !Intrinsics.areEqual((Object) iChannelTracker.getDirectId(), (Object) str)) {
            return true;
        }
        if (!(influenceType2 == null || !influenceType2.isIndirect() || iChannelTracker.getIndirectIds() == null)) {
            JSONArray indirectIds = iChannelTracker.getIndirectIds();
            Intrinsics.checkNotNull(indirectIds);
            if (indirectIds.length() <= 0 || JSONUtils.INSTANCE.compareJSONArrays(iChannelTracker.getIndirectIds(), jSONArray)) {
                return false;
            }
            return true;
        }
        return false;
    }

    static /* synthetic */ void attemptSessionUpgrade$default(InfluenceManager influenceManager, AppEntryAction appEntryAction, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        influenceManager.attemptSessionUpgrade(appEntryAction, str);
    }

    private final void attemptSessionUpgrade(AppEntryAction appEntryAction, String str) {
        boolean z;
        Influence influence;
        Logging.debug$default("InfluenceManager.attemptSessionUpgrade(entryAction: " + appEntryAction + ", directId: " + str + ')', (Throwable) null, 2, (Object) null);
        IChannelTracker channelByEntryAction = getChannelByEntryAction(appEntryAction);
        List<IChannelTracker> channelsToResetByEntryAction = getChannelsToResetByEntryAction(appEntryAction);
        List arrayList = new ArrayList();
        if (channelByEntryAction != null) {
            influence = channelByEntryAction.getCurrentSessionInfluence();
            InfluenceType influenceType = InfluenceType.DIRECT;
            if (str == null) {
                str = channelByEntryAction.getDirectId();
            }
            z = setSessionTracker(channelByEntryAction, influenceType, str, (JSONArray) null);
        } else {
            z = false;
            influence = null;
        }
        if (z) {
            Logging.debug$default("InfluenceManager.attemptSessionUpgrade: channel updated, search for ending direct influences on channels: " + channelsToResetByEntryAction, (Throwable) null, 2, (Object) null);
            Intrinsics.checkNotNull(influence);
            arrayList.add(influence);
            for (IChannelTracker next : channelsToResetByEntryAction) {
                InfluenceType influenceType2 = next.getInfluenceType();
                if (influenceType2 != null && influenceType2.isDirect()) {
                    arrayList.add(next.getCurrentSessionInfluence());
                    next.resetAndInitInfluence();
                }
            }
        }
        Logging.debug$default("InfluenceManager.attemptSessionUpgrade: try UNATTRIBUTED to INDIRECT upgrade", (Throwable) null, 2, (Object) null);
        for (IChannelTracker next2 : channelsToResetByEntryAction) {
            InfluenceType influenceType3 = next2.getInfluenceType();
            if (influenceType3 != null && influenceType3.isUnattributed()) {
                JSONArray lastReceivedIds = next2.getLastReceivedIds();
                if (lastReceivedIds.length() > 0 && !appEntryAction.isAppClose()) {
                    Influence currentSessionInfluence = next2.getCurrentSessionInfluence();
                    if (setSessionTracker(next2, InfluenceType.INDIRECT, (String) null, lastReceivedIds)) {
                        arrayList.add(currentSessionInfluence);
                    }
                }
            }
        }
        Logging.debug$default("InfluenceManager.attemptSessionUpgrade: Trackers after update attempt: " + getChannels(), (Throwable) null, 2, (Object) null);
    }
}
