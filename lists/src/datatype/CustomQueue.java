package datatype;

import java.util.List;

/**
 * FIFO queue
 */
public class CustomQueue<T> extends AbstractCustomQueueAdapter<T> {
    List<T> storage;

    public CustomQueue(List<T> storage) {
        this.storage = storage;
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    public boolean isEmpty() {
        return storage.isEmpty();
    }

    @Override
    public boolean add(T t) {
        storage.add(t);
        return true;
    }

    @Override
    public T poll() {
        if (isEmpty())
            return null;
        else
            return storage.remove(0);
    }

    @Override
    public T peek() {
        if (isEmpty())
            return null;
        else
            return storage.get(0);
    }
}
