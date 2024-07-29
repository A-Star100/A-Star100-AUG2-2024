package com.revenuecat.purchases.common;

import kotlin.Metadata;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001a\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0005R\u001c\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\r"}, d2 = {"Lcom/revenuecat/purchases/common/Delay;", "", "minDelay", "Lkotlin/time/Duration;", "maxDelay", "(Ljava/lang/String;IJJ)V", "getMaxDelay-UwyO8pc", "()J", "J", "getMinDelay-UwyO8pc", "NONE", "DEFAULT", "LONG", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Dispatcher.kt */
public enum Delay {
    NONE(r3, DurationKt.toDuration(0, DurationUnit.MILLISECONDS)),
    DEFAULT(DurationKt.toDuration(0, DurationUnit.MILLISECONDS), DispatcherConstants.INSTANCE.m1093getJitterDelayUwyO8pc()),
    LONG(DispatcherConstants.INSTANCE.m1093getJitterDelayUwyO8pc(), DispatcherConstants.INSTANCE.m1094getJitterLongDelayUwyO8pc());
    
    private final long maxDelay;
    private final long minDelay;

    /* renamed from: getMaxDelay-UwyO8pc  reason: not valid java name */
    public final long m1091getMaxDelayUwyO8pc() {
        return this.maxDelay;
    }

    /* renamed from: getMinDelay-UwyO8pc  reason: not valid java name */
    public final long m1092getMinDelayUwyO8pc() {
        return this.minDelay;
    }

    private Delay(long j, long j2) {
        this.minDelay = j;
        this.maxDelay = j2;
    }
}
