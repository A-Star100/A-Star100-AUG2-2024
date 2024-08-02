package redis.clients.jedis;

import java.io.Closeable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.BinaryClient;
import redis.clients.jedis.commands.BinaryJedisClusterCommands;
import redis.clients.jedis.commands.JedisClusterBinaryScriptingCommands;
import redis.clients.jedis.commands.MultiKeyBinaryJedisClusterCommands;
import redis.clients.jedis.params.geo.GeoRadiusParam;
import redis.clients.jedis.params.set.SetParams;
import redis.clients.jedis.params.sortedset.ZAddParams;
import redis.clients.jedis.params.sortedset.ZIncrByParams;
import redis.clients.util.JedisClusterHashTagUtil;
import redis.clients.util.KeyMergeUtil;
import redis.clients.util.SafeEncoder;

public class BinaryJedisCluster implements BinaryJedisClusterCommands, MultiKeyBinaryJedisClusterCommands, JedisClusterBinaryScriptingCommands, Closeable {
    protected static final int DEFAULT_MAX_REDIRECTIONS = 5;
    protected static final int DEFAULT_TIMEOUT = 2000;
    public static final short HASHSLOTS = 16384;
    protected JedisClusterConnectionHandler connectionHandler;
    protected int maxAttempts;

    public BinaryJedisCluster(Set<HostAndPort> nodes, int timeout) {
        this(nodes, timeout, 5, new GenericObjectPoolConfig());
    }

    public BinaryJedisCluster(Set<HostAndPort> nodes) {
        this(nodes, 2000);
    }

    public BinaryJedisCluster(Set<HostAndPort> jedisClusterNode, int timeout, int maxAttempts2, GenericObjectPoolConfig poolConfig) {
        this.connectionHandler = new JedisSlotBasedConnectionHandler(jedisClusterNode, poolConfig, timeout);
        this.maxAttempts = maxAttempts2;
    }

    public BinaryJedisCluster(Set<HostAndPort> jedisClusterNode, int connectionTimeout, int soTimeout, int maxAttempts2, GenericObjectPoolConfig poolConfig) {
        this.connectionHandler = new JedisSlotBasedConnectionHandler(jedisClusterNode, poolConfig, connectionTimeout, soTimeout);
        this.maxAttempts = maxAttempts2;
    }

    public BinaryJedisCluster(Set<HostAndPort> jedisClusterNode, int connectionTimeout, int soTimeout, int maxAttempts2, String password, GenericObjectPoolConfig poolConfig) {
        this.connectionHandler = new JedisSlotBasedConnectionHandler(jedisClusterNode, poolConfig, connectionTimeout, soTimeout, password);
        this.maxAttempts = maxAttempts2;
    }

    public BinaryJedisCluster(Set<HostAndPort> jedisClusterNode, int connectionTimeout, int soTimeout, int maxAttempts2, String password, String clientName, GenericObjectPoolConfig poolConfig) {
        this.connectionHandler = new JedisSlotBasedConnectionHandler(jedisClusterNode, poolConfig, connectionTimeout, soTimeout, password, clientName);
        this.maxAttempts = maxAttempts2;
    }

    public void close() {
        JedisClusterConnectionHandler jedisClusterConnectionHandler = this.connectionHandler;
        if (jedisClusterConnectionHandler != null) {
            jedisClusterConnectionHandler.close();
        }
    }

    public Map<String, JedisPool> getClusterNodes() {
        return this.connectionHandler.getNodes();
    }

    public String set(byte[] key, byte[] value) {
        final byte[] bArr = key;
        final byte[] bArr2 = value;
        return (String) new JedisClusterCommand<String>(this.connectionHandler, this.maxAttempts) {
            public String execute(Jedis connection) {
                return connection.set(bArr, bArr2);
            }
        }.runBinary(key);
    }

    public String set(byte[] key, byte[] value, SetParams params) {
        final byte[] bArr = key;
        final byte[] bArr2 = value;
        final SetParams setParams = params;
        return (String) new JedisClusterCommand<String>(this.connectionHandler, this.maxAttempts) {
            public String execute(Jedis connection) {
                return connection.set(bArr, bArr2, setParams);
            }
        }.runBinary(key);
    }

    public byte[] get(final byte[] key) {
        return (byte[]) new JedisClusterCommand<byte[]>(this.connectionHandler, this.maxAttempts) {
            public byte[] execute(Jedis connection) {
                return connection.get(key);
            }
        }.runBinary(key);
    }

