package redis.clients.jedis.commands;

import java.util.List;

public interface JedisClusterBinaryScriptingCommands {
    Object eval(byte[] bArr, int i, byte[]... bArr2);

    Object eval(byte[] bArr, List<byte[]> list, List<byte[]> list2);

    Object eval(byte[] bArr, byte[] bArr2);

    Object eval(byte[] bArr, byte[] bArr2, byte[]... bArr3);

    Object evalsha(byte[] bArr, int i, byte[]... bArr2);

    Object evalsha(byte[] bArr, List<byte[]> list, List<byte[]> list2);

    Object evalsha(byte[] bArr, byte[] bArr2);

    List<Long> scriptExists(byte[] bArr, byte[][] bArr2);

    String scriptFlush(byte[] bArr);

    String scriptKill(byte[] bArr);

    byte[] scriptLoad(byte[] bArr, byte[] bArr2);
}
