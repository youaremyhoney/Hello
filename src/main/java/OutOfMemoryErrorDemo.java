import java.util.Random;

/**
 * java.lang.OutOfMemoryError：java head space
 */

public class OutOfMemoryErrorDemo {
    public static void main(String[] args) {
        String str = "www.atguigu.com";
        while(true)
        {
            str += str + new Random().nextInt(999999999) + new Random().nextInt(88888);
        }
    }
}
