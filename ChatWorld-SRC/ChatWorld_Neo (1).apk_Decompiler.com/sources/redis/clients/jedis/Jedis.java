package redis.clients.jedis;

import java.net.URI;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocketFactory;
import redis.clients.jedis.BinaryClient;
import redis.clients.jedis.BinaryJedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.Protocol;
import redis.clients.jedis.commands.AdvancedJedisCommands;
import redis.clients.jedis.commands.BasicCommands;
import redis.clients.jedis.commands.ClusterCommands;
import redis.clients.jedis.commands.JedisCommands;
import redis.clients.jedis.commands.ModuleCommands;
import redis.clients.jedis.commands.MultiKeyCommands;
import redis.clients.jedis.commands.ProtocolCommand;
import redis.clients.jedis.commands.ScriptingCommands;
import redis.clients.jedis.commands.SentinelCommands;
import redis.clients.jedis.params.geo.GeoRadiusParam;
import redis.clients.jedis.params.set.SetParams;
import redis.clients.jedis.params.sortedset.ZAddParams;
import redis.clients.jedis.params.sortedset.ZIncrByParams;
import redis.clients.util.SafeEncoder;
import redis.clients.util.Slowlog;

public class Jedis extends BinaryJedis implements JedisCommands, MultiKeyCommands, AdvancedJedisCommands, ScriptingCommands, BasicCommands, ClusterCommands, SentinelCommands, ModuleCommands {
    protected JedisPoolAbstract dataSource = null;

    public Jedis() {
    }

    public Jedis(String host) {
        super(host);
    }

    public Jedis(String host, int port) {
        super(host, port);
    }

    public Jedis(String host, int port, boolean ssl) {
        super(host, port, ssl);
    }

    public Jedis(String host, int port, boolean ssl, SSLSocketFactory sslSocketFactory, SSLParameters sslParameters, HostnameVerifier hostnameVerifier) {
        super(host, port, ssl, sslSocketFactory, sslParameters, hostnameVerifier);
    }

    public Jedis(String host, int port, int timeout) {
        super(host, port, timeout);
    }

    public Jedis(String host, int port, int timeout, boolean ssl) {
        super(host, port, timeout, ssl);
    }

    public Jedis(String host, int port, int timeout, boolean ssl, SSLSocketFactory sslSocketFactory, SSLParameters sslParameters, HostnameVerifier hostnameVerifier) {
        super(host, port, timeout, ssl, sslSocketFactory, sslParameters, hostnameVerifier);
    }

    public Jedis(String host, int port, int connectionTimeout, int soTimeout) {
        super(host, port, connectionTimeout, soTimeout);
    }

    public Jedis(String host, int port, int connectionTimeout, int soTimeout, boolean ssl) {
        super(host, port, connectionTimeout, soTimeout, ssl);
    }

    public Jedis(String host, int port, int connectionTimeout, int soTimeout, boolean ssl, SSLSocketFactory sslSocketFactory, SSLParameters sslParameters, HostnameVerifier hostnameVerifier) {
        super(host, port, connectionTimeout, soTimeout, ssl, sslSocketFactory, sslParameters, hostnameVerifier);
    }

    public Jedis(JedisShardInfo shardInfo) {
        super(shardInfo);
    }

    public Jedis(URI uri) {
        super(uri);
    }

    public Jedis(URI uri, SSLSocketFactory sslSocketFactory, SSLParameters sslParameters, HostnameVerifier hostnameVerifier) {
        super(uri, sslSocketFactory, sslParameters, hostnameVerifier);
    }

    public Jedis(URI uri, int timeout) {
        super(uri, timeout);
    }

    public Jedis(URI uri, int timeout, SSLSocketFactory sslSocketFactory, SSLParameters sslParameters, HostnameVerifier hostnameVerifier) {
        super(uri, timeout, sslSocketFactory, sslParameters, hostnameVerifier);
    }

    public Jedis(URI uri, int connectionTimeout, int soTimeout) {
        super(uri, connectionTimeout, soTimeout);
    }

    public Jedis(URI uri, int connectionTimeout, int soTimeout, SSLSocketFactory sslSocketFactory, SSLParameters sslParameters, HostnameVerifier hostnameVerifier) {
        super(uri, connectionTimeout, soTimeout, sslSocketFactory, sslParameters, hostnameVerifier);
    }

    public String set(String key, String value) {
        checkIsInMultiOrPipeline();
        this.client.set(key, value);
        return this.client.getStatusCodeReply();
    }

    public String set(String key, String value, SetParams params) {
        checkIsInMultiOrPipeline();
        this.client.set(key, value, params);
        return this.client.getStatusCodeReply();
    }

    public String get(String key) {
        checkIsInMultiOrPipeline();
        this.client.sendCommand((ProtocolCommand) Protocol.Command.GET, key);
        return this.client.getBulkReply();
    }

    public Long exists(String... keys) {
        checkIsInMultiOrPipeline();
        this.client.exists(keys);
        return this.client.getIntegerReply();
    }

    public Boolean exists(String key) {
        checkIsInMultiOrPipeline();
        this.client.exists(key);
        return Boolean.valueOf(this.client.getIntegerReply().longValue() == 1);
    }

    public Long del(String... keys) {
        checkIsInMultiOrPipeline();
        this.client.del(keys);
        return this.client.getIntegerReply();
    }

    public Long del(String key) {
        this.client.del(key);
        return this.client.getIntegerReply();
    }

    public String type(String key) {
        checkIsInMultiOrPipeline();
        this.client.type(key);
        return this.client.getStatusCodeReply();
    }

    public Set<String> keys(String pattern) {
        checkIsInMultiOrPipeline();
        this.client.keys(pattern);
        return BuilderFactory.STRING_SET.build(this.client.getBinaryMultiBulkReply());
    }

    public String randomKey() {
        checkIsInMultiOrPipeline();
        this.client.randomKey();
        return this.client.getBulkReply();
    }

    public String rename(String oldkey, String newkey) {
        checkIsInMultiOrPipeline();
        this.client.rename(oldkey, newkey);
        return this.client.getStatusCodeReply();
    }

    public Long renamenx(String oldkey, String newkey) {
        checkIsInMultiOrPipeline();
        this.client.renamenx(oldkey, newkey);
        return this.client.getIntegerReply();
    }

    public Long expire(String key, int seconds) {
        checkIsInMultiOrPipeline();
        this.client.expire(key, seconds);
        return this.client.getIntegerReply();
    }

    public Long expireAt(String key, long unixTime) {
        checkIsInMultiOrPipeline();
        this.client.expireAt(key, unixTime);
        return this.client.getIntegerReply();
    }

    public Long ttl(String key) {
        checkIsInMultiOrPipeline();
        this.client.ttl(key);
        return this.client.getIntegerReply();
    }

