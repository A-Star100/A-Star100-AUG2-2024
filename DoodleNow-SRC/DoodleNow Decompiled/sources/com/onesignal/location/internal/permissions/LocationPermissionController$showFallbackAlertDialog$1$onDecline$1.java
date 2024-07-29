package com.onesignal.location.internal.permissions;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/onesignal/location/internal/permissions/ILocationPermissionChangedHandler;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: LocationPermissionController.kt */
final class LocationPermissionController$showFallbackAlertDialog$1$onDecline$1 extends Lambda implements Function1<ILocationPermissionChangedHandler, Unit> {
    public static final LocationPermissionController$showFallbackAlertDialog$1$onDecline$1 INSTANCE = new LocationPermissionController$showFallbackAlertDialog$1$onDecline$1();

    LocationPermissionController$showFallbackAlertDialog$1$onDecline$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ILocationPermissionChangedHandler) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ILocationPermissionChangedHandler iLocationPermissionChangedHandler) {
        Intrinsics.checkNotNullParameter(iLocationPermissionChangedHandler, "it");
        iLocationPermissionChangedHandler.onLocationPermissionChanged(false);
    }
}
