package com.polidea.rxandroidble2.internal.operations;

import android.os.DeadObjectException;
import com.polidea.rxandroidble2.exceptions.BleException;
import com.polidea.rxandroidble2.exceptions.BleScanException;
import com.polidea.rxandroidble2.internal.QueueOperation;
import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.internal.serialization.QueueReleaseInterface;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;
import io.reactivex.ObservableEmitter;
import io.reactivex.functions.Cancellable;

public abstract class ScanOperation<SCAN_RESULT_TYPE, SCAN_CALLBACK_TYPE> extends QueueOperation<SCAN_RESULT_TYPE> {
    final RxBleAdapterWrapper rxBleAdapterWrapper;

    /* access modifiers changed from: package-private */
    public abstract SCAN_CALLBACK_TYPE createScanCallback(ObservableEmitter<SCAN_RESULT_TYPE> observableEmitter);

    /* access modifiers changed from: package-private */
    public abstract boolean startScan(RxBleAdapterWrapper rxBleAdapterWrapper2, SCAN_CALLBACK_TYPE scan_callback_type);

    /* access modifiers changed from: package-private */
    public abstract void stopScan(RxBleAdapterWrapper rxBleAdapterWrapper2, SCAN_CALLBACK_TYPE scan_callback_type);

    ScanOperation(RxBleAdapterWrapper rxBleAdapterWrapper2) {
        this.rxBleAdapterWrapper = rxBleAdapterWrapper2;
    }

    /* access modifiers changed from: protected */
    public final void protectedRun(ObservableEmitter<SCAN_RESULT_TYPE> observableEmitter, QueueReleaseInterface queueReleaseInterface) {
        final Object createScanCallback = createScanCallback(observableEmitter);
        try {
            observableEmitter.setCancellable(new Cancellable() {
                public void cancel() {
                    RxBleLog.i("Scan operation is requested to stop.", new Object[0]);
                    ScanOperation scanOperation = ScanOperation.this;
                    scanOperation.stopScan(scanOperation.rxBleAdapterWrapper, createScanCallback);
                }
            });
            RxBleLog.i("Scan operation is requested to start.", new Object[0]);
            if (!startScan(this.rxBleAdapterWrapper, createScanCallback)) {
                observableEmitter.tryOnError(new BleScanException(0));
            }
        } catch (Throwable th) {
            queueReleaseInterface.release();
            throw th;
        }
        queueReleaseInterface.release();
    }

    /* access modifiers changed from: protected */
    public BleException provideException(DeadObjectException deadObjectException) {
        return new BleScanException(1, (Throwable) deadObjectException);
    }
}
