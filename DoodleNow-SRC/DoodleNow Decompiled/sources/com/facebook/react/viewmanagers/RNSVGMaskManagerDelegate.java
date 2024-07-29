package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.RNSVGMaskManagerInterface;

public class RNSVGMaskManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & RNSVGMaskManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public RNSVGMaskManagerDelegate(U u) {
        super(u);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v18, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v19, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v20, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v21, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r7, java.lang.String r8, java.lang.Object r9) {
        /*
            r6 = this;
            r8.hashCode()
            int r0 = r8.hashCode()
            r1 = 1
            r2 = 0
            r3 = -1
            switch(r0) {
                case -1267206133: goto L_0x01c8;
                case -1221029593: goto L_0x01bd;
                case -1081239615: goto L_0x01b2;
                case -993894751: goto L_0x01a7;
                case -933864895: goto L_0x019c;
                case -933857362: goto L_0x0191;
                case -891980232: goto L_0x0186;
                case -734428249: goto L_0x017b;
                case -729118945: goto L_0x016d;
                case -416535885: goto L_0x015f;
                case -293492298: goto L_0x0151;
                case -61221917: goto L_0x0143;
                case -53677816: goto L_0x0135;
                case -44578051: goto L_0x0127;
                case 120: goto L_0x0119;
                case 121: goto L_0x010b;
                case 3143043: goto L_0x00fd;
                case 3148879: goto L_0x00ef;
                case 3344108: goto L_0x00e1;
                case 3373707: goto L_0x00d3;
                case 78845486: goto L_0x00c5;
                case 104482996: goto L_0x00b7;
                case 113126854: goto L_0x00a9;
                case 217109576: goto L_0x009b;
                case 365601008: goto L_0x008d;
                case 401643183: goto L_0x007f;
                case 917656469: goto L_0x0071;
                case 917735020: goto L_0x0063;
                case 1027575302: goto L_0x0055;
                case 1671764162: goto L_0x0047;
                case 1790285174: goto L_0x0039;
                case 1847674614: goto L_0x002b;
                case 1924065902: goto L_0x001d;
                case 2037673858: goto L_0x000f;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x01d2
        L_0x000f:
            java.lang.String r0 = "maskContentUnits"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0019
            goto L_0x01d2
        L_0x0019:
            r3 = 33
            goto L_0x01d2
        L_0x001d:
            java.lang.String r0 = "strokeWidth"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0027
            goto L_0x01d2
        L_0x0027:
            r3 = 32
            goto L_0x01d2
        L_0x002b:
            java.lang.String r0 = "responsible"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0035
            goto L_0x01d2
        L_0x0035:
            r3 = 31
            goto L_0x01d2
        L_0x0039:
            java.lang.String r0 = "strokeLinejoin"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0043
            goto L_0x01d2
        L_0x0043:
            r3 = 30
            goto L_0x01d2
        L_0x0047:
            java.lang.String r0 = "display"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0051
            goto L_0x01d2
        L_0x0051:
            r3 = 29
            goto L_0x01d2
        L_0x0055:
            java.lang.String r0 = "strokeLinecap"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x005f
            goto L_0x01d2
        L_0x005f:
            r3 = 28
            goto L_0x01d2
        L_0x0063:
            java.lang.String r0 = "clipRule"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x006d
            goto L_0x01d2
        L_0x006d:
            r3 = 27
            goto L_0x01d2
        L_0x0071:
            java.lang.String r0 = "clipPath"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x007b
            goto L_0x01d2
        L_0x007b:
            r3 = 26
            goto L_0x01d2
        L_0x007f:
            java.lang.String r0 = "strokeDasharray"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0089
            goto L_0x01d2
        L_0x0089:
            r3 = 25
            goto L_0x01d2
        L_0x008d:
            java.lang.String r0 = "fontSize"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0097
            goto L_0x01d2
        L_0x0097:
            r3 = 24
            goto L_0x01d2
        L_0x009b:
            java.lang.String r0 = "markerStart"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00a5
            goto L_0x01d2
        L_0x00a5:
            r3 = 23
            goto L_0x01d2
        L_0x00a9:
            java.lang.String r0 = "width"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00b3
            goto L_0x01d2
        L_0x00b3:
            r3 = 22
            goto L_0x01d2
        L_0x00b7:
            java.lang.String r0 = "vectorEffect"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00c1
            goto L_0x01d2
        L_0x00c1:
            r3 = 21
            goto L_0x01d2
        L_0x00c5:
            java.lang.String r0 = "strokeMiterlimit"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00cf
            goto L_0x01d2
        L_0x00cf:
            r3 = 20
            goto L_0x01d2
        L_0x00d3:
            java.lang.String r0 = "name"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00dd
            goto L_0x01d2
        L_0x00dd:
            r3 = 19
            goto L_0x01d2
        L_0x00e1:
            java.lang.String r0 = "mask"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00eb
            goto L_0x01d2
        L_0x00eb:
            r3 = 18
            goto L_0x01d2
        L_0x00ef:
            java.lang.String r0 = "font"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00f9
            goto L_0x01d2
        L_0x00f9:
            r3 = 17
            goto L_0x01d2
        L_0x00fd:
            java.lang.String r0 = "fill"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0107
            goto L_0x01d2
        L_0x0107:
            r3 = 16
            goto L_0x01d2
        L_0x010b:
            java.lang.String r0 = "y"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0115
            goto L_0x01d2
        L_0x0115:
            r3 = 15
            goto L_0x01d2
        L_0x0119:
            java.lang.String r0 = "x"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0123
            goto L_0x01d2
        L_0x0123:
            r3 = 14
            goto L_0x01d2
        L_0x0127:
            java.lang.String r0 = "strokeDashoffset"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0131
            goto L_0x01d2
        L_0x0131:
            r3 = 13
            goto L_0x01d2
        L_0x0135:
            java.lang.String r0 = "fillOpacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x013f
            goto L_0x01d2
        L_0x013f:
            r3 = 12
            goto L_0x01d2
        L_0x0143:
            java.lang.String r0 = "maskUnits"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x014d
            goto L_0x01d2
        L_0x014d:
            r3 = 11
            goto L_0x01d2
        L_0x0151:
            java.lang.String r0 = "pointerEvents"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x015b
            goto L_0x01d2
        L_0x015b:
            r3 = 10
            goto L_0x01d2
        L_0x015f:
            java.lang.String r0 = "strokeOpacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0169
            goto L_0x01d2
        L_0x0169:
            r3 = 9
            goto L_0x01d2
        L_0x016d:
            java.lang.String r0 = "fillRule"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0177
            goto L_0x01d2
        L_0x0177:
            r3 = 8
            goto L_0x01d2
        L_0x017b:
            java.lang.String r0 = "fontWeight"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0184
            goto L_0x01d2
        L_0x0184:
            r3 = 7
            goto L_0x01d2
        L_0x0186:
            java.lang.String r0 = "stroke"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x018f
            goto L_0x01d2
        L_0x018f:
            r3 = 6
            goto L_0x01d2
        L_0x0191:
            java.lang.String r0 = "markerMid"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x019a
            goto L_0x01d2
        L_0x019a:
            r3 = 5
            goto L_0x01d2
        L_0x019c:
            java.lang.String r0 = "markerEnd"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01a5
            goto L_0x01d2
        L_0x01a5:
            r3 = 4
            goto L_0x01d2
        L_0x01a7:
            java.lang.String r0 = "propList"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01b0
            goto L_0x01d2
        L_0x01b0:
            r3 = 3
            goto L_0x01d2
        L_0x01b2:
            java.lang.String r0 = "matrix"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01bb
            goto L_0x01d2
        L_0x01bb:
            r3 = 2
            goto L_0x01d2
        L_0x01bd:
            java.lang.String r0 = "height"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01c6
            goto L_0x01d2
        L_0x01c6:
            r3 = r1
            goto L_0x01d2
        L_0x01c8:
            java.lang.String r0 = "opacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01d1
            goto L_0x01d2
        L_0x01d1:
            r3 = r2
        L_0x01d2:
            r0 = 0
            r4 = 1065353216(0x3f800000, float:1.0)
            r5 = 0
            switch(r3) {
                case 0: goto L_0x03d0;
                case 1: goto L_0x03c3;
                case 2: goto L_0x03b9;
                case 3: goto L_0x03af;
                case 4: goto L_0x03a1;
                case 5: goto L_0x0393;
                case 6: goto L_0x0389;
                case 7: goto L_0x037c;
                case 8: goto L_0x036b;
                case 9: goto L_0x0359;
                case 10: goto L_0x034a;
                case 11: goto L_0x0338;
                case 12: goto L_0x0326;
                case 13: goto L_0x0314;
                case 14: goto L_0x0306;
                case 15: goto L_0x02f8;
                case 16: goto L_0x02ed;
                case 17: goto L_0x02df;
                case 18: goto L_0x02d0;
                case 19: goto L_0x02c1;
                case 20: goto L_0x02af;
                case 21: goto L_0x029d;
                case 22: goto L_0x028f;
                case 23: goto L_0x0280;
                case 24: goto L_0x0272;
                case 25: goto L_0x0264;
                case 26: goto L_0x0255;
                case 27: goto L_0x0243;
                case 28: goto L_0x0231;
                case 29: goto L_0x0222;
                case 30: goto L_0x0210;
                case 31: goto L_0x01fe;
                case 32: goto L_0x01f0;
                case 33: goto L_0x01de;
                default: goto L_0x01d9;
            }
        L_0x01d9:
            super.setProperty(r7, r8, r9)
            goto L_0x03e0
        L_0x01de:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            if (r9 != 0) goto L_0x01e5
            goto L_0x01eb
        L_0x01e5:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x01eb:
            r8.setMaskContentUnits(r7, r2)
            goto L_0x03e0
        L_0x01f0:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setStrokeWidth(r7, r0)
            goto L_0x03e0
        L_0x01fe:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            if (r9 != 0) goto L_0x0205
            goto L_0x020b
        L_0x0205:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r2 = r9.booleanValue()
        L_0x020b:
            r8.setResponsible(r7, r2)
            goto L_0x03e0
        L_0x0210:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            if (r9 != 0) goto L_0x0217
            goto L_0x021d
        L_0x0217:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x021d:
            r8.setStrokeLinejoin(r7, r2)
            goto L_0x03e0
        L_0x0222:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            if (r9 != 0) goto L_0x0229
            goto L_0x022c
        L_0x0229:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x022c:
            r8.setDisplay(r7, r5)
            goto L_0x03e0
        L_0x0231:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            if (r9 != 0) goto L_0x0238
            goto L_0x023e
        L_0x0238:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x023e:
            r8.setStrokeLinecap(r7, r2)
            goto L_0x03e0
        L_0x0243:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            if (r9 != 0) goto L_0x024a
            goto L_0x0250
        L_0x024a:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x0250:
            r8.setClipRule(r7, r2)
            goto L_0x03e0
        L_0x0255:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            if (r9 != 0) goto L_0x025c
            goto L_0x025f
        L_0x025c:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x025f:
            r8.setClipPath(r7, r5)
            goto L_0x03e0
        L_0x0264:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setStrokeDasharray(r7, r0)
            goto L_0x03e0
        L_0x0272:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setFontSize(r7, r0)
            goto L_0x03e0
        L_0x0280:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            if (r9 != 0) goto L_0x0287
            goto L_0x028a
        L_0x0287:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x028a:
            r8.setMarkerStart(r7, r5)
            goto L_0x03e0
        L_0x028f:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setWidth(r7, r0)
            goto L_0x03e0
        L_0x029d:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            if (r9 != 0) goto L_0x02a4
            goto L_0x02aa
        L_0x02a4:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x02aa:
            r8.setVectorEffect(r7, r2)
            goto L_0x03e0
        L_0x02af:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            if (r9 != 0) goto L_0x02b6
            goto L_0x02bc
        L_0x02b6:
            java.lang.Double r9 = (java.lang.Double) r9
            float r0 = r9.floatValue()
        L_0x02bc:
            r8.setStrokeMiterlimit(r7, r0)
            goto L_0x03e0
        L_0x02c1:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            if (r9 != 0) goto L_0x02c8
            goto L_0x02cb
        L_0x02c8:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x02cb:
            r8.setName(r7, r5)
            goto L_0x03e0
        L_0x02d0:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            if (r9 != 0) goto L_0x02d7
            goto L_0x02da
        L_0x02d7:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x02da:
            r8.setMask(r7, r5)
            goto L_0x03e0
        L_0x02df:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setFont(r7, r0)
            goto L_0x03e0
        L_0x02ed:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setFill(r7, r9)
            goto L_0x03e0
        L_0x02f8:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setY(r7, r0)
            goto L_0x03e0
        L_0x0306:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setX(r7, r0)
            goto L_0x03e0
        L_0x0314:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            if (r9 != 0) goto L_0x031b
            goto L_0x0321
        L_0x031b:
            java.lang.Double r9 = (java.lang.Double) r9
            float r0 = r9.floatValue()
        L_0x0321:
            r8.setStrokeDashoffset(r7, r0)
            goto L_0x03e0
        L_0x0326:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            if (r9 != 0) goto L_0x032d
            goto L_0x0333
        L_0x032d:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x0333:
            r8.setFillOpacity(r7, r4)
            goto L_0x03e0
        L_0x0338:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            if (r9 != 0) goto L_0x033f
            goto L_0x0345
        L_0x033f:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x0345:
            r8.setMaskUnits(r7, r2)
            goto L_0x03e0
        L_0x034a:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            if (r9 != 0) goto L_0x0351
            goto L_0x0354
        L_0x0351:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0354:
            r8.setPointerEvents(r7, r5)
            goto L_0x03e0
        L_0x0359:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            if (r9 != 0) goto L_0x0360
            goto L_0x0366
        L_0x0360:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x0366:
            r8.setStrokeOpacity(r7, r4)
            goto L_0x03e0
        L_0x036b:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            if (r9 != 0) goto L_0x0372
            goto L_0x0378
        L_0x0372:
            java.lang.Double r9 = (java.lang.Double) r9
            int r1 = r9.intValue()
        L_0x0378:
            r8.setFillRule(r7, r1)
            goto L_0x03e0
        L_0x037c:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setFontWeight(r7, r0)
            goto L_0x03e0
        L_0x0389:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setStroke(r7, r9)
            goto L_0x03e0
        L_0x0393:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            if (r9 != 0) goto L_0x039a
            goto L_0x039d
        L_0x039a:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x039d:
            r8.setMarkerMid(r7, r5)
            goto L_0x03e0
        L_0x03a1:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            if (r9 != 0) goto L_0x03a8
            goto L_0x03ab
        L_0x03a8:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x03ab:
            r8.setMarkerEnd(r7, r5)
            goto L_0x03e0
        L_0x03af:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setPropList(r7, r9)
            goto L_0x03e0
        L_0x03b9:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setMatrix(r7, r9)
            goto L_0x03e0
        L_0x03c3:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setHeight(r7, r0)
            goto L_0x03e0
        L_0x03d0:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMaskManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMaskManagerInterface) r8
            if (r9 != 0) goto L_0x03d7
            goto L_0x03dd
        L_0x03d7:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x03dd:
            r8.setOpacity(r7, r4)
        L_0x03e0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.RNSVGMaskManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
