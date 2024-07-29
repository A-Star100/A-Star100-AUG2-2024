package expo.modules.sms;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Telephony;
import androidx.core.os.BundleKt;
import androidx.core.os.EnvironmentCompat;
import androidx.tracing.Trace;
import androidx.webkit.internal.AssetHelper;
import expo.modules.core.interfaces.ActivityProvider;
import expo.modules.core.interfaces.LifecycleEventListener;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunction;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.objects.ObjectDefinitionBuilder;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J.\u0010\u0016\u001a\u00020\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\rH\u0002R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8BX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lexpo/modules/sms/SMSModule;", "Lexpo/modules/kotlin/modules/Module;", "Lexpo/modules/core/interfaces/LifecycleEventListener;", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "currentActivity", "Landroid/app/Activity;", "getCurrentActivity", "()Landroid/app/Activity;", "pendingPromise", "Lexpo/modules/kotlin/Promise;", "smsComposerOpened", "", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "onHostDestroy", "", "onHostPause", "onHostResume", "sendSMSAsync", "addresses", "", "", "message", "options", "Lexpo/modules/sms/SMSOptions;", "promise", "expo-sms_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SMSModule.kt */
public final class SMSModule extends Module implements LifecycleEventListener {
    private Promise pendingPromise;
    private boolean smsComposerOpened;

    public void onHostDestroy() {
    }

    public void onHostPause() {
    }

    /* access modifiers changed from: private */
    public final Context getContext() {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new Exceptions.ReactContextLost();
    }

    private final Activity getCurrentActivity() {
        ActivityProvider activityProvider = getAppContext().getActivityProvider();
        Activity currentActivity = activityProvider != null ? activityProvider.getCurrentActivity() : null;
        if (currentActivity != null) {
            return currentActivity;
        }
        throw new MissingCurrentActivityException();
    }

    public ModuleDefinitionData definition() {
        AsyncFunction asyncFunction;
        Module module = this;
        Trace.beginSection("[ExpoModulesCore] " + (module.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(module);
            moduleDefinitionBuilder.Name("ExpoSMS");
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_CREATE, new BasicEventListener(EventName.MODULE_CREATE, new SMSModule$definition$lambda$4$$inlined$OnCreate$1(this)));
            Class<List> cls = List.class;
            Class<String> cls2 = String.class;
            Class<SMSOptions> cls3 = SMSOptions.class;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("sendSMSAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(List.class), false, SMSModule$definition$lambda$4$$inlined$AsyncFunctionWithPromise$1.INSTANCE)), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, SMSModule$definition$lambda$4$$inlined$AsyncFunctionWithPromise$2.INSTANCE)), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(SMSOptions.class), false, SMSModule$definition$lambda$4$$inlined$AsyncFunctionWithPromise$3.INSTANCE))}, new SMSModule$definition$lambda$4$$inlined$AsyncFunctionWithPromise$4(this));
            moduleDefinitionBuilder.getAsyncFunctions().put("sendSMSAsync", asyncFunctionWithPromiseComponent);
            AsyncFunction asyncFunction2 = asyncFunctionWithPromiseComponent;
            ObjectDefinitionBuilder objectDefinitionBuilder = moduleDefinitionBuilder;
            AnyType[] anyTypeArr = new AnyType[0];
            Function1 sMSModule$definition$lambda$4$$inlined$AsyncFunction$1 = new SMSModule$definition$lambda$4$$inlined$AsyncFunction$1(this);
            Class<Boolean> cls4 = Boolean.class;
            if (Intrinsics.areEqual((Object) cls4, (Object) Integer.TYPE)) {
                asyncFunction = new IntAsyncFunctionComponent("isAvailableAsync", anyTypeArr, sMSModule$definition$lambda$4$$inlined$AsyncFunction$1);
            } else if (Intrinsics.areEqual((Object) cls4, (Object) Boolean.TYPE)) {
                asyncFunction = new BoolAsyncFunctionComponent("isAvailableAsync", anyTypeArr, sMSModule$definition$lambda$4$$inlined$AsyncFunction$1);
            } else if (Intrinsics.areEqual((Object) cls4, (Object) Double.TYPE)) {
                asyncFunction = new DoubleAsyncFunctionComponent("isAvailableAsync", anyTypeArr, sMSModule$definition$lambda$4$$inlined$AsyncFunction$1);
            } else if (Intrinsics.areEqual((Object) cls4, (Object) Float.TYPE)) {
                asyncFunction = new FloatAsyncFunctionComponent("isAvailableAsync", anyTypeArr, sMSModule$definition$lambda$4$$inlined$AsyncFunction$1);
            } else if (Intrinsics.areEqual((Object) cls4, (Object) String.class)) {
                asyncFunction = new StringAsyncFunctionComponent("isAvailableAsync", anyTypeArr, sMSModule$definition$lambda$4$$inlined$AsyncFunction$1);
            } else {
                asyncFunction = new AsyncFunctionComponent("isAvailableAsync", anyTypeArr, sMSModule$definition$lambda$4$$inlined$AsyncFunction$1);
            }
            objectDefinitionBuilder.getAsyncFunctions().put("isAvailableAsync", asyncFunction);
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_DESTROY, new BasicEventListener(EventName.MODULE_DESTROY, new SMSModule$definition$lambda$4$$inlined$OnDestroy$1(this)));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* access modifiers changed from: private */
    public final void sendSMSAsync(List<String> list, String str, SMSOptions sMSOptions, Promise promise) {
        Intent intent;
        if (!sMSOptions.getAttachments().isEmpty()) {
            intent = new Intent("android.intent.action.SEND");
            intent.setType(AssetHelper.DEFAULT_MIME_TYPE);
            intent.putExtra("address", CollectionsKt.joinToString$default(list, ";", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
            SMSAttachment sMSAttachment = sMSOptions.getAttachments().get(0);
            intent.putExtra("android.intent.extra.STREAM", Uri.parse(sMSAttachment.getUri()));
            intent.setType(sMSAttachment.getMimeType());
            intent.addFlags(1);
        } else {
            intent = new Intent("android.intent.action.SENDTO");
            String joinToString$default = CollectionsKt.joinToString$default(list, ";", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
            intent.setData(Uri.parse("smsto:" + joinToString$default));
        }
        String defaultSmsPackage = Telephony.Sms.getDefaultSmsPackage(getContext());
        if (defaultSmsPackage == null || intent.setPackage(defaultSmsPackage) == null) {
            throw new MissingSMSAppException();
        }
        intent.putExtra("exit_on_sent", true);
        intent.putExtra("compose_mode", true);
        intent.putExtra("sms_body", str);
        this.pendingPromise = promise;
        getCurrentActivity().startActivity(intent);
        this.smsComposerOpened = true;
    }

    public void onHostResume() {
        Promise promise = this.pendingPromise;
        if (this.smsComposerOpened && promise != null) {
            promise.resolve((Object) BundleKt.bundleOf(new Pair("result", EnvironmentCompat.MEDIA_UNKNOWN)));
            this.pendingPromise = null;
        }
        this.smsComposerOpened = false;
    }
}
