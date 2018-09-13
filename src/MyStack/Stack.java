package MyStack;

/**
 * Created by chao on 2018/9/3.
 */
public interface Stack<E> {

    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
