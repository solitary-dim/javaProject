package sixteen.february.sixteenth.inherit;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 2/16/16
 * Time: 10:23 AM
 * To change this template use File | Settings | File Templates.
 */
class Mid extends Root {
    static{
        System.out.println("Mid静态初始化");
    }
    {
        System.out.println("Mid普通初始化");
    }
    public Mid(){
        System.out.println("Mid无参数初始化");
    }
    public Mid(String str){
        this();
        System.out.println("Mid有参数初始化："+str);
    }
}
