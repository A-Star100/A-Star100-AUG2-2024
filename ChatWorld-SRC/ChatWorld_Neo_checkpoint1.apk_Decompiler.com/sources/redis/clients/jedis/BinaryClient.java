package redis.clients.jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocketFactory;
import redis.clients.jedis.Protocol;
import redis.clients.jedis.commands.ProtocolCommand;
import redis.clients.jedis.params.geo.GeoRadiusParam;
import redis.clients.jedis.params.set.SetParams;
import redis.clients.jedis.params.sortedset.ZAddParams;
import redis.clients.jedis.params.sortedset.ZIncrByParams;

public class BinaryClient extends Connection {
    private static /* synthetic */ int[] $SWITCH_TABLE$redis$clients$jedis$BitOP;
    private int db;
    private boolean isInMulti;
    private boolean isInWatch;
    private String password;

    public enum LIST_POSITION {
        BEFORE,
        AFTER;
        
        public final byte[] raw;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$redis$clients$jedis$BitOP() {
        int[] iArr = $SWITCH_TABLE$redis$clients$jedis$BitOP;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[BitOP.values().length];
        try {
            iArr2[BitOP.AND.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            iArr2[BitOP.NOT.ordinal()] = 4;
        } catch (NoSuchFieldError e2) {
        }
        try {
            iArr2[BitOP.OR.ordinal()] = 2;
        } catch (NoSuchFieldError e3) {
        }
        try {
            iArr2[BitOP.XOR.ordinal()] = 3;
        } catch (NoSuchFieldError e4) {
        }
        $SWITCH_TABLE$redis$clients$jedis$BitOP = iArr2;
        return iArr2;
    }

    public BinaryClient() {
    }

    public BinaryClient(String host) {
        super(host);
    }

    public BinaryClient(String host, int port) {
        super(host, port);
    }

    public BinaryClient(String host, int port, boolean ssl) {
        super(host, port, ssl);
    }

    public BinaryClient(String host, int port, boolean ssl, SSLSocketFactory sslSocketFactory, SSLParameters sslParameters, HostnameVerifier hostnameVerifier) {
        super(host, port, ssl, sslSocketFactory, sslParameters, hostnameVerifier);
    }

    public boolean isInMulti() {
        return this.isInMulti;
    }

    public boolean isInWatch() {
        return this.isInWatch;
    }

    private byte[][] joinParameters(byte[] first, byte[][] rest) {
        byte[][] result = new byte[(rest.length + 1)][];
        result[0] = first;
        System.arraycopy(rest, 0, result, 1, rest.length);
        return result;
    }

    public void setPassword(String password2) {
        this.password = password2;
    }

    public void setDb(int db2) {
        this.db = db2;
    }

    public void connect() {
        if (!isConnected()) {
            super.connect();
            String str = this.password;
            if (str != null) {
                auth(str);
                getStatusCodeReply();
            }
            int i = this.db;
            if (i > 0) {
                select(Long.valueOf((long) i).intValue());
                getStatusCodeReply();
            }
        }
    }

    public void ping() {
        sendCommand(Protocol.Command.PING);
    }

    public void set(byte[] key, byte[] value) {
        sendCommand((ProtocolCommand) Protocol.Command.SET, key, value);
    }

    public void set(byte[] key, byte[] value, SetParams params) {
        sendCommand((ProtocolCommand) Protocol.Command.SET, params.getByteParams(key, value));
    }

    public void get(byte[] key) {
        sendCommand((ProtocolCommand) Protocol.Command.GET, key);
    }

    public void quit() {
        this.db = 0;
        sendCommand(Protocol.Command.QUIT);
    }

    public void exists(byte[]... keys) {
        sendCommand((ProtocolCommand) Protocol.Command.EXISTS, keys);
    }

    public void exists(byte[] key) {
        sendCommand((ProtocolCommand) Protocol.Command.EXISTS, key);
    }

    public void del(byte[]... keys) {
        sendCommand((ProtocolCommand) Protocol.Command.DEL, keys);
    }

    public void type(byte[] key) {
        sendCommand((ProtocolCommand) Protocol.Command.TYPE, key);
    }

    public void flushDB() {
        sendCommand(Protocol.Command.FLUSHDB);
    }

    public void keys(byte[] pattern) {
        sendCommand((ProtocolCommand) Protocol.Command.KEYS, pattern);
    }

    public void randomKey() {
        sendCommand(Protocol.Command.RANDOMKEY);
    }

    public void rename(byte[] oldkey, byte[] newkey) {
        sendCommand((ProtocolCommand) Protocol.Command.RENAME, oldkey, newkey);
    }

    public void renamenx(byte[] oldkey, byte[] newkey) {
        sendCommand((ProtocolCommand) Protocol.Command.RENAMENX, oldkey, newkey);
    }

    public void dbSize() {
        sendCommand(Protocol.Command.DBSIZE);
    }

    public void expire(byte[] key, int seconds) {
        sendCommand((ProtocolCommand) Protocol.Command.EXPIRE, key, Protocol.toByteArray(seconds));
    }

    public void expireAt(byte[] key, long unixTime) {
        sendCommand((ProtocolCommand) Protocol.Command.EXPIREAT, key, Protocol.toByteArray(unixTime));
    }

    public void ttl(byte[] key) {
        sendCommand((ProtocolCommand) Protocol.Command.TTL, key);
    }

    public void select(int index) {
        sendCommand((ProtocolCommand) Protocol.Command.SELECT, Protocol.toByteArray(index));
    }

    public void move(byte[] key, int dbIndex) {
        sendCommand((ProtocolCommand) Protocol.Command.MOVE, key, Protocol.toByteArray(dbIndex));
    }

    public void flushAll() {
        sendCommand(Protocol.Command.FLUSHALL);
    }

    public void getSet(byte[] key, byte[] value) {
        sendCommand((ProtocolCommand) Protocol.Command.GETSET, key, value);
    }

    public void mget(byte[]... keys) {
        sendCommand((ProtocolCommand) Protocol.Command.MGET, keys);
    }

    public void setnx(byte[] key, byte[] value) {
        sendCommand((ProtocolCommand) Protocol.Command.SETNX, key, value);
    }

    public void setex(byte[] key, int seconds, byte[] value) {
        sendCommand((ProtocolCommand) Protocol.Command.SETEX, key, Protocol.toByteArray(seconds), value);
    }

    public void mset(byte[]... keysvalues) {
        sendCommand((ProtocolCommand) Protocol.Command.MSET, keysvalues);
    }

    public void msetnx(byte[]... keysvalues) {
        sendCommand((ProtocolCommand) Protocol.Command.MSETNX, keysvalues);
    }

    public void decrBy(byte[] key, long integer) {
        sendCommand((ProtocolCommand) Protocol.Command.DECRBY, key, Protocol.toByteArray(integer));
    }

    public void decr(byte[] key) {
        sendCommand((ProtocolCommand) Protocol.Command.DECR, key);
    }

    public void incrBy(byte[] key, long integer) {
        sendCommand((ProtocolCommand) Protocol.Command.INCRBY, key, Protocol.toByteArray(integer));
    }

    public void incrByFloat(byte[] key, double value) {
        sendCommand((ProtocolCommand) Protocol.Command.INCRBYFLOAT, key, Protocol.toByteArray(value));
    }

    public void incr(byte[] key) {
        sendCommand((ProtocolCommand) Protocol.Command.INCR, key);
    }

    public void append(byte[] key, byte[] value) {
        sendCommand((ProtocolCommand) Protocol.Command.APPEND, key, value);
    }

    public void substr(byte[] key, int start, int end) {
        sendCommand((ProtocolCommand) Protocol.Command.SUBSTR, key, Protocol.toByteArray(start), Protocol.toByteArray(end));
    }

    public void hset(byte[] key, byte[] field, byte[] value) {
        sendCommand((ProtocolCommand) Protocol.Command.HSET, key, field, value);
    }

    public void hget(byte[] key, byte[] field) {
        sendCommand((ProtocolCommand) Protocol.Command.HGET, key, field);
    }

    public void hsetnx(byte[] key, byte[] field, byte[] value) {
        sendCommand((ProtocolCommand) Protocol.Command.HSETNX, key, field, value);
    }

    public void hmset(byte[] key, Map<byte[], byte[]> hash) {
        List<byte[]> params = new ArrayList<>();
        params.add(key);
        for (Map.Entry<byte[], byte[]> entry : hash.entrySet()) {
            params.add(entry.getKey());
            params.add(entry.getValue());
        }
        sendCommand((ProtocolCommand) Protocol.Command.HMSET, (byte[][]) params.toArray(new byte[params.size()][]));
    }

    public void hmget(byte[] key, byte[]... fields) {
        byte[][] params = new byte[(fields.length + 1)][];
        params[0] = key;
        System.arraycopy(fields, 0, params, 1, fields.length);
        sendCommand((ProtocolCommand) Protocol.Command.HMGET, params);
    }

    public void hincrBy(byte[] key, byte[] field, long value) {
        sendCommand((ProtocolCommand) Protocol.Command.HINCRBY, key, field, Protocol.toByteArray(value));
    }

    public void hexists(byte[] key, byte[] field) {
        sendCommand((ProtocolCommand) Protocol.Command.HEXISTS, key, field);
    }

    public void hdel(byte[] key, byte[]... fields) {
        sendCommand((ProtocolCommand) Protocol.Command.HDEL, joinParameters(key, fields));
    }

    public void hlen(byte[] key) {
        sendCommand((ProtocolCommand) Protocol.Command.HLEN, key);
    }

    public void hkeys(byte[] key) {
        sendCommand((ProtocolCommand) Protocol.Command.HKEYS, key);
    }

    public void hvals(byte[] key) {
        sendCommand((ProtocolCommand) Protocol.Command.HVALS, key);
    }

    public void hgetAll(byte[] key) {
        sendCommand((ProtocolCommand) Protocol.Command.HGETALL, key);
    }

    public void rpush(byte[] key, byte[]... strings) {
        sendCommand((ProtocolCommand) Protocol.Command.RPUSH, joinParameters(key, strings));
    }

    public void lpush(byte[] key, byte[]... strings) {
        sendCommand((ProtocolCommand) Protocol.Command.LPUSH, joinParameters(key, strings));
    }

    public void llen(byte[] key) {
        sendCommand((ProtocolCommand) Protocol.Command.LLEN, key);
    }

    public void lrange(byte[] key, long start, long end) {
        sendCommand((ProtocolCommand) Protocol.Command.LRANGE, key, Protocol.toByteArray(start), Protocol.toByteArray(end));
    }

    public void ltrim(byte[] key, long start, long end) {
        sendCommand((ProtocolCommand) Protocol.Command.LTRIM, key, Protocol.toByteArray(start), Protocol.toByteArray(end));
    }

    public void lindex(byte[] key, long index) {
        sendCommand((ProtocolCommand) Protocol.Command.LINDEX, key, Protocol.toByteArray(index));
    }

    public void lset(byte[] key, long index, byte[] value) {
        sendCommand((ProtocolCommand) Protocol.Command.LSET, key, Protocol.toByteArray(index), value);
    }

    public void lrem(byte[] key, long count, byte[] value) {
        sendCommand((ProtocolCommand) Protocol.Command.LREM, key, Protocol.toByteArray(count), value);
    }

    public void lpop(byte[] key) {
        sendCommand((ProtocolCommand) Protocol.Command.LPOP, key);
    }

    public void rpop(byte[] key) {
        sendCommand((ProtocolCommand) Protocol.Command.RPOP, key);
    }

    public void rpoplpush(byte[] srckey, byte[] dstkey) {
        sendCommand((ProtocolCommand) Protocol.Command.RPOPLPUSH, srckey, dstkey);
    }

    public void sadd(byte[] key, byte[]... members) {
        sendCommand((ProtocolCommand) Protocol.Command.SADD, joinParameters(key, members));
    }

    public void smembers(byte[] key) {
        sendCommand((ProtocolCommand) Protocol.Command.SMEMBERS, key);
    }

    public void srem(byte[] key, byte[]... members) {
        sendCommand((ProtocolCommand) Protocol.Command.SREM, joinParameters(key, members));
    }

    public void spop(byte[] key) {
        sendCommand((ProtocolCommand) Protocol.Command.SPOP, key);
    }

    public void spop(byte[] key, long count) {
        sendCommand((ProtocolCommand) Protocol.Command.SPOP, key, Protocol.toByteArray(count));
    }

    public void smove(byte[] srckey, byte[] dstkey, byte[] member) {
        sendCommand((ProtocolCommand) Protocol.Command.SMOVE, srckey, dstkey, member);
    }

    public void scard(byte[] key) {
        sendCommand((ProtocolCommand) Protocol.Command.SCARD, key);
    }

    public void sismember(byte[] key, byte[] member) {
        sendCommand((ProtocolCommand) Protocol.Command.SISMEMBER, key, member);
    }

    public void sinter(byte[]... keys) {
        sendCommand((ProtocolCommand) Protocol.Command.SINTER, keys);
    }

    public void sinterstore(byte[] dstkey, byte[]... keys) {
        byte[][] params = new byte[(keys.length + 1)][];
        params[0] = dstkey;
        System.arraycopy(keys, 0, params, 1, keys.length);
        sendCommand((ProtocolCommand) Protocol.Command.SINTERSTORE, params);
    }

    public void sunion(byte[]... keys) {
        sendCommand((ProtocolCommand) Protocol.Command.SUNION, keys);
    }

    public void sunionstore(byte[] dstkey, byte[]... keys) {
        byte[][] params = new byte[(keys.length + 1)][];
        params[0] = dstkey;
        System.arraycopy(keys, 0, params, 1, keys.length);
        sendCommand((ProtocolCommand) Protocol.Command.SUNIONSTORE, params);
    }

    public void sdiff(byte[]... keys) {
        sendCommand((ProtocolCommand) Protocol.Command.SDIFF, keys);
    }

    public void sdiffstore(byte[] dstkey, byte[]... keys) {
        byte[][] params = new byte[(keys.length + 1)][];
        params[0] = dstkey;
        System.arraycopy(keys, 0, params, 1, keys.length);
        sendCommand((ProtocolCommand) Protocol.Command.SDIFFSTORE, params);
    }

    public void srandmember(byte[] key) {
        sendCommand((ProtocolCommand) Protocol.Command.SRANDMEMBER, key);
    }

    public void zadd(byte[] key, double score, byte[] member) {
        sendCommand((ProtocolCommand) Protocol.Command.ZADD, key, Protocol.toByteArray(score), member);
    }

    public void zadd(byte[] key, double score, byte[] member, ZAddParams params) {
        sendCommand((ProtocolCommand) Protocol.Command.ZADD, params.getByteParams(key, Protocol.toByteArray(score), member));
    }

    public void zadd(byte[] key, Map<byte[], Double> scoreMembers) {
        ArrayList<byte[]> args = new ArrayList<>((scoreMembers.size() * 2) + 1);
        args.add(key);
        args.addAll(convertScoreMembersToByteArrays(scoreMembers));
        byte[][] argsArray = new byte[args.size()][];
        args.toArray(argsArray);
        sendCommand((ProtocolCommand) Protocol.Command.ZADD, argsArray);
    }

    public void zadd(byte[] key, Map<byte[], Double> scoreMembers, ZAddParams params) {
        ArrayList<byte[]> args = convertScoreMembersToByteArrays(scoreMembers);
        byte[][] argsArray = new byte[args.size()][];
        args.toArray(argsArray);
        sendCommand((ProtocolCommand) Protocol.Command.ZADD, params.getByteParams(key, argsArray));
    }

    public void zrange(byte[] key, long start, long end) {
        sendCommand((ProtocolCommand) Protocol.Command.ZRANGE, key, Protocol.toByteArray(start), Protocol.toByteArray(end));
    }

    public void zrem(byte[] key, byte[]... members) {
        sendCommand((ProtocolCommand) Protocol.Command.ZREM, joinParameters(key, members));
    }

    public void zincrby(byte[] key, double score, byte[] member) {
        sendCommand((ProtocolCommand) Protocol.Command.ZINCRBY, key, Protocol.toByteArray(score), member);
    }

    public void zincrby(byte[] key, double score, byte[] member, ZIncrByParams params) {
        sendCommand((ProtocolCommand) Protocol.Command.ZADD, params.getByteParams(key, Protocol.toByteArray(score), member));
    }

    public void zrank(byte[] key, byte[] member) {
        sendCommand((ProtocolCommand) Protocol.Command.ZRANK, key, member);
    }

    public void zrevrank(byte[] key, byte[] member) {
        sendCommand((ProtocolCommand) Protocol.Command.ZREVRANK, key, member);
    }

    public void zrevrange(byte[] key, long start, long end) {
        sendCommand((ProtocolCommand) Protocol.Command.ZREVRANGE, key, Protocol.toByteArray(start), Protocol.toByteArray(end));
    }

    public void zrangeWithScores(byte[] key, long start, long end) {
        sendCommand((ProtocolCommand) Protocol.Command.ZRANGE, key, Protocol.toByteArray(start), Protocol.toByteArray(end), Protocol.Keyword.WITHSCORES.raw);
    }

    public void zrevrangeWithScores(byte[] key, long start, long end) {
        sendCommand((ProtocolCommand) Protocol.Command.ZREVRANGE, key, Protocol.toByteArray(start), Protocol.toByteArray(end), Protocol.Keyword.WITHSCORES.raw);
    }

    public void zcard(byte[] key) {
        sendCommand((ProtocolCommand) Protocol.Command.ZCARD, key);
    }

    public void zscore(byte[] key, byte[] member) {
        sendCommand((ProtocolCommand) Protocol.Command.ZSCORE, key, member);
    }

    public void multi() {
        sendCommand(Protocol.Command.MULTI);
        this.isInMulti = true;
    }

    public void discard() {
        sendCommand(Protocol.Command.DISCARD);
        this.isInMulti = false;
        this.isInWatch = false;
    }

    public void exec() {
        sendCommand(Protocol.Command.EXEC);
        this.isInMulti = false;
        this.isInWatch = false;
    }

    public void watch(byte[]... keys) {
        sendCommand((ProtocolCommand) Protocol.Command.WATCH, keys);
        this.isInWatch = true;
    }

    public void unwatch() {
        sendCommand(Protocol.Command.UNWATCH);
        this.isInWatch = false;
    }

    public void sort(byte[] key) {
        sendCommand((ProtocolCommand) Protocol.Command.SORT, key);
    }

    public void sort(byte[] key, SortingParams sortingParameters) {
        List<byte[]> args = new ArrayList<>();
        args.add(key);
        args.addAll(sortingParameters.getParams());
        sendCommand((ProtocolCommand) Protocol.Command.SORT, (byte[][]) args.toArray(new byte[args.size()][]));
    }

    public void blpop(byte[][] args) {
        sendCommand((ProtocolCommand) Protocol.Command.BLPOP, args);
    }

    public void blpop(int timeout, byte[]... keys) {
        List<byte[]> args = new ArrayList<>();
        for (byte[] arg : keys) {
            args.add(arg);
        }
        args.add(Protocol.toByteArray(timeout));
        blpop((byte[][]) args.toArray(new byte[args.size()][]));
    }

    public void sort(byte[] key, SortingParams sortingParameters, byte[] dstkey) {
        List<byte[]> args = new ArrayList<>();
        args.add(key);
        args.addAll(sortingParameters.getParams());
        args.add(Protocol.Keyword.STORE.raw);
        args.add(dstkey);
        sendCommand((ProtocolCommand) Protocol.Command.SORT, (byte[][]) args.toArray(new byte[args.size()][]));
    }

    public void sort(byte[] key, byte[] dstkey) {
        sendCommand((ProtocolCommand) Protocol.Command.SORT, key, Protocol.Keyword.STORE.raw, dstkey);
    }

    public void brpop(byte[][] args) {
        sendCommand((ProtocolCommand) Protocol.Command.BRPOP, args);
    }

    public void brpop(int timeout, byte[]... keys) {
        List<byte[]> args = new ArrayList<>();
        for (byte[] arg : keys) {
            args.add(arg);
        }
        args.add(Protocol.toByteArray(timeout));
        brpop((byte[][]) args.toArray(new byte[args.size()][]));
    }

    public void auth(String password2) {
        setPassword(password2);
        sendCommand((ProtocolCommand) Protocol.Command.AUTH, password2);
    }

    public void subscribe(byte[]... channels) {
        sendCommand((ProtocolCommand) Protocol.Command.SUBSCRIBE, channels);
    }

    public void publish(byte[] channel, byte[] message) {
        sendCommand((ProtocolCommand) Protocol.Command.PUBLISH, channel, message);
    }

    public void unsubscribe() {
        sendCommand(Protocol.Command.UNSUBSCRIBE);
    }

    public void unsubscribe(byte[]... channels) {
        sendCommand((ProtocolCommand) Protocol.Command.UNSUBSCRIBE, channels);
    }

    public void psubscribe(byte[]... patterns) {
        sendCommand((ProtocolCommand) Protocol.Command.PSUBSCRIBE, patterns);
    }

    public void punsubscribe() {
        sendCommand(Protocol.Command.PUNSUBSCRIBE);
    }

    public void punsubscribe(byte[]... patterns) {
        sendCommand((ProtocolCommand) Protocol.Command.PUNSUBSCRIBE, patterns);
    }

    public void pubsub(byte[]... args) {
        sendCommand((ProtocolCommand) Protocol.Command.PUBSUB, args);
    }

    public void zcount(byte[] key, double min, double max) {
        sendCommand((ProtocolCommand) Protocol.Command.ZCOUNT, key, Protocol.toByteArray(min), Protocol.toByteArray(max));
    }

    public void zcount(byte[] key, byte[] min, byte[] max) {
        sendCommand((ProtocolCommand) Protocol.Command.ZCOUNT, key, min, max);
    }

    public void zcount(byte[] key, String min, String max) {
        sendCommand((ProtocolCommand) Protocol.Command.ZCOUNT, key, min.getBytes(), max.getBytes());
    }

    public void zrangeByScore(byte[] key, double min, double max) {
        sendCommand((ProtocolCommand) Protocol.Command.ZRANGEBYSCORE, key, Protocol.toByteArray(min), Protocol.toByteArray(max));
    }

    public void zrangeByScore(byte[] key, byte[] min, byte[] max) {
        sendCommand((ProtocolCommand) Protocol.Command.ZRANGEBYSCORE, key, min, max);
    }

    public void zrangeByScore(byte[] key, String min, String max) {
        sendCommand((ProtocolCommand) Protocol.Command.ZRANGEBYSCORE, key, min.getBytes(), max.getBytes());
    }

    public void zrevrangeByScore(byte[] key, double max, double min) {
        sendCommand((ProtocolCommand) Protocol.Command.ZREVRANGEBYSCORE, key, Protocol.toByteArray(max), Protocol.toByteArray(min));
    }

    public void zrevrangeByScore(byte[] key, byte[] max, byte[] min) {
        sendCommand((ProtocolCommand) Protocol.Command.ZREVRANGEBYSCORE, key, max, min);
    }

    public void zrevrangeByScore(byte[] key, String max, String min) {
        sendCommand((ProtocolCommand) Protocol.Command.ZREVRANGEBYSCORE, key, max.getBytes(), min.getBytes());
    }

    public void zrangeByScore(byte[] key, double min, double max, int offset, int count) {
        sendCommand((ProtocolCommand) Protocol.Command.ZRANGEBYSCORE, key, Protocol.toByteArray(min), Protocol.toByteArray(max), Protocol.Keyword.LIMIT.raw, Protocol.toByteArray(offset), Protocol.toByteArray(count));
    }

    public void zrangeByScore(byte[] key, String min, String max, int offset, int count) {
        sendCommand((ProtocolCommand) Protocol.Command.ZRANGEBYSCORE, key, min.getBytes(), max.getBytes(), Protocol.Keyword.LIMIT.raw, Protocol.toByteArray(offset), Protocol.toByteArray(count));
    }

    public void zrevrangeByScore(byte[] key, double max, double min, int offset, int count) {
        sendCommand((ProtocolCommand) Protocol.Command.ZREVRANGEBYSCORE, key, Protocol.toByteArray(max), Protocol.toByteArray(min), Protocol.Keyword.LIMIT.raw, Protocol.toByteArray(offset), Protocol.toByteArray(count));
    }

    public void zrevrangeByScore(byte[] key, String max, String min, int offset, int count) {
        sendCommand((ProtocolCommand) Protocol.Command.ZREVRANGEBYSCORE, key, max.getBytes(), min.getBytes(), Protocol.Keyword.LIMIT.raw, Protocol.toByteArray(offset), Protocol.toByteArray(count));
    }

    public void zrangeByScoreWithScores(byte[] key, double min, double max) {
        sendCommand((ProtocolCommand) Protocol.Command.ZRANGEBYSCORE, key, Protocol.toByteArray(min), Protocol.toByteArray(max), Protocol.Keyword.WITHSCORES.raw);
    }

    public void zrangeByScoreWithScores(byte[] key, String min, String max) {
        sendCommand((ProtocolCommand) Protocol.Command.ZRANGEBYSCORE, key, min.getBytes(), max.getBytes(), Protocol.Keyword.WITHSCORES.raw);
    }

    public void zrevrangeByScoreWithScores(byte[] key, double max, double min) {
        sendCommand((ProtocolCommand) Protocol.Command.ZREVRANGEBYSCORE, key, Protocol.toByteArray(max), Protocol.toByteArray(min), Protocol.Keyword.WITHSCORES.raw);
    }

    public void zrevrangeByScoreWithScores(byte[] key, String max, String min) {
        sendCommand((ProtocolCommand) Protocol.Command.ZREVRANGEBYSCORE, key, max.getBytes(), min.getBytes(), Protocol.Keyword.WITHSCORES.raw);
    }

    public void zrangeByScoreWithScores(byte[] key, double min, double max, int offset, int count) {
        sendCommand((ProtocolCommand) Protocol.Command.ZRANGEBYSCORE, key, Protocol.toByteArray(min), Protocol.toByteArray(max), Protocol.Keyword.LIMIT.raw, Protocol.toByteArray(offset), Protocol.toByteArray(count), Protocol.Keyword.WITHSCORES.raw);
    }

    public void zrangeByScoreWithScores(byte[] key, String min, String max, int offset, int count) {
        sendCommand((ProtocolCommand) Protocol.Command.ZRANGEBYSCORE, key, min.getBytes(), max.getBytes(), Protocol.Keyword.LIMIT.raw, Protocol.toByteArray(offset), Protocol.toByteArray(count), Protocol.Keyword.WITHSCORES.raw);
    }

    public void zrevrangeByScoreWithScores(byte[] key, double max, double min, int offset, int count) {
        sendCommand((ProtocolCommand) Protocol.Command.ZREVRANGEBYSCORE, key, Protocol.toByteArray(max), Protocol.toByteArray(min), Protocol.Keyword.LIMIT.raw, Protocol.toByteArray(offset), Protocol.toByteArray(count), Protocol.Keyword.WITHSCORES.raw);
    }

    public void zrevrangeByScoreWithScores(byte[] key, String max, String min, int offset, int count) {
        sendCommand((ProtocolCommand) Protocol.Command.ZREVRANGEBYSCORE, key, max.getBytes(), min.getBytes(), Protocol.Keyword.LIMIT.raw, Protocol.toByteArray(offset), Protocol.toByteArray(count), Protocol.Keyword.WITHSCORES.raw);
    }

    public void zrangeByScore(byte[] key, byte[] min, byte[] max, int offset, int count) {
        sendCommand((ProtocolCommand) Protocol.Command.ZRANGEBYSCORE, key, min, max, Protocol.Keyword.LIMIT.raw, Protocol.toByteArray(offset), Protocol.toByteArray(count));
    }

    public void zrevrangeByScore(byte[] key, byte[] max, byte[] min, int offset, int count) {
        sendCommand((ProtocolCommand) Protocol.Command.ZREVRANGEBYSCORE, key, max, min, Protocol.Keyword.LIMIT.raw, Protocol.toByteArray(offset), Protocol.toByteArray(count));
    }

    public void zrangeByScoreWithScores(byte[] key, byte[] min, byte[] max) {
        sendCommand((ProtocolCommand) Protocol.Command.ZRANGEBYSCORE, key, min, max, Protocol.Keyword.WITHSCORES.raw);
    }

    public void zrevrangeByScoreWithScores(byte[] key, byte[] max, byte[] min) {
        sendCommand((ProtocolCommand) Protocol.Command.ZREVRANGEBYSCORE, key, max, min, Protocol.Keyword.WITHSCORES.raw);
    }

    public void zrangeByScoreWithScores(byte[] key, byte[] min, byte[] max, int offset, int count) {
        sendCommand((ProtocolCommand) Protocol.Command.ZRANGEBYSCORE, key, min, max, Protocol.Keyword.LIMIT.raw, Protocol.toByteArray(offset), Protocol.toByteArray(count), Protocol.Keyword.WITHSCORES.raw);
    }

    public void zrevrangeByScoreWithScores(byte[] key, byte[] max, byte[] min, int offset, int count) {
        sendCommand((ProtocolCommand) Protocol.Command.ZREVRANGEBYSCORE, key, max, min, Protocol.Keyword.LIMIT.raw, Protocol.toByteArray(offset), Protocol.toByteArray(count), Protocol.Keyword.WITHSCORES.raw);
    }

    public void zremrangeByRank(byte[] key, long start, long end) {
        sendCommand((ProtocolCommand) Protocol.Command.ZREMRANGEBYRANK, key, Protocol.toByteArray(start), Protocol.toByteArray(end));
    }

    public void zremrangeByScore(byte[] key, byte[] start, byte[] end) {
        sendCommand((ProtocolCommand) Protocol.Command.ZREMRANGEBYSCORE, key, start, end);
    }

    public void zremrangeByScore(byte[] key, String start, String end) {
        sendCommand((ProtocolCommand) Protocol.Command.ZREMRANGEBYSCORE, key, start.getBytes(), end.getBytes());
    }

    public void zunionstore(byte[] dstkey, byte[]... sets) {
        byte[][] params = new byte[(sets.length + 2)][];
        params[0] = dstkey;
        params[1] = Protocol.toByteArray(sets.length);
        System.arraycopy(sets, 0, params, 2, sets.length);
        sendCommand((ProtocolCommand) Protocol.Command.ZUNIONSTORE, params);
    }

    public void zunionstore(byte[] dstkey, ZParams params, byte[]... sets) {
        List<byte[]> args = new ArrayList<>();
        args.add(dstkey);
        args.add(Protocol.toByteArray(sets.length));
        for (byte[] set : sets) {
            args.add(set);
        }
        args.addAll(params.getParams());
        sendCommand((ProtocolCommand) Protocol.Command.ZUNIONSTORE, (byte[][]) args.toArray(new byte[args.size()][]));
    }

    public void zinterstore(byte[] dstkey, byte[]... sets) {
        byte[][] params = new byte[(sets.length + 2)][];
        params[0] = dstkey;
        params[1] = Protocol.toByteArray(sets.length);
        System.arraycopy(sets, 0, params, 2, sets.length);
        sendCommand((ProtocolCommand) Protocol.Command.ZINTERSTORE, params);
    }

    public void zinterstore(byte[] dstkey, ZParams params, byte[]... sets) {
        List<byte[]> args = new ArrayList<>();
        args.add(dstkey);
        args.add(Protocol.toByteArray(sets.length));
        for (byte[] set : sets) {
            args.add(set);
        }
        args.addAll(params.getParams());
        sendCommand((ProtocolCommand) Protocol.Command.ZINTERSTORE, (byte[][]) args.toArray(new byte[args.size()][]));
    }

    public void zlexcount(byte[] key, byte[] min, byte[] max) {
        sendCommand((ProtocolCommand) Protocol.Command.ZLEXCOUNT, key, min, max);
    }

    public void zrangeByLex(byte[] key, byte[] min, byte[] max) {
        sendCommand((ProtocolCommand) Protocol.Command.ZRANGEBYLEX, key, min, max);
    }

    public void zrangeByLex(byte[] key, byte[] min, byte[] max, int offset, int count) {
        sendCommand((ProtocolCommand) Protocol.Command.ZRANGEBYLEX, key, min, max, Protocol.Keyword.LIMIT.raw, Protocol.toByteArray(offset), Protocol.toByteArray(count));
    }

    public void zrevrangeByLex(byte[] key, byte[] max, byte[] min) {
        sendCommand((ProtocolCommand) Protocol.Command.ZREVRANGEBYLEX, key, max, min);
    }

    public void zrevrangeByLex(byte[] key, byte[] max, byte[] min, int offset, int count) {
        sendCommand((ProtocolCommand) Protocol.Command.ZREVRANGEBYLEX, key, max, min, Protocol.Keyword.LIMIT.raw, Protocol.toByteArray(offset), Protocol.toByteArray(count));
    }

    public void zremrangeByLex(byte[] key, byte[] min, byte[] max) {
        sendCommand((ProtocolCommand) Protocol.Command.ZREMRANGEBYLEX, key, min, max);
    }

    public void save() {
        sendCommand(Protocol.Command.SAVE);
    }

    public void bgsave() {
        sendCommand(Protocol.Command.BGSAVE);
    }

    public void bgrewriteaof() {
        sendCommand(Protocol.Command.BGREWRITEAOF);
    }

    public void lastsave() {
        sendCommand(Protocol.Command.LASTSAVE);
    }

    public void shutdown() {
        sendCommand(Protocol.Command.SHUTDOWN);
    }

    public void info() {
        sendCommand(Protocol.Command.INFO);
    }

    public void info(String section) {
        sendCommand((ProtocolCommand) Protocol.Command.INFO, section);
    }

    public void monitor() {
        sendCommand(Protocol.Command.MONITOR);
    }

    public void slaveof(String host, int port) {
        sendCommand((ProtocolCommand) Protocol.Command.SLAVEOF, host, String.valueOf(port));
    }

    public void slaveofNoOne() {
        sendCommand((ProtocolCommand) Protocol.Command.SLAVEOF, Protocol.Keyword.NO.raw, Protocol.Keyword.ONE.raw);
    }

    public void configGet(byte[] pattern) {
        sendCommand((ProtocolCommand) Protocol.Command.CONFIG, Protocol.Keyword.GET.raw, pattern);
    }

    public void configSet(byte[] parameter, byte[] value) {
        sendCommand((ProtocolCommand) Protocol.Command.CONFIG, Protocol.Keyword.SET.raw, parameter, value);
    }

    public void strlen(byte[] key) {
        sendCommand((ProtocolCommand) Protocol.Command.STRLEN, key);
    }

    public void sync() {
        sendCommand(Protocol.Command.SYNC);
    }

    public void lpushx(byte[] key, byte[]... string) {
        sendCommand((ProtocolCommand) Protocol.Command.LPUSHX, joinParameters(key, string));
    }

    public void persist(byte[] key) {
        sendCommand((ProtocolCommand) Protocol.Command.PERSIST, key);
    }

    public void rpushx(byte[] key, byte[]... string) {
        sendCommand((ProtocolCommand) Protocol.Command.RPUSHX, joinParameters(key, string));
    }

    public void echo(byte[] string) {
        sendCommand((ProtocolCommand) Protocol.Command.ECHO, string);
    }

    public void linsert(byte[] key, LIST_POSITION where, byte[] pivot, byte[] value) {
        sendCommand((ProtocolCommand) Protocol.Command.LINSERT, key, where.raw, pivot, value);
    }

    public void debug(DebugParams params) {
        sendCommand((ProtocolCommand) Protocol.Command.DEBUG, params.getCommand());
    }

    public void brpoplpush(byte[] source, byte[] destination, int timeout) {
        sendCommand((ProtocolCommand) Protocol.Command.BRPOPLPUSH, source, destination, Protocol.toByteArray(timeout));
    }

    public void configResetStat() {
        sendCommand((ProtocolCommand) Protocol.Command.CONFIG, Protocol.Keyword.RESETSTAT.name());
    }

    public void setbit(byte[] key, long offset, byte[] value) {
        sendCommand((ProtocolCommand) Protocol.Command.SETBIT, key, Protocol.toByteArray(offset), value);
    }

    public void setbit(byte[] key, long offset, boolean value) {
        sendCommand((ProtocolCommand) Protocol.Command.SETBIT, key, Protocol.toByteArray(offset), Protocol.toByteArray(value));
    }

    public void getbit(byte[] key, long offset) {
        sendCommand((ProtocolCommand) Protocol.Command.GETBIT, key, Protocol.toByteArray(offset));
    }

    public void bitpos(byte[] key, boolean value, BitPosParams params) {
        List<byte[]> args = new ArrayList<>();
        args.add(key);
        args.add(Protocol.toByteArray(value));
        args.addAll(params.getParams());
        sendCommand((ProtocolCommand) Protocol.Command.BITPOS, (byte[][]) args.toArray(new byte[args.size()][]));
    }

    public void setrange(byte[] key, long offset, byte[] value) {
        sendCommand((ProtocolCommand) Protocol.Command.SETRANGE, key, Protocol.toByteArray(offset), value);
    }

    public void getrange(byte[] key, long startOffset, long endOffset) {
        sendCommand((ProtocolCommand) Protocol.Command.GETRANGE, key, Protocol.toByteArray(startOffset), Protocol.toByteArray(endOffset));
    }

    public int getDB() {
        return this.db;
    }

    public void disconnect() {
        this.db = 0;
        super.disconnect();
    }

    public void close() {
        this.db = 0;
        super.close();
    }

    public void resetState() {
        if (isInWatch()) {
            unwatch();
        }
    }

    private void sendEvalCommand(Protocol.Command command, byte[] script, byte[] keyCount, byte[][] params) {
        byte[][] allArgs = new byte[(params.length + 2)][];
        allArgs[0] = script;
        allArgs[1] = keyCount;
        for (int i = 0; i < params.length; i++) {
            allArgs[i + 2] = params[i];
        }
        sendCommand((ProtocolCommand) command, allArgs);
    }

    public void eval(byte[] script, byte[] keyCount, byte[][] params) {
        sendEvalCommand(Protocol.Command.EVAL, script, keyCount, params);
    }

    public void eval(byte[] script, int keyCount, byte[]... params) {
        eval(script, Protocol.toByteArray(keyCount), params);
    }

    public void evalsha(byte[] sha1, byte[] keyCount, byte[]... params) {
        sendEvalCommand(Protocol.Command.EVALSHA, sha1, keyCount, params);
    }

    public void evalsha(byte[] sha1, int keyCount, byte[]... params) {
        sendEvalCommand(Protocol.Command.EVALSHA, sha1, Protocol.toByteArray(keyCount), params);
    }

    public void scriptFlush() {
        sendCommand((ProtocolCommand) Protocol.Command.SCRIPT, Protocol.Keyword.FLUSH.raw);
    }

    public void scriptExists(byte[]... sha1) {
        byte[][] args = new byte[(sha1.length + 1)][];
        args[0] = Protocol.Keyword.EXISTS.raw;
        for (int i = 0; i < sha1.length; i++) {
            args[i + 1] = sha1[i];
        }
        sendCommand((ProtocolCommand) Protocol.Command.SCRIPT, args);
    }

    public void scriptLoad(byte[] script) {
        sendCommand((ProtocolCommand) Protocol.Command.SCRIPT, Protocol.Keyword.LOAD.raw, script);
    }

    public void scriptKill() {
        sendCommand((ProtocolCommand) Protocol.Command.SCRIPT, Protocol.Keyword.KILL.raw);
    }

    public void slowlogGet() {
        sendCommand((ProtocolCommand) Protocol.Command.SLOWLOG, Protocol.Keyword.GET.raw);
    }

    public void slowlogGet(long entries) {
        sendCommand((ProtocolCommand) Protocol.Command.SLOWLOG, Protocol.Keyword.GET.raw, Protocol.toByteArray(entries));
    }

    public void slowlogReset() {
        sendCommand((ProtocolCommand) Protocol.Command.SLOWLOG, Protocol.Keyword.RESET.raw);
    }

    public void slowlogLen() {
        sendCommand((ProtocolCommand) Protocol.Command.SLOWLOG, Protocol.Keyword.LEN.raw);
    }

    public void objectRefcount(byte[] key) {
        sendCommand((ProtocolCommand) Protocol.Command.OBJECT, Protocol.Keyword.REFCOUNT.raw, key);
    }

    public void objectIdletime(byte[] key) {
        sendCommand((ProtocolCommand) Protocol.Command.OBJECT, Protocol.Keyword.IDLETIME.raw, key);
    }

    public void objectEncoding(byte[] key) {
        sendCommand((ProtocolCommand) Protocol.Command.OBJECT, Protocol.Keyword.ENCODING.raw, key);
    }

    public void bitcount(byte[] key) {
        sendCommand((ProtocolCommand) Protocol.Command.BITCOUNT, key);
    }

    public void bitcount(byte[] key, long start, long end) {
        sendCommand((ProtocolCommand) Protocol.Command.BITCOUNT, key, Protocol.toByteArray(start), Protocol.toByteArray(end));
    }

    public void bitop(BitOP op, byte[] destKey, byte[]... srcKeys) {
        Protocol.Keyword kw = Protocol.Keyword.AND;
        int len = srcKeys.length;
        switch ($SWITCH_TABLE$redis$clients$jedis$BitOP()[op.ordinal()]) {
            case 1:
                kw = Protocol.Keyword.AND;
                break;
            case 2:
                kw = Protocol.Keyword.OR;
                break;
            case 3:
                kw = Protocol.Keyword.XOR;
                break;
            case 4:
                kw = Protocol.Keyword.NOT;
                len = Math.min(1, len);
                break;
        }
        byte[][] bargs = new byte[(len + 2)][];
        bargs[0] = kw.raw;
        bargs[1] = destKey;
        for (int i = 0; i < len; i++) {
            bargs[i + 2] = srcKeys[i];
        }
        sendCommand((ProtocolCommand) Protocol.Command.BITOP, bargs);
    }

    public void sentinel(byte[]... args) {
        sendCommand((ProtocolCommand) Protocol.Command.SENTINEL, args);
    }

    public void dump(byte[] key) {
        sendCommand((ProtocolCommand) Protocol.Command.DUMP, key);
    }

    public void restore(byte[] key, int ttl, byte[] serializedValue) {
        sendCommand((ProtocolCommand) Protocol.Command.RESTORE, key, Protocol.toByteArray(ttl), serializedValue);
    }

    public void pexpire(byte[] key, long milliseconds) {
        sendCommand((ProtocolCommand) Protocol.Command.PEXPIRE, key, Protocol.toByteArray(milliseconds));
    }

    public void pexpireAt(byte[] key, long millisecondsTimestamp) {
        sendCommand((ProtocolCommand) Protocol.Command.PEXPIREAT, key, Protocol.toByteArray(millisecondsTimestamp));
    }

    public void pttl(byte[] key) {
        sendCommand((ProtocolCommand) Protocol.Command.PTTL, key);
    }

    public void psetex(byte[] key, long milliseconds, byte[] value) {
        sendCommand((ProtocolCommand) Protocol.Command.PSETEX, key, Protocol.toByteArray(milliseconds), value);
    }

    public void srandmember(byte[] key, int count) {
        sendCommand((ProtocolCommand) Protocol.Command.SRANDMEMBER, key, Protocol.toByteArray(count));
    }

    public void clientKill(byte[] client) {
        sendCommand((ProtocolCommand) Protocol.Command.CLIENT, Protocol.Keyword.KILL.raw, client);
    }

    public void clientGetname() {
        sendCommand((ProtocolCommand) Protocol.Command.CLIENT, Protocol.Keyword.GETNAME.raw);
    }

    public void clientList() {
        sendCommand((ProtocolCommand) Protocol.Command.CLIENT, Protocol.Keyword.LIST.raw);
    }

    public void clientSetname(byte[] name) {
        sendCommand((ProtocolCommand) Protocol.Command.CLIENT, Protocol.Keyword.SETNAME.raw, name);
    }

    public void time() {
        sendCommand(Protocol.Command.TIME);
    }

    public void migrate(byte[] host, int port, byte[] key, int destinationDb, int timeout) {
        sendCommand((ProtocolCommand) Protocol.Command.MIGRATE, host, Protocol.toByteArray(port), key, Protocol.toByteArray(destinationDb), Protocol.toByteArray(timeout));
    }

    public void hincrByFloat(byte[] key, byte[] field, double increment) {
        sendCommand((ProtocolCommand) Protocol.Command.HINCRBYFLOAT, key, field, Protocol.toByteArray(increment));
    }

    public void scan(byte[] cursor, ScanParams params) {
        List<byte[]> args = new ArrayList<>();
        args.add(cursor);
        args.addAll(params.getParams());
        sendCommand((ProtocolCommand) Protocol.Command.SCAN, (byte[][]) args.toArray(new byte[args.size()][]));
    }

    public void hscan(byte[] key, byte[] cursor, ScanParams params) {
        List<byte[]> args = new ArrayList<>();
        args.add(key);
        args.add(cursor);
        args.addAll(params.getParams());
        sendCommand((ProtocolCommand) Protocol.Command.HSCAN, (byte[][]) args.toArray(new byte[args.size()][]));
    }

    public void sscan(byte[] key, byte[] cursor, ScanParams params) {
        List<byte[]> args = new ArrayList<>();
        args.add(key);
        args.add(cursor);
        args.addAll(params.getParams());
        sendCommand((ProtocolCommand) Protocol.Command.SSCAN, (byte[][]) args.toArray(new byte[args.size()][]));
    }

    public void zscan(byte[] key, byte[] cursor, ScanParams params) {
        List<byte[]> args = new ArrayList<>();
        args.add(key);
        args.add(cursor);
        args.addAll(params.getParams());
        sendCommand((ProtocolCommand) Protocol.Command.ZSCAN, (byte[][]) args.toArray(new byte[args.size()][]));
    }

    public void waitReplicas(int replicas, long timeout) {
        sendCommand((ProtocolCommand) Protocol.Command.WAIT, Protocol.toByteArray(replicas), Protocol.toByteArray(timeout));
    }

    public void cluster(byte[]... args) {
        sendCommand((ProtocolCommand) Protocol.Command.CLUSTER, args);
    }

    public void asking() {
        sendCommand(Protocol.Command.ASKING);
    }

    public void pfadd(byte[] key, byte[]... elements) {
        sendCommand((ProtocolCommand) Protocol.Command.PFADD, joinParameters(key, elements));
    }

    public void pfcount(byte[] key) {
        sendCommand((ProtocolCommand) Protocol.Command.PFCOUNT, key);
    }

    public void pfcount(byte[]... keys) {
        sendCommand((ProtocolCommand) Protocol.Command.PFCOUNT, keys);
    }

    public void pfmerge(byte[] destkey, byte[]... sourcekeys) {
        sendCommand((ProtocolCommand) Protocol.Command.PFMERGE, joinParameters(destkey, sourcekeys));
    }

    public void readonly() {
        sendCommand(Protocol.Command.READONLY);
    }

    public void geoadd(byte[] key, double longitude, double latitude, byte[] member) {
        sendCommand((ProtocolCommand) Protocol.Command.GEOADD, key, Protocol.toByteArray(longitude), Protocol.toByteArray(latitude), member);
    }

    public void geoadd(byte[] key, Map<byte[], GeoCoordinate> memberCoordinateMap) {
        List<byte[]> args = new ArrayList<>((memberCoordinateMap.size() * 3) + 1);
        args.add(key);
        args.addAll(convertGeoCoordinateMapToByteArrays(memberCoordinateMap));
        byte[][] argsArray = new byte[args.size()][];
        args.toArray(argsArray);
        sendCommand((ProtocolCommand) Protocol.Command.GEOADD, argsArray);
    }

    public void geodist(byte[] key, byte[] member1, byte[] member2) {
        sendCommand((ProtocolCommand) Protocol.Command.GEODIST, key, member1, member2);
    }

    public void geodist(byte[] key, byte[] member1, byte[] member2, GeoUnit unit) {
        sendCommand((ProtocolCommand) Protocol.Command.GEODIST, key, member1, member2, unit.raw);
    }

    public void geohash(byte[] key, byte[]... members) {
        sendCommand((ProtocolCommand) Protocol.Command.GEOHASH, joinParameters(key, members));
    }

    public void geopos(byte[] key, byte[][] members) {
        sendCommand((ProtocolCommand) Protocol.Command.GEOPOS, joinParameters(key, members));
    }

    public void georadius(byte[] key, double longitude, double latitude, double radius, GeoUnit unit) {
        sendCommand((ProtocolCommand) Protocol.Command.GEORADIUS, key, Protocol.toByteArray(longitude), Protocol.toByteArray(latitude), Protocol.toByteArray(radius), unit.raw);
    }

    public void georadius(byte[] key, double longitude, double latitude, double radius, GeoUnit unit, GeoRadiusParam param) {
        sendCommand((ProtocolCommand) Protocol.Command.GEORADIUS, param.getByteParams(key, Protocol.toByteArray(longitude), Protocol.toByteArray(latitude), Protocol.toByteArray(radius), unit.raw));
    }

    public void georadiusByMember(byte[] key, byte[] member, double radius, GeoUnit unit) {
        sendCommand((ProtocolCommand) Protocol.Command.GEORADIUSBYMEMBER, key, member, Protocol.toByteArray(radius), unit.raw);
    }

    public void georadiusByMember(byte[] key, byte[] member, double radius, GeoUnit unit, GeoRadiusParam param) {
        sendCommand((ProtocolCommand) Protocol.Command.GEORADIUSBYMEMBER, param.getByteParams(key, member, Protocol.toByteArray(radius), unit.raw));
    }

    public void moduleLoad(byte[] path) {
        sendCommand((ProtocolCommand) Protocol.Command.MODULE, Protocol.Keyword.LOAD.raw, path);
    }

    public void moduleList() {
        sendCommand((ProtocolCommand) Protocol.Command.MODULE, Protocol.Keyword.LIST.raw);
    }

    public void moduleUnload(byte[] name) {
        sendCommand((ProtocolCommand) Protocol.Command.MODULE, Protocol.Keyword.UNLOAD.raw, name);
    }

    private ArrayList<byte[]> convertScoreMembersToByteArrays(Map<byte[], Double> scoreMembers) {
        ArrayList<byte[]> args = new ArrayList<>(scoreMembers.size() * 2);
        for (Map.Entry<byte[], Double> entry : scoreMembers.entrySet()) {
            args.add(Protocol.toByteArray(entry.getValue().doubleValue()));
            args.add(entry.getKey());
        }
        return args;
    }

    private List<byte[]> convertGeoCoordinateMapToByteArrays(Map<byte[], GeoCoordinate> memberCoordinateMap) {
        List<byte[]> args = new ArrayList<>(memberCoordinateMap.size() * 3);
        for (Map.Entry<byte[], GeoCoordinate> entry : memberCoordinateMap.entrySet()) {
            GeoCoordinate coordinate = entry.getValue();
            args.add(Protocol.toByteArray(coordinate.getLongitude()));
            args.add(Protocol.toByteArray(coordinate.getLatitude()));
            args.add(entry.getKey());
        }
        return args;
    }

    public void bitfield(byte[] key, byte[]... value) {
        int argsLength = value.length;
        byte[][] bitfieldArgs = new byte[(argsLength + 1)][];
        bitfieldArgs[0] = key;
        System.arraycopy(value, 0, bitfieldArgs, 1, argsLength);
        sendCommand((ProtocolCommand) Protocol.Command.BITFIELD, bitfieldArgs);
    }

    public void hstrlen(byte[] key, byte[] field) {
        sendCommand((ProtocolCommand) Protocol.Command.HSTRLEN, key, field);
    }
}
