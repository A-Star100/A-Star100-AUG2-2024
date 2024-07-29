package com.onesignal.core.internal.time.impl;

import com.onesignal.core.internal.time.ITime;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/onesignal/core/internal/time/impl/Time;", "Lcom/onesignal/core/internal/time/ITime;", "()V", "currentTimeMillis", "", "getCurrentTimeMillis", "()J", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Time.kt */
public final class Time implements ITime {
    public long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }
}
