package redis.clients.jedis.commands;

import java.util.List;
import java.util.Set;
import redis.clients.jedis.BitOP;
import redis.clients.jedis.Response;
import redis.clients.jedis.SortingParams;
import redis.clients.jedis.ZParams;

public interface MultiKeyBinaryRedisPipeline {
    Response<Long> bitop(BitOP bitOP, byte[] bArr, byte[]... bArr2);

    Response<List<byte[]>> blpop(byte[]... bArr);

    Response<List<byte[]>> brpop(byte[]... bArr);

    Response<byte[]> brpoplpush(byte[] bArr, byte[] bArr2, int i);

    Response<Long> del(byte[]... bArr);

    Response<Long> exists(byte[]... bArr);

    Response<Set<byte[]>> keys(byte[] bArr);

    Response<List<byte[]>> mget(byte[]... bArr);

    Response<String> mset(byte[]... bArr);

    Response<Long> msetnx(byte[]... bArr);

    Response<Long> pfcount(byte[]... bArr);

    Response<String> pfmerge(byte[] bArr, byte[]... bArr2);

    Response<Long> publish(byte[] bArr, byte[] bArr2);

    Response<byte[]> randomKeyBinary();

    Response<String> rename(byte[] bArr, byte[] bArr2);

    Response<Long> renamenx(byte[] bArr, byte[] bArr2);

    Response<byte[]> rpoplpush(byte[] bArr, byte[] bArr2);

    Response<Set<byte[]>> sdiff(byte[]... bArr);

    Response<Long> sdiffstore(byte[] bArr, byte[]... bArr2);

    Response<Set<byte[]>> sinter(byte[]... bArr);

    Response<Long> sinterstore(byte[] bArr, byte[]... bArr2);

    Response<Long> smove(byte[] bArr, byte[] bArr2, byte[] bArr3);

    Response<Long> sort(byte[] bArr, SortingParams sortingParams, byte[] bArr2);

    Response<Long> sort(byte[] bArr, byte[] bArr2);

    Response<Set<byte[]>> sunion(byte[]... bArr);

    Response<Long> sunionstore(byte[] bArr, byte[]... bArr2);

    Response<String> watch(byte[]... bArr);

    Response<Long> zinterstore(byte[] bArr, ZParams zParams, byte[]... bArr2);

    Response<Long> zinterstore(byte[] bArr, byte[]... bArr2);

    Response<Long> zunionstore(byte[] bArr, ZParams zParams, byte[]... bArr2);

    Response<Long> zunionstore(byte[] bArr, byte[]... bArr2);
}
