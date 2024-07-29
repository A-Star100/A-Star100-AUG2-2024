package io.legere.pdfiumandroid;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/legere/pdfiumandroid/PdfPasswordException;", "Ljava/io/IOException;", "msg", "", "(Ljava/lang/String;)V", "pdfiumandroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PdfPasswordException.kt */
public final class PdfPasswordException extends IOException {
    public PdfPasswordException() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public PdfPasswordException(String str) {
        super(str);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PdfPasswordException(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }
}
