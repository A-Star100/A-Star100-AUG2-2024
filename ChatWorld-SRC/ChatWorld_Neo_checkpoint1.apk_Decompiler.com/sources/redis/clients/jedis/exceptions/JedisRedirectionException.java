package redis.clients.jedis.exceptions;

import redis.clients.jedis.HostAndPort;

public class JedisRedirectionException extends JedisDataException {
    private static final long serialVersionUID = 3878126572474819403L;
    private int slot;
    private HostAndPort targetNode;

    public JedisRedirectionException(String message, HostAndPort targetNode2, int slot2) {
        super(message);
        this.targetNode = targetNode2;
        this.slot = slot2;
    }

    public JedisRedirectionException(Throwable cause, HostAndPort targetNode2, int slot2) {
        super(cause);
        this.targetNode = targetNode2;
        this.slot = slot2;
    }

    public JedisRedirectionException(String message, Throwable cause, HostAndPort targetNode2, int slot2) {
        super(message, cause);
        this.targetNode = targetNode2;
        this.slot = slot2;
    }

    public HostAndPort getTargetNode() {
        return this.targetNode;
    }

    public int getSlot() {
        return this.slot;
    }
}
