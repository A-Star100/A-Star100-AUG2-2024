package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface;

public class RNSVGRadialGradientManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & RNSVGRadialGradientManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public RNSVGRadialGradientManagerDelegate(U u) {
        super(u);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r4, java.lang.String r5, java.lang.Object r6) {
        /*
            r3 = this;
            r5.hashCode()
            int r0 = r5.hashCode()
            r1 = 0
            r2 = -1
            switch(r0) {
                case -1932235233: goto L_0x0111;
                case -1267206133: goto L_0x0106;
                case -1081239615: goto L_0x00fb;
                case -933864895: goto L_0x00f0;
                case -933857362: goto L_0x00e5;
                case -293492298: goto L_0x00da;
                case 3189: goto L_0x00cf;
                case 3190: goto L_0x00c4;
                case 3282: goto L_0x00b6;
                case 3283: goto L_0x00a8;
                case 3654: goto L_0x009a;
                case 3655: goto L_0x008c;
                case 3344108: goto L_0x007e;
                case 3373707: goto L_0x0070;
                case 89650992: goto L_0x0062;
                case 217109576: goto L_0x0054;
                case 917656469: goto L_0x0046;
                case 917735020: goto L_0x0038;
                case 1671764162: goto L_0x002a;
                case 1822665244: goto L_0x001c;
                case 1847674614: goto L_0x000e;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x011b
        L_0x000e:
            java.lang.String r0 = "responsible"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0018
            goto L_0x011b
        L_0x0018:
            r2 = 20
            goto L_0x011b
        L_0x001c:
            java.lang.String r0 = "gradientTransform"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0026
            goto L_0x011b
        L_0x0026:
            r2 = 19
            goto L_0x011b
        L_0x002a:
            java.lang.String r0 = "display"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0034
            goto L_0x011b
        L_0x0034:
            r2 = 18
            goto L_0x011b
        L_0x0038:
            java.lang.String r0 = "clipRule"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0042
            goto L_0x011b
        L_0x0042:
            r2 = 17
            goto L_0x011b
        L_0x0046:
            java.lang.String r0 = "clipPath"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0050
            goto L_0x011b
        L_0x0050:
            r2 = 16
            goto L_0x011b
        L_0x0054:
            java.lang.String r0 = "markerStart"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x005e
            goto L_0x011b
        L_0x005e:
            r2 = 15
            goto L_0x011b
        L_0x0062:
            java.lang.String r0 = "gradient"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x006c
            goto L_0x011b
        L_0x006c:
            r2 = 14
            goto L_0x011b
        L_0x0070:
            java.lang.String r0 = "name"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x007a
            goto L_0x011b
        L_0x007a:
            r2 = 13
            goto L_0x011b
        L_0x007e:
            java.lang.String r0 = "mask"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0088
            goto L_0x011b
        L_0x0088:
            r2 = 12
            goto L_0x011b
        L_0x008c:
            java.lang.String r0 = "ry"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0096
            goto L_0x011b
        L_0x0096:
            r2 = 11
            goto L_0x011b
        L_0x009a:
            java.lang.String r0 = "rx"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x00a4
            goto L_0x011b
        L_0x00a4:
            r2 = 10
            goto L_0x011b
        L_0x00a8:
            java.lang.String r0 = "fy"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x00b2
            goto L_0x011b
        L_0x00b2:
            r2 = 9
            goto L_0x011b
        L_0x00b6:
            java.lang.String r0 = "fx"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x00c0
            goto L_0x011b
        L_0x00c0:
            r2 = 8
            goto L_0x011b
        L_0x00c4:
            java.lang.String r0 = "cy"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x00cd
            goto L_0x011b
        L_0x00cd:
            r2 = 7
            goto L_0x011b
        L_0x00cf:
            java.lang.String r0 = "cx"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x00d8
            goto L_0x011b
        L_0x00d8:
            r2 = 6
            goto L_0x011b
        L_0x00da:
            java.lang.String r0 = "pointerEvents"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x00e3
            goto L_0x011b
        L_0x00e3:
            r2 = 5
            goto L_0x011b
        L_0x00e5:
            java.lang.String r0 = "markerMid"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x00ee
            goto L_0x011b
        L_0x00ee:
            r2 = 4
            goto L_0x011b
        L_0x00f0:
            java.lang.String r0 = "markerEnd"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x00f9
            goto L_0x011b
        L_0x00f9:
            r2 = 3
            goto L_0x011b
        L_0x00fb:
            java.lang.String r0 = "matrix"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0104
            goto L_0x011b
        L_0x0104:
            r2 = 2
            goto L_0x011b
        L_0x0106:
            java.lang.String r0 = "opacity"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x010f
            goto L_0x011b
        L_0x010f:
            r2 = 1
            goto L_0x011b
        L_0x0111:
            java.lang.String r0 = "gradientUnits"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x011a
            goto L_0x011b
        L_0x011a:
            r2 = r1
        L_0x011b:
            r0 = 0
            switch(r2) {
                case 0: goto L_0x0243;
                case 1: goto L_0x0230;
                case 2: goto L_0x0226;
                case 3: goto L_0x0218;
                case 4: goto L_0x020a;
                case 5: goto L_0x01fc;
                case 6: goto L_0x01ef;
                case 7: goto L_0x01e1;
                case 8: goto L_0x01d3;
                case 9: goto L_0x01c5;
                case 10: goto L_0x01b7;
                case 11: goto L_0x01a9;
                case 12: goto L_0x019a;
                case 13: goto L_0x018b;
                case 14: goto L_0x0180;
                case 15: goto L_0x0171;
                case 16: goto L_0x0162;
                case 17: goto L_0x0150;
                case 18: goto L_0x0141;
                case 19: goto L_0x0136;
                case 20: goto L_0x0124;
                default: goto L_0x011f;
            }
        L_0x011f:
            super.setProperty(r4, r5, r6)
            goto L_0x0253
        L_0x0124:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface) r5
            if (r6 != 0) goto L_0x012b
            goto L_0x0131
        L_0x012b:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r1 = r6.booleanValue()
        L_0x0131:
            r5.setResponsible(r4, r1)
            goto L_0x0253
        L_0x0136:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface) r5
            com.facebook.react.bridge.ReadableArray r6 = (com.facebook.react.bridge.ReadableArray) r6
            r5.setGradientTransform(r4, r6)
            goto L_0x0253
        L_0x0141:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface) r5
            if (r6 != 0) goto L_0x0148
            goto L_0x014b
        L_0x0148:
            r0 = r6
            java.lang.String r0 = (java.lang.String) r0
        L_0x014b:
            r5.setDisplay(r4, r0)
            goto L_0x0253
        L_0x0150:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface) r5
            if (r6 != 0) goto L_0x0157
            goto L_0x015d
        L_0x0157:
            java.lang.Double r6 = (java.lang.Double) r6
            int r1 = r6.intValue()
        L_0x015d:
            r5.setClipRule(r4, r1)
            goto L_0x0253
        L_0x0162:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface) r5
            if (r6 != 0) goto L_0x0169
            goto L_0x016c
        L_0x0169:
            r0 = r6
            java.lang.String r0 = (java.lang.String) r0
        L_0x016c:
            r5.setClipPath(r4, r0)
            goto L_0x0253
        L_0x0171:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface) r5
            if (r6 != 0) goto L_0x0178
            goto L_0x017b
        L_0x0178:
            r0 = r6
            java.lang.String r0 = (java.lang.String) r0
        L_0x017b:
            r5.setMarkerStart(r4, r0)
            goto L_0x0253
        L_0x0180:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface) r5
            com.facebook.react.bridge.ReadableArray r6 = (com.facebook.react.bridge.ReadableArray) r6
            r5.setGradient(r4, r6)
            goto L_0x0253
        L_0x018b:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface) r5
            if (r6 != 0) goto L_0x0192
            goto L_0x0195
        L_0x0192:
            r0 = r6
            java.lang.String r0 = (java.lang.String) r0
        L_0x0195:
            r5.setName(r4, r0)
            goto L_0x0253
        L_0x019a:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface) r5
            if (r6 != 0) goto L_0x01a1
            goto L_0x01a4
        L_0x01a1:
            r0 = r6
            java.lang.String r0 = (java.lang.String) r0
        L_0x01a4:
            r5.setMask(r4, r0)
            goto L_0x0253
        L_0x01a9:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface) r5
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r6)
            r5.setRy(r4, r0)
            goto L_0x0253
        L_0x01b7:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface) r5
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r6)
            r5.setRx(r4, r0)
            goto L_0x0253
        L_0x01c5:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface) r5
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r6)
            r5.setFy(r4, r0)
            goto L_0x0253
        L_0x01d3:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface) r5
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r6)
            r5.setFx(r4, r0)
            goto L_0x0253
        L_0x01e1:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface) r5
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r6)
            r5.setCy(r4, r0)
            goto L_0x0253
        L_0x01ef:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface) r5
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r6)
            r5.setCx(r4, r0)
            goto L_0x0253
        L_0x01fc:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface) r5
            if (r6 != 0) goto L_0x0203
            goto L_0x0206
        L_0x0203:
            r0 = r6
            java.lang.String r0 = (java.lang.String) r0
        L_0x0206:
            r5.setPointerEvents(r4, r0)
            goto L_0x0253
        L_0x020a:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface) r5
            if (r6 != 0) goto L_0x0211
            goto L_0x0214
        L_0x0211:
            r0 = r6
            java.lang.String r0 = (java.lang.String) r0
        L_0x0214:
            r5.setMarkerMid(r4, r0)
            goto L_0x0253
        L_0x0218:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface) r5
            if (r6 != 0) goto L_0x021f
            goto L_0x0222
        L_0x021f:
            r0 = r6
            java.lang.String r0 = (java.lang.String) r0
        L_0x0222:
            r5.setMarkerEnd(r4, r0)
            goto L_0x0253
        L_0x0226:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface) r5
            com.facebook.react.bridge.ReadableArray r6 = (com.facebook.react.bridge.ReadableArray) r6
            r5.setMatrix(r4, r6)
            goto L_0x0253
        L_0x0230:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface) r5
            if (r6 != 0) goto L_0x0239
            r6 = 1065353216(0x3f800000, float:1.0)
            goto L_0x023f
        L_0x0239:
            java.lang.Double r6 = (java.lang.Double) r6
            float r6 = r6.floatValue()
        L_0x023f:
            r5.setOpacity(r4, r6)
            goto L_0x0253
        L_0x0243:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface r5 = (com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface) r5
            if (r6 != 0) goto L_0x024a
            goto L_0x0250
        L_0x024a:
            java.lang.Double r6 = (java.lang.Double) r6
            int r1 = r6.intValue()
        L_0x0250:
            r5.setGradientUnits(r4, r1)
        L_0x0253:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.RNSVGRadialGradientManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
