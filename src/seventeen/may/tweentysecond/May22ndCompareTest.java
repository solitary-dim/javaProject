package seventeen.may.tweentysecond;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 2017/5/22
 * Time: 9:38
 */
public class May22ndCompareTest {

    public static void main(String[] args) {
        System.out.println(new BigDecimal("1.2").equals(new BigDecimal("1.20"))); //输出false
        System.out.println(new BigDecimal("1.2").compareTo(new BigDecimal("1.20")) == 0); //输出true

        System.out.println(new BigDecimal("1.2").equals(new BigDecimal("1.2"))); //输出true
        System.out.println(new BigDecimal("1.2").compareTo(new BigDecimal("1.20")) == 0); //输出true

        System.out.println(new BigDecimal(1.2).equals(new BigDecimal("1.20"))); //输出是false
        System.out.println(new BigDecimal(1.2).compareTo(new BigDecimal("1.20")) == 0); //输出是false

        System.out.println(new BigDecimal(1.2).equals(new BigDecimal(1.20))); //输出是true
        System.out.println(new BigDecimal(1.2).compareTo(new BigDecimal(1.20)) == 0);//输出是true
        System.out.println("====================================================");
        /**
         * 对于BigDecimal的大小比较，用equals方法的话会不仅会比较值的大小，还会比较两个对象的精确度
         * 而compareTo方法则不会比较精确度，只比较数值的大小
         */

        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println((s1 == s2) ? "true" : "false");
        System.out.println((s1.equals(s2)) ? "true" : "false");
        if (s1.compareTo(s2) == 0) {
            System.out.println("s1 is equal s2");
        }
        s1 = s2;
        System.out.println((s1 == s2) ? "true" : "false");
        String s3 = new String("ab");
        String s4 = new String("abcd");
        System.out.println(s1.compareTo(s3));
        System.out.println(s1.compareTo(s4));
    }
}
