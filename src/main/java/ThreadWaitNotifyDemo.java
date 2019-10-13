import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class AirConditioner {

    private int number = 0;//定义一个初始值为0的number
    private Lock lock = new ReentrantLock();//定义一个可重入锁
    private Condition condition = lock.newCondition();

    void increment() {
        lock.lock();//加锁
        try {
            //判断
            while (number != 0) {
               // this.wait();
                condition.await();//让线程处于等待状态
            }
            number++;//干活
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            //通知
            condition.signalAll();//唤醒正在等待的所有线程
            //this.notifyAll();//唤醒所有线程
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();//释放锁
        }

    }

     void decrement() {
        lock.lock();//加锁
        try {
            //判断
            while (number == 0) {
               //this.wait();
                condition.await();//让当前这个线程处于等待状态
            }
            //干活
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            //通知
            //this.notifyAll();
            condition.signalAll();//唤醒正在等待的所有
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();//释放锁
        }

    }
}

/**
 * 题目：现在两个线程，可以操作初始值为零的一个变量，
 * 实现一个线程对该变量加1，一个线程对该变量减1，
 * 实现交替，来10轮，变量初始值为零。
 * <p>
 * 1、高内聚低耦合前提下，线程操作资源类
 *  * 2、判断//干活//通知
 *  * 3、小心，防止多线程虚假唤醒，使用while进行条件判断
 *  * 4、注意标志位的更新
 */
public class ThreadWaitNotifyDemo {
    public static void main(String[] args)
    {

        AirConditioner airConditioner = new AirConditioner();//创建一个资源类的对象

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    airConditioner.increment();//利用A线程实现对number变量实现加一
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 1; i <= 10 ; i++) {
                try {
                    airConditioner.decrement();//利用B线程实现对number变量实现减一
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"B").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    airConditioner.increment();//利用A线程实现对number变量实现加一
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 1; i <= 10 ; i++) {
                try {
                    airConditioner.decrement();//利用B线程实现对number变量实现减一
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"D").start();

    }
}