    public Long exists(final byte[]... keys) {
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.exists(keys);
            }
        }.runBinary(keys.length, keys);
    }

    public Boolean exists(final byte[] key) {
        return (Boolean) new JedisClusterCommand<Boolean>(this.connectionHandler, this.maxAttempts) {
            public Boolean execute(Jedis connection) {
                return connection.exists(key);
            }
        }.runBinary(key);
    }

    public Long persist(final byte[] key) {
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.persist(key);
            }
        }.runBinary(key);
    }

    public String type(final byte[] key) {
        return (String) new JedisClusterCommand<String>(this.connectionHandler, this.maxAttempts) {
            public String execute(Jedis connection) {
                return connection.type(key);
            }
        }.runBinary(key);
    }

    public Long expire(byte[] key, int seconds) {
        final byte[] bArr = key;
        final int i = seconds;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.expire(bArr, i);
            }
        }.runBinary(key);
    }

    public Long pexpire(byte[] key, long milliseconds) {
        final byte[] bArr = key;
        final long j = milliseconds;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.pexpire(bArr, j);
            }
        }.runBinary(key);
    }

    public Long expireAt(byte[] key, long unixTime) {
        final byte[] bArr = key;
        final long j = unixTime;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.expireAt(bArr, j);
            }
        }.runBinary(key);
    }

    public Long pexpireAt(byte[] key, long millisecondsTimestamp) {
        final byte[] bArr = key;
        final long j = millisecondsTimestamp;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.pexpire(bArr, j);
            }
        }.runBinary(key);
    }

    public Long ttl(final byte[] key) {
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.ttl(key);
            }
        }.runBinary(key);
    }

    public Boolean setbit(byte[] key, long offset, boolean value) {
        final byte[] bArr = key;
        final long j = offset;
        final boolean z = value;
        return (Boolean) new JedisClusterCommand<Boolean>(this.connectionHandler, this.maxAttempts) {
            public Boolean execute(Jedis connection) {
                return connection.setbit(bArr, j, z);
            }
        }.runBinary(key);
    }

    public Boolean setbit(byte[] key, long offset, byte[] value) {
        final byte[] bArr = key;
        final long j = offset;
        final byte[] bArr2 = value;
        return (Boolean) new JedisClusterCommand<Boolean>(this.connectionHandler, this.maxAttempts) {
            public Boolean execute(Jedis connection) {
                return connection.setbit(bArr, j, bArr2);
            }
        }.runBinary(key);
    }

    public Boolean getbit(byte[] key, long offset) {
        final byte[] bArr = key;
        final long j = offset;
        return (Boolean) new JedisClusterCommand<Boolean>(this.connectionHandler, this.maxAttempts) {
            public Boolean execute(Jedis connection) {
                return connection.getbit(bArr, j);
            }
        }.runBinary(key);
    }

    public Long setrange(byte[] key, long offset, byte[] value) {
        final byte[] bArr = key;
        final long j = offset;
        final byte[] bArr2 = value;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.setrange(bArr, j, bArr2);
            }
        }.runBinary(key);
    }

    public byte[] getrange(byte[] key, long startOffset, long endOffset) {
        final byte[] bArr = key;
        final long j = startOffset;
        final long j2 = endOffset;
        return (byte[]) new JedisClusterCommand<byte[]>(this.connectionHandler, this.maxAttempts) {
            public byte[] execute(Jedis connection) {
                return connection.getrange(bArr, j, j2);
            }
        }.runBinary(key);
    }

    public byte[] getSet(byte[] key, byte[] value) {
        final byte[] bArr = key;
        final byte[] bArr2 = value;
        return (byte[]) new JedisClusterCommand<byte[]>(this.connectionHandler, this.maxAttempts) {
            public byte[] execute(Jedis connection) {
                return connection.getSet(bArr, bArr2);
            }
        }.runBinary(key);
    }

    public Long setnx(byte[] key, byte[] value) {
        final byte[] bArr = key;
        final byte[] bArr2 = value;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.setnx(bArr, bArr2);
            }
        }.runBinary(key);
    }

    public String setex(byte[] key, int seconds, byte[] value) {
        final byte[] bArr = key;
        final int i = seconds;
        final byte[] bArr2 = value;
        return (String) new JedisClusterCommand<String>(this.connectionHandler, this.maxAttempts) {
            public String execute(Jedis connection) {
                return connection.setex(bArr, i, bArr2);
            }
        }.runBinary(key);
    }

    public Long decrBy(byte[] key, long integer) {
        final byte[] bArr = key;
        final long j = integer;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.decrBy(bArr, j);
            }
        }.runBinary(key);
    }

    public Long decr(final byte[] key) {
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.decr(key);
            }
        }.runBinary(key);
    }

    public Long incrBy(byte[] key, long integer) {
        final byte[] bArr = key;
        final long j = integer;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.incrBy(bArr, j);
            }
        }.runBinary(key);
    }

    public Double incrByFloat(byte[] key, double value) {
        final byte[] bArr = key;
        final double d = value;
        return (Double) new JedisClusterCommand<Double>(this.connectionHandler, this.maxAttempts) {
            public Double execute(Jedis connection) {
                return connection.incrByFloat(bArr, d);
            }
        }.runBinary(key);
    }

    public Long incr(final byte[] key) {
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.incr(key);
            }
        }.runBinary(key);
    }

    public Long append(byte[] key, byte[] value) {
        final byte[] bArr = key;
        final byte[] bArr2 = value;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.append(bArr, bArr2);
            }
        }.runBinary(key);
    }

    public byte[] substr(byte[] key, int start, int end) {
        final byte[] bArr = key;
        final int i = start;
        final int i2 = end;
        return (byte[]) new JedisClusterCommand<byte[]>(this.connectionHandler, this.maxAttempts) {
            public byte[] execute(Jedis connection) {
                return connection.substr(bArr, i, i2);
            }
        }.runBinary(key);
    }

    public Long hset(byte[] key, byte[] field, byte[] value) {
        final byte[] bArr = key;
        final byte[] bArr2 = field;
        final byte[] bArr3 = value;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.hset(bArr, bArr2, bArr3);
            }
        }.runBinary(key);
    }

    public byte[] hget(byte[] key, byte[] field) {
        final byte[] bArr = key;
        final byte[] bArr2 = field;
        return (byte[]) new JedisClusterCommand<byte[]>(this.connectionHandler, this.maxAttempts) {
            public byte[] execute(Jedis connection) {
                return connection.hget(bArr, bArr2);
            }
        }.runBinary(key);
    }

    public Long hsetnx(byte[] key, byte[] field, byte[] value) {
        final byte[] bArr = key;
        final byte[] bArr2 = field;
        final byte[] bArr3 = value;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.hsetnx(bArr, bArr2, bArr3);
            }
        }.runBinary(key);
    }

    public String hmset(byte[] key, Map<byte[], byte[]> hash) {
        final byte[] bArr = key;
        final Map<byte[], byte[]> map = hash;
        return (String) new JedisClusterCommand<String>(this.connectionHandler, this.maxAttempts) {
            public String execute(Jedis connection) {
                return connection.hmset(bArr, map);
            }
        }.runBinary(key);
    }

    public List<byte[]> hmget(byte[] key, byte[]... fields) {
        final byte[] bArr = key;
        final byte[][] bArr2 = fields;
        return (List) new JedisClusterCommand<List<byte[]>>(this.connectionHandler, this.maxAttempts) {
            public List<byte[]> execute(Jedis connection) {
                return connection.hmget(bArr, bArr2);
            }
        }.runBinary(key);
    }

    public Long hincrBy(byte[] key, byte[] field, long value) {
        final byte[] bArr = key;
        final byte[] bArr2 = field;
        final long j = value;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.hincrBy(bArr, bArr2, j);
            }
        }.runBinary(key);
    }

    public Double hincrByFloat(byte[] key, byte[] field, double value) {
        final byte[] bArr = key;
        final byte[] bArr2 = field;
        final double d = value;
        return (Double) new JedisClusterCommand<Double>(this.connectionHandler, this.maxAttempts) {
            public Double execute(Jedis connection) {
                return connection.hincrByFloat(bArr, bArr2, d);
            }
        }.runBinary(key);
    }

    public Boolean hexists(byte[] key, byte[] field) {
        final byte[] bArr = key;
        final byte[] bArr2 = field;
        return (Boolean) new JedisClusterCommand<Boolean>(this.connectionHandler, this.maxAttempts) {
            public Boolean execute(Jedis connection) {
                return connection.hexists(bArr, bArr2);
            }
        }.runBinary(key);
    }

    public Long hdel(byte[] key, byte[]... field) {
        final byte[] bArr = key;
        final byte[][] bArr2 = field;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.hdel(bArr, bArr2);
            }
        }.runBinary(key);
    }

    public Long hlen(final byte[] key) {
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.hlen(key);
            }
        }.runBinary(key);
    }

    public Set<byte[]> hkeys(final byte[] key) {
        return (Set) new JedisClusterCommand<Set<byte[]>>(this.connectionHandler, this.maxAttempts) {
            public Set<byte[]> execute(Jedis connection) {
                return connection.hkeys(key);
            }
        }.runBinary(key);
    }

    public Collection<byte[]> hvals(final byte[] key) {
        return (Collection) new JedisClusterCommand<Collection<byte[]>>(this.connectionHandler, this.maxAttempts) {
            public Collection<byte[]> execute(Jedis connection) {
                return connection.hvals(key);
            }
        }.runBinary(key);
    }

    public Map<byte[], byte[]> hgetAll(final byte[] key) {
        return (Map) new JedisClusterCommand<Map<byte[], byte[]>>(this.connectionHandler, this.maxAttempts) {
            public Map<byte[], byte[]> execute(Jedis connection) {
                return connection.hgetAll(key);
            }
        }.runBinary(key);
    }

    public Long rpush(byte[] key, byte[]... args) {
        final byte[] bArr = key;
        final byte[][] bArr2 = args;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.rpush(bArr, bArr2);
            }
        }.runBinary(key);
    }

    public Long lpush(byte[] key, byte[]... args) {
        final byte[] bArr = key;
        final byte[][] bArr2 = args;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.lpush(bArr, bArr2);
            }
        }.runBinary(key);
    }

    public Long llen(final byte[] key) {
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.llen(key);
            }
        }.runBinary(key);
    }

    public List<byte[]> lrange(byte[] key, long start, long end) {
        final byte[] bArr = key;
        final long j = start;
        final long j2 = end;
        return (List) new JedisClusterCommand<List<byte[]>>(this.connectionHandler, this.maxAttempts) {
            public List<byte[]> execute(Jedis connection) {
                return connection.lrange(bArr, j, j2);
            }
        }.runBinary(key);
    }

    public String ltrim(byte[] key, long start, long end) {
        final byte[] bArr = key;
        final long j = start;
        final long j2 = end;
        return (String) new JedisClusterCommand<String>(this.connectionHandler, this.maxAttempts) {
            public String execute(Jedis connection) {
                return connection.ltrim(bArr, j, j2);
            }
        }.runBinary(key);
    }

    public byte[] lindex(byte[] key, long index) {
        final byte[] bArr = key;
        final long j = index;
        return (byte[]) new JedisClusterCommand<byte[]>(this.connectionHandler, this.maxAttempts) {
            public byte[] execute(Jedis connection) {
                return connection.lindex(bArr, j);
            }
        }.runBinary(key);
    }

    public String lset(byte[] key, long index, byte[] value) {
        final byte[] bArr = key;
        final long j = index;
        final byte[] bArr2 = value;
        return (String) new JedisClusterCommand<String>(this.connectionHandler, this.maxAttempts) {
            public String execute(Jedis connection) {
                return connection.lset(bArr, j, bArr2);
            }
        }.runBinary(key);
    }

    public Long lrem(byte[] key, long count, byte[] value) {
        final byte[] bArr = key;
        final long j = count;
        final byte[] bArr2 = value;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.lrem(bArr, j, bArr2);
            }
        }.runBinary(key);
    }

    public byte[] lpop(final byte[] key) {
        return (byte[]) new JedisClusterCommand<byte[]>(this.connectionHandler, this.maxAttempts) {
            public byte[] execute(Jedis connection) {
                return connection.lpop(key);
            }
        }.runBinary(key);
    }

    public byte[] rpop(final byte[] key) {
        return (byte[]) new JedisClusterCommand<byte[]>(this.connectionHandler, this.maxAttempts) {
            public byte[] execute(Jedis connection) {
                return connection.rpop(key);
            }
        }.runBinary(key);
    }

    public Long sadd(byte[] key, byte[]... member) {
        final byte[] bArr = key;
        final byte[][] bArr2 = member;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.sadd(bArr, bArr2);
            }
        }.runBinary(key);
    }

    public Set<byte[]> smembers(final byte[] key) {
        return (Set) new JedisClusterCommand<Set<byte[]>>(this.connectionHandler, this.maxAttempts) {
            public Set<byte[]> execute(Jedis connection) {
                return connection.smembers(key);
            }
        }.runBinary(key);
    }

    public Long srem(byte[] key, byte[]... member) {
        final byte[] bArr = key;
        final byte[][] bArr2 = member;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.srem(bArr, bArr2);
            }
        }.runBinary(key);
    }

    public byte[] spop(final byte[] key) {
        return (byte[]) new JedisClusterCommand<byte[]>(this.connectionHandler, this.maxAttempts) {
            public byte[] execute(Jedis connection) {
                return connection.spop(key);
            }
        }.runBinary(key);
    }

    public Set<byte[]> spop(byte[] key, long count) {
        final byte[] bArr = key;
        final long j = count;
        return (Set) new JedisClusterCommand<Set<byte[]>>(this.connectionHandler, this.maxAttempts) {
            public Set<byte[]> execute(Jedis connection) {
                return connection.spop(bArr, j);
            }
        }.runBinary(key);
    }

    public Long scard(final byte[] key) {
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.scard(key);
            }
        }.runBinary(key);
    }

    public Boolean sismember(byte[] key, byte[] member) {
        final byte[] bArr = key;
        final byte[] bArr2 = member;
        return (Boolean) new JedisClusterCommand<Boolean>(this.connectionHandler, this.maxAttempts) {
            public Boolean execute(Jedis connection) {
                return connection.sismember(bArr, bArr2);
            }
        }.runBinary(key);
    }

    public byte[] srandmember(final byte[] key) {
        return (byte[]) new JedisClusterCommand<byte[]>(this.connectionHandler, this.maxAttempts) {
            public byte[] execute(Jedis connection) {
                return connection.srandmember(key);
            }
        }.runBinary(key);
    }

    public Long strlen(final byte[] key) {
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.strlen(key);
            }
        }.runBinary(key);
    }

    public Long zadd(byte[] key, double score, byte[] member) {
        final byte[] bArr = key;
        final double d = score;
        final byte[] bArr2 = member;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.zadd(bArr, d, bArr2);
            }
        }.runBinary(key);
    }

    public Long zadd(byte[] key, double score, byte[] member, ZAddParams params) {
        final byte[] bArr = key;
        final double d = score;
        final byte[] bArr2 = member;
        final ZAddParams zAddParams = params;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.zadd(bArr, d, bArr2, zAddParams);
            }
        }.runBinary(key);
    }

    public Long zadd(byte[] key, Map<byte[], Double> scoreMembers) {
        final byte[] bArr = key;
        final Map<byte[], Double> map = scoreMembers;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.zadd(bArr, map);
            }
        }.runBinary(key);
    }

    public Long zadd(byte[] key, Map<byte[], Double> scoreMembers, ZAddParams params) {
        final byte[] bArr = key;
        final Map<byte[], Double> map = scoreMembers;
        final ZAddParams zAddParams = params;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.zadd(bArr, (Map<byte[], Double>) map, zAddParams);
            }
        }.runBinary(key);
    }

    public Set<byte[]> zrange(byte[] key, long start, long end) {
        final byte[] bArr = key;
        final long j = start;
        final long j2 = end;
        return (Set) new JedisClusterCommand<Set<byte[]>>(this.connectionHandler, this.maxAttempts) {
            public Set<byte[]> execute(Jedis connection) {
                return connection.zrange(bArr, j, j2);
            }
        }.runBinary(key);
    }

    public Long zrem(byte[] key, byte[]... member) {
        final byte[] bArr = key;
        final byte[][] bArr2 = member;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.zrem(bArr, bArr2);
            }
        }.runBinary(key);
    }

    public Double zincrby(byte[] key, double score, byte[] member) {
        final byte[] bArr = key;
        final double d = score;
        final byte[] bArr2 = member;
        return (Double) new JedisClusterCommand<Double>(this.connectionHandler, this.maxAttempts) {
            public Double execute(Jedis connection) {
                return connection.zincrby(bArr, d, bArr2);
            }
        }.runBinary(key);
    }

    public Double zincrby(byte[] key, double score, byte[] member, ZIncrByParams params) {
        final byte[] bArr = key;
        final double d = score;
        final byte[] bArr2 = member;
        final ZIncrByParams zIncrByParams = params;
        return (Double) new JedisClusterCommand<Double>(this.connectionHandler, this.maxAttempts) {
            public Double execute(Jedis connection) {
                return connection.zincrby(bArr, d, bArr2, zIncrByParams);
            }
        }.runBinary(key);
    }

    public Long zrank(byte[] key, byte[] member) {
        final byte[] bArr = key;
        final byte[] bArr2 = member;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.zrank(bArr, bArr2);
            }
        }.runBinary(key);
    }

    public Long zrevrank(byte[] key, byte[] member) {
        final byte[] bArr = key;
        final byte[] bArr2 = member;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.zrevrank(bArr, bArr2);
            }
        }.runBinary(key);
    }

    public Set<byte[]> zrevrange(byte[] key, long start, long end) {
        final byte[] bArr = key;
        final long j = start;
        final long j2 = end;
        return (Set) new JedisClusterCommand<Set<byte[]>>(this.connectionHandler, this.maxAttempts) {
            public Set<byte[]> execute(Jedis connection) {
                return connection.zrevrange(bArr, j, j2);
            }
        }.runBinary(key);
    }

    public Set<Tuple> zrangeWithScores(byte[] key, long start, long end) {
        final byte[] bArr = key;
        final long j = start;
        final long j2 = end;
        return (Set) new JedisClusterCommand<Set<Tuple>>(this.connectionHandler, this.maxAttempts) {
            public Set<Tuple> execute(Jedis connection) {
                return connection.zrangeWithScores(bArr, j, j2);
            }
        }.runBinary(key);
    }

    public Set<Tuple> zrevrangeWithScores(byte[] key, long start, long end) {
        final byte[] bArr = key;
        final long j = start;
        final long j2 = end;
        return (Set) new JedisClusterCommand<Set<Tuple>>(this.connectionHandler, this.maxAttempts) {
            public Set<Tuple> execute(Jedis connection) {
                return connection.zrevrangeWithScores(bArr, j, j2);
            }
        }.runBinary(key);
    }

    public Long zcard(final byte[] key) {
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.zcard(key);
            }
        }.runBinary(key);
    }

    public Double zscore(byte[] key, byte[] member) {
        final byte[] bArr = key;
        final byte[] bArr2 = member;
        return (Double) new JedisClusterCommand<Double>(this.connectionHandler, this.maxAttempts) {
            public Double execute(Jedis connection) {
                return connection.zscore(bArr, bArr2);
            }
        }.runBinary(key);
    }

    public List<byte[]> sort(final byte[] key) {
        return (List) new JedisClusterCommand<List<byte[]>>(this.connectionHandler, this.maxAttempts) {
            public List<byte[]> execute(Jedis connection) {
                return connection.sort(key);
            }
        }.runBinary(key);
    }

    public List<byte[]> sort(byte[] key, SortingParams sortingParameters) {
        final byte[] bArr = key;
        final SortingParams sortingParams = sortingParameters;
        return (List) new JedisClusterCommand<List<byte[]>>(this.connectionHandler, this.maxAttempts) {
            public List<byte[]> execute(Jedis connection) {
                return connection.sort(bArr, sortingParams);
            }
        }.runBinary(key);
    }

    public Long zcount(byte[] key, double min, double max) {
        final byte[] bArr = key;
        final double d = min;
        final double d2 = max;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.zcount(bArr, d, d2);
            }
        }.runBinary(key);
    }

    public Long zcount(byte[] key, byte[] min, byte[] max) {
        final byte[] bArr = key;
        final byte[] bArr2 = min;
        final byte[] bArr3 = max;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.zcount(bArr, bArr2, bArr3);
            }
        }.runBinary(key);
    }

    public Set<byte[]> zrangeByScore(byte[] key, double min, double max) {
        final byte[] bArr = key;
        final double d = min;
        final double d2 = max;
        return (Set) new JedisClusterCommand<Set<byte[]>>(this.connectionHandler, this.maxAttempts) {
            public Set<byte[]> execute(Jedis connection) {
                return connection.zrangeByScore(bArr, d, d2);
            }
        }.runBinary(key);
    }

    public Set<byte[]> zrangeByScore(byte[] key, byte[] min, byte[] max) {
        final byte[] bArr = key;
        final byte[] bArr2 = min;
        final byte[] bArr3 = max;
        return (Set) new JedisClusterCommand<Set<byte[]>>(this.connectionHandler, this.maxAttempts) {
            public Set<byte[]> execute(Jedis connection) {
                return connection.zrangeByScore(bArr, bArr2, bArr3);
            }
        }.runBinary(key);
    }

    public Set<byte[]> zrevrangeByScore(byte[] key, double max, double min) {
        final byte[] bArr = key;
        final double d = max;
        final double d2 = min;
        return (Set) new JedisClusterCommand<Set<byte[]>>(this.connectionHandler, this.maxAttempts) {
            public Set<byte[]> execute(Jedis connection) {
                return connection.zrevrangeByScore(bArr, d, d2);
            }
        }.runBinary(key);
    }

    public Set<byte[]> zrangeByScore(byte[] key, double min, double max, int offset, int count) {
        final byte[] bArr = key;
        final double d = min;
        final double d2 = max;
        final int i = offset;
        final int i2 = count;
        byte[] bArr2 = key;
        return (Set) new JedisClusterCommand<Set<byte[]>>(this.connectionHandler, this.maxAttempts) {
            public Set<byte[]> execute(Jedis connection) {
                return connection.zrangeByScore(bArr, d, d2, i, i2);
            }
        }.runBinary(key);
    }

    public Set<byte[]> zrevrangeByScore(byte[] key, byte[] max, byte[] min) {
        final byte[] bArr = key;
        final byte[] bArr2 = max;
        final byte[] bArr3 = min;
        return (Set) new JedisClusterCommand<Set<byte[]>>(this.connectionHandler, this.maxAttempts) {
            public Set<byte[]> execute(Jedis connection) {
                return connection.zrevrangeByScore(bArr, bArr2, bArr3);
            }
        }.runBinary(key);
    }

    public Set<byte[]> zrangeByScore(byte[] key, byte[] min, byte[] max, int offset, int count) {
        final byte[] bArr = key;
        final byte[] bArr2 = min;
        final byte[] bArr3 = max;
        final int i = offset;
        final int i2 = count;
        return (Set) new JedisClusterCommand<Set<byte[]>>(this.connectionHandler, this.maxAttempts) {
            public Set<byte[]> execute(Jedis connection) {
                return connection.zrangeByScore(bArr, bArr2, bArr3, i, i2);
            }
        }.runBinary(key);
    }

    public Set<byte[]> zrevrangeByScore(byte[] key, double max, double min, int offset, int count) {
        final byte[] bArr = key;
        final double d = max;
        final double d2 = min;
        final int i = offset;
        final int i2 = count;
        byte[] bArr2 = key;
        return (Set) new JedisClusterCommand<Set<byte[]>>(this.connectionHandler, this.maxAttempts) {
            public Set<byte[]> execute(Jedis connection) {
                return connection.zrevrangeByScore(bArr, d, d2, i, i2);
            }
        }.runBinary(key);
    }

    public Set<Tuple> zrangeByScoreWithScores(byte[] key, double min, double max) {
        final byte[] bArr = key;
        final double d = min;
        final double d2 = max;
        return (Set) new JedisClusterCommand<Set<Tuple>>(this.connectionHandler, this.maxAttempts) {
            public Set<Tuple> execute(Jedis connection) {
                return connection.zrangeByScoreWithScores(bArr, d, d2);
            }
        }.runBinary(key);
    }

    public Set<Tuple> zrevrangeByScoreWithScores(byte[] key, double max, double min) {
        final byte[] bArr = key;
        final double d = max;
        final double d2 = min;
        return (Set) new JedisClusterCommand<Set<Tuple>>(this.connectionHandler, this.maxAttempts) {
            public Set<Tuple> execute(Jedis connection) {
                return connection.zrevrangeByScoreWithScores(bArr, d, d2);
            }
        }.runBinary(key);
    }

    public Set<Tuple> zrangeByScoreWithScores(byte[] key, double min, double max, int offset, int count) {
        final byte[] bArr = key;
        final double d = min;
        final double d2 = max;
        final int i = offset;
        final int i2 = count;
        byte[] bArr2 = key;
        return (Set) new JedisClusterCommand<Set<Tuple>>(this.connectionHandler, this.maxAttempts) {
            public Set<Tuple> execute(Jedis connection) {
                return connection.zrangeByScoreWithScores(bArr, d, d2, i, i2);
            }
        }.runBinary(key);
    }

    public Set<byte[]> zrevrangeByScore(byte[] key, byte[] max, byte[] min, int offset, int count) {
        final byte[] bArr = key;
        final byte[] bArr2 = max;
        final byte[] bArr3 = min;
        final int i = offset;
        final int i2 = count;
        return (Set) new JedisClusterCommand<Set<byte[]>>(this.connectionHandler, this.maxAttempts) {
            public Set<byte[]> execute(Jedis connection) {
                return connection.zrevrangeByScore(bArr, bArr2, bArr3, i, i2);
            }
        }.runBinary(key);
    }

    public Set<Tuple> zrangeByScoreWithScores(byte[] key, byte[] min, byte[] max) {
        final byte[] bArr = key;
        final byte[] bArr2 = min;
        final byte[] bArr3 = max;
        return (Set) new JedisClusterCommand<Set<Tuple>>(this.connectionHandler, this.maxAttempts) {
            public Set<Tuple> execute(Jedis connection) {
                return connection.zrangeByScoreWithScores(bArr, bArr2, bArr3);
            }
        }.runBinary(key);
    }

    public Set<Tuple> zrevrangeByScoreWithScores(byte[] key, byte[] max, byte[] min) {
        final byte[] bArr = key;
        final byte[] bArr2 = max;
        final byte[] bArr3 = min;
        return (Set) new JedisClusterCommand<Set<Tuple>>(this.connectionHandler, this.maxAttempts) {
            public Set<Tuple> execute(Jedis connection) {
                return connection.zrevrangeByScoreWithScores(bArr, bArr2, bArr3);
            }
        }.runBinary(key);
    }

    public Set<Tuple> zrangeByScoreWithScores(byte[] key, byte[] min, byte[] max, int offset, int count) {
        final byte[] bArr = key;
        final byte[] bArr2 = min;
        final byte[] bArr3 = max;
        final int i = offset;
        final int i2 = count;
        return (Set) new JedisClusterCommand<Set<Tuple>>(this.connectionHandler, this.maxAttempts) {
            public Set<Tuple> execute(Jedis connection) {
                return connection.zrangeByScoreWithScores(bArr, bArr2, bArr3, i, i2);
            }
        }.runBinary(key);
    }

    public Set<Tuple> zrevrangeByScoreWithScores(byte[] key, double max, double min, int offset, int count) {
        final byte[] bArr = key;
        final double d = max;
        final double d2 = min;
        final int i = offset;
        final int i2 = count;
        byte[] bArr2 = key;
        return (Set) new JedisClusterCommand<Set<Tuple>>(this.connectionHandler, this.maxAttempts) {
            public Set<Tuple> execute(Jedis connection) {
                return connection.zrevrangeByScoreWithScores(bArr, d, d2, i, i2);
            }
        }.runBinary(key);
    }

    public Set<Tuple> zrevrangeByScoreWithScores(byte[] key, byte[] max, byte[] min, int offset, int count) {
        final byte[] bArr = key;
        final byte[] bArr2 = max;
        final byte[] bArr3 = min;
        final int i = offset;
        final int i2 = count;
        return (Set) new JedisClusterCommand<Set<Tuple>>(this.connectionHandler, this.maxAttempts) {
            public Set<Tuple> execute(Jedis connection) {
                return connection.zrevrangeByScoreWithScores(bArr, bArr2, bArr3, i, i2);
            }
        }.runBinary(key);
    }

    public Long zremrangeByRank(byte[] key, long start, long end) {
        final byte[] bArr = key;
        final long j = start;
        final long j2 = end;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.zremrangeByRank(bArr, j, j2);
            }
        }.runBinary(key);
    }

    public Long zremrangeByScore(byte[] key, double start, double end) {
        final byte[] bArr = key;
        final double d = start;
        final double d2 = end;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.zremrangeByScore(bArr, d, d2);
            }
        }.runBinary(key);
    }

    public Long zremrangeByScore(byte[] key, byte[] start, byte[] end) {
        final byte[] bArr = key;
        final byte[] bArr2 = start;
        final byte[] bArr3 = end;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.zremrangeByScore(bArr, bArr2, bArr3);
            }
        }.runBinary(key);
    }

    public Long linsert(byte[] key, BinaryClient.LIST_POSITION where, byte[] pivot, byte[] value) {
        final byte[] bArr = key;
        final BinaryClient.LIST_POSITION list_position = where;
        final byte[] bArr2 = pivot;
        final byte[] bArr3 = value;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.linsert(bArr, list_position, bArr2, bArr3);
            }
        }.runBinary(key);
    }

    public Long lpushx(byte[] key, byte[]... arg) {
        final byte[] bArr = key;
        final byte[][] bArr2 = arg;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.lpushx(bArr, bArr2);
            }
        }.runBinary(key);
    }

    public Long rpushx(byte[] key, byte[]... arg) {
        final byte[] bArr = key;
        final byte[][] bArr2 = arg;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.rpushx(bArr, bArr2);
            }
        }.runBinary(key);
    }

    public Long del(final byte[] key) {
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.del(key);
            }
        }.runBinary(key);
    }

    public byte[] echo(final byte[] arg) {
        return (byte[]) new JedisClusterCommand<byte[]>(this.connectionHandler, this.maxAttempts) {
            public byte[] execute(Jedis connection) {
                return connection.echo(arg);
            }
        }.runBinary(arg);
    }

    public Long bitcount(final byte[] key) {
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.bitcount(key);
            }
        }.runBinary(key);
    }

    public Long bitcount(byte[] key, long start, long end) {
        final byte[] bArr = key;
        final long j = start;
        final long j2 = end;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.bitcount(bArr, j, j2);
            }
        }.runBinary(key);
    }

    public Long pfadd(byte[] key, byte[]... elements) {
        final byte[] bArr = key;
        final byte[][] bArr2 = elements;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.pfadd(bArr, bArr2);
            }
        }.runBinary(key);
    }

    public long pfcount(final byte[] key) {
        return ((Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return Long.valueOf(connection.pfcount(key));
            }
        }.runBinary(key)).longValue();
    }

    public List<byte[]> srandmember(byte[] key, int count) {
        final byte[] bArr = key;
        final int i = count;
        return (List) new JedisClusterCommand<List<byte[]>>(this.connectionHandler, this.maxAttempts) {
            public List<byte[]> execute(Jedis connection) {
                return connection.srandmember(bArr, i);
            }
        }.runBinary(key);
    }

    public Long zlexcount(byte[] key, byte[] min, byte[] max) {
        final byte[] bArr = key;
        final byte[] bArr2 = min;
        final byte[] bArr3 = max;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.zlexcount(bArr, bArr2, bArr3);
            }
        }.runBinary(key);
    }

    public Set<byte[]> zrangeByLex(byte[] key, byte[] min, byte[] max) {
        final byte[] bArr = key;
        final byte[] bArr2 = min;
        final byte[] bArr3 = max;
        return (Set) new JedisClusterCommand<Set<byte[]>>(this.connectionHandler, this.maxAttempts) {
            public Set<byte[]> execute(Jedis connection) {
                return connection.zrangeByLex(bArr, bArr2, bArr3);
            }
        }.runBinary(key);
    }

    public Set<byte[]> zrangeByLex(byte[] key, byte[] min, byte[] max, int offset, int count) {
        final byte[] bArr = key;
        final byte[] bArr2 = min;
        final byte[] bArr3 = max;
        final int i = offset;
        final int i2 = count;
        return (Set) new JedisClusterCommand<Set<byte[]>>(this.connectionHandler, this.maxAttempts) {
            public Set<byte[]> execute(Jedis connection) {
                return connection.zrangeByLex(bArr, bArr2, bArr3, i, i2);
            }
        }.runBinary(key);
    }

    public Set<byte[]> zrevrangeByLex(byte[] key, byte[] max, byte[] min) {
        final byte[] bArr = key;
        final byte[] bArr2 = max;
        final byte[] bArr3 = min;
        return (Set) new JedisClusterCommand<Set<byte[]>>(this.connectionHandler, this.maxAttempts) {
            public Set<byte[]> execute(Jedis connection) {
                return connection.zrevrangeByLex(bArr, bArr2, bArr3);
            }
        }.runBinary(key);
    }

    public Set<byte[]> zrevrangeByLex(byte[] key, byte[] max, byte[] min, int offset, int count) {
        final byte[] bArr = key;
        final byte[] bArr2 = max;
        final byte[] bArr3 = min;
        final int i = offset;
        final int i2 = count;
        return (Set) new JedisClusterCommand<Set<byte[]>>(this.connectionHandler, this.maxAttempts) {
            public Set<byte[]> execute(Jedis connection) {
                return connection.zrevrangeByLex(bArr, bArr2, bArr3, i, i2);
            }
        }.runBinary(key);
    }

    public Long zremrangeByLex(byte[] key, byte[] min, byte[] max) {
        final byte[] bArr = key;
        final byte[] bArr2 = min;
        final byte[] bArr3 = max;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.zremrangeByLex(bArr, bArr2, bArr3);
            }
        }.runBinary(key);
    }

    public Object eval(byte[] script, byte[] keyCount, byte[]... params) {
        final byte[] bArr = script;
        final byte[] bArr2 = keyCount;
        final byte[][] bArr3 = params;
        return new JedisClusterCommand<Object>(this.connectionHandler, this.maxAttempts) {
            public Object execute(Jedis connection) {
                return connection.eval(bArr, bArr2, bArr3);
            }
        }.runBinary(Integer.parseInt(SafeEncoder.encode(keyCount)), params);
    }

    public Object eval(byte[] script, int keyCount, byte[]... params) {
        final byte[] bArr = script;
        final int i = keyCount;
        final byte[][] bArr2 = params;
        return new JedisClusterCommand<Object>(this.connectionHandler, this.maxAttempts) {
            public Object execute(Jedis connection) {
                return connection.eval(bArr, i, bArr2);
            }
        }.runBinary(keyCount, params);
    }

    public Object eval(byte[] script, List<byte[]> keys, List<byte[]> args) {
        final byte[] bArr = script;
        final List<byte[]> list = keys;
        final List<byte[]> list2 = args;
        return new JedisClusterCommand<Object>(this.connectionHandler, this.maxAttempts) {
            public Object execute(Jedis connection) {
                return connection.eval(bArr, (List<byte[]>) list, (List<byte[]>) list2);
            }
        }.runBinary(keys.size(), (byte[][]) keys.toArray(new byte[keys.size()][]));
    }

    public Object eval(final byte[] script, byte[] key) {
        return new JedisClusterCommand<Object>(this.connectionHandler, this.maxAttempts) {
            public Object execute(Jedis connection) {
                return connection.eval(script);
            }
        }.runBinary(key);
    }

    public Object evalsha(final byte[] script, byte[] key) {
        return new JedisClusterCommand<Object>(this.connectionHandler, this.maxAttempts) {
            public Object execute(Jedis connection) {
                return connection.evalsha(script);
            }
        }.runBinary(key);
    }

    public Object evalsha(byte[] sha1, List<byte[]> keys, List<byte[]> args) {
        final byte[] bArr = sha1;
        final List<byte[]> list = keys;
        final List<byte[]> list2 = args;
        return new JedisClusterCommand<Object>(this.connectionHandler, this.maxAttempts) {
            public Object execute(Jedis connection) {
                return connection.evalsha(bArr, (List<byte[]>) list, (List<byte[]>) list2);
            }
        }.runBinary(keys.size(), (byte[][]) keys.toArray(new byte[keys.size()][]));
    }

    public Object evalsha(byte[] sha1, int keyCount, byte[]... params) {
        final byte[] bArr = sha1;
        final int i = keyCount;
        final byte[][] bArr2 = params;
        return new JedisClusterCommand<Object>(this.connectionHandler, this.maxAttempts) {
            public Object execute(Jedis connection) {
                return connection.evalsha(bArr, i, bArr2);
            }
        }.runBinary(keyCount, params);
    }

    public List<Long> scriptExists(byte[] key, final byte[][] sha1) {
        return (List) new JedisClusterCommand<List<Long>>(this.connectionHandler, this.maxAttempts) {
            public List<Long> execute(Jedis connection) {
                return connection.scriptExists(sha1);
            }
        }.runBinary(key);
    }

    public byte[] scriptLoad(final byte[] script, byte[] key) {
        return (byte[]) new JedisClusterCommand<byte[]>(this.connectionHandler, this.maxAttempts) {
            public byte[] execute(Jedis connection) {
                return connection.scriptLoad(script);
            }
        }.runBinary(key);
    }

    public String scriptFlush(byte[] key) {
        return (String) new JedisClusterCommand<String>(this.connectionHandler, this.maxAttempts) {
            public String execute(Jedis connection) {
                return connection.scriptFlush();
            }
        }.runBinary(key);
    }

    public String scriptKill(byte[] key) {
        return (String) new JedisClusterCommand<String>(this.connectionHandler, this.maxAttempts) {
            public String execute(Jedis connection) {
                return connection.scriptKill();
            }
        }.runBinary(key);
    }

    public Long del(final byte[]... keys) {
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.del(keys);
            }
        }.runBinary(keys.length, keys);
    }

    public List<byte[]> blpop(int timeout, byte[]... keys) {
        final int i = timeout;
        final byte[][] bArr = keys;
        return (List) new JedisClusterCommand<List<byte[]>>(this.connectionHandler, this.maxAttempts) {
            public List<byte[]> execute(Jedis connection) {
                return connection.blpop(i, bArr);
            }
        }.runBinary(keys.length, keys);
    }

    public List<byte[]> brpop(int timeout, byte[]... keys) {
        final int i = timeout;
        final byte[][] bArr = keys;
        return (List) new JedisClusterCommand<List<byte[]>>(this.connectionHandler, this.maxAttempts) {
            public List<byte[]> execute(Jedis connection) {
                return connection.brpop(i, bArr);
            }
        }.runBinary(keys.length, keys);
    }

    public List<byte[]> mget(final byte[]... keys) {
        return (List) new JedisClusterCommand<List<byte[]>>(this.connectionHandler, this.maxAttempts) {
            public List<byte[]> execute(Jedis connection) {
                return connection.mget(keys);
            }
        }.runBinary(keys.length, keys);
    }

    public String mset(final byte[]... keysvalues) {
        byte[][] keys = new byte[(keysvalues.length / 2)][];
        for (int keyIdx = 0; keyIdx < keys.length; keyIdx++) {
            keys[keyIdx] = keysvalues[keyIdx * 2];
        }
        return (String) new JedisClusterCommand<String>(this.connectionHandler, this.maxAttempts) {
            public String execute(Jedis connection) {
                return connection.mset(keysvalues);
            }
        }.runBinary(keys.length, keys);
    }

    public Long msetnx(final byte[]... keysvalues) {
        byte[][] keys = new byte[(keysvalues.length / 2)][];
        for (int keyIdx = 0; keyIdx < keys.length; keyIdx++) {
            keys[keyIdx] = keysvalues[keyIdx * 2];
        }
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.msetnx(keysvalues);
            }
        }.runBinary(keys.length, keys);
    }

    public String rename(byte[] oldkey, byte[] newkey) {
        final byte[] bArr = oldkey;
        final byte[] bArr2 = newkey;
        return (String) new JedisClusterCommand<String>(this.connectionHandler, this.maxAttempts) {
            public String execute(Jedis connection) {
                return connection.rename(bArr, bArr2);
            }
        }.runBinary(2, oldkey, newkey);
    }

    public Long renamenx(byte[] oldkey, byte[] newkey) {
        final byte[] bArr = oldkey;
        final byte[] bArr2 = newkey;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.renamenx(bArr, bArr2);
            }
        }.runBinary(2, oldkey, newkey);
    }

    public byte[] rpoplpush(byte[] srckey, byte[] dstkey) {
        final byte[] bArr = srckey;
        final byte[] bArr2 = dstkey;
        return (byte[]) new JedisClusterCommand<byte[]>(this.connectionHandler, this.maxAttempts) {
            public byte[] execute(Jedis connection) {
                return connection.rpoplpush(bArr, bArr2);
            }
        }.runBinary(2, srckey, dstkey);
    }

    public Set<byte[]> sdiff(final byte[]... keys) {
        return (Set) new JedisClusterCommand<Set<byte[]>>(this.connectionHandler, this.maxAttempts) {
            public Set<byte[]> execute(Jedis connection) {
                return connection.sdiff(keys);
            }
        }.runBinary(keys.length, keys);
    }

    public Long sdiffstore(byte[] dstkey, byte[]... keys) {
        byte[][] wholeKeys = KeyMergeUtil.merge(dstkey, keys);
        final byte[] bArr = dstkey;
        final byte[][] bArr2 = keys;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.sdiffstore(bArr, bArr2);
            }
        }.runBinary(wholeKeys.length, wholeKeys);
    }

    public Set<byte[]> sinter(final byte[]... keys) {
        return (Set) new JedisClusterCommand<Set<byte[]>>(this.connectionHandler, this.maxAttempts) {
            public Set<byte[]> execute(Jedis connection) {
                return connection.sinter(keys);
            }
        }.runBinary(keys.length, keys);
    }

    public Long sinterstore(byte[] dstkey, byte[]... keys) {
        byte[][] wholeKeys = KeyMergeUtil.merge(dstkey, keys);
        final byte[] bArr = dstkey;
        final byte[][] bArr2 = keys;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.sinterstore(bArr, bArr2);
            }
        }.runBinary(wholeKeys.length, wholeKeys);
    }

    public Long smove(byte[] srckey, byte[] dstkey, byte[] member) {
        final byte[] bArr = srckey;
        final byte[] bArr2 = dstkey;
        final byte[] bArr3 = member;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.smove(bArr, bArr2, bArr3);
            }
        }.runBinary(2, srckey, dstkey);
    }

    public Long sort(byte[] key, SortingParams sortingParameters, byte[] dstkey) {
        final byte[] bArr = key;
        final SortingParams sortingParams = sortingParameters;
        final byte[] bArr2 = dstkey;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.sort(bArr, sortingParams, bArr2);
            }
        }.runBinary(2, key, dstkey);
    }

    public Long sort(byte[] key, byte[] dstkey) {
        final byte[] bArr = key;
        final byte[] bArr2 = dstkey;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.sort(bArr, bArr2);
            }
        }.runBinary(2, key, dstkey);
    }

    public Set<byte[]> sunion(final byte[]... keys) {
        return (Set) new JedisClusterCommand<Set<byte[]>>(this.connectionHandler, this.maxAttempts) {
            public Set<byte[]> execute(Jedis connection) {
                return connection.sunion(keys);
            }
        }.runBinary(keys.length, keys);
    }

    public Long sunionstore(byte[] dstkey, byte[]... keys) {
        byte[][] wholeKeys = KeyMergeUtil.merge(dstkey, keys);
        final byte[] bArr = dstkey;
        final byte[][] bArr2 = keys;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.sunionstore(bArr, bArr2);
            }
        }.runBinary(wholeKeys.length, wholeKeys);
    }

    public Long zinterstore(byte[] dstkey, byte[]... sets) {
        byte[][] wholeKeys = KeyMergeUtil.merge(dstkey, sets);
        final byte[] bArr = dstkey;
        final byte[][] bArr2 = sets;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.zinterstore(bArr, bArr2);
            }
        }.runBinary(wholeKeys.length, wholeKeys);
    }

    public Long zinterstore(byte[] dstkey, ZParams params, byte[]... sets) {
        byte[][] wholeKeys = KeyMergeUtil.merge(dstkey, sets);
        final byte[] bArr = dstkey;
        final ZParams zParams = params;
        final byte[][] bArr2 = sets;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.zinterstore(bArr, zParams, bArr2);
            }
        }.runBinary(wholeKeys.length, wholeKeys);
    }

    public Long zunionstore(byte[] dstkey, byte[]... sets) {
        byte[][] wholeKeys = KeyMergeUtil.merge(dstkey, sets);
        final byte[] bArr = dstkey;
        final byte[][] bArr2 = sets;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.zunionstore(bArr, bArr2);
            }
        }.runBinary(wholeKeys.length, wholeKeys);
    }

    public Long zunionstore(byte[] dstkey, ZParams params, byte[]... sets) {
        byte[][] wholeKeys = KeyMergeUtil.merge(dstkey, sets);
        final byte[] bArr = dstkey;
        final ZParams zParams = params;
        final byte[][] bArr2 = sets;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.zunionstore(bArr, zParams, bArr2);
            }
        }.runBinary(wholeKeys.length, wholeKeys);
    }

    public byte[] brpoplpush(byte[] source, byte[] destination, int timeout) {
        final byte[] bArr = source;
        final byte[] bArr2 = destination;
        final int i = timeout;
        return (byte[]) new JedisClusterCommand<byte[]>(this.connectionHandler, this.maxAttempts) {
            public byte[] execute(Jedis connection) {
                return connection.brpoplpush(bArr, bArr2, i);
            }
        }.runBinary(2, source, destination);
    }

    public Long publish(byte[] channel, byte[] message) {
        final byte[] bArr = channel;
        final byte[] bArr2 = message;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.publish(bArr, bArr2);
            }
        }.runWithAnyNode();
    }

    public void subscribe(BinaryJedisPubSub jedisPubSub, byte[]... channels) {
        final BinaryJedisPubSub binaryJedisPubSub = jedisPubSub;
        final byte[][] bArr = channels;
        new JedisClusterCommand<Integer>(this.connectionHandler, this.maxAttempts) {
            public Integer execute(Jedis connection) {
                connection.subscribe(binaryJedisPubSub, bArr);
                return 0;
            }
        }.runWithAnyNode();
    }

    public void psubscribe(BinaryJedisPubSub jedisPubSub, byte[]... patterns) {
        final BinaryJedisPubSub binaryJedisPubSub = jedisPubSub;
        final byte[][] bArr = patterns;
        new JedisClusterCommand<Integer>(this.connectionHandler, this.maxAttempts) {
            public Integer execute(Jedis connection) {
                connection.psubscribe(binaryJedisPubSub, bArr);
                return 0;
            }
        }.runWithAnyNode();
    }

    public Long bitop(BitOP op, byte[] destKey, byte[]... srcKeys) {
        byte[][] wholeKeys = KeyMergeUtil.merge(destKey, srcKeys);
        final BitOP bitOP = op;
        final byte[] bArr = destKey;
        final byte[][] bArr2 = srcKeys;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.bitop(bitOP, bArr, bArr2);
            }
        }.runBinary(wholeKeys.length, wholeKeys);
    }

    public String pfmerge(byte[] destkey, byte[]... sourcekeys) {
        byte[][] wholeKeys = KeyMergeUtil.merge(destkey, sourcekeys);
        final byte[] bArr = destkey;
        final byte[][] bArr2 = sourcekeys;
        return (String) new JedisClusterCommand<String>(this.connectionHandler, this.maxAttempts) {
            public String execute(Jedis connection) {
                return connection.pfmerge(bArr, bArr2);
            }
        }.runBinary(wholeKeys.length, wholeKeys);
    }

    public Long pfcount(final byte[]... keys) {
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.pfcount(keys);
            }
        }.runBinary(keys.length, keys);
    }

    public Long geoadd(byte[] key, double longitude, double latitude, byte[] member) {
        final byte[] bArr = key;
        final double d = longitude;
        final double d2 = latitude;
        final byte[] bArr2 = member;
        byte[] bArr3 = key;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.geoadd(bArr, d, d2, bArr2);
            }
        }.runBinary(key);
    }

    public Long geoadd(byte[] key, Map<byte[], GeoCoordinate> memberCoordinateMap) {
        final byte[] bArr = key;
        final Map<byte[], GeoCoordinate> map = memberCoordinateMap;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.geoadd(bArr, map);
            }
        }.runBinary(key);
    }

    public Double geodist(byte[] key, byte[] member1, byte[] member2) {
        final byte[] bArr = key;
        final byte[] bArr2 = member1;
        final byte[] bArr3 = member2;
        return (Double) new JedisClusterCommand<Double>(this.connectionHandler, this.maxAttempts) {
            public Double execute(Jedis connection) {
                return connection.geodist(bArr, bArr2, bArr3);
            }
        }.runBinary(key);
    }

    public Double geodist(byte[] key, byte[] member1, byte[] member2, GeoUnit unit) {
        final byte[] bArr = key;
        final byte[] bArr2 = member1;
        final byte[] bArr3 = member2;
        final GeoUnit geoUnit = unit;
        return (Double) new JedisClusterCommand<Double>(this.connectionHandler, this.maxAttempts) {
            public Double execute(Jedis connection) {
                return connection.geodist(bArr, bArr2, bArr3, geoUnit);
            }
        }.runBinary(key);
    }

    public List<byte[]> geohash(byte[] key, byte[]... members) {
        final byte[] bArr = key;
        final byte[][] bArr2 = members;
        return (List) new JedisClusterCommand<List<byte[]>>(this.connectionHandler, this.maxAttempts) {
            public List<byte[]> execute(Jedis connection) {
                return connection.geohash(bArr, bArr2);
            }
        }.runBinary(key);
    }

    public List<GeoCoordinate> geopos(byte[] key, byte[]... members) {
        final byte[] bArr = key;
        final byte[][] bArr2 = members;
        return (List) new JedisClusterCommand<List<GeoCoordinate>>(this.connectionHandler, this.maxAttempts) {
            public List<GeoCoordinate> execute(Jedis connection) {
                return connection.geopos(bArr, bArr2);
            }
        }.runBinary(key);
    }

    public List<GeoRadiusResponse> georadius(byte[] key, double longitude, double latitude, double radius, GeoUnit unit) {
        final byte[] bArr = key;
        final double d = longitude;
        final double d2 = latitude;
        final double d3 = radius;
        final GeoUnit geoUnit = unit;
        byte[] bArr2 = key;
        return (List) new JedisClusterCommand<List<GeoRadiusResponse>>(this.connectionHandler, this.maxAttempts) {
            public List<GeoRadiusResponse> execute(Jedis connection) {
                return connection.georadius(bArr, d, d2, d3, geoUnit);
            }
        }.runBinary(key);
    }

    public List<GeoRadiusResponse> georadius(byte[] key, double longitude, double latitude, double radius, GeoUnit unit, GeoRadiusParam param) {
        final byte[] bArr = key;
        final double d = longitude;
        final double d2 = latitude;
        final double d3 = radius;
        final GeoUnit geoUnit = unit;
        final GeoRadiusParam geoRadiusParam = param;
        return (List) new JedisClusterCommand<List<GeoRadiusResponse>>(this.connectionHandler, this.maxAttempts) {
            public List<GeoRadiusResponse> execute(Jedis connection) {
                return connection.georadius(bArr, d, d2, d3, geoUnit, geoRadiusParam);
            }
        }.runBinary(key);
    }

    public List<GeoRadiusResponse> georadiusByMember(byte[] key, byte[] member, double radius, GeoUnit unit) {
        final byte[] bArr = key;
        final byte[] bArr2 = member;
        final double d = radius;
        final GeoUnit geoUnit = unit;
        return (List) new JedisClusterCommand<List<GeoRadiusResponse>>(this.connectionHandler, this.maxAttempts) {
            public List<GeoRadiusResponse> execute(Jedis connection) {
                return connection.georadiusByMember(bArr, bArr2, d, geoUnit);
            }
        }.runBinary(key);
    }

    public List<GeoRadiusResponse> georadiusByMember(byte[] key, byte[] member, double radius, GeoUnit unit, GeoRadiusParam param) {
        final byte[] bArr = key;
        final byte[] bArr2 = member;
        final double d = radius;
        final GeoUnit geoUnit = unit;
        final GeoRadiusParam geoRadiusParam = param;
        byte[] bArr3 = key;
        return (List) new JedisClusterCommand<List<GeoRadiusResponse>>(this.connectionHandler, this.maxAttempts) {
            public List<GeoRadiusResponse> execute(Jedis connection) {
                return connection.georadiusByMember(bArr, bArr2, d, geoUnit, geoRadiusParam);
            }
        }.runBinary(key);
    }

    public ScanResult<byte[]> scan(byte[] cursor, ScanParams params) {
        Class<BinaryJedisCluster> cls = BinaryJedisCluster.class;
        if (params != null) {
            String match = params.match();
            String matchPattern = match;
            if (match != null && !matchPattern.isEmpty()) {
                if (JedisClusterHashTagUtil.isClusterCompliantMatchPattern(matchPattern)) {
                    final byte[] bArr = cursor;
                    final ScanParams scanParams = params;
                    return (ScanResult) new JedisClusterCommand<ScanResult<byte[]>>(this.connectionHandler, this.maxAttempts) {
                        public ScanResult<byte[]> execute(Jedis connection) {
                            return connection.scan(bArr, scanParams);
                        }
                    }.runBinary(SafeEncoder.encode(matchPattern));
                }
                throw new IllegalArgumentException(String.valueOf(cls.getSimpleName()) + " only supports SCAN commands with MATCH patterns containing hash-tags ( curly-brackets enclosed strings )");
            }
        }
        throw new IllegalArgumentException(String.valueOf(cls.getSimpleName()) + " only supports SCAN commands with non-empty MATCH patterns");
    }

    public ScanResult<Map.Entry<byte[], byte[]>> hscan(byte[] key, byte[] cursor) {
        final byte[] bArr = key;
        final byte[] bArr2 = cursor;
        return (ScanResult) new JedisClusterCommand<ScanResult<Map.Entry<byte[], byte[]>>>(this.connectionHandler, this.maxAttempts) {
            public ScanResult<Map.Entry<byte[], byte[]>> execute(Jedis connection) {
                return connection.hscan(bArr, bArr2);
            }
        }.runBinary(key);
    }

    public ScanResult<Map.Entry<byte[], byte[]>> hscan(byte[] key, byte[] cursor, ScanParams params) {
        final byte[] bArr = key;
        final byte[] bArr2 = cursor;
        final ScanParams scanParams = params;
        return (ScanResult) new JedisClusterCommand<ScanResult<Map.Entry<byte[], byte[]>>>(this.connectionHandler, this.maxAttempts) {
            public ScanResult<Map.Entry<byte[], byte[]>> execute(Jedis connection) {
                return connection.hscan(bArr, bArr2, scanParams);
            }
        }.runBinary(key);
    }

    public ScanResult<byte[]> sscan(byte[] key, byte[] cursor) {
        final byte[] bArr = key;
        final byte[] bArr2 = cursor;
        return (ScanResult) new JedisClusterCommand<ScanResult<byte[]>>(this.connectionHandler, this.maxAttempts) {
            public ScanResult<byte[]> execute(Jedis connection) {
                return connection.sscan(bArr, bArr2);
            }
        }.runBinary(key);
    }

    public ScanResult<byte[]> sscan(byte[] key, byte[] cursor, ScanParams params) {
        final byte[] bArr = key;
        final byte[] bArr2 = cursor;
        final ScanParams scanParams = params;
        return (ScanResult) new JedisClusterCommand<ScanResult<byte[]>>(this.connectionHandler, this.maxAttempts) {
            public ScanResult<byte[]> execute(Jedis connection) {
                return connection.sscan(bArr, bArr2, scanParams);
            }
        }.runBinary(key);
    }

    public ScanResult<Tuple> zscan(byte[] key, byte[] cursor) {
        final byte[] bArr = key;
        final byte[] bArr2 = cursor;
        return (ScanResult) new JedisClusterCommand<ScanResult<Tuple>>(this.connectionHandler, this.maxAttempts) {
            public ScanResult<Tuple> execute(Jedis connection) {
                return connection.zscan(bArr, bArr2);
            }
        }.runBinary(key);
    }

    public ScanResult<Tuple> zscan(byte[] key, byte[] cursor, ScanParams params) {
        final byte[] bArr = key;
        final byte[] bArr2 = cursor;
        final ScanParams scanParams = params;
        return (ScanResult) new JedisClusterCommand<ScanResult<Tuple>>(this.connectionHandler, this.maxAttempts) {
            public ScanResult<Tuple> execute(Jedis connection) {
                return connection.zscan(bArr, bArr2, scanParams);
            }
        }.runBinary(key);
    }

    public List<Long> bitfield(byte[] key, byte[]... arguments) {
        final byte[] bArr = key;
        final byte[][] bArr2 = arguments;
        return (List) new JedisClusterCommand<List<Long>>(this.connectionHandler, this.maxAttempts) {
            public List<Long> execute(Jedis connection) {
                return connection.bitfield(bArr, bArr2);
            }
        }.runBinary(key);
    }

    public Long hstrlen(byte[] key, byte[] field) {
        final byte[] bArr = key;
        final byte[] bArr2 = field;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.hstrlen(bArr, bArr2);
            }
        }.runBinary(key);
    }
}
