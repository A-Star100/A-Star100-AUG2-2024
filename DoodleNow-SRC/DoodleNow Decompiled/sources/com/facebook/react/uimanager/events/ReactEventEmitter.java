package com.facebook.react.uimanager.events;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.common.ViewUtil;

class ReactEventEmitter implements RCTModernEventEmitter {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "ReactEventEmitter";
    private RCTEventEmitter mDefaultEventEmitter = null;
    private RCTModernEventEmitter mFabricEventEmitter = null;
    private final ReactApplicationContext mReactContext;

    public void register(int i, RCTEventEmitter rCTEventEmitter) {
        this.mDefaultEventEmitter = rCTEventEmitter;
    }

    public void register(int i, RCTModernEventEmitter rCTModernEventEmitter) {
        this.mFabricEventEmitter = rCTModernEventEmitter;
    }

    public void unregister(int i) {
        if (i == 1) {
            this.mDefaultEventEmitter = null;
        } else {
            this.mFabricEventEmitter = null;
        }
    }

    public ReactEventEmitter(ReactApplicationContext reactApplicationContext) {
        this.mReactContext = reactApplicationContext;
    }

    public void receiveEvent(int i, String str, WritableMap writableMap) {
        receiveEvent(-1, i, str, writableMap);
    }

    public void receiveEvent(int i, int i2, String str, WritableMap writableMap) {
        receiveEvent(i, i2, str, false, 0, writableMap, 2);
    }

    public void receiveTouches(String str, WritableArray writableArray, WritableArray writableArray2) {
        Assertions.assertCondition(writableArray.size() > 0);
        if (ViewUtil.getUIManagerType(writableArray.getMap(0).getInt(TouchesHelper.TARGET_KEY)) == 1 && getDefaultEventEmitter() != null) {
            this.mDefaultEventEmitter.receiveTouches(str, writableArray, writableArray2);
        }
    }

    public void receiveTouches(TouchEvent touchEvent) {
        RCTModernEventEmitter rCTModernEventEmitter;
        int viewTag = touchEvent.getViewTag();
        int uIManagerType = ViewUtil.getUIManagerType(touchEvent.getViewTag(), touchEvent.getSurfaceId());
        if (uIManagerType == 2 && (rCTModernEventEmitter = this.mFabricEventEmitter) != null) {
            TouchesHelper.sendTouchEvent(rCTModernEventEmitter, touchEvent);
        } else if (uIManagerType != 1 || getDefaultEventEmitter() == null) {
            ReactSoftExceptionLogger.logSoftException(TAG, new ReactNoCrashSoftException("Cannot find EventEmitter for receivedTouches: ReactTag[" + viewTag + "] UIManagerType[" + uIManagerType + "] EventName[" + touchEvent.getEventName() + "]"));
        } else {
            TouchesHelper.sendTouchesLegacy(this.mDefaultEventEmitter, touchEvent);
        }
    }

    private RCTEventEmitter getDefaultEventEmitter() {
        if (this.mDefaultEventEmitter == null) {
            if (this.mReactContext.hasActiveReactInstance()) {
                this.mDefaultEventEmitter = (RCTEventEmitter) this.mReactContext.getJSModule(RCTEventEmitter.class);
            } else {
                ReactSoftExceptionLogger.logSoftException(TAG, new ReactNoCrashSoftException("Cannot get RCTEventEmitter from Context, no active Catalyst instance!"));
            }
        }
        return this.mDefaultEventEmitter;
    }

    public void receiveEvent(int i, int i2, String str, boolean z, int i3, WritableMap writableMap, int i4) {
        RCTModernEventEmitter rCTModernEventEmitter;
        int i5 = i;
        int i6 = i2;
        String str2 = str;
        int uIManagerType = ViewUtil.getUIManagerType(i2, i);
        if (uIManagerType == 2 && (rCTModernEventEmitter = this.mFabricEventEmitter) != null) {
            rCTModernEventEmitter.receiveEvent(i, i2, str, z, i3, writableMap, i4);
        } else if (uIManagerType != 1 || getDefaultEventEmitter() == null) {
            ReactSoftExceptionLogger.logSoftException(TAG, new ReactNoCrashSoftException("Cannot find EventEmitter for receiveEvent: SurfaceId[" + i + "] ReactTag[" + i2 + "] UIManagerType[" + uIManagerType + "] EventName[" + str + "]"));
        } else {
            WritableMap writableMap2 = writableMap;
            this.mDefaultEventEmitter.receiveEvent(i2, str, writableMap);
        }
    }
}
