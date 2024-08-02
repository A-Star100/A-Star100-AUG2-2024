package redis.clients.jedis;

import java.io.Closeable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import redis.clients.jedis.BinaryClient;
import redis.clients.jedis.commands.JedisCommands;
import redis.clients.jedis.params.geo.GeoRadiusParam;
import redis.clients.jedis.params.set.SetParams;
import redis.clients.jedis.params.sortedset.ZAddParams;
import redis.clients.jedis.params.sortedset.ZIncrByParams;
import redis.clients.util.Hashing;

public class ShardedJedis extends BinaryShardedJedis implements JedisCommands, Closeable {
    protected ShardedJedisPool dataSource = null;

    public ShardedJedis(List<JedisShardInfo> shards) {
        super(shards);
    }

    public ShardedJedis(List<JedisShardInfo> shards, Hashing algo) {
        super(shards, algo);
    }

    public ShardedJedis(List<JedisShardInfo> shards, Pattern keyTagPattern) {
        super(shards, keyTagPattern);
    }

    public ShardedJedis(List<JedisShardInfo> shards, Hashing algo, Pattern keyTagPattern) {
        super(shards, algo, keyTagPattern);
    }

    public String set(String key, String value) {
        return ((Jedis) getShard(key)).set(key, value);
    }

    public String set(String key, String value, SetParams params) {
        return ((Jedis) getShard(key)).set(key, value, params);
    }

    public String get(String key) {
        return ((Jedis) getShard(key)).get(key);
    }

    public String echo(String string) {
        return ((Jedis) getShard(string)).echo(string);
    }

    public Boolean exists(String key) {
        return ((Jedis) getShard(key)).exists(key);
    }

    public String type(String key) {
        return ((Jedis) getShard(key)).type(key);
    }

    public Long expire(String key, int seconds) {
        return ((Jedis) getShard(key)).expire(key, seconds);
    }

    public Long pexpire(String key, long milliseconds) {
        return ((Jedis) getShard(key)).pexpire(key, milliseconds);
    }

    public Long expireAt(String key, long unixTime) {
        return ((Jedis) getShard(key)).expireAt(key, unixTime);
    }

    public Long pexpireAt(String key, long millisecondsTimestamp) {
        return ((Jedis) getShard(key)).pexpireAt(key, millisecondsTimestamp);
    }

    public Long ttl(String key) {
        return ((Jedis) getShard(key)).ttl(key);
    }

    public Long pttl(String key) {
        return ((Jedis) getShard(key)).pttl(key);
    }

    public Boolean setbit(String key, long offset, boolean value) {
        return ((Jedis) getShard(key)).setbit(key, offset, value);
    }

    public Boolean setbit(String key, long offset, String value) {
        return ((Jedis) getShard(key)).setbit(key, offset, value);
    }

    public Boolean getbit(String key, long offset) {
        return ((Jedis) getShard(key)).getbit(key, offset);
    }

    public Long setrange(String key, long offset, String value) {
        return ((Jedis) getShard(key)).setrange(key, offset, value);
    }

    public String getrange(String key, long startOffset, long endOffset) {
        return ((Jedis) getShard(key)).getrange(key, startOffset, endOffset);
    }

    public String getSet(String key, String value) {
        return ((Jedis) getShard(key)).getSet(key, value);
    }

    public Long setnx(String key, String value) {
        return ((Jedis) getShard(key)).setnx(key, value);
    }

    public String setex(String key, int seconds, String value) {
        return ((Jedis) getShard(key)).setex(key, seconds, value);
    }

    public String psetex(String key, long milliseconds, String value) {
        return ((Jedis) getShard(key)).psetex(key, milliseconds, value);
    }

    public List<String> blpop(String arg) {
        return ((Jedis) getShard(arg)).blpop(arg);
    }

    public List<String> blpop(int timeout, String key) {
        return ((Jedis) getShard(key)).blpop(timeout, key);
    }

    public List<String> brpop(String arg) {
        return ((Jedis) getShard(arg)).brpop(arg);
    }

    public List<String> brpop(int timeout, String key) {
        return ((Jedis) getShard(key)).brpop(timeout, key);
    }

