package expo.modules.documentpicker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.tracing.Trace;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.EventListenerWithSenderAndPayload;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunction;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0012\u0010\u001a\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012H\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lexpo/modules/documentpicker/DocumentPickerModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "copyToCacheDirectory", "", "currentActivity", "Landroid/app/Activity;", "getCurrentActivity", "()Landroid/app/Activity;", "pendingPromise", "Lexpo/modules/kotlin/Promise;", "copyDocumentToCacheDirectory", "", "documentUri", "Landroid/net/Uri;", "name", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "handleMultipleSelection", "", "intent", "Landroid/content/Intent;", "handleSingleSelection", "readDocumentDetails", "Lexpo/modules/documentpicker/DocumentInfo;", "uri", "expo-document-picker_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DocumentPickerModule.kt */
public final class DocumentPickerModule extends Module {
    /* access modifiers changed from: private */
    public boolean copyToCacheDirectory = true;
    /* access modifiers changed from: private */
    public Promise pendingPromise;

    private final Context getContext() {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new Exceptions.ReactContextLost();
    }

    /* access modifiers changed from: private */
    public final Activity getCurrentActivity() {
        Activity currentActivity = getAppContext().getCurrentActivity();
        if (currentActivity != null) {
            return currentActivity;
        }
        throw new Exceptions.MissingActivity();
    }

