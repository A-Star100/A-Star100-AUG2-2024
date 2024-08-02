package redis.clients.jedis;

import java.io.Closeable;
import java.io.Serializable;
import java.net.URI;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
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
import redis.clients.jedis.commands.AdvancedBinaryJedisCommands;
import redis.clients.jedis.commands.BasicCommands;
import redis.clients.jedis.commands.BinaryJedisCommands;
import redis.clients.jedis.commands.BinaryScriptingCommands;
import redis.clients.jedis.commands.MultiKeyBinaryCommands;
import redis.clients.jedis.exceptions.InvalidURIException;
import redis.clients.jedis.exceptions.JedisDataException;
import redis.clients.jedis.exceptions.JedisException;
import redis.clients.jedis.params.geo.GeoRadiusParam;
import redis.clients.jedis.params.set.SetParams;
import redis.clients.jedis.params.sortedset.ZAddParams;
import redis.clients.jedis.params.sortedset.ZIncrByParams;
import redis.clients.util.JedisByteHashMap;
import redis.clients.util.JedisURIHelper;
import redis.clients.util.SafeEncoder;

public class BinaryJedis implements BasicCommands, BinaryJedisCommands, MultiKeyBinaryCommands, AdvancedBinaryJedisCommands, BinaryScriptingCommands, Closeable {
    protected Client client;
    protected Pipeline pipeline;
    protected Transaction transaction;

    public BinaryJedis() {
        this.client = null;
        this.transaction = null;
        this.pipeline = null;
        this.client = new Client();
    }

    public BinaryJedis(String host) {
        this.client = null;
        this.transaction = null;
        this.pipeline = null;
        URI uri = URI.create(host);
        if (uri.getScheme() == null || !uri.getScheme().equals("redis")) {
            this.client = new Client(host);
        } else {
            initializeClientFromURI(uri);
        }
    }

    public BinaryJedis(String host, int port) {
        this.client = null;
        this.transaction = null;
        this.pipeline = null;
        this.client = new Client(host, port);
    }

    public BinaryJedis(String host, int port, boolean ssl) {
        this.client = null;
        this.transaction = null;
        this.pipeline = null;
        this.client = new Client(host, port, ssl);
    }

    public BinaryJedis(String host, int port, boolean ssl, SSLSocketFactory sslSocketFactory, SSLParameters sslParameters, HostnameVerifier hostnameVerifier) {
        this.client = null;
        this.transaction = null;
        this.pipeline = null;
        this.client = new Client(host, port, ssl, sslSocketFactory, sslParameters, hostnameVerifier);
    }

    public BinaryJedis(String host, int port, int timeout) {
        this.client = null;
        this.transaction = null;
        this.pipeline = null;
        Client client2 = new Client(host, port);
        this.client = client2;
        client2.setConnectionTimeout(timeout);
        this.client.setSoTimeout(timeout);
    }

    public BinaryJedis(String host, int port, int timeout, boolean ssl) {
        this.client = null;
        this.transaction = null;
        this.pipeline = null;
        Client client2 = new Client(host, port, ssl);
        this.client = client2;
        client2.setConnectionTimeout(timeout);
        this.client.setSoTimeout(timeout);
    }

    public BinaryJedis(String host, int port, int timeout, boolean ssl, SSLSocketFactory sslSocketFactory, SSLParameters sslParameters, HostnameVerifier hostnameVerifier) {
        this.client = null;
        this.transaction = null;
        this.pipeline = null;
        Client client2 = new Client(host, port, ssl, sslSocketFactory, sslParameters, hostnameVerifier);
        this.client = client2;
        client2.setConnectionTimeout(timeout);
        this.client.setSoTimeout(timeout);
    }

    public BinaryJedis(String host, int port, int connectionTimeout, int soTimeout) {
        this.client = null;
        this.transaction = null;
        this.pipeline = null;
        Client client2 = new Client(host, port);
        this.client = client2;
        client2.setConnectionTimeout(connectionTimeout);
        this.client.setSoTimeout(soTimeout);
    }

    public BinaryJedis(String host, int port, int connectionTimeout, int soTimeout, boolean ssl) {
        this.client = null;
        this.transaction = null;
        this.pipeline = null;
        Client client2 = new Client(host, port, ssl);
        this.client = client2;
        client2.setConnectionTimeout(connectionTimeout);
        this.client.setSoTimeout(soTimeout);
    }

    public BinaryJedis(String host, int port, int connectionTimeout, int soTimeout, boolean ssl, SSLSocketFactory sslSocketFactory, SSLParameters sslParameters, HostnameVerifier hostnameVerifier) {
        this.client = null;
        this.transaction = null;
        this.pipeline = null;
        Client client2 = new Client(host, port, ssl, sslSocketFactory, sslParameters, hostnameVerifier);
        this.client = client2;
        int i = connectionTimeout;
        client2.setConnectionTimeout(connectionTimeout);
        int i2 = soTimeout;
        this.client.setSoTimeout(soTimeout);
    }

    public BinaryJedis(JedisShardInfo shardInfo) {
        this.client = null;
        this.transaction = null;
        this.pipeline = null;
        Client client2 = new Client(shardInfo.getHost(), shardInfo.getPort(), shardInfo.getSsl(), shardInfo.getSslSocketFactory(), shardInfo.getSslParameters(), shardInfo.getHostnameVerifier());
        this.client = client2;
        client2.setConnectionTimeout(shardInfo.getConnectionTimeout());
        this.client.setSoTimeout(shardInfo.getSoTimeout());
        this.client.setPassword(shardInfo.getPassword());
        this.client.setDb(shardInfo.getDb());
    }

    public BinaryJedis(URI uri) {
        this.client = null;
        this.transaction = null;
        this.pipeline = null;
        initializeClientFromURI(uri);
    }

    public BinaryJedis(URI uri, SSLSocketFactory sslSocketFactory, SSLParameters sslParameters, HostnameVerifier hostnameVerifier) {
        this.client = null;
        this.transaction = null;
        this.pipeline = null;
        initializeClientFromURI(uri, sslSocketFactory, sslParameters, hostnameVerifier);
    }

    public BinaryJedis(URI uri, int timeout) {
        this.client = null;
        this.transaction = null;
        this.pipeline = null;
        initializeClientFromURI(uri);
        this.client.setConnectionTimeout(timeout);
        this.client.setSoTimeout(timeout);
    }

    public BinaryJedis(URI uri, int timeout, SSLSocketFactory sslSocketFactory, SSLParameters sslParameters, HostnameVerifier hostnameVerifier) {
        this.client = null;
        this.transaction = null;
        this.pipeline = null;
        initializeClientFromURI(uri, sslSocketFactory, sslParameters, hostnameVerifier);
        this.client.setConnectionTimeout(timeout);
        this.client.setSoTimeout(timeout);
    }

    public BinaryJedis(URI uri, int connectionTimeout, int soTimeout) {
        this.client = null;
        this.transaction = null;
        this.pipeline = null;
        initializeClientFromURI(uri);
        this.client.setConnectionTimeout(connectionTimeout);
        this.client.setSoTimeout(soTimeout);
    }

