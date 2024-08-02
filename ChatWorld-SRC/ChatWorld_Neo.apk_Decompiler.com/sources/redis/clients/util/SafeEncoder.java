package redis.clients.util;

import java.io.UnsupportedEncodingException;
import redis.clients.jedis.Protocol;
import redis.clients.jedis.exceptions.JedisDataException;
import redis.clients.jedis.exceptions.JedisException;

public final class SafeEncoder {
    private SafeEncoder() {
        throw new InstantiationError("Must not instantiate this class");
    }

    public static byte[][] encodeMany(String... strs) {
        byte[][] many = new byte[strs.length][];
        for (int i = 0; i < strs.length; i++) {
            many[i] = encode(strs[i]);
        }
        return many;
    }

    public static byte[] encode(String str) {
        if (str != null) {
            try {
                return str.getBytes(Protocol.CHARSET);
            } catch (UnsupportedEncodingException e) {
                throw new JedisException((Throwable) e);
            }
        } else {
            throw new JedisDataException("value sent to redis cannot be null");
        }
    }

    public static String encode(byte[] data) {
        try {
            return new String(data, Protocol.CHARSET);
        } catch (UnsupportedEncodingException e) {
            throw new JedisException((Throwable) e);
        }
    }
}
