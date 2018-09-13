package MyQueue;

/**
 * Created by chao on 2018/9/5.
 */
public interface Queue<E> {

    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