    public BinaryJedis(URI uri, int connectionTimeout, int soTimeout, SSLSocketFactory sslSocketFactory, SSLParameters sslParameters, HostnameVerifier hostnameVerifier) {
        this.client = null;
        this.transaction = null;
        this.pipeline = null;
        initializeClientFromURI(uri, sslSocketFactory, sslParameters, hostnameVerifier);
        this.client.setConnectionTimeout(connectionTimeout);
        this.client.setSoTimeout(soTimeout);
    }

    private void initializeClientFromURI(URI uri) {
        if (JedisURIHelper.isValid(uri)) {
            this.client = new Client(uri.getHost(), uri.getPort(), uri.getScheme().equals("rediss"));
            String password = JedisURIHelper.getPassword(uri);
            if (password != null) {
                this.client.auth(password);
                this.client.getStatusCodeReply();
            }
            int dbIndex = JedisURIHelper.getDBIndex(uri);
            if (dbIndex > 0) {
                this.client.select(dbIndex);
                this.client.getStatusCodeReply();
                this.client.setDb(dbIndex);
                return;
            }
            return;
        }
        throw new InvalidURIException(String.format("Cannot open Redis connection due invalid URI. %s", new Object[]{uri.toString()}));
    }

    private void initializeClientFromURI(URI uri, SSLSocketFactory sslSocketFactory, SSLParameters sslParameters, HostnameVerifier hostnameVerifier) {
        if (JedisURIHelper.isValid(uri)) {
            this.client = new Client(uri.getHost(), uri.getPort(), uri.getScheme().equals("rediss"), sslSocketFactory, sslParameters, hostnameVerifier);
            String password = JedisURIHelper.getPassword(uri);
            if (password != null) {
                this.client.auth(password);
                this.client.getStatusCodeReply();
            }
            int dbIndex = JedisURIHelper.getDBIndex(uri);
            if (dbIndex > 0) {
                this.client.select(dbIndex);
                this.client.getStatusCodeReply();
                this.client.setDb(dbIndex);
                return;
            }
            return;
        }
        throw new InvalidURIException(String.format("Cannot open Redis connection due invalid URI. %s", new Object[]{uri.toString()}));
    }

    public String ping() {
        checkIsInMultiOrPipeline();
        this.client.ping();
        return this.client.getStatusCodeReply();
    }

    public String set(byte[] key, byte[] value) {
        checkIsInMultiOrPipeline();
        this.client.set(key, value);
        return this.client.getStatusCodeReply();
    }

    public String set(byte[] key, byte[] value, SetParams params) {
        checkIsInMultiOrPipeline();
        this.client.set(key, value, params);
        return this.client.getStatusCodeReply();
    }

    public byte[] get(byte[] key) {
        checkIsInMultiOrPipeline();
        this.client.get(key);
        return this.client.getBinaryBulkReply();
    }

    public String quit() {
        checkIsInMultiOrPipeline();
        this.client.quit();
        String quitReturn = this.client.getStatusCodeReply();
        this.client.disconnect();
        return quitReturn;
    }

    public Long exists(byte[]... keys) {
        checkIsInMultiOrPipeline();
        this.client.exists(keys);
        return this.client.getIntegerReply();
    }

    public Boolean exists(byte[] key) {
        checkIsInMultiOrPipeline();
        this.client.exists(key);
        return Boolean.valueOf(this.client.getIntegerReply().longValue() == 1);
    }

    public Long del(byte[]... keys) {
        checkIsInMultiOrPipeline();
        this.client.del(keys);
        return this.client.getIntegerReply();
    }

    public Long del(byte[] key) {
        checkIsInMultiOrPipeline();
        this.client.del(key);
        return this.client.getIntegerReply();
    }

    public String type(byte[] key) {
        checkIsInMultiOrPipeline();
        this.client.type(key);
        return this.client.getStatusCodeReply();
    }

    public String flushDB() {
        checkIsInMultiOrPipeline();
        this.client.flushDB();
        return this.client.getStatusCodeReply();
    }

    public Set<byte[]> keys(byte[] pattern) {
        checkIsInMultiOrPipeline();
        this.client.keys(pattern);
        return SetFromList.of(this.client.getBinaryMultiBulkReply());
    }

    public byte[] randomBinaryKey() {
        checkIsInMultiOrPipeline();
        this.client.randomKey();
        return this.client.getBinaryBulkReply();
    }

    public String rename(byte[] oldkey, byte[] newkey) {
        checkIsInMultiOrPipeline();
        this.client.rename(oldkey, newkey);
        return this.client.getStatusCodeReply();
    }

    public Long renamenx(byte[] oldkey, byte[] newkey) {
        checkIsInMultiOrPipeline();
        this.client.renamenx(oldkey, newkey);
        return this.client.getIntegerReply();
    }

    public Long dbSize() {
        checkIsInMultiOrPipeline();
        this.client.dbSize();
        return this.client.getIntegerReply();
    }

    public Long expire(byte[] key, int seconds) {
        checkIsInMultiOrPipeline();
        this.client.expire(key, seconds);
        return this.client.getIntegerReply();
    }

    public Long expireAt(byte[] key, long unixTime) {
        checkIsInMultiOrPipeline();
        this.client.expireAt(key, unixTime);
        return this.client.getIntegerReply();
    }

    public Long ttl(byte[] key) {
        checkIsInMultiOrPipeline();
        this.client.ttl(key);
        return this.client.getIntegerReply();
    }

    public String select(int index) {
        checkIsInMultiOrPipeline();
        this.client.select(index);
        String statusCodeReply = this.client.getStatusCodeReply();
        this.client.setDb(index);
        return statusCodeReply;
    }

    public Long move(byte[] key, int dbIndex) {
        checkIsInMultiOrPipeline();
        this.client.move(key, dbIndex);
        return this.client.getIntegerReply();
    }

    public String flushAll() {
        checkIsInMultiOrPipeline();
        this.client.flushAll();
        return this.client.getStatusCodeReply();
    }

    public byte[] getSet(byte[] key, byte[] value) {
        checkIsInMultiOrPipeline();
        this.client.getSet(key, value);
        return this.client.getBinaryBulkReply();
    }

    public List<byte[]> mget(byte[]... keys) {
        checkIsInMultiOrPipeline();
        this.client.mget(keys);
        return this.client.getBinaryMultiBulkReply();
    }

    public Long setnx(byte[] key, byte[] value) {
        checkIsInMultiOrPipeline();
        this.client.setnx(key, value);
        return this.client.getIntegerReply();
    }

    public String setex(byte[] key, int seconds, byte[] value) {
        checkIsInMultiOrPipeline();
        this.client.setex(key, seconds, value);
        return this.client.getStatusCodeReply();
    }

    public String mset(byte[]... keysvalues) {
        checkIsInMultiOrPipeline();
        this.client.mset(keysvalues);
        return this.client.getStatusCodeReply();
    }

    public Long msetnx(byte[]... keysvalues) {
        checkIsInMultiOrPipeline();
        this.client.msetnx(keysvalues);
        return this.client.getIntegerReply();
    }

    public Long decrBy(byte[] key, long integer) {
        checkIsInMultiOrPipeline();
        this.client.decrBy(key, integer);
        return this.client.getIntegerReply();
    }

    public Long decr(byte[] key) {
        checkIsInMultiOrPipeline();
        this.client.decr(key);
        return this.client.getIntegerReply();
    }