    public Long decrBy(String key, long integer) {
        return ((Jedis) getShard(key)).decrBy(key, integer);
    }

    public Long decr(String key) {
        return ((Jedis) getShard(key)).decr(key);
    }

    public Long incrBy(String key, long integer) {
        return ((Jedis) getShard(key)).incrBy(key, integer);
    }

    public Double incrByFloat(String key, double integer) {
        return ((Jedis) getShard(key)).incrByFloat(key, integer);
    }

    public Long incr(String key) {
        return ((Jedis) getShard(key)).incr(key);
    }

    public Long append(String key, String value) {
        return ((Jedis) getShard(key)).append(key, value);
    }

    public String substr(String key, int start, int end) {
        return ((Jedis) getShard(key)).substr(key, start, end);
    }

    public Long hset(String key, String field, String value) {
        return ((Jedis) getShard(key)).hset(key, field, value);
    }

    public String hget(String key, String field) {
        return ((Jedis) getShard(key)).hget(key, field);
    }

    public Long hsetnx(String key, String field, String value) {
        return ((Jedis) getShard(key)).hsetnx(key, field, value);
    }

    public String hmset(String key, Map<String, String> hash) {
        return ((Jedis) getShard(key)).hmset(key, hash);
    }

    public List<String> hmget(String key, String... fields) {
        return ((Jedis) getShard(key)).hmget(key, fields);
    }

    public Long hincrBy(String key, String field, long value) {
        return ((Jedis) getShard(key)).hincrBy(key, field, value);
    }

    public Double hincrByFloat(String key, String field, double value) {
        return ((Jedis) getShard(key)).hincrByFloat(key, field, value);
    }

    public Boolean hexists(String key, String field) {
        return ((Jedis) getShard(key)).hexists(key, field);
    }

    public Long del(String key) {
        return ((Jedis) getShard(key)).del(key);
    }

    public Long hdel(String key, String... fields) {
        return ((Jedis) getShard(key)).hdel(key, fields);
    }

    public Long hlen(String key) {
        return ((Jedis) getShard(key)).hlen(key);
    }

    public Set<String> hkeys(String key) {
        return ((Jedis) getShard(key)).hkeys(key);
    }

    public List<String> hvals(String key) {
        return ((Jedis) getShard(key)).hvals(key);
    }

    public Map<String, String> hgetAll(String key) {
        return ((Jedis) getShard(key)).hgetAll(key);
    }

    public Long rpush(String key, String... strings) {
        return ((Jedis) getShard(key)).rpush(key, strings);
    }

    public Long lpush(String key, String... strings) {
        return ((Jedis) getShard(key)).lpush(key, strings);
    }

    public Long lpushx(String key, String... string) {
        return ((Jedis) getShard(key)).lpushx(key, string);
    }

    public Long strlen(String key) {
        return ((Jedis) getShard(key)).strlen(key);
    }

    public Long move(String key, int dbIndex) {
        return ((Jedis) getShard(key)).move(key, dbIndex);
    }

    public Long rpushx(String key, String... string) {
        return ((Jedis) getShard(key)).rpushx(key, string);
    }

    public Long persist(String key) {
        return ((Jedis) getShard(key)).persist(key);
    }

    public Long llen(String key) {
        return ((Jedis) getShard(key)).llen(key);
    }

    public List<String> lrange(String key, long start, long end) {
        return ((Jedis) getShard(key)).lrange(key, start, end);
    }

    public String ltrim(String key, long start, long end) {
        return ((Jedis) getShard(key)).ltrim(key, start, end);
    }

    public String lindex(String key, long index) {
        return ((Jedis) getShard(key)).lindex(key, index);
    }

    public String lset(String key, long index, String value) {
        return ((Jedis) getShard(key)).lset(key, index, value);
    }

    public Long lrem(String key, long count, String value) {
        return ((Jedis) getShard(key)).lrem(key, count, value);
    }

    public String lpop(String key) {
        return ((Jedis) getShard(key)).lpop(key);
    }

    public String rpop(String key) {
        return ((Jedis) getShard(key)).rpop(key);
    }

