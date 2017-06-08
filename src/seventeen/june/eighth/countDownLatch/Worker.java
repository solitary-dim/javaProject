package seventeen.june.eighth.countDownLatch;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 2017/6/8
 * Time: 13:18
 *
 * ����
 */
public class Worker {

    //����
    private String name;
    //����ʱ��
    private Long time;

    public Worker(String name, Long time) {
        this.name = name;
        this.time = time;
    }

    //����
    public void doWork() {
        Long startTime = System.currentTimeMillis();
        System.out.println(startTime + ": " + name + "begin to work");
        try {
            //��ͣ�̣߳�������ʾ�ù��˴��ڹ���״̬
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Long endTime = System.currentTimeMillis();
        System.out.println((endTime-startTime) + ": " + name + "has finished the job");
    }
}
