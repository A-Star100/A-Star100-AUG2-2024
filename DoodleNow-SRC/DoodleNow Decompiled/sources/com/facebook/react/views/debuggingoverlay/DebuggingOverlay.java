package com.facebook.react.views.debuggingoverlay;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.facebook.react.bridge.UiThreadUtil;
import com.google.android.exoplayer2.ExoPlayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DebuggingOverlay extends View {
    private final Paint mHighlightedElementsPaint;
    private List<RectF> mHighlightedElementsRectangles;
    private HashMap<Integer, Runnable> mTraceUpdateIdToCleanupRunnableMap = new HashMap<>();
    private final Paint mTraceUpdatePaint;
    private HashMap<Integer, TraceUpdate> mTraceUpdatesToDisplayMap = new HashMap<>();

    public DebuggingOverlay(Context context) {
        super(context);
        Paint paint = new Paint();
        this.mTraceUpdatePaint = paint;
        Paint paint2 = new Paint();
        this.mHighlightedElementsPaint = paint2;
        this.mHighlightedElementsRectangles = new ArrayList();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(6.0f);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(-859248897);
    }

    public void setTraceUpdates(List<TraceUpdate> list) {
        for (TraceUpdate next : list) {
            int id = next.getId();
            if (this.mTraceUpdateIdToCleanupRunnableMap.containsKey(Integer.valueOf(id))) {
                UiThreadUtil.removeOnUiThread(this.mTraceUpdateIdToCleanupRunnableMap.get(Integer.valueOf(id)));
                this.mTraceUpdateIdToCleanupRunnableMap.remove(Integer.valueOf(id));
            }
            this.mTraceUpdatesToDisplayMap.put(Integer.valueOf(id), next);
        }
        invalidate();
    }

    public void setHighlightedElementsRectangles(List<RectF> list) {
        this.mHighlightedElementsRectangles = list;
        invalidate();
    }

    public void clearElementsHighlights() {
        this.mHighlightedElementsRectangles.clear();
        invalidate();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (TraceUpdate next : this.mTraceUpdatesToDisplayMap.values()) {
            this.mTraceUpdatePaint.setColor(next.getColor());
            canvas.drawRect(next.getRectangle(), this.mTraceUpdatePaint);
            int id = next.getId();
            DebuggingOverlay$$ExternalSyntheticLambda0 debuggingOverlay$$ExternalSyntheticLambda0 = new DebuggingOverlay$$ExternalSyntheticLambda0(this, id);
            if (!this.mTraceUpdateIdToCleanupRunnableMap.containsKey(Integer.valueOf(id))) {
                this.mTraceUpdateIdToCleanupRunnableMap.put(Integer.valueOf(id), debuggingOverlay$$ExternalSyntheticLambda0);
                UiThreadUtil.runOnUiThread(debuggingOverlay$$ExternalSyntheticLambda0, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            }
        }
        for (RectF drawRect : this.mHighlightedElementsRectangles) {
            canvas.drawRect(drawRect, this.mHighlightedElementsPaint);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onDraw$0(int i) {
        this.mTraceUpdatesToDisplayMap.remove(Integer.valueOf(i));
        this.mTraceUpdateIdToCleanupRunnableMap.remove(Integer.valueOf(i));
        invalidate();
    }
}
