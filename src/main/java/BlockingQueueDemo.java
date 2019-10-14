import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {//阻塞队列

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(3);//创建一个容量为3的阻塞队列 -- 相当于 List lsit = new ArrtyList();
//        blockingQueue.put("a");
//        blockingQueue.put("b");
//        blockingQueue.put("c");
        //blockingQueue.add("c"); 当阻塞队列满了以后，使用add()会直接抛出IllegalStateException(非法状态异常)

//        blockingQueue.remove();
//        blockingQueue.remove();
//        blockingQueue.remove();
        //blockingQueue.remove(); 当阻塞队列为空的时候，使用remove()会直接抛出NoSuchElementException(元素找不到异常)

       // blockingQueue.element();//方法会返回队首的元素

//        System.out.println(blockingQueue.offer("a"));//offer()添加元素成功，返回true，添加失败返回false
//        System.out.println(blockingQueue.offer("a"));
//        System.out.println(blockingQueue.offer("a"));
//        System.out.println(blockingQueue.offer("a"));

//        System.out.println(blockingQueue.poll());//poll()移除元素成功，返回被移除的元素，移除失败，返回null
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());

//          blockingQueue.put("a");//put()添加元素，如果添加没有成功，会一直阻塞
//          blockingQueue.put("a");
//          blockingQueue.put("a");
//          //blockingQueue.put("a");

//          blockingQueue.take();//take()方法没有成功移除元素，那么会一直阻塞线程
//          blockingQueue.take();
//          blockingQueue.take();
//          blockingQueue.take();

//            blockingQueue.offer("a",2, TimeUnit.SECONDS);//当队列满的时候，offer(elememt,time,timeunit)会在超时时间结束后直接退出
//            blockingQueue.offer("a",2, TimeUnit.SECONDS);
//            blockingQueue.offer("a",2, TimeUnit.SECONDS);
//            blockingQueue.offer("a",2, TimeUnit.SECONDS);

//            blockingQueue.poll(2,TimeUnit.SECONDS);//当队列为空的时候，poll(timeout,timeunit)会在超时时间结束的时候自动退出
//            blockingQueue.poll(2,TimeUnit.SECONDS);
//            blockingQueue.poll(2,TimeUnit.SECONDS);
//            blockingQueue.poll(2,TimeUnit.SECONDS);

    }
}
