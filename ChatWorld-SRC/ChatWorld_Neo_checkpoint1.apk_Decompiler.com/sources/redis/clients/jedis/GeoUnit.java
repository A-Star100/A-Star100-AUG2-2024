package redis.clients.jedis;

public enum GeoUnit {
    M,
    KM,
    MI,
    FT;
    
    public final byte[] raw;
}
