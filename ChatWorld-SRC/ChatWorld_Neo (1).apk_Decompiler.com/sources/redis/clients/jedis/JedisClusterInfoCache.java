package redis.clients.jedis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocketFactory;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.exceptions.JedisConnectionException;
import redis.clients.jedis.exceptions.JedisException;
import redis.clients.util.SafeEncoder;

public class JedisClusterInfoCache {
    private static final int MASTER_NODE_INDEX = 2;
    private String clientName;
    private int connectionTimeout;
    private final Map<String, JedisPool> nodes;
    private String password;
    private final GenericObjectPoolConfig poolConfig;
    private final Lock r;
    private volatile boolean rediscovering;
    private final ReentrantReadWriteLock rwl;
    private final Map<Integer, JedisPool> slots;
    private int soTimeout;
    private final Lock w;

    public JedisClusterInfoCache(GenericObjectPoolConfig poolConfig2, int timeout) {
        this(poolConfig2, timeout, timeout, (String) null, (String) null);
    }

    public JedisClusterInfoCache(GenericObjectPoolConfig poolConfig2, int connectionTimeout2, int soTimeout2, String password2, String clientName2) {
        this.nodes = new HashMap();
        this.slots = new HashMap();
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.rwl = reentrantReadWriteLock;
        this.r = reentrantReadWriteLock.readLock();
        this.w = reentrantReadWriteLock.writeLock();
        this.poolConfig = poolConfig2;
        this.connectionTimeout = connectionTimeout2;
        this.soTimeout = soTimeout2;
        this.password = password2;
        this.clientName = clientName2;
    }

    public void discoverClusterNodesAndSlots(Jedis jedis) {
        this.w.lock();
        try {
            reset();
            Iterator<Object> it = jedis.clusterSlots().iterator();
            while (it.hasNext()) {
                List<Object> slotInfo = (List) it.next();
                if (slotInfo.size() > 2) {
                    List<Integer> slotNums = getAssignedSlotArray(slotInfo);
                    int size = slotInfo.size();
                    for (int i = 2; i < size; i++) {
                        List<Object> hostInfos = (List) slotInfo.get(i);
                        if (hostInfos.size() > 0) {
                            HostAndPort targetNode = generateHostAndPort(hostInfos);
                            setupNodeIfNotExist(targetNode);
                            if (i == 2) {
                                assignSlotsToNode(slotNums, targetNode);
                            }
                        }
                    }
                }
            }
        } finally {
            this.w.unlock();
        }
    }

    public void renewClusterSlots(Jedis jedis) {
        if (!this.rediscovering) {
            try {
                this.w.lock();
                this.rediscovering = true;
                if (jedis != null) {
                    try {
                        discoverClusterSlots(jedis);
                        this.rediscovering = false;
                        this.w.unlock();
                        return;
                    } catch (JedisException e) {
                    }
                }
                for (JedisPool jp : getShuffledNodesPool()) {
                    jedis = jp.getResource();
                    discoverClusterSlots(jedis);
                    if (jedis != null) {
                        jedis.close();
                    }
                    this.rediscovering = false;
                    this.w.unlock();
                    return;
                }
                this.rediscovering = false;
                this.w.unlock();
            } catch (JedisConnectionException e2) {
                if (jedis != null) {
                    jedis.close();
                }
            } catch (Throwable th) {
                this.rediscovering = false;
                this.w.unlock();
                throw th;
            }
        }
    }

    private void discoverClusterSlots(Jedis jedis) {
        List<Object> slots2 = jedis.clusterSlots();
        this.slots.clear();
        Iterator<Object> it = slots2.iterator();
        while (it.hasNext()) {
            List<Object> slotInfo = (List) it.next();
            if (slotInfo.size() > 2) {
                List<Integer> slotNums = getAssignedSlotArray(slotInfo);
                List<Object> hostInfos = (List) slotInfo.get(2);
                if (!hostInfos.isEmpty()) {
                    assignSlotsToNode(slotNums, generateHostAndPort(hostInfos));
                }
            }
        }
    }

    private HostAndPort generateHostAndPort(List<Object> hostInfos) {
        return new HostAndPort(SafeEncoder.encode((byte[]) hostInfos.get(0)), ((Long) hostInfos.get(1)).intValue());
    }

