package org.pc.dta;


import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class LRU<V> {

    private final List<V> lruData;

    public LRU() {
        lruData = new ArrayList<>();
    }

    public List<V> getLruData() {
        return this.lruData;
    }
}
