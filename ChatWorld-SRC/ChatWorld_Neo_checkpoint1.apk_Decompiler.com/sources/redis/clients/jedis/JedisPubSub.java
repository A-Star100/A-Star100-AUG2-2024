package redis.clients.jedis;

import java.util.Arrays;
import java.util.List;
import redis.clients.jedis.Protocol;
import redis.clients.jedis.exceptions.JedisConnectionException;
import redis.clients.jedis.exceptions.JedisException;
import redis.clients.util.SafeEncoder;

public abstract class JedisPubSub {
    private static final String JEDIS_SUBSCRIPTION_MESSAGE = "JedisPubSub is not subscribed to a Jedis instance.";
    private volatile Client client;
    private int subscribedChannels = 0;

    public void onMessage(String channel, String message) {
    }

    public void onPMessage(String pattern, String channel, String message) {
    }

    public void onSubscribe(String channel, int subscribedChannels2) {
    }

    public void onUnsubscribe(String channel, int subscribedChannels2) {
    }

    public void onPUnsubscribe(String pattern, int subscribedChannels2) {
    }

    public void onPSubscribe(String pattern, int subscribedChannels2) {
    }

    public void onPong(String pattern) {
    }

    public void unsubscribe() {
        if (this.client != null) {
            this.client.unsubscribe();
            this.client.flush();
            return;
        }
        throw new JedisConnectionException(JEDIS_SUBSCRIPTION_MESSAGE);
    }

    public void unsubscribe(String... channels) {
        if (this.client != null) {
            this.client.unsubscribe(channels);
            this.client.flush();
            return;
        }
        throw new JedisConnectionException(JEDIS_SUBSCRIPTION_MESSAGE);
    }

    public void subscribe(String... channels) {
        if (this.client != null) {
            this.client.subscribe(channels);
            this.client.flush();
            return;
        }
        throw new JedisConnectionException(JEDIS_SUBSCRIPTION_MESSAGE);
    }

    public void psubscribe(String... patterns) {
        if (this.client != null) {
            this.client.psubscribe(patterns);
            this.client.flush();
            return;
        }
        throw new JedisConnectionException(JEDIS_SUBSCRIPTION_MESSAGE);
    }

    public void punsubscribe() {
        if (this.client != null) {
            this.client.punsubscribe();
            this.client.flush();
            return;
        }
        throw new JedisConnectionException(JEDIS_SUBSCRIPTION_MESSAGE);
    }

    public void punsubscribe(String... patterns) {
        if (this.client != null) {
            this.client.punsubscribe(patterns);
            this.client.flush();
            return;
        }
        throw new JedisConnectionException(JEDIS_SUBSCRIPTION_MESSAGE);
    }

    public void ping() {
        if (this.client != null) {
            this.client.ping();
            this.client.flush();
            return;
        }
        throw new JedisConnectionException(JEDIS_SUBSCRIPTION_MESSAGE);
    }

    public boolean isSubscribed() {
        return this.subscribedChannels > 0;
    }

    public void proceedWithPatterns(Client client2, String... patterns) {
        this.client = client2;
        client2.psubscribe(patterns);
        client2.flush();
        process(client2);
    }

    public void proceed(Client client2, String... channels) {
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
                    byte[] bchannel = (byte[]) reply.get(1);
                    onSubscribe(bchannel == null ? null : SafeEncoder.encode(bchannel), this.subscribedChannels);
                } else if (Arrays.equals(Protocol.Keyword.UNSUBSCRIBE.raw, resp)) {
                    this.subscribedChannels = ((Long) reply.get(2)).intValue();
                    byte[] bchannel2 = (byte[]) reply.get(1);
                    onUnsubscribe(bchannel2 == null ? null : SafeEncoder.encode(bchannel2), this.subscribedChannels);
                } else if (Arrays.equals(Protocol.Keyword.MESSAGE.raw, resp)) {
                    byte[] bchannel3 = (byte[]) reply.get(1);
                    byte[] bmesg = (byte[]) reply.get(2);
                    onMessage(bchannel3 == null ? null : SafeEncoder.encode(bchannel3), bmesg == null ? null : SafeEncoder.encode(bmesg));
                } else if (Arrays.equals(Protocol.Keyword.PMESSAGE.raw, resp)) {
                    byte[] bpattern = (byte[]) reply.get(1);
                    byte[] bchannel4 = (byte[]) reply.get(2);
                    byte[] bmesg2 = (byte[]) reply.get(3);
                    onPMessage(bpattern == null ? null : SafeEncoder.encode(bpattern), bchannel4 == null ? null : SafeEncoder.encode(bchannel4), bmesg2 == null ? null : SafeEncoder.encode(bmesg2));
                } else if (Arrays.equals(Protocol.Keyword.PSUBSCRIBE.raw, resp)) {
                    this.subscribedChannels = ((Long) reply.get(2)).intValue();
                    byte[] bpattern2 = (byte[]) reply.get(1);
                    onPSubscribe(bpattern2 == null ? null : SafeEncoder.encode(bpattern2), this.subscribedChannels);
                } else if (Arrays.equals(Protocol.Keyword.PUNSUBSCRIBE.raw, resp)) {
                    this.subscribedChannels = ((Long) reply.get(2)).intValue();
                    byte[] bpattern3 = (byte[]) reply.get(1);
                    onPUnsubscribe(bpattern3 == null ? null : SafeEncoder.encode(bpattern3), this.subscribedChannels);
                } else if (Arrays.equals(Protocol.Keyword.PONG.raw, resp)) {
                    byte[] bpattern4 = (byte[]) reply.get(1);
                    onPong(bpattern4 == null ? null : SafeEncoder.encode(bpattern4));
                } else {
                    throw new JedisException("Unknown message type: " + firstObj);
                }
            } else {
                throw new JedisException("Unknown message type: " + firstObj);
            }
        } while (isSubscribed());
        this.client = null;
    }

    public int getSubscribedChannels() {
        return this.subscribedChannels;
    }
}
