package org.th317erd.react;

import android.graphics.Typeface;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.views.text.ReactFontManager;
import java.io.File;

class DynamicFontsModule extends ReactContextBaseJavaModule {
    WritableMap response;
    int tempNameCounter = 0;

    public String getName() {
        return "DynamicFonts";
    }

    public DynamicFontsModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void loadFontFromFile(ReadableMap readableMap, Callback callback) {
        if (getCurrentActivity() == null) {
            callback.invoke("Invalid activity");
            return;
        }
        String string = readableMap.hasKey("filePath") ? readableMap.getString("filePath") : null;
        String string2 = readableMap.hasKey("name") ? readableMap.getString("name") : null;
        if (string == null || string.length() == 0) {
            callback.invoke("filePath property empty");
            return;
        }
        File file = new File(string);
        if (!file.exists() || !file.canRead()) {
            callback.invoke("invalid file");
            return;
        }
        try {
            Typeface createFromFile = Typeface.createFromFile(file);
            ReactFontManager.getInstance().setTypeface(string2, createFromFile.getStyle(), createFromFile);
            callback.invoke(null, string2);
        } catch (Throwable th) {
            callback.invoke(th.getMessage());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00f4 A[Catch:{ all -> 0x0135, Exception -> 0x013c }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x010b A[Catch:{ all -> 0x0135, Exception -> 0x013c }] */
    @com.facebook.react.bridge.ReactMethod
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void loadFont(com.facebook.react.bridge.ReadableMap r12, com.facebook.react.bridge.Callback r13) throws java.lang.Exception {
        /*
            r11 = this;
            java.lang.String r0 = "tempFont"
            android.app.Activity r1 = r11.getCurrentActivity()
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0014
            java.lang.Object[] r12 = new java.lang.Object[r2]
            java.lang.String r0 = "Invalid activity"
            r12[r3] = r0
            r13.invoke(r12)
            return
        L_0x0014:
            java.lang.String r4 = "name"
            boolean r5 = r12.hasKey(r4)
            r6 = 0
            if (r5 == 0) goto L_0x0022
            java.lang.String r4 = r12.getString(r4)
            goto L_0x0023
        L_0x0022:
            r4 = r6
        L_0x0023:
            java.lang.String r5 = "data"
            boolean r7 = r12.hasKey(r5)
            if (r7 == 0) goto L_0x0030
            java.lang.String r5 = r12.getString(r5)
            goto L_0x0031
        L_0x0030:
            r5 = r6
        L_0x0031:
            if (r4 == 0) goto L_0x0166
            int r7 = r4.length()
            if (r7 != 0) goto L_0x003b
            goto L_0x0166
        L_0x003b:
            if (r5 == 0) goto L_0x015c
            int r7 = r5.length()
            if (r7 != 0) goto L_0x0045
            goto L_0x015c
        L_0x0045:
            java.lang.String r7 = "data:"
            r8 = 5
            java.lang.String r9 = r5.substring(r3, r8)
            boolean r7 = r7.equalsIgnoreCase(r9)
            java.lang.String r9 = "ttf"
            if (r7 == 0) goto L_0x00ab
            r7 = 44
            int r7 = r5.indexOf(r7)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            int r10 = r7.intValue()
            if (r10 <= 0) goto L_0x00ab
            int r10 = r7.intValue()
            java.lang.String r8 = r5.substring(r8, r10)
            java.lang.String r10 = ";"
            java.lang.String[] r8 = r8.split(r10)
            r8 = r8[r3]
            int r7 = r7.intValue()
            int r7 = r7 + r2
            java.lang.String r5 = r5.substring(r7)
            java.lang.String r7 = "application/x-font-ttf"
            boolean r7 = r7.equalsIgnoreCase(r8)
            if (r7 != 0) goto L_0x00a9
            java.lang.String r7 = "application/x-font-truetype"
            boolean r7 = r7.equalsIgnoreCase(r8)
            if (r7 != 0) goto L_0x00a9
            java.lang.String r7 = "font/ttf"
            boolean r7 = r7.equalsIgnoreCase(r8)
            if (r7 == 0) goto L_0x0096
            goto L_0x00a9
        L_0x0096:
            java.lang.String r7 = "application/x-font-opentype"
            boolean r7 = r7.equalsIgnoreCase(r8)
            if (r7 != 0) goto L_0x00a6
            java.lang.String r7 = "font/opentype"
            boolean r7 = r7.equalsIgnoreCase(r8)
            if (r7 == 0) goto L_0x00ab
        L_0x00a6:
            java.lang.String r7 = "otf"
            goto L_0x00ac
        L_0x00a9:
            r7 = r9
            goto L_0x00ac
        L_0x00ab:
            r7 = r6
        L_0x00ac:
            java.lang.String r8 = "type"
            boolean r10 = r12.hasKey(r8)
            if (r10 == 0) goto L_0x00b8
            java.lang.String r7 = r12.getString(r8)
        L_0x00b8:
            if (r7 != 0) goto L_0x00bb
            goto L_0x00bc
        L_0x00bb:
            r9 = r7
        L_0x00bc:
            r12 = 2
            byte[] r5 = android.util.Base64.decode(r5, r3)     // Catch:{ Exception -> 0x013c }
            java.io.File r7 = new java.io.File     // Catch:{ Exception -> 0x013c }
            java.io.File r1 = r1.getCacheDir()     // Catch:{ Exception -> 0x013c }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013c }
            r8.<init>(r0)     // Catch:{ Exception -> 0x013c }
            int r0 = r11.tempNameCounter     // Catch:{ Exception -> 0x013c }
            int r10 = r0 + 1
            r11.tempNameCounter = r10     // Catch:{ Exception -> 0x013c }
            r8.append(r0)     // Catch:{ Exception -> 0x013c }
            r8.append(r9)     // Catch:{ Exception -> 0x013c }
            java.lang.String r0 = r8.toString()     // Catch:{ Exception -> 0x013c }
            r7.<init>(r1, r0)     // Catch:{ Exception -> 0x013c }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x013c }
            r0.<init>(r7)     // Catch:{ Exception -> 0x013c }
            r0.write(r5)     // Catch:{ all -> 0x0135 }
            r0.close()     // Catch:{ Exception -> 0x013c }
            android.graphics.Typeface r0 = android.graphics.Typeface.createFromFile(r7)     // Catch:{ Exception -> 0x013c }
            boolean r1 = r0.isBold()     // Catch:{ Exception -> 0x013c }
            if (r1 == 0) goto L_0x0105
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013c }
            r1.<init>()     // Catch:{ Exception -> 0x013c }
            r1.append(r4)     // Catch:{ Exception -> 0x013c }
            java.lang.String r5 = "_bold"
            r1.append(r5)     // Catch:{ Exception -> 0x013c }
            java.lang.String r4 = r1.toString()     // Catch:{ Exception -> 0x013c }
        L_0x0105:
            boolean r1 = r0.isItalic()     // Catch:{ Exception -> 0x013c }
            if (r1 == 0) goto L_0x011d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013c }
            r1.<init>()     // Catch:{ Exception -> 0x013c }
            r1.append(r4)     // Catch:{ Exception -> 0x013c }
            java.lang.String r5 = "_italic"
            r1.append(r5)     // Catch:{ Exception -> 0x013c }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x013c }
            r4 = r1
        L_0x011d:
            com.facebook.react.views.text.ReactFontManager r1 = com.facebook.react.views.text.ReactFontManager.getInstance()     // Catch:{ Exception -> 0x013c }
            int r5 = r0.getStyle()     // Catch:{ Exception -> 0x013c }
            r1.setTypeface(r4, r5, r0)     // Catch:{ Exception -> 0x013c }
            r7.delete()     // Catch:{ Exception -> 0x013c }
            java.lang.Object[] r12 = new java.lang.Object[r12]
            r12[r3] = r6
            r12[r2] = r4
            r13.invoke(r12)
            goto L_0x0151
        L_0x0135:
            r1 = move-exception
            r0.close()     // Catch:{ Exception -> 0x013c }
            throw r1     // Catch:{ Exception -> 0x013c }
        L_0x013a:
            r0 = move-exception
            goto L_0x0152
        L_0x013c:
            r0 = move-exception
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ all -> 0x013a }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x013a }
            r1[r3] = r0     // Catch:{ all -> 0x013a }
            r13.invoke(r1)     // Catch:{ all -> 0x013a }
            java.lang.Object[] r12 = new java.lang.Object[r12]
            r12[r3] = r6
            r12[r2] = r4
            r13.invoke(r12)
        L_0x0151:
            return
        L_0x0152:
            java.lang.Object[] r12 = new java.lang.Object[r12]
            r12[r3] = r6
            r12[r2] = r4
            r13.invoke(r12)
            throw r0
        L_0x015c:
            java.lang.Object[] r12 = new java.lang.Object[r2]
            java.lang.String r0 = "Data property empty"
            r12[r3] = r0
            r13.invoke(r12)
            return
        L_0x0166:
            java.lang.Object[] r12 = new java.lang.Object[r2]
            java.lang.String r0 = "Name property empty"
            r12[r3] = r0
            r13.invoke(r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.th317erd.react.DynamicFontsModule.loadFont(com.facebook.react.bridge.ReadableMap, com.facebook.react.bridge.Callback):void");
    }
}
