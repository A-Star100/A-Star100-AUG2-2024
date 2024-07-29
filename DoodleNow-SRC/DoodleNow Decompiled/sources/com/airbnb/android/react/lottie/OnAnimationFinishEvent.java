package com.airbnb.android.react.lottie;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/airbnb/android/react/lottie/OnAnimationFinishEvent;", "Lcom/facebook/react/uimanager/events/Event;", "surfaceId", "", "viewId", "isCancelled", "", "(IIZ)V", "getCoalescingKey", "", "getEventData", "Lcom/facebook/react/bridge/WritableMap;", "getEventName", "", "Companion", "lottie-react-native_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: OnAnimationFinishEvent.kt */
public final class OnAnimationFinishEvent extends Event<OnAnimationFinishEvent> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EVENT_NAME = "topAnimationFinish";
    private final boolean isCancelled;

    public short getCoalescingKey() {
        return 0;
    }

    public String getEventName() {
        return EVENT_NAME;
    }

    public OnAnimationFinishEvent(int i, int i2, boolean z) {
        super(i, i2);
        this.isCancelled = z;
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putBoolean("isCancelled", this.isCancelled);
        return createMap;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/airbnb/android/react/lottie/OnAnimationFinishEvent$Companion;", "", "()V", "EVENT_NAME", "", "lottie-react-native_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: OnAnimationFinishEvent.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
