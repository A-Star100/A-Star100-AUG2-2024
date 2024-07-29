package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.RNSVGTextManagerInterface;

public class RNSVGTextManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & RNSVGTextManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public RNSVGTextManagerDelegate(U u) {
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
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: boolean} */
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
                case -1603134955: goto L_0x020e;
                case -1267206133: goto L_0x0203;
                case -1171891896: goto L_0x01f8;
                case -1139902161: goto L_0x01ed;
                case -1081239615: goto L_0x01e2;
                case -993894751: goto L_0x01d7;
                case -933864895: goto L_0x01cc;
                case -933857362: goto L_0x01c1;
                case -925180581: goto L_0x01b3;
                case -891980232: goto L_0x01a5;
                case -734428249: goto L_0x0197;
                case -729118945: goto L_0x0189;
                case -416535885: goto L_0x017b;
                case -293492298: goto L_0x016d;
                case -53677816: goto L_0x015f;
                case -44578051: goto L_0x0151;
                case 120: goto L_0x0143;
                case 121: goto L_0x0135;
                case 3220: goto L_0x0127;
                case 3221: goto L_0x0119;
                case 3143043: goto L_0x010b;
                case 3148879: goto L_0x00fd;
                case 3344108: goto L_0x00ef;
                case 3373707: goto L_0x00e1;
                case 78845486: goto L_0x00d3;
                case 104482996: goto L_0x00c5;
                case 217109576: goto L_0x00b7;
                case 275888445: goto L_0x00a9;
                case 365601008: goto L_0x009b;
                case 401643183: goto L_0x008d;
                case 778043962: goto L_0x007f;
                case 917656469: goto L_0x0071;
                case 917735020: goto L_0x0063;
                case 1027575302: goto L_0x0055;
                case 1637488243: goto L_0x0047;
                case 1671764162: goto L_0x0039;
                case 1790285174: goto L_0x002b;
                case 1847674614: goto L_0x001d;
                case 1924065902: goto L_0x000f;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x0218
        L_0x000f:
            java.lang.String r0 = "strokeWidth"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0019
            goto L_0x0218
        L_0x0019:
            r3 = 38
            goto L_0x0218
        L_0x001d:
            java.lang.String r0 = "responsible"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0027
            goto L_0x0218
        L_0x0027:
            r3 = 37
            goto L_0x0218
        L_0x002b:
            java.lang.String r0 = "strokeLinejoin"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0035
            goto L_0x0218
        L_0x0035:
            r3 = 36
            goto L_0x0218
        L_0x0039:
            java.lang.String r0 = "display"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0043
            goto L_0x0218
        L_0x0043:
            r3 = 35
            goto L_0x0218
        L_0x0047:
            java.lang.String r0 = "textLength"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0051
            goto L_0x0218
        L_0x0051:
            r3 = 34
            goto L_0x0218
        L_0x0055:
            java.lang.String r0 = "strokeLinecap"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x005f
            goto L_0x0218
        L_0x005f:
            r3 = 33
            goto L_0x0218
        L_0x0063:
            java.lang.String r0 = "clipRule"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x006d
            goto L_0x0218
        L_0x006d:
            r3 = 32
            goto L_0x0218
        L_0x0071:
            java.lang.String r0 = "clipPath"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x007b
            goto L_0x0218
        L_0x007b:
            r3 = 31
            goto L_0x0218
        L_0x007f:
            java.lang.String r0 = "inlineSize"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0089
            goto L_0x0218
        L_0x0089:
            r3 = 30
            goto L_0x0218
        L_0x008d:
            java.lang.String r0 = "strokeDasharray"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0097
            goto L_0x0218
        L_0x0097:
            r3 = 29
            goto L_0x0218
        L_0x009b:
            java.lang.String r0 = "fontSize"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00a5
            goto L_0x0218
        L_0x00a5:
            r3 = 28
            goto L_0x0218
        L_0x00a9:
            java.lang.String r0 = "baselineShift"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00b3
            goto L_0x0218
        L_0x00b3:
            r3 = 27
            goto L_0x0218
        L_0x00b7:
            java.lang.String r0 = "markerStart"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00c1
            goto L_0x0218
        L_0x00c1:
            r3 = 26
            goto L_0x0218
        L_0x00c5:
            java.lang.String r0 = "vectorEffect"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00cf
            goto L_0x0218
        L_0x00cf:
            r3 = 25
            goto L_0x0218
        L_0x00d3:
            java.lang.String r0 = "strokeMiterlimit"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00dd
            goto L_0x0218
        L_0x00dd:
            r3 = 24
            goto L_0x0218
        L_0x00e1:
            java.lang.String r0 = "name"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00eb
            goto L_0x0218
        L_0x00eb:
            r3 = 23
            goto L_0x0218
        L_0x00ef:
            java.lang.String r0 = "mask"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00f9
            goto L_0x0218
        L_0x00f9:
            r3 = 22
            goto L_0x0218
        L_0x00fd:
            java.lang.String r0 = "font"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0107
            goto L_0x0218
        L_0x0107:
            r3 = 21
            goto L_0x0218
        L_0x010b:
            java.lang.String r0 = "fill"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0115
            goto L_0x0218
        L_0x0115:
            r3 = 20
            goto L_0x0218
        L_0x0119:
            java.lang.String r0 = "dy"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0123
            goto L_0x0218
        L_0x0123:
            r3 = 19
            goto L_0x0218
        L_0x0127:
            java.lang.String r0 = "dx"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0131
            goto L_0x0218
        L_0x0131:
            r3 = 18
            goto L_0x0218
        L_0x0135:
            java.lang.String r0 = "y"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x013f
            goto L_0x0218
        L_0x013f:
            r3 = 17
            goto L_0x0218
        L_0x0143:
            java.lang.String r0 = "x"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x014d
            goto L_0x0218
        L_0x014d:
            r3 = 16
            goto L_0x0218
        L_0x0151:
            java.lang.String r0 = "strokeDashoffset"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x015b
            goto L_0x0218
        L_0x015b:
            r3 = 15
            goto L_0x0218
        L_0x015f:
            java.lang.String r0 = "fillOpacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0169
            goto L_0x0218
        L_0x0169:
            r3 = 14
            goto L_0x0218
        L_0x016d:
            java.lang.String r0 = "pointerEvents"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0177
            goto L_0x0218
        L_0x0177:
            r3 = 13
            goto L_0x0218
        L_0x017b:
            java.lang.String r0 = "strokeOpacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0185
            goto L_0x0218
        L_0x0185:
            r3 = 12
            goto L_0x0218
        L_0x0189:
            java.lang.String r0 = "fillRule"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0193
            goto L_0x0218
        L_0x0193:
            r3 = 11
            goto L_0x0218
        L_0x0197:
            java.lang.String r0 = "fontWeight"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01a1
            goto L_0x0218
        L_0x01a1:
            r3 = 10
            goto L_0x0218
        L_0x01a5:
            java.lang.String r0 = "stroke"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01af
            goto L_0x0218
        L_0x01af:
            r3 = 9
            goto L_0x0218
        L_0x01b3:
            java.lang.String r0 = "rotate"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01bd
            goto L_0x0218
        L_0x01bd:
            r3 = 8
            goto L_0x0218
        L_0x01c1:
            java.lang.String r0 = "markerMid"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01ca
            goto L_0x0218
        L_0x01ca:
            r3 = 7
            goto L_0x0218
        L_0x01cc:
            java.lang.String r0 = "markerEnd"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01d5
            goto L_0x0218
        L_0x01d5:
            r3 = 6
            goto L_0x0218
        L_0x01d7:
            java.lang.String r0 = "propList"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01e0
            goto L_0x0218
        L_0x01e0:
            r3 = 5
            goto L_0x0218
        L_0x01e2:
            java.lang.String r0 = "matrix"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01eb
            goto L_0x0218
        L_0x01eb:
            r3 = 4
            goto L_0x0218
        L_0x01ed:
            java.lang.String r0 = "verticalAlign"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01f6
            goto L_0x0218
        L_0x01f6:
            r3 = 3
            goto L_0x0218
        L_0x01f8:
            java.lang.String r0 = "alignmentBaseline"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0201
            goto L_0x0218
        L_0x0201:
            r3 = 2
            goto L_0x0218
        L_0x0203:
            java.lang.String r0 = "opacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x020c
            goto L_0x0218
        L_0x020c:
            r3 = r1
            goto L_0x0218
        L_0x020e:
            java.lang.String r0 = "lengthAdjust"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0217
            goto L_0x0218
        L_0x0217:
            r3 = r2
        L_0x0218:
            r0 = 0
            r4 = 1065353216(0x3f800000, float:1.0)
            r5 = 0
            switch(r3) {
                case 0: goto L_0x045a;
                case 1: goto L_0x0449;
                case 2: goto L_0x043b;
                case 3: goto L_0x042e;
                case 4: goto L_0x0424;
                case 5: goto L_0x041a;
                case 6: goto L_0x040c;
                case 7: goto L_0x03fe;
                case 8: goto L_0x03f0;
                case 9: goto L_0x03e5;
                case 10: goto L_0x03d7;
                case 11: goto L_0x03c5;
                case 12: goto L_0x03b3;
                case 13: goto L_0x03a4;
                case 14: goto L_0x0392;
                case 15: goto L_0x0380;
                case 16: goto L_0x0372;
                case 17: goto L_0x0364;
                case 18: goto L_0x0356;
                case 19: goto L_0x0348;
                case 20: goto L_0x033d;
                case 21: goto L_0x032f;
                case 22: goto L_0x0320;
                case 23: goto L_0x0311;
                case 24: goto L_0x02ff;
                case 25: goto L_0x02ed;
                case 26: goto L_0x02de;
                case 27: goto L_0x02d0;
                case 28: goto L_0x02c2;
                case 29: goto L_0x02b4;
                case 30: goto L_0x02a6;
                case 31: goto L_0x0297;
                case 32: goto L_0x0285;
                case 33: goto L_0x0273;
                case 34: goto L_0x0265;
                case 35: goto L_0x0256;
                case 36: goto L_0x0244;
                case 37: goto L_0x0232;
                case 38: goto L_0x0224;
                default: goto L_0x021f;
            }
        L_0x021f:
            super.setProperty(r7, r8, r9)
            goto L_0x0467
        L_0x0224:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setStrokeWidth(r7, r0)
            goto L_0x0467
        L_0x0232:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            if (r9 != 0) goto L_0x0239
            goto L_0x023f
        L_0x0239:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r2 = r9.booleanValue()
        L_0x023f:
            r8.setResponsible(r7, r2)
            goto L_0x0467
        L_0x0244:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            if (r9 != 0) goto L_0x024b
            goto L_0x0251
        L_0x024b:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x0251:
            r8.setStrokeLinejoin(r7, r2)
            goto L_0x0467
        L_0x0256:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            if (r9 != 0) goto L_0x025d
            goto L_0x0260
        L_0x025d:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0260:
            r8.setDisplay(r7, r5)
            goto L_0x0467
        L_0x0265:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setTextLength(r7, r0)
            goto L_0x0467
        L_0x0273:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            if (r9 != 0) goto L_0x027a
            goto L_0x0280
        L_0x027a:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x0280:
            r8.setStrokeLinecap(r7, r2)
            goto L_0x0467
        L_0x0285:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            if (r9 != 0) goto L_0x028c
            goto L_0x0292
        L_0x028c:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x0292:
            r8.setClipRule(r7, r2)
            goto L_0x0467
        L_0x0297:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            if (r9 != 0) goto L_0x029e
            goto L_0x02a1
        L_0x029e:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x02a1:
            r8.setClipPath(r7, r5)
            goto L_0x0467
        L_0x02a6:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setInlineSize(r7, r0)
            goto L_0x0467
        L_0x02b4:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setStrokeDasharray(r7, r0)
            goto L_0x0467
        L_0x02c2:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setFontSize(r7, r0)
            goto L_0x0467
        L_0x02d0:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setBaselineShift(r7, r0)
            goto L_0x0467
        L_0x02de:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            if (r9 != 0) goto L_0x02e5
            goto L_0x02e8
        L_0x02e5:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x02e8:
            r8.setMarkerStart(r7, r5)
            goto L_0x0467
        L_0x02ed:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            if (r9 != 0) goto L_0x02f4
            goto L_0x02fa
        L_0x02f4:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x02fa:
            r8.setVectorEffect(r7, r2)
            goto L_0x0467
        L_0x02ff:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            if (r9 != 0) goto L_0x0306
            goto L_0x030c
        L_0x0306:
            java.lang.Double r9 = (java.lang.Double) r9
            float r0 = r9.floatValue()
        L_0x030c:
            r8.setStrokeMiterlimit(r7, r0)
            goto L_0x0467
        L_0x0311:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            if (r9 != 0) goto L_0x0318
            goto L_0x031b
        L_0x0318:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x031b:
            r8.setName(r7, r5)
            goto L_0x0467
        L_0x0320:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            if (r9 != 0) goto L_0x0327
            goto L_0x032a
        L_0x0327:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x032a:
            r8.setMask(r7, r5)
            goto L_0x0467
        L_0x032f:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setFont(r7, r0)
            goto L_0x0467
        L_0x033d:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setFill(r7, r9)
            goto L_0x0467
        L_0x0348:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setDy(r7, r0)
            goto L_0x0467
        L_0x0356:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setDx(r7, r0)
            goto L_0x0467
        L_0x0364:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setY(r7, r0)
            goto L_0x0467
        L_0x0372:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setX(r7, r0)
            goto L_0x0467
        L_0x0380:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            if (r9 != 0) goto L_0x0387
            goto L_0x038d
        L_0x0387:
            java.lang.Double r9 = (java.lang.Double) r9
            float r0 = r9.floatValue()
        L_0x038d:
            r8.setStrokeDashoffset(r7, r0)
            goto L_0x0467
        L_0x0392:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            if (r9 != 0) goto L_0x0399
            goto L_0x039f
        L_0x0399:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x039f:
            r8.setFillOpacity(r7, r4)
            goto L_0x0467
        L_0x03a4:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            if (r9 != 0) goto L_0x03ab
            goto L_0x03ae
        L_0x03ab:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x03ae:
            r8.setPointerEvents(r7, r5)
            goto L_0x0467
        L_0x03b3:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            if (r9 != 0) goto L_0x03ba
            goto L_0x03c0
        L_0x03ba:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x03c0:
            r8.setStrokeOpacity(r7, r4)
            goto L_0x0467
        L_0x03c5:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            if (r9 != 0) goto L_0x03cc
            goto L_0x03d2
        L_0x03cc:
            java.lang.Double r9 = (java.lang.Double) r9
            int r1 = r9.intValue()
        L_0x03d2:
            r8.setFillRule(r7, r1)
            goto L_0x0467
        L_0x03d7:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setFontWeight(r7, r0)
            goto L_0x0467
        L_0x03e5:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setStroke(r7, r9)
            goto L_0x0467
        L_0x03f0:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setRotate(r7, r0)
            goto L_0x0467
        L_0x03fe:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            if (r9 != 0) goto L_0x0405
            goto L_0x0408
        L_0x0405:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0408:
            r8.setMarkerMid(r7, r5)
            goto L_0x0467
        L_0x040c:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            if (r9 != 0) goto L_0x0413
            goto L_0x0416
        L_0x0413:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0416:
            r8.setMarkerEnd(r7, r5)
            goto L_0x0467
        L_0x041a:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setPropList(r7, r9)
            goto L_0x0467
        L_0x0424:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setMatrix(r7, r9)
            goto L_0x0467
        L_0x042e:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setVerticalAlign(r7, r0)
            goto L_0x0467
        L_0x043b:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            if (r9 != 0) goto L_0x0442
            goto L_0x0445
        L_0x0442:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0445:
            r8.setAlignmentBaseline(r7, r5)
            goto L_0x0467
        L_0x0449:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            if (r9 != 0) goto L_0x0450
            goto L_0x0456
        L_0x0450:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x0456:
            r8.setOpacity(r7, r4)
            goto L_0x0467
        L_0x045a:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTextManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTextManagerInterface) r8
            if (r9 != 0) goto L_0x0461
            goto L_0x0464
        L_0x0461:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0464:
            r8.setLengthAdjust(r7, r5)
        L_0x0467:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.RNSVGTextManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
