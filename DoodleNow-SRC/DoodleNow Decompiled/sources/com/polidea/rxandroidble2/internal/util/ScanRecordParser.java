package com.polidea.rxandroidble2.internal.util;

import android.os.ParcelUuid;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ScanRecordParser {
    public static final UUID BASE_UUID = UUID.fromString("00000000-0000-1000-8000-00805F9B34FB");
    private static final int DATA_TYPE_FLAGS = 1;
    private static final int DATA_TYPE_LOCAL_NAME_COMPLETE = 9;
    private static final int DATA_TYPE_LOCAL_NAME_SHORT = 8;
    private static final int DATA_TYPE_MANUFACTURER_SPECIFIC_DATA = 255;
    private static final int DATA_TYPE_SERVICE_DATA_128_BIT = 33;
    private static final int DATA_TYPE_SERVICE_DATA_16_BIT = 22;
    private static final int DATA_TYPE_SERVICE_DATA_32_BIT = 32;
    private static final int DATA_TYPE_SERVICE_SOLICITATION_UUIDS_128_BIT = 21;
    private static final int DATA_TYPE_SERVICE_SOLICITATION_UUIDS_16_BIT = 20;
    private static final int DATA_TYPE_SERVICE_SOLICITATION_UUIDS_32_BIT = 31;
    private static final int DATA_TYPE_SERVICE_UUIDS_128_BIT_COMPLETE = 7;
    private static final int DATA_TYPE_SERVICE_UUIDS_128_BIT_PARTIAL = 6;
    private static final int DATA_TYPE_SERVICE_UUIDS_16_BIT_COMPLETE = 3;
    private static final int DATA_TYPE_SERVICE_UUIDS_16_BIT_PARTIAL = 2;
    private static final int DATA_TYPE_SERVICE_UUIDS_32_BIT_COMPLETE = 5;
    private static final int DATA_TYPE_SERVICE_UUIDS_32_BIT_PARTIAL = 4;
    private static final int DATA_TYPE_TX_POWER_LEVEL = 10;
    public static final int UUID_BYTES_128_BIT = 16;
    public static final int UUID_BYTES_16_BIT = 2;
    public static final int UUID_BYTES_32_BIT = 4;

    public List<UUID> extractUUIDs(byte[] bArr) {
        List<ParcelUuid> serviceUuids = parseFromBytes(bArr).getServiceUuids();
        if (serviceUuids == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (ParcelUuid uuid : serviceUuids) {
            arrayList.add(uuid.getUuid());
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005e A[Catch:{ Exception -> 0x010a }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0060 A[Catch:{ Exception -> 0x010a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.polidea.rxandroidble2.scan.ScanRecord parseFromBytes(byte[] r19) {
        /*
            r18 = this;
            r7 = r18
            r15 = r19
            r0 = 0
            if (r15 != 0) goto L_0x0008
            return r0
        L_0x0008:
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            android.util.SparseArray r11 = new android.util.SparseArray
            r11.<init>()
            java.util.HashMap r12 = new java.util.HashMap
            r12.<init>()
            r17 = 0
            r1 = -1
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r16 = r0
            r13 = r1
            r14 = r2
            r1 = r17
        L_0x0027:
            int r2 = r15.length     // Catch:{ Exception -> 0x010a }
            if (r1 >= r2) goto L_0x00f6
            int r2 = r1 + 1
            byte r3 = r15[r1]     // Catch:{ Exception -> 0x010a }
            r4 = 255(0xff, float:3.57E-43)
            r3 = r3 & r4
            if (r3 != 0) goto L_0x0035
            goto L_0x00f6
        L_0x0035:
            int r9 = r3 + -1
            int r6 = r1 + 2
            byte r2 = r15[r2]     // Catch:{ Exception -> 0x010a }
            r2 = r2 & r4
            if (r2 == r4) goto L_0x00da
            switch(r2) {
                case 1: goto L_0x00d4;
                case 2: goto L_0x00c7;
                case 3: goto L_0x00c7;
                case 4: goto L_0x00ba;
                case 5: goto L_0x00ba;
                case 6: goto L_0x00ac;
                case 7: goto L_0x00ac;
                case 8: goto L_0x009f;
                case 9: goto L_0x009f;
                case 10: goto L_0x009a;
                default: goto L_0x0041;
            }     // Catch:{ Exception -> 0x010a }
        L_0x0041:
            switch(r2) {
                case 20: goto L_0x008c;
                case 21: goto L_0x007d;
                case 22: goto L_0x004a;
                default: goto L_0x0044;
            }     // Catch:{ Exception -> 0x010a }
        L_0x0044:
            switch(r2) {
                case 31: goto L_0x004c;
                case 32: goto L_0x004a;
                case 33: goto L_0x004a;
                default: goto L_0x0047;
            }     // Catch:{ Exception -> 0x010a }
        L_0x0047:
            r0 = r6
            goto L_0x00f1
        L_0x004a:
            r0 = r6
            goto L_0x005a
        L_0x004c:
            r5 = 4
            r1 = r18
            r2 = r19
            r3 = r6
            r4 = r9
            r0 = r6
            r6 = r10
            r1.parseServiceSolicitationUuid(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x010a }
            goto L_0x00f1
        L_0x005a:
            r1 = 32
            if (r2 != r1) goto L_0x0060
            r1 = 4
            goto L_0x0068
        L_0x0060:
            r1 = 33
            if (r2 != r1) goto L_0x0067
            r1 = 16
            goto L_0x0068
        L_0x0067:
            r1 = 2
        L_0x0068:
            byte[] r2 = r7.extractBytes(r15, r0, r1)     // Catch:{ Exception -> 0x010a }
            android.os.ParcelUuid r2 = parseUuidFrom(r2)     // Catch:{ Exception -> 0x010a }
            int r6 = r0 + r1
            int r1 = r9 - r1
            byte[] r1 = r7.extractBytes(r15, r6, r1)     // Catch:{ Exception -> 0x010a }
            r12.put(r2, r1)     // Catch:{ Exception -> 0x010a }
            goto L_0x00f1
        L_0x007d:
            r0 = r6
            r5 = 16
            r1 = r18
            r2 = r19
            r3 = r0
            r4 = r9
            r6 = r10
            r1.parseServiceSolicitationUuid(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x010a }
            goto L_0x00f1
        L_0x008c:
            r0 = r6
            r5 = 2
            r1 = r18
            r2 = r19
            r3 = r0
            r4 = r9
            r6 = r10
            r1.parseServiceSolicitationUuid(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x010a }
            goto L_0x00f1
        L_0x009a:
            r0 = r6
            byte r14 = r15[r0]     // Catch:{ Exception -> 0x010a }
            goto L_0x00f1
        L_0x009f:
            r0 = r6
            java.lang.String r1 = new java.lang.String     // Catch:{ Exception -> 0x010a }
            byte[] r2 = r7.extractBytes(r15, r0, r9)     // Catch:{ Exception -> 0x010a }
            r1.<init>(r2)     // Catch:{ Exception -> 0x010a }
            r16 = r1
            goto L_0x00f1
        L_0x00ac:
            r0 = r6
            r5 = 16
            r1 = r18
            r2 = r19
            r3 = r0
            r4 = r9
            r6 = r8
            r1.parseServiceUuid(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x010a }
            goto L_0x00f1
        L_0x00ba:
            r0 = r6
            r5 = 4
            r1 = r18
            r2 = r19
            r3 = r0
            r4 = r9
            r6 = r8
            r1.parseServiceUuid(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x010a }
            goto L_0x00f1
        L_0x00c7:
            r0 = r6
            r5 = 2
            r1 = r18
            r2 = r19
            r3 = r0
            r4 = r9
            r6 = r8
            r1.parseServiceUuid(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x010a }
            goto L_0x00f1
        L_0x00d4:
            r0 = r6
            byte r1 = r15[r0]     // Catch:{ Exception -> 0x010a }
            r13 = r1 & 255(0xff, float:3.57E-43)
            goto L_0x00f1
        L_0x00da:
            r0 = r6
            int r2 = r1 + 3
            byte r2 = r15[r2]     // Catch:{ Exception -> 0x010a }
            r2 = r2 & r4
            int r2 = r2 << 8
            byte r5 = r15[r0]     // Catch:{ Exception -> 0x010a }
            r4 = r4 & r5
            int r2 = r2 + r4
            int r1 = r1 + 4
            int r3 = r3 + -3
            byte[] r1 = r7.extractBytes(r15, r1, r3)     // Catch:{ Exception -> 0x010a }
            r11.put(r2, r1)     // Catch:{ Exception -> 0x010a }
        L_0x00f1:
            int r1 = r0 + r9
            r0 = 0
            goto L_0x0027
        L_0x00f6:
            boolean r0 = r8.isEmpty()     // Catch:{ Exception -> 0x010a }
            if (r0 == 0) goto L_0x00fe
            r9 = 0
            goto L_0x00ff
        L_0x00fe:
            r9 = r8
        L_0x00ff:
            com.polidea.rxandroidble2.internal.scan.ScanRecordImplCompat r0 = new com.polidea.rxandroidble2.internal.scan.ScanRecordImplCompat     // Catch:{ Exception -> 0x010a }
            r8 = r0
            r15 = r16
            r16 = r19
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16)     // Catch:{ Exception -> 0x010a }
            return r0
        L_0x010a:
            r0 = move-exception
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = com.polidea.rxandroidble2.internal.logger.LoggerUtil.bytesToHex(r19)
            r1[r17] = r2
            java.lang.String r2 = "Unable to parse scan record: %s"
            com.polidea.rxandroidble2.internal.RxBleLog.e(r0, r2, r1)
            com.polidea.rxandroidble2.internal.scan.ScanRecordImplCompat r0 = new com.polidea.rxandroidble2.internal.scan.ScanRecordImplCompat
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = -1
            r14 = -2147483648(0xffffffff80000000, float:-0.0)
            r15 = 0
            r8 = r0
            r16 = r19
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.polidea.rxandroidble2.internal.util.ScanRecordParser.parseFromBytes(byte[]):com.polidea.rxandroidble2.scan.ScanRecord");
    }

    private static ParcelUuid parseUuidFrom(byte[] bArr) {
        long j;
        if (bArr != null) {
            int length = bArr.length;
            if (length != 2 && length != 4 && length != 16) {
                throw new IllegalArgumentException("uuidBytes length invalid - " + length);
            } else if (length == 16) {
                ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                return new ParcelUuid(new UUID(order.getLong(8), order.getLong(0)));
            } else {
                if (length == 2) {
                    j = ((long) (bArr[0] & 255)) + ((long) ((bArr[1] & 255) << 8));
                } else {
                    j = ((long) ((bArr[3] & 255) << Ascii.CAN)) + ((long) (bArr[0] & 255)) + ((long) ((bArr[1] & 255) << 8)) + ((long) ((bArr[2] & 255) << Ascii.DLE));
                }
                UUID uuid = BASE_UUID;
                return new ParcelUuid(new UUID(uuid.getMostSignificantBits() + (j << 32), uuid.getLeastSignificantBits()));
            }
        } else {
            throw new IllegalArgumentException("uuidBytes cannot be null");
        }
    }

    private int parseServiceUuid(byte[] bArr, int i, int i2, int i3, List<ParcelUuid> list) {
        while (i2 > 0) {
            list.add(parseUuidFrom(extractBytes(bArr, i, i3)));
            i2 -= i3;
            i += i3;
        }
        return i;
    }

    private int parseServiceSolicitationUuid(byte[] bArr, int i, int i2, int i3, List<ParcelUuid> list) {
        while (i2 > 0) {
            list.add(parseUuidFrom(extractBytes(bArr, i, i3)));
            i2 -= i3;
            i += i3;
        }
        return i;
    }

    private byte[] extractBytes(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }
}
