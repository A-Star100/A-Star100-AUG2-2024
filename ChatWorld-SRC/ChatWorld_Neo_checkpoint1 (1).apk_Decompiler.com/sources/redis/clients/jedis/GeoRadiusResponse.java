package redis.clients.jedis;

import redis.clients.util.SafeEncoder;

public class GeoRadiusResponse {
    private GeoCoordinate coordinate;
    private double distance;
    private byte[] member;

    public GeoRadiusResponse(byte[] member2) {
        this.member = member2;
    }

    public void setDistance(double distance2) {
        this.distance = distance2;
    }

    public void setCoordinate(GeoCoordinate coordinate2) {
        this.coordinate = coordinate2;
    }

    public byte[] getMember() {
        return this.member;
    }

    public String getMemberByString() {
        return SafeEncoder.encode(this.member);
    }

    public double getDistance() {
        return this.distance;
    }

    public GeoCoordinate getCoordinate() {
        return this.coordinate;
    }
}