    public Long move(String key, int dbIndex) {
        checkIsInMultiOrPipeline();
        this.client.move(key, dbIndex);
        return this.client.getIntegerReply();
    }

    public String getSet(String key, String value) {
        checkIsInMultiOrPipeline();
        this.client.getSet(key, value);
        return this.client.getBulkReply();
    }

    public List<String> mget(String... keys) {
        checkIsInMultiOrPipeline();
        this.client.mget(keys);
        return this.client.getMultiBulkReply();
    }

    public Long setnx(String key, String value) {
        checkIsInMultiOrPipeline();
        this.client.setnx(key, value);
        return this.client.getIntegerReply();
    }

    public String setex(String key, int seconds, String value) {
        checkIsInMultiOrPipeline();
        this.client.setex(key, seconds, value);
        return this.client.getStatusCodeReply();
    }

    public String mset(String... keysvalues) {
        checkIsInMultiOrPipeline();
        this.client.mset(keysvalues);
        return this.client.getStatusCodeReply();
    }

    public Long msetnx(String... keysvalues) {
        checkIsInMultiOrPipeline();
        this.client.msetnx(keysvalues);
        return this.client.getIntegerReply();
    }

    public Long decrBy(String key, long integer) {
        checkIsInMultiOrPipeline();
        this.client.decrBy(key, integer);
        return this.client.getIntegerReply();
    }

    public Long decr(String key) {
        checkIsInMultiOrPipeline();
        this.client.decr(key);
        return this.client.getIntegerReply();
    }

    public Long incrBy(String key, long integer) {
        checkIsInMultiOrPipeline();
        this.client.incrBy(key, integer);
        return this.client.getIntegerReply();
    }

    public Double incrByFloat(String key, double value) {
        checkIsInMultiOrPipeline();
        this.client.incrByFloat(key, value);
        String dval = this.client.getBulkReply();
        if (dval != null) {
            return new Double(dval);
        }
        return null;
    }

    public Long incr(String key) {
        checkIsInMultiOrPipeline();
        this.client.incr(key);
        return this.client.getIntegerReply();
    }

    public Long append(String key, String value) {
        checkIsInMultiOrPipeline();
        this.client.append(key, value);
        return this.client.getIntegerReply();
    }

    public String substr(String key, int start, int end) {
        checkIsInMultiOrPipeline();
        this.client.substr(key, start, end);
        return this.client.getBulkReply();
    }

    public Long hset(String key, String field, String value) {
        checkIsInMultiOrPipeline();
        this.client.hset(key, field, value);
        return this.client.getIntegerReply();
    }

    public String hget(String key, String field) {
        checkIsInMultiOrPipeline();
        this.client.hget(key, field);
        return this.client.getBulkReply();
    }

    public Long hsetnx(String key, String field, String value) {
        checkIsInMultiOrPipeline();
        this.client.hsetnx(key, field, value);
        return this.client.getIntegerReply();
    }

    public String hmset(String key, Map<String, String> hash) {
        checkIsInMultiOrPipeline();
        this.client.hmset(key, hash);
        return this.client.getStatusCodeReply();
    }

    public List<String> hmget(String key, String... fields) {
        checkIsInMultiOrPipeline();
        this.client.hmget(key, fields);
        return this.client.getMultiBulkReply();
    }

    public Long hincrBy(String key, String field, long value) {
        checkIsInMultiOrPipeline();
        this.client.hincrBy(key, field, value);
        return this.client.getIntegerReply();
    }

    public Double hincrByFloat(String key, String field, double value) {
        checkIsInMultiOrPipeline();
        this.client.hincrByFloat(key, field, value);
        String dval = this.client.getBulkReply();
        if (dval != null) {
            return new Double(dval);
        }
        return null;
    }

    public Boolean hexists(String key, String field) {
        checkIsInMultiOrPipeline();
        this.client.hexists(key, field);
        return Boolean.valueOf(this.client.getIntegerReply().longValue() == 1);
    }

    public Long hdel(String key, String... fields) {
        checkIsInMultiOrPipeline();
        this.client.hdel(key, fields);
        return this.client.getIntegerReply();
    }

    public Long hlen(String key) {
        checkIsInMultiOrPipeline();
        this.client.hlen(key);
        return this.client.getIntegerReply();
    }

    public Set<String> hkeys(String key) {
        checkIsInMultiOrPipeline();
        this.client.hkeys(key);
        return BuilderFactory.STRING_SET.build(this.client.getBinaryMultiBulkReply());
    }

    public List<String> hvals(String key) {
        checkIsInMultiOrPipeline();
        this.client.hvals(key);
        return this.client.getMultiBulkReply();
    }

    public Map<String, String> hgetAll(String key) {
        checkIsInMultiOrPipeline();
        this.client.hgetAll(key);
        return BuilderFactory.STRING_MAP.build(this.client.getBinaryMultiBulkReply());
    }

    public Long rpush(String key, String... strings) {
        checkIsInMultiOrPipeline();
        this.client.rpush(key, strings);
        return this.client.getIntegerReply();
    }

    public Long lpush(String key, String... strings) {
        checkIsInMultiOrPipeline();
        this.client.lpush(key, strings);
        return this.client.getIntegerReply();
    }

    public Long llen(String key) {
        checkIsInMultiOrPipeline();
        this.client.llen(key);
        return this.client.getIntegerReply();
    }

    public List<String> lrange(String key, long start, long end) {
        checkIsInMultiOrPipeline();
        this.client.lrange(key, start, end);
        return this.client.getMultiBulkReply();
    }

    public String ltrim(String key, long start, long end) {
        checkIsInMultiOrPipeline();
        this.client.ltrim(key, start, end);
        return this.client.getStatusCodeReply();
    }

    public String lindex(String key, long index) {
        checkIsInMultiOrPipeline();
        this.client.lindex(key, index);
        return this.client.getBulkReply();
    }

    public String lset(String key, long index, String value) {
        checkIsInMultiOrPipeline();
        this.client.lset(key, index, value);
        return this.client.getStatusCodeReply();
    }

    public Long lrem(String key, long count, String value) {
        checkIsInMultiOrPipeline();
        this.client.lrem(key, count, value);
        return this.client.getIntegerReply();
    }

    public String lpop(String key) {
        checkIsInMultiOrPipeline();
        this.client.lpop(key);
        return this.client.getBulkReply();
    }

    public String rpop(String key) {
        checkIsInMultiOrPipeline();
        this.client.rpop(key);
        return this.client.getBulkReply();
    }

    public String rpoplpush(String srckey, String dstkey) {
        checkIsInMultiOrPipeline();
        this.client.rpoplpush(srckey, dstkey);
        return this.client.getBulkReply();
    }

