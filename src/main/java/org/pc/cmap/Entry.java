package org.pc.cmap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Entry<K,V> {

    private final K key;

    private V value;

    private Entry<K,V> next;
}
