package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.RNSVGRectManagerInterface;

public class RNSVGRectManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & RNSVGRectManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public RNSVGRectManagerDelegate(U u) {
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
                case -1267206133: goto L_0x019e;
                case -1221029593: goto L_0x0193;
                case -1081239615: goto L_0x0188;
                case -993894751: goto L_0x017d;
                case -933864895: goto L_0x0172;
                case -933857362: goto L_0x0167;
                case -891980232: goto L_0x015c;
                case -729118945: goto L_0x0151;
                case -416535885: goto L_0x0143;
                case -293492298: goto L_0x0135;
                case -53677816: goto L_0x0127;
                case -44578051: goto L_0x0119;
                case 120: goto L_0x010b;
                case 121: goto L_0x00fd;
                case 3654: goto L_0x00ef;
                case 3655: goto L_0x00e1;
                case 3143043: goto L_0x00d3;
                case 3344108: goto L_0x00c5;
                case 3373707: goto L_0x00b7;
                case 78845486: goto L_0x00a9;
                case 104482996: goto L_0x009b;
                case 113126854: goto L_0x008d;
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
            goto L_0x01a8
        L_0x000f:
            java.lang.String r0 = "strokeWidth"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0019
            goto L_0x01a8
        L_0x0019:
            r3 = 30
            goto L_0x01a8
        L_0x001d:
            java.lang.String r0 = "responsible"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0027
            goto L_0x01a8
        L_0x0027:
            r3 = 29
            goto L_0x01a8
        L_0x002b:
            java.lang.String r0 = "strokeLinejoin"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0035
            goto L_0x01a8
        L_0x0035:
            r3 = 28
            goto L_0x01a8
        L_0x0039:
            java.lang.String r0 = "display"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0043
            goto L_0x01a8
        L_0x0043:
            r3 = 27
            goto L_0x01a8
        L_0x0047:
            java.lang.String r0 = "strokeLinecap"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0051
            goto L_0x01a8
        L_0x0051:
            r3 = 26
            goto L_0x01a8
        L_0x0055:
            java.lang.String r0 = "clipRule"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x005f
            goto L_0x01a8
        L_0x005f:
            r3 = 25
            goto L_0x01a8
        L_0x0063:
            java.lang.String r0 = "clipPath"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x006d
            goto L_0x01a8
        L_0x006d:
            r3 = 24
            goto L_0x01a8
        L_0x0071:
            java.lang.String r0 = "strokeDasharray"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x007b
            goto L_0x01a8
        L_0x007b:
            r3 = 23
            goto L_0x01a8
        L_0x007f:
            java.lang.String r0 = "markerStart"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0089
            goto L_0x01a8
        L_0x0089:
            r3 = 22
            goto L_0x01a8
        L_0x008d:
            java.lang.String r0 = "width"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0097
            goto L_0x01a8
        L_0x0097:
            r3 = 21
            goto L_0x01a8
        L_0x009b:
            java.lang.String r0 = "vectorEffect"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00a5
            goto L_0x01a8
        L_0x00a5:
            r3 = 20
            goto L_0x01a8
        L_0x00a9:
            java.lang.String r0 = "strokeMiterlimit"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00b3
            goto L_0x01a8
        L_0x00b3:
            r3 = 19
            goto L_0x01a8
        L_0x00b7:
            java.lang.String r0 = "name"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00c1
            goto L_0x01a8
        L_0x00c1:
            r3 = 18
            goto L_0x01a8
        L_0x00c5:
            java.lang.String r0 = "mask"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00cf
            goto L_0x01a8
        L_0x00cf:
            r3 = 17
            goto L_0x01a8
        L_0x00d3:
            java.lang.String r0 = "fill"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00dd
            goto L_0x01a8
        L_0x00dd:
            r3 = 16
            goto L_0x01a8
        L_0x00e1:
            java.lang.String r0 = "ry"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00eb
            goto L_0x01a8
        L_0x00eb:
            r3 = 15
            goto L_0x01a8
        L_0x00ef:
            java.lang.String r0 = "rx"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00f9
            goto L_0x01a8
        L_0x00f9:
            r3 = 14
            goto L_0x01a8
        L_0x00fd:
            java.lang.String r0 = "y"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0107
            goto L_0x01a8
        L_0x0107:
            r3 = 13
            goto L_0x01a8
        L_0x010b:
            java.lang.String r0 = "x"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0115
            goto L_0x01a8
        L_0x0115:
            r3 = 12
            goto L_0x01a8
        L_0x0119:
            java.lang.String r0 = "strokeDashoffset"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0123
            goto L_0x01a8
        L_0x0123:
            r3 = 11
            goto L_0x01a8
        L_0x0127:
            java.lang.String r0 = "fillOpacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0131
            goto L_0x01a8
        L_0x0131:
            r3 = 10
            goto L_0x01a8
        L_0x0135:
            java.lang.String r0 = "pointerEvents"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x013f
            goto L_0x01a8
        L_0x013f:
            r3 = 9
            goto L_0x01a8
        L_0x0143:
            java.lang.String r0 = "strokeOpacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x014d
            goto L_0x01a8
        L_0x014d:
            r3 = 8
            goto L_0x01a8
        L_0x0151:
            java.lang.String r0 = "fillRule"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x015a
            goto L_0x01a8
        L_0x015a:
            r3 = 7
            goto L_0x01a8
        L_0x015c:
            java.lang.String r0 = "stroke"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0165
            goto L_0x01a8
        L_0x0165:
            r3 = 6
            goto L_0x01a8
        L_0x0167:
            java.lang.String r0 = "markerMid"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0170
            goto L_0x01a8
        L_0x0170:
            r3 = 5
            goto L_0x01a8
        L_0x0172:
            java.lang.String r0 = "markerEnd"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x017b
            goto L_0x01a8
        L_0x017b:
            r3 = 4
            goto L_0x01a8
        L_0x017d:
            java.lang.String r0 = "propList"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0186
            goto L_0x01a8
        L_0x0186:
            r3 = 3
            goto L_0x01a8
        L_0x0188:
            java.lang.String r0 = "matrix"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0191
            goto L_0x01a8
        L_0x0191:
            r3 = 2
            goto L_0x01a8
        L_0x0193:
            java.lang.String r0 = "height"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x019c
            goto L_0x01a8
        L_0x019c:
            r3 = r1
            goto L_0x01a8
        L_0x019e:
            java.lang.String r0 = "opacity"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01a7
            goto L_0x01a8
        L_0x01a7:
            r3 = r2
        L_0x01a8:
            r0 = 0
            r4 = 1065353216(0x3f800000, float:1.0)
            r5 = 0
            switch(r3) {
                case 0: goto L_0x0375;
                case 1: goto L_0x0368;
                case 2: goto L_0x035e;
                case 3: goto L_0x0354;
                case 4: goto L_0x0346;
                case 5: goto L_0x0338;
                case 6: goto L_0x032e;
                case 7: goto L_0x031d;
                case 8: goto L_0x030b;
                case 9: goto L_0x02fc;
                case 10: goto L_0x02ea;
                case 11: goto L_0x02d8;
                case 12: goto L_0x02ca;
                case 13: goto L_0x02bc;
                case 14: goto L_0x02ae;
                case 15: goto L_0x02a0;
                case 16: goto L_0x0295;
                case 17: goto L_0x0286;
                case 18: goto L_0x0277;
                case 19: goto L_0x0265;
                case 20: goto L_0x0253;
                case 21: goto L_0x0245;
                case 22: goto L_0x0236;
                case 23: goto L_0x0228;
                case 24: goto L_0x0219;
                case 25: goto L_0x0207;
                case 26: goto L_0x01f5;
                case 27: goto L_0x01e6;
                case 28: goto L_0x01d4;
                case 29: goto L_0x01c2;
                case 30: goto L_0x01b4;
                default: goto L_0x01af;
            }
        L_0x01af:
            super.setProperty(r7, r8, r9)
            goto L_0x0385
        L_0x01b4:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setStrokeWidth(r7, r0)
            goto L_0x0385
        L_0x01c2:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            if (r9 != 0) goto L_0x01c9
            goto L_0x01cf
        L_0x01c9:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r2 = r9.booleanValue()
        L_0x01cf:
            r8.setResponsible(r7, r2)
            goto L_0x0385
        L_0x01d4:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            if (r9 != 0) goto L_0x01db
            goto L_0x01e1
        L_0x01db:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x01e1:
            r8.setStrokeLinejoin(r7, r2)
            goto L_0x0385
        L_0x01e6:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            if (r9 != 0) goto L_0x01ed
            goto L_0x01f0
        L_0x01ed:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x01f0:
            r8.setDisplay(r7, r5)
            goto L_0x0385
        L_0x01f5:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            if (r9 != 0) goto L_0x01fc
            goto L_0x0202
        L_0x01fc:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x0202:
            r8.setStrokeLinecap(r7, r2)
            goto L_0x0385
        L_0x0207:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            if (r9 != 0) goto L_0x020e
            goto L_0x0214
        L_0x020e:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x0214:
            r8.setClipRule(r7, r2)
            goto L_0x0385
        L_0x0219:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            if (r9 != 0) goto L_0x0220
            goto L_0x0223
        L_0x0220:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0223:
            r8.setClipPath(r7, r5)
            goto L_0x0385
        L_0x0228:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setStrokeDasharray(r7, r0)
            goto L_0x0385
        L_0x0236:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            if (r9 != 0) goto L_0x023d
            goto L_0x0240
        L_0x023d:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0240:
            r8.setMarkerStart(r7, r5)
            goto L_0x0385
        L_0x0245:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setWidth(r7, r0)
            goto L_0x0385
        L_0x0253:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            if (r9 != 0) goto L_0x025a
            goto L_0x0260
        L_0x025a:
            java.lang.Double r9 = (java.lang.Double) r9
            int r2 = r9.intValue()
        L_0x0260:
            r8.setVectorEffect(r7, r2)
            goto L_0x0385
        L_0x0265:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            if (r9 != 0) goto L_0x026c
            goto L_0x0272
        L_0x026c:
            java.lang.Double r9 = (java.lang.Double) r9
            float r0 = r9.floatValue()
        L_0x0272:
            r8.setStrokeMiterlimit(r7, r0)
            goto L_0x0385
        L_0x0277:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            if (r9 != 0) goto L_0x027e
            goto L_0x0281
        L_0x027e:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0281:
            r8.setName(r7, r5)
            goto L_0x0385
        L_0x0286:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            if (r9 != 0) goto L_0x028d
            goto L_0x0290
        L_0x028d:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0290:
            r8.setMask(r7, r5)
            goto L_0x0385
        L_0x0295:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setFill(r7, r9)
            goto L_0x0385
        L_0x02a0:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setRy(r7, r0)
            goto L_0x0385
        L_0x02ae:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setRx(r7, r0)
            goto L_0x0385
        L_0x02bc:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setY(r7, r0)
            goto L_0x0385
        L_0x02ca:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setX(r7, r0)
            goto L_0x0385
        L_0x02d8:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            if (r9 != 0) goto L_0x02df
            goto L_0x02e5
        L_0x02df:
            java.lang.Double r9 = (java.lang.Double) r9
            float r0 = r9.floatValue()
        L_0x02e5:
            r8.setStrokeDashoffset(r7, r0)
            goto L_0x0385
        L_0x02ea:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            if (r9 != 0) goto L_0x02f1
            goto L_0x02f7
        L_0x02f1:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x02f7:
            r8.setFillOpacity(r7, r4)
            goto L_0x0385
        L_0x02fc:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            if (r9 != 0) goto L_0x0303
            goto L_0x0306
        L_0x0303:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0306:
            r8.setPointerEvents(r7, r5)
            goto L_0x0385
        L_0x030b:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            if (r9 != 0) goto L_0x0312
            goto L_0x0318
        L_0x0312:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x0318:
            r8.setStrokeOpacity(r7, r4)
            goto L_0x0385
        L_0x031d:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            if (r9 != 0) goto L_0x0324
            goto L_0x032a
        L_0x0324:
            java.lang.Double r9 = (java.lang.Double) r9
            int r1 = r9.intValue()
        L_0x032a:
            r8.setFillRule(r7, r1)
            goto L_0x0385
        L_0x032e:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setStroke(r7, r9)
            goto L_0x0385
        L_0x0338:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            if (r9 != 0) goto L_0x033f
            goto L_0x0342
        L_0x033f:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0342:
            r8.setMarkerMid(r7, r5)
            goto L_0x0385
        L_0x0346:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            if (r9 != 0) goto L_0x034d
            goto L_0x0350
        L_0x034d:
            r5 = r9
            java.lang.String r5 = (java.lang.String) r5
        L_0x0350:
            r8.setMarkerEnd(r7, r5)
            goto L_0x0385
        L_0x0354:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setPropList(r7, r9)
            goto L_0x0385
        L_0x035e:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            com.facebook.react.bridge.ReadableArray r9 = (com.facebook.react.bridge.ReadableArray) r9
            r8.setMatrix(r7, r9)
            goto L_0x0385
        L_0x0368:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setHeight(r7, r0)
            goto L_0x0385
        L_0x0375:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGRectManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGRectManagerInterface) r8
            if (r9 != 0) goto L_0x037c
            goto L_0x0382
        L_0x037c:
            java.lang.Double r9 = (java.lang.Double) r9
            float r4 = r9.floatValue()
        L_0x0382:
            r8.setOpacity(r7, r4)
        L_0x0385:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.RNSVGRectManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
