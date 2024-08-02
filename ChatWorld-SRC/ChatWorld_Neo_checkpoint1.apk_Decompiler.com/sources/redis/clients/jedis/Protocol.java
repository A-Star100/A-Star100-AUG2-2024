package redis.clients.jedis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import redis.clients.jedis.commands.ProtocolCommand;
import redis.clients.jedis.exceptions.JedisAskDataException;
import redis.clients.jedis.exceptions.JedisBusyException;
import redis.clients.jedis.exceptions.JedisClusterException;
import redis.clients.jedis.exceptions.JedisConnectionException;
import redis.clients.jedis.exceptions.JedisDataException;
import redis.clients.jedis.exceptions.JedisMovedDataException;
import redis.clients.jedis.exceptions.JedisNoScriptException;
import redis.clients.util.RedisInputStream;
import redis.clients.util.RedisOutputStream;
import redis.clients.util.SafeEncoder;

public final class Protocol {
    private static final String ASK_RESPONSE = "ASK";
    public static final byte ASTERISK_BYTE = 42;
    private static final String BUSY_RESPONSE = "BUSY";
    public static final byte[] BYTES_FALSE = toByteArray(0);
    public static final byte[] BYTES_TRUE = toByteArray(1);
    public static final String CHARSET = "UTF-8";
    private static final String CLUSTERDOWN_RESPONSE = "CLUSTERDOWN";
    public static final String CLUSTER_ADDSLOTS = "addslots";
    public static final String CLUSTER_COUNTKEYINSLOT = "countkeysinslot";
    public static final String CLUSTER_DELSLOTS = "delslots";
    public static final String CLUSTER_FAILOVER = "failover";
    public static final String CLUSTER_FLUSHSLOT = "flushslots";
    public static final String CLUSTER_FORGET = "forget";
    public static final String CLUSTER_GETKEYSINSLOT = "getkeysinslot";
    public static final String CLUSTER_INFO = "info";
    public static final String CLUSTER_KEYSLOT = "keyslot";
    public static final String CLUSTER_MEET = "meet";
    public static final String CLUSTER_NODES = "nodes";
    public static final String CLUSTER_REPLICATE = "replicate";
    public static final String CLUSTER_RESET = "reset";
    public static final String CLUSTER_SAVECONFIG = "saveconfig";
    public static final String CLUSTER_SETSLOT = "setslot";
    public static final String CLUSTER_SETSLOT_IMPORTING = "importing";
    public static final String CLUSTER_SETSLOT_MIGRATING = "migrating";
    public static final String CLUSTER_SETSLOT_NODE = "node";
    public static final String CLUSTER_SETSLOT_STABLE = "stable";
    public static final String CLUSTER_SLAVES = "slaves";
    public static final String CLUSTER_SLOTS = "slots";
    public static final byte COLON_BYTE = 58;
    public static final int DEFAULT_DATABASE = 0;
    public static final String DEFAULT_HOST = "localhost";
    public static final int DEFAULT_PORT = 6379;
    public static final int DEFAULT_SENTINEL_PORT = 26379;
    public static final int DEFAULT_TIMEOUT = 2000;
    public static final byte DOLLAR_BYTE = 36;
    public static final byte MINUS_BYTE = 45;
    private static final String MOVED_RESPONSE = "MOVED";
    private static final String NOSCRIPT_RESPONSE = "NOSCRIPT";
    public static final byte PLUS_BYTE = 43;
    public static final String PUBSUB_CHANNELS = "channels";
    public static final String PUBSUB_NUMSUB = "numsub";
    public static final String PUBSUB_NUM_PAT = "numpat";
    public static final String SENTINEL_FAILOVER = "failover";
    public static final String SENTINEL_GET_MASTER_ADDR_BY_NAME = "get-master-addr-by-name";
    public static final String SENTINEL_MASTERS = "masters";
    public static final String SENTINEL_MONITOR = "monitor";
    public static final String SENTINEL_REMOVE = "remove";
    public static final String SENTINEL_RESET = "reset";
    public static final String SENTINEL_SET = "set";
    public static final String SENTINEL_SLAVES = "slaves";

