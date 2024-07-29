package com.polidea.rxandroidble2;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Build;
import bleshadow.dagger.Binds;
import bleshadow.dagger.BindsInstance;
import bleshadow.dagger.Component;
import bleshadow.dagger.Module;
import bleshadow.dagger.Provides;
import bleshadow.javax.inject.Named;
import bleshadow.javax.inject.Provider;
import com.onesignal.location.internal.common.LocationConstants;
import com.polidea.rxandroidble2.RxBleAdapterStateObservable;
import com.polidea.rxandroidble2.helpers.LocationServicesOkObservable;
import com.polidea.rxandroidble2.internal.DeviceComponent;
import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.internal.scan.BackgroundScannerImpl;
import com.polidea.rxandroidble2.internal.scan.InternalToExternalScanResultConverter;
import com.polidea.rxandroidble2.internal.scan.IsConnectableChecker;
import com.polidea.rxandroidble2.internal.scan.IsConnectableCheckerApi18;
import com.polidea.rxandroidble2.internal.scan.IsConnectableCheckerApi26;
import com.polidea.rxandroidble2.internal.scan.RxBleInternalScanResult;
import com.polidea.rxandroidble2.internal.scan.ScanPreconditionsVerifier;
import com.polidea.rxandroidble2.internal.scan.ScanPreconditionsVerifierApi18;
import com.polidea.rxandroidble2.internal.scan.ScanPreconditionsVerifierApi24;
import com.polidea.rxandroidble2.internal.scan.ScanSetupBuilder;
import com.polidea.rxandroidble2.internal.scan.ScanSetupBuilderImplApi18;
import com.polidea.rxandroidble2.internal.scan.ScanSetupBuilderImplApi21;
import com.polidea.rxandroidble2.internal.scan.ScanSetupBuilderImplApi23;
import com.polidea.rxandroidble2.internal.serialization.ClientOperationQueue;
import com.polidea.rxandroidble2.internal.serialization.ClientOperationQueueImpl;
import com.polidea.rxandroidble2.internal.serialization.RxBleThreadFactory;
import com.polidea.rxandroidble2.internal.util.LocationServicesOkObservableApi23Factory;
import com.polidea.rxandroidble2.internal.util.LocationServicesStatus;
import com.polidea.rxandroidble2.internal.util.LocationServicesStatusApi18;
import com.polidea.rxandroidble2.internal.util.LocationServicesStatusApi23;
import com.polidea.rxandroidble2.internal.util.LocationServicesStatusApi31;
import com.polidea.rxandroidble2.internal.util.ObservableUtil;
import com.polidea.rxandroidble2.scan.BackgroundScanner;
import com.polidea.rxandroidble2.scan.ScanResult;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Function;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@ClientScope
@Component(modules = {ClientModule.class})
public interface ClientComponent {

    @Component.Builder
    public interface Builder {
        @BindsInstance
        Builder applicationContext(Context context);

        ClientComponent build();
    }

    public interface ClientComponentFinalizer {
        void onFinalize();
    }

    LocationServicesOkObservable locationServicesOkObservable();

    RxBleClient rxBleClient();

    public static class NamedExecutors {
        public static final String BLUETOOTH_INTERACTION = "executor_bluetooth_interaction";
        public static final String CONNECTION_QUEUE = "executor_connection_queue";

        private NamedExecutors() {
        }
    }

    public static class NamedSchedulers {
        public static final String BLUETOOTH_CALLBACKS = "bluetooth_callbacks";
        public static final String BLUETOOTH_INTERACTION = "bluetooth_interaction";
        public static final String COMPUTATION = "computation";
        public static final String TIMEOUT = "timeout";

        private NamedSchedulers() {
        }
    }

    public static class PlatformConstants {
        public static final String BOOL_IS_ANDROID_WEAR = "android-wear";
        public static final String BOOL_IS_NEARBY_PERMISSION_NEVER_FOR_LOCATION = "nearby-permission-never-for-location";
        public static final String INT_DEVICE_SDK = "device-sdk";
        public static final String INT_TARGET_SDK = "target-sdk";
        public static final String STRING_ARRAY_CONNECT_PERMISSIONS = "connect-permissions";
        public static final String STRING_ARRAY_SCAN_PERMISSIONS = "scan-permissions";

        private PlatformConstants() {
        }
    }

