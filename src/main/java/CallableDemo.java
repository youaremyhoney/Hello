import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyThread implements Callable<String>
{

    @Override
    public String call() throws  Exception {
        System.out.println("***come in call");
        return "call方法的返回值";
    }
}
public class CallableDemo
{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new MyThread());

        new Thread(futureTask,"AAA").start();

        Object result = futureTask.get();
        System.out.println(result);

        System.out.println("主线程" + Thread.currentThread().getName());
    }
}