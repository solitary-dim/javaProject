package sixteen.february.sixteenth;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 2/16/16
 * Time: 5:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestIterator {
    public static void main(String[]args){
        //HashSet无需
        Collection books = new HashSet();
        books.add(" 轻量级J2EE企业实战应用");
        books.add("Struts2权威指南");
        books.add("基于J2EE的Ajax宝典");
        System.out.println(books);
        //获取books集合对应的迭代器
        Iterator id = books.iterator();
        while(id.hasNext()){
            String book = (String) id.next();
            System.out.println(book);
            if(book.equals("Struts2权威指南")){
                //从集合中删除上一次next（）方法返回的元素
                id.remove();
            }
            //对book变量赋值，不会改变集合元素本省
            book = "测试字符串";
        }
        System.out.println(books);
    }
}
