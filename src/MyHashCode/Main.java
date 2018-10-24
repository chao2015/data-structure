package MyHashCode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by chao on 2018/10/23.
 */
public class Main {

    public static void main(String[] args) {
        int a = 42;
        System.out.println(((Integer)a).hashCode());

        int b = -42;
        System.out.println(((Integer)b).hashCode());

        double c = 3.1415926;
        System.out.println(((Double)c).hashCode());

        String d = "chao";
        System.out.println(d.hashCode());

        Student student = new Student(3, 2, "c", "c");
        System.out.println(student.hashCode());

        HashSet<Student> set = new HashSet<>();
        set.add(student);

        HashMap<Student, Integer> scores = new HashMap<>();
        scores.put(student, 100);

        // 把重写的hashCode注释掉，就和上面的不一样了，类的默认hashCode根据类地址来映射计算的
        Student student2 = new Student(3, 2, "c", "c");
        System.out.println(student2.hashCode());
    }
}
