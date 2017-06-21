package sixteen.february.sixteenth.inherit;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 2/16/16
 * Time: 10:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class Tes {
    public static void main(String[] args){
        new Leaf();
        //new Leaf();
    }
}

/**
 *the first new Leaf()
 Root静态初始化
 Mid静态初始化
 Leaf静态初始化
 Root普通初始化
 Root无参数初始化
 Mid普通初始化
 Mid无参数初始化
 Mid有参数初始化：Leaf Public
 Leaf普通初始化
 执行Leaf构造器
 *
 * the second new Leaf()
 Root普通初始化
 Root无参数初始化
 Mid普通初始化
 Mid无参数初始化
 Mid有参数初始化：Leaf Public
 Leaf普通初始化
 执行Leaf构造器
 */