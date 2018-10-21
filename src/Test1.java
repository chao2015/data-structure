import java.io.File;
import java.util.TreeMap;

/**
 * Created by chao on 2018/10/10.
 */
public class Test1 {

    private static String Reverse(int num) {
        String str = Integer.toString(num);

        int length = str.length();
        String result = "";
        for (int i = 0; i < length; i++) {
            result = str.charAt(i) + result;
        }

        return result;
    }

    public static void listAllFiles(File dir) {
        if (dir == null || !dir.exists()) {
            return;
        }
        if (dir.isFile()) {
            System.out.println(dir.getName());
            return;
        }
        for (File file : dir.listFiles()) {
            listAllFiles(file);
        }
    }


    public static void main(String[] args) {
        int num = 10000;
        System.out.println(Reverse(num));

        Integer x = new Integer(123);
        Integer y = new Integer(123);
        Integer z1 = 123;
        Integer z2 = 123;
        Integer z3 = 128;
        Integer z4 = 128;
        System.out.println(x == y);
        System.out.println(z1 == x);
        System.out.println(z1 == z2);
        System.out.println(z3 == z4);

        File file = new File("/Users/chao/Documents/java/data-structure/src/common");
        listAllFiles(file);

    }
}