    public Long incrBy(byte[] key, long integer) {
        checkIsInMultiOrPipeline();
        this.client.incrBy(key, integer);
        return this.client.getIntegerReply();
    }

    public Double incrByFloat(byte[] key, double integer) {
        checkIsInMultiOrPipeline();
        this.client.incrByFloat(key, integer);
        String dval = this.client.getBulkReply();
        if (dval != null) {
            return new Double(dval);
        }
        return null;
    }

    public Long incr(byte[] key) {
        checkIsInMultiOrPipeline();
        this.client.incr(key);
        return this.client.getIntegerReply();
    }

    public Long append(byte[] key, byte[] value) {
        checkIsInMultiOrPipeline();
        this.client.append(key, value);
        return this.client.getIntegerReply();
    }

    public byte[] substr(byte[] key, int start, int end) {
        checkIsInMultiOrPipeline();
        this.client.substr(key, start, end);
        return this.client.getBinaryBulkReply();
    }

    public Long hset(byte[] key, byte[] field, byte[] value) {
        checkIsInMultiOrPipeline();
        this.client.hset(key, field, value);
        return this.client.getIntegerReply();
    }

    public byte[] hget(byte[] key, byte[] field) {
        checkIsInMultiOrPipeline();
        this.client.hget(key, field);
        return this.client.getBinaryBulkReply();
    }

    public Long hsetnx(byte[] key, byte[] field, byte[] value) {
        checkIsInMultiOrPipeline();
        this.client.hsetnx(key, field, value);
        return this.client.getIntegerReply();
    }

    public String hmset(byte[] key, Map<byte[], byte[]> hash) {
        checkIsInMultiOrPipeline();
        this.client.hmset(key, hash);
        return this.client.getStatusCodeReply();
    }

    public List<byte[]> hmget(byte[] key, byte[]... fields) {
        checkIsInMultiOrPipeline();
        this.client.hmget(key, fields);
        return this.client.getBinaryMultiBulkReply();
    }

    public Long hincrBy(byte[] key, byte[] field, long value) {
        checkIsInMultiOrPipeline();
        this.client.hincrBy(key, field, value);
        return this.client.getIntegerReply();
    }

    public Double hincrByFloat(byte[] key, byte[] field, double value) {
        checkIsInMultiOrPipeline();
        this.client.hincrByFloat(key, field, value);
        String dval = this.client.getBulkReply();
        if (dval != null) {
            return new Double(dval);
        }
        return null;
    }

    public Boolean hexists(byte[] key, byte[] field) {
        checkIsInMultiOrPipeline();
        this.client.hexists(key, field);
        return Boolean.valueOf(this.client.getIntegerReply().longValue() == 1);
    }

    public Long hdel(byte[] key, byte[]... fields) {
        checkIsInMultiOrPipeline();
        this.client.hdel(key, fields);
        return this.client.getIntegerReply();
    }

    public Long hlen(byte[] key) {
        checkIsInMultiOrPipeline();
        this.client.hlen(key);
        return this.client.getIntegerReply();
    }

    public Set<byte[]> hkeys(byte[] key) {
        checkIsInMultiOrPipeline();
        this.client.hkeys(key);
        return SetFromList.of(this.client.getBinaryMultiBulkReply());
    }

    public List<byte[]> hvals(byte[] key) {
        checkIsInMultiOrPipeline();
        this.client.hvals(key);
        return this.client.getBinaryMultiBulkReply();
    }

    public Map<byte[], byte[]> hgetAll(byte[] key) {
        checkIsInMultiOrPipeline();
        this.client.hgetAll(key);
        List<byte[]> flatHash = this.client.getBinaryMultiBulkReply();
        Map<byte[], byte[]> hash = new JedisByteHashMap();
        Iterator<byte[]> iterator = flatHash.iterator();
        while (iterator.hasNext()) {
            hash.put(iterator.next(), iterator.next());
        }
        return hash;
    }

    public Long rpush(byte[] key, byte[]... strings) {
        checkIsInMultiOrPipeline();
        this.client.rpush(key, strings);
        return this.client.getIntegerReply();
    }

    public Long lpush(byte[] key, byte[]... strings) {
        checkIsInMultiOrPipeline();
        this.client.lpush(key, strings);
        return this.client.getIntegerReply();
    }

    public Long llen(byte[] key) {
        checkIsInMultiOrPipeline();
        this.client.llen(key);
        return this.client.getIntegerReply();
    }

    public List<byte[]> lrange(byte[] key, long start, long end) {
        checkIsInMultiOrPipeline();
        this.client.lrange(key, start, end);
        return this.client.getBinaryMultiBulkReply();
    }

    public String ltrim(byte[] key, long start, long end) {
        checkIsInMultiOrPipeline();
        this.client.ltrim(key, start, end);
        return this.client.getStatusCodeReply();
    }

    public byte[] lindex(byte[] key, long index) {
        checkIsInMultiOrPipeline();
        this.client.lindex(key, index);
        return this.client.getBinaryBulkReply();
    }

    public String lset(byte[] key, long index, byte[] value) {
        checkIsInMultiOrPipeline();
        this.client.lset(key, index, value);
        return this.client.getStatusCodeReply();
    }

    public Long lrem(byte[] key, long count, byte[] value) {
        checkIsInMultiOrPipeline();
        this.client.lrem(key, count, value);
        return this.client.getIntegerReply();
    }

    public byte[] lpop(byte[] key) {
        checkIsInMultiOrPipeline();
        this.client.lpop(key);
        return this.client.getBinaryBulkReply();
    }

    public byte[] rpop(byte[] key) {
        checkIsInMultiOrPipeline();
        this.client.rpop(key);
        return this.client.getBinaryBulkReply();
    }

    public byte[] rpoplpush(byte[] srckey, byte[] dstkey) {
        checkIsInMultiOrPipeline();
        this.client.rpoplpush(srckey, dstkey);
        return this.client.getBinaryBulkReply();
    }

    public Long sadd(byte[] key, byte[]... members) {
        checkIsInMultiOrPipeline();
        this.client.sadd(key, members);
        return this.client.getIntegerReply();
    }

    public Set<byte[]> smembers(byte[] key) {
        checkIsInMultiOrPipeline();
        this.client.smembers(key);
        return SetFromList.of(this.client.getBinaryMultiBulkReply());
    }

    public Long srem(byte[] key, byte[]... member) {
        checkIsInMultiOrPipeline();
        this.client.srem(key, member);
        return this.client.getIntegerReply();
    }

    public byte[] spop(byte[] key) {
        checkIsInMultiOrPipeline();
        this.client.spop(key);
        return this.client.getBinaryBulkReply();
    }

    public Set<byte[]> spop(byte[] key, long count) {
        checkIsInMultiOrPipeline();
        this.client.spop(key, count);
        return SetFromList.of(this.client.getBinaryMultiBulkReply());
    }

    public Long smove(byte[] srckey, byte[] dstkey, byte[] member) {
        checkIsInMultiOrPipeline();
        this.client.smove(srckey, dstkey, member);
        return this.client.getIntegerReply();
    }

    public Long scard(byte[] key) {
        checkIsInMultiOrPipeline();
        this.client.scard(key);
        return this.client.getIntegerReply();
    }

