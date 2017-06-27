package seventeen.june.eighth;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 2017/6/8
 * Time: 10:38
 */
public class GenerateUUID {

    /*
     GUID是一个128位长的数字，一般用16进制表示。
     算法的核心思想是结合机器的网卡、当地时间、一个随即数来生成GUID。
     从理论上讲，如果一台机器每秒产生10000000个GUID，则可以保证（概率意义上）3240年不重复。
     */

    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
    }
}
