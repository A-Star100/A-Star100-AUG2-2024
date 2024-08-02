package redis.clients.jedis.commands;

import java.util.List;

public interface ScriptingCommands {
    Object eval(String str);

    Object eval(String str, int i, String... strArr);

    Object eval(String str, List<String> list, List<String> list2);

    Object evalsha(String str);

    Object evalsha(String str, int i, String... strArr);

    Object evalsha(String str, List<String> list, List<String> list2);

    Boolean scriptExists(String str);

    List<Boolean> scriptExists(String... strArr);

    String scriptLoad(String str);
}
