package datastructure.list;

import messages.StandardMessages;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class CustomLinkedList<T> extends AbstractCustomListAdapter<T> {

    private Node<T> firstElement;
    private Node<T> lastElement;
    private int size = 0;

    public CustomLinkedList() {
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public boolean contains(Object o) {
        return (indexOf(o) > -1);
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomLinkedListIterator<>();
    }

    @Override
    public boolean add(T t) {
        Node newNode = new Node(t, null);
        Node last = lastElement;
        lastElement = newNode;
        if (firstElement == null)
            firstElement = newNode;
        else {
            last.next = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (isEmpty() || indexOf(o) == -1)
            return false;
        else {
            remove(indexOf(o));
            return true;
        }
    }

    @Override
    public void clear() {
        firstElement.next = null;
        firstElement.object = null;
        size = 0;
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException(StandardMessages.ELEMENT_DOES_NOT_EXISTS);
        int idx = 0;
        for (Node i = firstElement; i != null; i = i.next) {
            if (idx == index)
                return (T) i.object;
            idx++;
        }
        return null;
    }

    @Override
    public T set(int index, T element) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(StandardMessages.OUT_OF_SIZE);

        Node<T> retVal = null;
        int idx = 0;
        for (Node<T> element1 = firstElement; element1 != null; element1 = element1.next) {
            if (idx == index)
                retVal = element1;
            element1.object = element;
            idx++;
        }
        return (T) retVal;
    }

    @Override
    public void add(int index, T element) {
        Node<T> newNode = new Node(element, null);
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(StandardMessages.OUT_OF_SIZE);

        if (index == size)
            add(element);

        if (index == 0) {
            Node<T> i = firstElement;
            newNode.next = i;
            firstElement = newNode;
        }

        if (index > 0 && index < size) {
            int idx = 0;
            for (Node<T> element1 = firstElement; element1 != null; element1 = element1.next) {
                if (idx == index - 1) {
                    Node<T> tempNode = element1.next;
                    element1.next = newNode;
                    newNode.next = tempNode;
                }
                idx++;
            }
        }
        size++;
    }

    @Override
    public T remove(int index) {
        if (isEmpty())
            throw new NoSuchElementException(StandardMessages.EMPTY_LIST);
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException(StandardMessages.OUT_OF_SIZE);

        Node<T> prev = null;
        T oldValue = null;

        int idx = 0;
        for (Node<T> element = firstElement; element != null; element = element.next) {
            if (index == 0) {
                oldValue = unlinkFirstElement(element);
                break;
            }
            if (idx == index - 1)
                prev = element;

            if (idx == index) {
                oldValue = unlinkElement(prev, element);
                break;
            }
            idx++;
        }
        size--;
        return oldValue;
    }


    @Override
    public int indexOf(Object o) {

        int idx = 0;
        for (Node<T> element = firstElement; element != null; element = element.next) {
            if (o.equals(element.object))
                return idx;
            idx++;
        }
        return -1;
    }

    private T unlinkFirstElement(Node<T> i) {
        Node<T> next;
        T oldValue;
        oldValue = i.object;
        next = i.next;
        i.next = null;
        i.object = null;
        firstElement = next;
        return oldValue;
    }

    private T unlinkElement(Node<T> prev, Node<T> i) {
        T oldValue;
        Node<T> next;
        oldValue = i.object;
        next = i.next;
        prev.next = next;
        i.object = null;
        i.next = null;
        return oldValue;
    }

    private class CustomLinkedListIterator<E> implements Iterator<E> {


        int currentElementIndex;

        @Override
        public boolean hasNext() {
            return (currentElementIndex < size());
        }

        @Override
        public E next() {
            if (!hasNext())
                throw new NoSuchElementException();

            Object value = get(currentElementIndex);
            currentElementIndex++;
            return (E) value;

        }

        @Override
        public void remove() {
            if (currentElementIndex == 0)
                CustomLinkedList.this.remove(0);
            else
                CustomLinkedList.this.remove(currentElementIndex - 1);
        }
    }
}
