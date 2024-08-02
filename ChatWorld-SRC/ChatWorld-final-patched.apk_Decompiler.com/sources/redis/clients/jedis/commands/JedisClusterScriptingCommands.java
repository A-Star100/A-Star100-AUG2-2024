package redis.clients.jedis.commands;

import java.util.List;

public interface JedisClusterScriptingCommands {
    Object eval(String str, int i, String... strArr);

    Object eval(String str, String str2);

    Object eval(String str, List<String> list, List<String> list2);

    Object evalsha(String str, int i, String... strArr);

    Object evalsha(String str, String str2);

    Object evalsha(String str, List<String> list, List<String> list2);

    Boolean scriptExists(String str, String str2);

    List<Boolean> scriptExists(String str, String... strArr);

    String scriptLoad(String str, String str2);
}
