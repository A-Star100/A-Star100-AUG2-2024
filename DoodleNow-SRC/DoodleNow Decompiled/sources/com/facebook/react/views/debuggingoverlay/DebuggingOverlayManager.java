package com.facebook.react.views.debuggingoverlay;

import android.graphics.RectF;
import com.facebook.react.bridge.NoSuchKeyException;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UnexpectedNativeTypeException;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import java.util.ArrayList;

@ReactModule(name = "DebuggingOverlay")
public class DebuggingOverlayManager extends SimpleViewManager<DebuggingOverlay> {
    public static final String REACT_CLASS = "DebuggingOverlay";

    public String getName() {
        return REACT_CLASS;
    }

    public void receiveCommand(DebuggingOverlay debuggingOverlay, String str, ReadableArray readableArray) {
        DebuggingOverlay debuggingOverlay2 = debuggingOverlay;
        String str2 = str;
        ReadableArray readableArray2 = readableArray;
        str.hashCode();
        int i = 0;
        char c = 65535;
        switch (str.hashCode()) {
            case -1942063165:
                if (str2.equals("clearElementsHighlights")) {
                    c = 0;
                    break;
                }
                break;
            case 1326903961:
                if (str2.equals("highlightTraceUpdates")) {
                    c = 1;
                    break;
                }
                break;
            case 1385348555:
                if (str2.equals("highlightElements")) {
                    c = 2;
                    break;
                }
                break;
        }
        String str3 = "width";
        switch (c) {
            case 0:
                debuggingOverlay.clearElementsHighlights();
                return;
            case 1:
                if (readableArray2 != null) {
                    ReadableArray array = readableArray2.getArray(0);
                    ArrayList arrayList = new ArrayList();
                    while (i < array.size()) {
                        ReadableMap map = array.getMap(i);
                        ReadableMap map2 = map.getMap("rectangle");
                        if (map2 == null) {
                            ReactSoftExceptionLogger.logSoftException(REACT_CLASS, new ReactNoCrashSoftException("Unexpected payload for highlighting trace updates: rectangle field is null"));
                            return;
                        }
                        int i2 = map.getInt("id");
                        int i3 = map.getInt("color");
                        try {
                            float f = (float) map2.getDouble("x");
                            float f2 = (float) map2.getDouble("y");
                            ReadableArray readableArray3 = array;
                            String str4 = str3;
                            arrayList.add(new TraceUpdate(i2, new RectF(PixelUtil.toPixelFromDIP(f), PixelUtil.toPixelFromDIP(f2), PixelUtil.toPixelFromDIP((float) (((double) f) + map2.getDouble(str3))), PixelUtil.toPixelFromDIP((float) (((double) f2) + map2.getDouble("height")))), i3));
                            i++;
                            str3 = str4;
                            array = readableArray3;
                        } catch (NoSuchKeyException | UnexpectedNativeTypeException unused) {
                            ReactSoftExceptionLogger.logSoftException(REACT_CLASS, new ReactNoCrashSoftException("Unexpected payload for highlighting trace updates: rectangle field should have x, y, width, height fields"));
                            return;
                        }
                    }
                    debuggingOverlay2.setTraceUpdates(arrayList);
                    return;
                }
                return;
            case 2:
                if (readableArray2 != null) {
                    ReadableArray array2 = readableArray2.getArray(0);
                    ArrayList arrayList2 = new ArrayList();
                    while (i < array2.size()) {
                        ReadableMap map3 = array2.getMap(i);
                        try {
                            float f3 = (float) map3.getDouble("x");
                            float f4 = (float) map3.getDouble("y");
                            arrayList2.add(new RectF(PixelUtil.toPixelFromDIP(f3), PixelUtil.toPixelFromDIP(f4), PixelUtil.toPixelFromDIP((float) (((double) f3) + map3.getDouble(str3))), PixelUtil.toPixelFromDIP((float) (((double) f4) + map3.getDouble("height")))));
                            i++;
                        } catch (NoSuchKeyException | UnexpectedNativeTypeException unused2) {
                            ReactSoftExceptionLogger.logSoftException(REACT_CLASS, new ReactNoCrashSoftException("Unexpected payload for highlighting elements: every element should have x, y, width, height fields"));
                            return;
                        }
                    }
                    debuggingOverlay2.setHighlightedElementsRectangles(arrayList2);
                    return;
                }
                return;
            default:
                ReactSoftExceptionLogger.logSoftException(REACT_CLASS, new ReactNoCrashSoftException("Received unexpected command in DebuggingOverlayManager"));
                return;
        }
    }

    public DebuggingOverlay createViewInstance(ThemedReactContext themedReactContext) {
        return new DebuggingOverlay(themedReactContext);
    }
}