    public Boolean sismember(byte[] key, byte[] member) {
        checkIsInMultiOrPipeline();
        this.client.sismember(key, member);
        return Boolean.valueOf(this.client.getIntegerReply().longValue() == 1);
    }

    public Set<byte[]> sinter(byte[]... keys) {
        checkIsInMultiOrPipeline();
        this.client.sinter(keys);
        return SetFromList.of(this.client.getBinaryMultiBulkReply());
    }

    public Long sinterstore(byte[] dstkey, byte[]... keys) {
        checkIsInMultiOrPipeline();
        this.client.sinterstore(dstkey, keys);
        return this.client.getIntegerReply();
    }

    public Set<byte[]> sunion(byte[]... keys) {
        checkIsInMultiOrPipeline();
        this.client.sunion(keys);
        return SetFromList.of(this.client.getBinaryMultiBulkReply());
    }

    public Long sunionstore(byte[] dstkey, byte[]... keys) {
        checkIsInMultiOrPipeline();
        this.client.sunionstore(dstkey, keys);
        return this.client.getIntegerReply();
    }

    public Set<byte[]> sdiff(byte[]... keys) {
        checkIsInMultiOrPipeline();
        this.client.sdiff(keys);
        return SetFromList.of(this.client.getBinaryMultiBulkReply());
    }

    public Long sdiffstore(byte[] dstkey, byte[]... keys) {
        checkIsInMultiOrPipeline();
        this.client.sdiffstore(dstkey, keys);
        return this.client.getIntegerReply();
    }

    public byte[] srandmember(byte[] key) {
        checkIsInMultiOrPipeline();
        this.client.srandmember(key);
        return this.client.getBinaryBulkReply();
    }

    public List<byte[]> srandmember(byte[] key, int count) {
        checkIsInMultiOrPipeline();
        this.client.srandmember(key, count);
        return this.client.getBinaryMultiBulkReply();
    }

    public Long zadd(byte[] key, double score, byte[] member) {
        checkIsInMultiOrPipeline();
        this.client.zadd(key, score, member);
        return this.client.getIntegerReply();
    }

    public Long zadd(byte[] key, double score, byte[] member, ZAddParams params) {
        checkIsInMultiOrPipeline();
        this.client.zadd(key, score, member, params);
        return this.client.getIntegerReply();
    }

    public Long zadd(byte[] key, Map<byte[], Double> scoreMembers) {
        checkIsInMultiOrPipeline();
        this.client.zadd(key, scoreMembers);
        return this.client.getIntegerReply();
    }

    public Long zadd(byte[] key, Map<byte[], Double> scoreMembers, ZAddParams params) {
        checkIsInMultiOrPipeline();
        this.client.zadd(key, scoreMembers, params);
        return this.client.getIntegerReply();
    }

    public Set<byte[]> zrange(byte[] key, long start, long end) {
        checkIsInMultiOrPipeline();
        this.client.zrange(key, start, end);
        return SetFromList.of(this.client.getBinaryMultiBulkReply());
    }

    public Long zrem(byte[] key, byte[]... members) {
        checkIsInMultiOrPipeline();
        this.client.zrem(key, members);
        return this.client.getIntegerReply();
    }

    public Double zincrby(byte[] key, double score, byte[] member) {
        checkIsInMultiOrPipeline();
        this.client.zincrby(key, score, member);
        return Double.valueOf(this.client.getBulkReply());
    }

    public Double zincrby(byte[] key, double score, byte[] member, ZIncrByParams params) {
        checkIsInMultiOrPipeline();
        this.client.zincrby(key, score, member, params);
        String newscore = this.client.getBulkReply();
        if (newscore == null) {
            return null;
        }
        return Double.valueOf(newscore);
    }

    public Long zrank(byte[] key, byte[] member) {
        checkIsInMultiOrPipeline();
        this.client.zrank(key, member);
        return this.client.getIntegerReply();
    }

    public Long zrevrank(byte[] key, byte[] member) {
        checkIsInMultiOrPipeline();
        this.client.zrevrank(key, member);
        return this.client.getIntegerReply();
    }

    public Set<byte[]> zrevrange(byte[] key, long start, long end) {
        checkIsInMultiOrPipeline();
        this.client.zrevrange(key, start, end);
        return SetFromList.of(this.client.getBinaryMultiBulkReply());
    }

    public Set<Tuple> zrangeWithScores(byte[] key, long start, long end) {
        checkIsInMultiOrPipeline();
        this.client.zrangeWithScores(key, start, end);
        return getBinaryTupledSet();
    }

    public Set<Tuple> zrevrangeWithScores(byte[] key, long start, long end) {
        checkIsInMultiOrPipeline();
        this.client.zrevrangeWithScores(key, start, end);
        return getBinaryTupledSet();
    }

    public Long zcard(byte[] key) {
        checkIsInMultiOrPipeline();
        this.client.zcard(key);
        return this.client.getIntegerReply();
    }

    public Double zscore(byte[] key, byte[] member) {
        checkIsInMultiOrPipeline();
        this.client.zscore(key, member);
        String score = this.client.getBulkReply();
        if (score != null) {
            return new Double(score);
        }
        return null;
    }

    public Transaction multi() {
        this.client.multi();
        this.client.getOne();
        Transaction transaction2 = new Transaction(this.client);
        this.transaction = transaction2;
        return transaction2;
    }

    /* access modifiers changed from: protected */
    public void checkIsInMultiOrPipeline() {
        if (!this.client.isInMulti()) {
            Pipeline pipeline2 = this.pipeline;
            if (pipeline2 != null && pipeline2.hasPipelinedResponse()) {
                throw new JedisDataException("Cannot use Jedis when in Pipeline. Please use Pipeline or reset jedis state .");
            }
            return;
        }
        throw new JedisDataException("Cannot use Jedis when in Multi. Please use Transation or reset jedis state.");
    }

    public void connect() {
        this.client.connect();
    }

    public void disconnect() {
        this.client.disconnect();
    }

    public void resetState() {
        if (this.client.isConnected()) {
            Transaction transaction2 = this.transaction;
            if (transaction2 != null) {
                transaction2.clear();
            }
            Pipeline pipeline2 = this.pipeline;
            if (pipeline2 != null) {
                pipeline2.clear();
            }
            if (this.client.isInWatch()) {
                unwatch();
            }
            this.client.resetState();
        }
        this.transaction = null;
        this.pipeline = null;
    }

    public String watch(byte[]... keys) {
        this.client.watch(keys);
        return this.client.getStatusCodeReply();
    }

    public String unwatch() {
        this.client.unwatch();
        return this.client.getStatusCodeReply();
    }

    public void close() {
        this.client.close();
    }

    public List<byte[]> sort(byte[] key) {
        checkIsInMultiOrPipeline();
        this.client.sort(key);
        return this.client.getBinaryMultiBulkReply();
    }

    public List<byte[]> sort(byte[] key, SortingParams sortingParameters) {
        checkIsInMultiOrPipeline();
        this.client.sort(key, sortingParameters);
        return this.client.getBinaryMultiBulkReply();
    }

    public List<byte[]> blpop(int timeout, byte[]... keys) {
        return blpop(getArgsAddTimeout(timeout, keys));
    }

