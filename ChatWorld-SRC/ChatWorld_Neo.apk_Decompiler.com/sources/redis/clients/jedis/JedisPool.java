package redis.clients.jedis;

import java.net.URI;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocketFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.exceptions.JedisException;
import redis.clients.util.JedisURIHelper;

public class JedisPool extends JedisPoolAbstract {
    private static final String REDISS = "rediss";

    public JedisPool() {
        this(Protocol.DEFAULT_HOST, (int) Protocol.DEFAULT_PORT);
    }

    public JedisPool(GenericObjectPoolConfig poolConfig, String host) {
        this(poolConfig, host, (int) Protocol.DEFAULT_PORT, (int) Protocol.DEFAULT_TIMEOUT, (String) null, 0, (String) null);
    }

    public JedisPool(String host, int port) {
        this(new GenericObjectPoolConfig(), host, port, (int) Protocol.DEFAULT_TIMEOUT, (String) null, 0, (String) null);
    }

    public JedisPool(String host) {
        URI uri = URI.create(host);
        if (JedisURIHelper.isValid(uri)) {
            JedisFactory jedisFactory = r3;
            URI uri2 = uri;
            JedisFactory jedisFactory2 = new JedisFactory(uri.getHost(), uri.getPort(), Protocol.DEFAULT_TIMEOUT, Protocol.DEFAULT_TIMEOUT, JedisURIHelper.getPassword(uri), JedisURIHelper.getDBIndex(uri), (String) null, uri.getScheme().equals(REDISS), (SSLSocketFactory) null, (SSLParameters) null, (HostnameVerifier) null);
            this.internalPool = new GenericObjectPool(jedisFactory, new GenericObjectPoolConfig());
            return;
        }
        this.internalPool = new GenericObjectPool(new JedisFactory(host, Protocol.DEFAULT_PORT, Protocol.DEFAULT_TIMEOUT, Protocol.DEFAULT_TIMEOUT, (String) null, 0, (String) null, false, (SSLSocketFactory) null, (SSLParameters) null, (HostnameVerifier) null), new GenericObjectPoolConfig());
    }

    public JedisPool(String host, SSLSocketFactory sslSocketFactory, SSLParameters sslParameters, HostnameVerifier hostnameVerifier) {
        URI uri = URI.create(host);
        if (JedisURIHelper.isValid(uri)) {
            JedisFactory jedisFactory = r3;
            URI uri2 = uri;
            JedisFactory jedisFactory2 = new JedisFactory(uri.getHost(), uri.getPort(), Protocol.DEFAULT_TIMEOUT, Protocol.DEFAULT_TIMEOUT, JedisURIHelper.getPassword(uri), JedisURIHelper.getDBIndex(uri), (String) null, uri.getScheme().equals(REDISS), sslSocketFactory, sslParameters, hostnameVerifier);
            this.internalPool = new GenericObjectPool(jedisFactory, new GenericObjectPoolConfig());
            return;
        }
        this.internalPool = new GenericObjectPool(new JedisFactory(host, Protocol.DEFAULT_PORT, Protocol.DEFAULT_TIMEOUT, Protocol.DEFAULT_TIMEOUT, (String) null, 0, (String) null, false, (SSLSocketFactory) null, (SSLParameters) null, (HostnameVerifier) null), new GenericObjectPoolConfig());
    }

    public JedisPool(URI uri) {
        this(new GenericObjectPoolConfig(), uri, (int) Protocol.DEFAULT_TIMEOUT);
    }

    public JedisPool(URI uri, SSLSocketFactory sslSocketFactory, SSLParameters sslParameters, HostnameVerifier hostnameVerifier) {
        this(new GenericObjectPoolConfig(), uri, (int) Protocol.DEFAULT_TIMEOUT, sslSocketFactory, sslParameters, hostnameVerifier);
    }

