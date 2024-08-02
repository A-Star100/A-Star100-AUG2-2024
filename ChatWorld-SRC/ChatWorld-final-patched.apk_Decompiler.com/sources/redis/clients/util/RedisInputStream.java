package redis.clients.util;

import java.io.ByteArrayOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import redis.clients.jedis.exceptions.JedisConnectionException;

public class RedisInputStream extends FilterInputStream {
    protected final byte[] buf;
    protected int count;
    protected int limit;

    public RedisInputStream(InputStream in, int size) {
        super(in);
        if (size > 0) {
            this.buf = new byte[size];
            return;
        }
        throw new IllegalArgumentException("Buffer size <= 0");
    }

    public RedisInputStream(InputStream in) {
        this(in, 8192);
    }

    public byte readByte() throws JedisConnectionException {
        ensureFill();
        byte[] bArr = this.buf;
        int i = this.count;
        this.count = i + 1;
        return bArr[i];
    }

    public String readLine() {
        StringBuilder sb = new StringBuilder();
        while (true) {
            ensureFill();
            byte[] bArr = this.buf;
            int i = this.count;
            this.count = i + 1;
            byte b = bArr[i];
            if (b == 13) {
                ensureFill();
                byte[] bArr2 = this.buf;
                int i2 = this.count;
                this.count = i2 + 1;
                byte c = bArr2[i2];
                if (c == 10) {
                    break;
                }
                sb.append((char) b);
                sb.append((char) c);
            } else {
                sb.append((char) b);
            }
        }
        String reply = sb.toString();
        if (reply.length() != 0) {
            return reply;
        }
        throw new JedisConnectionException("It seems like server has closed the connection.");
    }

    public byte[] readLineBytes() {
        ensureFill();
        int pos = this.count;
        byte[] buf2 = this.buf;
        while (true) {
            int i = this.limit;
            if (pos == i) {
                return readLineBytesSlowly();
            }
            int pos2 = pos + 1;
            if (buf2[pos] != 13) {
                pos = pos2;
            } else if (pos2 == i) {
                return readLineBytesSlowly();
            } else {
                pos = pos2 + 1;
                if (buf2[pos2] == 10) {
                    int i2 = this.count;
                    int N = (pos - i2) - 2;
                    byte[] line = new byte[N];
                    System.arraycopy(buf2, i2, line, 0, N);
                    this.count = pos;
                    return line;
                }
            }
        }
    }

    private byte[] readLineBytesSlowly() {
        ByteArrayOutputStream bout = null;
        while (true) {
            ensureFill();
            byte[] bArr = this.buf;
            int i = this.count;
            this.count = i + 1;
            byte b = bArr[i];
            if (b == 13) {
                ensureFill();
                byte[] bArr2 = this.buf;
                int i2 = this.count;
                this.count = i2 + 1;
                byte c = bArr2[i2];
                if (c == 10) {
                    break;
                }
                if (bout == null) {
                    bout = new ByteArrayOutputStream(16);
                }
                bout.write(b);
                bout.write(c);
            } else {
                if (bout == null) {
                    bout = new ByteArrayOutputStream(16);
                }
                bout.write(b);
            }
        }
        return bout == null ? new byte[0] : bout.toByteArray();
    }

    public int readIntCrLf() {
        return (int) readLongCrLf();
    }

    public long readLongCrLf() {
        byte[] buf2 = this.buf;
        ensureFill();
        int i = this.count;
        boolean isNeg = buf2[i] == 45;
        if (isNeg) {
            this.count = i + 1;
        }
        long value = 0;
        while (true) {
            ensureFill();
            int i2 = this.count;
            this.count = i2 + 1;
            byte b = buf2[i2];
            if (b == 13) {
                break;
            }
            value = ((10 * value) + ((long) b)) - 48;
        }
        ensureFill();
        int i3 = this.count;
        this.count = i3 + 1;
        if (buf2[i3] == 10) {
            return isNeg ? -value : value;
        }
        throw new JedisConnectionException("Unexpected character!");
    }

    public int read(byte[] b, int off, int len) throws JedisConnectionException {
        ensureFill();
        int length = Math.min(this.limit - this.count, len);
        System.arraycopy(this.buf, this.count, b, off, length);
        this.count += length;
        return length;
    }

    private void ensureFill() throws JedisConnectionException {
        if (this.count >= this.limit) {
            try {
                int read = this.in.read(this.buf);
                this.limit = read;
                this.count = 0;
                if (read == -1) {
                    throw new JedisConnectionException("Unexpected end of stream.");
                }
            } catch (IOException e) {
                throw new JedisConnectionException((Throwable) e);
            }
        }
    }
}
