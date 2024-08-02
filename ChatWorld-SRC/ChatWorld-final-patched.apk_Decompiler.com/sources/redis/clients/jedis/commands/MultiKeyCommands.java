package redis.clients.jedis.commands;

import java.util.List;
import java.util.Set;
import redis.clients.jedis.BitOP;
import redis.clients.jedis.JedisPubSub;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;
import redis.clients.jedis.SortingParams;
import redis.clients.jedis.ZParams;

public interface MultiKeyCommands {
    Long bitop(BitOP bitOP, String str, String... strArr);

    List<String> blpop(int i, String... strArr);

    List<String> blpop(String... strArr);

    List<String> brpop(int i, String... strArr);

    List<String> brpop(String... strArr);

    String brpoplpush(String str, String str2, int i);

    Long del(String... strArr);

    Long exists(String... strArr);

    Set<String> keys(String str);

    List<String> mget(String... strArr);

    String mset(String... strArr);

    Long msetnx(String... strArr);

    long pfcount(String... strArr);

    String pfmerge(String str, String... strArr);

    void psubscribe(JedisPubSub jedisPubSub, String... strArr);

    Long publish(String str, String str2);

    String randomKey();

    String rename(String str, String str2);

    Long renamenx(String str, String str2);

    String rpoplpush(String str, String str2);

    ScanResult<String> scan(String str);

    ScanResult<String> scan(String str, ScanParams scanParams);

    Set<String> sdiff(String... strArr);

    Long sdiffstore(String str, String... strArr);

    Set<String> sinter(String... strArr);

    Long sinterstore(String str, String... strArr);

    Long smove(String str, String str2, String str3);

    Long sort(String str, String str2);

    Long sort(String str, SortingParams sortingParams, String str2);

    void subscribe(JedisPubSub jedisPubSub, String... strArr);

    Set<String> sunion(String... strArr);

    Long sunionstore(String str, String... strArr);

    String unwatch();

    String watch(String... strArr);

    Long zinterstore(String str, ZParams zParams, String... strArr);

    Long zinterstore(String str, String... strArr);

    Long zunionstore(String str, ZParams zParams, String... strArr);

    Long zunionstore(String str, String... strArr);
}