    public static class NamedBooleanObservables {
        public static final String LOCATION_SERVICES_OK = "location-ok-boolean-observable";

        private NamedBooleanObservables() {
        }
    }

    public static class BluetoothConstants {
        public static final String DISABLE_NOTIFICATION_VALUE = "disable-notification-value";
        public static final String ENABLE_INDICATION_VALUE = "enable-indication-value";
        public static final String ENABLE_NOTIFICATION_VALUE = "enable-notification-value";

        private BluetoothConstants() {
        }
    }

    @Module(subcomponents = {DeviceComponent.class})
    public static abstract class ClientModule {
        @Provides
        @Named("device-sdk")
        static int provideDeviceSdk() {
            return Build.VERSION.SDK_INT;
        }

        /* access modifiers changed from: package-private */
        @Binds
        public abstract BackgroundScanner bindBackgroundScanner(BackgroundScannerImpl backgroundScannerImpl);

        /* access modifiers changed from: package-private */
        @ClientScope
        @Binds
        public abstract ClientOperationQueue bindClientOperationQueue(ClientOperationQueueImpl clientOperationQueueImpl);

        /* access modifiers changed from: package-private */
        @ClientScope
        @Binds
        public abstract RxBleClient bindRxBleClient(RxBleClientImpl rxBleClientImpl);

        /* access modifiers changed from: package-private */
        @Binds
        public abstract Observable<RxBleAdapterStateObservable.BleAdapterState> bindStateObs(RxBleAdapterStateObservable rxBleAdapterStateObservable);

        /* access modifiers changed from: package-private */
        @Binds
        @Named("timeout")
        public abstract Scheduler bindTimeoutScheduler(@Named("computation") Scheduler scheduler);

        /* access modifiers changed from: package-private */
        @Binds
        public abstract Function<RxBleInternalScanResult, ScanResult> provideScanResultMapper(InternalToExternalScanResultConverter internalToExternalScanResultConverter);

        @Provides
        static BluetoothManager provideBluetoothManager(Context context) {
            return (BluetoothManager) context.getSystemService("bluetooth");
        }

        @Provides
        static BluetoothAdapter provideBluetoothAdapter() {
            return BluetoothAdapter.getDefaultAdapter();
        }

        @Provides
        @Named("computation")
        static Scheduler provideComputationScheduler() {
            return Schedulers.computation();
        }

        @Provides
        @Named("scan-permissions")
        static String[][] provideRecommendedScanRuntimePermissionNames(@Named("device-sdk") int i, @Named("target-sdk") int i2, @Named("nearby-permission-never-for-location") boolean z) {
            int min = Math.min(i, i2);
            if (min < 23) {
                return new String[0][];
            }
            if (min < 29) {
                return new String[][]{new String[]{LocationConstants.ANDROID_COARSE_LOCATION_PERMISSION_STRING, LocationConstants.ANDROID_FINE_LOCATION_PERMISSION_STRING}};
            } else if (min < 31) {
                return new String[][]{new String[]{LocationConstants.ANDROID_FINE_LOCATION_PERMISSION_STRING}};
            } else if (z) {
                return new String[][]{new String[]{"android.permission.BLUETOOTH_SCAN"}};
            } else {
                return new String[][]{new String[]{"android.permission.BLUETOOTH_SCAN"}, new String[]{LocationConstants.ANDROID_FINE_LOCATION_PERMISSION_STRING}};
            }
        }

        @Provides
        @Named("connect-permissions")
        static String[][] provideRecommendedConnectRuntimePermissionNames(@Named("device-sdk") int i, @Named("target-sdk") int i2) {
            if (Math.min(i, i2) < 31) {
                return new String[0][];
            }
            return new String[][]{new String[]{"android.permission.BLUETOOTH_CONNECT"}};
        }

        @Provides
        static ContentResolver provideContentResolver(Context context) {
            return context.getContentResolver();
        }

        @Provides
        static LocationServicesStatus provideLocationServicesStatus(@Named("device-sdk") int i, Provider<LocationServicesStatusApi18> provider, Provider<LocationServicesStatusApi23> provider2, Provider<LocationServicesStatusApi31> provider3) {
            if (i < 23) {
                return provider.get();
            }
            if (i < 31) {
                return provider2.get();
            }
            return provider3.get();
        }

