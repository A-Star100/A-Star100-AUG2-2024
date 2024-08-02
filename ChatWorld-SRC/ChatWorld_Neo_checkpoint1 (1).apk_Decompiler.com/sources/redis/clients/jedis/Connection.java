package redis.clients.jedis;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import redis.clients.jedis.commands.ProtocolCommand;
import redis.clients.jedis.exceptions.JedisConnectionException;
import redis.clients.jedis.exceptions.JedisDataException;
import redis.clients.util.IOUtils;
import redis.clients.util.RedisInputStream;
import redis.clients.util.RedisOutputStream;
import redis.clients.util.SafeEncoder;

public class Connection implements Closeable {
    private static final byte[][] EMPTY_ARGS = new byte[0][];
    private boolean broken = false;
    private int connectionTimeout = Protocol.DEFAULT_TIMEOUT;
    private String host = Protocol.DEFAULT_HOST;
    private HostnameVerifier hostnameVerifier;
    private RedisInputStream inputStream;
    private RedisOutputStream outputStream;
    private int port = Protocol.DEFAULT_PORT;
    private int soTimeout = Protocol.DEFAULT_TIMEOUT;
    private Socket socket;
    private boolean ssl;
    private SSLParameters sslParameters;
    private SSLSocketFactory sslSocketFactory;

    public Connection() {
    }

    public Connection(String host2) {
        this.host = host2;
    }

    public Connection(String host2, int port2) {
        this.host = host2;
        this.port = port2;
    }

    public Connection(String host2, int port2, boolean ssl2) {
        this.host = host2;
        this.port = port2;
        this.ssl = ssl2;
    }

    public Connection(String host2, int port2, boolean ssl2, SSLSocketFactory sslSocketFactory2, SSLParameters sslParameters2, HostnameVerifier hostnameVerifier2) {
        this.host = host2;
        this.port = port2;
        this.ssl = ssl2;
        this.sslSocketFactory = sslSocketFactory2;
        this.sslParameters = sslParameters2;
        this.hostnameVerifier = hostnameVerifier2;
    }

    public Socket getSocket() {
        return this.socket;
    }

    public int getConnectionTimeout() {
        return this.connectionTimeout;
    }

    public int getSoTimeout() {
        return this.soTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout2) {
        this.connectionTimeout = connectionTimeout2;
    }

    public void setSoTimeout(int soTimeout2) {
        this.soTimeout = soTimeout2;
    }

    public void setTimeoutInfinite() {
        try {
            if (!isConnected()) {
                connect();
            }
            this.socket.setSoTimeout(0);
        } catch (SocketException ex) {
            this.broken = true;
            throw new JedisConnectionException((Throwable) ex);
        }
    }

    public void rollbackTimeout() {
        try {
            this.socket.setSoTimeout(this.soTimeout);
        } catch (SocketException ex) {
            this.broken = true;
            throw new JedisConnectionException((Throwable) ex);
        }
    }

    public Connection sendCommand(ProtocolCommand cmd, String... args) {
        byte[][] bargs = new byte[args.length][];
        for (int i = 0; i < args.length; i++) {
            bargs[i] = SafeEncoder.encode(args[i]);
        }
        return sendCommand(cmd, bargs);
    }

    public Connection sendCommand(ProtocolCommand cmd) {
        return sendCommand(cmd, EMPTY_ARGS);
    }

    public Connection sendCommand(ProtocolCommand cmd, byte[]... args) {
        try {
            connect();
            Protocol.sendCommand(this.outputStream, cmd, args);
            return this;
        } catch (JedisConnectionException e) {
            ex = e;
            try {
                String errorMessage = Protocol.readErrorLineIfPossible(this.inputStream);
                if (errorMessage != null && errorMessage.length() > 0) {
                    ex = new JedisConnectionException(errorMessage, ex.getCause());
                }
            } catch (Exception e2) {
            }
            this.broken = true;
            throw ex;
        }
    }

    public String getHost() {
        return this.host;
    }

    public void setHost(String host2) {
        this.host = host2;
    }

    public int getPort() {
        return this.port;
    }

    public void setPort(int port2) {
        this.port = port2;
    }

