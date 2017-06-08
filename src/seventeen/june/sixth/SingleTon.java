package seventeen.june.sixth;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 2017/6/6
 * Time: 9:20
 */
public class SingleTon {
    private static volatile SingleTon singleTon;
    private SingleTon(){}
    public static SingleTon getInstance() {
        if (singleTon == null) {
            synchronized (SingleTon.class) {
                if (singleTon == null)        {
                    singleTon = new SingleTon();
                }
            }
        }
        return singleTon;
    }
}
