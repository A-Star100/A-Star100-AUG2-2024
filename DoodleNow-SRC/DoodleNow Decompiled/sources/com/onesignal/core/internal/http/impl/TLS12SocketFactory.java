package com.onesignal.core.internal.http.impl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\fH\u0016J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\fH\u0016J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH\u0002J\u0013\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u0018H\u0016¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u0018H\u0016¢\u0006\u0002\u0010\u0019R\u001a\u0010\u0002\u001a\u00020\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0003¨\u0006\u001b"}, d2 = {"Lcom/onesignal/core/internal/http/impl/TLS12SocketFactory;", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "(Ljavax/net/ssl/SSLSocketFactory;)V", "getSslSocketFactory", "()Ljavax/net/ssl/SSLSocketFactory;", "setSslSocketFactory", "createSocket", "Ljava/net/Socket;", "host", "Ljava/net/InetAddress;", "port", "", "address", "localAddress", "localPort", "s", "", "autoClose", "", "localHost", "enableTLS", "socket", "getDefaultCipherSuites", "", "()[Ljava/lang/String;", "getSupportedCipherSuites", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TLS12SocketFactory.kt */
public final class TLS12SocketFactory extends SSLSocketFactory {
    private SSLSocketFactory sslSocketFactory;

    public final SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    public final void setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        Intrinsics.checkNotNullParameter(sSLSocketFactory, "<set-?>");
        this.sslSocketFactory = sSLSocketFactory;
    }

    public TLS12SocketFactory(SSLSocketFactory sSLSocketFactory) {
        Intrinsics.checkNotNullParameter(sSLSocketFactory, "sslSocketFactory");
        this.sslSocketFactory = sSLSocketFactory;
    }

    public String[] getDefaultCipherSuites() {
        String[] defaultCipherSuites = this.sslSocketFactory.getDefaultCipherSuites();
        Intrinsics.checkNotNullExpressionValue(defaultCipherSuites, "sslSocketFactory.defaultCipherSuites");
        return defaultCipherSuites;
    }

    public String[] getSupportedCipherSuites() {
        String[] supportedCipherSuites = this.sslSocketFactory.getSupportedCipherSuites();
        Intrinsics.checkNotNullExpressionValue(supportedCipherSuites, "sslSocketFactory.supportedCipherSuites");
        return supportedCipherSuites;
    }

    public Socket createSocket() throws IOException {
        Socket createSocket = this.sslSocketFactory.createSocket();
        Intrinsics.checkNotNullExpressionValue(createSocket, "sslSocketFactory.createSocket()");
        return enableTLS(createSocket);
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(socket, "s");
        Intrinsics.checkNotNullParameter(str, "host");
        Socket createSocket = this.sslSocketFactory.createSocket(socket, str, i, z);
        Intrinsics.checkNotNullExpressionValue(createSocket, "sslSocketFactory.createS…s, host, port, autoClose)");
        return enableTLS(createSocket);
    }

    public Socket createSocket(String str, int i) throws IOException {
        Intrinsics.checkNotNullParameter(str, "host");
        Socket createSocket = this.sslSocketFactory.createSocket(str, i);
        Intrinsics.checkNotNullExpressionValue(createSocket, "sslSocketFactory.createSocket(host, port)");
        return enableTLS(createSocket);
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        Intrinsics.checkNotNullParameter(str, "host");
        Intrinsics.checkNotNullParameter(inetAddress, "localHost");
        Socket createSocket = this.sslSocketFactory.createSocket(str, i, inetAddress, i2);
        Intrinsics.checkNotNullExpressionValue(createSocket, "sslSocketFactory.createS…rt, localHost, localPort)");
        return enableTLS(createSocket);
    }

    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        Intrinsics.checkNotNullParameter(inetAddress, "host");
        Socket createSocket = this.sslSocketFactory.createSocket(inetAddress, i);
        Intrinsics.checkNotNullExpressionValue(createSocket, "sslSocketFactory.createSocket(host, port)");
        return enableTLS(createSocket);
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        Intrinsics.checkNotNullParameter(inetAddress, "address");
        Intrinsics.checkNotNullParameter(inetAddress2, "localAddress");
        Socket createSocket = this.sslSocketFactory.createSocket(inetAddress, i, inetAddress2, i2);
        Intrinsics.checkNotNullExpressionValue(createSocket, "sslSocketFactory.createS… localAddress, localPort)");
        return enableTLS(createSocket);
    }

    private final Socket enableTLS(Socket socket) {
        if (socket instanceof SSLSocket) {
            ((SSLSocket) socket).setEnabledProtocols(new String[]{"TLSv1.2"});
        }
        return socket;
    }
}
