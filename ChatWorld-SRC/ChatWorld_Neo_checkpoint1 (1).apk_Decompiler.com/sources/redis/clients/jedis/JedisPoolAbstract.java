package redis.clients.jedis;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.util.Pool;

public class JedisPoolAbstract extends Pool<Jedis> {
    public JedisPoolAbstract() {
    }

    public JedisPoolAbstract(GenericObjectPoolConfig poolConfig, PooledObjectFactory<Jedis> factory) {
        super(poolConfig, factory);
    }

    /* access modifiers changed from: protected */
    public void returnBrokenResource(Jedis resource) {
        super.returnBrokenResource(resource);
    }

    /* access modifiers changed from: protected */
    public void returnResource(Jedis resource) {
        super.returnResource(resource);
    }
}
