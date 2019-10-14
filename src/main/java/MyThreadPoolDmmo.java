import java.util.Random;
import java.util.concurrent.*;

public class MyThreadPoolDmmo {//模拟10个人来银行办业务的场景

    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(2,
                5,
                2L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

            try {
                for (int i = 1; i <= 8 ; i++)
                {
                    executorService.submit(()-> System.out.println(Thread.currentThread().getName() + "\t" + "办理业务" + new Random().nextInt(10)));
                }
                }catch (Exception e){
                e.printStackTrace();
            }finally {
                executorService.shutdown();
            }

    }
}
