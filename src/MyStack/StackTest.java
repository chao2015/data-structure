package MyStack;

import java.util.Random;

/**
 * Created by chao on 2018/9/5.
 */
public class StackTest {

    // 测试使用queue运行opCount个push和pop操作所需要的时间，单位：秒
    private static double testStack(Stack<Integer> stack, int opCount) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i=0; i<opCount; i++)
            stack.push(random.nextInt(Integer.MAX_VALUE));
        for (int i=0; i<opCount; i++)
            stack.pop();

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 100000;

        // 二者时间复杂度是同一量级
        // opCount = 100000时，数组栈更耗时，原因在分配空间方面
        // opCount = 1000000时，链表栈更耗时，原因在new寻找内存空间方面
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack, opCount);
        System.out.println("arrayStack, time: " + time1 + " s");  // 0.032065161 s

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = testStack(linkedListStack, opCount);
        System.out.println("linkedListStack, time: " + time2 + " s");  // 0.025262764 s

    }
}
