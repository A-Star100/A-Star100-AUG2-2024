package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import kotlin.Metadata;
import kotlin.io.path.PathTreeWalk$$ExternalSyntheticApiModelOutline0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\n\u001a\u00020\u000b*\u00020\f\u001a\u0012\u0010\r\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010\u001a\u0012\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0010\u001a\u0016\u0010\u0014\u001a\u00020\u000b*\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\u0006H\u0007\u001a\n\u0010\u0014\u001a\u00020\u000b*\u00020\u0016\u001a\n\u0010\u0014\u001a\u00020\u000b*\u00020\u0017\u001a%\u0010\u0014\u001a\u00020\u000b*\u00020\u00182\u0012\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001b0\u001a\"\u00020\u001bH\u0007¢\u0006\u0002\u0010\u001c\u001a\n\u0010\u001d\u001a\u00020\u0013*\u00020\f\u001a\n\u0010\u001d\u001a\u00020\u0013*\u00020\u001e\u001a\n\u0010\u001d\u001a\u00020\u0013*\u00020\u0017\u001a%\u0010\u001d\u001a\u00020\u0013*\u00020\u00182\u0012\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001b0\u001a\"\u00020\u001bH\u0007¢\u0006\u0002\u0010\u001f\"\u001c\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u001c\u0010\u0005\u001a\u00020\u0006*\u00060\u0007j\u0002`\b8@X\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\t¨\u0006 "}, d2 = {"logger", "Ljava/util/logging/Logger;", "kotlin.jvm.PlatformType", "getLogger$Okio__JvmOkioKt", "()Ljava/util/logging/Logger;", "isAndroidGetsocknameError", "", "Ljava/lang/AssertionError;", "Lkotlin/AssertionError;", "(Ljava/lang/AssertionError;)Z", "appendingSink", "Lokio/Sink;", "Ljava/io/File;", "cipherSink", "Lokio/CipherSink;", "cipher", "Ljavax/crypto/Cipher;", "cipherSource", "Lokio/CipherSource;", "Lokio/Source;", "sink", "append", "Ljava/io/OutputStream;", "Ljava/net/Socket;", "Ljava/nio/file/Path;", "options", "", "Ljava/nio/file/OpenOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Sink;", "source", "Ljava/io/InputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Source;", "okio"}, k = 5, mv = {1, 4, 0}, xs = "okio/Okio")
/* compiled from: JvmOkio.kt */
final /* synthetic */ class Okio__JvmOkioKt {
    /* access modifiers changed from: private */
    public static final Logger logger = Logger.getLogger("okio.Okio");

    private static final Logger getLogger$Okio__JvmOkioKt() {
        return logger;
    }

    public static final Sink sink(File file) throws FileNotFoundException {
        return sink$default(file, false, 1, (Object) null);
    }

    public static final Sink sink(OutputStream outputStream) {
        Intrinsics.checkNotNullParameter(outputStream, "$this$sink");
        return new OutputStreamSink(outputStream, new Timeout());
    }

    public static final Source source(InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "$this$source");
        return new InputStreamSource(inputStream, new Timeout());
    }

    public static final Sink sink(Socket socket) throws IOException {
        Intrinsics.checkNotNullParameter(socket, "$this$sink");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        OutputStream outputStream = socket.getOutputStream();
        Intrinsics.checkNotNullExpressionValue(outputStream, "getOutputStream()");
        return socketAsyncTimeout.sink(new OutputStreamSink(outputStream, socketAsyncTimeout));
    }

    public static final Source source(Socket socket) throws IOException {
        Intrinsics.checkNotNullParameter(socket, "$this$source");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        InputStream inputStream = socket.getInputStream();
        Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream()");
        return socketAsyncTimeout.source(new InputStreamSource(inputStream, socketAsyncTimeout));
    }

    public static final Sink sink(File file, boolean z) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(file, "$this$sink");
        return Okio.sink((OutputStream) new FileOutputStream(file, z));
    }

    public static /* synthetic */ Sink sink$default(File file, boolean z, int i, Object obj) throws FileNotFoundException {
        if ((i & 1) != 0) {
            z = false;
        }
        return Okio.sink(file, z);
    }

    public static final Sink appendingSink(File file) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(file, "$this$appendingSink");
        return Okio.sink((OutputStream) new FileOutputStream(file, true));
    }

    public static final Source source(File file) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(file, "$this$source");
        return Okio.source((InputStream) new FileInputStream(file));
    }

    public static final Sink sink(Path path, OpenOption... openOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "$this$sink");
        Intrinsics.checkNotNullParameter(openOptionArr, "options");
        OutputStream m = PathTreeWalk$$ExternalSyntheticApiModelOutline0.m(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(m, "Files.newOutputStream(this, *options)");
        return Okio.sink(m);
    }

    public static final Source source(Path path, OpenOption... openOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "$this$source");
        Intrinsics.checkNotNullParameter(openOptionArr, "options");
        InputStream m = PathTreeWalk$$ExternalSyntheticApiModelOutline0.m(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(m, "Files.newInputStream(this, *options)");
        return Okio.source(m);
    }

    public static final CipherSink cipherSink(Sink sink, Cipher cipher) {
        Intrinsics.checkNotNullParameter(sink, "$this$cipherSink");
        Intrinsics.checkNotNullParameter(cipher, "cipher");
        return new CipherSink(Okio.buffer(sink), cipher);
    }

    public static final CipherSource cipherSource(Source source, Cipher cipher) {
        Intrinsics.checkNotNullParameter(source, "$this$cipherSource");
        Intrinsics.checkNotNullParameter(cipher, "cipher");
        return new CipherSource(Okio.buffer(source), cipher);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
        r4 = r4.getMessage();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isAndroidGetsocknameError(java.lang.AssertionError r4) {
        /*
            java.lang.String r0 = "$this$isAndroidGetsocknameError"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.Throwable r0 = r4.getCause()
            r1 = 0
            if (r0 == 0) goto L_0x0021
            java.lang.String r4 = r4.getMessage()
            if (r4 == 0) goto L_0x0021
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.String r0 = "getsockname failed"
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r2 = 2
            r3 = 0
            boolean r4 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r4, (java.lang.CharSequence) r0, (boolean) r1, (int) r2, (java.lang.Object) r3)
            if (r4 == 0) goto L_0x0021
            r1 = 1
        L_0x0021:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Okio__JvmOkioKt.isAndroidGetsocknameError(java.lang.AssertionError):boolean");
    }
}
