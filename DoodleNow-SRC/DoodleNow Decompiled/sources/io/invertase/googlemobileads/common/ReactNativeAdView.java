package io.invertase.googlemobileads.common;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import java.util.List;

public class ReactNativeAdView extends FrameLayout {
    private boolean isFluid;
    private boolean manualImpressionsEnabled;
    private final Runnable measureAndLayout = new ReactNativeAdView$$ExternalSyntheticLambda0(this);
    private boolean propsChanged;
    private AdRequest request;
    private List<AdSize> sizes;
    private String unitId;

    public boolean getIsFluid() {
        return this.isFluid;
    }

    public boolean getManualImpressionsEnabled() {
        return this.manualImpressionsEnabled;
    }

    public boolean getPropsChanged() {
        return this.propsChanged;
    }

    public AdRequest getRequest() {
        return this.request;
    }

    public List<AdSize> getSizes() {
        return this.sizes;
    }

    public String getUnitId() {
        return this.unitId;
    }

    public void setIsFluid(boolean z) {
        this.isFluid = z;
    }

    public void setManualImpressionsEnabled(boolean z) {
        this.manualImpressionsEnabled = z;
    }

    public void setPropsChanged(boolean z) {
        this.propsChanged = z;
    }

    public void setRequest(AdRequest adRequest) {
        this.request = adRequest;
    }

    public void setSizes(List<AdSize> list) {
        this.sizes = list;
    }

    public void setUnitId(String str) {
        this.unitId = str;
    }

    public void requestLayout() {
        super.requestLayout();
        post(this.measureAndLayout);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        int i;
        if (this.isFluid) {
            i = View.MeasureSpec.makeMeasureSpec(0, 0);
        } else {
            i = View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824);
        }
        measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), i);
        layout(getLeft(), getTop(), getRight(), getTop() + getHeight());
    }

    public ReactNativeAdView(Context context) {
        super(context);
    }
}