    public JedisPool(URI uri, int timeout) {
        this(new GenericObjectPoolConfig(), uri, timeout);
    }

    public JedisPool(URI uri, int timeout, SSLSocketFactory sslSocketFactory, SSLParameters sslParameters, HostnameVerifier hostnameVerifier) {
        this(new GenericObjectPoolConfig(), uri, timeout, sslSocketFactory, sslParameters, hostnameVerifier);
    }

    public JedisPool(GenericObjectPoolConfig poolConfig, String host, int port, int timeout, String password) {
        this(poolConfig, host, port, timeout, password, 0, (String) null);
    }

    public JedisPool(GenericObjectPoolConfig poolConfig, String host, int port, int timeout, String password, boolean ssl) {
        this(poolConfig, host, port, timeout, password, 0, (String) null, ssl);
    }

    public JedisPool(GenericObjectPoolConfig poolConfig, String host, int port, int timeout, String password, boolean ssl, SSLSocketFactory sslSocketFactory, SSLParameters sslParameters, HostnameVerifier hostnameVerifier) {
        this(poolConfig, host, port, timeout, password, 0, (String) null, ssl, sslSocketFactory, sslParameters, hostnameVerifier);
    }

    public JedisPool(GenericObjectPoolConfig poolConfig, String host, int port) {
        this(poolConfig, host, port, (int) Protocol.DEFAULT_TIMEOUT, (String) null, 0, (String) null);
    }

    public JedisPool(GenericObjectPoolConfig poolConfig, String host, int port, boolean ssl) {
        this(poolConfig, host, port, (int) Protocol.DEFAULT_TIMEOUT, (String) null, 0, (String) null, ssl);
    }

    public JedisPool(GenericObjectPoolConfig poolConfig, String host, int port, boolean ssl, SSLSocketFactory sslSocketFactory, SSLParameters sslParameters, HostnameVerifier hostnameVerifier) {
        this(poolConfig, host, port, Protocol.DEFAULT_TIMEOUT, (String) null, 0, (String) null, ssl, sslSocketFactory, sslParameters, hostnameVerifier);
    }

    public JedisPool(GenericObjectPoolConfig poolConfig, String host, int port, int timeout) {
        this(poolConfig, host, port, timeout, (String) null, 0, (String) null);
    }

    public JedisPool(GenericObjectPoolConfig poolConfig, String host, int port, int timeout, boolean ssl) {
        this(poolConfig, host, port, timeout, (String) null, 0, (String) null, ssl);
    }

    public JedisPool(GenericObjectPoolConfig poolConfig, String host, int port, int timeout, boolean ssl, SSLSocketFactory sslSocketFactory, SSLParameters sslParameters, HostnameVerifier hostnameVerifier) {
        this(poolConfig, host, port, timeout, (String) null, 0, (String) null, ssl, sslSocketFactory, sslParameters, hostnameVerifier);
    }

    public JedisPool(GenericObjectPoolConfig poolConfig, String host, int port, int timeout, String password, int database) {
        this(poolConfig, host, port, timeout, password, database, (String) null);
    }

    public JedisPool(GenericObjectPoolConfig poolConfig, String host, int port, int timeout, String password, int database, boolean ssl) {
        this(poolConfig, host, port, timeout, password, database, (String) null, ssl);
    }

    public JedisPool(GenericObjectPoolConfig poolConfig, String host, int port, int timeout, String password, int database, boolean ssl, SSLSocketFactory sslSocketFactory, SSLParameters sslParameters, HostnameVerifier hostnameVerifier) {
        this(poolConfig, host, port, timeout, password, database, (String) null, ssl, sslSocketFactory, sslParameters, hostnameVerifier);
    }

    public JedisPool(GenericObjectPoolConfig poolConfig, String host, int port, int timeout, String password, int database, String clientName) {
        this(poolConfig, host, port, timeout, timeout, password, database, clientName, false, (SSLSocketFactory) null, (SSLParameters) null, (HostnameVerifier) null);
    }

