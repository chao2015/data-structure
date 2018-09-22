package MySet;

import MyBSTree.BSTree;

/**
 * Created by chao on 2018/9/21.
 */
public class BSTreeSet<E extends Comparable<E>> implements Set<E> {

    private BSTree<E> bstree;

    public BSTreeSet() {
        bstree = new BSTree<>();
    }

    @Override
    public int getSize() {
        return bstree.size();
    }

    @Override
    public boolean isEmpty() {
        return bstree.isEmpty();
    }

    @Override
    public void add(E e) {
        bstree.add(e);
    }

    @Override
    public boolean contains(E e) {
        return bstree.contains(e);
    }

    @Override
    public void remove(E e) {
        bstree.remove(e);
    }

}
