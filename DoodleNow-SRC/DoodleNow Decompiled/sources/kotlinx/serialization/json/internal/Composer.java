package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\u0010\f\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0010\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0012J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0013H\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0014H\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0015H\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0016H\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0017H\u0016J\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0018J\b\u0010\u001b\u001a\u00020\rH\u0016J\b\u0010\u001c\u001a\u00020\rH\u0016R\u0010\u0010\u0002\u001a\u00020\u00038\u0000X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u001d"}, d2 = {"Lkotlinx/serialization/json/internal/Composer;", "", "writer", "Lkotlinx/serialization/json/internal/JsonWriter;", "(Lkotlinx/serialization/json/internal/JsonWriter;)V", "<set-?>", "", "writingFirst", "getWritingFirst", "()Z", "setWritingFirst", "(Z)V", "indent", "", "nextItem", "print", "v", "", "", "", "", "", "", "", "", "printQuoted", "value", "space", "unIndent", "kotlinx-serialization-json"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Composers.kt */
public class Composer {
    public final JsonWriter writer;
    private boolean writingFirst = true;

    public final boolean getWritingFirst() {
        return this.writingFirst;
    }

    public void indent() {
        this.writingFirst = true;
    }

    public void nextItem() {
        this.writingFirst = false;
    }

    /* access modifiers changed from: protected */
    public final void setWritingFirst(boolean z) {
        this.writingFirst = z;
    }

    public void space() {
    }

    public void unIndent() {
    }

    public Composer(JsonWriter jsonWriter) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        this.writer = jsonWriter;
    }

    public final void print(char c) {
        this.writer.writeChar(c);
    }

    public final void print(String str) {
        Intrinsics.checkNotNullParameter(str, "v");
        this.writer.write(str);
    }

    public void print(float f) {
        this.writer.write(String.valueOf(f));
    }

    public void print(double d) {
        this.writer.write(String.valueOf(d));
    }

    public void print(byte b) {
        this.writer.writeLong((long) b);
    }

    public void print(short s) {
        this.writer.writeLong((long) s);
    }

    public void print(int i) {
        this.writer.writeLong((long) i);
    }

    public void print(long j) {
        this.writer.writeLong(j);
    }

    public void print(boolean z) {
        this.writer.write(String.valueOf(z));
    }

    public final void printQuoted(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.writer.writeQuoted(str);
    }
}
