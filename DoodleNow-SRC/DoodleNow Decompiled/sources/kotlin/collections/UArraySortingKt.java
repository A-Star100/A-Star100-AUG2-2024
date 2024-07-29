package kotlin.collections;

import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\t\u0010\n\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\f\u0010\r\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u000f\u0010\u0010\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0013\u0010\u0014\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0015\u0010\u0016\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0017\u0010\u0018\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0019\u0010\u001a\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u001e\u0010\u0014\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u001f\u0010\u0016\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b \u0010\u0018\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b!\u0010\u001a¨\u0006\""}, d2 = {"partition", "", "array", "Lkotlin/UByteArray;", "left", "right", "partition-4UcCI2c", "([BII)I", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort", "", "quickSort-4UcCI2c", "([BII)V", "quickSort-oBK06Vg", "([III)V", "quickSort--nroSd4", "([JII)V", "quickSort-Aa5vz7o", "([SII)V", "sortArray", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray-oBK06Vg", "sortArray--nroSd4", "sortArray-Aa5vz7o", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: UArraySorting.kt */
public final class UArraySortingKt {
    /* renamed from: partition-4UcCI2c  reason: not valid java name */
    private static final int m1682partition4UcCI2c(byte[] bArr, int i, int i2) {
        byte b;
        byte b2 = UByteArray.m1306getw2LRezQ(bArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                b = b2 & 255;
                if (Intrinsics.compare((int) UByteArray.m1306getw2LRezQ(bArr, i) & 255, (int) b) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare((int) UByteArray.m1306getw2LRezQ(bArr, i2) & 255, (int) b) > 0) {
                i2--;
            }
            if (i <= i2) {
                byte b3 = UByteArray.m1306getw2LRezQ(bArr, i);
                UByteArray.m1311setVurrAj0(bArr, i, UByteArray.m1306getw2LRezQ(bArr, i2));
                UByteArray.m1311setVurrAj0(bArr, i2, b3);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort-4UcCI2c  reason: not valid java name */
    private static final void m1686quickSort4UcCI2c(byte[] bArr, int i, int i2) {
        int r0 = m1682partition4UcCI2c(bArr, i, i2);
        int i3 = r0 - 1;
        if (i < i3) {
            m1686quickSort4UcCI2c(bArr, i, i3);
        }
        if (r0 < i2) {
            m1686quickSort4UcCI2c(bArr, r0, i2);
        }
    }

    /* renamed from: partition-Aa5vz7o  reason: not valid java name */
    private static final int m1683partitionAa5vz7o(short[] sArr, int i, int i2) {
        short s;
        short s2 = UShortArray.m1569getMh2AYeg(sArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                short s3 = UShortArray.m1569getMh2AYeg(sArr, i) & UShort.MAX_VALUE;
                s = s2 & UShort.MAX_VALUE;
                if (Intrinsics.compare((int) s3, (int) s) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare((int) UShortArray.m1569getMh2AYeg(sArr, i2) & UShort.MAX_VALUE, (int) s) > 0) {
                i2--;
            }
            if (i <= i2) {
                short s4 = UShortArray.m1569getMh2AYeg(sArr, i);
                UShortArray.m1574set01HTLdE(sArr, i, UShortArray.m1569getMh2AYeg(sArr, i2));
                UShortArray.m1574set01HTLdE(sArr, i2, s4);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort-Aa5vz7o  reason: not valid java name */
    private static final void m1687quickSortAa5vz7o(short[] sArr, int i, int i2) {
        int r0 = m1683partitionAa5vz7o(sArr, i, i2);
        int i3 = r0 - 1;
        if (i < i3) {
            m1687quickSortAa5vz7o(sArr, i, i3);
        }
        if (r0 < i2) {
            m1687quickSortAa5vz7o(sArr, r0, i2);
        }
    }

    /* renamed from: partition-oBK06Vg  reason: not valid java name */
    private static final int m1684partitionoBK06Vg(int[] iArr, int i, int i2) {
        int i3 = UIntArray.m1385getpVg5ArA(iArr, (i + i2) / 2);
        while (i <= i2) {
            while (Integer.compare(UIntArray.m1385getpVg5ArA(iArr, i) ^ Integer.MIN_VALUE, i3 ^ Integer.MIN_VALUE) < 0) {
                i++;
            }
            while (Integer.compare(UIntArray.m1385getpVg5ArA(iArr, i2) ^ Integer.MIN_VALUE, i3 ^ Integer.MIN_VALUE) > 0) {
                i2--;
            }
            if (i <= i2) {
                int i4 = UIntArray.m1385getpVg5ArA(iArr, i);
                UIntArray.m1390setVXSXFK8(iArr, i, UIntArray.m1385getpVg5ArA(iArr, i2));
                UIntArray.m1390setVXSXFK8(iArr, i2, i4);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort-oBK06Vg  reason: not valid java name */
    private static final void m1688quickSortoBK06Vg(int[] iArr, int i, int i2) {
        int r0 = m1684partitionoBK06Vg(iArr, i, i2);
        int i3 = r0 - 1;
        if (i < i3) {
            m1688quickSortoBK06Vg(iArr, i, i3);
        }
        if (r0 < i2) {
            m1688quickSortoBK06Vg(iArr, r0, i2);
        }
    }

    /* renamed from: partition--nroSd4  reason: not valid java name */
    private static final int m1681partitionnroSd4(long[] jArr, int i, int i2) {
        long j = ULongArray.m1464getsVKNKU(jArr, (i + i2) / 2);
        while (i <= i2) {
            while (UByte$$ExternalSyntheticBackport0.m(ULongArray.m1464getsVKNKU(jArr, i), j) < 0) {
                i++;
            }
            while (UByte$$ExternalSyntheticBackport0.m(ULongArray.m1464getsVKNKU(jArr, i2), j) > 0) {
                i2--;
            }
            if (i <= i2) {
                long j2 = ULongArray.m1464getsVKNKU(jArr, i);
                ULongArray.m1469setk8EXiF4(jArr, i, ULongArray.m1464getsVKNKU(jArr, i2));
                ULongArray.m1469setk8EXiF4(jArr, i2, j2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort--nroSd4  reason: not valid java name */
    private static final void m1685quickSortnroSd4(long[] jArr, int i, int i2) {
        int r0 = m1681partitionnroSd4(jArr, i, i2);
        int i3 = r0 - 1;
        if (i < i3) {
            m1685quickSortnroSd4(jArr, i, i3);
        }
        if (r0 < i2) {
            m1685quickSortnroSd4(jArr, r0, i2);
        }
    }

    /* renamed from: sortArray-4UcCI2c  reason: not valid java name */
    public static final void m1690sortArray4UcCI2c(byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "array");
        m1686quickSort4UcCI2c(bArr, i, i2 - 1);
    }

    /* renamed from: sortArray-Aa5vz7o  reason: not valid java name */
    public static final void m1691sortArrayAa5vz7o(short[] sArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(sArr, "array");
        m1687quickSortAa5vz7o(sArr, i, i2 - 1);
    }

    /* renamed from: sortArray-oBK06Vg  reason: not valid java name */
    public static final void m1692sortArrayoBK06Vg(int[] iArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(iArr, "array");
        m1688quickSortoBK06Vg(iArr, i, i2 - 1);
    }

    /* renamed from: sortArray--nroSd4  reason: not valid java name */
    public static final void m1689sortArraynroSd4(long[] jArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(jArr, "array");
        m1685quickSortnroSd4(jArr, i, i2 - 1);
    }
}
