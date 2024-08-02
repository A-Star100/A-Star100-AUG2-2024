package redis.clients.jedis;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.BinaryClient;
import redis.clients.jedis.commands.JedisClusterCommands;
import redis.clients.jedis.commands.JedisClusterScriptingCommands;
import redis.clients.jedis.commands.MultiKeyJedisClusterCommands;
import redis.clients.jedis.params.geo.GeoRadiusParam;
import redis.clients.jedis.params.set.SetParams;
import redis.clients.jedis.params.sortedset.ZAddParams;
import redis.clients.jedis.params.sortedset.ZIncrByParams;
import redis.clients.util.JedisClusterHashTagUtil;
import redis.clients.util.KeyMergeUtil;
import redis.clients.util.SafeEncoder;

public class JedisCluster extends BinaryJedisCluster implements JedisClusterCommands, MultiKeyJedisClusterCommands, JedisClusterScriptingCommands {

    public enum Reset {
        SOFT,
        HARD
    }

    public JedisCluster(HostAndPort node) {
        this((Set<HostAndPort>) Collections.singleton(node), (int) Protocol.DEFAULT_TIMEOUT);
    }

    public JedisCluster(HostAndPort node, int timeout) {
        this((Set<HostAndPort>) Collections.singleton(node), timeout, 5);
    }

    public JedisCluster(HostAndPort node, int timeout, int maxAttempts) {
        this((Set<HostAndPort>) Collections.singleton(node), timeout, maxAttempts, new GenericObjectPoolConfig());
    }

    public JedisCluster(HostAndPort node, GenericObjectPoolConfig poolConfig) {
        this((Set<HostAndPort>) Collections.singleton(node), (int) Protocol.DEFAULT_TIMEOUT, 5, poolConfig);
    }

    public JedisCluster(HostAndPort node, int timeout, GenericObjectPoolConfig poolConfig) {
        this((Set<HostAndPort>) Collections.singleton(node), timeout, 5, poolConfig);
    }

    public JedisCluster(HostAndPort node, int timeout, int maxAttempts, GenericObjectPoolConfig poolConfig) {
        this((Set<HostAndPort>) Collections.singleton(node), timeout, maxAttempts, poolConfig);
    }

    public JedisCluster(HostAndPort node, int connectionTimeout, int soTimeout, int maxAttempts, GenericObjectPoolConfig poolConfig) {
        super(Collections.singleton(node), connectionTimeout, soTimeout, maxAttempts, poolConfig);
    }

    public JedisCluster(HostAndPort node, int connectionTimeout, int soTimeout, int maxAttempts, String password, GenericObjectPoolConfig poolConfig) {
        super(Collections.singleton(node), connectionTimeout, soTimeout, maxAttempts, password, poolConfig);
    }

    public JedisCluster(HostAndPort node, int connectionTimeout, int soTimeout, int maxAttempts, String password, String clientName, GenericObjectPoolConfig poolConfig) {
        super(Collections.singleton(node), connectionTimeout, soTimeout, maxAttempts, password, clientName, poolConfig);
    }

    public JedisCluster(Set<HostAndPort> nodes) {
        this(nodes, (int) Protocol.DEFAULT_TIMEOUT);
    }

    public JedisCluster(Set<HostAndPort> nodes, int timeout) {
        this(nodes, timeout, 5);
    }

    public JedisCluster(Set<HostAndPort> nodes, int timeout, int maxAttempts) {
        this(nodes, timeout, maxAttempts, new GenericObjectPoolConfig());
    }

    public JedisCluster(Set<HostAndPort> nodes, GenericObjectPoolConfig poolConfig) {
        this(nodes, (int) Protocol.DEFAULT_TIMEOUT, 5, poolConfig);
    }

    public JedisCluster(Set<HostAndPort> nodes, int timeout, GenericObjectPoolConfig poolConfig) {
        this(nodes, timeout, 5, poolConfig);
    }

    public JedisCluster(Set<HostAndPort> jedisClusterNode, int timeout, int maxAttempts, GenericObjectPoolConfig poolConfig) {
        super(jedisClusterNode, timeout, maxAttempts, poolConfig);
    }

    public JedisCluster(Set<HostAndPort> jedisClusterNode, int connectionTimeout, int soTimeout, int maxAttempts, GenericObjectPoolConfig poolConfig) {
        super(jedisClusterNode, connectionTimeout, soTimeout, maxAttempts, poolConfig);
    }

    public JedisCluster(Set<HostAndPort> jedisClusterNode, int connectionTimeout, int soTimeout, int maxAttempts, String password, GenericObjectPoolConfig poolConfig) {
        super(jedisClusterNode, connectionTimeout, soTimeout, maxAttempts, password, poolConfig);
    }

    public JedisCluster(Set<HostAndPort> jedisClusterNode, int connectionTimeout, int soTimeout, int maxAttempts, String password, String clientName, GenericObjectPoolConfig poolConfig) {
        super(jedisClusterNode, connectionTimeout, soTimeout, maxAttempts, password, clientName, poolConfig);
    }

    public String set(String key, String value) {
        final String str = key;
        final String str2 = value;
        return (String) new JedisClusterCommand<String>(this.connectionHandler, this.maxAttempts) {
            public String execute(Jedis connection) {
                return connection.set(str, str2);
            }
        }.run(key);
    }

    public String set(String key, String value, SetParams params) {
        final String str = key;
        final String str2 = value;
        final SetParams setParams = params;
        return (String) new JedisClusterCommand<String>(this.connectionHandler, this.maxAttempts) {
            public String execute(Jedis connection) {
                return connection.set(str, str2, setParams);
            }
        }.run(key);
    }

    public String get(final String key) {
        return (String) new JedisClusterCommand<String>(this.connectionHandler, this.maxAttempts) {
            public String execute(Jedis connection) {
                return connection.get(key);
            }
        }.run(key);
    }

    public Boolean exists(final String key) {
        return (Boolean) new JedisClusterCommand<Boolean>(this.connectionHandler, this.maxAttempts) {
            public Boolean execute(Jedis connection) {
                return connection.exists(key);
            }
        }.run(key);
    }

