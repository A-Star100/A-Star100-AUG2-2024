package expo.modules.kotlin.defaultmodules;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0002\u0018\u00012\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "R", "P0", "<name for destructuring parameter 0>", "", "", "invoke", "([Ljava/lang/Object;)Ljava/lang/Object;", "expo/modules/kotlin/objects/ObjectDefinitionBuilder$AsyncFunction$6"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ObjectDefinitionBuilder.kt */
public final class CoreModule$definition$lambda$8$$inlined$AsyncFunction$3 extends Lambda implements Function1<Object[], Unit> {
    final /* synthetic */ CoreModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoreModule$definition$lambda$8$$inlined$AsyncFunction$3(CoreModule coreModule) {
        super(1);
        this.this$0 = coreModule;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: com.facebook.react.ReactDelegate} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.Unit invoke(java.lang.Object[] r7) {
        /*
            r6 = this;
            java.lang.String r0 = "<name for destructuring parameter 0>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = 0
            r7 = r7[r0]
            java.lang.String r7 = (java.lang.String) r7
            expo.modules.kotlin.defaultmodules.CoreModule r7 = r6.this$0
            expo.modules.kotlin.AppContext r7 = r7.getAppContext()
            android.app.Activity r7 = r7.getCurrentActivity()
            boolean r1 = r7 instanceof com.facebook.react.ReactActivity
            r2 = 0
            if (r1 == 0) goto L_0x001c
            com.facebook.react.ReactActivity r7 = (com.facebook.react.ReactActivity) r7
            goto L_0x001d
        L_0x001c:
            r7 = r2
        L_0x001d:
            if (r7 != 0) goto L_0x0020
            goto L_0x006d
        L_0x0020:
            java.lang.Class<com.facebook.react.ReactActivity> r1 = com.facebook.react.ReactActivity.class
            java.lang.String r3 = "mDelegate"
            java.lang.reflect.Field r1 = r1.getDeclaredField(r3)
            r3 = 1
            r1.setAccessible(r3)
            java.lang.Object r7 = r1.get(r7)
            java.lang.Class r1 = r7.getClass()
            java.lang.String r4 = "getReactDelegate"
            java.lang.Class[] r5 = new java.lang.Class[r0]
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r4, r5)
            r1.setAccessible(r3)
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.Object r7 = r1.invoke(r7, r0)
            boolean r0 = r7 instanceof com.facebook.react.ReactDelegate
            if (r0 == 0) goto L_0x004c
            r2 = r7
            com.facebook.react.ReactDelegate r2 = (com.facebook.react.ReactDelegate) r2
        L_0x004c:
            if (r2 != 0) goto L_0x004f
            goto L_0x006d
        L_0x004f:
            boolean r7 = com.facebook.react.config.ReactFeatureFlags.enableBridgelessArchitecture
            if (r7 != 0) goto L_0x006a
            com.facebook.react.ReactInstanceManager r7 = r2.getReactInstanceManager()
            com.facebook.react.devsupport.interfaces.DevSupportManager r0 = r7.getDevSupportManager()
            boolean r0 = r0 instanceof com.facebook.react.devsupport.DisabledDevSupportManager
            if (r0 == 0) goto L_0x006a
            expo.modules.kotlin.defaultmodules.CoreModule$definition$1$4$1 r0 = new expo.modules.kotlin.defaultmodules.CoreModule$definition$1$4$1
            r0.<init>(r7)
            java.lang.Runnable r0 = (java.lang.Runnable) r0
            com.facebook.react.bridge.UiThreadUtil.runOnUiThread(r0)
            goto L_0x006d
        L_0x006a:
            r2.reload()
        L_0x006d:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.kotlin.defaultmodules.CoreModule$definition$lambda$8$$inlined$AsyncFunction$3.invoke(java.lang.Object[]):java.lang.Object");
    }
}
