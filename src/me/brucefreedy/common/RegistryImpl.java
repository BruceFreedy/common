package me.brucefreedy.common;

import lombok.ToString;

import java.util.*;

@ToString
public abstract class RegistryImpl<K, T> implements Registry<K, T> {

    private final Map<K, T> registry = new HashMap<>();

    @Override
    public final void register(K name, T t) {
        if (name == null) return;
        if (t == null) registry.remove(name);
        else registry.put(name, t);
    }

    @Override
    public final T getRegistry(K name) {
        if (name == null) return null;
        return registry.getOrDefault(name, null);
    }

    @Override
    public final Collection<T> getRegistry() {
        return new ArrayList<>(registry.values());
    }

    @Override
    public final Set<K> getKeys() {
        return new HashSet<>(registry.keySet());
    }

}