    public enum Keyword {
        AGGREGATE,
        ALPHA,
        ASC,
        BY,
        DESC,
        GET,
        LIMIT,
        MESSAGE,
        NO,
        NOSORT,
        PMESSAGE,
        PSUBSCRIBE,
        PUNSUBSCRIBE,
        OK,
        ONE,
        QUEUED,
        SET,
        STORE,
        SUBSCRIBE,
        UNSUBSCRIBE,
        WEIGHTS,
        WITHSCORES,
        RESETSTAT,
        RESET,
        FLUSH,
        EXISTS,
        LOAD,
        KILL,
        LEN,
        REFCOUNT,
        ENCODING,
        IDLETIME,
        AND,
        OR,
        XOR,
        NOT,
        GETNAME,
        SETNAME,
        LIST,
        MATCH,
        COUNT,
        PING,
        PONG,
        UNLOAD;
        
        public final byte[] raw;
    }

    private Protocol() {
    }

    public static void sendCommand(RedisOutputStream os, ProtocolCommand command, byte[]... args) {
        sendCommand(os, command.getRaw(), args);
    }

    private static void sendCommand(RedisOutputStream os, byte[] command, byte[]... args) {
        try {
            os.write((byte) 42);
            os.writeIntCrLf(args.length + 1);
            os.write((byte) 36);
            os.writeIntCrLf(command.length);
            os.write(command);
            os.writeCrLf();
            for (byte[] arg : args) {
                os.write((byte) 36);
                os.writeIntCrLf(arg.length);
                os.write(arg);
                os.writeCrLf();
            }
        } catch (IOException e) {
            throw new JedisConnectionException((Throwable) e);
        }
    }

    private static void processError(RedisInputStream is) {
        String message = is.readLine();
        if (message.startsWith(MOVED_RESPONSE)) {
            String[] movedInfo = parseTargetHostAndSlot(message);
            throw new JedisMovedDataException(message, new HostAndPort(movedInfo[1], Integer.valueOf(movedInfo[2]).intValue()), Integer.valueOf(movedInfo[0]).intValue());
        } else if (message.startsWith(ASK_RESPONSE)) {
            String[] askInfo = parseTargetHostAndSlot(message);
            throw new JedisAskDataException(message, new HostAndPort(askInfo[1], Integer.valueOf(askInfo[2]).intValue()), Integer.valueOf(askInfo[0]).intValue());
        } else if (message.startsWith(CLUSTERDOWN_RESPONSE)) {
            throw new JedisClusterException(message);
        } else if (message.startsWith(BUSY_RESPONSE)) {
            throw new JedisBusyException(message);
        } else if (message.startsWith(NOSCRIPT_RESPONSE)) {
            throw new JedisNoScriptException(message);
        } else {
            throw new JedisDataException(message);
        }
    }

    public static String readErrorLineIfPossible(RedisInputStream is) {
        if (is.readByte() != 45) {
            return null;
        }
        return is.readLine();
    }

    private static String[] parseTargetHostAndSlot(String clusterRedirectResponse) {
        String[] messageInfo = clusterRedirectResponse.split(" ");
        String[] targetHostAndPort = HostAndPort.extractParts(messageInfo[2]);
        return new String[]{messageInfo[1], targetHostAndPort[0], targetHostAndPort[1]};
    }

    private static Object process(RedisInputStream is) {
        byte b = is.readByte();
        if (b == 43) {
            return processStatusCodeReply(is);
        }
        if (b == 36) {
            return processBulkReply(is);
        }
        if (b == 42) {
            return processMultiBulkReply(is);
        }
        if (b == 58) {
            return processInteger(is);
        }
        if (b == 45) {
            processError(is);
            return null;
        }
        throw new JedisConnectionException("Unknown reply: " + ((char) b));
    }

    private static byte[] processStatusCodeReply(RedisInputStream is) {
        return is.readLineBytes();
    }

    private static byte[] processBulkReply(RedisInputStream is) {
        int len = is.readIntCrLf();
        if (len == -1) {
            return null;
        }
        byte[] read = new byte[len];
        int offset = 0;
        while (offset < len) {
            int size = is.read(read, offset, len - offset);
            if (size != -1) {
                offset += size;
            } else {
                throw new JedisConnectionException("It seems like server has closed the connection.");
            }
        }
        is.readByte();
        is.readByte();
        return read;
    }

    private static Long processInteger(RedisInputStream is) {
        return Long.valueOf(is.readLongCrLf());
    }

