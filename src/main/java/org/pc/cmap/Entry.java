package org.pc.cmap;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public class Entry<K,V> {

    private final K key;

    private final V value;

    private Entry<K,V> next;
}
