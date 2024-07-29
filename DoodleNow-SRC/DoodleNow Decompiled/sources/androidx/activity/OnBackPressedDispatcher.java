package androidx.activity;

import android.os.Build;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0003\u001e\u001f B\u0013\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0010H\u0007J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u0010H\u0007J\u0015\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0010H\u0001¢\u0006\u0002\b\u0017J\b\u0010\u0018\u001a\u00020\u0006H\u0007J\b\u0010\u0019\u001a\u00020\tH\u0007J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u000bH\u0007J\r\u0010\u001c\u001a\u00020\tH\u0001¢\u0006\u0002\b\u001dR\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Landroidx/activity/OnBackPressedDispatcher;", "", "fallbackOnBackPressed", "Ljava/lang/Runnable;", "(Ljava/lang/Runnable;)V", "backInvokedCallbackRegistered", "", "enabledChangedCallback", "Lkotlin/Function0;", "", "invokedDispatcher", "Landroid/window/OnBackInvokedDispatcher;", "onBackInvokedCallback", "Landroid/window/OnBackInvokedCallback;", "onBackPressedCallbacks", "Lkotlin/collections/ArrayDeque;", "Landroidx/activity/OnBackPressedCallback;", "addCallback", "onBackPressedCallback", "owner", "Landroidx/lifecycle/LifecycleOwner;", "addCancellableCallback", "Landroidx/activity/Cancellable;", "addCancellableCallback$activity_release", "hasEnabledCallbacks", "onBackPressed", "setOnBackInvokedDispatcher", "invoker", "updateBackInvokedCallbackState", "updateBackInvokedCallbackState$activity_release", "Api33Impl", "LifecycleOnBackPressedCancellable", "OnBackPressedCancellable", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: OnBackPressedDispatcher.kt */
public final class OnBackPressedDispatcher {
    private boolean backInvokedCallbackRegistered;
    private Function0<Unit> enabledChangedCallback;
    private final Runnable fallbackOnBackPressed;
    private OnBackInvokedDispatcher invokedDispatcher;
    private OnBackInvokedCallback onBackInvokedCallback;
    /* access modifiers changed from: private */
    public final ArrayDeque<OnBackPressedCallback> onBackPressedCallbacks;

