package seventeen.july.removeAllTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 2017/7/7
 * Time: 9:16
 */
public class RemoveAllFunctionTest {

    public static void main(String[] args) {
        RemoveAllFunctionTest test = new RemoveAllFunctionTest();
        test.stringListRemoveAll();
        System.out.println();
        test.setRemoveAll();
        System.out.println();
        test.entityListRemoveAll();
        System.out.println();
        test.arrayListRemoveAll();
    }

    //string list remove all
    private void stringListRemoveAll() {
        List<String> list = new ArrayList<>();
        List<String> lists = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("String_" + i);
            lists.add("String_" + i);
        }
        System.out.println("list:");
        for (String str : list) {
            System.out.print(str + "; ");
        }
        lists.add("String end");
        System.out.println("\nlists:");
        for (String str : lists) {
            System.out.print(str + "; ");
        }
        lists.removeAll(list);
        System.out.println("\nlists after removeAll():");
        for (String str : lists) {
            System.out.print(str);
        }
    }

    //string set remove all
    private void setRemoveAll() {
        Set<String> set = new HashSet<>();
        Set<String> sets = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            set.add("Set_" + i);
            sets.add("Set_" + i);
        }
        System.out.println("set:");
        for (String str : set) {
            System.out.print(str + "; ");
        }
        sets.add("Set end");
        System.out.println("\nsets:");
        for (String str : sets) {
            System.out.print(str + "; ");
        }
        sets.removeAll(set);
        System.out.println("\nsets after removeAll():");
        for (String str : sets) {
            System.out.print(str);
        }
    }

    //entity list remove all
    private void entityListRemoveAll() {
        System.out.println("===========================================");
        List<DemoEntity> list = new ArrayList<>();
        List<DemoEntity> lists = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            DemoEntity entity = new DemoEntity();
            entity.setId(i);
            entity.setName("name" + i);
            list.add(entity);
            lists.add(entity);
        }
        System.out.println("list:");
        for (DemoEntity entity: list) {
            System.out.println(entity.toString());
        }

        DemoEntity demoEntity = new DemoEntity();
        demoEntity.setId(100);
        demoEntity.setName("String end");
        lists.add(demoEntity);

        System.out.println("lists:");
        for (DemoEntity entity : lists) {
            System.out.println(entity.toString());
        }
        lists.removeAll(list);
        System.out.println("lists after removeAll():");
        for (DemoEntity entity: lists) {
            System.out.println(entity.toString());
        }
        System.out.println("===========================================");
    }

    //String array remove all
    private void arrayListRemoveAll() {
        String[] a = {"zhang","wang","li","wu","han"};
        String[] b = {"zhang,math,88", "zhang,chinese,89", "zhang,english,90", "wu,math,99", "wu,english,66", "tang,math,77"};
    }
}
