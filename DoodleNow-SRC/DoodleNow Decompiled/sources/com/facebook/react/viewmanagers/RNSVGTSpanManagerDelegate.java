package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface;

public class RNSVGTSpanManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & RNSVGTSpanManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public RNSVGTSpanManagerDelegate(U u) {
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
                case -1603134955: goto L_0x021c;
                case -1267206133: goto L_0x0211;
                case -1171891896: goto L_0x0206;
                case -1139902161: goto L_0x01fb;
                case -1081239615: goto L_0x01f0;
                case -993894751: goto L_0x01e5;
                case -933864895: goto L_0x01da;
                case -933857362: goto L_0x01cf;
                case -925180581: goto L_0x01c1;
                case -891980232: goto L_0x01b3;
                case -734428249: goto L_0x01a5;
                case -729118945: goto L_0x0197;
                case -416535885: goto L_0x0189;
                case -293492298: goto L_0x017b;
                case -53677816: goto L_0x016d;
                case -44578051: goto L_0x015f;
                case 120: goto L_0x0151;
                case 121: goto L_0x0143;
                case 3220: goto L_0x0135;
                case 3221: goto L_0x0127;
                case 3143043: goto L_0x0119;
                case 3148879: goto L_0x010b;
                case 3344108: goto L_0x00fd;
                case 3373707: goto L_0x00ef;
                case 78845486: goto L_0x00e1;
                case 104482996: goto L_0x00d3;
                case 217109576: goto L_0x00c5;
                case 275888445: goto L_0x00b7;
                case 365601008: goto L_0x00a9;
                case 401643183: goto L_0x009b;
                case 778043962: goto L_0x008d;
                case 917656469: goto L_0x007f;
                case 917735020: goto L_0x0071;
                case 951530617: goto L_0x0063;
                case 1027575302: goto L_0x0055;
                case 1637488243: goto L_0x0047;
                case 1671764162: goto L_0x0039;
                case 1790285174: goto L_0x002b;
                case 1847674614: goto L_0x001d;
                case 1924065902: goto L_0x000f;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x0226
        L_0x000f:
            java.lang.String r0 = "strokeWidth"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0019
            goto L_0x0226
        L_0x0019:
            r3 = 39
            goto L_0x0226
        L_0x001d:
            java.lang.String r0 = "responsible"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0027
            goto L_0x0226
        L_0x0027:
            r3 = 38
            goto L_0x0226
        L_0x002b:
            java.lang.String r0 = "strokeLinejoin"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0035
            goto L_0x0226
        L_0x0035:
            r3 = 37
            goto L_0x0226
        L_0x0039:
            java.lang.String r0 = "display"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0043
            goto L_0x0226
        L_0x0043:
            r3 = 36
            goto L_0x0226
        L_0x0047:
            java.lang.String r0 = "textLength"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0051
            goto L_0x0226
        L_0x0051:
            r3 = 35
            goto L_0x0226
        L_0x0055:
            java.lang.String r0 = "strokeLinecap"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x005f
            goto L_0x0226
        L_0x005f:
            r3 = 34
            goto L_0x0226
        L_0x0063:
            java.lang.String r0 = "content"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x006d
            goto L_0x0226
        L_0x006d:
            r3 = 33
            goto L_0x0226
        L_0x0071:
            java.lang.String r0 = "clipRule"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x007b
            goto L_0x0226
        L_0x007b:
            r3 = 32
            goto L_0x0226
        L_0x007f:
            java.lang.String r0 = "clipPath"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0089
            goto L_0x0226
        L_0x0089:
            r3 = 31
            goto L_0x0226
        L_0x008d:
            java.lang.String r0 = "inlineSize"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0097
            goto L_0x0226
        L_0x0097:
            r3 = 30
            goto L_0x0226
        L_0x009b:
            java.lang.String r0 = "strokeDasharray"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00a5
            goto L_0x0226
        L_0x00a5:
            r3 = 29
            goto L_0x0226
        L_0x00a9:
            java.lang.String r0 = "fontSize"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00b3
            goto L_0x0226
        L_0x00b3:
            r3 = 28
            goto L_0x0226
        L_0x00b7:
            java.lang.String r0 = "baselineShift"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00c1
            goto L_0x0226
        L_0x00c1:
            r3 = 27
            goto L_0x0226
        L_0x00c5:
            java.lang.String r0 = "markerStart"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00cf
            goto L_0x0226
        L_0x00cf:
            r3 = 26
            goto L_0x0226
        L_0x00d3:
            java.lang.String r0 = "vectorEffect"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00dd
            goto L_0x0226
        L_0x00dd:
            r3 = 25
            goto L_0x0226
        L_0x00e1:
            java.lang.String r0 = "strokeMiterlimit"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00eb
            goto L_0x0226
        L_0x00eb:
            r3 = 24
            goto L_0x0226
        L_0x00ef:
            java.lang.String r0 = "name"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00f9
            goto L_0x0226
        L_0x00f9:
            r3 = 23
            goto L_0x0226
        L_0x00fd:
            java.lang.String r0 = "mask"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0107
            goto L_0x0226
        L_0x0107:
            r3 = 22
            goto L_0x0226
        L_0x010b:
            java.lang.String r0 = "font"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0115
            goto L_0x0226
        L_0x0115:
            r3 = 21
            goto L_0x0226
        L_0x0119:
            java.lang.String r0 = "fill"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0123
            goto L_0x0226
        L_0x0123:
            r3 = 20
            goto L_0x0226
        L_0x0127:
            java.lang.String r0 = "dy"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0131
            goto L_0x0226
        L_0x0131:
            r3 = 19
            goto L_0x0226
        L_0x0135:
            java.lang.String r0 = "dx"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x013f
            goto L_0x0226
        L_0x013f:
            r3 = 18
            goto L_0x0226
        L_0x0143:
            java.lang.String r0 = "y"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x014d
            goto L_0x0226
        L_0x014d:
            r3 = 17
            goto L_0x0226
        L_0x0151:
            java.lang.String r0 = "x"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x015b
            goto L_0x0226
        L_0x015b:
            r3 = 16
            goto L_0x0226
        L_0x015f:
            java.lang.String r0 = "strokeDashoffset"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0169
            goto L_0x0226
        L_0x0169:
            r3 = 15
            goto L_0x0226
        L_0x016d:
            java.lang.String r0 = "fillOpacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0177
            goto L_0x0226
        L_0x0177:
            r3 = 14
            goto L_0x0226
        L_0x017b:
            java.lang.String r0 = "pointerEvents"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0185
            goto L_0x0226
        L_0x0185:
            r3 = 13
            goto L_0x0226
        L_0x0189:
            java.lang.String r0 = "strokeOpacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0193
            goto L_0x0226
        L_0x0193:
            r3 = 12
            goto L_0x0226
        L_0x0197:
            java.lang.String r0 = "fillRule"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01a1
            goto L_0x0226
        L_0x01a1:
            r3 = 11
            goto L_0x0226
        L_0x01a5:
            java.lang.String r0 = "fontWeight"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01af
            goto L_0x0226
        L_0x01af:
            r3 = 10
            goto L_0x0226
        L_0x01b3:
            java.lang.String r0 = "stroke"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01bd
            goto L_0x0226
        L_0x01bd:
            r3 = 9
            goto L_0x0226
        L_0x01c1:
            java.lang.String r0 = "rotate"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01cb
            goto L_0x0226
        L_0x01cb:
            r3 = 8
            goto L_0x0226
        L_0x01cf:
            java.lang.String r0 = "markerMid"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01d8
            goto L_0x0226
        L_0x01d8:
            r3 = 7
            goto L_0x0226
        L_0x01da:
            java.lang.String r0 = "markerEnd"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01e3
            goto L_0x0226
        L_0x01e3:
            r3 = 6
            goto L_0x0226
        L_0x01e5:
            java.lang.String r0 = "propList"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01ee
            goto L_0x0226
        L_0x01ee:
            r3 = 5
            goto L_0x0226
        L_0x01f0:
            java.lang.String r0 = "matrix"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01f9
            goto L_0x0226
        L_0x01f9:
            r3 = 4
            goto L_0x0226
        L_0x01fb:
            java.lang.String r0 = "verticalAlign"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0204
            goto L_0x0226
        L_0x0204:
            r3 = 3
            goto L_0x0226
        L_0x0206:
            java.lang.String r0 = "alignmentBaseline"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x020f
            goto L_0x0226
        L_0x020f:
            r3 = 2
            goto L_0x0226
        L_0x0211:
            java.lang.String r0 = "opacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x021a
            goto L_0x0226
        L_0x021a:
            r3 = r1
            goto L_0x0226
        L_0x021c:
            java.lang.String r0 = "lengthAdjust"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0225
            goto L_0x0226
        L_0x0225:
            r3 = r2
        L_0x0226:
            r0 = 0
            r4 = 1065353216(0x3f800000, float:1.0)
            r5 = 0
            switch(r3) {
                case 0: goto L_0x0477;
                case 1: goto L_0x0466;
                case 2: goto L_0x0458;
                case 3: goto L_0x044b;
                case 4: goto L_0x0441;
                case 5: goto L_0x0437;
                case 6: goto L_0x0429;
                case 7: goto L_0x041b;
                case 8: goto L_0x040d;
                case 9: goto L_0x0402;
                case 10: goto L_0x03f4;
                case 11: goto L_0x03e2;
                case 12: goto L_0x03d0;
                case 13: goto L_0x03c1;
                case 14: goto L_0x03af;
                case 15: goto L_0x039d;
                case 16: goto L_0x038f;
                case 17: goto L_0x0381;
                case 18: goto L_0x0373;
                case 19: goto L_0x0365;
                case 20: goto L_0x035a;
                case 21: goto L_0x034c;
                case 22: goto L_0x033d;
                case 23: goto L_0x032e;
                case 24: goto L_0x031c;
                case 25: goto L_0x030a;
                case 26: goto L_0x02fb;
                case 27: goto L_0x02ed;
                case 28: goto L_0x02df;
                case 29: goto L_0x02d1;
                case 30: goto L_0x02c3;
                case 31: goto L_0x02b4;
                case 32: goto L_0x02a2;
                case 33: goto L_0x0293;
                case 34: goto L_0x0281;
                case 35: goto L_0x0273;
                case 36: goto L_0x0264;
                case 37: goto L_0x0252;
                case 38: goto L_0x0240;
                case 39: goto L_0x0232;
                default: goto L_0x022d;
            }
        L_0x022d:
            super.setProperty(r7, r8, r9)
            goto L_0x0484
        L_0x0232:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setStrokeWidth(r7, r0)
            goto L_0x0484
        L_0x0240:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            if (r9 != 0) goto L_0x0247
            goto L_0x024d
        L_0x0247:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r2 = r9.booleanValue()
        L_0x024d:
            r8.setResponsible(r7, r2)
            goto L_0x0484
        L_0x0252:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            if (r9 != 0) goto L_0x0259
            goto L_0x025f
        L_0x0259:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x025f:
            r8.setStrokeLinejoin(r7, r2)
            goto L_0x0484
        L_0x0264:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            if (r9 != 0) goto L_0x026b
            goto L_0x026e
        L_0x026b:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x026e:
            r8.setDisplay(r7, r5)
            goto L_0x0484
        L_0x0273:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setTextLength(r7, r0)
            goto L_0x0484
        L_0x0281:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            if (r9 != 0) goto L_0x0288
            goto L_0x028e
        L_0x0288:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x028e:
            r8.setStrokeLinecap(r7, r2)
            goto L_0x0484
        L_0x0293:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            if (r9 != 0) goto L_0x029a
            goto L_0x029d
        L_0x029a:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x029d:
            r8.setContent(r7, r5)
            goto L_0x0484
        L_0x02a2:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            if (r9 != 0) goto L_0x02a9
            goto L_0x02af
        L_0x02a9:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x02af:
            r8.setClipRule(r7, r2)
            goto L_0x0484
        L_0x02b4:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            if (r9 != 0) goto L_0x02bb
            goto L_0x02be
        L_0x02bb:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x02be:
            r8.setClipPath(r7, r5)
            goto L_0x0484
        L_0x02c3:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setInlineSize(r7, r0)
            goto L_0x0484
        L_0x02d1:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setStrokeDasharray(r7, r0)
            goto L_0x0484
        L_0x02df:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setFontSize(r7, r0)
            goto L_0x0484
        L_0x02ed:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setBaselineShift(r7, r0)
            goto L_0x0484
        L_0x02fb:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            if (r9 != 0) goto L_0x0302
            goto L_0x0305
        L_0x0302:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0305:
            r8.setMarkerStart(r7, r5)
            goto L_0x0484
        L_0x030a:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            if (r9 != 0) goto L_0x0311
            goto L_0x0317
        L_0x0311:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x0317:
            r8.setVectorEffect(r7, r2)
            goto L_0x0484
        L_0x031c:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            if (r9 != 0) goto L_0x0323
            goto L_0x0329
        L_0x0323:
            java.lang.Double r9 = (java.lang.Double) r9
            float r0 = r9.floatValue()
        L_0x0329:
            r8.setStrokeMiterlimit(r7, r0)
            goto L_0x0484
        L_0x032e:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            if (r9 != 0) goto L_0x0335
            goto L_0x0338
        L_0x0335:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0338:
            r8.setName(r7, r5)
            goto L_0x0484
        L_0x033d:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            if (r9 != 0) goto L_0x0344
            goto L_0x0347
        L_0x0344:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0347:
            r8.setMask(r7, r5)
            goto L_0x0484
        L_0x034c:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setFont(r7, r0)
            goto L_0x0484
        L_0x035a:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setFill(r7, r9)
            goto L_0x0484
        L_0x0365:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setDy(r7, r0)
            goto L_0x0484
        L_0x0373:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setDx(r7, r0)
            goto L_0x0484
        L_0x0381:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setY(r7, r0)
            goto L_0x0484
        L_0x038f:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setX(r7, r0)
            goto L_0x0484
        L_0x039d:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            if (r9 != 0) goto L_0x03a4
            goto L_0x03aa
        L_0x03a4:
            java.lang.Double r9 = (java.lang.Double) r9
            float r0 = r9.floatValue()
        L_0x03aa:
            r8.setStrokeDashoffset(r7, r0)
            goto L_0x0484
        L_0x03af:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            if (r9 != 0) goto L_0x03b6
            goto L_0x03bc
        L_0x03b6:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x03bc:
            r8.setFillOpacity(r7, r4)
            goto L_0x0484
        L_0x03c1:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            if (r9 != 0) goto L_0x03c8
            goto L_0x03cb
        L_0x03c8:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x03cb:
            r8.setPointerEvents(r7, r5)
            goto L_0x0484
        L_0x03d0:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            if (r9 != 0) goto L_0x03d7
            goto L_0x03dd
        L_0x03d7:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x03dd:
            r8.setStrokeOpacity(r7, r4)
            goto L_0x0484
        L_0x03e2:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            if (r9 != 0) goto L_0x03e9
            goto L_0x03ef
        L_0x03e9:
            java.lang.Double r9 = (java.lang.Double) r9
            int r1 = r9.intValue()
        L_0x03ef:
            r8.setFillRule(r7, r1)
            goto L_0x0484
        L_0x03f4:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setFontWeight(r7, r0)
            goto L_0x0484
        L_0x0402:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setStroke(r7, r9)
            goto L_0x0484
        L_0x040d:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setRotate(r7, r0)
            goto L_0x0484
        L_0x041b:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            if (r9 != 0) goto L_0x0422
            goto L_0x0425
        L_0x0422:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0425:
            r8.setMarkerMid(r7, r5)
            goto L_0x0484
        L_0x0429:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            if (r9 != 0) goto L_0x0430
            goto L_0x0433
        L_0x0430:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0433:
            r8.setMarkerEnd(r7, r5)
            goto L_0x0484
        L_0x0437:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setPropList(r7, r9)
            goto L_0x0484
        L_0x0441:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setMatrix(r7, r9)
            goto L_0x0484
        L_0x044b:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setVerticalAlign(r7, r0)
            goto L_0x0484
        L_0x0458:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            if (r9 != 0) goto L_0x045f
            goto L_0x0462
        L_0x045f:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0462:
            r8.setAlignmentBaseline(r7, r5)
            goto L_0x0484
        L_0x0466:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            if (r9 != 0) goto L_0x046d
            goto L_0x0473
        L_0x046d:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x0473:
            r8.setOpacity(r7, r4)
            goto L_0x0484
        L_0x0477:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGTSpanManagerInterface) r8
            if (r9 != 0) goto L_0x047e
            goto L_0x0481
        L_0x047e:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0481:
            r8.setLengthAdjust(r7, r5)
        L_0x0484:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.RNSVGTSpanManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
