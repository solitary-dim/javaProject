package sixteen.february.sixteenth;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 2/16/16
 * Time: 5:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestList {
    public static void main(String[]args){
        //list有序
        List list = new ArrayList();
        list.add("hel");
        list.add("mel");
        list.add("heoijofie");
        list.add("for");
        list.add("fiff");
        System.out.println(list);
        for(int i = 0 ; i < list.size() ; i++){
            System.out.println(list.get(i));
        }
    }
}