    private byte[][] getArgsAddTimeout(int timeout, byte[][] keys) {
        int size = keys.length;
        byte[][] args = new byte[(size + 1)][];
        for (int at = 0; at != size; at++) {
            args[at] = keys[at];
        }
        args[size] = Protocol.toByteArray(timeout);
        return args;
    }

    public Long sort(byte[] key, SortingParams sortingParameters, byte[] dstkey) {
        checkIsInMultiOrPipeline();
        this.client.sort(key, sortingParameters, dstkey);
        return this.client.getIntegerReply();
    }

    public Long sort(byte[] key, byte[] dstkey) {
        checkIsInMultiOrPipeline();
        this.client.sort(key, dstkey);
        return this.client.getIntegerReply();
    }

    public List<byte[]> brpop(int timeout, byte[]... keys) {
        return brpop(getArgsAddTimeout(timeout, keys));
    }

    public List<byte[]> blpop(byte[]... args) {
        checkIsInMultiOrPipeline();
        this.client.blpop(args);
        this.client.setTimeoutInfinite();
        try {
            return this.client.getBinaryMultiBulkReply();
        } finally {
            this.client.rollbackTimeout();
        }
    }

    public List<byte[]> brpop(byte[]... args) {
        checkIsInMultiOrPipeline();
        this.client.brpop(args);
        this.client.setTimeoutInfinite();
        try {
            return this.client.getBinaryMultiBulkReply();
        } finally {
            this.client.rollbackTimeout();
        }
    }

    public String auth(String password) {
        checkIsInMultiOrPipeline();
        this.client.auth(password);
        return this.client.getStatusCodeReply();
    }

    public Pipeline pipelined() {
        Pipeline pipeline2 = new Pipeline();
        this.pipeline = pipeline2;
        pipeline2.setClient(this.client);
        return this.pipeline;
    }

    public Long zcount(byte[] key, double min, double max) {
        return zcount(key, Protocol.toByteArray(min), Protocol.toByteArray(max));
    }

    public Long zcount(byte[] key, byte[] min, byte[] max) {
        checkIsInMultiOrPipeline();
        this.client.zcount(key, min, max);
        return this.client.getIntegerReply();
    }

    public Set<byte[]> zrangeByScore(byte[] key, double min, double max) {
        return zrangeByScore(key, Protocol.toByteArray(min), Protocol.toByteArray(max));
    }

    public Set<byte[]> zrangeByScore(byte[] key, byte[] min, byte[] max) {
        checkIsInMultiOrPipeline();
        this.client.zrangeByScore(key, min, max);
        return SetFromList.of(this.client.getBinaryMultiBulkReply());
    }

    public Set<byte[]> zrangeByScore(byte[] key, double min, double max, int offset, int count) {
        return zrangeByScore(key, Protocol.toByteArray(min), Protocol.toByteArray(max), offset, count);
    }

    public Set<byte[]> zrangeByScore(byte[] key, byte[] min, byte[] max, int offset, int count) {
        checkIsInMultiOrPipeline();
        this.client.zrangeByScore(key, min, max, offset, count);
        return SetFromList.of(this.client.getBinaryMultiBulkReply());
    }

    public Set<Tuple> zrangeByScoreWithScores(byte[] key, double min, double max) {
        return zrangeByScoreWithScores(key, Protocol.toByteArray(min), Protocol.toByteArray(max));
    }

    public Set<Tuple> zrangeByScoreWithScores(byte[] key, byte[] min, byte[] max) {
        checkIsInMultiOrPipeline();
        this.client.zrangeByScoreWithScores(key, min, max);
        return getBinaryTupledSet();
    }

    public Set<Tuple> zrangeByScoreWithScores(byte[] key, double min, double max, int offset, int count) {
        return zrangeByScoreWithScores(key, Protocol.toByteArray(min), Protocol.toByteArray(max), offset, count);
    }

    public Set<Tuple> zrangeByScoreWithScores(byte[] key, byte[] min, byte[] max, int offset, int count) {
        checkIsInMultiOrPipeline();
        this.client.zrangeByScoreWithScores(key, min, max, offset, count);
        return getBinaryTupledSet();
    }

    private Set<Tuple> getBinaryTupledSet() {
        checkIsInMultiOrPipeline();
        List<byte[]> membersWithScores = this.client.getBinaryMultiBulkReply();
        if (membersWithScores.isEmpty()) {
            return Collections.emptySet();
        }
        Set<Tuple> set = new LinkedHashSet<>(membersWithScores.size() / 2, 1.0f);
        Iterator<byte[]> iterator = membersWithScores.iterator();
        while (iterator.hasNext()) {
            set.add(new Tuple(iterator.next(), Double.valueOf(SafeEncoder.encode(iterator.next()))));
        }
        return set;
    }

    public Set<byte[]> zrevrangeByScore(byte[] key, double max, double min) {
        return zrevrangeByScore(key, Protocol.toByteArray(max), Protocol.toByteArray(min));
    }

    public Set<byte[]> zrevrangeByScore(byte[] key, byte[] max, byte[] min) {
        checkIsInMultiOrPipeline();
        this.client.zrevrangeByScore(key, max, min);
        return SetFromList.of(this.client.getBinaryMultiBulkReply());
    }

    public Set<byte[]> zrevrangeByScore(byte[] key, double max, double min, int offset, int count) {
        return zrevrangeByScore(key, Protocol.toByteArray(max), Protocol.toByteArray(min), offset, count);
    }

    public Set<byte[]> zrevrangeByScore(byte[] key, byte[] max, byte[] min, int offset, int count) {
        checkIsInMultiOrPipeline();
        this.client.zrevrangeByScore(key, max, min, offset, count);
        return SetFromList.of(this.client.getBinaryMultiBulkReply());
    }

    public Set<Tuple> zrevrangeByScoreWithScores(byte[] key, double max, double min) {
        return zrevrangeByScoreWithScores(key, Protocol.toByteArray(max), Protocol.toByteArray(min));
    }

    public Set<Tuple> zrevrangeByScoreWithScores(byte[] key, double max, double min, int offset, int count) {
        return zrevrangeByScoreWithScores(key, Protocol.toByteArray(max), Protocol.toByteArray(min), offset, count);
    }

    public Set<Tuple> zrevrangeByScoreWithScores(byte[] key, byte[] max, byte[] min) {
        checkIsInMultiOrPipeline();
        this.client.zrevrangeByScoreWithScores(key, max, min);
        return getBinaryTupledSet();
    }

    public Set<Tuple> zrevrangeByScoreWithScores(byte[] key, byte[] max, byte[] min, int offset, int count) {
        checkIsInMultiOrPipeline();
        this.client.zrevrangeByScoreWithScores(key, max, min, offset, count);
        return getBinaryTupledSet();
    }

    public Long zremrangeByRank(byte[] key, long start, long end) {
        checkIsInMultiOrPipeline();
        this.client.zremrangeByRank(key, start, end);
        return this.client.getIntegerReply();
    }

    public Long zremrangeByScore(byte[] key, double start, double end) {
        return zremrangeByScore(key, Protocol.toByteArray(start), Protocol.toByteArray(end));
    }

    public Long zremrangeByScore(byte[] key, byte[] start, byte[] end) {
        checkIsInMultiOrPipeline();
        this.client.zremrangeByScore(key, start, end);
        return this.client.getIntegerReply();
    }

