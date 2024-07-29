package com.polidea.rxandroidble2.internal.scan;

import bleshadow.javax.inject.Inject;
import bleshadow.javax.inject.Named;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.internal.util.ObservableUtil;
import com.polidea.rxandroidble2.scan.ScanCallbackType;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.functions.Function;
import io.reactivex.observables.GroupedObservable;
import java.util.concurrent.TimeUnit;

public class ScanSettingsEmulator {
    final ObservableTransformer<RxBleInternalScanResult, RxBleInternalScanResult> emulateFirstMatch;
    private final ObservableTransformer<RxBleInternalScanResult, RxBleInternalScanResult> emulateFirstMatchAndMatchLost = new ObservableTransformer<RxBleInternalScanResult, RxBleInternalScanResult>() {
        public Observable<RxBleInternalScanResult> apply(Observable<RxBleInternalScanResult> observable) {
            return observable.publish(new Function<Observable<RxBleInternalScanResult>, Observable<RxBleInternalScanResult>>() {
                public Observable<RxBleInternalScanResult> apply(Observable<RxBleInternalScanResult> observable) {
                    return Observable.merge(observable.compose(ScanSettingsEmulator.this.emulateFirstMatch), observable.compose(ScanSettingsEmulator.this.emulateMatchLost));
                }
            });
        }
    };
    final ObservableTransformer<RxBleInternalScanResult, RxBleInternalScanResult> emulateMatchLost = new ObservableTransformer<RxBleInternalScanResult, RxBleInternalScanResult>() {
        public Observable<RxBleInternalScanResult> apply(Observable<RxBleInternalScanResult> observable) {
            return observable.debounce(10, TimeUnit.SECONDS, ScanSettingsEmulator.this.scheduler).map(ScanSettingsEmulator.toMatchLost());
        }
    };
    final Scheduler scheduler;

    @Inject
    public ScanSettingsEmulator(@Named("computation") Scheduler scheduler2) {
        this.scheduler = scheduler2;
        this.emulateFirstMatch = new ObservableTransformer<RxBleInternalScanResult, RxBleInternalScanResult>(scheduler2) {
            final Function<RxBleInternalScanResult, Observable<?>> emitAfterTimerFunc;
            final Function<Observable<RxBleInternalScanResult>, Observable<RxBleInternalScanResult>> takeFirstFromEachWindowFunc;
            final Observable<Long> timerObservable;
            final Function<RxBleInternalScanResult, RxBleInternalScanResult> toFirstMatchFunc = ScanSettingsEmulator.toFirstMatch();
            final /* synthetic */ Scheduler val$scheduler;

            {
                this.val$scheduler = r4;
                this.timerObservable = Observable.timer(10, TimeUnit.SECONDS, r4);
                this.emitAfterTimerFunc = new Function<RxBleInternalScanResult, Observable<?>>() {
                    public Observable<?> apply(RxBleInternalScanResult rxBleInternalScanResult) {
                        return AnonymousClass1.this.timerObservable;
                    }
                };
                this.takeFirstFromEachWindowFunc = new Function<Observable<RxBleInternalScanResult>, Observable<RxBleInternalScanResult>>() {
                    public Observable<RxBleInternalScanResult> apply(Observable<RxBleInternalScanResult> observable) {
                        return observable.take(1);
                    }
                };
            }

            public Observable<RxBleInternalScanResult> apply(Observable<RxBleInternalScanResult> observable) {
                return observable.publish(new Function<Observable<RxBleInternalScanResult>, ObservableSource<RxBleInternalScanResult>>() {
                    public ObservableSource<RxBleInternalScanResult> apply(Observable<RxBleInternalScanResult> observable) {
                        return observable.window((ObservableSource<B>) observable.switchMap(AnonymousClass1.this.emitAfterTimerFunc)).flatMap(AnonymousClass1.this.takeFirstFromEachWindowFunc).map(AnonymousClass1.this.toFirstMatchFunc);
                    }
                });
            }
        };
    }

    /* access modifiers changed from: package-private */
    public ObservableTransformer<RxBleInternalScanResult, RxBleInternalScanResult> emulateScanMode(int i) {
        if (i == -1) {
            RxBleLog.w("Cannot emulate opportunistic scan mode since it is OS dependent - fallthrough to low power", new Object[0]);
        } else if (i != 0) {
            if (i != 1) {
                return ObservableUtil.identityTransformer();
            }
            return scanModeBalancedTransformer();
        }
        return scanModeLowPowerTransformer();
    }

