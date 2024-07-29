package com.onesignal.core.internal.application.impl;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import com.onesignal.common.events.EventProducer;
import com.onesignal.common.threading.Waiter;
import com.onesignal.core.internal.application.AppEntryAction;
import com.onesignal.core.internal.application.IActivityLifecycleHandler;
import com.onesignal.core.internal.application.IApplicationLifecycleHandler;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.debug.internal.logging.Logging;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000bH\u0016J\u0010\u0010+\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0012H\u0016J\u0016\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020/J\b\u00100\u001a\u00020)H\u0002J\b\u00101\u001a\u00020)H\u0002J\u001a\u00102\u001a\u00020)2\u0006\u0010-\u001a\u00020\b2\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u0010\u00105\u001a\u00020)2\u0006\u0010-\u001a\u00020\bH\u0016J\u0010\u00106\u001a\u00020)2\u0006\u0010-\u001a\u00020\bH\u0016J\u0010\u00107\u001a\u00020)2\u0006\u0010-\u001a\u00020\bH\u0016J\u0018\u00108\u001a\u00020)2\u0006\u00109\u001a\u00020\b2\u0006\u0010:\u001a\u000204H\u0016J\u0010\u0010;\u001a\u00020)2\u0006\u0010-\u001a\u00020\bH\u0016J\u0010\u0010<\u001a\u00020)2\u0006\u0010-\u001a\u00020\bH\u0016J\b\u0010=\u001a\u00020)H\u0016J\u0018\u0010>\u001a\u00020)2\u0006\u0010?\u001a\u00020\r2\u0006\u0010-\u001a\u00020\bH\u0002J\u0010\u0010@\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000bH\u0016J\u0010\u0010A\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0012H\u0016J\u000e\u0010B\u001a\u00020)2\u0006\u0010C\u001a\u00020\u0006J\u0011\u0010D\u001a\u00020 H@ø\u0001\u0000¢\u0006\u0002\u0010EJ\u0011\u0010F\u001a\u00020 H@ø\u0001\u0000¢\u0006\u0002\u0010ER\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\nX\u0004¢\u0006\u0002\n\u0000R(\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\b8V@VX\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u00020 8VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020 8BX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\"\u0002\u0004\n\u0002\b\u0019¨\u0006G"}, d2 = {"Lcom/onesignal/core/internal/application/impl/ApplicationService;", "Lcom/onesignal/core/internal/application/IApplicationService;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "()V", "_appContext", "Landroid/content/Context;", "_current", "Landroid/app/Activity;", "activityLifecycleNotifier", "Lcom/onesignal/common/events/EventProducer;", "Lcom/onesignal/core/internal/application/IActivityLifecycleHandler;", "activityReferences", "", "appContext", "getAppContext", "()Landroid/content/Context;", "applicationLifecycleNotifier", "Lcom/onesignal/core/internal/application/IApplicationLifecycleHandler;", "value", "current", "getCurrent", "()Landroid/app/Activity;", "setCurrent", "(Landroid/app/Activity;)V", "entryState", "Lcom/onesignal/core/internal/application/AppEntryAction;", "getEntryState", "()Lcom/onesignal/core/internal/application/AppEntryAction;", "setEntryState", "(Lcom/onesignal/core/internal/application/AppEntryAction;)V", "isActivityChangingConfigurations", "", "isInForeground", "()Z", "nextResumeIsFirstActivity", "systemConditionNotifier", "Lcom/onesignal/core/internal/application/impl/ISystemConditionHandler;", "wasInBackground", "getWasInBackground", "addActivityLifecycleHandler", "", "handler", "addApplicationLifecycleHandler", "decorViewReady", "activity", "runnable", "Ljava/lang/Runnable;", "handleFocus", "handleLostFocus", "onActivityCreated", "bundle", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "p0", "p1", "onActivityStarted", "onActivityStopped", "onGlobalLayout", "onOrientationChanged", "orientation", "removeActivityLifecycleHandler", "removeApplicationLifecycleHandler", "start", "context", "waitUntilActivityReady", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitUntilSystemConditionsAvailable", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ApplicationService.kt */
public final class ApplicationService implements IApplicationService, Application.ActivityLifecycleCallbacks, ViewTreeObserver.OnGlobalLayoutListener {
    private Context _appContext;
    private Activity _current;
    private final EventProducer<IActivityLifecycleHandler> activityLifecycleNotifier = new EventProducer<>();
    private int activityReferences;
    private final EventProducer<IApplicationLifecycleHandler> applicationLifecycleNotifier = new EventProducer<>();
    private AppEntryAction entryState = AppEntryAction.APP_CLOSE;
    private boolean isActivityChangingConfigurations;
    private boolean nextResumeIsFirstActivity;
    private final EventProducer<ISystemConditionHandler> systemConditionNotifier = new EventProducer<>();

    public Activity getCurrent() {
        return this._current;
    }

    public AppEntryAction getEntryState() {
        return this.entryState;
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "p0");
        Intrinsics.checkNotNullParameter(bundle, "p1");
    }

    public void setEntryState(AppEntryAction appEntryAction) {
        Intrinsics.checkNotNullParameter(appEntryAction, "<set-?>");
        this.entryState = appEntryAction;
    }

    public boolean isInForeground() {
        return getEntryState().isAppOpen() || getEntryState().isNotificationClick();
    }

    public Context getAppContext() {
        Context context = this._appContext;
        Intrinsics.checkNotNull(context);
        return context;
    }

    public void setCurrent(Activity activity) {
        this._current = activity;
        Logging.debug$default("ApplicationService: current activity=" + getCurrent(), (Throwable) null, 2, (Object) null);
        if (activity != null) {
            this.activityLifecycleNotifier.fire(new ApplicationService$current$1(activity));
            try {
                activity.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this);
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
    }

    private final boolean getWasInBackground() {
        return !isInForeground() || this.nextResumeIsFirstActivity;
    }

    public final void start(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this._appContext = context;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
        Application application = (Application) applicationContext;
        application.registerActivityLifecycleCallbacks(this);
        application.registerComponentCallbacks(new ApplicationService$start$configuration$1(this));
        boolean z = context instanceof Activity;
        boolean z2 = getCurrent() == null;
        if (!z2 || z) {
            setEntryState(AppEntryAction.APP_OPEN);
            if (z2 && z) {
                setCurrent((Activity) context);
                this.activityReferences = 1;
                this.nextResumeIsFirstActivity = false;
            }
        } else {
            this.nextResumeIsFirstActivity = true;
            setEntryState(AppEntryAction.APP_CLOSE);
        }
        Logging.debug$default("ApplicationService.init: entryState=" + getEntryState(), (Throwable) null, 2, (Object) null);
    }

    public void addApplicationLifecycleHandler(IApplicationLifecycleHandler iApplicationLifecycleHandler) {
        Intrinsics.checkNotNullParameter(iApplicationLifecycleHandler, "handler");
        this.applicationLifecycleNotifier.subscribe(iApplicationLifecycleHandler);
        if (getCurrent() != null) {
            iApplicationLifecycleHandler.onFocus(true);
        }
    }

    public void removeApplicationLifecycleHandler(IApplicationLifecycleHandler iApplicationLifecycleHandler) {
        Intrinsics.checkNotNullParameter(iApplicationLifecycleHandler, "handler");
        this.applicationLifecycleNotifier.unsubscribe(iApplicationLifecycleHandler);
    }

    public void addActivityLifecycleHandler(IActivityLifecycleHandler iActivityLifecycleHandler) {
        Intrinsics.checkNotNullParameter(iActivityLifecycleHandler, "handler");
        this.activityLifecycleNotifier.subscribe(iActivityLifecycleHandler);
        if (getCurrent() != null) {
            Activity current = getCurrent();
            Intrinsics.checkNotNull(current);
            iActivityLifecycleHandler.onActivityAvailable(current);
        }
    }

    public void removeActivityLifecycleHandler(IActivityLifecycleHandler iActivityLifecycleHandler) {
        Intrinsics.checkNotNullParameter(iActivityLifecycleHandler, "handler");
        this.activityLifecycleNotifier.unsubscribe(iActivityLifecycleHandler);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Logging.debug$default("ApplicationService.onActivityCreated(" + this.activityReferences + AbstractJsonLexerKt.COMMA + getEntryState() + "): " + activity, (Throwable) null, 2, (Object) null);
    }

    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Logging.debug$default("ApplicationService.onActivityStarted(" + this.activityReferences + AbstractJsonLexerKt.COMMA + getEntryState() + "): " + activity, (Throwable) null, 2, (Object) null);
        if (!Intrinsics.areEqual((Object) getCurrent(), (Object) activity)) {
            setCurrent(activity);
            if (!getWasInBackground() || this.isActivityChangingConfigurations) {
                this.activityReferences++;
                return;
            }
            this.activityReferences = 1;
            handleFocus();
        }
    }

    public void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Logging.debug$default("ApplicationService.onActivityResumed(" + this.activityReferences + AbstractJsonLexerKt.COMMA + getEntryState() + "): " + activity, (Throwable) null, 2, (Object) null);
        if (!Intrinsics.areEqual((Object) getCurrent(), (Object) activity)) {
            setCurrent(activity);
        }
        if (getWasInBackground() && !this.isActivityChangingConfigurations) {
            this.activityReferences = 1;
            handleFocus();
        }
    }

    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Logging.debug$default("ApplicationService.onActivityPaused(" + this.activityReferences + AbstractJsonLexerKt.COMMA + getEntryState() + "): " + activity, (Throwable) null, 2, (Object) null);
    }

    public void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Logging.debug$default("ApplicationService.onActivityStopped(" + this.activityReferences + AbstractJsonLexerKt.COMMA + getEntryState() + "): " + activity, (Throwable) null, 2, (Object) null);
        boolean isChangingConfigurations = activity.isChangingConfigurations();
        this.isActivityChangingConfigurations = isChangingConfigurations;
        if (!isChangingConfigurations) {
            int i = this.activityReferences - 1;
            this.activityReferences = i;
            if (i <= 0) {
                setCurrent((Activity) null);
                this.activityReferences = 0;
                handleLostFocus();
            }
        }
        this.activityLifecycleNotifier.fire(new ApplicationService$onActivityStopped$1(activity));
    }

    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Logging.debug$default("ApplicationService.onActivityDestroyed(" + this.activityReferences + AbstractJsonLexerKt.COMMA + getEntryState() + "): " + activity, (Throwable) null, 2, (Object) null);
    }

    public void onGlobalLayout() {
        this.systemConditionNotifier.fire(ApplicationService$onGlobalLayout$1.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009a A[SYNTHETIC, Splitter:B:34:0x009a] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x009e A[Catch:{ NoClassDefFoundError -> 0x00e6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object waitUntilSystemConditionsAvailable(kotlin.coroutines.Continuation<? super java.lang.Boolean> r14) {
        /*
            r13 = this;
            boolean r0 = r14 instanceof com.onesignal.core.internal.application.impl.ApplicationService$waitUntilSystemConditionsAvailable$1
            if (r0 == 0) goto L_0x0014
            r0 = r14
            com.onesignal.core.internal.application.impl.ApplicationService$waitUntilSystemConditionsAvailable$1 r0 = (com.onesignal.core.internal.application.impl.ApplicationService$waitUntilSystemConditionsAvailable$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L_0x0019
        L_0x0014:
            com.onesignal.core.internal.application.impl.ApplicationService$waitUntilSystemConditionsAvailable$1 r0 = new com.onesignal.core.internal.application.impl.ApplicationService$waitUntilSystemConditionsAvailable$1
            r0.<init>(r13, r14)
        L_0x0019:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 50
            r4 = 0
            r5 = 3
            r6 = 2
            r7 = 1
            r8 = 0
            if (r2 == 0) goto L_0x0060
            if (r2 == r7) goto L_0x0055
            if (r2 == r6) goto L_0x0045
            if (r2 != r5) goto L_0x003d
            java.lang.Object r1 = r0.L$1
            com.onesignal.core.internal.application.impl.ApplicationService$waitUntilSystemConditionsAvailable$systemConditionHandler$1 r1 = (com.onesignal.core.internal.application.impl.ApplicationService$waitUntilSystemConditionsAvailable$systemConditionHandler$1) r1
            java.lang.Object r0 = r0.L$0
            com.onesignal.core.internal.application.impl.ApplicationService r0 = (com.onesignal.core.internal.application.impl.ApplicationService) r0
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x012a
        L_0x003d:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x0045:
            java.lang.Object r2 = r0.L$1
            android.app.Activity r2 = (android.app.Activity) r2
            java.lang.Object r3 = r0.L$0
            com.onesignal.core.internal.application.impl.ApplicationService r3 = (com.onesignal.core.internal.application.impl.ApplicationService) r3
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ NoClassDefFoundError -> 0x0052 }
            goto L_0x00f9
        L_0x0052:
            r14 = move-exception
            goto L_0x00e8
        L_0x0055:
            int r2 = r0.I$0
            java.lang.Object r9 = r0.L$0
            com.onesignal.core.internal.application.impl.ApplicationService r9 = (com.onesignal.core.internal.application.impl.ApplicationService) r9
            kotlin.ResultKt.throwOnFailure(r14)
        L_0x005e:
            r14 = r2
            goto L_0x0095
        L_0x0060:
            kotlin.ResultKt.throwOnFailure(r14)
            android.app.Activity r14 = r13.getCurrent()
            com.onesignal.common.AndroidUtils r2 = com.onesignal.common.AndroidUtils.INSTANCE
            boolean r2 = r2.isRunningOnMainThread()
            if (r2 == 0) goto L_0x0071
            r2 = r3
            goto L_0x0072
        L_0x0071:
            r2 = r4
        L_0x0072:
            r9 = r13
            r12 = r2
            r2 = r14
            r14 = r12
        L_0x0076:
            if (r2 != 0) goto L_0x009a
            int r2 = r14 + 1
            if (r2 <= r3) goto L_0x0086
            java.lang.String r14 = "ApplicationService.waitUntilSystemConditionsAvailable: current is null"
            com.onesignal.debug.internal.logging.Logging.warn$default(r14, r8, r6, r8)
            java.lang.Boolean r14 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r14
        L_0x0086:
            r0.L$0 = r9
            r0.I$0 = r2
            r0.label = r7
            r10 = 100
            java.lang.Object r14 = kotlinx.coroutines.DelayKt.delay(r10, r0)
            if (r14 != r1) goto L_0x005e
            return r1
        L_0x0095:
            android.app.Activity r2 = r9.getCurrent()
            goto L_0x0076
        L_0x009a:
            boolean r14 = r2 instanceof androidx.appcompat.app.AppCompatActivity     // Catch:{ NoClassDefFoundError -> 0x00e6 }
            if (r14 == 0) goto L_0x00e3
            r14 = r2
            androidx.appcompat.app.AppCompatActivity r14 = (androidx.appcompat.app.AppCompatActivity) r14     // Catch:{ NoClassDefFoundError -> 0x00e6 }
            androidx.fragment.app.FragmentManager r14 = r14.getSupportFragmentManager()     // Catch:{ NoClassDefFoundError -> 0x00e6 }
            java.lang.String r3 = "currentActivity.supportFragmentManager"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r3)     // Catch:{ NoClassDefFoundError -> 0x00e6 }
            java.util.List r3 = r14.getFragments()     // Catch:{ NoClassDefFoundError -> 0x00e6 }
            java.lang.String r4 = "manager.fragments"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch:{ NoClassDefFoundError -> 0x00e6 }
            java.lang.Object r3 = kotlin.collections.CollectionsKt.lastOrNull(r3)     // Catch:{ NoClassDefFoundError -> 0x00e6 }
            androidx.fragment.app.Fragment r3 = (androidx.fragment.app.Fragment) r3     // Catch:{ NoClassDefFoundError -> 0x00e6 }
            if (r3 == 0) goto L_0x00e3
            boolean r4 = r3.isVisible()     // Catch:{ NoClassDefFoundError -> 0x00e6 }
            if (r4 == 0) goto L_0x00e3
            boolean r3 = r3 instanceof androidx.fragment.app.DialogFragment     // Catch:{ NoClassDefFoundError -> 0x00e6 }
            if (r3 == 0) goto L_0x00e3
            com.onesignal.common.threading.Waiter r3 = new com.onesignal.common.threading.Waiter     // Catch:{ NoClassDefFoundError -> 0x00e6 }
            r3.<init>()     // Catch:{ NoClassDefFoundError -> 0x00e6 }
            com.onesignal.core.internal.application.impl.ApplicationService$waitUntilSystemConditionsAvailable$2 r4 = new com.onesignal.core.internal.application.impl.ApplicationService$waitUntilSystemConditionsAvailable$2     // Catch:{ NoClassDefFoundError -> 0x00e6 }
            r4.<init>(r14, r3)     // Catch:{ NoClassDefFoundError -> 0x00e6 }
            androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks r4 = (androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks) r4     // Catch:{ NoClassDefFoundError -> 0x00e6 }
            r14.registerFragmentLifecycleCallbacks(r4, r7)     // Catch:{ NoClassDefFoundError -> 0x00e6 }
            r0.L$0 = r9     // Catch:{ NoClassDefFoundError -> 0x00e6 }
            r0.L$1 = r2     // Catch:{ NoClassDefFoundError -> 0x00e6 }
            r0.label = r6     // Catch:{ NoClassDefFoundError -> 0x00e6 }
            java.lang.Object r14 = r3.waitForWake(r0)     // Catch:{ NoClassDefFoundError -> 0x00e6 }
            if (r14 != r1) goto L_0x00e1
            return r1
        L_0x00e1:
            r3 = r9
            goto L_0x00f9
        L_0x00e3:
            r14 = r0
            r0 = r9
            goto L_0x00fb
        L_0x00e6:
            r14 = move-exception
            r3 = r9
        L_0x00e8:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r9 = "ApplicationService.waitUntilSystemConditionsAvailable: AppCompatActivity is not used in this app, skipping 'isDialogFragmentShowing' check: "
            r4.<init>(r9)
            r4.append(r14)
            java.lang.String r14 = r4.toString()
            com.onesignal.debug.internal.logging.Logging.info$default(r14, r8, r6, r8)
        L_0x00f9:
            r14 = r0
            r0 = r3
        L_0x00fb:
            com.onesignal.common.threading.Waiter r3 = new com.onesignal.common.threading.Waiter
            r3.<init>()
            com.onesignal.core.internal.application.impl.ApplicationService$waitUntilSystemConditionsAvailable$systemConditionHandler$1 r4 = new com.onesignal.core.internal.application.impl.ApplicationService$waitUntilSystemConditionsAvailable$systemConditionHandler$1
            r4.<init>(r0, r3)
            com.onesignal.common.events.EventProducer<com.onesignal.core.internal.application.impl.ISystemConditionHandler> r9 = r0.systemConditionNotifier
            r9.subscribe(r4)
            com.onesignal.common.DeviceUtils r9 = com.onesignal.common.DeviceUtils.INSTANCE
            java.lang.ref.WeakReference r10 = new java.lang.ref.WeakReference
            r10.<init>(r2)
            boolean r2 = r9.isKeyboardUp(r10)
            if (r2 == 0) goto L_0x012b
            java.lang.String r2 = "ApplicationService.waitUntilSystemConditionsAvailable: keyboard up detected"
            com.onesignal.debug.internal.logging.Logging.warn$default(r2, r8, r6, r8)
            r14.L$0 = r0
            r14.L$1 = r4
            r14.label = r5
            java.lang.Object r14 = r3.waitForWake(r14)
            if (r14 != r1) goto L_0x0129
            return r1
        L_0x0129:
            r1 = r4
        L_0x012a:
            r4 = r1
        L_0x012b:
            com.onesignal.common.events.EventProducer<com.onesignal.core.internal.application.impl.ISystemConditionHandler> r14 = r0.systemConditionNotifier
            r14.unsubscribe(r4)
            java.lang.Boolean r14 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.core.internal.application.impl.ApplicationService.waitUntilSystemConditionsAvailable(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object waitUntilActivityReady(kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.onesignal.core.internal.application.impl.ApplicationService$waitUntilActivityReady$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.onesignal.core.internal.application.impl.ApplicationService$waitUntilActivityReady$1 r0 = (com.onesignal.core.internal.application.impl.ApplicationService$waitUntilActivityReady$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.onesignal.core.internal.application.impl.ApplicationService$waitUntilActivityReady$1 r0 = new com.onesignal.core.internal.application.impl.ApplicationService$waitUntilActivityReady$1
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0057
        L_0x002a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            android.app.Activity r6 = r5.getCurrent()
            if (r6 != 0) goto L_0x0041
            r6 = 0
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            return r6
        L_0x0041:
            com.onesignal.common.threading.Waiter r2 = new com.onesignal.common.threading.Waiter
            r2.<init>()
            com.onesignal.core.internal.application.impl.ApplicationService$$ExternalSyntheticLambda1 r4 = new com.onesignal.core.internal.application.impl.ApplicationService$$ExternalSyntheticLambda1
            r4.<init>(r2)
            r5.decorViewReady(r6, r4)
            r0.label = r3
            java.lang.Object r6 = r2.waitForWake(r0)
            if (r6 != r1) goto L_0x0057
            return r1
        L_0x0057:
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.core.internal.application.impl.ApplicationService.waitUntilActivityReady(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* renamed from: waitUntilActivityReady$lambda-0  reason: not valid java name */
    public static final void m1027waitUntilActivityReady$lambda0(Waiter waiter) {
        Intrinsics.checkNotNullParameter(waiter, "$waiter");
        waiter.wake();
    }

    public final void decorViewReady(Activity activity, Runnable runnable) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        Objects.toString(runnable);
        activity.getWindow().getDecorView().post(new ApplicationService$$ExternalSyntheticLambda0(this, runnable, this));
    }

    /* access modifiers changed from: private */
    /* renamed from: decorViewReady$lambda-1  reason: not valid java name */
    public static final void m1026decorViewReady$lambda1(ApplicationService applicationService, Runnable runnable, ApplicationService applicationService2) {
        Intrinsics.checkNotNullParameter(applicationService, "$self");
        Intrinsics.checkNotNullParameter(runnable, "$runnable");
        Intrinsics.checkNotNullParameter(applicationService2, "this$0");
        applicationService.addActivityLifecycleHandler(new ApplicationService$decorViewReady$1$1(applicationService, runnable, applicationService2));
    }

    /* access modifiers changed from: private */
    public final void onOrientationChanged(int i, Activity activity) {
        if (i == 1) {
            Logging.debug$default("ApplicationService.onOrientationChanged: Configuration Orientation Change: PORTRAIT (" + i + ") on activity: " + activity, (Throwable) null, 2, (Object) null);
        } else if (i == 2) {
            Logging.debug$default("ApplicationService.onOrientationChanged: Configuration Orientation Change: LANDSCAPE (" + i + ") on activity: " + activity, (Throwable) null, 2, (Object) null);
        }
        handleLostFocus();
        this.activityLifecycleNotifier.fire(new ApplicationService$onOrientationChanged$1(activity));
        this.activityLifecycleNotifier.fire(new ApplicationService$onOrientationChanged$2(activity));
        activity.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this);
        handleFocus();
    }

    private final void handleLostFocus() {
        if (isInForeground()) {
            Logging.debug$default("ApplicationService.handleLostFocus: application is now out of focus", (Throwable) null, 2, (Object) null);
            setEntryState(AppEntryAction.APP_CLOSE);
            this.applicationLifecycleNotifier.fire(ApplicationService$handleLostFocus$1.INSTANCE);
            return;
        }
        Logging.debug$default("ApplicationService.handleLostFocus: application already out of focus", (Throwable) null, 2, (Object) null);
    }

    private final void handleFocus() {
        if (getWasInBackground()) {
            Logging.debug$default("ApplicationService.handleFocus: application is now in focus, nextResumeIsFirstActivity=" + this.nextResumeIsFirstActivity, (Throwable) null, 2, (Object) null);
            this.nextResumeIsFirstActivity = false;
            if (getEntryState() != AppEntryAction.NOTIFICATION_CLICK) {
                setEntryState(AppEntryAction.APP_OPEN);
            }
            this.applicationLifecycleNotifier.fire(ApplicationService$handleFocus$1.INSTANCE);
            return;
        }
        Logging.debug$default("ApplicationService.handleFocus: application never lost focus", (Throwable) null, 2, (Object) null);
    }
}