    public Long zunionstore(byte[] dstkey, byte[]... sets) {
        checkIsInMultiOrPipeline();
        this.client.zunionstore(dstkey, sets);
        return this.client.getIntegerReply();
    }

    public Long zunionstore(byte[] dstkey, ZParams params, byte[]... sets) {
        checkIsInMultiOrPipeline();
        this.client.zunionstore(dstkey, params, sets);
        return this.client.getIntegerReply();
    }

    public Long zinterstore(byte[] dstkey, byte[]... sets) {
        checkIsInMultiOrPipeline();
        this.client.zinterstore(dstkey, sets);
        return this.client.getIntegerReply();
    }

    public Long zinterstore(byte[] dstkey, ZParams params, byte[]... sets) {
        checkIsInMultiOrPipeline();
        this.client.zinterstore(dstkey, params, sets);
        return this.client.getIntegerReply();
    }

    public Long zlexcount(byte[] key, byte[] min, byte[] max) {
        checkIsInMultiOrPipeline();
        this.client.zlexcount(key, min, max);
        return this.client.getIntegerReply();
    }

    public Set<byte[]> zrangeByLex(byte[] key, byte[] min, byte[] max) {
        checkIsInMultiOrPipeline();
        this.client.zrangeByLex(key, min, max);
        return SetFromList.of(this.client.getBinaryMultiBulkReply());
    }

    public Set<byte[]> zrangeByLex(byte[] key, byte[] min, byte[] max, int offset, int count) {
        checkIsInMultiOrPipeline();
        this.client.zrangeByLex(key, min, max, offset, count);
        return SetFromList.of(this.client.getBinaryMultiBulkReply());
    }

    public Set<byte[]> zrevrangeByLex(byte[] key, byte[] max, byte[] min) {
        checkIsInMultiOrPipeline();
        this.client.zrevrangeByLex(key, max, min);
        return SetFromList.of(this.client.getBinaryMultiBulkReply());
    }

    public Set<byte[]> zrevrangeByLex(byte[] key, byte[] max, byte[] min, int offset, int count) {
        checkIsInMultiOrPipeline();
        this.client.zrevrangeByLex(key, max, min, offset, count);
        return SetFromList.of(this.client.getBinaryMultiBulkReply());
    }

    public Long zremrangeByLex(byte[] key, byte[] min, byte[] max) {
        checkIsInMultiOrPipeline();
        this.client.zremrangeByLex(key, min, max);
        return this.client.getIntegerReply();
    }

    public String save() {
        this.client.save();
        return this.client.getStatusCodeReply();
    }

    public String bgsave() {
        this.client.bgsave();
        return this.client.getStatusCodeReply();
    }

    public String bgrewriteaof() {
        this.client.bgrewriteaof();
        return this.client.getStatusCodeReply();
    }

    public Long lastsave() {
        this.client.lastsave();
        return this.client.getIntegerReply();
    }

    public String shutdown() {
        this.client.shutdown();
        try {
            return this.client.getStatusCodeReply();
        } catch (JedisException e) {
            return null;
        }
    }

    public String info() {
        this.client.info();
        return this.client.getBulkReply();
    }

    public String info(String section) {
        this.client.info(section);
        return this.client.getBulkReply();
    }

    public void monitor(JedisMonitor jedisMonitor) {
        this.client.monitor();
        this.client.getStatusCodeReply();
        jedisMonitor.proceed(this.client);
    }

    public String slaveof(String host, int port) {
        this.client.slaveof(host, port);
        return this.client.getStatusCodeReply();
    }

    public String slaveofNoOne() {
        this.client.slaveofNoOne();
        return this.client.getStatusCodeReply();
    }

    public List<byte[]> configGet(byte[] pattern) {
        this.client.configGet(pattern);
        return this.client.getBinaryMultiBulkReply();
    }

    public String configResetStat() {
        this.client.configResetStat();
        return this.client.getStatusCodeReply();
    }

    public byte[] configSet(byte[] parameter, byte[] value) {
        this.client.configSet(parameter, value);
        return this.client.getBinaryBulkReply();
    }

    public boolean isConnected() {
        return this.client.isConnected();
    }

    public Long strlen(byte[] key) {
        this.client.strlen(key);
        return this.client.getIntegerReply();
    }

    public void sync() {
        this.client.sync();
    }

    public Long lpushx(byte[] key, byte[]... string) {
        this.client.lpushx(key, string);
        return this.client.getIntegerReply();
    }

    public Long persist(byte[] key) {
        this.client.persist(key);
        return this.client.getIntegerReply();
    }

    public Long rpushx(byte[] key, byte[]... string) {
        this.client.rpushx(key, string);
        return this.client.getIntegerReply();
    }

    public byte[] echo(byte[] string) {
        this.client.echo(string);
        return this.client.getBinaryBulkReply();
    }

    public Long linsert(byte[] key, BinaryClient.LIST_POSITION where, byte[] pivot, byte[] value) {
        this.client.linsert(key, where, pivot, value);
        return this.client.getIntegerReply();
    }

    public String debug(DebugParams params) {
        this.client.debug(params);
        return this.client.getStatusCodeReply();
    }

    public Client getClient() {
        return this.client;
    }

    public byte[] brpoplpush(byte[] source, byte[] destination, int timeout) {
        this.client.brpoplpush(source, destination, timeout);
        this.client.setTimeoutInfinite();
        try {
            return this.client.getBinaryBulkReply();
        } finally {
            this.client.rollbackTimeout();
        }
    }

    public Boolean setbit(byte[] key, long offset, boolean value) {
        this.client.setbit(key, offset, value);
        return Boolean.valueOf(this.client.getIntegerReply().longValue() == 1);
    }

    public Boolean setbit(byte[] key, long offset, byte[] value) {
        this.client.setbit(key, offset, value);
        return Boolean.valueOf(this.client.getIntegerReply().longValue() == 1);
    }

    public Boolean getbit(byte[] key, long offset) {
        this.client.getbit(key, offset);
        return Boolean.valueOf(this.client.getIntegerReply().longValue() == 1);
    }

    public Long bitpos(byte[] key, boolean value) {
        return bitpos(key, value, new BitPosParams());
    }

    public Long bitpos(byte[] key, boolean value, BitPosParams params) {
        this.client.bitpos(key, value, params);
        return this.client.getIntegerReply();
    }

    public Long setrange(byte[] key, long offset, byte[] value) {
        this.client.setrange(key, offset, value);
        return this.client.getIntegerReply();
    }

    public byte[] getrange(byte[] key, long startOffset, long endOffset) {
        this.client.getrange(key, startOffset, endOffset);
        return this.client.getBinaryBulkReply();
    }

    public Long publish(byte[] channel, byte[] message) {
        this.client.publish(channel, message);
        return this.client.getIntegerReply();
    }

    public void subscribe(BinaryJedisPubSub jedisPubSub, byte[]... channels) {
        this.client.setTimeoutInfinite();
        try {
            jedisPubSub.proceed(this.client, channels);
        } finally {
            this.client.rollbackTimeout();
        }
    }

    public void psubscribe(BinaryJedisPubSub jedisPubSub, byte[]... patterns) {
        this.client.setTimeoutInfinite();
        try {
            jedisPubSub.proceedWithPatterns(this.client, patterns);
        } finally {
            this.client.rollbackTimeout();
        }
    }

