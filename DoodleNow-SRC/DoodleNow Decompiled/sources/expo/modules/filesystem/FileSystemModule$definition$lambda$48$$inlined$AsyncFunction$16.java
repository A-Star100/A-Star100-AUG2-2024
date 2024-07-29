package expo.modules.filesystem;

import android.net.Uri;
import androidx.documentfile.provider.DocumentFile;
import expo.modules.interfaces.filesystem.Permission;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0002\u0018\u00012\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "R", "P0", "<name for destructuring parameter 0>", "", "", "invoke", "([Ljava/lang/Object;)Ljava/lang/Object;", "expo/modules/kotlin/objects/ObjectDefinitionBuilder$AsyncFunction$6"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ObjectDefinitionBuilder.kt */
public final class FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$16 extends Lambda implements Function1<Object[], Unit> {
    final /* synthetic */ FileSystemModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$16(FileSystemModule fileSystemModule) {
        super(1);
        this.this$0 = fileSystemModule;
    }

    public final Unit invoke(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
        RelocatingOptions relocatingOptions = objArr[0];
        Uri parse = Uri.parse(FileSystemModuleKt.slashifyFilePath(relocatingOptions.getFrom()));
        FileSystemModule fileSystemModule = this.this$0;
        Uri withAppendedPath = Uri.withAppendedPath(parse, "..");
        Intrinsics.checkNotNullExpressionValue(withAppendedPath, "withAppendedPath(...)");
        Permission permission = Permission.WRITE;
        fileSystemModule.ensurePermission(withAppendedPath, permission, "Location '" + parse + "' isn't movable.");
        Uri parse2 = Uri.parse(FileSystemModuleKt.slashifyFilePath(relocatingOptions.getTo()));
        FileSystemModule fileSystemModule2 = this.this$0;
        Intrinsics.checkNotNull(parse2);
        fileSystemModule2.ensurePermission(parse2, Permission.WRITE);
        if (Intrinsics.areEqual((Object) parse.getScheme(), (Object) "file")) {
            FileSystemModule fileSystemModule3 = this.this$0;
            Intrinsics.checkNotNull(parse);
            if (!fileSystemModule3.toFile(parse).renameTo(this.this$0.toFile(parse2))) {
                throw new FileSystemCannotMoveFileException(parse, parse2);
            }
        } else {
            FileSystemModule fileSystemModule4 = this.this$0;
            Intrinsics.checkNotNull(parse);
            if (fileSystemModule4.isSAFUri(parse)) {
                DocumentFile access$getNearestSAFFile = this.this$0.getNearestSAFFile(parse);
                if (access$getNearestSAFFile == null || !access$getNearestSAFFile.exists()) {
                    throw new FileSystemCannotMoveFileException(parse, parse2);
                }
                this.this$0.transformFilesFromSAF(access$getNearestSAFFile, this.this$0.toFile(parse2), false);
            } else {
                throw new IOException("Unsupported scheme for location '" + parse + "'.");
            }
        }
        return Unit.INSTANCE;
    }
}
