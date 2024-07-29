package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface;

public class RNSScreenStackHeaderConfigManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & RNSScreenStackHeaderConfigManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public RNSScreenStackHeaderConfigManagerDelegate(U u) {
        super(u);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v19, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v21, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v23, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v25, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v26, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v27, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v28, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v29, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v30, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v31, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v32, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v33, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v34, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v35, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v36, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r5, java.lang.String r6, java.lang.Object r7) {
        /*
            r4 = this;
            r6.hashCode()
            int r0 = r6.hashCode()
            r1 = 1
            r2 = 0
            r3 = -1
            switch(r0) {
                case -1822687399: goto L_0x0166;
                case -1799367701: goto L_0x015b;
                case -1774658170: goto L_0x0150;
                case -1715368693: goto L_0x0145;
                case -1503810304: goto L_0x013a;
                case -1225100257: goto L_0x012f;
                case -1217487446: goto L_0x0124;
                case -1094575123: goto L_0x0119;
                case -1093089076: goto L_0x010b;
                case -1063138943: goto L_0x00fd;
                case -962590849: goto L_0x00ef;
                case -389245640: goto L_0x00e1;
                case -140063148: goto L_0x00d3;
                case 347216: goto L_0x00c5;
                case 94842723: goto L_0x00b7;
                case 110371416: goto L_0x00a9;
                case 183888321: goto L_0x009b;
                case 243070244: goto L_0x008d;
                case 339462402: goto L_0x007f;
                case 490615652: goto L_0x0071;
                case 1038753243: goto L_0x0063;
                case 1287124693: goto L_0x0055;
                case 1324688817: goto L_0x0047;
                case 1518161768: goto L_0x0039;
                case 1564506303: goto L_0x002b;
                case 2029798365: goto L_0x001d;
                case 2099541337: goto L_0x000f;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x0170
        L_0x000f:
            java.lang.String r0 = "topInsetEnabled"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0019
            goto L_0x0170
        L_0x0019:
            r3 = 26
            goto L_0x0170
        L_0x001d:
            java.lang.String r0 = "largeTitle"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0027
            goto L_0x0170
        L_0x0027:
            r3 = 25
            goto L_0x0170
        L_0x002b:
            java.lang.String r0 = "largeTitleHideShadow"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0035
            goto L_0x0170
        L_0x0035:
            r3 = 24
            goto L_0x0170
        L_0x0039:
            java.lang.String r0 = "titleFontSize"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0043
            goto L_0x0170
        L_0x0043:
            r3 = 23
            goto L_0x0170
        L_0x0047:
            java.lang.String r0 = "backTitle"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0051
            goto L_0x0170
        L_0x0051:
            r3 = 22
            goto L_0x0170
        L_0x0055:
            java.lang.String r0 = "backgroundColor"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x005f
            goto L_0x0170
        L_0x005f:
            r3 = 21
            goto L_0x0170
        L_0x0063:
            java.lang.String r0 = "hideBackButton"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x006d
            goto L_0x0170
        L_0x006d:
            r3 = 20
            goto L_0x0170
        L_0x0071:
            java.lang.String r0 = "largeTitleFontWeight"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x007b
            goto L_0x0170
        L_0x007b:
            r3 = 19
            goto L_0x0170
        L_0x007f:
            java.lang.String r0 = "hideShadow"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0089
            goto L_0x0170
        L_0x0089:
            r3 = 18
            goto L_0x0170
        L_0x008d:
            java.lang.String r0 = "backTitleFontFamily"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0097
            goto L_0x0170
        L_0x0097:
            r3 = 17
            goto L_0x0170
        L_0x009b:
            java.lang.String r0 = "backTitleFontSize"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x00a5
            goto L_0x0170
        L_0x00a5:
            r3 = 16
            goto L_0x0170
        L_0x00a9:
            java.lang.String r0 = "title"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x00b3
            goto L_0x0170
        L_0x00b3:
            r3 = 15
            goto L_0x0170
        L_0x00b7:
            java.lang.String r0 = "color"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x00c1
            goto L_0x0170
        L_0x00c1:
            r3 = 14
            goto L_0x0170
        L_0x00c5:
            java.lang.String r0 = "largeTitleFontFamily"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x00cf
            goto L_0x0170
        L_0x00cf:
            r3 = 13
            goto L_0x0170
        L_0x00d3:
            java.lang.String r0 = "backButtonInCustomView"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x00dd
            goto L_0x0170
        L_0x00dd:
            r3 = 12
            goto L_0x0170
        L_0x00e1:
            java.lang.String r0 = "largeTitleBackgroundColor"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x00eb
            goto L_0x0170
        L_0x00eb:
            r3 = 11
            goto L_0x0170
        L_0x00ef:
            java.lang.String r0 = "direction"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x00f9
            goto L_0x0170
        L_0x00f9:
            r3 = 10
            goto L_0x0170
        L_0x00fd:
            java.lang.String r0 = "backTitleVisible"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0107
            goto L_0x0170
        L_0x0107:
            r3 = 9
            goto L_0x0170
        L_0x010b:
            java.lang.String r0 = "backButtonDisplayMode"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0115
            goto L_0x0170
        L_0x0115:
            r3 = 8
            goto L_0x0170
        L_0x0119:
            java.lang.String r0 = "largeTitleFontSize"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0122
            goto L_0x0170
        L_0x0122:
            r3 = 7
            goto L_0x0170
        L_0x0124:
            java.lang.String r0 = "hidden"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x012d
            goto L_0x0170
        L_0x012d:
            r3 = 6
            goto L_0x0170
        L_0x012f:
            java.lang.String r0 = "titleFontWeight"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0138
            goto L_0x0170
        L_0x0138:
            r3 = 5
            goto L_0x0170
        L_0x013a:
            java.lang.String r0 = "disableBackButtonMenu"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0143
            goto L_0x0170
        L_0x0143:
            r3 = 4
            goto L_0x0170
        L_0x0145:
            java.lang.String r0 = "titleFontFamily"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x014e
            goto L_0x0170
        L_0x014e:
            r3 = 3
            goto L_0x0170
        L_0x0150:
            java.lang.String r0 = "largeTitleColor"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0159
            goto L_0x0170
        L_0x0159:
            r3 = 2
            goto L_0x0170
        L_0x015b:
            java.lang.String r0 = "titleColor"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0164
            goto L_0x0170
        L_0x0164:
            r3 = r1
            goto L_0x0170
        L_0x0166:
            java.lang.String r0 = "translucent"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x016f
            goto L_0x0170
        L_0x016f:
            r3 = r2
        L_0x0170:
            r0 = 0
            switch(r3) {
                case 0: goto L_0x031f;
                case 1: goto L_0x030f;
                case 2: goto L_0x02ff;
                case 3: goto L_0x02f1;
                case 4: goto L_0x02e0;
                case 5: goto L_0x02d2;
                case 6: goto L_0x02c1;
                case 7: goto L_0x02af;
                case 8: goto L_0x02a4;
                case 9: goto L_0x0292;
                case 10: goto L_0x0287;
                case 11: goto L_0x0276;
                case 12: goto L_0x0264;
                case 13: goto L_0x0255;
                case 14: goto L_0x0244;
                case 15: goto L_0x0235;
                case 16: goto L_0x0223;
                case 17: goto L_0x0214;
                case 18: goto L_0x0202;
                case 19: goto L_0x01f3;
                case 20: goto L_0x01e1;
                case 21: goto L_0x01d0;
                case 22: goto L_0x01c1;
                case 23: goto L_0x01af;
                case 24: goto L_0x019d;
                case 25: goto L_0x018b;
                case 26: goto L_0x0179;
                default: goto L_0x0174;
            }
        L_0x0174:
            super.setProperty(r5, r6, r7)
            goto L_0x032f
        L_0x0179:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            if (r7 != 0) goto L_0x0180
            goto L_0x0186
        L_0x0180:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r2 = r7.booleanValue()
        L_0x0186:
            r6.setTopInsetEnabled(r5, r2)
            goto L_0x032f
        L_0x018b:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            if (r7 != 0) goto L_0x0192
            goto L_0x0198
        L_0x0192:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r2 = r7.booleanValue()
        L_0x0198:
            r6.setLargeTitle(r5, r2)
            goto L_0x032f
        L_0x019d:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            if (r7 != 0) goto L_0x01a4
            goto L_0x01aa
        L_0x01a4:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r2 = r7.booleanValue()
        L_0x01aa:
            r6.setLargeTitleHideShadow(r5, r2)
            goto L_0x032f
        L_0x01af:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            if (r7 != 0) goto L_0x01b6
            goto L_0x01bc
        L_0x01b6:
            java.lang.Double r7 = (java.lang.Double) r7
            int r2 = r7.intValue()
        L_0x01bc:
            r6.setTitleFontSize(r5, r2)
            goto L_0x032f
        L_0x01c1:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            if (r7 != 0) goto L_0x01c8
            goto L_0x01cb
        L_0x01c8:
            r0 = r7
            java.lang.String r0 = (java.lang.String) r0
        L_0x01cb:
            r6.setBackTitle(r5, r0)
            goto L_0x032f
        L_0x01d0:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            android.content.Context r0 = r5.getContext()
            java.lang.Integer r7 = com.facebook.react.bridge.ColorPropConverter.getColor(r7, r0)
            r6.setBackgroundColor(r5, r7)
            goto L_0x032f
        L_0x01e1:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            if (r7 != 0) goto L_0x01e8
            goto L_0x01ee
        L_0x01e8:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r2 = r7.booleanValue()
        L_0x01ee:
            r6.setHideBackButton(r5, r2)
            goto L_0x032f
        L_0x01f3:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            if (r7 != 0) goto L_0x01fa
            goto L_0x01fd
        L_0x01fa:
            r0 = r7
            java.lang.String r0 = (java.lang.String) r0
        L_0x01fd:
            r6.setLargeTitleFontWeight(r5, r0)
            goto L_0x032f
        L_0x0202:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            if (r7 != 0) goto L_0x0209
            goto L_0x020f
        L_0x0209:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r2 = r7.booleanValue()
        L_0x020f:
            r6.setHideShadow(r5, r2)
            goto L_0x032f
        L_0x0214:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            if (r7 != 0) goto L_0x021b
            goto L_0x021e
        L_0x021b:
            r0 = r7
            java.lang.String r0 = (java.lang.String) r0
        L_0x021e:
            r6.setBackTitleFontFamily(r5, r0)
            goto L_0x032f
        L_0x0223:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            if (r7 != 0) goto L_0x022a
            goto L_0x0230
        L_0x022a:
            java.lang.Double r7 = (java.lang.Double) r7
            int r2 = r7.intValue()
        L_0x0230:
            r6.setBackTitleFontSize(r5, r2)
            goto L_0x032f
        L_0x0235:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            if (r7 != 0) goto L_0x023c
            goto L_0x023f
        L_0x023c:
            r0 = r7
            java.lang.String r0 = (java.lang.String) r0
        L_0x023f:
            r6.setTitle(r5, r0)
            goto L_0x032f
        L_0x0244:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            android.content.Context r0 = r5.getContext()
            java.lang.Integer r7 = com.facebook.react.bridge.ColorPropConverter.getColor(r7, r0)
            r6.setColor(r5, r7)
            goto L_0x032f
        L_0x0255:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            if (r7 != 0) goto L_0x025c
            goto L_0x025f
        L_0x025c:
            r0 = r7
            java.lang.String r0 = (java.lang.String) r0
        L_0x025f:
            r6.setLargeTitleFontFamily(r5, r0)
            goto L_0x032f
        L_0x0264:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            if (r7 != 0) goto L_0x026b
            goto L_0x0271
        L_0x026b:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r2 = r7.booleanValue()
        L_0x0271:
            r6.setBackButtonInCustomView(r5, r2)
            goto L_0x032f
        L_0x0276:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            android.content.Context r0 = r5.getContext()
            java.lang.Integer r7 = com.facebook.react.bridge.ColorPropConverter.getColor(r7, r0)
            r6.setLargeTitleBackgroundColor(r5, r7)
            goto L_0x032f
        L_0x0287:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            java.lang.String r7 = (java.lang.String) r7
            r6.setDirection(r5, r7)
            goto L_0x032f
        L_0x0292:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            if (r7 != 0) goto L_0x0299
            goto L_0x029f
        L_0x0299:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r1 = r7.booleanValue()
        L_0x029f:
            r6.setBackTitleVisible(r5, r1)
            goto L_0x032f
        L_0x02a4:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            java.lang.String r7 = (java.lang.String) r7
            r6.setBackButtonDisplayMode(r5, r7)
            goto L_0x032f
        L_0x02af:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            if (r7 != 0) goto L_0x02b6
            goto L_0x02bc
        L_0x02b6:
            java.lang.Double r7 = (java.lang.Double) r7
            int r2 = r7.intValue()
        L_0x02bc:
            r6.setLargeTitleFontSize(r5, r2)
            goto L_0x032f
        L_0x02c1:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            if (r7 != 0) goto L_0x02c8
            goto L_0x02ce
        L_0x02c8:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r2 = r7.booleanValue()
        L_0x02ce:
            r6.setHidden(r5, r2)
            goto L_0x032f
        L_0x02d2:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            if (r7 != 0) goto L_0x02d9
            goto L_0x02dc
        L_0x02d9:
            r0 = r7
            java.lang.String r0 = (java.lang.String) r0
        L_0x02dc:
            r6.setTitleFontWeight(r5, r0)
            goto L_0x032f
        L_0x02e0:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            if (r7 != 0) goto L_0x02e7
            goto L_0x02ed
        L_0x02e7:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r2 = r7.booleanValue()
        L_0x02ed:
            r6.setDisableBackButtonMenu(r5, r2)
            goto L_0x032f
        L_0x02f1:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            if (r7 != 0) goto L_0x02f8
            goto L_0x02fb
        L_0x02f8:
            r0 = r7
            java.lang.String r0 = (java.lang.String) r0
        L_0x02fb:
            r6.setTitleFontFamily(r5, r0)
            goto L_0x032f
        L_0x02ff:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            android.content.Context r0 = r5.getContext()
            java.lang.Integer r7 = com.facebook.react.bridge.ColorPropConverter.getColor(r7, r0)
            r6.setLargeTitleColor(r5, r7)
            goto L_0x032f
        L_0x030f:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            android.content.Context r0 = r5.getContext()
            java.lang.Integer r7 = com.facebook.react.bridge.ColorPropConverter.getColor(r7, r0)
            r6.setTitleColor(r5, r7)
            goto L_0x032f
        L_0x031f:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface r6 = (com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface) r6
            if (r7 != 0) goto L_0x0326
            goto L_0x032c
        L_0x0326:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r2 = r7.booleanValue()
        L_0x032c:
            r6.setTranslucent(r5, r2)
        L_0x032f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
