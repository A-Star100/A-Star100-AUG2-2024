package redis.clients.jedis.commands;

import java.util.List;
import redis.clients.jedis.Module;
import redis.clients.jedis.Response;

public interface BasicRedisPipeline {
    Response<String> bgrewriteaof();

    Response<String> bgsave();

    Response<List<String>> configGet(String str);

    Response<String> configResetStat();

    Response<String> configSet(String str, String str2);

    Response<Long> dbSize();

    Response<String> flushAll();

    Response<String> flushDB();

    Response<String> info();

    Response<Long> lastsave();

    Response<List<Module>> moduleList();

    Response<String> moduleLoad(String str);

    Response<String> moduleUnload(String str);

    Response<String> ping();

    Response<String> save();

    Response<String> select(int i);

    Response<String> shutdown();

    Response<List<String>> time();
}
