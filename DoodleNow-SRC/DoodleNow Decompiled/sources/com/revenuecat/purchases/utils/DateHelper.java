package com.revenuecat.purchases.utils;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/revenuecat/purchases/utils/DateHelper;", "", "()V", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: DateHelper.kt */
public final class DateHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final long ENTITLEMENT_GRACE_PERIOD = DurationKt.toDuration(3, DurationUnit.DAYS);

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J/\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000e"}, d2 = {"Lcom/revenuecat/purchases/utils/DateHelper$Companion;", "", "()V", "ENTITLEMENT_GRACE_PERIOD", "Lkotlin/time/Duration;", "J", "isDateActive", "Lcom/revenuecat/purchases/utils/DateActive;", "expirationDate", "Ljava/util/Date;", "requestDate", "gracePeriod", "isDateActive-SxA4cEA", "(Ljava/util/Date;Ljava/util/Date;J)Lcom/revenuecat/purchases/utils/DateActive;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: DateHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: isDateActive-SxA4cEA$default  reason: not valid java name */
        public static /* synthetic */ DateActive m1109isDateActiveSxA4cEA$default(Companion companion, Date date, Date date2, long j, int i, Object obj) {
            if ((i & 4) != 0) {
                j = DateHelper.ENTITLEMENT_GRACE_PERIOD;
            }
            return companion.m1110isDateActiveSxA4cEA(date, date2, j);
        }

        /* renamed from: isDateActive-SxA4cEA  reason: not valid java name */
        public final DateActive m1110isDateActiveSxA4cEA(Date date, Date date2, long j) {
            Intrinsics.checkNotNullParameter(date2, "requestDate");
            boolean z = true;
            if (date == null) {
                return new DateActive(true, true);
            }
            if (new Date().getTime() - date2.getTime() > Duration.m2581getInWholeMillisecondsimpl(j)) {
                z = false;
            }
            if (!z) {
                date2 = new Date();
            }
            return new DateActive(date.after(date2), z);
        }
    }

    private DateHelper() {
    }

    static {
        Duration.Companion companion = Duration.Companion;
    }
}