    public int getDB() {
        return this.client.getDB();
    }

    public Object eval(byte[] script, List<byte[]> keys, List<byte[]> args) {
        return eval(script, Protocol.toByteArray(keys.size()), getParamsWithBinary(keys, args));
    }

    protected static byte[][] getParamsWithBinary(List<byte[]> keys, List<byte[]> args) {
        int keyCount = keys.size();
        int argCount = args.size();
        byte[][] params = new byte[(keyCount + argCount)][];
        for (int i = 0; i < keyCount; i++) {
            params[i] = keys.get(i);
        }
        for (int i2 = 0; i2 < argCount; i2++) {
            params[keyCount + i2] = args.get(i2);
        }
        return params;
    }

    public Object eval(byte[] script, byte[] keyCount, byte[]... params) {
        this.client.setTimeoutInfinite();
        try {
            this.client.eval(script, keyCount, params);
            return this.client.getOne();
        } finally {
            this.client.rollbackTimeout();
        }
    }

    public Object eval(byte[] script, int keyCount, byte[]... params) {
        return eval(script, Protocol.toByteArray(keyCount), params);
    }

    public Object eval(byte[] script) {
        return eval(script, 0, new byte[0][]);
    }

    public Object evalsha(byte[] sha1) {
        return evalsha(sha1, 1, new byte[0][]);
    }

    public Object evalsha(byte[] sha1, List<byte[]> keys, List<byte[]> args) {
        return evalsha(sha1, keys.size(), getParamsWithBinary(keys, args));
    }

    public Object evalsha(byte[] sha1, int keyCount, byte[]... params) {
        this.client.setTimeoutInfinite();
        try {
            this.client.evalsha(sha1, keyCount, params);
            return this.client.getOne();
        } finally {
            this.client.rollbackTimeout();
        }
    }

    public String scriptFlush() {
        this.client.scriptFlush();
        return this.client.getStatusCodeReply();
    }

    public Long scriptExists(byte[] sha1) {
        return scriptExists(sha1).get(0);
    }

    public List<Long> scriptExists(byte[]... sha1) {
        this.client.scriptExists(sha1);
        return this.client.getIntegerMultiBulkReply();
    }

    public byte[] scriptLoad(byte[] script) {
        this.client.scriptLoad(script);
        return this.client.getBinaryBulkReply();
    }

    public String scriptKill() {
        this.client.scriptKill();
        return this.client.getStatusCodeReply();
    }

    public String slowlogReset() {
        this.client.slowlogReset();
        return this.client.getBulkReply();
    }

    public Long slowlogLen() {
        this.client.slowlogLen();
        return this.client.getIntegerReply();
    }

    public List<byte[]> slowlogGetBinary() {
        this.client.slowlogGet();
        return this.client.getBinaryMultiBulkReply();
    }

    public List<byte[]> slowlogGetBinary(long entries) {
        this.client.slowlogGet(entries);
        return this.client.getBinaryMultiBulkReply();
    }

    public Long objectRefcount(byte[] key) {
        this.client.objectRefcount(key);
        return this.client.getIntegerReply();
    }

    public byte[] objectEncoding(byte[] key) {
        this.client.objectEncoding(key);
        return this.client.getBinaryBulkReply();
    }

    public Long objectIdletime(byte[] key) {
        this.client.objectIdletime(key);
        return this.client.getIntegerReply();
    }

    public Long bitcount(byte[] key) {
        this.client.bitcount(key);
        return this.client.getIntegerReply();
    }

    public Long bitcount(byte[] key, long start, long end) {
        this.client.bitcount(key, start, end);
        return this.client.getIntegerReply();
    }

    public Long bitop(BitOP op, byte[] destKey, byte[]... srcKeys) {
        this.client.bitop(op, destKey, srcKeys);
        return this.client.getIntegerReply();
    }

    public byte[] dump(byte[] key) {
        checkIsInMultiOrPipeline();
        this.client.dump(key);
        return this.client.getBinaryBulkReply();
    }

    public String restore(byte[] key, int ttl, byte[] serializedValue) {
        checkIsInMultiOrPipeline();
        this.client.restore(key, ttl, serializedValue);
        return this.client.getStatusCodeReply();
    }

    public Long pexpire(byte[] key, long milliseconds) {
        checkIsInMultiOrPipeline();
        this.client.pexpire(key, milliseconds);
        return this.client.getIntegerReply();
    }

    public Long pexpireAt(byte[] key, long millisecondsTimestamp) {
        checkIsInMultiOrPipeline();
        this.client.pexpireAt(key, millisecondsTimestamp);
        return this.client.getIntegerReply();
    }

    public Long pttl(byte[] key) {
        checkIsInMultiOrPipeline();
        this.client.pttl(key);
        return this.client.getIntegerReply();
    }

    public String psetex(byte[] key, long milliseconds, byte[] value) {
        checkIsInMultiOrPipeline();
        this.client.psetex(key, milliseconds, value);
        return this.client.getStatusCodeReply();
    }

    public String clientKill(byte[] client2) {
        checkIsInMultiOrPipeline();
        this.client.clientKill(client2);
        return this.client.getStatusCodeReply();
    }

    public String clientGetname() {
        checkIsInMultiOrPipeline();
        this.client.clientGetname();
        return this.client.getBulkReply();
    }

    public String clientList() {
        checkIsInMultiOrPipeline();
        this.client.clientList();
        return this.client.getBulkReply();
    }

    public String clientSetname(byte[] name) {
        checkIsInMultiOrPipeline();
        this.client.clientSetname(name);
        return this.client.getBulkReply();
    }

    public List<String> time() {
        checkIsInMultiOrPipeline();
        this.client.time();
        return this.client.getMultiBulkReply();
    }

    public String migrate(byte[] host, int port, byte[] key, int destinationDb, int timeout) {
        checkIsInMultiOrPipeline();
        this.client.migrate(host, port, key, destinationDb, timeout);
        return this.client.getStatusCodeReply();
    }

    public Long waitReplicas(int replicas, long timeout) {
        checkIsInMultiOrPipeline();
        this.client.waitReplicas(replicas, timeout);
        return this.client.getIntegerReply();
    }

    public Long pfadd(byte[] key, byte[]... elements) {
        checkIsInMultiOrPipeline();
        this.client.pfadd(key, elements);
        return this.client.getIntegerReply();
    }

    public long pfcount(byte[] key) {
        checkIsInMultiOrPipeline();
        this.client.pfcount(key);
        return this.client.getIntegerReply().longValue();
    }

    public String pfmerge(byte[] destkey, byte[]... sourcekeys) {
        checkIsInMultiOrPipeline();
        this.client.pfmerge(destkey, sourcekeys);
        return this.client.getStatusCodeReply();
    }

    public Long pfcount(byte[]... keys) {
        checkIsInMultiOrPipeline();
        this.client.pfcount(keys);
        return this.client.getIntegerReply();
    }

    public ScanResult<byte[]> scan(byte[] cursor) {
        return scan(cursor, new ScanParams());
    }

    public ScanResult<byte[]> scan(byte[] cursor, ScanParams params) {
        checkIsInMultiOrPipeline();
        this.client.scan(cursor, params);
        List<Object> result = this.client.getObjectMultiBulkReply();
        return new ScanResult<>((byte[]) result.get(0), (List) result.get(1));
    }

