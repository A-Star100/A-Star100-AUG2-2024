package expo.modules.filesystem;

import android.net.Uri;
import android.os.Build;
import androidx.documentfile.provider.DocumentFile;
import expo.modules.interfaces.filesystem.Permission;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.apache.commons.io.FileUtils;

@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0002\u0018\u0001\"\u0006\b\u0002\u0010\u0003\u0018\u00012\u0010\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\u0005H\n¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"<anonymous>", "R", "P0", "P1", "<name for destructuring parameter 0>", "", "", "invoke", "([Ljava/lang/Object;)Ljava/lang/Object;", "expo/modules/kotlin/objects/ObjectDefinitionBuilder$AsyncFunction$8"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ObjectDefinitionBuilder.kt */
public final class FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$13 extends Lambda implements Function1<Object[], Unit> {
    final /* synthetic */ FileSystemModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$13(FileSystemModule fileSystemModule) {
        super(1);
        this.this$0 = fileSystemModule;
    }

    public final Unit invoke(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
        String str = objArr[0];
        DeletingOptions deletingOptions = objArr[1];
        Uri parse = Uri.parse(FileSystemModuleKt.slashifyFilePath(str));
        Uri withAppendedPath = Uri.withAppendedPath(parse, "..");
        FileSystemModule fileSystemModule = this.this$0;
        Intrinsics.checkNotNull(withAppendedPath);
        Permission permission = Permission.WRITE;
        fileSystemModule.ensurePermission(withAppendedPath, permission, "Location '" + parse + "' isn't deletable.");
        if (Intrinsics.areEqual((Object) parse.getScheme(), (Object) "file")) {
            FileSystemModule fileSystemModule2 = this.this$0;
            Intrinsics.checkNotNull(parse);
            File access$toFile = fileSystemModule2.toFile(parse);
            if (access$toFile.exists()) {
                if (Build.VERSION.SDK_INT >= 26) {
                    FileUtils.forceDelete(access$toFile);
                } else {
                    this.this$0.forceDelete(access$toFile);
                }
            } else if (!deletingOptions.getIdempotent()) {
                throw new FileSystemFileNotFoundException(parse);
            }
        } else {
            FileSystemModule fileSystemModule3 = this.this$0;
            Intrinsics.checkNotNull(parse);
            if (fileSystemModule3.isSAFUri(parse)) {
                DocumentFile access$getNearestSAFFile = this.this$0.getNearestSAFFile(parse);
                if (access$getNearestSAFFile != null && access$getNearestSAFFile.exists()) {
                    access$getNearestSAFFile.delete();
                } else if (!deletingOptions.getIdempotent()) {
                    throw new FileSystemFileNotFoundException(parse);
                }
            } else {
                throw new IOException("Unsupported scheme for location '" + parse + "'.");
            }
        }
        return Unit.INSTANCE;
    }
}
