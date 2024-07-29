package com.polidea.rxandroidble2.internal.util;

import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
import bleshadow.javax.inject.Inject;
import com.polidea.rxandroidble2.exceptions.BleException;
import com.polidea.rxandroidble2.internal.RxBleLog;
import java.util.List;
import java.util.Set;

public class RxBleAdapterWrapper {
    private static BleException nullBluetoothAdapter = new BleException("bluetoothAdapter is null");
    private final BluetoothAdapter bluetoothAdapter;

    public boolean hasBluetoothAdapter() {
        return this.bluetoothAdapter != null;
    }

    @Inject
    public RxBleAdapterWrapper(BluetoothAdapter bluetoothAdapter2) {
        this.bluetoothAdapter = bluetoothAdapter2;
    }

    public BluetoothDevice getRemoteDevice(String str) {
        BluetoothAdapter bluetoothAdapter2 = this.bluetoothAdapter;
        if (bluetoothAdapter2 != null) {
            return bluetoothAdapter2.getRemoteDevice(str);
        }
        throw nullBluetoothAdapter;
    }

    public boolean isBluetoothEnabled() {
        BluetoothAdapter bluetoothAdapter2 = this.bluetoothAdapter;
        return bluetoothAdapter2 != null && bluetoothAdapter2.isEnabled();
    }

    public boolean startLegacyLeScan(BluetoothAdapter.LeScanCallback leScanCallback) {
        BluetoothAdapter bluetoothAdapter2 = this.bluetoothAdapter;
        if (bluetoothAdapter2 != null) {
            return bluetoothAdapter2.startLeScan(leScanCallback);
        }
        throw nullBluetoothAdapter;
    }

    public void stopLegacyLeScan(BluetoothAdapter.LeScanCallback leScanCallback) {
        BluetoothAdapter bluetoothAdapter2 = this.bluetoothAdapter;
        if (bluetoothAdapter2 != null) {
            bluetoothAdapter2.stopLeScan(leScanCallback);
            return;
        }
        throw nullBluetoothAdapter;
    }

    public void startLeScan(List<ScanFilter> list, ScanSettings scanSettings, ScanCallback scanCallback) {
        BluetoothAdapter bluetoothAdapter2 = this.bluetoothAdapter;
        if (bluetoothAdapter2 != null) {
            bluetoothAdapter2.getBluetoothLeScanner().startScan(list, scanSettings, scanCallback);
            return;
        }
        throw nullBluetoothAdapter;
    }

    public int startLeScan(List<ScanFilter> list, ScanSettings scanSettings, PendingIntent pendingIntent) {
        BluetoothAdapter bluetoothAdapter2 = this.bluetoothAdapter;
        if (bluetoothAdapter2 != null) {
            return bluetoothAdapter2.getBluetoothLeScanner().startScan(list, scanSettings, pendingIntent);
        }
        throw nullBluetoothAdapter;
    }

    public void stopLeScan(PendingIntent pendingIntent) {
        BluetoothAdapter bluetoothAdapter2 = this.bluetoothAdapter;
        if (bluetoothAdapter2 != null) {
            bluetoothAdapter2.getBluetoothLeScanner().stopScan(pendingIntent);
            return;
        }
        throw nullBluetoothAdapter;
    }

    public void stopLeScan(ScanCallback scanCallback) {
        BluetoothAdapter bluetoothAdapter2 = this.bluetoothAdapter;
        if (bluetoothAdapter2 == null) {
            throw nullBluetoothAdapter;
        } else if (!bluetoothAdapter2.isEnabled()) {
            RxBleLog.v("BluetoothAdapter is disabled, calling BluetoothLeScanner.stopScan(ScanCallback) may cause IllegalStateException", new Object[0]);
        } else {
            BluetoothLeScanner bluetoothLeScanner = this.bluetoothAdapter.getBluetoothLeScanner();
            if (bluetoothLeScanner == null) {
                RxBleLog.w("Cannot call BluetoothLeScanner.stopScan(ScanCallback) on 'null' reference; BluetoothAdapter.isEnabled() == %b", Boolean.valueOf(this.bluetoothAdapter.isEnabled()));
                return;
            }
            bluetoothLeScanner.stopScan(scanCallback);
        }
    }

    public Set<BluetoothDevice> getBondedDevices() {
        BluetoothAdapter bluetoothAdapter2 = this.bluetoothAdapter;
        if (bluetoothAdapter2 != null) {
            return bluetoothAdapter2.getBondedDevices();
        }
        throw nullBluetoothAdapter;
    }
}