    public OnBackPressedDispatcher() {
        this((Runnable) null, 1, (DefaultConstructorMarker) null);
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.fallbackOnBackPressed = runnable;
        this.onBackPressedCallbacks = new ArrayDeque<>();
        if (Build.VERSION.SDK_INT >= 33) {
            this.enabledChangedCallback = new Function0<Unit>(this) {
                final /* synthetic */ OnBackPressedDispatcher this$0;

                {
                    this.this$0 = r1;
                }

                public final void invoke() {
                    this.this$0.updateBackInvokedCallbackState$activity_release();
                }
            };
            this.onBackInvokedCallback = Api33Impl.INSTANCE.createOnBackInvokedCallback(new Function0<Unit>(this) {
                final /* synthetic */ OnBackPressedDispatcher this$0;

                {
                    this.this$0 = r1;
                }

                public final void invoke() {
                    this.this$0.onBackPressed();
                }
            });
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OnBackPressedDispatcher(Runnable runnable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : runnable);
    }

    public final void setOnBackInvokedDispatcher(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        Intrinsics.checkNotNullParameter(onBackInvokedDispatcher, "invoker");
        this.invokedDispatcher = onBackInvokedDispatcher;
        updateBackInvokedCallbackState$activity_release();
    }

    public final void updateBackInvokedCallbackState$activity_release() {
        boolean hasEnabledCallbacks = hasEnabledCallbacks();
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.invokedDispatcher;
        OnBackInvokedCallback onBackInvokedCallback2 = this.onBackInvokedCallback;
        if (onBackInvokedDispatcher != null && onBackInvokedCallback2 != null) {
            if (hasEnabledCallbacks && !this.backInvokedCallbackRegistered) {
                Api33Impl.INSTANCE.registerOnBackInvokedCallback(onBackInvokedDispatcher, 0, onBackInvokedCallback2);
                this.backInvokedCallbackRegistered = true;
            } else if (!hasEnabledCallbacks && this.backInvokedCallbackRegistered) {
                Api33Impl.INSTANCE.unregisterOnBackInvokedCallback(onBackInvokedDispatcher, onBackInvokedCallback2);
                this.backInvokedCallbackRegistered = false;
            }
        }
    }

    public final void addCallback(OnBackPressedCallback onBackPressedCallback) {
        Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
        addCancellableCallback$activity_release(onBackPressedCallback);
    }

    public final Cancellable addCancellableCallback$activity_release(OnBackPressedCallback onBackPressedCallback) {
        Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
        this.onBackPressedCallbacks.add(onBackPressedCallback);
        Cancellable onBackPressedCancellable = new OnBackPressedCancellable(this, onBackPressedCallback);
        onBackPressedCallback.addCancellable(onBackPressedCancellable);
        if (Build.VERSION.SDK_INT >= 33) {
            updateBackInvokedCallbackState$activity_release();
            onBackPressedCallback.setEnabledChangedCallback$activity_release(this.enabledChangedCallback);
        }
        return onBackPressedCancellable;
    }

    public final void addCallback(LifecycleOwner lifecycleOwner, OnBackPressedCallback onBackPressedCallback) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
            onBackPressedCallback.addCancellable(new LifecycleOnBackPressedCancellable(this, lifecycle, onBackPressedCallback));
            if (Build.VERSION.SDK_INT >= 33) {
                updateBackInvokedCallbackState$activity_release();
                onBackPressedCallback.setEnabledChangedCallback$activity_release(this.enabledChangedCallback);
            }
        }
    }

    public final boolean hasEnabledCallbacks() {
        Iterable<OnBackPressedCallback> iterable = this.onBackPressedCallbacks;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        for (OnBackPressedCallback isEnabled : iterable) {
            if (isEnabled.isEnabled()) {
                return true;
            }
        }
        return false;
    }

    public final void onBackPressed() {
        Object obj;
        List list = this.onBackPressedCallbacks;
        ListIterator listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                obj = null;
                break;
            }
            obj = listIterator.previous();
            if (((OnBackPressedCallback) obj).isEnabled()) {
                break;
            }
        }
        OnBackPressedCallback onBackPressedCallback = (OnBackPressedCallback) obj;
        if (onBackPressedCallback != null) {
            onBackPressedCallback.handleOnBackPressed();
            return;
        }
        Runnable runnable = this.fallbackOnBackPressed;
        if (runnable != null) {
            runnable.run();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/activity/OnBackPressedDispatcher$OnBackPressedCancellable;", "Landroidx/activity/Cancellable;", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "(Landroidx/activity/OnBackPressedDispatcher;Landroidx/activity/OnBackPressedCallback;)V", "cancel", "", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: OnBackPressedDispatcher.kt */
    private final class OnBackPressedCancellable implements Cancellable {
        private final OnBackPressedCallback onBackPressedCallback;
        final /* synthetic */ OnBackPressedDispatcher this$0;

        public OnBackPressedCancellable(OnBackPressedDispatcher onBackPressedDispatcher, OnBackPressedCallback onBackPressedCallback2) {
            Intrinsics.checkNotNullParameter(onBackPressedCallback2, "onBackPressedCallback");
            this.this$0 = onBackPressedDispatcher;
            this.onBackPressedCallback = onBackPressedCallback2;
        }

        public void cancel() {
            this.this$0.onBackPressedCallbacks.remove(this.onBackPressedCallback);
            this.onBackPressedCallback.removeCancellable(this);
            if (Build.VERSION.SDK_INT >= 33) {
                this.onBackPressedCallback.setEnabledChangedCallback$activity_release((Function0<Unit>) null);
                this.this$0.updateBackInvokedCallbackState$activity_release();
            }
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/activity/OnBackPressedDispatcher$LifecycleOnBackPressedCancellable;", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/activity/Cancellable;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "(Landroidx/activity/OnBackPressedDispatcher;Landroidx/lifecycle/Lifecycle;Landroidx/activity/OnBackPressedCallback;)V", "currentCancellable", "cancel", "", "onStateChanged", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: OnBackPressedDispatcher.kt */
    private final class LifecycleOnBackPressedCancellable implements LifecycleEventObserver, Cancellable {
        private Cancellable currentCancellable;
        private final Lifecycle lifecycle;
        private final OnBackPressedCallback onBackPressedCallback;
        final /* synthetic */ OnBackPressedDispatcher this$0;

        public LifecycleOnBackPressedCancellable(OnBackPressedDispatcher onBackPressedDispatcher, Lifecycle lifecycle2, OnBackPressedCallback onBackPressedCallback2) {
            Intrinsics.checkNotNullParameter(lifecycle2, "lifecycle");
            Intrinsics.checkNotNullParameter(onBackPressedCallback2, "onBackPressedCallback");
            this.this$0 = onBackPressedDispatcher;
            this.lifecycle = lifecycle2;
            this.onBackPressedCallback = onBackPressedCallback2;
            lifecycle2.addObserver(this);
        }

        public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            Intrinsics.checkNotNullParameter(lifecycleOwner, "source");
            Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
            if (event == Lifecycle.Event.ON_START) {
                this.currentCancellable = this.this$0.addCancellableCallback$activity_release(this.onBackPressedCallback);
            } else if (event == Lifecycle.Event.ON_STOP) {
                Cancellable cancellable = this.currentCancellable;
                if (cancellable != null) {
                    cancellable.cancel();
                }
            } else if (event == Lifecycle.Event.ON_DESTROY) {
                cancel();
            }
        }

        public void cancel() {
            this.lifecycle.removeObserver(this);
            this.onBackPressedCallback.removeCancellable(this);
            Cancellable cancellable = this.currentCancellable;
            if (cancellable != null) {
                cancellable.cancel();
            }
            this.currentCancellable = null;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007J \u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0001H\u0007J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0001H\u0007¨\u0006\u000e"}, d2 = {"Landroidx/activity/OnBackPressedDispatcher$Api33Impl;", "", "()V", "createOnBackInvokedCallback", "Landroid/window/OnBackInvokedCallback;", "onBackInvoked", "Lkotlin/Function0;", "", "registerOnBackInvokedCallback", "dispatcher", "priority", "", "callback", "unregisterOnBackInvokedCallback", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: OnBackPressedDispatcher.kt */
    public static final class Api33Impl {
        public static final Api33Impl INSTANCE = new Api33Impl();

        private Api33Impl() {
        }

        public final void registerOnBackInvokedCallback(Object obj, int i, Object obj2) {
            Intrinsics.checkNotNullParameter(obj, "dispatcher");
            Intrinsics.checkNotNullParameter(obj2, "callback");
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(i, (OnBackInvokedCallback) obj2);
        }

        public final void unregisterOnBackInvokedCallback(Object obj, Object obj2) {
            Intrinsics.checkNotNullParameter(obj, "dispatcher");
            Intrinsics.checkNotNullParameter(obj2, "callback");
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }

        /* access modifiers changed from: private */
        public static final void createOnBackInvokedCallback$lambda$0(Function0 function0) {
            Intrinsics.checkNotNullParameter(function0, "$onBackInvoked");
            function0.invoke();
        }

        public final OnBackInvokedCallback createOnBackInvokedCallback(Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, "onBackInvoked");
            return new OnBackPressedDispatcher$Api33Impl$$ExternalSyntheticLambda0(function0);
        }
    }
}
