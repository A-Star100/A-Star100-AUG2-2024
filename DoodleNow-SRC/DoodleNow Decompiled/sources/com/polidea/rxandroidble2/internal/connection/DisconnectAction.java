package com.polidea.rxandroidble2.internal.connection;

import bleshadow.javax.inject.Inject;
import com.polidea.rxandroidble2.internal.operations.DisconnectOperation;
import com.polidea.rxandroidble2.internal.serialization.ClientOperationQueue;
import io.reactivex.internal.functions.Functions;

@ConnectionScope
class DisconnectAction implements ConnectionSubscriptionWatcher {
    private final ClientOperationQueue clientOperationQueue;
    private final DisconnectOperation operationDisconnect;

    public void onConnectionSubscribed() {
    }

    @Inject
    DisconnectAction(ClientOperationQueue clientOperationQueue2, DisconnectOperation disconnectOperation) {
        this.clientOperationQueue = clientOperationQueue2;
        this.operationDisconnect = disconnectOperation;
    }

    public void onConnectionUnsubscribed() {
        this.clientOperationQueue.queue(this.operationDisconnect).subscribe(Functions.emptyConsumer(), Functions.emptyConsumer());
    }
}
