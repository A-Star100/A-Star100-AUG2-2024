package redis.clients.jedis;

import java.util.Arrays;
import java.util.List;
import redis.clients.jedis.Protocol;
import redis.clients.jedis.exceptions.JedisException;

public abstract class BinaryJedisPubSub {
    private Client client;
    private int subscribedChannels = 0;

    public void onMessage(byte[] channel, byte[] message) {
    }

    public void onPMessage(byte[] pattern, byte[] channel, byte[] message) {
    }

    public void onSubscribe(byte[] channel, int subscribedChannels2) {
    }

    public void onUnsubscribe(byte[] channel, int subscribedChannels2) {
    }

    public void onPUnsubscribe(byte[] pattern, int subscribedChannels2) {
    }

    public void onPSubscribe(byte[] pattern, int subscribedChannels2) {
    }

    public void unsubscribe() {
        this.client.unsubscribe();
        this.client.flush();
    }

    public void unsubscribe(byte[]... channels) {
        this.client.unsubscribe(channels);
        this.client.flush();
    }

    public void subscribe(byte[]... channels) {
        this.client.subscribe(channels);
        this.client.flush();
    }

    public void psubscribe(byte[]... patterns) {
        this.client.psubscribe(patterns);
        this.client.flush();
    }

    public void punsubscribe() {
        this.client.punsubscribe();
        this.client.flush();
    }

    public void punsubscribe(byte[]... patterns) {
        this.client.punsubscribe(patterns);
        this.client.flush();
    }

    public boolean isSubscribed() {
        return this.subscribedChannels > 0;
    }

    public void proceedWithPatterns(Client client2, byte[]... patterns) {
        this.client = client2;
        client2.psubscribe(patterns);
        client2.flush();
        process(client2);
    }

    public void proceed(Client client2, byte[]... channels) {
        this.client = client2;
        client2.subscribe(channels);
        client2.flush();
        process(client2);
    }

    private void process(Client client2) {
        do {
            List<Object> reply = client2.getRawObjectMultiBulkReply();
            Object firstObj = reply.get(0);
            if (firstObj instanceof byte[]) {
                byte[] resp = (byte[]) firstObj;
                if (Arrays.equals(Protocol.Keyword.SUBSCRIBE.raw, resp)) {
                    this.subscribedChannels = ((Long) reply.get(2)).intValue();
                    onSubscribe((byte[]) reply.get(1), this.subscribedChannels);
                } else if (Arrays.equals(Protocol.Keyword.UNSUBSCRIBE.raw, resp)) {
                    this.subscribedChannels = ((Long) reply.get(2)).intValue();
                    onUnsubscribe((byte[]) reply.get(1), this.subscribedChannels);
                } else if (Arrays.equals(Protocol.Keyword.MESSAGE.raw, resp)) {
                    onMessage((byte[]) reply.get(1), (byte[]) reply.get(2));
                } else if (Arrays.equals(Protocol.Keyword.PMESSAGE.raw, resp)) {
                    onPMessage((byte[]) reply.get(1), (byte[]) reply.get(2), (byte[]) reply.get(3));
                } else if (Arrays.equals(Protocol.Keyword.PSUBSCRIBE.raw, resp)) {
                    this.subscribedChannels = ((Long) reply.get(2)).intValue();
                    onPSubscribe((byte[]) reply.get(1), this.subscribedChannels);
                } else if (Arrays.equals(Protocol.Keyword.PUNSUBSCRIBE.raw, resp)) {
                    this.subscribedChannels = ((Long) reply.get(2)).intValue();
                    onPUnsubscribe((byte[]) reply.get(1), this.subscribedChannels);
                } else {
                    throw new JedisException("Unknown message type: " + firstObj);
                }
            } else {
                throw new JedisException("Unknown message type: " + firstObj);
            }
        } while (isSubscribed());
    }

    public int getSubscribedChannels() {
        return this.subscribedChannels;
    }
}
