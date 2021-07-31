package org.pc.start.bucket;

import org.pc.start.dta.LRU;

public class LRUBucket<K, V> {

    private LRU<V> data;

    private LRUBucket<K, V> next;

    private LRUBucket<K, V> prev;

    public LRUBucket () {
        data = new LRU<>();
    }

    public void setNext(LRUBucket next) {
        this.next = next;
    }

    public void setPrev(LRUBucket prev) {
        this.prev = prev;
    }
}
