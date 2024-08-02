package redis.clients.jedis;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocketFactory;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.exceptions.JedisConnectionException;
import redis.clients.jedis.exceptions.JedisException;

public class JedisSentinelPool extends JedisPoolAbstract {
    protected String clientName;
    protected int connectionTimeout;
    private volatile HostAndPort currentHostMaster;
    protected int database;
    private volatile JedisFactory factory;
    protected Logger log;
    protected Set<MasterListener> masterListeners;
    protected String password;
    protected GenericObjectPoolConfig poolConfig;
    protected int soTimeout;

    public JedisSentinelPool(String masterName, Set<String> sentinels, GenericObjectPoolConfig poolConfig2) {
        this(masterName, sentinels, poolConfig2, Protocol.DEFAULT_TIMEOUT, (String) null, 0);
    }

    public JedisSentinelPool(String masterName, Set<String> sentinels) {
        this(masterName, sentinels, new GenericObjectPoolConfig(), Protocol.DEFAULT_TIMEOUT, (String) null, 0);
    }

    public JedisSentinelPool(String masterName, Set<String> sentinels, String password2) {
        this(masterName, sentinels, new GenericObjectPoolConfig(), Protocol.DEFAULT_TIMEOUT, password2);
    }

    public JedisSentinelPool(String masterName, Set<String> sentinels, GenericObjectPoolConfig poolConfig2, int timeout, String password2) {
        this(masterName, sentinels, poolConfig2, timeout, password2, 0);
    }

    public JedisSentinelPool(String masterName, Set<String> sentinels, GenericObjectPoolConfig poolConfig2, int timeout) {
        this(masterName, sentinels, poolConfig2, timeout, (String) null, 0);
    }

    public JedisSentinelPool(String masterName, Set<String> sentinels, GenericObjectPoolConfig poolConfig2, String password2) {
        this(masterName, sentinels, poolConfig2, Protocol.DEFAULT_TIMEOUT, password2);
    }

    public JedisSentinelPool(String masterName, Set<String> sentinels, GenericObjectPoolConfig poolConfig2, int timeout, String password2, int database2) {
        this(masterName, sentinels, poolConfig2, timeout, timeout, password2, database2);
    }

    public JedisSentinelPool(String masterName, Set<String> sentinels, GenericObjectPoolConfig poolConfig2, int timeout, String password2, int database2, String clientName2) {
        this(masterName, sentinels, poolConfig2, timeout, timeout, password2, database2, clientName2);
    }

    public JedisSentinelPool(String masterName, Set<String> sentinels, GenericObjectPoolConfig poolConfig2, int timeout, int soTimeout2, String password2, int database2) {
        this(masterName, sentinels, poolConfig2, timeout, soTimeout2, password2, database2, (String) null);
    }

    public JedisSentinelPool(String masterName, Set<String> sentinels, GenericObjectPoolConfig poolConfig2, int connectionTimeout2, int soTimeout2, String password2, int database2, String clientName2) {
        this.connectionTimeout = Protocol.DEFAULT_TIMEOUT;
        this.soTimeout = Protocol.DEFAULT_TIMEOUT;
        this.database = 0;
        this.masterListeners = new HashSet();
        this.log = Logger.getLogger(getClass().getName());
        this.poolConfig = poolConfig2;
        this.connectionTimeout = connectionTimeout2;
        this.soTimeout = soTimeout2;
        this.password = password2;
        this.database = database2;
        this.clientName = clientName2;
        initPool(initSentinels(sentinels, masterName));
    }

    public void destroy() {
        for (MasterListener m : this.masterListeners) {
            m.shutdown();
        }
        super.destroy();
    }

    public HostAndPort getCurrentHostMaster() {
        return this.currentHostMaster;
    }

    /* access modifiers changed from: private */
    public void initPool(HostAndPort master) {
        if (!master.equals(this.currentHostMaster)) {
            this.currentHostMaster = master;
            if (this.factory == null) {
                this.factory = new JedisFactory(master.getHost(), master.getPort(), this.connectionTimeout, this.soTimeout, this.password, this.database, this.clientName, false, (SSLSocketFactory) null, (SSLParameters) null, (HostnameVerifier) null);
                initPool(this.poolConfig, this.factory);
            } else {
                this.factory.setHostAndPort(this.currentHostMaster);
                this.internalPool.clear();
            }
            this.log.info("Created JedisPool to master at " + master);
        }
    }

    private HostAndPort initSentinels(Set<String> sentinels, String masterName) {
        HostAndPort master;
        boolean sentinelAvailable;
        boolean sentinelAvailable2 = false;
        this.log.info("Trying to find master from available Sentinels...");
        Iterator<String> it = sentinels.iterator();
        while (true) {
            if (!it.hasNext()) {
                master = null;
                sentinelAvailable = sentinelAvailable2;
                break;
            }
            HostAndPort hap = HostAndPort.parseString(it.next());
            this.log.fine("Connecting to Sentinel " + hap);
            Jedis jedis = null;
            try {
                jedis = new Jedis(hap.getHost(), hap.getPort());
                List<String> masterAddr = jedis.sentinelGetMasterAddrByName(masterName);
                sentinelAvailable2 = true;
                if (masterAddr != null) {
                    if (masterAddr.size() == 2) {
                        HostAndPort master2 = toHostAndPort(masterAddr);
                        this.log.fine("Found Redis master at " + master2);
                        jedis.close();
                        master = master2;
                        sentinelAvailable = true;
                        break;
                    }
                }
                this.log.warning("Can not get master addr, master name: " + masterName + ". Sentinel: " + hap + ".");
                jedis.close();
            } catch (JedisException e) {
                this.log.warning("Cannot get master address from sentinel running @ " + hap + ". Reason: " + e + ". Trying next one.");
                if (jedis != null) {
                    jedis.close();
                }
            } catch (Throwable th) {
                if (jedis != null) {
                    jedis.close();
                }
                throw th;
            }
        }
        if (master != null) {
            this.log.info("Redis master running at " + master + ", starting Sentinel listeners...");
            for (String sentinel : sentinels) {
                HostAndPort hap2 = HostAndPort.parseString(sentinel);
                MasterListener masterListener = new MasterListener(masterName, hap2.getHost(), hap2.getPort());
                masterListener.setDaemon(true);
                this.masterListeners.add(masterListener);
                masterListener.start();
            }
            return master;
        } else if (sentinelAvailable) {
            throw new JedisException("Can connect to sentinel, but " + masterName + " seems to be not monitored...");
        } else {
            throw new JedisConnectionException("All sentinels down, cannot determine where is " + masterName + " master is running...");
        }
    }