    public Long sadd(String key, String... members) {
        return ((Jedis) getShard(key)).sadd(key, members);
    }

    public Set<String> smembers(String key) {
        return ((Jedis) getShard(key)).smembers(key);
    }

    public Long srem(String key, String... members) {
        return ((Jedis) getShard(key)).srem(key, members);
    }

    public String spop(String key) {
        return ((Jedis) getShard(key)).spop(key);
    }

    public Set<String> spop(String key, long count) {
        return ((Jedis) getShard(key)).spop(key, count);
    }

    public Long scard(String key) {
        return ((Jedis) getShard(key)).scard(key);
    }

    public Boolean sismember(String key, String member) {
        return ((Jedis) getShard(key)).sismember(key, member);
    }

    public String srandmember(String key) {
        return ((Jedis) getShard(key)).srandmember(key);
    }

    public List<String> srandmember(String key, int count) {
        return ((Jedis) getShard(key)).srandmember(key, count);
    }

    public Long zadd(String key, double score, String member) {
        return ((Jedis) getShard(key)).zadd(key, score, member);
    }

    public Long zadd(String key, double score, String member, ZAddParams params) {
        return ((Jedis) getShard(key)).zadd(key, score, member, params);
    }

    public Long zadd(String key, Map<String, Double> scoreMembers) {
        return ((Jedis) getShard(key)).zadd(key, scoreMembers);
    }

    public Long zadd(String key, Map<String, Double> scoreMembers, ZAddParams params) {
        return ((Jedis) getShard(key)).zadd(key, scoreMembers, params);
    }

    public Set<String> zrange(String key, long start, long end) {
        return ((Jedis) getShard(key)).zrange(key, start, end);
    }

    public Long zrem(String key, String... members) {
        return ((Jedis) getShard(key)).zrem(key, members);
    }

    public Double zincrby(String key, double score, String member) {
        return ((Jedis) getShard(key)).zincrby(key, score, member);
    }

    public Double zincrby(String key, double score, String member, ZIncrByParams params) {
        return ((Jedis) getShard(key)).zincrby(key, score, member, params);
    }

    public Long zrank(String key, String member) {
        return ((Jedis) getShard(key)).zrank(key, member);
    }

    public Long zrevrank(String key, String member) {
        return ((Jedis) getShard(key)).zrevrank(key, member);
    }

    public Set<String> zrevrange(String key, long start, long end) {
        return ((Jedis) getShard(key)).zrevrange(key, start, end);
    }

    public Set<Tuple> zrangeWithScores(String key, long start, long end) {
        return ((Jedis) getShard(key)).zrangeWithScores(key, start, end);
    }

    public Set<Tuple> zrevrangeWithScores(String key, long start, long end) {
        return ((Jedis) getShard(key)).zrevrangeWithScores(key, start, end);
    }

    public Long zcard(String key) {
        return ((Jedis) getShard(key)).zcard(key);
    }

    public Double zscore(String key, String member) {
        return ((Jedis) getShard(key)).zscore(key, member);
    }

    public List<String> sort(String key) {
        return ((Jedis) getShard(key)).sort(key);
    }

    public List<String> sort(String key, SortingParams sortingParameters) {
        return ((Jedis) getShard(key)).sort(key, sortingParameters);
    }

    public Long zcount(String key, double min, double max) {
        return ((Jedis) getShard(key)).zcount(key, min, max);
    }

    public Long zcount(String key, String min, String max) {
        return ((Jedis) getShard(key)).zcount(key, min, max);
    }

    public Set<String> zrangeByScore(String key, double min, double max) {
        return ((Jedis) getShard(key)).zrangeByScore(key, min, max);
    }

    public Set<String> zrevrangeByScore(String key, double max, double min) {
        return ((Jedis) getShard(key)).zrevrangeByScore(key, max, min);
    }

    public Set<String> zrangeByScore(String key, double min, double max, int offset, int count) {
        return ((Jedis) getShard(key)).zrangeByScore(key, min, max, offset, count);
    }

    public Set<String> zrevrangeByScore(String key, double max, double min, int offset, int count) {
        return ((Jedis) getShard(key)).zrevrangeByScore(key, max, min, offset, count);
    }

