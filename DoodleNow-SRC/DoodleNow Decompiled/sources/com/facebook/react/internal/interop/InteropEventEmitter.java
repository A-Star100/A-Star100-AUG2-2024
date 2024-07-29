package com.facebook.react.internal.interop;

import android.content.Context;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\"\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0017J \u0010\u0010\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/facebook/react/internal/interop/InteropEventEmitter;", "Lcom/facebook/react/uimanager/events/RCTEventEmitter;", "reactContext", "Lcom/facebook/react/bridge/ReactContext;", "(Lcom/facebook/react/bridge/ReactContext;)V", "eventDispatcherOverride", "Lcom/facebook/react/uimanager/events/EventDispatcher;", "overrideEventDispatcher", "", "receiveEvent", "targetReactTag", "", "eventName", "", "eventData", "Lcom/facebook/react/bridge/WritableMap;", "receiveTouches", "touches", "Lcom/facebook/react/bridge/WritableArray;", "changedIndices", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: InteropEventEmitter.kt */
public final class InteropEventEmitter implements RCTEventEmitter {
    private EventDispatcher eventDispatcherOverride;
    private final ReactContext reactContext;

    @VisibleForTesting
    public final void overrideEventDispatcher(EventDispatcher eventDispatcher) {
        this.eventDispatcherOverride = eventDispatcher;
    }

    public InteropEventEmitter(ReactContext reactContext2) {
        Intrinsics.checkNotNullParameter(reactContext2, "reactContext");
        this.reactContext = reactContext2;
    }

    @Deprecated(message = "Deprecated in Java")
    public void receiveEvent(int i, String str, WritableMap writableMap) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        EventDispatcher eventDispatcher = this.eventDispatcherOverride;
        if (eventDispatcher == null) {
            eventDispatcher = UIManagerHelper.getEventDispatcherForReactTag(this.reactContext, i);
        }
        int surfaceId = UIManagerHelper.getSurfaceId((Context) this.reactContext);
        if (eventDispatcher != null) {
            eventDispatcher.dispatchEvent(new InteropEvent(str, writableMap, surfaceId, i));
        }
    }

    public void receiveTouches(String str, WritableArray writableArray, WritableArray writableArray2) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(writableArray, "touches");
        Intrinsics.checkNotNullParameter(writableArray2, "changedIndices");
        throw new UnsupportedOperationException("EventEmitter#receiveTouches is not supported by the Fabric Interop Layer");
    }
}
