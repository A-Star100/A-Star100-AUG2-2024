package expo.modules.filesystem;

import android.net.Uri;
import androidx.documentfile.provider.DocumentFile;
import com.facebook.common.util.UriUtil;
import expo.modules.interfaces.filesystem.Permission;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0002\u0018\u00012\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "R", "P0", "<name for destructuring parameter 0>", "", "", "invoke", "([Ljava/lang/Object;)Ljava/lang/Object;", "expo/modules/kotlin/objects/ObjectDefinitionBuilder$AsyncFunction$6"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ObjectDefinitionBuilder.kt */
public final class FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$19 extends Lambda implements Function1<Object[], Object> {
    final /* synthetic */ FileSystemModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$19(FileSystemModule fileSystemModule) {
        super(1);
        this.this$0 = fileSystemModule;
    }

    public final Object invoke(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
        RelocatingOptions relocatingOptions = objArr[0];
        Uri parse = Uri.parse(FileSystemModuleKt.slashifyFilePath(relocatingOptions.getFrom()));
        FileSystemModule fileSystemModule = this.this$0;
        Intrinsics.checkNotNull(parse);
        Permission permission = Permission.READ;
        fileSystemModule.ensurePermission(parse, permission, "Location '" + parse + "' isn't readable.");
        Uri parse2 = Uri.parse(FileSystemModuleKt.slashifyFilePath(relocatingOptions.getTo()));
        FileSystemModule fileSystemModule2 = this.this$0;
        Intrinsics.checkNotNull(parse2);
        fileSystemModule2.ensurePermission(parse2, Permission.WRITE);
        if (Intrinsics.areEqual((Object) parse.getScheme(), (Object) "file")) {
            File access$toFile = this.this$0.toFile(parse);
            File access$toFile2 = this.this$0.toFile(parse2);
            if (access$toFile.isDirectory()) {
                FileUtils.copyDirectory(access$toFile, access$toFile2);
            } else {
                FileUtils.copyFile(access$toFile, access$toFile2);
            }
            return Unit.INSTANCE;
        } else if (this.this$0.isSAFUri(parse)) {
            DocumentFile access$getNearestSAFFile = this.this$0.getNearestSAFFile(parse);
            if (access$getNearestSAFFile == null || !access$getNearestSAFFile.exists()) {
                throw new FileSystemCopyFailedException(parse);
            }
            this.this$0.transformFilesFromSAF(access$getNearestSAFFile, this.this$0.toFile(parse2), true);
            return Unit.INSTANCE;
        } else if (Intrinsics.areEqual((Object) parse.getScheme(), (Object) UriUtil.LOCAL_CONTENT_SCHEME)) {
            return Integer.valueOf(IOUtils.copy(this.this$0.getContext().getContentResolver().openInputStream(parse), (OutputStream) new FileOutputStream(this.this$0.toFile(parse2))));
        } else {
            if (Intrinsics.areEqual((Object) parse.getScheme(), (Object) UriUtil.LOCAL_ASSET_SCHEME)) {
                return Integer.valueOf(IOUtils.copy(this.this$0.openAssetInputStream(parse), (OutputStream) new FileOutputStream(this.this$0.toFile(parse2))));
            }
            if (parse.getScheme() == null) {
                return Integer.valueOf(IOUtils.copy(this.this$0.openResourceInputStream(relocatingOptions.getFrom()), (OutputStream) new FileOutputStream(this.this$0.toFile(parse2))));
            }
            throw new IOException("Unsupported scheme for location '" + parse + "'.");
        }
    }
}
