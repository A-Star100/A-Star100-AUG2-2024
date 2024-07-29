package com.onesignal.location.internal.controller.impl;

import android.location.Location;
import com.onesignal.location.internal.controller.ILocationController;
import com.onesignal.location.internal.controller.ILocationUpdatedHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0011\u0010\t\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0011\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/onesignal/location/internal/controller/impl/NullLocationController;", "Lcom/onesignal/location/internal/controller/ILocationController;", "()V", "hasSubscribers", "", "getHasSubscribers", "()Z", "getLastLocation", "Landroid/location/Location;", "start", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stop", "", "subscribe", "handler", "Lcom/onesignal/location/internal/controller/ILocationUpdatedHandler;", "unsubscribe", "com.onesignal.location"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NullLocationController.kt */
public final class NullLocationController implements ILocationController {
    public boolean getHasSubscribers() {
        return false;
    }

    public Location getLastLocation() {
        return null;
    }

    public void subscribe(ILocationUpdatedHandler iLocationUpdatedHandler) {
        Intrinsics.checkNotNullParameter(iLocationUpdatedHandler, "handler");
    }

    public void unsubscribe(ILocationUpdatedHandler iLocationUpdatedHandler) {
        Intrinsics.checkNotNullParameter(iLocationUpdatedHandler, "handler");
    }

    public Object start(Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(false);
    }

    public Object stop(Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }
}
