import java.util.concurrent.TimeUnit;

class Phone //资源类
{
    public static synchronized void sendEmail() throws  Exception {
        TimeUnit.SECONDS.sleep(4);//调用时间枚举类来实现暂停4秒的方法
        System.out.println("--------sendEmail");
    }

    public synchronized void sendSms() throws Exception {
        System.out.println("--------sendSms");
    }

    public void sayHello()
    {
        System.out.println("----Hello");
    }
}

/**
 * 在高内聚低耦合的前提下，线程操作资源类
 * <p>
 * 同步锁8问
 * 1、标准访问，执行顺序是什么                                                 执行顺序是   E        S
 * 2、发送邮件的方法添加一个暂停4秒的方法，执行的顺序是什么                       执行顺序是   E        S
 * 3、新增普通方法sayHello，执行顺序是什么样子的(sayHello方法和sendEmail方法)    执行顺序是   sayHello E
 * 4、有两部手机(一步手机执行一个方法)，请问执行的顺序是什么样子的                执行的顺序是 S        E
 * 5、两个静态同步的方法，同一部手机，执行的顺序是什么样子的                      执行顺序是  E        S
 * 6、两个静态同步方法，两部手机，执行顺序是什么                                 执行顺序是 E        S
 * 7、一个静态同步方法，一个同步方法，一部手机，执行的顺序是什么                  执行顺序是  S        E
 * 8、一个静态同步方法，一个同步刚发，两部手机，执行的顺序是什么                   执行顺序是  S       E
 *
 */
public class ManyThreadLock8 {

    public static void main(String[] args) throws Exception {

        Phone phone = new Phone();
        Phone phone2 = new Phone();

        new Thread(() -> {

            try {
                phone.sendEmail();//调用手机类的发送邮件的方法
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "A").start();

        Thread.sleep(1000); //用一个线程延时来控制线程的执行顺序

        new Thread(() -> {
            try {
                //phone.sendSms();      //调用手机类的发送短信的方法
                //phone.sayHello();        //调用手机类的普通方法sayHello()
                phone2.sendSms();       //手机实例phone2调用手机发送短信的方法
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "B").start();//写线程一定要启用线程

    }

}
