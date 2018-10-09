package MySegmentTree;

/**
 * Created by chao on 2018/10/9.
 */
public interface Merger<E> {
    E merge(E a, E b);
}
