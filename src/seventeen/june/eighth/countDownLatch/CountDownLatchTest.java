package seventeen.june.eighth.countDownLatch;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 2017/6/8
 * Time: 13:24
 *
 * CountDownLatch是一种简单的同步模式
 * 它让一个线程可以等待一个或多个线程完成它们的工作从而避免对临界资源并发访问所引发的各种问题。
 */
public class CountDownLatchTest {

    private static final int MAX_WORK_TIME = 5000;
    private static final int MIN_WORK_TIME = 1000;

    private static long getRandomWorkTime(int min, int max) {
        return (long) (Math.random()* (max - min) + min);
    }

    public static void main(String[] args) {
        int num = 10;
        CountDownLatch latch = new CountDownLatch(num);
        for (int i=0;i<num;i++) {
            Worker worker = new Worker("工人" + i, getRandomWorkTime(MIN_WORK_TIME, MAX_WORK_TIME));
            new Thread(new WorkerTestThread(worker, latch)).start();
        }
        try {
            latch.await();
            System.out.println("All jobs have been finished!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
