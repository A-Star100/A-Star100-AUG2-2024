package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Objects;
import com.facebook.drawee.drawable.ScalingUtils;
import javax.annotation.Nullable;

public class ScaleTypeDrawable extends ForwardingDrawable {
    @Nullable
    Matrix mDrawMatrix;
    @Nullable
    PointF mFocusPoint = null;
    ScalingUtils.ScaleType mScaleType;
    @Nullable
    Object mScaleTypeState;
    private Matrix mTempMatrix = new Matrix();
    int mUnderlyingHeight = 0;
    int mUnderlyingWidth = 0;

    @Nullable
    public PointF getFocusPoint() {
        return this.mFocusPoint;
    }

    public ScalingUtils.ScaleType getScaleType() {
        return this.mScaleType;
    }

    public ScaleTypeDrawable(@Nullable Drawable drawable, ScalingUtils.ScaleType scaleType) {
        super(drawable);
        this.mScaleType = scaleType;
    }

    public ScaleTypeDrawable(@Nullable Drawable drawable, ScalingUtils.ScaleType scaleType, @Nullable PointF pointF) {
        super(drawable);
        this.mScaleType = scaleType;
        this.mFocusPoint = pointF;
    }

    @Nullable
    public Drawable setCurrent(@Nullable Drawable drawable) {
        Drawable current = super.setCurrent(drawable);
        configureBounds();
        return current;
    }

    public void setScaleType(ScalingUtils.ScaleType scaleType) {
        if (!Objects.equal(this.mScaleType, scaleType)) {
            this.mScaleType = scaleType;
            this.mScaleTypeState = null;
            configureBounds();
            invalidateSelf();
        }
    }

    public void setFocusPoint(@Nullable PointF pointF) {
        if (!Objects.equal(this.mFocusPoint, pointF)) {
            if (pointF == null) {
                this.mFocusPoint = null;
            } else {
                if (this.mFocusPoint == null) {
                    this.mFocusPoint = new PointF();
                }
                this.mFocusPoint.set(pointF);
            }
            configureBounds();
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        configureBoundsIfUnderlyingChanged();
        if (this.mDrawMatrix != null) {
            int save = canvas.save();
            canvas.clipRect(getBounds());
            canvas.concat(this.mDrawMatrix);
            super.draw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        super.draw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        configureBounds();
    }

    private void configureBoundsIfUnderlyingChanged() {
        ScalingUtils.ScaleType scaleType = this.mScaleType;
        boolean z = false;
        if (scaleType instanceof ScalingUtils.StatefulScaleType) {
            Object state = ((ScalingUtils.StatefulScaleType) scaleType).getState();
            if (state == null || !state.equals(this.mScaleTypeState)) {
                z = true;
            }
            this.mScaleTypeState = state;
        }
        Drawable current = getCurrent();
        if (current != null) {
            if (this.mUnderlyingWidth != current.getIntrinsicWidth() || this.mUnderlyingHeight != current.getIntrinsicHeight() || z) {
                configureBounds();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void configureBounds() {
        float f;
        Drawable current = getCurrent();
        if (current == null) {
            this.mUnderlyingHeight = 0;
            this.mUnderlyingWidth = 0;
            this.mDrawMatrix = null;
            return;
        }
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.mUnderlyingWidth = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.mUnderlyingHeight = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (this.mScaleType == ScalingUtils.ScaleType.FIT_XY) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            ScalingUtils.ScaleType scaleType = this.mScaleType;
            Matrix matrix = this.mTempMatrix;
            PointF pointF = this.mFocusPoint;
            float f2 = pointF != null ? pointF.x : 0.5f;
            PointF pointF2 = this.mFocusPoint;
            if (pointF2 != null) {
                f = pointF2.y;
            } else {
                f = 0.5f;
            }
            scaleType.getTransform(matrix, bounds, intrinsicWidth, intrinsicHeight, f2, f);
            this.mDrawMatrix = this.mTempMatrix;
        }
    }

    public void getTransform(Matrix matrix) {
        getParentTransform(matrix);
        configureBoundsIfUnderlyingChanged();
        Matrix matrix2 = this.mDrawMatrix;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
    }
}
