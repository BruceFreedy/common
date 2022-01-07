package me.brucefreedy.common;

import java.util.Collection;
import java.util.Set;

/**
 * mapping T with String key
 */
public interface Registry<K, T> {

    /**
     * register T with name key
     */
    void register(K name, T t);

    /**
     * get T with name key
     */
    T getRegistry(K name);

    Collection<T> getRegistry();

    Set<K> getKeys();

}
