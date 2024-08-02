package redis.clients.jedis.commands;

import java.util.List;
import redis.clients.jedis.Response;

public interface ClusterPipeline {
    Response<String> clusterAddSlots(int... iArr);

    Response<String> clusterDelSlots(int... iArr);

    Response<List<String>> clusterGetKeysInSlot(int i, int i2);

    Response<String> clusterInfo();

    Response<String> clusterMeet(String str, int i);

    Response<String> clusterNodes();

    Response<String> clusterSetSlotImporting(int i, String str);

    Response<String> clusterSetSlotMigrating(int i, String str);

    Response<String> clusterSetSlotNode(int i, String str);
}
