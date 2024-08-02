package redis.clients.jedis;

public class GeoCoordinate {
    private double latitude;
    private double longitude;

    public GeoCoordinate(double longitude2, double latitude2) {
        this.longitude = longitude2;
        this.latitude = latitude2;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GeoCoordinate)) {
            return false;
        }
        GeoCoordinate that = (GeoCoordinate) o;
        if (Double.compare(that.longitude, this.longitude) == 0 && Double.compare(that.latitude, this.latitude) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long temp = Double.doubleToLongBits(this.longitude);
        long temp2 = Double.doubleToLongBits(this.latitude);
        return (((int) ((temp >>> 32) ^ temp)) * 31) + ((int) ((temp2 >>> 32) ^ temp2));
    }

    public String toString() {
        return "(" + this.longitude + "," + this.latitude + ")";
    }
}
