package redis.clients.jedis;

import java.util.Set;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.exceptions.JedisException;
import redis.clients.jedis.exceptions.JedisNoReachableClusterNodeException;

public class JedisSlotBasedConnectionHandler extends JedisClusterConnectionHandler {
    public JedisSlotBasedConnectionHandler(Set<HostAndPort> nodes, GenericObjectPoolConfig poolConfig, int timeout) {
        this(nodes, poolConfig, timeout, timeout);
    }

    public JedisSlotBasedConnectionHandler(Set<HostAndPort> nodes, GenericObjectPoolConfig poolConfig, int connectionTimeout, int soTimeout) {
        super(nodes, poolConfig, connectionTimeout, soTimeout, (String) null);
    }

    public JedisSlotBasedConnectionHandler(Set<HostAndPort> nodes, GenericObjectPoolConfig poolConfig, int connectionTimeout, int soTimeout, String password) {
        super(nodes, poolConfig, connectionTimeout, soTimeout, password);
    }

    public JedisSlotBasedConnectionHandler(Set<HostAndPort> nodes, GenericObjectPoolConfig poolConfig, int connectionTimeout, int soTimeout, String password, String clientName) {
        super(nodes, poolConfig, connectionTimeout, soTimeout, password, clientName);
    }

    public Jedis getConnection() {
        for (JedisPool pool : this.cache.getShuffledNodesPool()) {
            Jedis jedis = null;
            try {
                Jedis jedis2 = pool.getResource();
                if (jedis2 != null) {
                    if (jedis2.ping().equalsIgnoreCase("pong")) {
                        return jedis2;
                    }
                    jedis2.close();
                }
            } catch (JedisException e) {
                if (jedis != null) {
                    jedis.close();
                }
            }
        }
        throw new JedisNoReachableClusterNodeException("No reachable node in cluster");
    }

    public Jedis getConnectionFromSlot(int slot) {
        JedisPool connectionPool = this.cache.getSlotPool(slot);
        if (connectionPool != null) {
            return connectionPool.getResource();
        }
        renewSlotCache();
        JedisPool connectionPool2 = this.cache.getSlotPool(slot);
        if (connectionPool2 != null) {
            return connectionPool2.getResource();
        }
        return getConnection();
    }
}
