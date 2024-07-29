package com.revenuecat.purchases.common;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"between", "Lkotlin/time/Duration;", "Lkotlin/time/Duration$Companion;", "startTime", "Ljava/util/Date;", "endTime", "(Lkotlin/time/Duration$Companion;Ljava/util/Date;Ljava/util/Date;)J", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: durationExtensions.kt */
public final class DurationExtensionsKt {
    public static final long between(Duration.Companion companion, Date date, Date date2) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(date, "startTime");
        Intrinsics.checkNotNullParameter(date2, "endTime");
        return DurationKt.toDuration(date2.getTime() - date.getTime(), DurationUnit.MILLISECONDS);
    }
}
