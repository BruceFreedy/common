package me.brucefreedy.common;

import lombok.ToString;

import java.util.*;

@ToString
public class RegistryImpl<K, T> implements Registry<K, T> {

    public RegistryImpl(RegistryImpl<K, T> registry) {
        this.registry = registry.newMap();
    }

    public RegistryImpl() {
        this.registry = new HashMap<>();
    }

    private final Map<K, T> registry;

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
    public <TYPE> TYPE getRegistry(K name, Class<TYPE> t1Class) {
        try {
            T registry = getRegistry(name);
            return (TYPE) registry;
        } catch (ClassCastException ignored) {
            return null;
        }
    }

    @Override
    public Map<K, T> newMap() {
        return new HashMap<>(registry);
    }

    @Override
    public Collection<T> values() {
        return registry.values();
    }

    @Override
    public Set<K> keys() {
        return registry.keySet();
    }

    @Override
    public Map<K, T> map() {
        return registry;
    }
}
