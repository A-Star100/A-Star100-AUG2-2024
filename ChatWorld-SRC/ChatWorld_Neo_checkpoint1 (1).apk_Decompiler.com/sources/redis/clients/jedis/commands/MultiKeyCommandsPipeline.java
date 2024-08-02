package redis.clients.jedis.commands;

import java.util.List;
import java.util.Set;
import redis.clients.jedis.BitOP;
import redis.clients.jedis.Response;
import redis.clients.jedis.SortingParams;
import redis.clients.jedis.ZParams;

public interface MultiKeyCommandsPipeline {
    Response<Long> bitop(BitOP bitOP, String str, String... strArr);

    Response<List<String>> blpop(String... strArr);

    Response<List<String>> brpop(String... strArr);

    Response<String> brpoplpush(String str, String str2, int i);

    Response<Long> del(String... strArr);

    Response<Long> exists(String... strArr);

    Response<Set<String>> keys(String str);

    Response<List<String>> mget(String... strArr);

    Response<String> mset(String... strArr);

    Response<Long> msetnx(String... strArr);

    Response<Long> pfcount(String... strArr);

    Response<String> pfmerge(String str, String... strArr);

    Response<Long> publish(String str, String str2);

    Response<String> randomKey();

    Response<String> rename(String str, String str2);

    Response<Long> renamenx(String str, String str2);

    Response<String> rpoplpush(String str, String str2);

    Response<Set<String>> sdiff(String... strArr);

    Response<Long> sdiffstore(String str, String... strArr);

    Response<Set<String>> sinter(String... strArr);

    Response<Long> sinterstore(String str, String... strArr);

    Response<Long> smove(String str, String str2, String str3);

    Response<Long> sort(String str, String str2);

    Response<Long> sort(String str, SortingParams sortingParams, String str2);

    Response<Set<String>> sunion(String... strArr);

    Response<Long> sunionstore(String str, String... strArr);

    Response<String> watch(String... strArr);

    Response<Long> zinterstore(String str, ZParams zParams, String... strArr);

    Response<Long> zinterstore(String str, String... strArr);

    Response<Long> zunionstore(String str, ZParams zParams, String... strArr);

    Response<Long> zunionstore(String str, String... strArr);
}
