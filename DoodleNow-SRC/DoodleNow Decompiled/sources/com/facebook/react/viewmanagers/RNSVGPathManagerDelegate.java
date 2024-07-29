package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.RNSVGPathManagerInterface;

public class RNSVGPathManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & RNSVGPathManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public RNSVGPathManagerDelegate(U u) {
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
                case -1267206133: goto L_0x0158;
                case -1081239615: goto L_0x014d;
                case -993894751: goto L_0x0142;
                case -933864895: goto L_0x0137;
                case -933857362: goto L_0x012c;
                case -891980232: goto L_0x0121;
                case -729118945: goto L_0x0116;
                case -416535885: goto L_0x010b;
                case -293492298: goto L_0x00fd;
                case -53677816: goto L_0x00ef;
                case -44578051: goto L_0x00e1;
                case 100: goto L_0x00d3;
                case 3143043: goto L_0x00c5;
                case 3344108: goto L_0x00b7;
                case 3373707: goto L_0x00a9;
                case 78845486: goto L_0x009b;
                case 104482996: goto L_0x008d;
                case 217109576: goto L_0x007f;
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
            goto L_0x0162
        L_0x000f:
            java.lang.String r0 = "strokeWidth"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0019
            goto L_0x0162
        L_0x0019:
            r3 = 25
            goto L_0x0162
        L_0x001d:
            java.lang.String r0 = "responsible"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0027
            goto L_0x0162
        L_0x0027:
            r3 = 24
            goto L_0x0162
        L_0x002b:
            java.lang.String r0 = "strokeLinejoin"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0035
            goto L_0x0162
        L_0x0035:
            r3 = 23
            goto L_0x0162
        L_0x0039:
            java.lang.String r0 = "display"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0043
            goto L_0x0162
        L_0x0043:
            r3 = 22
            goto L_0x0162
        L_0x0047:
            java.lang.String r0 = "strokeLinecap"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0051
            goto L_0x0162
        L_0x0051:
            r3 = 21
            goto L_0x0162
        L_0x0055:
            java.lang.String r0 = "clipRule"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x005f
            goto L_0x0162
        L_0x005f:
            r3 = 20
            goto L_0x0162
        L_0x0063:
            java.lang.String r0 = "clipPath"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x006d
            goto L_0x0162
        L_0x006d:
            r3 = 19
            goto L_0x0162
        L_0x0071:
            java.lang.String r0 = "strokeDasharray"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x007b
            goto L_0x0162
        L_0x007b:
            r3 = 18
            goto L_0x0162
        L_0x007f:
            java.lang.String r0 = "markerStart"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0089
            goto L_0x0162
        L_0x0089:
            r3 = 17
            goto L_0x0162
        L_0x008d:
            java.lang.String r0 = "vectorEffect"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0097
            goto L_0x0162
        L_0x0097:
            r3 = 16
            goto L_0x0162
        L_0x009b:
            java.lang.String r0 = "strokeMiterlimit"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00a5
            goto L_0x0162
        L_0x00a5:
            r3 = 15
            goto L_0x0162
        L_0x00a9:
            java.lang.String r0 = "name"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00b3
            goto L_0x0162
        L_0x00b3:
            r3 = 14
            goto L_0x0162
        L_0x00b7:
            java.lang.String r0 = "mask"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00c1
            goto L_0x0162
        L_0x00c1:
            r3 = 13
            goto L_0x0162
        L_0x00c5:
            java.lang.String r0 = "fill"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00cf
            goto L_0x0162
        L_0x00cf:
            r3 = 12
            goto L_0x0162
        L_0x00d3:
            java.lang.String r0 = "d"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00dd
            goto L_0x0162
        L_0x00dd:
            r3 = 11
            goto L_0x0162
        L_0x00e1:
            java.lang.String r0 = "strokeDashoffset"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00eb
            goto L_0x0162
        L_0x00eb:
            r3 = 10
            goto L_0x0162
        L_0x00ef:
            java.lang.String r0 = "fillOpacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00f9
            goto L_0x0162
        L_0x00f9:
            r3 = 9
            goto L_0x0162
        L_0x00fd:
            java.lang.String r0 = "pointerEvents"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0107
            goto L_0x0162
        L_0x0107:
            r3 = 8
            goto L_0x0162
        L_0x010b:
            java.lang.String r0 = "strokeOpacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0114
            goto L_0x0162
        L_0x0114:
            r3 = 7
            goto L_0x0162
        L_0x0116:
            java.lang.String r0 = "fillRule"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x011f
            goto L_0x0162
        L_0x011f:
            r3 = 6
            goto L_0x0162
        L_0x0121:
            java.lang.String r0 = "stroke"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x012a
            goto L_0x0162
        L_0x012a:
            r3 = 5
            goto L_0x0162
        L_0x012c:
            java.lang.String r0 = "markerMid"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0135
            goto L_0x0162
        L_0x0135:
            r3 = 4
            goto L_0x0162
        L_0x0137:
            java.lang.String r0 = "markerEnd"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0140
            goto L_0x0162
        L_0x0140:
            r3 = 3
            goto L_0x0162
        L_0x0142:
            java.lang.String r0 = "propList"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x014b
            goto L_0x0162
        L_0x014b:
            r3 = 2
            goto L_0x0162
        L_0x014d:
            java.lang.String r0 = "matrix"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0156
            goto L_0x0162
        L_0x0156:
            r3 = r1
            goto L_0x0162
        L_0x0158:
            java.lang.String r0 = "opacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0161
            goto L_0x0162
        L_0x0161:
            r3 = r2
        L_0x0162:
            r0 = 0
            r4 = 1065353216(0x3f800000, float:1.0)
            r5 = 0
            switch(r3) {
                case 0: goto L_0x02ea;
                case 1: goto L_0x02e0;
                case 2: goto L_0x02d6;
                case 3: goto L_0x02c8;
                case 4: goto L_0x02ba;
                case 5: goto L_0x02b0;
                case 6: goto L_0x029f;
                case 7: goto L_0x028e;
                case 8: goto L_0x027f;
                case 9: goto L_0x026d;
                case 10: goto L_0x025b;
                case 11: goto L_0x024c;
                case 12: goto L_0x0241;
                case 13: goto L_0x0232;
                case 14: goto L_0x0223;
                case 15: goto L_0x0211;
                case 16: goto L_0x01ff;
                case 17: goto L_0x01f0;
                case 18: goto L_0x01e2;
                case 19: goto L_0x01d3;
                case 20: goto L_0x01c1;
                case 21: goto L_0x01af;
                case 22: goto L_0x01a0;
                case 23: goto L_0x018e;
                case 24: goto L_0x017c;
                case 25: goto L_0x016e;
                default: goto L_0x0169;
            }
        L_0x0169:
            super.setProperty(r7, r8, r9)
            goto L_0x02fa
        L_0x016e:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setStrokeWidth(r7, r0)
            goto L_0x02fa
        L_0x017c:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            if (r9 != 0) goto L_0x0183
            goto L_0x0189
        L_0x0183:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r2 = r9.booleanValue()
        L_0x0189:
            r8.setResponsible(r7, r2)
            goto L_0x02fa
        L_0x018e:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            if (r9 != 0) goto L_0x0195
            goto L_0x019b
        L_0x0195:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x019b:
            r8.setStrokeLinejoin(r7, r2)
            goto L_0x02fa
        L_0x01a0:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            if (r9 != 0) goto L_0x01a7
            goto L_0x01aa
        L_0x01a7:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x01aa:
            r8.setDisplay(r7, r5)
            goto L_0x02fa
        L_0x01af:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            if (r9 != 0) goto L_0x01b6
            goto L_0x01bc
        L_0x01b6:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x01bc:
            r8.setStrokeLinecap(r7, r2)
            goto L_0x02fa
        L_0x01c1:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            if (r9 != 0) goto L_0x01c8
            goto L_0x01ce
        L_0x01c8:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x01ce:
            r8.setClipRule(r7, r2)
            goto L_0x02fa
        L_0x01d3:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            if (r9 != 0) goto L_0x01da
            goto L_0x01dd
        L_0x01da:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x01dd:
            r8.setClipPath(r7, r5)
            goto L_0x02fa
        L_0x01e2:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setStrokeDasharray(r7, r0)
            goto L_0x02fa
        L_0x01f0:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            if (r9 != 0) goto L_0x01f7
            goto L_0x01fa
        L_0x01f7:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x01fa:
            r8.setMarkerStart(r7, r5)
            goto L_0x02fa
        L_0x01ff:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            if (r9 != 0) goto L_0x0206
            goto L_0x020c
        L_0x0206:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x020c:
            r8.setVectorEffect(r7, r2)
            goto L_0x02fa
        L_0x0211:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            if (r9 != 0) goto L_0x0218
            goto L_0x021e
        L_0x0218:
            java.lang.Double r9 = (java.lang.Double) r9
            float r0 = r9.floatValue()
        L_0x021e:
            r8.setStrokeMiterlimit(r7, r0)
            goto L_0x02fa
        L_0x0223:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            if (r9 != 0) goto L_0x022a
            goto L_0x022d
        L_0x022a:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x022d:
            r8.setName(r7, r5)
            goto L_0x02fa
        L_0x0232:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            if (r9 != 0) goto L_0x0239
            goto L_0x023c
        L_0x0239:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x023c:
            r8.setMask(r7, r5)
            goto L_0x02fa
        L_0x0241:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setFill(r7, r9)
            goto L_0x02fa
        L_0x024c:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            if (r9 != 0) goto L_0x0253
            goto L_0x0256
        L_0x0253:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0256:
            r8.setD(r7, r5)
            goto L_0x02fa
        L_0x025b:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            if (r9 != 0) goto L_0x0262
            goto L_0x0268
        L_0x0262:
            java.lang.Double r9 = (java.lang.Double) r9
            float r0 = r9.floatValue()
        L_0x0268:
            r8.setStrokeDashoffset(r7, r0)
            goto L_0x02fa
        L_0x026d:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            if (r9 != 0) goto L_0x0274
            goto L_0x027a
        L_0x0274:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x027a:
            r8.setFillOpacity(r7, r4)
            goto L_0x02fa
        L_0x027f:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            if (r9 != 0) goto L_0x0286
            goto L_0x0289
        L_0x0286:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0289:
            r8.setPointerEvents(r7, r5)
            goto L_0x02fa
        L_0x028e:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            if (r9 != 0) goto L_0x0295
            goto L_0x029b
        L_0x0295:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x029b:
            r8.setStrokeOpacity(r7, r4)
            goto L_0x02fa
        L_0x029f:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            if (r9 != 0) goto L_0x02a6
            goto L_0x02ac
        L_0x02a6:
            java.lang.Double r9 = (java.lang.Double) r9
            int r1 = r9.intValue()
        L_0x02ac:
            r8.setFillRule(r7, r1)
            goto L_0x02fa
        L_0x02b0:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setStroke(r7, r9)
            goto L_0x02fa
        L_0x02ba:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            if (r9 != 0) goto L_0x02c1
            goto L_0x02c4
        L_0x02c1:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x02c4:
            r8.setMarkerMid(r7, r5)
            goto L_0x02fa
        L_0x02c8:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            if (r9 != 0) goto L_0x02cf
            goto L_0x02d2
        L_0x02cf:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x02d2:
            r8.setMarkerEnd(r7, r5)
            goto L_0x02fa
        L_0x02d6:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setPropList(r7, r9)
            goto L_0x02fa
        L_0x02e0:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setMatrix(r7, r9)
            goto L_0x02fa
        L_0x02ea:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGPathManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGPathManagerInterface) r8
            if (r9 != 0) goto L_0x02f1
            goto L_0x02f7
        L_0x02f1:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x02f7:
            r8.setOpacity(r7, r4)
        L_0x02fa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.RNSVGPathManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
