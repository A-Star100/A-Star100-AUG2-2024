package redis.clients.jedis.commands;

import java.util.List;
import redis.clients.jedis.Module;

public interface ModuleCommands {
    List<Module> moduleList();

    String moduleLoad(String str);

    String moduleUnload(String str);
}
