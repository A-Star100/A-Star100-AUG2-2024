package redis.clients.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Slowlog {
    private static final String COMMA = ",";
    private final List<String> args;
    private final long executionTime;
    private final long id;
    private final long timeStamp;

    private Slowlog(List<Object> properties) {
        this.id = ((Long) properties.get(0)).longValue();
        this.timeStamp = ((Long) properties.get(1)).longValue();
        this.executionTime = ((Long) properties.get(2)).longValue();
        List<byte[]> bargs = (List) properties.get(3);
        this.args = new ArrayList(bargs.size());
        for (byte[] barg : bargs) {
            this.args.add(SafeEncoder.encode(barg));
        }
    }

    public static List<Slowlog> from(List<Object> nestedMultiBulkReply) {
        List<Slowlog> logs = new ArrayList<>(nestedMultiBulkReply.size());
        Iterator<Object> it = nestedMultiBulkReply.iterator();
        while (it.hasNext()) {
            logs.add(new Slowlog((List) it.next()));
        }
        return logs;
    }

    public long getId() {
        return this.id;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public long getExecutionTime() {
        return this.executionTime;
    }

    public List<String> getArgs() {
        return this.args;
    }

    public String toString() {
        return this.id + COMMA + this.timeStamp + COMMA + this.executionTime + COMMA + this.args;
    }
}
