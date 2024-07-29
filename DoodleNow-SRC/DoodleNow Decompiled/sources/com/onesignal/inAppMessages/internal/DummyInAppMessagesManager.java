package com.onesignal.inAppMessages.internal;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.onesignal.inAppMessages.IInAppMessageClickListener;
import com.onesignal.inAppMessages.IInAppMessageLifecycleListener;
import com.onesignal.inAppMessages.IInAppMessagesManager;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u001e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u001c\u0010\u0013\u001a\u00020\n2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0015H\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000eH\u0016J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0016\u0010\u001a\u001a\u00020\n2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00110\u001cH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u001d"}, d2 = {"Lcom/onesignal/inAppMessages/internal/DummyInAppMessagesManager;", "Lcom/onesignal/inAppMessages/IInAppMessagesManager;", "()V", "paused", "", "getPaused", "()Z", "setPaused", "(Z)V", "addClickListener", "", "listener", "Lcom/onesignal/inAppMessages/IInAppMessageClickListener;", "addLifecycleListener", "Lcom/onesignal/inAppMessages/IInAppMessageLifecycleListener;", "addTrigger", "key", "", "value", "addTriggers", "triggers", "", "clearTriggers", "removeClickListener", "removeLifecycleListener", "removeTrigger", "removeTriggers", "keys", "", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: DummyInAppMessagesManager.kt */
public final class DummyInAppMessagesManager implements IInAppMessagesManager {
    private boolean paused = true;

    public void addClickListener(IInAppMessageClickListener iInAppMessageClickListener) {
        Intrinsics.checkNotNullParameter(iInAppMessageClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
    }

    public void addLifecycleListener(IInAppMessageLifecycleListener iInAppMessageLifecycleListener) {
        Intrinsics.checkNotNullParameter(iInAppMessageLifecycleListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
    }

    public void addTrigger(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, SubscriberAttributeKt.JSON_NAME_KEY);
        Intrinsics.checkNotNullParameter(str2, "value");
    }

    public void addTriggers(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "triggers");
    }

    public void clearTriggers() {
    }

    public boolean getPaused() {
        return this.paused;
    }

    public void removeClickListener(IInAppMessageClickListener iInAppMessageClickListener) {
        Intrinsics.checkNotNullParameter(iInAppMessageClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
    }

    public void removeLifecycleListener(IInAppMessageLifecycleListener iInAppMessageLifecycleListener) {
        Intrinsics.checkNotNullParameter(iInAppMessageLifecycleListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
    }

    public void removeTrigger(String str) {
        Intrinsics.checkNotNullParameter(str, SubscriberAttributeKt.JSON_NAME_KEY);
    }

    public void removeTriggers(Collection<String> collection) {
        Intrinsics.checkNotNullParameter(collection, "keys");
    }

    public void setPaused(boolean z) {
        this.paused = z;
    }
}
