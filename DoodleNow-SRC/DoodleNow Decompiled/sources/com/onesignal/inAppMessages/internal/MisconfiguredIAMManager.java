package com.onesignal.inAppMessages.internal;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.onesignal.inAppMessages.IInAppMessageClickListener;
import com.onesignal.inAppMessages.IInAppMessageLifecycleListener;
import com.onesignal.inAppMessages.IInAppMessagesManager;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u001e\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0012H\u0016J\u001c\u0010\u0013\u001a\u00020\u000b2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000fH\u0016J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0016\u0010\u001a\u001a\u00020\u000b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00120\u001cH\u0016R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048V@VX\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u001e"}, d2 = {"Lcom/onesignal/inAppMessages/internal/MisconfiguredIAMManager;", "Lcom/onesignal/inAppMessages/IInAppMessagesManager;", "()V", "value", "", "paused", "getPaused", "()Z", "setPaused", "(Z)V", "addClickListener", "", "listener", "Lcom/onesignal/inAppMessages/IInAppMessageClickListener;", "addLifecycleListener", "Lcom/onesignal/inAppMessages/IInAppMessageLifecycleListener;", "addTrigger", "key", "", "addTriggers", "triggers", "", "clearTriggers", "removeClickListener", "removeLifecycleListener", "removeTrigger", "removeTriggers", "keys", "", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: MisconfiguredIAMManager.kt */
public final class MisconfiguredIAMManager implements IInAppMessagesManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public boolean getPaused() {
        throw Companion.getEXCEPTION();
    }

    public void setPaused(boolean z) {
        throw Companion.getEXCEPTION();
    }

    public Void addTrigger(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, SubscriberAttributeKt.JSON_NAME_KEY);
        Intrinsics.checkNotNullParameter(str2, "value");
        throw Companion.getEXCEPTION();
    }

    public Void addTriggers(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "triggers");
        throw Companion.getEXCEPTION();
    }

    public Void removeTrigger(String str) {
        Intrinsics.checkNotNullParameter(str, SubscriberAttributeKt.JSON_NAME_KEY);
        throw Companion.getEXCEPTION();
    }

    public Void removeTriggers(Collection<String> collection) {
        Intrinsics.checkNotNullParameter(collection, "keys");
        throw Companion.getEXCEPTION();
    }

    public Void clearTriggers() {
        throw Companion.getEXCEPTION();
    }

    public Void addLifecycleListener(IInAppMessageLifecycleListener iInAppMessageLifecycleListener) {
        Intrinsics.checkNotNullParameter(iInAppMessageLifecycleListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        throw Companion.getEXCEPTION();
    }

    public Void removeLifecycleListener(IInAppMessageLifecycleListener iInAppMessageLifecycleListener) {
        Intrinsics.checkNotNullParameter(iInAppMessageLifecycleListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        throw Companion.getEXCEPTION();
    }

    public Void addClickListener(IInAppMessageClickListener iInAppMessageClickListener) {
        Intrinsics.checkNotNullParameter(iInAppMessageClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        throw Companion.getEXCEPTION();
    }

    public Void removeClickListener(IInAppMessageClickListener iInAppMessageClickListener) {
        Intrinsics.checkNotNullParameter(iInAppMessageClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        throw Companion.getEXCEPTION();
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/onesignal/inAppMessages/internal/MisconfiguredIAMManager$Companion;", "", "()V", "EXCEPTION", "", "getEXCEPTION", "()Ljava/lang/Throwable;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: MisconfiguredIAMManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final Throwable getEXCEPTION() {
            return new Exception("Must include gradle module com.onesignal:InAppMessages in order to use this functionality!");
        }
    }
}
