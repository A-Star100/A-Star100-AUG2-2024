package redis.clients.jedis.commands;

import java.util.List;
import redis.clients.jedis.Response;

public interface BinaryScriptingCommandsPipeline {
    Response<Object> eval(byte[] bArr);

    Response<Object> eval(byte[] bArr, int i, byte[]... bArr2);

    Response<Object> eval(byte[] bArr, List<byte[]> list, List<byte[]> list2);

    Response<Object> eval(byte[] bArr, byte[] bArr2, byte[]... bArr3);

    Response<Object> evalsha(byte[] bArr);

    Response<Object> evalsha(byte[] bArr, int i, byte[]... bArr2);

    Response<Object> evalsha(byte[] bArr, List<byte[]> list, List<byte[]> list2);
}