    public Long sadd(String key, String... members) {
        checkIsInMultiOrPipeline();
        this.client.sadd(key, members);
        return this.client.getIntegerReply();
    }

    public Set<String> smembers(String key) {
        checkIsInMultiOrPipeline();
        this.client.smembers(key);
        List<String> members = this.client.getMultiBulkReply();
        if (members == null) {
            return Collections.emptySet();
        }
        return BinaryJedis.SetFromList.of(members);
    }

    public Long srem(String key, String... members) {
        checkIsInMultiOrPipeline();
        this.client.srem(key, members);
        return this.client.getIntegerReply();
    }

    public String spop(String key) {
        checkIsInMultiOrPipeline();
        this.client.spop(key);
        return this.client.getBulkReply();
    }

    public Set<String> spop(String key, long count) {
        checkIsInMultiOrPipeline();
        this.client.spop(key, count);
        List<String> members = this.client.getMultiBulkReply();
        if (members == null) {
            return Collections.emptySet();
        }
        return BinaryJedis.SetFromList.of(members);
    }

    public Long smove(String srckey, String dstkey, String member) {
        checkIsInMultiOrPipeline();
        this.client.smove(srckey, dstkey, member);
        return this.client.getIntegerReply();
    }

    public Long scard(String key) {
        checkIsInMultiOrPipeline();
        this.client.scard(key);
        return this.client.getIntegerReply();
    }

    public Boolean sismember(String key, String member) {
        checkIsInMultiOrPipeline();
        this.client.sismember(key, member);
        return Boolean.valueOf(this.client.getIntegerReply().longValue() == 1);
    }

    public Set<String> sinter(String... keys) {
        checkIsInMultiOrPipeline();
        this.client.sinter(keys);
        List<String> members = this.client.getMultiBulkReply();
        if (members == null) {
            return Collections.emptySet();
        }
        return BinaryJedis.SetFromList.of(members);
    }

    public Long sinterstore(String dstkey, String... keys) {
        checkIsInMultiOrPipeline();
        this.client.sinterstore(dstkey, keys);
        return this.client.getIntegerReply();
    }

    public Set<String> sunion(String... keys) {
        checkIsInMultiOrPipeline();
        this.client.sunion(keys);
        List<String> members = this.client.getMultiBulkReply();
        if (members == null) {
            return Collections.emptySet();
        }
        return BinaryJedis.SetFromList.of(members);
    }

    public Long sunionstore(String dstkey, String... keys) {
        checkIsInMultiOrPipeline();
        this.client.sunionstore(dstkey, keys);
        return this.client.getIntegerReply();
    }

    public Set<String> sdiff(String... keys) {
        checkIsInMultiOrPipeline();
        this.client.sdiff(keys);
        return BuilderFactory.STRING_SET.build(this.client.getBinaryMultiBulkReply());
    }

    public Long sdiffstore(String dstkey, String... keys) {
        checkIsInMultiOrPipeline();
        this.client.sdiffstore(dstkey, keys);
        return this.client.getIntegerReply();
    }

    public String srandmember(String key) {
        checkIsInMultiOrPipeline();
        this.client.srandmember(key);
        return this.client.getBulkReply();
    }

    public List<String> srandmember(String key, int count) {
        checkIsInMultiOrPipeline();
        this.client.srandmember(key, count);
        return this.client.getMultiBulkReply();
    }

    public Long zadd(String key, double score, String member) {
        checkIsInMultiOrPipeline();
        this.client.zadd(key, score, member);
        return this.client.getIntegerReply();
    }

    public Long zadd(String key, double score, String member, ZAddParams params) {
        checkIsInMultiOrPipeline();
        this.client.zadd(key, score, member, params);
        return this.client.getIntegerReply();
    }

    public Long zadd(String key, Map<String, Double> scoreMembers) {
        checkIsInMultiOrPipeline();
        this.client.zadd(key, scoreMembers);
        return this.client.getIntegerReply();
    }

    public Long zadd(String key, Map<String, Double> scoreMembers, ZAddParams params) {
        checkIsInMultiOrPipeline();
        this.client.zadd(key, scoreMembers, params);
        return this.client.getIntegerReply();
    }

    public Set<String> zrange(String key, long start, long end) {
        checkIsInMultiOrPipeline();
        this.client.zrange(key, start, end);
        List<String> members = this.client.getMultiBulkReply();
        if (members == null) {
            return Collections.emptySet();
        }
        return BinaryJedis.SetFromList.of(members);
    }

    public Long zrem(String key, String... members) {
        checkIsInMultiOrPipeline();
        this.client.zrem(key, members);
        return this.client.getIntegerReply();
    }

    public Double zincrby(String key, double score, String member) {
        checkIsInMultiOrPipeline();
        this.client.zincrby(key, score, member);
        return Double.valueOf(this.client.getBulkReply());
    }

    public Double zincrby(String key, double score, String member, ZIncrByParams params) {
        checkIsInMultiOrPipeline();
        this.client.zincrby(key, score, member, params);
        String newscore = this.client.getBulkReply();
        if (newscore == null) {
            return null;
        }
        return Double.valueOf(newscore);
    }

    public Long zrank(String key, String member) {
        checkIsInMultiOrPipeline();
        this.client.zrank(key, member);
        return this.client.getIntegerReply();
    }

    public Long zrevrank(String key, String member) {
        checkIsInMultiOrPipeline();
        this.client.zrevrank(key, member);
        return this.client.getIntegerReply();
    }

    public Set<String> zrevrange(String key, long start, long end) {
        checkIsInMultiOrPipeline();
        this.client.zrevrange(key, start, end);
        List<String> members = this.client.getMultiBulkReply();
        if (members == null) {
            return Collections.emptySet();
        }
        return BinaryJedis.SetFromList.of(members);
    }

    public Set<Tuple> zrangeWithScores(String key, long start, long end) {
        checkIsInMultiOrPipeline();
        this.client.zrangeWithScores(key, start, end);
        return getTupledSet();
    }

    public Set<Tuple> zrevrangeWithScores(String key, long start, long end) {
        checkIsInMultiOrPipeline();
        this.client.zrevrangeWithScores(key, start, end);
        return getTupledSet();
    }

    public Long zcard(String key) {
        checkIsInMultiOrPipeline();
        this.client.zcard(key);
        return this.client.getIntegerReply();
    }

    public Double zscore(String key, String member) {
        checkIsInMultiOrPipeline();
        this.client.zscore(key, member);
        String score = this.client.getBulkReply();
        if (score != null) {
            return new Double(score);
        }
        return null;
    }

    public String watch(String... keys) {
        this.client.watch(keys);
        return this.client.getStatusCodeReply();
    }

    public List<String> sort(String key) {
        checkIsInMultiOrPipeline();
        this.client.sort(key);
        return this.client.getMultiBulkReply();
    }

