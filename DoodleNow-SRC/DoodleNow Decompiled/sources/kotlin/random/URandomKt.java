package kotlin.random;

import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import kotlin.ranges.ULongRange;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\bH\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0019\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001a\u001b\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u0011\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a/\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0011\u0010\u0018\u001a\u00020\u0003*\u00020\rH\u0007¢\u0006\u0002\u0010\u0019\u001a\u001b\u0010\u0018\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a#\u0010\u0018\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0019\u0010\u0018\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007¢\u0006\u0002\u0010 \u001a\u0011\u0010!\u001a\u00020\b*\u00020\rH\u0007¢\u0006\u0002\u0010\"\u001a\u001b\u0010!\u001a\u00020\b*\u00020\r2\u0006\u0010\u0004\u001a\u00020\bH\u0007¢\u0006\u0004\b#\u0010$\u001a#\u0010!\u001a\u00020\b*\u00020\r2\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\bH\u0007¢\u0006\u0004\b%\u0010&\u001a\u0019\u0010!\u001a\u00020\b*\u00020\r2\u0006\u0010\u001e\u001a\u00020'H\u0007¢\u0006\u0002\u0010(¨\u0006)"}, d2 = {"checkUIntRangeBounds", "", "from", "Lkotlin/UInt;", "until", "checkUIntRangeBounds-J1ME1BU", "(II)V", "checkULongRangeBounds", "Lkotlin/ULong;", "checkULongRangeBounds-eb3DHEI", "(JJ)V", "nextUBytes", "Lkotlin/UByteArray;", "Lkotlin/random/Random;", "size", "", "(Lkotlin/random/Random;I)[B", "array", "nextUBytes-EVgfTAA", "(Lkotlin/random/Random;[B)[B", "fromIndex", "toIndex", "nextUBytes-Wvrt4B4", "(Lkotlin/random/Random;[BII)[B", "nextUInt", "(Lkotlin/random/Random;)I", "nextUInt-qCasIEU", "(Lkotlin/random/Random;I)I", "nextUInt-a8DCA5k", "(Lkotlin/random/Random;II)I", "range", "Lkotlin/ranges/UIntRange;", "(Lkotlin/random/Random;Lkotlin/ranges/UIntRange;)I", "nextULong", "(Lkotlin/random/Random;)J", "nextULong-V1Xi4fY", "(Lkotlin/random/Random;J)J", "nextULong-jmpaW-c", "(Lkotlin/random/Random;JJ)J", "Lkotlin/ranges/ULongRange;", "(Lkotlin/random/Random;Lkotlin/ranges/ULongRange;)J", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: URandom.kt */
public final class URandomKt {
    public static final int nextUInt(Random random) {
        Intrinsics.checkNotNullParameter(random, "<this>");
        return UInt.m1325constructorimpl(random.nextInt());
    }

    /* renamed from: nextUInt-qCasIEU  reason: not valid java name */
    public static final int m2447nextUIntqCasIEU(Random random, int i) {
        Intrinsics.checkNotNullParameter(random, "$this$nextUInt");
        return m2446nextUInta8DCA5k(random, 0, i);
    }

    /* renamed from: nextUInt-a8DCA5k  reason: not valid java name */
    public static final int m2446nextUInta8DCA5k(Random random, int i, int i2) {
        Intrinsics.checkNotNullParameter(random, "$this$nextUInt");
        m2441checkUIntRangeBoundsJ1ME1BU(i, i2);
        return UInt.m1325constructorimpl(random.nextInt(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE) ^ Integer.MIN_VALUE);
    }

