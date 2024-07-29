package com.polidea.rxandroidble2.internal.connection;

import com.polidea.rxandroidble2.internal.util.CharacteristicChangedEvent;
import io.reactivex.functions.Function;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class NotificationAndIndicationManager$$ExternalSyntheticLambda6 implements Function {
    public final Object apply(Object obj) {
        return ((CharacteristicChangedEvent) obj).data;
    }
}
