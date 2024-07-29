package com.onesignal.common;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0003J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tH\u0002J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t¨\u0006\u0012"}, d2 = {"Lcom/onesignal/common/ViewUtils;", "", "()V", "dpToPx", "", "dp", "getCutoutAndStatusBarInsets", "", "activity", "Landroid/app/Activity;", "getDisplaySizeY", "getFullbleedWindowWidth", "getWindowHeight", "getWindowHeightAPI23Plus", "getWindowHeightLollipop", "getWindowVisibleDisplayFrame", "Landroid/graphics/Rect;", "getWindowWidth", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ViewUtils.kt */
public final class ViewUtils {
    public static final ViewUtils INSTANCE = new ViewUtils();

    private ViewUtils() {
    }

    public final int dpToPx(int i) {
        return (int) (((float) i) * Resources.getSystem().getDisplayMetrics().density);
    }

    public final int getWindowHeight(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return getWindowHeightAPI23Plus(activity);
    }

    private final int getDisplaySizeY(Activity activity) {
        Point point = new Point();
        activity.getWindowManager().getDefaultDisplay().getSize(point);
        return point.y;
    }

    private final int getWindowHeightAPI23Plus(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "activity.window.decorView");
        WindowInsets rootWindowInsets = decorView.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return decorView.getHeight();
        }
        return (decorView.getHeight() - rootWindowInsets.getStableInsetBottom()) - rootWindowInsets.getStableInsetTop();
    }

    private final int getWindowHeightLollipop(Activity activity) {
        if (activity.getResources().getConfiguration().orientation == 2) {
            return getWindowVisibleDisplayFrame(activity).height();
        }
        return getDisplaySizeY(activity);
    }

    private final Rect getWindowVisibleDisplayFrame(Activity activity) {
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect;
    }

    public final int[] getCutoutAndStatusBarInsets(Activity activity) {
        float f;
        float f2;
        DisplayCutout m;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Rect windowVisibleDisplayFrame = getWindowVisibleDisplayFrame(activity);
        View findViewById = activity.getWindow().findViewById(16908290);
        float top = ((float) (windowVisibleDisplayFrame.top - findViewById.getTop())) / Resources.getSystem().getDisplayMetrics().density;
        float bottom = ((float) (findViewById.getBottom() - windowVisibleDisplayFrame.bottom)) / Resources.getSystem().getDisplayMetrics().density;
        if (Build.VERSION.SDK_INT != 29 || (m = activity.getWindowManager().getDefaultDisplay().getCutout()) == null) {
            f2 = 0.0f;
            f = 0.0f;
        } else {
            f2 = ((float) m.getSafeInsetRight()) / Resources.getSystem().getDisplayMetrics().density;
            f = ((float) m.getSafeInsetLeft()) / Resources.getSystem().getDisplayMetrics().density;
        }
        return new int[]{MathKt.roundToInt(top), MathKt.roundToInt(bottom), MathKt.roundToInt(f2), MathKt.roundToInt(f)};
    }

    public final int getFullbleedWindowWidth(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        View decorView = activity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "activity.window.decorView");
        return decorView.getWidth();
    }

    public final int getWindowWidth(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return getWindowVisibleDisplayFrame(activity).width();
    }
}