    public static final int nextUInt(Random random, UIntRange uIntRange) {
        Intrinsics.checkNotNullParameter(random, "<this>");
        Intrinsics.checkNotNullParameter(uIntRange, SessionDescription.ATTR_RANGE);
        if (uIntRange.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + uIntRange);
        } else if (Integer.compare(uIntRange.m2451getLastpVg5ArA() ^ Integer.MIN_VALUE, -1 ^ Integer.MIN_VALUE) < 0) {
            return m2446nextUInta8DCA5k(random, uIntRange.m2450getFirstpVg5ArA(), UInt.m1325constructorimpl(uIntRange.m2451getLastpVg5ArA() + 1));
        } else {
            if (Integer.compare(uIntRange.m2450getFirstpVg5ArA() ^ Integer.MIN_VALUE, 0 ^ Integer.MIN_VALUE) > 0) {
                return UInt.m1325constructorimpl(m2446nextUInta8DCA5k(random, UInt.m1325constructorimpl(uIntRange.m2450getFirstpVg5ArA() - 1), uIntRange.m2451getLastpVg5ArA()) + 1);
            }
            return nextUInt(random);
        }
    }

    public static final long nextULong(Random random) {
        Intrinsics.checkNotNullParameter(random, "<this>");
        return ULong.m1404constructorimpl(random.nextLong());
    }

    /* renamed from: nextULong-V1Xi4fY  reason: not valid java name */
    public static final long m2448nextULongV1Xi4fY(Random random, long j) {
        Intrinsics.checkNotNullParameter(random, "$this$nextULong");
        return m2449nextULongjmpaWc(random, 0, j);
    }

    /* renamed from: nextULong-jmpaW-c  reason: not valid java name */
    public static final long m2449nextULongjmpaWc(Random random, long j, long j2) {
        Intrinsics.checkNotNullParameter(random, "$this$nextULong");
        m2442checkULongRangeBoundseb3DHEI(j, j2);
        return ULong.m1404constructorimpl(random.nextLong(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE) ^ Long.MIN_VALUE);
    }

    public static final long nextULong(Random random, ULongRange uLongRange) {
        Intrinsics.checkNotNullParameter(random, "<this>");
        Intrinsics.checkNotNullParameter(uLongRange, SessionDescription.ATTR_RANGE);
        if (uLongRange.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + uLongRange);
        } else if (UByte$$ExternalSyntheticBackport0.m(uLongRange.m2460getLastsVKNKU(), -1) < 0) {
            return m2449nextULongjmpaWc(random, uLongRange.m2459getFirstsVKNKU(), ULong.m1404constructorimpl(uLongRange.m2460getLastsVKNKU() + ULong.m1404constructorimpl(((long) 1) & 4294967295L)));
        } else {
            if (UByte$$ExternalSyntheticBackport0.m(uLongRange.m2459getFirstsVKNKU(), 0) <= 0) {
                return nextULong(random);
            }
            long j = ((long) 1) & 4294967295L;
            return ULong.m1404constructorimpl(m2449nextULongjmpaWc(random, ULong.m1404constructorimpl(uLongRange.m2459getFirstsVKNKU() - ULong.m1404constructorimpl(j)), uLongRange.m2460getLastsVKNKU()) + ULong.m1404constructorimpl(j));
        }
    }

    /* renamed from: nextUBytes-EVgfTAA  reason: not valid java name */
    public static final byte[] m2443nextUBytesEVgfTAA(Random random, byte[] bArr) {
        Intrinsics.checkNotNullParameter(random, "$this$nextUBytes");
        Intrinsics.checkNotNullParameter(bArr, "array");
        random.nextBytes(bArr);
        return bArr;
    }

    public static final byte[] nextUBytes(Random random, int i) {
        Intrinsics.checkNotNullParameter(random, "<this>");
        return UByteArray.m1301constructorimpl(random.nextBytes(i));
    }

    /* renamed from: nextUBytes-Wvrt4B4$default  reason: not valid java name */
    public static /* synthetic */ byte[] m2445nextUBytesWvrt4B4$default(Random random, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m1307getSizeimpl(bArr);
        }
        return m2444nextUBytesWvrt4B4(random, bArr, i, i2);
    }

    /* renamed from: nextUBytes-Wvrt4B4  reason: not valid java name */
    public static final byte[] m2444nextUBytesWvrt4B4(Random random, byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(random, "$this$nextUBytes");
        Intrinsics.checkNotNullParameter(bArr, "array");
        random.nextBytes(bArr, i, i2);
        return bArr;
    }

    /* renamed from: checkUIntRangeBounds-J1ME1BU  reason: not valid java name */
    public static final void m2441checkUIntRangeBoundsJ1ME1BU(int i, int i2) {
        if (Integer.compare(i2 ^ Integer.MIN_VALUE, i ^ Integer.MIN_VALUE) <= 0) {
            throw new IllegalArgumentException(RandomKt.boundsErrorMessage(UInt.m1319boximpl(i), UInt.m1319boximpl(i2)).toString());
        }
    }

    /* renamed from: checkULongRangeBounds-eb3DHEI  reason: not valid java name */
    public static final void m2442checkULongRangeBoundseb3DHEI(long j, long j2) {
        if (UByte$$ExternalSyntheticBackport0.m(j2, j) <= 0) {
            throw new IllegalArgumentException(RandomKt.boundsErrorMessage(ULong.m1398boximpl(j), ULong.m1398boximpl(j2)).toString());
        }
    }
}
