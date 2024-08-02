package redis.clients.jedis;

import java.util.List;
import java.util.regex.Pattern;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.util.Hashing;
import redis.clients.util.Pool;

public class ShardedJedisPool extends Pool<ShardedJedis> {
    public ShardedJedisPool(GenericObjectPoolConfig poolConfig, List<JedisShardInfo> shards) {
        this(poolConfig, shards, Hashing.MURMUR_HASH);
    }

    public ShardedJedisPool(GenericObjectPoolConfig poolConfig, List<JedisShardInfo> shards, Hashing algo) {
        this(poolConfig, shards, algo, (Pattern) null);
    }

    public ShardedJedisPool(GenericObjectPoolConfig poolConfig, List<JedisShardInfo> shards, Pattern keyTagPattern) {
        this(poolConfig, shards, Hashing.MURMUR_HASH, keyTagPattern);
    }

    public ShardedJedisPool(GenericObjectPoolConfig poolConfig, List<JedisShardInfo> shards, Hashing algo, Pattern keyTagPattern) {
        super(poolConfig, new ShardedJedisFactory(shards, algo, keyTagPattern));
    }

    public ShardedJedis getResource() {
        ShardedJedis jedis = (ShardedJedis) super.getResource();
        jedis.setDataSource(this);
        return jedis;
    }

    /* access modifiers changed from: protected */
    public void returnBrokenResource(ShardedJedis resource) {
        if (resource != null) {
            returnBrokenResourceObject(resource);
        }
    }

    /* access modifiers changed from: protected */
    public void returnResource(ShardedJedis resource) {
        if (resource != null) {
            resource.resetState();
            returnResourceObject(resource);
        }
    }

    private static class ShardedJedisFactory implements PooledObjectFactory<ShardedJedis> {
        private Hashing algo;
        private Pattern keyTagPattern;
        private List<JedisShardInfo> shards;

        public ShardedJedisFactory(List<JedisShardInfo> shards2, Hashing algo2, Pattern keyTagPattern2) {
            this.shards = shards2;
            this.algo = algo2;
            this.keyTagPattern = keyTagPattern2;
        }

        public PooledObject<ShardedJedis> makeObject() throws Exception {
            return new DefaultPooledObject(new ShardedJedis(this.shards, this.algo, this.keyTagPattern));
        }

        public void destroyObject(PooledObject<ShardedJedis> pooledShardedJedis) throws Exception {
            for (Jedis jedis : pooledShardedJedis.getObject().getAllShards()) {
                try {
                    jedis.quit();
                } catch (Exception e) {
                }
                try {
                    jedis.disconnect();
                } catch (Exception e2) {
                }
            }
        }

        public boolean validateObject(PooledObject<ShardedJedis> pooledShardedJedis) {
            try {
                for (Jedis shard : pooledShardedJedis.getObject().getAllShards()) {
                    if (!shard.ping().equals("PONG")) {
                        return false;
                    }
                }
                return true;
            } catch (Exception e) {
                return false;
            }
        }

        public void activateObject(PooledObject<ShardedJedis> pooledObject) throws Exception {
        }

        public void passivateObject(PooledObject<ShardedJedis> pooledObject) throws Exception {
        }
    }
}
