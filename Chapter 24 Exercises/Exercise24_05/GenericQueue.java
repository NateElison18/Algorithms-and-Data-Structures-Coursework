import java.util.LinkedList;

public class GenericQueue<E> extends LinkedList {
    GenericQueue(){}

    public void enqueue(E e) {
        add(e);
    }
    public void dequeue() {
        removeFirst();
    }
    public int getSize() {
        return size();
    }
}
