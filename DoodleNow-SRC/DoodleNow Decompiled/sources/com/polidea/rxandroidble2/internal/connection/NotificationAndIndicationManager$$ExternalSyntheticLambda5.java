package com.polidea.rxandroidble2.internal.connection;

import com.polidea.rxandroidble2.internal.util.CharacteristicChangedEvent;
import com.polidea.rxandroidble2.internal.util.CharacteristicNotificationId;
import io.reactivex.functions.Predicate;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class NotificationAndIndicationManager$$ExternalSyntheticLambda5 implements Predicate {
    public final /* synthetic */ CharacteristicNotificationId f$0;

    public /* synthetic */ NotificationAndIndicationManager$$ExternalSyntheticLambda5(CharacteristicNotificationId characteristicNotificationId) {
        this.f$0 = characteristicNotificationId;
    }

    public final boolean test(Object obj) {
        return ((CharacteristicChangedEvent) obj).equals(this.f$0);
    }
}
