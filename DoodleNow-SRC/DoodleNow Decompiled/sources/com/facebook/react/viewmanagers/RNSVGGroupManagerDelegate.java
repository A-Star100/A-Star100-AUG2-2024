package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.RNSVGGroupManagerInterface;

public class RNSVGGroupManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & RNSVGGroupManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public RNSVGGroupManagerDelegate(U u) {
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
                case -1267206133: goto L_0x0174;
                case -1081239615: goto L_0x0169;
                case -993894751: goto L_0x015e;
                case -933864895: goto L_0x0153;
                case -933857362: goto L_0x0148;
                case -891980232: goto L_0x013d;
                case -734428249: goto L_0x0132;
                case -729118945: goto L_0x0127;
                case -416535885: goto L_0x0119;
                case -293492298: goto L_0x010b;
                case -53677816: goto L_0x00fd;
                case -44578051: goto L_0x00ef;
                case 3143043: goto L_0x00e1;
                case 3148879: goto L_0x00d3;
                case 3344108: goto L_0x00c5;
                case 3373707: goto L_0x00b7;
                case 78845486: goto L_0x00a9;
                case 104482996: goto L_0x009b;
                case 217109576: goto L_0x008d;
                case 365601008: goto L_0x007f;
                case 401643183: goto L_0x0071;
                case 917656469: goto L_0x0063;
                case 917735020: goto L_0x0055;
                case 1027575302: goto L_0x0047;
                case 1671764162: goto L_0x0039;
                case 1790285174: goto L_0x002b;
                case 1847674614: goto L_0x001d;
                case 1924065902: goto L_0x000f;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x017e
        L_0x000f:
            java.lang.String r0 = "strokeWidth"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0019
            goto L_0x017e
        L_0x0019:
            r3 = 27
            goto L_0x017e
        L_0x001d:
            java.lang.String r0 = "responsible"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0027
            goto L_0x017e
        L_0x0027:
            r3 = 26
            goto L_0x017e
        L_0x002b:
            java.lang.String r0 = "strokeLinejoin"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0035
            goto L_0x017e
        L_0x0035:
            r3 = 25
            goto L_0x017e
        L_0x0039:
            java.lang.String r0 = "display"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0043
            goto L_0x017e
        L_0x0043:
            r3 = 24
            goto L_0x017e
        L_0x0047:
            java.lang.String r0 = "strokeLinecap"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0051
            goto L_0x017e
        L_0x0051:
            r3 = 23
            goto L_0x017e
        L_0x0055:
            java.lang.String r0 = "clipRule"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x005f
            goto L_0x017e
        L_0x005f:
            r3 = 22
            goto L_0x017e
        L_0x0063:
            java.lang.String r0 = "clipPath"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x006d
            goto L_0x017e
        L_0x006d:
            r3 = 21
            goto L_0x017e
        L_0x0071:
            java.lang.String r0 = "strokeDasharray"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x007b
            goto L_0x017e
        L_0x007b:
            r3 = 20
            goto L_0x017e
        L_0x007f:
            java.lang.String r0 = "fontSize"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0089
            goto L_0x017e
        L_0x0089:
            r3 = 19
            goto L_0x017e
        L_0x008d:
            java.lang.String r0 = "markerStart"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0097
            goto L_0x017e
        L_0x0097:
            r3 = 18
            goto L_0x017e
        L_0x009b:
            java.lang.String r0 = "vectorEffect"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00a5
            goto L_0x017e
        L_0x00a5:
            r3 = 17
            goto L_0x017e
        L_0x00a9:
            java.lang.String r0 = "strokeMiterlimit"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00b3
            goto L_0x017e
        L_0x00b3:
            r3 = 16
            goto L_0x017e
        L_0x00b7:
            java.lang.String r0 = "name"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00c1
            goto L_0x017e
        L_0x00c1:
            r3 = 15
            goto L_0x017e
        L_0x00c5:
            java.lang.String r0 = "mask"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00cf
            goto L_0x017e
        L_0x00cf:
            r3 = 14
            goto L_0x017e
        L_0x00d3:
            java.lang.String r0 = "font"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00dd
            goto L_0x017e
        L_0x00dd:
            r3 = 13
            goto L_0x017e
        L_0x00e1:
            java.lang.String r0 = "fill"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00eb
            goto L_0x017e
        L_0x00eb:
            r3 = 12
            goto L_0x017e
        L_0x00ef:
            java.lang.String r0 = "strokeDashoffset"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00f9
            goto L_0x017e
        L_0x00f9:
            r3 = 11
            goto L_0x017e
        L_0x00fd:
            java.lang.String r0 = "fillOpacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0107
            goto L_0x017e
        L_0x0107:
            r3 = 10
            goto L_0x017e
        L_0x010b:
            java.lang.String r0 = "pointerEvents"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0115
            goto L_0x017e
        L_0x0115:
            r3 = 9
            goto L_0x017e
        L_0x0119:
            java.lang.String r0 = "strokeOpacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0123
            goto L_0x017e
        L_0x0123:
            r3 = 8
            goto L_0x017e
        L_0x0127:
            java.lang.String r0 = "fillRule"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0130
            goto L_0x017e
        L_0x0130:
            r3 = 7
            goto L_0x017e
        L_0x0132:
            java.lang.String r0 = "fontWeight"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x013b
            goto L_0x017e
        L_0x013b:
            r3 = 6
            goto L_0x017e
        L_0x013d:
            java.lang.String r0 = "stroke"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0146
            goto L_0x017e
        L_0x0146:
            r3 = 5
            goto L_0x017e
        L_0x0148:
            java.lang.String r0 = "markerMid"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0151
            goto L_0x017e
        L_0x0151:
            r3 = 4
            goto L_0x017e
        L_0x0153:
            java.lang.String r0 = "markerEnd"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x015c
            goto L_0x017e
        L_0x015c:
            r3 = 3
            goto L_0x017e
        L_0x015e:
            java.lang.String r0 = "propList"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0167
            goto L_0x017e
        L_0x0167:
            r3 = 2
            goto L_0x017e
        L_0x0169:
            java.lang.String r0 = "matrix"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0172
            goto L_0x017e
        L_0x0172:
            r3 = r1
            goto L_0x017e
        L_0x0174:
            java.lang.String r0 = "opacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x017d
            goto L_0x017e
        L_0x017d:
            r3 = r2
        L_0x017e:
            r0 = 0
            r4 = 1065353216(0x3f800000, float:1.0)
            r5 = 0
            switch(r3) {
                case 0: goto L_0x0321;
                case 1: goto L_0x0317;
                case 2: goto L_0x030d;
                case 3: goto L_0x02ff;
                case 4: goto L_0x02f1;
                case 5: goto L_0x02e7;
                case 6: goto L_0x02da;
                case 7: goto L_0x02c9;
                case 8: goto L_0x02b7;
                case 9: goto L_0x02a8;
                case 10: goto L_0x0296;
                case 11: goto L_0x0284;
                case 12: goto L_0x0279;
                case 13: goto L_0x026b;
                case 14: goto L_0x025c;
                case 15: goto L_0x024d;
                case 16: goto L_0x023b;
                case 17: goto L_0x0229;
                case 18: goto L_0x021a;
                case 19: goto L_0x020c;
                case 20: goto L_0x01fe;
                case 21: goto L_0x01ef;
                case 22: goto L_0x01dd;
                case 23: goto L_0x01cb;
                case 24: goto L_0x01bc;
                case 25: goto L_0x01aa;
                case 26: goto L_0x0198;
                case 27: goto L_0x018a;
                default: goto L_0x0185;
            }
        L_0x0185:
            super.setProperty(r7, r8, r9)
            goto L_0x0331
        L_0x018a:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGGroupManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGGroupManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setStrokeWidth(r7, r0)
            goto L_0x0331
        L_0x0198:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGGroupManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGGroupManagerInterface) r8
            if (r9 != 0) goto L_0x019f
            goto L_0x01a5
        L_0x019f:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r2 = r9.booleanValue()
        L_0x01a5:
            r8.setResponsible(r7, r2)
            goto L_0x0331
        L_0x01aa:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGGroupManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGGroupManagerInterface) r8
            if (r9 != 0) goto L_0x01b1
            goto L_0x01b7
        L_0x01b1:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x01b7:
            r8.setStrokeLinejoin(r7, r2)
            goto L_0x0331
        L_0x01bc:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGGroupManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGGroupManagerInterface) r8
            if (r9 != 0) goto L_0x01c3
            goto L_0x01c6
        L_0x01c3:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x01c6:
            r8.setDisplay(r7, r5)
            goto L_0x0331
        L_0x01cb:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGGroupManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGGroupManagerInterface) r8
            if (r9 != 0) goto L_0x01d2
            goto L_0x01d8
        L_0x01d2:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x01d8:
            r8.setStrokeLinecap(r7, r2)
            goto L_0x0331
        L_0x01dd:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGGroupManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGGroupManagerInterface) r8
            if (r9 != 0) goto L_0x01e4
            goto L_0x01ea
        L_0x01e4:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x01ea:
            r8.setClipRule(r7, r2)
            goto L_0x0331
        L_0x01ef:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGGroupManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGGroupManagerInterface) r8
            if (r9 != 0) goto L_0x01f6
            goto L_0x01f9
        L_0x01f6:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x01f9:
            r8.setClipPath(r7, r5)
            goto L_0x0331
        L_0x01fe:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGGroupManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGGroupManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setStrokeDasharray(r7, r0)
            goto L_0x0331
        L_0x020c:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGGroupManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGGroupManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setFontSize(r7, r0)
            goto L_0x0331
        L_0x021a:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGGroupManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGGroupManagerInterface) r8
            if (r9 != 0) goto L_0x0221
            goto L_0x0224
        L_0x0221:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0224:
            r8.setMarkerStart(r7, r5)
            goto L_0x0331
        L_0x0229:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGGroupManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGGroupManagerInterface) r8
            if (r9 != 0) goto L_0x0230
            goto L_0x0236
        L_0x0230:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x0236:
            r8.setVectorEffect(r7, r2)
            goto L_0x0331
        L_0x023b:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGGroupManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGGroupManagerInterface) r8
            if (r9 != 0) goto L_0x0242
            goto L_0x0248
        L_0x0242:
            java.lang.Double r9 = (java.lang.Double) r9
            float r0 = r9.floatValue()
        L_0x0248:
            r8.setStrokeMiterlimit(r7, r0)
            goto L_0x0331
        L_0x024d:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGGroupManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGGroupManagerInterface) r8
            if (r9 != 0) goto L_0x0254
            goto L_0x0257
        L_0x0254:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0257:
            r8.setName(r7, r5)
            goto L_0x0331
        L_0x025c:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGGroupManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGGroupManagerInterface) r8
            if (r9 != 0) goto L_0x0263
            goto L_0x0266
        L_0x0263:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0266:
            r8.setMask(r7, r5)
            goto L_0x0331
        L_0x026b:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGGroupManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGGroupManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setFont(r7, r0)
            goto L_0x0331
        L_0x0279:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGGroupManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGGroupManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setFill(r7, r9)
            goto L_0x0331
        L_0x0284:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGGroupManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGGroupManagerInterface) r8
            if (r9 != 0) goto L_0x028b
            goto L_0x0291
        L_0x028b:
            java.lang.Double r9 = (java.lang.Double) r9
            float r0 = r9.floatValue()
        L_0x0291:
            r8.setStrokeDashoffset(r7, r0)
            goto L_0x0331
        L_0x0296:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGGroupManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGGroupManagerInterface) r8
            if (r9 != 0) goto L_0x029d
            goto L_0x02a3
        L_0x029d:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x02a3:
            r8.setFillOpacity(r7, r4)
            goto L_0x0331
        L_0x02a8:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGGroupManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGGroupManagerInterface) r8
            if (r9 != 0) goto L_0x02af
            goto L_0x02b2
        L_0x02af:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x02b2:
            r8.setPointerEvents(r7, r5)
            goto L_0x0331
        L_0x02b7:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGGroupManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGGroupManagerInterface) r8
            if (r9 != 0) goto L_0x02be
            goto L_0x02c4
        L_0x02be:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x02c4:
            r8.setStrokeOpacity(r7, r4)
            goto L_0x0331
        L_0x02c9:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGGroupManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGGroupManagerInterface) r8
            if (r9 != 0) goto L_0x02d0
            goto L_0x02d6
        L_0x02d0:
            java.lang.Double r9 = (java.lang.Double) r9
            int r1 = r9.intValue()
        L_0x02d6:
            r8.setFillRule(r7, r1)
            goto L_0x0331
        L_0x02da:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGGroupManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGGroupManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setFontWeight(r7, r0)
            goto L_0x0331
        L_0x02e7:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGGroupManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGGroupManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setStroke(r7, r9)
            goto L_0x0331
        L_0x02f1:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGGroupManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGGroupManagerInterface) r8
            if (r9 != 0) goto L_0x02f8
            goto L_0x02fb
        L_0x02f8:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x02fb:
            r8.setMarkerMid(r7, r5)
            goto L_0x0331
        L_0x02ff:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGGroupManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGGroupManagerInterface) r8
            if (r9 != 0) goto L_0x0306
            goto L_0x0309
        L_0x0306:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0309:
            r8.setMarkerEnd(r7, r5)
            goto L_0x0331
        L_0x030d:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGGroupManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGGroupManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setPropList(r7, r9)
            goto L_0x0331
        L_0x0317:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGGroupManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGGroupManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setMatrix(r7, r9)
            goto L_0x0331
        L_0x0321:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGGroupManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGGroupManagerInterface) r8
            if (r9 != 0) goto L_0x0328
            goto L_0x032e
        L_0x0328:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x032e:
            r8.setOpacity(r7, r4)
        L_0x0331:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.RNSVGGroupManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
