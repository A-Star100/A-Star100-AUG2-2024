package com.polidea.rxandroidble2.internal.connection;

import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ConnectorImpl$$ExternalSyntheticLambda0 implements Callable {
    public final /* synthetic */ ConnectionComponent f$0;

    public /* synthetic */ ConnectorImpl$$ExternalSyntheticLambda0(ConnectionComponent connectionComponent) {
        this.f$0 = connectionComponent;
    }

    public final Object call() {
        return this.f$0.rxBleConnection();
    }
}
