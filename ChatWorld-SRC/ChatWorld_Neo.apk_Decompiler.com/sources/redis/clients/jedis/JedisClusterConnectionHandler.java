package redis.clients.jedis;

import java.io.Closeable;
import java.util.Map;
import java.util.Set;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.exceptions.JedisConnectionException;

public abstract class JedisClusterConnectionHandler implements Closeable {
    protected final JedisClusterInfoCache cache;

    /* access modifiers changed from: package-private */
    public abstract Jedis getConnection();

    /* access modifiers changed from: package-private */
    public abstract Jedis getConnectionFromSlot(int i);

    public JedisClusterConnectionHandler(Set<HostAndPort> nodes, GenericObjectPoolConfig poolConfig, int connectionTimeout, int soTimeout, String password) {
        this(nodes, poolConfig, connectionTimeout, soTimeout, password, (String) null);
    }

    public JedisClusterConnectionHandler(Set<HostAndPort> nodes, GenericObjectPoolConfig poolConfig, int connectionTimeout, int soTimeout, String password, String clientName) {
        this.cache = new JedisClusterInfoCache(poolConfig, connectionTimeout, soTimeout, password, clientName);
        initializeSlotsCache(nodes, poolConfig, password, clientName);
    }

    public Jedis getConnectionFromNode(HostAndPort node) {
        return this.cache.setupNodeIfNotExist(node).getResource();
    }

    public Map<String, JedisPool> getNodes() {
        return this.cache.getNodes();
    }

    private void initializeSlotsCache(Set<HostAndPort> startNodes, GenericObjectPoolConfig poolConfig, String password, String clientName) {
        for (HostAndPort hostAndPort : startNodes) {
            Jedis jedis = new Jedis(hostAndPort.getHost(), hostAndPort.getPort());
            if (password != null) {
                try {
                    jedis.auth(password);
                } catch (JedisConnectionException e) {
                    jedis.close();
                } catch (Throwable th) {
                    jedis.close();
                    throw th;
                }
            }
            if (clientName != null) {
                jedis.clientSetname(clientName);
            }
            this.cache.discoverClusterNodesAndSlots(jedis);
            jedis.close();
            return;
        }
    }

    public void renewSlotCache() {
        this.cache.renewClusterSlots((Jedis) null);
    }

    public void renewSlotCache(Jedis jedis) {
        this.cache.renewClusterSlots(jedis);
    }

    public void close() {
        this.cache.reset();
    }
}
