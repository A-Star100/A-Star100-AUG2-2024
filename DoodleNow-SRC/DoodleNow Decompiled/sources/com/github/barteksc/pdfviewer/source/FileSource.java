package com.github.barteksc.pdfviewer.source;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import io.legere.pdfiumandroid.PdfDocument;
import io.legere.pdfiumandroid.PdfiumCore;
import java.io.File;
import java.io.IOException;

public class FileSource implements DocumentSource {
    private File file;

    public FileSource(File file2) {
        this.file = file2;
    }

    public PdfDocument createDocument(Context context, PdfiumCore pdfiumCore, String str) throws IOException {
        return pdfiumCore.newDocument(ParcelFileDescriptor.open(this.file, 268435456), str);
    }
}
