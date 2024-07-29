package com.onesignal.core.internal.config;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.apache.commons.lang3.time.DateUtils;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Long;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ConfigModel.kt */
final class ConfigModel$backgroundFetchNotificationPermissionInterval$2 extends Lambda implements Function0<Long> {
    public static final ConfigModel$backgroundFetchNotificationPermissionInterval$2 INSTANCE = new ConfigModel$backgroundFetchNotificationPermissionInterval$2();

    ConfigModel$backgroundFetchNotificationPermissionInterval$2() {
        super(0);
    }

    public final Long invoke() {
        return Long.valueOf(DateUtils.MILLIS_PER_DAY);
    }
}
