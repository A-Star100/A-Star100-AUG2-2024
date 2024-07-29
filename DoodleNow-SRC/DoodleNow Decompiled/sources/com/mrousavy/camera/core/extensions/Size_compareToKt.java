package com.mrousavy.camera.core.extensions;

import android.util.Size;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¨\u0006\u0004"}, d2 = {"compareTo", "", "Landroid/util/Size;", "other", "react-native-vision-camera_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: Size+compareTo.kt */
public final class Size_compareToKt {
    public static final int compareTo(Size size, Size size2) {
        Intrinsics.checkNotNullParameter(size, "<this>");
        Intrinsics.checkNotNullParameter(size2, "other");
        return Intrinsics.compare(size.getWidth() * size.getHeight(), size2.getWidth() * size2.getHeight());
    }
}
