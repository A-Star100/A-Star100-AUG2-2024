package com.polidea.rxandroidble2.internal.util;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import java.util.Arrays;
import java.util.UUID;

public class ByteAssociation<T> {
    public final T first;
    public final byte[] second;

    public ByteAssociation(T t, byte[] bArr) {
        this.first = t;
        this.second = bArr;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ByteAssociation)) {
            return false;
        }
        ByteAssociation byteAssociation = (ByteAssociation) obj;
        if (!Arrays.equals(byteAssociation.second, this.second) || !byteAssociation.first.equals(this.first)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.first.hashCode() ^ Arrays.hashCode(this.second);
    }

    public String toString() {
        String str;
        T t = this.first;
        if (t instanceof BluetoothGattCharacteristic) {
            StringBuilder sb = new StringBuilder("BluetoothGattCharacteristic(");
            Class<BluetoothGattCharacteristic> cls = BluetoothGattCharacteristic.class;
            sb.append(((BluetoothGattCharacteristic) this.first).getUuid().toString());
            sb.append(")");
            str = sb.toString();
        } else if (t instanceof BluetoothGattDescriptor) {
            StringBuilder sb2 = new StringBuilder("BluetoothGattDescriptor(");
            Class<BluetoothGattDescriptor> cls2 = BluetoothGattDescriptor.class;
            sb2.append(((BluetoothGattDescriptor) this.first).getUuid().toString());
            sb2.append(")");
            str = sb2.toString();
        } else if (t instanceof UUID) {
            StringBuilder sb3 = new StringBuilder("UUID(");
            Class<UUID> cls3 = UUID.class;
            sb3.append(this.first.toString());
            sb3.append(")");
            str = sb3.toString();
        } else {
            str = t.getClass().getSimpleName();
        }
        return getClass().getSimpleName() + "[first=" + str + ", second=" + Arrays.toString(this.second) + "]";
    }

    public static <T> ByteAssociation<T> create(T t, byte[] bArr) {
        return new ByteAssociation<>(t, bArr);
    }
}
