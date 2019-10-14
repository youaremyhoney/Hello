import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierDemo {
    public static void main(String[] args) {//循环屏障
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()-> System.out.println("集齐7颗龙珠，可以召唤神龙"));

            for (int i = 0; i < 7; i++) {
                int finalI = i;
                new Thread(() -> {
                   try {
                       System.out.println("收集到第" + finalI + "颗龙珠");
                       cyclicBarrier.await(2,TimeUnit.SECONDS);//设置超时时间，如果时间到了还没有满足条件，那么会直接报异常 brokenbarrierexception 和 timeoutexception
                   }catch (Exception e){
                        e.printStackTrace();
                   }
                },String.valueOf(finalI)).start();
            }
    }
}
