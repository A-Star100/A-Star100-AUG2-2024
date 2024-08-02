package redis.clients.jedis;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import redis.clients.jedis.Protocol;
import redis.clients.util.SafeEncoder;

public class ScanParams {
    public static final String SCAN_POINTER_START;
    public static final byte[] SCAN_POINTER_START_BINARY;
    private final Map<Protocol.Keyword, ByteBuffer> params = new EnumMap(Protocol.Keyword.class);

    static {
        String valueOf = String.valueOf(0);
        SCAN_POINTER_START = valueOf;
        SCAN_POINTER_START_BINARY = SafeEncoder.encode(valueOf);
    }

    public ScanParams match(byte[] pattern) {
        this.params.put(Protocol.Keyword.MATCH, ByteBuffer.wrap(pattern));
        return this;
    }

    public ScanParams match(String pattern) {
        this.params.put(Protocol.Keyword.MATCH, ByteBuffer.wrap(SafeEncoder.encode(pattern)));
        return this;
    }

    public ScanParams count(Integer count) {
        this.params.put(Protocol.Keyword.COUNT, ByteBuffer.wrap(Protocol.toByteArray(count.intValue())));
        return this;
    }

    public Collection<byte[]> getParams() {
        List<byte[]> paramsList = new ArrayList<>(this.params.size());
        for (Map.Entry<Protocol.Keyword, ByteBuffer> param : this.params.entrySet()) {
            paramsList.add(param.getKey().raw);
            paramsList.add(param.getValue().array());
        }
        return Collections.unmodifiableCollection(paramsList);
    }

    /* access modifiers changed from: package-private */
    public String match() {
        if (this.params.containsKey(Protocol.Keyword.MATCH)) {
            return new String(this.params.get(Protocol.Keyword.MATCH).array());
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Integer count() {
        if (this.params.containsKey(Protocol.Keyword.COUNT)) {
            return Integer.valueOf(this.params.get(Protocol.Keyword.COUNT).getInt());
        }
        return null;
    }
}
