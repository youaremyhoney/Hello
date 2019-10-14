import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池改造版的3个人卖30张票
 */
class Ticket
{
    private int ticket = 30;

    void saleTicket()
    {
        System.out.println(Thread.currentThread().getName() + "\t" + ticket--);
    }
}

public class SaleTicketThreadPool {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        ExecutorService executorService = Executors.newFixedThreadPool(3);//创建一个含有三个线程的线程池

            try {
                for (int i = 1;i <= 30; i++) {
                    executorService.execute(() -> ticket.saleTicket());
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                executorService.shutdown();
            }
        }
    }

