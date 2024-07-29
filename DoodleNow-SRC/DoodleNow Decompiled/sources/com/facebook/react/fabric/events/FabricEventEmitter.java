package com.facebook.react.fabric.events;

import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.fabric.FabricUIManager;
import com.facebook.react.uimanager.events.RCTModernEventEmitter;
import com.facebook.react.uimanager.events.TouchEvent;
import com.facebook.systrace.Systrace;

public class FabricEventEmitter implements RCTModernEventEmitter {
    private final FabricUIManager mUIManager;

    public FabricEventEmitter(FabricUIManager fabricUIManager) {
        this.mUIManager = fabricUIManager;
    }

    public void receiveEvent(int i, String str, WritableMap writableMap) {
        receiveEvent(-1, i, str, writableMap);
    }

    public void receiveEvent(int i, int i2, String str, WritableMap writableMap) {
        receiveEvent(i, i2, str, false, 0, writableMap, 2);
    }

    public void receiveEvent(int i, int i2, String str, boolean z, int i3, WritableMap writableMap, int i4) {
        StringBuilder sb = new StringBuilder("FabricEventEmitter.receiveEvent('");
        String str2 = str;
        sb.append(str);
        sb.append("')");
        Systrace.beginSection(0, sb.toString());
        try {
            this.mUIManager.receiveEvent(i, i2, str, z, writableMap, i4);
        } finally {
            Systrace.endSection(0);
        }
    }

    public void receiveTouches(String str, WritableArray writableArray, WritableArray writableArray2) {
        throw new UnsupportedOperationException("EventEmitter#receiveTouches is not supported by Fabric");
    }

    public void receiveTouches(TouchEvent touchEvent) {
        throw new UnsupportedOperationException("EventEmitter#receiveTouches is not supported by Fabric");
    }
}
