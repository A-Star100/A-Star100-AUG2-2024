package com.polidea.rxandroidble2.internal.connection;

import android.bluetooth.BluetoothGatt;
import bleshadow.javax.inject.Inject;
import bleshadow.javax.inject.Named;
import com.polidea.rxandroidble2.ConnectionSetup;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.internal.connection.ConnectionComponent;
import com.polidea.rxandroidble2.internal.serialization.ClientOperationQueue;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class ConnectorImpl implements Connector {
    final Scheduler callbacksScheduler;
    private final ClientOperationQueue clientOperationQueue;
    final ConnectionComponent.Builder connectionComponentBuilder;

    @Inject
    public ConnectorImpl(ClientOperationQueue clientOperationQueue2, ConnectionComponent.Builder builder, @Named("bluetooth_callbacks") Scheduler scheduler) {
        this.clientOperationQueue = clientOperationQueue2;
        this.connectionComponentBuilder = builder;
        this.callbacksScheduler = scheduler;
    }

    public Observable<RxBleConnection> prepareConnection(ConnectionSetup connectionSetup) {
        return Observable.defer(new ConnectorImpl$$ExternalSyntheticLambda3(this, connectionSetup));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$prepareConnection$2$com-polidea-rxandroidble2-internal-connection-ConnectorImpl  reason: not valid java name */
    public /* synthetic */ ObservableSource m1053lambda$prepareConnection$2$compolidearxandroidble2internalconnectionConnectorImpl(ConnectionSetup connectionSetup) throws Exception {
        ConnectionComponent build = this.connectionComponentBuilder.autoConnect(connectionSetup.autoConnect).suppressOperationChecks(connectionSetup.suppressOperationCheck).operationTimeout(connectionSetup.operationTimeout).build();
        Set<ConnectionSubscriptionWatcher> connectionSubscriptionWatchers = build.connectionSubscriptionWatchers();
        return obtainRxBleConnection(build).mergeWith(observeDisconnections(build)).delaySubscription(enqueueConnectOperation(build)).doOnSubscribe(new ConnectorImpl$$ExternalSyntheticLambda1(connectionSubscriptionWatchers)).doFinally(new ConnectorImpl$$ExternalSyntheticLambda2(connectionSubscriptionWatchers)).subscribeOn(this.callbacksScheduler).unsubscribeOn(this.callbacksScheduler);
    }

    static /* synthetic */ void lambda$prepareConnection$0(Set set, Disposable disposable) throws Exception {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((ConnectionSubscriptionWatcher) it.next()).onConnectionSubscribed();
        }
    }

    static /* synthetic */ void lambda$prepareConnection$1(Set set) throws Exception {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((ConnectionSubscriptionWatcher) it.next()).onConnectionUnsubscribed();
        }
    }

    static Observable<RxBleConnection> obtainRxBleConnection(ConnectionComponent connectionComponent) {
        Objects.requireNonNull(connectionComponent);
        return Observable.fromCallable(new ConnectorImpl$$ExternalSyntheticLambda0(connectionComponent));
    }

    static Observable<RxBleConnection> observeDisconnections(ConnectionComponent connectionComponent) {
        return connectionComponent.gattCallback().observeDisconnect();
    }

    /* access modifiers changed from: package-private */
    public Observable<BluetoothGatt> enqueueConnectOperation(ConnectionComponent connectionComponent) {
        return this.clientOperationQueue.queue(connectionComponent.connectOperation());
    }
}
