package com.github.barteksc.pdfviewer.source;

import android.content.Context;
import com.github.barteksc.pdfviewer.util.Util;
import io.legere.pdfiumandroid.PdfDocument;
import io.legere.pdfiumandroid.PdfiumCore;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamSource implements DocumentSource {
    private InputStream inputStream;

    public InputStreamSource(InputStream inputStream2) {
        this.inputStream = inputStream2;
    }

    public PdfDocument createDocument(Context context, PdfiumCore pdfiumCore, String str) throws IOException {
        return pdfiumCore.newDocument(Util.toByteArray(this.inputStream), str);
    }
}
