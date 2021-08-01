package org.pc.cmap;

/**
 * Custom map implementation
 */
public class CustomHashMap<K, V> {

    /**
     *
     */
    private Entry<K, V>[] entries;

    /**
     *
     */
    private final int initialCapacities;

    /**
     *
     */
    public CustomHashMap() {
        initialCapacities = 16;
        entries = new Entry[initialCapacities];
    }

    /**
     *  Custom
     *
     * @param capacities
     */
    public CustomHashMap(int capacities) {
        this.initialCapacities = capacities;
        entries = new Entry[capacities];
    }

    /**
     * Put value in custom map.
     *
     * @param key   key
     * @param value value
     */
    public void put(K key, V value) {
        int index  = index(key);
        Entry<K,V> entry = new Entry<>(key, value, null);
        if (entries[index] == null) {
            entries[index] = entry;
        }
        else {
            Entry<K, V> entry1 = entries[index];
            while (entry1 != null) {
                if (entry1.getKey().equals(key)) {
                    entry1.setValue(value);
                    break;
                }
                else if (entry1.getNext() == null ) {
                    entry1.setNext(entry);
                    break;
                }
                entry1 = entry1.getNext();
            }
        }
    }

    /**
     *  Get value from custom map.
     *
     * @param key   key
     */
    public V get(K key) {
        int index = index(key);
        if(entries[index] != null) {
            Entry<K, V> entry = entries[index];
            while (entry != null) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
                entry = entry.getNext();
            }
        }
        return null;
    }

    /**
     *  Return index from key.
     *
     * @param key   Key
     * @return  index of array entry.
     */
    public int index(K key) {
        int hash = hash(key);
        return hash & (initialCapacities-1);
    }

    /**
     *
     * @param key
     * @return
     */
    public int hash(K key){
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
