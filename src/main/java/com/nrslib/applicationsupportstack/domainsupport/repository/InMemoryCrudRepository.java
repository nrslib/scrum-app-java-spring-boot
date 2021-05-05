package com.nrslib.applicationsupportstack.domainsupport.repository;

import java.util.HashMap;
import java.util.Optional;

public abstract class InMemoryCrudRepository<K, V> {
    public HashMap<K, V> keyToValue = new HashMap<>();

    public void save(V value) {
        var key = getKey(value);
        var cloned = deepClone(value);
        keyToValue.put(key, cloned);
    }

    public Optional<V> find(K key) {
        if (!keyToValue.containsKey(key)) {
            return Optional.empty();
        }

        var target = keyToValue.get(key);
        var cloned = deepClone(target);

        return Optional.of(cloned);
    }

    public void delete(V value) {
        var key = getKey(value);
        keyToValue.remove(key);
    }

    protected abstract K getKey(V value);

    protected abstract V deepClone(V value);
}
