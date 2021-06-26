package datastructure.list;


import messages.StandardMessages;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomArrayList<T> extends AbstractCustomListAdapter<T> {


    private static final int DEFAULT_CAPACITY = 0;


    private static final Object[] DEF_ARRAY = new Object[0];


    private Object[] array;


    public CustomArrayList() {
        this.array = DEF_ARRAY;
    }


    public CustomArrayList(int initialCapacity) {
        this.array = new Object[initialCapacity];
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public boolean isEmpty() {
        return (array.length == 0);
    }

    @Override
    public boolean contains(Object o) {
        boolean contain = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(o)) {
                contain = true;
                break;
            }
        }
        return contain;
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomArrayListIterator<>();
    }

    @Override
    public boolean add(T t) {
        increaseSize();
        array[array.length - 1] = t;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (contains(o)) {
            remove(indexOf(o));
            return true;
        } else
            return false;
    }

    @Override
    public void clear() {
        array = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > array.length - 1)
            throw new IndexOutOfBoundsException(StandardMessages.ELEMENT_DOES_NOT_EXISTS);
        return (T) array[index];
    }

    @Override
    public T set(int index, T element) {
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException(StandardMessages.OUT_OF_SIZE);

        T oldValue = (T) array[index];
        array[index] = element;
        return oldValue;
    }

    @Override
    public void add(int index, T element) {
        if (index > size() || index < 0)
            throw new IndexOutOfBoundsException(StandardMessages.OUT_OF_SIZE);

        increaseSize();

        if (index == size())
            add(element);

        Object[] tempArray = new Object[array.length];
        int a = 0;
        for (int i = index; i < size() - 1; i++) {
            tempArray[a] = array[i];
            a++;
        }
        array[index] = element;
        int b = 0;
        for (int i = index + 1; i < size(); i++) {
            array[i] = tempArray[b];
            b++;
        }
    }

    @Override
    public T remove(int index) {
        if (isEmpty())
            throw new NoSuchElementException(StandardMessages.EMPTY_LIST);
        if (index < size()) {
            Object object = array[index];
            array[index] = null;
            int tempIndex = index;
            while (tempIndex < size() - 1) {
                array[tempIndex] = array[tempIndex + 1];
                array[tempIndex + 1] = null;
                tempIndex++;
            }
            decreaseSize();
            return (T) object;
        } else
            throw new IndexOutOfBoundsException(StandardMessages.ELEMENT_DOES_NOT_EXISTS);
    }

    @Override
    public int indexOf(Object o) {
        int a = -5;
        for (int i = 0; i <= array.length - 1; i++) {
            if (array[i].equals(o)) {
                a = i;
                break;
            }
        }
        if (a >= 0)
            return a;
        else
            throw new IllegalArgumentException(StandardMessages.WRONG_ELEMENT);
    }

    private void increaseSize() {
        array = Arrays.copyOf(array, size() + 1);
    }

    private void decreaseSize() {
        array = Arrays.copyOf(array, size() - 1);
    }

    private class CustomArrayListIterator<E> implements Iterator<E> {

        int currentElementIndex;

        @Override
        public boolean hasNext() {
            return (currentElementIndex < size());
        }

        @Override
        public E next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Object value = array[currentElementIndex];
            currentElementIndex++;
            return (E) value;
        }

        @Override
        public void remove() {
            if (currentElementIndex == 0)
                CustomArrayList.this.remove(0);
            else
                CustomArrayList.this.remove(currentElementIndex - 1);
        }
    }
}
