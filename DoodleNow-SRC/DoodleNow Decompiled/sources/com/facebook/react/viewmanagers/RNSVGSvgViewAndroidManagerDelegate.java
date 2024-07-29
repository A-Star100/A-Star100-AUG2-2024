package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface;

public class RNSVGSvgViewAndroidManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & RNSVGSvgViewAndroidManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public RNSVGSvgViewAndroidManagerDelegate(U u) {
        super(u);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v17, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v20, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v21, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v22, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v23, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v24, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v25, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v26, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v27, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v28, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v29, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v30, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v31, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v32, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v33, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r7, java.lang.String r8, java.lang.Object r9) {
        /*
            r6 = this;
            r8.hashCode()
            int r0 = r8.hashCode()
            r1 = 0
            r2 = -1
            switch(r0) {
                case -2064426617: goto L_0x0299;
                case -1989576717: goto L_0x028e;
                case -1697814026: goto L_0x0283;
                case -1567958285: goto L_0x0278;
                case -1470826662: goto L_0x026d;
                case -1308858324: goto L_0x0262;
                case -1228066334: goto L_0x0257;
                case -1141400650: goto L_0x024c;
                case -1122140597: goto L_0x023e;
                case -867333731: goto L_0x0230;
                case -679581037: goto L_0x0222;
                case -631506969: goto L_0x0214;
                case -631278772: goto L_0x0206;
                case -483490364: goto L_0x01f8;
                case -329721498: goto L_0x01ea;
                case -293492298: goto L_0x01dc;
                case -252105751: goto L_0x01ce;
                case -242276144: goto L_0x01c0;
                case -223134121: goto L_0x01b2;
                case -148030058: goto L_0x01a4;
                case -109689771: goto L_0x0196;
                case -27894242: goto L_0x0188;
                case 3351622: goto L_0x017a;
                case 3351623: goto L_0x016c;
                case 92903173: goto L_0x015e;
                case 94842723: goto L_0x0150;
                case 240482938: goto L_0x0142;
                case 306963138: goto L_0x0134;
                case 333432965: goto L_0x0126;
                case 503397728: goto L_0x0118;
                case 581268560: goto L_0x010a;
                case 588239831: goto L_0x00fc;
                case 660795168: goto L_0x00ee;
                case 684610594: goto L_0x00e0;
                case 722830999: goto L_0x00d2;
                case 737768677: goto L_0x00c4;
                case 762983977: goto L_0x00b6;
                case 910681861: goto L_0x00a8;
                case 926871597: goto L_0x009a;
                case 1220735892: goto L_0x008c;
                case 1327599912: goto L_0x007e;
                case 1349188574: goto L_0x0070;
                case 1629011506: goto L_0x0062;
                case 1667773924: goto L_0x0054;
                case 1735382270: goto L_0x0046;
                case 1747724810: goto L_0x0038;
                case 1908075304: goto L_0x002a;
                case 1910855543: goto L_0x001c;
                case 2119889261: goto L_0x000e;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x02a3
        L_0x000e:
            java.lang.String r0 = "borderStartColor"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0018
            goto L_0x02a3
        L_0x0018:
            r2 = 48
            goto L_0x02a3
        L_0x001c:
            java.lang.String r0 = "nextFocusRight"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0026
            goto L_0x02a3
        L_0x0026:
            r2 = 47
            goto L_0x02a3
        L_0x002a:
            java.lang.String r0 = "meetOrSlice"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0034
            goto L_0x02a3
        L_0x0034:
            r2 = 46
            goto L_0x02a3
        L_0x0038:
            java.lang.String r0 = "nativeBackgroundAndroid"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0042
            goto L_0x02a3
        L_0x0042:
            r2 = 45
            goto L_0x02a3
        L_0x0046:
            java.lang.String r0 = "borderEndEndRadius"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0050
            goto L_0x02a3
        L_0x0050:
            r2 = 44
            goto L_0x02a3
        L_0x0054:
            java.lang.String r0 = "needsOffscreenAlphaCompositing"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x005e
            goto L_0x02a3
        L_0x005e:
            r2 = 43
            goto L_0x02a3
        L_0x0062:
            java.lang.String r0 = "focusable"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x006c
            goto L_0x02a3
        L_0x006c:
            r2 = 42
            goto L_0x02a3
        L_0x0070:
            java.lang.String r0 = "borderRadius"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x007a
            goto L_0x02a3
        L_0x007a:
            r2 = 41
            goto L_0x02a3
        L_0x007e:
            java.lang.String r0 = "tintColor"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0088
            goto L_0x02a3
        L_0x0088:
            r2 = 40
            goto L_0x02a3
        L_0x008c:
            java.lang.String r0 = "borderEndColor"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0096
            goto L_0x02a3
        L_0x0096:
            r2 = 39
            goto L_0x02a3
        L_0x009a:
            java.lang.String r0 = "hitSlop"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00a4
            goto L_0x02a3
        L_0x00a4:
            r2 = 38
            goto L_0x02a3
        L_0x00a8:
            java.lang.String r0 = "borderEndStartRadius"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00b2
            goto L_0x02a3
        L_0x00b2:
            r2 = 37
            goto L_0x02a3
        L_0x00b6:
            java.lang.String r0 = "borderBlockEndColor"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00c0
            goto L_0x02a3
        L_0x00c0:
            r2 = 36
            goto L_0x02a3
        L_0x00c4:
            java.lang.String r0 = "borderStyle"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00ce
            goto L_0x02a3
        L_0x00ce:
            r2 = 35
            goto L_0x02a3
        L_0x00d2:
            java.lang.String r0 = "borderColor"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00dc
            goto L_0x02a3
        L_0x00dc:
            r2 = 34
            goto L_0x02a3
        L_0x00e0:
            java.lang.String r0 = "borderBlockColor"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00ea
            goto L_0x02a3
        L_0x00ea:
            r2 = 33
            goto L_0x02a3
        L_0x00ee:
            java.lang.String r0 = "nextFocusUp"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x00f8
            goto L_0x02a3
        L_0x00f8:
            r2 = 32
            goto L_0x02a3
        L_0x00fc:
            java.lang.String r0 = "borderBottomRightRadius"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0106
            goto L_0x02a3
        L_0x0106:
            r2 = 31
            goto L_0x02a3
        L_0x010a:
            java.lang.String r0 = "borderBottomLeftRadius"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0114
            goto L_0x02a3
        L_0x0114:
            r2 = 30
            goto L_0x02a3
        L_0x0118:
            java.lang.String r0 = "nextFocusForward"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0122
            goto L_0x02a3
        L_0x0122:
            r2 = 29
            goto L_0x02a3
        L_0x0126:
            java.lang.String r0 = "borderTopRightRadius"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0130
            goto L_0x02a3
        L_0x0130:
            r2 = 28
            goto L_0x02a3
        L_0x0134:
            java.lang.String r0 = "borderBlockStartColor"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x013e
            goto L_0x02a3
        L_0x013e:
            r2 = 27
            goto L_0x02a3
        L_0x0142:
            java.lang.String r0 = "vbWidth"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x014c
            goto L_0x02a3
        L_0x014c:
            r2 = 26
            goto L_0x02a3
        L_0x0150:
            java.lang.String r0 = "color"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x015a
            goto L_0x02a3
        L_0x015a:
            r2 = 25
            goto L_0x02a3
        L_0x015e:
            java.lang.String r0 = "align"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0168
            goto L_0x02a3
        L_0x0168:
            r2 = 24
            goto L_0x02a3
        L_0x016c:
            java.lang.String r0 = "minY"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0176
            goto L_0x02a3
        L_0x0176:
            r2 = 23
            goto L_0x02a3
        L_0x017a:
            java.lang.String r0 = "minX"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0184
            goto L_0x02a3
        L_0x0184:
            r2 = 22
            goto L_0x02a3
        L_0x0188:
            java.lang.String r0 = "borderStartStartRadius"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0192
            goto L_0x02a3
        L_0x0192:
            r2 = 21
            goto L_0x02a3
        L_0x0196:
            java.lang.String r0 = "nativeForegroundAndroid"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01a0
            goto L_0x02a3
        L_0x01a0:
            r2 = 20
            goto L_0x02a3
        L_0x01a4:
            java.lang.String r0 = "borderBottomEndRadius"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01ae
            goto L_0x02a3
        L_0x01ae:
            r2 = 19
            goto L_0x02a3
        L_0x01b2:
            java.lang.String r0 = "borderStartEndRadius"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01bc
            goto L_0x02a3
        L_0x01bc:
            r2 = 18
            goto L_0x02a3
        L_0x01c0:
            java.lang.String r0 = "borderLeftColor"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01ca
            goto L_0x02a3
        L_0x01ca:
            r2 = 17
            goto L_0x02a3
        L_0x01ce:
            java.lang.String r0 = "removeClippedSubviews"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01d8
            goto L_0x02a3
        L_0x01d8:
            r2 = 16
            goto L_0x02a3
        L_0x01dc:
            java.lang.String r0 = "pointerEvents"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01e6
            goto L_0x02a3
        L_0x01e6:
            r2 = 15
            goto L_0x02a3
        L_0x01ea:
            java.lang.String r0 = "bbWidth"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x01f4
            goto L_0x02a3
        L_0x01f4:
            r2 = 14
            goto L_0x02a3
        L_0x01f8:
            java.lang.String r0 = "borderTopEndRadius"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0202
            goto L_0x02a3
        L_0x0202:
            r2 = 13
            goto L_0x02a3
        L_0x0206:
            java.lang.String r0 = "nextFocusLeft"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0210
            goto L_0x02a3
        L_0x0210:
            r2 = 12
            goto L_0x02a3
        L_0x0214:
            java.lang.String r0 = "nextFocusDown"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x021e
            goto L_0x02a3
        L_0x021e:
            r2 = 11
            goto L_0x02a3
        L_0x0222:
            java.lang.String r0 = "hasTVPreferredFocus"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x022c
            goto L_0x02a3
        L_0x022c:
            r2 = 10
            goto L_0x02a3
        L_0x0230:
            java.lang.String r0 = "borderBottomStartRadius"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x023a
            goto L_0x02a3
        L_0x023a:
            r2 = 9
            goto L_0x02a3
        L_0x023e:
            java.lang.String r0 = "borderTopStartRadius"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0248
            goto L_0x02a3
        L_0x0248:
            r2 = 8
            goto L_0x02a3
        L_0x024c:
            java.lang.String r0 = "accessible"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0255
            goto L_0x02a3
        L_0x0255:
            r2 = 7
            goto L_0x02a3
        L_0x0257:
            java.lang.String r0 = "borderTopLeftRadius"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0260
            goto L_0x02a3
        L_0x0260:
            r2 = 6
            goto L_0x02a3
        L_0x0262:
            java.lang.String r0 = "borderBottomColor"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x026b
            goto L_0x02a3
        L_0x026b:
            r2 = 5
            goto L_0x02a3
        L_0x026d:
            java.lang.String r0 = "borderTopColor"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0276
            goto L_0x02a3
        L_0x0276:
            r2 = 4
            goto L_0x02a3
        L_0x0278:
            java.lang.String r0 = "vbHeight"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0281
            goto L_0x02a3
        L_0x0281:
            r2 = 3
            goto L_0x02a3
        L_0x0283:
            java.lang.String r0 = "backfaceVisibility"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x028c
            goto L_0x02a3
        L_0x028c:
            r2 = 2
            goto L_0x02a3
        L_0x028e:
            java.lang.String r0 = "borderRightColor"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x0297
            goto L_0x02a3
        L_0x0297:
            r2 = 1
            goto L_0x02a3
        L_0x0299:
            java.lang.String r0 = "bbHeight"
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x02a2
            goto L_0x02a3
        L_0x02a2:
            r2 = r1
        L_0x02a3:
            r0 = 0
            r3 = 0
            r4 = 0
            switch(r2) {
                case 0: goto L_0x05d8;
                case 1: goto L_0x05c8;
                case 2: goto L_0x05ba;
                case 3: goto L_0x05a9;
                case 4: goto L_0x0599;
                case 5: goto L_0x0589;
                case 6: goto L_0x0578;
                case 7: goto L_0x0566;
                case 8: goto L_0x0554;
                case 9: goto L_0x0542;
                case 10: goto L_0x0530;
                case 11: goto L_0x051e;
                case 12: goto L_0x050c;
                case 13: goto L_0x04fa;
                case 14: goto L_0x04ec;
                case 15: goto L_0x04dd;
                case 16: goto L_0x04cb;
                case 17: goto L_0x04ba;
                case 18: goto L_0x04a8;
                case 19: goto L_0x0496;
                case 20: goto L_0x048b;
                case 21: goto L_0x0479;
                case 22: goto L_0x0467;
                case 23: goto L_0x0455;
                case 24: goto L_0x0446;
                case 25: goto L_0x0435;
                case 26: goto L_0x0423;
                case 27: goto L_0x0412;
                case 28: goto L_0x0400;
                case 29: goto L_0x03ee;
                case 30: goto L_0x03dc;
                case 31: goto L_0x03ca;
                case 32: goto L_0x03b8;
                case 33: goto L_0x03a7;
                case 34: goto L_0x0396;
                case 35: goto L_0x0387;
                case 36: goto L_0x0376;
                case 37: goto L_0x0364;
                case 38: goto L_0x0359;
                case 39: goto L_0x0348;
                case 40: goto L_0x0337;
                case 41: goto L_0x0325;
                case 42: goto L_0x0313;
                case 43: goto L_0x0301;
                case 44: goto L_0x02ef;
                case 45: goto L_0x02e4;
                case 46: goto L_0x02d2;
                case 47: goto L_0x02c0;
                case 48: goto L_0x02af;
                default: goto L_0x02aa;
            }
        L_0x02aa:
            super.setProperty(r7, r8, r9)
            goto L_0x05e4
        L_0x02af:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            android.content.Context r0 = r7.getContext()
            java.lang.Integer r9 = com.facebook.react.bridge.ColorPropConverter.getColor(r9, r0)
            r8.setBorderStartColor(r7, r9)
            goto L_0x05e4
        L_0x02c0:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            if (r9 != 0) goto L_0x02c7
            goto L_0x02cd
        L_0x02c7:
            java.lang.Double r9 = (java.lang.Double) r9
            int r1 = r9.intValue()
        L_0x02cd:
            r8.setNextFocusRight(r7, r1)
            goto L_0x05e4
        L_0x02d2:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            if (r9 != 0) goto L_0x02d9
            goto L_0x02df
        L_0x02d9:
            java.lang.Double r9 = (java.lang.Double) r9
            int r1 = r9.intValue()
        L_0x02df:
            r8.setMeetOrSlice(r7, r1)
            goto L_0x05e4
        L_0x02e4:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setNativeBackgroundAndroid(r7, r9)
            goto L_0x05e4
        L_0x02ef:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            if (r9 != 0) goto L_0x02f6
            goto L_0x02fc
        L_0x02f6:
            java.lang.Double r9 = (java.lang.Double) r9
            double r4 = r9.doubleValue()
        L_0x02fc:
            r8.setBorderEndEndRadius(r7, r4)
            goto L_0x05e4
        L_0x0301:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            if (r9 != 0) goto L_0x0308
            goto L_0x030e
        L_0x0308:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r1 = r9.booleanValue()
        L_0x030e:
            r8.setNeedsOffscreenAlphaCompositing(r7, r1)
            goto L_0x05e4
        L_0x0313:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            if (r9 != 0) goto L_0x031a
            goto L_0x0320
        L_0x031a:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r1 = r9.booleanValue()
        L_0x0320:
            r8.setFocusable(r7, r1)
            goto L_0x05e4
        L_0x0325:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            if (r9 != 0) goto L_0x032c
            goto L_0x0332
        L_0x032c:
            java.lang.Double r9 = (java.lang.Double) r9
            double r4 = r9.doubleValue()
        L_0x0332:
            r8.setBorderRadius(r7, r4)
            goto L_0x05e4
        L_0x0337:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            android.content.Context r0 = r7.getContext()
            java.lang.Integer r9 = com.facebook.react.bridge.ColorPropConverter.getColor(r9, r0)
            r8.setTintColor(r7, r9)
            goto L_0x05e4
        L_0x0348:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            android.content.Context r0 = r7.getContext()
            java.lang.Integer r9 = com.facebook.react.bridge.ColorPropConverter.getColor(r9, r0)
            r8.setBorderEndColor(r7, r9)
            goto L_0x05e4
        L_0x0359:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setHitSlop(r7, r9)
            goto L_0x05e4
        L_0x0364:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            if (r9 != 0) goto L_0x036b
            goto L_0x0371
        L_0x036b:
            java.lang.Double r9 = (java.lang.Double) r9
            double r4 = r9.doubleValue()
        L_0x0371:
            r8.setBorderEndStartRadius(r7, r4)
            goto L_0x05e4
        L_0x0376:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            android.content.Context r0 = r7.getContext()
            java.lang.Integer r9 = com.facebook.react.bridge.ColorPropConverter.getColor(r9, r0)
            r8.setBorderBlockEndColor(r7, r9)
            goto L_0x05e4
        L_0x0387:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            if (r9 != 0) goto L_0x038e
            goto L_0x0391
        L_0x038e:
            r0 = r9
            java.lang.String r0 = (java.lang.String) r0
        L_0x0391:
            r8.setBorderStyle(r7, r0)
            goto L_0x05e4
        L_0x0396:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            android.content.Context r0 = r7.getContext()
            java.lang.Integer r9 = com.facebook.react.bridge.ColorPropConverter.getColor(r9, r0)
            r8.setBorderColor(r7, r9)
            goto L_0x05e4
        L_0x03a7:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            android.content.Context r0 = r7.getContext()
            java.lang.Integer r9 = com.facebook.react.bridge.ColorPropConverter.getColor(r9, r0)
            r8.setBorderBlockColor(r7, r9)
            goto L_0x05e4
        L_0x03b8:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            if (r9 != 0) goto L_0x03bf
            goto L_0x03c5
        L_0x03bf:
            java.lang.Double r9 = (java.lang.Double) r9
            int r1 = r9.intValue()
        L_0x03c5:
            r8.setNextFocusUp(r7, r1)
            goto L_0x05e4
        L_0x03ca:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            if (r9 != 0) goto L_0x03d1
            goto L_0x03d7
        L_0x03d1:
            java.lang.Double r9 = (java.lang.Double) r9
            double r4 = r9.doubleValue()
        L_0x03d7:
            r8.setBorderBottomRightRadius(r7, r4)
            goto L_0x05e4
        L_0x03dc:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            if (r9 != 0) goto L_0x03e3
            goto L_0x03e9
        L_0x03e3:
            java.lang.Double r9 = (java.lang.Double) r9
            double r4 = r9.doubleValue()
        L_0x03e9:
            r8.setBorderBottomLeftRadius(r7, r4)
            goto L_0x05e4
        L_0x03ee:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            if (r9 != 0) goto L_0x03f5
            goto L_0x03fb
        L_0x03f5:
            java.lang.Double r9 = (java.lang.Double) r9
            int r1 = r9.intValue()
        L_0x03fb:
            r8.setNextFocusForward(r7, r1)
            goto L_0x05e4
        L_0x0400:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            if (r9 != 0) goto L_0x0407
            goto L_0x040d
        L_0x0407:
            java.lang.Double r9 = (java.lang.Double) r9
            double r4 = r9.doubleValue()
        L_0x040d:
            r8.setBorderTopRightRadius(r7, r4)
            goto L_0x05e4
        L_0x0412:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            android.content.Context r0 = r7.getContext()
            java.lang.Integer r9 = com.facebook.react.bridge.ColorPropConverter.getColor(r9, r0)
            r8.setBorderBlockStartColor(r7, r9)
            goto L_0x05e4
        L_0x0423:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            if (r9 != 0) goto L_0x042a
            goto L_0x0430
        L_0x042a:
            java.lang.Double r9 = (java.lang.Double) r9
            float r3 = r9.floatValue()
        L_0x0430:
            r8.setVbWidth(r7, r3)
            goto L_0x05e4
        L_0x0435:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            android.content.Context r0 = r7.getContext()
            java.lang.Integer r9 = com.facebook.react.bridge.ColorPropConverter.getColor(r9, r0)
            r8.setColor(r7, r9)
            goto L_0x05e4
        L_0x0446:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            if (r9 != 0) goto L_0x044d
            goto L_0x0450
        L_0x044d:
            r0 = r9
            java.lang.String r0 = (java.lang.String) r0
        L_0x0450:
            r8.setAlign(r7, r0)
            goto L_0x05e4
        L_0x0455:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            if (r9 != 0) goto L_0x045c
            goto L_0x0462
        L_0x045c:
            java.lang.Double r9 = (java.lang.Double) r9
            float r3 = r9.floatValue()
        L_0x0462:
            r8.setMinY(r7, r3)
            goto L_0x05e4
        L_0x0467:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            if (r9 != 0) goto L_0x046e
            goto L_0x0474
        L_0x046e:
            java.lang.Double r9 = (java.lang.Double) r9
            float r3 = r9.floatValue()
        L_0x0474:
            r8.setMinX(r7, r3)
            goto L_0x05e4
        L_0x0479:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            if (r9 != 0) goto L_0x0480
            goto L_0x0486
        L_0x0480:
            java.lang.Double r9 = (java.lang.Double) r9
            double r4 = r9.doubleValue()
        L_0x0486:
            r8.setBorderStartStartRadius(r7, r4)
            goto L_0x05e4
        L_0x048b:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setNativeForegroundAndroid(r7, r9)
            goto L_0x05e4
        L_0x0496:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            if (r9 != 0) goto L_0x049d
            goto L_0x04a3
        L_0x049d:
            java.lang.Double r9 = (java.lang.Double) r9
            float r3 = r9.floatValue()
        L_0x04a3:
            r8.setBorderBottomEndRadius(r7, r3)
            goto L_0x05e4
        L_0x04a8:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            if (r9 != 0) goto L_0x04af
            goto L_0x04b5
        L_0x04af:
            java.lang.Double r9 = (java.lang.Double) r9
            double r4 = r9.doubleValue()
        L_0x04b5:
            r8.setBorderStartEndRadius(r7, r4)
            goto L_0x05e4
        L_0x04ba:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            android.content.Context r0 = r7.getContext()
            java.lang.Integer r9 = com.facebook.react.bridge.ColorPropConverter.getColor(r9, r0)
            r8.setBorderLeftColor(r7, r9)
            goto L_0x05e4
        L_0x04cb:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            if (r9 != 0) goto L_0x04d2
            goto L_0x04d8
        L_0x04d2:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r1 = r9.booleanValue()
        L_0x04d8:
            r8.setRemoveClippedSubviews(r7, r1)
            goto L_0x05e4
        L_0x04dd:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            if (r9 != 0) goto L_0x04e4
            goto L_0x04e7
        L_0x04e4:
            r0 = r9
            java.lang.String r0 = (java.lang.String) r0
        L_0x04e7:
            r8.setPointerEvents(r7, r0)
            goto L_0x05e4
        L_0x04ec:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setBbWidth(r7, r0)
            goto L_0x05e4
        L_0x04fa:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            if (r9 != 0) goto L_0x0501
            goto L_0x0507
        L_0x0501:
            java.lang.Double r9 = (java.lang.Double) r9
            float r3 = r9.floatValue()
        L_0x0507:
            r8.setBorderTopEndRadius(r7, r3)
            goto L_0x05e4
        L_0x050c:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            if (r9 != 0) goto L_0x0513
            goto L_0x0519
        L_0x0513:
            java.lang.Double r9 = (java.lang.Double) r9
            int r1 = r9.intValue()
        L_0x0519:
            r8.setNextFocusLeft(r7, r1)
            goto L_0x05e4
        L_0x051e:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            if (r9 != 0) goto L_0x0525
            goto L_0x052b
        L_0x0525:
            java.lang.Double r9 = (java.lang.Double) r9
            int r1 = r9.intValue()
        L_0x052b:
            r8.setNextFocusDown(r7, r1)
            goto L_0x05e4
        L_0x0530:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            if (r9 != 0) goto L_0x0537
            goto L_0x053d
        L_0x0537:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r1 = r9.booleanValue()
        L_0x053d:
            r8.setHasTVPreferredFocus(r7, r1)
            goto L_0x05e4
        L_0x0542:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            if (r9 != 0) goto L_0x0549
            goto L_0x054f
        L_0x0549:
            java.lang.Double r9 = (java.lang.Double) r9
            float r3 = r9.floatValue()
        L_0x054f:
            r8.setBorderBottomStartRadius(r7, r3)
            goto L_0x05e4
        L_0x0554:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            if (r9 != 0) goto L_0x055b
            goto L_0x0561
        L_0x055b:
            java.lang.Double r9 = (java.lang.Double) r9
            float r3 = r9.floatValue()
        L_0x0561:
            r8.setBorderTopStartRadius(r7, r3)
            goto L_0x05e4
        L_0x0566:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            if (r9 != 0) goto L_0x056d
            goto L_0x0573
        L_0x056d:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r1 = r9.booleanValue()
        L_0x0573:
            r8.setAccessible(r7, r1)
            goto L_0x05e4
        L_0x0578:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            if (r9 != 0) goto L_0x057f
            goto L_0x0585
        L_0x057f:
            java.lang.Double r9 = (java.lang.Double) r9
            double r4 = r9.doubleValue()
        L_0x0585:
            r8.setBorderTopLeftRadius(r7, r4)
            goto L_0x05e4
        L_0x0589:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            android.content.Context r0 = r7.getContext()
            java.lang.Integer r9 = com.facebook.react.bridge.ColorPropConverter.getColor(r9, r0)
            r8.setBorderBottomColor(r7, r9)
            goto L_0x05e4
        L_0x0599:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            android.content.Context r0 = r7.getContext()
            java.lang.Integer r9 = com.facebook.react.bridge.ColorPropConverter.getColor(r9, r0)
            r8.setBorderTopColor(r7, r9)
            goto L_0x05e4
        L_0x05a9:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            if (r9 != 0) goto L_0x05b0
            goto L_0x05b6
        L_0x05b0:
            java.lang.Double r9 = (java.lang.Double) r9
            float r3 = r9.floatValue()
        L_0x05b6:
            r8.setVbHeight(r7, r3)
            goto L_0x05e4
        L_0x05ba:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            if (r9 != 0) goto L_0x05c1
            goto L_0x05c4
        L_0x05c1:
            r0 = r9
            java.lang.String r0 = (java.lang.String) r0
        L_0x05c4:
            r8.setBackfaceVisibility(r7, r0)
            goto L_0x05e4
        L_0x05c8:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            android.content.Context r0 = r7.getContext()
            java.lang.Integer r9 = com.facebook.react.bridge.ColorPropConverter.getColor(r9, r0)
            r8.setBorderRightColor(r7, r9)
            goto L_0x05e4
        L_0x05d8:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface r8 = (com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface) r8
            com.facebook.react.bridge.DynamicFromObject r0 = new com.facebook.react.bridge.DynamicFromObject
            r0.<init>(r9)
            r8.setBbHeight(r7, r0)
        L_0x05e4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
