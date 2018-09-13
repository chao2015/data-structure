package MyArray;

/**
 * Created by chao on 2018/9/13.
 */

// 数组最大的优点：随机访问，快速查询
// 数组最好应用于"索引有语意"的情况
public class JavaArray {

    public static void main(String[] args) {

        // 声明数组
        int[] arr = new int[10];
        // 给数组赋值
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        // 声明数组并赋值
        int[] scores = new int[]{100, 99, 66};
        // 遍历方法1
        for (int i = 0; i < scores.length; i++) {
            System.out.println(scores[i]);  // 100 99 66
        }
        // 遍历方法2
        for (int score: scores)
            System.out.println(score);  // 100 99 66

        // 修改数组元素
        scores[0] = 98;
        for (int score: scores)
            System.out.println(score);  // 98 99 66
    }
}
