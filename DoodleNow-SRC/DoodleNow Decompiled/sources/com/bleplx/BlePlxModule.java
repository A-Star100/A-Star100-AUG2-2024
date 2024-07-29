package com.bleplx;

import android.app.Activity;
import com.bleplx.adapter.BleAdapter;
import com.bleplx.adapter.BleAdapterFactory;
import com.bleplx.adapter.Characteristic;
import com.bleplx.adapter.Descriptor;
import com.bleplx.adapter.Device;
import com.bleplx.adapter.OnErrorCallback;
import com.bleplx.adapter.OnEventCallback;
import com.bleplx.adapter.OnSuccessCallback;
import com.bleplx.adapter.ScanResult;
import com.bleplx.adapter.Service;
import com.bleplx.adapter.errors.BleError;
import com.bleplx.adapter.errors.BleErrorCode;
import com.bleplx.converter.BleErrorToJsObjectConverter;
import com.bleplx.converter.CharacteristicToJsObjectConverter;
import com.bleplx.converter.DescriptorToJsObjectConverter;
import com.bleplx.converter.DeviceToJsObjectConverter;
import com.bleplx.converter.ScanResultToJsObjectConverter;
import com.bleplx.converter.ServiceToJsObjectConverter;
import com.bleplx.utils.ReadableArrayConverter;
import com.bleplx.utils.SafePromise;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.polidea.rxandroidble2.internal.RxBleLog;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.plugins.RxJavaPlugins;
import java.lang.Thread;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ReactModule(name = "BlePlx")
public class BlePlxModule extends ReactContextBaseJavaModule {
    public static final String NAME = "BlePlx";
    private BleAdapter bleAdapter;
    /* access modifiers changed from: private */
    public final CharacteristicToJsObjectConverter characteristicConverter = new CharacteristicToJsObjectConverter();
    /* access modifiers changed from: private */
    public final DescriptorToJsObjectConverter descriptorConverter = new DescriptorToJsObjectConverter();
    /* access modifiers changed from: private */
    public final DeviceToJsObjectConverter deviceConverter = new DeviceToJsObjectConverter();
    /* access modifiers changed from: private */
    public final BleErrorToJsObjectConverter errorConverter = new BleErrorToJsObjectConverter();
    /* access modifiers changed from: private */
    public final ScanResultToJsObjectConverter scanResultConverter = new ScanResultToJsObjectConverter();
    private final ServiceToJsObjectConverter serviceConverter = new ServiceToJsObjectConverter();

    @ReactMethod
    public void addListener(String str) {
    }

    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void removeListeners(int i) {
    }

