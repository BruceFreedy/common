package me.brucefreedy.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

public class List<T> extends ArrayList<T> {

    public List() {}

    public List(Collection<? extends T> c) {
        super(c);
    }

    public T popFirst() {
        if (isEmpty()) return null;
        T t = get(0);
        remove(0);
        return t;
    }

    public T popPeek() {
        if (isEmpty()) return null;
        int index = size() - 1;
        T t = get(index);
        remove(index);
        return t;
    }

    public boolean popFirst(Consumer<T> consumer) {
        T pop = popFirst();
        boolean result = pop != null;
        if (result) consumer.accept(pop);
        return result;
    }

    public boolean popPeek(Consumer<T> consumer) {
        T pop = popPeek();
        boolean result = pop != null;
        if (result) consumer.accept(pop);
        return result;
    }

    public T peek() {
        if (isEmpty()) return null;
        return get(size() - 1);
    }

    public T first() {
        if (isEmpty()) return null;
        return get(0);
    }

    @Override
    public String toString() {
        if (isEmpty()) return super.toString();
        else if (size() == 1) return get(0).toString();
        else return toString();
    }

}