    /* access modifiers changed from: private */
    public HostAndPort toHostAndPort(List<String> getMasterAddrByNameResult) {
        return new HostAndPort(getMasterAddrByNameResult.get(0), Integer.parseInt(getMasterAddrByNameResult.get(1)));
    }

    public Jedis getResource() {
        while (true) {
            Jedis jedis = (Jedis) super.getResource();
            jedis.setDataSource(this);
            if (this.currentHostMaster.equals(new HostAndPort(jedis.getClient().getHost(), jedis.getClient().getPort()))) {
                return jedis;
            }
            returnBrokenResource(jedis);
        }
    }

    /* access modifiers changed from: protected */
    public void returnBrokenResource(Jedis resource) {
        if (resource != null) {
            returnBrokenResourceObject(resource);
        }
    }

    /* access modifiers changed from: protected */
    public void returnResource(Jedis resource) {
        if (resource != null) {
            resource.resetState();
            returnResourceObject(resource);
        }
    }

    protected class MasterListener extends Thread {
        protected String host;
        protected volatile Jedis j;
        protected String masterName;
        protected int port;
        protected AtomicBoolean running;
        protected long subscribeRetryWaitTimeMillis;

        protected MasterListener() {
            this.subscribeRetryWaitTimeMillis = 5000;
            this.running = new AtomicBoolean(false);
        }

        public MasterListener(String masterName2, String host2, int port2) {
            super(String.format("MasterListener-%s-[%s:%d]", new Object[]{masterName2, host2, Integer.valueOf(port2)}));
            this.subscribeRetryWaitTimeMillis = 5000;
            this.running = new AtomicBoolean(false);
            this.masterName = masterName2;
            this.host = host2;
            this.port = port2;
        }

        public MasterListener(JedisSentinelPool jedisSentinelPool, String masterName2, String host2, int port2, long subscribeRetryWaitTimeMillis2) {
            this(masterName2, host2, port2);
            this.subscribeRetryWaitTimeMillis = subscribeRetryWaitTimeMillis2;
        }

        public void run() {
            this.running.set(true);
            while (this.running.get()) {
                this.j = new Jedis(this.host, this.port);
                try {
                    if (!this.running.get()) {
                        this.j.close();
                        return;
                    }
                    this.j.subscribe(new JedisPubSub() {
                        public void onMessage(String channel, String message) {
                            JedisSentinelPool.this.log.fine("Sentinel " + MasterListener.this.host + ":" + MasterListener.this.port + " published: " + message + ".");
                            String[] switchMasterMsg = message.split(" ");
                            if (switchMasterMsg.length <= 3) {
                                JedisSentinelPool.this.log.severe("Invalid message received on Sentinel " + MasterListener.this.host + ":" + MasterListener.this.port + " on channel +switch-master: " + message);
                            } else if (MasterListener.this.masterName.equals(switchMasterMsg[0])) {
                                JedisSentinelPool.this.initPool(JedisSentinelPool.this.toHostAndPort(Arrays.asList(new String[]{switchMasterMsg[3], switchMasterMsg[4]})));
                            } else {
                                JedisSentinelPool.this.log.fine("Ignoring message on +switch-master for master name " + switchMasterMsg[0] + ", our master name is " + MasterListener.this.masterName);
                            }
                        }
                    }, "+switch-master");
                    this.j.close();
                } catch (JedisConnectionException e) {
                    if (this.running.get()) {
                        JedisSentinelPool.this.log.log(Level.SEVERE, "Lost connection to Sentinel at " + this.host + ":" + this.port + ". Sleeping 5000ms and retrying.", e);
                        try {
                            Thread.sleep(this.subscribeRetryWaitTimeMillis);
                        } catch (InterruptedException e1) {
                            JedisSentinelPool.this.log.log(Level.SEVERE, "Sleep interrupted: ", e1);
                        }
                    } else {
                        JedisSentinelPool.this.log.fine("Unsubscribing from Sentinel at " + this.host + ":" + this.port);
                    }
                } catch (Throwable th) {
                    this.j.close();
                    throw th;
                }
            }
        }

        public void shutdown() {
            try {
                JedisSentinelPool.this.log.fine("Shutting down listener on " + this.host + ":" + this.port);
                this.running.set(false);
                if (this.j != null) {
                    this.j.disconnect();
                }
            } catch (Exception e) {
                JedisSentinelPool.this.log.log(Level.SEVERE, "Caught exception while shutting down: ", e);
            }
        }
    }
}
