package org.apache.commons.lang3.mutable;

public class MutableInt extends Number implements Comparable<MutableInt>, Mutable<Number> {
    private static final long serialVersionUID = 512176391864L;
    private int value;

    public void add(int i) {
        this.value += i;
    }

    public void decrement() {
        this.value--;
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
        this.value++;
    }

    public int intValue() {
        return this.value;
    }

    public long longValue() {
        return (long) this.value;
    }

    public void setValue(int i) {
        this.value = i;
    }

    public void subtract(int i) {
        this.value -= i;
    }

    public MutableInt() {
    }

    public MutableInt(int i) {
        this.value = i;
    }

    public MutableInt(Number number) {
        this.value = number.intValue();
    }

    public MutableInt(String str) throws NumberFormatException {
        this.value = Integer.parseInt(str);
    }

    public Integer getValue() {
        return new Integer(this.value);
    }

    public void setValue(Number number) {
        this.value = number.intValue();
    }

    public void add(Number number) {
        this.value += number.intValue();
    }

    public void subtract(Number number) {
        this.value -= number.intValue();
    }

    public Integer toInteger() {
        return Integer.valueOf(intValue());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MutableInt) || this.value != ((MutableInt) obj).intValue()) {
            return false;
        }
        return true;
    }

    public int compareTo(MutableInt mutableInt) {
        int i = mutableInt.value;
        int i2 = this.value;
        if (i2 < i) {
            return -1;
        }
        return i2 == i ? 0 : 1;
    }

    public String toString() {
        return String.valueOf(this.value);
    }
}
