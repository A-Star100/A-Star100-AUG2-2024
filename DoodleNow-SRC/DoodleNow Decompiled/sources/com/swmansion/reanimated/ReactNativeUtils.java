package com.swmansion.reanimated;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReactNativeUtils {
    private static Method getCornerRadiiMethod;
    private static Field mBorderRadiusField;

    public static class BorderRadii {
        public float bottomLeft;
        public float bottomRight;
        public float full;
        public float topLeft;
        public float topRight;

        public BorderRadii(float f, float f2, float f3, float f4, float f5) {
            this.full = Float.isNaN(f) ? 0.0f : f;
            this.topLeft = Float.isNaN(f2) ? this.full : f2;
            this.topRight = Float.isNaN(f3) ? this.full : f3;
            this.bottomLeft = Float.isNaN(f4) ? this.full : f4;
            this.bottomRight = Float.isNaN(f5) ? this.full : f5;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.swmansion.reanimated.ReactNativeUtils.BorderRadii getBorderRadii(android.view.View r17) {
        /*
            r0 = r17
            android.graphics.drawable.Drawable r1 = r17.getBackground()
            if (r1 == 0) goto L_0x0035
            android.graphics.drawable.Drawable r0 = r17.getBackground()
            boolean r1 = r0 instanceof com.facebook.react.views.view.ReactViewBackgroundDrawable
            if (r1 == 0) goto L_0x008e
            com.facebook.react.views.view.ReactViewBackgroundDrawable r0 = (com.facebook.react.views.view.ReactViewBackgroundDrawable) r0
            com.swmansion.reanimated.ReactNativeUtils$BorderRadii r7 = new com.swmansion.reanimated.ReactNativeUtils$BorderRadii
            float r2 = r0.getFullBorderRadius()
            com.facebook.react.views.view.ReactViewBackgroundDrawable$BorderRadiusLocation r1 = com.facebook.react.views.view.ReactViewBackgroundDrawable.BorderRadiusLocation.TOP_LEFT
            float r3 = r0.getBorderRadius(r1)
            com.facebook.react.views.view.ReactViewBackgroundDrawable$BorderRadiusLocation r1 = com.facebook.react.views.view.ReactViewBackgroundDrawable.BorderRadiusLocation.TOP_RIGHT
            float r4 = r0.getBorderRadius(r1)
            com.facebook.react.views.view.ReactViewBackgroundDrawable$BorderRadiusLocation r1 = com.facebook.react.views.view.ReactViewBackgroundDrawable.BorderRadiusLocation.BOTTOM_LEFT
            float r5 = r0.getBorderRadius(r1)
            com.facebook.react.views.view.ReactViewBackgroundDrawable$BorderRadiusLocation r1 = com.facebook.react.views.view.ReactViewBackgroundDrawable.BorderRadiusLocation.BOTTOM_RIGHT
            float r6 = r0.getBorderRadius(r1)
            r1 = r7
            r1.<init>(r2, r3, r4, r5, r6)
            return r7
        L_0x0035:
            boolean r1 = r0 instanceof com.facebook.react.views.image.ReactImageView
            if (r1 == 0) goto L_0x008e
            java.lang.reflect.Field r1 = mBorderRadiusField     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x008e }
            r2 = 1
            if (r1 != 0) goto L_0x004b
            java.lang.Class<com.facebook.react.views.image.ReactImageView> r1 = com.facebook.react.views.image.ReactImageView.class
            java.lang.String r3 = "mBorderRadius"
            java.lang.reflect.Field r1 = r1.getDeclaredField(r3)     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x008e }
            mBorderRadiusField = r1     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x008e }
            r1.setAccessible(r2)     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x008e }
        L_0x004b:
            java.lang.reflect.Field r1 = mBorderRadiusField     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x008e }
            float r1 = r1.getFloat(r0)     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x008e }
            java.lang.reflect.Method r3 = getCornerRadiiMethod     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x008e }
            r4 = 0
            if (r3 != 0) goto L_0x0069
            java.lang.Class<com.facebook.react.views.image.ReactImageView> r3 = com.facebook.react.views.image.ReactImageView.class
            java.lang.String r5 = "getCornerRadii"
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x008e }
            java.lang.Class<float[]> r7 = float[].class
            r6[r4] = r7     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x008e }
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r5, r6)     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x008e }
            getCornerRadiiMethod = r3     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x008e }
            r3.setAccessible(r2)     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x008e }
        L_0x0069:
            boolean r3 = java.lang.Float.isNaN(r1)     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x008e }
            if (r3 == 0) goto L_0x0070
            r1 = 0
        L_0x0070:
            r6 = r1
            r1 = 4
            float[] r1 = new float[r1]     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x008e }
            java.lang.reflect.Method r3 = getCornerRadiiMethod     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x008e }
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x008e }
            r5[r4] = r1     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x008e }
            r3.invoke(r0, r5)     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x008e }
            com.swmansion.reanimated.ReactNativeUtils$BorderRadii r0 = new com.swmansion.reanimated.ReactNativeUtils$BorderRadii     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x008e }
            r7 = r1[r4]     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x008e }
            r8 = r1[r2]     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x008e }
            r2 = 2
            r9 = r1[r2]     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x008e }
            r2 = 3
            r10 = r1[r2]     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x008e }
            r5 = r0
            r5.<init>(r6, r7, r8, r9, r10)     // Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | NullPointerException | InvocationTargetException -> 0x008e }
            return r0
        L_0x008e:
            com.swmansion.reanimated.ReactNativeUtils$BorderRadii r0 = new com.swmansion.reanimated.ReactNativeUtils$BorderRadii
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r11 = r0
            r11.<init>(r12, r13, r14, r15, r16)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.reanimated.ReactNativeUtils.getBorderRadii(android.view.View):com.swmansion.reanimated.ReactNativeUtils$BorderRadii");
    }
}
