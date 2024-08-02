package redis.clients.jedis.commands;

import java.util.List;
import redis.clients.util.Slowlog;

public interface AdvancedJedisCommands {
    List<String> configGet(String str);

    String configSet(String str, String str2);

    String objectEncoding(String str);

    Long objectIdletime(String str);

    Long objectRefcount(String str);

    List<Slowlog> slowlogGet();

    List<Slowlog> slowlogGet(long j);

    Long slowlogLen();

    String slowlogReset();
}
