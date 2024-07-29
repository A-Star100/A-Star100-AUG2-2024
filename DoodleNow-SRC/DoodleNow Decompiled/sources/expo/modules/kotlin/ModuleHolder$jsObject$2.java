package expo.modules.kotlin;

import expo.modules.kotlin.jni.JavaScriptModuleObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lexpo/modules/kotlin/jni/JavaScriptModuleObject;", "T", "Lexpo/modules/kotlin/modules/Module;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ModuleHolder.kt */
final class ModuleHolder$jsObject$2 extends Lambda implements Function0<JavaScriptModuleObject> {
    final /* synthetic */ ModuleHolder<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ModuleHolder$jsObject$2(ModuleHolder<T> moduleHolder) {
        super(0);
        this.this$0 = moduleHolder;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00df, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00e3, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final expo.modules.kotlin.jni.JavaScriptModuleObject invoke() {
        /*
            r15 = this;
            expo.modules.kotlin.ModuleHolder<T> r0 = r15.this$0
            java.lang.String r0 = r0.getName()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = ".jsObject"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            expo.modules.kotlin.ModuleHolder<T> r1 = r15.this$0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "[ExpoModulesCore] "
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            androidx.tracing.Trace.beginSection(r0)
            expo.modules.kotlin.modules.Module r0 = r1.getModule()     // Catch:{ all -> 0x0197 }
            expo.modules.kotlin.AppContext r0 = r0.getAppContext()     // Catch:{ all -> 0x0197 }
            expo.modules.kotlin.jni.JNIDeallocator r2 = r0.getJniDeallocator()     // Catch:{ all -> 0x0197 }
            expo.modules.kotlin.jni.JavaScriptModuleObject r11 = new expo.modules.kotlin.jni.JavaScriptModuleObject     // Catch:{ all -> 0x0197 }
            java.lang.String r3 = r1.getName()     // Catch:{ all -> 0x0197 }
            r11.<init>(r2, r3)     // Catch:{ all -> 0x0197 }
            expo.modules.kotlin.modules.ModuleDefinitionData r3 = r1.getDefinition()     // Catch:{ all -> 0x0197 }
            expo.modules.kotlin.objects.ObjectDefinitionData r3 = r3.getObjectDefinition()     // Catch:{ all -> 0x0197 }
            r11.initUsingObjectDefinition(r0, r3)     // Catch:{ all -> 0x0197 }
            java.lang.String r4 = "__expo_module_name__"
            r5 = 0
            r12 = 0
            expo.modules.kotlin.jni.ExpectedType[] r6 = new expo.modules.kotlin.jni.ExpectedType[r12]     // Catch:{ all -> 0x0197 }
            expo.modules.kotlin.ModuleHolder$jsObject$2$1$1$1 r3 = new expo.modules.kotlin.ModuleHolder$jsObject$2$1$1$1     // Catch:{ all -> 0x0197 }
            r3.<init>(r11)     // Catch:{ all -> 0x0197 }
            r7 = r3
            expo.modules.kotlin.jni.JNIFunctionBody r7 = (expo.modules.kotlin.jni.JNIFunctionBody) r7     // Catch:{ all -> 0x0197 }
            r8 = 0
            expo.modules.kotlin.jni.ExpectedType[] r9 = new expo.modules.kotlin.jni.ExpectedType[r12]     // Catch:{ all -> 0x0197 }
            r10 = 0
            r3 = r11
            r3.registerProperty(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0197 }
            expo.modules.kotlin.modules.ModuleDefinitionData r3 = r1.getDefinition()     // Catch:{ all -> 0x0197 }
            expo.modules.kotlin.views.ViewManagerDefinition r3 = r3.getViewManagerDefinition()     // Catch:{ all -> 0x0197 }
            r10 = 0
            if (r3 == 0) goto L_0x0070
            java.util.List r3 = r3.getAsyncFunctions()     // Catch:{ all -> 0x0197 }
            goto L_0x0071
        L_0x0070:
            r3 = r10
        L_0x0071:
            if (r3 == 0) goto L_0x00e4
            r4 = r3
            java.util.Collection r4 = (java.util.Collection) r4     // Catch:{ all -> 0x0197 }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x0197 }
            r5 = 1
            r4 = r4 ^ r5
            if (r4 != r5) goto L_0x00e4
            java.lang.String r4 = "[ExpoModulesCore] Attaching view prototype"
            androidx.tracing.Trace.beginSection(r4)     // Catch:{ all -> 0x0197 }
            expo.modules.kotlin.jni.JavaScriptModuleObject r4 = new expo.modules.kotlin.jni.JavaScriptModuleObject     // Catch:{ all -> 0x00df }
            java.lang.String r5 = r11.getName()     // Catch:{ all -> 0x00df }
            expo.modules.kotlin.modules.ModuleDefinitionData r6 = r1.getDefinition()     // Catch:{ all -> 0x00df }
            expo.modules.kotlin.views.ViewManagerDefinition r6 = r6.getViewManagerDefinition()     // Catch:{ all -> 0x00df }
            if (r6 == 0) goto L_0x009e
            java.lang.Class r6 = r6.getViewType$expo_modules_core_release()     // Catch:{ all -> 0x00df }
            if (r6 == 0) goto L_0x009e
            java.lang.String r6 = r6.getName()     // Catch:{ all -> 0x00df }
            goto L_0x009f
        L_0x009e:
            r6 = r10
        L_0x009f:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00df }
            r7.<init>()     // Catch:{ all -> 0x00df }
            r7.append(r5)     // Catch:{ all -> 0x00df }
            java.lang.String r5 = "_"
            r7.append(r5)     // Catch:{ all -> 0x00df }
            r7.append(r6)     // Catch:{ all -> 0x00df }
            java.lang.String r5 = r7.toString()     // Catch:{ all -> 0x00df }
            r4.<init>(r2, r5)     // Catch:{ all -> 0x00df }
            expo.modules.kotlin.jni.JNIDeallocator r5 = r0.getJniDeallocator()     // Catch:{ all -> 0x00df }
            r6 = r4
            expo.modules.kotlin.jni.Destructible r6 = (expo.modules.kotlin.jni.Destructible) r6     // Catch:{ all -> 0x00df }
            r5.addReference(r6)     // Catch:{ all -> 0x00df }
            java.lang.Iterable r3 = (java.lang.Iterable) r3     // Catch:{ all -> 0x00df }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x00df }
        L_0x00c6:
            boolean r5 = r3.hasNext()     // Catch:{ all -> 0x00df }
            if (r5 == 0) goto L_0x00d6
            java.lang.Object r5 = r3.next()     // Catch:{ all -> 0x00df }
            expo.modules.kotlin.functions.BaseAsyncFunctionComponent r5 = (expo.modules.kotlin.functions.BaseAsyncFunctionComponent) r5     // Catch:{ all -> 0x00df }
            r5.attachToJSObject(r0, r4)     // Catch:{ all -> 0x00df }
            goto L_0x00c6
        L_0x00d6:
            r11.registerViewPrototype(r4)     // Catch:{ all -> 0x00df }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00df }
            androidx.tracing.Trace.endSection()     // Catch:{ all -> 0x0197 }
            goto L_0x00e4
        L_0x00df:
            r0 = move-exception
            androidx.tracing.Trace.endSection()     // Catch:{ all -> 0x0197 }
            throw r0     // Catch:{ all -> 0x0197 }
        L_0x00e4:
            java.lang.String r3 = "Attaching classes"
            java.lang.String r4 = "ExpoModulesCore"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0197 }
            r5.<init>()     // Catch:{ all -> 0x0197 }
            java.lang.String r6 = "["
            r5.append(r6)     // Catch:{ all -> 0x0197 }
            r5.append(r4)     // Catch:{ all -> 0x0197 }
            java.lang.String r4 = "] "
            r5.append(r4)     // Catch:{ all -> 0x0197 }
            r5.append(r3)     // Catch:{ all -> 0x0197 }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x0197 }
            androidx.tracing.Trace.beginSection(r3)     // Catch:{ all -> 0x0197 }
            expo.modules.kotlin.modules.ModuleDefinitionData r3 = r1.getDefinition()     // Catch:{ all -> 0x0192 }
            java.util.List r3 = r3.getClassData()     // Catch:{ all -> 0x0192 }
            java.lang.Iterable r3 = (java.lang.Iterable) r3     // Catch:{ all -> 0x0192 }
            java.util.Iterator r13 = r3.iterator()     // Catch:{ all -> 0x0192 }
        L_0x0112:
            boolean r3 = r13.hasNext()     // Catch:{ all -> 0x0192 }
            if (r3 == 0) goto L_0x0189
            java.lang.Object r3 = r13.next()     // Catch:{ all -> 0x0192 }
            expo.modules.kotlin.classcomponent.ClassDefinitionData r3 = (expo.modules.kotlin.classcomponent.ClassDefinitionData) r3     // Catch:{ all -> 0x0192 }
            expo.modules.kotlin.jni.JavaScriptModuleObject r4 = new expo.modules.kotlin.jni.JavaScriptModuleObject     // Catch:{ all -> 0x0192 }
            java.lang.String r5 = r3.getName()     // Catch:{ all -> 0x0192 }
            r4.<init>(r2, r5)     // Catch:{ all -> 0x0192 }
            expo.modules.kotlin.modules.Module r5 = r1.getModule()     // Catch:{ all -> 0x0192 }
            expo.modules.kotlin.AppContext r5 = r5.getAppContext()     // Catch:{ all -> 0x0192 }
            expo.modules.kotlin.objects.ObjectDefinitionData r6 = r3.getObjectDefinition()     // Catch:{ all -> 0x0192 }
            expo.modules.kotlin.jni.JavaScriptModuleObject r5 = r4.initUsingObjectDefinition(r5, r6)     // Catch:{ all -> 0x0192 }
            expo.modules.kotlin.jni.JNIDeallocator r4 = r0.getJniDeallocator()     // Catch:{ all -> 0x0192 }
            r6 = r5
            expo.modules.kotlin.jni.Destructible r6 = (expo.modules.kotlin.jni.Destructible) r6     // Catch:{ all -> 0x0192 }
            r4.addReference(r6)     // Catch:{ all -> 0x0192 }
            expo.modules.kotlin.functions.SyncFunctionComponent r4 = r3.getConstructor()     // Catch:{ all -> 0x0192 }
            kotlin.reflect.KType r6 = r4.getOwnerType()     // Catch:{ all -> 0x0192 }
            if (r6 == 0) goto L_0x0150
            kotlin.reflect.KClassifier r6 = r6.getClassifier()     // Catch:{ all -> 0x0192 }
            goto L_0x0151
        L_0x0150:
            r6 = r10
        L_0x0151:
            boolean r7 = r6 instanceof kotlin.reflect.KClass     // Catch:{ all -> 0x0192 }
            if (r7 == 0) goto L_0x0158
            kotlin.reflect.KClass r6 = (kotlin.reflect.KClass) r6     // Catch:{ all -> 0x0192 }
            goto L_0x0159
        L_0x0158:
            r6 = r10
        L_0x0159:
            if (r6 == 0) goto L_0x0161
            java.lang.Class r6 = kotlin.jvm.JvmClassMappingKt.getJavaClass(r6)     // Catch:{ all -> 0x0192 }
            r7 = r6
            goto L_0x0162
        L_0x0161:
            r7 = r10
        L_0x0162:
            java.lang.String r6 = r3.getName()     // Catch:{ all -> 0x0192 }
            boolean r8 = r4.getTakesOwner$expo_modules_core_release()     // Catch:{ all -> 0x0192 }
            java.util.List r9 = r4.getCppRequiredTypes()     // Catch:{ all -> 0x0192 }
            java.util.Collection r9 = (java.util.Collection) r9     // Catch:{ all -> 0x0192 }
            expo.modules.kotlin.jni.ExpectedType[] r14 = new expo.modules.kotlin.jni.ExpectedType[r12]     // Catch:{ all -> 0x0192 }
            java.lang.Object[] r9 = r9.toArray(r14)     // Catch:{ all -> 0x0192 }
            expo.modules.kotlin.jni.ExpectedType[] r9 = (expo.modules.kotlin.jni.ExpectedType[]) r9     // Catch:{ all -> 0x0192 }
            java.lang.String r3 = r3.getName()     // Catch:{ all -> 0x0192 }
            expo.modules.kotlin.jni.JNIFunctionBody r14 = r4.getJNIFunctionBody$expo_modules_core_release(r3, r0)     // Catch:{ all -> 0x0192 }
            r3 = r11
            r4 = r6
            r6 = r8
            r8 = r9
            r9 = r14
            r3.registerClass(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0192 }
            goto L_0x0112
        L_0x0189:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0192 }
            androidx.tracing.Trace.endSection()     // Catch:{ all -> 0x0197 }
            androidx.tracing.Trace.endSection()
            return r11
        L_0x0192:
            r0 = move-exception
            androidx.tracing.Trace.endSection()     // Catch:{ all -> 0x0197 }
            throw r0     // Catch:{ all -> 0x0197 }
        L_0x0197:
            r0 = move-exception
            androidx.tracing.Trace.endSection()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.kotlin.ModuleHolder$jsObject$2.invoke():expo.modules.kotlin.jni.JavaScriptModuleObject");
    }
}
