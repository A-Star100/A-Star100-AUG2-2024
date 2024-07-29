package com.onesignal.inAppMessages.internal.triggers.impl;

import com.onesignal.debug.internal.logging.Logging;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/onesignal/inAppMessages/internal/triggers/impl/DynamicTriggerTimer;", "", "()V", "scheduleTrigger", "", "task", "Ljava/util/TimerTask;", "triggerId", "", "delay", "", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: DynamicTriggerTimer.kt */
public final class DynamicTriggerTimer {
    public static final DynamicTriggerTimer INSTANCE = new DynamicTriggerTimer();

    private DynamicTriggerTimer() {
    }

    public final void scheduleTrigger(TimerTask timerTask, String str, long j) {
        Intrinsics.checkNotNullParameter(str, "triggerId");
        Logging.debug$default("scheduleTrigger: " + str + " delay: " + j, (Throwable) null, 2, (Object) null);
        StringBuilder sb = new StringBuilder("trigger_timer:");
        sb.append(str);
        new Timer(sb.toString()).schedule(timerTask, j);
    }
}