    public JedisPool(GenericObjectPoolConfig poolConfig, String host, int port, int timeout, String password, int database, String clientName, boolean ssl) {
        this(poolConfig, host, port, timeout, timeout, password, database, clientName, ssl, (SSLSocketFactory) null, (SSLParameters) null, (HostnameVerifier) null);
    }

    public JedisPool(GenericObjectPoolConfig poolConfig, String host, int port, int timeout, String password, int database, String clientName, boolean ssl, SSLSocketFactory sslSocketFactory, SSLParameters sslParameters, HostnameVerifier hostnameVerifier) {
        this(poolConfig, host, port, timeout, timeout, password, database, clientName, ssl, sslSocketFactory, sslParameters, hostnameVerifier);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JedisPool(GenericObjectPoolConfig poolConfig, String host, int port, int connectionTimeout, int soTimeout, String password, int database, String clientName, boolean ssl, SSLSocketFactory sslSocketFactory, SSLParameters sslParameters, HostnameVerifier hostnameVerifier) {
        super(poolConfig, new JedisFactory(host, port, connectionTimeout, soTimeout, password, database, clientName, ssl, sslSocketFactory, sslParameters, hostnameVerifier));
        GenericObjectPoolConfig genericObjectPoolConfig = poolConfig;
    }

    public JedisPool(GenericObjectPoolConfig poolConfig, URI uri) {
        this(poolConfig, uri, (int) Protocol.DEFAULT_TIMEOUT);
    }

    public JedisPool(GenericObjectPoolConfig poolConfig, URI uri, SSLSocketFactory sslSocketFactory, SSLParameters sslParameters, HostnameVerifier hostnameVerifier) {
        this(poolConfig, uri, (int) Protocol.DEFAULT_TIMEOUT, sslSocketFactory, sslParameters, hostnameVerifier);
    }

    public JedisPool(GenericObjectPoolConfig poolConfig, URI uri, int timeout) {
        this(poolConfig, uri, timeout, timeout);
    }

    public JedisPool(GenericObjectPoolConfig poolConfig, URI uri, int timeout, SSLSocketFactory sslSocketFactory, SSLParameters sslParameters, HostnameVerifier hostnameVerifier) {
        this(poolConfig, uri, timeout, timeout, sslSocketFactory, sslParameters, hostnameVerifier);
    }

    public JedisPool(GenericObjectPoolConfig poolConfig, URI uri, int connectionTimeout, int soTimeout) {
        super(poolConfig, new JedisFactory(uri, connectionTimeout, soTimeout, (String) null, false, (SSLSocketFactory) null, (SSLParameters) null, (HostnameVerifier) null));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JedisPool(GenericObjectPoolConfig poolConfig, URI uri, int connectionTimeout, int soTimeout, SSLSocketFactory sslSocketFactory, SSLParameters sslParameters, HostnameVerifier hostnameVerifier) {
        super(poolConfig, new JedisFactory(uri, connectionTimeout, soTimeout, (String) null, uri.getScheme() != null && uri.getScheme().equals(REDISS), sslSocketFactory, sslParameters, hostnameVerifier));
        GenericObjectPoolConfig genericObjectPoolConfig = poolConfig;
    }

    public Jedis getResource() {
        Jedis jedis = (Jedis) super.getResource();
        jedis.setDataSource(this);
        return jedis;
    }

    /* access modifiers changed from: protected */
    public void returnBrokenResource(Jedis resource) {
        if (resource != null) {
            returnBrokenResourceObject(resource);
        }
    }

    /* access modifiers changed from: protected */
    public void returnResource(Jedis resource) {
        if (resource != null) {
            try {
                resource.resetState();
                returnResourceObject(resource);
            } catch (Exception e) {
                returnBrokenResource(resource);
                throw new JedisException("Could not return the resource to the pool", e);
            }
        }
    }
}
