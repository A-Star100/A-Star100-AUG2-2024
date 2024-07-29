package com.onesignal.location.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.location.internal.LocationManager", f = "LocationManager.kt", i = {}, l = {195}, m = "startGetLocation", n = {}, s = {})
/* compiled from: LocationManager.kt */
final class LocationManager$startGetLocation$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocationManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LocationManager$startGetLocation$1(LocationManager locationManager, Continuation<? super LocationManager$startGetLocation$1> continuation) {
        super(continuation);
        this.this$0 = locationManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.startGetLocation(this);
    }
}
