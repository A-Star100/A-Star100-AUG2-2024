package com.onesignal.core.internal.config;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ConfigModel.kt */
final class InfluenceConfigModel$indirectNotificationAttributionWindow$2 extends Lambda implements Function0<Integer> {
    public static final InfluenceConfigModel$indirectNotificationAttributionWindow$2 INSTANCE = new InfluenceConfigModel$indirectNotificationAttributionWindow$2();

    InfluenceConfigModel$indirectNotificationAttributionWindow$2() {
        super(0);
    }

    public final Integer invoke() {
        return Integer.valueOf(InfluenceConfigModel.DEFAULT_INDIRECT_ATTRIBUTION_WINDOW);
    }
}
