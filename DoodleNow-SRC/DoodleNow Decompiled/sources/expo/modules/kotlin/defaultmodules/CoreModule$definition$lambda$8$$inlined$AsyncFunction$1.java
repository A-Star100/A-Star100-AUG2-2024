package expo.modules.kotlin.defaultmodules;

import expo.modules.kotlin.Promise;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0003\u0018\u00012\u0010\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"<anonymous>", "", "R", "P0", "<anonymous parameter 0>", "", "", "promise", "Lexpo/modules/kotlin/Promise;", "invoke", "([Ljava/lang/Object;Lexpo/modules/kotlin/Promise;)V", "expo/modules/kotlin/objects/ObjectDefinitionBuilder$AsyncFunction$5"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ObjectDefinitionBuilder.kt */
public final class CoreModule$definition$lambda$8$$inlined$AsyncFunction$1 extends Lambda implements Function2<Object[], Promise, Unit> {
    final /* synthetic */ CoreModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoreModule$definition$lambda$8$$inlined$AsyncFunction$1(CoreModule coreModule) {
        super(2);
        this.this$0 = coreModule;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: com.facebook.react.ReactDelegate} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(java.lang.Object[] r6, expo.modules.kotlin.Promise r7) {
        /*
            r5 = this;
            java.lang.String r0 = "<anonymous parameter 0>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r6 = "promise"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r6)
            java.lang.String r7 = (java.lang.String) r7
            expo.modules.kotlin.defaultmodules.CoreModule r6 = r5.this$0
            expo.modules.kotlin.AppContext r6 = r6.getAppContext()
            android.app.Activity r6 = r6.getCurrentActivity()
            boolean r7 = r6 instanceof com.facebook.react.ReactActivity
            r0 = 0
            if (r7 == 0) goto L_0x001e
            com.facebook.react.ReactActivity r6 = (com.facebook.react.ReactActivity) r6
            goto L_0x001f
        L_0x001e:
            r6 = r0
        L_0x001f:
            if (r6 != 0) goto L_0x0022
            goto L_0x0070
        L_0x0022:
            java.lang.Class<com.facebook.react.ReactActivity> r7 = com.facebook.react.ReactActivity.class
            java.lang.String r1 = "mDelegate"
            java.lang.reflect.Field r7 = r7.getDeclaredField(r1)
            r1 = 1
            r7.setAccessible(r1)
            java.lang.Object r6 = r7.get(r6)
            java.lang.Class r7 = r6.getClass()
            java.lang.String r2 = "getReactDelegate"
            r3 = 0
            java.lang.Class[] r4 = new java.lang.Class[r3]
            java.lang.reflect.Method r7 = r7.getDeclaredMethod(r2, r4)
            r7.setAccessible(r1)
            java.lang.Object[] r1 = new java.lang.Object[r3]
            java.lang.Object r6 = r7.invoke(r6, r1)
            boolean r7 = r6 instanceof com.facebook.react.ReactDelegate
            if (r7 == 0) goto L_0x004f
            r0 = r6
            com.facebook.react.ReactDelegate r0 = (com.facebook.react.ReactDelegate) r0
        L_0x004f:
            if (r0 != 0) goto L_0x0052
            goto L_0x0070
        L_0x0052:
            boolean r6 = com.facebook.react.config.ReactFeatureFlags.enableBridgelessArchitecture
            if (r6 != 0) goto L_0x006d
            com.facebook.react.ReactInstanceManager r6 = r0.getReactInstanceManager()
            com.facebook.react.devsupport.interfaces.DevSupportManager r7 = r6.getDevSupportManager()
            boolean r7 = r7 instanceof com.facebook.react.devsupport.DisabledDevSupportManager
            if (r7 == 0) goto L_0x006d
            expo.modules.kotlin.defaultmodules.CoreModule$definition$1$4$1 r7 = new expo.modules.kotlin.defaultmodules.CoreModule$definition$1$4$1
            r7.<init>(r6)
            java.lang.Runnable r7 = (java.lang.Runnable) r7
            com.facebook.react.bridge.UiThreadUtil.runOnUiThread(r7)
            goto L_0x0070
        L_0x006d:
            r0.reload()
        L_0x0070:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.kotlin.defaultmodules.CoreModule$definition$lambda$8$$inlined$AsyncFunction$1.invoke(java.lang.Object[], expo.modules.kotlin.Promise):void");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Object[]) obj, (Promise) obj2);
        return Unit.INSTANCE;
    }
}
