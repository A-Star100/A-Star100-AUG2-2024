package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.RNCAndroidDialogPickerManagerInterface;

public class RNCAndroidDialogPickerManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & RNCAndroidDialogPickerManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public RNCAndroidDialogPickerManagerDelegate(U u) {
        super(u);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v16, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v17, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v18, resolved type: boolean} */
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
                case -1902983847: goto L_0x0069;
                case -1808880503: goto L_0x005e;
                case -1609594047: goto L_0x0053;
                case -1329887265: goto L_0x0048;
                case -979805852: goto L_0x003d;
                case 94842723: goto L_0x0032;
                case 100526016: goto L_0x0027;
                case 1191572123: goto L_0x001c;
                case 1287124693: goto L_0x000e;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x0073
        L_0x000e:
            java.lang.String r0 = "backgroundColor"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0018
            goto L_0x0073
        L_0x0018:
            r2 = 8
            goto L_0x0073
        L_0x001c:
            java.lang.String r0 = "selected"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0025
            goto L_0x0073
        L_0x0025:
            r2 = 7
            goto L_0x0073
        L_0x0027:
            java.lang.String r0 = "items"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0030
            goto L_0x0073
        L_0x0030:
            r2 = 6
            goto L_0x0073
        L_0x0032:
            java.lang.String r0 = "color"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x003b
            goto L_0x0073
        L_0x003b:
            r2 = 5
            goto L_0x0073
        L_0x003d:
            java.lang.String r0 = "prompt"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0046
            goto L_0x0073
        L_0x0046:
            r2 = 4
            goto L_0x0073
        L_0x0048:
            java.lang.String r0 = "numberOfLines"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0051
            goto L_0x0073
        L_0x0051:
            r2 = 3
            goto L_0x0073
        L_0x0053:
            java.lang.String r0 = "enabled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x005c
            goto L_0x0073
        L_0x005c:
            r2 = 2
            goto L_0x0073
        L_0x005e:
            java.lang.String r0 = "dropdownIconRippleColor"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0067
            goto L_0x0073
        L_0x0067:
            r2 = 1
            goto L_0x0073
        L_0x0069:
            java.lang.String r0 = "dropdownIconColor"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0072
            goto L_0x0073
        L_0x0072:
            r2 = r1
        L_0x0073:
            switch(r2) {
                case 0: goto L_0x00fa;
                case 1: goto L_0x00e9;
                case 2: goto L_0x00d8;
                case 3: goto L_0x00c7;
                case 4: goto L_0x00b9;
                case 5: goto L_0x00a9;
                case 6: goto L_0x009f;
                case 7: goto L_0x008d;
                case 8: goto L_0x007b;
                default: goto L_0x0076;
            }
        L_0x0076:
            super.setProperty(r4, r5, r6)
            goto L_0x010a
        L_0x007b:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNCAndroidDialogPickerManagerInterface r5 = (com.facebook.react.viewmanagers.RNCAndroidDialogPickerManagerInterface) r5
            if (r6 != 0) goto L_0x0082
            goto L_0x0088
        L_0x0082:
            java.lang.Double r6 = (java.lang.Double) r6
            int r1 = r6.intValue()
        L_0x0088:
            r5.setBackgroundColor(r4, r1)
            goto L_0x010a
        L_0x008d:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNCAndroidDialogPickerManagerInterface r5 = (com.facebook.react.viewmanagers.RNCAndroidDialogPickerManagerInterface) r5
            if (r6 != 0) goto L_0x0094
            goto L_0x009a
        L_0x0094:
            java.lang.Double r6 = (java.lang.Double) r6
            int r1 = r6.intValue()
        L_0x009a:
            r5.setSelected(r4, r1)
            goto L_0x010a
        L_0x009f:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNCAndroidDialogPickerManagerInterface r5 = (com.facebook.react.viewmanagers.RNCAndroidDialogPickerManagerInterface) r5
            com.facebook.react.bridge.ReadableArray r6 = (com.facebook.react.bridge.ReadableArray) r6
            r5.setItems(r4, r6)
            goto L_0x010a
        L_0x00a9:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNCAndroidDialogPickerManagerInterface r5 = (com.facebook.react.viewmanagers.RNCAndroidDialogPickerManagerInterface) r5
            android.content.Context r0 = r4.getContext()
            java.lang.Integer r6 = com.facebook.react.bridge.ColorPropConverter.getColor(r6, r0)
            r5.setColor(r4, r6)
            goto L_0x010a
        L_0x00b9:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNCAndroidDialogPickerManagerInterface r5 = (com.facebook.react.viewmanagers.RNCAndroidDialogPickerManagerInterface) r5
            if (r6 != 0) goto L_0x00c1
            r6 = 0
            goto L_0x00c3
        L_0x00c1:
            java.lang.String r6 = (java.lang.String) r6
        L_0x00c3:
            r5.setPrompt(r4, r6)
            goto L_0x010a
        L_0x00c7:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNCAndroidDialogPickerManagerInterface r5 = (com.facebook.react.viewmanagers.RNCAndroidDialogPickerManagerInterface) r5
            if (r6 != 0) goto L_0x00ce
            goto L_0x00d4
        L_0x00ce:
            java.lang.Double r6 = (java.lang.Double) r6
            int r1 = r6.intValue()
        L_0x00d4:
            r5.setNumberOfLines(r4, r1)
            goto L_0x010a
        L_0x00d8:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNCAndroidDialogPickerManagerInterface r5 = (com.facebook.react.viewmanagers.RNCAndroidDialogPickerManagerInterface) r5
            if (r6 != 0) goto L_0x00df
            goto L_0x00e5
        L_0x00df:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r1 = r6.booleanValue()
        L_0x00e5:
            r5.setEnabled(r4, r1)
            goto L_0x010a
        L_0x00e9:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNCAndroidDialogPickerManagerInterface r5 = (com.facebook.react.viewmanagers.RNCAndroidDialogPickerManagerInterface) r5
            if (r6 != 0) goto L_0x00f0
            goto L_0x00f6
        L_0x00f0:
            java.lang.Double r6 = (java.lang.Double) r6
            int r1 = r6.intValue()
        L_0x00f6:
            r5.setDropdownIconRippleColor(r4, r1)
            goto L_0x010a
        L_0x00fa:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.RNCAndroidDialogPickerManagerInterface r5 = (com.facebook.react.viewmanagers.RNCAndroidDialogPickerManagerInterface) r5
            if (r6 != 0) goto L_0x0101
            goto L_0x0107
        L_0x0101:
            java.lang.Double r6 = (java.lang.Double) r6
            int r1 = r6.intValue()
        L_0x0107:
            r5.setDropdownIconColor(r4, r1)
        L_0x010a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.RNCAndroidDialogPickerManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }

    public void receiveCommand(T t, String str, ReadableArray readableArray) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 3027047:
                if (str.equals("blur")) {
                    c = 0;
                    break;
                }
                break;
            case 97604824:
                if (str.equals("focus")) {
                    c = 1;
                    break;
                }
                break;
            case 361157844:
                if (str.equals("setNativeSelected")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                ((RNCAndroidDialogPickerManagerInterface) this.mViewManager).blur(t);
                return;
            case 1:
                ((RNCAndroidDialogPickerManagerInterface) this.mViewManager).focus(t);
                return;
            case 2:
                ((RNCAndroidDialogPickerManagerInterface) this.mViewManager).setNativeSelected(t, readableArray.getInt(0));
                return;
            default:
                return;
        }
    }
}