    private static List<Object> processMultiBulkReply(RedisInputStream is) {
        int num = is.readIntCrLf();
        if (num == -1) {
            return null;
        }
        List<Object> ret = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            try {
                ret.add(process(is));
            } catch (JedisDataException e) {
                ret.add(e);
            }
        }
        return ret;
    }

    public static Object read(RedisInputStream is) {
        return process(is);
    }

    public static final byte[] toByteArray(boolean value) {
        return value ? BYTES_TRUE : BYTES_FALSE;
    }

    public static final byte[] toByteArray(int value) {
        return SafeEncoder.encode(String.valueOf(value));
    }

    public static final byte[] toByteArray(long value) {
        return SafeEncoder.encode(String.valueOf(value));
    }

    public static final byte[] toByteArray(double value) {
        if (!Double.isInfinite(value)) {
            return SafeEncoder.encode(String.valueOf(value));
        }
        return (value == Double.POSITIVE_INFINITY ? "+inf" : "-inf").getBytes();
    }

    public enum Command implements ProtocolCommand {
        PING,
        SET,
        GET,
        QUIT,
        EXISTS,
        DEL,
        TYPE,
        FLUSHDB,
        KEYS,
        RANDOMKEY,
        RENAME,
        RENAMENX,
        RENAMEX,
        DBSIZE,
        EXPIRE,
        EXPIREAT,
        TTL,
        SELECT,
        MOVE,
        FLUSHALL,
        GETSET,
        MGET,
        SETNX,
        SETEX,
        MSET,
        MSETNX,
        DECRBY,
        DECR,
        INCRBY,
        INCR,
        APPEND,
        SUBSTR,
        HSET,
        HGET,
        HSETNX,
        HMSET,
        HMGET,
        HINCRBY,
        HEXISTS,
        HDEL,
        HLEN,
        HKEYS,
        HVALS,
        HGETALL,
        RPUSH,
        LPUSH,
        LLEN,
        LRANGE,
        LTRIM,
        LINDEX,
        LSET,
        LREM,
        LPOP,
        RPOP,
        RPOPLPUSH,
        SADD,
        SMEMBERS,
        SREM,
        SPOP,
        SMOVE,
        SCARD,
        SISMEMBER,
        SINTER,
        SINTERSTORE,
        SUNION,
        SUNIONSTORE,
        SDIFF,
        SDIFFSTORE,
        SRANDMEMBER,
        ZADD,
        ZRANGE,
        ZREM,
        ZINCRBY,
        ZRANK,
        ZREVRANK,
        ZREVRANGE,
        ZCARD,
        ZSCORE,
        MULTI,
        DISCARD,
        EXEC,
        WATCH,
        UNWATCH,
        SORT,
        BLPOP,
        BRPOP,
        AUTH,
        SUBSCRIBE,
        PUBLISH,
        UNSUBSCRIBE,
        PSUBSCRIBE,
        PUNSUBSCRIBE,
        PUBSUB,
        ZCOUNT,
        ZRANGEBYSCORE,
        ZREVRANGEBYSCORE,
        ZREMRANGEBYRANK,
        ZREMRANGEBYSCORE,
        ZUNIONSTORE,
        ZINTERSTORE,
        ZLEXCOUNT,
        ZRANGEBYLEX,
        ZREVRANGEBYLEX,
        ZREMRANGEBYLEX,
        SAVE,
        BGSAVE,
        BGREWRITEAOF,
        LASTSAVE,
        SHUTDOWN,
        INFO,
        MONITOR,
        SLAVEOF,
        CONFIG,
        STRLEN,
        SYNC,
        LPUSHX,
        PERSIST,
        RPUSHX,
        ECHO,
        LINSERT,
        DEBUG,
        BRPOPLPUSH,
        SETBIT,
        GETBIT,
        BITPOS,
        SETRANGE,
        GETRANGE,
        EVAL,
        EVALSHA,
        SCRIPT,
        SLOWLOG,
        OBJECT,
        BITCOUNT,
        BITOP,
        SENTINEL,
        DUMP,
        RESTORE,
        PEXPIRE,
        PEXPIREAT,
        PTTL,
        INCRBYFLOAT,
        PSETEX,
        CLIENT,
        TIME,
        MIGRATE,
        HINCRBYFLOAT,
        SCAN,
        HSCAN,
        SSCAN,
        ZSCAN,
        WAIT,
        CLUSTER,
        ASKING,
        PFADD,
        PFCOUNT,
        PFMERGE,
        READONLY,
        GEOADD,
        GEODIST,
        GEOHASH,
        GEOPOS,
        GEORADIUS,
        GEORADIUSBYMEMBER,
        MODULE,
        BITFIELD,
        HSTRLEN;
        
        private final byte[] raw;

        public byte[] getRaw() {
            return this.raw;
        }
    }
}
