package redis.clients.jedis.params;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import redis.clients.util.SafeEncoder;

public abstract class Params {
    private Map<String, Object> params;

    public <T> T getParam(String name) {
        Map<String, Object> map = this.params;
        if (map == null) {
            return null;
        }
        return map.get(name);
    }

    public byte[][] getByteParams() {
        ArrayList<byte[]> byteParams = new ArrayList<>();
        for (Map.Entry<String, Object> param : this.params.entrySet()) {
            byteParams.add(SafeEncoder.encode(param.getKey()));
            if (param.getValue() != null) {
                byteParams.add(SafeEncoder.encode(String.valueOf(param.getValue())));
            }
        }
        return (byte[][]) byteParams.toArray(new byte[byteParams.size()][]);
    }

    public boolean contains(String name) {
        Map<String, Object> map = this.params;
        if (map == null) {
            return false;
        }
        return map.containsKey(name);
    }

    /* access modifiers changed from: protected */
    public void addParam(String name, Object value) {
        if (this.params == null) {
            this.params = new HashMap();
        }
        this.params.put(name, value);
    }

    /* access modifiers changed from: protected */
    public void addParam(String name) {
        if (this.params == null) {
            this.params = new HashMap();
        }
        this.params.put(name, (Object) null);
    }
}
