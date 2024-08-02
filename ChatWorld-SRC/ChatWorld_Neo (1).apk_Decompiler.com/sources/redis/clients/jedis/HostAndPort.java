package redis.clients.jedis;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HostAndPort implements Serializable {
    public static final String LOCALHOST_STR = getLocalHostQuietly();
    protected static Logger log = Logger.getLogger(HostAndPort.class.getName());
    private static final long serialVersionUID = -519876229978427751L;
    private String host;
    private int port;

    public HostAndPort(String host2, int port2) {
        this.host = host2;
        this.port = port2;
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        return this.port;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof HostAndPort)) {
            return false;
        }
        HostAndPort hp = (HostAndPort) obj;
        String thisHost = convertHost(this.host);
        String hpHost = convertHost(hp.host);
        if (this.port != hp.port || !thisHost.equals(hpHost)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (convertHost(this.host).hashCode() * 31) + this.port;
    }

    public String toString() {
        return String.valueOf(this.host) + ":" + this.port;
    }

    public static String[] extractParts(String from) {
        int idx = from.lastIndexOf(":");
        return new String[]{idx != -1 ? from.substring(0, idx) : from, idx != -1 ? from.substring(idx + 1) : ""};
    }

    public static HostAndPort parseString(String from) {
        try {
            String[] parts = extractParts(from);
            String host2 = parts[0];
            return new HostAndPort(convertHost(host2), Integer.valueOf(parts[1]).intValue());
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    public static String convertHost(String host2) {
        if (host2.equals("127.0.0.1") || host2.startsWith(Protocol.DEFAULT_HOST) || host2.equals("0.0.0.0") || host2.startsWith("169.254") || host2.startsWith("::1") || host2.startsWith("0:0:0:0:0:0:0:1")) {
            return LOCALHOST_STR;
        }
        return host2;
    }

    public static String getLocalHostQuietly() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            log.logp(Level.SEVERE, HostAndPort.class.getName(), "getLocalHostQuietly", "cant resolve localhost address", e);
            return Protocol.DEFAULT_HOST;
        }
    }
}
