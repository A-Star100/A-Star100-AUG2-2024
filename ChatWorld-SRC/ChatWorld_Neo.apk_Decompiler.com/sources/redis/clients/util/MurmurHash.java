package redis.clients.util;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class MurmurHash implements Hashing {
    public static int hash(byte[] data, int seed) {
        return hash(ByteBuffer.wrap(data), seed);
    }

    public static int hash(byte[] data, int offset, int length, int seed) {
        return hash(ByteBuffer.wrap(data, offset, length), seed);
    }

    public static int hash(ByteBuffer buf, int seed) {
        ByteOrder byteOrder = buf.order();
        buf.order(ByteOrder.LITTLE_ENDIAN);
        int h = buf.remaining() ^ seed;
        while (buf.remaining() >= 4) {
            int k = buf.getInt() * 1540483477;
            h = (h * 1540483477) ^ ((k ^ (k >>> 24)) * 1540483477);
        }
        if (buf.remaining() > 0) {
            ByteBuffer finish = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
            finish.put(buf).rewind();
            h = (h ^ finish.getInt()) * 1540483477;
        }
        int h2 = (h ^ (h >>> 13)) * 1540483477;
        int h3 = h2 ^ (h2 >>> 15);
        buf.order(byteOrder);
        return h3;
    }

    public static long hash64A(byte[] data, int seed) {
        return hash64A(ByteBuffer.wrap(data), seed);
    }

    public static long hash64A(byte[] data, int offset, int length, int seed) {
        return hash64A(ByteBuffer.wrap(data, offset, length), seed);
    }

    public static long hash64A(ByteBuffer buf, int seed) {
        ByteOrder byteOrder = buf.order();
        buf.order(ByteOrder.LITTLE_ENDIAN);
        long h = ((long) seed) ^ (((long) buf.remaining()) * -4132994306676758123L);
        while (buf.remaining() >= 8) {
            long k = buf.getLong() * -4132994306676758123L;
            h = (h ^ ((k ^ (k >>> 47)) * -4132994306676758123L)) * -4132994306676758123L;
        }
        if (buf.remaining() > 0) {
            ByteBuffer finish = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);
            finish.put(buf).rewind();
            h = (h ^ finish.getLong()) * -4132994306676758123L;
        }
        long h2 = (h ^ (h >>> 47)) * -4132994306676758123L;
        long h3 = h2 ^ (h2 >>> 47);
        buf.order(byteOrder);
        return h3;
    }

    public long hash(byte[] key) {
        return hash64A(key, 305441741);
    }

    public long hash(String key) {
        return hash(SafeEncoder.encode(key));
    }
}