    public ModuleDefinitionData definition() {
        Module module = this;
        Trace.beginSection("[ExpoModulesCore] " + (module.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(module);
            moduleDefinitionBuilder.Name("ExpoDocumentPicker");
            Class<DocumentPickerOptions> cls = DocumentPickerOptions.class;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("getDocumentAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(DocumentPickerOptions.class), false, DocumentPickerModule$definition$lambda$3$$inlined$AsyncFunctionWithPromise$1.INSTANCE))}, new DocumentPickerModule$definition$lambda$3$$inlined$AsyncFunctionWithPromise$2(this));
            moduleDefinitionBuilder.getAsyncFunctions().put("getDocumentAsync", asyncFunctionWithPromiseComponent);
            AsyncFunction asyncFunction = asyncFunctionWithPromiseComponent;
            moduleDefinitionBuilder.getEventListeners().put(EventName.ON_ACTIVITY_RESULT, new EventListenerWithSenderAndPayload(EventName.ON_ACTIVITY_RESULT, new DocumentPickerModule$definition$lambda$3$$inlined$OnActivityResult$1(this)));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0049, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004d, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0050, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r5, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0054, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String copyDocumentToCacheDirectory(android.net.Uri r5, java.lang.String r6) {
        /*
            r4 = this;
            android.content.Context r0 = r4.getContext()
            java.io.File r0 = r0.getCacheDir()
            java.lang.String r1 = "DocumentPicker"
            java.lang.String r6 = org.apache.commons.io.FilenameUtils.getExtension(r6)
            java.lang.String r6 = expo.modules.core.utilities.FileUtilities.generateOutputPath(r0, r1, r6)
            java.io.File r0 = new java.io.File
            r0.<init>(r6)
            r6 = 0
            android.content.Context r1 = r4.getContext()     // Catch:{ IOException -> 0x0055 }
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ IOException -> 0x0055 }
            java.io.InputStream r5 = r1.openInputStream(r5)     // Catch:{ IOException -> 0x0055 }
            java.io.Closeable r5 = (java.io.Closeable) r5     // Catch:{ IOException -> 0x0055 }
            r1 = r5
            java.io.InputStream r1 = (java.io.InputStream) r1     // Catch:{ all -> 0x004e }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x004e }
            r2.<init>(r0)     // Catch:{ all -> 0x004e }
            java.io.Closeable r2 = (java.io.Closeable) r2     // Catch:{ all -> 0x004e }
            r3 = r2
            java.io.FileOutputStream r3 = (java.io.FileOutputStream) r3     // Catch:{ all -> 0x0047 }
            java.io.OutputStream r3 = (java.io.OutputStream) r3     // Catch:{ all -> 0x0047 }
            org.apache.commons.io.IOUtils.copy((java.io.InputStream) r1, (java.io.OutputStream) r3)     // Catch:{ all -> 0x0047 }
            kotlin.io.CloseableKt.closeFinally(r2, r6)     // Catch:{ all -> 0x004e }
            kotlin.io.CloseableKt.closeFinally(r5, r6)     // Catch:{ IOException -> 0x0055 }
            android.net.Uri r5 = android.net.Uri.fromFile(r0)
            java.lang.String r5 = r5.toString()
            return r5
        L_0x0047:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0049 }
        L_0x0049:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r0)     // Catch:{ all -> 0x004e }
            throw r1     // Catch:{ all -> 0x004e }
        L_0x004e:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0050 }
        L_0x0050:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r5, r0)     // Catch:{ IOException -> 0x0055 }
            throw r1     // Catch:{ IOException -> 0x0055 }
        L_0x0055:
            r5 = move-exception
            r5.printStackTrace()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.documentpicker.DocumentPickerModule.copyDocumentToCacheDirectory(android.net.Uri, java.lang.String):java.lang.String");
    }

    /* access modifiers changed from: private */
    public final void handleSingleSelection(Intent intent) {
        Uri data;
        Unit unit = null;
        if (!(intent == null || (data = intent.getData()) == null)) {
            DocumentPickerResult documentPickerResult = new DocumentPickerResult(false, CollectionsKt.listOf(readDocumentDetails(data)), 1, (DefaultConstructorMarker) null);
            Promise promise = this.pendingPromise;
            if (promise != null) {
                promise.resolve((Object) documentPickerResult);
                unit = Unit.INSTANCE;
            }
        }
        if (unit == null) {
            throw new FailedToReadDocumentException();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r1 = r7.getClipData();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void handleMultipleSelection(android.content.Intent r7) {
        /*
            r6 = this;
            r0 = 0
            if (r7 == 0) goto L_0x000e
            android.content.ClipData r1 = r7.getClipData()
            if (r1 == 0) goto L_0x000e
            int r1 = r1.getItemCount()
            goto L_0x000f
        L_0x000e:
            r1 = r0
        L_0x000f:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.List r2 = (java.util.List) r2
            r3 = r0
        L_0x0017:
            r4 = 0
            if (r3 >= r1) goto L_0x003e
            if (r7 == 0) goto L_0x002c
            android.content.ClipData r5 = r7.getClipData()
            if (r5 == 0) goto L_0x002c
            android.content.ClipData$Item r5 = r5.getItemAt(r3)
            if (r5 == 0) goto L_0x002c
            android.net.Uri r4 = r5.getUri()
        L_0x002c:
            if (r4 == 0) goto L_0x0038
            expo.modules.documentpicker.DocumentInfo r4 = r6.readDocumentDetails(r4)
            r2.add(r4)
            int r3 = r3 + 1
            goto L_0x0017
        L_0x0038:
            expo.modules.documentpicker.FailedToReadDocumentException r7 = new expo.modules.documentpicker.FailedToReadDocumentException
            r7.<init>()
            throw r7
        L_0x003e:
            expo.modules.kotlin.Promise r7 = r6.pendingPromise
            if (r7 == 0) goto L_0x004b
            expo.modules.documentpicker.DocumentPickerResult r1 = new expo.modules.documentpicker.DocumentPickerResult
            r3 = 1
            r1.<init>(r0, r2, r3, r4)
            r7.resolve((java.lang.Object) r1)
        L_0x004b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.documentpicker.DocumentPickerModule.handleMultipleSelection(android.content.Intent):void");
    }

    private final DocumentInfo readDocumentDetails(Uri uri) {
        String copyDocumentToCacheDirectory;
        DocumentDetails read = new DocumentDetailsReader(getContext()).read(uri);
        if (this.copyToCacheDirectory && read != null && ((copyDocumentToCacheDirectory = copyDocumentToCacheDirectory(uri, read.getName())) == null || (read = DocumentDetails.copy$default(read, (String) null, copyDocumentToCacheDirectory, (Integer) null, (String) null, 13, (Object) null)) == null)) {
            throw new FailedToCopyToCacheException();
        } else if (read != null) {
            return new DocumentInfo(read.getUri(), read.getName(), read.getMimeType(), read.getSize());
        } else {
            throw new FailedToReadDocumentException();
        }
    }
}
