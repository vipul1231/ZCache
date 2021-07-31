package org.pc.cmap;

/**
 * Custom map implementation
 */
public class CustomHashMap<K, V> {

    private Entry<K, V>[] entries;

    private int initialCapacities;

    public CustomHashMap(int capacities) {
        entries = new Entry[capacities];
    }

    public void put(K key, V value) {
        int index  = hash(key);
        System.out.printf("Index: "+index);
    }

    public void get(K key) {

    }

    public int hash(K key){
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
