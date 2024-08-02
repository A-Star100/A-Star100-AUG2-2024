package redis.clients.jedis;

public abstract class JedisMonitor {
    protected Client client;

    public abstract void onCommand(String str);

    public void proceed(Client client2) {
        this.client = client2;
        client2.setTimeoutInfinite();
        do {
            onCommand(client2.getBulkReply());
        } while (client2.isConnected());
    }
}
