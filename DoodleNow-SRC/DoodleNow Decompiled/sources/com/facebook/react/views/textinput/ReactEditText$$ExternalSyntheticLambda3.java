package com.facebook.react.views.textinput;

import androidx.core.util.Predicate;
import com.facebook.react.views.text.internal.span.ReactStrikethroughSpan;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ReactEditText$$ExternalSyntheticLambda3 implements Predicate {
    public final /* synthetic */ ReactEditText f$0;

    public /* synthetic */ ReactEditText$$ExternalSyntheticLambda3(ReactEditText reactEditText) {
        this.f$0 = reactEditText;
    }

    public /* synthetic */ Predicate and(Predicate predicate) {
        return Predicate.CC.$default$and(this, predicate);
    }

    public /* synthetic */ Predicate negate() {
        return Predicate.CC.$default$negate(this);
    }

    public /* synthetic */ Predicate or(Predicate predicate) {
        return Predicate.CC.$default$or(this, predicate);
    }

    public final boolean test(Object obj) {
        return this.f$0.lambda$stripStyleEquivalentSpans$3((ReactStrikethroughSpan) obj);
    }
}
