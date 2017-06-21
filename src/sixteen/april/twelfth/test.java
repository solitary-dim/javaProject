package sixteen.april.twelfth;

/**
 * Created by solitary.wang on 2016/4/12.
 */
public class test {

    public static void main(String[] args){
        test t = new test();
        /*t.stringBuf();
        t.stringBul();
        t.nonReapt();*/
        t.toChoose();
    }

    public void stringBuf(){
        StringBuffer sbuffer = new StringBuffer("This is only a ").append("simple ").append("test.");
        sbuffer = sbuffer.append("\n12");
        System.out.println(sbuffer);
    }

    public void stringBul(){
        StringBuilder sbuilder = new StringBuilder("This");
        sbuilder.append(" is").append(" a test too.");
        System.out.println(sbuilder);
        System.out.println(sbuilder.reverse());
        System.out.println(sbuilder.length());
    }

    //去除字符串中重复的字符串
    public void nonReapt() {
        String oldName = "15606243133,15151689848,15151689848,15151689848,18913788032,18913788032";
        String name[] = oldName.split(",");
        StringBuilder newName = new StringBuilder("");
        for (int i = name.length - 1 ; i >= 0 ; i-- ) {
            for (int j = i - 1 ; j >= 0 ; j-- ) {
                if (name[i].equals(name[j])) {
                    name[i] = "";
                }
            }
            if (!"".equals(name[i])) {
                if (i != 0) {
                    newName.append(name[i]).append(",");
                } else {
                    newName.append(name[i]);
                }
            }
        }
        System.out.println(newName.toString());
    }

    public void toChoose(){
        for (int j = 0; j <= 101; j++){
            int m = j%5;
            switch (m) {
                case 1: System.out.println(j + "-" + 1); break;
                case 2: System.out.println(j + "-" + 2); break;
                case 3: System.out.println(j + "-" + 3); break;
                case 4: System.out.println(j + "-" + 4); break;
                case 5: System.out.println(j + "-" + 5); break;
                case 6: System.out.println(j + "-" + 6); break;
                case 7: System.out.println(j + "-" + 7); break;
                case 8: System.out.println(j + "-" + 8); break;
                default: System.out.println(j + "-" + "default"); break;
            }
        }
    }
}

/**
 * 三者在执行速度方面的比较：StringBuilder >  StringBuffer  >  String
 *
 * StringBuilder：线程非安全的，相对为轻量级
 * StringBuffer：线程安全的，相对为重量级
 *
 * 1.如果要操作少量的数据用 = String
 * 2.单线程操作字符串缓冲区 下操作大量数据 = StringBuilder
 * 3.多线程操作字符串缓冲区 下操作大量数据 = StringBuffer
 */