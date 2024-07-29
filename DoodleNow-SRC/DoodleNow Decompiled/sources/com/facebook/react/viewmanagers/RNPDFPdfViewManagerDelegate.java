package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface;

public class RNPDFPdfViewManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & RNPDFPdfViewManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public RNPDFPdfViewManagerDelegate(U u) {
        super(u);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v17, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v21, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v23, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v25, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v26, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v27, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v28, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v29, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v30, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v31, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v32, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v33, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v34, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v35, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v36, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r5, java.lang.String r6, java.lang.Object r7) {
        /*
            r4 = this;
            r6.hashCode()
            int r0 = r6.hashCode()
            r1 = 0
            r2 = -1
            switch(r0) {
                case -2012158909: goto L_0x00d9;
                case -1790919953: goto L_0x00ce;
                case -1379690984: goto L_0x00c3;
                case -922092170: goto L_0x00b8;
                case -657951334: goto L_0x00ad;
                case -631667225: goto L_0x00a2;
                case 3433103: goto L_0x0097;
                case 3433509: goto L_0x008c;
                case 109250890: goto L_0x007e;
                case 396505670: goto L_0x0070;
                case 902106275: goto L_0x0062;
                case 913503991: goto L_0x0054;
                case 1216985755: goto L_0x0046;
                case 1308044823: goto L_0x0038;
                case 1387629604: goto L_0x002a;
                case 1539343426: goto L_0x001c;
                case 1915931784: goto L_0x000e;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x00e3
        L_0x000e:
            java.lang.String r0 = "showsHorizontalScrollIndicator"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0018
            goto L_0x00e3
        L_0x0018:
            r2 = 16
            goto L_0x00e3
        L_0x001c:
            java.lang.String r0 = "enableDoubleTapZoom"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0026
            goto L_0x00e3
        L_0x0026:
            r2 = 15
            goto L_0x00e3
        L_0x002a:
            java.lang.String r0 = "horizontal"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0034
            goto L_0x00e3
        L_0x0034:
            r2 = 14
            goto L_0x00e3
        L_0x0038:
            java.lang.String r0 = "enableAntialiasing"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0042
            goto L_0x00e3
        L_0x0042:
            r2 = 13
            goto L_0x00e3
        L_0x0046:
            java.lang.String r0 = "password"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0050
            goto L_0x00e3
        L_0x0050:
            r2 = 12
            goto L_0x00e3
        L_0x0054:
            java.lang.String r0 = "singlePage"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x005e
            goto L_0x00e3
        L_0x005e:
            r2 = 11
            goto L_0x00e3
        L_0x0062:
            java.lang.String r0 = "fitPolicy"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x006c
            goto L_0x00e3
        L_0x006c:
            r2 = 10
            goto L_0x00e3
        L_0x0070:
            java.lang.String r0 = "maxScale"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x007a
            goto L_0x00e3
        L_0x007a:
            r2 = 9
            goto L_0x00e3
        L_0x007e:
            java.lang.String r0 = "scale"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0088
            goto L_0x00e3
        L_0x0088:
            r2 = 8
            goto L_0x00e3
        L_0x008c:
            java.lang.String r0 = "path"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0095
            goto L_0x00e3
        L_0x0095:
            r2 = 7
            goto L_0x00e3
        L_0x0097:
            java.lang.String r0 = "page"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x00a0
            goto L_0x00e3
        L_0x00a0:
            r2 = 6
            goto L_0x00e3
        L_0x00a2:
            java.lang.String r0 = "enableRTL"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x00ab
            goto L_0x00e3
        L_0x00ab:
            r2 = 5
            goto L_0x00e3
        L_0x00ad:
            java.lang.String r0 = "enableAnnotationRendering"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x00b6
            goto L_0x00e3
        L_0x00b6:
            r2 = 4
            goto L_0x00e3
        L_0x00b8:
            java.lang.String r0 = "showsVerticalScrollIndicator"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x00c1
            goto L_0x00e3
        L_0x00c1:
            r2 = 3
            goto L_0x00e3
        L_0x00c3:
            java.lang.String r0 = "minScale"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x00cc
            goto L_0x00e3
        L_0x00cc:
            r2 = 2
            goto L_0x00e3
        L_0x00ce:
            java.lang.String r0 = "enablePaging"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x00d7
            goto L_0x00e3
        L_0x00d7:
            r2 = 1
            goto L_0x00e3
        L_0x00d9:
            java.lang.String r0 = "spacing"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x00e2
            goto L_0x00e3
        L_0x00e2:
            r2 = r1
        L_0x00e3:
            r0 = 0
            r3 = 0
            switch(r2) {
                case 0: goto L_0x0202;
                case 1: goto L_0x01f1;
                case 2: goto L_0x01e0;
                case 3: goto L_0x01cf;
                case 4: goto L_0x01be;
                case 5: goto L_0x01ad;
                case 6: goto L_0x019b;
                case 7: goto L_0x018c;
                case 8: goto L_0x017a;
                case 9: goto L_0x0168;
                case 10: goto L_0x0156;
                case 11: goto L_0x0144;
                case 12: goto L_0x0135;
                case 13: goto L_0x0123;
                case 14: goto L_0x0111;
                case 15: goto L_0x00ff;
                case 16: goto L_0x00ed;
                default: goto L_0x00e8;
            }
        L_0x00e8:
            super.setProperty(r5, r6, r7)
            goto L_0x0212
        L_0x00ed:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface r6 = (com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface) r6
            if (r7 != 0) goto L_0x00f4
            goto L_0x00fa
        L_0x00f4:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r1 = r7.booleanValue()
        L_0x00fa:
            r6.setShowsHorizontalScrollIndicator(r5, r1)
            goto L_0x0212
        L_0x00ff:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface r6 = (com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface) r6
            if (r7 != 0) goto L_0x0106
            goto L_0x010c
        L_0x0106:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r1 = r7.booleanValue()
        L_0x010c:
            r6.setEnableDoubleTapZoom(r5, r1)
            goto L_0x0212
        L_0x0111:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface r6 = (com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface) r6
            if (r7 != 0) goto L_0x0118
            goto L_0x011e
        L_0x0118:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r1 = r7.booleanValue()
        L_0x011e:
            r6.setHorizontal(r5, r1)
            goto L_0x0212
        L_0x0123:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface r6 = (com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface) r6
            if (r7 != 0) goto L_0x012a
            goto L_0x0130
        L_0x012a:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r1 = r7.booleanValue()
        L_0x0130:
            r6.setEnableAntialiasing(r5, r1)
            goto L_0x0212
        L_0x0135:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface r6 = (com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface) r6
            if (r7 != 0) goto L_0x013c
            goto L_0x013f
        L_0x013c:
            r0 = r7
            java.lang.String r0 = (java.lang.String) r0
        L_0x013f:
            r6.setPassword(r5, r0)
            goto L_0x0212
        L_0x0144:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface r6 = (com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface) r6
            if (r7 != 0) goto L_0x014b
            goto L_0x0151
        L_0x014b:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r1 = r7.booleanValue()
        L_0x0151:
            r6.setSinglePage(r5, r1)
            goto L_0x0212
        L_0x0156:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface r6 = (com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface) r6
            if (r7 != 0) goto L_0x015d
            goto L_0x0163
        L_0x015d:
            java.lang.Double r7 = (java.lang.Double) r7
            int r1 = r7.intValue()
        L_0x0163:
            r6.setFitPolicy(r5, r1)
            goto L_0x0212
        L_0x0168:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface r6 = (com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface) r6
            if (r7 != 0) goto L_0x016f
            goto L_0x0175
        L_0x016f:
            java.lang.Double r7 = (java.lang.Double) r7
            float r3 = r7.floatValue()
        L_0x0175:
            r6.setMaxScale(r5, r3)
            goto L_0x0212
        L_0x017a:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface r6 = (com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface) r6
            if (r7 != 0) goto L_0x0181
            goto L_0x0187
        L_0x0181:
            java.lang.Double r7 = (java.lang.Double) r7
            float r3 = r7.floatValue()
        L_0x0187:
            r6.setScale(r5, r3)
            goto L_0x0212
        L_0x018c:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface r6 = (com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface) r6
            if (r7 != 0) goto L_0x0193
            goto L_0x0196
        L_0x0193:
            r0 = r7
            java.lang.String r0 = (java.lang.String) r0
        L_0x0196:
            r6.setPath(r5, r0)
            goto L_0x0212
        L_0x019b:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface r6 = (com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface) r6
            if (r7 != 0) goto L_0x01a2
            goto L_0x01a8
        L_0x01a2:
            java.lang.Double r7 = (java.lang.Double) r7
            int r1 = r7.intValue()
        L_0x01a8:
            r6.setPage(r5, r1)
            goto L_0x0212
        L_0x01ad:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface r6 = (com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface) r6
            if (r7 != 0) goto L_0x01b4
            goto L_0x01ba
        L_0x01b4:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r1 = r7.booleanValue()
        L_0x01ba:
            r6.setEnableRTL(r5, r1)
            goto L_0x0212
        L_0x01be:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface r6 = (com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface) r6
            if (r7 != 0) goto L_0x01c5
            goto L_0x01cb
        L_0x01c5:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r1 = r7.booleanValue()
        L_0x01cb:
            r6.setEnableAnnotationRendering(r5, r1)
            goto L_0x0212
        L_0x01cf:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface r6 = (com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface) r6
            if (r7 != 0) goto L_0x01d6
            goto L_0x01dc
        L_0x01d6:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r1 = r7.booleanValue()
        L_0x01dc:
            r6.setShowsVerticalScrollIndicator(r5, r1)
            goto L_0x0212
        L_0x01e0:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface r6 = (com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface) r6
            if (r7 != 0) goto L_0x01e7
            goto L_0x01ed
        L_0x01e7:
            java.lang.Double r7 = (java.lang.Double) r7
            float r3 = r7.floatValue()
        L_0x01ed:
            r6.setMinScale(r5, r3)
            goto L_0x0212
        L_0x01f1:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface r6 = (com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface) r6
            if (r7 != 0) goto L_0x01f8
            goto L_0x01fe
        L_0x01f8:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r1 = r7.booleanValue()
        L_0x01fe:
            r6.setEnablePaging(r5, r1)
            goto L_0x0212
        L_0x0202:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface r6 = (com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface) r6
            if (r7 != 0) goto L_0x0209
            goto L_0x020f
        L_0x0209:
            java.lang.Double r7 = (java.lang.Double) r7
            int r1 = r7.intValue()
        L_0x020f:
            r6.setSpacing(r5, r1)
        L_0x0212:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.RNPDFPdfViewManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }

    public void receiveCommand(T t, String str, ReadableArray readableArray) {
        str.hashCode();
        if (str.equals("setNativePage")) {
            ((RNPDFPdfViewManagerInterface) this.mViewManager).setNativePage(t, readableArray.getInt(0));
        }
    }
}
