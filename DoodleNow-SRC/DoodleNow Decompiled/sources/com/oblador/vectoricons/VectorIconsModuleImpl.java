package com.oblador.vectoricons;

import android.graphics.Typeface;
import java.util.HashMap;
import java.util.Map;

public class VectorIconsModuleImpl {
    public static final String NAME = "RNVectorIcons";
    private static final Map<String, Typeface> sTypefaceCache = new HashMap();

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0119 A[SYNTHETIC, Splitter:B:17:0x0119] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getImageForFont(java.lang.String r6, java.lang.String r7, java.lang.Integer r8, java.lang.Integer r9, android.content.Context r10) throws java.io.IOException, java.io.FileNotFoundException {
        /*
            java.io.File r0 = r10.getCacheDir()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r0 = r0.getAbsolutePath()
            r1.append(r0)
            java.lang.String r0 = "/"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            android.content.res.Resources r1 = r10.getResources()
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            float r1 = r1.density
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "@"
            r2.<init>(r3)
            int r3 = (int) r1
            float r4 = (float) r3
            int r4 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r4 != 0) goto L_0x0035
            java.lang.String r3 = java.lang.Integer.toString(r3)
            goto L_0x0039
        L_0x0035:
            java.lang.String r3 = java.lang.Float.toString(r1)
        L_0x0039:
            r2.append(r3)
            java.lang.String r3 = "x"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            int r3 = r8.intValue()
            float r3 = (float) r3
            float r3 = r3 * r1
            int r1 = java.lang.Math.round(r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r6)
            java.lang.String r4 = ":"
            r3.append(r4)
            r3.append(r7)
            r3.append(r4)
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            int r3 = r3.hashCode()
            r4 = 32
            java.lang.String r3 = java.lang.Integer.toString(r3, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            r4.append(r3)
            java.lang.String r0 = "_"
            r4.append(r0)
            int r8 = r8.intValue()
            java.lang.String r8 = java.lang.Integer.toString(r8)
            r4.append(r8)
            r4.append(r2)
            java.lang.String r8 = ".png"
            r4.append(r8)
            java.lang.String r8 = r4.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "file://"
            r0.<init>(r2)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            java.io.File r2 = new java.io.File
            r2.<init>(r8)
            boolean r8 = r2.exists()
            if (r8 == 0) goto L_0x00b4
            return r0
        L_0x00b4:
            com.facebook.react.views.text.ReactFontManager r8 = com.facebook.react.views.text.ReactFontManager.getInstance()
            android.content.res.AssetManager r10 = r10.getAssets()
            r3 = 0
            android.graphics.Typeface r6 = r8.getTypeface(r6, r3, r10)
            android.graphics.Paint r8 = new android.graphics.Paint
            r8.<init>()
            r8.setTypeface(r6)
            int r6 = r9.intValue()
            r8.setColor(r6)
            float r6 = (float) r1
            r8.setTextSize(r6)
            r6 = 1
            r8.setAntiAlias(r6)
            android.graphics.Rect r6 = new android.graphics.Rect
            r6.<init>()
            int r9 = r7.length()
            r8.getTextBounds(r7, r3, r9, r6)
            android.graphics.Paint$FontMetrics r6 = r8.getFontMetrics()
            float r6 = r6.bottom
            int r6 = (int) r6
            int r6 = r1 - r6
            android.graphics.Bitmap$Config r9 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r9 = android.graphics.Bitmap.createBitmap(r1, r1, r9)
            android.graphics.Canvas r10 = new android.graphics.Canvas
            r10.<init>(r9)
            float r1 = (float) r3
            float r6 = (float) r6
            r10.drawText(r7, r1, r6, r8)
            r6 = 0
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ all -> 0x0113 }
            r7.<init>(r2)     // Catch:{ all -> 0x0113 }
            android.graphics.Bitmap$CompressFormat r6 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ all -> 0x0111 }
            r8 = 100
            r9.compress(r6, r8, r7)     // Catch:{ all -> 0x0111 }
            r7.flush()     // Catch:{ all -> 0x0111 }
            r7.close()     // Catch:{ all -> 0x0111 }
            return r0
        L_0x0111:
            r6 = move-exception
            goto L_0x0117
        L_0x0113:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
        L_0x0117:
            if (r7 == 0) goto L_0x0121
            r7.close()     // Catch:{ IOException -> 0x011d }
            goto L_0x0121
        L_0x011d:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0121:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oblador.vectoricons.VectorIconsModuleImpl.getImageForFont(java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, android.content.Context):java.lang.String");
    }
}
