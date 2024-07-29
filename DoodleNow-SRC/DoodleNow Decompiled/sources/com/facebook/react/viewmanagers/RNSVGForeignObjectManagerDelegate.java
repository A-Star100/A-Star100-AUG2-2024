package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface;

public class RNSVGForeignObjectManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & RNSVGForeignObjectManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public RNSVGForeignObjectManagerDelegate(U u) {
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
                case -1267206133: goto L_0x01ac;
                case -1221029593: goto L_0x01a1;
                case -1081239615: goto L_0x0196;
                case -993894751: goto L_0x018b;
                case -933864895: goto L_0x0180;
                case -933857362: goto L_0x0175;
                case -891980232: goto L_0x016a;
                case -734428249: goto L_0x015f;
                case -729118945: goto L_0x0151;
                case -416535885: goto L_0x0143;
                case -293492298: goto L_0x0135;
                case -53677816: goto L_0x0127;
                case -44578051: goto L_0x0119;
                case 120: goto L_0x010b;
                case 121: goto L_0x00fd;
                case 3143043: goto L_0x00ef;
                case 3148879: goto L_0x00e1;
                case 3344108: goto L_0x00d3;
                case 3373707: goto L_0x00c5;
                case 78845486: goto L_0x00b7;
                case 104482996: goto L_0x00a9;
                case 113126854: goto L_0x009b;
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
            goto L_0x01b6
        L_0x000f:
            java.lang.String r0 = "strokeWidth"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0019
            goto L_0x01b6
        L_0x0019:
            r3 = 31
            goto L_0x01b6
        L_0x001d:
            java.lang.String r0 = "responsible"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0027
            goto L_0x01b6
        L_0x0027:
            r3 = 30
            goto L_0x01b6
        L_0x002b:
            java.lang.String r0 = "strokeLinejoin"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0035
            goto L_0x01b6
        L_0x0035:
            r3 = 29
            goto L_0x01b6
        L_0x0039:
            java.lang.String r0 = "display"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0043
            goto L_0x01b6
        L_0x0043:
            r3 = 28
            goto L_0x01b6
        L_0x0047:
            java.lang.String r0 = "strokeLinecap"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0051
            goto L_0x01b6
        L_0x0051:
            r3 = 27
            goto L_0x01b6
        L_0x0055:
            java.lang.String r0 = "clipRule"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x005f
            goto L_0x01b6
        L_0x005f:
            r3 = 26
            goto L_0x01b6
        L_0x0063:
            java.lang.String r0 = "clipPath"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x006d
            goto L_0x01b6
        L_0x006d:
            r3 = 25
            goto L_0x01b6
        L_0x0071:
            java.lang.String r0 = "strokeDasharray"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x007b
            goto L_0x01b6
        L_0x007b:
            r3 = 24
            goto L_0x01b6
        L_0x007f:
            java.lang.String r0 = "fontSize"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0089
            goto L_0x01b6
        L_0x0089:
            r3 = 23
            goto L_0x01b6
        L_0x008d:
            java.lang.String r0 = "markerStart"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0097
            goto L_0x01b6
        L_0x0097:
            r3 = 22
            goto L_0x01b6
        L_0x009b:
            java.lang.String r0 = "width"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00a5
            goto L_0x01b6
        L_0x00a5:
            r3 = 21
            goto L_0x01b6
        L_0x00a9:
            java.lang.String r0 = "vectorEffect"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00b3
            goto L_0x01b6
        L_0x00b3:
            r3 = 20
            goto L_0x01b6
        L_0x00b7:
            java.lang.String r0 = "strokeMiterlimit"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00c1
            goto L_0x01b6
        L_0x00c1:
            r3 = 19
            goto L_0x01b6
        L_0x00c5:
            java.lang.String r0 = "name"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00cf
            goto L_0x01b6
        L_0x00cf:
            r3 = 18
            goto L_0x01b6
        L_0x00d3:
            java.lang.String r0 = "mask"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00dd
            goto L_0x01b6
        L_0x00dd:
            r3 = 17
            goto L_0x01b6
        L_0x00e1:
            java.lang.String r0 = "font"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00eb
            goto L_0x01b6
        L_0x00eb:
            r3 = 16
            goto L_0x01b6
        L_0x00ef:
            java.lang.String r0 = "fill"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00f9
            goto L_0x01b6
        L_0x00f9:
            r3 = 15
            goto L_0x01b6
        L_0x00fd:
            java.lang.String r0 = "y"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0107
            goto L_0x01b6
        L_0x0107:
            r3 = 14
            goto L_0x01b6
        L_0x010b:
            java.lang.String r0 = "x"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0115
            goto L_0x01b6
        L_0x0115:
            r3 = 13
            goto L_0x01b6
        L_0x0119:
            java.lang.String r0 = "strokeDashoffset"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0123
            goto L_0x01b6
        L_0x0123:
            r3 = 12
            goto L_0x01b6
        L_0x0127:
            java.lang.String r0 = "fillOpacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0131
            goto L_0x01b6
        L_0x0131:
            r3 = 11
            goto L_0x01b6
        L_0x0135:
            java.lang.String r0 = "pointerEvents"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x013f
            goto L_0x01b6
        L_0x013f:
            r3 = 10
            goto L_0x01b6
        L_0x0143:
            java.lang.String r0 = "strokeOpacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x014d
            goto L_0x01b6
        L_0x014d:
            r3 = 9
            goto L_0x01b6
        L_0x0151:
            java.lang.String r0 = "fillRule"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x015b
            goto L_0x01b6
        L_0x015b:
            r3 = 8
            goto L_0x01b6
        L_0x015f:
            java.lang.String r0 = "fontWeight"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0168
            goto L_0x01b6
        L_0x0168:
            r3 = 7
            goto L_0x01b6
        L_0x016a:
            java.lang.String r0 = "stroke"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0173
            goto L_0x01b6
        L_0x0173:
            r3 = 6
            goto L_0x01b6
        L_0x0175:
            java.lang.String r0 = "markerMid"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x017e
            goto L_0x01b6
        L_0x017e:
            r3 = 5
            goto L_0x01b6
        L_0x0180:
            java.lang.String r0 = "markerEnd"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0189
            goto L_0x01b6
        L_0x0189:
            r3 = 4
            goto L_0x01b6
        L_0x018b:
            java.lang.String r0 = "propList"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0194
            goto L_0x01b6
        L_0x0194:
            r3 = 3
            goto L_0x01b6
        L_0x0196:
            java.lang.String r0 = "matrix"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x019f
            goto L_0x01b6
        L_0x019f:
            r3 = 2
            goto L_0x01b6
        L_0x01a1:
            java.lang.String r0 = "height"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01aa
            goto L_0x01b6
        L_0x01aa:
            r3 = r1
            goto L_0x01b6
        L_0x01ac:
            java.lang.String r0 = "opacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01b5
            goto L_0x01b6
        L_0x01b5:
            r3 = r2
        L_0x01b6:
            r0 = 0
            r4 = 1065353216(0x3f800000, float:1.0)
            r5 = 0
            switch(r3) {
                case 0: goto L_0x0390;
                case 1: goto L_0x0383;
                case 2: goto L_0x0379;
                case 3: goto L_0x036f;
                case 4: goto L_0x0361;
                case 5: goto L_0x0353;
                case 6: goto L_0x0349;
                case 7: goto L_0x033c;
                case 8: goto L_0x032b;
                case 9: goto L_0x0319;
                case 10: goto L_0x030a;
                case 11: goto L_0x02f8;
                case 12: goto L_0x02e6;
                case 13: goto L_0x02d8;
                case 14: goto L_0x02ca;
                case 15: goto L_0x02bf;
                case 16: goto L_0x02b1;
                case 17: goto L_0x02a2;
                case 18: goto L_0x0293;
                case 19: goto L_0x0281;
                case 20: goto L_0x026f;
                case 21: goto L_0x0261;
                case 22: goto L_0x0252;
                case 23: goto L_0x0244;
                case 24: goto L_0x0236;
                case 25: goto L_0x0227;
                case 26: goto L_0x0215;
                case 27: goto L_0x0203;
                case 28: goto L_0x01f4;
                case 29: goto L_0x01e2;
                case 30: goto L_0x01d0;
                case 31: goto L_0x01c2;
                default: goto L_0x01bd;
            }
        L_0x01bd:
            super.setProperty(r7, r8, r9)
            goto L_0x03a0
        L_0x01c2:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setStrokeWidth(r7, r0)
            goto L_0x03a0
        L_0x01d0:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface) r8
            if (r9 != 0) goto L_0x01d7
            goto L_0x01dd
        L_0x01d7:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r2 = r9.booleanValue()
        L_0x01dd:
            r8.setResponsible(r7, r2)
            goto L_0x03a0
        L_0x01e2:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface) r8
            if (r9 != 0) goto L_0x01e9
            goto L_0x01ef
        L_0x01e9:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x01ef:
            r8.setStrokeLinejoin(r7, r2)
            goto L_0x03a0
        L_0x01f4:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface) r8
            if (r9 != 0) goto L_0x01fb
            goto L_0x01fe
        L_0x01fb:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x01fe:
            r8.setDisplay(r7, r5)
            goto L_0x03a0
        L_0x0203:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface) r8
            if (r9 != 0) goto L_0x020a
            goto L_0x0210
        L_0x020a:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x0210:
            r8.setStrokeLinecap(r7, r2)
            goto L_0x03a0
        L_0x0215:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface) r8
            if (r9 != 0) goto L_0x021c
            goto L_0x0222
        L_0x021c:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x0222:
            r8.setClipRule(r7, r2)
            goto L_0x03a0
        L_0x0227:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface) r8
            if (r9 != 0) goto L_0x022e
            goto L_0x0231
        L_0x022e:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0231:
            r8.setClipPath(r7, r5)
            goto L_0x03a0
        L_0x0236:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setStrokeDasharray(r7, r0)
            goto L_0x03a0
        L_0x0244:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setFontSize(r7, r0)
            goto L_0x03a0
        L_0x0252:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface) r8
            if (r9 != 0) goto L_0x0259
            goto L_0x025c
        L_0x0259:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x025c:
            r8.setMarkerStart(r7, r5)
            goto L_0x03a0
        L_0x0261:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setWidth(r7, r0)
            goto L_0x03a0
        L_0x026f:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface) r8
            if (r9 != 0) goto L_0x0276
            goto L_0x027c
        L_0x0276:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x027c:
            r8.setVectorEffect(r7, r2)
            goto L_0x03a0
        L_0x0281:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface) r8
            if (r9 != 0) goto L_0x0288
            goto L_0x028e
        L_0x0288:
            java.lang.Double r9 = (java.lang.Double) r9
            float r0 = r9.floatValue()
        L_0x028e:
            r8.setStrokeMiterlimit(r7, r0)
            goto L_0x03a0
        L_0x0293:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface) r8
            if (r9 != 0) goto L_0x029a
            goto L_0x029d
        L_0x029a:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x029d:
            r8.setName(r7, r5)
            goto L_0x03a0
        L_0x02a2:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface) r8
            if (r9 != 0) goto L_0x02a9
            goto L_0x02ac
        L_0x02a9:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x02ac:
            r8.setMask(r7, r5)
            goto L_0x03a0
        L_0x02b1:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setFont(r7, r0)
            goto L_0x03a0
        L_0x02bf:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setFill(r7, r9)
            goto L_0x03a0
        L_0x02ca:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setY(r7, r0)
            goto L_0x03a0
        L_0x02d8:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setX(r7, r0)
            goto L_0x03a0
        L_0x02e6:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface) r8
            if (r9 != 0) goto L_0x02ed
            goto L_0x02f3
        L_0x02ed:
            java.lang.Double r9 = (java.lang.Double) r9
            float r0 = r9.floatValue()
        L_0x02f3:
            r8.setStrokeDashoffset(r7, r0)
            goto L_0x03a0
        L_0x02f8:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface) r8
            if (r9 != 0) goto L_0x02ff
            goto L_0x0305
        L_0x02ff:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x0305:
            r8.setFillOpacity(r7, r4)
            goto L_0x03a0
        L_0x030a:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface) r8
            if (r9 != 0) goto L_0x0311
            goto L_0x0314
        L_0x0311:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0314:
            r8.setPointerEvents(r7, r5)
            goto L_0x03a0
        L_0x0319:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface) r8
            if (r9 != 0) goto L_0x0320
            goto L_0x0326
        L_0x0320:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x0326:
            r8.setStrokeOpacity(r7, r4)
            goto L_0x03a0
        L_0x032b:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface) r8
            if (r9 != 0) goto L_0x0332
            goto L_0x0338
        L_0x0332:
            java.lang.Double r9 = (java.lang.Double) r9
            int r1 = r9.intValue()
        L_0x0338:
            r8.setFillRule(r7, r1)
            goto L_0x03a0
        L_0x033c:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setFontWeight(r7, r0)
            goto L_0x03a0
        L_0x0349:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setStroke(r7, r9)
            goto L_0x03a0
        L_0x0353:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface) r8
            if (r9 != 0) goto L_0x035a
            goto L_0x035d
        L_0x035a:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x035d:
            r8.setMarkerMid(r7, r5)
            goto L_0x03a0
        L_0x0361:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface) r8
            if (r9 != 0) goto L_0x0368
            goto L_0x036b
        L_0x0368:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x036b:
            r8.setMarkerEnd(r7, r5)
            goto L_0x03a0
        L_0x036f:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setPropList(r7, r9)
            goto L_0x03a0
        L_0x0379:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setMatrix(r7, r9)
            goto L_0x03a0
        L_0x0383:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setHeight(r7, r0)
            goto L_0x03a0
        L_0x0390:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGForeignObjectManagerInterface) r8
            if (r9 != 0) goto L_0x0397
            goto L_0x039d
        L_0x0397:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x039d:
            r8.setOpacity(r7, r4)
        L_0x03a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.RNSVGForeignObjectManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
