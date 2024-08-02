package redis.clients.jedis;

import java.net.URI;
import java.util.concurrent.atomic.AtomicReference;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocketFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import redis.clients.jedis.exceptions.InvalidURIException;
import redis.clients.jedis.exceptions.JedisException;
import redis.clients.util.JedisURIHelper;

class JedisFactory implements PooledObjectFactory<Jedis> {
    private final String clientName;
    private final int connectionTimeout;
    private final int database;
    private final AtomicReference<HostAndPort> hostAndPort;
    private HostnameVerifier hostnameVerifier;
    private final String password;
    private final int soTimeout;
    private final boolean ssl;
    private SSLParameters sslParameters;
    private final SSLSocketFactory sslSocketFactory;

    public JedisFactory(String host, int port, int connectionTimeout2, int soTimeout2, String password2, int database2, String clientName2, boolean ssl2, SSLSocketFactory sslSocketFactory2, SSLParameters sslParameters2, HostnameVerifier hostnameVerifier2) {
        AtomicReference<HostAndPort> atomicReference = new AtomicReference<>();
        this.hostAndPort = atomicReference;
        atomicReference.set(new HostAndPort(host, port));
        this.connectionTimeout = connectionTimeout2;
        this.soTimeout = soTimeout2;
        this.password = password2;
        this.database = database2;
        this.clientName = clientName2;
        this.ssl = ssl2;
        this.sslSocketFactory = sslSocketFactory2;
        this.sslParameters = sslParameters2;
        this.hostnameVerifier = hostnameVerifier2;
    }

    public JedisFactory(URI uri, int connectionTimeout2, int soTimeout2, String clientName2, boolean ssl2, SSLSocketFactory sslSocketFactory2, SSLParameters sslParameters2, HostnameVerifier hostnameVerifier2) {
        AtomicReference<HostAndPort> atomicReference = new AtomicReference<>();
        this.hostAndPort = atomicReference;
        if (JedisURIHelper.isValid(uri)) {
            atomicReference.set(new HostAndPort(uri.getHost(), uri.getPort()));
            this.connectionTimeout = connectionTimeout2;
            this.soTimeout = soTimeout2;
            this.password = JedisURIHelper.getPassword(uri);
            this.database = JedisURIHelper.getDBIndex(uri);
            this.clientName = clientName2;
            this.ssl = ssl2;
            this.sslSocketFactory = sslSocketFactory2;
            this.sslParameters = sslParameters2;
            this.hostnameVerifier = hostnameVerifier2;
            return;
        }
        throw new InvalidURIException(String.format("Cannot open Redis connection due invalid URI. %s", new Object[]{uri.toString()}));
    }

    public void setHostAndPort(HostAndPort hostAndPort2) {
        this.hostAndPort.set(hostAndPort2);
    }

    public void activateObject(PooledObject<Jedis> pooledJedis) throws Exception {
        BinaryJedis jedis = pooledJedis.getObject();
        int db = jedis.getDB();
        int i = this.database;
        if (db != i) {
            jedis.select(i);
        }
    }

    public void destroyObject(PooledObject<Jedis> pooledJedis) throws Exception {
        BinaryJedis jedis = pooledJedis.getObject();
        if (jedis.isConnected()) {
            try {
                jedis.quit();
            } catch (Exception e) {
            }
            try {
                jedis.disconnect();
            } catch (Exception e2) {
            }
        }
    }

    public PooledObject<Jedis> makeObject() throws Exception {
        HostAndPort hostAndPort2 = this.hostAndPort.get();
        Jedis jedis = new Jedis(hostAndPort2.getHost(), hostAndPort2.getPort(), this.connectionTimeout, this.soTimeout, this.ssl, this.sslSocketFactory, this.sslParameters, this.hostnameVerifier);
        try {
            jedis.connect();
            String str = this.password;
            if (str != null) {
                jedis.auth(str);
            }
            int i = this.database;
            if (i != 0) {
                jedis.select(i);
            }
            String str2 = this.clientName;
            if (str2 != null) {
                jedis.clientSetname(str2);
            }
            return new DefaultPooledObject(jedis);
        } catch (JedisException je) {
            jedis.close();
            throw je;
        }
    }

    public void passivateObject(PooledObject<Jedis> pooledObject) throws Exception {
    }

    public boolean validateObject(PooledObject<Jedis> pooledJedis) {
        BinaryJedis jedis = pooledJedis.getObject();
        try {
            HostAndPort hostAndPort2 = this.hostAndPort.get();
            String connectionHost = jedis.getClient().getHost();
            int connectionPort = jedis.getClient().getPort();
            if (!hostAndPort2.getHost().equals(connectionHost) || hostAndPort2.getPort() != connectionPort || !jedis.isConnected() || !jedis.ping().equals("PONG")) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
