package com.onesignal.user.internal.subscriptions.impl;

import android.os.Build;
import com.onesignal.common.AndroidUtils;
import com.onesignal.common.DeviceUtils;
import com.onesignal.common.IDManager;
import com.onesignal.common.OneSignalUtils;
import com.onesignal.common.events.EventProducer;
import com.onesignal.common.modeling.IModelStore;
import com.onesignal.common.modeling.IModelStoreChangeHandler;
import com.onesignal.common.modeling.Model;
import com.onesignal.common.modeling.ModelChangedArgs;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.session.internal.session.ISessionLifecycleHandler;
import com.onesignal.session.internal.session.ISessionService;
import com.onesignal.user.internal.EmailSubscription;
import com.onesignal.user.internal.PushSubscription;
import com.onesignal.user.internal.SmsSubscription;
import com.onesignal.user.internal.Subscription;
import com.onesignal.user.internal.UninitializedPushSubscription;
import com.onesignal.user.internal.subscriptions.ISubscriptionChangedHandler;
import com.onesignal.user.internal.subscriptions.ISubscriptionManager;
import com.onesignal.user.internal.subscriptions.SubscriptionList;
import com.onesignal.user.internal.subscriptions.SubscriptionModel;
import com.onesignal.user.internal.subscriptions.SubscriptionModelStore;
import com.onesignal.user.internal.subscriptions.SubscriptionStatus;
import com.onesignal.user.internal.subscriptions.SubscriptionType;
import com.onesignal.user.subscriptions.IEmailSubscription;
import com.onesignal.user.subscriptions.IPushSubscription;
import com.onesignal.user.subscriptions.ISmsSubscription;
import com.onesignal.user.subscriptions.ISubscription;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u001a\u0010 \u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001fH\u0016J$\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001f2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010#H\u0002J\u0010\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u0003H\u0002J\u0010\u0010-\u001a\u00020.2\u0006\u0010,\u001a\u00020\u0003H\u0002J\u0018\u0010/\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\u00032\u0006\u00101\u001a\u00020\u001fH\u0016J\u0018\u00102\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\u00032\u0006\u00101\u001a\u00020\u001fH\u0016J\u0018\u00103\u001a\u00020\u001d2\u0006\u00104\u001a\u0002052\u0006\u00101\u001a\u00020\u001fH\u0016J\b\u00106\u001a\u00020\u001dH\u0016J\u0010\u00107\u001a\u00020\u001d2\u0006\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u00020\u001dH\u0016J\b\u0010;\u001a\u00020\u001dH\u0002J\u0010\u0010<\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010=\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001fH\u0016J\u0010\u0010>\u001a\u00020\u001d2\u0006\u0010?\u001a\u00020.H\u0002J\u0010\u0010@\u001a\u00020\u001d2\u0006\u0010?\u001a\u00020.H\u0002J\u0010\u0010A\u001a\u00020\u001d2\u0006\u0010B\u001a\u00020\u000eH\u0016J\u0010\u0010C\u001a\u00020\u001d2\u0006\u0010B\u001a\u00020\u000eH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006D"}, d2 = {"Lcom/onesignal/user/internal/subscriptions/impl/SubscriptionManager;", "Lcom/onesignal/user/internal/subscriptions/ISubscriptionManager;", "Lcom/onesignal/common/modeling/IModelStoreChangeHandler;", "Lcom/onesignal/user/internal/subscriptions/SubscriptionModel;", "Lcom/onesignal/session/internal/session/ISessionLifecycleHandler;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_sessionService", "Lcom/onesignal/session/internal/session/ISessionService;", "_subscriptionModelStore", "Lcom/onesignal/user/internal/subscriptions/SubscriptionModelStore;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/session/internal/session/ISessionService;Lcom/onesignal/user/internal/subscriptions/SubscriptionModelStore;)V", "events", "Lcom/onesignal/common/events/EventProducer;", "Lcom/onesignal/user/internal/subscriptions/ISubscriptionChangedHandler;", "hasSubscribers", "", "getHasSubscribers", "()Z", "pushSubscriptionModel", "getPushSubscriptionModel", "()Lcom/onesignal/user/internal/subscriptions/SubscriptionModel;", "subscriptions", "Lcom/onesignal/user/internal/subscriptions/SubscriptionList;", "getSubscriptions", "()Lcom/onesignal/user/internal/subscriptions/SubscriptionList;", "setSubscriptions", "(Lcom/onesignal/user/internal/subscriptions/SubscriptionList;)V", "addEmailSubscription", "", "email", "", "addOrUpdatePushSubscriptionToken", "pushToken", "pushTokenStatus", "Lcom/onesignal/user/internal/subscriptions/SubscriptionStatus;", "addSmsSubscription", "sms", "addSubscriptionToModels", "type", "Lcom/onesignal/user/internal/subscriptions/SubscriptionType;", "address", "status", "createSubscriptionAndAddToSubscriptionList", "subscriptionModel", "createSubscriptionFromModel", "Lcom/onesignal/user/subscriptions/ISubscription;", "onModelAdded", "model", "tag", "onModelRemoved", "onModelUpdated", "args", "Lcom/onesignal/common/modeling/ModelChangedArgs;", "onSessionActive", "onSessionEnded", "duration", "", "onSessionStarted", "refreshPushSubscriptionState", "removeEmailSubscription", "removeSmsSubscription", "removeSubscriptionFromModels", "subscription", "removeSubscriptionFromSubscriptionList", "subscribe", "handler", "unsubscribe", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SubscriptionManager.kt */
public final class SubscriptionManager implements ISubscriptionManager, IModelStoreChangeHandler<SubscriptionModel>, ISessionLifecycleHandler {
    private final IApplicationService _applicationService;
    private final ISessionService _sessionService;
    private final SubscriptionModelStore _subscriptionModelStore;
    private final EventProducer<ISubscriptionChangedHandler> events = new EventProducer<>();
    private SubscriptionList subscriptions = new SubscriptionList(CollectionsKt.emptyList(), new UninitializedPushSubscription());

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SubscriptionManager.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SubscriptionType.values().length];
            iArr[SubscriptionType.SMS.ordinal()] = 1;
            iArr[SubscriptionType.EMAIL.ordinal()] = 2;
            iArr[SubscriptionType.PUSH.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public SubscriptionList getSubscriptions() {
        return this.subscriptions;
    }

    public void onSessionActive() {
    }

    public void onSessionEnded(long j) {
    }

    public void setSubscriptions(SubscriptionList subscriptionList) {
        Intrinsics.checkNotNullParameter(subscriptionList, "<set-?>");
        this.subscriptions = subscriptionList;
    }

    public SubscriptionManager(IApplicationService iApplicationService, ISessionService iSessionService, SubscriptionModelStore subscriptionModelStore) {
        Intrinsics.checkNotNullParameter(iApplicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(iSessionService, "_sessionService");
        Intrinsics.checkNotNullParameter(subscriptionModelStore, "_subscriptionModelStore");
        this._applicationService = iApplicationService;
        this._sessionService = iSessionService;
        this._subscriptionModelStore = subscriptionModelStore;
        for (SubscriptionModel createSubscriptionAndAddToSubscriptionList : subscriptionModelStore.list()) {
            createSubscriptionAndAddToSubscriptionList(createSubscriptionAndAddToSubscriptionList);
        }
        this._subscriptionModelStore.subscribe(this);
        this._sessionService.subscribe(this);
    }

    public SubscriptionModel getPushSubscriptionModel() {
        IPushSubscription push = getSubscriptions().getPush();
        Intrinsics.checkNotNull(push, "null cannot be cast to non-null type com.onesignal.user.internal.PushSubscription");
        return ((PushSubscription) push).getModel();
    }

    public void onSessionStarted() {
        refreshPushSubscriptionState();
    }

    public void addEmailSubscription(String str) {
        Intrinsics.checkNotNullParameter(str, "email");
        addSubscriptionToModels$default(this, SubscriptionType.EMAIL, str, (SubscriptionStatus) null, 4, (Object) null);
    }

    public void addSmsSubscription(String str) {
        Intrinsics.checkNotNullParameter(str, "sms");
        addSubscriptionToModels$default(this, SubscriptionType.SMS, str, (SubscriptionStatus) null, 4, (Object) null);
    }

    public void addOrUpdatePushSubscriptionToken(String str, SubscriptionStatus subscriptionStatus) {
        Intrinsics.checkNotNullParameter(subscriptionStatus, "pushTokenStatus");
        IPushSubscription push = getSubscriptions().getPush();
        if (push instanceof UninitializedPushSubscription) {
            SubscriptionType subscriptionType = SubscriptionType.PUSH;
            if (str == null) {
                str = "";
            }
            addSubscriptionToModels(subscriptionType, str, subscriptionStatus);
            return;
        }
        Intrinsics.checkNotNull(push, "null cannot be cast to non-null type com.onesignal.user.internal.Subscription");
        SubscriptionModel model = ((Subscription) push).getModel();
        if (str != null) {
            model.setAddress(str);
        }
        model.setStatus(subscriptionStatus);
    }

    public void removeEmailSubscription(String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "email");
        Iterator it = getSubscriptions().getEmails().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            IEmailSubscription iEmailSubscription = (IEmailSubscription) obj;
            if ((iEmailSubscription instanceof EmailSubscription) && Intrinsics.areEqual((Object) iEmailSubscription.getEmail(), (Object) str)) {
                break;
            }
        }
        IEmailSubscription iEmailSubscription2 = (IEmailSubscription) obj;
        if (iEmailSubscription2 != null) {
            removeSubscriptionFromModels(iEmailSubscription2);
        }
    }

    public void removeSmsSubscription(String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "sms");
        Iterator it = getSubscriptions().getSmss().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            ISmsSubscription iSmsSubscription = (ISmsSubscription) obj;
            if ((iSmsSubscription instanceof SmsSubscription) && Intrinsics.areEqual((Object) iSmsSubscription.getNumber(), (Object) str)) {
                break;
            }
        }
        ISmsSubscription iSmsSubscription2 = (ISmsSubscription) obj;
        if (iSmsSubscription2 != null) {
            removeSubscriptionFromModels(iSmsSubscription2);
        }
    }

    static /* synthetic */ void addSubscriptionToModels$default(SubscriptionManager subscriptionManager, SubscriptionType subscriptionType, String str, SubscriptionStatus subscriptionStatus, int i, Object obj) {
        if ((i & 4) != 0) {
            subscriptionStatus = null;
        }
        subscriptionManager.addSubscriptionToModels(subscriptionType, str, subscriptionStatus);
    }

    private final void addSubscriptionToModels(SubscriptionType subscriptionType, String str, SubscriptionStatus subscriptionStatus) {
        LogLevel logLevel = LogLevel.DEBUG;
        Logging.log(logLevel, "SubscriptionManager.addSubscription(type: " + subscriptionType + ", address: " + str + ')');
        SubscriptionModel subscriptionModel = new SubscriptionModel();
        subscriptionModel.setId(IDManager.INSTANCE.createLocalId());
        subscriptionModel.setOptedIn(true);
        subscriptionModel.setType(subscriptionType);
        subscriptionModel.setAddress(str);
        if (subscriptionStatus == null) {
            subscriptionStatus = SubscriptionStatus.SUBSCRIBED;
        }
        subscriptionModel.setStatus(subscriptionStatus);
        IModelStore.DefaultImpls.add$default(this._subscriptionModelStore, subscriptionModel, (String) null, 2, (Object) null);
    }

    private final void removeSubscriptionFromModels(ISubscription iSubscription) {
        LogLevel logLevel = LogLevel.DEBUG;
        Logging.log(logLevel, "SubscriptionManager.removeSubscription(subscription: " + iSubscription + ')');
        IModelStore.DefaultImpls.remove$default(this._subscriptionModelStore, iSubscription.getId(), (String) null, 2, (Object) null);
    }

    public void subscribe(ISubscriptionChangedHandler iSubscriptionChangedHandler) {
        Intrinsics.checkNotNullParameter(iSubscriptionChangedHandler, "handler");
        this.events.subscribe(iSubscriptionChangedHandler);
    }

    public void unsubscribe(ISubscriptionChangedHandler iSubscriptionChangedHandler) {
        Intrinsics.checkNotNullParameter(iSubscriptionChangedHandler, "handler");
        this.events.unsubscribe(iSubscriptionChangedHandler);
    }

    public boolean getHasSubscribers() {
        return this.events.getHasSubscribers();
    }

    public void onModelAdded(SubscriptionModel subscriptionModel, String str) {
        Intrinsics.checkNotNullParameter(subscriptionModel, "model");
        Intrinsics.checkNotNullParameter(str, "tag");
        createSubscriptionAndAddToSubscriptionList(subscriptionModel);
    }

    public void onModelUpdated(ModelChangedArgs modelChangedArgs, String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(modelChangedArgs, "args");
        Intrinsics.checkNotNullParameter(str, "tag");
        Iterator it = getSubscriptions().getCollection().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            ISubscription iSubscription = (ISubscription) obj;
            Model model = modelChangedArgs.getModel();
            Intrinsics.checkNotNull(iSubscription, "null cannot be cast to non-null type com.onesignal.user.internal.Subscription");
            if (Intrinsics.areEqual((Object) model, (Object) ((Subscription) iSubscription).getModel())) {
                break;
            }
        }
        ISubscription iSubscription2 = (ISubscription) obj;
        if (iSubscription2 == null) {
            Model model2 = modelChangedArgs.getModel();
            Intrinsics.checkNotNull(model2, "null cannot be cast to non-null type com.onesignal.user.internal.subscriptions.SubscriptionModel");
            createSubscriptionAndAddToSubscriptionList((SubscriptionModel) model2);
            return;
        }
        if (iSubscription2 instanceof PushSubscription) {
            ((PushSubscription) iSubscription2).getChangeHandlersNotifier().fireOnMain(new SubscriptionManager$onModelUpdated$1(iSubscription2));
        }
        this.events.fire(new SubscriptionManager$onModelUpdated$2(iSubscription2, modelChangedArgs));
    }

    public void onModelRemoved(SubscriptionModel subscriptionModel, String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(subscriptionModel, "model");
        Intrinsics.checkNotNullParameter(str, "tag");
        Iterator it = getSubscriptions().getCollection().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((ISubscription) obj).getId(), (Object) subscriptionModel.getId())) {
                break;
            }
        }
        ISubscription iSubscription = (ISubscription) obj;
        if (iSubscription != null) {
            removeSubscriptionFromSubscriptionList(iSubscription);
        }
    }

    private final void createSubscriptionAndAddToSubscriptionList(SubscriptionModel subscriptionModel) {
        ISubscription createSubscriptionFromModel = createSubscriptionFromModel(subscriptionModel);
        List mutableList = CollectionsKt.toMutableList(getSubscriptions().getCollection());
        if (subscriptionModel.getType() == SubscriptionType.PUSH) {
            IPushSubscription push = getSubscriptions().getPush();
            Intrinsics.checkNotNull(push, "null cannot be cast to non-null type com.onesignal.user.internal.PushSubscription");
            PushSubscription pushSubscription = (PushSubscription) push;
            Intrinsics.checkNotNull(createSubscriptionFromModel, "null cannot be cast to non-null type com.onesignal.user.internal.PushSubscription");
            ((PushSubscription) createSubscriptionFromModel).getChangeHandlersNotifier().subscribeAll(pushSubscription.getChangeHandlersNotifier());
            mutableList.remove(pushSubscription);
        }
        mutableList.add(createSubscriptionFromModel);
        setSubscriptions(new SubscriptionList(mutableList, new UninitializedPushSubscription()));
        this.events.fire(new SubscriptionManager$createSubscriptionAndAddToSubscriptionList$1(createSubscriptionFromModel));
    }

    private final void removeSubscriptionFromSubscriptionList(ISubscription iSubscription) {
        List mutableList = CollectionsKt.toMutableList(getSubscriptions().getCollection());
        mutableList.remove(iSubscription);
        setSubscriptions(new SubscriptionList(mutableList, new UninitializedPushSubscription()));
        this.events.fire(new SubscriptionManager$removeSubscriptionFromSubscriptionList$1(iSubscription));
    }

    private final ISubscription createSubscriptionFromModel(SubscriptionModel subscriptionModel) {
        int i = WhenMappings.$EnumSwitchMapping$0[subscriptionModel.getType().ordinal()];
        if (i == 1) {
            return new SmsSubscription(subscriptionModel);
        }
        if (i == 2) {
            return new EmailSubscription(subscriptionModel);
        }
        if (i == 3) {
            return new PushSubscription(subscriptionModel);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final void refreshPushSubscriptionState() {
        IPushSubscription push = getSubscriptions().getPush();
        if (!(push instanceof UninitializedPushSubscription)) {
            Intrinsics.checkNotNull(push, "null cannot be cast to non-null type com.onesignal.user.internal.Subscription");
            SubscriptionModel model = ((Subscription) push).getModel();
            model.setSdk(OneSignalUtils.SDK_VERSION);
            String str = Build.VERSION.RELEASE;
            Intrinsics.checkNotNullExpressionValue(str, "RELEASE");
            model.setDeviceOS(str);
            String carrierName = DeviceUtils.INSTANCE.getCarrierName(this._applicationService.getAppContext());
            if (carrierName != null) {
                model.setCarrier(carrierName);
            }
            String appVersion = AndroidUtils.INSTANCE.getAppVersion(this._applicationService.getAppContext());
            if (appVersion != null) {
                model.setAppVersion(appVersion);
            }
        }
    }
}
