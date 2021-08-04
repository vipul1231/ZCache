package org.pc.cmap;

/**
 * Custom map implementation
 */
public class CustomHashMap<K, V> implements ICustomMap<K,V>{

    /**
     *  Entries array.
     */
    private Entry<Object, Object>[] entries;

    /**
     *  Initial capacities.
     */
    private final int initialCapacities;

    /**
     * Custom hash map
     */
    public CustomHashMap() {
        initialCapacities = 16;
        entries = new Entry[initialCapacities];
    }

    /**
     *  Custom hash map
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
    public void put(Object key, Object value) {
        int index  = index(key);
        Entry<Object,Object> entry = new Entry<>(key, value, null);
        if (entries[index] == null) {
            entries[index] = entry;
        }
        else {
            Entry<Object, Object> entry1 = entries[index];
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
    public Object get(Object key) {
        int index = index(key);
        if(entries[index] != null) {
            Entry<Object, Object> entry = entries[index];
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
    public int index(Object key) {
        int hash = hash(key);
        return hash & (initialCapacities-1);
    }

    /**
     *
     * @param key
     * @return
     */
    public int hash(Object key){
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    @Override
    public boolean remove(Object key) {
        int index = index(key);
        Entry<Object, Object> entry = entries[index];

        if (entry != null) {
            Entry<Object, Object> previous = null;
            while (entry != null) {
                if (entry.getKey().equals(key)) {

                    if (previous != null) {
                        previous.setNext(entry.getNext());

                        return true;
                    } else {
                        entries[index] = null;
                        return true;
                    }
                }
                previous = entry;
                entry = entry.getNext();
            }
        }

        return false;
    }
}
