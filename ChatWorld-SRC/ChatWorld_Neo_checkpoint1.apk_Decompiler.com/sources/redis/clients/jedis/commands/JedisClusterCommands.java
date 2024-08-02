package redis.clients.jedis.commands;

import java.util.List;
import java.util.Map;
import java.util.Set;
import redis.clients.jedis.BinaryClient;
import redis.clients.jedis.GeoCoordinate;
import redis.clients.jedis.GeoRadiusResponse;
import redis.clients.jedis.GeoUnit;
import redis.clients.jedis.ScanResult;
import redis.clients.jedis.SortingParams;
import redis.clients.jedis.Tuple;
import redis.clients.jedis.params.geo.GeoRadiusParam;
import redis.clients.jedis.params.set.SetParams;
import redis.clients.jedis.params.sortedset.ZAddParams;
import redis.clients.jedis.params.sortedset.ZIncrByParams;

public interface JedisClusterCommands {
    Long append(String str, String str2);

    Long bitcount(String str);

    Long bitcount(String str, long j, long j2);

    List<Long> bitfield(String str, String... strArr);

    List<String> blpop(int i, String str);

    List<String> brpop(int i, String str);

    Long decr(String str);

    Long decrBy(String str, long j);

    Long del(String str);

    String echo(String str);

    Boolean exists(String str);

    Long expire(String str, int i);

    Long expireAt(String str, long j);

    Long geoadd(String str, double d, double d2, String str2);

    Long geoadd(String str, Map<String, GeoCoordinate> map);

    Double geodist(String str, String str2, String str3);

    Double geodist(String str, String str2, String str3, GeoUnit geoUnit);

    List<String> geohash(String str, String... strArr);

    List<GeoCoordinate> geopos(String str, String... strArr);

    List<GeoRadiusResponse> georadius(String str, double d, double d2, double d3, GeoUnit geoUnit);

    List<GeoRadiusResponse> georadius(String str, double d, double d2, double d3, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam);

    List<GeoRadiusResponse> georadiusByMember(String str, String str2, double d, GeoUnit geoUnit);

    List<GeoRadiusResponse> georadiusByMember(String str, String str2, double d, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam);

    String get(String str);

    String getSet(String str, String str2);

    Boolean getbit(String str, long j);

    String getrange(String str, long j, long j2);

    Long hdel(String str, String... strArr);

    Boolean hexists(String str, String str2);

    String hget(String str, String str2);

    Map<String, String> hgetAll(String str);

    Long hincrBy(String str, String str2, long j);

    Set<String> hkeys(String str);

    Long hlen(String str);

    List<String> hmget(String str, String... strArr);

    String hmset(String str, Map<String, String> map);

    ScanResult<Map.Entry<String, String>> hscan(String str, String str2);

    Long hset(String str, String str2, String str3);

    Long hsetnx(String str, String str2, String str3);

    Long hstrlen(String str, String str2);

    List<String> hvals(String str);

    Long incr(String str);

    Long incrBy(String str, long j);

    Double incrByFloat(String str, double d);

    String lindex(String str, long j);

    Long linsert(String str, BinaryClient.LIST_POSITION list_position, String str2, String str3);

    Long llen(String str);

    String lpop(String str);

    Long lpush(String str, String... strArr);

    Long lpushx(String str, String... strArr);

    List<String> lrange(String str, long j, long j2);

    Long lrem(String str, long j, String str2);

    String lset(String str, long j, String str2);

    String ltrim(String str, long j, long j2);

    Long persist(String str);

    Long pexpire(String str, long j);

    Long pexpireAt(String str, long j);

    Long pfadd(String str, String... strArr);

    long pfcount(String str);

    String rpop(String str);

    Long rpush(String str, String... strArr);

    Long rpushx(String str, String... strArr);

    Long sadd(String str, String... strArr);

    Long scard(String str);

    String set(String str, String str2);

    String set(String str, String str2, SetParams setParams);

    Boolean setbit(String str, long j, String str2);

    Boolean setbit(String str, long j, boolean z);

    String setex(String str, int i, String str2);

    Long setnx(String str, String str2);

    Long setrange(String str, long j, String str2);

    Boolean sismember(String str, String str2);

    Set<String> smembers(String str);

    List<String> sort(String str);

    List<String> sort(String str, SortingParams sortingParams);

    String spop(String str);

    Set<String> spop(String str, long j);

    String srandmember(String str);

    List<String> srandmember(String str, int i);

    Long srem(String str, String... strArr);

    ScanResult<String> sscan(String str, String str2);

    Long strlen(String str);

    String substr(String str, int i, int i2);

    Long ttl(String str);

    String type(String str);

    Long zadd(String str, double d, String str2);

    Long zadd(String str, double d, String str2, ZAddParams zAddParams);

    Long zadd(String str, Map<String, Double> map);

    Long zadd(String str, Map<String, Double> map, ZAddParams zAddParams);

    Long zcard(String str);

    Long zcount(String str, double d, double d2);

    Long zcount(String str, String str2, String str3);

    Double zincrby(String str, double d, String str2);

    Double zincrby(String str, double d, String str2, ZIncrByParams zIncrByParams);

    Long zlexcount(String str, String str2, String str3);

    Set<String> zrange(String str, long j, long j2);

    Set<String> zrangeByLex(String str, String str2, String str3);

    Set<String> zrangeByLex(String str, String str2, String str3, int i, int i2);

    Set<String> zrangeByScore(String str, double d, double d2);

    Set<String> zrangeByScore(String str, double d, double d2, int i, int i2);

    Set<String> zrangeByScore(String str, String str2, String str3);

    Set<String> zrangeByScore(String str, String str2, String str3, int i, int i2);

    Set<Tuple> zrangeByScoreWithScores(String str, double d, double d2);

    Set<Tuple> zrangeByScoreWithScores(String str, double d, double d2, int i, int i2);

    Set<Tuple> zrangeByScoreWithScores(String str, String str2, String str3);

    Set<Tuple> zrangeByScoreWithScores(String str, String str2, String str3, int i, int i2);

    Set<Tuple> zrangeWithScores(String str, long j, long j2);

    Long zrank(String str, String str2);

    Long zrem(String str, String... strArr);

    Long zremrangeByLex(String str, String str2, String str3);

    Long zremrangeByRank(String str, long j, long j2);

    Long zremrangeByScore(String str, double d, double d2);

    Long zremrangeByScore(String str, String str2, String str3);

    Set<String> zrevrange(String str, long j, long j2);

    Set<String> zrevrangeByLex(String str, String str2, String str3);

    Set<String> zrevrangeByLex(String str, String str2, String str3, int i, int i2);

    Set<String> zrevrangeByScore(String str, double d, double d2);

    Set<String> zrevrangeByScore(String str, double d, double d2, int i, int i2);

    Set<String> zrevrangeByScore(String str, String str2, String str3);

    Set<String> zrevrangeByScore(String str, String str2, String str3, int i, int i2);

    Set<Tuple> zrevrangeByScoreWithScores(String str, double d, double d2);

    Set<Tuple> zrevrangeByScoreWithScores(String str, double d, double d2, int i, int i2);

    Set<Tuple> zrevrangeByScoreWithScores(String str, String str2, String str3);

    Set<Tuple> zrevrangeByScoreWithScores(String str, String str2, String str3, int i, int i2);

    Set<Tuple> zrevrangeWithScores(String str, long j, long j2);

    Long zrevrank(String str, String str2);

    ScanResult<Tuple> zscan(String str, String str2);

    Double zscore(String str, String str2);
}
