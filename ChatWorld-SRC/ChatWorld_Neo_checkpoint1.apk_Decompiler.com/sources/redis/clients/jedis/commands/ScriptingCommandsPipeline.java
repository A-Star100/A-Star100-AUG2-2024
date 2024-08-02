package redis.clients.jedis.commands;

import java.util.List;
import redis.clients.jedis.Response;

public interface ScriptingCommandsPipeline {
    Response<Object> eval(String str);

    Response<Object> eval(String str, int i, String... strArr);

    Response<Object> eval(String str, List<String> list, List<String> list2);

    Response<Object> evalsha(String str);

    Response<Object> evalsha(String str, int i, String... strArr);

    Response<Object> evalsha(String str, List<String> list, List<String> list2);
}