    public void connect() {
        if (!isConnected()) {
            try {
                Socket socket2 = new Socket();
                this.socket = socket2;
                socket2.setReuseAddress(true);
                this.socket.setKeepAlive(true);
                this.socket.setTcpNoDelay(true);
                this.socket.setSoLinger(true, 0);
                this.socket.connect(new InetSocketAddress(this.host, this.port), this.connectionTimeout);
                this.socket.setSoTimeout(this.soTimeout);
                if (this.ssl) {
                    if (this.sslSocketFactory == null) {
                        this.sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
                    }
                    SSLSocket sSLSocket = (SSLSocket) this.sslSocketFactory.createSocket(this.socket, this.host, this.port, true);
                    this.socket = sSLSocket;
                    SSLParameters sSLParameters = this.sslParameters;
                    if (sSLParameters != null) {
                        SSLSocket sSLSocket2 = sSLSocket;
                        sSLSocket.setSSLParameters(sSLParameters);
                    }
                    HostnameVerifier hostnameVerifier2 = this.hostnameVerifier;
                    if (hostnameVerifier2 != null) {
                        if (!hostnameVerifier2.verify(this.host, ((SSLSocket) this.socket).getSession())) {
                            throw new JedisConnectionException(String.format("The connection to '%s' failed ssl/tls hostname verification.", new Object[]{this.host}));
                        }
                    }
                }
                this.outputStream = new RedisOutputStream(this.socket.getOutputStream());
                this.inputStream = new RedisInputStream(this.socket.getInputStream());
            } catch (IOException ex) {
                this.broken = true;
                throw new JedisConnectionException((Throwable) ex);
            }
        }
    }

    public void close() {
        disconnect();
    }

    public void disconnect() {
        if (isConnected()) {
            try {
                this.outputStream.flush();
                this.socket.close();
                IOUtils.closeQuietly(this.socket);
            } catch (IOException ex) {
                this.broken = true;
                throw new JedisConnectionException((Throwable) ex);
            } catch (Throwable th) {
                IOUtils.closeQuietly(this.socket);
                throw th;
            }
        }
    }

    public boolean isConnected() {
        Socket socket2 = this.socket;
        return socket2 != null && socket2.isBound() && !this.socket.isClosed() && this.socket.isConnected() && !this.socket.isInputShutdown() && !this.socket.isOutputShutdown();
    }

    public String getStatusCodeReply() {
        flush();
        byte[] resp = (byte[]) readProtocolWithCheckingBroken();
        if (resp == null) {
            return null;
        }
        return SafeEncoder.encode(resp);
    }

    public String getBulkReply() {
        byte[] result = getBinaryBulkReply();
        if (result != null) {
            return SafeEncoder.encode(result);
        }
        return null;
    }

    public byte[] getBinaryBulkReply() {
        flush();
        return (byte[]) readProtocolWithCheckingBroken();
    }

    public Long getIntegerReply() {
        flush();
        return (Long) readProtocolWithCheckingBroken();
    }

    public List<String> getMultiBulkReply() {
        return BuilderFactory.STRING_LIST.build(getBinaryMultiBulkReply());
    }

    public List<byte[]> getBinaryMultiBulkReply() {
        flush();
        return (List) readProtocolWithCheckingBroken();
    }

    public List<Object> getRawObjectMultiBulkReply() {
        return (List) readProtocolWithCheckingBroken();
    }

    public List<Object> getObjectMultiBulkReply() {
        flush();
        return getRawObjectMultiBulkReply();
    }

    public List<Long> getIntegerMultiBulkReply() {
        flush();
        return (List) readProtocolWithCheckingBroken();
    }

    public Object getOne() {
        flush();
        return readProtocolWithCheckingBroken();
    }

    public boolean isBroken() {
        return this.broken;
    }

    /* access modifiers changed from: protected */
    public void flush() {
        try {
            this.outputStream.flush();
        } catch (IOException ex) {
            this.broken = true;
            throw new JedisConnectionException((Throwable) ex);
        }
    }

    /* access modifiers changed from: protected */
    public Object readProtocolWithCheckingBroken() {
        try {
            return Protocol.read(this.inputStream);
        } catch (JedisConnectionException exc) {
            this.broken = true;
            throw exc;
        }
    }

    public List<Object> getMany(int count) {
        flush();
        List<Object> responses = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            try {
                responses.add(readProtocolWithCheckingBroken());
            } catch (JedisDataException e) {
                responses.add(e);
            }
        }
        return responses;
    }
}
