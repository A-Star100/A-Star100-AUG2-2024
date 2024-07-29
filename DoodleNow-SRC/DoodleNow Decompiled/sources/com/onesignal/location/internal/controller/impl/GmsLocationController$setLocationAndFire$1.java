package com.onesignal.location.internal.controller.impl;

import android.location.Location;
import com.onesignal.location.internal.controller.ILocationUpdatedHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/onesignal/location/internal/controller/ILocationUpdatedHandler;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: GmsLocationController.kt */
final class GmsLocationController$setLocationAndFire$1 extends Lambda implements Function1<ILocationUpdatedHandler, Unit> {
    final /* synthetic */ Location $location;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GmsLocationController$setLocationAndFire$1(Location location) {
        super(1);
        this.$location = location;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ILocationUpdatedHandler) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ILocationUpdatedHandler iLocationUpdatedHandler) {
        Intrinsics.checkNotNullParameter(iLocationUpdatedHandler, "it");
        iLocationUpdatedHandler.onLocationChanged(this.$location);
    }
}
