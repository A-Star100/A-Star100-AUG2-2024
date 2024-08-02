package redis.clients.jedis.commands;

import java.util.List;

public interface AdvancedBinaryJedisCommands {
    List<byte[]> configGet(byte[] bArr);

    byte[] configSet(byte[] bArr, byte[] bArr2);

    byte[] objectEncoding(byte[] bArr);

    Long objectIdletime(byte[] bArr);

    Long objectRefcount(byte[] bArr);

    List<byte[]> slowlogGetBinary();

    List<byte[]> slowlogGetBinary(long j);

    Long slowlogLen();

    String slowlogReset();
}
