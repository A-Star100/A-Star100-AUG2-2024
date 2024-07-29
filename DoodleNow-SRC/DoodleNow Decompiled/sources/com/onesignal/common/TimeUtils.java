package com.onesignal.common;

import android.os.Build;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.io.path.PathTreeWalk$$ExternalSyntheticApiModelOutline0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/onesignal/common/TimeUtils;", "", "()V", "getTimeZoneId", "", "getTimeZoneOffset", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TimeUtils.kt */
public final class TimeUtils {
    public static final TimeUtils INSTANCE = new TimeUtils();

    private TimeUtils() {
    }

    public final int getTimeZoneOffset() {
        TimeZone timeZone = Calendar.getInstance().getTimeZone();
        int rawOffset = timeZone.getRawOffset();
        if (timeZone.inDaylightTime(new Date())) {
            rawOffset += timeZone.getDSTSavings();
        }
        return rawOffset / 1000;
    }

    public final String getTimeZoneId() {
        if (Build.VERSION.SDK_INT >= 26) {
            String m = PathTreeWalk$$ExternalSyntheticApiModelOutline0.m().getId();
            Intrinsics.checkNotNullExpressionValue(m, "{\n            ZoneId.systemDefault().id\n        }");
            return m;
        }
        String id = TimeZone.getDefault().getID();
        Intrinsics.checkNotNullExpressionValue(id, "{\n            TimeZone.getDefault().id\n        }");
        return id;
    }
}
