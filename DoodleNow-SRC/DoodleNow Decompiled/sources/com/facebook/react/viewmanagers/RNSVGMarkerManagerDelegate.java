package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface;

public class RNSVGMarkerManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & RNSVGMarkerManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public RNSVGMarkerManagerDelegate(U u) {
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
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v18, resolved type: boolean} */
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
                case -1567958285: goto L_0x021c;
                case -1267206133: goto L_0x0211;
                case -1081239615: goto L_0x0206;
                case -1008621499: goto L_0x01fb;
                case -993894751: goto L_0x01f0;
                case -933864895: goto L_0x01e5;
                case -933857362: goto L_0x01da;
                case -891980232: goto L_0x01cf;
                case -734428249: goto L_0x01c1;
                case -729118945: goto L_0x01b3;
                case -416535885: goto L_0x01a5;
                case -293492298: goto L_0x0197;
                case -53677816: goto L_0x0189;
                case -44578051: goto L_0x017b;
                case 3143043: goto L_0x016d;
                case 3148879: goto L_0x015f;
                case 3344108: goto L_0x0151;
                case 3351622: goto L_0x0143;
                case 3351623: goto L_0x0135;
                case 3373707: goto L_0x0127;
                case 3496485: goto L_0x0119;
                case 3496486: goto L_0x010b;
                case 78845486: goto L_0x00fd;
                case 92903173: goto L_0x00ef;
                case 104482996: goto L_0x00e1;
                case 217109576: goto L_0x00d3;
                case 218785621: goto L_0x00c5;
                case 220478892: goto L_0x00b7;
                case 240482938: goto L_0x00a9;
                case 365601008: goto L_0x009b;
                case 401643183: goto L_0x008d;
                case 917656469: goto L_0x007f;
                case 917735020: goto L_0x0071;
                case 1027575302: goto L_0x0063;
                case 1671764162: goto L_0x0055;
                case 1790285174: goto L_0x0047;
                case 1847674614: goto L_0x0039;
                case 1908075304: goto L_0x002b;
                case 1924065902: goto L_0x001d;
                case 2106883585: goto L_0x000f;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x0226
        L_0x000f:
            java.lang.String r0 = "markerHeight"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0019
            goto L_0x0226
        L_0x0019:
            r3 = 39
            goto L_0x0226
        L_0x001d:
            java.lang.String r0 = "strokeWidth"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0027
            goto L_0x0226
        L_0x0027:
            r3 = 38
            goto L_0x0226
        L_0x002b:
            java.lang.String r0 = "meetOrSlice"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0035
            goto L_0x0226
        L_0x0035:
            r3 = 37
            goto L_0x0226
        L_0x0039:
            java.lang.String r0 = "responsible"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0043
            goto L_0x0226
        L_0x0043:
            r3 = 36
            goto L_0x0226
        L_0x0047:
            java.lang.String r0 = "strokeLinejoin"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0051
            goto L_0x0226
        L_0x0051:
            r3 = 35
            goto L_0x0226
        L_0x0055:
            java.lang.String r0 = "display"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x005f
            goto L_0x0226
        L_0x005f:
            r3 = 34
            goto L_0x0226
        L_0x0063:
            java.lang.String r0 = "strokeLinecap"
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
            java.lang.String r0 = "strokeDasharray"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0097
            goto L_0x0226
        L_0x0097:
            r3 = 30
            goto L_0x0226
        L_0x009b:
            java.lang.String r0 = "fontSize"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00a5
            goto L_0x0226
        L_0x00a5:
            r3 = 29
            goto L_0x0226
        L_0x00a9:
            java.lang.String r0 = "vbWidth"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00b3
            goto L_0x0226
        L_0x00b3:
            r3 = 28
            goto L_0x0226
        L_0x00b7:
            java.lang.String r0 = "markerWidth"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00c1
            goto L_0x0226
        L_0x00c1:
            r3 = 27
            goto L_0x0226
        L_0x00c5:
            java.lang.String r0 = "markerUnits"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00cf
            goto L_0x0226
        L_0x00cf:
            r3 = 26
            goto L_0x0226
        L_0x00d3:
            java.lang.String r0 = "markerStart"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00dd
            goto L_0x0226
        L_0x00dd:
            r3 = 25
            goto L_0x0226
        L_0x00e1:
            java.lang.String r0 = "vectorEffect"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00eb
            goto L_0x0226
        L_0x00eb:
            r3 = 24
            goto L_0x0226
        L_0x00ef:
            java.lang.String r0 = "align"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00f9
            goto L_0x0226
        L_0x00f9:
            r3 = 23
            goto L_0x0226
        L_0x00fd:
            java.lang.String r0 = "strokeMiterlimit"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0107
            goto L_0x0226
        L_0x0107:
            r3 = 22
            goto L_0x0226
        L_0x010b:
            java.lang.String r0 = "refY"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0115
            goto L_0x0226
        L_0x0115:
            r3 = 21
            goto L_0x0226
        L_0x0119:
            java.lang.String r0 = "refX"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0123
            goto L_0x0226
        L_0x0123:
            r3 = 20
            goto L_0x0226
        L_0x0127:
            java.lang.String r0 = "name"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0131
            goto L_0x0226
        L_0x0131:
            r3 = 19
            goto L_0x0226
        L_0x0135:
            java.lang.String r0 = "minY"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x013f
            goto L_0x0226
        L_0x013f:
            r3 = 18
            goto L_0x0226
        L_0x0143:
            java.lang.String r0 = "minX"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x014d
            goto L_0x0226
        L_0x014d:
            r3 = 17
            goto L_0x0226
        L_0x0151:
            java.lang.String r0 = "mask"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x015b
            goto L_0x0226
        L_0x015b:
            r3 = 16
            goto L_0x0226
        L_0x015f:
            java.lang.String r0 = "font"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0169
            goto L_0x0226
        L_0x0169:
            r3 = 15
            goto L_0x0226
        L_0x016d:
            java.lang.String r0 = "fill"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0177
            goto L_0x0226
        L_0x0177:
            r3 = 14
            goto L_0x0226
        L_0x017b:
            java.lang.String r0 = "strokeDashoffset"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0185
            goto L_0x0226
        L_0x0185:
            r3 = 13
            goto L_0x0226
        L_0x0189:
            java.lang.String r0 = "fillOpacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0193
            goto L_0x0226
        L_0x0193:
            r3 = 12
            goto L_0x0226
        L_0x0197:
            java.lang.String r0 = "pointerEvents"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01a1
            goto L_0x0226
        L_0x01a1:
            r3 = 11
            goto L_0x0226
        L_0x01a5:
            java.lang.String r0 = "strokeOpacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01af
            goto L_0x0226
        L_0x01af:
            r3 = 10
            goto L_0x0226
        L_0x01b3:
            java.lang.String r0 = "fillRule"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01bd
            goto L_0x0226
        L_0x01bd:
            r3 = 9
            goto L_0x0226
        L_0x01c1:
            java.lang.String r0 = "fontWeight"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01cb
            goto L_0x0226
        L_0x01cb:
            r3 = 8
            goto L_0x0226
        L_0x01cf:
            java.lang.String r0 = "stroke"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01d8
            goto L_0x0226
        L_0x01d8:
            r3 = 7
            goto L_0x0226
        L_0x01da:
            java.lang.String r0 = "markerMid"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01e3
            goto L_0x0226
        L_0x01e3:
            r3 = 6
            goto L_0x0226
        L_0x01e5:
            java.lang.String r0 = "markerEnd"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01ee
            goto L_0x0226
        L_0x01ee:
            r3 = 5
            goto L_0x0226
        L_0x01f0:
            java.lang.String r0 = "propList"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01f9
            goto L_0x0226
        L_0x01f9:
            r3 = 4
            goto L_0x0226
        L_0x01fb:
            java.lang.String r0 = "orient"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0204
            goto L_0x0226
        L_0x0204:
            r3 = 3
            goto L_0x0226
        L_0x0206:
            java.lang.String r0 = "matrix"
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
            java.lang.String r0 = "vbHeight"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0225
            goto L_0x0226
        L_0x0225:
            r3 = r2
        L_0x0226:
            r0 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            r5 = 0
            switch(r3) {
                case 0: goto L_0x0488;
                case 1: goto L_0x0477;
                case 2: goto L_0x046d;
                case 3: goto L_0x045f;
                case 4: goto L_0x0455;
                case 5: goto L_0x0447;
                case 6: goto L_0x0439;
                case 7: goto L_0x042f;
                case 8: goto L_0x0421;
                case 9: goto L_0x040f;
                case 10: goto L_0x03fd;
                case 11: goto L_0x03ee;
                case 12: goto L_0x03dc;
                case 13: goto L_0x03ca;
                case 14: goto L_0x03bf;
                case 15: goto L_0x03b1;
                case 16: goto L_0x03a2;
                case 17: goto L_0x0390;
                case 18: goto L_0x037e;
                case 19: goto L_0x036f;
                case 20: goto L_0x0361;
                case 21: goto L_0x0353;
                case 22: goto L_0x0341;
                case 23: goto L_0x0332;
                case 24: goto L_0x0320;
                case 25: goto L_0x0311;
                case 26: goto L_0x0302;
                case 27: goto L_0x02f4;
                case 28: goto L_0x02e2;
                case 29: goto L_0x02d4;
                case 30: goto L_0x02c6;
                case 31: goto L_0x02b7;
                case 32: goto L_0x02a5;
                case 33: goto L_0x0293;
                case 34: goto L_0x0284;
                case 35: goto L_0x0272;
                case 36: goto L_0x0260;
                case 37: goto L_0x024e;
                case 38: goto L_0x0240;
                case 39: goto L_0x0232;
                default: goto L_0x022d;
            }
        L_0x022d:
            super.setProperty(r7, r8, r9)
            goto L_0x0498
        L_0x0232:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setMarkerHeight(r7, r0)
            goto L_0x0498
        L_0x0240:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setStrokeWidth(r7, r0)
            goto L_0x0498
        L_0x024e:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface) r8
            if (r9 != 0) goto L_0x0255
            goto L_0x025b
        L_0x0255:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x025b:
            r8.setMeetOrSlice(r7, r2)
            goto L_0x0498
        L_0x0260:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface) r8
            if (r9 != 0) goto L_0x0267
            goto L_0x026d
        L_0x0267:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r2 = r9.booleanValue()
        L_0x026d:
            r8.setResponsible(r7, r2)
            goto L_0x0498
        L_0x0272:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface) r8
            if (r9 != 0) goto L_0x0279
            goto L_0x027f
        L_0x0279:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x027f:
            r8.setStrokeLinejoin(r7, r2)
            goto L_0x0498
        L_0x0284:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface) r8
            if (r9 != 0) goto L_0x028b
            goto L_0x028e
        L_0x028b:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x028e:
            r8.setDisplay(r7, r5)
            goto L_0x0498
        L_0x0293:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface) r8
            if (r9 != 0) goto L_0x029a
            goto L_0x02a0
        L_0x029a:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x02a0:
            r8.setStrokeLinecap(r7, r2)
            goto L_0x0498
        L_0x02a5:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface) r8
            if (r9 != 0) goto L_0x02ac
            goto L_0x02b2
        L_0x02ac:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x02b2:
            r8.setClipRule(r7, r2)
            goto L_0x0498
        L_0x02b7:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface) r8
            if (r9 != 0) goto L_0x02be
            goto L_0x02c1
        L_0x02be:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x02c1:
            r8.setClipPath(r7, r5)
            goto L_0x0498
        L_0x02c6:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setStrokeDasharray(r7, r0)
            goto L_0x0498
        L_0x02d4:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setFontSize(r7, r0)
            goto L_0x0498
        L_0x02e2:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface) r8
            if (r9 != 0) goto L_0x02e9
            goto L_0x02ef
        L_0x02e9:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x02ef:
            r8.setVbWidth(r7, r4)
            goto L_0x0498
        L_0x02f4:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setMarkerWidth(r7, r0)
            goto L_0x0498
        L_0x0302:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface) r8
            if (r9 != 0) goto L_0x0309
            goto L_0x030c
        L_0x0309:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x030c:
            r8.setMarkerUnits(r7, r5)
            goto L_0x0498
        L_0x0311:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface) r8
            if (r9 != 0) goto L_0x0318
            goto L_0x031b
        L_0x0318:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x031b:
            r8.setMarkerStart(r7, r5)
            goto L_0x0498
        L_0x0320:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface) r8
            if (r9 != 0) goto L_0x0327
            goto L_0x032d
        L_0x0327:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x032d:
            r8.setVectorEffect(r7, r2)
            goto L_0x0498
        L_0x0332:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface) r8
            if (r9 != 0) goto L_0x0339
            goto L_0x033c
        L_0x0339:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x033c:
            r8.setAlign(r7, r5)
            goto L_0x0498
        L_0x0341:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface) r8
            if (r9 != 0) goto L_0x0348
            goto L_0x034e
        L_0x0348:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x034e:
            r8.setStrokeMiterlimit(r7, r4)
            goto L_0x0498
        L_0x0353:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setRefY(r7, r0)
            goto L_0x0498
        L_0x0361:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setRefX(r7, r0)
            goto L_0x0498
        L_0x036f:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface) r8
            if (r9 != 0) goto L_0x0376
            goto L_0x0379
        L_0x0376:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0379:
            r8.setName(r7, r5)
            goto L_0x0498
        L_0x037e:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface) r8
            if (r9 != 0) goto L_0x0385
            goto L_0x038b
        L_0x0385:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x038b:
            r8.setMinY(r7, r4)
            goto L_0x0498
        L_0x0390:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface) r8
            if (r9 != 0) goto L_0x0397
            goto L_0x039d
        L_0x0397:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x039d:
            r8.setMinX(r7, r4)
            goto L_0x0498
        L_0x03a2:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface) r8
            if (r9 != 0) goto L_0x03a9
            goto L_0x03ac
        L_0x03a9:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x03ac:
            r8.setMask(r7, r5)
            goto L_0x0498
        L_0x03b1:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setFont(r7, r0)
            goto L_0x0498
        L_0x03bf:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setFill(r7, r9)
            goto L_0x0498
        L_0x03ca:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface) r8
            if (r9 != 0) goto L_0x03d1
            goto L_0x03d7
        L_0x03d1:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x03d7:
            r8.setStrokeDashoffset(r7, r4)
            goto L_0x0498
        L_0x03dc:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface) r8
            if (r9 != 0) goto L_0x03e3
            goto L_0x03e9
        L_0x03e3:
            java.lang.Double r9 = (java.lang.Double) r9
            float r0 = r9.floatValue()
        L_0x03e9:
            r8.setFillOpacity(r7, r0)
            goto L_0x0498
        L_0x03ee:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface) r8
            if (r9 != 0) goto L_0x03f5
            goto L_0x03f8
        L_0x03f5:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x03f8:
            r8.setPointerEvents(r7, r5)
            goto L_0x0498
        L_0x03fd:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface) r8
            if (r9 != 0) goto L_0x0404
            goto L_0x040a
        L_0x0404:
            java.lang.Double r9 = (java.lang.Double) r9
            float r0 = r9.floatValue()
        L_0x040a:
            r8.setStrokeOpacity(r7, r0)
            goto L_0x0498
        L_0x040f:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface) r8
            if (r9 != 0) goto L_0x0416
            goto L_0x041c
        L_0x0416:
            java.lang.Double r9 = (java.lang.Double) r9
            int r1 = r9.intValue()
        L_0x041c:
            r8.setFillRule(r7, r1)
            goto L_0x0498
        L_0x0421:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setFontWeight(r7, r0)
            goto L_0x0498
        L_0x042f:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setStroke(r7, r9)
            goto L_0x0498
        L_0x0439:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface) r8
            if (r9 != 0) goto L_0x0440
            goto L_0x0443
        L_0x0440:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0443:
            r8.setMarkerMid(r7, r5)
            goto L_0x0498
        L_0x0447:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface) r8
            if (r9 != 0) goto L_0x044e
            goto L_0x0451
        L_0x044e:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0451:
            r8.setMarkerEnd(r7, r5)
            goto L_0x0498
        L_0x0455:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setPropList(r7, r9)
            goto L_0x0498
        L_0x045f:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface) r8
            if (r9 != 0) goto L_0x0466
            goto L_0x0469
        L_0x0466:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0469:
            r8.setOrient(r7, r5)
            goto L_0x0498
        L_0x046d:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setMatrix(r7, r9)
            goto L_0x0498
        L_0x0477:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface) r8
            if (r9 != 0) goto L_0x047e
            goto L_0x0484
        L_0x047e:
            java.lang.Double r9 = (java.lang.Double) r9
            float r0 = r9.floatValue()
        L_0x0484:
            r8.setOpacity(r7, r0)
            goto L_0x0498
        L_0x0488:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface) r8
            if (r9 != 0) goto L_0x048f
            goto L_0x0495
        L_0x048f:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x0495:
            r8.setVbHeight(r7, r4)
        L_0x0498:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.RNSVGMarkerManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
