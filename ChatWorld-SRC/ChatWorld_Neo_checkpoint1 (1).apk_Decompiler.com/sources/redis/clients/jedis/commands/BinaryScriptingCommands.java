package redis.clients.jedis.commands;

import java.util.List;

public interface BinaryScriptingCommands {
    Object eval(byte[] bArr);

    Object eval(byte[] bArr, int i, byte[]... bArr2);

    Object eval(byte[] bArr, List<byte[]> list, List<byte[]> list2);

    Object eval(byte[] bArr, byte[] bArr2, byte[]... bArr3);

    Object evalsha(byte[] bArr);

    Object evalsha(byte[] bArr, int i, byte[]... bArr2);

    Object evalsha(byte[] bArr, List<byte[]> list, List<byte[]> list2);

    List<Long> scriptExists(byte[]... bArr);

    String scriptFlush();

    String scriptKill();

    byte[] scriptLoad(byte[] bArr);
}
