package MyLinkedList;

/**
 * Created by chao on 2018/9/5.
 */
public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyhead;
    private int size;

    public LinkedList() {
        dummyhead = new Node(null, null);
        size = 0;
    }

    // 获取链表中的元素个数
    public int getSize() {
        return size;
    }

    // 返回链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 在链表的index(0-based)位置添加新的元素e
    // 在链表中不是一个常用的操作，仅练习用
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");

        Node prev = dummyhead;
        for (int i = 0; i < index; i++)
            prev = prev.next;

//        Node node = new Node(e);
//        node.next = prev.next;
//        prev.next = node;

        prev.next = new Node(e, prev.next);
        size++;
    }

    // 在链表头添加新的元素e
    public void addFirst(E e) {
        add(0, e);
    }

    // 在链表尾添加新的元素e
    public void addLast(E e) {
        add(size, e);
    }

    // 获得链表的index(0-based)位置的元素
    // 在链表中不是一个常用的操作，仅练习用
    public E get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Get failed. Illegal index.");

        Node cur = dummyhead.next;
        for (int i=0; i<index; i++)
            cur = cur.next;
        return cur.e;
    }

    // 获得链表的第一个元素
    public E getFirst() {
        return get(0);
    }

    // 获得链表的最后一个元素
    public E getLast() {
        return get(size - 1);
    }

    // 修改链表的index(0-based)位置的元素
    // 在链表中不是一个常用的操作，仅练习用
    public void set(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Set failed. Illegal index.");

        Node cur = dummyhead.next;
        for (int i=0; i<index; i++)
            cur = cur.next;
        cur.e = e;
    }

    // 查找链表中是否有元素e
    public boolean contains(E e) {
        Node cur = dummyhead.next;
        while(cur != null) {
            if (cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }

    // 删除链表的index(0-based)位置的元素，返回删除的元素
    // 在链表中不是一个常用的操作，仅练习用
    public E remove(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Remove failed. Illegal index.");

        Node prev = dummyhead;
        for (int i=0; i<index; i++)
            prev = prev.next;

        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;

        return retNode.e;
    }

    // 从链表中删除第一个元素，返回删除的元素
    public E removeFirst() {
        return remove(0);
    }

    // 从链表中删除最后一个元素，返回删除的元素
    public E removeLast() {
        return remove(size-1);
    }

    // 从链表中删除元素e
    public void removeElement(E e) {

        Node prev = dummyhead;
        while (prev.next != null) {
            if (prev.next.e.equals(e))
                break;
            prev = prev.next;
        }

        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        Node cur = dummyhead.next;
        while(cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
//        for (Node cur = dummyhead.next; cur != null; cur = cur.next)
//            res.append(cur + "->");
        res.append("NULL");

        return res.toString();
    }

    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i=0; i<5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        // 0->NULL
        // 1->0->NULL
        // 2->1->0->NULL
        // 3->2->1->0->NULL
        // 4->3->2->1->0->NULL

        linkedList.add(2,666);
        System.out.println(linkedList);
        // 4->3->666->2->1->0->NULL

        linkedList.remove(2);
        System.out.println(linkedList);
        // 4->3->2->1->0->NULL

        linkedList.removeFirst();
        System.out.println(linkedList);
        // 3->2->1->0->NULL

        linkedList.removeLast();
        System.out.println(linkedList);
        // 3->2->1->NULL
    }
}
