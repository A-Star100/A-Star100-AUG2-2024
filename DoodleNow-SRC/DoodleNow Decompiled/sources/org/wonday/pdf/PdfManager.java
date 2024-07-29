package org.wonday.pdf;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.RNPDFPdfViewManagerDelegate;
import com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface;

@ReactModule(name = "RNPDFPdfView")
public class PdfManager extends SimpleViewManager<PdfView> implements RNPDFPdfViewManagerInterface<PdfView> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String REACT_CLASS = "RNPDFPdfView";
    private Context context;
    private final ViewManagerDelegate<PdfView> mDelegate = new RNPDFPdfViewManagerDelegate(this);
    private PdfView pdfView;

    /* access modifiers changed from: protected */
    public ViewManagerDelegate<PdfView> getDelegate() {
        return this.mDelegate;
    }

    public String getName() {
        return REACT_CLASS;
    }

    public void onDropViewInstance(PdfView pdfView2) {
    }

    public void setEnableRTL(PdfView pdfView2, boolean z) {
    }

    public void setShowsHorizontalScrollIndicator(PdfView pdfView2, boolean z) {
    }

    public void setShowsVerticalScrollIndicator(PdfView pdfView2, boolean z) {
    }

    public PdfManager() {
    }

    public PdfManager(ReactApplicationContext reactApplicationContext) {
        this.context = reactApplicationContext;
    }

    public PdfView createViewInstance(ThemedReactContext themedReactContext) {
        PdfView pdfView2 = new PdfView(themedReactContext, (AttributeSet) null);
        this.pdfView = pdfView2;
        return pdfView2;
    }

    @ReactProp(name = "path")
    public void setPath(PdfView pdfView2, String str) {
        pdfView2.setPath(str);
    }

    @ReactProp(name = "page")
    public void setPage(PdfView pdfView2, int i) {
        pdfView2.setPage(i);
    }

    @ReactProp(name = "scale")
    public void setScale(PdfView pdfView2, float f) {
        pdfView2.setScale(f);
    }

    @ReactProp(name = "minScale")
    public void setMinScale(PdfView pdfView2, float f) {
        pdfView2.setMinScale(f);
    }

    @ReactProp(name = "maxScale")
    public void setMaxScale(PdfView pdfView2, float f) {
        pdfView2.setMaxScale(f);
    }

    @ReactProp(name = "horizontal")
    public void setHorizontal(PdfView pdfView2, boolean z) {
        pdfView2.setHorizontal(z);
    }

    @ReactProp(name = "spacing")
    public void setSpacing(PdfView pdfView2, int i) {
        pdfView2.setSpacing(i);
    }

    @ReactProp(name = "password")
    public void setPassword(PdfView pdfView2, String str) {
        pdfView2.setPassword(str);
    }

    @ReactProp(name = "enableAntialiasing")
    public void setEnableAntialiasing(PdfView pdfView2, boolean z) {
        pdfView2.setEnableAntialiasing(z);
    }

    @ReactProp(name = "enableAnnotationRendering")
    public void setEnableAnnotationRendering(PdfView pdfView2, boolean z) {
        pdfView2.setEnableAnnotationRendering(z);
    }

    @ReactProp(name = "enableDoubleTapZoom")
    public void setEnableDoubleTapZoom(PdfView pdfView2, boolean z) {
        pdfView2.setEnableDoubleTapZoom(z);
    }

    @ReactProp(name = "enablePaging")
    public void setEnablePaging(PdfView pdfView2, boolean z) {
        pdfView2.setEnablePaging(z);
    }

    @ReactProp(name = "fitPolicy")
    public void setFitPolicy(PdfView pdfView2, int i) {
        pdfView2.setFitPolicy(i);
    }

    @ReactProp(name = "singlePage")
    public void setSinglePage(PdfView pdfView2, boolean z) {
        pdfView2.setSinglePage(z);
    }

    public void setNativePage(PdfView pdfView2, int i) {
        this.pdfView.setPage(i);
    }

    public void receiveCommand(PdfView pdfView2, String str, ReadableArray readableArray) {
        Assertions.assertNotNull(pdfView2);
        if ("setNativePage".equals(str)) {
            Assertions.assertNotNull(readableArray);
            setNativePage(pdfView2, readableArray.getInt(0));
        }
    }

    public void onAfterUpdateTransaction(PdfView pdfView2) {
        super.onAfterUpdateTransaction(pdfView2);
        pdfView2.drawPdf();
    }
}
