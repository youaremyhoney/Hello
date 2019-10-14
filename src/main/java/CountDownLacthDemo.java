import java.util.concurrent.CountDownLatch;

public class CountDownLacthDemo {
    public static void main(String[] args) throws  Exception {
        CountDownLatch  countDownLatch = new CountDownLatch(5);//创建一个倒计时锁存器 从0开始计数，每次countDownLatch一次就加1
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(()->{
                countDownLatch.countDown();//为倒计时加一
                System.out.println(Thread.currentThread().getName() + "\t离开教室" + finalI);
            }).start();
        }

        countDownLatch.await();//挂起当前线程，等countDownLatch构造方法里面的值计数到了以后执行
        System.out.println(Thread.currentThread().getName() + "\t离开教室");
    }
}
