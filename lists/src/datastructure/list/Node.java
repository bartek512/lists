package datastructure.list;

/**
 * Component of linked list that stores a value and reference to the next element.
 */
public class Node<T> {

    T object;
    Node<T> next;

    public Node(T object, Node<T> next) {
        this.object = object;
        this.next = next;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
