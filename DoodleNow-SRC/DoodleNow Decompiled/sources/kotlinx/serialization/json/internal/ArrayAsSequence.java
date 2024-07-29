package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0002J\u0018\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH\u0016J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lkotlinx/serialization/json/internal/ArrayAsSequence;", "", "buffer", "", "([C)V", "getBuffer", "()[C", "length", "", "getLength", "()I", "setLength", "(I)V", "get", "", "index", "subSequence", "startIndex", "endIndex", "substring", "", "trim", "", "newSize", "kotlinx-serialization-json"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: JsonLexer.kt */
public final class ArrayAsSequence implements CharSequence {
    private final char[] buffer;
    private int length;

    public final char[] getBuffer() {
        return this.buffer;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int i) {
        this.length = i;
    }

    public ArrayAsSequence(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "buffer");
        this.buffer = cArr;
        this.length = cArr.length;
    }

    public final /* bridge */ char charAt(int i) {
        return get(i);
    }

    public final /* bridge */ int length() {
        return getLength();
    }

    public char get(int i) {
        return this.buffer[i];
    }

    public CharSequence subSequence(int i, int i2) {
        return StringsKt.concatToString(this.buffer, i, Math.min(i2, length()));
    }

    public final String substring(int i, int i2) {
        return StringsKt.concatToString(this.buffer, i, Math.min(i2, length()));
    }

    public final void trim(int i) {
        setLength(Math.min(this.buffer.length, i));
    }
}
