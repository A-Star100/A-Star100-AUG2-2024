package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\n\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000bH\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\fH\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlinx/serialization/json/internal/ComposerForUnsignedNumbers;", "Lkotlinx/serialization/json/internal/Composer;", "writer", "Lkotlinx/serialization/json/internal/JsonWriter;", "forceQuoting", "", "(Lkotlinx/serialization/json/internal/JsonWriter;Z)V", "print", "", "v", "", "", "", "", "kotlinx-serialization-json"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Composers.kt */
public final class ComposerForUnsignedNumbers extends Composer {
    private final boolean forceQuoting;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposerForUnsignedNumbers(JsonWriter jsonWriter, boolean z) {
        super(jsonWriter);
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        this.forceQuoting = z;
    }

    public void print(int i) {
        boolean z = this.forceQuoting;
        int r2 = UInt.m1325constructorimpl(i);
        if (z) {
            printQuoted(UByte$$ExternalSyntheticBackport0.m(r2, 10));
        } else {
            print(UByte$$ExternalSyntheticBackport0.m(r2, 10));
        }
    }

    public void print(long j) {
        boolean z = this.forceQuoting;
        long r2 = ULong.m1404constructorimpl(j);
        if (z) {
            printQuoted(UByte$$ExternalSyntheticBackport0.m$1(r2, 10));
        } else {
            print(UByte$$ExternalSyntheticBackport0.m$1(r2, 10));
        }
    }

    public void print(byte b) {
        boolean z = this.forceQuoting;
        String r2 = UByte.m1292toStringimpl(UByte.m1248constructorimpl(b));
        if (z) {
            printQuoted(r2);
        } else {
            print(r2);
        }
    }

    public void print(short s) {
        boolean z = this.forceQuoting;
        String r2 = UShort.m1555toStringimpl(UShort.m1511constructorimpl(s));
        if (z) {
            printQuoted(r2);
        } else {
            print(r2);
        }
    }
}
