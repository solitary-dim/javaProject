package seventeen.june.eighth.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 2017/6/8
 * Time: 13:22
 */
public class WorkerTestThread implements Runnable {

    private Worker worker;
    private CountDownLatch countDownLatch;

    public WorkerTestThread(Worker worker, CountDownLatch countDownLatch) {
        this.worker = worker;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        //工人工作
        worker.doWork();
        //工人完成工作后倒计时次数减一
        countDownLatch.countDown();
    }
}
