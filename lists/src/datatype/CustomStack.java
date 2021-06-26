package datatype;

import messages.StandardMessages;

import java.util.EmptyStackException;
import java.util.List;

/**
 * Stack, LIFO queue
 */
public class CustomStack<T> extends AbstractCustomStackAdapter<T> {
    List<T> storage;


    public CustomStack(List<T> storage) {
        this.storage = storage;
    }

    @Override
    public void push(T t) {
        storage.add(t);
    }

    @Override
    public T pop() {
        if (size() == 0)
            throw new EmptyStackException();
        T element = storage.get(size() - 1);
        storage.remove(size() - 1);
        return element;
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    public boolean isEmpty() {
        return storage.isEmpty();
    }
}
