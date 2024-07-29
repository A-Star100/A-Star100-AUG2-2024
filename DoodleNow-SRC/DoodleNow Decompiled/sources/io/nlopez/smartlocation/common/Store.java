package io.nlopez.smartlocation.common;

public interface Store<T> {
    T get(String str);

    void put(String str, T t);

    void remove(String str);
}
