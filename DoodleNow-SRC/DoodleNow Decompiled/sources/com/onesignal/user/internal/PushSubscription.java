package com.onesignal.user.internal;

import com.onesignal.common.events.EventProducer;
import com.onesignal.common.modeling.Model;
import com.onesignal.user.internal.subscriptions.SubscriptionModel;
import com.onesignal.user.internal.subscriptions.SubscriptionStatus;
import com.onesignal.user.subscriptions.IPushSubscription;
import com.onesignal.user.subscriptions.IPushSubscriptionObserver;
import com.onesignal.user.subscriptions.PushSubscriptionState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\bH\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u0019H\u0016J\u0006\u0010\u001e\u001a\u00020\u0010J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\bH\u0016R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006 "}, d2 = {"Lcom/onesignal/user/internal/PushSubscription;", "Lcom/onesignal/user/internal/Subscription;", "Lcom/onesignal/user/subscriptions/IPushSubscription;", "model", "Lcom/onesignal/user/internal/subscriptions/SubscriptionModel;", "(Lcom/onesignal/user/internal/subscriptions/SubscriptionModel;)V", "changeHandlersNotifier", "Lcom/onesignal/common/events/EventProducer;", "Lcom/onesignal/user/subscriptions/IPushSubscriptionObserver;", "getChangeHandlersNotifier", "()Lcom/onesignal/common/events/EventProducer;", "optedIn", "", "getOptedIn", "()Z", "<set-?>", "Lcom/onesignal/user/subscriptions/PushSubscriptionState;", "savedState", "getSavedState", "()Lcom/onesignal/user/subscriptions/PushSubscriptionState;", "token", "", "getToken", "()Ljava/lang/String;", "addObserver", "", "observer", "fetchState", "optIn", "optOut", "refreshState", "removeObserver", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PushSubscription.kt */
public class PushSubscription extends Subscription implements IPushSubscription {
    private final EventProducer<IPushSubscriptionObserver> changeHandlersNotifier = new EventProducer<>();
    private PushSubscriptionState savedState = fetchState();

    public final EventProducer<IPushSubscriptionObserver> getChangeHandlersNotifier() {
        return this.changeHandlersNotifier;
    }

    public final PushSubscriptionState getSavedState() {
        return this.savedState;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PushSubscription(SubscriptionModel subscriptionModel) {
        super(subscriptionModel);
        Intrinsics.checkNotNullParameter(subscriptionModel, "model");
    }

    public String getToken() {
        return getModel().getAddress();
    }

    public boolean getOptedIn() {
        return getModel().getOptedIn() && getModel().getStatus() != SubscriptionStatus.NO_PERMISSION;
    }

    public void optIn() {
        Model.setBooleanProperty$default(getModel(), "optedIn", true, (String) null, true, 4, (Object) null);
    }

    public void optOut() {
        getModel().setOptedIn(false);
    }

    public void addObserver(IPushSubscriptionObserver iPushSubscriptionObserver) {
        Intrinsics.checkNotNullParameter(iPushSubscriptionObserver, "observer");
        this.changeHandlersNotifier.subscribe(iPushSubscriptionObserver);
    }

    public void removeObserver(IPushSubscriptionObserver iPushSubscriptionObserver) {
        Intrinsics.checkNotNullParameter(iPushSubscriptionObserver, "observer");
        this.changeHandlersNotifier.unsubscribe(iPushSubscriptionObserver);
    }

    public final PushSubscriptionState refreshState() {
        PushSubscriptionState fetchState = fetchState();
        this.savedState = fetchState;
        return fetchState;
    }

    private final PushSubscriptionState fetchState() {
        return new PushSubscriptionState(getId(), getToken(), getOptedIn());
    }
}
