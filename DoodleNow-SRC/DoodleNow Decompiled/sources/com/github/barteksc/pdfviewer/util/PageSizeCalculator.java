package com.github.barteksc.pdfviewer.util;

import android.util.SizeF;
import io.legere.pdfiumandroid.util.Size;

public class PageSizeCalculator {
    private boolean fitEachPage;
    private FitPolicy fitPolicy;
    private float heightRatio;
    private SizeF optimalMaxHeightPageSize;
    private SizeF optimalMaxWidthPageSize;
    private final Size originalMaxHeightPageSize;
    private final Size originalMaxWidthPageSize;
    private final Size viewSize;
    private float widthRatio;

    public SizeF getOptimalMaxHeightPageSize() {
        return this.optimalMaxHeightPageSize;
    }

    public SizeF getOptimalMaxWidthPageSize() {
        return this.optimalMaxWidthPageSize;
    }

    public PageSizeCalculator(FitPolicy fitPolicy2, Size size, Size size2, Size size3, boolean z) {
        this.fitPolicy = fitPolicy2;
        this.originalMaxWidthPageSize = size;
        this.originalMaxHeightPageSize = size2;
        this.viewSize = size3;
        this.fitEachPage = z;
        calculateMaxPages();
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0068  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.util.SizeF calculate(io.legere.pdfiumandroid.util.Size r4, boolean r5, boolean r6) {
        /*
            r3 = this;
            int r0 = r4.getWidth()
            if (r0 <= 0) goto L_0x006d
            int r0 = r4.getHeight()
            if (r0 > 0) goto L_0x000d
            goto L_0x006d
        L_0x000d:
            r0 = 2
            if (r5 == 0) goto L_0x0028
            if (r6 != 0) goto L_0x0028
            boolean r5 = r3.fitEachPage
            if (r5 == 0) goto L_0x001e
            io.legere.pdfiumandroid.util.Size r5 = r3.viewSize
            int r5 = r5.getWidth()
        L_0x001c:
            float r5 = (float) r5
            goto L_0x003b
        L_0x001e:
            int r5 = r4.getWidth()
            int r5 = r5 / r0
            float r5 = (float) r5
            float r6 = r3.widthRatio
        L_0x0026:
            float r5 = r5 * r6
            goto L_0x003b
        L_0x0028:
            boolean r5 = r3.fitEachPage
            if (r5 == 0) goto L_0x0033
            io.legere.pdfiumandroid.util.Size r5 = r3.viewSize
            int r5 = r5.getWidth()
            goto L_0x001c
        L_0x0033:
            int r5 = r4.getWidth()
            float r5 = (float) r5
            float r6 = r3.widthRatio
            goto L_0x0026
        L_0x003b:
            boolean r6 = r3.fitEachPage
            if (r6 == 0) goto L_0x0047
            io.legere.pdfiumandroid.util.Size r6 = r3.viewSize
            int r6 = r6.getHeight()
            float r6 = (float) r6
            goto L_0x004f
        L_0x0047:
            int r6 = r4.getHeight()
            float r6 = (float) r6
            float r1 = r3.heightRatio
            float r6 = r6 * r1
        L_0x004f:
            int[] r1 = com.github.barteksc.pdfviewer.util.PageSizeCalculator.AnonymousClass1.$SwitchMap$com$github$barteksc$pdfviewer$util$FitPolicy
            com.github.barteksc.pdfviewer.util.FitPolicy r2 = r3.fitPolicy
            int r2 = r2.ordinal()
            r1 = r1[r2]
            r2 = 1
            if (r1 == r2) goto L_0x0068
            if (r1 == r0) goto L_0x0063
            android.util.SizeF r4 = r3.fitWidth(r4, r5)
            return r4
        L_0x0063:
            android.util.SizeF r4 = r3.fitBoth(r4, r5, r6)
            return r4
        L_0x0068:
            android.util.SizeF r4 = r3.fitHeight(r4, r6)
            return r4
        L_0x006d:
            android.util.SizeF r4 = new android.util.SizeF
            r5 = 0
            r4.<init>(r5, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.barteksc.pdfviewer.util.PageSizeCalculator.calculate(io.legere.pdfiumandroid.util.Size, boolean, boolean):android.util.SizeF");
    }

    /* renamed from: com.github.barteksc.pdfviewer.util.PageSizeCalculator$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$github$barteksc$pdfviewer$util$FitPolicy;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.github.barteksc.pdfviewer.util.FitPolicy[] r0 = com.github.barteksc.pdfviewer.util.FitPolicy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$github$barteksc$pdfviewer$util$FitPolicy = r0
                com.github.barteksc.pdfviewer.util.FitPolicy r1 = com.github.barteksc.pdfviewer.util.FitPolicy.HEIGHT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$github$barteksc$pdfviewer$util$FitPolicy     // Catch:{ NoSuchFieldError -> 0x001d }
                com.github.barteksc.pdfviewer.util.FitPolicy r1 = com.github.barteksc.pdfviewer.util.FitPolicy.BOTH     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.github.barteksc.pdfviewer.util.PageSizeCalculator.AnonymousClass1.<clinit>():void");
        }
    }

    private void calculateMaxPages() {
        int i = AnonymousClass1.$SwitchMap$com$github$barteksc$pdfviewer$util$FitPolicy[this.fitPolicy.ordinal()];
        if (i == 1) {
            SizeF fitHeight = fitHeight(this.originalMaxHeightPageSize, (float) this.viewSize.getHeight());
            this.optimalMaxHeightPageSize = fitHeight;
            this.heightRatio = fitHeight.getHeight() / ((float) this.originalMaxHeightPageSize.getHeight());
            Size size = this.originalMaxWidthPageSize;
            this.optimalMaxWidthPageSize = fitHeight(size, ((float) size.getHeight()) * this.heightRatio);
        } else if (i != 2) {
            SizeF fitWidth = fitWidth(this.originalMaxWidthPageSize, (float) this.viewSize.getWidth());
            this.optimalMaxWidthPageSize = fitWidth;
            this.widthRatio = fitWidth.getWidth() / ((float) this.originalMaxWidthPageSize.getWidth());
            Size size2 = this.originalMaxHeightPageSize;
            this.optimalMaxHeightPageSize = fitWidth(size2, ((float) size2.getWidth()) * this.widthRatio);
        } else {
            float width = fitBoth(this.originalMaxWidthPageSize, (float) this.viewSize.getWidth(), (float) this.viewSize.getHeight()).getWidth() / ((float) this.originalMaxWidthPageSize.getWidth());
            Size size3 = this.originalMaxHeightPageSize;
            SizeF fitBoth = fitBoth(size3, ((float) size3.getWidth()) * width, (float) this.viewSize.getHeight());
            this.optimalMaxHeightPageSize = fitBoth;
            this.heightRatio = fitBoth.getHeight() / ((float) this.originalMaxHeightPageSize.getHeight());
            SizeF fitBoth2 = fitBoth(this.originalMaxWidthPageSize, (float) this.viewSize.getWidth(), ((float) this.originalMaxWidthPageSize.getHeight()) * this.heightRatio);
            this.optimalMaxWidthPageSize = fitBoth2;
            this.widthRatio = fitBoth2.getWidth() / ((float) this.originalMaxWidthPageSize.getWidth());
        }
    }

    private SizeF fitWidth(Size size, float f) {
        return new SizeF(f, (float) Math.floor((double) (f / (((float) size.getWidth()) / ((float) size.getHeight())))));
    }

    private SizeF fitHeight(Size size, float f) {
        return new SizeF((float) Math.floor((double) (f / (((float) size.getHeight()) / ((float) size.getWidth())))), f);
    }

    private SizeF fitBoth(Size size, float f, float f2) {
        float width = ((float) size.getWidth()) / ((float) size.getHeight());
        float floor = (float) Math.floor((double) (f / width));
        if (floor > f2) {
            f = (float) Math.floor((double) (width * f2));
        } else {
            f2 = floor;
        }
        return new SizeF(f, f2);
    }
}