    public BlePlxModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        RxJavaPlugins.setErrorHandler(new BlePlxModule$$ExternalSyntheticLambda0());
    }

    static /* synthetic */ void lambda$new$0(Throwable th) throws Exception {
        if (th instanceof UndeliverableException) {
            RxBleLog.e("Handle all unhandled exceptions from RxJava: " + th.getMessage(), new Object[0]);
            return;
        }
        Thread currentThread = Thread.currentThread();
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = currentThread.getUncaughtExceptionHandler();
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(currentThread, th);
        }
    }

    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        for (Event event : Event.values()) {
            hashMap.put(event.name, event.name);
        }
        return hashMap;
    }

    @ReactMethod
    public void createClient(String str) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            BleAdapter newAdapter = BleAdapterFactory.getNewAdapter(currentActivity);
            this.bleAdapter = newAdapter;
            newAdapter.createClient(str, new OnEventCallback<String>() {
                public void onEvent(String str) {
                    BlePlxModule.this.sendEvent(Event.StateChangeEvent, str);
                }
            }, new OnEventCallback<Integer>() {
                public void onEvent(Integer num) {
                    BlePlxModule.this.sendEvent(Event.RestoreStateEvent, (Object) null);
                }
            });
        }
    }

    @ReactMethod
    public void destroyClient(Promise promise) {
        if (isRequestPossibleHandler("destroyClient", promise)) {
            this.bleAdapter.destroyClient();
            this.bleAdapter = null;
            promise.resolve((Object) null);
        }
    }

    @ReactMethod
    public void cancelTransaction(String str, Promise promise) {
        if (isRequestPossibleHandler("cancelTransaction", promise)) {
            this.bleAdapter.cancelTransaction(str);
            promise.resolve((Object) null);
        }
    }

    @ReactMethod
    public void setLogLevel(String str, Promise promise) {
        if (isRequestPossibleHandler("setLogLevel", promise)) {
            this.bleAdapter.setLogLevel(str);
            promise.resolve(this.bleAdapter.getLogLevel());
        }
    }

    @ReactMethod
    public void logLevel(Promise promise) {
        if (isRequestPossibleHandler("logLevel", promise)) {
            promise.resolve(this.bleAdapter.getLogLevel());
        }
    }

    @ReactMethod
    public void enable(String str, Promise promise) {
        if (isRequestPossibleHandler("enable", promise)) {
            final SafePromise safePromise = new SafePromise(promise);
            this.bleAdapter.enable(str, new OnSuccessCallback<Void>() {
                public void onSuccess(Void voidR) {
                    safePromise.resolve((Object) null);
                }
            }, new OnErrorCallback() {
                public void onError(BleError bleError) {
                    safePromise.reject((String) null, BlePlxModule.this.errorConverter.toJs(bleError));
                }
            });
        }
    }

    @ReactMethod
    public void disable(String str, Promise promise) {
        if (isRequestPossibleHandler("disable", promise)) {
            final SafePromise safePromise = new SafePromise(promise);
            this.bleAdapter.disable(str, new OnSuccessCallback<Void>() {
                public void onSuccess(Void voidR) {
                    safePromise.resolve((Object) null);
                }
            }, new OnErrorCallback() {
                public void onError(BleError bleError) {
                    safePromise.reject((String) null, BlePlxModule.this.errorConverter.toJs(bleError));
                }
            });
        }
    }

    @ReactMethod
    public void state(Promise promise) {
        if (isRequestPossibleHandler("state", promise)) {
            promise.resolve(this.bleAdapter.getCurrentState());
        }
    }

    @ReactMethod
    public void startDeviceScan(ReadableArray readableArray, ReadableMap readableMap, Promise promise) {
        boolean z;
        int i;
        int i2;
        if (isRequestPossibleHandler("startDeviceScan", promise)) {
            boolean z2 = true;
            int i3 = 0;
            if (readableMap != null) {
                if (readableMap.hasKey("scanMode") && readableMap.getType("scanMode") == ReadableType.Number) {
                    i3 = readableMap.getInt("scanMode");
                }
                int i4 = (!readableMap.hasKey("callbackType") || readableMap.getType("callbackType") != ReadableType.Number) ? 1 : readableMap.getInt("callbackType");
                if (readableMap.hasKey("legacyScan") && readableMap.getType("legacyScan") == ReadableType.Boolean) {
                    z2 = readableMap.getBoolean("legacyScan");
                }
                z = z2;
                i2 = i3;
                i = i4;
            } else {
                i = 1;
                z = true;
                i2 = 0;
            }
            this.bleAdapter.startDeviceScan(readableArray != null ? ReadableArrayConverter.toStringArray(readableArray) : null, i2, i, z, new OnEventCallback<ScanResult>() {
                public void onEvent(ScanResult scanResult) {
                    BlePlxModule.this.sendEvent(Event.ScanEvent, BlePlxModule.this.scanResultConverter.toJSCallback(scanResult));
                }
            }, new OnErrorCallback() {
                public void onError(BleError bleError) {
                    BlePlxModule.this.sendEvent(Event.ScanEvent, BlePlxModule.this.errorConverter.toJSCallback(bleError));
                }
            });
            promise.resolve((Object) null);
        }
    }

    @ReactMethod
    public void stopDeviceScan(Promise promise) {
        if (isRequestPossibleHandler("stopDeviceScan", promise)) {
            this.bleAdapter.stopDeviceScan();
            promise.resolve((Object) null);
        }
    }

    @ReactMethod
    public void devices(ReadableArray readableArray, final Promise promise) {
        if (isRequestPossibleHandler("devices", promise)) {
            this.bleAdapter.getKnownDevices(ReadableArrayConverter.toStringArray(readableArray), new OnSuccessCallback<Device[]>() {
                public void onSuccess(Device[] deviceArr) {
                    WritableArray createArray = Arguments.createArray();
                    for (Device jSObject : deviceArr) {
                        createArray.pushMap(BlePlxModule.this.deviceConverter.toJSObject(jSObject));
                    }
                    promise.resolve(createArray);
                }
            }, new OnErrorCallback() {
                public void onError(BleError bleError) {
                    promise.reject((String) null, BlePlxModule.this.errorConverter.toJs(bleError));
                }
            });
        }
    }

    @ReactMethod
    public void connectedDevices(ReadableArray readableArray, final Promise promise) {
        if (isRequestPossibleHandler("connectedDevices", promise)) {
            this.bleAdapter.getConnectedDevices(ReadableArrayConverter.toStringArray(readableArray), new OnSuccessCallback<Device[]>() {
                public void onSuccess(Device[] deviceArr) {
                    WritableArray createArray = Arguments.createArray();
                    for (Device jSObject : deviceArr) {
                        createArray.pushMap(BlePlxModule.this.deviceConverter.toJSObject(jSObject));
                    }
                    promise.resolve(createArray);
                }
            }, new OnErrorCallback() {
                public void onError(BleError bleError) {
                    promise.reject((String) null, BlePlxModule.this.errorConverter.toJs(bleError));
                }
            });
        }
    }

    @ReactMethod
    public void requestConnectionPriorityForDevice(String str, int i, String str2, Promise promise) {
        if (isRequestPossibleHandler("requestConnectionPriorityForDevice", promise)) {
            final SafePromise safePromise = new SafePromise(promise);
            this.bleAdapter.requestConnectionPriorityForDevice(str, i, str2, new OnSuccessCallback<Device>() {
                public void onSuccess(Device device) {
                    safePromise.resolve(BlePlxModule.this.deviceConverter.toJSObject(device));
                }
            }, new OnErrorCallback() {
                public void onError(BleError bleError) {
                    safePromise.reject((String) null, BlePlxModule.this.errorConverter.toJs(bleError));
                }
            });
        }
    }

    @ReactMethod
    public void requestMTUForDevice(String str, int i, String str2, Promise promise) {
        if (isRequestPossibleHandler("requestMTUForDevice", promise)) {
            final SafePromise safePromise = new SafePromise(promise);
            this.bleAdapter.requestMTUForDevice(str, i, str2, new OnSuccessCallback<Device>() {
                public void onSuccess(Device device) {
                    safePromise.resolve(BlePlxModule.this.deviceConverter.toJSObject(device));
                }
            }, new OnErrorCallback() {
                public void onError(BleError bleError) {
                    safePromise.reject((String) null, BlePlxModule.this.errorConverter.toJs(bleError));
                }
            });
        }
    }

    @ReactMethod
    public void readRSSIForDevice(String str, String str2, Promise promise) {
        if (isRequestPossibleHandler("readRSSIForDevice", promise)) {
            final SafePromise safePromise = new SafePromise(promise);
            this.bleAdapter.readRSSIForDevice(str, str2, new OnSuccessCallback<Device>() {
                public void onSuccess(Device device) {
                    safePromise.resolve(BlePlxModule.this.deviceConverter.toJSObject(device));
                }
            }, new OnErrorCallback() {
                public void onError(BleError bleError) {
                    safePromise.reject((String) null, BlePlxModule.this.errorConverter.toJs(bleError));
                }
            });
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    @com.facebook.react.bridge.ReactMethod
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connectToDevice(java.lang.String r18, com.facebook.react.bridge.ReadableMap r19, com.facebook.react.bridge.Promise r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r19
            r2 = r20
            java.lang.String r3 = "connectToDevice"
            boolean r3 = r0.isRequestPossibleHandler(r3, r2)
            if (r3 != 0) goto L_0x000f
            return
        L_0x000f:
            com.bleplx.utils.SafePromise r3 = new com.bleplx.utils.SafePromise
            r3.<init>(r2)
            r2 = 0
            r4 = 0
            if (r1 == 0) goto L_0x0092
            java.lang.String r5 = "autoConnect"
            boolean r6 = r1.hasKey(r5)
            if (r6 == 0) goto L_0x002d
            com.facebook.react.bridge.ReadableType r6 = r1.getType(r5)
            com.facebook.react.bridge.ReadableType r7 = com.facebook.react.bridge.ReadableType.Boolean
            if (r6 != r7) goto L_0x002d
            boolean r5 = r1.getBoolean(r5)
            goto L_0x002e
        L_0x002d:
            r5 = r4
        L_0x002e:
            java.lang.String r6 = "requestMTU"
            boolean r7 = r1.hasKey(r6)
            if (r7 == 0) goto L_0x0043
            com.facebook.react.bridge.ReadableType r7 = r1.getType(r6)
            com.facebook.react.bridge.ReadableType r8 = com.facebook.react.bridge.ReadableType.Number
            if (r7 != r8) goto L_0x0043
            int r6 = r1.getInt(r6)
            goto L_0x0044
        L_0x0043:
            r6 = r4
        L_0x0044:
            java.lang.String r7 = "refreshGatt"
            boolean r8 = r1.hasKey(r7)
            if (r8 == 0) goto L_0x005d
            com.facebook.react.bridge.ReadableType r8 = r1.getType(r7)
            com.facebook.react.bridge.ReadableType r9 = com.facebook.react.bridge.ReadableType.String
            if (r8 != r9) goto L_0x005d
            java.lang.String r7 = r1.getString(r7)
            com.bleplx.adapter.RefreshGattMoment r7 = com.bleplx.adapter.RefreshGattMoment.getByName(r7)
            goto L_0x005e
        L_0x005d:
            r7 = r2
        L_0x005e:
            java.lang.String r8 = "timeout"
            boolean r9 = r1.hasKey(r8)
            if (r9 == 0) goto L_0x0077
            com.facebook.react.bridge.ReadableType r9 = r1.getType(r8)
            com.facebook.react.bridge.ReadableType r10 = com.facebook.react.bridge.ReadableType.Number
            if (r9 != r10) goto L_0x0077
            int r8 = r1.getInt(r8)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            goto L_0x0078
        L_0x0077:
            r8 = r2
        L_0x0078:
            java.lang.String r9 = "connectionPriority"
            boolean r10 = r1.hasKey(r9)
            if (r10 == 0) goto L_0x008c
            com.facebook.react.bridge.ReadableType r10 = r1.getType(r9)
            com.facebook.react.bridge.ReadableType r11 = com.facebook.react.bridge.ReadableType.Number
            if (r10 != r11) goto L_0x008c
            int r4 = r1.getInt(r9)
        L_0x008c:
            r10 = r4
            r4 = r5
            r1 = r8
            r8 = r7
            r7 = r6
            goto L_0x0096
        L_0x0092:
            r1 = r2
            r8 = r1
            r7 = r4
            r10 = r7
        L_0x0096:
            com.bleplx.adapter.BleAdapter r11 = r0.bleAdapter
            com.bleplx.adapter.ConnectionOptions r13 = new com.bleplx.adapter.ConnectionOptions
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r4)
            if (r1 == 0) goto L_0x00a8
            long r1 = r1.longValue()
            java.lang.Long r2 = java.lang.Long.valueOf(r1)
        L_0x00a8:
            r9 = r2
            r5 = r13
            r5.<init>(r6, r7, r8, r9, r10)
            com.bleplx.BlePlxModule$19 r14 = new com.bleplx.BlePlxModule$19
            r14.<init>(r3)
            com.bleplx.BlePlxModule$20 r15 = new com.bleplx.BlePlxModule$20
            r1 = r18
            r15.<init>(r1)
            com.bleplx.BlePlxModule$21 r2 = new com.bleplx.BlePlxModule$21
            r2.<init>(r3)
            r12 = r18
            r16 = r2
            r11.connectToDevice(r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bleplx.BlePlxModule.connectToDevice(java.lang.String, com.facebook.react.bridge.ReadableMap, com.facebook.react.bridge.Promise):void");
    }

    @ReactMethod
    public void cancelDeviceConnection(String str, Promise promise) {
        if (isRequestPossibleHandler("cancelDeviceConnection", promise)) {
            final SafePromise safePromise = new SafePromise(promise);
            this.bleAdapter.cancelDeviceConnection(str, new OnSuccessCallback<Device>() {
                public void onSuccess(Device device) {
                    safePromise.resolve(BlePlxModule.this.deviceConverter.toJSObject(device));
                }
            }, new OnErrorCallback() {
                public void onError(BleError bleError) {
                    safePromise.reject((String) null, BlePlxModule.this.errorConverter.toJs(bleError));
                }
            });
        }
    }

    @ReactMethod
    public void isDeviceConnected(String str, final Promise promise) {
        if (isRequestPossibleHandler("isDeviceConnected", promise)) {
            this.bleAdapter.isDeviceConnected(str, new OnSuccessCallback<Boolean>() {
                public void onSuccess(Boolean bool) {
                    promise.resolve(bool);
                }
            }, new OnErrorCallback() {
                public void onError(BleError bleError) {
                    promise.reject((String) null, BlePlxModule.this.errorConverter.toJs(bleError));
                }
            });
        }
    }

    @ReactMethod
    public void discoverAllServicesAndCharacteristicsForDevice(String str, String str2, Promise promise) {
        if (isRequestPossibleHandler("discoverAllServicesAndCharacteristicsForDevice", promise)) {
            final SafePromise safePromise = new SafePromise(promise);
            this.bleAdapter.discoverAllServicesAndCharacteristicsForDevice(str, str2, new OnSuccessCallback<Device>() {
                public void onSuccess(Device device) {
                    safePromise.resolve(BlePlxModule.this.deviceConverter.toJSObject(device));
                }
            }, new OnErrorCallback() {
                public void onError(BleError bleError) {
                    safePromise.reject((String) null, BlePlxModule.this.errorConverter.toJs(bleError));
                }
            });
        }
    }

    @ReactMethod
    public void servicesForDevice(String str, Promise promise) {
        if (isRequestPossibleHandler("servicesForDevice", promise)) {
            try {
                List<Service> servicesForDevice = this.bleAdapter.getServicesForDevice(str);
                WritableArray createArray = Arguments.createArray();
                for (Service jSObject : servicesForDevice) {
                    createArray.pushMap(this.serviceConverter.toJSObject(jSObject));
                }
                promise.resolve(createArray);
            } catch (BleError e) {
                promise.reject((String) null, this.errorConverter.toJs(e));
            }
        }
    }

    @ReactMethod
    public void characteristicsForDevice(String str, String str2, Promise promise) {
        if (isRequestPossibleHandler("characteristicsForDevice", promise)) {
            try {
                List<Characteristic> characteristicsForDevice = this.bleAdapter.getCharacteristicsForDevice(str, str2);
                WritableArray createArray = Arguments.createArray();
                for (Characteristic jSObject : characteristicsForDevice) {
                    createArray.pushMap(this.characteristicConverter.toJSObject(jSObject));
                }
                promise.resolve(createArray);
            } catch (BleError e) {
                promise.reject((String) null, this.errorConverter.toJs(e));
            }
        }
    }

    @ReactMethod
    public void characteristicsForService(int i, Promise promise) {
        if (isRequestPossibleHandler("characteristicsForService", promise)) {
            try {
                List<Characteristic> characteristicsForService = this.bleAdapter.getCharacteristicsForService(i);
                WritableArray createArray = Arguments.createArray();
                for (Characteristic jSObject : characteristicsForService) {
                    createArray.pushMap(this.characteristicConverter.toJSObject(jSObject));
                }
                promise.resolve(createArray);
            } catch (BleError e) {
                promise.reject((String) null, this.errorConverter.toJs(e));
            }
        }
    }

    @ReactMethod
    public void descriptorsForDevice(String str, String str2, String str3, Promise promise) {
        if (isRequestPossibleHandler("descriptorsForDevice", promise)) {
            try {
                List<Descriptor> descriptorsForDevice = this.bleAdapter.descriptorsForDevice(str, str2, str3);
                WritableArray createArray = Arguments.createArray();
                for (Descriptor jSObject : descriptorsForDevice) {
                    createArray.pushMap(this.descriptorConverter.toJSObject(jSObject));
                }
                promise.resolve(createArray);
            } catch (BleError e) {
                promise.reject((String) null, this.errorConverter.toJs(e));
            }
        }
    }

    @ReactMethod
    public void descriptorsForService(int i, String str, Promise promise) {
        if (isRequestPossibleHandler("descriptorsForService", promise)) {
            try {
                List<Descriptor> descriptorsForService = this.bleAdapter.descriptorsForService(i, str);
                WritableArray createArray = Arguments.createArray();
                for (Descriptor jSObject : descriptorsForService) {
                    createArray.pushMap(this.descriptorConverter.toJSObject(jSObject));
                }
                promise.resolve(createArray);
            } catch (BleError e) {
                promise.reject((String) null, this.errorConverter.toJs(e));
            }
        }
    }

    @ReactMethod
    public void descriptorsForCharacteristic(int i, Promise promise) {
        if (isRequestPossibleHandler("descriptorsForCharacteristic", promise)) {
            try {
                List<Descriptor> descriptorsForCharacteristic = this.bleAdapter.descriptorsForCharacteristic(i);
                WritableArray createArray = Arguments.createArray();
                for (Descriptor jSObject : descriptorsForCharacteristic) {
                    createArray.pushMap(this.descriptorConverter.toJSObject(jSObject));
                }
                promise.resolve(createArray);
            } catch (BleError e) {
                promise.reject((String) null, this.errorConverter.toJs(e));
            }
        }
    }

    @ReactMethod
    public void writeCharacteristicForDevice(String str, String str2, String str3, String str4, Boolean bool, String str5, Promise promise) {
        Promise promise2 = promise;
        if (isRequestPossibleHandler("writeCharacteristicForDevice", promise2)) {
            final SafePromise safePromise = new SafePromise(promise2);
            this.bleAdapter.writeCharacteristicForDevice(str, str2, str3, str4, bool.booleanValue(), str5, new OnSuccessCallback<Characteristic>() {
                public void onSuccess(Characteristic characteristic) {
                    safePromise.resolve(BlePlxModule.this.characteristicConverter.toJSObject(characteristic));
                }
            }, new OnErrorCallback() {
                public void onError(BleError bleError) {
                    safePromise.reject((String) null, BlePlxModule.this.errorConverter.toJs(bleError));
                }
            });
        }
    }

    @ReactMethod
    public void writeCharacteristicForService(int i, String str, String str2, Boolean bool, String str3, Promise promise) {
        if (isRequestPossibleHandler("writeCharacteristicForService", promise)) {
            final SafePromise safePromise = new SafePromise(promise);
            this.bleAdapter.writeCharacteristicForService(i, str, str2, bool.booleanValue(), str3, new OnSuccessCallback<Characteristic>() {
                public void onSuccess(Characteristic characteristic) {
                    safePromise.resolve(BlePlxModule.this.characteristicConverter.toJSObject(characteristic));
                }
            }, new OnErrorCallback() {
                public void onError(BleError bleError) {
                    safePromise.reject((String) null, BlePlxModule.this.errorConverter.toJs(bleError));
                }
            });
        }
    }

    @ReactMethod
    public void writeCharacteristic(int i, String str, Boolean bool, String str2, Promise promise) {
        if (isRequestPossibleHandler("writeCharacteristic", promise)) {
            final SafePromise safePromise = new SafePromise(promise);
            this.bleAdapter.writeCharacteristic(i, str, bool.booleanValue(), str2, new OnSuccessCallback<Characteristic>() {
                public void onSuccess(Characteristic characteristic) {
                    safePromise.resolve(BlePlxModule.this.characteristicConverter.toJSObject(characteristic));
                }
            }, new OnErrorCallback() {
                public void onError(BleError bleError) {
                    safePromise.reject((String) null, BlePlxModule.this.errorConverter.toJs(bleError));
                }
            });
        }
    }

    @ReactMethod
    public void readCharacteristicForDevice(String str, String str2, String str3, String str4, Promise promise) {
        if (isRequestPossibleHandler("readCharacteristicForDevice", promise)) {
            final SafePromise safePromise = new SafePromise(promise);
            this.bleAdapter.readCharacteristicForDevice(str, str2, str3, str4, new OnSuccessCallback<Characteristic>() {
                public void onSuccess(Characteristic characteristic) {
                    safePromise.resolve(BlePlxModule.this.characteristicConverter.toJSObject(characteristic));
                }
            }, new OnErrorCallback() {
                public void onError(BleError bleError) {
                    safePromise.reject((String) null, BlePlxModule.this.errorConverter.toJs(bleError));
                }
            });
        }
    }

    @ReactMethod
    public void readCharacteristicForService(int i, String str, String str2, Promise promise) {
        if (isRequestPossibleHandler("readCharacteristicForService", promise)) {
            final SafePromise safePromise = new SafePromise(promise);
            this.bleAdapter.readCharacteristicForService(i, str, str2, new OnSuccessCallback<Characteristic>() {
                public void onSuccess(Characteristic characteristic) {
                    safePromise.resolve(BlePlxModule.this.characteristicConverter.toJSObject(characteristic));
                }
            }, new OnErrorCallback() {
                public void onError(BleError bleError) {
                    safePromise.reject((String) null, BlePlxModule.this.errorConverter.toJs(bleError));
                }
            });
        }
    }

    @ReactMethod
    public void readCharacteristic(int i, String str, Promise promise) {
        if (isRequestPossibleHandler("readCharacteristic", promise)) {
            final SafePromise safePromise = new SafePromise(promise);
            this.bleAdapter.readCharacteristic(i, str, new OnSuccessCallback<Characteristic>() {
                public void onSuccess(Characteristic characteristic) {
                    safePromise.resolve(BlePlxModule.this.characteristicConverter.toJSObject(characteristic));
                }
            }, new OnErrorCallback() {
                public void onError(BleError bleError) {
                    safePromise.reject((String) null, BlePlxModule.this.errorConverter.toJs(bleError));
                }
            });
        }
    }

    @ReactMethod
    public void monitorCharacteristicForDevice(String str, String str2, String str3, final String str4, Promise promise) {
        if (isRequestPossibleHandler("monitorCharacteristicForDevice", promise)) {
            final SafePromise safePromise = new SafePromise(promise);
            this.bleAdapter.monitorCharacteristicForDevice(str, str2, str3, str4, new OnEventCallback<Characteristic>() {
                public void onEvent(Characteristic characteristic) {
                    WritableArray createArray = Arguments.createArray();
                    createArray.pushNull();
                    createArray.pushMap(BlePlxModule.this.characteristicConverter.toJSObject(characteristic));
                    createArray.pushString(str4);
                    BlePlxModule.this.sendEvent(Event.ReadEvent, createArray);
                }
            }, new OnErrorCallback() {
                public void onError(BleError bleError) {
                    safePromise.reject((String) null, BlePlxModule.this.errorConverter.toJs(bleError));
                }
            });
        }
    }

    @ReactMethod
    public void monitorCharacteristicForService(int i, String str, final String str2, Promise promise) {
        if (isRequestPossibleHandler("monitorCharacteristicForService", promise)) {
            final SafePromise safePromise = new SafePromise(promise);
            this.bleAdapter.monitorCharacteristicForService(i, str, str2, new OnEventCallback<Characteristic>() {
                public void onEvent(Characteristic characteristic) {
                    WritableArray createArray = Arguments.createArray();
                    createArray.pushNull();
                    createArray.pushMap(BlePlxModule.this.characteristicConverter.toJSObject(characteristic));
                    createArray.pushString(str2);
                    BlePlxModule.this.sendEvent(Event.ReadEvent, createArray);
                }
            }, new OnErrorCallback() {
                public void onError(BleError bleError) {
                    safePromise.reject((String) null, BlePlxModule.this.errorConverter.toJs(bleError));
                }
            });
        }
    }

    @ReactMethod
    public void monitorCharacteristic(int i, final String str, Promise promise) {
        if (isRequestPossibleHandler("monitorCharacteristic", promise)) {
            final SafePromise safePromise = new SafePromise(promise);
            this.bleAdapter.monitorCharacteristic(i, str, new OnEventCallback<Characteristic>() {
                public void onEvent(Characteristic characteristic) {
                    WritableArray createArray = Arguments.createArray();
                    createArray.pushNull();
                    createArray.pushMap(BlePlxModule.this.characteristicConverter.toJSObject(characteristic));
                    createArray.pushString(str);
                    BlePlxModule.this.sendEvent(Event.ReadEvent, createArray);
                }
            }, new OnErrorCallback() {
                public void onError(BleError bleError) {
                    safePromise.reject((String) null, BlePlxModule.this.errorConverter.toJs(bleError));
                }
            });
        }
    }

    @ReactMethod
    public void readDescriptorForDevice(String str, String str2, String str3, String str4, String str5, final Promise promise) {
        if (isRequestPossibleHandler("readDescriptorForDevice", promise)) {
            this.bleAdapter.readDescriptorForDevice(str, str2, str3, str4, str5, new OnSuccessCallback<Descriptor>() {
                public void onSuccess(Descriptor descriptor) {
                    promise.resolve(BlePlxModule.this.descriptorConverter.toJSObject(descriptor));
                }
            }, new OnErrorCallback() {
                public void onError(BleError bleError) {
                    promise.reject((String) null, BlePlxModule.this.errorConverter.toJs(bleError));
                }
            });
        }
    }

    @ReactMethod
    public void readDescriptorForService(int i, String str, String str2, String str3, final Promise promise) {
        if (isRequestPossibleHandler("readDescriptorForService", promise)) {
            this.bleAdapter.readDescriptorForService(i, str, str2, str3, new OnSuccessCallback<Descriptor>() {
                public void onSuccess(Descriptor descriptor) {
                    promise.resolve(BlePlxModule.this.descriptorConverter.toJSObject(descriptor));
                }
            }, new OnErrorCallback() {
                public void onError(BleError bleError) {
                    promise.reject((String) null, BlePlxModule.this.errorConverter.toJs(bleError));
                }
            });
        }
    }

    @ReactMethod
    public void readDescriptorForCharacteristic(int i, String str, String str2, final Promise promise) {
        if (isRequestPossibleHandler("readDescriptorForCharacteristic", promise)) {
            this.bleAdapter.readDescriptorForCharacteristic(i, str, str2, new OnSuccessCallback<Descriptor>() {
                public void onSuccess(Descriptor descriptor) {
                    promise.resolve(BlePlxModule.this.descriptorConverter.toJSObject(descriptor));
                }
            }, new OnErrorCallback() {
                public void onError(BleError bleError) {
                    promise.reject((String) null, BlePlxModule.this.errorConverter.toJs(bleError));
                }
            });
        }
    }

    @ReactMethod
    public void readDescriptor(int i, String str, final Promise promise) {
        if (isRequestPossibleHandler("readDescriptor", promise)) {
            this.bleAdapter.readDescriptor(i, str, new OnSuccessCallback<Descriptor>() {
                public void onSuccess(Descriptor descriptor) {
                    promise.resolve(BlePlxModule.this.descriptorConverter.toJSObject(descriptor));
                }
            }, new OnErrorCallback() {
                public void onError(BleError bleError) {
                    promise.reject((String) null, BlePlxModule.this.errorConverter.toJs(bleError));
                }
            });
        }
    }

    @ReactMethod
    public void writeDescriptorForDevice(String str, String str2, String str3, String str4, String str5, String str6, Promise promise) {
        final Promise promise2 = promise;
        if (isRequestPossibleHandler("writeDescriptorForDevice", promise2)) {
            this.bleAdapter.writeDescriptorForDevice(str, str2, str3, str4, str5, str6, new OnSuccessCallback<Descriptor>() {
                public void onSuccess(Descriptor descriptor) {
                    promise2.resolve(BlePlxModule.this.descriptorConverter.toJSObject(descriptor));
                }
            }, new OnErrorCallback() {
                public void onError(BleError bleError) {
                    promise2.reject((String) null, BlePlxModule.this.errorConverter.toJs(bleError));
                }
            });
        }
    }

    @ReactMethod
    public void writeDescriptorForService(int i, String str, String str2, String str3, String str4, final Promise promise) {
        if (isRequestPossibleHandler("writeDescriptorForService", promise)) {
            this.bleAdapter.writeDescriptorForService(i, str, str2, str3, str4, new OnSuccessCallback<Descriptor>() {
                public void onSuccess(Descriptor descriptor) {
                    promise.resolve(BlePlxModule.this.descriptorConverter.toJSObject(descriptor));
                }
            }, new OnErrorCallback() {
                public void onError(BleError bleError) {
                    promise.reject((String) null, BlePlxModule.this.errorConverter.toJs(bleError));
                }
            });
        }
    }

    @ReactMethod
    public void writeDescriptorForCharacteristic(int i, String str, String str2, String str3, final Promise promise) {
        if (isRequestPossibleHandler("writeDescriptorForCharacteristic", promise)) {
            this.bleAdapter.writeDescriptorForCharacteristic(i, str, str2, str3, new OnSuccessCallback<Descriptor>() {
                public void onSuccess(Descriptor descriptor) {
                    promise.resolve(BlePlxModule.this.descriptorConverter.toJSObject(descriptor));
                }
            }, new OnErrorCallback() {
                public void onError(BleError bleError) {
                    promise.reject((String) null, BlePlxModule.this.errorConverter.toJs(bleError));
                }
            });
        }
    }

    @ReactMethod
    public void writeDescriptor(int i, String str, String str2, final Promise promise) {
        if (isRequestPossibleHandler("writeDescriptor", promise)) {
            this.bleAdapter.writeDescriptor(i, str, str2, new OnSuccessCallback<Descriptor>() {
                public void onSuccess(Descriptor descriptor) {
                    promise.resolve(BlePlxModule.this.descriptorConverter.toJSObject(descriptor));
                }
            }, new OnErrorCallback() {
                public void onError(BleError bleError) {
                    promise.reject((String) null, BlePlxModule.this.errorConverter.toJs(bleError));
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void sendEvent(Event event, Object obj) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(event.name, obj);
    }

    private boolean isRequestPossibleHandler(String str, Promise promise) {
        if (this.bleAdapter != null) {
            return true;
        }
        promise.reject((String) null, this.errorConverter.toJs(new BleError(BleErrorCode.BluetoothManagerDestroyed, String.format("BleManager cannot call the %s function because BleManager has been destroyed", new Object[]{str}), (Integer) null)));
        return false;
    }
}
