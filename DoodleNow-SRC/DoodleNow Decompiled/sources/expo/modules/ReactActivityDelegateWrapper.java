package expo.modules;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.collection.ArrayMap;
import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.ReactDelegate;
import com.facebook.react.ReactHost;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactRootView;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.modules.core.PermissionListener;
import expo.modules.core.interfaces.Package;
import expo.modules.core.interfaces.ReactActivityHandler;
import expo.modules.core.interfaces.ReactActivityLifecycleListener;
import expo.modules.kotlin.Utils;
import expo.modules.kotlin.exception.Exceptions;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\bJ\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\n\u0010!\u001a\u0004\u0018\u00010\"H\u0014J\b\u0010#\u001a\u00020$H\u0014J\n\u0010%\u001a\u0004\u0018\u00010 H\u0014J\n\u0010&\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010'\u001a\u00020(H\u0014J\n\u0010)\u001a\u0004\u0018\u00010*H\u0014J\n\u0010+\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020\u0010H\u0014J\u001b\u0010/\u001a\u0002H0\"\u0004\b\u0000\u001002\u0006\u00101\u001a\u00020\u0016H\u0002¢\u0006\u0002\u00102JA\u0010/\u001a\u0002H0\"\u0004\b\u0000\u00100\"\u0004\b\u0001\u001032\u0006\u00101\u001a\u00020\u00162\u0010\u00104\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u000306052\f\u00107\u001a\b\u0012\u0004\u0012\u0002H305H\u0002¢\u0006\u0002\u00108J\b\u00109\u001a\u00020\u0007H\u0014J\u0012\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\u0016H\u0014J\"\u0010=\u001a\u00020;2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020?2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\b\u0010C\u001a\u00020\u0007H\u0016J\u0012\u0010D\u001a\u00020;2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\u0012\u0010G\u001a\u00020;2\b\u0010H\u001a\u0004\u0018\u00010 H\u0014J\b\u0010I\u001a\u00020;H\u0014J\u001a\u0010J\u001a\u00020\u00072\u0006\u0010K\u001a\u00020?2\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J\u001a\u0010N\u001a\u00020\u00072\u0006\u0010K\u001a\u00020?2\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J\u001a\u0010O\u001a\u00020\u00072\u0006\u0010K\u001a\u00020?2\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J\u0012\u0010P\u001a\u00020\u00072\b\u0010Q\u001a\u0004\u0018\u00010BH\u0016J\b\u0010R\u001a\u00020;H\u0014J1\u0010S\u001a\u00020;2\u0006\u0010>\u001a\u00020?2\u0010\u0010T\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0016\u0018\u0001052\b\u0010U\u001a\u0004\u0018\u00010VH\u0016¢\u0006\u0002\u0010WJ\b\u0010X\u001a\u00020;H\u0014J\u0010\u0010Y\u001a\u00020;2\u0006\u0010Z\u001a\u00020\u0007H\u0016J1\u0010[\u001a\u00020;2\u0010\u0010T\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0016\u0018\u0001052\u0006\u0010>\u001a\u00020?2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0016¢\u0006\u0002\u0010^R\u001d\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0001X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u001a0\u001a0\u0019X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u001d0\u001d0\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006_"}, d2 = {"Lexpo/modules/ReactActivityDelegateWrapper;", "Lcom/facebook/react/ReactActivityDelegate;", "activity", "Lcom/facebook/react/ReactActivity;", "delegate", "(Lcom/facebook/react/ReactActivity;Lcom/facebook/react/ReactActivityDelegate;)V", "isNewArchitectureEnabled", "", "(Lcom/facebook/react/ReactActivity;ZLcom/facebook/react/ReactActivityDelegate;)V", "_reactHost", "Lcom/facebook/react/ReactHost;", "get_reactHost", "()Lcom/facebook/react/ReactHost;", "_reactHost$delegate", "Lkotlin/Lazy;", "_reactNativeHost", "Lcom/facebook/react/ReactNativeHost;", "get_reactNativeHost", "()Lcom/facebook/react/ReactNativeHost;", "_reactNativeHost$delegate", "methodMap", "Landroidx/collection/ArrayMap;", "", "Ljava/lang/reflect/Method;", "reactActivityHandlers", "", "Lexpo/modules/core/interfaces/ReactActivityHandler;", "kotlin.jvm.PlatformType", "reactActivityLifecycleListeners", "Lexpo/modules/core/interfaces/ReactActivityLifecycleListener;", "shouldEmitPendingResume", "composeLaunchOptions", "Landroid/os/Bundle;", "createRootView", "Lcom/facebook/react/ReactRootView;", "getContext", "Landroid/content/Context;", "getLaunchOptions", "getMainComponentName", "getPlainActivity", "Landroid/app/Activity;", "getReactDelegate", "Lcom/facebook/react/ReactDelegate;", "getReactHost", "getReactInstanceManager", "Lcom/facebook/react/ReactInstanceManager;", "getReactNativeHost", "invokeDelegateMethod", "T", "name", "(Ljava/lang/String;)Ljava/lang/Object;", "A", "argTypes", "", "Ljava/lang/Class;", "args", "(Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;", "isFabricEnabled", "loadApp", "", "appKey", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyLongPress", "onKeyUp", "onNewIntent", "intent", "onPause", "onRequestPermissionsResult", "permissions", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onWindowFocusChanged", "hasFocus", "requestPermissions", "listener", "Lcom/facebook/react/modules/core/PermissionListener;", "([Ljava/lang/String;ILcom/facebook/react/modules/core/PermissionListener;)V", "expo_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ReactActivityDelegateWrapper.kt */
public final class ReactActivityDelegateWrapper extends ReactActivityDelegate {
    private final Lazy _reactHost$delegate;
    private final Lazy _reactNativeHost$delegate;
    /* access modifiers changed from: private */
    public final ReactActivity activity;
    /* access modifiers changed from: private */
    public ReactActivityDelegate delegate;
    private final boolean isNewArchitectureEnabled;
    private final ArrayMap<String, Method> methodMap;
    private final List<ReactActivityHandler> reactActivityHandlers;
    private final List<ReactActivityLifecycleListener> reactActivityLifecycleListeners;
    private boolean shouldEmitPendingResume;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReactActivityDelegateWrapper(ReactActivity reactActivity, boolean z, ReactActivityDelegate reactActivityDelegate) {
        super(reactActivity, (String) null);
        Intrinsics.checkNotNullParameter(reactActivity, "activity");
        Intrinsics.checkNotNullParameter(reactActivityDelegate, "delegate");
        this.activity = reactActivity;
        this.isNewArchitectureEnabled = z;
        this.delegate = reactActivityDelegate;
        Collection arrayList = new ArrayList();
        for (Package createReactActivityLifecycleListeners : ExpoModulesPackage.Companion.getPackageList()) {
            List<? extends ReactActivityLifecycleListener> createReactActivityLifecycleListeners2 = createReactActivityLifecycleListeners.createReactActivityLifecycleListeners(this.activity);
            Intrinsics.checkNotNullExpressionValue(createReactActivityLifecycleListeners2, "createReactActivityLifecycleListeners(...)");
            CollectionsKt.addAll(arrayList, createReactActivityLifecycleListeners2);
        }
        this.reactActivityLifecycleListeners = (List) arrayList;
        Collection arrayList2 = new ArrayList();
        for (Package createReactActivityHandlers : ExpoModulesPackage.Companion.getPackageList()) {
            List<? extends ReactActivityHandler> createReactActivityHandlers2 = createReactActivityHandlers.createReactActivityHandlers(this.activity);
            Intrinsics.checkNotNullExpressionValue(createReactActivityHandlers2, "createReactActivityHandlers(...)");
            CollectionsKt.addAll(arrayList2, createReactActivityHandlers2);
        }
        this.reactActivityHandlers = (List) arrayList2;
        this.methodMap = new ArrayMap<>();
        this._reactNativeHost$delegate = LazyKt.lazy(new ReactActivityDelegateWrapper$_reactNativeHost$2(this));
        this._reactHost$delegate = LazyKt.lazy(new ReactActivityDelegateWrapper$_reactHost$2(this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ReactActivityDelegateWrapper(ReactActivity reactActivity, ReactActivityDelegate reactActivityDelegate) {
        this(reactActivity, false, reactActivityDelegate);
        Intrinsics.checkNotNullParameter(reactActivity, "activity");
        Intrinsics.checkNotNullParameter(reactActivityDelegate, "delegate");
    }

    private final ReactNativeHost get_reactNativeHost() {
        return (ReactNativeHost) this._reactNativeHost$delegate.getValue();
    }

    private final ReactHost get_reactHost() {
        return (ReactHost) this._reactHost$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public Bundle getLaunchOptions() {
        return (Bundle) invokeDelegateMethod("getLaunchOptions");
    }

    /* access modifiers changed from: protected */
    public ReactRootView createRootView() {
        return (ReactRootView) invokeDelegateMethod("createRootView");
    }

    /* access modifiers changed from: protected */
    public ReactDelegate getReactDelegate() {
        return (ReactDelegate) invokeDelegateMethod("getReactDelegate");
    }

    /* access modifiers changed from: protected */
    public ReactNativeHost getReactNativeHost() {
        return get_reactNativeHost();
    }

    public ReactHost getReactHost() {
        return get_reactHost();
    }

    public ReactInstanceManager getReactInstanceManager() {
        ReactInstanceManager reactInstanceManager = this.delegate.getReactInstanceManager();
        Intrinsics.checkNotNullExpressionValue(reactInstanceManager, "getReactInstanceManager(...)");
        return reactInstanceManager;
    }

    public String getMainComponentName() {
        return this.delegate.getMainComponentName();
    }

    /* access modifiers changed from: protected */
    public void loadApp(String str) {
        ViewGroup viewGroup = (ViewGroup) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(this.reactActivityHandlers), new ReactActivityDelegateWrapper$loadApp$rootViewContainer$1(this)));
        if (viewGroup != null) {
            Field declaredField = ReactActivityDelegate.class.getDeclaredField("mReactDelegate");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this.delegate);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.facebook.react.ReactDelegate");
            ReactDelegate reactDelegate = (ReactDelegate) obj;
            reactDelegate.loadApp(str);
            ReactRootView reactRootView = reactDelegate.getReactRootView();
            ViewGroup viewGroup2 = null;
            ViewParent parent = reactRootView != null ? reactRootView.getParent() : null;
            if (parent instanceof ViewGroup) {
                viewGroup2 = (ViewGroup) parent;
            }
            if (viewGroup2 != null) {
                viewGroup2.removeView(reactRootView);
            }
            viewGroup.addView(reactRootView, -1);
            this.activity.setContentView((View) viewGroup);
            for (ReactActivityLifecycleListener onContentChanged : this.reactActivityLifecycleListeners) {
                onContentChanged.onContentChanged(this.activity);
            }
            return;
        }
        ReactActivityHandler.DelayLoadAppHandler delayLoadAppHandler = (ReactActivityHandler.DelayLoadAppHandler) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(this.reactActivityHandlers), new ReactActivityDelegateWrapper$loadApp$delayLoadAppHandler$1(this)));
        if (delayLoadAppHandler != null) {
            this.shouldEmitPendingResume = true;
            delayLoadAppHandler.whenReady(new ReactActivityDelegateWrapper$$ExternalSyntheticLambda0(this, str));
            return;
        }
        invokeDelegateMethod("loadApp", new Class[]{String.class}, new String[]{str});
        for (ReactActivityLifecycleListener onContentChanged2 : this.reactActivityLifecycleListeners) {
            onContentChanged2.onContentChanged(this.activity);
        }
    }

    /* access modifiers changed from: private */
    public static final void loadApp$lambda$4(ReactActivityDelegateWrapper reactActivityDelegateWrapper, String str) {
        Intrinsics.checkNotNullParameter(reactActivityDelegateWrapper, "this$0");
        Utils utils = Utils.INSTANCE;
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            reactActivityDelegateWrapper.invokeDelegateMethod("loadApp", new Class[]{String.class}, new String[]{str});
            for (ReactActivityLifecycleListener onContentChanged : reactActivityDelegateWrapper.reactActivityLifecycleListeners) {
                onContentChanged.onContentChanged(reactActivityDelegateWrapper.activity);
            }
            reactActivityDelegateWrapper.shouldEmitPendingResume = false;
            reactActivityDelegateWrapper.onResume();
            return;
        }
        String name = Thread.currentThread().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        String name2 = Looper.getMainLooper().getThread().getName();
        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
        throw new Exceptions.IncorrectThreadException(name, name2);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        ReactDelegate reactDelegate;
        ReactActivityDelegate reactActivityDelegate = (ReactActivityDelegate) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(this.reactActivityHandlers), new ReactActivityDelegateWrapper$onCreate$newDelegate$1(this)));
        if (reactActivityDelegate == null || Intrinsics.areEqual((Object) reactActivityDelegate, (Object) this)) {
            Bundle composeLaunchOptions = composeLaunchOptions();
            if (ReactFeatureFlags.enableBridgelessArchitecture) {
                reactDelegate = new ReactDelegate(getPlainActivity(), getReactHost(), getMainComponentName(), composeLaunchOptions);
            } else {
                reactDelegate = new ReactActivityDelegateWrapper$onCreate$1(composeLaunchOptions, this, getPlainActivity(), getReactNativeHost(), getMainComponentName());
            }
            Field declaredField = ReactActivityDelegate.class.getDeclaredField("mReactDelegate");
            declaredField.setAccessible(true);
            declaredField.set(this.delegate, reactDelegate);
            if (getMainComponentName() != null) {
                loadApp(getMainComponentName());
            }
        } else {
            Field declaredField2 = ReactActivity.class.getDeclaredField("mDelegate");
            declaredField2.setAccessible(true);
            Field declaredField3 = Field.class.getDeclaredField("accessFlags");
            declaredField3.setAccessible(true);
            declaredField3.setInt(declaredField2, declaredField2.getModifiers() & -17);
            declaredField2.set(this.activity, reactActivityDelegate);
            this.delegate = reactActivityDelegate;
            invokeDelegateMethod("onCreate", new Class[]{Bundle.class}, new Bundle[]{bundle});
        }
        for (ReactActivityLifecycleListener onCreate : this.reactActivityLifecycleListeners) {
            onCreate.onCreate(this.activity, bundle);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        if (!this.shouldEmitPendingResume) {
            invokeDelegateMethod("onResume");
            for (ReactActivityLifecycleListener onResume : this.reactActivityLifecycleListeners) {
                onResume.onResume(this.activity);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        if (this.shouldEmitPendingResume) {
            this.shouldEmitPendingResume = false;
        }
        for (ReactActivityLifecycleListener onPause : this.reactActivityLifecycleListeners) {
            onPause.onPause(this.activity);
        }
        invokeDelegateMethod("onPause");
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        if (this.shouldEmitPendingResume) {
            this.shouldEmitPendingResume = false;
        }
        for (ReactActivityLifecycleListener onDestroy : this.reactActivityLifecycleListeners) {
            onDestroy.onDestroy(this.activity);
        }
        invokeDelegateMethod("onDestroy");
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (ReactFeatureFlags.enableBridgelessArchitecture || this.delegate.getReactInstanceManager().getCurrentReactContext() != null) {
            this.delegate.onActivityResult(i, i2, intent);
            return;
        }
        this.delegate.getReactInstanceManager().addReactInstanceEventListener(new ReactActivityDelegateWrapper$onActivityResult$reactContextListener$1(this, i, i2, intent));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z;
        Iterable<ReactActivityHandler> iterable = this.reactActivityHandlers;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ReactActivityHandler onKeyDown : iterable) {
            arrayList.add(Boolean.valueOf(onKeyDown.onKeyDown(i, keyEvent)));
        }
        Iterator it = ((List) arrayList).iterator();
        loop1:
        while (true) {
            z = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop1;
                }
                boolean booleanValue = ((Boolean) it.next()).booleanValue();
                if (z || booleanValue) {
                    z = true;
                }
            }
        }
        return z || this.delegate.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        boolean z;
        Iterable<ReactActivityHandler> iterable = this.reactActivityHandlers;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ReactActivityHandler onKeyUp : iterable) {
            arrayList.add(Boolean.valueOf(onKeyUp.onKeyUp(i, keyEvent)));
        }
        Iterator it = ((List) arrayList).iterator();
        loop1:
        while (true) {
            z = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop1;
                }
                boolean booleanValue = ((Boolean) it.next()).booleanValue();
                if (z || booleanValue) {
                    z = true;
                }
            }
        }
        return z || this.delegate.onKeyUp(i, keyEvent);
    }

    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        boolean z;
        Iterable<ReactActivityHandler> iterable = this.reactActivityHandlers;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ReactActivityHandler onKeyLongPress : iterable) {
            arrayList.add(Boolean.valueOf(onKeyLongPress.onKeyLongPress(i, keyEvent)));
        }
        Iterator it = ((List) arrayList).iterator();
        loop1:
        while (true) {
            z = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop1;
                }
                boolean booleanValue = ((Boolean) it.next()).booleanValue();
                if (z || booleanValue) {
                    z = true;
                }
            }
        }
        return z || this.delegate.onKeyLongPress(i, keyEvent);
    }

    public boolean onBackPressed() {
        boolean z;
        Iterable<ReactActivityLifecycleListener> iterable = this.reactActivityLifecycleListeners;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ReactActivityLifecycleListener onBackPressed : iterable) {
            arrayList.add(Boolean.valueOf(onBackPressed.onBackPressed()));
        }
        Iterator it = ((List) arrayList).iterator();
        loop1:
        while (true) {
            z = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop1;
                }
                boolean booleanValue = ((Boolean) it.next()).booleanValue();
                if (z || booleanValue) {
                    z = true;
                }
            }
        }
        return z || this.delegate.onBackPressed();
    }

    public boolean onNewIntent(Intent intent) {
        boolean z;
        Iterable<ReactActivityLifecycleListener> iterable = this.reactActivityLifecycleListeners;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ReactActivityLifecycleListener onNewIntent : iterable) {
            arrayList.add(Boolean.valueOf(onNewIntent.onNewIntent(intent)));
        }
        Iterator it = ((List) arrayList).iterator();
        loop1:
        while (true) {
            z = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop1;
                }
                boolean booleanValue = ((Boolean) it.next()).booleanValue();
                if (z || booleanValue) {
                    z = true;
                }
            }
        }
        return z || this.delegate.onNewIntent(intent);
    }

    public void onWindowFocusChanged(boolean z) {
        this.delegate.onWindowFocusChanged(z);
    }

    public void requestPermissions(String[] strArr, int i, PermissionListener permissionListener) {
        this.delegate.requestPermissions(strArr, i, permissionListener);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.delegate.onRequestPermissionsResult(i, strArr, iArr);
    }

    /* access modifiers changed from: protected */
    public Context getContext() {
        return (Context) invokeDelegateMethod("getContext");
    }

    /* access modifiers changed from: protected */
    public Activity getPlainActivity() {
        return (Activity) invokeDelegateMethod("getPlainActivity");
    }

    /* access modifiers changed from: protected */
    public boolean isFabricEnabled() {
        return ((Boolean) invokeDelegateMethod("isFabricEnabled")).booleanValue();
    }

    /* access modifiers changed from: protected */
    public Bundle composeLaunchOptions() {
        return (Bundle) invokeDelegateMethod("composeLaunchOptions");
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.delegate.onConfigurationChanged(configuration);
    }

    /* access modifiers changed from: private */
    public final <T> T invokeDelegateMethod(String str) {
        Method method = this.methodMap.get(str);
        if (method == null) {
            method = ReactActivityDelegate.class.getDeclaredMethod(str, new Class[0]);
            method.setAccessible(true);
            this.methodMap.put(str, method);
        }
        Intrinsics.checkNotNull(method);
        return method.invoke(this.delegate, new Object[0]);
    }

    private final <T, A> T invokeDelegateMethod(String str, Class<?>[] clsArr, A[] aArr) {
        Method method = this.methodMap.get(str);
        if (method == null) {
            method = ReactActivityDelegate.class.getDeclaredMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
            method.setAccessible(true);
            this.methodMap.put(str, method);
        }
        Intrinsics.checkNotNull(method);
        return method.invoke(this.delegate, Arrays.copyOf(aArr, aArr.length));
    }
}
