package redis.clients.jedis.commands;

import java.util.List;
import java.util.Set;
import redis.clients.jedis.BinaryJedisPubSub;
import redis.clients.jedis.BitOP;
import redis.clients.jedis.SortingParams;
import redis.clients.jedis.ZParams;

public interface MultiKeyBinaryCommands {
    Long bitop(BitOP bitOP, byte[] bArr, byte[]... bArr2);

    List<byte[]> blpop(int i, byte[]... bArr);

    List<byte[]> blpop(byte[]... bArr);

    List<byte[]> brpop(int i, byte[]... bArr);

    List<byte[]> brpop(byte[]... bArr);

    byte[] brpoplpush(byte[] bArr, byte[] bArr2, int i);

    Long del(byte[]... bArr);

    Long exists(byte[]... bArr);

    Set<byte[]> keys(byte[] bArr);

    List<byte[]> mget(byte[]... bArr);

    String mset(byte[]... bArr);

    Long msetnx(byte[]... bArr);

    Long pfcount(byte[]... bArr);

    String pfmerge(byte[] bArr, byte[]... bArr2);

    void psubscribe(BinaryJedisPubSub binaryJedisPubSub, byte[]... bArr);

    Long publish(byte[] bArr, byte[] bArr2);

    byte[] randomBinaryKey();

    String rename(byte[] bArr, byte[] bArr2);

    Long renamenx(byte[] bArr, byte[] bArr2);

    byte[] rpoplpush(byte[] bArr, byte[] bArr2);

    Set<byte[]> sdiff(byte[]... bArr);

    Long sdiffstore(byte[] bArr, byte[]... bArr2);

    Set<byte[]> sinter(byte[]... bArr);

    Long sinterstore(byte[] bArr, byte[]... bArr2);

    Long smove(byte[] bArr, byte[] bArr2, byte[] bArr3);

    Long sort(byte[] bArr, SortingParams sortingParams, byte[] bArr2);

    Long sort(byte[] bArr, byte[] bArr2);

    void subscribe(BinaryJedisPubSub binaryJedisPubSub, byte[]... bArr);

    Set<byte[]> sunion(byte[]... bArr);

    Long sunionstore(byte[] bArr, byte[]... bArr2);

    String unwatch();

    String watch(byte[]... bArr);

    Long zinterstore(byte[] bArr, ZParams zParams, byte[]... bArr2);

    Long zinterstore(byte[] bArr, byte[]... bArr2);

    Long zunionstore(byte[] bArr, ZParams zParams, byte[]... bArr2);

    Long zunionstore(byte[] bArr, byte[]... bArr2);
}
