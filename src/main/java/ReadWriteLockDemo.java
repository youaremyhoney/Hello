import java.security.cert.TrustAnchor;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class ReadWrite
{
    private volatile Map<String,String> map = new HashMap<>();
//    private Lock lock = new ReentrantLock();
    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();//创建一个可重入的读写锁

    public void put(String key,String value)
    {
        reentrantReadWriteLock.writeLock().lock();//加锁
        try {
            System.out.println(Thread.currentThread().getName() + "\t写入开始");
            map.put(key,value);
            System.out.println(Thread.currentThread().getName() + "\t写入结束");
        }finally {
            reentrantReadWriteLock.writeLock().unlock();//释放锁
        }
    }

    public void get(String key)
    {
        reentrantReadWriteLock.readLock().lock();//加锁
        try {
            String result = null;//定义一个为空的变量来接收获取到的map的值
            System.out.println(Thread.currentThread().getName() + "\t读取开始");
            result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t读取结束,result：" + result);
        }finally {
            reentrantReadWriteLock.readLock().unlock();//释放锁
        }
    }
}
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        ReadWrite readWrite = new ReadWrite();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                readWrite.put(finalI+"",finalI+"");
            }).start();
        }

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                readWrite.get(finalI+"");
            }).start();
        }
    }
}
