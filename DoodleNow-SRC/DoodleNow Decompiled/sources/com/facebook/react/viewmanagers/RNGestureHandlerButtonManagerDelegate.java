package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface;

public class RNGestureHandlerButtonManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & RNGestureHandlerButtonManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public RNGestureHandlerButtonManagerDelegate(U u) {
        super(u);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r5, java.lang.String r6, java.lang.Object r7) {
        /*
            r4 = this;
            r6.hashCode()
            int r0 = r6.hashCode()
            r1 = 1
            r2 = 0
            r3 = -1
            switch(r0) {
                case -2143114526: goto L_0x0078;
                case -1609594047: goto L_0x006d;
                case -775297261: goto L_0x0062;
                case 722830999: goto L_0x0057;
                case 737768677: goto L_0x004c;
                case 741115130: goto L_0x0041;
                case 1387411372: goto L_0x0036;
                case 1686617758: goto L_0x002b;
                case 1825644485: goto L_0x001d;
                case 1984457027: goto L_0x000f;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x0082
        L_0x000f:
            java.lang.String r0 = "foreground"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0019
            goto L_0x0082
        L_0x0019:
            r3 = 9
            goto L_0x0082
        L_0x001d:
            java.lang.String r0 = "borderless"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0027
            goto L_0x0082
        L_0x0027:
            r3 = 8
            goto L_0x0082
        L_0x002b:
            java.lang.String r0 = "exclusive"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0034
            goto L_0x0082
        L_0x0034:
            r3 = 7
            goto L_0x0082
        L_0x0036:
            java.lang.String r0 = "touchSoundDisabled"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x003f
            goto L_0x0082
        L_0x003f:
            r3 = 6
            goto L_0x0082
        L_0x0041:
            java.lang.String r0 = "borderWidth"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x004a
            goto L_0x0082
        L_0x004a:
            r3 = 5
            goto L_0x0082
        L_0x004c:
            java.lang.String r0 = "borderStyle"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0055
            goto L_0x0082
        L_0x0055:
            r3 = 4
            goto L_0x0082
        L_0x0057:
            java.lang.String r0 = "borderColor"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0060
            goto L_0x0082
        L_0x0060:
            r3 = 3
            goto L_0x0082
        L_0x0062:
            java.lang.String r0 = "rippleColor"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x006b
            goto L_0x0082
        L_0x006b:
            r3 = 2
            goto L_0x0082
        L_0x006d:
            java.lang.String r0 = "enabled"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0076
            goto L_0x0082
        L_0x0076:
            r3 = r1
            goto L_0x0082
        L_0x0078:
            java.lang.String r0 = "rippleRadius"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0081
            goto L_0x0082
        L_0x0081:
            r3 = r2
        L_0x0082:
            switch(r3) {
                case 0: goto L_0x0123;
                case 1: goto L_0x0112;
                case 2: goto L_0x0102;
                case 3: goto L_0x00f2;
                case 4: goto L_0x00e3;
                case 5: goto L_0x00d1;
                case 6: goto L_0x00c0;
                case 7: goto L_0x00ae;
                case 8: goto L_0x009c;
                case 9: goto L_0x008a;
                default: goto L_0x0085;
            }
        L_0x0085:
            super.setProperty(r5, r6, r7)
            goto L_0x0133
        L_0x008a:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface r6 = (com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface) r6
            if (r7 != 0) goto L_0x0091
            goto L_0x0097
        L_0x0091:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r2 = r7.booleanValue()
        L_0x0097:
            r6.setForeground(r5, r2)
            goto L_0x0133
        L_0x009c:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface r6 = (com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface) r6
            if (r7 != 0) goto L_0x00a3
            goto L_0x00a9
        L_0x00a3:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r2 = r7.booleanValue()
        L_0x00a9:
            r6.setBorderless(r5, r2)
            goto L_0x0133
        L_0x00ae:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface r6 = (com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface) r6
            if (r7 != 0) goto L_0x00b5
            goto L_0x00bb
        L_0x00b5:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r1 = r7.booleanValue()
        L_0x00bb:
            r6.setExclusive(r5, r1)
            goto L_0x0133
        L_0x00c0:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface r6 = (com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface) r6
            if (r7 != 0) goto L_0x00c7
            goto L_0x00cd
        L_0x00c7:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r2 = r7.booleanValue()
        L_0x00cd:
            r6.setTouchSoundDisabled(r5, r2)
            goto L_0x0133
        L_0x00d1:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface r6 = (com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface) r6
            if (r7 != 0) goto L_0x00d9
            r7 = 0
            goto L_0x00df
        L_0x00d9:
            java.lang.Double r7 = (java.lang.Double) r7
            float r7 = r7.floatValue()
        L_0x00df:
            r6.setBorderWidth(r5, r7)
            goto L_0x0133
        L_0x00e3:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface r6 = (com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface) r6
            if (r7 != 0) goto L_0x00ec
            java.lang.String r7 = "solid"
            goto L_0x00ee
        L_0x00ec:
            java.lang.String r7 = (java.lang.String) r7
        L_0x00ee:
            r6.setBorderStyle(r5, r7)
            goto L_0x0133
        L_0x00f2:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface r6 = (com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface) r6
            android.content.Context r0 = r5.getContext()
            java.lang.Integer r7 = com.facebook.react.bridge.ColorPropConverter.getColor(r7, r0)
            r6.setBorderColor(r5, r7)
            goto L_0x0133
        L_0x0102:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface r6 = (com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface) r6
            android.content.Context r0 = r5.getContext()
            java.lang.Integer r7 = com.facebook.react.bridge.ColorPropConverter.getColor(r7, r0)
            r6.setRippleColor(r5, r7)
            goto L_0x0133
        L_0x0112:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface r6 = (com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface) r6
            if (r7 != 0) goto L_0x0119
            goto L_0x011f
        L_0x0119:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r1 = r7.booleanValue()
        L_0x011f:
            r6.setEnabled(r5, r1)
            goto L_0x0133
        L_0x0123:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface r6 = (com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface) r6
            if (r7 != 0) goto L_0x012a
            goto L_0x0130
        L_0x012a:
            java.lang.Double r7 = (java.lang.Double) r7
            int r2 = r7.intValue()
        L_0x0130:
            r6.setRippleRadius(r5, r2)
        L_0x0133:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