    public ScanResult<Map.Entry<byte[], byte[]>> hscan(byte[] key, byte[] cursor) {
        return hscan(key, cursor, new ScanParams());
    }

    public ScanResult<Map.Entry<byte[], byte[]>> hscan(byte[] key, byte[] cursor, ScanParams params) {
        checkIsInMultiOrPipeline();
        this.client.hscan(key, cursor, params);
        List<Object> result = this.client.getObjectMultiBulkReply();
        byte[] newcursor = (byte[]) result.get(0);
        List<Map.Entry<byte[], byte[]>> results = new ArrayList<>();
        Iterator<byte[]> iterator = ((List) result.get(1)).iterator();
        while (iterator.hasNext()) {
            results.add(new AbstractMap.SimpleEntry(iterator.next(), iterator.next()));
        }
        return new ScanResult<>(newcursor, results);
    }

    public ScanResult<byte[]> sscan(byte[] key, byte[] cursor) {
        return sscan(key, cursor, new ScanParams());
    }

    public ScanResult<byte[]> sscan(byte[] key, byte[] cursor, ScanParams params) {
        checkIsInMultiOrPipeline();
        this.client.sscan(key, cursor, params);
        List<Object> result = this.client.getObjectMultiBulkReply();
        return new ScanResult<>((byte[]) result.get(0), (List) result.get(1));
    }

    public ScanResult<Tuple> zscan(byte[] key, byte[] cursor) {
        return zscan(key, cursor, new ScanParams());
    }

    public ScanResult<Tuple> zscan(byte[] key, byte[] cursor, ScanParams params) {
        checkIsInMultiOrPipeline();
        this.client.zscan(key, cursor, params);
        List<Object> result = this.client.getObjectMultiBulkReply();
        byte[] newcursor = (byte[]) result.get(0);
        List<Tuple> results = new ArrayList<>();
        Iterator<byte[]> iterator = ((List) result.get(1)).iterator();
        while (iterator.hasNext()) {
            results.add(new Tuple(iterator.next(), Double.valueOf(SafeEncoder.encode(iterator.next()))));
        }
        return new ScanResult<>(newcursor, results);
    }

    public Long geoadd(byte[] key, double longitude, double latitude, byte[] member) {
        checkIsInMultiOrPipeline();
        this.client.geoadd(key, longitude, latitude, member);
        return this.client.getIntegerReply();
    }

    public Long geoadd(byte[] key, Map<byte[], GeoCoordinate> memberCoordinateMap) {
        checkIsInMultiOrPipeline();
        this.client.geoadd(key, memberCoordinateMap);
        return this.client.getIntegerReply();
    }

    public Double geodist(byte[] key, byte[] member1, byte[] member2) {
        checkIsInMultiOrPipeline();
        this.client.geodist(key, member1, member2);
        String dval = this.client.getBulkReply();
        if (dval != null) {
            return new Double(dval);
        }
        return null;
    }

    public Double geodist(byte[] key, byte[] member1, byte[] member2, GeoUnit unit) {
        checkIsInMultiOrPipeline();
        this.client.geodist(key, member1, member2, unit);
        String dval = this.client.getBulkReply();
        if (dval != null) {
            return new Double(dval);
        }
        return null;
    }

    public List<byte[]> geohash(byte[] key, byte[]... members) {
        checkIsInMultiOrPipeline();
        this.client.geohash(key, members);
        return this.client.getBinaryMultiBulkReply();
    }

    public List<GeoCoordinate> geopos(byte[] key, byte[]... members) {
        checkIsInMultiOrPipeline();
        this.client.geopos(key, members);
        return BuilderFactory.GEO_COORDINATE_LIST.build(this.client.getObjectMultiBulkReply());
    }

    public List<GeoRadiusResponse> georadius(byte[] key, double longitude, double latitude, double radius, GeoUnit unit) {
        checkIsInMultiOrPipeline();
        this.client.georadius(key, longitude, latitude, radius, unit);
        return BuilderFactory.GEORADIUS_WITH_PARAMS_RESULT.build(this.client.getObjectMultiBulkReply());
    }

    public List<GeoRadiusResponse> georadius(byte[] key, double longitude, double latitude, double radius, GeoUnit unit, GeoRadiusParam param) {
        checkIsInMultiOrPipeline();
        this.client.georadius(key, longitude, latitude, radius, unit, param);
        return BuilderFactory.GEORADIUS_WITH_PARAMS_RESULT.build(this.client.getObjectMultiBulkReply());
    }

    public List<GeoRadiusResponse> georadiusByMember(byte[] key, byte[] member, double radius, GeoUnit unit) {
        checkIsInMultiOrPipeline();
        this.client.georadiusByMember(key, member, radius, unit);
        return BuilderFactory.GEORADIUS_WITH_PARAMS_RESULT.build(this.client.getObjectMultiBulkReply());
    }

    public List<GeoRadiusResponse> georadiusByMember(byte[] key, byte[] member, double radius, GeoUnit unit, GeoRadiusParam param) {
        checkIsInMultiOrPipeline();
        this.client.georadiusByMember(key, member, radius, unit, param);
        return BuilderFactory.GEORADIUS_WITH_PARAMS_RESULT.build(this.client.getObjectMultiBulkReply());
    }

    protected static class SetFromList<E> extends AbstractSet<E> implements Serializable {
        private static final long serialVersionUID = -2850347066962734052L;
        private final transient List<E> list;

        private SetFromList(List<E> list2) {
            if (list2 != null) {
                this.list = list2;
                return;
            }
            throw new NullPointerException("list");
        }

        public void clear() {
            this.list.clear();
        }

        public int size() {
            return this.list.size();
        }

        public boolean isEmpty() {
            return this.list.isEmpty();
        }

        public boolean contains(Object o) {
            return this.list.contains(o);
        }

        public boolean remove(Object o) {
            return this.list.remove(o);
        }

        public boolean add(E e) {
            return !contains(e) && this.list.add(e);
        }

        public Iterator<E> iterator() {
            return this.list.iterator();
        }

        public Object[] toArray() {
            return this.list.toArray();
        }

        public <T> T[] toArray(T[] a) {
            return this.list.toArray(a);
        }

        public String toString() {
            return this.list.toString();
        }

        public int hashCode() {
            return this.list.hashCode();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Set)) {
                return false;
            }
            Collection<?> c = (Collection) o;
            if (c.size() != size()) {
                return false;
            }
            return containsAll(c);
        }

        public boolean containsAll(Collection<?> c) {
            return this.list.containsAll(c);
        }

        public boolean removeAll(Collection<?> c) {
            return this.list.removeAll(c);
        }

        public boolean retainAll(Collection<?> c) {
            return this.list.retainAll(c);
        }

        protected static <E> SetFromList<E> of(List<E> list2) {
            return new SetFromList<>(list2);
        }
    }

    public List<Long> bitfield(byte[] key, byte[]... arguments) {
        checkIsInMultiOrPipeline();
        this.client.bitfield(key, arguments);
        return this.client.getIntegerMultiBulkReply();
    }

    public Long hstrlen(byte[] key, byte[] field) {
        checkIsInMultiOrPipeline();
        this.client.hstrlen(key, field);
        return this.client.getIntegerReply();
    }
}