    public List<String> sort(String key, SortingParams sortingParameters) {
        checkIsInMultiOrPipeline();
        this.client.sort(key, sortingParameters);
        return this.client.getMultiBulkReply();
    }

    public List<String> blpop(int timeout, String... keys) {
        return blpop(getArgsAddTimeout(timeout, keys));
    }

    private String[] getArgsAddTimeout(int timeout, String[] keys) {
        int keyCount = keys.length;
        String[] args = new String[(keyCount + 1)];
        for (int at = 0; at != keyCount; at++) {
            args[at] = keys[at];
        }
        args[keyCount] = String.valueOf(timeout);
        return args;
    }

    public List<String> blpop(String... args) {
        checkIsInMultiOrPipeline();
        this.client.blpop(args);
        this.client.setTimeoutInfinite();
        try {
            return this.client.getMultiBulkReply();
        } finally {
            this.client.rollbackTimeout();
        }
    }

    public List<String> brpop(String... args) {
        checkIsInMultiOrPipeline();
        this.client.brpop(args);
        this.client.setTimeoutInfinite();
        try {
            return this.client.getMultiBulkReply();
        } finally {
            this.client.rollbackTimeout();
        }
    }

    public Long sort(String key, SortingParams sortingParameters, String dstkey) {
        checkIsInMultiOrPipeline();
        this.client.sort(key, sortingParameters, dstkey);
        return this.client.getIntegerReply();
    }

    public Long sort(String key, String dstkey) {
        checkIsInMultiOrPipeline();
        this.client.sort(key, dstkey);
        return this.client.getIntegerReply();
    }

    public List<String> brpop(int timeout, String... keys) {
        return brpop(getArgsAddTimeout(timeout, keys));
    }

    public Long zcount(String key, double min, double max) {
        checkIsInMultiOrPipeline();
        this.client.zcount(key, min, max);
        return this.client.getIntegerReply();
    }

    public Long zcount(String key, String min, String max) {
        checkIsInMultiOrPipeline();
        this.client.zcount(key, min, max);
        return this.client.getIntegerReply();
    }

    public Set<String> zrangeByScore(String key, double min, double max) {
        checkIsInMultiOrPipeline();
        this.client.zrangeByScore(key, min, max);
        List<String> members = this.client.getMultiBulkReply();
        if (members == null) {
            return Collections.emptySet();
        }
        return BinaryJedis.SetFromList.of(members);
    }

    public Set<String> zrangeByScore(String key, String min, String max) {
        checkIsInMultiOrPipeline();
        this.client.zrangeByScore(key, min, max);
        List<String> members = this.client.getMultiBulkReply();
        if (members == null) {
            return Collections.emptySet();
        }
        return BinaryJedis.SetFromList.of(members);
    }

    public Set<String> zrangeByScore(String key, double min, double max, int offset, int count) {
        checkIsInMultiOrPipeline();
        this.client.zrangeByScore(key, min, max, offset, count);
        List<String> members = this.client.getMultiBulkReply();
        if (members == null) {
            return Collections.emptySet();
        }
        return BinaryJedis.SetFromList.of(members);
    }

    public Set<String> zrangeByScore(String key, String min, String max, int offset, int count) {
        checkIsInMultiOrPipeline();
        this.client.zrangeByScore(key, min, max, offset, count);
        List<String> members = this.client.getMultiBulkReply();
        if (members == null) {
            return Collections.emptySet();
        }
        return BinaryJedis.SetFromList.of(members);
    }

