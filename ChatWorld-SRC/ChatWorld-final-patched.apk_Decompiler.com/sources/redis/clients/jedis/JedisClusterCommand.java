package redis.clients.jedis;

import redis.clients.jedis.exceptions.JedisAskDataException;
import redis.clients.jedis.exceptions.JedisClusterException;
import redis.clients.jedis.exceptions.JedisClusterMaxRedirectionsException;
import redis.clients.jedis.exceptions.JedisConnectionException;
import redis.clients.jedis.exceptions.JedisMovedDataException;
import redis.clients.jedis.exceptions.JedisNoReachableClusterNodeException;
import redis.clients.jedis.exceptions.JedisRedirectionException;
import redis.clients.util.JedisClusterCRC16;
import redis.clients.util.SafeEncoder;

public abstract class JedisClusterCommand<T> {
    private static final String NO_DISPATCH_MESSAGE = "No way to dispatch this command to Redis Cluster.";
    private ThreadLocal<Jedis> askConnection = new ThreadLocal<>();
    private JedisClusterConnectionHandler connectionHandler;
    private int maxAttempts;

    public abstract T execute(Jedis jedis);

    public JedisClusterCommand(JedisClusterConnectionHandler connectionHandler2, int maxAttempts2) {
        this.connectionHandler = connectionHandler2;
        this.maxAttempts = maxAttempts2;
    }

    public T run(String key) {
        if (key != null) {
            return runWithRetries(SafeEncoder.encode(key), this.maxAttempts, false, false);
        }
        throw new JedisClusterException(NO_DISPATCH_MESSAGE);
    }

    public T run(int keyCount, String... keys) {
        if (keys == null || keys.length == 0) {
            throw new JedisClusterException(NO_DISPATCH_MESSAGE);
        }
        if (keys.length > 1) {
            int slot = JedisClusterCRC16.getSlot(keys[0]);
            int i = 1;
            while (i < keyCount) {
                if (slot == JedisClusterCRC16.getSlot(keys[i])) {
                    i++;
                } else {
                    throw new JedisClusterException("No way to dispatch this command to Redis Cluster because keys have different slots.");
                }
            }
        }
        return runWithRetries(SafeEncoder.encode(keys[0]), this.maxAttempts, false, false);
    }

    public T runBinary(byte[] key) {
        if (key != null) {
            return runWithRetries(key, this.maxAttempts, false, false);
        }
        throw new JedisClusterException(NO_DISPATCH_MESSAGE);
    }

    public T runBinary(int keyCount, byte[]... keys) {
        if (keys == null || keys.length == 0) {
            throw new JedisClusterException(NO_DISPATCH_MESSAGE);
        }
        if (keys.length > 1) {
            int slot = JedisClusterCRC16.getSlot(keys[0]);
            int i = 1;
            while (i < keyCount) {
                if (slot == JedisClusterCRC16.getSlot(keys[i])) {
                    i++;
                } else {
                    throw new JedisClusterException("No way to dispatch this command to Redis Cluster because keys have different slots.");
                }
            }
        }
        return runWithRetries(keys[0], this.maxAttempts, false, false);
    }

    public T runWithAnyNode() {
        try {
            Jedis connection = this.connectionHandler.getConnection();
            T execute = execute(connection);
            releaseConnection(connection);
            return execute;
        } catch (JedisConnectionException e) {
            throw e;
        } catch (Throwable th) {
            releaseConnection((Jedis) null);
            throw th;
        }
    }

    private T runWithRetries(byte[] key, int attempts, boolean tryRandomNode, boolean asking) {
        Jedis connection;
        if (attempts > 0) {
            Jedis connection2 = null;
            if (asking) {
                try {
                    connection = this.askConnection.get();
                    connection.asking();
                } catch (JedisNoReachableClusterNodeException jnrcne) {
                    throw jnrcne;
                } catch (JedisConnectionException jce) {
                    releaseConnection((Jedis) null);
                    connection2 = null;
                    if (attempts > 1) {
                        T runWithRetries = runWithRetries(key, attempts - 1, tryRandomNode, asking);
                        releaseConnection((Jedis) null);
                        return runWithRetries;
                    }
                    this.connectionHandler.renewSlotCache();
                    throw jce;
                } catch (JedisRedirectionException jre) {
                    if (jre instanceof JedisMovedDataException) {
                        this.connectionHandler.renewSlotCache((Jedis) null);
                    }
                    releaseConnection((Jedis) null);
                    connection2 = null;
                    if (jre instanceof JedisAskDataException) {
                        asking = true;
                        this.askConnection.set(this.connectionHandler.getConnectionFromNode(jre.getTargetNode()));
                    } else if (!(jre instanceof JedisMovedDataException)) {
                        throw new JedisClusterException((Throwable) jre);
                    }
                    T runWithRetries2 = runWithRetries(key, attempts - 1, false, asking);
                    releaseConnection((Jedis) null);
                    return runWithRetries2;
                } catch (Throwable th) {
                    releaseConnection(connection2);
                    throw th;
                }
            } else if (tryRandomNode) {
                connection = this.connectionHandler.getConnection();
            } else {
                connection = this.connectionHandler.getConnectionFromSlot(JedisClusterCRC16.getSlot(key));
            }
            T execute = execute(connection);
            releaseConnection(connection);
            return execute;
        }
        throw new JedisClusterMaxRedirectionsException("Too many Cluster redirections?");
    }

    private void releaseConnection(Jedis connection) {
        if (connection != null) {
            connection.close();
        }
    }
}
