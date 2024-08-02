package redis.clients.jedis;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import redis.clients.jedis.BinaryClient;
import redis.clients.jedis.commands.BinaryJedisCommands;
import redis.clients.jedis.exceptions.JedisConnectionException;
import redis.clients.jedis.params.geo.GeoRadiusParam;
import redis.clients.jedis.params.set.SetParams;
import redis.clients.jedis.params.sortedset.ZAddParams;
import redis.clients.jedis.params.sortedset.ZIncrByParams;
import redis.clients.util.Hashing;
import redis.clients.util.Sharded;

public class BinaryShardedJedis extends Sharded<Jedis, JedisShardInfo> implements BinaryJedisCommands {
    public BinaryShardedJedis(List<JedisShardInfo> shards) {
        super(shards);
    }

    public BinaryShardedJedis(List<JedisShardInfo> shards, Hashing algo) {
        super(shards, algo);
    }

    public BinaryShardedJedis(List<JedisShardInfo> shards, Pattern keyTagPattern) {
        super(shards, keyTagPattern);
    }

    public BinaryShardedJedis(List<JedisShardInfo> shards, Hashing algo, Pattern keyTagPattern) {
        super(shards, algo, keyTagPattern);
    }

    public void disconnect() {
        for (Jedis jedis : getAllShards()) {
            try {
                jedis.quit();
            } catch (JedisConnectionException e) {
            }
            try {
                jedis.disconnect();
            } catch (JedisConnectionException e2) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public Jedis create(JedisShardInfo shard) {
        return new Jedis(shard);
    }

    public String set(byte[] key, byte[] value) {
        return ((Jedis) getShard(key)).set(key, value);
    }

    public String set(byte[] key, byte[] value, SetParams params) {
        return ((Jedis) getShard(key)).set(key, value, params);
    }

    public byte[] get(byte[] key) {
        return ((Jedis) getShard(key)).get(key);
    }

    public Boolean exists(byte[] key) {
        return ((Jedis) getShard(key)).exists(key);
    }

    public String type(byte[] key) {
        return ((Jedis) getShard(key)).type(key);
    }

    public Long expire(byte[] key, int seconds) {
        return ((Jedis) getShard(key)).expire(key, seconds);
    }

    public Long pexpire(byte[] key, long milliseconds) {
        return ((Jedis) getShard(key)).pexpire(key, milliseconds);
    }

    public Long expireAt(byte[] key, long unixTime) {
        return ((Jedis) getShard(key)).expireAt(key, unixTime);
    }

    public Long pexpireAt(byte[] key, long millisecondsTimestamp) {
        return ((Jedis) getShard(key)).pexpireAt(key, millisecondsTimestamp);
    }

    public Long ttl(byte[] key) {
        return ((Jedis) getShard(key)).ttl(key);
    }

    public byte[] getSet(byte[] key, byte[] value) {
        return ((Jedis) getShard(key)).getSet(key, value);
    }

    public Long setnx(byte[] key, byte[] value) {
        return ((Jedis) getShard(key)).setnx(key, value);
    }

    public String setex(byte[] key, int seconds, byte[] value) {
        return ((Jedis) getShard(key)).setex(key, seconds, value);
    }

    public Long decrBy(byte[] key, long integer) {
        return ((Jedis) getShard(key)).decrBy(key, integer);
    }

    public Long decr(byte[] key) {
        return ((Jedis) getShard(key)).decr(key);
    }

    public Long del(byte[] key) {
        return ((Jedis) getShard(key)).del(key);
    }

    public Long incrBy(byte[] key, long integer) {
        return ((Jedis) getShard(key)).incrBy(key, integer);
    }

    public Double incrByFloat(byte[] key, double integer) {
        return ((Jedis) getShard(key)).incrByFloat(key, integer);
    }

    public Long incr(byte[] key) {
        return ((Jedis) getShard(key)).incr(key);
    }

    public Long append(byte[] key, byte[] value) {
        return ((Jedis) getShard(key)).append(key, value);
    }

    public byte[] substr(byte[] key, int start, int end) {
        return ((Jedis) getShard(key)).substr(key, start, end);
    }

    public Long hset(byte[] key, byte[] field, byte[] value) {
        return ((Jedis) getShard(key)).hset(key, field, value);
    }

    public byte[] hget(byte[] key, byte[] field) {
        return ((Jedis) getShard(key)).hget(key, field);
    }

    public Long hsetnx(byte[] key, byte[] field, byte[] value) {
        return ((Jedis) getShard(key)).hsetnx(key, field, value);
    }

    public String hmset(byte[] key, Map<byte[], byte[]> hash) {
        return ((Jedis) getShard(key)).hmset(key, hash);
    }

    public List<byte[]> hmget(byte[] key, byte[]... fields) {
        return ((Jedis) getShard(key)).hmget(key, fields);
    }

    public Long hincrBy(byte[] key, byte[] field, long value) {
        return ((Jedis) getShard(key)).hincrBy(key, field, value);
    }

    public Double hincrByFloat(byte[] key, byte[] field, double value) {
        return ((Jedis) getShard(key)).hincrByFloat(key, field, value);
    }

    public Boolean hexists(byte[] key, byte[] field) {
        return ((Jedis) getShard(key)).hexists(key, field);
    }

    public Long hdel(byte[] key, byte[]... fields) {
        return ((Jedis) getShard(key)).hdel(key, fields);
    }

    public Long hlen(byte[] key) {
        return ((Jedis) getShard(key)).hlen(key);
    }

    public Set<byte[]> hkeys(byte[] key) {
        return ((Jedis) getShard(key)).hkeys(key);
    }

    public Collection<byte[]> hvals(byte[] key) {
        return ((Jedis) getShard(key)).hvals(key);
    }

    public Map<byte[], byte[]> hgetAll(byte[] key) {
        return ((Jedis) getShard(key)).hgetAll(key);
    }

    public Long rpush(byte[] key, byte[]... strings) {
        return ((Jedis) getShard(key)).rpush(key, strings);
    }

    public Long lpush(byte[] key, byte[]... strings) {
        return ((Jedis) getShard(key)).lpush(key, strings);
    }

    public Long strlen(byte[] key) {
        return ((Jedis) getShard(key)).strlen(key);
    }

    public Long lpushx(byte[] key, byte[]... string) {
        return ((Jedis) getShard(key)).lpushx(key, string);
    }

    public Long persist(byte[] key) {
        return ((Jedis) getShard(key)).persist(key);
    }

    public Long rpushx(byte[] key, byte[]... string) {
        return ((Jedis) getShard(key)).rpushx(key, string);
    }

    public Long llen(byte[] key) {
        return ((Jedis) getShard(key)).llen(key);
    }

    public List<byte[]> lrange(byte[] key, long start, long end) {
        return ((Jedis) getShard(key)).lrange(key, start, end);
    }

    public String ltrim(byte[] key, long start, long end) {
        return ((Jedis) getShard(key)).ltrim(key, start, end);
    }

    public byte[] lindex(byte[] key, long index) {
        return ((Jedis) getShard(key)).lindex(key, index);
    }

    public String lset(byte[] key, long index, byte[] value) {
        return ((Jedis) getShard(key)).lset(key, index, value);
    }

    public Long lrem(byte[] key, long count, byte[] value) {
        return ((Jedis) getShard(key)).lrem(key, count, value);
    }

    public byte[] lpop(byte[] key) {
        return ((Jedis) getShard(key)).lpop(key);
    }

    public byte[] rpop(byte[] key) {
        return ((Jedis) getShard(key)).rpop(key);
    }

    public Long sadd(byte[] key, byte[]... members) {
        return ((Jedis) getShard(key)).sadd(key, members);
    }

    public Set<byte[]> smembers(byte[] key) {
        return ((Jedis) getShard(key)).smembers(key);
    }

    public Long srem(byte[] key, byte[]... members) {
        return ((Jedis) getShard(key)).srem(key, members);
    }

    public byte[] spop(byte[] key) {
        return ((Jedis) getShard(key)).spop(key);
    }

    public Set<byte[]> spop(byte[] key, long count) {
        return ((Jedis) getShard(key)).spop(key, count);
    }

    public Long scard(byte[] key) {
        return ((Jedis) getShard(key)).scard(key);
    }

    public Boolean sismember(byte[] key, byte[] member) {
        return ((Jedis) getShard(key)).sismember(key, member);
    }

    public byte[] srandmember(byte[] key) {
        return ((Jedis) getShard(key)).srandmember(key);
    }

    public List srandmember(byte[] key, int count) {
        return ((Jedis) getShard(key)).srandmember(key, count);
    }

    public Long zadd(byte[] key, double score, byte[] member) {
        return ((Jedis) getShard(key)).zadd(key, score, member);
    }

    public Long zadd(byte[] key, double score, byte[] member, ZAddParams params) {
        return ((Jedis) getShard(key)).zadd(key, score, member, params);
    }

    public Long zadd(byte[] key, Map<byte[], Double> scoreMembers) {
        return ((Jedis) getShard(key)).zadd(key, scoreMembers);
    }

    public Long zadd(byte[] key, Map<byte[], Double> scoreMembers, ZAddParams params) {
        return ((Jedis) getShard(key)).zadd(key, scoreMembers, params);
    }

    public Set<byte[]> zrange(byte[] key, long start, long end) {
        return ((Jedis) getShard(key)).zrange(key, start, end);
    }

    public Long zrem(byte[] key, byte[]... members) {
        return ((Jedis) getShard(key)).zrem(key, members);
    }

    public Double zincrby(byte[] key, double score, byte[] member) {
        return ((Jedis) getShard(key)).zincrby(key, score, member);
    }

    public Double zincrby(byte[] key, double score, byte[] member, ZIncrByParams params) {
        return ((Jedis) getShard(key)).zincrby(key, score, member, params);
    }

    public Long zrank(byte[] key, byte[] member) {
        return ((Jedis) getShard(key)).zrank(key, member);
    }

    public Long zrevrank(byte[] key, byte[] member) {
        return ((Jedis) getShard(key)).zrevrank(key, member);
    }

    public Set<byte[]> zrevrange(byte[] key, long start, long end) {
        return ((Jedis) getShard(key)).zrevrange(key, start, end);
    }

    public Set<Tuple> zrangeWithScores(byte[] key, long start, long end) {
        return ((Jedis) getShard(key)).zrangeWithScores(key, start, end);
    }

    public Set<Tuple> zrevrangeWithScores(byte[] key, long start, long end) {
        return ((Jedis) getShard(key)).zrevrangeWithScores(key, start, end);
    }

    public Long zcard(byte[] key) {
        return ((Jedis) getShard(key)).zcard(key);
    }

    public Double zscore(byte[] key, byte[] member) {
        return ((Jedis) getShard(key)).zscore(key, member);
    }

    public List<byte[]> sort(byte[] key) {
        return ((Jedis) getShard(key)).sort(key);
    }

    public List<byte[]> sort(byte[] key, SortingParams sortingParameters) {
        return ((Jedis) getShard(key)).sort(key, sortingParameters);
    }

    public Long zcount(byte[] key, double min, double max) {
        return ((Jedis) getShard(key)).zcount(key, min, max);
    }

    public Long zcount(byte[] key, byte[] min, byte[] max) {
        return ((Jedis) getShard(key)).zcount(key, min, max);
    }

    public Set<byte[]> zrangeByScore(byte[] key, double min, double max) {
        return ((Jedis) getShard(key)).zrangeByScore(key, min, max);
    }

    public Set<byte[]> zrangeByScore(byte[] key, double min, double max, int offset, int count) {
        return ((Jedis) getShard(key)).zrangeByScore(key, min, max, offset, count);
    }

    public Set<Tuple> zrangeByScoreWithScores(byte[] key, double min, double max) {
        return ((Jedis) getShard(key)).zrangeByScoreWithScores(key, min, max);
    }

    public Set<Tuple> zrangeByScoreWithScores(byte[] key, double min, double max, int offset, int count) {
        return ((Jedis) getShard(key)).zrangeByScoreWithScores(key, min, max, offset, count);
    }

    public Set<byte[]> zrangeByScore(byte[] key, byte[] min, byte[] max) {
        return ((Jedis) getShard(key)).zrangeByScore(key, min, max);
    }

    public Set<Tuple> zrangeByScoreWithScores(byte[] key, byte[] min, byte[] max) {
        return ((Jedis) getShard(key)).zrangeByScoreWithScores(key, min, max);
    }

    public Set<Tuple> zrangeByScoreWithScores(byte[] key, byte[] min, byte[] max, int offset, int count) {
        return ((Jedis) getShard(key)).zrangeByScoreWithScores(key, min, max, offset, count);
    }

    public Set<byte[]> zrangeByScore(byte[] key, byte[] min, byte[] max, int offset, int count) {
        return ((Jedis) getShard(key)).zrangeByScore(key, min, max, offset, count);
    }

    public Set<byte[]> zrevrangeByScore(byte[] key, double max, double min) {
        return ((Jedis) getShard(key)).zrevrangeByScore(key, max, min);
    }

    public Set<byte[]> zrevrangeByScore(byte[] key, double max, double min, int offset, int count) {
        return ((Jedis) getShard(key)).zrevrangeByScore(key, max, min, offset, count);
    }

    public Set<Tuple> zrevrangeByScoreWithScores(byte[] key, double max, double min) {
        return ((Jedis) getShard(key)).zrevrangeByScoreWithScores(key, max, min);
    }

    public Set<Tuple> zrevrangeByScoreWithScores(byte[] key, double max, double min, int offset, int count) {
        return ((Jedis) getShard(key)).zrevrangeByScoreWithScores(key, max, min, offset, count);
    }

    public Set<byte[]> zrevrangeByScore(byte[] key, byte[] max, byte[] min) {
        return ((Jedis) getShard(key)).zrevrangeByScore(key, max, min);
    }

    public Set<byte[]> zrevrangeByScore(byte[] key, byte[] max, byte[] min, int offset, int count) {
        return ((Jedis) getShard(key)).zrevrangeByScore(key, max, min, offset, count);
    }

    public Set<Tuple> zrevrangeByScoreWithScores(byte[] key, byte[] max, byte[] min) {
        return ((Jedis) getShard(key)).zrevrangeByScoreWithScores(key, max, min);
    }

    public Set<Tuple> zrevrangeByScoreWithScores(byte[] key, byte[] max, byte[] min, int offset, int count) {
        return ((Jedis) getShard(key)).zrevrangeByScoreWithScores(key, max, min, offset, count);
    }

    public Long zremrangeByRank(byte[] key, long start, long end) {
        return ((Jedis) getShard(key)).zremrangeByRank(key, start, end);
    }

    public Long zremrangeByScore(byte[] key, double start, double end) {
        return ((Jedis) getShard(key)).zremrangeByScore(key, start, end);
    }

    public Long zremrangeByScore(byte[] key, byte[] start, byte[] end) {
        return ((Jedis) getShard(key)).zremrangeByScore(key, start, end);
    }

    public Long zlexcount(byte[] key, byte[] min, byte[] max) {
        return ((Jedis) getShard(key)).zlexcount(key, min, max);
    }

    public Set<byte[]> zrangeByLex(byte[] key, byte[] min, byte[] max) {
        return ((Jedis) getShard(key)).zrangeByLex(key, min, max);
    }

    public Set<byte[]> zrangeByLex(byte[] key, byte[] min, byte[] max, int offset, int count) {
        return ((Jedis) getShard(key)).zrangeByLex(key, min, max, offset, count);
    }

    public Set<byte[]> zrevrangeByLex(byte[] key, byte[] max, byte[] min) {
        return ((Jedis) getShard(key)).zrevrangeByLex(key, max, min);
    }

    public Set<byte[]> zrevrangeByLex(byte[] key, byte[] max, byte[] min, int offset, int count) {
        return ((Jedis) getShard(key)).zrevrangeByLex(key, max, min, offset, count);
    }

    public Long zremrangeByLex(byte[] key, byte[] min, byte[] max) {
        return ((Jedis) getShard(key)).zremrangeByLex(key, min, max);
    }

    public Long linsert(byte[] key, BinaryClient.LIST_POSITION where, byte[] pivot, byte[] value) {
        return ((Jedis) getShard(key)).linsert(key, where, pivot, value);
    }

    public ShardedJedisPipeline pipelined() {
        ShardedJedisPipeline pipeline = new ShardedJedisPipeline();
        pipeline.setShardedJedis(this);
        return pipeline;
    }

    public Long objectRefcount(byte[] key) {
        return ((Jedis) getShard(key)).objectRefcount(key);
    }

    public byte[] objectEncoding(byte[] key) {
        return ((Jedis) getShard(key)).objectEncoding(key);
    }

    public Long objectIdletime(byte[] key) {
        return ((Jedis) getShard(key)).objectIdletime(key);
    }

    public Boolean setbit(byte[] key, long offset, boolean value) {
        return ((Jedis) getShard(key)).setbit(key, offset, value);
    }

    public Boolean setbit(byte[] key, long offset, byte[] value) {
        return ((Jedis) getShard(key)).setbit(key, offset, value);
    }

    public Boolean getbit(byte[] key, long offset) {
        return ((Jedis) getShard(key)).getbit(key, offset);
    }

    public Long setrange(byte[] key, long offset, byte[] value) {
        return ((Jedis) getShard(key)).setrange(key, offset, value);
    }

    public byte[] getrange(byte[] key, long startOffset, long endOffset) {
        return ((Jedis) getShard(key)).getrange(key, startOffset, endOffset);
    }

    public Long move(byte[] key, int dbIndex) {
        return ((Jedis) getShard(key)).move(key, dbIndex);
    }

    public byte[] echo(byte[] arg) {
        return ((Jedis) getShard(arg)).echo(arg);
    }

    public List<byte[]> brpop(byte[] arg) {
        return ((Jedis) getShard(arg)).brpop(arg);
    }

    public List<byte[]> blpop(byte[] arg) {
        return ((Jedis) getShard(arg)).blpop(arg);
    }

    public Long bitcount(byte[] key) {
        return ((Jedis) getShard(key)).bitcount(key);
    }

    public Long bitcount(byte[] key, long start, long end) {
        return ((Jedis) getShard(key)).bitcount(key, start, end);
    }

    public Long pfadd(byte[] key, byte[]... elements) {
        return ((Jedis) getShard(key)).pfadd(key, elements);
    }

    public long pfcount(byte[] key) {
        return ((Jedis) getShard(key)).pfcount(key);
    }

    public Long geoadd(byte[] key, double longitude, double latitude, byte[] member) {
        return ((Jedis) getShard(key)).geoadd(key, longitude, latitude, member);
    }

    public Long geoadd(byte[] key, Map<byte[], GeoCoordinate> memberCoordinateMap) {
        return ((Jedis) getShard(key)).geoadd(key, memberCoordinateMap);
    }

    public Double geodist(byte[] key, byte[] member1, byte[] member2) {
        return ((Jedis) getShard(key)).geodist(key, member1, member2);
    }

    public Double geodist(byte[] key, byte[] member1, byte[] member2, GeoUnit unit) {
        return ((Jedis) getShard(key)).geodist(key, member1, member2, unit);
    }

    public List<byte[]> geohash(byte[] key, byte[]... members) {
        return ((Jedis) getShard(key)).geohash(key, members);
    }

    public List<GeoCoordinate> geopos(byte[] key, byte[]... members) {
        return ((Jedis) getShard(key)).geopos(key, members);
    }

    public List<GeoRadiusResponse> georadius(byte[] key, double longitude, double latitude, double radius, GeoUnit unit) {
        return ((Jedis) getShard(key)).georadius(key, longitude, latitude, radius, unit);
    }

    public List<GeoRadiusResponse> georadius(byte[] key, double longitude, double latitude, double radius, GeoUnit unit, GeoRadiusParam param) {
        return ((Jedis) getShard(key)).georadius(key, longitude, latitude, radius, unit, param);
    }

    public List<GeoRadiusResponse> georadiusByMember(byte[] key, byte[] member, double radius, GeoUnit unit) {
        return ((Jedis) getShard(key)).georadiusByMember(key, member, radius, unit);
    }

    public List<GeoRadiusResponse> georadiusByMember(byte[] key, byte[] member, double radius, GeoUnit unit, GeoRadiusParam param) {
        return ((Jedis) getShard(key)).georadiusByMember(key, member, radius, unit, param);
    }

    public ScanResult<Map.Entry<byte[], byte[]>> hscan(byte[] key, byte[] cursor) {
        return ((Jedis) getShard(key)).hscan(key, cursor);
    }

    public ScanResult<Map.Entry<byte[], byte[]>> hscan(byte[] key, byte[] cursor, ScanParams params) {
        return ((Jedis) getShard(key)).hscan(key, cursor, params);
    }

    public ScanResult<byte[]> sscan(byte[] key, byte[] cursor) {
        return ((Jedis) getShard(key)).sscan(key, cursor);
    }

    public ScanResult<byte[]> sscan(byte[] key, byte[] cursor, ScanParams params) {
        return ((Jedis) getShard(key)).sscan(key, cursor, params);
    }

    public ScanResult<Tuple> zscan(byte[] key, byte[] cursor) {
        return ((Jedis) getShard(key)).zscan(key, cursor);
    }

    public ScanResult<Tuple> zscan(byte[] key, byte[] cursor, ScanParams params) {
        return ((Jedis) getShard(key)).zscan(key, cursor, params);
    }

    public List<Long> bitfield(byte[] key, byte[]... arguments) {
        return ((Jedis) getShard(key)).bitfield(key, arguments);
    }

    public Long hstrlen(byte[] key, byte[] field) {
        return ((Jedis) getShard(key)).hstrlen(key, field);
    }
}
