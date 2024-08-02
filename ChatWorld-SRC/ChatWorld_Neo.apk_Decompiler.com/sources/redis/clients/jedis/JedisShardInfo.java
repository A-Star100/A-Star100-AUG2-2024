package redis.clients.jedis;

import java.net.URI;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocketFactory;
import redis.clients.jedis.exceptions.InvalidURIException;
import redis.clients.util.JedisURIHelper;
import redis.clients.util.ShardInfo;

public class JedisShardInfo extends ShardInfo<Jedis> {
    private static final String REDISS = "rediss";
    private int connectionTimeout;
    private int db;
    private String host;
    private HostnameVerifier hostnameVerifier;
    private String name;
    private String password;
    private int port;
    private int soTimeout;
    private boolean ssl;
    private SSLParameters sslParameters;
    private SSLSocketFactory sslSocketFactory;

    public JedisShardInfo(String host2) {
        super(1);
        this.password = null;
        this.name = null;
        this.db = 0;
        URI uri = URI.create(host2);
        if (JedisURIHelper.isValid(uri)) {
            this.host = uri.getHost();
            this.port = uri.getPort();
            this.password = JedisURIHelper.getPassword(uri);
            this.db = JedisURIHelper.getDBIndex(uri);
            this.ssl = uri.getScheme().equals(REDISS);
            return;
        }
        this.host = host2;
        this.port = Protocol.DEFAULT_PORT;
    }

    public JedisShardInfo(String host2, SSLSocketFactory sslSocketFactory2, SSLParameters sslParameters2, HostnameVerifier hostnameVerifier2) {
        super(1);
        this.password = null;
        this.name = null;
        this.db = 0;
        URI uri = URI.create(host2);
        if (JedisURIHelper.isValid(uri)) {
            this.host = uri.getHost();
            this.port = uri.getPort();
            this.password = JedisURIHelper.getPassword(uri);
            this.db = JedisURIHelper.getDBIndex(uri);
            this.ssl = uri.getScheme().equals(REDISS);
            this.sslSocketFactory = sslSocketFactory2;
            this.sslParameters = sslParameters2;
            this.hostnameVerifier = hostnameVerifier2;
            return;
        }
        this.host = host2;
        this.port = Protocol.DEFAULT_PORT;
    }

    public JedisShardInfo(String host2, String name2) {
        this(host2, (int) Protocol.DEFAULT_PORT, name2);
    }

    public JedisShardInfo(String host2, int port2) {
        this(host2, port2, (int) Protocol.DEFAULT_TIMEOUT);
    }

    public JedisShardInfo(String host2, int port2, boolean ssl2) {
        this(host2, port2, (int) Protocol.DEFAULT_TIMEOUT, (int) Protocol.DEFAULT_TIMEOUT, 1, ssl2);
    }

    public JedisShardInfo(String host2, int port2, boolean ssl2, SSLSocketFactory sslSocketFactory2, SSLParameters sslParameters2, HostnameVerifier hostnameVerifier2) {
        this(host2, port2, (int) Protocol.DEFAULT_TIMEOUT, (int) Protocol.DEFAULT_TIMEOUT, 1, ssl2, sslSocketFactory2, sslParameters2, hostnameVerifier2);
    }

    public JedisShardInfo(String host2, int port2, String name2) {
        this(host2, port2, (int) Protocol.DEFAULT_TIMEOUT, name2);
    }

    public JedisShardInfo(String host2, int port2, String name2, boolean ssl2) {
        this(host2, port2, (int) Protocol.DEFAULT_TIMEOUT, name2, ssl2);
    }

    public JedisShardInfo(String host2, int port2, String name2, boolean ssl2, SSLSocketFactory sslSocketFactory2, SSLParameters sslParameters2, HostnameVerifier hostnameVerifier2) {
        this(host2, port2, Protocol.DEFAULT_TIMEOUT, name2, ssl2, sslSocketFactory2, sslParameters2, hostnameVerifier2);
    }

    public JedisShardInfo(String host2, int port2, int timeout) {
        this(host2, port2, timeout, timeout, 1);
    }

    public JedisShardInfo(String host2, int port2, int timeout, boolean ssl2) {
        this(host2, port2, timeout, timeout, 1, ssl2);
    }

    public JedisShardInfo(String host2, int port2, int timeout, boolean ssl2, SSLSocketFactory sslSocketFactory2, SSLParameters sslParameters2, HostnameVerifier hostnameVerifier2) {
        this(host2, port2, timeout, timeout, 1, ssl2, sslSocketFactory2, sslParameters2, hostnameVerifier2);
    }

    public JedisShardInfo(String host2, int port2, int timeout, String name2) {
        this(host2, port2, timeout, timeout, 1);
        this.name = name2;
    }

    public JedisShardInfo(String host2, int port2, int timeout, String name2, boolean ssl2) {
        this(host2, port2, timeout, timeout, 1);
        this.name = name2;
        this.ssl = ssl2;
    }