    public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max) {
        return ((Jedis) getShard(key)).zrangeByScoreWithScores(key, min, max);
    }

    public Set<Tuple> zrevrangeByScoreWithScores(String key, double max, double min) {
        return ((Jedis) getShard(key)).zrevrangeByScoreWithScores(key, max, min);
    }

    public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max, int offset, int count) {
        return ((Jedis) getShard(key)).zrangeByScoreWithScores(key, min, max, offset, count);
    }

    public Set<Tuple> zrevrangeByScoreWithScores(String key, double max, double min, int offset, int count) {
        return ((Jedis) getShard(key)).zrevrangeByScoreWithScores(key, max, min, offset, count);
    }

    public Set<String> zrangeByScore(String key, String min, String max) {
        return ((Jedis) getShard(key)).zrangeByScore(key, min, max);
    }

    public Set<String> zrevrangeByScore(String key, String max, String min) {
        return ((Jedis) getShard(key)).zrevrangeByScore(key, max, min);
    }

    public Set<String> zrangeByScore(String key, String min, String max, int offset, int count) {
        return ((Jedis) getShard(key)).zrangeByScore(key, min, max, offset, count);
    }

    public Set<String> zrevrangeByScore(String key, String max, String min, int offset, int count) {
        return ((Jedis) getShard(key)).zrevrangeByScore(key, max, min, offset, count);
    }

    public Set<Tuple> zrangeByScoreWithScores(String key, String min, String max) {
        return ((Jedis) getShard(key)).zrangeByScoreWithScores(key, min, max);
    }

    public Set<Tuple> zrevrangeByScoreWithScores(String key, String max, String min) {
        return ((Jedis) getShard(key)).zrevrangeByScoreWithScores(key, max, min);
    }

    public Set<Tuple> zrangeByScoreWithScores(String key, String min, String max, int offset, int count) {
        return ((Jedis) getShard(key)).zrangeByScoreWithScores(key, min, max, offset, count);
    }

    public Set<Tuple> zrevrangeByScoreWithScores(String key, String max, String min, int offset, int count) {
        return ((Jedis) getShard(key)).zrevrangeByScoreWithScores(key, max, min, offset, count);
    }

    public Long zremrangeByRank(String key, long start, long end) {
        return ((Jedis) getShard(key)).zremrangeByRank(key, start, end);
    }

    public Long zremrangeByScore(String key, double start, double end) {
        return ((Jedis) getShard(key)).zremrangeByScore(key, start, end);
    }

    public Long zremrangeByScore(String key, String start, String end) {
        return ((Jedis) getShard(key)).zremrangeByScore(key, start, end);
    }

    public Long zlexcount(String key, String min, String max) {
        return ((Jedis) getShard(key)).zlexcount(key, min, max);
    }

    public Set<String> zrangeByLex(String key, String min, String max) {
        return ((Jedis) getShard(key)).zrangeByLex(key, min, max);
    }

    public Set<String> zrangeByLex(String key, String min, String max, int offset, int count) {
        return ((Jedis) getShard(key)).zrangeByLex(key, min, max, offset, count);
    }

    public Set<String> zrevrangeByLex(String key, String max, String min) {
        return ((Jedis) getShard(key)).zrevrangeByLex(key, max, min);
    }

    public Set<String> zrevrangeByLex(String key, String max, String min, int offset, int count) {
        return ((Jedis) getShard(key)).zrevrangeByLex(key, max, min, offset, count);
    }

    public Long zremrangeByLex(String key, String min, String max) {
        return ((Jedis) getShard(key)).zremrangeByLex(key, min, max);
    }

    public Long linsert(String key, BinaryClient.LIST_POSITION where, String pivot, String value) {
        return ((Jedis) getShard(key)).linsert(key, where, pivot, value);
    }

    public Long bitcount(String key) {
        return ((Jedis) getShard(key)).bitcount(key);
    }

    public Long bitcount(String key, long start, long end) {
        return ((Jedis) getShard(key)).bitcount(key, start, end);
    }

    public Long bitpos(String key, boolean value) {
        return ((Jedis) getShard(key)).bitpos(key, value);
    }

    public Long bitpos(String key, boolean value, BitPosParams params) {
        return ((Jedis) getShard(key)).bitpos(key, value, params);
    }

    public ScanResult<Map.Entry<String, String>> hscan(String key, String cursor) {
        return ((Jedis) getShard(key)).hscan(key, cursor);
    }

    public ScanResult<Map.Entry<String, String>> hscan(String key, String cursor, ScanParams params) {
        return ((Jedis) getShard(key)).hscan(key, cursor, params);
    }

    public ScanResult<String> sscan(String key, String cursor) {
        return ((Jedis) getShard(key)).sscan(key, cursor);
    }

    public ScanResult<Tuple> zscan(String key, String cursor) {
        return ((Jedis) getShard(key)).zscan(key, cursor);
    }

    public ScanResult<Tuple> zscan(String key, String cursor, ScanParams params) {
        return ((Jedis) getShard(key)).zscan(key, cursor, params);
    }

    public ScanResult<String> sscan(String key, String cursor, ScanParams params) {
        return ((Jedis) getShard(key)).sscan(key, cursor, params);
    }

    public void close() {
        if (this.dataSource != null) {
            boolean broken = false;
            Iterator it = getAllShards().iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((Jedis) it.next()).getClient().isBroken()) {
                        broken = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (broken) {
                this.dataSource.returnBrokenResource(this);
            } else {
                this.dataSource.returnResource(this);
            }
        } else {
            disconnect();
        }
    }

    public void setDataSource(ShardedJedisPool shardedJedisPool) {
        this.dataSource = shardedJedisPool;
    }

    public void resetState() {
        for (Jedis jedis : getAllShards()) {
            jedis.resetState();
        }
    }

    public Long pfadd(String key, String... elements) {
        return ((Jedis) getShard(key)).pfadd(key, elements);
    }

    public long pfcount(String key) {
        return ((Jedis) getShard(key)).pfcount(key);
    }

    public Long geoadd(String key, double longitude, double latitude, String member) {
        return ((Jedis) getShard(key)).geoadd(key, longitude, latitude, member);
    }

    public Long geoadd(String key, Map<String, GeoCoordinate> memberCoordinateMap) {
        return ((Jedis) getShard(key)).geoadd(key, memberCoordinateMap);
    }

    public Double geodist(String key, String member1, String member2) {
        return ((Jedis) getShard(key)).geodist(key, member1, member2);
    }

    public Double geodist(String key, String member1, String member2, GeoUnit unit) {
        return ((Jedis) getShard(key)).geodist(key, member1, member2, unit);
    }

    public List<String> geohash(String key, String... members) {
        return ((Jedis) getShard(key)).geohash(key, members);
    }

    public List<GeoCoordinate> geopos(String key, String... members) {
        return ((Jedis) getShard(key)).geopos(key, members);
    }

    public List<GeoRadiusResponse> georadius(String key, double longitude, double latitude, double radius, GeoUnit unit) {
        return ((Jedis) getShard(key)).georadius(key, longitude, latitude, radius, unit);
    }

    public List<GeoRadiusResponse> georadius(String key, double longitude, double latitude, double radius, GeoUnit unit, GeoRadiusParam param) {
        return ((Jedis) getShard(key)).georadius(key, longitude, latitude, radius, unit, param);
    }

    public List<GeoRadiusResponse> georadiusByMember(String key, String member, double radius, GeoUnit unit) {
        return ((Jedis) getShard(key)).georadiusByMember(key, member, radius, unit);
    }

    public List<GeoRadiusResponse> georadiusByMember(String key, String member, double radius, GeoUnit unit, GeoRadiusParam param) {
        return ((Jedis) getShard(key)).georadiusByMember(key, member, radius, unit, param);
    }

    public List<Long> bitfield(String key, String... arguments) {
        return ((Jedis) getShard(key)).bitfield(key, arguments);
    }

    public Long hstrlen(String key, String field) {
        return ((Jedis) getShard(key)).hstrlen(key, field);
    }
}
