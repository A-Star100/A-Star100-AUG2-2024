package com.onesignal.notifications.internal.analytics.impl;

import com.google.firebase.messaging.Constants;
import com.onesignal.notifications.internal.analytics.IAnalyticsTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/onesignal/notifications/internal/analytics/impl/NoAnalyticsTracker;", "Lcom/onesignal/notifications/internal/analytics/IAnalyticsTracker;", "()V", "trackInfluenceOpenEvent", "", "trackOpenedEvent", "notificationId", "", "campaign", "trackReceivedEvent", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NoAnalyticsTracker.kt */
public final class NoAnalyticsTracker implements IAnalyticsTracker {
    public void trackInfluenceOpenEvent() {
    }

    public void trackOpenedEvent(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "notificationId");
        Intrinsics.checkNotNullParameter(str2, Constants.ScionAnalytics.PARAM_CAMPAIGN);
    }

    public void trackReceivedEvent(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "notificationId");
        Intrinsics.checkNotNullParameter(str2, Constants.ScionAnalytics.PARAM_CAMPAIGN);
    }
}
