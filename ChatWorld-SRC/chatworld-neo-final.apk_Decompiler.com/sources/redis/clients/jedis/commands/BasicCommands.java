package redis.clients.jedis.commands;

import redis.clients.jedis.DebugParams;

public interface BasicCommands {
    String auth(String str);

    String bgrewriteaof();

    String bgsave();

    String configResetStat();

    Long dbSize();

    String debug(DebugParams debugParams);

    String flushAll();

    String flushDB();

    int getDB();

    String info();

    String info(String str);

    Long lastsave();

    String ping();

    String quit();

    String save();

    String select(int i);

    String shutdown();

    String slaveof(String str, int i);

    String slaveofNoOne();

    Long waitReplicas(int i, long j);
}
