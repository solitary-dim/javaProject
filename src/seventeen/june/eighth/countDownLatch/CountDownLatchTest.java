package seventeen.june.eighth.countDownLatch;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 2017/6/8
 * Time: 13:24
 *
 * CountDownLatch��һ�ּ򵥵�ͬ��ģʽ
 * ����һ���߳̿��Եȴ�һ�������߳�������ǵĹ����Ӷ�������ٽ���Դ���������������ĸ������⡣
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
            Worker worker = new Worker("����" + i, getRandomWorkTime(MIN_WORK_TIME, MAX_WORK_TIME));
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
