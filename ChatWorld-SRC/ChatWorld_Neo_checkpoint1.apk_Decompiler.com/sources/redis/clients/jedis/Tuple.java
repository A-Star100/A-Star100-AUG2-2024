package redis.clients.jedis;

import java.util.Arrays;
import redis.clients.util.SafeEncoder;

public class Tuple implements Comparable<Tuple> {
    private byte[] element;
    private Double score;

    public Tuple(String element2, Double score2) {
        this.element = SafeEncoder.encode(element2);
        this.score = score2;
    }

    public Tuple(byte[] element2, Double score2) {
        this.element = element2;
        this.score = score2;
    }

    public int hashCode() {
        int result = 1 * 31;
        byte[] bArr = this.element;
        if (bArr != null) {
            for (byte b : bArr) {
                result = (result * 31) + b;
            }
        }
        long temp = Double.doubleToLongBits(this.score.doubleValue());
        return (result * 31) + ((int) ((temp >>> 32) ^ temp));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Tuple other = (Tuple) obj;
        byte[] bArr = this.element;
        if (bArr == null) {
            if (other.element != null) {
                return false;
            }
        } else if (!Arrays.equals(bArr, other.element)) {
            return false;
        }
        return true;
    }

    public int compareTo(Tuple other) {
        if (this.score.doubleValue() == other.getScore() || Arrays.equals(this.element, other.element)) {
            return 0;
        }
        return this.score.doubleValue() < other.getScore() ? -1 : 1;
    }

    public String getElement() {
        byte[] bArr = this.element;
        if (bArr != null) {
            return SafeEncoder.encode(bArr);
        }
        return null;
    }

    public byte[] getBinaryElement() {
        return this.element;
    }

    public double getScore() {
        return this.score.doubleValue();
    }

    public String toString() {
        return String.valueOf('[') + Arrays.toString(this.element) + ',' + this.score + ']';
    }
}
