package sixteen.february.sixteenth.inherit;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 2/16/16
 * Time: 10:25 AM
 * To change this template use File | Settings | File Templates.
 */
class Leaf extends Mid {
    static{
        System.out.println("Leaf静态初始化");
    }
    {
        System.out.println("Leaf普通初始化");
    }
    public Leaf(){
        super("Leaf Public");
        System.out.println("执行Leaf构造器");
    }
}
