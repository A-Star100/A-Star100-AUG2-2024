package org.apache.commons.lang3.mutable;

public class MutableShort extends Number implements Comparable<MutableShort>, Mutable<Number> {
    private static final long serialVersionUID = -2135791679;
    private short value;

    public void add(short s) {
        this.value = (short) (this.value + s);
    }

    public void decrement() {
        this.value = (short) (this.value - 1);
    }

    public double doubleValue() {
        return (double) this.value;
    }

    public float floatValue() {
        return (float) this.value;
    }

    public int hashCode() {
        return this.value;
    }

    public void increment() {
        this.value = (short) (this.value + 1);
    }

    public int intValue() {
        return this.value;
    }

    public long longValue() {
        return (long) this.value;
    }

    public void setValue(short s) {
        this.value = s;
    }

    public short shortValue() {
        return this.value;
    }

    public void subtract(short s) {
        this.value = (short) (this.value - s);
    }

    public MutableShort() {
    }

    public MutableShort(short s) {
        this.value = s;
    }

    public MutableShort(Number number) {
        this.value = number.shortValue();
    }

    public MutableShort(String str) throws NumberFormatException {
        this.value = Short.parseShort(str);
    }

    public Short getValue() {
        return new Short(this.value);
    }

    public void setValue(Number number) {
        this.value = number.shortValue();
    }

    public void add(Number number) {
        this.value = (short) (this.value + number.shortValue());
    }

    public void subtract(Number number) {
        this.value = (short) (this.value - number.shortValue());
    }

    public Short toShort() {
        return Short.valueOf(shortValue());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MutableShort) || this.value != ((MutableShort) obj).shortValue()) {
            return false;
        }
        return true;
    }

    public int compareTo(MutableShort mutableShort) {
        short s = mutableShort.value;
        short s2 = this.value;
        if (s2 < s) {
            return -1;
        }
        return s2 == s ? 0 : 1;
    }

    public String toString() {
        return String.valueOf(this.value);
    }
}
