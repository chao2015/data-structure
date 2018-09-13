package Array;

import java.util.Arrays;

/**
 * Created by chao on 2018/8/21.
 */
public class Array<E> {

    private E[] data;
    private int size;

    // 构造函数，传入数组的容量capacity构造Array
    public Array(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }

    // 无参数的构造函数，默认数组的容量capacity=10
    public Array() {
        this(10);
    }

    // 获取数组中的元素个数
    public int getSize() {
        return size;
    }

    // 获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    // 返回数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 向所有元素后添加一个新元素
    public void addLast(E e) {
        add(size, e);
    }

    // 在所有元素前加一个新元素
    public void addFirst(E e) {
        add(0, e);
    }

    // 在第index位置插入一个新元素e
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("AddLast failed. Require index >= 0 and index <= size.");
        if (size == data.length)
            resize(2 * data.length);
        for (int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];
        data[index] = e;
        size++;
    }

    // 获取index索引位置的元素
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        return data[index];
    }

    public E getLast() {
        return get(size - 1);
    }

    public E getFirst() {
        return get(0);
    }

    // 修改index索引位置的元素为e
    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        data[index] = e;
    }

    // 查找数组中是否有元素e
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            // ==是引用比较，equals()是值比较
            if (data[i].equals(e))
                return true;
        }
        return false;
    }

    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    // 查找数组中所有的元素e所在的索引，返回索引的数组
    public int[] findAll(E e) {
        int[] result = new int[10];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                result[j] = i;
                j++;
            }
        }
        return Arrays.copyOfRange(result, 0, j);
    }

    // 从数组中删除index位置的元素，返回删除的元素
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");

        E ret = data[index];
        for (int i = index + 1; i < size; i++)
            data[i - 1] = data[i];
        size--;
        data[size] = null;  // 对于loitering objects(!= memory leak)，可以释放对象，使得JVM可以自动回收
        // 不设为data.length / 2是要防止复杂度震荡
        if (size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        return ret;
    }

    // 从数组中删除第一个元素，返回删除的元素
    public E removeFirst() {
        return remove(0);
    }

    // 从数组中删除最后一个元素，返回删除的元素
    public E removeLast() {
        return remove(size - 1);
    }

    // 从数组中删除第一个元素e
    public boolean removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    // 从数组中删除所有的元素e
    public boolean removeAllElement(E e) {
        int[] indexes = findAll(e);
        for (int i=0; i<indexes.length; i++) {
            remove(indexes[i]-i);  // 删除一个元素后，下一个待删除的元素坐标更新-1
            if (i == indexes.length-1)
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n[", size, data.length));
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }

    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++)
            newData[i] = data[i];
        data = newData;
    }

    public static void main(String[] args) {
        Array<Integer> arr = new Array<Integer>();
        for (int i = 0; i < 10; i++)
            arr.addLast(i);
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);
        //[-1, 0, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9]

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);

        arr.set(8, 1);
        System.out.println(arr);
        int[] result = arr.findAll(1);
        for (int i = 0; i < result.length; i++) {
            System.out.printf("index: %d ", result[i]);
        }
        System.out.println("\n");

        arr.removeAllElement(1);
        System.out.println(arr);
        // java中的泛型不可以是基本数据类型，只能是类对象，可以放包装类
        // boolean, byte, char, short, int, long, float, double
        // Boolean, Byte, Char, Short, Int, Long, Float, Double
    }

}
