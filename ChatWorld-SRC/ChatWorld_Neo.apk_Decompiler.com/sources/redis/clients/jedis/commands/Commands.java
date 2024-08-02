package redis.clients.jedis.commands;

import java.util.Map;
import redis.clients.jedis.BinaryClient;
import redis.clients.jedis.BitOP;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.SortingParams;
import redis.clients.jedis.ZParams;
import redis.clients.jedis.params.set.SetParams;
import redis.clients.jedis.params.sortedset.ZAddParams;
import redis.clients.jedis.params.sortedset.ZIncrByParams;

public interface Commands {
    void append(String str, String str2);

    void bgrewriteaof();

    void bgsave();

    void bitcount(String str);

    void bitcount(String str, long j, long j2);

    void bitfield(String str, String... strArr);

    void bitop(BitOP bitOP, String str, String... strArr);

    void blpop(String[] strArr);

    void brpop(String[] strArr);

    void brpoplpush(String str, String str2, int i);

    void configGet(String str);

    void configResetStat();

    void configSet(String str, String str2);

    void decr(String str);

    void decrBy(String str, long j);

    void del(String... strArr);

    void discard();

    void echo(String str);

    void exec();

    void exists(String str);

    void exists(String... strArr);

    void expire(String str, int i);

    void expireAt(String str, long j);

    void get(String str);

    void getSet(String str, String str2);

    void getbit(String str, long j);

    void getrange(String str, long j, long j2);

    void hdel(String str, String... strArr);

    void hexists(String str, String str2);

    void hget(String str, String str2);

    void hgetAll(String str);

    void hincrBy(String str, String str2, long j);

    void hincrByFloat(String str, String str2, double d);

    void hkeys(String str);

    void hlen(String str);

    void hmget(String str, String... strArr);

    void hmset(String str, Map<String, String> map);

    void hscan(String str, String str2, ScanParams scanParams);

    void hset(String str, String str2, String str3);

    void hsetnx(String str, String str2, String str3);

    void hstrlen(String str, String str2);

    void hvals(String str);

    void incr(String str);

    void incrBy(String str, long j);

    void incrByFloat(String str, double d);

    void keys(String str);

    void lastsave();

    void lindex(String str, long j);

    void linsert(String str, BinaryClient.LIST_POSITION list_position, String str2, String str3);

    void llen(String str);

    void lpop(String str);

    void lpush(String str, String... strArr);

    void lpushx(String str, String... strArr);

    void lrange(String str, long j, long j2);

    void lrem(String str, long j, String str2);

    void lset(String str, long j, String str2);

    void ltrim(String str, long j, long j2);

    void mget(String... strArr);

    void move(String str, int i);

    void mset(String... strArr);

    void msetnx(String... strArr);

    void multi();

    void objectEncoding(String str);

    void objectIdletime(String str);

    void objectRefcount(String str);

    void persist(String str);

    void rename(String str, String str2);

    void renamenx(String str, String str2);

    void rpop(String str);

    void rpoplpush(String str, String str2);

    void rpush(String str, String... strArr);

    void rpushx(String str, String... strArr);

    void sadd(String str, String... strArr);

    void save();

    void scan(String str, ScanParams scanParams);

    void scard(String str);

    void sdiff(String... strArr);

    void sdiffstore(String str, String... strArr);

    void set(String str, String str2);

    void set(String str, String str2, SetParams setParams);

    void setbit(String str, long j, String str2);

    void setbit(String str, long j, boolean z);

    void setex(String str, int i, String str2);

    void setnx(String str, String str2);

    void setrange(String str, long j, String str2);

    void sinter(String... strArr);

    void sinterstore(String str, String... strArr);

    void sismember(String str, String str2);

    void smembers(String str);

    void smove(String str, String str2, String str3);

    void sort(String str);

    void sort(String str, String str2);

    void sort(String str, SortingParams sortingParams);

    void sort(String str, SortingParams sortingParams, String str2);

    void spop(String str);

    void spop(String str, long j);

    void srandmember(String str);

    void srem(String str, String... strArr);

    void sscan(String str, String str2, ScanParams scanParams);

    void strlen(String str);

    void substr(String str, int i, int i2);

    void sunion(String... strArr);

    void sunionstore(String str, String... strArr);

    void ttl(String str);

    void type(String str);

    void waitReplicas(int i, long j);

    void watch(String... strArr);

    void zadd(String str, double d, String str2);

    void zadd(String str, double d, String str2, ZAddParams zAddParams);

    void zadd(String str, Map<String, Double> map);

    void zadd(String str, Map<String, Double> map, ZAddParams zAddParams);

    void zcard(String str);

    void zcount(String str, double d, double d2);

    void zcount(String str, String str2, String str3);

    void zincrby(String str, double d, String str2);

    void zincrby(String str, double d, String str2, ZIncrByParams zIncrByParams);

    void zinterstore(String str, ZParams zParams, String... strArr);

    void zinterstore(String str, String... strArr);

    void zrange(String str, long j, long j2);

    void zrangeByScore(String str, double d, double d2);

    void zrangeByScore(String str, double d, double d2, int i, int i2);

    void zrangeByScore(String str, String str2, String str3);

    void zrangeByScoreWithScores(String str, double d, double d2);

    void zrangeByScoreWithScores(String str, double d, double d2, int i, int i2);

    void zrangeByScoreWithScores(String str, String str2, String str3);

    void zrangeByScoreWithScores(String str, String str2, String str3, int i, int i2);

    void zrangeWithScores(String str, long j, long j2);

    void zrank(String str, String str2);

    void zrem(String str, String... strArr);

    void zremrangeByRank(String str, long j, long j2);

    void zremrangeByScore(String str, double d, double d2);

    void zremrangeByScore(String str, String str2, String str3);

    void zrevrange(String str, long j, long j2);

    void zrevrangeByScore(String str, double d, double d2);

    void zrevrangeByScore(String str, double d, double d2, int i, int i2);

    void zrevrangeByScore(String str, String str2, String str3);

    void zrevrangeByScoreWithScores(String str, double d, double d2);

    void zrevrangeByScoreWithScores(String str, double d, double d2, int i, int i2);

    void zrevrangeByScoreWithScores(String str, String str2, String str3);

    void zrevrangeByScoreWithScores(String str, String str2, String str3, int i, int i2);

    void zrevrangeWithScores(String str, long j, long j2);

    void zrevrank(String str, String str2);

    void zscan(String str, String str2, ScanParams scanParams);

    void zscore(String str, String str2);

    void zunionstore(String str, ZParams zParams, String... strArr);

    void zunionstore(String str, String... strArr);
}
