package ru.kpfu.itis.j903.cw.minsafin.inf_6;

import ru.kpfu.itis.j903.cw.minsafin.inf_6.setformap.FromArrayListSet;

import java.util.AbstractMap;
import java.util.Set;

public class MyMap<K, V> extends AbstractMap<K, V> {
    protected Set<Entry<K, V>> entrySet;

    public MyMap() {
        entrySet = new FromArrayListSet<>();
    }

    @Override
    public V put(K key, V value) {
        if (keySet().contains(key)){
            Entry<K, V> newEntry = new SimpleEntry<>(key, value);
            V old = remove(key);
            entrySet().add(newEntry);
            return old;
        }else {
            Entry<K, V> newEntry = new SimpleEntry<>(key, value);
            entrySet().add(newEntry);
            return null;
        }
    }

    public MyMap(Set<Entry<K, V>> entrySet) {
        this.entrySet = entrySet;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return entrySet;
    }
}
