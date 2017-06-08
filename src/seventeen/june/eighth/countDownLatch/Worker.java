package seventeen.june.eighth.countDownLatch;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 2017/6/8
 * Time: 13:18
 *
 * 工人
 */
public class Worker {

    //姓名
    private String name;
    //工作时间
    private Long time;

    public Worker(String name, Long time) {
        this.name = name;
        this.time = time;
    }

    //工作
    public void doWork() {
        Long startTime = System.currentTimeMillis();
        System.out.println(startTime + ": " + name + "begin to work");
        try {
            //暂停线程，用来表示该工人处于工作状态
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Long endTime = System.currentTimeMillis();
        System.out.println((endTime-startTime) + ": " + name + "has finished the job");
    }
}