        @Provides
        @Named("location-ok-boolean-observable")
        static Observable<Boolean> provideLocationServicesOkObservable(@Named("device-sdk") int i, LocationServicesOkObservableApi23Factory locationServicesOkObservableApi23Factory) {
            if (i < 23) {
                return ObservableUtil.justOnNext(true);
            }
            return locationServicesOkObservableApi23Factory.get();
        }

        @ClientScope
        @Provides
        @Named("executor_connection_queue")
        static ExecutorService provideConnectionQueueExecutorService() {
            return Executors.newCachedThreadPool();
        }

        @ClientScope
        @Provides
        @Named("executor_bluetooth_interaction")
        static ExecutorService provideBluetoothInteractionExecutorService() {
            return Executors.newSingleThreadExecutor();
        }

        @ClientScope
        @Provides
        @Named("bluetooth_interaction")
        static Scheduler provideBluetoothInteractionScheduler(@Named("executor_bluetooth_interaction") ExecutorService executorService) {
            return Schedulers.from(executorService);
        }

        @ClientScope
        @Provides
        @Named("bluetooth_callbacks")
        static Scheduler provideBluetoothCallbacksScheduler() {
            return RxJavaPlugins.createSingleScheduler(new RxBleThreadFactory());
        }

        @Provides
        static ClientComponentFinalizer provideFinalizationCloseable(@Named("executor_bluetooth_interaction") final ExecutorService executorService, @Named("bluetooth_callbacks") final Scheduler scheduler, @Named("executor_connection_queue") final ExecutorService executorService2) {
            return new ClientComponentFinalizer() {
                public void onFinalize() {
                    executorService.shutdown();
                    scheduler.shutdown();
                    executorService2.shutdown();
                }
            };
        }

        @Provides
        static LocationManager provideLocationManager(Context context) {
            return (LocationManager) context.getSystemService("location");
        }

        @Provides
        @Named("target-sdk")
        static int provideTargetSdk(Context context) {
            try {
                return context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).targetSdkVersion;
            } catch (Throwable unused) {
                return Integer.MAX_VALUE;
            }
        }

        @Provides
        @Named("android-wear")
        static boolean provideIsAndroidWear(Context context, @Named("device-sdk") int i) {
            return i >= 20 && context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
        }

        @ClientScope
        @Provides
        @Named("nearby-permission-never-for-location")
        static boolean provideIsNearbyPermissionNeverForLocation(Context context) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
                int i = 0;
                while (i < packageInfo.requestedPermissions.length) {
                    if (!"android.permission.BLUETOOTH_SCAN".equals(packageInfo.requestedPermissions[i])) {
                        i++;
                    } else if ((packageInfo.requestedPermissionsFlags[i] & 65536) != 0) {
                        return true;
                    } else {
                        return false;
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                RxBleLog.e(e, "Could not find application PackageInfo", new Object[0]);
            }
            return false;
        }

        @ClientScope
        @Provides
        static ScanSetupBuilder provideScanSetupProvider(@Named("device-sdk") int i, Provider<ScanSetupBuilderImplApi18> provider, Provider<ScanSetupBuilderImplApi21> provider2, Provider<ScanSetupBuilderImplApi23> provider3) {
            if (i < 21) {
                return provider.get();
            }
            if (i < 23) {
                return provider2.get();
            }
            return provider3.get();
        }

        @ClientScope
        @Provides
        static IsConnectableChecker provideIsConnectableChecker(@Named("device-sdk") int i, Provider<IsConnectableCheckerApi18> provider, Provider<IsConnectableCheckerApi26> provider2) {
            if (i < 26) {
                return provider.get();
            }
            return provider2.get();
        }

        @Provides
        @Named("enable-notification-value")
        static byte[] provideEnableNotificationValue() {
            return BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        }

        @Provides
        @Named("enable-indication-value")
        static byte[] provideEnableIndicationValue() {
            return BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
        }

        @Provides
        @Named("disable-notification-value")
        static byte[] provideDisableNotificationValue() {
            return BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        }

        @Provides
        static ScanPreconditionsVerifier provideScanPreconditionVerifier(@Named("device-sdk") int i, Provider<ScanPreconditionsVerifierApi18> provider, Provider<ScanPreconditionsVerifierApi24> provider2) {
            if (i < 24) {
                return provider.get();
            }
            return provider2.get();
        }
    }
}
