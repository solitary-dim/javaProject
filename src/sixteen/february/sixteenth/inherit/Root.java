package sixteen.february.sixteenth.inherit;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 2/16/16
 * Time: 10:21 AM
 * To change this template use File | Settings | File Templates.
 */
class Root {
    static {
        System.out.println("Root静态初始化");
    }
    {
        System.out.println("Root普通初始化");
    }
    public Root(){
        System.out.println("Root无参数初始化");
    }
}
