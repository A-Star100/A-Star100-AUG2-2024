package com.facebook.react.internal.featureflags;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/facebook/react/internal/featureflags/ReactNativeFeatureFlagsAccessor;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ReactNativeFeatureFlagsForTests.kt */
final class ReactNativeFeatureFlagsForTests$setUp$1 extends Lambda implements Function0<ReactNativeFeatureFlagsAccessor> {
    public static final ReactNativeFeatureFlagsForTests$setUp$1 INSTANCE = new ReactNativeFeatureFlagsForTests$setUp$1();

    ReactNativeFeatureFlagsForTests$setUp$1() {
        super(0);
    }

    public final ReactNativeFeatureFlagsAccessor invoke() {
        return new ReactNativeFeatureFlagsLocalAccessor();
    }
}
