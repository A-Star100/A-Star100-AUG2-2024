package expo.modules.filesystem;

import android.net.Uri;
import expo.modules.interfaces.filesystem.Permission;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0002\u0018\u00012\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "R", "P0", "<name for destructuring parameter 0>", "", "", "invoke", "([Ljava/lang/Object;)Ljava/lang/Object;", "expo/modules/kotlin/objects/ObjectDefinitionBuilder$AsyncFunction$6"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ObjectDefinitionBuilder.kt */
public final class FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$30 extends Lambda implements Function1<Object[], String> {
    final /* synthetic */ FileSystemModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$30(FileSystemModule fileSystemModule) {
        super(1);
        this.this$0 = fileSystemModule;
    }

    public final String invoke(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
        String str = objArr[0];
        Uri parse = Uri.parse(FileSystemModuleKt.slashifyFilePath(str));
        FileSystemModule fileSystemModule = this.this$0;
        Intrinsics.checkNotNull(parse);
        fileSystemModule.ensurePermission(parse, Permission.WRITE);
        this.this$0.ensurePermission(parse, Permission.READ);
        this.this$0.checkIfFileDirExists(parse);
        if (Intrinsics.areEqual((Object) parse.getScheme(), (Object) "file")) {
            return this.this$0.contentUriFromFile(this.this$0.toFile(parse)).toString();
        }
        throw new FileSystemUnreadableDirectoryException(str);
    }
}
