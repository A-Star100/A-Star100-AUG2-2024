package redis.clients.jedis.commands;

import java.util.List;
import java.util.Map;

public interface SentinelCommands {
    String sentinelFailover(String str);

    List<String> sentinelGetMasterAddrByName(String str);

    List<Map<String, String>> sentinelMasters();

    String sentinelMonitor(String str, String str2, int i, int i2);

    String sentinelRemove(String str);

    Long sentinelReset(String str);

    String sentinelSet(String str, Map<String, String> map);

    List<Map<String, String>> sentinelSlaves(String str);
}
