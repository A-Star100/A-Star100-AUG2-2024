package com.polidea.rxandroidble2.internal.operations;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.os.DeadObjectException;
import bleshadow.javax.inject.Named;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.exceptions.BleDisconnectedException;
import com.polidea.rxandroidble2.exceptions.BleException;
import com.polidea.rxandroidble2.exceptions.BleGattCallbackTimeoutException;
import com.polidea.rxandroidble2.exceptions.BleGattCannotStartException;
import com.polidea.rxandroidble2.exceptions.BleGattCharacteristicException;
import com.polidea.rxandroidble2.exceptions.BleGattException;
import com.polidea.rxandroidble2.exceptions.BleGattOperationType;
import com.polidea.rxandroidble2.internal.QueueOperation;
import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.internal.connection.PayloadSizeLimitProvider;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback;
import com.polidea.rxandroidble2.internal.logger.LoggerUtil;
import com.polidea.rxandroidble2.internal.serialization.QueueReleaseInterface;
import com.polidea.rxandroidble2.internal.util.ByteAssociation;
import com.polidea.rxandroidble2.internal.util.DisposableUtil;
import com.polidea.rxandroidble2.internal.util.QueueReleasingEmitterWrapper;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.observers.DisposableObserver;
import java.nio.ByteBuffer;
import java.util.UUID;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class CharacteristicLongWriteOperation extends QueueOperation<byte[]> {
    private final PayloadSizeLimitProvider batchSizeProvider;
    private final BluetoothGatt bluetoothGatt;
    private final BluetoothGattCharacteristic bluetoothGattCharacteristic;
    private final Scheduler bluetoothInteractionScheduler;
    final byte[] bytesToWrite;
    private final RxBleGattCallback rxBleGattCallback;
    private byte[] tempBatchArray;
    private final TimeoutConfiguration timeoutConfiguration;
    private final RxBleConnection.WriteOperationAckStrategy writeOperationAckStrategy;
    private final RxBleConnection.WriteOperationRetryStrategy writeOperationRetryStrategy;

    interface IntSupplier {
        int get();
    }

    CharacteristicLongWriteOperation(BluetoothGatt bluetoothGatt2, RxBleGattCallback rxBleGattCallback2, @Named("bluetooth_interaction") Scheduler scheduler, @Named("operation-timeout") TimeoutConfiguration timeoutConfiguration2, BluetoothGattCharacteristic bluetoothGattCharacteristic2, PayloadSizeLimitProvider payloadSizeLimitProvider, RxBleConnection.WriteOperationAckStrategy writeOperationAckStrategy2, RxBleConnection.WriteOperationRetryStrategy writeOperationRetryStrategy2, byte[] bArr) {
        this.bluetoothGatt = bluetoothGatt2;
        this.rxBleGattCallback = rxBleGattCallback2;
        this.bluetoothInteractionScheduler = scheduler;
        this.timeoutConfiguration = timeoutConfiguration2;
        this.bluetoothGattCharacteristic = bluetoothGattCharacteristic2;
        this.batchSizeProvider = payloadSizeLimitProvider;
        this.writeOperationAckStrategy = writeOperationAckStrategy2;
        this.writeOperationRetryStrategy = writeOperationRetryStrategy2;
        this.bytesToWrite = bArr;
    }

    /* access modifiers changed from: protected */
    public void protectedRun(ObservableEmitter<byte[]> observableEmitter, QueueReleaseInterface queueReleaseInterface) {
        final int payloadSizeLimit = this.batchSizeProvider.getPayloadSizeLimit();
        if (payloadSizeLimit > 0) {
            Observable error = Observable.error((Throwable) new BleGattCallbackTimeoutException(this.bluetoothGatt, BleGattOperationType.CHARACTERISTIC_LONG_WRITE));
            final ByteBuffer wrap = ByteBuffer.wrap(this.bytesToWrite);
            final QueueReleasingEmitterWrapper queueReleasingEmitterWrapper = new QueueReleasingEmitterWrapper(observableEmitter, queueReleaseInterface);
            AnonymousClass1 r11 = new IntSupplier() {
                public int get() {
                    return ((int) Math.ceil((double) (((float) wrap.position()) / ((float) payloadSizeLimit)))) - 1;
                }
            };
            writeBatchAndObserve(payloadSizeLimit, wrap, r11).subscribeOn(this.bluetoothInteractionScheduler).filter(writeResponseForMatchingCharacteristic(this.bluetoothGattCharacteristic)).take(1).timeout(this.timeoutConfiguration.timeout, this.timeoutConfiguration.timeoutTimeUnit, this.timeoutConfiguration.timeoutScheduler, error).repeatWhen(bufferIsNotEmptyAndOperationHasBeenAcknowledgedAndNotUnsubscribed(this.writeOperationAckStrategy, wrap, queueReleasingEmitterWrapper)).retryWhen(errorIsRetryableAndAccordingTo(this.writeOperationRetryStrategy, wrap, payloadSizeLimit, r11)).subscribe(new Observer<ByteAssociation<UUID>>() {
                public void onNext(ByteAssociation<UUID> byteAssociation) {
                }

                public void onSubscribe(Disposable disposable) {
                }

                public void onError(Throwable th) {
                    queueReleasingEmitterWrapper.onError(th);
                }

                public void onComplete() {
                    queueReleasingEmitterWrapper.onNext(CharacteristicLongWriteOperation.this.bytesToWrite);
                    queueReleasingEmitterWrapper.onComplete();
                }
            });
            return;
        }
        throw new IllegalArgumentException("batchSizeProvider value must be greater than zero (now: " + payloadSizeLimit + ")");
    }

    /* access modifiers changed from: protected */
    public BleException provideException(DeadObjectException deadObjectException) {
        return new BleDisconnectedException(deadObjectException, this.bluetoothGatt.getDevice().getAddress(), -1);
    }

    private Observable<ByteAssociation<UUID>> writeBatchAndObserve(int i, ByteBuffer byteBuffer, IntSupplier intSupplier) {
        final Observable<ByteAssociation<UUID>> onCharacteristicWrite = this.rxBleGattCallback.getOnCharacteristicWrite();
        final ByteBuffer byteBuffer2 = byteBuffer;
        final int i2 = i;
        final IntSupplier intSupplier2 = intSupplier;
        return Observable.create(new ObservableOnSubscribe<ByteAssociation<UUID>>() {
            public void subscribe(ObservableEmitter<ByteAssociation<UUID>> observableEmitter) {
                observableEmitter.setDisposable((DisposableObserver) onCharacteristicWrite.subscribeWith(DisposableUtil.disposableObserverFromEmitter(observableEmitter)));
                try {
                    CharacteristicLongWriteOperation.this.writeData(CharacteristicLongWriteOperation.this.getNextBatch(byteBuffer2, i2), intSupplier2);
                } catch (Throwable th) {
                    observableEmitter.onError(th);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public byte[] getNextBatch(ByteBuffer byteBuffer, int i) {
        int min = Math.min(byteBuffer.remaining(), i);
        byte[] bArr = this.tempBatchArray;
        if (bArr == null || bArr.length != min) {
            this.tempBatchArray = new byte[min];
        }
        byteBuffer.get(this.tempBatchArray);
        return this.tempBatchArray;
    }

    /* access modifiers changed from: package-private */
    public void writeData(byte[] bArr, IntSupplier intSupplier) {
        if (RxBleLog.isAtLeast(3)) {
            RxBleLog.d("Writing batch #%04d: %s", Integer.valueOf(intSupplier.get()), LoggerUtil.bytesToHex(bArr));
        }
        this.bluetoothGattCharacteristic.setValue(bArr);
        if (!this.bluetoothGatt.writeCharacteristic(this.bluetoothGattCharacteristic)) {
            throw new BleGattCannotStartException(this.bluetoothGatt, BleGattOperationType.CHARACTERISTIC_LONG_WRITE);
        }
    }

    private static Predicate<ByteAssociation<UUID>> writeResponseForMatchingCharacteristic(final BluetoothGattCharacteristic bluetoothGattCharacteristic2) {
        return new Predicate<ByteAssociation<UUID>>() {
            public boolean test(ByteAssociation<UUID> byteAssociation) {
                return ((UUID) byteAssociation.first).equals(bluetoothGattCharacteristic2.getUuid());
            }
        };
    }

    static Function<Observable<?>, ObservableSource<?>> bufferIsNotEmptyAndOperationHasBeenAcknowledgedAndNotUnsubscribed(final RxBleConnection.WriteOperationAckStrategy writeOperationAckStrategy2, final ByteBuffer byteBuffer, final QueueReleasingEmitterWrapper<byte[]> queueReleasingEmitterWrapper) {
        return new Function<Observable<?>, ObservableSource<?>>() {
            public ObservableSource<?> apply(Observable<?> observable) {
                return observable.takeWhile(notUnsubscribed(QueueReleasingEmitterWrapper.this)).map(bufferIsNotEmpty(byteBuffer)).compose(writeOperationAckStrategy2).takeWhile(new Predicate<Boolean>() {
                    public boolean test(Boolean bool) {
                        return bool.booleanValue();
                    }
                });
            }

            private Function<Object, Boolean> bufferIsNotEmpty(final ByteBuffer byteBuffer) {
                return new Function<Object, Boolean>() {
                    public Boolean apply(Object obj) {
                        return Boolean.valueOf(byteBuffer.hasRemaining());
                    }
                };
            }

            private Predicate<Object> notUnsubscribed(final QueueReleasingEmitterWrapper<byte[]> queueReleasingEmitterWrapper) {
                return new Predicate<Object>() {
                    public boolean test(Object obj) {
                        return !queueReleasingEmitterWrapper.isWrappedEmitterUnsubscribed();
                    }
                };
            }
        };
    }

    private static Function<Observable<Throwable>, ObservableSource<?>> errorIsRetryableAndAccordingTo(final RxBleConnection.WriteOperationRetryStrategy writeOperationRetryStrategy2, final ByteBuffer byteBuffer, final int i, final IntSupplier intSupplier) {
        return new Function<Observable<Throwable>, ObservableSource<?>>() {
            public ObservableSource<?> apply(Observable<Throwable> observable) {
                return observable.flatMap(toLongWriteFailureOrError()).doOnNext(repositionByteBufferForRetry()).compose(RxBleConnection.WriteOperationRetryStrategy.this);
            }

            private Function<Throwable, Observable<RxBleConnection.WriteOperationRetryStrategy.LongWriteFailure>> toLongWriteFailureOrError() {
                return new Function<Throwable, Observable<RxBleConnection.WriteOperationRetryStrategy.LongWriteFailure>>() {
                    public Observable<RxBleConnection.WriteOperationRetryStrategy.LongWriteFailure> apply(Throwable th) {
                        if ((th instanceof BleGattCharacteristicException) || (th instanceof BleGattCannotStartException)) {
                            return Observable.just(new RxBleConnection.WriteOperationRetryStrategy.LongWriteFailure(intSupplier.get(), (BleGattException) th));
                        }
                        return Observable.error(th);
                    }
                };
            }

            private Consumer<RxBleConnection.WriteOperationRetryStrategy.LongWriteFailure> repositionByteBufferForRetry() {
                return new Consumer<RxBleConnection.WriteOperationRetryStrategy.LongWriteFailure>() {
                    public void accept(RxBleConnection.WriteOperationRetryStrategy.LongWriteFailure longWriteFailure) {
                        byteBuffer.position(longWriteFailure.getBatchIndex() * i);
                    }
                };
            }
        };
    }

    public String toString() {
        return "CharacteristicLongWriteOperation{" + LoggerUtil.commonMacMessage(this.bluetoothGatt) + ", characteristic=" + LoggerUtil.wrap(this.bluetoothGattCharacteristic, false) + ", maxBatchSize=" + this.batchSizeProvider.getPayloadSizeLimit() + AbstractJsonLexerKt.END_OBJ;
    }
}
