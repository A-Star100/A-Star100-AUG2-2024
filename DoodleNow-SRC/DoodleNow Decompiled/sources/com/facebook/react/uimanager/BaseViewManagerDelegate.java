package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManagerInterface;

public abstract class BaseViewManagerDelegate<T extends View, U extends BaseViewManagerInterface<T>> implements ViewManagerDelegate<T> {
    protected final U mViewManager;

    public void receiveCommand(T t, String str, ReadableArray readableArray) {
    }

    public BaseViewManagerDelegate(U u) {
        this.mViewManager = u;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r5, java.lang.String r6, java.lang.Object r7) {
        /*
            r4 = this;
            r6.hashCode()
            int r0 = r6.hashCode()
            r1 = 0
            r2 = -1
            switch(r0) {
                case -1721943862: goto L_0x019d;
                case -1721943861: goto L_0x0192;
                case -1589741021: goto L_0x0187;
                case -1267206133: goto L_0x017c;
                case -1228066334: goto L_0x0171;
                case -908189618: goto L_0x0166;
                case -908189617: goto L_0x015b;
                case -877170387: goto L_0x0150;
                case -781597262: goto L_0x0142;
                case -731417480: goto L_0x0134;
                case -101663499: goto L_0x0126;
                case -101359900: goto L_0x0118;
                case -80891667: goto L_0x010a;
                case -40300674: goto L_0x00fc;
                case -4379043: goto L_0x00ee;
                case 3506294: goto L_0x00e0;
                case 36255470: goto L_0x00d2;
                case 333432965: goto L_0x00c4;
                case 581268560: goto L_0x00b6;
                case 588239831: goto L_0x00a8;
                case 746986311: goto L_0x009a;
                case 1052666732: goto L_0x008c;
                case 1146842694: goto L_0x007e;
                case 1153872867: goto L_0x0070;
                case 1287124693: goto L_0x0062;
                case 1349188574: goto L_0x0054;
                case 1505602511: goto L_0x0046;
                case 1761903244: goto L_0x0038;
                case 1865277756: goto L_0x002a;
                case 1993034687: goto L_0x001c;
                case 2045685618: goto L_0x000e;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x01a7
        L_0x000e:
            java.lang.String r0 = "nativeID"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0018
            goto L_0x01a7
        L_0x0018:
            r2 = 30
            goto L_0x01a7
        L_0x001c:
            java.lang.String r0 = "accessibilityCollectionItem"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0026
            goto L_0x01a7
        L_0x0026:
            r2 = 29
            goto L_0x01a7
        L_0x002a:
            java.lang.String r0 = "accessibilityLabelledBy"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0034
            goto L_0x01a7
        L_0x0034:
            r2 = 28
            goto L_0x01a7
        L_0x0038:
            java.lang.String r0 = "accessibilityCollection"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0042
            goto L_0x01a7
        L_0x0042:
            r2 = 27
            goto L_0x01a7
        L_0x0046:
            java.lang.String r0 = "accessibilityActions"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0050
            goto L_0x01a7
        L_0x0050:
            r2 = 26
            goto L_0x01a7
        L_0x0054:
            java.lang.String r0 = "borderRadius"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x005e
            goto L_0x01a7
        L_0x005e:
            r2 = 25
            goto L_0x01a7
        L_0x0062:
            java.lang.String r0 = "backgroundColor"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x006c
            goto L_0x01a7
        L_0x006c:
            r2 = 24
            goto L_0x01a7
        L_0x0070:
            java.lang.String r0 = "accessibilityState"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x007a
            goto L_0x01a7
        L_0x007a:
            r2 = 23
            goto L_0x01a7
        L_0x007e:
            java.lang.String r0 = "accessibilityLabel"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0088
            goto L_0x01a7
        L_0x0088:
            r2 = 22
            goto L_0x01a7
        L_0x008c:
            java.lang.String r0 = "transform"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0096
            goto L_0x01a7
        L_0x0096:
            r2 = 21
            goto L_0x01a7
        L_0x009a:
            java.lang.String r0 = "importantForAccessibility"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x00a4
            goto L_0x01a7
        L_0x00a4:
            r2 = 20
            goto L_0x01a7
        L_0x00a8:
            java.lang.String r0 = "borderBottomRightRadius"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x00b2
            goto L_0x01a7
        L_0x00b2:
            r2 = 19
            goto L_0x01a7
        L_0x00b6:
            java.lang.String r0 = "borderBottomLeftRadius"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x00c0
            goto L_0x01a7
        L_0x00c0:
            r2 = 18
            goto L_0x01a7
        L_0x00c4:
            java.lang.String r0 = "borderTopRightRadius"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x00ce
            goto L_0x01a7
        L_0x00ce:
            r2 = 17
            goto L_0x01a7
        L_0x00d2:
            java.lang.String r0 = "accessibilityLiveRegion"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x00dc
            goto L_0x01a7
        L_0x00dc:
            r2 = 16
            goto L_0x01a7
        L_0x00e0:
            java.lang.String r0 = "role"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x00ea
            goto L_0x01a7
        L_0x00ea:
            r2 = 15
            goto L_0x01a7
        L_0x00ee:
            java.lang.String r0 = "elevation"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x00f8
            goto L_0x01a7
        L_0x00f8:
            r2 = 14
            goto L_0x01a7
        L_0x00fc:
            java.lang.String r0 = "rotation"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0106
            goto L_0x01a7
        L_0x0106:
            r2 = 13
            goto L_0x01a7
        L_0x010a:
            java.lang.String r0 = "renderToHardwareTextureAndroid"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0114
            goto L_0x01a7
        L_0x0114:
            r2 = 12
            goto L_0x01a7
        L_0x0118:
            java.lang.String r0 = "accessibilityRole"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0122
            goto L_0x01a7
        L_0x0122:
            r2 = 11
            goto L_0x01a7
        L_0x0126:
            java.lang.String r0 = "accessibilityHint"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0130
            goto L_0x01a7
        L_0x0130:
            r2 = 10
            goto L_0x01a7
        L_0x0134:
            java.lang.String r0 = "zIndex"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x013e
            goto L_0x01a7
        L_0x013e:
            r2 = 9
            goto L_0x01a7
        L_0x0142:
            java.lang.String r0 = "transformOrigin"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x014c
            goto L_0x01a7
        L_0x014c:
            r2 = 8
            goto L_0x01a7
        L_0x0150:
            java.lang.String r0 = "testID"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0159
            goto L_0x01a7
        L_0x0159:
            r2 = 7
            goto L_0x01a7
        L_0x015b:
            java.lang.String r0 = "scaleY"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0164
            goto L_0x01a7
        L_0x0164:
            r2 = 6
            goto L_0x01a7
        L_0x0166:
            java.lang.String r0 = "scaleX"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x016f
            goto L_0x01a7
        L_0x016f:
            r2 = 5
            goto L_0x01a7
        L_0x0171:
            java.lang.String r0 = "borderTopLeftRadius"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x017a
            goto L_0x01a7
        L_0x017a:
            r2 = 4
            goto L_0x01a7
        L_0x017c:
            java.lang.String r0 = "opacity"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0185
            goto L_0x01a7
        L_0x0185:
            r2 = 3
            goto L_0x01a7
        L_0x0187:
            java.lang.String r0 = "shadowColor"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0190
            goto L_0x01a7
        L_0x0190:
            r2 = 2
            goto L_0x01a7
        L_0x0192:
            java.lang.String r0 = "translateY"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x019b
            goto L_0x01a7
        L_0x019b:
            r2 = 1
            goto L_0x01a7
        L_0x019d:
            java.lang.String r0 = "translateX"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x01a6
            goto L_0x01a7
        L_0x01a6:
            r2 = r1
        L_0x01a7:
            r6 = 1065353216(0x3f800000, float:1.0)
            r0 = 0
            r3 = 2143289344(0x7fc00000, float:NaN)
            switch(r2) {
                case 0: goto L_0x0331;
                case 1: goto L_0x0322;
                case 2: goto L_0x030d;
                case 3: goto L_0x02fe;
                case 4: goto L_0x02ef;
                case 5: goto L_0x02e0;
                case 6: goto L_0x02d1;
                case 7: goto L_0x02c8;
                case 8: goto L_0x02bf;
                case 9: goto L_0x02af;
                case 10: goto L_0x02a6;
                case 11: goto L_0x029d;
                case 12: goto L_0x028d;
                case 13: goto L_0x027d;
                case 14: goto L_0x026d;
                case 15: goto L_0x0264;
                case 16: goto L_0x025b;
                case 17: goto L_0x024b;
                case 18: goto L_0x023b;
                case 19: goto L_0x022b;
                case 20: goto L_0x0222;
                case 21: goto L_0x0219;
                case 22: goto L_0x0210;
                case 23: goto L_0x0207;
                case 24: goto L_0x01f1;
                case 25: goto L_0x01e1;
                case 26: goto L_0x01d8;
                case 27: goto L_0x01cf;
                case 28: goto L_0x01c3;
                case 29: goto L_0x01ba;
                case 30: goto L_0x01b1;
                default: goto L_0x01af;
            }
        L_0x01af:
            goto L_0x033f
        L_0x01b1:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setNativeId(r5, r7)
            goto L_0x033f
        L_0x01ba:
            U r6 = r4.mViewManager
            com.facebook.react.bridge.ReadableMap r7 = (com.facebook.react.bridge.ReadableMap) r7
            r6.setAccessibilityCollectionItem(r5, r7)
            goto L_0x033f
        L_0x01c3:
            com.facebook.react.bridge.DynamicFromObject r6 = new com.facebook.react.bridge.DynamicFromObject
            r6.<init>(r7)
            U r7 = r4.mViewManager
            r7.setAccessibilityLabelledBy(r5, r6)
            goto L_0x033f
        L_0x01cf:
            U r6 = r4.mViewManager
            com.facebook.react.bridge.ReadableMap r7 = (com.facebook.react.bridge.ReadableMap) r7
            r6.setAccessibilityCollection(r5, r7)
            goto L_0x033f
        L_0x01d8:
            U r6 = r4.mViewManager
            com.facebook.react.bridge.ReadableArray r7 = (com.facebook.react.bridge.ReadableArray) r7
            r6.setAccessibilityActions(r5, r7)
            goto L_0x033f
        L_0x01e1:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x01e6
            goto L_0x01ec
        L_0x01e6:
            java.lang.Double r7 = (java.lang.Double) r7
            float r3 = r7.floatValue()
        L_0x01ec:
            r6.setBorderRadius(r5, r3)
            goto L_0x033f
        L_0x01f1:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x01f6
            goto L_0x0202
        L_0x01f6:
            android.content.Context r0 = r5.getContext()
            java.lang.Integer r7 = com.facebook.react.bridge.ColorPropConverter.getColor(r7, r0)
            int r1 = r7.intValue()
        L_0x0202:
            r6.setBackgroundColor(r5, r1)
            goto L_0x033f
        L_0x0207:
            U r6 = r4.mViewManager
            com.facebook.react.bridge.ReadableMap r7 = (com.facebook.react.bridge.ReadableMap) r7
            r6.setViewState(r5, r7)
            goto L_0x033f
        L_0x0210:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setAccessibilityLabel(r5, r7)
            goto L_0x033f
        L_0x0219:
            U r6 = r4.mViewManager
            com.facebook.react.bridge.ReadableArray r7 = (com.facebook.react.bridge.ReadableArray) r7
            r6.setTransform(r5, r7)
            goto L_0x033f
        L_0x0222:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setImportantForAccessibility(r5, r7)
            goto L_0x033f
        L_0x022b:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0230
            goto L_0x0236
        L_0x0230:
            java.lang.Double r7 = (java.lang.Double) r7
            float r3 = r7.floatValue()
        L_0x0236:
            r6.setBorderBottomRightRadius(r5, r3)
            goto L_0x033f
        L_0x023b:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0240
            goto L_0x0246
        L_0x0240:
            java.lang.Double r7 = (java.lang.Double) r7
            float r3 = r7.floatValue()
        L_0x0246:
            r6.setBorderBottomLeftRadius(r5, r3)
            goto L_0x033f
        L_0x024b:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0250
            goto L_0x0256
        L_0x0250:
            java.lang.Double r7 = (java.lang.Double) r7
            float r3 = r7.floatValue()
        L_0x0256:
            r6.setBorderTopRightRadius(r5, r3)
            goto L_0x033f
        L_0x025b:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setAccessibilityLiveRegion(r5, r7)
            goto L_0x033f
        L_0x0264:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setRole(r5, r7)
            goto L_0x033f
        L_0x026d:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0272
            goto L_0x0278
        L_0x0272:
            java.lang.Double r7 = (java.lang.Double) r7
            float r0 = r7.floatValue()
        L_0x0278:
            r6.setElevation(r5, r0)
            goto L_0x033f
        L_0x027d:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0282
            goto L_0x0288
        L_0x0282:
            java.lang.Double r7 = (java.lang.Double) r7
            float r0 = r7.floatValue()
        L_0x0288:
            r6.setRotation(r5, r0)
            goto L_0x033f
        L_0x028d:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0292
            goto L_0x0298
        L_0x0292:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r1 = r7.booleanValue()
        L_0x0298:
            r6.setRenderToHardwareTexture(r5, r1)
            goto L_0x033f
        L_0x029d:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setAccessibilityRole(r5, r7)
            goto L_0x033f
        L_0x02a6:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setAccessibilityHint(r5, r7)
            goto L_0x033f
        L_0x02af:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x02b4
            goto L_0x02ba
        L_0x02b4:
            java.lang.Double r7 = (java.lang.Double) r7
            float r0 = r7.floatValue()
        L_0x02ba:
            r6.setZIndex(r5, r0)
            goto L_0x033f
        L_0x02bf:
            U r6 = r4.mViewManager
            com.facebook.react.bridge.ReadableArray r7 = (com.facebook.react.bridge.ReadableArray) r7
            r6.setTransformOrigin(r5, r7)
            goto L_0x033f
        L_0x02c8:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setTestId(r5, r7)
            goto L_0x033f
        L_0x02d1:
            U r0 = r4.mViewManager
            if (r7 != 0) goto L_0x02d6
            goto L_0x02dc
        L_0x02d6:
            java.lang.Double r7 = (java.lang.Double) r7
            float r6 = r7.floatValue()
        L_0x02dc:
            r0.setScaleY(r5, r6)
            goto L_0x033f
        L_0x02e0:
            U r0 = r4.mViewManager
            if (r7 != 0) goto L_0x02e5
            goto L_0x02eb
        L_0x02e5:
            java.lang.Double r7 = (java.lang.Double) r7
            float r6 = r7.floatValue()
        L_0x02eb:
            r0.setScaleX(r5, r6)
            goto L_0x033f
        L_0x02ef:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x02f4
            goto L_0x02fa
        L_0x02f4:
            java.lang.Double r7 = (java.lang.Double) r7
            float r3 = r7.floatValue()
        L_0x02fa:
            r6.setBorderTopLeftRadius(r5, r3)
            goto L_0x033f
        L_0x02fe:
            U r0 = r4.mViewManager
            if (r7 != 0) goto L_0x0303
            goto L_0x0309
        L_0x0303:
            java.lang.Double r7 = (java.lang.Double) r7
            float r6 = r7.floatValue()
        L_0x0309:
            r0.setOpacity(r5, r6)
            goto L_0x033f
        L_0x030d:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0312
            goto L_0x031e
        L_0x0312:
            android.content.Context r0 = r5.getContext()
            java.lang.Integer r7 = com.facebook.react.bridge.ColorPropConverter.getColor(r7, r0)
            int r1 = r7.intValue()
        L_0x031e:
            r6.setShadowColor(r5, r1)
            goto L_0x033f
        L_0x0322:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0327
            goto L_0x032d
        L_0x0327:
            java.lang.Double r7 = (java.lang.Double) r7
            float r0 = r7.floatValue()
        L_0x032d:
            r6.setTranslateY(r5, r0)
            goto L_0x033f
        L_0x0331:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0336
            goto L_0x033c
        L_0x0336:
            java.lang.Double r7 = (java.lang.Double) r7
            float r0 = r7.floatValue()
        L_0x033c:
            r6.setTranslateX(r5, r0)
        L_0x033f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.BaseViewManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
