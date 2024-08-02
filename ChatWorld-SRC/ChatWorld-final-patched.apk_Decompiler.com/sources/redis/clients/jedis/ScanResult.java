package redis.clients.jedis;

import java.util.List;
import redis.clients.util.SafeEncoder;

public class ScanResult<T> {
    private byte[] cursor;
    private List<T> results;

    public ScanResult(String cursor2, List<T> results2) {
        this(SafeEncoder.encode(cursor2), results2);
    }

    public ScanResult(byte[] cursor2, List<T> results2) {
        this.cursor = cursor2;
        this.results = results2;
    }

    public String getCursor() {
        return SafeEncoder.encode(this.cursor);
    }

    public byte[] getCursorAsBytes() {
        return this.cursor;
    }

    public List<T> getResult() {
        return this.results;
    }
}