    public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max) {
        checkIsInMultiOrPipeline();
        this.client.zrangeByScoreWithScores(key, min, max);
        return getTupledSet();
    }

    public Set<Tuple> zrangeByScoreWithScores(String key, String min, String max) {
        checkIsInMultiOrPipeline();
        this.client.zrangeByScoreWithScores(key, min, max);
        return getTupledSet();
    }

    public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max, int offset, int count) {
        checkIsInMultiOrPipeline();
        this.client.zrangeByScoreWithScores(key, min, max, offset, count);
        return getTupledSet();
    }

    public Set<Tuple> zrangeByScoreWithScores(String key, String min, String max, int offset, int count) {
        checkIsInMultiOrPipeline();
        this.client.zrangeByScoreWithScores(key, min, max, offset, count);
        return getTupledSet();
    }

    private Set<Tuple> getTupledSet() {
        checkIsInMultiOrPipeline();
        List<String> membersWithScores = this.client.getMultiBulkReply();
        if (membersWithScores == null) {
            return Collections.emptySet();
        }
        if (membersWithScores.isEmpty()) {
            return Collections.emptySet();
        }
        Set<Tuple> set = new LinkedHashSet<>(membersWithScores.size() / 2, 1.0f);
        Iterator<String> iterator = membersWithScores.iterator();
        while (iterator.hasNext()) {
            set.add(new Tuple(iterator.next(), Double.valueOf(iterator.next())));
        }
        return set;
    }

    public Set<String> zrevrangeByScore(String key, double max, double min) {
        checkIsInMultiOrPipeline();
        this.client.zrevrangeByScore(key, max, min);
        List<String> members = this.client.getMultiBulkReply();
        if (members == null) {
            return Collections.emptySet();
        }
        return BinaryJedis.SetFromList.of(members);
    }

    public Set<String> zrevrangeByScore(String key, String max, String min) {
        checkIsInMultiOrPipeline();
        this.client.zrevrangeByScore(key, max, min);
        List<String> members = this.client.getMultiBulkReply();
        if (members == null) {
            return Collections.emptySet();
        }
        return BinaryJedis.SetFromList.of(members);
    }

    public Set<String> zrevrangeByScore(String key, double max, double min, int offset, int count) {
        checkIsInMultiOrPipeline();
        this.client.zrevrangeByScore(key, max, min, offset, count);
        List<String> members = this.client.getMultiBulkReply();
        if (members == null) {
            return Collections.emptySet();
        }
        return BinaryJedis.SetFromList.of(members);
    }

    public Set<Tuple> zrevrangeByScoreWithScores(String key, double max, double min) {
        checkIsInMultiOrPipeline();
        this.client.zrevrangeByScoreWithScores(key, max, min);
        return getTupledSet();
    }

    public Set<Tuple> zrevrangeByScoreWithScores(String key, double max, double min, int offset, int count) {
        checkIsInMultiOrPipeline();
        this.client.zrevrangeByScoreWithScores(key, max, min, offset, count);
        return getTupledSet();
    }

    public Set<Tuple> zrevrangeByScoreWithScores(String key, String max, String min, int offset, int count) {
        checkIsInMultiOrPipeline();
        this.client.zrevrangeByScoreWithScores(key, max, min, offset, count);
        return getTupledSet();
    }

    public Set<String> zrevrangeByScore(String key, String max, String min, int offset, int count) {
        checkIsInMultiOrPipeline();
        this.client.zrevrangeByScore(key, max, min, offset, count);
        List<String> members = this.client.getMultiBulkReply();
        if (members == null) {
            return Collections.emptySet();
        }
        return BinaryJedis.SetFromList.of(members);
    }

    public Set<Tuple> zrevrangeByScoreWithScores(String key, String max, String min) {
        checkIsInMultiOrPipeline();
        this.client.zrevrangeByScoreWithScores(key, max, min);
        return getTupledSet();
    }

    public Long zremrangeByRank(String key, long start, long end) {
        checkIsInMultiOrPipeline();
        this.client.zremrangeByRank(key, start, end);
        return this.client.getIntegerReply();
    }

    public Long zremrangeByScore(String key, double start, double end) {
        checkIsInMultiOrPipeline();
        this.client.zremrangeByScore(key, start, end);
        return this.client.getIntegerReply();
    }

    public Long zremrangeByScore(String key, String start, String end) {
        checkIsInMultiOrPipeline();
        this.client.zremrangeByScore(key, start, end);
        return this.client.getIntegerReply();
    }

    public Long zunionstore(String dstkey, String... sets) {
        checkIsInMultiOrPipeline();
        this.client.zunionstore(dstkey, sets);
        return this.client.getIntegerReply();
    }

    public Long zunionstore(String dstkey, ZParams params, String... sets) {
        checkIsInMultiOrPipeline();
        this.client.zunionstore(dstkey, params, sets);
        return this.client.getIntegerReply();
    }

    public Long zinterstore(String dstkey, String... sets) {
        checkIsInMultiOrPipeline();
        this.client.zinterstore(dstkey, sets);
        return this.client.getIntegerReply();
    }

    public Long zinterstore(String dstkey, ZParams params, String... sets) {
        checkIsInMultiOrPipeline();
        this.client.zinterstore(dstkey, params, sets);
        return this.client.getIntegerReply();
    }

    public Long zlexcount(String key, String min, String max) {
        checkIsInMultiOrPipeline();
        this.client.zlexcount(key, min, max);
        return this.client.getIntegerReply();
    }

    public Set<String> zrangeByLex(String key, String min, String max) {
        checkIsInMultiOrPipeline();
        this.client.zrangeByLex(key, min, max);
        List<String> members = this.client.getMultiBulkReply();
        if (members == null) {
            return Collections.emptySet();
        }
        return BinaryJedis.SetFromList.of(members);
    }

    public Set<String> zrangeByLex(String key, String min, String max, int offset, int count) {
        checkIsInMultiOrPipeline();
        this.client.zrangeByLex(key, min, max, offset, count);
        List<String> members = this.client.getMultiBulkReply();
        if (members == null) {
            return Collections.emptySet();
        }
        return BinaryJedis.SetFromList.of(members);
    }

    public Set<String> zrevrangeByLex(String key, String max, String min) {
        checkIsInMultiOrPipeline();
        this.client.zrevrangeByLex(key, max, min);
        List<String> members = this.client.getMultiBulkReply();
        if (members == null) {
            return Collections.emptySet();
        }
        return BinaryJedis.SetFromList.of(members);
    }

    public Set<String> zrevrangeByLex(String key, String max, String min, int offset, int count) {
        checkIsInMultiOrPipeline();
        this.client.zrevrangeByLex(key, max, min, offset, count);
        List<String> members = this.client.getMultiBulkReply();
        if (members == null) {
            return Collections.emptySet();
        }
        return BinaryJedis.SetFromList.of(members);
    }

    public Long zremrangeByLex(String key, String min, String max) {
        checkIsInMultiOrPipeline();
        this.client.zremrangeByLex(key, min, max);
        return this.client.getIntegerReply();
    }

    public Long strlen(String key) {
        this.client.strlen(key);
        return this.client.getIntegerReply();
    }

    public Long lpushx(String key, String... string) {
        this.client.lpushx(key, string);
        return this.client.getIntegerReply();
    }

    public Long persist(String key) {
        this.client.persist(key);
        return this.client.getIntegerReply();
    }

    public Long rpushx(String key, String... string) {
        this.client.rpushx(key, string);
        return this.client.getIntegerReply();
    }

    public String echo(String string) {
        this.client.echo(string);
        return this.client.getBulkReply();
    }

    public Long linsert(String key, BinaryClient.LIST_POSITION where, String pivot, String value) {
        this.client.linsert(key, where, pivot, value);
        return this.client.getIntegerReply();
    }

    public String brpoplpush(String source, String destination, int timeout) {
        this.client.brpoplpush(source, destination, timeout);
        this.client.setTimeoutInfinite();
        try {
            return this.client.getBulkReply();
        } finally {
            this.client.rollbackTimeout();
        }
    }

    public Boolean setbit(String key, long offset, boolean value) {
        this.client.setbit(key, offset, value);
        return Boolean.valueOf(this.client.getIntegerReply().longValue() == 1);
    }

    public Boolean setbit(String key, long offset, String value) {
        this.client.setbit(key, offset, value);
        return Boolean.valueOf(this.client.getIntegerReply().longValue() == 1);
    }

    public Boolean getbit(String key, long offset) {
        this.client.getbit(key, offset);
        return Boolean.valueOf(this.client.getIntegerReply().longValue() == 1);
    }

    public Long setrange(String key, long offset, String value) {
        this.client.setrange(key, offset, value);
        return this.client.getIntegerReply();
    }

    public String getrange(String key, long startOffset, long endOffset) {
        this.client.getrange(key, startOffset, endOffset);
        return this.client.getBulkReply();
    }

    public Long bitpos(String key, boolean value) {
        return bitpos(key, value, new BitPosParams());
    }

    public Long bitpos(String key, boolean value, BitPosParams params) {
        this.client.bitpos(key, value, params);
        return this.client.getIntegerReply();
    }

    public List<String> configGet(String pattern) {
        this.client.configGet(pattern);
        return this.client.getMultiBulkReply();
    }

    public String configSet(String parameter, String value) {
        this.client.configSet(parameter, value);
        return this.client.getStatusCodeReply();
    }

    public Object eval(String script, int keyCount, String... params) {
        this.client.setTimeoutInfinite();
        try {
            this.client.eval(script, keyCount, params);
            return getEvalResult();
        } finally {
            this.client.rollbackTimeout();
        }
    }

    public void subscribe(JedisPubSub jedisPubSub, String... channels) {
        this.client.setTimeoutInfinite();
        try {
            jedisPubSub.proceed(this.client, channels);
        } finally {
            this.client.rollbackTimeout();
        }
    }

    public Long publish(String channel, String message) {
        checkIsInMultiOrPipeline();
        connect();
        this.client.publish(channel, message);
        return this.client.getIntegerReply();
    }

    public void psubscribe(JedisPubSub jedisPubSub, String... patterns) {
        checkIsInMultiOrPipeline();
        this.client.setTimeoutInfinite();
        try {
            jedisPubSub.proceedWithPatterns(this.client, patterns);
        } finally {
            this.client.rollbackTimeout();
        }
    }

    protected static String[] getParams(List<String> keys, List<String> args) {
        int keyCount = keys.size();
        int argCount = args.size();
        String[] params = new String[(args.size() + keyCount)];
        for (int i = 0; i < keyCount; i++) {
            params[i] = keys.get(i);
        }
        for (int i2 = 0; i2 < argCount; i2++) {
            params[keyCount + i2] = args.get(i2);
        }
        return params;
    }

    public Object eval(String script, List<String> keys, List<String> args) {
        return eval(script, keys.size(), getParams(keys, args));
    }

    public Object eval(String script) {
        return eval(script, 0, new String[0]);
    }

    public Object evalsha(String script) {
        return evalsha(script, 0, new String[0]);
    }

    private Object getEvalResult() {
        return evalResult(this.client.getOne());
    }

    private Object evalResult(Object result) {
        if (result instanceof byte[]) {
            return SafeEncoder.encode((byte[]) result);
        }
        if (!(result instanceof List)) {
            return result;
        }
        List<?> list = (List) result;
        List<Object> listResult = new ArrayList<>(list.size());
        for (Object bin : list) {
            listResult.add(evalResult(bin));
        }
        return listResult;
    }

    public Object evalsha(String sha1, List<String> keys, List<String> args) {
        return evalsha(sha1, keys.size(), getParams(keys, args));
    }

    public Object evalsha(String sha1, int keyCount, String... params) {
        checkIsInMultiOrPipeline();
        this.client.evalsha(sha1, keyCount, params);
        return getEvalResult();
    }

    public Boolean scriptExists(String sha1) {
        return scriptExists(sha1).get(0);
    }

    public List<Boolean> scriptExists(String... sha1) {
        this.client.scriptExists(sha1);
        List<Long> result = this.client.getIntegerMultiBulkReply();
        List<Boolean> exists = new ArrayList<>();
        for (Long value : result) {
            exists.add(Boolean.valueOf(value.longValue() == 1));
        }
        return exists;
    }

    public String scriptLoad(String script) {
        this.client.scriptLoad(script);
        return this.client.getBulkReply();
    }

    public List<Slowlog> slowlogGet() {
        this.client.slowlogGet();
        return Slowlog.from(this.client.getObjectMultiBulkReply());
    }

    public List<Slowlog> slowlogGet(long entries) {
        this.client.slowlogGet(entries);
        return Slowlog.from(this.client.getObjectMultiBulkReply());
    }

    public Long objectRefcount(String string) {
        this.client.objectRefcount(string);
        return this.client.getIntegerReply();
    }

    public String objectEncoding(String string) {
        this.client.objectEncoding(string);
        return this.client.getBulkReply();
    }

    public Long objectIdletime(String string) {
        this.client.objectIdletime(string);
        return this.client.getIntegerReply();
    }

    public Long bitcount(String key) {
        this.client.bitcount(key);
        return this.client.getIntegerReply();
    }

    public Long bitcount(String key, long start, long end) {
        this.client.bitcount(key, start, end);
        return this.client.getIntegerReply();
    }

    public Long bitop(BitOP op, String destKey, String... srcKeys) {
        this.client.bitop(op, destKey, srcKeys);
        return this.client.getIntegerReply();
    }

    public List<Map<String, String>> sentinelMasters() {
        this.client.sentinel(Protocol.SENTINEL_MASTERS);
        List<Object> reply = this.client.getObjectMultiBulkReply();
        List<Map<String, String>> masters = new ArrayList<>();
        Iterator<Object> it = reply.iterator();
        while (it.hasNext()) {
            masters.add(BuilderFactory.STRING_MAP.build((List) it.next()));
        }
        return masters;
    }

    public List<String> sentinelGetMasterAddrByName(String masterName) {
        this.client.sentinel(Protocol.SENTINEL_GET_MASTER_ADDR_BY_NAME, masterName);
        return BuilderFactory.STRING_LIST.build(this.client.getObjectMultiBulkReply());
    }

    public Long sentinelReset(String pattern) {
        this.client.sentinel("reset", pattern);
        return this.client.getIntegerReply();
    }

    public List<Map<String, String>> sentinelSlaves(String masterName) {
        this.client.sentinel("slaves", masterName);
        List<Object> reply = this.client.getObjectMultiBulkReply();
        List<Map<String, String>> slaves = new ArrayList<>();
        Iterator<Object> it = reply.iterator();
        while (it.hasNext()) {
            slaves.add(BuilderFactory.STRING_MAP.build((List) it.next()));
        }
        return slaves;
    }

    public String sentinelFailover(String masterName) {
        this.client.sentinel("failover", masterName);
        return this.client.getStatusCodeReply();
    }

    public String sentinelMonitor(String masterName, String ip, int port, int quorum) {
        this.client.sentinel(Protocol.SENTINEL_MONITOR, masterName, ip, String.valueOf(port), String.valueOf(quorum));
        return this.client.getStatusCodeReply();
    }

    public String sentinelRemove(String masterName) {
        this.client.sentinel(Protocol.SENTINEL_REMOVE, masterName);
        return this.client.getStatusCodeReply();
    }

    public String sentinelSet(String masterName, Map<String, String> parameterMap) {
        String[] params = new String[((parameterMap.size() * 2) + 2)];
        int index = 0 + 1;
        params[0] = Protocol.SENTINEL_SET;
        int index2 = index + 1;
        params[index] = masterName;
        for (Map.Entry<String, String> entry : parameterMap.entrySet()) {
            int index3 = index2 + 1;
            params[index2] = entry.getKey();
            index2 = index3 + 1;
            params[index3] = entry.getValue();
        }
        this.client.sentinel(params);
        return this.client.getStatusCodeReply();
    }

    public byte[] dump(String key) {
        checkIsInMultiOrPipeline();
        this.client.dump(key);
        return this.client.getBinaryBulkReply();
    }

    public String restore(String key, int ttl, byte[] serializedValue) {
        checkIsInMultiOrPipeline();
        this.client.restore(key, ttl, serializedValue);
        return this.client.getStatusCodeReply();
    }

    public Long pexpire(String key, long milliseconds) {
        checkIsInMultiOrPipeline();
        this.client.pexpire(key, milliseconds);
        return this.client.getIntegerReply();
    }

    public Long pexpireAt(String key, long millisecondsTimestamp) {
        checkIsInMultiOrPipeline();
        this.client.pexpireAt(key, millisecondsTimestamp);
        return this.client.getIntegerReply();
    }

    public Long pttl(String key) {
        checkIsInMultiOrPipeline();
        this.client.pttl(key);
        return this.client.getIntegerReply();
    }

    public String psetex(String key, long milliseconds, String value) {
        checkIsInMultiOrPipeline();
        this.client.psetex(key, milliseconds, value);
        return this.client.getStatusCodeReply();
    }

    public String clientKill(String client) {
        checkIsInMultiOrPipeline();
        this.client.clientKill(client);
        return this.client.getStatusCodeReply();
    }

    public String clientSetname(String name) {
        checkIsInMultiOrPipeline();
        this.client.clientSetname(name);
        return this.client.getStatusCodeReply();
    }

    public String migrate(String host, int port, String key, int destinationDb, int timeout) {
        checkIsInMultiOrPipeline();
        this.client.migrate(host, port, key, destinationDb, timeout);
        return this.client.getStatusCodeReply();
    }

    public ScanResult<String> scan(String cursor) {
        return scan(cursor, new ScanParams());
    }

    public ScanResult<String> scan(String cursor, ScanParams params) {
        checkIsInMultiOrPipeline();
        this.client.scan(cursor, params);
        List<Object> result = this.client.getObjectMultiBulkReply();
        String newcursor = new String((byte[]) result.get(0));
        List<String> results = new ArrayList<>();
        for (byte[] bs : (List) result.get(1)) {
            results.add(SafeEncoder.encode(bs));
        }
        return new ScanResult<>(newcursor, results);
    }

    public ScanResult<Map.Entry<String, String>> hscan(String key, String cursor) {
        return hscan(key, cursor, new ScanParams());
    }

    public ScanResult<Map.Entry<String, String>> hscan(String key, String cursor, ScanParams params) {
        checkIsInMultiOrPipeline();
        this.client.hscan(key, cursor, params);
        List<Object> result = this.client.getObjectMultiBulkReply();
        String newcursor = new String((byte[]) result.get(0));
        List<Map.Entry<String, String>> results = new ArrayList<>();
        Iterator<byte[]> iterator = ((List) result.get(1)).iterator();
        while (iterator.hasNext()) {
            results.add(new AbstractMap.SimpleEntry(SafeEncoder.encode(iterator.next()), SafeEncoder.encode(iterator.next())));
        }
        return new ScanResult<>(newcursor, results);
    }

    public ScanResult<String> sscan(String key, String cursor) {
        return sscan(key, cursor, new ScanParams());
    }

    public ScanResult<String> sscan(String key, String cursor, ScanParams params) {
        checkIsInMultiOrPipeline();
        this.client.sscan(key, cursor, params);
        List<Object> result = this.client.getObjectMultiBulkReply();
        String newcursor = new String((byte[]) result.get(0));
        List<String> results = new ArrayList<>();
        for (byte[] bs : (List) result.get(1)) {
            results.add(SafeEncoder.encode(bs));
        }
        return new ScanResult<>(newcursor, results);
    }

    public ScanResult<Tuple> zscan(String key, String cursor) {
        return zscan(key, cursor, new ScanParams());
    }

    public ScanResult<Tuple> zscan(String key, String cursor, ScanParams params) {
        checkIsInMultiOrPipeline();
        this.client.zscan(key, cursor, params);
        List<Object> result = this.client.getObjectMultiBulkReply();
        String newcursor = new String((byte[]) result.get(0));
        List<Tuple> results = new ArrayList<>();
        Iterator<byte[]> iterator = ((List) result.get(1)).iterator();
        while (iterator.hasNext()) {
            results.add(new Tuple(SafeEncoder.encode(iterator.next()), Double.valueOf(SafeEncoder.encode(iterator.next()))));
        }
        return new ScanResult<>(newcursor, results);
    }

    public String clusterNodes() {
        checkIsInMultiOrPipeline();
        this.client.clusterNodes();
        return this.client.getBulkReply();
    }

    public String readonly() {
        this.client.readonly();
        return this.client.getStatusCodeReply();
    }

    public String clusterMeet(String ip, int port) {
        checkIsInMultiOrPipeline();
        this.client.clusterMeet(ip, port);
        return this.client.getStatusCodeReply();
    }

    public String clusterReset(JedisCluster.Reset resetType) {
        checkIsInMultiOrPipeline();
        this.client.clusterReset(resetType);
        return this.client.getStatusCodeReply();
    }

    public String clusterAddSlots(int... slots) {
        checkIsInMultiOrPipeline();
        this.client.clusterAddSlots(slots);
        return this.client.getStatusCodeReply();
    }

    public String clusterDelSlots(int... slots) {
        checkIsInMultiOrPipeline();
        this.client.clusterDelSlots(slots);
        return this.client.getStatusCodeReply();
    }

    public String clusterInfo() {
        checkIsInMultiOrPipeline();
        this.client.clusterInfo();
        return this.client.getStatusCodeReply();
    }

    public List<String> clusterGetKeysInSlot(int slot, int count) {
        checkIsInMultiOrPipeline();
        this.client.clusterGetKeysInSlot(slot, count);
        return this.client.getMultiBulkReply();
    }

    public String clusterSetSlotNode(int slot, String nodeId) {
        checkIsInMultiOrPipeline();
        this.client.clusterSetSlotNode(slot, nodeId);
        return this.client.getStatusCodeReply();
    }

    public String clusterSetSlotMigrating(int slot, String nodeId) {
        checkIsInMultiOrPipeline();
        this.client.clusterSetSlotMigrating(slot, nodeId);
        return this.client.getStatusCodeReply();
    }

    public String clusterSetSlotImporting(int slot, String nodeId) {
        checkIsInMultiOrPipeline();
        this.client.clusterSetSlotImporting(slot, nodeId);
        return this.client.getStatusCodeReply();
    }

    public String clusterSetSlotStable(int slot) {
        checkIsInMultiOrPipeline();
        this.client.clusterSetSlotStable(slot);
        return this.client.getStatusCodeReply();
    }

    public String clusterForget(String nodeId) {
        checkIsInMultiOrPipeline();
        this.client.clusterForget(nodeId);
        return this.client.getStatusCodeReply();
    }

    public String clusterFlushSlots() {
        checkIsInMultiOrPipeline();
        this.client.clusterFlushSlots();
        return this.client.getStatusCodeReply();
    }

    public Long clusterKeySlot(String key) {
        checkIsInMultiOrPipeline();
        this.client.clusterKeySlot(key);
        return this.client.getIntegerReply();
    }

    public Long clusterCountKeysInSlot(int slot) {
        checkIsInMultiOrPipeline();
        this.client.clusterCountKeysInSlot(slot);
        return this.client.getIntegerReply();
    }

    public String clusterSaveConfig() {
        checkIsInMultiOrPipeline();
        this.client.clusterSaveConfig();
        return this.client.getStatusCodeReply();
    }

    public String clusterReplicate(String nodeId) {
        checkIsInMultiOrPipeline();
        this.client.clusterReplicate(nodeId);
        return this.client.getStatusCodeReply();
    }

    public List<String> clusterSlaves(String nodeId) {
        checkIsInMultiOrPipeline();
        this.client.clusterSlaves(nodeId);
        return this.client.getMultiBulkReply();
    }

    public String clusterFailover() {
        checkIsInMultiOrPipeline();
        this.client.clusterFailover();
        return this.client.getStatusCodeReply();
    }

    public List<Object> clusterSlots() {
        checkIsInMultiOrPipeline();
        this.client.clusterSlots();
        return this.client.getObjectMultiBulkReply();
    }

    public String asking() {
        checkIsInMultiOrPipeline();
        this.client.asking();
        return this.client.getStatusCodeReply();
    }

    public List<String> pubsubChannels(String pattern) {
        checkIsInMultiOrPipeline();
        this.client.pubsubChannels(pattern);
        return this.client.getMultiBulkReply();
    }

    public Long pubsubNumPat() {
        checkIsInMultiOrPipeline();
        this.client.pubsubNumPat();
        return this.client.getIntegerReply();
    }

    public Map<String, String> pubsubNumSub(String... channels) {
        checkIsInMultiOrPipeline();
        this.client.pubsubNumSub(channels);
        return BuilderFactory.PUBSUB_NUMSUB_MAP.build(this.client.getBinaryMultiBulkReply());
    }

    public void close() {
        if (this.dataSource == null) {
            this.client.close();
        } else if (this.client.isBroken()) {
            this.dataSource.returnBrokenResource(this);
        } else {
            this.dataSource.returnResource(this);
        }
    }

    public void setDataSource(JedisPoolAbstract jedisPool) {
        this.dataSource = jedisPool;
    }

    public Long pfadd(String key, String... elements) {
        checkIsInMultiOrPipeline();
        this.client.pfadd(key, elements);
        return this.client.getIntegerReply();
    }

    public long pfcount(String key) {
        checkIsInMultiOrPipeline();
        this.client.pfcount(key);
        return this.client.getIntegerReply().longValue();
    }

    public long pfcount(String... keys) {
        checkIsInMultiOrPipeline();
        this.client.pfcount(keys);
        return this.client.getIntegerReply().longValue();
    }

    public String pfmerge(String destkey, String... sourcekeys) {
        checkIsInMultiOrPipeline();
        this.client.pfmerge(destkey, sourcekeys);
        return this.client.getStatusCodeReply();
    }

    public List<String> blpop(int timeout, String key) {
        return blpop(key, String.valueOf(timeout));
    }

    public List<String> brpop(int timeout, String key) {
        return brpop(key, String.valueOf(timeout));
    }

    public Long geoadd(String key, double longitude, double latitude, String member) {
        checkIsInMultiOrPipeline();
        this.client.geoadd(key, longitude, latitude, member);
        return this.client.getIntegerReply();
    }

    public Long geoadd(String key, Map<String, GeoCoordinate> memberCoordinateMap) {
        checkIsInMultiOrPipeline();
        this.client.geoadd(key, memberCoordinateMap);
        return this.client.getIntegerReply();
    }

    public Double geodist(String key, String member1, String member2) {
        checkIsInMultiOrPipeline();
        this.client.geodist(key, member1, member2);
        String dval = this.client.getBulkReply();
        if (dval != null) {
            return new Double(dval);
        }
        return null;
    }

    public Double geodist(String key, String member1, String member2, GeoUnit unit) {
        checkIsInMultiOrPipeline();
        this.client.geodist(key, member1, member2, unit);
        String dval = this.client.getBulkReply();
        if (dval != null) {
            return new Double(dval);
        }
        return null;
    }

    public List<String> geohash(String key, String... members) {
        checkIsInMultiOrPipeline();
        this.client.geohash(key, members);
        return this.client.getMultiBulkReply();
    }

    public List<GeoCoordinate> geopos(String key, String... members) {
        checkIsInMultiOrPipeline();
        this.client.geopos(key, members);
        return BuilderFactory.GEO_COORDINATE_LIST.build(this.client.getObjectMultiBulkReply());
    }

    public List<GeoRadiusResponse> georadius(String key, double longitude, double latitude, double radius, GeoUnit unit) {
        checkIsInMultiOrPipeline();
        this.client.georadius(key, longitude, latitude, radius, unit);
        return BuilderFactory.GEORADIUS_WITH_PARAMS_RESULT.build(this.client.getObjectMultiBulkReply());
    }

    public List<GeoRadiusResponse> georadius(String key, double longitude, double latitude, double radius, GeoUnit unit, GeoRadiusParam param) {
        checkIsInMultiOrPipeline();
        this.client.georadius(key, longitude, latitude, radius, unit, param);
        return BuilderFactory.GEORADIUS_WITH_PARAMS_RESULT.build(this.client.getObjectMultiBulkReply());
    }

    public List<GeoRadiusResponse> georadiusByMember(String key, String member, double radius, GeoUnit unit) {
        checkIsInMultiOrPipeline();
        this.client.georadiusByMember(key, member, radius, unit);
        return BuilderFactory.GEORADIUS_WITH_PARAMS_RESULT.build(this.client.getObjectMultiBulkReply());
    }

    public List<GeoRadiusResponse> georadiusByMember(String key, String member, double radius, GeoUnit unit, GeoRadiusParam param) {
        checkIsInMultiOrPipeline();
        this.client.georadiusByMember(key, member, radius, unit, param);
        return BuilderFactory.GEORADIUS_WITH_PARAMS_RESULT.build(this.client.getObjectMultiBulkReply());
    }

    public String moduleLoad(String path) {
        this.client.moduleLoad(path);
        return this.client.getStatusCodeReply();
    }

    public String moduleUnload(String name) {
        this.client.moduleUnload(name);
        return this.client.getStatusCodeReply();
    }

    public List<Module> moduleList() {
        this.client.moduleList();
        return BuilderFactory.MODULE_LIST.build(this.client.getObjectMultiBulkReply());
    }

    public List<Long> bitfield(String key, String... arguments) {
        checkIsInMultiOrPipeline();
        this.client.bitfield(key, arguments);
        return this.client.getIntegerMultiBulkReply();
    }

    public Long hstrlen(String key, String field) {
        checkIsInMultiOrPipeline();
        this.client.hstrlen(key, field);
        return this.client.getIntegerReply();
    }
}