    public JedisPool setupNodeIfNotExist(HostAndPort node) {
        this.w.lock();
        try {
            String nodeKey = getNodeKey(node);
            JedisPool existingPool = this.nodes.get(nodeKey);
            if (existingPool != null) {
                return existingPool;
            }
            JedisPool jedisPool = new JedisPool(this.poolConfig, node.getHost(), node.getPort(), this.connectionTimeout, this.soTimeout, this.password, 0, this.clientName, false, (SSLSocketFactory) null, (SSLParameters) null, (HostnameVerifier) null);
            this.nodes.put(nodeKey, jedisPool);
            this.w.unlock();
            return jedisPool;
        } finally {
            this.w.unlock();
        }
    }

    public JedisPool setupNodeIfNotExist(HostAndPort node, boolean ssl) {
        this.w.lock();
        try {
            String nodeKey = getNodeKey(node);
            JedisPool existingPool = this.nodes.get(nodeKey);
            if (existingPool != null) {
                return existingPool;
            }
            JedisPool jedisPool = new JedisPool(this.poolConfig, node.getHost(), node.getPort(), this.connectionTimeout, this.soTimeout, this.password, 0, (String) null, ssl, (SSLSocketFactory) null, (SSLParameters) null, (HostnameVerifier) null);
            this.nodes.put(nodeKey, jedisPool);
            this.w.unlock();
            return jedisPool;
        } finally {
            this.w.unlock();
        }
    }

    public JedisPool setupNodeIfNotExist(HostAndPort node, boolean ssl, SSLSocketFactory sslSocketFactory, SSLParameters sslParameters, HostnameVerifier hostnameVerifier) {
        this.w.lock();
        try {
            String nodeKey = getNodeKey(node);
            JedisPool existingPool = this.nodes.get(nodeKey);
            if (existingPool != null) {
                return existingPool;
            }
            JedisPool jedisPool = new JedisPool(this.poolConfig, node.getHost(), node.getPort(), this.connectionTimeout, this.soTimeout, this.password, 0, (String) null, ssl, sslSocketFactory, sslParameters, hostnameVerifier);
            this.nodes.put(nodeKey, jedisPool);
            this.w.unlock();
            return jedisPool;
        } finally {
            this.w.unlock();
        }
    }

    public void assignSlotToNode(int slot, HostAndPort targetNode) {
        this.w.lock();
        try {
            this.slots.put(Integer.valueOf(slot), setupNodeIfNotExist(targetNode));
        } finally {
            this.w.unlock();
        }
    }

    public void assignSlotsToNode(List<Integer> targetSlots, HostAndPort targetNode) {
        this.w.lock();
        try {
            JedisPool targetPool = setupNodeIfNotExist(targetNode);
            for (Integer slot : targetSlots) {
                this.slots.put(slot, targetPool);
            }
        } finally {
            this.w.unlock();
        }
    }

    public JedisPool getNode(String nodeKey) {
        this.r.lock();
        try {
            return this.nodes.get(nodeKey);
        } finally {
            this.r.unlock();
        }
    }

    public JedisPool getSlotPool(int slot) {
        this.r.lock();
        try {
            return this.slots.get(Integer.valueOf(slot));
        } finally {
            this.r.unlock();
        }
    }

    public Map<String, JedisPool> getNodes() {
        this.r.lock();
        try {
            return new HashMap(this.nodes);
        } finally {
            this.r.unlock();
        }
    }

    public List<JedisPool> getShuffledNodesPool() {
        this.r.lock();
        try {
            List<JedisPool> pools = new ArrayList<>(this.nodes.values());
            Collections.shuffle(pools);
            return pools;
        } finally {
            this.r.unlock();
        }
    }

    public void reset() {
        this.w.lock();
        try {
            for (JedisPool pool : this.nodes.values()) {
                if (pool != null) {
                    try {
                        pool.destroy();
                    } catch (Exception e) {
                    }
                }
            }
            this.nodes.clear();
            this.slots.clear();
        } finally {
            this.w.unlock();
        }
    }

    public static String getNodeKey(HostAndPort hnp) {
        return String.valueOf(hnp.getHost()) + ":" + hnp.getPort();
    }

    public static String getNodeKey(Client client) {
        return String.valueOf(client.getHost()) + ":" + client.getPort();
    }

    public static String getNodeKey(Jedis jedis) {
        return getNodeKey(jedis.getClient());
    }

    private List<Integer> getAssignedSlotArray(List<Object> slotInfo) {
        List<Integer> slotNums = new ArrayList<>();
        for (int slot = ((Long) slotInfo.get(0)).intValue(); slot <= ((Long) slotInfo.get(1)).intValue(); slot++) {
            slotNums.add(Integer.valueOf(slot));
        }
        return slotNums;
    }
}