    private ObservableTransformer<RxBleInternalScanResult, RxBleInternalScanResult> scanModeBalancedTransformer() {
        return repeatedWindowTransformer(DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS);
    }

    private ObservableTransformer<RxBleInternalScanResult, RxBleInternalScanResult> scanModeLowPowerTransformer() {
        return repeatedWindowTransformer(500);
    }

    private ObservableTransformer<RxBleInternalScanResult, RxBleInternalScanResult> repeatedWindowTransformer(final int i) {
        final long max = Math.max(TimeUnit.SECONDS.toMillis(5) - ((long) i), 0);
        return new ObservableTransformer<RxBleInternalScanResult, RxBleInternalScanResult>() {
            public Observable<RxBleInternalScanResult> apply(Observable<RxBleInternalScanResult> observable) {
                return observable.take((long) i, TimeUnit.MILLISECONDS, ScanSettingsEmulator.this.scheduler).repeatWhen(new Function<Observable<Object>, ObservableSource<?>>() {
                    public ObservableSource<?> apply(Observable<Object> observable) {
                        return observable.delay(max, TimeUnit.MILLISECONDS, ScanSettingsEmulator.this.scheduler);
                    }
                });
            }
        };
    }

    /* access modifiers changed from: package-private */
    public ObservableTransformer<RxBleInternalScanResult, RxBleInternalScanResult> emulateCallbackType(int i) {
        if (i == 2) {
            return splitByAddressAndForEach(this.emulateFirstMatch);
        }
        if (i == 4) {
            return splitByAddressAndForEach(this.emulateMatchLost);
        }
        if (i != 6) {
            return ObservableUtil.identityTransformer();
        }
        return splitByAddressAndForEach(this.emulateFirstMatchAndMatchLost);
    }

    private static ObservableTransformer<RxBleInternalScanResult, RxBleInternalScanResult> splitByAddressAndForEach(final ObservableTransformer<RxBleInternalScanResult, RxBleInternalScanResult> observableTransformer) {
        return new ObservableTransformer<RxBleInternalScanResult, RxBleInternalScanResult>() {
            public Observable<RxBleInternalScanResult> apply(Observable<RxBleInternalScanResult> observable) {
                return observable.groupBy(new Function<RxBleInternalScanResult, String>() {
                    public String apply(RxBleInternalScanResult rxBleInternalScanResult) {
                        return rxBleInternalScanResult.getBluetoothDevice().getAddress();
                    }
                }).flatMap(new Function<GroupedObservable<String, RxBleInternalScanResult>, Observable<RxBleInternalScanResult>>() {
                    public Observable<RxBleInternalScanResult> apply(GroupedObservable<String, RxBleInternalScanResult> groupedObservable) {
                        return groupedObservable.compose(ObservableTransformer.this);
                    }
                });
            }
        };
    }

    static Function<RxBleInternalScanResult, RxBleInternalScanResult> toFirstMatch() {
        return new Function<RxBleInternalScanResult, RxBleInternalScanResult>() {
            public RxBleInternalScanResult apply(RxBleInternalScanResult rxBleInternalScanResult) {
                return new RxBleInternalScanResult(rxBleInternalScanResult.getBluetoothDevice(), rxBleInternalScanResult.getRssi(), rxBleInternalScanResult.getTimestampNanos(), rxBleInternalScanResult.getScanRecord(), ScanCallbackType.CALLBACK_TYPE_FIRST_MATCH, rxBleInternalScanResult.isConnectable());
            }
        };
    }

    static Function<RxBleInternalScanResult, RxBleInternalScanResult> toMatchLost() {
        return new Function<RxBleInternalScanResult, RxBleInternalScanResult>() {
            public RxBleInternalScanResult apply(RxBleInternalScanResult rxBleInternalScanResult) {
                return new RxBleInternalScanResult(rxBleInternalScanResult.getBluetoothDevice(), rxBleInternalScanResult.getRssi(), rxBleInternalScanResult.getTimestampNanos(), rxBleInternalScanResult.getScanRecord(), ScanCallbackType.CALLBACK_TYPE_MATCH_LOST, rxBleInternalScanResult.isConnectable());
            }
        };
    }
}
