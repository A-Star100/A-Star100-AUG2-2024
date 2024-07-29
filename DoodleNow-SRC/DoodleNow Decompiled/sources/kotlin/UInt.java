package kotlin;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.UIntRange;
import kotlin.ranges.URangesKt;

@JvmInline
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b@\u0018\u0000 {2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001{B\u0011\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\f¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\rH\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0010\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0011H\n¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0014H\n¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0005J\u0018\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\n¢\u0006\u0004\b\u001a\u0010\u000fJ\u0018\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\n¢\u0006\u0004\b\u001b\u0010\u000bJ\u0018\u0010\u0019\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\n¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\n¢\u0006\u0004\b\u001e\u0010\u0016J\u001a\u0010\u001f\u001a\u00020 2\b\u0010\t\u001a\u0004\u0018\u00010!HÖ\u0003¢\u0006\u0004\b\"\u0010#J\u0018\u0010$\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\b¢\u0006\u0004\b%\u0010\u000fJ\u0018\u0010$\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\b¢\u0006\u0004\b&\u0010\u000bJ\u0018\u0010$\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\b¢\u0006\u0004\b'\u0010\u001dJ\u0018\u0010$\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\b¢\u0006\u0004\b(\u0010\u0016J\u0010\u0010)\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b*\u0010\u0005J\u0013\u0010+\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b,\u0010\u0005J\u0013\u0010-\u001a\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b.\u0010\u0005J\u0018\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\n¢\u0006\u0004\b0\u0010\u000fJ\u0018\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\n¢\u0006\u0004\b1\u0010\u000bJ\u0018\u0010/\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\n¢\u0006\u0004\b2\u0010\u001dJ\u0018\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\n¢\u0006\u0004\b3\u0010\u0016J\u0018\u00104\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\rH\b¢\u0006\u0004\b5\u00106J\u0018\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\b¢\u0006\u0004\b7\u0010\u000bJ\u0018\u00104\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\b¢\u0006\u0004\b8\u0010\u001dJ\u0018\u00104\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\b¢\u0006\u0004\b9\u0010:J\u0018\u0010;\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\f¢\u0006\u0004\b<\u0010\u000bJ\u0018\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\n¢\u0006\u0004\b>\u0010\u000fJ\u0018\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\n¢\u0006\u0004\b?\u0010\u000bJ\u0018\u0010=\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\n¢\u0006\u0004\b@\u0010\u001dJ\u0018\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\n¢\u0006\u0004\bA\u0010\u0016J\u0018\u0010B\u001a\u00020C2\u0006\u0010\t\u001a\u00020\u0000H\n¢\u0006\u0004\bD\u0010EJ\u0018\u0010F\u001a\u00020C2\u0006\u0010\t\u001a\u00020\u0000H\n¢\u0006\u0004\bG\u0010EJ\u0018\u0010H\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\n¢\u0006\u0004\bI\u0010\u000fJ\u0018\u0010H\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\n¢\u0006\u0004\bJ\u0010\u000bJ\u0018\u0010H\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\n¢\u0006\u0004\bK\u0010\u001dJ\u0018\u0010H\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\n¢\u0006\u0004\bL\u0010\u0016J\u001b\u0010M\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u0003H\fø\u0001\u0000¢\u0006\u0004\bO\u0010\u000bJ\u001b\u0010P\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u0003H\fø\u0001\u0000¢\u0006\u0004\bQ\u0010\u000bJ\u0018\u0010R\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\n¢\u0006\u0004\bS\u0010\u000fJ\u0018\u0010R\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\n¢\u0006\u0004\bT\u0010\u000bJ\u0018\u0010R\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\n¢\u0006\u0004\bU\u0010\u001dJ\u0018\u0010R\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\n¢\u0006\u0004\bV\u0010\u0016J\u0010\u0010W\u001a\u00020XH\b¢\u0006\u0004\bY\u0010ZJ\u0010\u0010[\u001a\u00020\\H\b¢\u0006\u0004\b]\u0010^J\u0010\u0010_\u001a\u00020`H\b¢\u0006\u0004\ba\u0010bJ\u0010\u0010c\u001a\u00020\u0003H\b¢\u0006\u0004\bd\u0010\u0005J\u0010\u0010e\u001a\u00020fH\b¢\u0006\u0004\bg\u0010hJ\u0010\u0010i\u001a\u00020jH\b¢\u0006\u0004\bk\u0010lJ\u000f\u0010m\u001a\u00020nH\u0016¢\u0006\u0004\bo\u0010pJ\u0013\u0010q\u001a\u00020\rH\bø\u0001\u0000¢\u0006\u0004\br\u0010ZJ\u0013\u0010s\u001a\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\bt\u0010\u0005J\u0013\u0010u\u001a\u00020\u0011H\bø\u0001\u0000¢\u0006\u0004\bv\u0010hJ\u0013\u0010w\u001a\u00020\u0014H\bø\u0001\u0000¢\u0006\u0004\bx\u0010lJ\u0018\u0010y\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\f¢\u0006\u0004\bz\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0001\u0002\u0001\u00020\u0003\u0002\u0004\n\u0002\b!¨\u0006|"}, d2 = {"Lkotlin/UInt;", "", "data", "", "constructor-impl", "(I)I", "getData$annotations", "()V", "and", "other", "and-WZ4Q5Ns", "(II)I", "compareTo", "Lkotlin/UByte;", "compareTo-7apg3OU", "(IB)I", "compareTo-WZ4Q5Ns", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(IJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(IS)I", "dec", "dec-pVg5ArA", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(IJ)J", "div-xj2QHRw", "equals", "", "", "equals-impl", "(ILjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode", "hashCode-impl", "inc", "inc-pVg5ArA", "inv", "inv-pVg5ArA", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "(IB)B", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(IS)S", "or", "or-WZ4Q5Ns", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-WZ4Q5Ns", "(II)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-WZ4Q5Ns", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "shl", "bitCount", "shl-pVg5ArA", "shr", "shr-pVg5ArA", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(I)B", "toDouble", "", "toDouble-impl", "(I)D", "toFloat", "", "toFloat-impl", "(I)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(I)J", "toShort", "", "toShort-impl", "(I)S", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-WZ4Q5Ns", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: UInt.kt */
public final class UInt implements Comparable<UInt> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int MAX_VALUE = -1;
    public static final int MIN_VALUE = 0;
    public static final int SIZE_BITS = 32;
    public static final int SIZE_BYTES = 4;
    private final int data;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ UInt m1319boximpl(int i) {
        return new UInt(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m1325constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1331equalsimpl(int i, Object obj) {
        return (obj instanceof UInt) && i == ((UInt) obj).m1377unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1332equalsimpl0(int i, int i2) {
        return i == i2;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1337hashCodeimpl(int i) {
        return i;
    }

    /* renamed from: toByte-impl  reason: not valid java name */
    private static final byte m1365toByteimpl(int i) {
        return (byte) i;
    }

    /* renamed from: toInt-impl  reason: not valid java name */
    private static final int m1368toIntimpl(int i) {
        return i;
    }

    /* renamed from: toLong-impl  reason: not valid java name */
    private static final long m1369toLongimpl(int i) {
        return ((long) i) & 4294967295L;
    }

    /* renamed from: toShort-impl  reason: not valid java name */
    private static final short m1370toShortimpl(int i) {
        return (short) i;
    }

    /* renamed from: toUInt-pVg5ArA  reason: not valid java name */
    private static final int m1373toUIntpVg5ArA(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m1331equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m1337hashCodeimpl(this.data);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m1377unboximpl() {
        return this.data;
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return UnsignedKt.uintCompare(m1377unboximpl(), ((UInt) obj).m1377unboximpl());
    }

    private /* synthetic */ UInt(int i) {
        this.data = i;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u00020\u0004XTø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005R\u0013\u0010\u0006\u001a\u00020\u0004XTø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b!¨\u0006\n"}, d2 = {"Lkotlin/UInt$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/UInt;", "I", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: UInt.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* renamed from: compareTo-7apg3OU  reason: not valid java name */
    private static final int m1320compareTo7apg3OU(int i, byte b) {
        return Integer.compare(i ^ Integer.MIN_VALUE, m1325constructorimpl(b & 255) ^ Integer.MIN_VALUE);
    }

    /* renamed from: compareTo-xj2QHRw  reason: not valid java name */
    private static final int m1324compareToxj2QHRw(int i, short s) {
        return Integer.compare(i ^ Integer.MIN_VALUE, m1325constructorimpl(s & UShort.MAX_VALUE) ^ Integer.MIN_VALUE);
    }

    /* renamed from: compareTo-WZ4Q5Ns  reason: not valid java name */
    private int m1322compareToWZ4Q5Ns(int i) {
        return UnsignedKt.uintCompare(m1377unboximpl(), i);
    }

    /* renamed from: compareTo-WZ4Q5Ns  reason: not valid java name */
    private static int m1323compareToWZ4Q5Ns(int i, int i2) {
        return UnsignedKt.uintCompare(i, i2);
    }

    /* renamed from: compareTo-VKZWuLQ  reason: not valid java name */
    private static final int m1321compareToVKZWuLQ(int i, long j) {
        return UByte$$ExternalSyntheticBackport0.m(ULong.m1404constructorimpl(((long) i) & 4294967295L), j);
    }

    /* renamed from: plus-7apg3OU  reason: not valid java name */
    private static final int m1349plus7apg3OU(int i, byte b) {
        return m1325constructorimpl(i + m1325constructorimpl(b & 255));
    }

    /* renamed from: plus-xj2QHRw  reason: not valid java name */
    private static final int m1352plusxj2QHRw(int i, short s) {
        return m1325constructorimpl(i + m1325constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: plus-WZ4Q5Ns  reason: not valid java name */
    private static final int m1351plusWZ4Q5Ns(int i, int i2) {
        return m1325constructorimpl(i + i2);
    }

    /* renamed from: plus-VKZWuLQ  reason: not valid java name */
    private static final long m1350plusVKZWuLQ(int i, long j) {
        return ULong.m1404constructorimpl(ULong.m1404constructorimpl(((long) i) & 4294967295L) + j);
    }

    /* renamed from: minus-7apg3OU  reason: not valid java name */
    private static final int m1340minus7apg3OU(int i, byte b) {
        return m1325constructorimpl(i - m1325constructorimpl(b & 255));
    }

    /* renamed from: minus-xj2QHRw  reason: not valid java name */
    private static final int m1343minusxj2QHRw(int i, short s) {
        return m1325constructorimpl(i - m1325constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: minus-WZ4Q5Ns  reason: not valid java name */
    private static final int m1342minusWZ4Q5Ns(int i, int i2) {
        return m1325constructorimpl(i - i2);
    }

    /* renamed from: minus-VKZWuLQ  reason: not valid java name */
    private static final long m1341minusVKZWuLQ(int i, long j) {
        return ULong.m1404constructorimpl(ULong.m1404constructorimpl(((long) i) & 4294967295L) - j);
    }

    /* renamed from: times-7apg3OU  reason: not valid java name */
    private static final int m1361times7apg3OU(int i, byte b) {
        return m1325constructorimpl(i * m1325constructorimpl(b & 255));
    }

    /* renamed from: times-xj2QHRw  reason: not valid java name */
    private static final int m1364timesxj2QHRw(int i, short s) {
        return m1325constructorimpl(i * m1325constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: times-WZ4Q5Ns  reason: not valid java name */
    private static final int m1363timesWZ4Q5Ns(int i, int i2) {
        return m1325constructorimpl(i * i2);
    }

    /* renamed from: times-VKZWuLQ  reason: not valid java name */
    private static final long m1362timesVKZWuLQ(int i, long j) {
        return ULong.m1404constructorimpl(ULong.m1404constructorimpl(((long) i) & 4294967295L) * j);
    }

    /* renamed from: div-7apg3OU  reason: not valid java name */
    private static final int m1327div7apg3OU(int i, byte b) {
        return UByte$$ExternalSyntheticBackport0.m$1(i, m1325constructorimpl(b & 255));
    }

    /* renamed from: div-xj2QHRw  reason: not valid java name */
    private static final int m1330divxj2QHRw(int i, short s) {
        return UByte$$ExternalSyntheticBackport0.m$1(i, m1325constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: div-WZ4Q5Ns  reason: not valid java name */
    private static final int m1329divWZ4Q5Ns(int i, int i2) {
        return UnsignedKt.m1581uintDivideJ1ME1BU(i, i2);
    }

    /* renamed from: div-VKZWuLQ  reason: not valid java name */
    private static final long m1328divVKZWuLQ(int i, long j) {
        return UByte$$ExternalSyntheticBackport0.m$1(ULong.m1404constructorimpl(((long) i) & 4294967295L), j);
    }

    /* renamed from: rem-7apg3OU  reason: not valid java name */
    private static final int m1355rem7apg3OU(int i, byte b) {
        return UByte$$ExternalSyntheticBackport0.m(i, m1325constructorimpl(b & 255));
    }

    /* renamed from: rem-xj2QHRw  reason: not valid java name */
    private static final int m1358remxj2QHRw(int i, short s) {
        return UByte$$ExternalSyntheticBackport0.m(i, m1325constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: rem-WZ4Q5Ns  reason: not valid java name */
    private static final int m1357remWZ4Q5Ns(int i, int i2) {
        return UnsignedKt.m1582uintRemainderJ1ME1BU(i, i2);
    }

    /* renamed from: rem-VKZWuLQ  reason: not valid java name */
    private static final long m1356remVKZWuLQ(int i, long j) {
        return UByte$$ExternalSyntheticBackport0.m(ULong.m1404constructorimpl(((long) i) & 4294967295L), j);
    }

    /* renamed from: floorDiv-7apg3OU  reason: not valid java name */
    private static final int m1333floorDiv7apg3OU(int i, byte b) {
        return UByte$$ExternalSyntheticBackport0.m$1(i, m1325constructorimpl(b & 255));
    }

    /* renamed from: floorDiv-xj2QHRw  reason: not valid java name */
    private static final int m1336floorDivxj2QHRw(int i, short s) {
        return UByte$$ExternalSyntheticBackport0.m$1(i, m1325constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: floorDiv-WZ4Q5Ns  reason: not valid java name */
    private static final int m1335floorDivWZ4Q5Ns(int i, int i2) {
        return UByte$$ExternalSyntheticBackport0.m$1(i, i2);
    }

    /* renamed from: floorDiv-VKZWuLQ  reason: not valid java name */
    private static final long m1334floorDivVKZWuLQ(int i, long j) {
        return UByte$$ExternalSyntheticBackport0.m$1(ULong.m1404constructorimpl(((long) i) & 4294967295L), j);
    }

    /* renamed from: mod-7apg3OU  reason: not valid java name */
    private static final byte m1344mod7apg3OU(int i, byte b) {
        return UByte.m1248constructorimpl((byte) UByte$$ExternalSyntheticBackport0.m(i, m1325constructorimpl(b & 255)));
    }

    /* renamed from: mod-xj2QHRw  reason: not valid java name */
    private static final short m1347modxj2QHRw(int i, short s) {
        return UShort.m1511constructorimpl((short) UByte$$ExternalSyntheticBackport0.m(i, m1325constructorimpl(s & UShort.MAX_VALUE)));
    }

    /* renamed from: mod-WZ4Q5Ns  reason: not valid java name */
    private static final int m1346modWZ4Q5Ns(int i, int i2) {
        return UByte$$ExternalSyntheticBackport0.m(i, i2);
    }

    /* renamed from: mod-VKZWuLQ  reason: not valid java name */
    private static final long m1345modVKZWuLQ(int i, long j) {
        return UByte$$ExternalSyntheticBackport0.m(ULong.m1404constructorimpl(((long) i) & 4294967295L), j);
    }

    /* renamed from: inc-pVg5ArA  reason: not valid java name */
    private static final int m1338incpVg5ArA(int i) {
        return m1325constructorimpl(i + 1);
    }

    /* renamed from: dec-pVg5ArA  reason: not valid java name */
    private static final int m1326decpVg5ArA(int i) {
        return m1325constructorimpl(i - 1);
    }

    /* renamed from: rangeTo-WZ4Q5Ns  reason: not valid java name */
    private static final UIntRange m1353rangeToWZ4Q5Ns(int i, int i2) {
        return new UIntRange(i, i2, (DefaultConstructorMarker) null);
    }

    /* renamed from: rangeUntil-WZ4Q5Ns  reason: not valid java name */
    private static final UIntRange m1354rangeUntilWZ4Q5Ns(int i, int i2) {
        return URangesKt.m2495untilJ1ME1BU(i, i2);
    }

    /* renamed from: shl-pVg5ArA  reason: not valid java name */
    private static final int m1359shlpVg5ArA(int i, int i2) {
        return m1325constructorimpl(i << i2);
    }

    /* renamed from: shr-pVg5ArA  reason: not valid java name */
    private static final int m1360shrpVg5ArA(int i, int i2) {
        return m1325constructorimpl(i >>> i2);
    }

    /* renamed from: and-WZ4Q5Ns  reason: not valid java name */
    private static final int m1318andWZ4Q5Ns(int i, int i2) {
        return m1325constructorimpl(i & i2);
    }

    /* renamed from: or-WZ4Q5Ns  reason: not valid java name */
    private static final int m1348orWZ4Q5Ns(int i, int i2) {
        return m1325constructorimpl(i | i2);
    }

    /* renamed from: xor-WZ4Q5Ns  reason: not valid java name */
    private static final int m1376xorWZ4Q5Ns(int i, int i2) {
        return m1325constructorimpl(i ^ i2);
    }

    /* renamed from: inv-pVg5ArA  reason: not valid java name */
    private static final int m1339invpVg5ArA(int i) {
        return m1325constructorimpl(~i);
    }

    /* renamed from: toUByte-w2LRezQ  reason: not valid java name */
    private static final byte m1372toUBytew2LRezQ(int i) {
        return UByte.m1248constructorimpl((byte) i);
    }

    /* renamed from: toUShort-Mh2AYeg  reason: not valid java name */
    private static final short m1375toUShortMh2AYeg(int i) {
        return UShort.m1511constructorimpl((short) i);
    }

    /* renamed from: toULong-s-VKNKU  reason: not valid java name */
    private static final long m1374toULongsVKNKU(int i) {
        return ULong.m1404constructorimpl(((long) i) & 4294967295L);
    }

    /* renamed from: toFloat-impl  reason: not valid java name */
    private static final float m1367toFloatimpl(int i) {
        return (float) UnsignedKt.uintToDouble(i);
    }

    /* renamed from: toDouble-impl  reason: not valid java name */
    private static final double m1366toDoubleimpl(int i) {
        return UnsignedKt.uintToDouble(i);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1371toStringimpl(int i) {
        return String.valueOf(((long) i) & 4294967295L);
    }

    public String toString() {
        return m1371toStringimpl(this.data);
    }
}
