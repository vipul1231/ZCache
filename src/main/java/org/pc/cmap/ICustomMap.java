package org.pc.cmap;

public interface ICustomMap<K,V> {

    void put(K key, V value);

    V get(K key);

    int index(K key);

    int hash(K key);

    boolean remove(K key);
}