    public JedisShardInfo(String host2, int port2, int timeout, String name2, boolean ssl2, SSLSocketFactory sslSocketFactory2, SSLParameters sslParameters2, HostnameVerifier hostnameVerifier2) {
        this(host2, port2, timeout, timeout, 1);
        this.name = name2;
        this.ssl = ssl2;
        this.sslSocketFactory = sslSocketFactory2;
        this.sslParameters = sslParameters2;
        this.hostnameVerifier = hostnameVerifier2;
    }

    public JedisShardInfo(String host2, int port2, int connectionTimeout2, int soTimeout2, int weight) {
        super(weight);
        this.password = null;
        this.name = null;
        this.db = 0;
        this.host = host2;
        this.port = port2;
        this.connectionTimeout = connectionTimeout2;
        this.soTimeout = soTimeout2;
    }

    public JedisShardInfo(String host2, int port2, int connectionTimeout2, int soTimeout2, int weight, boolean ssl2) {
        super(weight);
        this.password = null;
        this.name = null;
        this.db = 0;
        this.host = host2;
        this.port = port2;
        this.connectionTimeout = connectionTimeout2;
        this.soTimeout = soTimeout2;
        this.ssl = ssl2;
    }

    public JedisShardInfo(String host2, int port2, int connectionTimeout2, int soTimeout2, int weight, boolean ssl2, SSLSocketFactory sslSocketFactory2, SSLParameters sslParameters2, HostnameVerifier hostnameVerifier2) {
        super(weight);
        this.password = null;
        this.name = null;
        this.db = 0;
        this.host = host2;
        this.port = port2;
        this.connectionTimeout = connectionTimeout2;
        this.soTimeout = soTimeout2;
        this.ssl = ssl2;
        this.sslSocketFactory = sslSocketFactory2;
        this.sslParameters = sslParameters2;
        this.hostnameVerifier = hostnameVerifier2;
    }

    public JedisShardInfo(String host2, String name2, int port2, int timeout, int weight) {
        super(weight);
        this.password = null;
        this.name = null;
        this.db = 0;
        this.host = host2;
        this.name = name2;
        this.port = port2;
        this.connectionTimeout = timeout;
        this.soTimeout = timeout;
    }

    public JedisShardInfo(String host2, String name2, int port2, int timeout, int weight, boolean ssl2) {
        super(weight);
        this.password = null;
        this.name = null;
        this.db = 0;
        this.host = host2;
        this.name = name2;
        this.port = port2;
        this.connectionTimeout = timeout;
        this.soTimeout = timeout;
        this.ssl = ssl2;
    }

    public JedisShardInfo(String host2, String name2, int port2, int timeout, int weight, boolean ssl2, SSLSocketFactory sslSocketFactory2, SSLParameters sslParameters2, HostnameVerifier hostnameVerifier2) {
        super(weight);
        this.password = null;
        this.name = null;
        this.db = 0;
        this.host = host2;
        this.name = name2;
        this.port = port2;
        this.connectionTimeout = timeout;
        this.soTimeout = timeout;
        this.ssl = ssl2;
        this.sslSocketFactory = sslSocketFactory2;
        this.sslParameters = sslParameters2;
        this.hostnameVerifier = hostnameVerifier2;
    }

    public JedisShardInfo(URI uri) {
        super(1);
        this.password = null;
        this.name = null;
        this.db = 0;
        if (JedisURIHelper.isValid(uri)) {
            this.host = uri.getHost();
            this.port = uri.getPort();
            this.password = JedisURIHelper.getPassword(uri);
            this.db = JedisURIHelper.getDBIndex(uri);
            this.ssl = uri.getScheme().equals(REDISS);
            return;
        }
        throw new InvalidURIException(String.format("Cannot open Redis connection due invalid URI. %s", new Object[]{uri.toString()}));
    }

    public JedisShardInfo(URI uri, SSLSocketFactory sslSocketFactory2, SSLParameters sslParameters2, HostnameVerifier hostnameVerifier2) {
        super(1);
        this.password = null;
        this.name = null;
        this.db = 0;
        if (JedisURIHelper.isValid(uri)) {
            this.host = uri.getHost();
            this.port = uri.getPort();
            this.password = JedisURIHelper.getPassword(uri);
            this.db = JedisURIHelper.getDBIndex(uri);
            this.ssl = uri.getScheme().equals(REDISS);
            this.sslSocketFactory = sslSocketFactory2;
            this.sslParameters = sslParameters2;
            this.hostnameVerifier = hostnameVerifier2;
            return;
        }
        throw new InvalidURIException(String.format("Cannot open Redis connection due invalid URI. %s", new Object[]{uri.toString()}));
    }

    public String toString() {
        return String.valueOf(this.host) + ":" + this.port + "*" + getWeight();
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        return this.port;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String auth) {
        this.password = auth;
    }

    public int getConnectionTimeout() {
        return this.connectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout2) {
        this.connectionTimeout = connectionTimeout2;
    }

    public int getSoTimeout() {
        return this.soTimeout;
    }

    public void setSoTimeout(int soTimeout2) {
        this.soTimeout = soTimeout2;
    }

    public String getName() {
        return this.name;
    }

    public int getDb() {
        return this.db;
    }

    public boolean getSsl() {
        return this.ssl;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    public SSLParameters getSslParameters() {
        return this.sslParameters;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public Jedis createResource() {
        return new Jedis(this);
    }
}