    public Long exists(final String... keys) {
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.exists(keys);
            }
        }.run(keys.length, keys);
    }

    public Long persist(final String key) {
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.persist(key);
            }
        }.run(key);
    }

    public String type(final String key) {
        return (String) new JedisClusterCommand<String>(this.connectionHandler, this.maxAttempts) {
            public String execute(Jedis connection) {
                return connection.type(key);
            }
        }.run(key);
    }

    public Long expire(String key, int seconds) {
        final String str = key;
        final int i = seconds;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.expire(str, i);
            }
        }.run(key);
    }

    public Long pexpire(String key, long milliseconds) {
        final String str = key;
        final long j = milliseconds;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.pexpire(str, j);
            }
        }.run(key);
    }

    public Long expireAt(String key, long unixTime) {
        final String str = key;
        final long j = unixTime;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.expireAt(str, j);
            }
        }.run(key);
    }

    public Long pexpireAt(String key, long millisecondsTimestamp) {
        final String str = key;
        final long j = millisecondsTimestamp;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.pexpireAt(str, j);
            }
        }.run(key);
    }

    public Long ttl(final String key) {
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.ttl(key);
            }
        }.run(key);
    }

    public Boolean setbit(String key, long offset, boolean value) {
        final String str = key;
        final long j = offset;
        final boolean z = value;
        return (Boolean) new JedisClusterCommand<Boolean>(this.connectionHandler, this.maxAttempts) {
            public Boolean execute(Jedis connection) {
                return connection.setbit(str, j, z);
            }
        }.run(key);
    }

    public Boolean setbit(String key, long offset, String value) {
        final String str = key;
        final long j = offset;
        final String str2 = value;
        return (Boolean) new JedisClusterCommand<Boolean>(this.connectionHandler, this.maxAttempts) {
            public Boolean execute(Jedis connection) {
                return connection.setbit(str, j, str2);
            }
        }.run(key);
    }

    public Boolean getbit(String key, long offset) {
        final String str = key;
        final long j = offset;
        return (Boolean) new JedisClusterCommand<Boolean>(this.connectionHandler, this.maxAttempts) {
            public Boolean execute(Jedis connection) {
                return connection.getbit(str, j);
            }
        }.run(key);
    }

    public Long setrange(String key, long offset, String value) {
        final String str = key;
        final long j = offset;
        final String str2 = value;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.setrange(str, j, str2);
            }
        }.run(key);
    }

    public String getrange(String key, long startOffset, long endOffset) {
        final String str = key;
        final long j = startOffset;
        final long j2 = endOffset;
        return (String) new JedisClusterCommand<String>(this.connectionHandler, this.maxAttempts) {
            public String execute(Jedis connection) {
                return connection.getrange(str, j, j2);
            }
        }.run(key);
    }

    public String getSet(String key, String value) {
        final String str = key;
        final String str2 = value;
        return (String) new JedisClusterCommand<String>(this.connectionHandler, this.maxAttempts) {
            public String execute(Jedis connection) {
                return connection.getSet(str, str2);
            }
        }.run(key);
    }

    public Long setnx(String key, String value) {
        final String str = key;
        final String str2 = value;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.setnx(str, str2);
            }
        }.run(key);
    }

    public String setex(String key, int seconds, String value) {
        final String str = key;
        final int i = seconds;
        final String str2 = value;
        return (String) new JedisClusterCommand<String>(this.connectionHandler, this.maxAttempts) {
            public String execute(Jedis connection) {
                return connection.setex(str, i, str2);
            }
        }.run(key);
    }

    public Long decrBy(String key, long integer) {
        final String str = key;
        final long j = integer;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.decrBy(str, j);
            }
        }.run(key);
    }

    public Long decr(final String key) {
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.decr(key);
            }
        }.run(key);
    }

    public Long incrBy(String key, long integer) {
        final String str = key;
        final long j = integer;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.incrBy(str, j);
            }
        }.run(key);
    }

    public Double incrByFloat(String key, double value) {
        final String str = key;
        final double d = value;
        return (Double) new JedisClusterCommand<Double>(this.connectionHandler, this.maxAttempts) {
            public Double execute(Jedis connection) {
                return connection.incrByFloat(str, d);
            }
        }.run(key);
    }

    public Long incr(final String key) {
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.incr(key);
            }
        }.run(key);
    }

    public Long append(String key, String value) {
        final String str = key;
        final String str2 = value;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.append(str, str2);
            }
        }.run(key);
    }

    public String substr(String key, int start, int end) {
        final String str = key;
        final int i = start;
        final int i2 = end;
        return (String) new JedisClusterCommand<String>(this.connectionHandler, this.maxAttempts) {
            public String execute(Jedis connection) {
                return connection.substr(str, i, i2);
            }
        }.run(key);
    }

    public Long hset(String key, String field, String value) {
        final String str = key;
        final String str2 = field;
        final String str3 = value;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.hset(str, str2, str3);
            }
        }.run(key);
    }

    public String hget(String key, String field) {
        final String str = key;
        final String str2 = field;
        return (String) new JedisClusterCommand<String>(this.connectionHandler, this.maxAttempts) {
            public String execute(Jedis connection) {
                return connection.hget(str, str2);
            }
        }.run(key);
    }

    public Long hsetnx(String key, String field, String value) {
        final String str = key;
        final String str2 = field;
        final String str3 = value;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.hsetnx(str, str2, str3);
            }
        }.run(key);
    }

    public String hmset(String key, Map<String, String> hash) {
        final String str = key;
        final Map<String, String> map = hash;
        return (String) new JedisClusterCommand<String>(this.connectionHandler, this.maxAttempts) {
            public String execute(Jedis connection) {
                return connection.hmset(str, map);
            }
        }.run(key);
    }

    public List<String> hmget(String key, String... fields) {
        final String str = key;
        final String[] strArr = fields;
        return (List) new JedisClusterCommand<List<String>>(this.connectionHandler, this.maxAttempts) {
            public List<String> execute(Jedis connection) {
                return connection.hmget(str, strArr);
            }
        }.run(key);
    }

    public Long hincrBy(String key, String field, long value) {
        final String str = key;
        final String str2 = field;
        final long j = value;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.hincrBy(str, str2, j);
            }
        }.run(key);
    }

    public Boolean hexists(String key, String field) {
        final String str = key;
        final String str2 = field;
        return (Boolean) new JedisClusterCommand<Boolean>(this.connectionHandler, this.maxAttempts) {
            public Boolean execute(Jedis connection) {
                return connection.hexists(str, str2);
            }
        }.run(key);
    }

    public Long hdel(String key, String... field) {
        final String str = key;
        final String[] strArr = field;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.hdel(str, strArr);
            }
        }.run(key);
    }

    public Long hlen(final String key) {
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.hlen(key);
            }
        }.run(key);
    }

    public Set<String> hkeys(final String key) {
        return (Set) new JedisClusterCommand<Set<String>>(this.connectionHandler, this.maxAttempts) {
            public Set<String> execute(Jedis connection) {
                return connection.hkeys(key);
            }
        }.run(key);
    }

    public List<String> hvals(final String key) {
        return (List) new JedisClusterCommand<List<String>>(this.connectionHandler, this.maxAttempts) {
            public List<String> execute(Jedis connection) {
                return connection.hvals(key);
            }
        }.run(key);
    }

    public Map<String, String> hgetAll(final String key) {
        return (Map) new JedisClusterCommand<Map<String, String>>(this.connectionHandler, this.maxAttempts) {
            public Map<String, String> execute(Jedis connection) {
                return connection.hgetAll(key);
            }
        }.run(key);
    }

    public Long rpush(String key, String... string) {
        final String str = key;
        final String[] strArr = string;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.rpush(str, strArr);
            }
        }.run(key);
    }

    public Long lpush(String key, String... string) {
        final String str = key;
        final String[] strArr = string;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.lpush(str, strArr);
            }
        }.run(key);
    }

    public Long llen(final String key) {
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.llen(key);
            }
        }.run(key);
    }

    public List<String> lrange(String key, long start, long end) {
        final String str = key;
        final long j = start;
        final long j2 = end;
        return (List) new JedisClusterCommand<List<String>>(this.connectionHandler, this.maxAttempts) {
            public List<String> execute(Jedis connection) {
                return connection.lrange(str, j, j2);
            }
        }.run(key);
    }

    public String ltrim(String key, long start, long end) {
        final String str = key;
        final long j = start;
        final long j2 = end;
        return (String) new JedisClusterCommand<String>(this.connectionHandler, this.maxAttempts) {
            public String execute(Jedis connection) {
                return connection.ltrim(str, j, j2);
            }
        }.run(key);
    }

    public String lindex(String key, long index) {
        final String str = key;
        final long j = index;
        return (String) new JedisClusterCommand<String>(this.connectionHandler, this.maxAttempts) {
            public String execute(Jedis connection) {
                return connection.lindex(str, j);
            }
        }.run(key);
    }

    public String lset(String key, long index, String value) {
        final String str = key;
        final long j = index;
        final String str2 = value;
        return (String) new JedisClusterCommand<String>(this.connectionHandler, this.maxAttempts) {
            public String execute(Jedis connection) {
                return connection.lset(str, j, str2);
            }
        }.run(key);
    }

    public Long lrem(String key, long count, String value) {
        final String str = key;
        final long j = count;
        final String str2 = value;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.lrem(str, j, str2);
            }
        }.run(key);
    }

    public String lpop(final String key) {
        return (String) new JedisClusterCommand<String>(this.connectionHandler, this.maxAttempts) {
            public String execute(Jedis connection) {
                return connection.lpop(key);
            }
        }.run(key);
    }

    public String rpop(final String key) {
        return (String) new JedisClusterCommand<String>(this.connectionHandler, this.maxAttempts) {
            public String execute(Jedis connection) {
                return connection.rpop(key);
            }
        }.run(key);
    }

    public Long sadd(String key, String... member) {
        final String str = key;
        final String[] strArr = member;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.sadd(str, strArr);
            }
        }.run(key);
    }

    public Set<String> smembers(final String key) {
        return (Set) new JedisClusterCommand<Set<String>>(this.connectionHandler, this.maxAttempts) {
            public Set<String> execute(Jedis connection) {
                return connection.smembers(key);
            }
        }.run(key);
    }

    public Long srem(String key, String... member) {
        final String str = key;
        final String[] strArr = member;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.srem(str, strArr);
            }
        }.run(key);
    }

    public String spop(final String key) {
        return (String) new JedisClusterCommand<String>(this.connectionHandler, this.maxAttempts) {
            public String execute(Jedis connection) {
                return connection.spop(key);
            }
        }.run(key);
    }

    public Set<String> spop(String key, long count) {
        final String str = key;
        final long j = count;
        return (Set) new JedisClusterCommand<Set<String>>(this.connectionHandler, this.maxAttempts) {
            public Set<String> execute(Jedis connection) {
                return connection.spop(str, j);
            }
        }.run(key);
    }

    public Long scard(final String key) {
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.scard(key);
            }
        }.run(key);
    }

    public Boolean sismember(String key, String member) {
        final String str = key;
        final String str2 = member;
        return (Boolean) new JedisClusterCommand<Boolean>(this.connectionHandler, this.maxAttempts) {
            public Boolean execute(Jedis connection) {
                return connection.sismember(str, str2);
            }
        }.run(key);
    }

    public String srandmember(final String key) {
        return (String) new JedisClusterCommand<String>(this.connectionHandler, this.maxAttempts) {
            public String execute(Jedis connection) {
                return connection.srandmember(key);
            }
        }.run(key);
    }

    public List<String> srandmember(String key, int count) {
        final String str = key;
        final int i = count;
        return (List) new JedisClusterCommand<List<String>>(this.connectionHandler, this.maxAttempts) {
            public List<String> execute(Jedis connection) {
                return connection.srandmember(str, i);
            }
        }.run(key);
    }

    public Long strlen(final String key) {
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.strlen(key);
            }
        }.run(key);
    }

    public Long zadd(String key, double score, String member) {
        final String str = key;
        final double d = score;
        final String str2 = member;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.zadd(str, d, str2);
            }
        }.run(key);
    }

    public Long zadd(String key, double score, String member, ZAddParams params) {
        final String str = key;
        final double d = score;
        final String str2 = member;
        final ZAddParams zAddParams = params;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.zadd(str, d, str2, zAddParams);
            }
        }.run(key);
    }

    public Long zadd(String key, Map<String, Double> scoreMembers) {
        final String str = key;
        final Map<String, Double> map = scoreMembers;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.zadd(str, map);
            }
        }.run(key);
    }

    public Long zadd(String key, Map<String, Double> scoreMembers, ZAddParams params) {
        final String str = key;
        final Map<String, Double> map = scoreMembers;
        final ZAddParams zAddParams = params;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.zadd(str, (Map<String, Double>) map, zAddParams);
            }
        }.run(key);
    }

    public Set<String> zrange(String key, long start, long end) {
        final String str = key;
        final long j = start;
        final long j2 = end;
        return (Set) new JedisClusterCommand<Set<String>>(this.connectionHandler, this.maxAttempts) {
            public Set<String> execute(Jedis connection) {
                return connection.zrange(str, j, j2);
            }
        }.run(key);
    }

    public Long zrem(String key, String... member) {
        final String str = key;
        final String[] strArr = member;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.zrem(str, strArr);
            }
        }.run(key);
    }

    public Double zincrby(String key, double score, String member) {
        final String str = key;
        final double d = score;
        final String str2 = member;
        return (Double) new JedisClusterCommand<Double>(this.connectionHandler, this.maxAttempts) {
            public Double execute(Jedis connection) {
                return connection.zincrby(str, d, str2);
            }
        }.run(key);
    }

    public Double zincrby(String key, double score, String member, ZIncrByParams params) {
        final String str = key;
        final double d = score;
        final String str2 = member;
        final ZIncrByParams zIncrByParams = params;
        return (Double) new JedisClusterCommand<Double>(this.connectionHandler, this.maxAttempts) {
            public Double execute(Jedis connection) {
                return connection.zincrby(str, d, str2, zIncrByParams);
            }
        }.run(key);
    }

    public Long zrank(String key, String member) {
        final String str = key;
        final String str2 = member;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.zrank(str, str2);
            }
        }.run(key);
    }

    public Long zrevrank(String key, String member) {
        final String str = key;
        final String str2 = member;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.zrevrank(str, str2);
            }
        }.run(key);
    }

    public Set<String> zrevrange(String key, long start, long end) {
        final String str = key;
        final long j = start;
        final long j2 = end;
        return (Set) new JedisClusterCommand<Set<String>>(this.connectionHandler, this.maxAttempts) {
            public Set<String> execute(Jedis connection) {
                return connection.zrevrange(str, j, j2);
            }
        }.run(key);
    }

    public Set<Tuple> zrangeWithScores(String key, long start, long end) {
        final String str = key;
        final long j = start;
        final long j2 = end;
        return (Set) new JedisClusterCommand<Set<Tuple>>(this.connectionHandler, this.maxAttempts) {
            public Set<Tuple> execute(Jedis connection) {
                return connection.zrangeWithScores(str, j, j2);
            }
        }.run(key);
    }

    public Set<Tuple> zrevrangeWithScores(String key, long start, long end) {
        final String str = key;
        final long j = start;
        final long j2 = end;
        return (Set) new JedisClusterCommand<Set<Tuple>>(this.connectionHandler, this.maxAttempts) {
            public Set<Tuple> execute(Jedis connection) {
                return connection.zrevrangeWithScores(str, j, j2);
            }
        }.run(key);
    }

    public Long zcard(final String key) {
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.zcard(key);
            }
        }.run(key);
    }

    public Double zscore(String key, String member) {
        final String str = key;
        final String str2 = member;
        return (Double) new JedisClusterCommand<Double>(this.connectionHandler, this.maxAttempts) {
            public Double execute(Jedis connection) {
                return connection.zscore(str, str2);
            }
        }.run(key);
    }

    public List<String> sort(final String key) {
        return (List) new JedisClusterCommand<List<String>>(this.connectionHandler, this.maxAttempts) {
            public List<String> execute(Jedis connection) {
                return connection.sort(key);
            }
        }.run(key);
    }

    public List<String> sort(String key, SortingParams sortingParameters) {
        final String str = key;
        final SortingParams sortingParams = sortingParameters;
        return (List) new JedisClusterCommand<List<String>>(this.connectionHandler, this.maxAttempts) {
            public List<String> execute(Jedis connection) {
                return connection.sort(str, sortingParams);
            }
        }.run(key);
    }

    public Long zcount(String key, double min, double max) {
        final String str = key;
        final double d = min;
        final double d2 = max;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.zcount(str, d, d2);
            }
        }.run(key);
    }

    public Long zcount(String key, String min, String max) {
        final String str = key;
        final String str2 = min;
        final String str3 = max;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.zcount(str, str2, str3);
            }
        }.run(key);
    }

    public Set<String> zrangeByScore(String key, double min, double max) {
        final String str = key;
        final double d = min;
        final double d2 = max;
        return (Set) new JedisClusterCommand<Set<String>>(this.connectionHandler, this.maxAttempts) {
            public Set<String> execute(Jedis connection) {
                return connection.zrangeByScore(str, d, d2);
            }
        }.run(key);
    }

    public Set<String> zrangeByScore(String key, String min, String max) {
        final String str = key;
        final String str2 = min;
        final String str3 = max;
        return (Set) new JedisClusterCommand<Set<String>>(this.connectionHandler, this.maxAttempts) {
            public Set<String> execute(Jedis connection) {
                return connection.zrangeByScore(str, str2, str3);
            }
        }.run(key);
    }

    public Set<String> zrevrangeByScore(String key, double max, double min) {
        final String str = key;
        final double d = max;
        final double d2 = min;
        return (Set) new JedisClusterCommand<Set<String>>(this.connectionHandler, this.maxAttempts) {
            public Set<String> execute(Jedis connection) {
                return connection.zrevrangeByScore(str, d, d2);
            }
        }.run(key);
    }

    public Set<String> zrangeByScore(String key, double min, double max, int offset, int count) {
        final String str = key;
        final double d = min;
        final double d2 = max;
        final int i = offset;
        final int i2 = count;
        String str2 = key;
        return (Set) new JedisClusterCommand<Set<String>>(this.connectionHandler, this.maxAttempts) {
            public Set<String> execute(Jedis connection) {
                return connection.zrangeByScore(str, d, d2, i, i2);
            }
        }.run(key);
    }

    public Set<String> zrevrangeByScore(String key, String max, String min) {
        final String str = key;
        final String str2 = max;
        final String str3 = min;
        return (Set) new JedisClusterCommand<Set<String>>(this.connectionHandler, this.maxAttempts) {
            public Set<String> execute(Jedis connection) {
                return connection.zrevrangeByScore(str, str2, str3);
            }
        }.run(key);
    }

    public Set<String> zrangeByScore(String key, String min, String max, int offset, int count) {
        final String str = key;
        final String str2 = min;
        final String str3 = max;
        final int i = offset;
        final int i2 = count;
        return (Set) new JedisClusterCommand<Set<String>>(this.connectionHandler, this.maxAttempts) {
            public Set<String> execute(Jedis connection) {
                return connection.zrangeByScore(str, str2, str3, i, i2);
            }
        }.run(key);
    }

    public Set<String> zrevrangeByScore(String key, double max, double min, int offset, int count) {
        final String str = key;
        final double d = max;
        final double d2 = min;
        final int i = offset;
        final int i2 = count;
        String str2 = key;
        return (Set) new JedisClusterCommand<Set<String>>(this.connectionHandler, this.maxAttempts) {
            public Set<String> execute(Jedis connection) {
                return connection.zrevrangeByScore(str, d, d2, i, i2);
            }
        }.run(key);
    }

    public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max) {
        final String str = key;
        final double d = min;
        final double d2 = max;
        return (Set) new JedisClusterCommand<Set<Tuple>>(this.connectionHandler, this.maxAttempts) {
            public Set<Tuple> execute(Jedis connection) {
                return connection.zrangeByScoreWithScores(str, d, d2);
            }
        }.run(key);
    }

    public Set<Tuple> zrevrangeByScoreWithScores(String key, double max, double min) {
        final String str = key;
        final double d = max;
        final double d2 = min;
        return (Set) new JedisClusterCommand<Set<Tuple>>(this.connectionHandler, this.maxAttempts) {
            public Set<Tuple> execute(Jedis connection) {
                return connection.zrevrangeByScoreWithScores(str, d, d2);
            }
        }.run(key);
    }

    public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max, int offset, int count) {
        final String str = key;
        final double d = min;
        final double d2 = max;
        final int i = offset;
        final int i2 = count;
        String str2 = key;
        return (Set) new JedisClusterCommand<Set<Tuple>>(this.connectionHandler, this.maxAttempts) {
            public Set<Tuple> execute(Jedis connection) {
                return connection.zrangeByScoreWithScores(str, d, d2, i, i2);
            }
        }.run(key);
    }

    public Set<String> zrevrangeByScore(String key, String max, String min, int offset, int count) {
        final String str = key;
        final String str2 = max;
        final String str3 = min;
        final int i = offset;
        final int i2 = count;
        return (Set) new JedisClusterCommand<Set<String>>(this.connectionHandler, this.maxAttempts) {
            public Set<String> execute(Jedis connection) {
                return connection.zrevrangeByScore(str, str2, str3, i, i2);
            }
        }.run(key);
    }

    public Set<Tuple> zrangeByScoreWithScores(String key, String min, String max) {
        final String str = key;
        final String str2 = min;
        final String str3 = max;
        return (Set) new JedisClusterCommand<Set<Tuple>>(this.connectionHandler, this.maxAttempts) {
            public Set<Tuple> execute(Jedis connection) {
                return connection.zrangeByScoreWithScores(str, str2, str3);
            }
        }.run(key);
    }

    public Set<Tuple> zrevrangeByScoreWithScores(String key, String max, String min) {
        final String str = key;
        final String str2 = max;
        final String str3 = min;
        return (Set) new JedisClusterCommand<Set<Tuple>>(this.connectionHandler, this.maxAttempts) {
            public Set<Tuple> execute(Jedis connection) {
                return connection.zrevrangeByScoreWithScores(str, str2, str3);
            }
        }.run(key);
    }

    public Set<Tuple> zrangeByScoreWithScores(String key, String min, String max, int offset, int count) {
        final String str = key;
        final String str2 = min;
        final String str3 = max;
        final int i = offset;
        final int i2 = count;
        return (Set) new JedisClusterCommand<Set<Tuple>>(this.connectionHandler, this.maxAttempts) {
            public Set<Tuple> execute(Jedis connection) {
                return connection.zrangeByScoreWithScores(str, str2, str3, i, i2);
            }
        }.run(key);
    }

    public Set<Tuple> zrevrangeByScoreWithScores(String key, double max, double min, int offset, int count) {
        final String str = key;
        final double d = max;
        final double d2 = min;
        final int i = offset;
        final int i2 = count;
        String str2 = key;
        return (Set) new JedisClusterCommand<Set<Tuple>>(this.connectionHandler, this.maxAttempts) {
            public Set<Tuple> execute(Jedis connection) {
                return connection.zrevrangeByScoreWithScores(str, d, d2, i, i2);
            }
        }.run(key);
    }

    public Set<Tuple> zrevrangeByScoreWithScores(String key, String max, String min, int offset, int count) {
        final String str = key;
        final String str2 = max;
        final String str3 = min;
        final int i = offset;
        final int i2 = count;
        return (Set) new JedisClusterCommand<Set<Tuple>>(this.connectionHandler, this.maxAttempts) {
            public Set<Tuple> execute(Jedis connection) {
                return connection.zrevrangeByScoreWithScores(str, str2, str3, i, i2);
            }
        }.run(key);
    }

    public Long zremrangeByRank(String key, long start, long end) {
        final String str = key;
        final long j = start;
        final long j2 = end;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.zremrangeByRank(str, j, j2);
            }
        }.run(key);
    }

    public Long zremrangeByScore(String key, double start, double end) {
        final String str = key;
        final double d = start;
        final double d2 = end;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.zremrangeByScore(str, d, d2);
            }
        }.run(key);
    }

    public Long zremrangeByScore(String key, String start, String end) {
        final String str = key;
        final String str2 = start;
        final String str3 = end;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.zremrangeByScore(str, str2, str3);
            }
        }.run(key);
    }

    public Long zlexcount(String key, String min, String max) {
        final String str = key;
        final String str2 = min;
        final String str3 = max;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.zlexcount(str, str2, str3);
            }
        }.run(key);
    }

    public Set<String> zrangeByLex(String key, String min, String max) {
        final String str = key;
        final String str2 = min;
        final String str3 = max;
        return (Set) new JedisClusterCommand<Set<String>>(this.connectionHandler, this.maxAttempts) {
            public Set<String> execute(Jedis connection) {
                return connection.zrangeByLex(str, str2, str3);
            }
        }.run(key);
    }

    public Set<String> zrangeByLex(String key, String min, String max, int offset, int count) {
        final String str = key;
        final String str2 = min;
        final String str3 = max;
        final int i = offset;
        final int i2 = count;
        return (Set) new JedisClusterCommand<Set<String>>(this.connectionHandler, this.maxAttempts) {
            public Set<String> execute(Jedis connection) {
                return connection.zrangeByLex(str, str2, str3, i, i2);
            }
        }.run(key);
    }

    public Set<String> zrevrangeByLex(String key, String max, String min) {
        final String str = key;
        final String str2 = max;
        final String str3 = min;
        return (Set) new JedisClusterCommand<Set<String>>(this.connectionHandler, this.maxAttempts) {
            public Set<String> execute(Jedis connection) {
                return connection.zrevrangeByLex(str, str2, str3);
            }
        }.run(key);
    }

    public Set<String> zrevrangeByLex(String key, String max, String min, int offset, int count) {
        final String str = key;
        final String str2 = max;
        final String str3 = min;
        final int i = offset;
        final int i2 = count;
        return (Set) new JedisClusterCommand<Set<String>>(this.connectionHandler, this.maxAttempts) {
            public Set<String> execute(Jedis connection) {
                return connection.zrevrangeByLex(str, str2, str3, i, i2);
            }
        }.run(key);
    }

    public Long zremrangeByLex(String key, String min, String max) {
        final String str = key;
        final String str2 = min;
        final String str3 = max;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.zremrangeByLex(str, str2, str3);
            }
        }.run(key);
    }

    public Long linsert(String key, BinaryClient.LIST_POSITION where, String pivot, String value) {
        final String str = key;
        final BinaryClient.LIST_POSITION list_position = where;
        final String str2 = pivot;
        final String str3 = value;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.linsert(str, list_position, str2, str3);
            }
        }.run(key);
    }

    public Long lpushx(String key, String... string) {
        final String str = key;
        final String[] strArr = string;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.lpushx(str, strArr);
            }
        }.run(key);
    }

    public Long rpushx(String key, String... string) {
        final String str = key;
        final String[] strArr = string;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.rpushx(str, strArr);
            }
        }.run(key);
    }

    public Long del(final String key) {
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.del(key);
            }
        }.run(key);
    }

    public String echo(final String string) {
        return (String) new JedisClusterCommand<String>(this.connectionHandler, this.maxAttempts) {
            public String execute(Jedis connection) {
                return connection.echo(string);
            }
        }.run(string);
    }

    public Long bitcount(final String key) {
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.bitcount(key);
            }
        }.run(key);
    }

    public Long bitcount(String key, long start, long end) {
        final String str = key;
        final long j = start;
        final long j2 = end;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.bitcount(str, j, j2);
            }
        }.run(key);
    }

    public ScanResult<String> scan(String cursor, ScanParams params) {
        Class<JedisCluster> cls = JedisCluster.class;
        if (params != null) {
            String match = params.match();
            String matchPattern = match;
            if (match != null && !matchPattern.isEmpty()) {
                if (JedisClusterHashTagUtil.isClusterCompliantMatchPattern(matchPattern)) {
                    final String str = cursor;
                    final ScanParams scanParams = params;
                    return (ScanResult) new JedisClusterCommand<ScanResult<String>>(this.connectionHandler, this.maxAttempts) {
                        public ScanResult<String> execute(Jedis connection) {
                            return connection.scan(str, scanParams);
                        }
                    }.runBinary(SafeEncoder.encode(matchPattern));
                }
                throw new IllegalArgumentException(String.valueOf(cls.getSimpleName()) + " only supports SCAN commands with MATCH patterns containing hash-tags ( curly-brackets enclosed strings )");
            }
        }
        throw new IllegalArgumentException(String.valueOf(cls.getSimpleName()) + " only supports SCAN commands with non-empty MATCH patterns");
    }

    public ScanResult<Map.Entry<String, String>> hscan(String key, String cursor) {
        final String str = key;
        final String str2 = cursor;
        return (ScanResult) new JedisClusterCommand<ScanResult<Map.Entry<String, String>>>(this.connectionHandler, this.maxAttempts) {
            public ScanResult<Map.Entry<String, String>> execute(Jedis connection) {
                return connection.hscan(str, str2);
            }
        }.run(key);
    }

    public ScanResult<String> sscan(String key, String cursor) {
        final String str = key;
        final String str2 = cursor;
        return (ScanResult) new JedisClusterCommand<ScanResult<String>>(this.connectionHandler, this.maxAttempts) {
            public ScanResult<String> execute(Jedis connection) {
                return connection.sscan(str, str2);
            }
        }.run(key);
    }

    public ScanResult<Tuple> zscan(String key, String cursor) {
        final String str = key;
        final String str2 = cursor;
        return (ScanResult) new JedisClusterCommand<ScanResult<Tuple>>(this.connectionHandler, this.maxAttempts) {
            public ScanResult<Tuple> execute(Jedis connection) {
                return connection.zscan(str, str2);
            }
        }.run(key);
    }

    public Long pfadd(String key, String... elements) {
        final String str = key;
        final String[] strArr = elements;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.pfadd(str, strArr);
            }
        }.run(key);
    }

    public long pfcount(final String key) {
        return ((Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return Long.valueOf(connection.pfcount(key));
            }
        }.run(key)).longValue();
    }

    public List<String> blpop(int timeout, String key) {
        final int i = timeout;
        final String str = key;
        return (List) new JedisClusterCommand<List<String>>(this.connectionHandler, this.maxAttempts) {
            public List<String> execute(Jedis connection) {
                return connection.blpop(i, str);
            }
        }.run(key);
    }

    public List<String> brpop(int timeout, String key) {
        final int i = timeout;
        final String str = key;
        return (List) new JedisClusterCommand<List<String>>(this.connectionHandler, this.maxAttempts) {
            public List<String> execute(Jedis connection) {
                return connection.brpop(i, str);
            }
        }.run(key);
    }

    public Long del(final String... keys) {
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.del(keys);
            }
        }.run(keys.length, keys);
    }

    public List<String> blpop(int timeout, String... keys) {
        final int i = timeout;
        final String[] strArr = keys;
        return (List) new JedisClusterCommand<List<String>>(this.connectionHandler, this.maxAttempts) {
            public List<String> execute(Jedis connection) {
                return connection.blpop(i, strArr);
            }
        }.run(keys.length, keys);
    }

    public List<String> brpop(int timeout, String... keys) {
        final int i = timeout;
        final String[] strArr = keys;
        return (List) new JedisClusterCommand<List<String>>(this.connectionHandler, this.maxAttempts) {
            public List<String> execute(Jedis connection) {
                return connection.brpop(i, strArr);
            }
        }.run(keys.length, keys);
    }

    public List<String> mget(final String... keys) {
        return (List) new JedisClusterCommand<List<String>>(this.connectionHandler, this.maxAttempts) {
            public List<String> execute(Jedis connection) {
                return connection.mget(keys);
            }
        }.run(keys.length, keys);
    }

    public String mset(final String... keysvalues) {
        String[] keys = new String[(keysvalues.length / 2)];
        for (int keyIdx = 0; keyIdx < keys.length; keyIdx++) {
            keys[keyIdx] = keysvalues[keyIdx * 2];
        }
        return (String) new JedisClusterCommand<String>(this.connectionHandler, this.maxAttempts) {
            public String execute(Jedis connection) {
                return connection.mset(keysvalues);
            }
        }.run(keys.length, keys);
    }

    public Long msetnx(final String... keysvalues) {
        String[] keys = new String[(keysvalues.length / 2)];
        for (int keyIdx = 0; keyIdx < keys.length; keyIdx++) {
            keys[keyIdx] = keysvalues[keyIdx * 2];
        }
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.msetnx(keysvalues);
            }
        }.run(keys.length, keys);
    }

    public String rename(String oldkey, String newkey) {
        final String str = oldkey;
        final String str2 = newkey;
        return (String) new JedisClusterCommand<String>(this.connectionHandler, this.maxAttempts) {
            public String execute(Jedis connection) {
                return connection.rename(str, str2);
            }
        }.run(2, oldkey, newkey);
    }

    public Long renamenx(String oldkey, String newkey) {
        final String str = oldkey;
        final String str2 = newkey;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.renamenx(str, str2);
            }
        }.run(2, oldkey, newkey);
    }

    public String rpoplpush(String srckey, String dstkey) {
        final String str = srckey;
        final String str2 = dstkey;
        return (String) new JedisClusterCommand<String>(this.connectionHandler, this.maxAttempts) {
            public String execute(Jedis connection) {
                return connection.rpoplpush(str, str2);
            }
        }.run(2, srckey, dstkey);
    }

    public Set<String> sdiff(final String... keys) {
        return (Set) new JedisClusterCommand<Set<String>>(this.connectionHandler, this.maxAttempts) {
            public Set<String> execute(Jedis connection) {
                return connection.sdiff(keys);
            }
        }.run(keys.length, keys);
    }

    public Long sdiffstore(String dstkey, String... keys) {
        String[] mergedKeys = KeyMergeUtil.merge(dstkey, keys);
        final String str = dstkey;
        final String[] strArr = keys;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.sdiffstore(str, strArr);
            }
        }.run(mergedKeys.length, mergedKeys);
    }

    public Set<String> sinter(final String... keys) {
        return (Set) new JedisClusterCommand<Set<String>>(this.connectionHandler, this.maxAttempts) {
            public Set<String> execute(Jedis connection) {
                return connection.sinter(keys);
            }
        }.run(keys.length, keys);
    }

    public Long sinterstore(String dstkey, String... keys) {
        String[] mergedKeys = KeyMergeUtil.merge(dstkey, keys);
        final String str = dstkey;
        final String[] strArr = keys;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.sinterstore(str, strArr);
            }
        }.run(mergedKeys.length, mergedKeys);
    }

    public Long smove(String srckey, String dstkey, String member) {
        final String str = srckey;
        final String str2 = dstkey;
        final String str3 = member;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.smove(str, str2, str3);
            }
        }.run(2, srckey, dstkey);
    }

    public Long sort(String key, SortingParams sortingParameters, String dstkey) {
        final String str = key;
        final SortingParams sortingParams = sortingParameters;
        final String str2 = dstkey;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.sort(str, sortingParams, str2);
            }
        }.run(2, key, dstkey);
    }

    public Long sort(String key, String dstkey) {
        final String str = key;
        final String str2 = dstkey;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.sort(str, str2);
            }
        }.run(2, key, dstkey);
    }

    public Set<String> sunion(final String... keys) {
        return (Set) new JedisClusterCommand<Set<String>>(this.connectionHandler, this.maxAttempts) {
            public Set<String> execute(Jedis connection) {
                return connection.sunion(keys);
            }
        }.run(keys.length, keys);
    }

    public Long sunionstore(String dstkey, String... keys) {
        String[] wholeKeys = KeyMergeUtil.merge(dstkey, keys);
        final String str = dstkey;
        final String[] strArr = keys;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.sunionstore(str, strArr);
            }
        }.run(wholeKeys.length, wholeKeys);
    }

    public Long zinterstore(String dstkey, String... sets) {
        String[] wholeKeys = KeyMergeUtil.merge(dstkey, sets);
        final String str = dstkey;
        final String[] strArr = sets;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.zinterstore(str, strArr);
            }
        }.run(wholeKeys.length, wholeKeys);
    }

    public Long zinterstore(String dstkey, ZParams params, String... sets) {
        String[] mergedKeys = KeyMergeUtil.merge(dstkey, sets);
        final String str = dstkey;
        final ZParams zParams = params;
        final String[] strArr = sets;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.zinterstore(str, zParams, strArr);
            }
        }.run(mergedKeys.length, mergedKeys);
    }

    public Long zunionstore(String dstkey, String... sets) {
        String[] mergedKeys = KeyMergeUtil.merge(dstkey, sets);
        final String str = dstkey;
        final String[] strArr = sets;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.zunionstore(str, strArr);
            }
        }.run(mergedKeys.length, mergedKeys);
    }

    public Long zunionstore(String dstkey, ZParams params, String... sets) {
        String[] mergedKeys = KeyMergeUtil.merge(dstkey, sets);
        final String str = dstkey;
        final ZParams zParams = params;
        final String[] strArr = sets;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.zunionstore(str, zParams, strArr);
            }
        }.run(mergedKeys.length, mergedKeys);
    }

    public String brpoplpush(String source, String destination, int timeout) {
        final String str = source;
        final String str2 = destination;
        final int i = timeout;
        return (String) new JedisClusterCommand<String>(this.connectionHandler, this.maxAttempts) {
            public String execute(Jedis connection) {
                return connection.brpoplpush(str, str2, i);
            }
        }.run(2, source, destination);
    }

    public Long publish(String channel, String message) {
        final String str = channel;
        final String str2 = message;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.publish(str, str2);
            }
        }.runWithAnyNode();
    }

    public void subscribe(JedisPubSub jedisPubSub, String... channels) {
        final JedisPubSub jedisPubSub2 = jedisPubSub;
        final String[] strArr = channels;
        new JedisClusterCommand<Integer>(this.connectionHandler, this.maxAttempts) {
            public Integer execute(Jedis connection) {
                connection.subscribe(jedisPubSub2, strArr);
                return 0;
            }
        }.runWithAnyNode();
    }

    public void psubscribe(JedisPubSub jedisPubSub, String... patterns) {
        final JedisPubSub jedisPubSub2 = jedisPubSub;
        final String[] strArr = patterns;
        new JedisClusterCommand<Integer>(this.connectionHandler, this.maxAttempts) {
            public Integer execute(Jedis connection) {
                connection.psubscribe(jedisPubSub2, strArr);
                return 0;
            }
        }.runWithAnyNode();
    }

    public Long bitop(BitOP op, String destKey, String... srcKeys) {
        String[] mergedKeys = KeyMergeUtil.merge(destKey, srcKeys);
        final BitOP bitOP = op;
        final String str = destKey;
        final String[] strArr = srcKeys;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.bitop(bitOP, str, strArr);
            }
        }.run(mergedKeys.length, mergedKeys);
    }

    public String pfmerge(String destkey, String... sourcekeys) {
        String[] mergedKeys = KeyMergeUtil.merge(destkey, sourcekeys);
        final String str = destkey;
        final String[] strArr = sourcekeys;
        return (String) new JedisClusterCommand<String>(this.connectionHandler, this.maxAttempts) {
            public String execute(Jedis connection) {
                return connection.pfmerge(str, strArr);
            }
        }.run(mergedKeys.length, mergedKeys);
    }

    public long pfcount(final String... keys) {
        return ((Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return Long.valueOf(connection.pfcount(keys));
            }
        }.run(keys.length, keys)).longValue();
    }

    public Object eval(String script, int keyCount, String... params) {
        final String str = script;
        final int i = keyCount;
        final String[] strArr = params;
        return new JedisClusterCommand<Object>(this.connectionHandler, this.maxAttempts) {
            public Object execute(Jedis connection) {
                return connection.eval(str, i, strArr);
            }
        }.run(keyCount, params);
    }

    public Object eval(final String script, String key) {
        return new JedisClusterCommand<Object>(this.connectionHandler, this.maxAttempts) {
            public Object execute(Jedis connection) {
                return connection.eval(script);
            }
        }.run(key);
    }

    public Object eval(String script, List<String> keys, List<String> args) {
        final String str = script;
        final List<String> list = keys;
        final List<String> list2 = args;
        return new JedisClusterCommand<Object>(this.connectionHandler, this.maxAttempts) {
            public Object execute(Jedis connection) {
                return connection.eval(str, (List<String>) list, (List<String>) list2);
            }
        }.run(keys.size(), (String[]) keys.toArray(new String[keys.size()]));
    }

    public Object evalsha(String sha1, int keyCount, String... params) {
        final String str = sha1;
        final int i = keyCount;
        final String[] strArr = params;
        return new JedisClusterCommand<Object>(this.connectionHandler, this.maxAttempts) {
            public Object execute(Jedis connection) {
                return connection.evalsha(str, i, strArr);
            }
        }.run(keyCount, params);
    }

    public Object evalsha(String sha1, List<String> keys, List<String> args) {
        final String str = sha1;
        final List<String> list = keys;
        final List<String> list2 = args;
        return new JedisClusterCommand<Object>(this.connectionHandler, this.maxAttempts) {
            public Object execute(Jedis connection) {
                return connection.evalsha(str, (List<String>) list, (List<String>) list2);
            }
        }.run(keys.size(), (String[]) keys.toArray(new String[keys.size()]));
    }

    public Object evalsha(final String script, String key) {
        return new JedisClusterCommand<Object>(this.connectionHandler, this.maxAttempts) {
            public Object execute(Jedis connection) {
                return connection.evalsha(script);
            }
        }.run(key);
    }

    public Boolean scriptExists(final String sha1, String key) {
        return (Boolean) new JedisClusterCommand<Boolean>(this.connectionHandler, this.maxAttempts) {
            public Boolean execute(Jedis connection) {
                return connection.scriptExists(sha1);
            }
        }.run(key);
    }

    public List<Boolean> scriptExists(String key, final String... sha1) {
        return (List) new JedisClusterCommand<List<Boolean>>(this.connectionHandler, this.maxAttempts) {
            public List<Boolean> execute(Jedis connection) {
                return connection.scriptExists(sha1);
            }
        }.run(key);
    }

    public String scriptLoad(final String script, String key) {
        return (String) new JedisClusterCommand<String>(this.connectionHandler, this.maxAttempts) {
            public String execute(Jedis connection) {
                return connection.scriptLoad(script);
            }
        }.run(key);
    }

    public Long geoadd(String key, double longitude, double latitude, String member) {
        final String str = key;
        final double d = longitude;
        final double d2 = latitude;
        final String str2 = member;
        String str3 = key;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.geoadd(str, d, d2, str2);
            }
        }.run(key);
    }

    public Long geoadd(String key, Map<String, GeoCoordinate> memberCoordinateMap) {
        final String str = key;
        final Map<String, GeoCoordinate> map = memberCoordinateMap;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.geoadd(str, map);
            }
        }.run(key);
    }

    public Double geodist(String key, String member1, String member2) {
        final String str = key;
        final String str2 = member1;
        final String str3 = member2;
        return (Double) new JedisClusterCommand<Double>(this.connectionHandler, this.maxAttempts) {
            public Double execute(Jedis connection) {
                return connection.geodist(str, str2, str3);
            }
        }.run(key);
    }

    public Double geodist(String key, String member1, String member2, GeoUnit unit) {
        final String str = key;
        final String str2 = member1;
        final String str3 = member2;
        final GeoUnit geoUnit = unit;
        return (Double) new JedisClusterCommand<Double>(this.connectionHandler, this.maxAttempts) {
            public Double execute(Jedis connection) {
                return connection.geodist(str, str2, str3, geoUnit);
            }
        }.run(key);
    }

    public List<String> geohash(String key, String... members) {
        final String str = key;
        final String[] strArr = members;
        return (List) new JedisClusterCommand<List<String>>(this.connectionHandler, this.maxAttempts) {
            public List<String> execute(Jedis connection) {
                return connection.geohash(str, strArr);
            }
        }.run(key);
    }

    public List<GeoCoordinate> geopos(String key, String... members) {
        final String str = key;
        final String[] strArr = members;
        return (List) new JedisClusterCommand<List<GeoCoordinate>>(this.connectionHandler, this.maxAttempts) {
            public List<GeoCoordinate> execute(Jedis connection) {
                return connection.geopos(str, strArr);
            }
        }.run(key);
    }

    public List<GeoRadiusResponse> georadius(String key, double longitude, double latitude, double radius, GeoUnit unit) {
        final String str = key;
        final double d = longitude;
        final double d2 = latitude;
        final double d3 = radius;
        final GeoUnit geoUnit = unit;
        String str2 = key;
        return (List) new JedisClusterCommand<List<GeoRadiusResponse>>(this.connectionHandler, this.maxAttempts) {
            public List<GeoRadiusResponse> execute(Jedis connection) {
                return connection.georadius(str, d, d2, d3, geoUnit);
            }
        }.run(key);
    }

    public List<GeoRadiusResponse> georadius(String key, double longitude, double latitude, double radius, GeoUnit unit, GeoRadiusParam param) {
        final String str = key;
        final double d = longitude;
        final double d2 = latitude;
        final double d3 = radius;
        final GeoUnit geoUnit = unit;
        final GeoRadiusParam geoRadiusParam = param;
        return (List) new JedisClusterCommand<List<GeoRadiusResponse>>(this.connectionHandler, this.maxAttempts) {
            public List<GeoRadiusResponse> execute(Jedis connection) {
                return connection.georadius(str, d, d2, d3, geoUnit, geoRadiusParam);
            }
        }.run(key);
    }

    public List<GeoRadiusResponse> georadiusByMember(String key, String member, double radius, GeoUnit unit) {
        final String str = key;
        final String str2 = member;
        final double d = radius;
        final GeoUnit geoUnit = unit;
        return (List) new JedisClusterCommand<List<GeoRadiusResponse>>(this.connectionHandler, this.maxAttempts) {
            public List<GeoRadiusResponse> execute(Jedis connection) {
                return connection.georadiusByMember(str, str2, d, geoUnit);
            }
        }.run(key);
    }

    public List<GeoRadiusResponse> georadiusByMember(String key, String member, double radius, GeoUnit unit, GeoRadiusParam param) {
        final String str = key;
        final String str2 = member;
        final double d = radius;
        final GeoUnit geoUnit = unit;
        final GeoRadiusParam geoRadiusParam = param;
        String str3 = key;
        return (List) new JedisClusterCommand<List<GeoRadiusResponse>>(this.connectionHandler, this.maxAttempts) {
            public List<GeoRadiusResponse> execute(Jedis connection) {
                return connection.georadiusByMember(str, str2, d, geoUnit, geoRadiusParam);
            }
        }.run(key);
    }

    public List<Long> bitfield(String key, String... arguments) {
        final String str = key;
        final String[] strArr = arguments;
        return (List) new JedisClusterCommand<List<Long>>(this.connectionHandler, this.maxAttempts) {
            public List<Long> execute(Jedis connection) {
                return connection.bitfield(str, strArr);
            }
        }.run(key);
    }

    public Long hstrlen(String key, String field) {
        final String str = key;
        final String str2 = field;
        return (Long) new JedisClusterCommand<Long>(this.connectionHandler, this.maxAttempts) {
            public Long execute(Jedis connection) {
                return connection.hstrlen(str, str2);
            }
        }.run(key);
    }
}
