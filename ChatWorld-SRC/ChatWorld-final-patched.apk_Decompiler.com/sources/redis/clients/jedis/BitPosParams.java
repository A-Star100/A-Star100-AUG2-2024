package redis.clients.jedis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BitPosParams {
    private List<byte[]> params;

    protected BitPosParams() {
        this.params = new ArrayList();
    }

    public BitPosParams(long start) {
        ArrayList arrayList = new ArrayList();
        this.params = arrayList;
        arrayList.add(Protocol.toByteArray(start));
    }

    public BitPosParams(long start, long end) {
        this(start);
        this.params.add(Protocol.toByteArray(end));
    }

    public Collection<byte[]> getParams() {
        return Collections.unmodifiableCollection(this.params);
    }
}
