package org.reactivestreams;

import java.util.StringJoiner;
import java.util.concurrent.Flow;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FlowAdapters$$ExternalSyntheticApiModelOutline0 {
    public static /* synthetic */ StringJoiner m(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        return new StringJoiner(charSequence, charSequence2, charSequence3);
    }

    public static /* bridge */ /* synthetic */ boolean m$1(Object obj) {
        return obj instanceof Flow.Subscriber;
    }

    public static /* bridge */ /* synthetic */ boolean m$2(Object obj) {
        return obj instanceof Flow.Publisher;
    }
}
