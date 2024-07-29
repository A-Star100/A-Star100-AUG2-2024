package com.airbnb.android.react.lottie;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/airbnb/android/react/lottie/OnAnimationLoadedEvent;", "Lcom/facebook/react/uimanager/events/Event;", "surfaceId", "", "viewId", "(II)V", "getEventData", "Lcom/facebook/react/bridge/WritableMap;", "getEventName", "", "Companion", "lottie-react-native_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: OnAnimationLoadedEvent.kt */
public final class OnAnimationLoadedEvent extends Event<OnAnimationLoadedEvent> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EVENT_NAME = "topAnimationLoaded";

    public String getEventName() {
        return EVENT_NAME;
    }

    public OnAnimationLoadedEvent(int i, int i2) {
        super(i, i2);
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        return Arguments.createMap();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/airbnb/android/react/lottie/OnAnimationLoadedEvent$Companion;", "", "()V", "EVENT_NAME", "", "lottie-react-native_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: OnAnimationLoadedEvent.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
