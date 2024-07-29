package androidx.camera.core;

import android.graphics.Matrix;
import android.util.Size;
import androidx.camera.core.ImageAnalysis;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ImageAnalysis$$ExternalSyntheticLambda3 implements ImageAnalysis.Analyzer {
    public final /* synthetic */ ImageAnalysis.Analyzer f$0;

    public /* synthetic */ ImageAnalysis$$ExternalSyntheticLambda3(ImageAnalysis.Analyzer analyzer) {
        this.f$0 = analyzer;
    }

    public final void analyze(ImageProxy imageProxy) {
        this.f$0.analyze(imageProxy);
    }

    public /* synthetic */ Size getDefaultTargetResolution() {
        return ImageAnalysis.Analyzer.CC.$default$getDefaultTargetResolution(this);
    }

    public /* synthetic */ int getTargetCoordinateSystem() {
        return ImageAnalysis.Analyzer.CC.$default$getTargetCoordinateSystem(this);
    }

    public /* synthetic */ void updateTransform(Matrix matrix) {
        ImageAnalysis.Analyzer.CC.$default$updateTransform(this, matrix);
    }
}
