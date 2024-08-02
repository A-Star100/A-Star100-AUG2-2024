package redis.clients.jedis.commands;

import java.util.List;
import redis.clients.jedis.JedisCluster;

public interface ClusterCommands {
    String clusterAddSlots(int... iArr);

    Long clusterCountKeysInSlot(int i);

    String clusterDelSlots(int... iArr);

    String clusterFailover();

    String clusterFlushSlots();

    String clusterForget(String str);

    List<String> clusterGetKeysInSlot(int i, int i2);

    String clusterInfo();

    Long clusterKeySlot(String str);

    String clusterMeet(String str, int i);

    String clusterNodes();

    String clusterReplicate(String str);

    String clusterReset(JedisCluster.Reset reset);

    String clusterSaveConfig();

    String clusterSetSlotImporting(int i, String str);

    String clusterSetSlotMigrating(int i, String str);

    String clusterSetSlotNode(int i, String str);

    String clusterSetSlotStable(int i);

    List<String> clusterSlaves(String str);

    List<Object> clusterSlots();

    String readonly();
}
