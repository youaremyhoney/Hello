import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class NotSafeDemo {


    public static void main(String[] args) {

        //List list = new ArrayList();
        //List list = Collections.synchronizedList(new ArrayList());//方法第一种--利用集合辅助工具类
       // List list = new Vector();//第二种方法--转用线程安全的集合Vector
        List list = new CopyOnWriteArrayList();

        for (int i = 1;i <= 30; i++){
            new Thread(()->{
                list.add(UUID.randomUUID().toString().replace("-","").substring(0,6));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }

}
